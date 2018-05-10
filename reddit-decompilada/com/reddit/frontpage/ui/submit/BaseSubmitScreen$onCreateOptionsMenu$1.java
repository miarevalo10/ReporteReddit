package com.reddit.frontpage.ui.submit;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
final class BaseSubmitScreen$onCreateOptionsMenu$1 implements OnClickListener {
    final /* synthetic */ BaseSubmitScreen f21599a;
    final /* synthetic */ MenuItem f21600b;

    BaseSubmitScreen$onCreateOptionsMenu$1(BaseSubmitScreen baseSubmitScreen, MenuItem menuItem) {
        this.f21599a = baseSubmitScreen;
        this.f21600b = menuItem;
    }

    public final void onClick(View view) {
        this.f21599a.mo7201a(this.f21600b);
    }
}
