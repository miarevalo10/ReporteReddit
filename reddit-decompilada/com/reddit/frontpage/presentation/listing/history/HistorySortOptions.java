package com.reddit.frontpage.presentation.listing.history;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000Rf\u0010\u000b\u001aZ\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \r*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004 \r*,\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \r*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/history/HistorySortOptions;", "", "()V", "SORT_DOWNVOTED", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "SORT_HIDDEN", "SORT_OPTIONS", "", "SORT_RECENT", "SORT_UPVOTED", "TYPE_TO_OPTION", "Lcom/google/common/collect/ImmutableMap;", "kotlin.jvm.PlatformType", "getDefault", "getOption", "type", "getOptions", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistorySortOptions.kt */
public final class HistorySortOptions {
    public static final HistorySortOptions f20601a = new HistorySortOptions();
    private static final SortOption<HistorySortType> f20602b = new SortOption(C1761R.drawable.ic_icon_sort_recent, C1761R.string.label_sort_recent, HistorySortType.f28408a, false);
    private static final SortOption<HistorySortType> f20603c = new SortOption(C1761R.drawable.ic_icon_upvotes, C1761R.string.label_sort_upvoted, HistorySortType.f28409b, false);
    private static final SortOption<HistorySortType> f20604d = new SortOption(C1761R.drawable.ic_icon_downvotes, C1761R.string.label_sort_downvoted, HistorySortType.f28410c, false);
    private static final SortOption<HistorySortType> f20605e = new SortOption(C1761R.drawable.ic_icon_hide, C1761R.string.label_sort_hidden, HistorySortType.f28411d, false);
    private static final List<SortOption<HistorySortType>> f20606f;
    private static final ImmutableMap<HistorySortType, SortOption<HistorySortType>> f20607g = ImmutableMap.a(HistorySortType.f28408a, f20602b, HistorySortType.f28409b, f20603c, HistorySortType.f28410c, f20604d, HistorySortType.f28411d, f20605e);

    static {
        Object a = ImmutableList.a(f20602b, f20603c, f20604d, f20605e);
        Intrinsics.m26843a(a, "ImmutableList.of(\n      …ED,\n      SORT_HIDDEN\n  )");
        f20606f = (List) a;
    }

    private HistorySortOptions() {
    }

    public static SortOption<HistorySortType> m22956a() {
        return f20602b;
    }

    public static List<SortOption<HistorySortType>> m22958b() {
        return f20606f;
    }

    public static SortOption<HistorySortType> m22957a(HistorySortType historySortType) {
        Intrinsics.m26847b(historySortType, "type");
        SortOption sortOption = (SortOption) f20607g.get(historySortType);
        return sortOption == null ? f20602b : sortOption;
    }
}
