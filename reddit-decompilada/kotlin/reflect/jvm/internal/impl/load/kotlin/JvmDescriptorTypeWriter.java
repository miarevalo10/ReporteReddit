package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: typeSignatureMapping.kt */
public class JvmDescriptorTypeWriter<T> {
    private int f25796a;
    private T f25797b;
    private final JvmTypeFactory<T> f25798c;

    public final void m27314a() {
        if (this.f25797b == null) {
            this.f25796a++;
        }
    }

    public final void m27315a(T t) {
        Intrinsics.m26847b(t, "objectType");
        m27316b(t);
    }

    final void m27316b(T t) {
        Intrinsics.m26847b(t, "type");
        if (this.f25797b == null) {
            JvmTypeFactory jvmTypeFactory = this.f25798c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(StringsKt__StringsJVMKt.m41939a((CharSequence) "[", this.f25796a));
            stringBuilder.append(this.f25798c.mo5836b((Object) t));
            this.f25797b = jvmTypeFactory.mo5834a(stringBuilder.toString());
        }
    }
}
