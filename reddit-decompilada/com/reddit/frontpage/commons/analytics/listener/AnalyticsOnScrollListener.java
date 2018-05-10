package com.reddit.frontpage.commons.analytics.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.BaseEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScrollEvent.ScrollPayload;

public abstract class AnalyticsOnScrollListener extends OnScrollListener {
    protected final String f27464a;
    private int f27465b;
    private int f27466c;
    private final long f27467d = System.currentTimeMillis();

    public void mo6461a(ScrollPayload scrollPayload) {
    }

    public AnalyticsOnScrollListener(String str) {
        this.f27464a = str;
    }

    public final void m28965a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            m28963b(recyclerView);
        }
    }

    public void mo6460a(RecyclerView recyclerView) {
        if (recyclerView != null) {
            int height = recyclerView.getHeight();
            if (height != 0) {
                BaseEvent a = AppAnalytics.m21847a((View) recyclerView, this.f27464a);
                ScrollPayload scrollPayload = (ScrollPayload) a.payload;
                if (recyclerView.getAdapter() != null) {
                    scrollPayload.total_scroll_items = recyclerView.getAdapter().a();
                }
                scrollPayload.total_screens_scrolled = this.f27465b / height;
                scrollPayload.scroll_items_seen = m28963b(recyclerView);
                scrollPayload.time_on_page = System.currentTimeMillis() - this.f27467d;
                mo6461a(scrollPayload);
                AppAnalytics.m21852a(a);
            }
        }
    }

    public void mo6498a(RecyclerView recyclerView, int i, int i2) {
        this.f27465b += i2;
    }

    private int m28963b(RecyclerView recyclerView) {
        this.f27466c = Math.max(this.f27466c, ((LinearLayoutManager) recyclerView.getLayoutManager()).m());
        return this.f27466c;
    }
}
