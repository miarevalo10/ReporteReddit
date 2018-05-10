package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$notConsideredDeprecation$2 extends Lambda implements Function0<AnnotationsImpl> {
    final /* synthetic */ JvmBuiltInsSettings f38779a;

    JvmBuiltInsSettings$notConsideredDeprecation$2(JvmBuiltInsSettings jvmBuiltInsSettings) {
        this.f38779a = jvmBuiltInsSettings;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new AnnotationsImpl(CollectionsKt__CollectionsKt.m26791a((Object) AnnotationUtilKt.m27110a(this.f38779a.f32809j.mo7089b(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version")));
    }
}
