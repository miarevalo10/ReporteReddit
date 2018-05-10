package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$computeValueArguments$1 extends Lambda implements Function1<ValueParameterDescriptor, ConstantValue<?>> {
    final /* synthetic */ LazyJavaAnnotationDescriptor f38378a;
    final /* synthetic */ Map f38379b;

    LazyJavaAnnotationDescriptor$computeValueArguments$1(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor, Map map) {
        this.f38378a = lazyJavaAnnotationDescriptor;
        this.f38379b = map;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
        JavaAnnotationArgument javaAnnotationArgument = (JavaAnnotationArgument) this.f38379b.get(valueParameterDescriptor.mo6689i());
        if (javaAnnotationArgument == null && Intrinsics.m26845a(valueParameterDescriptor.mo6689i(), JvmAnnotationNames.f25632c) != null) {
            javaAnnotationArgument = (JavaAnnotationArgument) this.f38379b.get(null);
        }
        return this.f38378a.m33053a(javaAnnotationArgument);
    }
}
