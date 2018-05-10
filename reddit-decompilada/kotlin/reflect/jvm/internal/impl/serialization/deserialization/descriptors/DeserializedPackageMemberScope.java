package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable.Companion;

/* compiled from: DeserializedPackageMemberScope.kt */
public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    private final FqName f39879a;

    protected final void mo7307a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(collection, "result");
        Intrinsics.m26847b(function1, "nameFilter");
    }

    public DeserializedPackageMemberScope(PackageFragmentDescriptor packageFragmentDescriptor, Package packageR, NameResolver nameResolver, DeserializedContainerSource deserializedContainerSource, DeserializationComponents deserializationComponents, Function0<? extends Collection<Name>> function0) {
        Package packageR2 = packageR;
        PackageFragmentDescriptor packageFragmentDescriptor2 = packageFragmentDescriptor;
        Intrinsics.m26847b(packageFragmentDescriptor2, "packageDescriptor");
        Intrinsics.m26847b(packageR2, "proto");
        NameResolver nameResolver2 = nameResolver;
        Intrinsics.m26847b(nameResolver2, "nameResolver");
        DeserializationComponents deserializationComponents2 = deserializationComponents;
        Intrinsics.m26847b(deserializationComponents2, "components");
        Function0<? extends Collection<Name>> function02 = function0;
        Intrinsics.m26847b(function02, "classNames");
        Object obj = packageR2.f40399h;
        Intrinsics.m26843a(obj, "proto.typeTable");
        TypeTable typeTable = new TypeTable(obj);
        Companion companion = SinceKotlinInfoTable.f26281a;
        obj = packageR2.f40400i;
        Intrinsics.m26843a(obj, "proto.sinceKotlinInfoTable");
        DeserializationContext a = deserializationComponents2.m27833a(packageFragmentDescriptor2, nameResolver2, typeTable, Companion.m27897a(obj), deserializedContainerSource);
        obj = packageR2.f40396e;
        Intrinsics.m26843a(obj, "proto.functionList");
        Collection collection = (Collection) obj;
        obj = packageR2.f40397f;
        Intrinsics.m26843a(obj, "proto.propertyList");
        Collection collection2 = (Collection) obj;
        Object obj2 = packageR2.f40398g;
        Intrinsics.m26843a(obj2, "proto.typeAliasList");
        super(a, collection, collection2, (Collection) obj2, function02);
        this.f39879a = packageFragmentDescriptor2.mo7722d();
    }

    public final /* synthetic */ Collection mo6695a(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        descriptorKindFilter = m38640a(descriptorKindFilter, function1, NoLookupLocation.f32683m);
        Collection arrayList = new ArrayList();
        for (ClassDescriptorFactory a : this.f38901b.f26245c.f26238k) {
            CollectionsKt__MutableCollectionsKt.m38194a(arrayList, (Iterable) a.mo5704a(this.f39879a));
        }
        return CollectionsKt___CollectionsKt.m41423b((Collection) descriptorKindFilter, (Iterable) (List) arrayList);
    }

    protected final boolean mo7312b(Name name) {
        Intrinsics.m26847b(name, "name");
        if (!super.mo7312b(name)) {
            for (ClassDescriptorFactory a : this.f38901b.f26245c.f26238k) {
                if (a.mo5706a(this.f39879a, name)) {
                    name = 1;
                    break;
                }
            }
            name = null;
            if (name == null) {
                return false;
            }
        }
        return true;
    }

    protected final ClassId mo7306a(Name name) {
        Intrinsics.m26847b(name, "name");
        return new ClassId(this.f39879a, name);
    }

    protected final Set<Name> mo7310c() {
        return SetsKt__SetsKt.m26799a();
    }

    protected final Set<Name> mo7311d() {
        return SetsKt__SetsKt.m26799a();
    }
}
