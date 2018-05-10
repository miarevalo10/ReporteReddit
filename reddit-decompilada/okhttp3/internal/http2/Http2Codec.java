package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {
    private static final ByteString CONNECTION = ByteString.m28267a("connection");
    private static final ByteString ENCODING = ByteString.m28267a("encoding");
    private static final ByteString HOST = ByteString.m28267a("host");
    private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY);
    private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    private static final ByteString KEEP_ALIVE = ByteString.m28267a("keep-alive");
    private static final ByteString PROXY_CONNECTION = ByteString.m28267a("proxy-connection");
    private static final ByteString TE = ByteString.m28267a("te");
    private static final ByteString TRANSFER_ENCODING = ByteString.m28267a("transfer-encoding");
    private static final ByteString UPGRADE = ByteString.m28267a("upgrade");
    private final Chain chain;
    private final OkHttpClient client;
    private final Http2Connection connection;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    class StreamFinishingSource extends ForwardingSource {
        long bytesRead = null;
        boolean completed = null;

        StreamFinishingSource(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                buffer = delegate().read(buffer, j);
                if (buffer > 0) {
                    this.bytesRead += buffer;
                }
                return buffer;
            } catch (Buffer buffer2) {
                endOfInput(buffer2);
                throw buffer2;
            }
        }

        public void close() throws IOException {
            super.close();
            endOfInput(null);
        }

        private void endOfInput(IOException iOException) {
            if (!this.completed) {
                this.completed = true;
                Http2Codec.this.streamAllocation.streamFinished(false, Http2Codec.this, this.bytesRead, iOException);
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.client = okHttpClient;
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
    }

    public final Sink createRequestBody(Request request, long j) {
        return this.stream.getSink();
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        if (this.stream == null) {
            this.stream = this.connection.newStream(http2HeadersList(request), request.body() != null);
            this.stream.readTimeout().timeout((long) this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public final void flushRequest() throws IOException {
        this.connection.flush();
    }

    public final void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public final Builder readResponseHeaders(boolean z) throws IOException {
        Builder readHttp2HeadersList = readHttp2HeadersList(this.stream.takeResponseHeaders());
        return (z && Internal.instance.code(readHttp2HeadersList)) ? false : readHttp2HeadersList;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        List<Header> arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header("Host");
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (request = null; request < size; request++) {
            ByteString a = ByteString.m28267a(headers.name(request).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(a)) {
                arrayList.add(new Header(a, headers.value(request)));
            }
        }
        return arrayList;
    }

    public static Builder readHttp2HeadersList(List<Header> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        Headers.Builder builder2 = builder;
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = (Header) list.get(i);
            if (header != null) {
                ByteString byteString = header.name;
                String a = header.value.mo6154a();
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    StringBuilder stringBuilder = new StringBuilder("HTTP/1.1 ");
                    stringBuilder.append(a);
                    statusLine = StatusLine.parse(stringBuilder.toString());
                } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
                    Internal.instance.addLenient(builder2, byteString.mo6154a(), a);
                }
            } else if (statusLine != null && statusLine.code == 100) {
                builder2 = new Headers.Builder();
                statusLine = null;
            }
        }
        if (statusLine != null) {
            return new Builder().protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder2.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), Okio.m28289a(new StreamFinishingSource(this.stream.getSource())));
    }

    public final void cancel() {
        if (this.stream != null) {
            this.stream.closeLater(ErrorCode.CANCEL);
        }
    }
}
