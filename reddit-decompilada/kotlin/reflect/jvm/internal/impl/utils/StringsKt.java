package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: strings.kt */
public final class StringsKt {
    public static final String m28121a(Iterable<? extends Object> iterable, String str) {
        Intrinsics.m26847b(iterable, "collection");
        Intrinsics.m26847b(str, "separator");
        return CollectionsKt___CollectionsKt.m41412a((Iterable) iterable, (CharSequence) str, null, null, 0, null, null, 62);
    }
}
