package com.reddit.frontpage.ui.subreddit;

import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.widgets.BaseHtmlTextView;

public abstract class AbstractSubredditHtmlScreen extends BaseScreen {
    @State
    String subredditName;
    protected BaseHtmlTextView f39374v;
    protected View f39375w;

    public String getAnalyticsScreenName() {
        return "community_info";
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_subreddit_html;
    }

    public abstract boolean mo7488w();

    public abstract void mo7489x();

    public abstract void mo7490y();

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        n();
        this.f39374v = (BaseHtmlTextView) this.K.findViewById(C1761R.id.info_text);
        return this.K;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.a(this.subredditName);
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        if (mo7488w() == null) {
            mo7489x();
        } else {
            mo7490y();
        }
    }

    protected final void m39611a(String str) {
        this.f39374v.setHtmlFromString(str);
        this.f39374v.setVisibility(0);
        if (this.f39375w != null) {
            this.f39375w.setVisibility(8);
        }
    }
}
