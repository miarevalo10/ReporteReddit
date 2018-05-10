package com.reddit.frontpage.presentation.common.ui.view.listoptions.sort;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.C1761R;
import io.reactivex.Observer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B=\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/PostSortOptionsDialog;", "", "sortObservable", "Lio/reactivex/Observer;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "context", "Landroid/content/Context;", "hasBestSort", "", "selectedSort", "selectedTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Lio/reactivex/Observer;Landroid/content/Context;ZLcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "dialog", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SimpleSortOptionsDialog;", "show", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PostSortOptionsDialog.kt */
public final class PostSortOptionsDialog {
    public static final Companion f20394a = new Companion();
    private static final SortOption<SortType> f20395c = new SortOption(C1761R.drawable.ic_icon_sort_best, C1761R.string.label_sort_best, SortType.a, false);
    private static final SortOption<SortType> f20396d = new SortOption(C1761R.drawable.ic_icon_sort_hot, C1761R.string.label_sort_hot, SortType.c, false);
    private static final SortOption<SortType> f20397e = new SortOption(C1761R.drawable.ic_icon_sort_new, C1761R.string.label_sort_new, SortType.b, false);
    private static final SortOption<SortType> f20398f = new SortOption(C1761R.drawable.ic_icon_sort_top, C1761R.string.label_sort_top, SortType.d, true);
    private static final SortOption<SortType> f20399g = new SortOption(C1761R.drawable.ic_icon_sort_controversial, C1761R.string.label_sort_controversial, SortType.e, true);
    private static final List<SortOption<SortType>> f20400h = CollectionsKt__CollectionsKt.m26796b((Object[]) new SortOption[]{f20395c, f20396d, f20397e, f20398f, f20399g});
    private static final List<SortOption<SortType>> f20401i = CollectionsKt__CollectionsKt.m26796b((Object[]) new SortOption[]{f20396d, f20397e, f20398f, f20399g});
    private static final Map<SortType, SortOption<SortType>> f20402j = MapsKt__MapsKt.m36121a(new Pair(SortType.a, f20395c), new Pair(SortType.c, f20396d), new Pair(SortType.b, f20397e), new Pair(SortType.d, f20398f), new Pair(SortType.e, f20399g));
    private SimpleSortOptionsDialog<SortType> f20403b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R&\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/PostSortOptionsDialog$Companion;", "", "()V", "BEST", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "getBEST", "()Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "CONTROVERSIAL", "getCONTROVERSIAL", "HOT", "getHOT", "NEW", "getNEW", "SORT_OPTIONS", "", "getSORT_OPTIONS", "()Ljava/util/List;", "SORT_OPTIONS_WITH_BEST", "getSORT_OPTIONS_WITH_BEST", "TOP", "getTOP", "TYPE_TO_OPTION", "", "getTYPE_TO_OPTION", "()Ljava/util/Map;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PostSortOptionsDialog.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public PostSortOptionsDialog(Observer<SortSelection<SortType>> observer, Context context, boolean z, SortType sortType, SortTimeFrame sortTimeFrame) {
        Intrinsics.m26847b(observer, "sortObservable");
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(sortType, "selectedSort");
        List a = z ? f20400h : f20401i;
        SortOption sortOption = (SortOption) a.get(false);
        Object string = context.getResources().getString(C1761R.string.title_sort_posts);
        Intrinsics.m26843a(string, "context.resources.getStr….string.title_sort_posts)");
        sortType = f20402j.get(sortType);
        if (sortType == null) {
            Intrinsics.m26842a();
        }
        this.f20403b = new SimpleSortOptionsDialog(observer, context, string, a, sortOption, (SortOption) sortType, true, sortTimeFrame);
    }

    public final void m22764a() {
        this.f20403b.f20405a.show();
    }
}
