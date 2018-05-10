package com.reddit.frontpage.util.kotlin;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005"}, d2 = {"clearAndReplace", "", "T", "other", "", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: MutableLists.kt */
public final class MutableListsKt {
    public static final <T> List<T> m24089a(List<T> list, List<? extends T> list2) {
        Intrinsics.m26847b(list, "$receiver");
        Intrinsics.m26847b(list2, "other");
        list.clear();
        list.addAll(list2);
        return list;
    }
}
