package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = bufferedSource;
    }

    public final MediaType contentType() {
        return this.contentTypeString != null ? MediaType.parse(this.contentTypeString) : null;
    }

    public final long contentLength() {
        return this.contentLength;
    }

    public final BufferedSource source() {
        return this.source;
    }
}
