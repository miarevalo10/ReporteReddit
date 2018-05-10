package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: context.kt */
public final class DeserializationComponents {
    public final ClassDeserializer f26228a = new ClassDeserializer(this);
    public final StorageManager f26229b;
    public final ModuleDescriptor f26230c;
    public final DeserializationConfiguration f26231d;
    final ClassDataFinder f26232e;
    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>, AnnotationWithTarget> f26233f;
    final PackageFragmentProvider f26234g;
    public final ErrorReporter f26235h;
    public final LookupTracker f26236i;
    final FlexibleTypeDeserializer f26237j;
    public final Iterable<ClassDescriptorFactory> f26238k;
    public final NotFoundClasses f26239l;
    public final AdditionalClassPartsProvider f26240m;
    public final PlatformDependentDeclarationFilter f26241n;
    private final LocalClassifierTypeSettings f26242o;

    public DeserializationComponents(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>, AnnotationWithTarget> annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable<? extends ClassDescriptorFactory> iterable, NotFoundClasses notFoundClasses, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(moduleDescriptor, "moduleDescriptor");
        Intrinsics.m26847b(deserializationConfiguration, "configuration");
        Intrinsics.m26847b(classDataFinder, "classDataFinder");
        Intrinsics.m26847b(annotationAndConstantLoader, "annotationAndConstantLoader");
        Intrinsics.m26847b(packageFragmentProvider, "packageFragmentProvider");
        Intrinsics.m26847b(localClassifierTypeSettings, "localClassifierTypeSettings");
        Intrinsics.m26847b(errorReporter, "errorReporter");
        Intrinsics.m26847b(lookupTracker, "lookupTracker");
        Intrinsics.m26847b(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        Intrinsics.m26847b(iterable, "fictitiousClassDescriptorFactories");
        Intrinsics.m26847b(notFoundClasses, "notFoundClasses");
        Intrinsics.m26847b(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics.m26847b(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        this.f26229b = storageManager;
        this.f26230c = moduleDescriptor;
        this.f26231d = deserializationConfiguration;
        this.f26232e = classDataFinder;
        this.f26233f = annotationAndConstantLoader;
        this.f26234g = packageFragmentProvider;
        this.f26242o = localClassifierTypeSettings;
        this.f26235h = errorReporter;
        this.f26236i = lookupTracker;
        this.f26237j = flexibleTypeDeserializer;
        this.f26238k = iterable;
        this.f26239l = notFoundClasses;
        this.f26240m = additionalClassPartsProvider;
        this.f26241n = platformDependentDeclarationFilter;
    }

    public final ClassDescriptor m27832a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        return this.f26228a.m27825a(classId, null);
    }

    public final DeserializationContext m27833a(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics.m26847b(packageFragmentDescriptor, "descriptor");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(typeTable, "typeTable");
        Intrinsics.m26847b(sinceKotlinInfoTable, "sinceKotlinInfoTable");
        return new DeserializationContext(this, nameResolver, packageFragmentDescriptor, typeTable, sinceKotlinInfoTable, deserializedContainerSource, null, CollectionsKt__CollectionsKt.m26790a());
    }
}
