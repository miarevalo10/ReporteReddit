package com.reddit.frontpage.widgets.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.SelectionListener;

final /* synthetic */ class SubredditLocationSelectView$$Lambda$1 implements OnClickListener {
    private final SelectionListener f22033a;

    SubredditLocationSelectView$$Lambda$1(SelectionListener selectionListener) {
        this.f22033a = selectionListener;
    }

    public final void onClick(View view) {
        this.f22033a.mo5017a();
    }
}
