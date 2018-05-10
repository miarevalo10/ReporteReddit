package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ImplicitClassReceiver.kt */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {
    private final ClassDescriptor f36163a = this.f36164b;
    private final ClassDescriptor f36164b;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "classDescriptor");
        this.f36164b = classDescriptor;
    }

    public final /* synthetic */ KotlinType mo5715a() {
        return m36373c();
    }

    public final ClassDescriptor mo6730b() {
        return this.f36164b;
    }

    private SimpleType m36373c() {
        return this.f36164b.mo7714h();
    }

    public boolean equals(Object obj) {
        Object obj2 = this.f36164b;
        Object obj3 = null;
        if (!(obj instanceof ImplicitClassReceiver)) {
            obj = null;
        }
        ImplicitClassReceiver implicitClassReceiver = (ImplicitClassReceiver) obj;
        if (implicitClassReceiver != null) {
            obj3 = implicitClassReceiver.f36164b;
        }
        return Intrinsics.m26845a(obj2, obj3);
    }

    public int hashCode() {
        return this.f36164b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Class{");
        stringBuilder.append(m36373c());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
