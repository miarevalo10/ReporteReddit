package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public final class AbstractTypeAliasDescriptor$typeConstructor$1 implements TypeConstructor {
    final /* synthetic */ AbstractTypeAliasDescriptor f32644a;

    AbstractTypeAliasDescriptor$typeConstructor$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        this.f32644a = abstractTypeAliasDescriptor;
    }

    public final List<TypeParameterDescriptor> mo5723b() {
        return this.f32644a.mo7811k();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[typealias ");
        stringBuilder.append(this.f32644a.mo6689i().m27429a());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ ClassifierDescriptor mo5724c() {
        return this.f32644a;
    }

    public final Collection<KotlinType> aL_() {
        Object aL_ = this.f32644a.mo7809b().mo6743g().aL_();
        Intrinsics.m26843a(aL_, "declarationDescriptor.un…pe.constructor.supertypes");
        return aL_;
    }

    public final boolean mo5725d() {
        return this.f32644a.mo7809b().mo6743g().mo5725d();
    }

    public final KotlinBuiltIns mo5726e() {
        return DescriptorUtilsKt.m27745d(this.f32644a);
    }
}
