package okhttp3.internal.huc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;

abstract class OutputStreamRequestBody extends RequestBody {
    boolean closed;
    private long expectedContentLength;
    private OutputStream outputStream;
    private Timeout timeout;

    public final MediaType contentType() {
        return null;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        return request;
    }

    OutputStreamRequestBody() {
    }

    protected void initOutputStream(final BufferedSink bufferedSink, final long j) {
        this.timeout = bufferedSink.timeout();
        this.expectedContentLength = j;
        this.outputStream = new OutputStream() {
            private long bytesReceived;

            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (OutputStreamRequestBody.this.closed) {
                    throw new IOException("closed");
                } else if (j == -1 || this.bytesReceived + ((long) i2) <= j) {
                    this.bytesReceived += (long) i2;
                    try {
                        bufferedSink.mo6765c(bArr, i, i2);
                    } catch (byte[] bArr2) {
                        throw new SocketTimeoutException(bArr2.getMessage());
                    }
                } else {
                    i = new StringBuilder("expected ");
                    i.append(j);
                    i.append(" bytes but received ");
                    i.append(this.bytesReceived);
                    i.append(i2);
                    throw new ProtocolException(i.toString());
                }
            }

            public void flush() throws IOException {
                if (!OutputStreamRequestBody.this.closed) {
                    bufferedSink.flush();
                }
            }

            public void close() throws IOException {
                OutputStreamRequestBody.this.closed = true;
                if (j == -1 || this.bytesReceived >= j) {
                    bufferedSink.close();
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder("expected ");
                stringBuilder.append(j);
                stringBuilder.append(" bytes but received ");
                stringBuilder.append(this.bytesReceived);
                throw new ProtocolException(stringBuilder.toString());
            }
        };
    }

    public final OutputStream outputStream() {
        return this.outputStream;
    }

    public final Timeout timeout() {
        return this.timeout;
    }

    public final boolean isClosed() {
        return this.closed;
    }

    public long contentLength() throws IOException {
        return this.expectedContentLength;
    }
}
