package okhttp3.internal.huc;

import java.io.IOException;
import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSink;

final class BufferedRequestBody extends OutputStreamRequestBody {
    final Buffer buffer = new Buffer();
    long contentLength = -1;

    BufferedRequestBody(long j) {
        initOutputStream(this.buffer, j);
    }

    public final long contentLength() throws IOException {
        return this.contentLength;
    }

    public final Request prepareToSendRequest(Request request) throws IOException {
        if (request.header("Content-Length") != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.f36201b;
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.f36201b)).build();
    }

    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        this.buffer.m36485a(bufferedSink.mo6754a(), 0, this.buffer.f36201b);
    }
}
