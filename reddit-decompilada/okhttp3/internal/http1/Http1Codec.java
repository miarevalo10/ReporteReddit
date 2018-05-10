package okhttp3.internal.http1;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit = 262144;
    final BufferedSink sink;
    final BufferedSource source;
    int state = 0;
    final StreamAllocation streamAllocation;

    private abstract class AbstractSource implements Source {
        protected long bytesRead;
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1Codec.this.source.timeout());
            this.bytesRead = 0;
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                buffer = Http1Codec.this.source.read(buffer, j);
                if (buffer > 0) {
                    this.bytesRead += buffer;
                }
                return buffer;
            } catch (Buffer buffer2) {
                endOfInput(0, buffer2);
                throw buffer2;
            }
        }

        protected final void endOfInput(boolean z, IOException iOException) throws IOException {
            if (Http1Codec.this.state != 6) {
                if (Http1Codec.this.state != 5) {
                    iOException = new StringBuilder("state: ");
                    iOException.append(Http1Codec.this.state);
                    throw new IllegalStateException(iOException.toString());
                }
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 6;
                if (Http1Codec.this.streamAllocation != null) {
                    Http1Codec.this.streamAllocation.streamFinished(z ^ 1, Http1Codec.this, this.bytesRead, iOException);
                }
            }
        }
    }

    private final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());

        ChunkedSink() {
        }

        public final Timeout timeout() {
            return this.timeout;
        }

        public final void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1Codec.this.sink.mo6784m(j);
                Http1Codec.this.sink.mo6760b("\r\n");
                Http1Codec.this.sink.write(buffer, j);
                Http1Codec.this.sink.mo6760b("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.sink.mo6760b("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }
    }

    private final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout = new ForwardingTimeout(Http1Codec.this.sink.timeout());

        FixedLengthSink(long j) {
            this.bytesRemaining = j;
        }

        public final Timeout timeout() {
            return this.timeout;
        }

        public final void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.f36201b, 0, j);
            if (j > this.bytesRemaining) {
                StringBuilder stringBuilder = new StringBuilder("expected ");
                stringBuilder.append(this.bytesRemaining);
                stringBuilder.append(" bytes but received ");
                stringBuilder.append(j);
                throw new ProtocolException(stringBuilder.toString());
            }
            Http1Codec.this.sink.write(buffer, j);
            this.bytesRemaining -= j;
        }

        public final void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpUrl url;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.url = httpUrl;
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                buffer = super.read(buffer, Math.min(j, this.bytesRemainingInChunk));
                if (buffer == -1) {
                    buffer = new ProtocolException("unexpected end of stream");
                    endOfInput(0, buffer);
                    throw buffer;
                }
                this.bytesRemainingInChunk -= buffer;
                return buffer;
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1Codec.this.source.mo6788q();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.mo6785n();
                String trim = Http1Codec.this.source.mo6788q().trim();
                if (this.bytesRemainingInChunk >= 0) {
                    if (trim.isEmpty() || trim.startsWith(";")) {
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                            endOfInput(true, null);
                            return;
                        }
                        return;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("expected chunk size and optional extensions but was \"");
                stringBuilder.append(this.bytesRemainingInChunk);
                stringBuilder.append(trim);
                stringBuilder.append("\"");
                throw new ProtocolException(stringBuilder.toString());
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput(true, null);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                buffer = super.read(buffer, Math.min(this.bytesRemaining, j));
                if (buffer == -1) {
                    buffer = new ProtocolException("unexpected end of stream");
                    endOfInput(0, buffer);
                    throw buffer;
                }
                this.bytesRemaining -= buffer;
                if (this.bytesRemaining == 0) {
                    endOfInput(true, null);
                }
                return buffer;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!(this.bytesRemaining == 0 || Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        UnknownLengthSource() {
            super();
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                buffer = super.read(buffer, j);
                if (buffer != -1) {
                    return buffer;
                }
                this.inputExhausted = true;
                endOfInput(true, 0);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    public final Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding")) != null) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, Okio.m28289a(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, Okio.m28289a(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(header, contentLength, Okio.m28289a(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(header, -1, Okio.m28289a(newUnknownLengthSource()));
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    public final void flushRequest() throws IOException {
        this.sink.flush();
    }

    public final void finishRequest() throws IOException {
        this.sink.flush();
    }

    public final void writeRequest(Headers headers, String str) throws IOException {
        if (this.state != 0) {
            str = new StringBuilder("state: ");
            str.append(this.state);
            throw new IllegalStateException(str.toString());
        }
        this.sink.mo6760b(str).mo6760b("\r\n");
        int size = headers.size();
        for (str = null; str < size; str++) {
            this.sink.mo6760b(headers.name(str)).mo6760b(": ").mo6760b(headers.value(str)).mo6760b("\r\n");
        }
        this.sink.mo6760b("\r\n");
        this.state = 1;
    }

    public final Builder readResponseHeaders(boolean z) throws IOException {
        if (this.state == 1 || this.state == 3) {
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Builder headers = new Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code) {
                    return false;
                }
                this.state = true;
                return headers;
            } catch (boolean z2) {
                StringBuilder stringBuilder = new StringBuilder("unexpected end of stream on ");
                stringBuilder.append(this.streamAllocation);
                IOException iOException = new IOException(stringBuilder.toString());
                iOException.initCause(z2);
                throw iOException;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("state: ");
        stringBuilder2.append(this.state);
        throw new IllegalStateException(stringBuilder2.toString());
    }

    private String readHeaderLine() throws IOException {
        String f = this.source.mo6771f(this.headerLimit);
        this.headerLimit -= (long) f.length();
        return f;
    }

    public final Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readHeaderLine);
        }
    }

    public final Sink newChunkedSink() {
        if (this.state != 1) {
            StringBuilder stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.state);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.state = 2;
        return new ChunkedSink();
    }

    public final Sink newFixedLengthSink(long j) {
        if (this.state != 1) {
            StringBuilder stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.state);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.state = 2;
        return new FixedLengthSink(j);
    }

    public final Source newFixedLengthSource(long j) throws IOException {
        if (this.state != 4) {
            StringBuilder stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.state);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.state = 5;
        return new FixedLengthSource(j);
    }

    public final Source newChunkedSource(HttpUrl httpUrl) throws IOException {
        if (this.state != 4) {
            StringBuilder stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.state);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.state = 5;
        return new ChunkedSource(httpUrl);
    }

    public final Source newUnknownLengthSource() throws IOException {
        if (this.state != 4) {
            StringBuilder stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.state);
            throw new IllegalStateException(stringBuilder.toString());
        } else if (this.streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.state = 5;
            this.streamAllocation.noNewStreams();
            return new UnknownLengthSource();
        }
    }

    final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout timeout = forwardingTimeout.f33185a;
        Timeout timeout2 = Timeout.NONE;
        if (timeout2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        forwardingTimeout.f33185a = timeout2;
        timeout.clearDeadline();
        timeout.clearTimeout();
    }
}
