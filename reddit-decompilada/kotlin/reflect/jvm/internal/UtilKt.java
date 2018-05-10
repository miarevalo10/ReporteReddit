package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.RuntimeSourceElementFactory.RuntimeSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.reflect.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\"\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\b¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011*\u0004\u0018\u00010\u0012H\u0000\u001a\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u0004\u0018\u00010\u0012H\u0000\u001a\u0014\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u0004\u0018\u00010\u0012H\u0000\u001a\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u001aH\u0000\u001a\u0012\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u001cH\u0000\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u001fH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006 "}, d2 = {"JVM_STATIC", "Lorg/jetbrains/kotlin/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "loadClass", "Ljava/lang/Class;", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lorg/jetbrains/kotlin/descriptors/annotations/Annotated;", "toJavaClass", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lorg/jetbrains/kotlin/descriptors/Visibility;", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: util.kt */
public final class UtilKt {
    private static final FqName f25344a = new FqName("kotlin.jvm.JvmStatic");

    public static final FqName m26935a() {
        return f25344a;
    }

    public static final Class<?> m26932a(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "$receiver");
        SourceElement r = classDescriptor.mo7258r();
        if (r instanceof KotlinJvmBinarySourceElement) {
            classDescriptor = ((KotlinJvmBinarySourceElement) r).f36122b;
            if (classDescriptor != null) {
                return ((ReflectKotlinClass) classDescriptor).f32848a;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.reflect.ReflectKotlinClass");
        } else if (r instanceof RuntimeSourceElement) {
            classDescriptor = ((RuntimeSourceElement) r).f36087b;
            if (classDescriptor != null) {
                return ((ReflectJavaClass) classDescriptor).f39725a;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.reflect.ReflectJavaClass");
        } else {
            ClassId a = JavaToKotlinClassMap.f25878a.m27443a(DescriptorUtils.m27653c(classDescriptor));
            if (a == null) {
                a = DescriptorUtilsKt.m27736a((ClassifierDescriptorWithTypeParameters) classDescriptor);
                if (a == null) {
                    Intrinsics.m26842a();
                }
            }
            Object a2 = a.m27398a().m27407a();
            Object a3 = a.m27399b().m27407a();
            classDescriptor = ReflectClassUtilKt.m27239a(classDescriptor.getClass());
            Intrinsics.m26843a(a2, "packageName");
            Intrinsics.m26843a(a3, "className");
            Intrinsics.m26847b(classDescriptor, "classLoader");
            Intrinsics.m26847b(a2, "packageName");
            Intrinsics.m26847b(a3, "className");
            if (Intrinsics.m26845a(a2, (Object) "kotlin")) {
                switch (a3.hashCode()) {
                    case -901856463:
                        if (a3.equals("BooleanArray")) {
                            return boolean[].class;
                        }
                        break;
                    case -763279523:
                        if (a3.equals("ShortArray")) {
                            return short[].class;
                        }
                        break;
                    case -755911549:
                        if (a3.equals("CharArray")) {
                            return char[].class;
                        }
                        break;
                    case -74930671:
                        if (a3.equals("ByteArray")) {
                            return byte[].class;
                        }
                        break;
                    case 22374632:
                        if (a3.equals("DoubleArray")) {
                            return double[].class;
                        }
                        break;
                    case 63537721:
                        if (a3.equals("Array")) {
                            return Object[].class;
                        }
                        break;
                    case 601811914:
                        if (a3.equals("IntArray")) {
                            return int[].class;
                        }
                        break;
                    case 948852093:
                        if (a3.equals("FloatArray")) {
                            return float[].class;
                        }
                        break;
                    case 2104330525:
                        if (a3.equals("LongArray")) {
                            return long[].class;
                        }
                        break;
                    default:
                        break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a2);
            stringBuilder.append(".");
            stringBuilder.append(StringsKt__StringsJVMKt.m41941a((String) a3, '.', '$'));
            return ReflectJavaClassFinderKt.m27234a(classDescriptor, stringBuilder.toString());
        }
    }

    public static final List<Annotation> m26933a(Annotated annotated) {
        Intrinsics.m26847b(annotated, "$receiver");
        Collection arrayList = new ArrayList();
        for (AnnotationDescriptor c : annotated.mo5718q()) {
            SourceElement c2 = c.mo5721c();
            Object obj = null;
            if (c2 instanceof ReflectAnnotationSource) {
                obj = ((ReflectAnnotationSource) c2).f32846b;
            } else if (c2 instanceof RuntimeSourceElement) {
                ReflectJavaElement reflectJavaElement = ((RuntimeSourceElement) c2).f36087b;
                if (!(reflectJavaElement instanceof ReflectJavaAnnotation)) {
                    reflectJavaElement = null;
                }
                ReflectJavaAnnotation reflectJavaAnnotation = (ReflectJavaAnnotation) reflectJavaElement;
                if (reflectJavaAnnotation != null) {
                    obj = reflectJavaAnnotation.f36099a;
                }
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return (List) arrayList;
    }

    public static final KFunctionImpl m26934a(Object obj) {
        KFunctionImpl kFunctionImpl = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        if (!(obj instanceof FunctionReference)) {
            obj = null;
        }
        FunctionReference functionReference = (FunctionReference) obj;
        obj = functionReference != null ? functionReference.m32847g() : null;
        if (!(obj instanceof KFunctionImpl)) {
            obj = null;
        }
        return (KFunctionImpl) obj;
    }

    public static final KPropertyImpl<?> m26936b(Object obj) {
        KPropertyImpl<?> kPropertyImpl = (KPropertyImpl) (!(obj instanceof KPropertyImpl) ? null : obj);
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        if (!(obj instanceof PropertyReference)) {
            obj = null;
        }
        PropertyReference propertyReference = (PropertyReference) obj;
        obj = propertyReference != null ? propertyReference.m32847g() : null;
        if (!(obj instanceof KPropertyImpl)) {
            obj = null;
        }
        return (KPropertyImpl) obj;
    }
}
