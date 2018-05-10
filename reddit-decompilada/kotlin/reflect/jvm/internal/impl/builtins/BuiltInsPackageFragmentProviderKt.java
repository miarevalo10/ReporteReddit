package kotlin.reflect.jvm.internal.impl.builtins;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.Companion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: builtInsPackageFragmentProvider.kt */
public final class BuiltInsPackageFragmentProviderKt {
    public static final PackageFragmentProvider m26940a(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Set<FqName> set, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, Function1<? super String, ? extends InputStream> function1) {
        StorageManager storageManager2 = storageManager;
        ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
        Set<FqName> set2 = set;
        Function1<? super String, ? extends InputStream> function12 = function1;
        Intrinsics.m26847b(storageManager2, "storageManager");
        Intrinsics.m26847b(moduleDescriptor2, "module");
        Intrinsics.m26847b(set2, "packageFqNames");
        Iterable<? extends ClassDescriptorFactory> iterable2 = iterable;
        Intrinsics.m26847b(iterable2, "classDescriptorFactories");
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter2 = platformDependentDeclarationFilter;
        Intrinsics.m26847b(platformDependentDeclarationFilter2, "platformDependentDeclarationFilter");
        AdditionalClassPartsProvider additionalClassPartsProvider2 = additionalClassPartsProvider;
        Intrinsics.m26847b(additionalClassPartsProvider2, "additionalClassPartsProvider");
        Intrinsics.m26847b(function12, "loadResource");
        Iterable<FqName> iterable3 = set2;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable3));
        for (FqName fqName : iterable3) {
            String str;
            BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.f32612b;
            Intrinsics.m26847b(fqName, "fqName");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(StringsKt__StringsJVMKt.m41941a(fqName.m27407a(), '.', '/'));
            stringBuilder.append(Operation.DIVISION);
            Intrinsics.m26847b(fqName, "fqName");
            StringBuilder stringBuilder2 = new StringBuilder();
            if (fqName.f25856b.f25861b.isEmpty()) {
                str = "default-package";
            } else {
                str = fqName.m27412e().m27429a();
                Intrinsics.m26843a((Object) str, "fqName.shortName().asString()");
            }
            stringBuilder2.append(str);
            stringBuilder2.append(".");
            stringBuilder2.append(BuiltInSerializerProtocol.f32611a);
            stringBuilder.append(stringBuilder2.toString());
            String stringBuilder3 = stringBuilder.toString();
            InputStream inputStream = (InputStream) function12.mo6492a(stringBuilder3);
            if (inputStream == null) {
                StringBuilder stringBuilder4 = new StringBuilder("Resource not found in classpath: ");
                stringBuilder4.append(stringBuilder3);
                throw new IllegalStateException(stringBuilder4.toString());
            }
            arrayList.add(new BuiltInsPackageFragment(fqName, storageManager2, moduleDescriptor2, inputStream));
        }
        List<BuiltInsPackageFragment> list = (List) arrayList;
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(list);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager2, moduleDescriptor2);
        DeserializationConfiguration deserializationConfiguration = Default.f33033a;
        PackageFragmentProvider packageFragmentProvider = packageFragmentProviderImpl;
        ClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(packageFragmentProvider);
        AnnotationAndConstantLoader annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, BuiltInSerializerProtocol.f32612b);
        LocalClassifierTypeSettings localClassifierTypeSettings = LocalClassifierTypeSettings.Default.f33036a;
        Object obj = ErrorReporter.f26251b;
        Intrinsics.m26843a(obj, "ErrorReporter.DO_NOTHING");
        Companion companion = LookupTracker.f25593a;
        PackageFragmentProvider packageFragmentProvider2 = packageFragmentProvider;
        DeserializationComponents deserializationComponents = r0;
        DeserializationComponents deserializationComponents2 = new DeserializationComponents(storageManager2, moduleDescriptor2, deserializationConfiguration, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProvider, localClassifierTypeSettings, obj, Companion.m27125a(), ThrowException.f33035a, iterable2, notFoundClasses, additionalClassPartsProvider2, platformDependentDeclarationFilter2);
        for (BuiltInsPackageFragment builtInsPackageFragment : list) {
            DeserializationComponents deserializationComponents3 = deserializationComponents;
            Intrinsics.m26847b(deserializationComponents3, "<set-?>");
            builtInsPackageFragment.f40808b = deserializationComponents3;
        }
        return packageFragmentProvider2;
    }
}
