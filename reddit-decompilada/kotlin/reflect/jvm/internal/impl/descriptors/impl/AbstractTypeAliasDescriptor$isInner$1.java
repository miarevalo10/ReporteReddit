package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: AbstractTypeAliasDescriptor.kt */
final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    final /* synthetic */ AbstractTypeAliasDescriptor f38332a;

    AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        this.f38332a = abstractTypeAliasDescriptor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        UnwrappedType unwrappedType = (UnwrappedType) obj;
        boolean z = false;
        if (!unwrappedType.mo6742d()) {
            obj = unwrappedType.mo6743g().mo5724c();
            obj = (!(obj instanceof TypeParameterDescriptor) || (Intrinsics.m26845a(((TypeParameterDescriptor) obj).aD_(), (Object) this.f38332a) ^ 1) == null) ? null : 1;
            if (obj != null) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}
