package fi.iki.elonen;

import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.ads.AdRequest;
import com.instabug.library.model.NetworkLog;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.http.StatusLine;

public abstract class NanoHTTPD {
    private static final Pattern f24425a = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
    private static final Pattern f24426d = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
    private static final Pattern f24427e = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
    private static final Logger f24428f = Logger.getLogger(NanoHTTPD.class.getName());
    protected volatile ServerSocket f24429b;
    protected AsyncRunner f24430c;
    private final String f24431g;
    private final int f24432h;
    private ServerSocketFactory f24433i = new DefaultServerSocketFactory();
    private Thread f24434j;
    private TempFileManagerFactory f24435k;

    public interface AsyncRunner {
        void mo5526a(ClientHandler clientHandler);

        void mo5527b(ClientHandler clientHandler);
    }

    public class ClientHandler implements Runnable {
        final /* synthetic */ NanoHTTPD f24376a;
        private final InputStream f24377b;
        private final Socket f24378c;

        public ClientHandler(NanoHTTPD nanoHTTPD, InputStream inputStream, Socket socket) {
            this.f24376a = nanoHTTPD;
            this.f24377b = inputStream;
            this.f24378c = socket;
        }

        public void run() {
            Object outputStream;
            Throwable e;
            Throwable th;
            try {
                outputStream = this.f24378c.getOutputStream();
                try {
                    HTTPSession hTTPSession = new HTTPSession(this.f24376a, this.f24376a.f24435k.mo5533a(), this.f24377b, outputStream, this.f24378c.getInetAddress());
                    while (!this.f24378c.isClosed()) {
                        hTTPSession.m31859a();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (!(((e instanceof SocketException) && "NanoHttpd Shutdown".equals(e.getMessage())) || (e instanceof SocketTimeoutException))) {
                            NanoHTTPD.f24428f.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e);
                        }
                        NanoHTTPD.m26053a(outputStream);
                        NanoHTTPD.m26053a(this.f24377b);
                        NanoHTTPD.m26053a(this.f24378c);
                        this.f24376a.f24430c.mo5526a(this);
                    } catch (Throwable th2) {
                        e = th2;
                        NanoHTTPD.m26053a(outputStream);
                        NanoHTTPD.m26053a(this.f24377b);
                        NanoHTTPD.m26053a(this.f24378c);
                        this.f24376a.f24430c.mo5526a(this);
                        throw e;
                    }
                }
            } catch (Throwable e3) {
                th = e3;
                outputStream = null;
                e = th;
                NanoHTTPD.f24428f.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e);
                NanoHTTPD.m26053a(outputStream);
                NanoHTTPD.m26053a(this.f24377b);
                NanoHTTPD.m26053a(this.f24378c);
                this.f24376a.f24430c.mo5526a(this);
            } catch (Throwable e32) {
                th = e32;
                outputStream = null;
                e = th;
                NanoHTTPD.m26053a(outputStream);
                NanoHTTPD.m26053a(this.f24377b);
                NanoHTTPD.m26053a(this.f24378c);
                this.f24376a.f24430c.mo5526a(this);
                throw e;
            }
            NanoHTTPD.m26053a(outputStream);
            NanoHTTPD.m26053a(this.f24377b);
            NanoHTTPD.m26053a(this.f24378c);
            this.f24376a.f24430c.mo5526a(this);
        }
    }

    protected static class ContentType {
        private static final Pattern f24379e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
        private static final Pattern f24380f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
        private static final Pattern f24381g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
        final String f24382a;
        final String f24383b;
        final String f24384c;
        final String f24385d;

        public ContentType(String str) {
            this.f24382a = str;
            if (str != null) {
                this.f24383b = m26024a(str, f24379e, "", 1);
                this.f24384c = m26024a(str, f24380f, null, 2);
            } else {
                this.f24383b = "";
                this.f24384c = "UTF-8";
            }
            if ("multipart/form-data".equalsIgnoreCase(this.f24383b)) {
                this.f24385d = m26024a(str, f24381g, null, 2);
            } else {
                this.f24385d = null;
            }
        }

        private static String m26024a(String str, Pattern pattern, String str2, int i) {
            str = pattern.matcher(str);
            return str.find() != null ? str.group(i) : str2;
        }

        public final String m26025a() {
            return this.f24384c == null ? "US-ASCII" : this.f24384c;
        }
    }

    public static class Cookie {
        final String f24386a;
        final String f24387b;
        final String f24388c;
    }

    public class CookieHandler implements Iterable<String> {
        final /* synthetic */ NanoHTTPD f24389a;
        private final HashMap<String, String> f24390b = new HashMap();
        private final ArrayList<Cookie> f24391c = new ArrayList();

        public CookieHandler(NanoHTTPD nanoHTTPD, Map<String, String> map) {
            this.f24389a = nanoHTTPD;
            String str = (String) map.get("cookie");
            if (str != null) {
                for (String trim : str.split(";")) {
                    String[] split = trim.trim().split(Operation.EQUALS);
                    if (split.length == 2) {
                        this.f24390b.put(split[0], split[1]);
                    }
                }
            }
        }

        public Iterator<String> iterator() {
            return this.f24390b.keySet().iterator();
        }

        public final void m26026a(Response response) {
            Iterator it = this.f24391c.iterator();
            while (it.hasNext()) {
                Cookie cookie = (Cookie) it.next();
                String format = String.format("%s=%s; expires=%s", new Object[]{cookie.f24386a, cookie.f24387b, cookie.f24388c});
                response.f24411b.put("Set-Cookie", format);
            }
        }
    }

    public interface IHTTPSession {
        void mo5534a(Map<String, String> map) throws IOException, ResponseException;

        Method mo5535b();

        @Deprecated
        Map<String, String> mo5536c();

        String mo5537d();

        String mo5538e();
    }

    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        static fi.iki.elonen.NanoHTTPD.Method m26032a(java.lang.String r1) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = 0;
            if (r1 != 0) goto L_0x0004;
        L_0x0003:
            return r0;
        L_0x0004:
            r1 = valueOf(r1);	 Catch:{ IllegalArgumentException -> 0x0009 }
            return r1;
        L_0x0009:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.Method.a(java.lang.String):fi.iki.elonen.NanoHTTPD$Method");
        }
    }

    public static class Response implements Closeable {
        String f24410a;
        final Map<String, String> f24411b = new C20991(this);
        Method f24412c;
        boolean f24413d;
        boolean f24414e;
        private IStatus f24415f;
        private InputStream f24416g;
        private long f24417h;
        private final Map<String, String> f24418i = new HashMap();
        private boolean f24419j;

        class C20991 extends HashMap<String, String> {
            final /* synthetic */ Response f24409a;

            C20991(Response response) {
                this.f24409a = response;
            }

            public /* synthetic */ Object put(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                this.f24409a.f24418i.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        }

        private static class ChunkedOutputStream extends FilterOutputStream {
            public ChunkedOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (i2 != 0) {
                    this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i2)}).getBytes());
                    this.out.write(bArr, i, i2);
                    this.out.write("\r\n".getBytes());
                }
            }

            public final void m26033a() throws IOException {
                this.out.write("0\r\n\r\n".getBytes());
            }
        }

        public interface IStatus {
            String mo5539a();
        }

        public enum Status implements IStatus {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(HttpStatus.HTTP_OK, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            MULTI_STATUS(207, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(HttpStatus.HTTP_NOT_FOUND, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            GONE(410, "Gone"),
            LENGTH_REQUIRED(411, "Length Required"),
            PRECONDITION_FAILED(412, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(417, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(HttpStatus.HTTP_NOT_IMPLEMENTED, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            private final int f30891G;
            private final String f30892H;

            private Status(int i, String str) {
                this.f30891G = i;
                this.f30892H = str;
            }

            public final String mo5539a() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f30891G);
                stringBuilder.append(" ");
                stringBuilder.append(this.f30892H);
                return stringBuilder.toString();
            }
        }

        protected Response(IStatus iStatus, String str, InputStream inputStream, long j) {
            this.f24415f = iStatus;
            this.f24410a = str;
            boolean z = false;
            if (inputStream == null) {
                this.f24416g = new ByteArrayInputStream(new byte[0]);
                this.f24417h = 0;
            } else {
                this.f24416g = inputStream;
                this.f24417h = j;
            }
            if (this.f24417h < null) {
                z = true;
            }
            this.f24419j = z;
            this.f24414e = true;
        }

        public void close() throws IOException {
            if (this.f24416g != null) {
                this.f24416g.close();
            }
        }

        public final String m26040a(String str) {
            return (String) this.f24418i.get(str.toLowerCase());
        }

        protected final void m26041a(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.f24415f == null) {
                    throw new Error("sendResponse(): Status can't be null.");
                }
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, new ContentType(this.f24410a).m26025a())), false);
                printWriter.append("HTTP/1.1 ").append(this.f24415f.mo5539a()).append(" \r\n");
                if (this.f24410a != null) {
                    m26038a(printWriter, "Content-Type", this.f24410a);
                }
                if (m26040a("date") == null) {
                    m26038a(printWriter, HttpRequest.HEADER_DATE, simpleDateFormat.format(new Date()));
                }
                for (Entry entry : this.f24411b.entrySet()) {
                    m26038a(printWriter, (String) entry.getKey(), (String) entry.getValue());
                }
                if (m26040a("connection") == null) {
                    m26038a(printWriter, "Connection", this.f24414e ? "keep-alive" : "close");
                }
                if (m26040a("content-length") != null) {
                    this.f24413d = false;
                }
                if (this.f24413d) {
                    m26038a(printWriter, HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
                    this.f24419j = true;
                }
                long j = this.f24416g != null ? this.f24417h : 0;
                if (this.f24412c != Method.HEAD && this.f24419j) {
                    m26038a(printWriter, "Transfer-Encoding", "chunked");
                } else if (!this.f24413d) {
                    j = m26035a(printWriter, j);
                }
                printWriter.append("\r\n");
                printWriter.flush();
                if (this.f24412c == Method.HEAD || !this.f24419j) {
                    m26037a(outputStream, j);
                } else {
                    OutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
                    m26037a(chunkedOutputStream, -1);
                    chunkedOutputStream.m26033a();
                }
                outputStream.flush();
                NanoHTTPD.m26053a(this.f24416g);
            } catch (OutputStream outputStream2) {
                NanoHTTPD.f24428f.log(Level.SEVERE, "Could not send response to the client", outputStream2);
            }
        }

        private static void m26038a(PrintWriter printWriter, String str, String str2) {
            printWriter.append(str).append(": ").append(str2).append("\r\n");
        }

        private long m26035a(java.io.PrintWriter r5, long r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = "content-length";
            r0 = r4.m26040a(r0);
            if (r0 == 0) goto L_0x0023;
        L_0x0008:
            r1 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x000e }
            r6 = r1;
            goto L_0x0023;
        L_0x000e:
            r1 = fi.iki.elonen.NanoHTTPD.f24428f;
            r2 = new java.lang.StringBuilder;
            r3 = "content-length was no number ";
            r2.<init>(r3);
            r2.append(r0);
            r0 = r2.toString();
            r1.severe(r0);
        L_0x0023:
            r0 = new java.lang.StringBuilder;
            r1 = "Content-Length: ";
            r0.<init>(r1);
            r0.append(r6);
            r1 = "\r\n";
            r0.append(r1);
            r0 = r0.toString();
            r5.print(r0);
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.Response.a(java.io.PrintWriter, long):long");
        }

        private void m26037a(OutputStream outputStream, long j) throws IOException {
            if (this.f24413d) {
                j = new GZIPOutputStream(outputStream);
                m26039b(j, -1);
                j.finish();
                return;
            }
            m26039b(outputStream, j);
        }

        private void m26039b(OutputStream outputStream, long j) throws IOException {
            byte[] bArr = new byte[16384];
            int i = j == -1 ? 1 : 0;
            while (true) {
                if (j > 0 || i != 0) {
                    long j2 = 16384;
                    if (i == 0) {
                        j2 = Math.min(j, 16384);
                    }
                    int read = this.f24416g.read(bArr, 0, (int) j2);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (i == 0) {
                            j -= (long) read;
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
        }
    }

    public static final class ResponseException extends Exception {
        final Status f24420a;

        public ResponseException(Status status, String str) {
            super(str);
            this.f24420a = status;
        }

        public ResponseException(Status status, String str, Exception exception) {
            super(str, exception);
            this.f24420a = status;
        }
    }

    public class ServerRunnable implements Runnable {
        final /* synthetic */ NanoHTTPD f24421a;
        private final int f24422b = 5000;
        private IOException f24423c;
        private boolean f24424d = null;

        public ServerRunnable(NanoHTTPD nanoHTTPD) {
            this.f24421a = nanoHTTPD;
        }

        public void run() {
            try {
                this.f24421a.f24429b.bind(this.f24421a.f24431g != null ? new InetSocketAddress(this.f24421a.f24431g, this.f24421a.f24432h) : new InetSocketAddress(this.f24421a.f24432h));
                this.f24424d = true;
                do {
                    try {
                        Socket accept = this.f24421a.f24429b.accept();
                        if (this.f24422b > 0) {
                            accept.setSoTimeout(this.f24422b);
                        }
                        this.f24421a.f24430c.mo5527b(new ClientHandler(this.f24421a, accept.getInputStream(), accept));
                    } catch (Throwable e) {
                        NanoHTTPD.f24428f.log(Level.FINE, "Communication with the client broken", e);
                    }
                } while (!this.f24421a.f24429b.isClosed());
            } catch (IOException e2) {
                this.f24423c = e2;
            }
        }
    }

    public interface ServerSocketFactory {
        ServerSocket mo5528a() throws IOException;
    }

    public interface TempFile {
        void mo5529a() throws Exception;

        String mo5530b();
    }

    public interface TempFileManager {
        void mo5531a();

        TempFile mo5532b() throws Exception;
    }

    public interface TempFileManagerFactory {
        TempFileManager mo5533a();
    }

    public static class DefaultAsyncRunner implements AsyncRunner {
        private long f30836a;
        private final List<ClientHandler> f30837b = Collections.synchronizedList(new ArrayList());

        public final void mo5526a(ClientHandler clientHandler) {
            this.f30837b.remove(clientHandler);
        }

        public final void mo5527b(ClientHandler clientHandler) {
            this.f30836a++;
            Thread thread = new Thread(clientHandler);
            thread.setDaemon(true);
            StringBuilder stringBuilder = new StringBuilder("NanoHttpd Request Processor (#");
            stringBuilder.append(this.f30836a);
            stringBuilder.append(")");
            thread.setName(stringBuilder.toString());
            this.f30837b.add(clientHandler);
            thread.start();
        }
    }

    public static class DefaultServerSocketFactory implements ServerSocketFactory {
        public final ServerSocket mo5528a() throws IOException {
            return new ServerSocket();
        }
    }

    public static class DefaultTempFile implements TempFile {
        private final File f30838a;
        private final OutputStream f30839b = new FileOutputStream(this.f30838a);

        public DefaultTempFile(File file) throws IOException {
            this.f30838a = File.createTempFile("NanoHTTPD-", "", file);
        }

        public final void mo5529a() throws Exception {
            NanoHTTPD.m26053a(this.f30839b);
            if (!this.f30838a.delete()) {
                StringBuilder stringBuilder = new StringBuilder("could not delete temporary file: ");
                stringBuilder.append(this.f30838a.getAbsolutePath());
                throw new Exception(stringBuilder.toString());
            }
        }

        public final String mo5530b() {
            return this.f30838a.getAbsolutePath();
        }
    }

    public static class DefaultTempFileManager implements TempFileManager {
        private final File f30840a = new File(System.getProperty("java.io.tmpdir"));
        private final List<TempFile> f30841b;

        public DefaultTempFileManager() {
            if (!this.f30840a.exists()) {
                this.f30840a.mkdirs();
            }
            this.f30841b = new ArrayList();
        }

        public final void mo5531a() {
            for (TempFile a : this.f30841b) {
                try {
                    a.mo5529a();
                } catch (Throwable e) {
                    NanoHTTPD.f24428f.log(Level.WARNING, "could not delete file ", e);
                }
            }
            this.f30841b.clear();
        }

        public final TempFile mo5532b() throws Exception {
            TempFile defaultTempFile = new DefaultTempFile(this.f30840a);
            this.f30841b.add(defaultTempFile);
            return defaultTempFile;
        }
    }

    private class DefaultTempFileManagerFactory implements TempFileManagerFactory {
        final /* synthetic */ NanoHTTPD f30842a;

        private DefaultTempFileManagerFactory(NanoHTTPD nanoHTTPD) {
            this.f30842a = nanoHTTPD;
        }

        public final TempFileManager mo5533a() {
            return new DefaultTempFileManager();
        }
    }

    protected class HTTPSession implements IHTTPSession {
        final /* synthetic */ NanoHTTPD f30843a;
        private final TempFileManager f30844b;
        private final OutputStream f30845c;
        private final BufferedInputStream f30846d;
        private int f30847e;
        private int f30848f;
        private String f30849g;
        private Method f30850h;
        private Map<String, List<String>> f30851i;
        private Map<String, String> f30852j;
        private CookieHandler f30853k;
        private String f30854l;
        private String f30855m;
        private String f30856n;
        private String f30857o;

        public HTTPSession(NanoHTTPD nanoHTTPD, TempFileManager tempFileManager, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            this.f30843a = nanoHTTPD;
            this.f30844b = tempFileManager;
            this.f30846d = new BufferedInputStream(inputStream, 8192);
            this.f30845c = outputStream;
            if (inetAddress.isLoopbackAddress() == null) {
                if (inetAddress.isAnyLocalAddress() == null) {
                    nanoHTTPD = inetAddress.getHostAddress().toString();
                    this.f30855m = nanoHTTPD;
                    if (inetAddress.isLoopbackAddress() == null) {
                        if (inetAddress.isAnyLocalAddress() != null) {
                            nanoHTTPD = inetAddress.getHostName().toString();
                            this.f30856n = nanoHTTPD;
                            this.f30852j = new HashMap();
                        }
                    }
                    nanoHTTPD = "localhost";
                    this.f30856n = nanoHTTPD;
                    this.f30852j = new HashMap();
                }
            }
            nanoHTTPD = "127.0.0.1";
            this.f30855m = nanoHTTPD;
            if (inetAddress.isLoopbackAddress() == null) {
                if (inetAddress.isAnyLocalAddress() != null) {
                    nanoHTTPD = inetAddress.getHostName().toString();
                    this.f30856n = nanoHTTPD;
                    this.f30852j = new HashMap();
                }
            }
            nanoHTTPD = "localhost";
            this.f30856n = nanoHTTPD;
            this.f30852j = new HashMap();
        }

        private void m31855a(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) throws ResponseException {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    if (stringTokenizer.hasMoreTokens()) {
                        map.put("method", stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            readLine = stringTokenizer.nextToken();
                            int indexOf = readLine.indexOf(63);
                            if (indexOf >= 0) {
                                m31856a(readLine.substring(indexOf + 1), (Map) map2);
                                map2 = NanoHTTPD.m26056b(readLine.substring(0, indexOf));
                            } else {
                                map2 = NanoHTTPD.m26056b(readLine);
                            }
                            if (stringTokenizer.hasMoreTokens()) {
                                this.f30857o = stringTokenizer.nextToken();
                            } else {
                                this.f30857o = "HTTP/1.1";
                                NanoHTTPD.f24428f.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                            }
                            readLine = bufferedReader.readLine();
                            while (readLine != null && !readLine.trim().isEmpty()) {
                                int indexOf2 = readLine.indexOf(58);
                                if (indexOf2 >= 0) {
                                    map3.put(readLine.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine.substring(indexOf2 + 1).trim());
                                }
                                readLine = bufferedReader.readLine();
                            }
                            map.put("uri", map2);
                            return;
                        }
                        throw new ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    }
                    throw new ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
            } catch (BufferedReader bufferedReader2) {
                map2 = Status.INTERNAL_ERROR;
                map3 = new StringBuilder("SERVER INTERNAL ERROR: IOException: ");
                map3.append(bufferedReader2.getMessage());
                throw new ResponseException(map2, map3.toString(), bufferedReader2);
            }
        }

        private static int m31852a(byte[] bArr, int i) {
            while (bArr[i] != (byte) 10) {
                i++;
            }
            return i + 1;
        }

        private void m31856a(String str, Map<String, List<String>> map) {
            if (str == null) {
                this.f30854l = "";
                return;
            }
            this.f30854l = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens() != null) {
                Object trim;
                str = stringTokenizer.nextToken();
                int indexOf = str.indexOf(61);
                if (indexOf >= 0) {
                    trim = NanoHTTPD.m26056b(str.substring(0, indexOf)).trim();
                    str = NanoHTTPD.m26056b(str.substring(indexOf + 1));
                } else {
                    trim = NanoHTTPD.m26056b(str).trim();
                    str = "";
                }
                List list = (List) map.get(trim);
                if (list == null) {
                    list = new ArrayList();
                    map.put(trim, list);
                }
                list.add(str);
            }
        }

        public final void m31859a() throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r1 = 0;
            r2 = new byte[r0];	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r3 = 0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30847e = r3;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30848f = r3;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30846d;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4.mark(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30846d;	 Catch:{ SSLException -> 0x01a0, IOException -> 0x018e, SocketException -> 0x020d, SocketTimeoutException -> 0x020b, ResponseException -> 0x01a4 }
            r4 = r4.read(r2, r3, r0);	 Catch:{ SSLException -> 0x01a0, IOException -> 0x018e, SocketException -> 0x020d, SocketTimeoutException -> 0x020b, ResponseException -> 0x01a4 }
            r5 = -1;
            if (r4 != r5) goto L_0x002a;
        L_0x0018:
            r0 = r7.f30846d;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            fi.iki.elonen.NanoHTTPD.m26053a(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30845c;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            fi.iki.elonen.NanoHTTPD.m26053a(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = new java.net.SocketException;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = "NanoHttpd Shutdown";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.<init>(r2);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            throw r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x002a:
            if (r4 <= 0) goto L_0x004a;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x002c:
            r5 = r7.f30848f;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = r5 + r4;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30848f = r5;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30848f;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = m31857b(r2, r4);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30847e = r4;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30847e;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r4 > 0) goto L_0x004a;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x003d:
            r4 = r7.f30846d;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = r7.f30848f;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r6 = r7.f30848f;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r6 = 8192 - r6;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r4.read(r2, r5, r6);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            goto L_0x002a;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x004a:
            r0 = r7.f30847e;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30848f;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r0 >= r4) goto L_0x005d;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0050:
            r0 = r7.f30846d;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.reset();	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30846d;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30847e;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = (long) r4;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.skip(r4);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x005d:
            r0 = new java.util.HashMap;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.<init>();	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30851i = r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30852j;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r0 != 0) goto L_0x0070;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0068:
            r0 = new java.util.HashMap;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.<init>();	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30852j = r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            goto L_0x0075;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0070:
            r0 = r7.f30852j;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.clear();	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0075:
            r0 = new java.io.BufferedReader;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = new java.io.InputStreamReader;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = new java.io.ByteArrayInputStream;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r6 = r7.f30848f;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5.<init>(r2, r3, r6);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4.<init>(r5);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.<init>(r4);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = new java.util.HashMap;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2.<init>();	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30851i;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = r7.f30852j;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.m31855a(r0, r2, r4, r5);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30855m;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r0 == 0) goto L_0x00a8;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0096:
            r0 = r7.f30852j;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = "remote-addr";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = r7.f30855m;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.put(r4, r5);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30852j;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = "http-client-ip";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = r7.f30855m;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.put(r4, r5);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x00a8:
            r0 = "method";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r2.get(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = (java.lang.String) r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = fi.iki.elonen.NanoHTTPD.Method.m26032a(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30850h = r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30850h;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r0 != 0) goto L_0x00dd;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x00ba:
            r0 = new fi.iki.elonen.NanoHTTPD$ResponseException;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r3 = fi.iki.elonen.NanoHTTPD.Response.Status.BAD_REQUEST;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = "BAD REQUEST: Syntax error. HTTP verb ";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4.<init>(r5);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r5 = "method";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = r2.get(r5);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = (java.lang.String) r2;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4.append(r2);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = " unhandled.";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4.append(r2);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = r4.toString();	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.<init>(r3, r2);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            throw r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x00dd:
            r0 = "uri";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r2.get(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = (java.lang.String) r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30849g = r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = new fi.iki.elonen.NanoHTTPD$CookieHandler;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = r7.f30843a;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30852j;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.<init>(r2, r4);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r7.f30853k = r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30852j;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = "connection";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r0.get(r2);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = (java.lang.String) r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = "HTTP/1.1";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = r7.f30857o;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = r2.equals(r4);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r4 = 1;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r2 == 0) goto L_0x0114;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0108:
            if (r0 == 0) goto L_0x0112;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x010a:
            r2 = "(?i).*close.*";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r0.matches(r2);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r0 != 0) goto L_0x0114;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0112:
            r0 = r4;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            goto L_0x0115;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0114:
            r0 = r3;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x0115:
            r2 = r7.f30843a;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = r2.mo5053a(r7);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            if (r2 != 0) goto L_0x013f;
        L_0x011d:
            r0 = new fi.iki.elonen.NanoHTTPD$ResponseException;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r3 = "SERVER INTERNAL ERROR: Serve() returned a null response.";	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r0.<init>(r1, r3);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            throw r0;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x0127:
            r0 = move-exception;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r2;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            goto L_0x020f;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x012b:
            r0 = move-exception;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r2;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            goto L_0x01a5;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x012f:
            r0 = move-exception;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r2;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            goto L_0x01c0;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x0133:
            r0 = move-exception;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r2;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            goto L_0x01e6;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x0137:
            r0 = move-exception;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r2;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            goto L_0x020c;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x013b:
            r0 = move-exception;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r2;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            goto L_0x020e;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x013f:
            r1 = r7.f30852j;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r5 = "accept-encoding";	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r1.get(r5);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = (java.lang.String) r1;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r5 = r7.f30853k;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r5.m26026a(r2);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r5 = r7.f30850h;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r2.f24412c = r5;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r5 = fi.iki.elonen.NanoHTTPD.m26054a(r2);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            if (r5 == 0) goto L_0x0163;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x0158:
            if (r1 == 0) goto L_0x0163;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x015a:
            r5 = "gzip";	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r1.contains(r5);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            if (r1 == 0) goto L_0x0163;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x0162:
            r3 = r4;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x0163:
            r2.f24413d = r3;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r2.f24414e = r0;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r7.f30845c;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r2.m26041a(r1);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            if (r0 == 0) goto L_0x0186;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x016e:
            r0 = "close";	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = "connection";	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = r2.m26040a(r1);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r0 = r0.equals(r1);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            if (r0 == 0) goto L_0x017d;
        L_0x017c:
            goto L_0x0186;
        L_0x017d:
            fi.iki.elonen.NanoHTTPD.m26053a(r2);
        L_0x0180:
            r0 = r7.f30844b;
            r0.mo5531a();
            return;
        L_0x0186:
            r0 = new java.net.SocketException;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r1 = "NanoHttpd Shutdown";	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            r0.<init>(r1);	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
            throw r0;	 Catch:{ SocketException -> 0x013b, SocketTimeoutException -> 0x0137, SSLException -> 0x0133, IOException -> 0x012f, ResponseException -> 0x012b, all -> 0x0127 }
        L_0x018e:
            r0 = r7.f30846d;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            fi.iki.elonen.NanoHTTPD.m26053a(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = r7.f30845c;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            fi.iki.elonen.NanoHTTPD.m26053a(r0);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0 = new java.net.SocketException;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r2 = "NanoHttpd Shutdown";	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            r0.<init>(r2);	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            throw r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x01a0:
            r0 = move-exception;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
            throw r0;	 Catch:{ SocketException -> 0x020d, SocketTimeoutException -> 0x020b, SSLException -> 0x01e5, IOException -> 0x01bf, ResponseException -> 0x01a4 }
        L_0x01a2:
            r0 = move-exception;
            goto L_0x020f;
        L_0x01a4:
            r0 = move-exception;
        L_0x01a5:
            r2 = r0.f24420a;	 Catch:{ all -> 0x01a2 }
            r3 = "text/plain";	 Catch:{ all -> 0x01a2 }
            r0 = r0.getMessage();	 Catch:{ all -> 0x01a2 }
            r0 = fi.iki.elonen.NanoHTTPD.m26051a(r2, r3, r0);	 Catch:{ all -> 0x01a2 }
            r2 = r7.f30845c;	 Catch:{ all -> 0x01a2 }
            r0.m26041a(r2);	 Catch:{ all -> 0x01a2 }
            r0 = r7.f30845c;	 Catch:{ all -> 0x01a2 }
            fi.iki.elonen.NanoHTTPD.m26053a(r0);	 Catch:{ all -> 0x01a2 }
        L_0x01bb:
            fi.iki.elonen.NanoHTTPD.m26053a(r1);
            goto L_0x0180;
        L_0x01bf:
            r0 = move-exception;
        L_0x01c0:
            r2 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR;	 Catch:{ all -> 0x01a2 }
            r3 = "text/plain";	 Catch:{ all -> 0x01a2 }
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a2 }
            r5 = "SERVER INTERNAL ERROR: IOException: ";	 Catch:{ all -> 0x01a2 }
            r4.<init>(r5);	 Catch:{ all -> 0x01a2 }
            r0 = r0.getMessage();	 Catch:{ all -> 0x01a2 }
            r4.append(r0);	 Catch:{ all -> 0x01a2 }
            r0 = r4.toString();	 Catch:{ all -> 0x01a2 }
            r0 = fi.iki.elonen.NanoHTTPD.m26051a(r2, r3, r0);	 Catch:{ all -> 0x01a2 }
            r2 = r7.f30845c;	 Catch:{ all -> 0x01a2 }
            r0.m26041a(r2);	 Catch:{ all -> 0x01a2 }
            r0 = r7.f30845c;	 Catch:{ all -> 0x01a2 }
            fi.iki.elonen.NanoHTTPD.m26053a(r0);	 Catch:{ all -> 0x01a2 }
            goto L_0x01bb;	 Catch:{ all -> 0x01a2 }
        L_0x01e5:
            r0 = move-exception;	 Catch:{ all -> 0x01a2 }
        L_0x01e6:
            r2 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR;	 Catch:{ all -> 0x01a2 }
            r3 = "text/plain";	 Catch:{ all -> 0x01a2 }
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a2 }
            r5 = "SSL PROTOCOL FAILURE: ";	 Catch:{ all -> 0x01a2 }
            r4.<init>(r5);	 Catch:{ all -> 0x01a2 }
            r0 = r0.getMessage();	 Catch:{ all -> 0x01a2 }
            r4.append(r0);	 Catch:{ all -> 0x01a2 }
            r0 = r4.toString();	 Catch:{ all -> 0x01a2 }
            r0 = fi.iki.elonen.NanoHTTPD.m26051a(r2, r3, r0);	 Catch:{ all -> 0x01a2 }
            r2 = r7.f30845c;	 Catch:{ all -> 0x01a2 }
            r0.m26041a(r2);	 Catch:{ all -> 0x01a2 }
            r0 = r7.f30845c;	 Catch:{ all -> 0x01a2 }
            fi.iki.elonen.NanoHTTPD.m26053a(r0);	 Catch:{ all -> 0x01a2 }
            goto L_0x01bb;	 Catch:{ all -> 0x01a2 }
        L_0x020b:
            r0 = move-exception;	 Catch:{ all -> 0x01a2 }
        L_0x020c:
            throw r0;	 Catch:{ all -> 0x01a2 }
        L_0x020d:
            r0 = move-exception;	 Catch:{ all -> 0x01a2 }
        L_0x020e:
            throw r0;	 Catch:{ all -> 0x01a2 }
        L_0x020f:
            fi.iki.elonen.NanoHTTPD.m26053a(r1);
            r1 = r7.f30844b;
            r1.mo5531a();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.HTTPSession.a():void");
        }

        private static int m31857b(byte[] bArr, int i) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= i) {
                    return 0;
                }
                if (bArr[i2] == (byte) 13 && bArr[i3] == (byte) 10) {
                    int i4 = i2 + 3;
                    if (i4 < i && bArr[i2 + 2] == (byte) 13 && bArr[i4] == (byte) 10) {
                        return i2 + 4;
                    }
                }
                if (bArr[i2] == (byte) 10 && bArr[i3] == (byte) 10) {
                    return i2 + 2;
                }
                i2 = i3;
            }
        }

        public final Method mo5535b() {
            return this.f30850h;
        }

        @Deprecated
        public final Map<String, String> mo5536c() {
            Map<String, String> hashMap = new HashMap();
            for (String str : this.f30851i.keySet()) {
                hashMap.put(str, ((List) this.f30851i.get(str)).get(0));
            }
            return hashMap;
        }

        public final String mo5537d() {
            return this.f30854l;
        }

        private RandomAccessFile m31858f() {
            try {
                return new RandomAccessFile(this.f30844b.mo5532b().mo5530b(), "rw");
            } catch (Throwable e) {
                throw new Error(e);
            }
        }

        public final String mo5538e() {
            return this.f30849g;
        }

        private String m31853a(ByteBuffer byteBuffer, int i, int i2) {
            String str = "";
            if (i2 > 0) {
                Object obj = null;
                try {
                    TempFile b = this.f30844b.mo5532b();
                    byteBuffer = byteBuffer.duplicate();
                    Object fileOutputStream = new FileOutputStream(b.mo5530b());
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        byteBuffer.position(i).limit(i + i2);
                        channel.write(byteBuffer.slice());
                        str = b.mo5530b();
                        NanoHTTPD.m26053a(fileOutputStream);
                    } catch (Exception e) {
                        byteBuffer = e;
                        obj = fileOutputStream;
                        try {
                            throw new Error(byteBuffer);
                        } catch (Throwable th) {
                            byteBuffer = th;
                            NanoHTTPD.m26053a(obj);
                            throw byteBuffer;
                        }
                    } catch (Throwable th2) {
                        byteBuffer = th2;
                        obj = fileOutputStream;
                        NanoHTTPD.m26053a(obj);
                        throw byteBuffer;
                    }
                } catch (Exception e2) {
                    byteBuffer = e2;
                    throw new Error(byteBuffer);
                }
            }
            return str;
        }

        private void m31854a(ContentType contentType, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) throws ResponseException {
            ResponseException e;
            Exception e2;
            ContentType contentType2 = contentType;
            ByteBuffer byteBuffer2 = byteBuffer;
            Map<String, List<String>> map3 = map;
            Map<String, String> map4 = map2;
            HTTPSession hTTPSession;
            try {
                int[] iArr;
                int remaining;
                int i;
                int i2;
                int i3;
                byte[] bytes = contentType2.f24385d.getBytes();
                int i4 = 0;
                int[] iArr2 = new int[0];
                int i5 = 1;
                if (byteBuffer.remaining() < bytes.length) {
                    iArr = iArr2;
                } else {
                    Object obj = new byte[(4096 + bytes.length)];
                    remaining = byteBuffer.remaining() < obj.length ? byteBuffer.remaining() : obj.length;
                    byteBuffer2.get(obj, 0, remaining);
                    remaining -= bytes.length;
                    int[] iArr3 = iArr2;
                    i = 0;
                    while (true) {
                        iArr = iArr3;
                        i2 = 0;
                        while (i2 < remaining) {
                            Object obj2 = iArr;
                            int i6 = 0;
                            while (i6 < bytes.length && obj[i2 + i6] == bytes[i6]) {
                                if (i6 == bytes.length - i5) {
                                    Object obj3 = new int[(obj2.length + i5)];
                                    System.arraycopy(obj2, 0, obj3, 0, obj2.length);
                                    obj3[obj2.length] = i + i2;
                                    obj2 = obj3;
                                }
                                i6++;
                            }
                            i2++;
                            Object obj4 = obj2;
                        }
                        i += remaining;
                        System.arraycopy(obj, obj.length - bytes.length, obj, 0, bytes.length);
                        remaining = obj.length - bytes.length;
                        if (byteBuffer.remaining() < remaining) {
                            remaining = byteBuffer.remaining();
                        }
                        byteBuffer2.get(obj, bytes.length, remaining);
                        if (remaining <= 0) {
                            break;
                        }
                        i3 = i5;
                        hTTPSession = this;
                        contentType2 = contentType;
                        iArr3 = iArr;
                        i5 = i3;
                    }
                }
                i = 2;
                if (iArr.length < 2) {
                    throw new ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
                }
                int i7 = 1024;
                byte[] bArr = new byte[1024];
                remaining = 0;
                i2 = remaining;
                while (remaining < iArr.length - i5) {
                    byteBuffer2.position(iArr[remaining]);
                    int remaining2 = byteBuffer.remaining() < i7 ? byteBuffer.remaining() : i7;
                    byteBuffer2.get(bArr, i4, remaining2);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i4, remaining2), Charset.forName(contentType.m26025a())), remaining2);
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.contains(contentType2.f24385d)) {
                            String group;
                            int i8;
                            CharSequence readLine2 = bufferedReader.readLine();
                            String str = null;
                            String str2 = str;
                            int i9 = i2;
                            String str3 = str2;
                            i4 = i;
                            while (readLine2 != null && readLine2.trim().length() > 0) {
                                Matcher matcher = NanoHTTPD.f24425a.matcher(readLine2);
                                if (matcher.matches()) {
                                    Matcher matcher2 = NanoHTTPD.f24427e.matcher(matcher.group(i));
                                    i5 = i9;
                                    while (matcher2.find()) {
                                        group = matcher2.group(1);
                                        if ("name".equalsIgnoreCase(group)) {
                                            str3 = matcher2.group(2);
                                        } else if ("filename".equalsIgnoreCase(group)) {
                                            String group2 = matcher2.group(2);
                                            if (!group2.isEmpty()) {
                                                if (i5 > 0) {
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append(str3);
                                                    i2 = i5 + 1;
                                                    stringBuilder.append(String.valueOf(i5));
                                                    str2 = group2;
                                                    i5 = i2;
                                                    map4 = map2;
                                                    str3 = stringBuilder.toString();
                                                    contentType2 = contentType;
                                                } else {
                                                    i5++;
                                                }
                                            }
                                            str2 = group2;
                                        }
                                        contentType2 = contentType;
                                        map4 = map2;
                                    }
                                    i9 = i5;
                                }
                                Matcher matcher3 = NanoHTTPD.f24426d.matcher(readLine2);
                                if (matcher3.matches()) {
                                    i8 = 2;
                                    str = matcher3.group(2).trim();
                                } else {
                                    i8 = 2;
                                }
                                readLine2 = bufferedReader.readLine();
                                i4++;
                                i = i8;
                                contentType2 = contentType;
                                map4 = map2;
                            }
                            i8 = i;
                            int i10 = 0;
                            while (true) {
                                i7 = i4 - 1;
                                if (i4 <= 0) {
                                    break;
                                }
                                i10 = m31852a(bArr, i10);
                                i4 = i7;
                            }
                            if (i10 >= remaining2 - 4) {
                                throw new ResponseException(Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                            }
                            Map map5;
                            i7 = iArr[remaining] + i10;
                            remaining++;
                            i10 = iArr[remaining] - 4;
                            byteBuffer2.position(i7);
                            List list = (List) map3.get(str3);
                            if (list == null) {
                                list = new ArrayList();
                                map3.put(str3, list);
                            }
                            if (str == null) {
                                byte[] bArr2 = new byte[(i10 - i7)];
                                byteBuffer2.get(bArr2);
                                list.add(new String(bArr2, contentType.m26025a()));
                                hTTPSession = this;
                                map5 = map2;
                                i3 = 1;
                            } else {
                                try {
                                    group = m31853a(byteBuffer2, i7, i10 - i7);
                                    map5 = map2;
                                    i3 = 1;
                                    if (map5.containsKey(str3)) {
                                        StringBuilder stringBuilder2;
                                        i7 = i8;
                                        while (true) {
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append(str3);
                                            stringBuilder2.append(i7);
                                            if (!map5.containsKey(stringBuilder2.toString())) {
                                                break;
                                            }
                                            i7++;
                                        }
                                        stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append(str3);
                                        stringBuilder2.append(i7);
                                        map5.put(stringBuilder2.toString(), group);
                                    } else {
                                        map5.put(str3, group);
                                    }
                                    list.add(str2);
                                } catch (ResponseException e3) {
                                    e = e3;
                                } catch (Exception e4) {
                                    e2 = e4;
                                }
                            }
                            contentType2 = contentType;
                            i = i8;
                            Map map6 = map5;
                            i5 = i3;
                            i2 = i9;
                            i7 = 1024;
                            i4 = 0;
                        }
                    }
                    hTTPSession = this;
                    throw new ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                hTTPSession = this;
            } catch (ResponseException e5) {
                e = e5;
                hTTPSession = this;
                throw e;
            } catch (Exception e6) {
                e2 = e6;
                hTTPSession = this;
                throw new ResponseException(Status.INTERNAL_ERROR, e2.toString());
            }
        }

        public final void mo5534a(Map<String, String> map) throws IOException, ResponseException {
            Map map2 = map;
            Object obj = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream;
                DataOutput dataOutputStream;
                ByteBuffer wrap;
                long parseLong = this.f30852j.containsKey("content-length") ? Long.parseLong((String) r1.f30852j.get("content-length")) : r1.f30847e < r1.f30848f ? (long) (r1.f30848f - r1.f30847e) : 0;
                if (parseLong < 1024) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                } else {
                    dataOutputStream = m31858f();
                    byteArrayOutputStream = null;
                    obj = dataOutputStream;
                }
                byte[] bArr = new byte[AdRequest.MAX_CONTENT_URL_LENGTH];
                while (r1.f30848f >= 0 && parseLong > 0) {
                    r1.f30848f = r1.f30846d.read(bArr, 0, (int) Math.min(parseLong, 512));
                    parseLong -= (long) r1.f30848f;
                    if (r1.f30848f > 0) {
                        dataOutputStream.write(bArr, 0, r1.f30848f);
                    }
                }
                if (byteArrayOutputStream != null) {
                    wrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                } else {
                    wrap = obj.getChannel().map(MapMode.READ_ONLY, 0, obj.length());
                    obj.seek(0);
                }
                if (Method.POST.equals(r1.f30850h)) {
                    ContentType contentType = new ContentType((String) r1.f30852j.get(NetworkLog.CONTENT_TYPE));
                    if (!"multipart/form-data".equalsIgnoreCase(contentType.f24383b)) {
                        byte[] bArr2 = new byte[wrap.remaining()];
                        wrap.get(bArr2);
                        String trim = new String(bArr2, contentType.m26025a()).trim();
                        if (HttpRequest.CONTENT_TYPE_FORM.equalsIgnoreCase(contentType.f24383b)) {
                            m31856a(trim, r1.f30851i);
                        } else if (trim.length() != 0) {
                            map2.put("postData", trim);
                        }
                    } else if (contentType.f24385d == null) {
                        throw new ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    } else {
                        m31854a(contentType, wrap, r1.f30851i, map2);
                    }
                } else if (Method.PUT.equals(r1.f30850h)) {
                    map2.put("content", m31853a(wrap, 0, wrap.limit()));
                }
                NanoHTTPD.m26053a(obj);
            } catch (Throwable th) {
                Throwable th2 = th;
                NanoHTTPD.m26053a(null);
            }
        }
    }

    public NanoHTTPD(String str) {
        this.f24431g = str;
        this.f24432h = 0;
        this.f24435k = new DefaultTempFileManagerFactory();
        this.f24430c = new DefaultAsyncRunner();
    }

    protected static String m26056b(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (String str2) {
            f24428f.log(Level.WARNING, "Encoding not supported, ignored", str2);
            return null;
        }
    }

    private static Response m26050a(IStatus iStatus, String str, InputStream inputStream, long j) {
        return new Response(iStatus, str, inputStream, j);
    }

    public static Response m26051a(IStatus iStatus, String str, String str2) {
        ContentType contentType = new ContentType(str);
        if (str2 == null) {
            return m26050a(iStatus, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            if (Charset.forName(contentType.m26025a()).newEncoder().canEncode(str2) == null && contentType.f24384c == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(contentType.f24382a);
                stringBuilder.append("; charset=UTF-8");
                contentType = new ContentType(stringBuilder.toString());
            }
            str = str2.getBytes(contentType.m26025a());
        } catch (String str3) {
            f24428f.log(Level.SEVERE, "encoding problem, responding nothing", str3);
            str3 = new byte[0];
        }
        return m26050a(iStatus, contentType.f24382a, new ByteArrayInputStream(str3), (long) str3.length);
    }

    public Response mo5053a(IHTTPSession iHTTPSession) {
        Map hashMap = new HashMap();
        Method b = iHTTPSession.mo5535b();
        if (Method.PUT.equals(b) || Method.POST.equals(b)) {
            try {
                iHTTPSession.mo5534a(hashMap);
            } catch (IHTTPSession iHTTPSession2) {
                IStatus iStatus = Status.INTERNAL_ERROR;
                String str = NetworkLog.PLAIN_TEXT;
                StringBuilder stringBuilder = new StringBuilder("SERVER INTERNAL ERROR: IOException: ");
                stringBuilder.append(iHTTPSession2.getMessage());
                return m26051a(iStatus, str, stringBuilder.toString());
            } catch (IHTTPSession iHTTPSession22) {
                return m26051a(iHTTPSession22.f24420a, NetworkLog.PLAIN_TEXT, iHTTPSession22.getMessage());
            }
        }
        iHTTPSession22.mo5536c().put("NanoHttpd.QUERY_STRING", iHTTPSession22.mo5537d());
        return m26051a(Status.NOT_FOUND, NetworkLog.PLAIN_TEXT, "Not Found");
    }

    protected static boolean m26054a(Response response) {
        return (response.f24410a == null || (!response.f24410a.toLowerCase().contains("text/") && response.f24410a.toLowerCase().contains("/json") == null)) ? null : true;
    }

    public final void m26064a() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.f24433i;
        r0 = r0.mo5528a();
        r3.f24429b = r0;
        r0 = r3.f24429b;
        r1 = 1;
        r0.setReuseAddress(r1);
        r0 = new fi.iki.elonen.NanoHTTPD$ServerRunnable;
        r0.<init>(r3);
        r2 = new java.lang.Thread;
        r2.<init>(r0);
        r3.f24434j = r2;
        r2 = r3.f24434j;
        r2.setDaemon(r1);
        r1 = r3.f24434j;
        r2 = "NanoHttpd Main Listener";
        r1.setName(r2);
        r1 = r3.f24434j;
        r1.start();
    L_0x002b:
        r1 = r0.f24424d;
        if (r1 != 0) goto L_0x003d;
    L_0x0031:
        r1 = r0.f24423c;
        if (r1 != 0) goto L_0x003d;
    L_0x0037:
        r1 = 10;
        java.lang.Thread.sleep(r1);	 Catch:{ Throwable -> 0x002b }
        goto L_0x002b;
    L_0x003d:
        r1 = r0.f24423c;
        if (r1 == 0) goto L_0x0048;
    L_0x0043:
        r0 = r0.f24423c;
        throw r0;
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.a():void");
    }

    static /* synthetic */ void m26053a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (Object obj2) {
                f24428f.log(Level.SEVERE, "Could not close", obj2);
            }
        }
    }
}
