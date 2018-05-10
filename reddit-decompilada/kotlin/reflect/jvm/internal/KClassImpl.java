package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal;
import kotlin.reflect.jvm.internal.ReflectProperties.LazyVal;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass.Factory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u0001]B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010N\u001a\u00020&2\b\u0010O\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00132\u0006\u0010R\u001a\u00020SH\u0016J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u00132\u0006\u0010R\u001a\u00020SH\u0016J\b\u0010V\u001a\u00020WH\u0016J\u0012\u0010X\u001a\u00020&2\b\u0010Y\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010Z\u001a\u00020[H\u0002J\b\u0010\\\u001a\u00020=H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R8\u0010\u001a\u001a)\u0012 \u0012\u001e \u001d*\u000e\u0018\u00010\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001cR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001b¢\u0006\u0002\b\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010'R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u0002018@X\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u001e\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0016R\u001e\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0016R\u0016\u00109\u001a\u0004\u0018\u00018\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\u0004\u0018\u00010=8VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010=8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?R\u0014\u0010B\u001a\u0002018@X\u0004¢\u0006\u0006\u001a\u0004\bC\u00103R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\rR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\n8VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\rR\u0016\u0010J\u001a\u0004\u0018\u00010K8VX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006^"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lorg/jetbrains/kotlin/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "Lorg/jetbrains/annotations/NotNull;", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isInner", "isOpen", "isSealed", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "name", "Lorg/jetbrains/kotlin/name/Name;", "getProperties", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "hashCode", "", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T> {
    final LazyVal<Data> f38245a = ReflectProperties.m26918a((Function0) new KClassImpl$data$1(this));
    final Class<T> f38246b;

    @Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 5})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25328a;

        static {
            int[] iArr = new int[Kind.values().length];
            f25328a = iArr;
            iArr[Kind.f25829c.ordinal()] = 1;
            f25328a[Kind.f25831e.ordinal()] = 2;
            f25328a[Kind.f25832f.ordinal()] = 3;
            f25328a[Kind.f25830d.ordinal()] = 4;
            f25328a[Kind.f25827a.ordinal()] = 5;
            f25328a[Kind.f25828b.ordinal()] = 6;
        }
    }

    @Metadata(bv = {1, 0, 1}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010K\u001a\u00020<2\n\u0010L\u001a\u0006\u0012\u0002\b\u00030MH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010<8FX\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010>R!\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00128FX\u0002¢\u0006\f\n\u0004\bF\u0010\n\u001a\u0004\bE\u0010\u0015R!\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00128FX\u0002¢\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bI\u0010\u0015¨\u0006N"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
    /* compiled from: KClassImpl.kt */
    public final class Data extends kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty[] f32572g = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        final LazySoftVal f32573a = ReflectProperties.m26919b((Function0) new KClassImpl$Data$simpleName$2(this));
        final LazySoftVal f32574b = ReflectProperties.m26919b((Function0) new KClassImpl$Data$qualifiedName$2(this));
        final LazySoftVal f32575c = ReflectProperties.m26919b((Function0) new KClassImpl$Data$inheritedNonStaticMembers$2(this));
        final LazySoftVal f32576d = ReflectProperties.m26919b((Function0) new KClassImpl$Data$inheritedStaticMembers$2(this));
        final LazySoftVal f32577e = ReflectProperties.m26919b((Function0) new KClassImpl$Data$allNonStaticMembers$2(this));
        final LazySoftVal f32578f = ReflectProperties.m26919b((Function0) new KClassImpl$Data$allStaticMembers$2(this));
        final /* synthetic */ KClassImpl f32579h;
        private final LazySoftVal f32580k = ReflectProperties.m26919b((Function0) new KClassImpl$Data$descriptor$2(this));
        private final LazySoftVal f32581l = ReflectProperties.m26919b((Function0) new KClassImpl$Data$annotations$2(this));
        private final LazySoftVal f32582m = ReflectProperties.m26919b((Function0) new KClassImpl$Data$constructors$2(this));
        private final LazySoftVal f32583n = ReflectProperties.m26919b((Function0) new KClassImpl$Data$nestedClasses$2(this));
        private final LazyVal f32584o = ReflectProperties.m26918a((Function0) new KClassImpl$Data$objectInstance$2(this));
        private final LazySoftVal f32585p = ReflectProperties.m26919b((Function0) new KClassImpl$Data$typeParameters$2(this));
        private final LazySoftVal f32586q = ReflectProperties.m26919b((Function0) new KClassImpl$Data$supertypes$2(this));
        private final LazySoftVal f32587r = ReflectProperties.m26919b((Function0) new KClassImpl$Data$declaredNonStaticMembers$2(this));
        private final LazySoftVal f32588s = ReflectProperties.m26919b((Function0) new KClassImpl$Data$declaredStaticMembers$2(this));
        private final LazySoftVal f32589t = ReflectProperties.m26919b((Function0) new KClassImpl$Data$declaredMembers$2(this));
        private final LazySoftVal f32590u = ReflectProperties.m26919b((Function0) new KClassImpl$Data$allMembers$2(this));

        public Data(KClassImpl kClassImpl) {
            this.f32579h = kClassImpl;
            super(kClassImpl);
        }

        public final ClassDescriptor m32891a() {
            return (ClassDescriptor) this.f32580k.mo5694a();
        }

        public final Collection<KCallableImpl<?>> m32892b() {
            return (Collection) this.f32587r.mo5694a();
        }

        public final Collection<KCallableImpl<?>> m32893c() {
            return (Collection) this.f32588s.mo5694a();
        }

        public static final /* synthetic */ String m32890a(Class cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                enclosingMethod = enclosingMethod;
                cls = new StringBuilder();
                cls.append(enclosingMethod.getName());
                cls.append("$");
                return StringsKt__StringsKt.m42465d(simpleName, cls.toString());
            }
            cls = cls.getEnclosingConstructor();
            if (cls == null) {
                return StringsKt__StringsKt.m42457b(simpleName);
            }
            Constructor constructor = (Constructor) cls;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(constructor.getName());
            stringBuilder.append("$");
            return StringsKt__StringsKt.m42465d(simpleName, stringBuilder.toString());
        }
    }

    public KClassImpl(Class<T> cls) {
        Intrinsics.m26847b(cls, "jClass");
        this.f38246b = cls;
    }

    public final Class<T> mo6657a() {
        return this.f38246b;
    }

    private ClassDescriptor m38228h() {
        return ((Data) this.f38245a.mo5694a()).m32891a();
    }

    private final ClassId m38229i() {
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
        Class cls = this.f38246b;
        Intrinsics.m26847b(cls, "klass");
        if (cls.isArray()) {
            PrimitiveType a = RuntimeTypeMapper.m26930a(cls.getComponentType());
            if (a != null) {
                return new ClassId(KotlinBuiltIns.f25415c, a.m27029b());
            }
            Object a2 = ClassId.m27396a(KotlinBuiltIns.f25420j.f25387h.m27420d());
            Intrinsics.m26843a(a2, "ClassId.topLevel(KotlinB….FQ_NAMES.array.toSafe())");
            return a2;
        }
        PrimitiveType a3 = RuntimeTypeMapper.m26930a(cls);
        if (a3 != null) {
            return new ClassId(KotlinBuiltIns.f25415c, a3.m27028a());
        }
        ClassId e = ReflectClassUtilKt.m27244e(cls);
        if (!e.f25852a) {
            ClassId a4 = JavaToKotlinClassMap.f25878a.m27442a(e.m27403f());
            if (a4 != null) {
                Object obj = a4;
                Intrinsics.m26843a(obj, "it");
                return obj;
            }
        }
        return e;
    }

    public final MemberScope m38235d() {
        return m38228h().mo7714h().mo6740b();
    }

    public final MemberScope m38236e() {
        Object b = m38228h().mo7767b();
        Intrinsics.m26843a(b, "descriptor.staticScope");
        return b;
    }

    public final Collection<ConstructorDescriptor> mo7070b() {
        ClassDescriptor h = m38228h();
        if (!Intrinsics.m26845a(h.mo7771g(), ClassKind.INTERFACE)) {
            if (!Intrinsics.m26845a(h.mo7771g(), ClassKind.OBJECT)) {
                Object f = h.mo7770f();
                Intrinsics.m26843a(f, "descriptor.constructors");
                return f;
            }
        }
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final Collection<PropertyDescriptor> mo7069a(Name name) {
        Intrinsics.m26847b(name, "name");
        return CollectionsKt___CollectionsKt.m41423b(m38235d().mo6694a(name, NoLookupLocation.f32678h), (Iterable) m38236e().mo6694a(name, NoLookupLocation.f32678h));
    }

    public final Collection<FunctionDescriptor> mo7071b(Name name) {
        Intrinsics.m26847b(name, "name");
        return CollectionsKt___CollectionsKt.m41423b(m38235d().mo6698b(name, NoLookupLocation.f32678h), (Iterable) m38236e().mo6698b(name, NoLookupLocation.f32678h));
    }

    public final String aB_() {
        return (String) ((Data) this.f38245a.mo5694a()).f32573a.mo5694a();
    }

    public final String mo6659c() {
        return (String) ((Data) this.f38245a.mo5694a()).f32574b.mo5694a();
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof KClassImpl) || Intrinsics.m26845a(JvmClassMappingKt.m26833c(this), JvmClassMappingKt.m26833c((KClass) obj)) == null) ? null : true;
    }

    public final int hashCode() {
        return JvmClassMappingKt.m26833c(this).hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder("class ");
        ClassId i = m38229i();
        FqName a = i.m27398a();
        if (a.f25856b.f25861b.isEmpty()) {
            str = "";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.m27407a());
            stringBuilder.append(".");
            str = stringBuilder.toString();
        }
        String a2 = StringsKt__StringsJVMKt.m41941a(i.m27399b().m27407a(), '.', '$');
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(a2);
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }

    public static final /* synthetic */ Void m38227b(KClassImpl kClassImpl) {
        Kind kind;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        Factory factory = ReflectKotlinClass.f32847c;
        ReflectKotlinClass a = Factory.m27389a(kClassImpl.f38246b);
        if (a != null) {
            KotlinClassHeader kotlinClassHeader = a.f32849b;
            if (kotlinClassHeader != null) {
                kind = kotlinClassHeader.f25837a;
                if (kind == null) {
                    switch (WhenMappings.f25328a[kind.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            stringBuilder = new StringBuilder("Packages and file facades are not yet supported in Kotlin reflection. ");
                            stringBuilder2 = new StringBuilder("Meanwhile please use Java reflection to inspect this class: ");
                            stringBuilder2.append(kClassImpl.f38246b);
                            stringBuilder.append(stringBuilder2.toString());
                            throw new UnsupportedOperationException(stringBuilder.toString());
                        case 4:
                            stringBuilder = new StringBuilder("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ");
                            stringBuilder2 = new StringBuilder("library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                            stringBuilder2.append(kClassImpl.f38246b);
                            stringBuilder.append(stringBuilder2.toString());
                            throw new UnsupportedOperationException(stringBuilder.toString());
                        case 5:
                            stringBuilder2 = new StringBuilder("Unknown class: ");
                            stringBuilder2.append(kClassImpl.f38246b);
                            stringBuilder2.append(" (kind = ");
                            stringBuilder2.append(kind);
                            stringBuilder2.append(")");
                            throw new KotlinReflectionInternalError(stringBuilder2.toString());
                        case 6:
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                stringBuilder = new StringBuilder("Unresolved class: ");
                stringBuilder.append(kClassImpl.f38246b);
                throw new KotlinReflectionInternalError(stringBuilder.toString());
            }
        }
        kind = null;
        if (kind == null) {
            switch (WhenMappings.f25328a[kind.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    stringBuilder = new StringBuilder("Packages and file facades are not yet supported in Kotlin reflection. ");
                    stringBuilder2 = new StringBuilder("Meanwhile please use Java reflection to inspect this class: ");
                    stringBuilder2.append(kClassImpl.f38246b);
                    stringBuilder.append(stringBuilder2.toString());
                    throw new UnsupportedOperationException(stringBuilder.toString());
                case 4:
                    stringBuilder = new StringBuilder("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ");
                    stringBuilder2 = new StringBuilder("library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                    stringBuilder2.append(kClassImpl.f38246b);
                    stringBuilder.append(stringBuilder2.toString());
                    throw new UnsupportedOperationException(stringBuilder.toString());
                case 5:
                    stringBuilder2 = new StringBuilder("Unknown class: ");
                    stringBuilder2.append(kClassImpl.f38246b);
                    stringBuilder2.append(" (kind = ");
                    stringBuilder2.append(kind);
                    stringBuilder2.append(")");
                    throw new KotlinReflectionInternalError(stringBuilder2.toString());
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        stringBuilder = new StringBuilder("Unresolved class: ");
        stringBuilder.append(kClassImpl.f38246b);
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }
}
