package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* compiled from: DeserializedDescriptorResolver.kt */
final class DeserializedDescriptorResolver$readData$1 extends Lambda implements Function1<String[], Boolean> {
    final /* synthetic */ Set f38767a;
    final /* synthetic */ KotlinClassHeader f38768b;

    DeserializedDescriptorResolver$readData$1(Set set, KotlinClassHeader kotlinClassHeader) {
        this.f38767a = set;
        this.f38768b = kotlinClassHeader;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((String[]) obj, "it");
        return Boolean.valueOf(this.f38767a.contains(this.f38768b.f25837a));
    }
}
