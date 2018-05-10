package com.reddit.frontpage.widgets.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.SelectionListener;

final /* synthetic */ class SubredditLocationSelectView$$Lambda$0 implements OnClickListener {
    private final SelectionListener f22032a;

    SubredditLocationSelectView$$Lambda$0(SelectionListener selectionListener) {
        this.f22032a = selectionListener;
    }

    public final void onClick(View view) {
        this.f22032a.mo5017a();
    }
}
