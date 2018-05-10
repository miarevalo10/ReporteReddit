package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    final String f25163a;
    final int f25164b;
    final boolean f25165c;

    static final class RxCustomThread extends Thread implements NonBlockingThread {
        RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.f25163a = str;
        this.f25164b = i;
        this.f25165c = z;
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder(this.f25163a);
        stringBuilder.append('-');
        stringBuilder.append(incrementAndGet());
        String stringBuilder2 = stringBuilder.toString();
        Thread rxCustomThread = this.f25165c ? new RxCustomThread(runnable, stringBuilder2) : new Thread(runnable, stringBuilder2);
        rxCustomThread.setPriority(this.f25164b);
        rxCustomThread.setDaemon(true);
        return rxCustomThread;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RxThreadFactory[");
        stringBuilder.append(this.f25163a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
