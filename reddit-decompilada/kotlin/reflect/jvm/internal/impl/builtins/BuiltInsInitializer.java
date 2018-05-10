package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BuiltInsInitializer.kt */
public final class BuiltInsInitializer<T extends KotlinBuiltIns> {
    private volatile T f25348a;
    private volatile boolean f25349b;
    private Throwable f25350c;
    private final Function0<T> f25351d;

    public BuiltInsInitializer(Function0<? extends T> function0) {
        Intrinsics.m26847b(function0, "constructor");
        this.f25351d = function0;
    }

    private final synchronized void m26938b() {
        if (this.f25348a != null) {
            return;
        }
        Throwable th;
        if (this.f25350c != null) {
            StringBuilder stringBuilder = new StringBuilder("Built-in library initialization failed previously: ");
            th = this.f25350c;
            if (th == null) {
                Intrinsics.m26842a();
            }
            stringBuilder.append(th);
            throw new IllegalStateException(stringBuilder.toString(), this.f25350c);
        } else if (this.f25349b) {
            throw new IllegalStateException("Built-in library initialization loop");
        } else {
            this.f25349b = true;
            try {
                this.f25348a = (KotlinBuiltIns) this.f25351d.invoke();
                this.f25349b = false;
            } catch (Throwable th2) {
                this.f25349b = false;
            }
        }
    }

    public final T m26939a() {
        if (this.f25349b) {
            KotlinBuiltIns kotlinBuiltIns;
            synchronized (this) {
                kotlinBuiltIns = this.f25348a;
                if (kotlinBuiltIns == null) {
                    throw new AssertionError("Built-ins are not initialized (note: We are under the same lock as initializing and instance)");
                }
                kotlinBuiltIns = kotlinBuiltIns;
            }
            return kotlinBuiltIns;
        }
        if (this.f25348a == null) {
            m26938b();
        }
        T t = this.f25348a;
        if (t == null) {
            Intrinsics.m26842a();
        }
        return t;
    }
}
