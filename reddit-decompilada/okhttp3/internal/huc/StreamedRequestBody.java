package okhttp3.internal.huc;

import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final Pipe pipe = new Pipe();

    StreamedRequestBody(long j) {
        initOutputStream(Okio.m28288a(this.pipe.f26674e), j);
    }

    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.pipe.f26675f.read(buffer, 8192) != -1) {
            bufferedSink.write(buffer, buffer.f36201b);
        }
    }
}
