package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    public static final Throwable f25187a = new Termination();

    static final class Termination extends Throwable {
        public final Throwable fillInStackTrace() {
            return this;
        }

        Termination() {
            super("No further exceptions");
        }
    }

    public static RuntimeException m26682a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }

    public static <T> boolean m26684a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Object obj;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == f25187a) {
                return false;
            }
            if (th2 == null) {
                obj = th;
            } else {
                obj = new CompositeException(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, obj));
        return true;
    }

    public static <T> Throwable m26683a(AtomicReference<Throwable> atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        return th != f25187a ? (Throwable) atomicReference.getAndSet(f25187a) : th;
    }

    public static <E extends Throwable> Exception m26685b(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }
}
