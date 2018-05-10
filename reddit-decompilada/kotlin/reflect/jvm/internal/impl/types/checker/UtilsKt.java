package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* compiled from: utils.kt */
public final class UtilsKt {
    public static final KotlinType m28059a(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        Intrinsics.m26847b(kotlinType, "subtype");
        Intrinsics.m26847b(kotlinType2, "supertype");
        Intrinsics.m26847b(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new SubtypePathNode(kotlinType, null));
        TypeConstructor g = kotlinType2.mo6743g();
        while (arrayDeque.isEmpty() == null) {
            SubtypePathNode subtypePathNode = (SubtypePathNode) arrayDeque.poll();
            KotlinType kotlinType3 = subtypePathNode.f26353a;
            TypeConstructor g2 = kotlinType3.mo6743g();
            if (typeCheckingProcedureCallbacks.mo5941a(g2, g)) {
                boolean c = kotlinType3.mo6741c();
                for (kotlinType2 = subtypePathNode.f26354b; kotlinType2 != null; kotlinType2 = kotlinType2.f26354b) {
                    int i;
                    KotlinType kotlinType4 = kotlinType2.f26353a;
                    for (TypeProjection b : kotlinType4.mo6739a()) {
                        if ((Intrinsics.m26845a(b.mo6735b(), Variance.f26337a) ^ 1) != 0) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    Companion companion;
                    if (i != 0) {
                        companion = TypeConstructorSubstitution.f33074b;
                        kotlinType3 = (KotlinType) CapturedTypeApproximationKt.m28072a(CapturedTypeConstructorKt.m27711a(Companion.m27970a(kotlinType4)).m27987d().m28002a(kotlinType3, Variance.f26337a)).f26369b;
                    } else {
                        companion = TypeConstructorSubstitution.f33074b;
                        kotlinType3 = Companion.m27970a(kotlinType4).m27987d().m28002a(kotlinType3, Variance.f26337a);
                        Intrinsics.m26843a((Object) kotlinType3, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                    }
                    if (!c) {
                        if (!kotlinType4.mo6741c()) {
                            c = false;
                        }
                    }
                    c = true;
                }
                TypeConstructor g3 = kotlinType3.mo6743g();
                if (typeCheckingProcedureCallbacks.mo5941a(g3, g)) {
                    return TypeUtils.m28007a(kotlinType3, c);
                }
                StringBuilder stringBuilder = new StringBuilder("Type constructors should be equals!\n");
                StringBuilder stringBuilder2 = new StringBuilder("substitutedSuperType: ");
                stringBuilder2.append(m28058a(g3));
                stringBuilder2.append(", \n\n");
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("supertype: ");
                stringBuilder2.append(m28058a(g));
                stringBuilder2.append(" \n");
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append(typeCheckingProcedureCallbacks.mo5941a(g3, g));
                throw new AssertionError(stringBuilder.toString());
            }
            for (Object obj : g2.aL_()) {
                Intrinsics.m26843a(obj, "immediateSupertype");
                arrayDeque.add(new SubtypePathNode(obj, subtypePathNode));
            }
        }
        return null;
    }

    private static final String m28058a(TypeConstructor typeConstructor) {
        StringBuilder stringBuilder = new StringBuilder();
        UtilsKt$debugInfo$1$1 utilsKt$debugInfo$1$1 = new UtilsKt$debugInfo$1$1(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder("type: ");
        stringBuilder2.append(typeConstructor);
        utilsKt$debugInfo$1$1.m38707a(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder("hashCode: ");
        stringBuilder2.append(typeConstructor.hashCode());
        utilsKt$debugInfo$1$1.m38707a(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder("javaClass: ");
        stringBuilder2.append(typeConstructor.getClass().getCanonicalName());
        utilsKt$debugInfo$1$1.m38707a(stringBuilder2.toString());
        for (DeclarationDescriptor c = typeConstructor.mo5724c(); c != null; c = c.aD_()) {
            stringBuilder2 = new StringBuilder("fqName: ");
            stringBuilder2.append(DescriptorRenderer.f26012e.mo5890a(c));
            utilsKt$debugInfo$1$1.m38707a(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("javaClass: ");
            stringBuilder2.append(c.getClass().getCanonicalName());
            utilsKt$debugInfo$1$1.m38707a(stringBuilder2.toString());
        }
        Object stringBuilder3 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder3;
    }
}
