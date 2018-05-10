package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: ReflectionTypes.kt */
final class ReflectionTypes$kotlinReflectScope$2 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ ModuleDescriptor f38320a;

    ReflectionTypes$kotlinReflectScope$2(ModuleDescriptor moduleDescriptor) {
        this.f38320a = moduleDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38320a.mo7087a(ReflectionTypesKt.m27032a()).mo7081c();
    }
}
