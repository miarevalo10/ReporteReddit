package com.reddit.datalibrary.frontpage.data.feature.common;

import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "T", "", "sortOption", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "timeFrameOption", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getSortOption", "()Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "getTimeFrameOption", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Sortings.kt */
public final class SortSelection<T> {
    public final SortOption<T> f10389a;
    public final SortTimeFrame f10390b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SortSelection) {
                SortSelection sortSelection = (SortSelection) obj;
                if (Intrinsics.a(this.f10389a, sortSelection.f10389a) && Intrinsics.a(this.f10390b, sortSelection.f10390b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        SortOption sortOption = this.f10389a;
        int i = 0;
        int hashCode = (sortOption != null ? sortOption.hashCode() : 0) * 31;
        SortTimeFrame sortTimeFrame = this.f10390b;
        if (sortTimeFrame != null) {
            i = sortTimeFrame.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SortSelection(sortOption=");
        stringBuilder.append(this.f10389a);
        stringBuilder.append(", timeFrameOption=");
        stringBuilder.append(this.f10390b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public SortSelection(SortOption<T> sortOption, SortTimeFrame sortTimeFrame) {
        Intrinsics.b(sortOption, "sortOption");
        this.f10389a = sortOption;
        this.f10390b = sortTimeFrame;
    }
}
