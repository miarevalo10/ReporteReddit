package kotlin.reflect.jvm.internal.impl.builtins;

import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider.None;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public abstract class KotlinBuiltIns {
    private static final FqName f25413a;
    public static final Name f25414b;
    public static final FqName f25415c;
    public static final FqName f25416d = f25415c.m27408a(Name.m27424a("collections"));
    public static final FqName f25417e = f25415c.m27408a(Name.m27424a("ranges"));
    public static final FqName f25418f = f25415c.m27408a(Name.m27424a("text"));
    public static final Set<FqName> f25419g = SetsKt__SetsKt.m26802a((Object[]) new FqName[]{f25415c, f25416d, f25417e, f25413a, ReflectionTypesKt.m27032a(), f25415c.m27408a(Name.m27424a("internal"))});
    public static final FqNames f25420j = new FqNames();
    public static final Name f25421k = Name.m27426c("<built-ins module>");
    static final /* synthetic */ boolean f25422l = true;
    public final NotNullLazyValue<Primitives> f25423h;
    public final NotNullLazyValue<PackageFragments> f25424i;
    private ModuleDescriptorImpl f25425m;
    private final MemoizedFunctionToNotNull<Integer, ClassDescriptor> f25426n;
    private final StorageManager f25427o;

    public static class FqNames {
        public final FqName f25354A = m26960b("ParameterName");
        public final FqName f25355B = m26960b("Annotation");
        public final FqName f25356C = m26964f("Target");
        public final FqName f25357D = m26964f("AnnotationTarget");
        public final FqName f25358E = m26964f("AnnotationRetention");
        public final FqName f25359F = m26964f("Retention");
        public final FqName f25360G = m26964f("Repeatable");
        public final FqName f25361H = m26964f("MustBeDocumented");
        public final FqName f25362I = m26960b("UnsafeVariance");
        public final FqName f25363J = m26960b("PublishedApi");
        public final FqName f25364K = m26961c("Iterator");
        public final FqName f25365L = m26961c("Iterable");
        public final FqName f25366M = m26961c("Collection");
        public final FqName f25367N = m26961c("List");
        public final FqName f25368O = m26961c("ListIterator");
        public final FqName f25369P = m26961c("Set");
        public final FqName f25370Q = m26961c("Map");
        public final FqName f25371R = this.f25370Q.m27408a(Name.m27424a("Entry"));
        public final FqName f25372S = m26961c("MutableIterator");
        public final FqName f25373T = m26961c("MutableIterable");
        public final FqName f25374U = m26961c("MutableCollection");
        public final FqName f25375V = m26961c("MutableList");
        public final FqName f25376W = m26961c("MutableListIterator");
        public final FqName f25377X = m26961c("MutableSet");
        public final FqName f25378Y = m26961c("MutableMap");
        public final FqName f25379Z = this.f25378Y.m27408a(Name.m27424a("MutableEntry"));
        public final FqNameUnsafe f25380a = m26959a("Any");
        public final FqNameUnsafe aa = m26963e("KClass");
        public final FqNameUnsafe ab = m26963e("KCallable");
        public final FqNameUnsafe ac = m26963e("KProperty0");
        public final FqNameUnsafe ad = m26963e("KProperty1");
        public final FqNameUnsafe ae = m26963e("KProperty2");
        public final FqNameUnsafe af = m26963e("KMutableProperty0");
        public final FqNameUnsafe ag = m26963e("KMutableProperty1");
        public final FqNameUnsafe ah = m26963e("KMutableProperty2");
        public final ClassId ai = ClassId.m27396a(m26963e("KProperty").m27420d());
        public final Map<FqNameUnsafe, PrimitiveType> aj;
        public final Map<FqNameUnsafe, PrimitiveType> ak;
        public final FqNameUnsafe f25381b = m26959a("Nothing");
        public final FqNameUnsafe f25382c = m26959a("Cloneable");
        public final FqNameUnsafe f25383d = m26959a("Suppress");
        public final FqNameUnsafe f25384e = m26959a("Unit");
        public final FqNameUnsafe f25385f = m26959a("CharSequence");
        public final FqNameUnsafe f25386g = m26959a("String");
        public final FqNameUnsafe f25387h = m26959a("Array");
        public final FqNameUnsafe f25388i = m26959a("Boolean");
        public final FqNameUnsafe f25389j = m26959a("Char");
        public final FqNameUnsafe f25390k = m26959a("Byte");
        public final FqNameUnsafe f25391l = m26959a("Short");
        public final FqNameUnsafe f25392m = m26959a("Int");
        public final FqNameUnsafe f25393n = m26959a("Long");
        public final FqNameUnsafe f25394o = m26959a("Float");
        public final FqNameUnsafe f25395p = m26959a("Double");
        public final FqNameUnsafe f25396q = m26959a("Number");
        public final FqNameUnsafe f25397r = m26959a("Enum");
        public final FqName f25398s = m26960b("Throwable");
        public final FqName f25399t = m26960b("Comparable");
        public final FqNameUnsafe f25400u = m26962d("CharRange");
        public final FqNameUnsafe f25401v = m26962d("IntRange");
        public final FqNameUnsafe f25402w = m26962d("LongRange");
        public final FqName f25403x = m26960b("Deprecated");
        public final FqName f25404y = m26960b("DeprecationLevel");
        public final FqName f25405z = m26960b("ExtensionFunctionType");

        public FqNames() {
            int i = 0;
            this.aj = new HashMap(0);
            this.ak = new HashMap(0);
            PrimitiveType[] values = PrimitiveType.values();
            int length = values.length;
            while (i < length) {
                PrimitiveType primitiveType = values[i];
                this.aj.put(m26959a(primitiveType.m27028a().m27429a()), primitiveType);
                this.ak.put(m26959a(primitiveType.m27029b().m27429a()), primitiveType);
                i++;
            }
        }

        private static FqNameUnsafe m26959a(String str) {
            if (str == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "fqNameUnsafe"}));
            }
            str = m26960b(str).m27409b();
            if (str != null) {
                return str;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "fqNameUnsafe"}));
        }

        private static FqName m26960b(String str) {
            if (str != null) {
                return KotlinBuiltIns.f25415c.m27408a(Name.m27424a(str));
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "fqName"}));
        }

        private static FqName m26961c(String str) {
            return KotlinBuiltIns.f25416d.m27408a(Name.m27424a(str));
        }

        private static FqNameUnsafe m26962d(String str) {
            str = KotlinBuiltIns.f25417e.m27408a(Name.m27424a(str)).m27409b();
            if (str != null) {
                return str;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "rangesFqName"}));
        }

        private static FqNameUnsafe m26963e(String str) {
            str = ReflectionTypesKt.m27032a().m27408a(Name.m27424a(str)).m27409b();
            if (str != null) {
                return str;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "reflect"}));
        }

        private static FqName m26964f(String str) {
            return KotlinBuiltIns.f25413a.m27408a(Name.m27424a(str));
        }
    }

    private static class PackageFragments {
        public final PackageFragmentDescriptor f25406a;
        public final PackageFragmentDescriptor f25407b;
        public final PackageFragmentDescriptor f25408c;
        public final Set<PackageFragmentDescriptor> f25409d;

        private PackageFragments(PackageFragmentDescriptor packageFragmentDescriptor, PackageFragmentDescriptor packageFragmentDescriptor2, PackageFragmentDescriptor packageFragmentDescriptor3, Set<PackageFragmentDescriptor> set) {
            if (packageFragmentDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"builtInsPackageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"}));
            } else if (packageFragmentDescriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"collectionsPackageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"}));
            } else if (packageFragmentDescriptor3 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotationPackageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"}));
            } else if (set == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"allImportedByDefaultBuiltInsPackageFragments", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"}));
            } else {
                this.f25406a = packageFragmentDescriptor;
                this.f25407b = packageFragmentDescriptor2;
                this.f25408c = packageFragmentDescriptor3;
                this.f25409d = set;
            }
        }
    }

    private static class Primitives {
        public final Map<PrimitiveType, SimpleType> f25410a;
        public final Map<KotlinType, SimpleType> f25411b;
        public final Map<SimpleType, SimpleType> f25412c;

        private Primitives(Map<PrimitiveType, SimpleType> map, Map<KotlinType, SimpleType> map2, Map<SimpleType, SimpleType> map3) {
            if (map == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"primitiveTypeToArrayKotlinType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives", "<init>"}));
            } else if (map2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"primitiveKotlinTypeToKotlinArrayType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives", "<init>"}));
            } else if (map3 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kotlinArrayTypeToPrimitiveKotlinType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives", "<init>"}));
            } else {
                this.f25410a = map;
                this.f25411b = map2;
                this.f25412c = map3;
            }
        }
    }

    class C27391 implements Function0<PackageFragments> {
        final /* synthetic */ KotlinBuiltIns f36045a;

        C27391(KotlinBuiltIns kotlinBuiltIns) {
            this.f36045a = kotlinBuiltIns;
        }

        public /* synthetic */ Object invoke() {
            PackageFragmentProvider d = this.f36045a.f25425m.m38344d();
            Map linkedHashMap = new LinkedHashMap();
            PackageFragmentDescriptor a = KotlinBuiltIns.m26968a(this.f36045a, d, linkedHashMap, KotlinBuiltIns.f25415c);
            PackageFragmentDescriptor a2 = KotlinBuiltIns.m26968a(this.f36045a, d, linkedHashMap, KotlinBuiltIns.f25416d);
            KotlinBuiltIns.m26968a(this.f36045a, d, linkedHashMap, KotlinBuiltIns.f25417e);
            return new PackageFragments(a, a2, KotlinBuiltIns.m26968a(this.f36045a, d, linkedHashMap, KotlinBuiltIns.f25413a), new LinkedHashSet(linkedHashMap.values()));
        }
    }

    class C27402 implements Function0<Primitives> {
        final /* synthetic */ KotlinBuiltIns f36046a;

        C27402(KotlinBuiltIns kotlinBuiltIns) {
            this.f36046a = kotlinBuiltIns;
        }

        public /* synthetic */ Object invoke() {
            Map enumMap = new EnumMap(PrimitiveType.class);
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                SimpleType a = KotlinBuiltIns.m26970a(this.f36046a, primitiveType.m27028a().m27429a());
                SimpleType a2 = KotlinBuiltIns.m26970a(this.f36046a, primitiveType.m27029b().m27429a());
                enumMap.put(primitiveType, a2);
                hashMap.put(a, a2);
                hashMap2.put(a2, a);
            }
            return new Primitives(enumMap, hashMap, hashMap2);
        }
    }

    class C27413 implements Function1<Integer, ClassDescriptor> {
        final /* synthetic */ KotlinBuiltIns f36047a;

        C27413(KotlinBuiltIns kotlinBuiltIns) {
            this.f36047a = kotlinBuiltIns;
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            return new FunctionClassDescriptor(this.f36047a.m27009g(), ((PackageFragments) this.f36047a.f25424i.invoke()).f25406a, Kind.f25457b, ((Integer) obj).intValue());
        }
    }

    class C27424 implements Function1<String, InputStream> {
        final /* synthetic */ KotlinBuiltIns f36048a;

        C27424(KotlinBuiltIns kotlinBuiltIns) {
            this.f36048a = kotlinBuiltIns;
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            String str = (String) obj;
            ClassLoader classLoader = KotlinBuiltIns.class.getClassLoader();
            return classLoader != null ? classLoader.getResourceAsStream(str) : ClassLoader.getSystemResourceAsStream(str);
        }
    }

    static /* synthetic */ PackageFragmentDescriptor m26968a(KotlinBuiltIns kotlinBuiltIns, PackageFragmentProvider packageFragmentProvider, Map map, FqName fqName) {
        if (packageFragmentProvider == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fragmentProvider", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "createPackage"}));
        } else if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"packageFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "createPackage"}));
        } else {
            final List a = packageFragmentProvider.mo5712a(fqName);
            if (a.isEmpty() != null) {
                packageFragmentProvider = new EmptyPackageFragmentDescriptor(kotlinBuiltIns.f25425m, fqName);
            } else if (a.size() == 1) {
                packageFragmentProvider = (PackageFragmentDescriptor) a.iterator().next();
            } else {
                final FqName fqName2 = fqName;
                PackageFragmentProvider c30476 = new PackageFragmentDescriptorImpl(kotlinBuiltIns, kotlinBuiltIns.f25425m, fqName) {
                    final /* synthetic */ KotlinBuiltIns f40754c;

                    class C27431 implements Function1<PackageFragmentDescriptor, MemberScope> {
                        final /* synthetic */ C30476 f36049a;

                        C27431(C30476 c30476) {
                            this.f36049a = c30476;
                        }

                        public final /* synthetic */ Object mo6492a(Object obj) {
                            return ((PackageFragmentDescriptor) obj).aC_();
                        }
                    }

                    public final MemberScope aC_() {
                        StringBuilder stringBuilder = new StringBuilder("built-in package ");
                        stringBuilder.append(fqName2);
                        return new ChainedMemberScope(stringBuilder.toString(), CollectionsKt___CollectionsKt.m41431d(a, new C27431(this)));
                    }
                };
            }
            map.put(fqName, packageFragmentProvider);
            if (packageFragmentProvider != null) {
                return packageFragmentProvider;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "createPackage"}));
        }
    }

    static /* synthetic */ SimpleType m26970a(KotlinBuiltIns kotlinBuiltIns, String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classSimpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInTypeByClassName"}));
        }
        kotlinBuiltIns = kotlinBuiltIns.m26997a(str).mo7714h();
        if (kotlinBuiltIns != null) {
            return kotlinBuiltIns;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInTypeByClassName"}));
    }

    static {
        Name a = Name.m27424a("kotlin");
        f25414b = a;
        FqName b = FqName.m27406b(a);
        f25415c = b;
        f25413a = b.m27408a(Name.m27424a("annotation"));
    }

    protected KotlinBuiltIns(StorageManager storageManager) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "<init>"}));
        }
        this.f25427o = storageManager;
        this.f25424i = storageManager.mo5926a(new C27391(this));
        this.f25423h = storageManager.mo5926a(new C27402(this));
        this.f25426n = storageManager.mo5925a(new C27413(this));
    }

    protected final void m27005c() {
        this.f25425m = new ModuleDescriptorImpl(f25421k, this.f25427o, this);
        this.f25425m.m38338a(BuiltInsPackageFragmentProviderKt.m26940a(this.f25427o, this.f25425m, f25419g, mo5858f(), mo5822e(), mo5857d(), new C27424(this)));
        this.f25425m.m38339a(this.f25425m);
    }

    public AdditionalClassPartsProvider mo5857d() {
        AdditionalClassPartsProvider additionalClassPartsProvider = None.f33030a;
        if (additionalClassPartsProvider != null) {
            return additionalClassPartsProvider;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAdditionalClassPartsProvider"}));
    }

    public PlatformDependentDeclarationFilter mo5822e() {
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter = NoPlatformDependent.f33040a;
        if (platformDependentDeclarationFilter != null) {
            return platformDependentDeclarationFilter;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPlatformDependentDeclarationFilter"}));
    }

    public Iterable<ClassDescriptorFactory> mo5858f() {
        Iterable singletonList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.f25427o, this.f25425m));
        if (singletonList != null) {
            return singletonList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getClassDescriptorFactories"}));
    }

    protected final StorageManager m27009g() {
        StorageManager storageManager = this.f25427o;
        if (storageManager != null) {
            return storageManager;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getStorageManager"}));
    }

    public final ModuleDescriptorImpl m27010h() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.f25425m;
        if (moduleDescriptorImpl != null) {
            return moduleDescriptorImpl;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInsModule"}));
    }

    public static boolean m26973a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return DescriptorUtils.m27639a(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isBuiltIn"}));
        }
    }

    public final ClassDescriptor m26999a(Name name) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationClassByName"}));
        }
        name = m26967a(name, ((PackageFragments) this.f25424i.invoke()).f25408c);
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationClassByName"}));
    }

    public static ClassDescriptor m26967a(Name name, PackageFragmentDescriptor packageFragmentDescriptor) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
        } else if (packageFragmentDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"packageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByNameNullable"}));
        } else if (packageFragmentDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"packageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByNameNullable"}));
        } else {
            ClassifierDescriptor c = packageFragmentDescriptor.aC_().mo6699c(name, NoLookupLocation.f32674d);
            StringBuilder stringBuilder;
            if (f25422l || c == null || (c instanceof ClassDescriptor)) {
                ClassDescriptor classDescriptor = (ClassDescriptor) c;
                if (classDescriptor == null) {
                    stringBuilder = new StringBuilder("Built-in class ");
                    stringBuilder.append(packageFragmentDescriptor.mo7722d().m27408a(name).m27407a());
                    stringBuilder.append(" is not found");
                    throw new AssertionError(stringBuilder.toString());
                } else if (classDescriptor != null) {
                    return classDescriptor;
                } else {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
                }
            }
            stringBuilder = new StringBuilder("Must be a class descriptor ");
            stringBuilder.append(name);
            stringBuilder.append(", but was ");
            stringBuilder.append(c);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public final ClassDescriptor m26998a(FqName fqName) {
        if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByFqName"}));
        } else if (fqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByFqNameNullable"}));
        } else {
            ClassDescriptor a = DescriptorUtilKt.m27058a(this.f25425m, fqName, NoLookupLocation.f32674d);
            if (!f25422l && a == null) {
                StringBuilder stringBuilder = new StringBuilder("Can't find built-in class ");
                stringBuilder.append(fqName);
                throw new AssertionError(stringBuilder.toString());
            } else if (a != null) {
                return a;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByFqName"}));
            }
        }
    }

    public final ClassDescriptor m26997a(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
        }
        str = m27003b(Name.m27424a(str));
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
    }

    public final ClassDescriptor m27011i() {
        ClassDescriptor a = m26997a("Array");
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArray"}));
    }

    public static String m26965a(int i) {
        StringBuilder stringBuilder = new StringBuilder("Function");
        stringBuilder.append(i);
        i = stringBuilder.toString();
        if (i != 0) {
            return i;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFunctionName"}));
    }

    public static ClassId m26977b(int i) {
        return new ClassId(f25415c, Name.m27424a(m26965a(i)));
    }

    public final ClassDescriptor m27004c(int i) {
        ClassDescriptor classDescriptor = (ClassDescriptor) this.f25426n.mo6492a(Integer.valueOf(i));
        if (classDescriptor != null) {
            return classDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getSuspendFunction"}));
    }

    public final ClassDescriptor m27012j() {
        ClassDescriptor b = m27003b(f25420j.f25403x.m27412e());
        if (b != null) {
            return b;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDeprecatedAnnotation"}));
    }

    public static ClassDescriptor m26966a(ClassDescriptor classDescriptor, String str) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumDescriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getEnumEntry"}));
        } else if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"entryName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getEnumEntry"}));
        } else {
            classDescriptor = classDescriptor.mo7739t().mo6699c(Name.m27424a(str), NoLookupLocation.f32674d);
            return (classDescriptor instanceof ClassDescriptor) != null ? classDescriptor : null;
        }
    }

    public final ClassDescriptor m27013k() {
        ClassDescriptor a = m26999a(f25420j.f25356C.m27412e());
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getTargetAnnotation"}));
    }

    public final SimpleType m27016n() {
        SimpleType b = m27015m().mo7297b(true);
        if (b != null) {
            return b;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNullableAnyType"}));
    }

    public final SimpleType m27017o() {
        SimpleType n = m27016n();
        if (n != null) {
            return n;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDefaultBound"}));
    }

    public final SimpleType m27001a(PrimitiveType primitiveType) {
        if (primitiveType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveKotlinType"}));
        } else if (primitiveType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveClassDescriptor"}));
        } else {
            primitiveType = m26997a(primitiveType.m27028a().m27429a());
            if (primitiveType == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveClassDescriptor"}));
            }
            primitiveType = primitiveType.mo7714h();
            if (primitiveType != null) {
                return primitiveType;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveKotlinType"}));
        }
    }

    public final SimpleType m27018p() {
        SimpleType a = m27001a(PrimitiveType.BYTE);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getByteType"}));
    }

    public final SimpleType m27019q() {
        SimpleType a = m27001a(PrimitiveType.SHORT);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getShortType"}));
    }

    public final SimpleType m27020r() {
        SimpleType a = m27001a(PrimitiveType.INT);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getIntType"}));
    }

    public final SimpleType m27021s() {
        SimpleType a = m27001a(PrimitiveType.LONG);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getLongType"}));
    }

    public final SimpleType m27022t() {
        SimpleType a = m27001a(PrimitiveType.FLOAT);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFloatType"}));
    }

    public final SimpleType m27023u() {
        SimpleType a = m27001a(PrimitiveType.DOUBLE);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDoubleType"}));
    }

    public final SimpleType m27024v() {
        SimpleType a = m27001a(PrimitiveType.CHAR);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getCharType"}));
    }

    public final SimpleType m27025w() {
        SimpleType a = m27001a(PrimitiveType.BOOLEAN);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBooleanType"}));
    }

    public final KotlinType m27000a(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"arrayType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayElementType"}));
        } else if (!m26982b(kotlinType)) {
            KotlinType kotlinType2 = (KotlinType) ((Primitives) this.f25423h.invoke()).f25412c.get(TypeUtils.m28014c(kotlinType));
            if (kotlinType2 == null) {
                StringBuilder stringBuilder = new StringBuilder("not array: ");
                stringBuilder.append(kotlinType);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (kotlinType2 != null) {
                return kotlinType2;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayElementType"}));
            }
        } else if (kotlinType.mo6739a().size() != 1) {
            throw new IllegalStateException();
        } else {
            kotlinType = ((TypeProjection) kotlinType.mo6739a().get(0)).mo6736c();
            if (kotlinType != null) {
                return kotlinType;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayElementType"}));
        }
    }

    public static boolean m26974a(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe != null) {
            return m26984c(fqNameUnsafe) != null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"arrayFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveArray"}));
        }
    }

    public static PrimitiveType m26976b(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe != null) {
            return (PrimitiveType) f25420j.aj.get(fqNameUnsafe);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"primitiveClassFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveTypeByFqName"}));
    }

    public static PrimitiveType m26984c(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe != null) {
            return (PrimitiveType) f25420j.ak.get(fqNameUnsafe);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"primitiveArrayClassFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveTypeByArrayClassFqName"}));
    }

    public final SimpleType m27002a(Variance variance, KotlinType kotlinType) {
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"projectionType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayType"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"argument", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayType"}));
        } else {
            variance = Collections.singletonList(new TypeProjectionImpl(variance, kotlinType));
            kotlinType = Annotations.f32643a;
            return KotlinTypeFactory.m27950a(Companion.m27115a(), m27011i(), variance);
        }
    }

    public static boolean m26982b(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m26975a(kotlinType, f25420j.f25387h);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isArray"}));
    }

    public static boolean m26971a(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isArrayOrPrimitiveArray"}));
        }
        if (!m26972a((ClassifierDescriptor) classDescriptor, f25420j.f25387h)) {
            if (m26984c(DescriptorUtils.m27653c(classDescriptor)) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean m26986c(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveArray"}));
        }
        kotlinType = kotlinType.mo6743g().mo5724c();
        return (kotlinType == null || m26984c(DescriptorUtils.m27653c(kotlinType)) == null) ? false : true;
    }

    public static boolean m26988d(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveType"}));
        }
        ClassifierDescriptor c = kotlinType.mo6743g().mo5724c();
        return (kotlinType.mo6741c() != null || (c instanceof ClassDescriptor) == null || m26980b((ClassDescriptor) c) == null) ? false : true;
    }

    public static boolean m26980b(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return m26976b(DescriptorUtils.m27653c(classDescriptor)) != null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveClass"}));
        }
    }

    private static boolean m26975a(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClass"}));
        } else if (fqNameUnsafe == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClass"}));
        } else {
            ClassifierDescriptor c = kotlinType.mo6743g().mo5724c();
            return (c instanceof ClassDescriptor) && m26972a(c, fqNameUnsafe) != null;
        }
    }

    private static boolean m26972a(ClassifierDescriptor classifierDescriptor, FqNameUnsafe fqNameUnsafe) {
        if (classifierDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "classFqNameEquals"}));
        } else if (fqNameUnsafe != null) {
            return classifierDescriptor.mo6689i().equals(fqNameUnsafe.m27421e()) && fqNameUnsafe.equals(DescriptorUtils.m27653c(classifierDescriptor)) != null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "classFqNameEquals"}));
        }
    }

    private static boolean m26983b(KotlinType kotlinType, FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNotNullConstructedFromGivenClass"}));
        } else if (fqNameUnsafe != null) {
            return (kotlinType.mo6741c() || m26975a(kotlinType, fqNameUnsafe) == null) ? false : true;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNotNullConstructedFromGivenClass"}));
        }
    }

    public static boolean m26985c(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return m26972a((ClassifierDescriptor) classDescriptor, f25420j.f25380a);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isAny"}));
    }

    public static boolean m26989e(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m26990f(kotlinType) && kotlinType.mo6741c() == null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNothing"}));
        }
    }

    public static boolean m26990f(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m26975a(kotlinType, f25420j.f25381b);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNothingOrNullableNothing"}));
    }

    public static boolean m26991g(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m26975a(kotlinType, f25420j.f25380a);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isAnyOrNullableAny"}));
    }

    public static boolean m26992h(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m26991g(kotlinType) && kotlinType.mo6741c() != null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNullableAny"}));
        }
    }

    public static boolean m26993i(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m26992h(kotlinType);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isDefaultBound"}));
    }

    public static boolean m26994j(KotlinType kotlinType) {
        if (kotlinType != null) {
            return m26983b(kotlinType, f25420j.f25384e);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isUnit"}));
    }

    public static boolean m26995k(KotlinType kotlinType) {
        return (kotlinType == null || m26983b(kotlinType, f25420j.f25386g) == null) ? null : true;
    }

    public static boolean m26987d(ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return m26972a((ClassifierDescriptor) classDescriptor, f25420j.aa);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isKClass"}));
    }

    public static boolean m26981b(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"declarationDescriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isDeprecated"}));
        }
        boolean z;
        FqName fqName = f25420j.f25403x;
        Annotations q = declarationDescriptor.aJ_().mo5718q();
        if (q.mo6679a(fqName) == null) {
            AnnotationUseSiteTarget.Companion companion = AnnotationUseSiteTarget.f25531k;
            AnnotationUseSiteTarget a = AnnotationUseSiteTarget.Companion.m27107a(declarationDescriptor);
            if (a != null) {
                Companion companion2 = Annotations.f32643a;
                if (Companion.m27114a(q, a, fqName) != null) {
                }
            }
            z = false;
            if (z) {
                return true;
            }
            if (declarationDescriptor instanceof PropertyDescriptor) {
                return false;
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
            z = propertyDescriptor.mo7807y();
            DeclarationDescriptor b = propertyDescriptor.mo7826b();
            declarationDescriptor = propertyDescriptor.mo7827c();
            return b == null && m26981b(b) && !(z && (declarationDescriptor == null || m26981b(declarationDescriptor) == null));
        }
        z = true;
        if (z) {
            return true;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return false;
        }
        PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) declarationDescriptor;
        z = propertyDescriptor2.mo7807y();
        DeclarationDescriptor b2 = propertyDescriptor2.mo7826b();
        declarationDescriptor = propertyDescriptor2.mo7827c();
        if (b2 == null) {
        }
    }

    public static FqName m26978b(PrimitiveType primitiveType) {
        if (primitiveType != null) {
            return f25415c.m27408a(primitiveType.m27028a());
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"primitiveType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveFqName"}));
    }

    public final ClassDescriptor m27003b(Name name) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
        }
        PackageFragmentDescriptor packageFragmentDescriptor = ((PackageFragments) this.f25424i.invoke()).f25406a;
        if (packageFragmentDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInsPackageFragment"}));
        }
        name = m26967a(name, packageFragmentDescriptor);
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"}));
    }

    public final SimpleType m27014l() {
        ClassDescriptor a = m26997a("Nothing");
        if (a == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNothing"}));
        }
        SimpleType h = a.mo7714h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNothingType"}));
    }

    public final SimpleType m27015m() {
        ClassDescriptor a = m26997a("Any");
        if (a == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAny"}));
        }
        SimpleType h = a.mo7714h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnyType"}));
    }

    public final SimpleType m27026x() {
        ClassDescriptor a = m26997a("Unit");
        if (a == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getUnit"}));
        }
        SimpleType h = a.mo7714h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getUnitType"}));
    }

    public final SimpleType m27027y() {
        ClassDescriptor a = m26997a("String");
        if (a == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getString"}));
        }
        SimpleType h = a.mo7714h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getStringType"}));
    }
}
