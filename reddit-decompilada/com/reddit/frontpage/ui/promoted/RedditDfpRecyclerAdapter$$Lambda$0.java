package com.reddit.frontpage.ui.promoted;

import android.support.v7.widget.RecyclerView.ViewHolder;

final /* synthetic */ class RedditDfpRecyclerAdapter$$Lambda$0 implements Runnable {
    private final RedditDfpRecyclerAdapter f21579a;
    private final ViewHolder f21580b;

    RedditDfpRecyclerAdapter$$Lambda$0(RedditDfpRecyclerAdapter redditDfpRecyclerAdapter, ViewHolder viewHolder) {
        this.f21579a = redditDfpRecyclerAdapter;
        this.f21580b = viewHolder;
    }

    public final void run() {
        RedditDfpRecyclerAdapter redditDfpRecyclerAdapter = this.f21579a;
        ViewHolder viewHolder = this.f21580b;
        AdViewHolder adViewHolder = (AdViewHolder) viewHolder;
        adViewHolder.mo7018a(adViewHolder.f34437b);
        redditDfpRecyclerAdapter.f34446h.b(adViewHolder.f34436a);
        redditDfpRecyclerAdapter.f(viewHolder.d());
    }
}
