package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: typeEnhancement.kt */
public final class TypeEnhancementKt {
    private static final EnhancedTypeAnnotations f25778a;
    private static final EnhancedTypeAnnotations f25779b;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25776a;
        public static final /* synthetic */ int[] f25777b;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            f25776a = iArr;
            iArr[MutabilityQualifier.f25744a.ordinal()] = 1;
            f25776a[MutabilityQualifier.f25745b.ordinal()] = 2;
            iArr = new int[NullabilityQualifier.values().length];
            f25777b = iArr;
            iArr[NullabilityQualifier.f25747a.ordinal()] = 1;
            f25777b[NullabilityQualifier.f25748b.ordinal()] = 2;
        }
    }

    public static final KotlinType m27277a(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> function1) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        Intrinsics.m26847b(function1, "qualifiers");
        kotlinType = m27275a(kotlinType.mo6738h(), function1, 0);
        return (KotlinType) AddToStdlibKt.m28126a(kotlinType.mo5801a(), new Result$typeIfChanged$1(kotlinType));
    }

    public static final boolean m27279a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        kotlinType = kotlinType.mo5718q();
        Object obj = JvmAnnotationNames.f25638i;
        Intrinsics.m26843a(obj, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        return kotlinType.mo6679a(obj) != null ? true : null;
    }

    private static final Result m27275a(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i) {
        boolean z = false;
        if (unwrappedType.mo6742d()) {
            return new Result(unwrappedType, 1, false);
        }
        if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            Result a = m27276a(flexibleType.f38926a, function1, i, TypeComponentPosition.f25771a);
            function1 = m27276a(flexibleType.f38927b, function1, i, TypeComponentPosition.f25772b);
            i = a.f25758a == function1.f25758a ? 1 : 0;
            if (_Assertions.f25274a && i == 0) {
                unwrappedType = new StringBuilder("Different tree sizes of bounds: ");
                i = new StringBuilder("lower = (");
                i.append(flexibleType.f38926a);
                i.append(", ");
                i.append(a.f25758a);
                i.append("), ");
                unwrappedType.append(i.toString());
                i = new StringBuilder("upper = (");
                i.append(flexibleType.f38927b);
                i.append(", ");
                i.append(function1.f25758a);
                i.append(")");
                unwrappedType.append(i.toString());
                throw ((Throwable) new AssertionError(unwrappedType.toString()));
            }
            if (!(a.f25759b == 0 && function1.f25759b == 0)) {
                z = true;
            }
            if (z) {
                if ((unwrappedType instanceof RawTypeImpl) != null) {
                    unwrappedType = new RawTypeImpl(a.f32760c, function1.f32760c);
                } else {
                    unwrappedType = KotlinTypeFactory.m27953a(a.f32760c, function1.f32760c);
                }
            }
            return new Result(unwrappedType, a.f25758a, z);
        } else if (unwrappedType instanceof SimpleType) {
            return m27276a((SimpleType) unwrappedType, function1, i, TypeComponentPosition.f25773c);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult m27276a(kotlin.reflect.jvm.internal.impl.types.SimpleType r19, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r20, int r21, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r22) {
        /*
        r0 = r19;
        r1 = r20;
        r3 = r22;
        r4 = m27278a(r22);
        r5 = 0;
        r6 = 1;
        if (r4 != 0) goto L_0x001e;
    L_0x000e:
        r4 = r19.mo6739a();
        r4 = r4.isEmpty();
        if (r4 == 0) goto L_0x001e;
    L_0x0018:
        r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult;
        r1.<init>(r0, r6, r5);
        return r1;
    L_0x001e:
        r4 = r19.mo6743g();
        r4 = r4.mo5724c();
        if (r4 != 0) goto L_0x002e;
    L_0x0028:
        r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult;
        r1.<init>(r0, r6, r5);
        return r1;
    L_0x002e:
        r7 = java.lang.Integer.valueOf(r21);
        r7 = r1.mo6492a(r7);
        r7 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r7;
        r8 = m27278a(r22);
        r9 = 3;
        r10 = 2;
        if (r8 == 0) goto L_0x00c4;
    L_0x0040:
        r8 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        if (r8 == 0) goto L_0x00c4;
    L_0x0044:
        r8 = kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap.f25878a;
        r11 = r7.f25742b;
        if (r11 != 0) goto L_0x004c;
    L_0x004a:
        goto L_0x00c4;
    L_0x004c:
        r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.WhenMappings.f25776a;
        r11 = r11.ordinal();
        r11 = r12[r11];
        switch(r11) {
            case 1: goto L_0x0072;
            case 2: goto L_0x0058;
            default: goto L_0x0057;
        };
    L_0x0057:
        goto L_0x00c4;
    L_0x0058:
        r11 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.f25772b;
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r3, r11);
        if (r11 == 0) goto L_0x00c4;
    L_0x0060:
        r11 = r4;
        r11 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r11;
        r12 = r8.m27445b(r11);
        if (r12 == 0) goto L_0x00c4;
    L_0x0069:
        r4 = r8.m27446c(r11);
        r4 = m27281c(r4);
        goto L_0x00c8;
    L_0x0072:
        r11 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.f25771a;
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r3, r11);
        if (r11 == 0) goto L_0x00c4;
    L_0x007a:
        r11 = r4;
        r11 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r11;
        r12 = r8.m27444a(r11);
        if (r12 == 0) goto L_0x00c4;
    L_0x0083:
        if (r11 != 0) goto L_0x009f;
    L_0x0085:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r2 = new java.lang.Object[r9];
        r3 = "mutable";
        r2[r5] = r3;
        r3 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r2[r6] = r3;
        r3 = "convertMutableToReadOnly";
        r2[r10] = r3;
        r1 = java.lang.String.format(r1, r2);
        r0.<init>(r1);
        throw r0;
    L_0x009f:
        r4 = r8.f25880b;
        r8 = "mutable";
        r4 = kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap.m27434a(r11, r4, r8);
        if (r4 != 0) goto L_0x00bf;
    L_0x00a9:
        r0 = new java.lang.IllegalStateException;
        r1 = "@NotNull method %s.%s must not return null";
        r2 = new java.lang.Object[r10];
        r3 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r2[r5] = r3;
        r3 = "convertMutableToReadOnly";
        r2[r6] = r3;
        r1 = java.lang.String.format(r1, r2);
        r0.<init>(r1);
        throw r0;
    L_0x00bf:
        r4 = m27281c(r4);
        goto L_0x00c8;
    L_0x00c4:
        r4 = m27274a(r4);
    L_0x00c8:
        r8 = r4.f25737a;
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r8;
        r4 = r4.f25738b;
        r11 = r8.mo7610c();
        r12 = new kotlin.jvm.internal.Ref$IntRef;
        r12.<init>();
        r13 = r21 + 1;
        r12.f25290a = r13;
        r13 = new kotlin.jvm.internal.Ref$BooleanRef;
        r13.<init>();
        if (r4 == 0) goto L_0x00e4;
    L_0x00e2:
        r14 = r6;
        goto L_0x00e5;
    L_0x00e4:
        r14 = r5;
    L_0x00e5:
        r13.f25288a = r14;
        r14 = r19.mo6739a();
        r14 = (java.lang.Iterable) r14;
        r15 = new java.util.ArrayList;
        r10 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r14);
        r15.<init>(r10);
        r15 = (java.util.Collection) r15;
        r10 = r14.iterator();
        r14 = r5;
    L_0x00fd:
        r16 = r10.hasNext();
        if (r16 == 0) goto L_0x0174;
    L_0x0103:
        r16 = r10.next();
        r17 = r14 + 1;
        r9 = r16;
        r9 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r9;
        r16 = r9.mo6734a();
        if (r16 == 0) goto L_0x012b;
    L_0x0113:
        r9 = r12.f25290a;
        r9 = r9 + r6;
        r12.f25290a = r9;
        r9 = r8.mo7610c();
        r9 = r9.mo5723b();
        r9 = r9.get(r14);
        r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9;
        r9 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.m28009a(r9);
        goto L_0x0169;
    L_0x012b:
        r6 = r9.mo6736c();
        r6 = r6.mo6738h();
        r5 = r12.f25290a;
        r5 = m27275a(r6, r1, r5);
        r6 = r13.f25288a;
        if (r6 != 0) goto L_0x0144;
    L_0x013d:
        r6 = r5.f25759b;
        if (r6 == 0) goto L_0x0142;
    L_0x0141:
        goto L_0x0144;
    L_0x0142:
        r6 = 0;
        goto L_0x0145;
    L_0x0144:
        r6 = 1;
    L_0x0145:
        r13.f25288a = r6;
        r6 = r12.f25290a;
        r1 = r5.f25758a;
        r6 = r6 + r1;
        r12.f25290a = r6;
        r1 = r5.mo5801a();
        r5 = r9.mo6735b();
        r6 = "arg.projectionKind";
        kotlin.jvm.internal.Intrinsics.m26843a(r5, r6);
        r6 = r11.mo5723b();
        r6 = r6.get(r14);
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r6;
        r9 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.m28063a(r1, r5, r6);
    L_0x0169:
        r15.add(r9);
        r14 = r17;
        r1 = r20;
        r5 = 0;
        r6 = 1;
        r9 = 3;
        goto L_0x00fd;
    L_0x0174:
        r15 = (java.util.List) r15;
        r1 = r0;
        r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1;
        r3 = m27278a(r22);
        if (r3 == 0) goto L_0x01a4;
    L_0x017f:
        r3 = r7.f25741a;
        if (r3 != 0) goto L_0x0184;
    L_0x0183:
        goto L_0x01a4;
    L_0x0184:
        r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.WhenMappings.f25777b;
        r3 = r3.ordinal();
        r3 = r5[r3];
        switch(r3) {
            case 1: goto L_0x019a;
            case 2: goto L_0x0190;
            default: goto L_0x018f;
        };
    L_0x018f:
        goto L_0x01a4;
    L_0x0190:
        r3 = 0;
        r1 = java.lang.Boolean.valueOf(r3);
        r1 = m27280b(r1);
        goto L_0x01b0;
    L_0x019a:
        r1 = 1;
        r3 = java.lang.Boolean.valueOf(r1);
        r1 = m27280b(r3);
        goto L_0x01b0;
    L_0x01a4:
        r1 = r1.mo6741c();
        r1 = java.lang.Boolean.valueOf(r1);
        r1 = m27274a(r1);
    L_0x01b0:
        r3 = r1.f25737a;
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        r1 = r1.f25738b;
        r5 = r13.f25288a;
        if (r5 != 0) goto L_0x01c3;
    L_0x01be:
        if (r1 == 0) goto L_0x01c1;
    L_0x01c0:
        goto L_0x01c3;
    L_0x01c1:
        r5 = 0;
        goto L_0x01c4;
    L_0x01c3:
        r5 = 1;
    L_0x01c4:
        r13.f25288a = r5;
        r5 = r12.f25290a;
        r5 = r5 - r21;
        r2 = r13.f25288a;
        if (r2 != 0) goto L_0x01d5;
    L_0x01ce:
        r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult;
        r2 = 0;
        r1.<init>(r0, r5, r2);
        return r1;
    L_0x01d5:
        r2 = 0;
        r6 = 3;
        r6 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[r6];
        r0 = r19.mo5718q();
        r6[r2] = r0;
        r0 = 1;
        r6[r0] = r4;
        r0 = 2;
        r6[r0] = r1;
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.m26796b(r6);
        r0 = (java.lang.Iterable) r0;
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.m41446k(r0);
        r1 = r0.size();
        switch(r1) {
            case 0: goto L_0x020c;
            case 1: goto L_0x0205;
            default: goto L_0x01f6;
        };
    L_0x01f6:
        r1 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
        r0 = (java.util.Collection) r0;
        r0 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.m28089a(r0);
        r1.<init>(r0);
        r0 = r1;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r0;
        goto L_0x021a;
    L_0x0205:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.m41441h(r0);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r0;
        goto L_0x021a;
    L_0x020c:
        r0 = "At least one Annotations object expected";
        r1 = new java.lang.IllegalStateException;
        r0 = r0.toString();
        r1.<init>(r0);
        r1 = (java.lang.Throwable) r1;
        throw r1;
    L_0x021a:
        r1 = "typeConstructor";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r1);
        r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.m27951a(r0, r11, r15, r3);
        r1 = r7.f25743c;
        if (r1 == 0) goto L_0x0230;
    L_0x0228:
        r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter;
        r1.<init>(r0);
        r0 = r1;
        r0 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r0;
    L_0x0230:
        r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult;
        r2 = 1;
        r1.<init>(r0, r5, r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.a(kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.jvm.functions.Function1, int, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult");
    }

    private static final boolean m27278a(TypeComponentPosition typeComponentPosition) {
        return Intrinsics.m26845a((Object) typeComponentPosition, TypeComponentPosition.f25773c) ^ 1;
    }

    private static final <T> EnhancementResult<T> m27274a(T t) {
        return new EnhancementResult(t, null);
    }

    private static final <T> EnhancementResult<T> m27280b(T t) {
        return new EnhancementResult(t, f25778a);
    }

    private static final <T> EnhancementResult<T> m27281c(T t) {
        return new EnhancementResult(t, f25779b);
    }

    static {
        Object obj = JvmAnnotationNames.f25638i;
        Intrinsics.m26843a(obj, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        f25778a = new EnhancedTypeAnnotations(obj);
        obj = JvmAnnotationNames.f25639j;
        Intrinsics.m26843a(obj, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        f25779b = new EnhancedTypeAnnotations(obj);
    }
}
