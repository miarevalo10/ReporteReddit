package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: CapturedTypeApproximation.kt */
final class C3004x21acc51c extends Lambda implements Function1<UnwrappedType, Boolean> {
    public static final C3004x21acc51c f38947a = new C3004x21acc51c();

    C3004x21acc51c() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(CapturedTypeConstructorKt.m27712a((KotlinType) (UnwrappedType) obj));
    }
}
