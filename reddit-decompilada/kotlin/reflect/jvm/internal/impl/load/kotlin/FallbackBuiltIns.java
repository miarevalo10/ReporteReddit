package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsInitializer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter.All;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* compiled from: JvmBuiltInsSettings.kt */
final class FallbackBuiltIns extends KotlinBuiltIns {
    public static final Companion f32786a = new Companion();
    private static final BuiltInsInitializer<FallbackBuiltIns> f32787m = new BuiltInsInitializer(FallbackBuiltIns$Companion$initializer$1.f38769a);

    /* compiled from: JvmBuiltInsSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public static KotlinBuiltIns m27301a() {
            Companion companion = FallbackBuiltIns.f32786a;
            return FallbackBuiltIns.f32787m.m26939a();
        }
    }

    private FallbackBuiltIns() {
        super(new LockBasedStorageManager());
        m27005c();
    }

    public final /* bridge */ /* synthetic */ PlatformDependentDeclarationFilter mo5822e() {
        return All.f33039a;
    }
}
