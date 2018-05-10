package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.platform.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider.None;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializationComponentsForJava.kt */
public final class DeserializationComponentsForJava {
    public final DeserializationComponents f25783a;

    public DeserializationComponentsForJava(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, JavaClassDataFinder javaClassDataFinder, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, NotFoundClasses notFoundClasses, ErrorReporter errorReporter, LookupTracker lookupTracker) {
        JvmBuiltInsSettings a;
        AdditionalClassPartsProvider additionalClassPartsProvider;
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
        DeserializationComponents deserializationComponents;
        DeserializationComponents deserializationComponents2;
        JavaClassDataFinder javaClassDataFinder2 = javaClassDataFinder;
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl2 = binaryClassAnnotationAndConstantLoaderImpl;
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider2 = lazyJavaPackageFragmentProvider;
        StorageManager storageManager2 = storageManager;
        Intrinsics.m26847b(storageManager2, "storageManager");
        ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        Intrinsics.m26847b(moduleDescriptor2, "moduleDescriptor");
        DeserializationConfiguration deserializationConfiguration2 = deserializationConfiguration;
        Intrinsics.m26847b(deserializationConfiguration2, "configuration");
        Intrinsics.m26847b(javaClassDataFinder2, "classDataFinder");
        Intrinsics.m26847b(binaryClassAnnotationAndConstantLoaderImpl2, "annotationAndConstantLoader");
        Intrinsics.m26847b(lazyJavaPackageFragmentProvider2, "packageFragmentProvider");
        Intrinsics.m26847b(notFoundClasses, "notFoundClasses");
        ErrorReporter errorReporter2 = errorReporter;
        Intrinsics.m26847b(errorReporter2, "errorReporter");
        LookupTracker lookupTracker2 = lookupTracker;
        Intrinsics.m26847b(lookupTracker2, "lookupTracker");
        KotlinBuiltIns b = moduleDescriptor.mo7089b();
        if (!(b instanceof JvmBuiltIns)) {
            b = null;
        }
        JvmBuiltIns jvmBuiltIns = (JvmBuiltIns) b;
        ClassDataFinder classDataFinder = javaClassDataFinder2;
        AnnotationAndConstantLoader annotationAndConstantLoader = binaryClassAnnotationAndConstantLoaderImpl2;
        PackageFragmentProvider packageFragmentProvider = lazyJavaPackageFragmentProvider2;
        LocalClassifierTypeSettings localClassifierTypeSettings = Default.f33036a;
        FlexibleTypeDeserializer flexibleTypeDeserializer = JavaFlexibleTypeDeserializer.f32790a;
        Iterable a2 = CollectionsKt__CollectionsKt.m26790a();
        if (jvmBuiltIns != null) {
            a = jvmBuiltIns.m33271a();
            if (a != null) {
                additionalClassPartsProvider = a;
                if (jvmBuiltIns != null) {
                    a = jvmBuiltIns.m33271a();
                    if (a != null) {
                        platformDependentDeclarationFilter = a;
                        deserializationComponents = deserializationComponents2;
                        deserializationComponents2 = new DeserializationComponents(storageManager2, moduleDescriptor2, deserializationConfiguration2, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter2, lookupTracker2, flexibleTypeDeserializer, a2, notFoundClasses, additionalClassPartsProvider, platformDependentDeclarationFilter);
                        this.f25783a = deserializationComponents;
                    }
                }
                a = NoPlatformDependent.f33040a;
                platformDependentDeclarationFilter = a;
                deserializationComponents = deserializationComponents2;
                deserializationComponents2 = new DeserializationComponents(storageManager2, moduleDescriptor2, deserializationConfiguration2, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter2, lookupTracker2, flexibleTypeDeserializer, a2, notFoundClasses, additionalClassPartsProvider, platformDependentDeclarationFilter);
                this.f25783a = deserializationComponents;
            }
        }
        a = None.f33030a;
        additionalClassPartsProvider = a;
        if (jvmBuiltIns != null) {
            a = jvmBuiltIns.m33271a();
            if (a != null) {
                platformDependentDeclarationFilter = a;
                deserializationComponents = deserializationComponents2;
                deserializationComponents2 = new DeserializationComponents(storageManager2, moduleDescriptor2, deserializationConfiguration2, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter2, lookupTracker2, flexibleTypeDeserializer, a2, notFoundClasses, additionalClassPartsProvider, platformDependentDeclarationFilter);
                this.f25783a = deserializationComponents;
            }
        }
        a = NoPlatformDependent.f33040a;
        platformDependentDeclarationFilter = a;
        deserializationComponents = deserializationComponents2;
        deserializationComponents2 = new DeserializationComponents(storageManager2, moduleDescriptor2, deserializationConfiguration2, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter2, lookupTracker2, flexibleTypeDeserializer, a2, notFoundClasses, additionalClassPartsProvider, platformDependentDeclarationFilter);
        this.f25783a = deserializationComponents;
    }
}
