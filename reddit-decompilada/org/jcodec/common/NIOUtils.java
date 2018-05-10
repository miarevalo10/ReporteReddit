package org.jcodec.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class NIOUtils {

    public static abstract class FileReader {
        private int oldPd;

        public abstract void data(ByteBuffer byteBuffer, long j);

        public abstract void done();

        public void readFile(SeekableByteChannel seekableByteChannel, int i, FileReaderListener fileReaderListener) throws IOException {
            i = ByteBuffer.allocate(i);
            long size = seekableByteChannel.size();
            while (true) {
                long position = seekableByteChannel.position();
                if (seekableByteChannel.read(i) != -1) {
                    i.flip();
                    data(i, position);
                    i.flip();
                    if (fileReaderListener != null) {
                        int i2 = (int) ((100 * position) / size);
                        if (i2 != this.oldPd) {
                            fileReaderListener.progress(i2);
                        }
                        this.oldPd = i2;
                    }
                } else {
                    done();
                    return;
                }
            }
        }

        public void readFile(File file, int i, FileReaderListener fileReaderListener) throws IOException {
            ReadableByteChannel readableFileChannel;
            try {
                readableFileChannel = NIOUtils.readableFileChannel(file);
                try {
                    readFile((SeekableByteChannel) readableFileChannel, i, fileReaderListener);
                    NIOUtils.closeQuietly(readableFileChannel);
                } catch (Throwable th) {
                    i = th;
                    NIOUtils.closeQuietly(readableFileChannel);
                    throw i;
                }
            } catch (Throwable th2) {
                i = th2;
                readableFileChannel = null;
                NIOUtils.closeQuietly(readableFileChannel);
                throw i;
            }
        }
    }

    public interface FileReaderListener {
        void progress(int i);
    }

    public static java.nio.ByteBuffer combine(java.nio.ByteBuffer... r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: org.jcodec.common.NIOUtils.combine(java.nio.ByteBuffer[]):java.nio.ByteBuffer
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:370)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:360)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:106)
	... 7 more
