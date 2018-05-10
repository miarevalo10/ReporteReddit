package rx.internal.util;

import java.util.List;
import rx.Notification;
import rx.Observable;
import rx.Observable.Operator;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.OperatorAny;

public enum InternalObservableUtils {
    ;
    
    public static final PlusOneLongFunc2 f41351a = null;
    public static final ObjectEqualsFunc2 f41352b = null;
    public static final ToArrayFunc1 f41353c = null;
    static final ReturnsVoidFunc1 f41354d = null;
    public static final PlusOneFunc2 f41355e = null;
    static final NotificationErrorExtractor f41356f = null;
    public static final Action1<Throwable> f41357g = null;
    public static final Operator<Boolean, Object> f41358h = null;

    static final class ErrorNotImplementedAction implements Action1<Throwable> {
        ErrorNotImplementedAction() {
        }

        public final /* synthetic */ void mo7899a(Object obj) {
            throw new OnErrorNotImplementedException((Throwable) obj);
        }
    }

    static final class IsInstanceOfFunc1 implements Func1<Object, Boolean> {
        final Class<?> f41772a;

        public IsInstanceOfFunc1(Class<?> cls) {
            this.f41772a = cls;
        }

        public final /* synthetic */ Object call(Object obj) {
            return Boolean.valueOf(this.f41772a.isInstance(obj));
        }
    }

    static final class NotificationErrorExtractor implements Func1<Notification<?>, Throwable> {
        NotificationErrorExtractor() {
        }

        public final /* bridge */ /* synthetic */ Object call(Object obj) {
            return ((Notification) obj).f41300b;
        }
    }

    static final class ObjectEqualsFunc2 implements Func2<Object, Object, Boolean> {
        ObjectEqualsFunc2() {
        }

        public final /* synthetic */ Object mo7907a(Object obj, Object obj2) {
            if (obj != obj2) {
                if (obj == null || obj.equals(obj2) == null) {
                    obj = null;
                    return Boolean.valueOf(obj);
                }
            }
            obj = true;
            return Boolean.valueOf(obj);
        }
    }

    static final class PlusOneFunc2 implements Func2<Integer, Object, Integer> {
        PlusOneFunc2() {
        }

        public final /* synthetic */ Object mo7907a(Object obj, Object obj2) {
            return Integer.valueOf(((Integer) obj).intValue() + 1);
        }
    }

    static final class PlusOneLongFunc2 implements Func2<Long, Object, Long> {
        PlusOneLongFunc2() {
        }

        public final /* synthetic */ Object mo7907a(Object obj, Object obj2) {
            return Long.valueOf(((Long) obj).longValue() + 1);
        }
    }

    static final class RetryNotificationDematerializer implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> f41773a;

        public final /* synthetic */ Object call(Object obj) {
            return (Observable) this.f41773a.call(((Observable) obj).m43410b(InternalObservableUtils.f41356f));
        }

        public RetryNotificationDematerializer(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
            this.f41773a = func1;
        }
    }

    static final class ReturnsVoidFunc1 implements Func1<Object, Void> {
        public final /* bridge */ /* synthetic */ Object call(Object obj) {
            return null;
        }

        ReturnsVoidFunc1() {
        }
    }

    static final class ToArrayFunc1 implements Func1<List<? extends Observable<?>>, Observable<?>[]> {
        ToArrayFunc1() {
        }

        public final /* synthetic */ Object call(Object obj) {
            List list = (List) obj;
            return (Observable[]) list.toArray(new Observable[list.size()]);
        }
    }

    static {
        f41351a = new PlusOneLongFunc2();
        f41352b = new ObjectEqualsFunc2();
        f41353c = new ToArrayFunc1();
        f41354d = new ReturnsVoidFunc1();
        f41355e = new PlusOneFunc2();
        f41356f = new NotificationErrorExtractor();
        f41357g = new ErrorNotImplementedAction();
        f41358h = new OperatorAny(UtilityFunctions.m43473a());
    }

    public static Func1<Object, Boolean> m43468a(Class<?> cls) {
        return new IsInstanceOfFunc1(cls);
    }

    public static final Func1<Observable<? extends Notification<?>>, Observable<?>> m43469a(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return new RetryNotificationDematerializer(func1);
    }
}
