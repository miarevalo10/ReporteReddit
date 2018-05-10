package kotlin.reflect.jvm.internal;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.BuiltInFunction.Predefined;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction;
import kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField;
import kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty;
import kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "primitiveType", "Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "mapIntrinsicFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "function", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "Lorg/jetbrains/kotlin/name/ClassId;", "klass", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "mapSignature", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: RuntimeTypeMapper.kt */
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper f25343a = null;

    static {
        RuntimeTypeMapper runtimeTypeMapper = new RuntimeTypeMapper();
    }

    private RuntimeTypeMapper() {
        f25343a = this;
    }

    public static JvmFunctionSignature m26928a(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "possiblySubstitutedFunction");
        Object v = ((FunctionDescriptor) DescriptorUtils.m27636a((CallableMemberDescriptor) functionDescriptor)).mo7761v();
        Object obj = null;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        if (v instanceof DeserializedCallableMemberDescriptor) {
            Intrinsics.m26843a(v, "function");
            List k = v.mo7757k();
            String a = v.mo6689i().m27429a();
            int hashCode = a.hashCode();
            Object declaredMethod;
            if (hashCode != -1776922004) {
                if (hashCode != -1295482945) {
                    if (hashCode == 147696667) {
                        if (a.equals("hashCode") && k.isEmpty()) {
                            declaredMethod = Object.class.getDeclaredMethod("hashCode", new Class[0]);
                            Intrinsics.m26843a(declaredMethod, "Any::class.java.getDeclaredMethod(\"hashCode\")");
                            obj = new Predefined("hashCode()I", (Member) declaredMethod);
                        }
                    }
                } else if (a.equals("equals") && k.size() == 1 && KotlinBuiltIns.m26992h(((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(k)).mo7777x())) {
                    declaredMethod = Object.class.getDeclaredMethod("equals", new Class[]{Object.class});
                    Intrinsics.m26843a(declaredMethod, "Any::class.java.getDecla…equals\", Any::class.java)");
                    obj = new Predefined("equals(Ljava/lang/Object;)Z", (Member) declaredMethod);
                }
            } else if (a.equals("toString") && k.isEmpty()) {
                declaredMethod = Object.class.getDeclaredMethod("toString", new Class[0]);
                Intrinsics.m26843a(declaredMethod, "Any::class.java.getDeclaredMethod(\"toString\")");
                obj = new Predefined("toString()Ljava/lang/String;", (Member) declaredMethod);
            }
            if (obj != null) {
                return (JvmFunctionSignature) obj;
            }
            JvmProtoBufUtil jvmProtoBufUtil;
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = (DeserializedCallableMemberDescriptor) v;
            MessageLite F = deserializedCallableMemberDescriptor.mo7812F();
            if (F instanceof Function) {
                jvmProtoBufUtil = JvmProtoBufUtil.f26297a;
                a = JvmProtoBufUtil.m27907a((Function) F, deserializedCallableMemberDescriptor.mo7813G(), deserializedCallableMemberDescriptor.mo7814H());
                if (a != null) {
                    return (JvmFunctionSignature) new KotlinFunction(a);
                }
            }
            if (F instanceof Constructor) {
                jvmProtoBufUtil = JvmProtoBufUtil.f26297a;
                String a2 = JvmProtoBufUtil.m27906a((Constructor) F, deserializedCallableMemberDescriptor.mo7813G(), deserializedCallableMemberDescriptor.mo7814H());
                if (a2 != null) {
                    return (JvmFunctionSignature) new KotlinConstructor(a2);
                }
            }
            stringBuilder = new StringBuilder("Reflection on built-in Kotlin types is not yet fully supported. ");
            stringBuilder2 = new StringBuilder("No metadata found for ");
            stringBuilder2.append(v);
            stringBuilder.append(stringBuilder2.toString());
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        } else if (v instanceof JavaMethodDescriptor) {
            r0 = ((JavaMethodDescriptor) v).mo7258r();
            if (!(r0 instanceof JavaSourceElement)) {
                r0 = null;
            }
            r0 = (JavaSourceElement) r0;
            JavaElement b = r0 != null ? r0.mo6693b() : null;
            if (!(b instanceof ReflectJavaMethod)) {
                b = null;
            }
            ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) b;
            if (reflectJavaMethod != null) {
                Method method = reflectJavaMethod.f39728a;
                if (method != null) {
                    return (JvmFunctionSignature) new JavaMethod(method);
                }
            }
            stringBuilder = new StringBuilder("Incorrect resolution sequence for Java method ");
            stringBuilder.append(v);
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        } else if (v instanceof JavaClassConstructorDescriptor) {
            r0 = ((JavaClassConstructorDescriptor) v).mo7258r();
            if (!(r0 instanceof JavaSourceElement)) {
                r0 = null;
            }
            r0 = (JavaSourceElement) r0;
            if (r0 != null) {
                obj = r0.mo6693b();
            }
            if (obj instanceof ReflectJavaConstructor) {
                return (JvmFunctionSignature) new JavaConstructor(((ReflectJavaConstructor) obj).f39726a);
            }
            if (obj instanceof ReflectJavaClass) {
                ReflectJavaClass reflectJavaClass = (ReflectJavaClass) obj;
                if (reflectJavaClass.f39725a.isAnnotation()) {
                    return (JvmFunctionSignature) new FakeJavaAnnotationConstructor(reflectJavaClass.f39725a);
                }
            }
            stringBuilder2 = new StringBuilder("Incorrect resolution sequence for Java constructor ");
            stringBuilder2.append(v);
            stringBuilder2.append(" (");
            stringBuilder2.append(obj);
            stringBuilder2.append(")");
            throw new KotlinReflectionInternalError(stringBuilder2.toString());
        } else {
            stringBuilder = new StringBuilder("Unknown origin of ");
            stringBuilder.append(v);
            stringBuilder.append(" (");
            stringBuilder.append(v.getClass());
            stringBuilder.append(")");
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        }
    }

    public static JvmPropertySignature m26929a(PropertyDescriptor propertyDescriptor) {
        Intrinsics.m26847b(propertyDescriptor, "possiblyOverriddenProperty");
        PropertyDescriptor v = ((PropertyDescriptor) DescriptorUtils.m27636a((CallableMemberDescriptor) propertyDescriptor)).mo7829v();
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        if ((v instanceof DeserializedPropertyDescriptor) != null) {
            DeserializedPropertyDescriptor deserializedPropertyDescriptor = (DeserializedPropertyDescriptor) v;
            Property property = deserializedPropertyDescriptor.f40993m;
            if (property.m39930a(JvmProtoBuf.f26289c)) {
                Intrinsics.m26843a((Object) v, "property");
                Object b = property.m39931b(JvmProtoBuf.f26289c);
                Intrinsics.m26843a(b, "proto.getExtension(JvmProtoBuf.propertySignature)");
                return new KotlinProperty(v, property, (JvmPropertySignature) b, deserializedPropertyDescriptor.f40994n, deserializedPropertyDescriptor.f40995o);
            }
            stringBuilder = new StringBuilder("Reflection on built-in Kotlin types is not yet fully supported. ");
            stringBuilder2 = new StringBuilder("No metadata found for ");
            stringBuilder2.append(v);
            stringBuilder.append(stringBuilder2.toString());
            throw ((Throwable) new KotlinReflectionInternalError(stringBuilder.toString()));
        } else if ((v instanceof JavaPropertyDescriptor) != null) {
            propertyDescriptor = ((JavaPropertyDescriptor) v).mo7258r();
            Method method = null;
            if (!(propertyDescriptor instanceof JavaSourceElement)) {
                propertyDescriptor = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) propertyDescriptor;
            propertyDescriptor = javaSourceElement != null ? javaSourceElement.mo6693b() : null;
            if (propertyDescriptor instanceof ReflectJavaField) {
                return new JavaField(((ReflectJavaField) propertyDescriptor).f39727a);
            }
            if (propertyDescriptor instanceof ReflectJavaMethod) {
                propertyDescriptor = ((ReflectJavaMethod) propertyDescriptor).f39728a;
                PropertySetterDescriptor c = v.mo7827c();
                SourceElement r = c != null ? c.mo7258r() : null;
                if (!(r instanceof JavaSourceElement)) {
                    r = null;
                }
                JavaSourceElement javaSourceElement2 = (JavaSourceElement) r;
                JavaElement b2 = javaSourceElement2 != null ? javaSourceElement2.mo6693b() : null;
                if (!(b2 instanceof ReflectJavaMethod)) {
                    b2 = null;
                }
                ReflectJavaMethod reflectJavaMethod = (ReflectJavaMethod) b2;
                if (reflectJavaMethod != null) {
                    method = reflectJavaMethod.f39728a;
                }
                return new JavaMethodProperty(propertyDescriptor, method);
            }
            stringBuilder2 = new StringBuilder("Incorrect resolution sequence for Java field ");
            stringBuilder2.append(v);
            stringBuilder2.append(" (source = ");
            stringBuilder2.append(propertyDescriptor);
            stringBuilder2.append(")");
            throw new KotlinReflectionInternalError(stringBuilder2.toString());
        } else {
            stringBuilder = new StringBuilder("Unknown origin of ");
            stringBuilder.append(v);
            stringBuilder.append(" (");
            stringBuilder.append(v.getClass());
            stringBuilder.append(")");
            throw ((Throwable) new KotlinReflectionInternalError(stringBuilder.toString()));
        }
    }

    static PrimitiveType m26930a(Class<?> cls) {
        return cls.isPrimitive() ? JvmPrimitiveType.m27753a(cls.getSimpleName()).m27755a() : null;
    }
}
