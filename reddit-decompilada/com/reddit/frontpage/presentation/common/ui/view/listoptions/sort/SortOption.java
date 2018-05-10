package com.reddit.frontpage.presentation.common.ui.view.listoptions.sort;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J<\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "T", "", "iconResId", "", "labelResId", "sortType", "requiresTimeFrame", "", "(IILjava/lang/Object;Z)V", "getIconResId", "()I", "getLabelResId", "getRequiresTimeFrame", "()Z", "getSortType", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Object;Z)Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "equals", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SortOption.kt */
public final class SortOption<T> {
    public final int f20412a;
    public final int f20413b;
    public final T f20414c;
    final boolean f20415d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SortOption) {
            SortOption sortOption = (SortOption) obj;
            if (this.f20412a == sortOption.f20412a) {
                if ((this.f20413b == sortOption.f20413b) && Intrinsics.m26845a(this.f20414c, sortOption.f20414c)) {
                    if (this.f20415d == sortOption.f20415d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.f20412a * 31) + this.f20413b) * 31;
        Object obj = this.f20414c;
        i = (i + (obj != null ? obj.hashCode() : 0)) * 31;
        int i2 = this.f20415d;
        if (i2 != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SortOption(iconResId=");
        stringBuilder.append(this.f20412a);
        stringBuilder.append(", labelResId=");
        stringBuilder.append(this.f20413b);
        stringBuilder.append(", sortType=");
        stringBuilder.append(this.f20414c);
        stringBuilder.append(", requiresTimeFrame=");
        stringBuilder.append(this.f20415d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SortOption(int i, int i2, T t, boolean z) {
        this.f20412a = i;
        this.f20413b = i2;
        this.f20414c = t;
        this.f20415d = z;
    }
}
