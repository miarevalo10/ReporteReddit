package org.jcodec.containers.mp4;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jcodec.common.Codec;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.BoxFactory;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class MP4Util {
    private static Map<Codec, String> codecMapping;

    public static class Atom {
        private Header header;
        private long offset;

        public Atom(Header header, long j) {
            this.header = header;
            this.offset = j;
        }

        public long getOffset() {
            return this.offset;
        }

        public Header getHeader() {
            return this.header;
        }

        public Box parseBox(SeekableByteChannel seekableByteChannel) throws IOException {
            seekableByteChannel.position(this.offset + this.header.headerSize());
            return NodeBox.parseBox(NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, (int) this.header.getSize()), this.header, BoxFactory.getDefault());
        }

        public void copy(SeekableByteChannel seekableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
            seekableByteChannel.position(this.offset);
            NIOUtils.copy(seekableByteChannel, writableByteChannel, this.header.getSize());
        }
    }

    static {
        Map hashMap = new HashMap();
        codecMapping = hashMap;
        hashMap.put(Codec.MPEG2, "m2v1");
        codecMapping.put(Codec.H264, VisualSampleEntry.TYPE3);
        codecMapping.put(Codec.J2K, "mjp2");
    }

    public static MovieBox createRefMovie(SeekableByteChannel seekableByteChannel, String str) throws IOException {
        seekableByteChannel = parseMovie(seekableByteChannel);
        for (TrakBox dataRef : seekableByteChannel.getTracks()) {
            dataRef.setDataRef(str);
        }
        return seekableByteChannel;
    }

    public static MovieBox parseMovie(SeekableByteChannel seekableByteChannel) throws IOException {
        for (Atom atom : getRootAtoms(seekableByteChannel)) {
            if (com.coremedia.iso.boxes.MovieBox.TYPE.equals(atom.getHeader().getFourcc())) {
                return (MovieBox) atom.parseBox(seekableByteChannel);
            }
        }
        return null;
    }

    public static List<MovieFragmentBox> parseMovieFragments(SeekableByteChannel seekableByteChannel) throws IOException {
        List linkedList = new LinkedList();
        MovieBox movieBox = null;
        for (Atom atom : getRootAtoms(seekableByteChannel)) {
            if (com.coremedia.iso.boxes.MovieBox.TYPE.equals(atom.getHeader().getFourcc())) {
                movieBox = (MovieBox) atom.parseBox(seekableByteChannel);
            } else if (com.coremedia.iso.boxes.fragment.MovieFragmentBox.TYPE.equalsIgnoreCase(atom.getHeader().getFourcc())) {
                linkedList.add((MovieFragmentBox) atom.parseBox(seekableByteChannel));
            }
        }
        seekableByteChannel = linkedList.iterator();
        while (seekableByteChannel.hasNext()) {
            ((MovieFragmentBox) seekableByteChannel.next()).setMovie(movieBox);
        }
        return linkedList;
    }

    public static List<Atom> getRootAtoms(SeekableByteChannel seekableByteChannel) throws IOException {
        long j = 0;
        seekableByteChannel.position(0);
        List<Atom> arrayList = new ArrayList();
        while (j < seekableByteChannel.size()) {
            seekableByteChannel.position(j);
            Header read = Header.read(NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, 16));
            if (read == null) {
                break;
            }
            arrayList.add(new Atom(read, j));
            j += read.getSize();
        }
        return arrayList;
    }

    public static Atom atom(SeekableByteChannel seekableByteChannel) throws IOException {
        long position = seekableByteChannel.position();
        seekableByteChannel = Header.read(NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, 16));
        if (seekableByteChannel == null) {
            return null;
        }
        return new Atom(seekableByteChannel, position);
    }

    public static MovieBox parseMovie(File file) throws IOException {
        Throwable th;
        try {
            file = NIOUtils.readableFileChannel(file);
            try {
                MovieBox parseMovie = parseMovie((SeekableByteChannel) file);
                if (file != null) {
                    file.close();
                }
                return parseMovie;
            } catch (Throwable th2) {
                th = th2;
                if (file != null) {
                    file.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            file = null;
            if (file != null) {
                file.close();
            }
            throw th;
        }
    }

    public static MovieBox createRefMovie(File file) throws IOException {
        SeekableByteChannel readableFileChannel;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file);
            try {
                StringBuilder stringBuilder = new StringBuilder("file://");
                stringBuilder.append(file.getCanonicalPath());
                file = createRefMovie(readableFileChannel, stringBuilder.toString());
                if (readableFileChannel != null) {
                    readableFileChannel.close();
                }
                return file;
            } catch (Throwable th) {
                file = th;
                if (readableFileChannel != null) {
                    readableFileChannel.close();
                }
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            readableFileChannel = null;
            if (readableFileChannel != null) {
                readableFileChannel.close();
            }
            throw file;
        }
    }

    public static void writeMovie(File file, MovieBox movieBox) throws IOException {
        FileChannel fileChannel = null;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                writeMovie(file, movieBox);
                channel.close();
            } catch (Throwable th) {
                file = th;
                fileChannel = channel;
                fileChannel.close();
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            fileChannel.close();
            throw file;
        }
    }

    public static void writeMovie(SeekableByteChannel seekableByteChannel, MovieBox movieBox) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(16777216);
        movieBox.write(allocate);
        allocate.flip();
        seekableByteChannel.write(allocate);
    }

    public static Box cloneBox(Box box, int i) {
        return cloneBox(box, i, BoxFactory.getDefault());
    }

    public static Box cloneBox(Box box, int i, BoxFactory boxFactory) {
        i = ByteBuffer.allocate(i);
        box.write(i);
        i.flip();
        return NodeBox.parseChildBox(i, boxFactory);
    }

    public static String getFourcc(Codec codec) {
        return (String) codecMapping.get(codec);
    }

    public static ByteBuffer writeBox(Box box, int i) {
        i = ByteBuffer.allocate(i);
        box.write(i);
        i.flip();
        return i;
    }
}
