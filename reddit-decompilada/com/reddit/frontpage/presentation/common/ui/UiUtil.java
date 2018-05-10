package com.reddit.frontpage.presentation.common.ui;

import android.content.res.ColorStateList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0003\u001a\u00020\u000422\u0010\u0005\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\bj\u0002`\t0\u00070\u0006\"\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\bj\u0002`\t0\u0007H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/UiUtil;", "", "()V", "createColorStateList", "Landroid/content/res/ColorStateList;", "values", "", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/util/kotlin/ColorInt;", "([Lkotlin/Pair;)Landroid/content/res/ColorStateList;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UiUtil.kt */
public final class UiUtil {
    public static final UiUtil f20387a = new UiUtil();

    private UiUtil() {
    }

    public static final ColorStateList m22746a(Pair<Integer, Integer>... pairArr) {
        int i;
        Intrinsics.m26847b(pairArr, "values");
        Object[] objArr = (Object[]) pairArr;
        int i2 = 0;
        Collection arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        for (i = 0; i < length; i++) {
            arrayList.add(new int[]{((Number) ((Pair) objArr[i]).f25267a).intValue()});
        }
        Object[] toArray = ((List) arrayList).toArray(new int[0][]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        int[][] iArr = (int[][]) toArray;
        Collection arrayList2 = new ArrayList(objArr.length);
        i = objArr.length;
        while (i2 < i) {
            arrayList2.add(Integer.valueOf(((Number) ((Pair) objArr[i2]).f25268b).intValue()));
            i2++;
        }
        return new ColorStateList(iArr, CollectionsKt___CollectionsKt.m41424b((List) arrayList2));
    }
}
