package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

class Framer {
    public static final byte ENTER_FRAME_PREFIX = (byte) 33;
    public static final byte EXIT_FRAME_PREFIX = (byte) 120;
    public static final byte STDERR_FRAME_PREFIX = (byte) 50;
    public static final byte STDIN_FRAME_PREFIX = (byte) 45;
    public static final byte STDIN_REQUEST_FRAME_PREFIX = (byte) 95;
    public static final byte STDOUT_FRAME_PREFIX = (byte) 49;
    private static final String TAG = "FramingSocket";
    private final DataInputStream mInput;
    private final DataOutputStream mMultiplexedOutputStream;
    private final PrintStream mStderr = new PrintStream(new FramingOutputStream(STDERR_FRAME_PREFIX));
    private final InputStream mStdin = new FramingInputStream();
    private final PrintStream mStdout = new PrintStream(new BufferedOutputStream(new FramingOutputStream(STDOUT_FRAME_PREFIX)));

    private static class ClosedHelper {
        private volatile boolean mClosed;

        private ClosedHelper() {
        }

        public void throwIfClosed() throws IOException {
            if (this.mClosed) {
                throw new IOException("Stream is closed");
            }
        }

        public void close() {
            this.mClosed = true;
        }
    }

    private class FramingInputStream extends InputStream {
        private final ClosedHelper mClosedHelper;

        private FramingInputStream() {
            this.mClosedHelper = new ClosedHelper();
        }

        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (read(bArr) == 0) {
                return -1;
            }
            return bArr[0];
        }

        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int readInt;
            this.mClosedHelper.throwIfClosed();
            synchronized (Framer.this) {
                Framer.this.writeIntFrame(Framer.STDIN_REQUEST_FRAME_PREFIX, i2);
                byte readFrameType = Framer.this.readFrameType();
                if (readFrameType != Framer.STDIN_FRAME_PREFIX) {
                    throw new UnexpectedFrameException(Framer.STDIN_FRAME_PREFIX, readFrameType);
                }
                readInt = Framer.this.readInt();
                if (readInt > 0) {
                    if (readInt > i2) {
                        i = new StringBuilder("Expected at most ");
                        i.append(i2);
                        i.append(" bytes, got: ");
                        i.append(readInt);
                        throw new DumpappFramingException(i.toString());
                    }
                    Framer.this.mInput.readFully(bArr, i, readInt);
                }
            }
            return readInt;
        }

        public long skip(long j) throws IOException {
            long j2;
            byte[] bArr = new byte[((int) Math.min(j, 2048))];
            synchronized (Framer.this) {
                j2 = 0;
                while (j2 < j) {
                    int read = read(bArr);
                    if (read < 0) {
                        break;
                    }
                    j2 += (long) read;
                }
            }
            return j2;
        }

        public void close() throws IOException {
            this.mClosedHelper.close();
        }
    }

    private class FramingOutputStream extends OutputStream {
        private final ClosedHelper mClosedHelper = new ClosedHelper();
        private final byte mPrefix;

        public FramingOutputStream(byte b) {
            this.mPrefix = b;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mClosedHelper.throwIfClosed();
            if (i2 > 0) {
                try {
                    synchronized (Framer.this) {
                        Framer.this.writeIntFrame(this.mPrefix, i2);
                        Framer.this.writeBlob(bArr, i, i2);
                        Framer.this.mMultiplexedOutputStream.flush();
                    }
                } catch (Throwable e) {
                    throw new DumpappOutputBrokenException(e);
                }
            }
        }

        public void write(int i) throws IOException {
            write(new byte[]{(byte) i}, 0, 1);
        }

        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        public void close() throws IOException {
            this.mClosedHelper.close();
        }
    }

    public Framer(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.mInput = new DataInputStream(inputStream);
        this.mMultiplexedOutputStream = new DataOutputStream(outputStream);
    }

    public InputStream getStdin() {
        return this.mStdin;
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public byte readFrameType() throws IOException {
        return this.mInput.readByte();
    }

    public int readInt() throws IOException {
        return this.mInput.readInt();
    }

    public String readString() throws IOException {
        byte[] bArr = new byte[this.mInput.readUnsignedShort()];
        this.mInput.readFully(bArr);
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public void writeExitCode(int i) throws IOException {
        this.mStdout.flush();
        this.mStderr.flush();
        writeIntFrame(EXIT_FRAME_PREFIX, i);
    }

    public void writeIntFrame(byte b, int i) throws IOException {
        this.mMultiplexedOutputStream.write(b);
        this.mMultiplexedOutputStream.writeInt(i);
    }

    public void writeBlob(byte[] bArr, int i, int i2) throws IOException {
        this.mMultiplexedOutputStream.write(bArr, i, i2);
    }

    private static <T extends Throwable> T handleSuppression(T t, T t2) {
        if (t == null) {
            return t2;
        }
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = t2;
        StringBuilder stringBuilder = new StringBuilder("Suppressed while handling ");
        stringBuilder.append(t);
        objArr[1] = stringBuilder.toString();
        LogUtil.m3440i(str, objArr);
        return t;
    }
}
