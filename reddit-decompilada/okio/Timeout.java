package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout {
    public static final Timeout NONE = new C26341();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    class C26341 extends Timeout {
        public final Timeout deadlineNanoTime(long j) {
            return this;
        }

        public final void throwIfReached() throws IOException {
        }

        public final Timeout timeout(long j, TimeUnit timeUnit) {
            return this;
        }

        C26341() {
        }
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("timeout < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public final Timeout deadline(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            StringBuilder stringBuilder = new StringBuilder("duration <= 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit != null) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public final void waitUntilNotified(java.lang.Object r10) throws java.io.InterruptedIOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.hasDeadline();	 Catch:{ InterruptedException -> 0x0052 }
        r1 = r9.timeoutNanos();	 Catch:{ InterruptedException -> 0x0052 }
        r3 = 0;	 Catch:{ InterruptedException -> 0x0052 }
        if (r0 != 0) goto L_0x0014;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x000c:
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0052 }
        if (r5 != 0) goto L_0x0014;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0010:
        r10.wait();	 Catch:{ InterruptedException -> 0x0052 }
        return;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0014:
        r5 = java.lang.System.nanoTime();	 Catch:{ InterruptedException -> 0x0052 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x001a:
        r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0052 }
        if (r7 == 0) goto L_0x0028;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x001e:
        r7 = r9.deadlineNanoTime();	 Catch:{ InterruptedException -> 0x0052 }
        r7 = r7 - r5;	 Catch:{ InterruptedException -> 0x0052 }
        r1 = java.lang.Math.min(r1, r7);	 Catch:{ InterruptedException -> 0x0052 }
        goto L_0x0030;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0028:
        if (r0 == 0) goto L_0x0030;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x002a:
        r0 = r9.deadlineNanoTime();	 Catch:{ InterruptedException -> 0x0052 }
        r1 = r0 - r5;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0030:
        r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0052 }
        if (r0 <= 0) goto L_0x0045;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0034:
        r3 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;	 Catch:{ InterruptedException -> 0x0052 }
        r7 = r1 / r3;	 Catch:{ InterruptedException -> 0x0052 }
        r3 = r3 * r7;	 Catch:{ InterruptedException -> 0x0052 }
        r3 = r1 - r3;	 Catch:{ InterruptedException -> 0x0052 }
        r0 = (int) r3;	 Catch:{ InterruptedException -> 0x0052 }
        r10.wait(r7, r0);	 Catch:{ InterruptedException -> 0x0052 }
        r3 = java.lang.System.nanoTime();	 Catch:{ InterruptedException -> 0x0052 }
        r3 = r3 - r5;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0045:
        r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0052 }
        if (r10 < 0) goto L_0x0051;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0049:
        r10 = new java.io.InterruptedIOException;	 Catch:{ InterruptedException -> 0x0052 }
        r0 = "timeout";	 Catch:{ InterruptedException -> 0x0052 }
        r10.<init>(r0);	 Catch:{ InterruptedException -> 0x0052 }
        throw r10;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0051:
        return;
    L_0x0052:
        r10 = new java.io.InterruptedIOException;
        r0 = "interrupted";
        r10.<init>(r0);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Timeout.waitUntilNotified(java.lang.Object):void");
    }
}
