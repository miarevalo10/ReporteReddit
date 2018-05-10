package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* compiled from: DefaultBuiltIns.kt */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion f32617a = new Companion();
    private static final BuiltInsInitializer<DefaultBuiltIns> f32618m = new BuiltInsInitializer(DefaultBuiltIns$Companion$initializer$1.f38315a);

    /* compiled from: DefaultBuiltIns.kt */
    public static final class Companion {
        private Companion() {
        }

        public static DefaultBuiltIns m26944a() {
            Companion companion = DefaultBuiltIns.f32617a;
            return (DefaultBuiltIns) DefaultBuiltIns.f32618m.m26939a();
        }
    }

    public static final DefaultBuiltIns m32915b() {
        return Companion.m26944a();
    }

    private DefaultBuiltIns() {
        super(new LockBasedStorageManager());
        m27005c();
    }
}
