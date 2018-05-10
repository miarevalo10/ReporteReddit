package org.jcodec.movtool;

import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.FreeBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.Chunk;
import org.jcodec.containers.mp4.ChunkReader;
import org.jcodec.containers.mp4.ChunkWriter;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.AliasBox;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.FileTypeBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.UrlBox;

public class Flattern {
    public List<ProgressListener> listeners = new ArrayList();

    public interface ProgressListener {
        void trigger(int i);
    }

    public static void main(String[] strArr) throws Exception {
        Throwable th;
        if (strArr.length < 2) {
            System.out.println("Syntax: self <ref movie> <out movie>");
            System.exit(-1);
        }
        File file = new File(strArr[1]);
        file.delete();
        try {
            strArr = NIOUtils.readableFileChannel(new File(strArr[0]));
            try {
                new Flattern().flattern(MP4Util.parseMovie((SeekableByteChannel) strArr), file);
                if (strArr != null) {
                    strArr.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (strArr != null) {
                    strArr.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            strArr = null;
            if (strArr != null) {
                strArr.close();
            }
            throw th;
        }
    }

    public void addProgressListener(ProgressListener progressListener) {
        this.listeners.add(progressListener);
    }

    public void flattern(MovieBox movieBox, SeekableByteChannel seekableByteChannel) throws IOException {
        MovieBox movieBox2 = movieBox;
        SeekableByteChannel seekableByteChannel2 = seekableByteChannel;
        if (movieBox2.isPureRefMovie(movieBox2)) {
            long j;
            long j2;
            TrakBox[] trakBoxArr;
            ByteBuffer allocate = ByteBuffer.allocate(16777216);
            new FileTypeBox("qt  ", 537199360, Arrays.asList(new String[]{"qt  "})).write(allocate);
            long position = (long) allocate.position();
            movieBox2.write(allocate);
            int calcSpaceReq = calcSpaceReq(movieBox);
            new Header(FreeBox.TYPE, (long) (8 + calcSpaceReq)).write(allocate);
            NIOUtils.skip(allocate, calcSpaceReq);
            long position2 = (long) allocate.position();
            new Header(MediaDataBox.TYPE, 4294967297L).write(allocate);
            allocate.flip();
            seekableByteChannel2.write(allocate);
            SeekableByteChannel[][] inputs = getInputs(movieBox);
            TrakBox[] tracks = movieBox.getTracks();
            ChunkReader[] chunkReaderArr = new ChunkReader[tracks.length];
            ChunkWriter[] chunkWriterArr = new ChunkWriter[tracks.length];
            Chunk[] chunkArr = new Chunk[tracks.length];
            long[] jArr = new long[tracks.length];
            int i = 0;
            int i2 = 0;
            while (i < tracks.length) {
                chunkReaderArr[i] = new ChunkReader(tracks[i]);
                int size = i2 + chunkReaderArr[i].size();
                chunkWriterArr[i] = new ChunkWriter(tracks[i], inputs[i], seekableByteChannel2);
                chunkArr[i] = chunkReaderArr[i].next();
                if (tracks[i].isVideo()) {
                    jArr[i] = (long) (2 * movieBox.getTimescale());
                }
                i++;
                i2 = size;
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5;
                j = position;
                int i6 = -1;
                i = 0;
                while (i < chunkReaderArr.length) {
                    if (chunkArr[i] != null) {
                        if (i6 == -1) {
                            j2 = position2;
                            trakBoxArr = tracks;
                            i5 = i4;
                        } else {
                            j2 = position2;
                            trakBoxArr = tracks;
                            i5 = i4;
                            if (movieBox2.rescale(chunkArr[i].getStartTv(), (long) tracks[i].getTimescale()) + jArr[i] >= movieBox2.rescale(chunkArr[i6].getStartTv(), (long) tracks[i6].getTimescale()) + jArr[i6]) {
                            }
                        }
                        i6 = i;
                    } else {
                        j2 = position2;
                        trakBoxArr = tracks;
                        i5 = i4;
                    }
                    i++;
                    position2 = j2;
                    tracks = trakBoxArr;
                    i4 = i5;
                    seekableByteChannel2 = seekableByteChannel;
                }
                j2 = position2;
                trakBoxArr = tracks;
                i5 = i4;
                if (i6 == -1) {
                    break;
                }
                chunkWriterArr[i6].write(chunkArr[i6]);
                chunkArr[i6] = chunkReaderArr[i6].next();
                i3++;
                i4 = calcProgress(i2, i3, i5);
                position = j;
                position2 = j2;
                tracks = trakBoxArr;
                seekableByteChannel2 = seekableByteChannel;
            }
            Flattern flattern = this;
            SeekableByteChannel seekableByteChannel3 = seekableByteChannel;
            position = seekableByteChannel.position() - j2;
            TrakBox[] trakBoxArr2 = trakBoxArr;
            for (int i7 = 0; i7 < trakBoxArr2.length; i7++) {
                chunkWriterArr[i7].apply();
            }
            seekableByteChannel3.position(j);
            MP4Util.writeMovie(seekableByteChannel3, movieBox2);
            position2 = j2 - seekableByteChannel.position();
            if (position2 < 0) {
                throw new RuntimeException("Not enough space to write the header");
            }
            seekableByteChannel3.write((ByteBuffer) ByteBuffer.allocate(8).putInt((int) position2).put(new byte[]{(byte) 102, (byte) 114, (byte) 101, (byte) 101}).flip());
            seekableByteChannel3.position(j2 + 8);
            seekableByteChannel3.write(ByteBuffer.allocate(8).putLong(position));
            return;
        }
        throw new IllegalArgumentException("movie should be reference");
    }

    private int calcProgress(int i, int i2, int i3) {
        i = (100 * i2) / i;
        if (i3 >= i) {
            return i3;
        }
        for (ProgressListener trigger : this.listeners) {
            trigger.trigger(i);
        }
        return i;
    }

    protected SeekableByteChannel[][] getInputs(MovieBox movieBox) throws IOException {
        movieBox = movieBox.getTracks();
        SeekableByteChannel[][] seekableByteChannelArr = new SeekableByteChannel[movieBox.length][];
        for (int i = 0; i < movieBox.length; i++) {
            DataRefBox dataRefBox = (DataRefBox) Box.findFirst(movieBox[i], DataRefBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, DataInformationBox.TYPE, DataReferenceBox.TYPE);
            if (dataRefBox == null) {
                throw new RuntimeException("No data references");
            }
            List boxes = dataRefBox.getBoxes();
            SeekableByteChannel[] seekableByteChannelArr2 = new SeekableByteChannel[boxes.size()];
            SeekableByteChannel[] seekableByteChannelArr3 = new SeekableByteChannel[boxes.size()];
            for (int i2 = 0; i2 < seekableByteChannelArr2.length; i2++) {
                seekableByteChannelArr3[i2] = resolveDataRef((Box) boxes.get(i2));
            }
            seekableByteChannelArr[i] = seekableByteChannelArr3;
        }
        return seekableByteChannelArr;
    }

    private int calcSpaceReq(MovieBox movieBox) {
        movieBox = movieBox.getTracks();
        int i = 0;
        int length = movieBox.length;
        int i2 = 0;
        while (i < length) {
            ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) Box.findFirst(movieBox[i], ChunkOffsetsBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, StaticChunkOffsetBox.TYPE);
            if (chunkOffsetsBox != null) {
                i2 += chunkOffsetsBox.getChunkOffsets().length * 4;
            }
            i++;
        }
        return i2;
    }

    public SeekableByteChannel resolveDataRef(Box box) throws IOException {
        if (box instanceof UrlBox) {
            box = ((UrlBox) box).getUrl();
            if (box.startsWith("file://")) {
                return NIOUtils.readableFileChannel(new File(box.substring(7)));
            }
            throw new RuntimeException("Only file:// urls are supported in data reference");
        } else if (box instanceof AliasBox) {
            box = ((AliasBox) box).getUnixPath();
            if (box != null) {
                return NIOUtils.readableFileChannel(new File(box));
            }
            throw new RuntimeException("Could not resolve alias");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(box.getHeader().getFourcc());
            stringBuilder.append(" dataref type is not supported");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public void flattern(MovieBox movieBox, File file) throws IOException {
        file.delete();
        try {
            file = NIOUtils.writableFileChannel(file);
            try {
                flattern(movieBox, (SeekableByteChannel) file);
                if (file != null) {
                    file.close();
                }
            } catch (Throwable th) {
                movieBox = th;
                if (file != null) {
                    file.close();
                }
                throw movieBox;
            }
        } catch (Throwable th2) {
            movieBox = th2;
            file = null;
            if (file != null) {
                file.close();
            }
            throw movieBox;
        }
    }
}
