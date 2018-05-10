package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltIns.kt */
public final class JvmBuiltIns extends KotlinBuiltIns {
    static final /* synthetic */ KProperty[] f32853n = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(JvmBuiltIns.class), "settings", "getSettings()Lorg/jetbrains/kotlin/load/kotlin/JvmBuiltInsSettings;"))};
    public ModuleDescriptor f32854a;
    public boolean f32855m;
    private final NotNullLazyValue f32856o;

    public final JvmBuiltInsSettings m33271a() {
        return (JvmBuiltInsSettings) StorageKt.m27920a(this.f32856o, f32853n[0]);
    }

    private JvmBuiltIns(StorageManager storageManager) {
        Intrinsics.m26847b(storageManager, "storageManager");
        super(storageManager);
        this.f32855m = true;
        this.f32856o = storageManager.mo5926a((Function0) new JvmBuiltIns$settings$2(this, storageManager));
        m27005c();
    }

    protected final PlatformDependentDeclarationFilter mo5822e() {
        return m33271a();
    }

    protected final AdditionalClassPartsProvider mo5857d() {
        return m33271a();
    }

    public final /* synthetic */ Iterable mo5858f() {
        Iterable f = super.mo5858f();
        Object g = m27009g();
        Intrinsics.m26843a(g, "storageManager");
        Object h = m27010h();
        Intrinsics.m26843a(h, "builtInsModule");
        return CollectionsKt___CollectionsKt.m41426c(f, (Object) new JvmBuiltInClassDescriptorFactory(g, (ModuleDescriptor) h));
    }
}
