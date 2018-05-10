package rx.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

public enum ExceptionsUtils {
    ;
    
    private static final Throwable f41349a = null;

    static {
        f41349a = new Throwable("Terminated");
    }

    public static boolean m43467a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Object obj;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == f41349a) {
                return false;
            }
            if (th2 == null) {
                obj = th;
            } else if (th2 instanceof CompositeException) {
                Collection arrayList = new ArrayList(((CompositeException) th2).f41309a);
                arrayList.add(th);
                obj = new CompositeException(arrayList, (byte) 0);
            } else {
                obj = new CompositeException(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, obj));
        return true;
    }

    public static Throwable m43465a(AtomicReference<Throwable> atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        return th != f41349a ? (Throwable) atomicReference.getAndSet(f41349a) : th;
    }

    public static boolean m43466a(Throwable th) {
        return th == f41349a ? true : null;
    }
}
