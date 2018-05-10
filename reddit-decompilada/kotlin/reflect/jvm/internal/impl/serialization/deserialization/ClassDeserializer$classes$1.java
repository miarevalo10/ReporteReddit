package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: ClassDeserializer.kt */
final class ClassDeserializer$classes$1 extends Lambda implements Function1<ClassKey, ClassDescriptor> {
    final /* synthetic */ ClassDeserializer f38830a;

    ClassDeserializer$classes$1(ClassDeserializer classDeserializer) {
        this.f38830a = classDeserializer;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ClassKey classKey = (ClassKey) obj;
        Intrinsics.m26847b(classKey, "key");
        return ClassDeserializer.m27824a(this.f38830a, classKey);
    }
}
