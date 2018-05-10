package com.sendbird.android.shadow.okio;

import com.sendbird.android.shadow.okio.AsyncTimeout.C24871;
import com.sendbird.android.shadow.okio.AsyncTimeout.C24882;
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
    static final Logger f23606a = Logger.getLogger(Okio.class.getName());

    class C24891 implements Sink {
        final /* synthetic */ Timeout f30581a;
        final /* synthetic */ OutputStream f30582b;

        C24891(Timeout timeout, OutputStream outputStream) {
            this.f30581a = timeout;
            this.f30582b = outputStream;
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            Util.m25643a(buffer.f34625b, 0, j);
            while (j > 0) {
                this.f30581a.mo5391f();
                Segment segment = buffer.f34624a;
                int min = (int) Math.min(j, (long) (segment.f23609c - segment.f23608b));
                this.f30582b.write(segment.f23607a, segment.f23608b, min);
                segment.f23608b += min;
                long j2 = (long) min;
                j -= j2;
                buffer.f34625b -= j2;
                if (segment.f23608b == segment.f23609c) {
                    buffer.f34624a = segment.m25628a();
                    SegmentPool.m25632a(segment);
                }
            }
        }

        public final void flush() throws IOException {
            this.f30582b.flush();
        }

        public final void close() throws IOException {
            this.f30582b.close();
        }

        public final Timeout mo5334a() {
            return this.f30581a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("sink(");
            stringBuilder.append(this.f30582b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    class C24902 implements Source {
        final /* synthetic */ Timeout f30583a;
        final /* synthetic */ InputStream f30584b;

        C24902(Timeout timeout, InputStream inputStream) {
            this.f30583a = timeout;
            this.f30584b = inputStream;
        }

        public final long mo5322a(Buffer buffer, long j) throws IOException {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i == 0) {
                return 0;
            } else {
                try {
                    this.f30583a.mo5391f();
                    Segment e = buffer.m35479e(1);
                    j = this.f30584b.read(e.f23607a, e.f23609c, (int) Math.min(j, (long) (8192 - e.f23609c)));
                    if (j == -1) {
                        return -1;
                    }
                    e.f23609c += j;
                    j = (long) j;
                    buffer.f34625b += j;
                    return j;
                } catch (AssertionError e2) {
                    if (Okio.m25623a(e2) != null) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public final void close() throws IOException {
            this.f30584b.close();
        }

        public final Timeout mo5323a() {
            return this.f30583a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("source(");
            stringBuilder.append(this.f30584b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    class C24913 implements Sink {
        public final void close() throws IOException {
        }

        public final void flush() throws IOException {
        }

        C24913() {
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            buffer.mo6568g(j);
        }

        public final Timeout mo5334a() {
            return Timeout.f23616c;
        }
    }

    class C27164 extends AsyncTimeout {
        final /* synthetic */ Socket f34626a;

        C27164(Socket socket) {
            this.f34626a = socket;
        }

        protected final IOException mo6545a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        protected final void mo6546a() {
            Logger logger;
            Level level;
            StringBuilder stringBuilder;
            try {
                this.f34626a.close();
            } catch (Throwable e) {
                logger = Okio.f23606a;
                level = Level.WARNING;
                stringBuilder = new StringBuilder("Failed to close timed out socket ");
                stringBuilder.append(this.f34626a);
                logger.log(level, stringBuilder.toString(), e);
            } catch (AssertionError e2) {
                if (Okio.m25623a(e2)) {
                    logger = Okio.f23606a;
                    level = Level.WARNING;
                    stringBuilder = new StringBuilder("Failed to close timed out socket ");
                    stringBuilder.append(this.f34626a);
                    logger.log(level, stringBuilder.toString(), e2);
                    return;
                }
                throw e2;
            }
        }
    }

    private Okio() {
    }

    public static BufferedSource m25615a(Source source) {
        return new RealBufferedSource(source);
    }

    public static BufferedSink m25614a(Sink sink) {
        return new RealBufferedSink(sink);
    }

    private static Sink m25617a(OutputStream outputStream) {
        return m25618a(outputStream, new Timeout());
    }

    private static Sink m25618a(OutputStream outputStream, Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new C24891(timeout, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink m25619a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        Timeout c = m25626c(socket);
        return new C24871(c, m25618a(socket.getOutputStream(), c));
    }

    public static Source m25621a(InputStream inputStream) {
        return m25622a(inputStream, new Timeout());
    }

    private static Source m25622a(InputStream inputStream, Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new C24902(timeout, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source m25620a(File file) throws FileNotFoundException {
        if (file != null) {
            return m25621a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink m25624b(File file) throws FileNotFoundException {
        if (file != null) {
            return m25617a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink m25627c(File file) throws FileNotFoundException {
        if (file != null) {
            return m25617a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink m25616a() {
        return new C24913();
    }

    public static Source m25625b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        Timeout c = m25626c(socket);
        return new C24882(c, m25622a(socket.getInputStream(), c));
    }

    private static AsyncTimeout m25626c(Socket socket) {
        return new C27164(socket);
    }

    static boolean m25623a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }
}
