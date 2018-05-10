package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver {
    private final LazyJavaResolverContext f25720a;
    private final TypeParameterResolver f25721b;

    public JavaTypeResolver(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(typeParameterResolver, "typeParameterResolver");
        this.f25720a = lazyJavaResolverContext;
        this.f25721b = typeParameterResolver;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.types.KotlinType m27225a(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r11, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r12) {
        /*
        r10 = this;
        r0 = "javaType";
        kotlin.jvm.internal.Intrinsics.m26847b(r11, r0);
        r0 = "attr";
        kotlin.jvm.internal.Intrinsics.m26847b(r12, r0);
        r0 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
        if (r0 == 0) goto L_0x003b;
    L_0x000e:
        r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType) r11;
        r11 = r11.mo6714a();
        if (r11 == 0) goto L_0x0025;
    L_0x0016:
        r12 = r10.f25720a;
        r12 = r12.f25703b;
        r12 = r12.f25700p;
        r12 = r12.mo7089b();
        r11 = r12.m27001a(r11);
        goto L_0x0033;
    L_0x0025:
        r11 = r10.f25720a;
        r11 = r11.f25703b;
        r11 = r11.f25700p;
        r11 = r11.mo7089b();
        r11 = r11.m27026x();
    L_0x0033:
        r12 = "if (primitiveType != nul….module.builtIns.unitType";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r12);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        return r11;
    L_0x003b:
        r0 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
        r1 = 0;
        if (r0 == 0) goto L_0x00c9;
    L_0x0040:
        r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) r11;
        r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$transformJavaClassifierType$1;
        r0.<init>(r11);
        r2 = r12.mo5790e();
        r8 = 1;
        if (r2 == 0) goto L_0x005d;
    L_0x004e:
        r2 = r12.mo5786a();
        r3 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE;
        r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r3);
        r2 = r2 ^ r8;
        if (r2 == 0) goto L_0x005d;
    L_0x005b:
        r6 = r8;
        goto L_0x005e;
    L_0x005d:
        r6 = r1;
    L_0x005e:
        r7 = r11.mo7095d();
        r2 = r11.mo7095d();
        if (r2 != 0) goto L_0x0081;
    L_0x0068:
        if (r6 != 0) goto L_0x0081;
    L_0x006a:
        r11 = r10.m27222a(r11, r12);
        if (r11 == 0) goto L_0x0073;
    L_0x0070:
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        return r11;
    L_0x0073:
        r0 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$transformJavaClassifierType$1) r0;
        r11 = r0.m38407a();
        r12 = "errorType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r12);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        return r11;
    L_0x0081:
        r9 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$transformJavaClassifierType$2;
        r2 = r9;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r2.<init>(r3, r4, r5, r6, r7);
        r9 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$transformJavaClassifierType$2) r9;
        r12 = r9.m38409a(r8);
        if (r12 != 0) goto L_0x00a0;
    L_0x0092:
        r0 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$transformJavaClassifierType$1) r0;
        r11 = r0.m38407a();
        r12 = "errorType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r12);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        return r11;
    L_0x00a0:
        r1 = r9.m38409a(r1);
        if (r1 != 0) goto L_0x00b4;
    L_0x00a6:
        r0 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$transformJavaClassifierType$1) r0;
        r11 = r0.m38407a();
        r12 = "errorType()";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r12);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        return r11;
    L_0x00b4:
        r11 = r11.mo7095d();
        if (r11 == 0) goto L_0x00c2;
    L_0x00ba:
        r11 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
        r11.<init>(r12, r1);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        return r11;
    L_0x00c2:
        r11 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.m27953a(r12, r1);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        return r11;
    L_0x00c9:
        r0 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
        if (r0 == 0) goto L_0x00d4;
    L_0x00cd:
        r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType) r11;
        r11 = r10.m27224a(r11, r12, r1);
        return r11;
    L_0x00d4:
        r0 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
        if (r0 == 0) goto L_0x0100;
    L_0x00d8:
        r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType) r11;
        r11 = r11.mo6715a();
        if (r11 == 0) goto L_0x00ea;
    L_0x00e0:
        r11 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r11;
        r11 = r10.m27225a(r11, r12);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
        if (r11 != 0) goto L_0x00ff;
    L_0x00ea:
        r11 = r10.f25720a;
        r11 = r11.f25703b;
        r11 = r11.f25700p;
        r11 = r11.mo7089b();
        r11 = r11.m27017o();
        r12 = "c.module.builtIns.defaultBound";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r12);
        r11 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r11;
    L_0x00ff:
        return r11;
    L_0x0100:
        r12 = new java.lang.UnsupportedOperationException;
        r0 = new java.lang.StringBuilder;
        r1 = "Unsupported type: ";
        r0.<init>(r1);
        r0.append(r11);
        r11 = r0.toString();
        r12.<init>(r11);
        r12 = (java.lang.Throwable) r12;
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.a(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    public final KotlinType m27224a(JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z) {
        Intrinsics.m26847b(javaArrayType, "arrayType");
        Intrinsics.m26847b(javaTypeAttributes, "attr");
        JavaTypeResolver javaTypeResolver = this;
        JavaType a = javaArrayType.mo6706a();
        JavaPrimitiveType javaPrimitiveType = (JavaPrimitiveType) (!(a instanceof JavaPrimitiveType) ? null : a);
        Object a2 = javaPrimitiveType != null ? javaPrimitiveType.mo6714a() : null;
        if (a2 != null) {
            javaArrayType = javaTypeResolver.f25720a.f25703b.f25700p.mo7089b();
            if (a2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"primitiveType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveArrayKotlinType"}));
            }
            Object obj = (SimpleType) ((Primitives) javaArrayType.f25423h.invoke()).f25410a.get(a2);
            if (obj == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveArrayKotlinType"}));
            } else if (javaTypeAttributes.mo5790e()) {
                Intrinsics.m26843a(obj, "jetType");
                javaArrayType = KotlinTypeFactory.m27953a(obj, obj.mo7297b(true));
            } else {
                javaArrayType = obj.mo7297b(javaTypeAttributes.mo5788c() ^ true);
            }
        } else {
            KotlinType a3 = m27225a(a, JavaTypeResolverKt.m27226a(TypeUsage.TYPE_ARGUMENT, javaTypeAttributes.mo5790e(), javaTypeAttributes.mo5792g(), null, 4));
            if (javaTypeAttributes.mo5790e()) {
                Object a4 = javaTypeResolver.f25720a.f25703b.f25700p.mo7089b().m27002a(Variance.f26337a, a3);
                Intrinsics.m26843a(a4, "c.module.builtIns.getArr…INVARIANT, componentType)");
                javaArrayType = KotlinTypeFactory.m27953a(a4, javaTypeResolver.f25720a.f25703b.f25700p.mo7089b().m27002a(Variance.f26339c, a3).mo7297b(true));
            } else {
                Variance variance;
                if (!Intrinsics.m26845a(javaTypeAttributes.mo5786a(), TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT)) {
                    if (!z) {
                        variance = Variance.f26337a;
                        javaArrayType = javaTypeResolver.f25720a.f25703b.f25700p.mo7089b().m27002a(variance, a3).mo7297b(javaTypeAttributes.mo5788c() ^ true);
                    }
                }
                variance = Variance.f26339c;
                javaArrayType = javaTypeResolver.f25720a.f25703b.f25700p.mo7089b().m27002a(variance, a3).mo7297b(javaTypeAttributes.mo5788c() ^ true);
            }
        }
        return ((UnwrappedType) javaArrayType).mo7271a(javaTypeAttributes.mo5791f());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType m27222a(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r12, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r13) {
        /*
        r11 = this;
        r0 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
        r1 = 2;
        r2 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[r1];
        r3 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
        r4 = r11.f25720a;
        r5 = r12;
        r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r5;
        r3.<init>(r4, r5);
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r3;
        r4 = 0;
        r2[r4] = r3;
        r3 = r13.mo5791f();
        r5 = 1;
        r2[r5] = r3;
        r2 = kotlin.collections.CollectionsKt__CollectionsKt.m26796b(r2);
        r0.<init>(r2);
        r2 = r12.mo7093b();
        r3 = 3;
        r6 = 0;
        if (r2 != 0) goto L_0x0030;
    L_0x002a:
        r2 = r11.m27223a(r12);
        goto L_0x015f;
    L_0x0030:
        r7 = r2 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
        if (r7 == 0) goto L_0x014b;
    L_0x0034:
        r7 = r2;
        r7 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) r7;
        r8 = r7.mo7274b();
        if (r8 != 0) goto L_0x0053;
    L_0x003d:
        r12 = new java.lang.AssertionError;
        r13 = new java.lang.StringBuilder;
        r0 = "Class type should have a FQ name: ";
        r13.<init>(r0);
        r13.append(r2);
        r13 = r13.toString();
        r12.<init>(r13);
        r12 = (java.lang.Throwable) r12;
        throw r12;
    L_0x0053:
        r8 = (kotlin.reflect.jvm.internal.impl.name.FqName) r8;
        r2 = r13.mo5792g();
        if (r2 == 0) goto L_0x0075;
    L_0x005b:
        r2 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.f25722a;
        r2 = kotlin.jvm.internal.Intrinsics.m26845a(r8, r2);
        if (r2 == 0) goto L_0x0075;
    L_0x0065:
        r2 = r11.f25720a;
        r2 = r2.f25703b;
        r2 = r2.f25701q;
        r8 = kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.f25443b;
        r8 = r8[r5];
        r2 = kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup.m27030a(r2, r8);
        goto L_0x0132;
    L_0x0075:
        r2 = kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap.f25878a;
        r9 = r13.mo5789d();
        r10 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.f25718c;
        r9 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r10);
        if (r9 == 0) goto L_0x0086;
    L_0x0083:
        r9 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.MEMBER_SIGNATURE_COVARIANT;
        goto L_0x00c5;
    L_0x0086:
        r9 = r13.mo5789d();
        r10 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.f25717b;
        r9 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r10);
        if (r9 == 0) goto L_0x0095;
    L_0x0092:
        r9 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT;
        goto L_0x00c5;
    L_0x0095:
        if (r8 != 0) goto L_0x00b1;
    L_0x0097:
        r12 = new java.lang.IllegalArgumentException;
        r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r0 = new java.lang.Object[r3];
        r2 = "fqName";
        r0[r4] = r2;
        r2 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r0[r5] = r2;
        r2 = "isJavaPlatformClass";
        r0[r1] = r2;
        r13 = java.lang.String.format(r13, r0);
        r12.<init>(r13);
        throw r12;
    L_0x00b1:
        r9 = r2.m27442a(r8);
        if (r9 == 0) goto L_0x00b9;
    L_0x00b7:
        r9 = r5;
        goto L_0x00ba;
    L_0x00b9:
        r9 = r4;
    L_0x00ba:
        if (r9 != 0) goto L_0x00c1;
    L_0x00bc:
        r9 = r13.mo5786a();
        goto L_0x00c5;
    L_0x00c1:
        r9 = r13.mo5787b();
    L_0x00c5:
        r10 = r11.f25720a;
        r10 = r10.f25703b;
        r10 = r10.f25700p;
        r10 = r10.mo7089b();
        r8 = r2.m27441a(r8, r10);
        if (r8 != 0) goto L_0x00d7;
    L_0x00d5:
        r2 = r6;
        goto L_0x0132;
    L_0x00d7:
        r10 = r2.m27445b(r8);
        if (r10 == 0) goto L_0x0131;
    L_0x00dd:
        r10 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.MEMBER_SIGNATURE_COVARIANT;
        r10 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r10);
        if (r10 != 0) goto L_0x012c;
    L_0x00e5:
        r10 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE;
        r9 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r10);
        if (r9 != 0) goto L_0x012c;
    L_0x00ed:
        r9 = "kotlinDescriptor";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r9);
        r9 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1.f38437a;
        r9 = r12.mo7094c();
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.m41439g(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r9;
        r9 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1.m38405a(r9);
        if (r9 != 0) goto L_0x0106;
    L_0x0104:
        r9 = r4;
        goto L_0x012a;
    L_0x0106:
        r9 = kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap.f25878a;
        r9 = r9.m27446c(r8);
        r9 = r9.mo7610c();
        r9 = r9.mo5723b();
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.m41439g(r9);
        r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9;
        if (r9 == 0) goto L_0x0104;
    L_0x011c:
        r9 = r9.mo7716k();
        if (r9 != 0) goto L_0x0123;
    L_0x0122:
        goto L_0x0104;
    L_0x0123:
        r10 = kotlin.reflect.jvm.internal.impl.types.Variance.f26339c;
        r9 = kotlin.jvm.internal.Intrinsics.m26845a(r9, r10);
        r9 = r9 ^ r5;
    L_0x012a:
        if (r9 == 0) goto L_0x0131;
    L_0x012c:
        r2 = r2.m27446c(r8);
        goto L_0x0132;
    L_0x0131:
        r2 = r8;
    L_0x0132:
        if (r2 != 0) goto L_0x013e;
    L_0x0134:
        r2 = r11.f25720a;
        r2 = r2.f25703b;
        r2 = r2.f25696l;
        r2 = r2.mo5780a(r7);
    L_0x013e:
        if (r2 == 0) goto L_0x0146;
    L_0x0140:
        r2 = r2.mo7610c();
        if (r2 != 0) goto L_0x015f;
    L_0x0146:
        r2 = r11.m27223a(r12);
        goto L_0x015f;
    L_0x014b:
        r7 = r2 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
        if (r7 == 0) goto L_0x01fe;
    L_0x014f:
        r7 = r11.f25721b;
        r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter) r2;
        r2 = r7.mo5779a(r2);
        if (r2 == 0) goto L_0x015e;
    L_0x0159:
        r2 = r2.mo7610c();
        goto L_0x015f;
    L_0x015e:
        r2 = r6;
    L_0x015f:
        if (r2 != 0) goto L_0x0162;
    L_0x0161:
        return r6;
    L_0x0162:
        r7 = r11.m27220a(r12, r13, r2);
        r8 = r13.mo5789d();
        r9 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.f25718c;
        r8 = kotlin.jvm.internal.Intrinsics.m26845a(r8, r9);
        if (r8 != 0) goto L_0x01f6;
    L_0x0172:
        r8 = r13.mo5789d();
        r9 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility.f25717b;
        r8 = kotlin.jvm.internal.Intrinsics.m26845a(r8, r9);
        if (r8 == 0) goto L_0x0180;
    L_0x017e:
        goto L_0x01f7;
    L_0x0180:
        r8 = r13.mo5788c();
        if (r8 != 0) goto L_0x01f6;
    L_0x0186:
        r8 = r12.mo7093b();
        r9 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
        if (r9 == 0) goto L_0x01af;
    L_0x018e:
        r12 = 4;
        r12 = new kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage[r12];
        r6 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.TYPE_ARGUMENT;
        r12[r4] = r6;
        r6 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.UPPER_BOUND;
        r12[r5] = r6;
        r6 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE_ARGUMENT;
        r12[r1] = r6;
        r1 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE;
        r12[r3] = r1;
        r12 = kotlin.collections.SetsKt__SetsKt.m26802a(r12);
        r13 = r13.mo5786a();
        r12 = r12.contains(r13);
        r12 = r12 ^ r5;
        goto L_0x01f3;
    L_0x01af:
        r9 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
        if (r9 != 0) goto L_0x01d8;
    L_0x01b3:
        r6 = kotlin.jvm.internal.Intrinsics.m26845a(r8, r6);
        if (r6 == 0) goto L_0x01ba;
    L_0x01b9:
        goto L_0x01d8;
    L_0x01ba:
        r13 = new java.lang.StringBuilder;
        r0 = "Unknown classifier: ";
        r13.<init>(r0);
        r12 = r12.mo7093b();
        r13.append(r12);
        r12 = r13.toString();
        r13 = new java.lang.IllegalStateException;
        r12 = r12.toString();
        r13.<init>(r12);
        r13 = (java.lang.Throwable) r13;
        throw r13;
    L_0x01d8:
        r12 = new kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage[r3];
        r3 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.TYPE_ARGUMENT;
        r12[r4] = r3;
        r3 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE_ARGUMENT;
        r12[r5] = r3;
        r3 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE;
        r12[r1] = r3;
        r12 = kotlin.collections.SetsKt__SetsKt.m26802a(r12);
        r13 = r13.mo5786a();
        r12 = r12.contains(r13);
        r12 = r12 ^ r5;
    L_0x01f3:
        if (r12 == 0) goto L_0x01f6;
    L_0x01f5:
        goto L_0x01f7;
    L_0x01f6:
        r5 = r4;
    L_0x01f7:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r0;
        r12 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.m27951a(r0, r2, r7, r5);
        return r12;
    L_0x01fe:
        r12 = new java.lang.IllegalStateException;
        r13 = new java.lang.StringBuilder;
        r0 = "Unknown classifier kind: ";
        r13.<init>(r0);
        r13.append(r2);
        r13 = r13.toString();
        r12.<init>(r13);
        r12 = (java.lang.Throwable) r12;
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.a(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes):kotlin.reflect.jvm.internal.impl.types.SimpleType");
    }

    private final TypeConstructor m27223a(JavaClassifierType javaClassifierType) {
        return this.f25720a.f25703b.f25688d.m27300a().f26239l.m27860b(NotFoundClassesKt.m27233a(javaClassifierType.mo7096e()), CollectionsKt__CollectionsKt.m26791a((Object) Integer.valueOf(0)));
    }

    private List<TypeProjection> m27220a(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        int i;
        List b;
        Iterable<TypeParameterDescriptor> iterable;
        Collection collection;
        Collection collection2;
        int i2;
        JavaType javaType;
        Object obj;
        JavaTypeAttributes a;
        Object typeProjectionImpl;
        JavaType a2;
        int a3;
        Intrinsics.m26847b(javaClassifierType, "javaType");
        Intrinsics.m26847b(javaTypeAttributes, "attr");
        Intrinsics.m26847b(typeConstructor, "constructor");
        if ((Intrinsics.m26845a(javaTypeAttributes.mo5794i(), RawBound.f25725c) ^ 1) == 0) {
            if (!javaClassifierType.mo7094c().isEmpty() || typeConstructor.mo5723b().isEmpty()) {
                i = false;
                b = typeConstructor.mo5723b();
                if (i != 0) {
                    iterable = b;
                    collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                    for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
                        KotlinType a4 = JavaTypeResolverKt.m27230a(typeParameterDescriptor, javaTypeAttributes.mo5793h(), new JavaTypeResolver$computeArguments$$inlined$map$lambda$1(javaTypeAttributes, typeConstructor));
                        RawSubstitution rawSubstitution = RawSubstitution.f32752a;
                        Intrinsics.m26843a((Object) typeParameterDescriptor, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                        collection.add(RawSubstitution.m33091a(typeParameterDescriptor, javaTypeAttributes, a4));
                    }
                    return CollectionsKt.m28089a((Collection) (List) collection);
                } else if (b.size() == javaClassifierType.mo7094c().size()) {
                    iterable = b;
                    collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                    for (TypeParameterDescriptor i3 : iterable) {
                        collection.add(new TypeProjectionImpl(ErrorUtils.m27943c(i3.mo6689i().m27429a())));
                    }
                    return CollectionsKt.m28089a((Collection) (List) collection);
                } else {
                    javaTypeAttributes = Intrinsics.m26845a(javaTypeAttributes.mo5786a(), TypeUsage.SUPERTYPE) == null ? TypeUsage.SUPERTYPE_ARGUMENT : TypeUsage.TYPE_ARGUMENT;
                    JavaClassifierType<IndexedValue> q = CollectionsKt___CollectionsKt.m41452q(javaClassifierType.mo7094c());
                    collection2 = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
                    for (IndexedValue indexedValue : q) {
                        i2 = indexedValue.f25277a;
                        javaType = (JavaType) indexedValue.f25278b;
                        int i4 = i2 >= b.size() ? 1 : false;
                        if (_Assertions.f25274a || i4 != 0) {
                            obj = (TypeParameterDescriptor) b.get(i2);
                            a = JavaTypeResolverKt.m27226a(javaTypeAttributes, false, false, null, 7);
                            Intrinsics.m26843a(obj, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                            if (javaType instanceof JavaWildcardType) {
                                typeProjectionImpl = new TypeProjectionImpl(Variance.f26337a, m27225a(javaType, a));
                            } else {
                                JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
                                a2 = javaWildcardType.mo6715a();
                                typeProjectionImpl = javaWildcardType.mo6716b() ? Variance.f26339c : Variance.f26338b;
                                if (a2 != null) {
                                    if (Intrinsics.m26845a(obj.mo7716k(), Variance.f26337a)) {
                                        a3 = Intrinsics.m26845a(typeProjectionImpl, obj.mo7716k()) ^ 1;
                                    } else {
                                        a3 = 0;
                                    }
                                    if (a3 != 0) {
                                        typeProjectionImpl = TypeUtilsKt.m28063a(m27225a(a2, JavaTypeResolverKt.m27226a(TypeUsage.UPPER_BOUND, false, false, null, 7)), typeProjectionImpl, obj);
                                    }
                                }
                                typeProjectionImpl = JavaTypeResolverKt.m27231a(obj, a);
                            }
                            collection2.add(typeProjectionImpl);
                        } else {
                            javaClassifierType = new StringBuilder("Argument index should be less then type parameters count, but ");
                            javaClassifierType.append(i2);
                            javaClassifierType.append(" > ");
                            javaClassifierType.append(b.size());
                            throw ((Throwable) new AssertionError(javaClassifierType.toString()));
                        }
                    }
                    return CollectionsKt.m28089a((Collection) (List) collection2);
                }
            }
        }
        i = 1;
        b = typeConstructor.mo5723b();
        if (i != 0) {
            iterable = b;
            collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (TypeParameterDescriptor typeParameterDescriptor2 : iterable) {
                KotlinType a42 = JavaTypeResolverKt.m27230a(typeParameterDescriptor2, javaTypeAttributes.mo5793h(), new JavaTypeResolver$computeArguments$$inlined$map$lambda$1(javaTypeAttributes, typeConstructor));
                RawSubstitution rawSubstitution2 = RawSubstitution.f32752a;
                Intrinsics.m26843a((Object) typeParameterDescriptor2, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                collection.add(RawSubstitution.m33091a(typeParameterDescriptor2, javaTypeAttributes, a42));
            }
            return CollectionsKt.m28089a((Collection) (List) collection);
        } else if (b.size() == javaClassifierType.mo7094c().size()) {
            if (Intrinsics.m26845a(javaTypeAttributes.mo5786a(), TypeUsage.SUPERTYPE) == null) {
            }
            JavaClassifierType<IndexedValue> q2 = CollectionsKt___CollectionsKt.m41452q(javaClassifierType.mo7094c());
            collection2 = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(q2));
            for (IndexedValue indexedValue2 : q2) {
                i2 = indexedValue2.f25277a;
                javaType = (JavaType) indexedValue2.f25278b;
                if (i2 >= b.size()) {
                }
                if (_Assertions.f25274a) {
                }
                obj = (TypeParameterDescriptor) b.get(i2);
                a = JavaTypeResolverKt.m27226a(javaTypeAttributes, false, false, null, 7);
                Intrinsics.m26843a(obj, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                if (javaType instanceof JavaWildcardType) {
                    typeProjectionImpl = new TypeProjectionImpl(Variance.f26337a, m27225a(javaType, a));
                } else {
                    JavaWildcardType javaWildcardType2 = (JavaWildcardType) javaType;
                    a2 = javaWildcardType2.mo6715a();
                    if (javaWildcardType2.mo6716b()) {
                    }
                    if (a2 != null) {
                        if (Intrinsics.m26845a(obj.mo7716k(), Variance.f26337a)) {
                            a3 = Intrinsics.m26845a(typeProjectionImpl, obj.mo7716k()) ^ 1;
                        } else {
                            a3 = 0;
                        }
                        if (a3 != 0) {
                            typeProjectionImpl = TypeUtilsKt.m28063a(m27225a(a2, JavaTypeResolverKt.m27226a(TypeUsage.UPPER_BOUND, false, false, null, 7)), typeProjectionImpl, obj);
                        }
                    }
                    typeProjectionImpl = JavaTypeResolverKt.m27231a(obj, a);
                }
                collection2.add(typeProjectionImpl);
            }
            return CollectionsKt.m28089a((Collection) (List) collection2);
        } else {
            iterable = b;
            collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            while (javaTypeAttributes.hasNext() != null) {
                collection.add(new TypeProjectionImpl(ErrorUtils.m27943c(i3.mo6689i().m27429a())));
            }
            return CollectionsKt.m28089a((Collection) (List) collection);
        }
    }
}
