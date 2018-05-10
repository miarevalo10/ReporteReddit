package com.reddit.frontpage.presentation.common.ui.view.listoptions.sort;

import android.content.Context;
import android.content.res.Resources;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import io.reactivex.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001c*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001cBo\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SimpleSortOptionsDialog;", "T", "", "sortObservable", "Lio/reactivex/Observer;", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortSelection;", "context", "Landroid/content/Context;", "title", "", "sortOptions", "", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;", "defaultSort", "selectedSort", "timeFrameEnabled", "", "selectedTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "(Lio/reactivex/Observer;Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SortOption;ZLcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "dialog", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialog;", "getSelectedSortOrDefault", "", "show", "", "showTimeFrameDialog", "sort", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SimpleSortOptionsDialog.kt */
public final class SimpleSortOptionsDialog<T> {
    public static final Companion f20404b = new Companion();
    public ListOptionsDialog f20405a;
    private final Observer<SortSelection<T>> f20406c;
    private final Context f20407d;
    private final List<SortOption<T>> f20408e;
    private final SortOption<T> f20409f;
    private final SortOption<T> f20410g;
    private final SortTimeFrame f20411h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/sort/SimpleSortOptionsDialog$Companion;", "", "()V", "NOT_FOUND_INDEX", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SimpleSortOptionsDialog.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public SimpleSortOptionsDialog(Observer<SortSelection<T>> observer, Context context, String str, List<SortOption<T>> list, SortOption<T> sortOption, SortOption<T> sortOption2, boolean z, SortTimeFrame sortTimeFrame) {
        Observer<SortSelection<T>> observer2 = observer;
        Context context2 = context;
        String str2 = str;
        List<SortOption<T>> list2 = list;
        SortOption<T> sortOption3 = sortOption;
        SortOption<T> sortOption4 = sortOption2;
        Intrinsics.m26847b(observer2, "sortObservable");
        Intrinsics.m26847b(context2, "context");
        Intrinsics.m26847b(str2, "title");
        Intrinsics.m26847b(list2, "sortOptions");
        Intrinsics.m26847b(sortOption3, "defaultSort");
        Intrinsics.m26847b(sortOption4, "selectedSort");
        this.f20406c = observer2;
        this.f20407d = context2;
        this.f20408e = list2;
        this.f20409f = sortOption3;
        this.f20410g = sortOption4;
        this.f20411h = sortTimeFrame;
        List arrayList = new ArrayList();
        Resources resources = this.f20407d.getResources();
        Iterator it = this.f20408e.iterator();
        while (true) {
            boolean z2 = true;
            if (it.hasNext()) {
                SortOption sortOption5 = (SortOption) it.next();
                Object string = resources.getString(sortOption5.f20413b);
                int i = sortOption5.f20412a;
                if (!z || !sortOption5.f20415d) {
                    z2 = false;
                }
                Intrinsics.m26843a(string, "label");
                arrayList.add(new ListOptionAction(string, Integer.valueOf(i), new SimpleSortOptionsDialog$$special$$inlined$forEach$lambda$1(z2, sortOption5, r7, resources, z, arrayList)));
            } else {
                r7.f20405a = new ListOptionsDialog(r7.f20407d, arrayList, m22765a(), true);
                r7.f20405a.m36781a(str2);
                return;
            }
        }
    }

    private final int m22765a() {
        int i = 0;
        int i2 = -1;
        int i3 = i2;
        for (Object obj : this.f20408e) {
            int i4 = i + 1;
            if (Intrinsics.m26845a(obj, this.f20409f)) {
                i3 = i;
            }
            if (Intrinsics.m26845a(obj, this.f20410g)) {
                i2 = i;
            }
            i = i4;
        }
        return i2 == -1 ? i3 : i2;
    }
}
