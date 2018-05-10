package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SimpleSortOptionsDialog;

final /* synthetic */ class BaseDetailScreen$$Lambda$15 implements OnClickListener {
    private final BaseDetailScreen f21139a;
    private final BaseActivity f21140b;

    BaseDetailScreen$$Lambda$15(BaseDetailScreen baseDetailScreen, BaseActivity baseActivity) {
        this.f21139a = baseDetailScreen;
        this.f21140b = baseActivity;
    }

    public final void onClick(View view) {
        view = this.f21139a;
        if (!this.f21140b.f40727b) {
            boolean b = FrontpageSettings.a().t().b();
            new SimpleSortOptionsDialog(view.f39163U, view.am_(), view.am_().getResources().getString(C1761R.string.title_sort_comments), b ? BaseDetailScreen.f39143V : BaseDetailScreen.f39144W, view.m39134d(b), view.m39135e(b), false, null).f20405a.show();
        }
    }
}
