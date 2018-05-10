package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;

/* compiled from: KotlinJvmBinaryPackageSourceElement.kt */
public final class KotlinJvmBinaryPackageSourceElement implements SourceElement {
    public final LazyJavaPackageFragment f32825b;

    public KotlinJvmBinaryPackageSourceElement(LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.m26847b(lazyJavaPackageFragment, "packageFragment");
        this.f32825b = lazyJavaPackageFragment;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f32825b);
        stringBuilder.append(": ");
        stringBuilder.append(this.f32825b.m42680b().keySet());
        return stringBuilder.toString();
    }

    public final SourceFile mo5713a() {
        Object obj = SourceFile.f25499a;
        Intrinsics.m26843a(obj, "SourceFile.NO_SOURCE_FILE");
        return obj;
    }
}
