package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
    private static final long f30563a = TimeUnit.SECONDS.toMillis(60);
    static AsyncTimeout f30564b;
    private static final long f30565d = TimeUnit.MILLISECONDS.toNanos(f30563a);
    private boolean f30566e;
    private AsyncTimeout f30567f;
    private long f30568g;

    private static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public final void run() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
        L_0x0000:
            r0 = com.sendbird.android.shadow.okio.AsyncTimeout.class;	 Catch:{ InterruptedException -> 0x0000 }
            monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0000 }
            r1 = com.sendbird.android.shadow.okio.AsyncTimeout.m31494e();	 Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
        L_0x0009:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            goto L_0x0000;	 Catch:{ all -> 0x0019 }
        L_0x000b:
            r2 = com.sendbird.android.shadow.okio.AsyncTimeout.f30564b;	 Catch:{ all -> 0x0019 }
            if (r1 != r2) goto L_0x0014;	 Catch:{ all -> 0x0019 }
        L_0x000f:
            r1 = 0;	 Catch:{ all -> 0x0019 }
            com.sendbird.android.shadow.okio.AsyncTimeout.f30564b = r1;	 Catch:{ all -> 0x0019 }
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            return;	 Catch:{ all -> 0x0019 }
        L_0x0014:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            r1.mo6546a();	 Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000;
        L_0x0019:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            throw r1;	 Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    class C24871 implements Sink {
        final /* synthetic */ Sink f30559a;
        final /* synthetic */ AsyncTimeout f30560b;

        C24871(AsyncTimeout asyncTimeout, Sink sink) {
            this.f30560b = asyncTimeout;
            this.f30559a = sink;
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            Util.m25643a(buffer.f34625b, 0, j);
            while (true) {
                long j2 = 0;
                if (j > 0) {
                    Segment segment = buffer.f34624a;
                    while (j2 < 65536) {
                        j2 += (long) (buffer.f34624a.f23609c - buffer.f34624a.f23608b);
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                    }
                    this.f30560b.at_();
                    try {
                        this.f30559a.a_(buffer, j2);
                        j -= j2;
                        this.f30560b.m31497a(true);
                    } catch (Buffer buffer2) {
                        throw this.f30560b.m31498b(buffer2);
                    } catch (Throwable th) {
                        this.f30560b.m31497a(false);
                    }
                } else {
                    return;
                }
            }
        }

        public void flush() throws IOException {
            this.f30560b.at_();
            try {
                this.f30559a.flush();
                this.f30560b.m31497a(true);
            } catch (IOException e) {
                throw this.f30560b.m31498b(e);
            } catch (Throwable th) {
                this.f30560b.m31497a(false);
            }
        }

        public void close() throws IOException {
            this.f30560b.at_();
            try {
                this.f30559a.close();
                this.f30560b.m31497a(true);
            } catch (IOException e) {
                throw this.f30560b.m31498b(e);
            } catch (Throwable th) {
                this.f30560b.m31497a(false);
            }
        }

        public final Timeout mo5334a() {
            return this.f30560b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("AsyncTimeout.sink(");
            stringBuilder.append(this.f30559a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    class C24882 implements Source {
        final /* synthetic */ Source f30561a;
        final /* synthetic */ AsyncTimeout f30562b;

        C24882(AsyncTimeout asyncTimeout, Source source) {
            this.f30562b = asyncTimeout;
            this.f30561a = source;
        }

        public final long mo5322a(Buffer buffer, long j) throws IOException {
            this.f30562b.at_();
            try {
                buffer = this.f30561a.mo5322a(buffer, j);
                this.f30562b.m31497a(true);
                return buffer;
            } catch (Buffer buffer2) {
                throw this.f30562b.m31498b(buffer2);
            } catch (Throwable th) {
                this.f30562b.m31497a(false);
            }
        }

        public void close() throws IOException {
            try {
                this.f30561a.close();
                this.f30562b.m31497a(true);
            } catch (IOException e) {
                throw this.f30562b.m31498b(e);
            } catch (Throwable th) {
                this.f30562b.m31497a(false);
            }
        }

        public final Timeout mo5323a() {
            return this.f30562b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("AsyncTimeout.source(");
            stringBuilder.append(this.f30561a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    protected void mo6546a() {
    }

    public final void at_() {
        if (this.f30566e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long av_ = av_();
        boolean aw_ = aw_();
        if (av_ != 0 || aw_) {
            this.f30566e = true;
            m31492a(this, av_, aw_);
        }
    }

    private static synchronized void m31492a(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (f30564b == null) {
                f30564b = new AsyncTimeout();
                new Watchdog().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.f30568g = Math.min(j, asyncTimeout.mo5389c() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.f30568g = j + nanoTime;
            } else if (z) {
                asyncTimeout.f30568g = asyncTimeout.mo5389c();
            } else {
                throw new AssertionError();
            }
            j = asyncTimeout.f30568g - nanoTime;
            z = f30564b;
            while (z.f30567f != null) {
                if (j < z.f30567f.f30568g - nanoTime) {
                    break;
                }
                z = z.f30567f;
            }
            asyncTimeout.f30567f = z.f30567f;
            z.f30567f = asyncTimeout;
            if (z == f30564b) {
                AsyncTimeout.class.notify();
                return;
            }
        }
    }

    public final boolean au_() {
        if (!this.f30566e) {
            return false;
        }
        this.f30566e = false;
        return m31493a(this);
    }

    private static synchronized boolean m31493a(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout asyncTimeout2 = f30564b; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.f30567f) {
                if (asyncTimeout2.f30567f == asyncTimeout) {
                    asyncTimeout2.f30567f = asyncTimeout.f30567f;
                    asyncTimeout.f30567f = null;
                    return null;
                }
            }
            return true;
        }
    }

    final void m31497a(boolean z) throws IOException {
        if (au_() && z) {
            throw mo6545a((IOException) false);
        }
    }

    final IOException m31498b(IOException iOException) throws IOException {
        if (au_()) {
            return mo6545a(iOException);
        }
        return iOException;
    }

    protected IOException mo6545a(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    static AsyncTimeout m31494e() throws InterruptedException {
        AsyncTimeout asyncTimeout = f30564b.f30567f;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(f30563a);
            if (f30564b.f30567f != null || System.nanoTime() - nanoTime < f30565d) {
                return null;
            }
            return f30564b;
        }
        long nanoTime2 = asyncTimeout.f30568g - System.nanoTime();
        if (nanoTime2 > 0) {
            long j = nanoTime2 / 1000000;
            AsyncTimeout.class.wait(j, (int) (nanoTime2 - (1000000 * j)));
            return null;
        }
        f30564b.f30567f = asyncTimeout.f30567f;
        asyncTimeout.f30567f = null;
        return asyncTimeout;
    }
}
