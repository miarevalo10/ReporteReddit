package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lorg/jetbrains/kotlin/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KTypeImpl.kt */
public final class KTypeImpl implements KType {
    static final /* synthetic */ KProperty[] f32602b = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KTypeImpl.class), "javaType", "getJavaType$kotlin_reflection()Ljava/lang/reflect/Type;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    public final KotlinType f32603a;
    private final LazySoftVal f32604c;
    private final LazySoftVal f32605d = ReflectProperties.m26919b((Function0) new KTypeImpl$classifier$2(this));
    private final LazySoftVal f32606e = ReflectProperties.m26919b((Function0) new KTypeImpl$arguments$2(this));

    @Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 5})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25336a;

        static {
            int[] iArr = new int[Variance.values().length];
            f25336a = iArr;
            iArr[Variance.f26337a.ordinal()] = 1;
            f25336a[Variance.f26338b.ordinal()] = 2;
            f25336a[Variance.f26339c.ordinal()] = 3;
        }
    }

    public KTypeImpl(KotlinType kotlinType, Function0<? extends Type> function0) {
        Intrinsics.m26847b(kotlinType, "type");
        Intrinsics.m26847b(function0, "computeJavaType");
        this.f32603a = kotlinType;
        this.f32604c = ReflectProperties.m26919b(function0);
    }

    private final KClassifier m32898a(KotlinType kotlinType) {
        ClassifierDescriptor c = kotlinType.mo6743g().mo5724c();
        if (c instanceof ClassDescriptor) {
            Class a = UtilKt.m26932a((ClassDescriptor) c);
            if (a == null) {
                return null;
            }
            if (a.isArray()) {
                TypeProjection typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41443i((List) kotlinType.mo6739a());
                if (typeProjection != null) {
                    Object c2 = typeProjection.mo6736c();
                    if (c2 != null) {
                        Intrinsics.m26843a(c2, "argument");
                        kotlinType = m32898a(c2);
                        if (kotlinType != null) {
                            return new KClassImpl(ReflectClassUtilKt.m27246g(JvmClassMappingKt.m26829a(KTypesJvm.m26889a(kotlinType))));
                        }
                        StringBuilder stringBuilder = new StringBuilder("Cannot determine classifier for array element type: ");
                        stringBuilder.append(this);
                        throw ((Throwable) new KotlinReflectionInternalError(stringBuilder.toString()));
                    }
                }
                return (KClassifier) new KClassImpl(a);
            } else if (TypeUtils.m28015d(kotlinType) != null) {
                return (KClassifier) new KClassImpl(a);
            } else {
                Class c3 = ReflectClassUtilKt.m27242c(a);
                if (c3 != null) {
                    a = c3;
                }
                return (KClassifier) new KClassImpl(a);
            }
        } else if ((c instanceof TypeParameterDescriptor) != null) {
            return (KClassifier) new KTypeParameterImpl((TypeParameterDescriptor) c);
        } else {
            if ((c instanceof TypeAliasDescriptor) == null) {
                return null;
            }
            StringBuilder stringBuilder2 = new StringBuilder("An operation is not implemented: ");
            stringBuilder2.append("Type alias classifiers are not yet supported");
            throw new NotImplementedError(stringBuilder2.toString());
        }
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof KTypeImpl) || Intrinsics.m26845a(this.f32603a, ((KTypeImpl) obj).f32603a) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f32603a.hashCode();
    }

    public final String toString() {
        ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.f25341a;
        return ReflectionObjectRenderer.m26924a(this.f32603a);
    }

    public final Type m32900b() {
        return (Type) this.f32604c.mo5694a();
    }

    public final KClassifier mo5693a() {
        return (KClassifier) this.f32605d.mo5694a();
    }
}
