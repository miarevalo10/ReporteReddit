package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int f36010a;

    public FunctionReference(int i) {
        this.f36010a = i;
    }

    public FunctionReference(int i, Object obj) {
        super(obj);
        this.f36010a = i;
    }

    public int getArity() {
        return this.f36010a;
    }

    protected final KCallable mo6660e() {
        return Reflection.m26852a(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r5 != r4) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof kotlin.jvm.internal.FunctionReference;
        r2 = 0;
        if (r1 == 0) goto L_0x0052;
    L_0x0009:
        r5 = (kotlin.jvm.internal.FunctionReference) r5;
        r1 = r4.mo6931a();
        if (r1 != 0) goto L_0x0018;
    L_0x0011:
        r1 = r5.mo6931a();
        if (r1 != 0) goto L_0x0051;
    L_0x0017:
        goto L_0x0026;
    L_0x0018:
        r1 = r4.mo6931a();
        r3 = r5.mo6931a();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0051;
    L_0x0026:
        r1 = r4.mo5687b();
        r3 = r5.mo5687b();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0051;
    L_0x0034:
        r1 = r4.mo6932c();
        r3 = r5.mo6932c();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0051;
    L_0x0042:
        r1 = r4.m32846f();
        r5 = r5.m32846f();
        r5 = kotlin.jvm.internal.Intrinsics.m26845a(r1, r5);
        if (r5 == 0) goto L_0x0051;
    L_0x0050:
        return r0;
    L_0x0051:
        return r2;
    L_0x0052:
        r0 = r5 instanceof kotlin.reflect.KFunction;
        if (r0 == 0) goto L_0x005f;
    L_0x0056:
        r0 = r4.m32847g();
        r5 = r5.equals(r0);
        return r5;
    L_0x005f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.FunctionReference.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return (((mo6931a() == null ? 0 : mo6931a().hashCode() * 31) + mo5687b().hashCode()) * 31) + mo6932c().hashCode();
    }

    public String toString() {
        FunctionReference g = m32847g();
        if (g != this) {
            return g.toString();
        }
        if ("<init>".equals(mo5687b())) {
            return "constructor (Kotlin reflection is not available)";
        }
        StringBuilder stringBuilder = new StringBuilder("function ");
        stringBuilder.append(mo5687b());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }

    protected final /* bridge */ /* synthetic */ KCallable mo6662h() {
        return (KFunction) super.mo6662h();
    }
}
