package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$extractQualifiersFromAnnotations$4 extends Lambda implements Function1<FqName, NullabilityQualifier> {
    final /* synthetic */ KotlinType f38764a;

    TypeQualifiersKt$extractQualifiersFromAnnotations$4(KotlinType kotlinType) {
        this.f38764a = kotlinType;
        super(1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier m38530a(kotlin.reflect.jvm.internal.impl.name.FqName r3) {
        /*
        r2 = this;
        r0 = "$receiver";
        kotlin.jvm.internal.Intrinsics.m26847b(r3, r0);
        r0 = r2.f38764a;
        r0 = r0.mo5718q();
        r3 = r0.mo6679a(r3);
        r0 = 0;
        if (r3 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r3 = r3.mo5720b();
        r3 = r3.values();
        r3 = (java.lang.Iterable) r3;
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.m41442i(r3);
        r3 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r3;
        if (r3 == 0) goto L_0x004b;
    L_0x0025:
        r3 = r3.mo5919b();
        if (r3 == 0) goto L_0x004b;
    L_0x002b:
        r1 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        if (r1 != 0) goto L_0x0030;
    L_0x002f:
        goto L_0x0047;
    L_0x0030:
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3;
        r3 = r3.mo6689i();
        r3 = r3.m27429a();
        r0 = "ALWAYS";
        r3 = kotlin.jvm.internal.Intrinsics.m26845a(r3, r0);
        if (r3 == 0) goto L_0x0045;
    L_0x0042:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.f25748b;
        goto L_0x0047;
    L_0x0045:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.f25747a;
    L_0x0047:
        r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier) r0;
        if (r0 != 0) goto L_0x004d;
    L_0x004b:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.f25748b;
    L_0x004d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$extractQualifiersFromAnnotations$4.a(kotlin.reflect.jvm.internal.impl.name.FqName):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier");
    }
}
