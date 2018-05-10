package com.reddit.frontpage.ui.submit.search;

import android.text.TextUtils;
import com.reddit.frontpage.widgets.GoEditTextView.OnGoClickedListener;

final /* synthetic */ class SubredditSelectScreen$$Lambda$1 implements OnGoClickedListener {
    private final SubredditSelectScreen f29359a;

    SubredditSelectScreen$$Lambda$1(SubredditSelectScreen subredditSelectScreen) {
        this.f29359a = subredditSelectScreen;
    }

    public final boolean mo5021a() {
        TextUtils.isEmpty(this.f29359a.subredditFilter.getText().toString());
        return false;
    }
}
