package com.reddit.frontpage.widgets.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.SelectionListener;

final /* synthetic */ class SubredditLocationSelectView$$Lambda$3 implements OnClickListener {
    private final SelectionListener f22035a;

    SubredditLocationSelectView$$Lambda$3(SelectionListener selectionListener) {
        this.f22035a = selectionListener;
    }

    public final void onClick(View view) {
        this.f22035a.mo5018b();
    }
}
