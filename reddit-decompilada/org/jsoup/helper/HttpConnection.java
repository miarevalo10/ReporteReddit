package org.jsoup.helper;

import com.facebook.stetho.server.http.HttpStatus;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.http.StatusLine;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jsoup.Connection;
import org.jsoup.Connection.KeyVal;
import org.jsoup.Connection.Method;
import org.jsoup.HttpStatusException;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

public class HttpConnection implements Connection {
    private org.jsoup.Connection.Request f33329a = new Request();
    private org.jsoup.Connection.Response f33330b = new Response();

    private static abstract class Base<T extends org.jsoup.Connection.Base> implements org.jsoup.Connection.Base<T> {
        Map<String, String> cookies;
        Map<String, String> headers;
        Method method;
        URL url;

        private Base() {
            this.headers = new LinkedHashMap();
            this.cookies = new LinkedHashMap();
        }

        public URL url() {
            return this.url;
        }

        public T url(URL url) {
            Validate.m28453a((Object) url, "URL must not be null");
            this.url = url;
            return this;
        }

        public Method method() {
            return this.method;
        }

        public T method(Method method) {
            Validate.m28453a((Object) method, "Method must not be null");
            this.method = method;
            return this;
        }

        public String header(String str) {
            Validate.m28453a((Object) str, "Header name must not be null");
            str = getHeaderCaseInsensitive(str);
            return str != null ? fixHeaderEncoding(str) : str;
        }