*/
        /*
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.NIOUtils.combine(java.nio.ByteBuffer[]):java.nio.ByteBuffer");
    }

    public static ByteBuffer search(ByteBuffer byteBuffer, int i, byte... bArr) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        int position = byteBuffer.position();
        int i2 = i;
        loop0:
        while (true) {
            i = 0;
            while (byteBuffer.hasRemaining()) {
                if (byteBuffer.get() == bArr[i]) {
                    i++;
                    if (i == bArr.length) {
                        if (i2 == 0) {
                            break;
                        }
                        i2--;
                    }
                } else if (i != 0) {
                    position++;
                    byteBuffer.position(position);
                } else {
                    position = byteBuffer.position();
                }
            }
            break loop0;
        }
        byteBuffer.position(position);
        duplicate.limit(byteBuffer.position());
        return duplicate;
    }

    public static final ByteBuffer read(ByteBuffer byteBuffer, int i) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        int position = byteBuffer.position() + i;
        duplicate.limit(position);
        byteBuffer.position(position);
        return duplicate;
    }

    public static ByteBuffer fetchFrom(File file) throws IOException {
        return fetchFrom(file, (int) file.length());
    }

    public static ByteBuffer fetchFrom(ReadableByteChannel readableByteChannel, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        read(readableByteChannel, allocate);
        allocate.flip();
        return allocate;
    }

    public static ByteBuffer fetchFrom(ByteBuffer byteBuffer, ReadableByteChannel readableByteChannel, int i) throws IOException {
        byteBuffer = byteBuffer.duplicate();
        byteBuffer.limit(i);
        read(readableByteChannel, byteBuffer);
        byteBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer fetchFrom(File file, int i) throws IOException {
        ReadableByteChannel readableByteChannel = null;
        try {
            ReadableByteChannel channel = new FileInputStream(file).getChannel();
            try {
                i = fetchFrom(channel, i);
                closeQuietly(channel);
                return i;
            } catch (Throwable th) {
                i = th;
                readableByteChannel = channel;
                closeQuietly(readableByteChannel);
                throw i;
            }
        } catch (Throwable th2) {
            i = th2;
            closeQuietly(readableByteChannel);
            throw i;
        }
    }

    public static void writeTo(ByteBuffer byteBuffer, File file) throws IOException {
        ReadableByteChannel readableByteChannel = null;
        try {
            ReadableByteChannel channel = new FileOutputStream(file).getChannel();
            try {
                channel.write(byteBuffer);
                closeQuietly(channel);
            } catch (Throwable th) {
                byteBuffer = th;
                readableByteChannel = channel;
                closeQuietly(readableByteChannel);
                throw byteBuffer;
            }
        } catch (Throwable th2) {
            byteBuffer = th2;
            closeQuietly(readableByteChannel);
            throw byteBuffer;
        }
    }

    public static byte[] toArray(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return bArr;
    }

    public static byte[] toArray(ByteBuffer byteBuffer, int i) {
        i = new byte[Math.min(byteBuffer.remaining(), i)];
        byteBuffer.duplicate().get(i);
        return i;
    }

    public static int read(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.limit(Math.min(duplicate.position() + i, duplicate.limit()));
        do {
            i = readableByteChannel.read(duplicate);
            if (i == -1) {
                break;
            }
        } while (duplicate.hasRemaining());
        if (i == -1) {
            return -1;
        }
        byteBuffer.position(duplicate.position());
        return i;
    }

    public static int read(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int position = byteBuffer.position();
        while (readableByteChannel.read(byteBuffer) != -1) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
        }
        return byteBuffer.position() - position;
    }

    public static void write(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer2.hasArray()) {
            byteBuffer.put(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        } else {
            byteBuffer.put(toArray(byteBuffer2, byteBuffer.remaining()));
        }
    }

    public static void write(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        if (byteBuffer2.hasArray()) {
            byteBuffer.put(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), Math.min(byteBuffer2.remaining(), i));
        } else {
            byteBuffer.put(toArray(byteBuffer2, i));
        }
    }

    public static void fill(ByteBuffer byteBuffer, byte b) {
        while (byteBuffer.hasRemaining()) {
            byteBuffer.put(b);
        }
    }

    public static final MappedByteBuffer map(String str) throws IOException {
        return map(new File(str));
    }

    public static final MappedByteBuffer map(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        file = fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length());
        fileInputStream.close();
        return file;
    }

    public static int skip(ByteBuffer byteBuffer, int i) {
        i = Math.min(byteBuffer.remaining(), i);
        byteBuffer.position(byteBuffer.position() + i);
        return i;
    }

    public static ByteBuffer from(ByteBuffer byteBuffer, int i) {
        byteBuffer = byteBuffer.duplicate();
        byteBuffer.position(byteBuffer.position() + i);
        return byteBuffer;
    }

    public static ByteBuffer combine(Iterable<ByteBuffer> iterable) {
        int i = 0;
        for (ByteBuffer remaining : iterable) {
            i += remaining.remaining();
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        for (ByteBuffer write : iterable) {
            write(allocate, write);
        }
        allocate.flip();
        return allocate;
    }

    public static String readString(ByteBuffer byteBuffer, int i) {
        return new String(toArray(read(byteBuffer, i)));
    }

    public static String readPascalString(ByteBuffer byteBuffer, int i) {
        byteBuffer = read(byteBuffer, i + 1);
        return new String(toArray(read(byteBuffer, Math.min(byteBuffer.get() & 255, i))));
    }

    public static void writePascalString(ByteBuffer byteBuffer, String str, int i) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(JCodecUtil.asciiString(str));
        skip(byteBuffer, i - str.length());
    }

    public static void writePascalString(ByteBuffer byteBuffer, String str) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(JCodecUtil.asciiString(str));
    }

    public static String readPascalString(ByteBuffer byteBuffer) {
        return readString(byteBuffer, byteBuffer.get() & 255);
    }

    public static String readNullTermString(ByteBuffer byteBuffer) {
        return readNullTermString(byteBuffer, Charset.defaultCharset());
    }

    public static String readNullTermString(ByteBuffer byteBuffer, Charset charset) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        while (byteBuffer.hasRemaining()) {
            if (byteBuffer.get() == (byte) 0) {
                break;
            }
        }
        if (byteBuffer.hasRemaining()) {
            duplicate.limit(byteBuffer.position() - 1);
        }
        return new String(toArray(duplicate), charset);
    }

    public static ByteBuffer read(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        byteBuffer.position(byteBuffer.limit());
        return duplicate;
    }

    public static void copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(65536);
        do {
            allocate.position(0);
            allocate.limit((int) Math.min(j, (long) allocate.capacity()));
            int read = readableByteChannel.read(allocate);
            if (read != -1) {
                allocate.flip();
                writableByteChannel.write(allocate);
                j -= (long) read;
            }
            if (read == -1) {
                return;
            }
        } while (j > 0);
    }

    public static void closeQuietly(java.nio.channels.ReadableByteChannel r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0007 }
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.NIOUtils.closeQuietly(java.nio.channels.ReadableByteChannel):void");
    }

    public static void closeQuietly(java.io.RandomAccessFile r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0007 }
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.NIOUtils.closeQuietly(java.io.RandomAccessFile):void");
    }

    public static byte readByte(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        readableByteChannel.read(allocate);
        allocate.flip();
        return allocate.get();
    }

    public static byte[] readNByte(ReadableByteChannel readableByteChannel, int i) throws IOException {
        i = new byte[i];
        readableByteChannel.read(ByteBuffer.wrap(i));
        return i;
    }

    public static int readInt(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        readableByteChannel.read(allocate);
        allocate.flip();
        return allocate.getInt();
    }

    public static int readInt(ReadableByteChannel readableByteChannel, ByteOrder byteOrder) throws IOException {
        byteOrder = ByteBuffer.allocate(4).order(byteOrder);
        readableByteChannel.read(byteOrder);
        byteOrder.flip();
        return byteOrder.getInt();
    }

    public static void writeByte(WritableByteChannel writableByteChannel, byte b) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(1).put(b).flip());
    }

    public static void writeInt(WritableByteChannel writableByteChannel, int i, ByteOrder byteOrder) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(4).order(byteOrder).putInt(i).flip());
    }

    public static void writeIntLE(WritableByteChannel writableByteChannel, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        writableByteChannel.write((ByteBuffer) allocate.putInt(i).flip());
    }

    public static void writeInt(WritableByteChannel writableByteChannel, int i) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(4).putInt(i).flip());
    }

    public static void writeLong(WritableByteChannel writableByteChannel, long j) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(8).putLong(j).flip());
    }

    public static FileChannelWrapper readableFileChannel(File file) throws FileNotFoundException {
        return new FileChannelWrapper(new FileInputStream(file).getChannel());
    }

    public static FileChannelWrapper writableFileChannel(File file) throws FileNotFoundException {
        return new FileChannelWrapper(new FileOutputStream(file).getChannel());
    }

    public static FileChannelWrapper rwFileChannel(File file) throws FileNotFoundException {
        return new FileChannelWrapper(new RandomAccessFile(file, "rw").getChannel());
    }

    public static FileChannelWrapper readableFileChannel(String str) throws FileNotFoundException {
        return new FileChannelWrapper(new FileInputStream(str).getChannel());
    }

    public static FileChannelWrapper writableFileChannel(String str) throws FileNotFoundException {
        return new FileChannelWrapper(new FileOutputStream(str).getChannel());
    }

    public static FileChannelWrapper rwFileChannel(String str) throws FileNotFoundException {
        return new FileChannelWrapper(new RandomAccessFile(str, "rw").getChannel());
    }

    public static AutoFileChannelWrapper autoChannel(File file) throws IOException {
        return new AutoFileChannelWrapper(file);
    }

    public static ByteBuffer duplicate(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.put(byteBuffer.duplicate());
        allocate.flip();
        return allocate;
    }

    public static int find(List<ByteBuffer> list, ByteBuffer byteBuffer) {
        byteBuffer = toArray(byteBuffer);
        for (int i = 0; i < list.size(); i++) {
            if (Arrays.equals(toArray((ByteBuffer) list.get(i)), byteBuffer)) {
                return i;
            }
        }
        return -1;
    }

    public static byte getRel(ByteBuffer byteBuffer, int i) {
        return byteBuffer.get(byteBuffer.position() + i);
    }

    public static ByteBuffer cloneBuffer(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.put(byteBuffer.duplicate());
        allocate.clear();
        return allocate;
    }

    public static ByteBuffer clone(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.put(byteBuffer.duplicate());
        allocate.flip();
        return allocate;
    }
}
