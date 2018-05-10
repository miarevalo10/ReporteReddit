package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltIns.kt */
final class JvmBuiltIns$settings$2 extends Lambda implements Function0<JvmBuiltInsSettings> {
    final /* synthetic */ JvmBuiltIns f38786a;
    final /* synthetic */ StorageManager f38787b;

    JvmBuiltIns$settings$2(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        this.f38786a = jvmBuiltIns;
        this.f38787b = storageManager;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object h = this.f38786a.m27010h();
        Intrinsics.m26843a(h, "builtInsModule");
        return new JvmBuiltInsSettings((ModuleDescriptor) h, this.f38787b, new Function0<ModuleDescriptor>() {
            public final /* synthetic */ Object invoke() {
                ModuleDescriptor a = this.f38786a.f32854a;
                if (a != null) {
                    return a;
                }
                throw new AssertionError("JvmBuiltins has not been initialized properly");
            }
        }, new Function0<Boolean>() {
            public final /* synthetic */ Object invoke() {
                if (this.f38786a.f32854a != null) {
                    return Boolean.valueOf(this.f38786a.f32855m);
                }
                throw new AssertionError("JvmBuiltins has not been initialized properly");
            }
        });
    }
}
