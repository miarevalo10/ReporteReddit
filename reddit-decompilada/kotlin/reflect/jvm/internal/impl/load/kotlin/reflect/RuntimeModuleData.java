package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.ExternalAnnotationResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator.DoNothing;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.RuntimeErrorReporter;
import kotlin.reflect.jvm.internal.impl.load.java.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.reflect.ReflectJavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: RuntimeModuleData.kt */
public final class RuntimeModuleData {
    public static final Companion f25847c = new Companion();
    public final DeserializationComponents f25848a;
    public final RuntimePackagePartProvider f25849b;

    /* compiled from: RuntimeModuleData.kt */
    public static final class Companion {
        private Companion() {
        }

        public static RuntimeModuleData m27392a(ClassLoader classLoader) {
            ClassLoader classLoader2 = classLoader;
            Intrinsics.m26847b(classLoader2, "classLoader");
            StorageManager lockBasedStorageManager = new LockBasedStorageManager();
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager);
            StringBuilder stringBuilder = new StringBuilder("<runtime module for ");
            stringBuilder.append(classLoader2);
            stringBuilder.append(Operation.GREATER_THAN);
            Object c = Name.m27426c(stringBuilder.toString());
            Intrinsics.m26843a(c, "Name.special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(c, lockBasedStorageManager, jvmBuiltIns, null, null, 56);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader2);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            RuntimePackagePartProvider runtimePackagePartProvider = new RuntimePackagePartProvider(classLoader2);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            JavaClassFinder reflectJavaClassFinder = new ReflectJavaClassFinder(classLoader2);
            KotlinClassFinder kotlinClassFinder = reflectKotlinClassFinder;
            Object obj = ExternalAnnotationResolver.f25648a;
            Intrinsics.m26843a(obj, "ExternalAnnotationResolver.EMPTY");
            SignaturePropagator signaturePropagator = SignaturePropagator.f25669a;
            Intrinsics.m26843a((Object) signaturePropagator, "SignaturePropagator.DO_NOTHING");
            ErrorReporter errorReporter = RuntimeErrorReporter.f32702a;
            Intrinsics.m26843a((Object) javaResolverCache, "javaResolverCache");
            JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator = DoNothing.f32701a;
            SamConversionResolver samConversionResolver = SamConversionResolver.f25662a;
            JavaSourceElementFactory javaSourceElementFactory = RuntimeSourceElementFactory.f32703a;
            ModuleClassResolver moduleClassResolver = singleModuleClassResolver;
            PackagePartProvider packagePartProvider = runtimePackagePartProvider;
            SupertypeLoopChecker supertypeLoopChecker = EMPTY.f32638a;
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.Companion companion = LookupTracker.f25593a;
            ModuleDescriptor moduleDescriptor = moduleDescriptorImpl;
            ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
            StorageManager storageManager = lockBasedStorageManager;
            JavaResolverComponents javaResolverComponents = r3;
            JavaResolverCache javaResolverCache2 = javaResolverCache;
            RuntimePackagePartProvider runtimePackagePartProvider2 = runtimePackagePartProvider;
            SingleModuleClassResolver singleModuleClassResolver2 = singleModuleClassResolver;
            KotlinClassFinder kotlinClassFinder2 = kotlinClassFinder;
            DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
            ModuleDescriptorImpl moduleDescriptorImpl2 = moduleDescriptorImpl;
            JavaResolverComponents javaResolverComponents2 = new JavaResolverComponents(lockBasedStorageManager, reflectJavaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, obj, signaturePropagator, errorReporter, javaResolverCache2, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.Companion.m27125a(), moduleDescriptor2, new ReflectionTypes(moduleDescriptor));
            LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = new LazyJavaPackageFragmentProvider(javaResolverComponents);
            ModuleDescriptor moduleDescriptor3 = moduleDescriptor2;
            Intrinsics.m26847b(moduleDescriptor3, "moduleDescriptor");
            boolean z = jvmBuiltIns.f32854a == null;
            if (!_Assertions.f25274a || z) {
                jvmBuiltIns.f32854a = moduleDescriptor3;
                jvmBuiltIns.f32855m = true;
                c = javaResolverCache2;
                Intrinsics.m26843a(c, "javaResolverCache");
                JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProvider, c);
                KotlinClassFinder kotlinClassFinder3 = kotlinClassFinder2;
                JavaClassDataFinder javaClassDataFinder = new JavaClassDataFinder(kotlinClassFinder3, deserializedDescriptorResolver2);
                StorageManager storageManager2 = storageManager;
                NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager2, moduleDescriptor3);
                BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = new BinaryClassAnnotationAndConstantLoaderImpl(moduleDescriptor3, notFoundClasses, storageManager2, kotlinClassFinder3);
                DeserializationConfiguration deserializationConfiguration = Default.f33033a;
                ErrorReporter errorReporter2 = RuntimeErrorReporter.f32702a;
                companion = LookupTracker.f25593a;
                DeserializationComponentsForJava deserializationComponentsForJava = new DeserializationComponentsForJava(storageManager2, moduleDescriptor3, deserializationConfiguration, javaClassDataFinder, binaryClassAnnotationAndConstantLoaderImpl, lazyJavaPackageFragmentProvider, notFoundClasses, errorReporter2, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.Companion.m27125a());
                Intrinsics.m26847b(javaDescriptorResolver, "<set-?>");
                singleModuleClassResolver2.f32712a = javaDescriptorResolver;
                Intrinsics.m26847b(deserializationComponentsForJava, "components");
                deserializedDescriptorResolver2.f25789a = deserializationComponentsForJava.f25783a;
                r0 = new ModuleDescriptorImpl[2];
                moduleDescriptorImpl = moduleDescriptorImpl2;
                r0[0] = moduleDescriptorImpl;
                Object h = jvmBuiltIns.m27010h();
                Intrinsics.m26843a(h, "builtIns.builtInsModule");
                r0[1] = h;
                moduleDescriptorImpl.m38339a(r0);
                moduleDescriptorImpl.m38338a((PackageFragmentProvider) javaDescriptorResolver.f26091a);
                return new RuntimeModuleData(deserializationComponentsForJava.f25783a, runtimePackagePartProvider2);
            }
            throw new AssertionError("JvmBuiltins repeated initialization");
        }
    }

    private RuntimeModuleData(DeserializationComponents deserializationComponents, RuntimePackagePartProvider runtimePackagePartProvider) {
        this.f25848a = deserializationComponents;
        this.f25849b = runtimePackagePartProvider;
    }
}
