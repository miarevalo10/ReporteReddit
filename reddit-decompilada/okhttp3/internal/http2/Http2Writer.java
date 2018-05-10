package okhttp3.internal.http2;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer = new Buffer();
    final Writer hpackWriter = new Writer(this.hpackBuffer);
    private int maxFrameSize = 16384;
    private final BufferedSink sink;

    Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.sink = bufferedSink;
        this.client = z;
    }

    public final synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (this.client) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.mo6164f()));
            }
            this.sink.mo6764c(Http2.CONNECTION_PREFACE.mo6168i());
            this.sink.flush();
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, (byte) 4, (byte) 1);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j = this.hpackBuffer.f36201b;
        list = (int) Math.min((long) (this.maxFrameSize - 4), j);
        long j2 = (long) list;
        int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        frameHeader(i, list + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
        this.sink.mo6772f(i2 & RedditJobManager.f10810d);
        this.sink.write(this.hpackBuffer, j2);
        if (i3 > 0) {
            writeContinuationFrames(i, j - j2);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final synchronized void synStream(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (this.closed != 0) {
            throw new IOException("closed");
        }
        headers(z, i, list);
    }

    public final synchronized void synReply(boolean z, int i, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(z, i, list);
    }

    public final synchronized void headers(int i, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        headers(false, i, list);
    }

    public final synchronized void rstStream(int i, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        } else {
            frameHeader(i, 4, (byte) 3, (byte) 0);
            this.sink.mo6772f(errorCode.httpCode);
            this.sink.flush();
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i, z, buffer, i2);
    }

    final void dataFrame(int i, byte b, Buffer buffer, int i2) throws IOException {
        frameHeader(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.sink.write(buffer, (long) i2);
        }
    }

    public final synchronized void settings(Settings settings) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        int i = 0;
        frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (settings.isSet(i)) {
                int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                this.sink.mo6774g(i2);
                this.sink.mo6772f(settings.get(i));
            }
            i++;
        }
        this.sink.flush();
    }

    public final synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z);
        this.sink.mo6772f(i);
        this.sink.mo6772f(i2);
        this.sink.flush();
    }

    public final synchronized void goAway(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode == -1) {
            throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
        } else {
            frameHeader(0, 8 + bArr.length, (byte) 7, (byte) 0);
            this.sink.mo6772f(i);
            this.sink.mo6772f(errorCode.httpCode);
            if (bArr.length > 0) {
                this.sink.mo6764c(bArr);
            }
            this.sink.flush();
        }
    }

    public final synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j != 0) {
            if (j <= 2147483647L) {
                frameHeader(i, 4, (byte) 8, (byte) 0);
                this.sink.mo6772f((int) j);
                this.sink.flush();
            }
        }
        throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
    }

    public final void frameHeader(int i, int i2, byte b, byte b2) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i, i2, b, b2));
        }
        if (i2 > this.maxFrameSize) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(this.maxFrameSize), Integer.valueOf(i2)});
        } else if ((Integer.MIN_VALUE & i) != 0) {
            throw Http2.illegalArgument("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
        } else {
            writeMedium(this.sink, i2);
            this.sink.mo6775h(b & 255);
            this.sink.mo6775h(b2 & 255);
            this.sink.mo6772f(i & (byte) -1);
        }
    }

    public final synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    private static void writeMedium(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.mo6775h((i >>> 16) & 255);
        bufferedSink.mo6775h((i >>> 8) & 255);
        bufferedSink.mo6775h(i & 255);
    }

    private void writeContinuationFrames(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j);
            long j2 = (long) min;
            j -= j2;
            frameHeader(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j2);
        }
    }

    final void headers(boolean z, int i, List<Header> list) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j = this.hpackBuffer.f36201b;
        list = (int) Math.min((long) this.maxFrameSize, j);
        long j2 = (long) list;
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        byte b = i2 == 0 ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        frameHeader(i, list, true, b);
        this.sink.write(this.hpackBuffer, j2);
        if (i2 > 0) {
            writeContinuationFrames(i, j - j2);
        }
    }
}
