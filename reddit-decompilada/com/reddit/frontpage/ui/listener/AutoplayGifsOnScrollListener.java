package com.reddit.frontpage.ui.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate.ItemChangedListener;

public class AutoplayGifsOnScrollListener extends OnPercentScrollListener {
    private final LinearLayoutManager f34309a;
    private int f34310b = -1;
    private int f34311c = -1;
    private ItemChangedListener f34312d;

    public AutoplayGifsOnScrollListener(LinearLayoutManager linearLayoutManager, ItemChangedListener itemChangedListener) {
        super(0.05f);
        this.f34309a = linearLayoutManager;
        this.f34312d = itemChangedListener;
    }

    public final void mo6501a(RecyclerView recyclerView, int i) {
        super.mo6501a(recyclerView, i);
        if (this.f34310b == -1) {
            this.f34310b = this.f34309a.k();
            this.f34311c = this.f34309a.m();
        }
    }

    protected final void mo6462a() {
        int k = this.f34309a.k();
        int m = this.f34309a.m();
        if (k >= 0) {
            if (m >= 0) {
                if (k < this.f34310b) {
                    this.f34312d.mo4827a(k + 1, this.f34310b - 1);
                }
                if (m > this.f34311c) {
                    this.f34312d.mo4827a(m + 1, this.f34311c);
                }
                this.f34312d.mo4826a(k);
                this.f34312d.mo4826a(m);
                this.f34310b = k;
                this.f34311c = m;
            }
        }
    }
}
