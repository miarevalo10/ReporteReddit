package com.reddit.frontpage.util.kotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a)\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"prepend", "", "T", "element", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Collections.kt */
public final class CollectionsKt {
    public static final <T> List<T> m24072a(List<? extends T> list, T t) {
        Intrinsics.m26847b(list, "$receiver");
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.add(t);
        arrayList.addAll(list);
        return arrayList;
    }
}
