package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.ExternalAnnotationResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltInsSettings.kt */
final class C2977x1b86dd87 extends Lambda implements Function0<LazyJavaClassDescriptor> {
    final /* synthetic */ LazyJavaClassDescriptor f38773a;
    final /* synthetic */ ClassDescriptor f38774b;

    C2977x1b86dd87(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        this.f38773a = lazyJavaClassDescriptor;
        this.f38774b = classDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.f38773a;
        Object obj = JavaResolverCache.EMPTY;
        Intrinsics.m26843a(obj, "JavaResolverCache.EMPTY");
        ClassDescriptor classDescriptor = this.f38774b;
        Intrinsics.m26847b(obj, "javaResolverCache");
        LazyJavaResolverContext lazyJavaResolverContext = lazyJavaClassDescriptor.f40956a;
        JavaResolverComponents javaResolverComponents = lazyJavaClassDescriptor.f40956a.f25703b;
        Intrinsics.m26847b(obj, "javaResolverCache");
        StorageManager storageManager = javaResolverComponents.f25685a;
        JavaClassFinder javaClassFinder = javaResolverComponents.f25686b;
        KotlinClassFinder kotlinClassFinder = javaResolverComponents.f25687c;
        DeserializedDescriptorResolver deserializedDescriptorResolver = javaResolverComponents.f25688d;
        ExternalAnnotationResolver externalAnnotationResolver = javaResolverComponents.f25689e;
        SignaturePropagator signaturePropagator = javaResolverComponents.f25690f;
        ErrorReporter errorReporter = javaResolverComponents.f25691g;
        JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator = javaResolverComponents.f25693i;
        SamConversionResolver samConversionResolver = javaResolverComponents.f25694j;
        LazyJavaResolverContext lazyJavaResolverContext2 = lazyJavaResolverContext;
        JavaSourceElementFactory javaSourceElementFactory = javaResolverComponents.f25695k;
        ModuleClassResolver moduleClassResolver = javaResolverComponents.f25696l;
        ClassDescriptor classDescriptor2 = classDescriptor;
        PackagePartProvider packagePartProvider = javaResolverComponents.f25697m;
        LazyJavaClassDescriptor lazyJavaClassDescriptor2 = lazyJavaClassDescriptor;
        SupertypeLoopChecker supertypeLoopChecker = javaResolverComponents.f25698n;
        LookupTracker lookupTracker = javaResolverComponents.f25699o;
        JavaResolverComponents javaResolverComponents2 = javaResolverComponents;
        SamConversionResolver samConversionResolver2 = samConversionResolver;
        LazyJavaResolverContext lazyJavaResolverContext3 = lazyJavaResolverContext2;
        ClassDescriptor classDescriptor3 = classDescriptor2;
        javaResolverComponents = new JavaResolverComponents(storageManager, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, externalAnnotationResolver, signaturePropagator, errorReporter, obj, javaPropertyInitializerEvaluator, samConversionResolver2, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, javaResolverComponents.f25700p, javaResolverComponents.f25701q);
        lazyJavaResolverContext3 = ContextKt.m27199a(lazyJavaResolverContext3, javaResolverComponents2);
        lazyJavaClassDescriptor = lazyJavaClassDescriptor2;
        Object aD_ = lazyJavaClassDescriptor.aD_();
        Intrinsics.m26843a(aD_, "containingDeclaration");
        return new LazyJavaClassDescriptor(lazyJavaResolverContext3, aD_, lazyJavaClassDescriptor.f40959f, classDescriptor3);
    }
}
