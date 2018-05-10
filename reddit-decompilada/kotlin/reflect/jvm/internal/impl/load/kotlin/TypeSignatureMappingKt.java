package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: typeSignatureMapping.kt */
public final class TypeSignatureMappingKt {
    private static final String f25826a = JvmClassName.m27749a(ClassId.m27396a(DescriptorUtils.f26056e)).m27752a();

    private static final <T> T m27375a(JvmTypeFactory<T> jvmTypeFactory, T t, boolean z) {
        return z ? jvmTypeFactory.mo5833a((Object) t) : t;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T m27377a(kotlin.reflect.jvm.internal.impl.types.KotlinType r7, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> r8, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r9, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration<? extends T> r10, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter<T> r11, kotlin.jvm.functions.Function3<? super kotlin.reflect.jvm.internal.impl.types.KotlinType, ? super T, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.Unit> r12) {
        /*
    L_0x0000:
        r0 = "kotlinType";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r0);
        r0 = "factory";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r0 = "mode";
        kotlin.jvm.internal.Intrinsics.m26847b(r9, r0);
        r0 = "typeMappingConfiguration";
        kotlin.jvm.internal.Intrinsics.m26847b(r10, r0);
        r0 = "writeGenericType";
        kotlin.jvm.internal.Intrinsics.m26847b(r12, r0);
        r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.m26949b(r7);
        if (r0 == 0) goto L_0x0028;
    L_0x0021:
        r7 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.m27034a(r7);
        r7 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r7;
        goto L_0x0000;
    L_0x0028:
        r0 = r7.mo6743g();
        r0 = r0.mo5724c();
        r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        r2 = 0;
        if (r1 != 0) goto L_0x0036;
    L_0x0035:
        r0 = r2;
    L_0x0036:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0;
        r1 = 1;
        r3 = 0;
        if (r0 != 0) goto L_0x003e;
    L_0x003c:
        goto L_0x00bd;
    L_0x003e:
        r4 = kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt.m27033a();
        if (r0 != r4) goto L_0x0051;
    L_0x0044:
        r0 = f25826a;
        r2 = "CONTINUATION_INTERNAL_NAME";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r2 = r8.mo5835b(r0);
        goto L_0x00bd;
    L_0x0051:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r0;
        r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.m27738a(r0);
        r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26976b(r0);
        if (r4 == 0) goto L_0x0083;
    L_0x005d:
        r0 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.m27754a(r4);
        r0 = r0.m27757c();
        r2 = "JvmPrimitiveType.get(primitiveType).desc";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r0 = r8.mo5834a(r0);
        r2 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.m28015d(r7);
        if (r2 != 0) goto L_0x007d;
    L_0x0074:
        r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt.m27279a(r7);
        if (r2 == 0) goto L_0x007b;
    L_0x007a:
        goto L_0x007d;
    L_0x007b:
        r2 = r3;
        goto L_0x007e;
    L_0x007d:
        r2 = r1;
    L_0x007e:
        r2 = m27375a(r8, r0, r2);
        goto L_0x00bd;
    L_0x0083:
        r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26984c(r0);
        if (r4 == 0) goto L_0x00a4;
    L_0x0089:
        r0 = new java.lang.StringBuilder;
        r2 = "[";
        r0.<init>(r2);
        r2 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.m27754a(r4);
        r2 = r2.m27757c();
        r0.append(r2);
        r0 = r0.toString();
        r2 = r8.mo5834a(r0);
        goto L_0x00bd;
    L_0x00a4:
        r4 = kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap.f25878a;
        r0 = r4.m27443a(r0);
        if (r0 == 0) goto L_0x00bd;
    L_0x00ac:
        r0 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.m27750a(r0, r10);
        r0 = r0.m27752a();
        r2 = "JvmClassName.byClassId(c…nfiguration).internalName";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r2 = r8.mo5835b(r0);
    L_0x00bd:
        if (r2 == 0) goto L_0x00c9;
    L_0x00bf:
        r10 = r9.f25819a;
        r8 = m27375a(r8, r2, r10);
        r12.mo6509a(r7, r8, r9);
        return r8;
    L_0x00c9:
        r0 = r7.mo6743g();
        r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
        if (r2 == 0) goto L_0x00e6;
    L_0x00d1:
        r0 = (kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) r0;
        r7 = r0.aL_();
        r0 = "constructor.supertypes";
        kotlin.jvm.internal.Intrinsics.m26843a(r7, r0);
        r7 = r10.mo5839a(r7);
        r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.m28069f(r7);
        goto L_0x0000;
    L_0x00e6:
        r0 = r0.mo5724c();
        if (r0 != 0) goto L_0x0102;
    L_0x00ec:
        r8 = new java.lang.UnsupportedOperationException;
        r9 = new java.lang.StringBuilder;
        r10 = "no descriptor for type constructor of ";
        r9.<init>(r10);
        r9.append(r7);
        r7 = r9.toString();
        r8.<init>(r7);
        r8 = (java.lang.Throwable) r8;
        throw r8;
    L_0x0102:
        r2 = r0;
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2;
        r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.m27938a(r2);
        if (r2 == 0) goto L_0x0126;
    L_0x010b:
        r9 = "error/NonExistentClass";
        r8 = r8.mo5835b(r9);
        if (r0 != 0) goto L_0x011b;
    L_0x0113:
        r7 = new kotlin.TypeCastException;
        r8 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor";
        r7.<init>(r8);
        throw r7;
    L_0x011b:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0;
        r10.mo5840a(r7, r0);
        if (r11 == 0) goto L_0x0125;
    L_0x0122:
        r11.m27315a(r8);
    L_0x0125:
        return r8;
    L_0x0126:
        r2 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        if (r2 == 0) goto L_0x01c0;
    L_0x012a:
        r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26982b(r7);
        if (r4 == 0) goto L_0x01c0;
    L_0x0130:
        r0 = r7.mo6739a();
        r0 = r0.size();
        if (r0 == r1) goto L_0x0144;
    L_0x013a:
        r7 = new java.lang.UnsupportedOperationException;
        r8 = "arrays must have one type argument";
        r7.<init>(r8);
        r7 = (java.lang.Throwable) r7;
        throw r7;
    L_0x0144:
        r7 = r7.mo6739a();
        r7 = r7.get(r3);
        r7 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r7;
        r0 = r7.mo6736c();
        r1 = r7.mo6735b();
        r2 = kotlin.reflect.jvm.internal.impl.types.Variance.f26338b;
        if (r1 != r2) goto L_0x016b;
    L_0x015a:
        r7 = "java/lang/Object";
        r7 = r8.mo5835b(r7);
        if (r11 == 0) goto L_0x01a9;
    L_0x0162:
        r11 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter) r11;
        r11.m27314a();
        r11.m27315a(r7);
        goto L_0x01a9;
    L_0x016b:
        if (r11 == 0) goto L_0x0170;
    L_0x016d:
        r11.m27314a();
    L_0x0170:
        r1 = "memberType";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r7 = r7.mo6735b();
        r1 = "memberProjection.projectionKind";
        kotlin.jvm.internal.Intrinsics.m26843a(r7, r1);
        r1 = "effectiveVariance";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r1);
        r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode.WhenMappings.f25813a;
        r7 = r7.ordinal();
        r7 = r1[r7];
        switch(r7) {
            case 1: goto L_0x019b;
            case 2: goto L_0x0194;
            default: goto L_0x018e;
        };
    L_0x018e:
        r7 = r9.f25821c;
        if (r7 != 0) goto L_0x01a0;
    L_0x0192:
        r2 = r9;
        goto L_0x01a1;
    L_0x0194:
        r7 = r9.f25823e;
        if (r7 != 0) goto L_0x0199;
    L_0x0198:
        goto L_0x0192;
    L_0x0199:
        r9 = r7;
        goto L_0x0192;
    L_0x019b:
        r7 = r9.f25822d;
        if (r7 != 0) goto L_0x0199;
    L_0x019f:
        goto L_0x0192;
    L_0x01a0:
        r2 = r7;
    L_0x01a1:
        r1 = r8;
        r3 = r10;
        r4 = r11;
        r5 = r12;
        r7 = m27377a(r0, r1, r2, r3, r4, r5);
    L_0x01a9:
        r9 = new java.lang.StringBuilder;
        r10 = "[";
        r9.<init>(r10);
        r7 = r8.mo5836b(r7);
        r9.append(r7);
        r7 = r9.toString();
        r7 = r8.mo5834a(r7);
        return r7;
    L_0x01c0:
        if (r2 == 0) goto L_0x01f7;
    L_0x01c2:
        r11 = r9.f25820b;
        if (r11 == 0) goto L_0x01d4;
    L_0x01c6:
        r11 = r0;
        r11 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r11;
        r11 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26987d(r11);
        if (r11 == 0) goto L_0x01d4;
    L_0x01cf:
        r8 = r8.mo5832a();
        goto L_0x01f3;
    L_0x01d4:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0;
        r11 = r0.mo7741v();
        r1 = "descriptor.original";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r1);
        r10.mo5837a(r11);
        r11 = r0.mo7741v();
        r0 = "descriptor.original";
        kotlin.jvm.internal.Intrinsics.m26843a(r11, r0);
        r10 = m27379a(r11, r10);
        r8 = r8.mo5835b(r10);
    L_0x01f3:
        r12.mo6509a(r7, r8, r9);
        return r8;
    L_0x01f7:
        r12 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
        if (r12 == 0) goto L_0x022d;
    L_0x01fb:
        r7 = "descriptor";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r7);
        r7 = r0;
        r7 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r7;
        r1 = m27380a(r7);
        r6 = kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.m28108d();
        r5 = 0;
        r2 = r8;
        r3 = r9;
        r4 = r10;
        r7 = m27377a(r1, r2, r3, r4, r5, r6);
        if (r11 == 0) goto L_0x022c;
    L_0x0215:
        r8 = r0.mo6689i();
        r9 = "descriptor.getName()";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r9);
        r9 = "name";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r9);
        r8 = "type";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r8);
        r11.m27316b(r7);
    L_0x022c:
        return r7;
    L_0x022d:
        r8 = new java.lang.UnsupportedOperationException;
        r9 = new java.lang.StringBuilder;
        r10 = "Unknown type ";
        r9.<init>(r10);
        r9.append(r7);
        r7 = r9.toString();
        r8.<init>(r7);
        r8 = (java.lang.Throwable) r8;
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt.a(kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration, kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter, kotlin.jvm.functions.Function3):T");
    }

    public static final boolean m27381a(CallableDescriptor callableDescriptor) {
        Intrinsics.m26847b(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType aN_ = callableDescriptor.aN_();
        if (aN_ == null) {
            Intrinsics.m26842a();
        }
        if (KotlinBuiltIns.m26994j(aN_)) {
            aN_ = callableDescriptor.aN_();
            if (aN_ == null) {
                Intrinsics.m26842a();
            }
            if (!TypeUtils.m28015d(aN_) && (callableDescriptor instanceof PropertyGetterDescriptor) == null) {
                return true;
            }
        }
        return null;
    }

    private static String m27379a(ClassDescriptor classDescriptor, TypeMappingConfiguration<?> typeMappingConfiguration) {
        Intrinsics.m26847b(classDescriptor, "klass");
        Intrinsics.m26847b(typeMappingConfiguration, "typeMappingConfiguration");
        DeclarationDescriptor aD_ = classDescriptor.aD_();
        Object b = SpecialNames.m27432a(classDescriptor.mo6689i()).m27430b();
        if (aD_ instanceof PackageFragmentDescriptor) {
            classDescriptor = ((PackageFragmentDescriptor) aD_).mo7722d();
            if (classDescriptor.f25856b.f25861b.isEmpty() != null) {
                Intrinsics.m26843a(b, "name");
                return b;
            }
            typeMappingConfiguration = new StringBuilder();
            typeMappingConfiguration.append(StringsKt__StringsJVMKt.m41941a((String) classDescriptor.m27407a(), '.', '/'));
            typeMappingConfiguration.append('/');
            typeMappingConfiguration.append(b);
            return typeMappingConfiguration.toString();
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) (!(aD_ instanceof ClassDescriptor) ? null : aD_);
        if (classDescriptor2 == null) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected container: ");
            stringBuilder.append(aD_);
            stringBuilder.append(" for ");
            stringBuilder.append(classDescriptor);
            throw ((Throwable) new IllegalArgumentException(stringBuilder.toString()));
        }
        typeMappingConfiguration.mo5841b(classDescriptor2);
        String a = m27379a(classDescriptor2, typeMappingConfiguration);
        if (Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.ENUM_ENTRY) != null) {
            return a;
        }
        classDescriptor = typeMappingConfiguration.mo5838a();
        Intrinsics.m26843a(b, "name");
        return (String) classDescriptor.mo6497a(a, b);
    }

    private static final KotlinType m27380a(TypeParameterDescriptor typeParameterDescriptor) {
        List j = typeParameterDescriptor.mo7715j();
        int isEmpty = j.isEmpty() ^ 1;
        if (_Assertions.f25274a && isEmpty == 0) {
            StringBuilder stringBuilder = new StringBuilder("Upper bounds should not be empty: ");
            stringBuilder.append(typeParameterDescriptor);
            throw new AssertionError(stringBuilder.toString());
        }
        Object obj;
        typeParameterDescriptor = j.iterator();
        int i;
        do {
            ClassifierDescriptor classifierDescriptor = null;
            if (!typeParameterDescriptor.hasNext()) {
                obj = null;
                break;
            }
            obj = typeParameterDescriptor.next();
            ClassifierDescriptor c = ((KotlinType) obj).mo6743g().mo5724c();
            if (c instanceof ClassDescriptor) {
                classifierDescriptor = c;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
            if (classDescriptor != null) {
                if (!((Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.INTERFACE) ^ 1) == 0 || (Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.ANNOTATION_CLASS) ^ 1) == 0)) {
                    i = 1;
                    continue;
                }
            }
            i = 0;
            continue;
        } while (i == 0);
        KotlinType kotlinType = (KotlinType) obj;
        if (kotlinType != null) {
            return kotlinType;
        }
        Object d = CollectionsKt___CollectionsKt.m41430d(j);
        Intrinsics.m26843a(d, "upperBounds.first()");
        return (KotlinType) d;
    }
}
