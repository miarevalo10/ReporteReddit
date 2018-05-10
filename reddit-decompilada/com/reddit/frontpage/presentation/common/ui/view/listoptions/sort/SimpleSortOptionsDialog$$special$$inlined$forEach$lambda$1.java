package com.reddit.frontpage.presentation.common.ui.view.listoptions.sort;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "dialogInterface", "Landroid/content/DialogInterface;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: SimpleSortOptionsDialog.kt */
final class SimpleSortOptionsDialog$$special$$inlined$forEach$lambda$1 extends Lambda implements Function1<DialogInterface, Unit> {
    final /* synthetic */ boolean f36392a;
    final /* synthetic */ SortOption f36393b;
    final /* synthetic */ SimpleSortOptionsDialog f36394c;
    final /* synthetic */ Resources f36395d;
    final /* synthetic */ boolean f36396e;
    final /* synthetic */ List f36397f;

    SimpleSortOptionsDialog$$special$$inlined$forEach$lambda$1(boolean z, SortOption sortOption, SimpleSortOptionsDialog simpleSortOptionsDialog, Resources resources, boolean z2, List list) {
        this.f36392a = z;
        this.f36393b = sortOption;
        this.f36394c = simpleSortOptionsDialog;
        this.f36395d = resources;
        this.f36396e = z2;
        this.f36397f = list;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DialogInterface dialogInterface = (DialogInterface) obj;
        Intrinsics.m26847b(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
        if (this.f36392a != null) {
            new TimeSortOptionsDialog(this.f36394c.f20406c, this.f36394c.f20407d, this.f36393b, this.f36394c.f20411h).f20419a.show();
        } else {
            this.f36394c.f20406c.onNext(new SortSelection(this.f36393b, null));
        }
        return Unit.f25273a;
    }
}