        private static java.lang.String fixHeaderEncoding(java.lang.String r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x0015 }
            r0 = r3.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0015 }
            r1 = looksLikeUtf8(r0);	 Catch:{ UnsupportedEncodingException -> 0x0015 }
            if (r1 != 0) goto L_0x000d;	 Catch:{ UnsupportedEncodingException -> 0x0015 }
        L_0x000c:
            return r3;	 Catch:{ UnsupportedEncodingException -> 0x0015 }
        L_0x000d:
            r1 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0015 }
            r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0015 }
            r1.<init>(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x0015 }
            return r1;
        L_0x0015:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Base.fixHeaderEncoding(java.lang.String):java.lang.String");
        }

        private static boolean looksLikeUtf8(byte[] bArr) {
            int length;
            byte b;
            int i;
            int i2 = 3;
            if (bArr.length >= 3 && (bArr[0] & 255) == JpegConst.APPF) {
                if ((((bArr[1] & 255) == 187 ? 1 : 0) & ((bArr[2] & 255) == 191 ? 1 : 0)) != 0) {
                    length = bArr.length;
                    while (i2 < length) {
                        b = bArr[i2];
                        if ((b & 128) == 0) {
                            if ((b & JpegConst.APP0) == JpegConst.SOF0) {
                                i = i2 + 1;
                            } else if ((b & 240) == JpegConst.APP0) {
                                i = i2 + 2;
                            } else if ((b & 248) == 240) {
                                return false;
                            } else {
                                i = i2 + 3;
                            }
                            while (i2 < i) {
                                i2++;
                                if ((bArr[i2] & JpegConst.SOF0) != 128) {
                                    return false;
                                }
                            }
                            continue;
                        }
                        i2++;
                    }
                    return true;
                }
            }
            i2 = false;
            length = bArr.length;
            while (i2 < length) {
                b = bArr[i2];
                if ((b & 128) == 0) {
                    if ((b & JpegConst.APP0) == JpegConst.SOF0) {
                        i = i2 + 1;
                    } else if ((b & 240) == JpegConst.APP0) {
                        i = i2 + 2;
                    } else if ((b & 248) == 240) {
                        return false;
                    } else {
                        i = i2 + 3;
                    }
                    while (i2 < i) {
                        i2++;
                        if ((bArr[i2] & JpegConst.SOF0) != 128) {
                            return false;
                        }
                    }
                    continue;
                }
                i2++;
            }
            return true;
        }

        public T header(String str, String str2) {
            Validate.m28455a(str, "Header name must not be empty");
            Validate.m28453a((Object) str2, "Header value must not be null");
            removeHeader(str);
            this.headers.put(str, str2);
            return this;
        }

        public boolean hasHeader(String str) {
            Validate.m28455a(str, "Header name must not be empty");
            return getHeaderCaseInsensitive(str) != null ? true : null;
        }

        public boolean hasHeaderWithValue(String str, String str2) {
            return (!hasHeader(str) || header(str).equalsIgnoreCase(str2) == null) ? null : true;
        }

        public T removeHeader(String str) {
            Validate.m28455a(str, "Header name must not be empty");
            str = scanHeaders(str);
            if (str != null) {
                this.headers.remove(str.getKey());
            }
            return this;
        }

        public Map<String, String> headers() {
            return this.headers;
        }

        private String getHeaderCaseInsensitive(String str) {
            Validate.m28453a((Object) str, "Header name must not be null");
            String str2 = (String) this.headers.get(str);
            if (str2 == null) {
                str2 = (String) this.headers.get(str.toLowerCase());
            }
            if (str2 != null) {
                return str2;
            }
            str = scanHeaders(str);
            return str != null ? (String) str.getValue() : str2;
        }

        private Entry<String, String> scanHeaders(String str) {
            str = str.toLowerCase();
            for (Entry<String, String> entry : this.headers.entrySet()) {
                if (((String) entry.getKey()).toLowerCase().equals(str)) {
                    return entry;
                }
            }
            return null;
        }

        public String cookie(String str) {
            Validate.m28455a(str, "Cookie name must not be empty");
            return (String) this.cookies.get(str);
        }

        public T cookie(String str, String str2) {
            Validate.m28455a(str, "Cookie name must not be empty");
            Validate.m28453a((Object) str2, "Cookie value must not be null");
            this.cookies.put(str, str2);
            return this;
        }

        public boolean hasCookie(String str) {
            Validate.m28455a(str, "Cookie name must not be empty");
            return this.cookies.containsKey(str);
        }

        public T removeCookie(String str) {
            Validate.m28455a(str, "Cookie name must not be empty");
            this.cookies.remove(str);
            return this;
        }

        public Map<String, String> cookies() {
            return this.cookies;
        }
    }

    public static class Request extends Base<org.jsoup.Connection.Request> implements org.jsoup.Connection.Request {
        private String body;
        private Collection<KeyVal> data;
        private boolean followRedirects;
        private boolean ignoreContentType;
        private boolean ignoreHttpErrors;
        private int maxBodySizeBytes;
        private Parser parser;
        private boolean parserDefined;
        private String postDataCharset;
        private Proxy proxy;
        private int timeoutMilliseconds;
        private boolean validateTSLCertificates;

        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        public /* bridge */ /* synthetic */ Method method() {
            return super.method();
        }

        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        private Request() {
            super();
            this.body = null;
            this.ignoreHttpErrors = false;
            this.ignoreContentType = false;
            this.parserDefined = false;
            this.validateTSLCertificates = true;
            this.postDataCharset = "UTF-8";
            this.timeoutMilliseconds = 30000;
            this.maxBodySizeBytes = 1048576;
            this.followRedirects = true;
            this.data = new ArrayList();
            this.method = Method.GET;
            this.headers.put(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
            this.headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
            this.parser = Parser.m28564a();
        }

        public Proxy proxy() {
            return this.proxy;
        }

        public Request proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Request proxy(String str, int i) {
            this.proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(str, i));
            return this;
        }

        public int timeout() {
            return this.timeoutMilliseconds;
        }

        public Request timeout(int i) {
            Validate.m28457a(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.timeoutMilliseconds = i;
            return this;
        }

        public int maxBodySize() {
            return this.maxBodySizeBytes;
        }

        public org.jsoup.Connection.Request maxBodySize(int i) {
            Validate.m28457a(i >= 0, "maxSize must be 0 (unlimited) or larger");
            this.maxBodySizeBytes = i;
            return this;
        }

        public boolean followRedirects() {
            return this.followRedirects;
        }

        public org.jsoup.Connection.Request followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public boolean ignoreHttpErrors() {
            return this.ignoreHttpErrors;
        }

        public boolean validateTLSCertificates() {
            return this.validateTSLCertificates;
        }

        public void validateTLSCertificates(boolean z) {
            this.validateTSLCertificates = z;
        }

        public org.jsoup.Connection.Request ignoreHttpErrors(boolean z) {
            this.ignoreHttpErrors = z;
            return this;
        }

        public boolean ignoreContentType() {
            return this.ignoreContentType;
        }

        public org.jsoup.Connection.Request ignoreContentType(boolean z) {
            this.ignoreContentType = z;
            return this;
        }

        public Request data(KeyVal keyVal) {
            Validate.m28453a((Object) keyVal, "Key val must not be null");
            this.data.add(keyVal);
            return this;
        }

        public Collection<KeyVal> data() {
            return this.data;
        }

        public org.jsoup.Connection.Request requestBody(String str) {
            this.body = str;
            return this;
        }

        public String requestBody() {
            return this.body;
        }

        public Request parser(Parser parser) {
            this.parser = parser;
            this.parserDefined = true;
            return this;
        }

        public Parser parser() {
            return this.parser;
        }

        public org.jsoup.Connection.Request postDataCharset(String str) {
            Validate.m28453a((Object) str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.postDataCharset = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        public String postDataCharset() {
            return this.postDataCharset;
        }
    }

    public static class Response extends Base<org.jsoup.Connection.Response> implements org.jsoup.Connection.Response {
        private static SSLSocketFactory f36218a;
        private static final Pattern f36219j = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        private int f36220b;
        private String f36221c;
        private ByteBuffer f36222d;
        private String f36223e;
        private String f36224f;
        private boolean f36225g = false;
        private int f36226h = 0;
        private org.jsoup.Connection.Request f36227i;

        static class C22201 implements HostnameVerifier {
            public final boolean verify(String str, SSLSession sSLSession) {
                return true;
            }

            C22201() {
            }
        }

        static class C22212 implements X509TrustManager {
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            C22212() {
            }
        }

        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        public /* bridge */ /* synthetic */ Method method() {
            return super.method();
        }

        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        Response() {
            super();
        }

        private Response(Response response) throws IOException {
            super();
            if (response != null) {
                this.f36226h = response.f36226h + 1;
                if (this.f36226h >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[]{response.url()}));
                }
            }
        }

        static Response m36591a(org.jsoup.Connection.Request request) throws IOException {
            return m36592a(request, null);
        }

        private static Response m36592a(org.jsoup.Connection.Request request, Response response) throws IOException {
            Validate.m28453a((Object) request, "Request must not be null");
            String protocol = request.url().getProtocol();
            if (protocol.equals("http") || protocol.equals("https")) {
                StringBuilder stringBuilder;
                HttpURLConnection b;
                int responseCode;
                Response response2;
                boolean z = request.method().f26955i;
                boolean z2 = request.requestBody() != null;
                if (!z) {
                    stringBuilder = new StringBuilder("Cannot set a request body for HTTP method ");
                    stringBuilder.append(request.method());
                    Validate.m28461b(z2, stringBuilder.toString());
                }
                InputStream inputStream = null;
                if (request.data().size() > 0 && (!z || z2)) {
                    m36598c(request);
                } else if (z && !request.hasHeader("Content-Type")) {
                    if (HttpConnection.m33894a(request)) {
                        protocol = DataUtil.m28440b();
                        stringBuilder = new StringBuilder("multipart/form-data; boundary=");
                        stringBuilder.append(protocol);
                        request.header("Content-Type", stringBuilder.toString());
                        b = m36596b(request);
                        b.connect();
                        if (b.getDoOutput()) {
                            m36595a(request, b.getOutputStream(), protocol);
                        }
                        responseCode = b.getResponseCode();
                        response2 = new Response(response);
                        response2.m36593a(b, (org.jsoup.Connection.Response) response);
                        response2.f36227i = request;
                        if (response2.hasHeader(HttpRequest.HEADER_LOCATION) != null || request.followRedirects() == null) {
                            if (responseCode < HttpStatus.HTTP_OK || responseCode >= 400) {
                                if (request.ignoreHttpErrors() == null) {
                                    throw new HttpStatusException("HTTP error fetching URL", responseCode, request.url().toString());
                                }
                            }
                            response = response2.f36224f;
                            if (response != null || request.ignoreContentType() || response.startsWith("text/") || f36219j.matcher(response).matches()) {
                                if (!(response == null || f36219j.matcher(response).matches() == null || (request instanceof Request) == null || ((Request) request).parserDefined != null)) {
                                    request.parser(Parser.m28565b());
                                }
                                response2.f36223e = DataUtil.m28435a(response2.f36224f);
                                if (b.getContentLength() != null || request.method() == Method.HEAD) {
                                    response2.f36222d = DataUtil.m28436a();
                                } else {
                                    inputStream = b.getErrorStream() != null ? b.getErrorStream() : b.getInputStream();
                                    if (response2.hasHeaderWithValue(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP) != null) {
                                        inputStream = new GZIPInputStream(inputStream);
                                    }
                                    response2.f36222d = DataUtil.m28437a(inputStream, request.maxBodySize());
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                }
                                b.disconnect();
                                response2.f36225g = true;
                                return response2;
                            }
                            throw new UnsupportedMimeTypeException("Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml", response, request.url().toString());
                        }
                        if (responseCode != StatusLine.HTTP_TEMP_REDIRECT) {
                            request.method(Method.GET);
                            request.data().clear();
                        }
                        String header = response2.header(HttpRequest.HEADER_LOCATION);
                        if (!(header == null || !header.startsWith("http:/") || header.charAt(6) == '/')) {
                            header = header.substring(6);
                        }
                        request.url(HttpConnection.m33895b(StringUtil.m28445a(request.url(), header)));
                        for (Entry entry : response2.cookies.entrySet()) {
                            request.cookie((String) entry.getKey(), (String) entry.getValue());
                        }
                        request = m36592a(request, response2);
                        b.disconnect();
                        return request;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("application/x-www-form-urlencoded; charset=");
                    stringBuilder2.append(request.postDataCharset());
                    request.header("Content-Type", stringBuilder2.toString());
                }
                protocol = inputStream;
                b = m36596b(request);
                try {
                    b.connect();
                    if (b.getDoOutput()) {
                        m36595a(request, b.getOutputStream(), protocol);
                    }
                    responseCode = b.getResponseCode();
                    response2 = new Response(response);
                    response2.m36593a(b, (org.jsoup.Connection.Response) response);
                    response2.f36227i = request;
                    if (response2.hasHeader(HttpRequest.HEADER_LOCATION) != null) {
                    }
                    if (request.ignoreHttpErrors() == null) {
                        throw new HttpStatusException("HTTP error fetching URL", responseCode, request.url().toString());
                    }
                    response = response2.f36224f;
                    if (response != null) {
                    }
                    request.parser(Parser.m28565b());
                    response2.f36223e = DataUtil.m28435a(response2.f36224f);
                    if (b.getContentLength() != null) {
                    }
                    response2.f36222d = DataUtil.m28436a();
                    b.disconnect();
                    response2.f36225g = true;
                    return response2;
                } catch (Throwable th) {
                    b.disconnect();
                }
            } else {
                throw new MalformedURLException("Only http & https protocols supported");
            }
        }

        public final Document mo6854a() throws IOException {
            Validate.m28457a(this.f36225g, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            Document a = DataUtil.m28438a(this.f36222d, this.f36223e, this.url.toExternalForm(), this.f36227i.parser());
            this.f36222d.rewind();
            this.f36223e = a.f36228a.f26971b.name();
            return a;
        }

        private static HttpURLConnection m36596b(org.jsoup.Connection.Request request) throws IOException {
            URLConnection openConnection;
            if (request.proxy() == null) {
                openConnection = request.url().openConnection();
            } else {
                openConnection = request.url().openConnection(request.proxy());
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod(request.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.timeout());
            httpURLConnection.setReadTimeout(request.timeout());
            if ((httpURLConnection instanceof HttpsURLConnection) && !request.validateTLSCertificates()) {
                m36597b();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setSSLSocketFactory(f36218a);
                httpsURLConnection.setHostnameVerifier(new C22201());
            }
            boolean z = true;
            if (request.method().f26955i) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.cookies().size() > 0) {
                String str = "Cookie";
                StringBuilder stringBuilder = new StringBuilder();
                for (Entry entry : request.cookies().entrySet()) {
                    if (z) {
                        z = false;
                    } else {
                        stringBuilder.append("; ");
                    }
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append('=');
                    stringBuilder.append((String) entry.getValue());
                }
                httpURLConnection.addRequestProperty(str, stringBuilder.toString());
            }
            for (Entry entry2 : request.headers().entrySet()) {
                httpURLConnection.addRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
            }
            return httpURLConnection;
        }

        private static synchronized void m36597b() throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = org.jsoup.helper.HttpConnection.Response.class;
            monitor-enter(r0);
            r1 = f36218a;	 Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x0039;	 Catch:{ all -> 0x003b }
        L_0x0007:
            r1 = 1;	 Catch:{ all -> 0x003b }
            r1 = new javax.net.ssl.TrustManager[r1];	 Catch:{ all -> 0x003b }
            r2 = 0;	 Catch:{ all -> 0x003b }
            r3 = new org.jsoup.helper.HttpConnection$Response$2;	 Catch:{ all -> 0x003b }
            r3.<init>();	 Catch:{ all -> 0x003b }
            r1[r2] = r3;	 Catch:{ all -> 0x003b }
            r2 = "SSL";	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            r2 = javax.net.ssl.SSLContext.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            r3 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            r4 = new java.security.SecureRandom;	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            r4.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            r2.init(r3, r1, r4);	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            r1 = r2.getSocketFactory();	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            f36218a = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0031, KeyManagementException -> 0x0029 }
            monitor-exit(r0);
            return;
        L_0x0029:
            r1 = new java.io.IOException;	 Catch:{ all -> 0x003b }
            r2 = "Can't create unsecure trust manager";	 Catch:{ all -> 0x003b }
            r1.<init>(r2);	 Catch:{ all -> 0x003b }
            throw r1;	 Catch:{ all -> 0x003b }
        L_0x0031:
            r1 = new java.io.IOException;	 Catch:{ all -> 0x003b }
            r2 = "Can't create unsecure trust manager";	 Catch:{ all -> 0x003b }
            r1.<init>(r2);	 Catch:{ all -> 0x003b }
            throw r1;	 Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r0);
            return;
        L_0x003b:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.b():void");
        }

        private void m36593a(HttpURLConnection httpURLConnection, org.jsoup.Connection.Response response) throws IOException {
            this.method = Method.valueOf(httpURLConnection.getRequestMethod());
            this.url = httpURLConnection.getURL();
            this.f36220b = httpURLConnection.getResponseCode();
            this.f36221c = httpURLConnection.getResponseMessage();
            this.f36224f = httpURLConnection.getContentType();
            Map linkedHashMap = new LinkedHashMap();
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null) {
                    if (headerField == null) {
                        break;
                    }
                }
                i++;
                if (!(headerFieldKey == null || headerField == null)) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        ((List) linkedHashMap.get(headerFieldKey)).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
            m36594a(linkedHashMap);
            if (response != null) {
                for (Entry entry : response.cookies().entrySet()) {
                    if (!hasCookie((String) entry.getKey())) {
                        cookie((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
        }

        private void m36594a(Map<String, List<String>> map) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                String str = (String) entry.getKey();
                if (str != null) {
                    List<String> list = (List) entry.getValue();
                    if (str.equalsIgnoreCase("Set-Cookie")) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                TokenQueue tokenQueue = new TokenQueue(str2);
                                str2 = tokenQueue.m28592e(Operation.EQUALS).trim();
                                String trim = tokenQueue.m28589d(";").trim();
                                if (str2.length() > 0) {
                                    cookie(str2, trim);
                                }
                            }
                        }
                    } else {
                        int i = 0;
                        if (list.size() == 1) {
                            header(str2, (String) list.get(0));
                        } else if (list.size() > 1) {
                            StringBuilder stringBuilder = new StringBuilder();
                            while (i < list.size()) {
                                String str3 = (String) list.get(i);
                                if (i != 0) {
                                    stringBuilder.append(", ");
                                }
                                stringBuilder.append(str3);
                                i++;
                            }
                            header(str2, stringBuilder.toString());
                        }
                    }
                }
            }
        }

        private static void m36595a(org.jsoup.Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<KeyVal> data = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.postDataCharset()));
            if (str != null) {
                for (KeyVal keyVal : data) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.m33897c(keyVal.m28427a()));
                    bufferedWriter.write("\"");
                    if (keyVal.m28430d()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.m33897c(keyVal.m28428b()));
                        bufferedWriter.write("\"\r\nContent-Type: application/octet-stream\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.m28439a(keyVal.m28429c(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.m28428b());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (request.requestBody() != null) {
                bufferedWriter.write(request.requestBody());
            } else {
                outputStream = true;
                for (KeyVal keyVal2 : data) {
                    if (outputStream == null) {
                        bufferedWriter.append('&');
                    } else {
                        outputStream = null;
                    }
                    bufferedWriter.write(URLEncoder.encode(keyVal2.m28427a(), request.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(keyVal2.m28428b(), request.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        private static void m36598c(org.jsoup.Connection.Request request) throws IOException {
            Object obj;
            URL url = request.url();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(url.getProtocol());
            stringBuilder.append("://");
            stringBuilder.append(url.getAuthority());
            stringBuilder.append(url.getPath());
            stringBuilder.append(Operation.EMPTY_PARAM);
            if (url.getQuery() != null) {
                stringBuilder.append(url.getQuery());
                obj = null;
            } else {
                obj = 1;
            }
            for (KeyVal keyVal : request.data()) {
                Validate.m28461b(keyVal.m28430d(), "InputStream data not supported in URL query string.");
                if (obj == null) {
                    stringBuilder.append('&');
                } else {
                    obj = null;
                }
                stringBuilder.append(URLEncoder.encode(keyVal.m28427a(), "UTF-8"));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode(keyVal.m28428b(), "UTF-8"));
            }
            request.url(new URL(stringBuilder.toString()));
            request.data().clear();
        }
    }

    public static Connection m33896b(String str) {
        Connection httpConnection = new HttpConnection();
        httpConnection.mo6325a(str);
        return httpConnection;
    }

    private static java.lang.String m33898d(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x000e }
        r0.<init>(r1);	 Catch:{ Exception -> 0x000e }
        r0 = m33895b(r0);	 Catch:{ Exception -> 0x000e }
        r0 = r0.toExternalForm();	 Catch:{ Exception -> 0x000e }
        return r0;
    L_0x000e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.d(java.lang.String):java.lang.String");
    }

    private static java.net.URL m33895b(java.net.URL r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = new java.net.URI;	 Catch:{ Exception -> 0x002c }
        r1 = r9.getProtocol();	 Catch:{ Exception -> 0x002c }
        r2 = r9.getUserInfo();	 Catch:{ Exception -> 0x002c }
        r3 = r9.getHost();	 Catch:{ Exception -> 0x002c }
        r4 = r9.getPort();	 Catch:{ Exception -> 0x002c }
        r5 = r9.getPath();	 Catch:{ Exception -> 0x002c }
        r6 = r9.getQuery();	 Catch:{ Exception -> 0x002c }
        r7 = r9.getRef();	 Catch:{ Exception -> 0x002c }
        r0 = r8;	 Catch:{ Exception -> 0x002c }
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x002c }
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x002c }
        r1 = r8.toASCIIString();	 Catch:{ Exception -> 0x002c }
        r0.<init>(r1);	 Catch:{ Exception -> 0x002c }
        return r0;
    L_0x002c:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.b(java.net.URL):java.net.URL");
    }

    private HttpConnection() {
    }

    public final Connection mo6325a(String str) {
        Validate.m28455a(str, "Must supply a valid URL");
        try {
            this.f33329a.url(new URL(m33898d(str)));
            return this;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Malformed URL: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        }
    }

    public final Document mo6326a() throws IOException {
        this.f33329a.method(Method.GET);
        this.f33330b = Response.m36591a(this.f33329a);
        return this.f33330b.mo6854a();
    }

    static /* synthetic */ boolean m33894a(org.jsoup.Connection.Request request) {
        for (KeyVal d : request.data()) {
            if (d.m28430d()) {
                return true;
            }
        }
        return null;
    }

    static /* synthetic */ String m33897c(String str) {
        return str == null ? null : str.replaceAll("\"", "%22");
    }
}
