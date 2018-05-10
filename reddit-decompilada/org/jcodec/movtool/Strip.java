package org.jcodec.movtool;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.Chunk;
import org.jcodec.containers.mp4.ChunkReader;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class Strip {
    private boolean intersects(long j, long j2, long j3, long j4) {
        return (j >= j3 && j < j4) || ((j2 >= j3 && j2 < j4) || ((j3 >= j && j3 < j2) || (j4 >= j && j4 < j2)));
    }

    public static void main(String[] strArr) throws Exception {
        SeekableByteChannel readableFileChannel;
        if (strArr.length < 2) {
            System.out.println("Syntax: strip <ref movie> <out movie>");
            System.exit(-1);
        }
        SeekableByteChannel writableFileChannel;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(new File(strArr[0]));
            try {
                File file = new File(strArr[1]);
                file.delete();
                writableFileChannel = NIOUtils.writableFileChannel(file);
                try {
                    StringBuilder stringBuilder = new StringBuilder("file://");
                    stringBuilder.append(new File(strArr[0]).getAbsolutePath());
                    MovieBox createRefMovie = MP4Util.createRefMovie(readableFileChannel, stringBuilder.toString());
                    new Strip().strip(createRefMovie);
                    MP4Util.writeMovie(writableFileChannel, createRefMovie);
                    if (readableFileChannel != null) {
                        readableFileChannel.close();
                    }
                    if (writableFileChannel != null) {
                        writableFileChannel.close();
                    }
                } catch (Throwable th) {
                    strArr = th;
                    if (readableFileChannel != null) {
                        readableFileChannel.close();
                    }
                    if (writableFileChannel != null) {
                        writableFileChannel.close();
                    }
                    throw strArr;
                }
            } catch (Throwable th2) {
                strArr = th2;
                writableFileChannel = null;
                if (readableFileChannel != null) {
                    readableFileChannel.close();
                }
                if (writableFileChannel != null) {
                    writableFileChannel.close();
                }
                throw strArr;
            }
        } catch (Throwable th3) {
            strArr = th3;
            readableFileChannel = null;
            writableFileChannel = readableFileChannel;
            if (readableFileChannel != null) {
                readableFileChannel.close();
            }
            if (writableFileChannel != null) {
                writableFileChannel.close();
            }
            throw strArr;
        }
    }

    public void strip(MovieBox movieBox) throws IOException {
        for (TrakBox stripTrack : movieBox.getTracks()) {
            stripTrack(movieBox, stripTrack);
        }
    }

    public void stripTrack(MovieBox movieBox, TrakBox trakBox) {
        TrakBox trakBox2 = trakBox;
        ChunkReader chunkReader = new ChunkReader(trakBox2);
        List edits = trakBox.getEdits();
        List deepCopy = deepCopy(edits);
        List arrayList = new ArrayList();
        while (true) {
            Chunk next = chunkReader.next();
            if (next != null) {
                ChunkReader chunkReader2;
                Iterator it = deepCopy.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Edit edit = (Edit) it.next();
                    if (edit.getMediaTime() != -1) {
                        Iterator it2 = it;
                        chunkReader2 = chunkReader;
                        z = intersects(edit.getMediaTime(), edit.getMediaTime() + trakBox2.rescale(edit.getDuration(), (long) movieBox.getTimescale()), next.getStartTv(), ((long) next.getDuration()) + next.getStartTv());
                        if (z) {
                            break;
                        }
                        it = it2;
                        chunkReader = chunkReader2;
                        trakBox2 = trakBox;
                    }
                }
                chunkReader2 = chunkReader;
                if (z) {
                    arrayList.add(next);
                } else {
                    for (int i = 0; i < deepCopy.size(); i++) {
                        if (((Edit) deepCopy.get(i)).getMediaTime() >= next.getStartTv() + ((long) next.getDuration())) {
                            ((Edit) edits.get(i)).shift((long) (-next.getDuration()));
                        }
                    }
                }
                chunkReader = chunkReader2;
                trakBox2 = trakBox;
            } else {
                NodeBox nodeBox = trakBox;
                NodeBox nodeBox2 = (NodeBox) Box.findFirst(nodeBox, NodeBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE);
                nodeBox2.replace(TimeToSampleBox.TYPE, getTimeToSamples(arrayList));
                nodeBox2.replace(SampleSizeBox.TYPE, getSampleSizes(arrayList));
                nodeBox2.replace(SampleToChunkBox.TYPE, getSamplesToChunk(arrayList));
                nodeBox2.removeChildren(StaticChunkOffsetBox.TYPE, ChunkOffset64BitBox.TYPE);
                nodeBox2.add(getChunkOffsets(arrayList));
                ((MediaHeaderBox) Box.findFirst(nodeBox, MediaHeaderBox.class, MediaBox.TYPE, com.coremedia.iso.boxes.MediaHeaderBox.TYPE)).setDuration(totalDuration(arrayList));
                return;
            }
        }
    }

    private long totalDuration(List<Chunk> list) {
        long j = 0;
        for (Chunk duration : list) {
            j += (long) duration.getDuration();
        }
        return j;
    }

    private List<Edit> deepCopy(List<Edit> list) {
        List arrayList = new ArrayList();
        for (Edit edit : list) {
            arrayList.add(new Edit(edit));
        }
        return arrayList;
    }

    public Box getChunkOffsets(List<Chunk> list) {
        long[] jArr = new long[list.size()];
        Object obj = null;
        int i = 0;
        for (Chunk chunk : list) {
            if (chunk.getOffset() >= 4294967296L) {
                obj = 1;
            }
            int i2 = i + 1;
            jArr[i] = chunk.getOffset();
            i = i2;
        }
        return obj != null ? new ChunkOffsets64Box(jArr) : new ChunkOffsetsBox(jArr);
    }

    public org.jcodec.containers.mp4.boxes.TimeToSampleBox getTimeToSamples(List<Chunk> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = -1;
        for (Chunk chunk : list) {
            if (chunk.getSampleDur() > 0) {
                if (i2 == -1 || i2 != chunk.getSampleDur()) {
                    if (i2 != -1) {
                        arrayList.add(new TimeToSampleEntry(i, i2));
                    }
                    i2 = chunk.getSampleDur();
                    i = 0;
                }
                i += chunk.getSampleCount();
            } else {
                int i3 = i;
                for (int i4 : chunk.getSampleDurs()) {
                    if (i2 == -1 || i2 != i4) {
                        if (i2 != -1) {
                            arrayList.add(new TimeToSampleEntry(i3, i2));
                        }
                        i3 = 0;
                        i2 = i4;
                    }
                    i3++;
                }
                i = i3;
            }
        }
        if (i > 0) {
            arrayList.add(new TimeToSampleEntry(i, i2));
        }
        return new org.jcodec.containers.mp4.boxes.TimeToSampleBox((TimeToSampleEntry[]) arrayList.toArray(new TimeToSampleEntry[0]));
    }

    public SampleSizesBox getSampleSizes(List<Chunk> list) {
        int sampleSize = ((Chunk) list.get(0)).getSampleSize();
        int i = 0;
        for (Chunk chunk : list) {
            i += chunk.getSampleCount();
            if (sampleSize == 0 && chunk.getSampleSize() != 0) {
                throw new RuntimeException("Mixed sample sizes not supported");
            }
        }
        if (sampleSize > 0) {
            return new SampleSizesBox(sampleSize, i);
        }
        Object obj = new int[i];
        int i2 = 0;
        for (Chunk chunk2 : list) {
            System.arraycopy(chunk2.getSampleSizes(), 0, obj, i2, chunk2.getSampleCount());
            i2 += chunk2.getSampleCount();
        }
        return new SampleSizesBox(obj);
    }

    public org.jcodec.containers.mp4.boxes.SampleToChunkBox getSamplesToChunk(List<Chunk> list) {
        ArrayList arrayList = new ArrayList();
        list = list.iterator();
        Chunk chunk = (Chunk) list.next();
        int sampleCount = chunk.getSampleCount();
        int entry = chunk.getEntry();
        int i = 1;
        int i2 = i;
        while (list.hasNext()) {
            Chunk chunk2 = (Chunk) list.next();
            int sampleCount2 = chunk2.getSampleCount();
            int entry2 = chunk2.getEntry();
            if (sampleCount != sampleCount2 || entry != entry2) {
                arrayList.add(new SampleToChunkEntry((long) i2, sampleCount, entry));
                i2 += i;
                entry = entry2;
                i = 0;
                sampleCount = sampleCount2;
            }
            i++;
        }
        if (i > 0) {
            arrayList.add(new SampleToChunkEntry((long) i2, sampleCount, entry));
        }
        return new org.jcodec.containers.mp4.boxes.SampleToChunkBox((SampleToChunkEntry[]) arrayList.toArray(new SampleToChunkEntry[0]));
    }
}
