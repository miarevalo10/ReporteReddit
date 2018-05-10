package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: typeEnhancement.kt */
final class Result$typeIfChanged$1 extends Lambda implements Function1<KotlinType, Boolean> {
    final /* synthetic */ Result f38749a;

    Result$typeIfChanged$1(Result result) {
        this.f38749a = result;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((KotlinType) obj, "it");
        return Boolean.valueOf(this.f38749a.f25759b);
    }
}
