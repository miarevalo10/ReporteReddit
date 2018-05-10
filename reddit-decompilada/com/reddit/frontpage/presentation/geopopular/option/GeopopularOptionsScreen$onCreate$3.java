package com.reddit.frontpage.presentation.geopopular.option;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.GeopopularOptionItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularOptionsScreen.kt */
final class GeopopularOptionsScreen$onCreate$3 implements OnClickListener {
    final /* synthetic */ GeopopularOptionsScreen f20545a;

    GeopopularOptionsScreen$onCreate$3(GeopopularOptionsScreen geopopularOptionsScreen) {
        this.f20545a = geopopularOptionsScreen;
    }

    public final void onClick(View view) {
        view = this.f20545a.m38956e();
        view.f33857a.mo7178c();
        view.f33858b.mo7173a();
        Object obj = (GeopopularOptionItemView) this.f20545a.findViewById(C1761R.id.other_option);
        Intrinsics.m26843a(obj, "other_option");
        obj.setSelected(true);
    }
}
