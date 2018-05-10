package rx.plugins;

import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableOperator;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Single;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;

public final class RxJavaHooks {
    static volatile Action1<Throwable> f41388a = new C31291();
    static volatile Func1<OnSubscribe, OnSubscribe> f41389b = new Func1<OnSubscribe, OnSubscribe>() {
        public final /* synthetic */ Object call(Object obj) {
            OnSubscribe onSubscribe = (OnSubscribe) obj;
            RxJavaPlugins.m43511a().m43513c();
            return RxJavaObservableExecutionHook.m43506a(onSubscribe);
        }
    };
    static volatile Func1<Single.OnSubscribe, Single.OnSubscribe> f41390c = new Func1<Single.OnSubscribe, Single.OnSubscribe>() {
        public final /* synthetic */ Object call(Object obj) {
            Single.OnSubscribe onSubscribe = (Single.OnSubscribe) obj;
            RxJavaPlugins.m43511a().m43514d();
            return RxJavaSingleExecutionHook.m43528a(onSubscribe);
        }
    };
    static volatile Func1<CompletableOnSubscribe, CompletableOnSubscribe> f41391d = new Func1<CompletableOnSubscribe, CompletableOnSubscribe>() {
        public final /* synthetic */ Object call(Object obj) {
            CompletableOnSubscribe completableOnSubscribe = (CompletableOnSubscribe) obj;
            RxJavaPlugins.m43511a().m43515e();
            return RxJavaCompletableExecutionHook.m43490a(completableOnSubscribe);
        }
    };
    static volatile Func2<Observable, OnSubscribe, OnSubscribe> f41392e = new C31302();
    static volatile Func2<Single, OnSubscribe, OnSubscribe> f41393f = new C31324();
    static volatile Func2<Completable, CompletableOnSubscribe, CompletableOnSubscribe> f41394g = new C31346();
    static volatile Func1<Scheduler, Scheduler> f41395h;
    static volatile Func1<Scheduler, Scheduler> f41396i;
    static volatile Func1<Scheduler, Scheduler> f41397j;
    static volatile Func1<Action0, Action0> f41398k = new C31357();
    static volatile Func1<Subscription, Subscription> f41399l = new C31313();
    static volatile Func1<Subscription, Subscription> f41400m = new C31335();
    static volatile Func0<? extends ScheduledExecutorService> f41401n;
    static volatile Func1<Throwable, Throwable> f41402o = new C31368();
    static volatile Func1<Throwable, Throwable> f41403p = new Func1<Throwable, Throwable>() {
        public final /* synthetic */ Object call(Object obj) {
            Throwable th = (Throwable) obj;
            RxJavaPlugins.m43511a().m43514d();
            return RxJavaSingleExecutionHook.m43525a(th);
        }
    };
    static volatile Func1<Throwable, Throwable> f41404q = new Func1<Throwable, Throwable>() {
        public final /* synthetic */ Object call(Object obj) {
            Throwable th = (Throwable) obj;
            RxJavaPlugins.m43511a().m43515e();
            return RxJavaCompletableExecutionHook.m43489a(th);
        }
    };
    static volatile Func1<Operator, Operator> f41405r = new C31379();
    static volatile Func1<Operator, Operator> f41406s = new Func1<Operator, Operator>() {
        public final /* synthetic */ Object call(Object obj) {
            Operator operator = (Operator) obj;
            RxJavaPlugins.m43511a().m43514d();
            return RxJavaSingleExecutionHook.m43527a(operator);
        }
    };
    static volatile Func1<CompletableOperator, CompletableOperator> f41407t = new Func1<CompletableOperator, CompletableOperator>() {
        public final /* synthetic */ Object call(Object obj) {
            CompletableOperator completableOperator = (CompletableOperator) obj;
            RxJavaPlugins.m43511a().m43515e();
            return RxJavaCompletableExecutionHook.m43491a(completableOperator);
        }
    };

    static class C31291 implements Action1<Throwable> {
        C31291() {
        }

        public final /* synthetic */ void mo7899a(Object obj) {
            RxJavaPlugins.m43511a().m43512b();
        }
    }

    static class C31302 implements Func2<Observable, OnSubscribe, OnSubscribe> {
        C31302() {
        }

        public final /* synthetic */ Object mo7907a(Object obj, Object obj2) {
            OnSubscribe onSubscribe = (OnSubscribe) obj2;
            RxJavaPlugins.m43511a().m43513c();
            return RxJavaObservableExecutionHook.m43509b(onSubscribe);
        }
    }

    static class C31313 implements Func1<Subscription, Subscription> {
        C31313() {
        }

