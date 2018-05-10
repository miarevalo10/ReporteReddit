package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* compiled from: LazyJavaClassMemberScope.kt */
final class C2939x40509986 extends Lambda implements Function1<SimpleFunctionDescriptor, Boolean> {
    final /* synthetic */ SimpleFunctionDescriptor f38395a;
    final /* synthetic */ PropertyDescriptor f38396b;

    C2939x40509986(SimpleFunctionDescriptor simpleFunctionDescriptor, PropertyDescriptor propertyDescriptor) {
        this.f38395a = simpleFunctionDescriptor;
        this.f38396b = propertyDescriptor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = KotlinTypeChecker.f26349a;
        KotlinType aN_ = this.f38395a.aN_();
        return Boolean.valueOf(aN_ == null ? null : obj.mo5935a(aN_, this.f38396b.mo7777x()));
    }
}
