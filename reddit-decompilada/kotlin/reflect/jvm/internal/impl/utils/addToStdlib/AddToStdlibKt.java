package kotlin.reflect.jvm.internal.impl.utils.addToStdlib;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: addToStdlib.kt */
public final class AddToStdlibKt {
    private static final ConcurrentHashMap<Function0<?>, Object> f26436a = new ConcurrentHashMap();

    public static final <T> T m28126a(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.m26847b(t, "$receiver");
        Intrinsics.m26847b(function1, "predicate");
        return ((Boolean) function1.mo6492a(t)).booleanValue() != null ? t : null;
    }
}
