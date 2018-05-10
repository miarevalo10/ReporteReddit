package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: CloneableClassScope.kt */
public final class CloneableClassScope extends GivenFunctionsMemberScope {
    public static final Companion f39715a = new Companion();
    private static final Name f39716d = Name.m27424a("clone");

    /* compiled from: CloneableClassScope.kt */
    public static final class Companion {
        private Companion() {
        }

        public static Name m26941a() {
            return CloneableClassScope.f39716d;
        }
    }

    public CloneableClassScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(classDescriptor, "containingClass");
        super(storageManager, classDescriptor);
    }

    protected final List<FunctionDescriptor> mo7256a() {
        DeclarationDescriptor declarationDescriptor = this.f38815b;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion companion = Annotations.f32643a;
        SimpleFunctionDescriptorImpl a = SimpleFunctionDescriptorImpl.m42798a(declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.m27115a(), Companion.m26941a(), Kind.DECLARATION, SourceElement.f25498a);
        a.mo7833b(null, this.f38815b.mo7740u(), CollectionsKt__CollectionsKt.m26790a(), CollectionsKt__CollectionsKt.m26790a(), DescriptorUtilsKt.m27745d(this.f38815b).m27015m(), Modality.f25490c, Visibilities.f25506c);
        return CollectionsKt__CollectionsKt.m26791a((Object) a);
    }
}
