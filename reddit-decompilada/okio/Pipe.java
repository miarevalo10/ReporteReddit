package okio;

import java.io.IOException;

public final class Pipe {
    final long f26670a = 8192;
    final Buffer f26671b = new Buffer();
    boolean f26672c;
    boolean f26673d;
    public final Sink f26674e = new PipeSink(this);
    public final Source f26675f = new PipeSource(this);

    final class PipeSink implements Sink {
        final Timeout f33199a = new Timeout();
        final /* synthetic */ Pipe f33200b;

        PipeSink(Pipe pipe) {
            this.f33200b = pipe;
        }

        public final void write(Buffer buffer, long j) throws IOException {
            synchronized (this.f33200b.f26671b) {
                if (this.f33200b.f26672c) {
                    throw new IllegalStateException("closed");
                }
                while (j > 0) {
                    if (this.f33200b.f26673d) {
                        throw new IOException("source is closed");
                    }
                    long j2 = this.f33200b.f26670a - this.f33200b.f26671b.f36201b;
                    if (j2 == 0) {
                        this.f33199a.waitUntilNotified(this.f33200b.f26671b);
                    } else {
                        long min = Math.min(j2, j);
                        this.f33200b.f26671b.write(buffer, min);
                        j -= min;
                        this.f33200b.f26671b.notifyAll();
                    }
                }
            }
        }

        public final void flush() throws IOException {
            synchronized (this.f33200b.f26671b) {
                if (this.f33200b.f26672c) {
                    throw new IllegalStateException("closed");
                } else if (!this.f33200b.f26673d || this.f33200b.f26671b.f36201b <= 0) {
                } else {
                    throw new IOException("source is closed");
                }
            }
        }

        public final void close() throws IOException {
            synchronized (this.f33200b.f26671b) {
                if (this.f33200b.f26672c) {
                } else if (!this.f33200b.f26673d || this.f33200b.f26671b.f36201b <= 0) {
                    this.f33200b.f26672c = true;
                    this.f33200b.f26671b.notifyAll();
                } else {
                    throw new IOException("source is closed");
                }
            }
        }

        public final Timeout timeout() {
            return this.f33199a;
        }
    }

    final class PipeSource implements Source {
        final Timeout f33201a = new Timeout();
        final /* synthetic */ Pipe f33202b;

        PipeSource(Pipe pipe) {
            this.f33202b = pipe;
        }

        public final long read(Buffer buffer, long j) throws IOException {
            synchronized (this.f33202b.f26671b) {
                if (this.f33202b.f26673d) {
                    throw new IllegalStateException("closed");
                }
                while (this.f33202b.f26671b.f36201b == 0) {
                    if (this.f33202b.f26672c) {
                        return -1;
                    }
                    this.f33201a.waitUntilNotified(this.f33202b.f26671b);
                }
                buffer = this.f33202b.f26671b.read(buffer, j);
                this.f33202b.f26671b.notifyAll();
                return buffer;
            }
        }

        public final void close() throws IOException {
            synchronized (this.f33202b.f26671b) {
                this.f33202b.f26673d = true;
                this.f33202b.f26671b.notifyAll();
            }
        }

        public final Timeout timeout() {
            return this.f33201a;
        }
    }
}
