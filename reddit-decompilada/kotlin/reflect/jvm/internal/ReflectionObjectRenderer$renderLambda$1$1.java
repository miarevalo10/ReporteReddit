package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/jetbrains/kotlin/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: ReflectionObjectRenderer.kt */
final class ReflectionObjectRenderer$renderLambda$1$1 extends Lambda implements Function1<ValueParameterDescriptor, String> {
    public static final ReflectionObjectRenderer$renderLambda$1$1 f38312a = new ReflectionObjectRenderer$renderLambda$1$1();

    ReflectionObjectRenderer$renderLambda$1$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f25341a;
        KotlinType x = valueParameterDescriptor.mo7777x();
        Intrinsics.m26843a((Object) x, "it.type");
        return ReflectionObjectRenderer.m26924a(x);
    }
}
