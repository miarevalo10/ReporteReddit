package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$type$1 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ LazyJavaAnnotationDescriptor f38381a;

    LazyJavaAnnotationDescriptor$type$1(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        this.f38381a = lazyJavaAnnotationDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        FqName fqName = (FqName) this.f38381a.f32721b.invoke();
        if (fqName == null) {
            StringBuilder stringBuilder = new StringBuilder("No fqName: ");
            stringBuilder.append(this.f38381a.f32720a);
            return ErrorUtils.m27943c(stringBuilder.toString());
        }
        ClassDescriptor a = JavaToKotlinClassMap.f25878a.m27441a(fqName, this.f38381a.f32726g.f25703b.f25700p.mo7089b());
        if (a == null) {
            a = this.f38381a.f32726g.f25703b.f25696l.mo5780a(this.f38381a.f32720a.mo6703c());
        }
        if (a == null) {
            LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.f38381a;
            Intrinsics.m26843a((Object) fqName, "fqName");
            a = LazyJavaAnnotationDescriptor.m33051a(lazyJavaAnnotationDescriptor, fqName);
        }
        return a.mo7714h();
    }
}