        public final /* synthetic */ Object call(Object obj) {
            Subscription subscription = (Subscription) obj;
            RxJavaPlugins.m43511a().m43513c();
            return RxJavaObservableExecutionHook.m43508a(subscription);
        }
    }

    static class C31324 implements Func2<Single, OnSubscribe, OnSubscribe> {
        C31324() {
        }

        public final /* synthetic */ Object mo7907a(Object obj, Object obj2) {
            OnSubscribe onSubscribe = (OnSubscribe) obj2;
            RxJavaPlugins.m43511a().m43514d();
            return RxJavaSingleExecutionHook.m43526a(onSubscribe);
        }
    }

    static class C31335 implements Func1<Subscription, Subscription> {
        C31335() {
        }

        public final /* synthetic */ Object call(Object obj) {
            Subscription subscription = (Subscription) obj;
            RxJavaPlugins.m43511a().m43514d();
            return RxJavaSingleExecutionHook.m43529a(subscription);
        }
    }

    static class C31346 implements Func2<Completable, CompletableOnSubscribe, CompletableOnSubscribe> {
        C31346() {
        }

        public final /* synthetic */ Object mo7907a(Object obj, Object obj2) {
            CompletableOnSubscribe completableOnSubscribe = (CompletableOnSubscribe) obj2;
            RxJavaPlugins.m43511a().m43515e();
            return RxJavaCompletableExecutionHook.m43492b(completableOnSubscribe);
        }
    }

    static class C31357 implements Func1<Action0, Action0> {
        C31357() {
        }

        public final /* synthetic */ Object call(Object obj) {
            Action0 action0 = (Action0) obj;
            RxJavaPlugins.m43511a().m43516f();
            return RxJavaSchedulersHook.m43518a(action0);
        }
    }

    static class C31368 implements Func1<Throwable, Throwable> {
        C31368() {
        }

        public final /* synthetic */ Object call(Object obj) {
            Throwable th = (Throwable) obj;
            RxJavaPlugins.m43511a().m43513c();
            return RxJavaObservableExecutionHook.m43505a(th);
        }
    }

    static class C31379 implements Func1<Operator, Operator> {
        C31379() {
        }

        public final /* synthetic */ Object call(Object obj) {
            Operator operator = (Operator) obj;
            RxJavaPlugins.m43511a().m43513c();
            return RxJavaObservableExecutionHook.m43507a(operator);
        }
    }

    public static void m43500a(Throwable th) {
        Action1 action1 = f41388a;
        if (action1 != null) {
            try {
                action1.mo7899a(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder("The onError handler threw an Exception. It shouldn't. => ");
                stringBuilder.append(th2.getMessage());
                printStream.println(stringBuilder.toString());
                th2.printStackTrace();
                m43504c(th2);
            }
        }
        m43504c(th);
    }

    private static void m43504c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> OnSubscribe<T> m43493a(OnSubscribe<T> onSubscribe) {
        Func1 func1 = f41389b;
        return func1 != null ? (OnSubscribe) func1.call(onSubscribe) : onSubscribe;
    }

    public static Scheduler m43496a(Scheduler scheduler) {
        Func1 func1 = f41395h;
        return func1 != null ? (Scheduler) func1.call(scheduler) : scheduler;
    }

    public static Scheduler m43502b(Scheduler scheduler) {
        Func1 func1 = f41396i;
        return func1 != null ? (Scheduler) func1.call(scheduler) : scheduler;
    }

    public static Scheduler m43503c(Scheduler scheduler) {
        Func1 func1 = f41397j;
        return func1 != null ? (Scheduler) func1.call(scheduler) : scheduler;
    }

    public static Action0 m43498a(Action0 action0) {
        Func1 func1 = f41398k;
        return func1 != null ? (Action0) func1.call(action0) : action0;
    }

    public static <T> OnSubscribe<T> m43494a(Observable<T> observable, OnSubscribe<T> onSubscribe) {
        Func2 func2 = f41392e;
        return func2 != null ? (OnSubscribe) func2.mo7907a(observable, onSubscribe) : onSubscribe;
    }

    public static Subscription m43497a(Subscription subscription) {
        Func1 func1 = f41399l;
        return func1 != null ? (Subscription) func1.call(subscription) : subscription;
    }

    public static Throwable m43501b(Throwable th) {
        Func1 func1 = f41402o;
        return func1 != null ? (Throwable) func1.call(th) : th;
    }

    public static <T, R> Operator<R, T> m43495a(Operator<R, T> operator) {
        Func1 func1 = f41405r;
        return func1 != null ? (Operator) func1.call(operator) : operator;
    }

    public static Func0<? extends ScheduledExecutorService> m43499a() {
        return f41401n;
    }
}
