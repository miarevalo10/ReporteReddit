package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Okio {
    static final Logger f26668a = Logger.getLogger(Okio.class.getName());

    class C26311 implements Sink {
        final /* synthetic */ Timeout f33195a;
        final /* synthetic */ OutputStream f33196b;

        C26311(Timeout timeout, OutputStream outputStream) {
            this.f33195a = timeout;
            this.f33196b = outputStream;
        }

        public final void write(Buffer buffer, long j) throws IOException {
            Util.m28310a(buffer.f36201b, 0, j);
            while (j > 0) {
                this.f33195a.throwIfReached();
                Segment segment = buffer.f36200a;
                int min = (int) Math.min(j, (long) (segment.f26680c - segment.f26679b));
                this.f33196b.write(segment.f26678a, segment.f26679b, min);
                segment.f26679b += min;
                long j2 = (long) min;
                j -= j2;
                buffer.f36201b -= j2;
                if (segment.f26679b == segment.f26680c) {
                    buffer.f36200a = segment.m28303a();
                    SegmentPool.m28307a(segment);
                }
            }
        }

        public final void flush() throws IOException {
            this.f33196b.flush();
        }

        public final void close() throws IOException {
            this.f33196b.close();
        }

        public final Timeout timeout() {
            return this.f33195a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("sink(");
            stringBuilder.append(this.f33196b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    class C26322 implements Source {
        final /* synthetic */ Timeout f33197a;
        final /* synthetic */ InputStream f33198b;

        C26322(Timeout timeout, InputStream inputStream) {
            this.f33197a = timeout;
            this.f33198b = inputStream;
        }

        public final long read(Buffer buffer, long j) throws IOException {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i == 0) {
                return 0;
            } else {
                try {
                    this.f33197a.throwIfReached();
                    Segment e = buffer.m36511e(1);
                    j = this.f33198b.read(e.f26678a, e.f26680c, (int) Math.min(j, (long) (8192 - e.f26680c)));
                    if (j == -1) {
                        return -1;
                    }
                    e.f26680c += j;
                    j = (long) j;
                    buffer.f36201b += j;
                    return j;
                } catch (AssertionError e2) {
                    if (Okio.m28297a(e2) != null) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public final void close() throws IOException {
            this.f33198b.close();
        }

        public final Timeout timeout() {
            return this.f33197a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("source(");
            stringBuilder.append(this.f33198b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    class C26333 implements Sink {
        public final void close() throws IOException {
        }

        public final void flush() throws IOException {
        }

        C26333() {
        }

        public final void write(Buffer buffer, long j) throws IOException {
            buffer.mo6779i(j);
        }

        public final Timeout timeout() {
            return Timeout.NONE;
        }
    }

    class C28064 extends AsyncTimeout {
        final /* synthetic */ Socket f36202a;

        C28064(Socket socket) {
            this.f36202a = socket;
        }

        protected final IOException newTimeoutException(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        protected final void timedOut() {
            Logger logger;
            Level level;
            StringBuilder stringBuilder;
            try {
                this.f36202a.close();
            } catch (Throwable e) {
                logger = Okio.f26668a;
                level = Level.WARNING;
                stringBuilder = new StringBuilder("Failed to close timed out socket ");
                stringBuilder.append(this.f36202a);
                logger.log(level, stringBuilder.toString(), e);
            } catch (AssertionError e2) {
                if (Okio.m28297a(e2)) {
                    logger = Okio.f26668a;
                    level = Level.WARNING;
                    stringBuilder = new StringBuilder("Failed to close timed out socket ");
                    stringBuilder.append(this.f36202a);
                    logger.log(level, stringBuilder.toString(), e2);
                    return;
                }
                throw e2;
            }
        }
    }

    private Okio() {
    }

    public static BufferedSource m28289a(Source source) {
        return new RealBufferedSource(source);
    }

    public static BufferedSink m28288a(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static Sink m28291a(OutputStream outputStream) {
        return m28292a(outputStream, new Timeout());
    }

    private static Sink m28292a(OutputStream outputStream, Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new C26311(timeout, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink m28293a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        Timeout c = m28300c(socket);
        return c.sink(m28292a(socket.getOutputStream(), c));
    }

    public static Source m28295a(InputStream inputStream) {
        return m28296a(inputStream, new Timeout());
    }

    private static Source m28296a(InputStream inputStream, Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new C26322(timeout, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source m28294a(File file) throws FileNotFoundException {
        if (file != null) {
            return m28295a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink m28298b(File file) throws FileNotFoundException {
        if (file != null) {
            return m28291a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink m28301c(File file) throws FileNotFoundException {
        if (file != null) {
            return m28291a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink m28290a() {
        return new C26333();
    }

    public static Source m28299b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        Timeout c = m28300c(socket);
        return c.source(m28296a(socket.getInputStream(), c));
    }

    private static AsyncTimeout m28300c(Socket socket) {
        return new C28064(socket);
    }

    static boolean m28297a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }
}
