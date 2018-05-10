package com.reddit.frontpage.presentation.common.ui.view.listoptions.sort;

import android.content.Context;
import android.content.res.Resources;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import io.reactivex.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u0013*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0013B;\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/TimeSortOptionsDialog;", "T", "", "sortObservable", "Lio/reactivex/Observer;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "context", "Landroid/content/Context;", "selectedSort", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "selectedTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Lio/reactivex/Observer;Landroid/content/Context;Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "dialog", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialog;", "getSelectedPos", "", "show", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TimeSortOptionsDialog.kt */
public final class TimeSortOptionsDialog<T> {
    public static final Companion f20416b = new Companion();
    private static final List<SortTimeFrame> f20417d = CollectionsKt__CollectionsKt.m26796b((Object[]) new SortTimeFrame[]{SortTimeFrame.a, SortTimeFrame.b, SortTimeFrame.c, SortTimeFrame.d, SortTimeFrame.e, SortTimeFrame.f});
    private static final Map<SortTimeFrame, Integer> f20418e = MapsKt__MapsKt.m36121a(new Pair(SortTimeFrame.a, Integer.valueOf(C1761R.string.label_past_hour)), new Pair(SortTimeFrame.b, Integer.valueOf(C1761R.string.label_past_24_hours)), new Pair(SortTimeFrame.c, Integer.valueOf(C1761R.string.label_past_week)), new Pair(SortTimeFrame.d, Integer.valueOf(C1761R.string.label_past_month)), new Pair(SortTimeFrame.e, Integer.valueOf(C1761R.string.label_past_year)), new Pair(SortTimeFrame.f, Integer.valueOf(C1761R.string.label_all_time)));
    ListOptionsDialog f20419a;
    private final SortTimeFrame f20420c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/TimeSortOptionsDialog$Companion;", "", "()V", "TIME_FRAME_OPTIONS", "", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getTIME_FRAME_OPTIONS", "()Ljava/util/List;", "TIME_FRAME_TO_NAME", "", "", "getTIME_FRAME_TO_NAME", "()Ljava/util/Map;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: TimeSortOptionsDialog.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public TimeSortOptionsDialog(Observer<SortSelection<T>> observer, Context context, SortOption<T> sortOption, SortTimeFrame sortTimeFrame) {
        int i;
        Context context2 = context;
        SortOption<T> sortOption2 = sortOption;
        Observer<SortSelection<T>> observer2 = observer;
        Intrinsics.m26847b(observer2, "sortObservable");
        Intrinsics.m26847b(context2, "context");
        Intrinsics.m26847b(sortOption2, "selectedSort");
        this.f20420c = sortTimeFrame;
        List arrayList = new ArrayList();
        Resources resources = context.getResources();
        for (SortTimeFrame sortTimeFrame2 : f20417d) {
            Object obj = f20418e.get(sortTimeFrame2);
            if (obj == null) {
                Intrinsics.m26842a();
            }
            Object string = resources.getString(((Number) obj).intValue());
            Intrinsics.m26843a(string, "label");
            arrayList.add(new ListOptionAction(string, null, new TimeSortOptionsDialog$$special$$inlined$forEach$lambda$1(sortTimeFrame2, resources, arrayList, observer2, sortOption2)));
        }
        if (r0.f20420c == null) {
            i = -2;
        } else {
            i = f20417d.indexOf(r0.f20420c);
        }
        r0.f20419a = new ListOptionsDialog(context2, arrayList, i, true);
        String string2 = resources.getString(sortOption2.f20413b);
        r0.f20419a.m36781a(resources.getString(C1761R.string.fmt_sort_posts_by_time_frame, new Object[]{string2}));
    }
}
