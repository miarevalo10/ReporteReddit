package com.reddit.frontpage.widgets.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.SelectionListener;

final /* synthetic */ class SubredditLocationSelectView$$Lambda$2 implements OnClickListener {
    private final SelectionListener f22034a;

    SubredditLocationSelectView$$Lambda$2(SelectionListener selectionListener) {
        this.f22034a = selectionListener;
    }

    public final void onClick(View view) {
        this.f22034a.mo5017a();
    }
}
