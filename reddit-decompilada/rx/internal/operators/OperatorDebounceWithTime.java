package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithTime<T> implements Operator<T, T> {
    final long f41939a;
    final TimeUnit f41940b;
    final Scheduler f41941c;

    static final class DebounceState<T> {
        int f41319a;
        T f41320b;
        boolean f41321c;
        boolean f41322d;
        boolean f41323e;

        DebounceState() {
        }

        public final synchronized int m43455a(T t) {
            int i;
            this.f41320b = t;
            this.f41321c = true;
            i = this.f41319a + 1;
            this.f41319a = i;
            return i;
        }

        public final synchronized void m43456a() {
            this.f41319a++;
            this.f41320b = null;
            this.f41321c = false;
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        final Object a = this.f41941c.mo7895a();
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final Object serialSubscription = new SerialSubscription();
        serializedSubscriber.m43809a((Subscription) a);
        serializedSubscriber.m43809a((Subscription) serialSubscription);
        return new Subscriber<T>(this, subscriber) {
            final DebounceState<T> f41933a = new DebounceState();
            final Subscriber<?> f41934b = this;
            final /* synthetic */ OperatorDebounceWithTime f41938g;

            public final void aV_() {
                m43807a(Long.MAX_VALUE);
            }

            public final void a_(T t) {
                t = this.f41933a.m43455a(t);
                serialSubscription.m43952a(a.mo7928a(new Action0(this) {
                    final /* synthetic */ C31571 f41706b;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void mo7898a() {
                        /*
                        r6 = this;
                        r0 = r6.f41706b;
                        r0 = r0.f41933a;
                        r1 = r6;
                        r2 = r6.f41706b;
                        r2 = r5;
                        r3 = r6.f41706b;
                        r3 = r3.f41934b;
                        monitor-enter(r0);
                        r4 = r0.f41323e;	 Catch:{ all -> 0x0043 }
                        if (r4 != 0) goto L_0x0041;
                    L_0x0013:
                        r4 = r0.f41321c;	 Catch:{ all -> 0x0043 }
                        if (r4 == 0) goto L_0x0041;
                    L_0x0017:
                        r4 = r0.f41319a;	 Catch:{ all -> 0x0043 }
                        if (r1 == r4) goto L_0x001c;
                    L_0x001b:
                        goto L_0x0041;
                    L_0x001c:
                        r1 = r0.f41320b;	 Catch:{ all -> 0x0043 }
                        r4 = 0;
                        r0.f41320b = r4;	 Catch:{ all -> 0x0043 }
                        r4 = 0;
                        r0.f41321c = r4;	 Catch:{ all -> 0x0043 }
                        r5 = 1;
                        r0.f41323e = r5;	 Catch:{ all -> 0x0043 }
                        monitor-exit(r0);	 Catch:{ all -> 0x0043 }
                        r2.a_(r1);	 Catch:{ Throwable -> 0x003c }
                        monitor-enter(r0);
                        r1 = r0.f41322d;	 Catch:{ all -> 0x0039 }
                        if (r1 != 0) goto L_0x0034;
                    L_0x0030:
                        r0.f41323e = r4;	 Catch:{ all -> 0x0039 }
                        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
                        return;
                    L_0x0034:
                        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
                        r2.mo7906b();
                        return;
                    L_0x0039:
                        r1 = move-exception;
                        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
                        throw r1;
                    L_0x003c:
                        r0 = move-exception;
                        rx.exceptions.Exceptions.m43433a(r0, r3, r1);
                        return;
                    L_0x0041:
                        monitor-exit(r0);	 Catch:{ all -> 0x0043 }
                        return;
                    L_0x0043:
                        r1 = move-exception;
                        monitor-exit(r0);	 Catch:{ all -> 0x0043 }
                        throw r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.1.1.a():void");
                    }
                }, this.f41938g.f41939a, this.f41938g.f41940b));
            }

            public final void mo7904a(Throwable th) {
                serializedSubscriber.mo7904a(th);
                this.f41662d.mo7893c();
                this.f41933a.m43456a();
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void mo7906b() {
                /*
                r6 = this;
                r0 = r6.f41933a;
                r1 = r5;
                monitor-enter(r0);
                r2 = r0.f41323e;	 Catch:{ all -> 0x002a }
                r3 = 1;
                if (r2 == 0) goto L_0x000e;
            L_0x000a:
                r0.f41322d = r3;	 Catch:{ all -> 0x002a }
                monitor-exit(r0);	 Catch:{ all -> 0x002a }
                return;
            L_0x000e:
                r2 = r0.f41320b;	 Catch:{ all -> 0x002a }
                r4 = r0.f41321c;	 Catch:{ all -> 0x002a }
                r5 = 0;
                r0.f41320b = r5;	 Catch:{ all -> 0x002a }
                r5 = 0;
                r0.f41321c = r5;	 Catch:{ all -> 0x002a }
                r0.f41323e = r3;	 Catch:{ all -> 0x002a }
                monitor-exit(r0);	 Catch:{ all -> 0x002a }
                if (r4 == 0) goto L_0x0026;
            L_0x001d:
                r1.a_(r2);	 Catch:{ Throwable -> 0x0021 }
                goto L_0x0026;
            L_0x0021:
                r0 = move-exception;
                rx.exceptions.Exceptions.m43433a(r0, r6, r2);
                return;
            L_0x0026:
                r1.mo7906b();
                return;
            L_0x002a:
                r1 = move-exception;
                monitor-exit(r0);	 Catch:{ all -> 0x002a }
                throw r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDebounceWithTime.1.b():void");
            }
        };
    }

    public OperatorDebounceWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f41939a = j;
        this.f41940b = timeUnit;
        this.f41941c = scheduler;
    }
}
