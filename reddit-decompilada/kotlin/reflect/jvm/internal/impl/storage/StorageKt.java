package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: storage.kt */
public final class StorageKt {
    public static final <T> T m27920a(NotNullLazyValue<? extends T> notNullLazyValue, KProperty<?> kProperty) {
        Intrinsics.m26847b(notNullLazyValue, "$receiver");
        Intrinsics.m26847b(kProperty, "p");
        return notNullLazyValue.invoke();
    }
}
