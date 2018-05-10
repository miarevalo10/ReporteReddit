package com.reddit.frontpage.presentation.common.ui.view.listoptions.sort;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import io.reactivex.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "dialogInterface", "Landroid/content/DialogInterface;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: TimeSortOptionsDialog.kt */
final class TimeSortOptionsDialog$$special$$inlined$forEach$lambda$1 extends Lambda implements Function1<DialogInterface, Unit> {
    final /* synthetic */ SortTimeFrame f36398a;
    final /* synthetic */ Resources f36399b;
    final /* synthetic */ List f36400c;
    final /* synthetic */ Observer f36401d;
    final /* synthetic */ SortOption f36402e;

    TimeSortOptionsDialog$$special$$inlined$forEach$lambda$1(SortTimeFrame sortTimeFrame, Resources resources, List list, Observer observer, SortOption sortOption) {
        this.f36398a = sortTimeFrame;
        this.f36399b = resources;
        this.f36400c = list;
        this.f36401d = observer;
        this.f36402e = sortOption;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DialogInterface dialogInterface = (DialogInterface) obj;
        Intrinsics.m26847b(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
        this.f36401d.onNext(new SortSelection(this.f36402e, this.f36398a));
        return Unit.f25273a;
    }
}
