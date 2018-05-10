package com.reddit.frontpage.util;

import android.support.v7.widget.LinearLayoutManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/util/ListUtil;", "", "()V", "DEFAULT_LOWER_BOUND_INDEX", "", "DEFAULT_SEARCH_LIMIT", "getPositionForItem", "T", "startPosition", "items", "", "predicate", "Lkotlin/Function1;", "", "searchAboveLimit", "searchBelowLimit", "isFirstItemCompletelyVisible", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListUtil.kt */
public final class ListUtil {
    public static final ListUtil f21753a = new ListUtil();

    private ListUtil() {
    }

    public static /* synthetic */ int m23809a(int i, List list, Function1 function1) {
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(function1, "predicate");
        if (((Boolean) function1.mo6492a(list.get(i))).booleanValue()) {
            return i;
        }
        i = new IntRange(RangesKt___RangesKt.m32855c(i - 3, 0), RangesKt___RangesKt.m32856d(i + 3, CollectionsKt__CollectionsKt.m26787a(list))).iterator();
        while (i.hasNext()) {
            int a = ((IntIterator) i).mo6663a();
            if (((Boolean) function1.mo6492a(list.get(a))).booleanValue()) {
                return a;
            }
        }
        throw ((Throwable) new IllegalStateException("item not found in list"));
    }

    public static final boolean m23810a(LinearLayoutManager linearLayoutManager) {
        Intrinsics.m26847b(linearLayoutManager, "layoutManager");
        if (linearLayoutManager.l() == 0) {
            return true;
        }
        int k = linearLayoutManager.k();
        linearLayoutManager = linearLayoutManager.a(k);
        linearLayoutManager = linearLayoutManager != null ? linearLayoutManager.getTop() : null;
        if (k == 0 && linearLayoutManager == null) {
            return true;
        }
        return false;
    }
}
