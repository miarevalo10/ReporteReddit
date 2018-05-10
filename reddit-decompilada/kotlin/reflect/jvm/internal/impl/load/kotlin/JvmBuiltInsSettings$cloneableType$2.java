package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.builtins.JvmBuiltInClassDescriptorFactory.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$cloneableType$2 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ JvmBuiltInsSettings f38770a;
    final /* synthetic */ StorageManager f38771b;

    JvmBuiltInsSettings$cloneableType$2(JvmBuiltInsSettings jvmBuiltInsSettings, StorageManager storageManager) {
        this.f38770a = jvmBuiltInsSettings;
        this.f38771b = storageManager;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        ModuleDescriptor c = this.f38770a.m33194g();
        Companion companion = JvmBuiltInClassDescriptorFactory.f32620b;
        Object a = Companion.m26956a();
        Intrinsics.m26843a(a, "JvmBuiltInClassDescripto…actory.CLONEABLE_CLASS_ID");
        return FindClassInModuleKt.m27839a(c, a, new NotFoundClasses(this.f38771b, this.f38770a.m33194g())).mo7714h();
    }
}
