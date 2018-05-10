package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;

public abstract class CallableReference implements Serializable, KCallable {
    public static final Object f32530c = NoReceiver.f25286a;
    private transient KCallable f32531a;
    protected final Object f32532b;

    private static class NoReceiver implements Serializable {
        private static final NoReceiver f25286a = new NoReceiver();

        private NoReceiver() {
        }
    }

    protected abstract KCallable mo6660e();

    public CallableReference() {
        this(f32530c);
    }

    protected CallableReference(Object obj) {
        this.f32532b = obj;
    }

    public final Object m32846f() {
        return this.f32532b;
    }

    public final KCallable m32847g() {
        KCallable kCallable = this.f32531a;
        if (kCallable != null) {
            return kCallable;
        }
        kCallable = mo6660e();
        this.f32531a = kCallable;
        return kCallable;
    }

    protected KCallable mo6662h() {
        CallableReference g = m32847g();
        if (g != this) {
            return g;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public KDeclarationContainer mo6931a() {
        throw new AbstractMethodError();
    }

    public String mo5687b() {
        throw new AbstractMethodError();
    }

    public String mo6932c() {
        throw new AbstractMethodError();
    }

    public final Object mo5686a(Object... objArr) {
        return mo6662h().mo5686a(objArr);
    }
}
