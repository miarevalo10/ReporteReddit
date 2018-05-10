package com.reddit.frontpage.ui.listing.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

@Deprecated
public class RecyclerHeaderFooterAdapter extends BaseWrapperAdapter {
    public View f34364b;
    public View f34365c;
    public Footer f34366f;

    public interface Footer {
        View mo4979a();

        void mo4980a(ViewHolder viewHolder);
    }

    private class HeaderFooterViewHolder extends ListingViewHolder {
        final /* synthetic */ RecyclerHeaderFooterAdapter f34363a;

        public final int mo6480Q() {
            return 0;
        }

        HeaderFooterViewHolder(RecyclerHeaderFooterAdapter recyclerHeaderFooterAdapter, View view) {
            this.f34363a = recyclerHeaderFooterAdapter;
            super(view);
        }
    }

    public RecyclerHeaderFooterAdapter(Adapter adapter) {
        super(adapter);
    }

    public final void m35092a(View view) {
        this.f34364b = view;
    }

    private boolean m35087h() {
        if (this.f34365c == null) {
            if (this.f34366f == null) {
                return false;
            }
        }
        return true;
    }

    public final int m35095f() {
        return this.f34364b != null ? 1 : 0;
    }

    public final int m35096g() {
        return m35087h() ? 1 : 0;
    }

    public final int mo6510a() {
        int f = m35095f() + m35096g();
        Adapter adapter = this.f29087a;
        return adapter == null ? f : adapter.a() + f;
    }

    public final ViewHolder mo6512a(ViewGroup viewGroup, int i) {
        if (i == Integer.MIN_VALUE) {
            return new HeaderFooterViewHolder(this, this.f34364b);
        }
        if (i != RedditJobManager.f10810d) {
            return super.mo6512a(viewGroup, i);
        }
        return new HeaderFooterViewHolder(this, this.f34365c != null ? this.f34365c : this.f34366f.mo4979a());
    }

    public final void mo6513a(ViewHolder viewHolder, int i) {
        int b = mo6514b(i);
        if (b != Integer.MIN_VALUE) {
            if (b == RedditJobManager.f10810d) {
                if (this.f34366f != 0) {
                    this.f34366f.mo4980a(viewHolder);
                }
                return;
            }
            super.mo6513a(viewHolder, i - m35095f());
        }
    }

    public final int mo6515c(int i) {
        return super.mo6515c(i - m35095f());
    }

    public final long mo6511a(int i) {
        return this.f29087a.a(i - m35095f());
    }

    public final int mo6514b(int i) {
        int i2 = 0;
        int i3 = (this.f34364b == null || i != 0) ? 0 : 1;
        if (i3 != 0) {
            return Integer.MIN_VALUE;
        }
        if (m35087h() && i == mo6510a() - 1) {
            i2 = 1;
        }
        if (i2 != 0) {
            return RedditJobManager.f10810d;
        }
        return this.f29087a.b(i - m35095f());
    }
}
