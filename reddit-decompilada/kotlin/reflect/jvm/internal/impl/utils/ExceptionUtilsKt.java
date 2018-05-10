package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: exceptionUtils.kt */
public final class ExceptionUtilsKt {
    public static final RuntimeException m28104a(Throwable th) {
        Intrinsics.m26847b(th, "e");
        throw th;
    }
}
