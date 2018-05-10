package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer = new Buffer();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    final byte[] maskBuffer;
    final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    boolean writerClosed;

    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        public final void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.buffer.write(buffer, j);
            buffer = (this.isFirstFrame == null || this.contentLength == -1 || WebSocketWriter.this.buffer.f36201b <= this.contentLength - 8192) ? null : true;
            long f = WebSocketWriter.this.buffer.m36512f();
            if (f > 0 && buffer == null) {
                WebSocketWriter.this.writeMessageFrame(this.formatOpcode, f, this.isFirstFrame, false);
                this.isFirstFrame = false;
            }
        }

        public final void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.f36201b, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        public final Timeout timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public final void close() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, WebSocketWriter.this.buffer.f36201b, this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }
    }

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random == null) {
            throw new NullPointerException("random == null");
        } else {
            this.isClient = z;
            this.sink = bufferedSink;
            this.random = random;
            bufferedSink = null;
            this.maskKey = z ? new byte[4] : null;
            if (z) {
                bufferedSink = new byte[true];
            }
            this.maskBuffer = bufferedSink;
        }
    }

    final void writePing(ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    final void writePong(ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }

    final void writeClose(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.f26664b;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            Buffer buffer = new Buffer();
            buffer.m36500c(i);
            if (byteString != null) {
                buffer.m36486a(byteString);
            }
            byteString2 = buffer.m36534o();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    private void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int h = byteString.mo6166h();
        if (((long) h) > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sink.mo6775h(i | 128);
        if (this.isClient != 0) {
            this.sink.mo6775h(h | 128);
            this.random.nextBytes(this.maskKey);
            this.sink.mo6764c(this.maskKey);
            i = byteString.mo6168i();
            WebSocketProtocol.toggleMask(i, (long) i.length, this.maskKey, 0);
            this.sink.mo6764c(i);
        } else {
            this.sink.mo6775h(h);
            this.sink.mo6767d(byteString);
        }
        this.sink.flush();
    }

    final Sink newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        this.frameSink.formatOpcode = i;
        this.frameSink.contentLength = j;
        this.frameSink.isFirstFrame = true;
        this.frameSink.closed = 0;
        return this.frameSink;
    }

    final void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.sink.mo6775h(i);
        i = this.isClient != 0 ? 128 : 0;
        if (j <= true) {
            this.sink.mo6775h(i | ((int) j));
        } else if (j <= true) {
            this.sink.mo6775h(i | 126);
            this.sink.mo6774g((int) j);
        } else {
            this.sink.mo6775h(i | 127);
            this.sink.mo6787o(j);
        }
        if (this.isClient != 0) {
            this.random.nextBytes(this.maskKey);
            this.sink.mo6764c(this.maskKey);
            z = 0;
            while (z < j) {
                i = this.buffer.mo6750a(this.maskBuffer, 0, (int) Math.min(j, (long) this.maskBuffer.length));
                if (i == -1) {
                    throw new AssertionError();
                }
                long j2 = (long) i;
                WebSocketProtocol.toggleMask(this.maskBuffer, j2, this.maskKey, z);
                this.sink.mo6765c(this.maskBuffer, 0, i);
                z += j2;
            }
        } else {
            this.sink.write(this.buffer, j);
        }
        this.sink.mo6763c();
    }
}
