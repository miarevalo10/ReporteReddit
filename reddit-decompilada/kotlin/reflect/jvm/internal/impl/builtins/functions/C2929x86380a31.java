package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;

/* compiled from: FunctionClassDescriptor.kt */
final class C2929x86380a31 extends Lambda implements Function2<PackageFragmentDescriptor, Name, Unit> {
    final /* synthetic */ FunctionTypeConstructor f38323a;
    final /* synthetic */ ArrayList f38324b;

    C2929x86380a31(FunctionTypeConstructor functionTypeConstructor, ArrayList arrayList) {
        this.f38323a = functionTypeConstructor;
        this.f38324b = arrayList;
        super(2);
    }

    public final void m38298a(PackageFragmentDescriptor packageFragmentDescriptor, Name name) {
        Intrinsics.m26847b(packageFragmentDescriptor, "packageFragment");
        Intrinsics.m26847b(name, "name");
        ClassifierDescriptor c = packageFragmentDescriptor.aC_().mo6699c(name, NoLookupLocation.f32674d);
        if (!(c instanceof ClassDescriptor)) {
            c = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) c;
        if (classDescriptor == null) {
            StringBuilder stringBuilder = new StringBuilder("Class ");
            stringBuilder.append(name);
            stringBuilder.append(" not found in ");
            stringBuilder.append(packageFragmentDescriptor);
            throw ((Throwable) new IllegalStateException(stringBuilder.toString().toString()));
        }
        Iterable<TypeParameterDescriptor> d = CollectionsKt___CollectionsKt.m41432d((List) this.f38323a.f38325a.f40841a, (int) classDescriptor.mo7610c().mo5723b().size());
        Collection collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(d));
        for (TypeParameterDescriptor h : d) {
            collection.add(new TypeProjectionImpl(h.mo7714h()));
        }
        List list = (List) collection;
        packageFragmentDescriptor = this.f38324b;
        Companion companion = Annotations.f32643a;
        packageFragmentDescriptor.add(KotlinTypeFactory.m27950a(Companion.m27115a(), classDescriptor, list));
    }
}
