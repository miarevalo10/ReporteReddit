package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    private static final class Watchdog extends Thread {
        Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
        L_0x0000:
            r0 = okio.AsyncTimeout.class;	 Catch:{ InterruptedException -> 0x0000 }
            monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0000 }
            r1 = okio.AsyncTimeout.awaitTimeout();	 Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
        L_0x0009:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            goto L_0x0000;	 Catch:{ all -> 0x0019 }
        L_0x000b:
            r2 = okio.AsyncTimeout.head;	 Catch:{ all -> 0x0019 }
            if (r1 != r2) goto L_0x0014;	 Catch:{ all -> 0x0019 }
        L_0x000f:
            r1 = 0;	 Catch:{ all -> 0x0019 }
            okio.AsyncTimeout.head = r1;	 Catch:{ all -> 0x0019 }
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            return;	 Catch:{ all -> 0x0019 }
        L_0x0014:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            r1.timedOut();	 Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000;
        L_0x0019:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            throw r1;	 Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    protected void timedOut() {
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    private static synchronized void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
        synchronized (AsyncTimeout.class) {
            if (head == null) {
                head = new AsyncTimeout();
                new Watchdog().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i != 0) {
                asyncTimeout.timeoutAt = j + nanoTime;
            } else if (z) {
                asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            j = asyncTimeout.remainingNanos(nanoTime);
            z = head;
            while (z.next != null) {
                if (j < z.next.remainingNanos(nanoTime)) {
                    break;
                }
                z = z.next;
            }
            asyncTimeout.next = z.next;
            z.next = asyncTimeout;
            if (z == head) {
                AsyncTimeout.class.notify();
                return;
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            for (AsyncTimeout asyncTimeout2 = head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                if (asyncTimeout2.next == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    return null;
                }
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final Sink sink(final Sink sink) {
        return new Sink(this) {
            final /* synthetic */ AsyncTimeout f33182b;

            public void write(Buffer buffer, long j) throws IOException {
                Util.m28310a(buffer.f36201b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        Segment segment = buffer.f36200a;
                        while (j2 < 65536) {
                            j2 += (long) (buffer.f36200a.f26680c - buffer.f36200a.f26679b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                        }
                        this.f33182b.enter();
                        try {
                            sink.write(buffer, j2);
                            j -= j2;
                            this.f33182b.exit(true);
                        } catch (IOException e) {
                            throw this.f33182b.exit(e);
                        } catch (Throwable th) {
                            this.f33182b.exit(false);
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() throws IOException {
                this.f33182b.enter();
                try {
                    sink.flush();
                    this.f33182b.exit(true);
                } catch (IOException e) {
                    throw this.f33182b.exit(e);
                } catch (Throwable th) {
                    this.f33182b.exit(false);
                }
            }

            public void close() throws IOException {
                this.f33182b.enter();
                try {
                    sink.close();
                    this.f33182b.exit(true);
                } catch (IOException e) {
                    throw this.f33182b.exit(e);
                } catch (Throwable th) {
                    this.f33182b.exit(false);
                }
            }

            public Timeout timeout() {
                return this.f33182b;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("AsyncTimeout.sink(");
                stringBuilder.append(sink);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    public final Source source(final Source source) {
        return new Source(this) {
            final /* synthetic */ AsyncTimeout f33184b;

            public long read(Buffer buffer, long j) throws IOException {
                this.f33184b.enter();
                try {
                    buffer = source.read(buffer, j);
                    this.f33184b.exit(true);
                    return buffer;
                } catch (IOException e) {
                    throw this.f33184b.exit(e);
                } catch (Throwable th) {
                    this.f33184b.exit(false);
                }
            }

            public void close() throws IOException {
                try {
                    source.close();
                    this.f33184b.exit(true);
                } catch (IOException e) {
                    throw this.f33184b.exit(e);
                } catch (Throwable th) {
                    this.f33184b.exit(false);
                }
            }

            public Timeout timeout() {
                return this.f33184b;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("AsyncTimeout.source(");
                stringBuilder.append(source);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(false);
        }
    }

    final IOException exit(IOException iOException) throws IOException {
        if (exit()) {
            return newTimeoutException(iOException);
        }
        return iOException;
    }

    protected IOException newTimeoutException(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    static AsyncTimeout awaitTimeout() throws InterruptedException {
        AsyncTimeout asyncTimeout = head.next;
        if (asyncTimeout == null) {
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        nanoTime = asyncTimeout.remainingNanos(System.nanoTime());
        if (nanoTime > 0) {
            long j = nanoTime / 1000000;
            AsyncTimeout.class.wait(j, (int) (nanoTime - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }
}
