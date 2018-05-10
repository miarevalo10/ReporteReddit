package com.reddit.frontpage.widgets.submit;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.RulesClickListener;

final /* synthetic */ class SubredditLocationSelectView$$Lambda$4 implements OnClickListener {
    private final SubredditLocationSelectView f22036a;
    private final RulesClickListener f22037b;

    SubredditLocationSelectView$$Lambda$4(SubredditLocationSelectView subredditLocationSelectView, RulesClickListener rulesClickListener) {
        this.f22036a = subredditLocationSelectView;
        this.f22037b = rulesClickListener;
    }

    public final void onClick(View view) {
        this.f22037b.mo5019a(this.f22036a.f29534b);
    }
}
