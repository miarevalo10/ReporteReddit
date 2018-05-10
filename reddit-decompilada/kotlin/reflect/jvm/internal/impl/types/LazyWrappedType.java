package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: SpecialTypes.kt */
public final class LazyWrappedType extends WrappedType {
    private final NotNullLazyValue<KotlinType> f38928a;

    public LazyWrappedType(StorageManager storageManager, Function0<? extends KotlinType> function0) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(function0, "computation");
        this.f38928a = storageManager.mo5926a((Function0) function0);
    }

    protected final KotlinType mo7117e() {
        return (KotlinType) this.f38928a.invoke();
    }

    public final boolean mo7118f() {
        return this.f38928a.m36413a();
    }
}
