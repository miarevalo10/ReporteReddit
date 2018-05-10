package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.platform.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: JvmBuiltInsSettings.kt */
public class JvmBuiltInsSettings implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty[] f32794a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(JvmBuiltInsSettings.class), "ownerModuleDescriptor", "getOwnerModuleDescriptor()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(JvmBuiltInsSettings.class), "isAdditionalBuiltInsFeatureSupported", "isAdditionalBuiltInsFeatureSupported()Z")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(JvmBuiltInsSettings.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(JvmBuiltInsSettings.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationsImpl;"))};
    public static final Companion f32795b = new Companion();
    private static final Set<String> f32796k = SetsKt___SetsKt.m32821b(SignatureBuildingComponents.m27363b("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    private static final Set<String> f32797l = SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(Companion.m27311g(), (Iterable) SignatureBuildingComponents.m27363b("List", "sort(Ljava/util/Comparator;)V")), (Iterable) SignatureBuildingComponents.m27360a("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;")), (Iterable) SignatureBuildingComponents.m27360a("Double", "isInfinite()Z", "isNaN()Z")), (Iterable) SignatureBuildingComponents.m27360a("Float", "isInfinite()Z", "isNaN()Z")), (Iterable) SignatureBuildingComponents.m27360a("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
    private static final Set<String> f32798m = SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a((Set) SignatureBuildingComponents.m27360a("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable) SignatureBuildingComponents.m27363b("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable) SignatureBuildingComponents.m27360a("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable) SignatureBuildingComponents.m27360a("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable) SignatureBuildingComponents.m27363b("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable) SignatureBuildingComponents.m27363b("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable) SignatureBuildingComponents.m27363b("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
    private static final Set<String> f32799n = SetsKt___SetsKt.m32819a(SetsKt___SetsKt.m32819a((Set) SignatureBuildingComponents.m27363b("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable) SignatureBuildingComponents.m27363b("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable) SignatureBuildingComponents.m27363b("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
    private static final Set<String> f32800o;
    private static final Set<String> f32801p;
    private final JavaToKotlinClassMap f32802c = JavaToKotlinClassMap.f25878a;
    private final Lazy f32803d;
    private final Lazy f32804e;
    private final KotlinType f32805f;
    private final NotNullLazyValue f32806g;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> f32807h;
    private final NotNullLazyValue f32808i;
    private final ModuleDescriptor f32809j;

    /* compiled from: JvmBuiltInsSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public static boolean m27303a(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r1) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = "fqName";
            kotlin.jvm.internal.Intrinsics.m26847b(r1, r0);
            r0 = m27307c(r1);
            if (r0 == 0) goto L_0x000d;
        L_0x000b:
            r1 = 1;
            return r1;
        L_0x000d:
            r0 = kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap.f25878a;
            r1 = r0.m27443a(r1);
            r0 = 0;
            if (r1 != 0) goto L_0x0017;
        L_0x0016:
            return r0;
        L_0x0017:
            r1 = r1.m27403f();	 Catch:{ ClassNotFoundException -> 0x002a }
            r1 = r1.m27407a();	 Catch:{ ClassNotFoundException -> 0x002a }
            r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x002a }
            r0 = java.io.Serializable.class;
            r1 = r0.isAssignableFrom(r1);
            return r1;
        L_0x002a:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings.Companion.a(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe):boolean");
        }

        private static boolean m27307c(FqNameUnsafe fqNameUnsafe) {
            if (!Intrinsics.m26845a((Object) fqNameUnsafe, KotlinBuiltIns.f25420j.f25387h)) {
                if (KotlinBuiltIns.m26974a(fqNameUnsafe) == null) {
                    return null;
                }
            }
            return true;
        }

        public static Set<String> m27302a() {
            return JvmBuiltInsSettings.f32796k;
        }

        public static Set<String> m27304b() {
            return JvmBuiltInsSettings.f32797l;
        }

        public static Set<String> m27306c() {
            return JvmBuiltInsSettings.f32798m;
        }

        public static Set<String> m27308d() {
            return JvmBuiltInsSettings.f32799n;
        }

        public static Set<String> m27309e() {
            return JvmBuiltInsSettings.f32800o;
        }

        public static Set<String> m27310f() {
            return JvmBuiltInsSettings.f32801p;
        }

        public static final /* synthetic */ Set m27311g() {
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
            Collection linkedHashSet = new LinkedHashSet();
            for (JvmPrimitiveType jvmPrimitiveType : CollectionsKt__CollectionsKt.m26796b((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR})) {
                String a = jvmPrimitiveType.m27758d().m27412e().m27429a();
                Intrinsics.m26843a((Object) a, "it.wrapperFqName.shortName().asString()");
                String[] strArr = new String[1];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(jvmPrimitiveType.m27756b());
                stringBuilder.append("Value()");
                stringBuilder.append(jvmPrimitiveType.m27757c());
                strArr[0] = stringBuilder.toString();
                CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) SignatureBuildingComponents.m27360a(a, strArr));
            }
            return (LinkedHashSet) linkedHashSet;
        }

        public static final /* synthetic */ Set m27312h() {
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
            Collection linkedHashSet = new LinkedHashSet();
            for (JvmPrimitiveType d : CollectionsKt__CollectionsKt.m26796b((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT})) {
                String a = d.m27758d().m27412e().m27429a();
                Intrinsics.m26843a((Object) a, "it.wrapperFqName.shortName().asString()");
                String[] a2 = SignatureBuildingComponents.m27361a("Ljava/lang/String;");
                CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) SignatureBuildingComponents.m27360a(a, (String[]) Arrays.copyOf(a2, a2.length)));
            }
            return (LinkedHashSet) linkedHashSet;
        }
    }

    /* compiled from: JvmBuiltInsSettings.kt */
    private enum JDKMemberStatus {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25795a;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            f25795a = iArr;
            iArr[JDKMemberStatus.f25790a.ordinal()] = 1;
            f25795a[JDKMemberStatus.f25792c.ordinal()] = 2;
            f25795a[JDKMemberStatus.f25793d.ordinal()] = 3;
            f25795a[JDKMemberStatus.f25791b.ordinal()] = 4;
        }
    }

    private final ModuleDescriptor m33194g() {
        return (ModuleDescriptor) this.f32803d.mo5678b();
    }

    private final boolean m33195h() {
        return ((Boolean) this.f32804e.mo5678b()).booleanValue();
    }

    private final SimpleType m33196i() {
        return (SimpleType) StorageKt.m27920a(this.f32806g, f32794a[2]);
    }

    private final AnnotationsImpl m33197j() {
        return (AnnotationsImpl) StorageKt.m27920a(this.f32808i, f32794a[3]);
    }

    public JvmBuiltInsSettings(ModuleDescriptor moduleDescriptor, StorageManager storageManager, Function0<? extends ModuleDescriptor> function0, Function0<Boolean> function02) {
        Intrinsics.m26847b(moduleDescriptor, "moduleDescriptor");
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(function0, "deferredOwnerModuleDescriptor");
        Intrinsics.m26847b(function02, "isAdditionalBuiltInsFeatureSupported");
        this.f32809j = moduleDescriptor;
        this.f32803d = LazyKt.m26777a(function0);
        this.f32804e = LazyKt.m26777a(function02);
        Function0<Boolean> classDescriptorImpl = new ClassDescriptorImpl(new C3048xaea9d104(this, this.f32809j, new FqName("java.io")), Name.m27424a("Serializable"), Modality.f25491d, ClassKind.INTERFACE, CollectionsKt__CollectionsKt.m26791a((Object) new LazyWrappedType(storageManager, new C2976xf01ceaf8(this))), SourceElement.f25498a);
        classDescriptorImpl.m42902a((MemberScope) Empty.f38819a, SetsKt__SetsKt.m26799a(), null);
        Object h = classDescriptorImpl.mo7714h();
        Intrinsics.m26843a(h, "mockSerializableClass.defaultType");
        this.f32805f = (KotlinType) h;
        this.f32806g = storageManager.mo5926a((Function0) new JvmBuiltInsSettings$cloneableType$2(this, storageManager));
        this.f32807h = storageManager.mo5929b();
        this.f32808i = storageManager.mo5926a((Function0) new JvmBuiltInsSettings$notConsideredDeprecation$2(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.util.Collection mo5827b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r2) {
        /*
        r1 = this;
        r0 = "classDescriptor";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r0);
        r0 = r1.m33195h();
        if (r0 != 0) goto L_0x0010;
    L_0x000b:
        r2 = kotlin.collections.SetsKt__SetsKt.m26799a();
        goto L_0x0026;
    L_0x0010:
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2;
        r2 = r1.m33185a(r2);
        if (r2 == 0) goto L_0x0022;
    L_0x0018:
        r2 = r2.f40957b;
        if (r2 == 0) goto L_0x0022;
    L_0x001c:
        r2 = r2.aE_();
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = kotlin.collections.SetsKt__SetsKt.m26799a();
    L_0x0026:
        r2 = (java.util.Collection) r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings.b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor):java.util.Collection");
    }

    public final Collection<KotlinType> mo5825a(DeserializedClassDescriptor deserializedClassDescriptor) {
        Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
        deserializedClassDescriptor = DescriptorUtilsKt.m27738a((DeclarationDescriptor) deserializedClassDescriptor);
        if (Companion.m27307c(deserializedClassDescriptor)) {
            deserializedClassDescriptor = new KotlinType[2];
            Object i = m33196i();
            Intrinsics.m26843a(i, "cloneableType");
            deserializedClassDescriptor[0] = (KotlinType) i;
            deserializedClassDescriptor[1] = this.f32805f;
            return CollectionsKt__CollectionsKt.m26796b((Object[]) deserializedClassDescriptor);
        } else if (Companion.m27303a(deserializedClassDescriptor) != null) {
            return CollectionsKt__CollectionsKt.m26791a((Object) this.f32805f);
        } else {
            return CollectionsKt__CollectionsKt.m26790a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> mo5824a(kotlin.reflect.jvm.internal.impl.name.Name r13, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r14) {
        /*
        r12 = this;
        r0 = "name";
        kotlin.jvm.internal.Intrinsics.m26847b(r13, r0);
        r0 = "classDescriptor";
        kotlin.jvm.internal.Intrinsics.m26847b(r14, r0);
        r0 = kotlin.reflect.jvm.internal.impl.builtins.CloneableClassScope.f39715a;
        r0 = kotlin.reflect.jvm.internal.impl.builtins.CloneableClassScope.Companion.m26941a();
        r0 = kotlin.jvm.internal.Intrinsics.m26845a(r13, r0);
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x00a2;
    L_0x0018:
        r0 = r14;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0;
        r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26971a(r0);
        if (r0 == 0) goto L_0x00a2;
    L_0x0021:
        r0 = r14.f40872g;
        r0 = r0.f40323m;
        r0 = (java.lang.Iterable) r0;
        r0 = r0.iterator();
    L_0x002b:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x004e;
    L_0x0031:
        r3 = r0.next();
        r3 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function) r3;
        r4 = r14.f40869b;
        r4 = r4.f26246d;
        r3 = r3.f40375g;
        r3 = r4.mo5830b(r3);
        r4 = kotlin.reflect.jvm.internal.impl.builtins.CloneableClassScope.f39715a;
        r4 = kotlin.reflect.jvm.internal.impl.builtins.CloneableClassScope.Companion.m26941a();
        r3 = kotlin.jvm.internal.Intrinsics.m26845a(r3, r4);
        if (r3 == 0) goto L_0x002b;
    L_0x004d:
        r1 = r2;
    L_0x004e:
        if (r1 == 0) goto L_0x0057;
    L_0x0050:
        r13 = kotlin.collections.CollectionsKt__CollectionsKt.m26790a();
        r13 = (java.util.Collection) r13;
        return r13;
    L_0x0057:
        r0 = r12.m33196i();
        r0 = r0.mo6740b();
        r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.f32674d;
        r1 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r1;
        r13 = r0.mo6698b(r13, r1);
        r13 = (java.lang.Iterable) r13;
        r13 = kotlin.collections.CollectionsKt___CollectionsKt.m41440h(r13);
        r13 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r13;
        r13 = r13.mo7736C();
        r13 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder) r13;
        r0 = r14;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r0;
        r13.mo5743a(r0);
        r0 = kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.f25508e;
        r13.mo5746a(r0);
        r0 = r14.mo7714h();
        r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0;
        r13.mo5749a(r0);
        r14 = r14.mo7740u();
        r13.mo5745a(r14);
        r13 = r13.mo5757f();
        if (r13 != 0) goto L_0x0099;
    L_0x0096:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0099:
        r13 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r13;
        r13 = kotlin.collections.CollectionsKt__CollectionsKt.m26791a(r13);
        r13 = (java.util.Collection) r13;
        return r13;
    L_0x00a2:
        r0 = r12.m33195h();
        if (r0 != 0) goto L_0x00af;
    L_0x00a8:
        r13 = kotlin.collections.CollectionsKt__CollectionsKt.m26790a();
        r13 = (java.util.Collection) r13;
        return r13;
    L_0x00af:
        r0 = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings$getFunctions$2;
        r0.<init>(r13);
        r0 = (kotlin.jvm.functions.Function1) r0;
        r13 = r14;
        r13 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r13;
        r3 = r12.m33185a(r13);
        if (r3 != 0) goto L_0x00c7;
    L_0x00bf:
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.m26790a();
        r0 = (java.util.Collection) r0;
        goto L_0x02a8;
    L_0x00c7:
        r4 = r12.f32802c;
        r5 = r3;
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r5;
        r6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.m27742b(r5);
        r7 = kotlin.reflect.jvm.internal.impl.load.kotlin.FallbackBuiltIns.f32786a;
        r7 = kotlin.reflect.jvm.internal.impl.load.kotlin.FallbackBuiltIns.Companion.m27301a();
        r8 = 3;
        r9 = 2;
        if (r6 != 0) goto L_0x00f4;
    L_0x00da:
        r13 = new java.lang.IllegalArgumentException;
        r14 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r0 = new java.lang.Object[r8];
        r3 = "fqName";
        r0[r1] = r3;
        r1 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r0[r2] = r1;
        r1 = "mapPlatformClass";
        r0[r9] = r1;
        r14 = java.lang.String.format(r14, r0);
        r13.<init>(r14);
        throw r13;
    L_0x00f4:
        if (r7 != 0) goto L_0x0110;
    L_0x00f6:
        r13 = new java.lang.IllegalArgumentException;
        r14 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        r0 = new java.lang.Object[r8];
        r3 = "builtIns";
        r0[r1] = r3;
        r1 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r0[r2] = r1;
        r1 = "mapPlatformClass";
        r0[r9] = r1;
        r14 = java.lang.String.format(r14, r0);
        r13.<init>(r14);
        throw r13;
    L_0x0110:
        r6 = r4.m27441a(r6, r7);
        if (r6 != 0) goto L_0x0132;
    L_0x0116:
        r4 = java.util.Collections.emptySet();
        if (r4 != 0) goto L_0x0182;
    L_0x011c:
        r13 = new java.lang.IllegalStateException;
        r14 = "@NotNull method %s.%s must not return null";
        r0 = new java.lang.Object[r9];
        r3 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r0[r1] = r3;
        r1 = "mapPlatformClass";
        r0[r2] = r1;
        r14 = java.lang.String.format(r14, r0);
        r13.<init>(r14);
        throw r13;
    L_0x0132:
        r4 = r4.f25881c;
        r8 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.m27738a(r6);
        r4 = r4.get(r8);
        r4 = (kotlin.reflect.jvm.internal.impl.name.FqName) r4;
        if (r4 != 0) goto L_0x015c;
    L_0x0140:
        r4 = java.util.Collections.singleton(r6);
        if (r4 != 0) goto L_0x0182;
    L_0x0146:
        r13 = new java.lang.IllegalStateException;
        r14 = "@NotNull method %s.%s must not return null";
        r0 = new java.lang.Object[r9];
        r3 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r0[r1] = r3;
        r1 = "mapPlatformClass";
        r0[r2] = r1;
        r14 = java.lang.String.format(r14, r0);
        r13.<init>(r14);
        throw r13;
    L_0x015c:
        r8 = new kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor[r9];
        r8[r1] = r6;
        r4 = r7.m26998a(r4);
        r8[r2] = r4;
        r4 = java.util.Arrays.asList(r8);
        if (r4 != 0) goto L_0x0182;
    L_0x016c:
        r13 = new java.lang.IllegalStateException;
        r14 = "@NotNull method %s.%s must not return null";
        r0 = new java.lang.Object[r9];
        r3 = "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap";
        r0[r1] = r3;
        r1 = "mapPlatformClass";
        r0[r2] = r1;
        r14 = java.lang.String.format(r14, r0);
        r13.<init>(r14);
        throw r13;
    L_0x0182:
        r4 = (java.lang.Iterable) r4;
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.m41438g(r4);
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6;
        if (r6 != 0) goto L_0x0194;
    L_0x018c:
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.m26790a();
        r0 = (java.util.Collection) r0;
        goto L_0x02a8;
    L_0x0194:
        r7 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.f26429a;
        r7 = new java.util.ArrayList;
        r8 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r4);
        r7.<init>(r8);
        r7 = (java.util.Collection) r7;
        r4 = r4.iterator();
    L_0x01a5:
        r8 = r4.hasNext();
        if (r8 == 0) goto L_0x01bb;
    L_0x01ab:
        r8 = r4.next();
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r8;
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r8;
        r8 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.m27742b(r8);
        r7.add(r8);
        goto L_0x01a5;
    L_0x01bb:
        r7 = (java.util.List) r7;
        r7 = (java.util.Collection) r7;
        r4 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.m28117a(r7);
        r7 = r12.f32802c;
        r7 = r7.m27444a(r13);
        r8 = r12.f32807h;
        r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.m27742b(r5);
        r9 = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1;
        r9.<init>(r3, r6);
        r9 = (kotlin.jvm.functions.Function0) r9;
        r3 = r8.mo7615a(r5, r9);
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3;
        r3 = r3.mo7768d();
        r5 = "scope";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r5);
        r0 = r0.mo6492a(r3);
        r0 = (java.lang.Iterable) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r3 = (java.util.Collection) r3;
        r0 = r0.iterator();
    L_0x01f6:
        r5 = r0.hasNext();
        if (r5 == 0) goto L_0x02a3;
    L_0x01fc:
        r5 = r0.next();
        r6 = r5;
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6;
        r8 = r6.mo7760t();
        r9 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION;
        r8 = kotlin.jvm.internal.Intrinsics.m26845a(r8, r9);
        r8 = r8 ^ r2;
        if (r8 != 0) goto L_0x029b;
    L_0x0210:
        r8 = r6.mo7257j();
        r8 = r8.f25520a;
        if (r8 == 0) goto L_0x029b;
    L_0x0218:
        r8 = r6;
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r8;
        r8 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.m26981b(r8);
        if (r8 != 0) goto L_0x029b;
    L_0x0221:
        r8 = r6.mo7609m();
        r8 = (java.lang.Iterable) r8;
        r8 = r8.iterator();
    L_0x022b:
        r9 = r8.hasNext();
        if (r9 == 0) goto L_0x0247;
    L_0x0231:
        r9 = r8.next();
        r9 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r9;
        r9 = r9.aD_();
        r9 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.m27742b(r9);
        r9 = r4.contains(r9);
        if (r9 == 0) goto L_0x022b;
    L_0x0245:
        r8 = r2;
        goto L_0x0248;
    L_0x0247:
        r8 = r1;
    L_0x0248:
        if (r8 != 0) goto L_0x029b;
    L_0x024a:
        r8 = r6.aD_();
        if (r8 != 0) goto L_0x0258;
    L_0x0250:
        r13 = new kotlin.TypeCastException;
        r14 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor";
        r13.<init>(r14);
        throw r13;
    L_0x0258:
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r8;
        r9 = r6;
        r9 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r9;
        r9 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.m27351a(r9, true);
        r10 = kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings.Companion.m27308d();
        r11 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.f25810a;
        r11 = "jvmDescriptor";
        kotlin.jvm.internal.Intrinsics.m26843a(r9, r11);
        r8 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.m27359a(r8, r9);
        r8 = r10.contains(r8);
        r8 = r8 ^ r7;
        if (r8 == 0) goto L_0x0279;
    L_0x0277:
        r6 = r2;
        goto L_0x0297;
    L_0x0279:
        r6 = kotlin.collections.CollectionsKt__CollectionsKt.m26791a(r6);
        r6 = (java.util.Collection) r6;
        r8 = kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings$isMutabilityViolation$1.f32793a;
        r8 = (kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors) r8;
        r9 = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings$isMutabilityViolation$2;
        r9.<init>(r12);
        r9 = (kotlin.jvm.functions.Function1) r9;
        r6 = kotlin.reflect.jvm.internal.impl.utils.DFS.m28100a(r6, r8, r9);
        r8 = "DFS.ifAny<CallableMember…lassDescriptor)\n        }";
        kotlin.jvm.internal.Intrinsics.m26843a(r6, r8);
        r6 = r6.booleanValue();
    L_0x0297:
        if (r6 != 0) goto L_0x029b;
    L_0x0299:
        r6 = r2;
        goto L_0x029c;
    L_0x029b:
        r6 = r1;
    L_0x029c:
        if (r6 == 0) goto L_0x01f6;
    L_0x029e:
        r3.add(r5);
        goto L_0x01f6;
    L_0x02a3:
        r3 = (java.util.List) r3;
        r0 = r3;
        r0 = (java.util.Collection) r0;
    L_0x02a8:
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = (java.util.Collection) r1;
        r0 = r0.iterator();
    L_0x02b5:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x038b;
    L_0x02bb:
        r2 = r0.next();
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r2;
        r3 = r2.aD_();
        if (r3 != 0) goto L_0x02cf;
    L_0x02c7:
        r13 = new kotlin.TypeCastException;
        r14 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor";
        r13.<init>(r14);
        throw r13;
    L_0x02cf:
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3;
        r3 = kotlin.reflect.jvm.internal.impl.platform.MappingUtilKt.m27447a(r3, r13);
        r3 = r3.m27987d();
        r3 = r2.mo7754d(r3);
        if (r3 != 0) goto L_0x02e7;
    L_0x02df:
        r13 = new kotlin.TypeCastException;
        r14 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor";
        r13.<init>(r14);
        throw r13;
    L_0x02e7:
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3;
        r3 = r3.mo7736C();
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder) r3;
        r4 = r14;
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r4;
        r3.mo5743a(r4);
        r4 = r14.mo7740u();
        r3.mo5745a(r4);
        r3.mo5752b();
        r4 = new kotlin.reflect.jvm.internal.impl.load.kotlin.UnsafeVarianceTypeSubstitution;
        r5 = r12.f32809j;
        r5 = r5.mo7089b();
        r4.<init>(r5);
        r4 = (kotlin.reflect.jvm.internal.impl.types.TypeSubstitution) r4;
        r3.mo5750a(r4);
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2;
        r4 = r2.aD_();
        if (r4 != 0) goto L_0x031f;
    L_0x0317:
        r13 = new kotlin.TypeCastException;
        r14 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor";
        r13.<init>(r14);
        throw r13;
    L_0x031f:
        r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4;
        r2 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.m27351a(r2, true);
        r5 = new kotlin.jvm.internal.Ref$ObjectRef;
        r5.<init>();
        r6 = 0;
        r5.f25291a = r6;
        r4 = kotlin.collections.CollectionsKt__CollectionsKt.m26791a(r4);
        r4 = (java.util.Collection) r4;
        r7 = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings$getJdkMethodStatus$1;
        r7.<init>(r12);
        r7 = (kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors) r7;
        r8 = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings$getJdkMethodStatus$2;
        r8.<init>(r2, r5);
        r8 = (kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler) r8;
        r2 = kotlin.reflect.jvm.internal.impl.utils.DFS.m28101a(r4, r7, r8);
        r4 = "DFS.dfs<ClassDescriptor,…IDERED\n                })";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r4);
        r2 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings.JDKMemberStatus) r2;
        r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings.WhenMappings.f25795a;
        r2 = r2.ordinal();
        r2 = r4[r2];
        switch(r2) {
            case 1: goto L_0x0368;
            case 2: goto L_0x0358;
            case 3: goto L_0x0384;
            default: goto L_0x0357;
        };
    L_0x0357:
        goto L_0x0378;
    L_0x0358:
        r2 = r12.m33197j();
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r2;
        r2 = r3.mo5747a(r2);
        r4 = "setAdditionalAnnotations(notConsideredDeprecation)";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r4);
        goto L_0x0378;
    L_0x0368:
        r2 = kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt.m27079a(r13);
        if (r2 == 0) goto L_0x036f;
    L_0x036e:
        goto L_0x0384;
    L_0x036f:
        r2 = r3.mo5756e();
        r4 = "setHiddenForResolutionEverywhereBesideSupercalls()";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r4);
    L_0x0378:
        r2 = r3.mo5757f();
        if (r2 != 0) goto L_0x0381;
    L_0x037e:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0381:
        r6 = r2;
        r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6;
    L_0x0384:
        if (r6 == 0) goto L_0x02b5;
    L_0x0386:
        r1.add(r6);
        goto L_0x02b5;
    L_0x038b:
        r1 = (java.util.List) r1;
        r1 = (java.util.Collection) r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings.a(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor):java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>");
    }

    private final LazyJavaClassDescriptor m33185a(ClassDescriptor classDescriptor) {
        if (Intrinsics.m26845a(DescriptorUtilsKt.m27738a((DeclarationDescriptor) classDescriptor), KotlinBuiltIns.f25420j.f25380a)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = (FqNameUnsafe) AddToStdlibKt.m28126a(DescriptorUtilsKt.m27738a((DeclarationDescriptor) classDescriptor), JvmBuiltInsSettings$getJavaAnalogue$fqName$1.f38777a);
        if (fqNameUnsafe != null) {
            classDescriptor = fqNameUnsafe.m27420d();
            if (classDescriptor != null) {
                classDescriptor = this.f32802c.m27443a(classDescriptor.m27409b());
                if (classDescriptor != null) {
                    Object f = classDescriptor.m27403f();
                    if (f != null) {
                        ModuleDescriptor g = m33194g();
                        Intrinsics.m26843a(f, "javaAnalogueFqName");
                        classDescriptor = DescriptorUtilKt.m27058a(g, f, NoLookupLocation.f32674d);
                        if (!(classDescriptor instanceof LazyJavaClassDescriptor)) {
                            classDescriptor = null;
                        }
                        return (LazyJavaClassDescriptor) classDescriptor;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public final boolean mo5826a(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
        Intrinsics.m26847b(simpleFunctionDescriptor, "functionDescriptor");
        if (!simpleFunctionDescriptor.mo5718q().mo6682b(PlatformDependentDeclarationFilterKt.m27864a())) {
            return true;
        }
        if (!m33195h()) {
            return false;
        }
        deserializedClassDescriptor = m33185a((ClassDescriptor) deserializedClassDescriptor);
        if (deserializedClassDescriptor == null) {
            return true;
        }
        Object a = MethodSignatureMappingKt.m27351a((FunctionDescriptor) simpleFunctionDescriptor, true);
        deserializedClassDescriptor = deserializedClassDescriptor.f40957b;
        Name i = simpleFunctionDescriptor.mo6689i();
        Intrinsics.m26843a((Object) i, "functionDescriptor.name");
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : deserializedClassDescriptor.mo6698b(i, (LookupLocation) NoLookupLocation.f32674d)) {
            if (Intrinsics.m26845a(MethodSignatureMappingKt.m27351a((FunctionDescriptor) simpleFunctionDescriptor2, true), a) != null) {
                return true;
            }
        }
        return false;
    }

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        Set h = Companion.m27312h();
        String[] a = SignatureBuildingComponents.m27361a("D");
        h = SetsKt___SetsKt.m32819a(h, (Iterable) SignatureBuildingComponents.m27360a("Float", (String[]) Arrays.copyOf(a, a.length)));
        a = SignatureBuildingComponents.m27361a("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f32800o = SetsKt___SetsKt.m32819a(h, (Iterable) SignatureBuildingComponents.m27360a("String", (String[]) Arrays.copyOf(a, a.length)));
        signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        String[] a2 = SignatureBuildingComponents.m27361a("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f32801p = SignatureBuildingComponents.m27360a("Throwable", (String[]) Arrays.copyOf(a2, a2.length));
    }

    public final Collection<ClassConstructorDescriptor> mo5828c(DeserializedClassDescriptor deserializedClassDescriptor) {
        Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
        if ((Intrinsics.m26845a(deserializedClassDescriptor.f40868a, ClassKind.CLASS) ^ 1) == 0) {
            if (m33195h()) {
                LazyJavaClassDescriptor a = m33185a((ClassDescriptor) deserializedClassDescriptor);
                if (a == null) {
                    return CollectionsKt__CollectionsKt.m26790a();
                }
                JavaToKotlinClassMap javaToKotlinClassMap = this.f32802c;
                FqName b = DescriptorUtilsKt.m27742b((DeclarationDescriptor) a);
                kotlin.reflect.jvm.internal.impl.load.kotlin.FallbackBuiltIns.Companion companion = FallbackBuiltIns.f32786a;
                Object a2 = javaToKotlinClassMap.m27441a(b, kotlin.reflect.jvm.internal.impl.load.kotlin.FallbackBuiltIns.Companion.m27301a());
                if (a2 == null) {
                    return CollectionsKt__CollectionsKt.m26790a();
                }
                Intrinsics.m26843a(a2, "defaultKotlinVersion");
                ClassDescriptor classDescriptor = a;
                TypeSubstitutor d = MappingUtilKt.m27447a(a2, classDescriptor).m27987d();
                JvmBuiltInsSettings$getConstructors$1 jvmBuiltInsSettings$getConstructors$1 = new JvmBuiltInsSettings$getConstructors$1(d);
                Collection arrayList = new ArrayList();
                for (Object next : a.m43035w()) {
                    Object obj = (ClassConstructorDescriptor) next;
                    int i = 0;
                    if (obj.mo7257j().f25520a) {
                        int i2;
                        for (ConstructorDescriptor constructorDescriptor : a2.mo7770f()) {
                            Intrinsics.m26843a(obj, "javaConstructor");
                            if (jvmBuiltInsSettings$getConstructors$1.m38534a(constructorDescriptor, (ConstructorDescriptor) obj)) {
                                i2 = 0;
                                break;
                            }
                        }
                        i2 = 1;
                        if (i2 != 0) {
                            Set e;
                            SignatureBuildingComponents signatureBuildingComponents;
                            String a3;
                            ConstructorDescriptor constructorDescriptor2 = (ConstructorDescriptor) obj;
                            if (constructorDescriptor2.mo7757k().size() == 1) {
                                ClassifierDescriptor c = ((ValueParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(constructorDescriptor2.mo7757k())).mo7777x().mo6743g().mo5724c();
                                if (Intrinsics.m26845a(c != null ? DescriptorUtilsKt.m27738a((DeclarationDescriptor) c) : null, DescriptorUtilsKt.m27738a((DeclarationDescriptor) deserializedClassDescriptor))) {
                                    i2 = 1;
                                    if (i2 == 0 && !KotlinBuiltIns.m26981b((DeclarationDescriptor) obj)) {
                                        e = Companion.m27309e();
                                        signatureBuildingComponents = SignatureBuildingComponents.f25810a;
                                        a3 = MethodSignatureMappingKt.m27351a((FunctionDescriptor) obj, true);
                                        Intrinsics.m26843a((Object) a3, "javaConstructor.computeJvmDescriptor()");
                                        if ((e.contains(SignatureBuildingComponents.m27359a(classDescriptor, a3)) ^ 1) != 0) {
                                            i = 1;
                                        }
                                    }
                                }
                            }
                            i2 = 0;
                            e = Companion.m27309e();
                            signatureBuildingComponents = SignatureBuildingComponents.f25810a;
                            a3 = MethodSignatureMappingKt.m27351a((FunctionDescriptor) obj, true);
                            Intrinsics.m26843a((Object) a3, "javaConstructor.computeJvmDescriptor()");
                            if ((e.contains(SignatureBuildingComponents.m27359a(classDescriptor, a3)) ^ 1) != 0) {
                                i = 1;
                            }
                        }
                    }
                    if (i != 0) {
                        arrayList.add(next);
                    }
                }
                Iterable<ClassConstructorDescriptor> iterable = (List) arrayList;
                Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (ClassConstructorDescriptor classConstructorDescriptor : iterable) {
                    CopyBuilder C = classConstructorDescriptor.mo7736C();
                    C.mo5743a((DeclarationDescriptor) deserializedClassDescriptor);
                    C.mo5749a((KotlinType) deserializedClassDescriptor.mo7714h());
                    C.mo5752b();
                    C.mo5750a(d.m28004a());
                    Set f = Companion.m27310f();
                    SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.f25810a;
                    String a4 = MethodSignatureMappingKt.m27351a((FunctionDescriptor) classConstructorDescriptor, true);
                    Intrinsics.m26843a((Object) a4, "javaConstructor.computeJvmDescriptor()");
                    if ((f.contains(SignatureBuildingComponents.m27359a(classDescriptor, a4)) ^ 1) != 0) {
                        C.mo5747a((Annotations) m33197j());
                    }
                    FunctionDescriptor f2 = C.mo5757f();
                    if (f2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                    }
                    arrayList2.add((ClassConstructorDescriptor) f2);
                }
                return (List) arrayList2;
            }
        }
        return CollectionsKt__CollectionsKt.m26790a();
    }
}
