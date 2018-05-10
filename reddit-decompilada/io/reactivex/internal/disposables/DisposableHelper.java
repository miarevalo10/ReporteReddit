package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public enum DisposableHelper implements Disposable {
    ;

    public final void mo5626a() {
    }

    public final boolean mo5627b() {
        return true;
    }

    private DisposableHelper(String str) {
    }

    public static boolean m32088a(Disposable disposable) {
        return disposable == f31095a ? true : null;
    }

    public static boolean m32091a(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) atomicReference.get();
            if (disposable2 == f31095a) {
                if (disposable != null) {
                    disposable.mo5626a();
                }
                return null;
            }
        } while (!atomicReference.compareAndSet(disposable2, disposable));
        if (disposable2 != null) {
            disposable2.mo5626a();
        }
        return true;
    }

    public static boolean m32092b(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        ObjectHelper.m26573a((Object) disposable, "d is null");
        if (atomicReference.compareAndSet(null, disposable)) {
            return true;
        }
        disposable.mo5626a();
        if (atomicReference.get() != f31095a) {
            m32093c();
        }
        return null;
    }

    public static boolean m32094c(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) atomicReference.get();
            if (disposable2 == f31095a) {
                if (disposable != null) {
                    disposable.mo5626a();
                }
                return null;
            }
        } while (!atomicReference.compareAndSet(disposable2, disposable));
        return true;
    }

    public static boolean m32090a(AtomicReference<Disposable> atomicReference) {
        Disposable disposable = (Disposable) atomicReference.get();
        Disposable disposable2 = f31095a;
        if (disposable != disposable2) {
            Disposable disposable3 = (Disposable) atomicReference.getAndSet(disposable2);
            if (disposable3 != disposable2) {
                if (disposable3 != null) {
                    disposable3.mo5626a();
                }
                return true;
            }
        }
        return null;
    }

    public static boolean m32089a(Disposable disposable, Disposable disposable2) {
        if (disposable2 == null) {
            RxJavaPlugins.m26757a(new NullPointerException("next is null"));
            return false;
        } else if (disposable == null) {
            return true;
        } else {
            disposable2.mo5626a();
            m32093c();
            return false;
        }
    }

    private static void m32093c() {
        RxJavaPlugins.m26757a(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean m32095d(AtomicReference<Disposable> atomicReference, Disposable disposable) {
        if (atomicReference.compareAndSet(null, disposable)) {
            return true;
        }
        if (atomicReference.get() == f31095a) {
            disposable.mo5626a();
        }
        return null;
    }
}
