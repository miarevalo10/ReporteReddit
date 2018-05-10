package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "", "()V", "asString", "", "JavaField", "JavaMethodProperty", "KotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: RuntimeTypeMapper.kt */
public abstract class JvmPropertySignature {

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class JavaField extends JvmPropertySignature {
        final Field f32559a;

        public JavaField(Field field) {
            Intrinsics.m26847b(field, "field");
            super();
            this.f32559a = field;
        }

        public final String mo5691a() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(JvmAbi.m27155c(this.f32559a.getName()));
            stringBuilder.append("()");
            stringBuilder.append(ReflectClassUtilKt.m27245f(this.f32559a.getType()));
            return stringBuilder.toString();
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", "", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class JavaMethodProperty extends JvmPropertySignature {
        final Method f32560a;
        final Method f32561b;

        public JavaMethodProperty(Method method, Method method2) {
            Intrinsics.m26847b(method, "getterMethod");
            super();
            this.f32560a = method;
            this.f32561b = method2;
        }

        public final String mo5691a() {
            return RuntimeTypeMapperKt.m26931a(this.f32560a);
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "proto", "Lorg/jetbrains/kotlin/serialization/ProtoBuf$Property;", "signature", "Lorg/jetbrains/kotlin/serialization/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lorg/jetbrains/kotlin/serialization/deserialization/NameResolver;", "typeTable", "Lorg/jetbrains/kotlin/serialization/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/serialization/ProtoBuf$Property;Lorg/jetbrains/kotlin/serialization/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/serialization/deserialization/NameResolver;Lorg/jetbrains/kotlin/serialization/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/serialization/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/serialization/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/serialization/jvm/JvmProtoBuf$JvmPropertySignature;", "string", "", "getTypeTable", "()Lorg/jetbrains/kotlin/serialization/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: RuntimeTypeMapper.kt */
    public static final class KotlinProperty extends JvmPropertySignature {
        final PropertyDescriptor f32562a;
        final Property f32563b;
        final kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmPropertySignature f32564c;
        final NameResolver f32565d;
        final TypeTable f32566e;
        private final String f32567f;

        public KotlinProperty(PropertyDescriptor propertyDescriptor, Property property, kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmPropertySignature jvmPropertySignature, NameResolver nameResolver, TypeTable typeTable) {
            Intrinsics.m26847b(propertyDescriptor, "descriptor");
            Intrinsics.m26847b(property, "proto");
            Intrinsics.m26847b(jvmPropertySignature, "signature");
            Intrinsics.m26847b(nameResolver, "nameResolver");
            Intrinsics.m26847b(typeTable, "typeTable");
            super();
            this.f32562a = propertyDescriptor;
            this.f32563b = property;
            this.f32564c = jvmPropertySignature;
            this.f32565d = nameResolver;
            this.f32566e = typeTable;
            if (this.f32564c.m40424j() != null) {
                propertyDescriptor = new StringBuilder();
                propertyDescriptor.append(this.f32565d.mo5829a(this.f32564c.f39937e.f39922c));
                propertyDescriptor.append(this.f32565d.mo5829a(this.f32564c.f39937e.f39923d));
                this.f32567f = propertyDescriptor.toString();
                return;
            }
            propertyDescriptor = JvmProtoBufUtil.f26297a;
            propertyDescriptor = JvmProtoBufUtil.m27911a(this.f32563b, this.f32565d, this.f32566e);
            if (propertyDescriptor == null) {
                property = new StringBuilder("No field signature for property: ");
                property.append(this.f32562a);
                throw ((Throwable) new KotlinReflectionInternalError(property.toString()));
            }
            property = propertyDescriptor.f26295a;
            propertyDescriptor = propertyDescriptor.f26296b;
            jvmPropertySignature = new StringBuilder();
            jvmPropertySignature.append(JvmAbi.m27155c(property));
            property = this.f32562a.aD_();
            if (Intrinsics.m26845a(this.f32562a.mo7257j(), Visibilities.f25507d) == null || (property instanceof DeserializedClassDescriptor) == null) {
                if (!(Intrinsics.m26845a(this.f32562a.mo7257j(), Visibilities.f25504a) == null || (property instanceof PackageFragmentDescriptor) == null)) {
                    property = this.f32562a;
                    if (property == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                    }
                    property = ((DeserializedPropertyDescriptor) property).f40996p;
                    if ((property instanceof JvmPackagePartSource) != null) {
                        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) property;
                        if (jvmPackagePartSource.f36119c != null) {
                            nameResolver = new StringBuilder("$");
                            nameResolver.append(jvmPackagePartSource.m36309b().m27429a());
                            property = nameResolver.toString();
                        }
                    }
                }
                property = "";
            } else {
                Object b;
                property = ((DeserializedClassDescriptor) property).f40872g;
                if (property.m39930a((GeneratedExtension) JvmProtoBuf.f26293g) != null) {
                    nameResolver = this.f32565d;
                    b = property.m39931b(JvmProtoBuf.f26293g);
                    Intrinsics.m26843a(b, "classProto.getExtension(…ProtoBuf.classModuleName)");
                    b = nameResolver.mo5829a(((Number) b).intValue());
                } else {
                    b = "main";
                }
                nameResolver = new StringBuilder("$");
                Intrinsics.m26843a(b, "moduleName");
                nameResolver.append(NameUtils.m27431a(b));
                property = nameResolver.toString();
            }
            jvmPropertySignature.append(property);
            jvmPropertySignature.append("()");
            jvmPropertySignature.append(propertyDescriptor);
            this.f32567f = jvmPropertySignature.toString();
        }

        public final String mo5691a() {
            return this.f32567f;
        }
    }

    public abstract String mo5691a();

    private JvmPropertySignature() {
    }
}
