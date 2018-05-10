package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: StaticScopeForKotlinEnum.kt */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {
    static final /* synthetic */ KProperty[] f38821a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    private final NotNullLazyValue f38822b;
    private final ClassDescriptor f38823c;

    private final List<SimpleFunctionDescriptor> m38588c() {
        return (List) StorageKt.m27920a(this.f38822b, f38821a[0]);
    }

    public final /* synthetic */ Collection mo6695a(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        return m38588c();
    }

    public final /* synthetic */ Collection mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        Collection arrayList = new ArrayList(1);
        for (Object next : m38588c()) {
            if (Intrinsics.m26845a(((SimpleFunctionDescriptor) next).mo6689i(), (Object) name)) {
                arrayList.add(next);
            }
        }
        return (ArrayList) arrayList;
    }

    public final /* synthetic */ ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return null;
    }

    public StaticScopeForKotlinEnum(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(classDescriptor, "containingClass");
        this.f38823c = classDescriptor;
        classDescriptor = Intrinsics.m26845a(this.f38823c.mo7771g(), ClassKind.ENUM_CLASS);
        if (_Assertions.f25274a && classDescriptor == null) {
            storageManager = new StringBuilder("Class should be an enum: ");
            storageManager.append(this.f38823c);
            throw ((Throwable) new AssertionError(storageManager.toString()));
        }
        this.f38822b = storageManager.mo5926a((Function0) new StaticScopeForKotlinEnum$functions$2(this));
    }
}
