package okhttp3.logging;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new C26281();

        class C26281 implements Logger {
            C26281() {
            }

            public final void log(String str) {
                Platform.get().log(4, str, null);
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.level = Level.NONE;
        this.logger = logger;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public final Level getLevel() {
        return this.level;
    }

    public final Response intercept(Chain chain) throws IOException {
        Chain chain2 = chain;
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain2.proceed(request);
        }
        Object obj;
        RequestBody body;
        Connection connection;
        StringBuilder stringBuilder;
        String stringBuilder2;
        Logger logger;
        StringBuilder stringBuilder3;
        Headers headers;
        int size;
        int i;
        String name;
        Logger logger2;
        Charset charset;
        MediaType contentType;
        StringBuilder stringBuilder4;
        long nanoTime;
        Response proceed;
        ResponseBody body2;
        long contentLength;
        String stringBuilder5;
        String stringBuilder6;
        String stringBuilder7;
        Headers headers2;
        int size2;
        int i2;
        Buffer a;
        Charset charset2;
        MediaType contentType2;
        Logger logger3;
        StringBuilder stringBuilder8;
        Object obj2 = 1;
        Object obj3 = level == Level.BODY ? 1 : null;
        if (obj3 == null) {
            if (level != Level.HEADERS) {
                obj = null;
                body = request.body();
                if (body != null) {
                    obj2 = null;
                }
                connection = chain.connection();
                stringBuilder = new StringBuilder("--> ");
                stringBuilder.append(request.method());
                stringBuilder.append(' ');
                stringBuilder.append(request.url());
                if (connection == null) {
                    StringBuilder stringBuilder9 = new StringBuilder(" ");
                    stringBuilder9.append(connection.protocol());
                    stringBuilder2 = stringBuilder9.toString();
                } else {
                    stringBuilder2 = "";
                }
                stringBuilder.append(stringBuilder2);
                stringBuilder2 = stringBuilder.toString();
                if (obj == null && obj2 != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append(" (");
                    stringBuilder.append(body.contentLength());
                    stringBuilder.append("-byte body)");
                    stringBuilder2 = stringBuilder.toString();
                }
                r1.logger.log(stringBuilder2);
                if (obj != null) {
                    if (obj2 != null) {
                        if (body.contentType() != null) {
                            logger = r1.logger;
                            stringBuilder3 = new StringBuilder("Content-Type: ");
                            stringBuilder3.append(body.contentType());
                            logger.log(stringBuilder3.toString());
                        }
                        if (body.contentLength() != -1) {
                            logger = r1.logger;
                            stringBuilder3 = new StringBuilder("Content-Length: ");
                            stringBuilder3.append(body.contentLength());
                            logger.log(stringBuilder3.toString());
                        }
                    }
                    headers = request.headers();
                    size = headers.size();
                    for (i = 0; i < size; i++) {
                        name = headers.name(i);
                        if (!("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name))) {
                            logger2 = r1.logger;
                            StringBuilder stringBuilder10 = new StringBuilder();
                            stringBuilder10.append(name);
                            stringBuilder10.append(": ");
                            stringBuilder10.append(headers.value(i));
                            logger2.log(stringBuilder10.toString());
                        }
                    }
                    if (obj3 != null) {
                        if (obj2 == null) {
                            if (bodyEncoded(request.headers())) {
                                Buffer buffer;
                                buffer = new Buffer();
                                body.writeTo(buffer);
                                charset = UTF8;
                                contentType = body.contentType();
                                if (contentType != null) {
                                    charset = contentType.charset(UTF8);
                                }
                                r1.logger.log("");
                                if (isPlaintext(buffer)) {
                                    logger2 = r1.logger;
                                    stringBuilder4 = new StringBuilder("--> END ");
                                    stringBuilder4.append(request.method());
                                    stringBuilder4.append(" (binary ");
                                    stringBuilder4.append(body.contentLength());
                                    stringBuilder4.append("-byte body omitted)");
                                    logger2.log(stringBuilder4.toString());
                                } else {
                                    r1.logger.log(buffer.mo6753a(charset));
                                    logger2 = r1.logger;
                                    stringBuilder4 = new StringBuilder("--> END ");
                                    stringBuilder4.append(request.method());
                                    stringBuilder4.append(" (");
                                    stringBuilder4.append(body.contentLength());
                                    stringBuilder4.append("-byte body)");
                                    logger2.log(stringBuilder4.toString());
                                }
                            } else {
                                logger2 = r1.logger;
                                stringBuilder4 = new StringBuilder("--> END ");
                                stringBuilder4.append(request.method());
                                stringBuilder4.append(" (encoded body omitted)");
                                logger2.log(stringBuilder4.toString());
                            }
                        }
                    }
                    logger2 = r1.logger;
                    stringBuilder4 = new StringBuilder("--> END ");
                    stringBuilder4.append(request.method());
                    logger2.log(stringBuilder4.toString());
                }
                nanoTime = System.nanoTime();
                proceed = chain2.proceed(request);
                nanoTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
                body2 = proceed.body();
                contentLength = body2.contentLength();
                if (contentLength == -1) {
                    StringBuilder stringBuilder11 = new StringBuilder();
                    stringBuilder11.append(contentLength);
                    stringBuilder11.append("-byte");
                    stringBuilder5 = stringBuilder11.toString();
                } else {
                    stringBuilder5 = "unknown-length";
                }
                Logger logger4 = r1.logger;
                stringBuilder = new StringBuilder("<-- ");
                stringBuilder.append(proceed.code());
                if (proceed.message().isEmpty()) {
                    stringBuilder3 = new StringBuilder(" ");
                    stringBuilder3.append(proceed.message());
                    stringBuilder6 = stringBuilder3.toString();
                } else {
                    stringBuilder6 = "";
                }
                stringBuilder.append(stringBuilder6);
                stringBuilder.append(' ');
                stringBuilder.append(proceed.request().url());
                stringBuilder.append(" (");
                stringBuilder.append(nanoTime);
                stringBuilder.append("ms");
                if (obj != null) {
                    StringBuilder stringBuilder12 = new StringBuilder(", ");
                    stringBuilder12.append(stringBuilder5);
                    stringBuilder12.append(" body");
                    stringBuilder7 = stringBuilder12.toString();
                } else {
                    stringBuilder7 = "";
                }
                stringBuilder.append(stringBuilder7);
                stringBuilder.append(')');
                logger4.log(stringBuilder.toString());
                if (obj != null) {
                    headers2 = proceed.headers();
                    size2 = headers2.size();
                    for (i2 = 0; i2 < size2; i2++) {
                        Logger logger5 = r1.logger;
                        StringBuilder stringBuilder13 = new StringBuilder();
                        stringBuilder13.append(headers2.name(i2));
                        stringBuilder13.append(": ");
                        stringBuilder13.append(headers2.value(i2));
                        logger5.log(stringBuilder13.toString());
                    }
                    if (obj3 != null) {
                        if (!HttpHeaders.hasBody(proceed)) {
                            if (bodyEncoded(proceed.headers())) {
                                BufferedSource source = body2.source();
                                source.mo6762b(Long.MAX_VALUE);
                                a = source.mo6754a();
                                charset2 = UTF8;
                                contentType2 = body2.contentType();
                                if (contentType2 != null) {
                                    charset2 = contentType2.charset(UTF8);
                                }
                                if (isPlaintext(a)) {
                                    r1.logger.log("");
                                    logger3 = r1.logger;
                                    stringBuilder8 = new StringBuilder("<-- END HTTP (binary ");
                                    stringBuilder8.append(a.f36201b);
                                    stringBuilder8.append("-byte body omitted)");
                                    logger3.log(stringBuilder8.toString());
                                    return proceed;
                                }
                                if (contentLength != 0) {
                                    r1.logger.log("");
                                    r1.logger.log(a.m36541v().mo6753a(charset2));
                                }
                                logger3 = r1.logger;
                                stringBuilder8 = new StringBuilder("<-- END HTTP (");
                                stringBuilder8.append(a.f36201b);
                                stringBuilder8.append("-byte body)");
                                logger3.log(stringBuilder8.toString());
                            } else {
                                r1.logger.log("<-- END HTTP (encoded body omitted)");
                            }
                        }
                    }
                    r1.logger.log("<-- END HTTP");
                }
                return proceed;
            }
        }
        obj = 1;
        body = request.body();
        if (body != null) {
            obj2 = null;
        }
        connection = chain.connection();
        stringBuilder = new StringBuilder("--> ");
        stringBuilder.append(request.method());
        stringBuilder.append(' ');
        stringBuilder.append(request.url());
        if (connection == null) {
            stringBuilder2 = "";
        } else {
            StringBuilder stringBuilder92 = new StringBuilder(" ");
            stringBuilder92.append(connection.protocol());
            stringBuilder2 = stringBuilder92.toString();
        }
        stringBuilder.append(stringBuilder2);
        stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(" (");
        stringBuilder.append(body.contentLength());
        stringBuilder.append("-byte body)");
        stringBuilder2 = stringBuilder.toString();
        r1.logger.log(stringBuilder2);
        if (obj != null) {
            if (obj2 != null) {
                if (body.contentType() != null) {
                    logger = r1.logger;
                    stringBuilder3 = new StringBuilder("Content-Type: ");
                    stringBuilder3.append(body.contentType());
                    logger.log(stringBuilder3.toString());
                }
                if (body.contentLength() != -1) {
                    logger = r1.logger;
                    stringBuilder3 = new StringBuilder("Content-Length: ");
                    stringBuilder3.append(body.contentLength());
                    logger.log(stringBuilder3.toString());
                }
            }
            headers = request.headers();
            size = headers.size();
            for (i = 0; i < size; i++) {
                name = headers.name(i);
                logger2 = r1.logger;
                StringBuilder stringBuilder102 = new StringBuilder();
                stringBuilder102.append(name);
                stringBuilder102.append(": ");
                stringBuilder102.append(headers.value(i));
                logger2.log(stringBuilder102.toString());
            }
            if (obj3 != null) {
                if (obj2 == null) {
                    if (bodyEncoded(request.headers())) {
                        buffer = new Buffer();
                        body.writeTo(buffer);
                        charset = UTF8;
                        contentType = body.contentType();
                        if (contentType != null) {
                            charset = contentType.charset(UTF8);
                        }
                        r1.logger.log("");
                        if (isPlaintext(buffer)) {
                            logger2 = r1.logger;
                            stringBuilder4 = new StringBuilder("--> END ");
                            stringBuilder4.append(request.method());
                            stringBuilder4.append(" (binary ");
                            stringBuilder4.append(body.contentLength());
                            stringBuilder4.append("-byte body omitted)");
                            logger2.log(stringBuilder4.toString());
                        } else {
                            r1.logger.log(buffer.mo6753a(charset));
                            logger2 = r1.logger;
                            stringBuilder4 = new StringBuilder("--> END ");
                            stringBuilder4.append(request.method());
                            stringBuilder4.append(" (");
                            stringBuilder4.append(body.contentLength());
                            stringBuilder4.append("-byte body)");
                            logger2.log(stringBuilder4.toString());
                        }
                    } else {
                        logger2 = r1.logger;
                        stringBuilder4 = new StringBuilder("--> END ");
                        stringBuilder4.append(request.method());
                        stringBuilder4.append(" (encoded body omitted)");
                        logger2.log(stringBuilder4.toString());
                    }
                }
            }
            logger2 = r1.logger;
            stringBuilder4 = new StringBuilder("--> END ");
            stringBuilder4.append(request.method());
            logger2.log(stringBuilder4.toString());
        }
        nanoTime = System.nanoTime();
        try {
            proceed = chain2.proceed(request);
            nanoTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            body2 = proceed.body();
            contentLength = body2.contentLength();
            if (contentLength == -1) {
                stringBuilder5 = "unknown-length";
            } else {
                StringBuilder stringBuilder112 = new StringBuilder();
                stringBuilder112.append(contentLength);
                stringBuilder112.append("-byte");
                stringBuilder5 = stringBuilder112.toString();
            }
            Logger logger42 = r1.logger;
            stringBuilder = new StringBuilder("<-- ");
            stringBuilder.append(proceed.code());
            if (proceed.message().isEmpty()) {
                stringBuilder3 = new StringBuilder(" ");
                stringBuilder3.append(proceed.message());
                stringBuilder6 = stringBuilder3.toString();
            } else {
                stringBuilder6 = "";
            }
            stringBuilder.append(stringBuilder6);
            stringBuilder.append(' ');
            stringBuilder.append(proceed.request().url());
            stringBuilder.append(" (");
            stringBuilder.append(nanoTime);
            stringBuilder.append("ms");
            if (obj != null) {
                stringBuilder7 = "";
            } else {
                StringBuilder stringBuilder122 = new StringBuilder(", ");
                stringBuilder122.append(stringBuilder5);
                stringBuilder122.append(" body");
                stringBuilder7 = stringBuilder122.toString();
            }
            stringBuilder.append(stringBuilder7);
            stringBuilder.append(')');
            logger42.log(stringBuilder.toString());
            if (obj != null) {
                headers2 = proceed.headers();
                size2 = headers2.size();
                for (i2 = 0; i2 < size2; i2++) {
                    Logger logger52 = r1.logger;
                    StringBuilder stringBuilder132 = new StringBuilder();
                    stringBuilder132.append(headers2.name(i2));
                    stringBuilder132.append(": ");
                    stringBuilder132.append(headers2.value(i2));
                    logger52.log(stringBuilder132.toString());
                }
                if (obj3 != null) {
                    if (!HttpHeaders.hasBody(proceed)) {
                        if (bodyEncoded(proceed.headers())) {
                            BufferedSource source2 = body2.source();
                            source2.mo6762b(Long.MAX_VALUE);
                            a = source2.mo6754a();
                            charset2 = UTF8;
                            contentType2 = body2.contentType();
                            if (contentType2 != null) {
                                charset2 = contentType2.charset(UTF8);
                            }
                            if (isPlaintext(a)) {
                                if (contentLength != 0) {
                                    r1.logger.log("");
                                    r1.logger.log(a.m36541v().mo6753a(charset2));
                                }
                                logger3 = r1.logger;
                                stringBuilder8 = new StringBuilder("<-- END HTTP (");
                                stringBuilder8.append(a.f36201b);
                                stringBuilder8.append("-byte body)");
                                logger3.log(stringBuilder8.toString());
                            } else {
                                r1.logger.log("");
                                logger3 = r1.logger;
                                stringBuilder8 = new StringBuilder("<-- END HTTP (binary ");
                                stringBuilder8.append(a.f36201b);
                                stringBuilder8.append("-byte body omitted)");
                                logger3.log(stringBuilder8.toString());
                                return proceed;
                            }
                        }
                        r1.logger.log("<-- END HTTP (encoded body omitted)");
                    }
                }
                r1.logger.log("<-- END HTTP");
            }
            return proceed;
        } catch (Exception e) {
            Logger logger6 = r1.logger;
            StringBuilder stringBuilder14 = new StringBuilder("<-- HTTP FAILED: ");
            stringBuilder14.append(e);
            logger6.log(stringBuilder14.toString());
            throw e;
        }
    }

    static boolean isPlaintext(okio.Buffer r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r7 = new okio.Buffer;	 Catch:{ EOFException -> 0x003b }
        r7.<init>();	 Catch:{ EOFException -> 0x003b }
        r1 = r8.f36201b;	 Catch:{ EOFException -> 0x003b }
        r3 = 64;	 Catch:{ EOFException -> 0x003b }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ EOFException -> 0x003b }
        if (r1 >= 0) goto L_0x0012;	 Catch:{ EOFException -> 0x003b }
    L_0x000e:
        r1 = r8.f36201b;	 Catch:{ EOFException -> 0x003b }
        r5 = r1;	 Catch:{ EOFException -> 0x003b }
        goto L_0x0013;	 Catch:{ EOFException -> 0x003b }
    L_0x0012:
        r5 = r3;	 Catch:{ EOFException -> 0x003b }
    L_0x0013:
        r3 = 0;	 Catch:{ EOFException -> 0x003b }
        r1 = r8;	 Catch:{ EOFException -> 0x003b }
        r2 = r7;	 Catch:{ EOFException -> 0x003b }
        r1.m36485a(r2, r3, r5);	 Catch:{ EOFException -> 0x003b }
        r8 = r0;	 Catch:{ EOFException -> 0x003b }
    L_0x001b:
        r1 = 16;	 Catch:{ EOFException -> 0x003b }
        if (r8 >= r1) goto L_0x0039;	 Catch:{ EOFException -> 0x003b }
    L_0x001f:
        r1 = r7.mo6769d();	 Catch:{ EOFException -> 0x003b }
        if (r1 != 0) goto L_0x0039;	 Catch:{ EOFException -> 0x003b }
    L_0x0025:
        r1 = r7.m36537r();	 Catch:{ EOFException -> 0x003b }
        r2 = java.lang.Character.isISOControl(r1);	 Catch:{ EOFException -> 0x003b }
        if (r2 == 0) goto L_0x0036;	 Catch:{ EOFException -> 0x003b }
    L_0x002f:
        r1 = java.lang.Character.isWhitespace(r1);	 Catch:{ EOFException -> 0x003b }
        if (r1 != 0) goto L_0x0036;
    L_0x0035:
        return r0;
    L_0x0036:
        r8 = r8 + 1;
        goto L_0x001b;
    L_0x0039:
        r8 = 1;
        return r8;
    L_0x003b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.isPlaintext(okio.Buffer):boolean");
    }

    private boolean bodyEncoded(Headers headers) {
        headers = headers.get(HttpRequest.HEADER_CONTENT_ENCODING);
        return (headers == null || headers.equalsIgnoreCase("identity") != null) ? null : true;
    }
}
