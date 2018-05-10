package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: StorageManager.kt */
public interface StorageManager {
    <K, V> MemoizedFunctionToNotNull<K, V> mo5925a(Function1<? super K, ? extends V> function1);

    <T> NotNullLazyValue<T> mo5926a(Function0<? extends T> function0);

    <T> NotNullLazyValue<T> mo5927a(Function0<? extends T> function0, T t);

    <T> NotNullLazyValue<T> mo5928a(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function12);

    <K, V> CacheWithNotNullValues<K, V> mo5929b();

    <K, V> MemoizedFunctionToNullable<K, V> mo5930b(Function1<? super K, ? extends V> function1);

    <T> NullableLazyValue<T> mo5931b(Function0<? extends T> function0);
}
