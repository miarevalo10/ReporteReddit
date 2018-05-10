package com.reddit.social.util;

import android.support.v7.util.DiffUtil.Callback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001aB\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"diff", "Landroid/support/v7/util/DiffUtil$Callback;", "T", "old", "", "new", "compareItems", "Lkotlin/Function2;", "", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: DiffUtil.kt */
public final class DiffUtilKt {
    public static final <T> Callback m24769a(List<? extends T> list, List<? extends T> list2, Function2<? super T, ? super T, Boolean> function2) {
        Intrinsics.m26847b(list, "old");
        Intrinsics.m26847b(list2, "new");
        Intrinsics.m26847b(function2, "compareItems");
        return new DiffUtilKt$diff$1(list, list2, function2);
    }
}
