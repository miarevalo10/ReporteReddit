package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    static final /* synthetic */ KProperty[] f32619a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    public static final Companion f32620b = new Companion();
    private static final FqName f32621f = KotlinBuiltIns.f25415c;
    private static final Name f32622g = KotlinBuiltIns.f25420j.f25382c.m27421e();
    private static final ClassId f32623h = ClassId.m27396a(KotlinBuiltIns.f25420j.f25382c.m27420d());
    private final NotNullLazyValue f32624c;
    private final ModuleDescriptor f32625d;
    private final Function1<ModuleDescriptor, DeclarationDescriptor> f32626e;

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ClassId m26956a() {
            return JvmBuiltInClassDescriptorFactory.f32623h;
        }
    }

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    static final class C29271 extends Lambda implements Function1<ModuleDescriptor, BuiltInsPackageFragment> {
        public static final C29271 f38317a = new C29271();

        C29271() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            ModuleDescriptor moduleDescriptor = (ModuleDescriptor) obj;
            Intrinsics.m26847b(moduleDescriptor, "module");
            Companion companion = JvmBuiltInClassDescriptorFactory.f32620b;
            FqName c = JvmBuiltInClassDescriptorFactory.f32621f;
            Intrinsics.m26843a((Object) c, "KOTLIN_FQ_NAME");
            Iterable f = moduleDescriptor.mo7087a(c).mo7083f();
            Collection arrayList = new ArrayList();
            for (Object next : f) {
                if (next instanceof BuiltInsPackageFragment) {
                    arrayList.add(next);
                }
            }
            return (BuiltInsPackageFragment) CollectionsKt___CollectionsKt.m41430d((List) arrayList);
        }
    }

    private final ClassDescriptorImpl m32921d() {
        return (ClassDescriptorImpl) StorageKt.m27920a(this.f32624c, f32619a[0]);
    }

    private JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> function1) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(moduleDescriptor, "moduleDescriptor");
        Intrinsics.m26847b(function1, "computeContainingDeclaration");
        this.f32625d = moduleDescriptor;
        this.f32626e = function1;
        this.f32624c = storageManager.mo5926a((Function0) new JvmBuiltInClassDescriptorFactory$cloneable$2(this, storageManager));
    }

    public final boolean mo5706a(FqName fqName, Name name) {
        Intrinsics.m26847b(fqName, "packageFqName");
        Intrinsics.m26847b(name, "name");
        return (Intrinsics.m26845a((Object) name, f32622g) == null || Intrinsics.m26845a((Object) fqName, f32621f) == null) ? null : true;
    }

    public final ClassDescriptor mo5705a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        return Intrinsics.m26845a((Object) classId, Companion.m26956a()) != null ? m32921d() : null;
    }

    public final Collection<ClassDescriptor> mo5704a(FqName fqName) {
        Intrinsics.m26847b(fqName, "packageFqName");
        if (Intrinsics.m26845a((Object) fqName, f32621f) != null) {
            return SetsKt__SetsKt.m26800a((Object) m32921d());
        }
        return SetsKt__SetsKt.m26799a();
    }
}
