package com.reddit.frontpage.presentation.viewmode;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.BottomSheetOptionItemView;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ViewModeOptionsScreen.kt */
final class ViewModeOptionsScreen$onCreate$2 implements OnClickListener {
    final /* synthetic */ ViewModeOptionsScreen f21002a;

    ViewModeOptionsScreen$onCreate$2(ViewModeOptionsScreen viewModeOptionsScreen) {
        this.f21002a = viewModeOptionsScreen;
    }

    public final void onClick(View view) {
        view = this.f21002a.m38987f();
        view.f28833a.mo7196e();
        view.f28833a.mo7194c();
        view.m29904a(ListingViewMode.f20613b);
        Object obj = (BottomSheetOptionItemView) this.f21002a.findViewById(C1761R.id.compact_option);
        Intrinsics.m26843a(obj, "compact_option");
        obj.setSelected(true);
    }
}
