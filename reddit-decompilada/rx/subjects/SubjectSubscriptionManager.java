package rx.subjects;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

final class SubjectSubscriptionManager<T> extends AtomicReference<State<T>> implements OnSubscribe<T> {
    volatile Object f42049a;
    boolean f42050b = true;
    Action1<SubjectObserver<T>> f42051c = Actions.m43440a();
    Action1<SubjectObserver<T>> f42052d = Actions.m43440a();
    Action1<SubjectObserver<T>> f42053e = Actions.m43440a();
    public final NotificationLite<T> f42054f = NotificationLite.m43450a();

    protected static final class State<T> {
        static final State EMPTY = new State(false, NO_OBSERVERS);
        static final SubjectObserver[] NO_OBSERVERS = new SubjectObserver[0];
        static final State TERMINATED = new State(true, NO_OBSERVERS);
        final SubjectObserver[] observers;
        final boolean terminated;

        public State(boolean z, SubjectObserver[] subjectObserverArr) {
            this.terminated = z;
            this.observers = subjectObserverArr;
        }

        public final State add(SubjectObserver subjectObserver) {
            int length = this.observers.length;
            Object obj = new SubjectObserver[(length + 1)];
            System.arraycopy(this.observers, 0, obj, 0, length);
            obj[length] = subjectObserver;
            return new State(this.terminated, obj);
        }

        public final State remove(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            int length = subjectObserverArr.length;
            if (length == 1 && subjectObserverArr[0] == subjectObserver) {
                return EMPTY;
            }
            if (length == 0) {
                return this;
            }
            int i = length - 1;
            SubjectObserver subjectObserver2 = new SubjectObserver[i];
            int i2 = 0;
            int i3 = i2;
            while (i2 < length) {
                SubjectObserver subjectObserver3 = subjectObserverArr[i2];
                if (subjectObserver3 != subjectObserver) {
                    if (i3 == i) {
                        return this;
                    }
                    int i4 = i3 + 1;
                    subjectObserver2[i3] = subjectObserver3;
                    i3 = i4;
                }
                i2++;
            }
            if (i3 == 0) {
                return EMPTY;
            }
            if (i3 < i) {
                subjectObserver = new SubjectObserver[i3];
                System.arraycopy(subjectObserver2, 0, subjectObserver, 0, i3);
            } else {
                subjectObserver = subjectObserver2;
            }
            return new State(this.terminated, subjectObserver);
        }
    }

    protected static final class SubjectObserver<T> implements Observer<T> {
        final Subscriber<? super T> f41830a;
        boolean f41831b = true;
        boolean f41832c;
        List<Object> f41833d;
        boolean f41834e;

        public SubjectObserver(Subscriber<? super T> subscriber) {
            this.f41830a = subscriber;
        }

        public final void a_(T t) {
            this.f41830a.a_(t);
        }

        public final void mo7904a(Throwable th) {
            this.f41830a.mo7904a(th);
        }

        public final void mo7906b() {
            this.f41830a.mo7906b();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m43941b(java.lang.Object r2) {
            /*
            r1 = this;
            r0 = r1.f41834e;
            if (r0 != 0) goto L_0x0026;
        L_0x0004:
            monitor-enter(r1);
            r0 = 0;
            r1.f41831b = r0;	 Catch:{ all -> 0x0023 }
            r0 = r1.f41832c;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001e;
        L_0x000c:
            r0 = r1.f41833d;	 Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0017;
        L_0x0010:
            r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0023 }
            r0.<init>();	 Catch:{ all -> 0x0023 }
            r1.f41833d = r0;	 Catch:{ all -> 0x0023 }
        L_0x0017:
            r0 = r1.f41833d;	 Catch:{ all -> 0x0023 }
            r0.add(r2);	 Catch:{ all -> 0x0023 }
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            return;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            r0 = 1;
            r1.f41834e = r0;
            goto L_0x0026;
        L_0x0023:
            r2 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            throw r2;
        L_0x0026:
            r0 = r1.f41830a;
            rx.internal.operators.NotificationLite.m43451a(r0, r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.SubjectSubscriptionManager.SubjectObserver.b(java.lang.Object):void");
        }

        final void m43942c(Object obj) {
            if (obj != null) {
                NotificationLite.m43451a(this.f41830a, obj);
            }
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        final SubjectObserver subjectObserver = new SubjectObserver(subscriber);
        subscriber.m43809a(Subscriptions.m43537a(new Action0(this) {
            final /* synthetic */ SubjectSubscriptionManager f41829b;

            public final void mo7898a() {
                this.f41829b.m44158a(subjectObserver);
            }
        }));
        this.f42051c.mo7899a(subjectObserver);
        if (!subscriber.mo7894d()) {
            Object obj2;
            State state;
            do {
                state = (State) get();
                if (state.terminated) {
                    this.f42053e.mo7899a(subjectObserver);
                    obj2 = null;
                    break;
                }
            } while (!compareAndSet(state, state.add(subjectObserver)));
            this.f42052d.mo7899a(subjectObserver);
            obj2 = 1;
            if (obj2 != null && subscriber.mo7894d() != null) {
                m44158a(subjectObserver);
            }
        }
    }

    public SubjectSubscriptionManager() {
        super(State.EMPTY);
    }

    final void m44158a(SubjectObserver<T> subjectObserver) {
        State state;
        State remove;
        do {
            state = (State) get();
            if (!state.terminated) {
                remove = state.remove(subjectObserver);
                if (remove == state) {
                    break;
                }
            } else {
                return;
            }
        } while (!compareAndSet(state, remove));
    }

    final SubjectObserver<T>[] m44159b(Object obj) {
        this.f42049a = obj;
        this.f42050b = null;
        if (((State) get()).terminated != null) {
            return State.NO_OBSERVERS;
        }
        return ((State) getAndSet(State.TERMINATED)).observers;
    }
}
