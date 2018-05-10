package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* compiled from: LazyJavaClassMemberScope.kt */
final class C2940xcbdbac88 extends Lambda implements Function1<SimpleFunctionDescriptor, Boolean> {
    final /* synthetic */ SimpleFunctionDescriptor f38397a;
    final /* synthetic */ PropertyDescriptor f38398b;

    C2940xcbdbac88(SimpleFunctionDescriptor simpleFunctionDescriptor, PropertyDescriptor propertyDescriptor) {
        this.f38397a = simpleFunctionDescriptor;
        this.f38398b = propertyDescriptor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(KotlinTypeChecker.f26349a.mo5936b(((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(this.f38397a.mo7757k())).mo7777x(), this.f38398b.mo7777x()));
    }
}
