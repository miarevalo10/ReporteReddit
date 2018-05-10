package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import rx.Observable.OnSubscribe;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;

public final class BehaviorSubject<T> extends Subject<T, T> {
    private static final Object[] f42039b = new Object[0];
    private final SubjectSubscriptionManager<T> f42040c;
    private final NotificationLite<T> f42041d = NotificationLite.m43450a();

    private BehaviorSubject(OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.f42040c = subjectSubscriptionManager;
    }

    public final void mo7906b() {
        if (this.f42040c.f42049a == null || this.f42040c.f42050b) {
            Object b = NotificationLite.m43452b();
            for (SubjectObserver b2 : this.f42040c.m44159b(b)) {
                b2.m43941b(b);
            }
        }
    }

    public final void mo7904a(Throwable th) {
        if (this.f42040c.f42049a == null || this.f42040c.f42050b) {
            th = NotificationLite.m43449a(th);
            List list = null;
            for (SubjectObserver b : this.f42040c.m44159b(th)) {
                try {
                    b.m43941b(th);
                } catch (Throwable th2) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(th2);
                }
            }
            Exceptions.m43434a(list);
        }
    }

    public final void a_(T t) {
        if (this.f42040c.f42049a == null || this.f42040c.f42050b) {
            t = NotificationLite.m43448a((Object) t);
            SubjectSubscriptionManager subjectSubscriptionManager = this.f42040c;
            subjectSubscriptionManager.f42049a = t;
            for (SubjectObserver b : ((State) subjectSubscriptionManager.get()).observers) {
                b.m43941b(t);
            }
        }
    }

    public final boolean mo7932e() {
        return ((State) this.f42040c.get()).observers.length > 0;
    }

    public static <T> BehaviorSubject<T> m44141d() {
        final Object subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.f42052d = new Action1<SubjectObserver<T>>() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ void mo7899a(java.lang.Object r8) {
                /*
                r7 = this;
                r8 = (rx.subjects.SubjectSubscriptionManager.SubjectObserver) r8;
                r0 = r0;
                r0 = r0.f42049a;
                monitor-enter(r8);
                r1 = r8.f41831b;	 Catch:{ all -> 0x0061 }
                if (r1 == 0) goto L_0x005f;
            L_0x000b:
                r1 = r8.f41832c;	 Catch:{ all -> 0x0061 }
                if (r1 == 0) goto L_0x0010;
            L_0x000f:
                goto L_0x005f;
            L_0x0010:
                r1 = 0;
                r8.f41831b = r1;	 Catch:{ all -> 0x0061 }
                r2 = 1;
                if (r0 == 0) goto L_0x0018;
            L_0x0016:
                r3 = r2;
                goto L_0x0019;
            L_0x0018:
                r3 = r1;
            L_0x0019:
                r8.f41832c = r3;	 Catch:{ all -> 0x0061 }
                monitor-exit(r8);	 Catch:{ all -> 0x0061 }
                if (r0 == 0) goto L_0x005e;
            L_0x001e:
                r3 = 0;
                r5 = r2;
                r4 = r3;
            L_0x0021:
                if (r4 == 0) goto L_0x0038;
            L_0x0023:
                r4 = r4.iterator();	 Catch:{ all -> 0x0035 }
            L_0x0027:
                r6 = r4.hasNext();	 Catch:{ all -> 0x0035 }
                if (r6 == 0) goto L_0x0038;
            L_0x002d:
                r6 = r4.next();	 Catch:{ all -> 0x0035 }
                r8.m43942c(r6);	 Catch:{ all -> 0x0035 }
                goto L_0x0027;
            L_0x0035:
                r0 = move-exception;
                r2 = r1;
                goto L_0x0053;
            L_0x0038:
                if (r5 == 0) goto L_0x003e;
            L_0x003a:
                r8.m43942c(r0);	 Catch:{ all -> 0x0035 }
                r5 = r1;
            L_0x003e:
                monitor-enter(r8);	 Catch:{ all -> 0x0035 }
                r4 = r8.f41833d;	 Catch:{ all -> 0x004b }
                r8.f41833d = r3;	 Catch:{ all -> 0x004b }
                if (r4 != 0) goto L_0x0049;
            L_0x0045:
                r8.f41832c = r1;	 Catch:{ all -> 0x004b }
                monitor-exit(r8);	 Catch:{ all -> 0x0051 }
                return;
            L_0x0049:
                monitor-exit(r8);	 Catch:{ all -> 0x004b }
                goto L_0x0021;
            L_0x004b:
                r0 = move-exception;
                r2 = r1;
            L_0x004d:
                monitor-exit(r8);	 Catch:{ all -> 0x0051 }
                throw r0;	 Catch:{ all -> 0x004f }
            L_0x004f:
                r0 = move-exception;
                goto L_0x0053;
            L_0x0051:
                r0 = move-exception;
                goto L_0x004d;
            L_0x0053:
                if (r2 != 0) goto L_0x005d;
            L_0x0055:
                monitor-enter(r8);
                r8.f41832c = r1;	 Catch:{ all -> 0x005a }
                monitor-exit(r8);	 Catch:{ all -> 0x005a }
                goto L_0x005d;
            L_0x005a:
                r0 = move-exception;
                monitor-exit(r8);	 Catch:{ all -> 0x005a }
                throw r0;
            L_0x005d:
                throw r0;
            L_0x005e:
                return;
            L_0x005f:
                monitor-exit(r8);	 Catch:{ all -> 0x0061 }
                return;
            L_0x0061:
                r0 = move-exception;
                monitor-exit(r8);	 Catch:{ all -> 0x0061 }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.subjects.BehaviorSubject.1.a(java.lang.Object):void");
            }
        };
        subjectSubscriptionManager.f42053e = subjectSubscriptionManager.f42052d;
        return new BehaviorSubject(subjectSubscriptionManager, subjectSubscriptionManager);
    }
}
