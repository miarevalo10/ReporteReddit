package com.reddit.frontpage.ui.profile;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.provider.SavedLinksProvider;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.layout.SmoothScrollingLinearLayoutManager;
import com.reddit.frontpage.ui.listener.AutoplayGifsOnScrollListener;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependentDelegate.ItemChangedListener;

public class SavedLinksScreen extends SavedListingScreen implements VisibilityDependent {
    private VisibilityDependentDelegate f40168A;
    private ItemChangedListener f40169B = new C23602(this);

    class C23591 implements OnChildAttachStateChangeListener {
        final /* synthetic */ SavedLinksScreen f29236a;

        C23591(SavedLinksScreen savedLinksScreen) {
            this.f29236a = savedLinksScreen;
        }

        public final void m30341a(View view) {
            view = this.f29236a.listview.getChildViewHolder(view);
            if (view instanceof VisibilityDependent) {
                ((VisibilityDependent) view).ap();
            }
        }

        public final void m30342b(View view) {
            view = this.f29236a.listview.getChildViewHolder(view);
            if (view instanceof VisibilityDependent) {
                ((VisibilityDependent) view).aq();
            }
        }
    }

    class C23602 implements ItemChangedListener {
        final /* synthetic */ SavedLinksScreen f29237a;

        C23602(SavedLinksScreen savedLinksScreen) {
            this.f29237a = savedLinksScreen;
        }

        public final void mo4827a(int i, int i2) {
            this.f29237a.f40168A.m23491a(i, i2, true);
        }

        public final void mo4826a(int i) {
            this.f29237a.f40168A.m23492a(i, true);
        }
    }

    private class SavedLinksAdapter extends CardLinkAdapter {
        final /* synthetic */ SavedLinksScreen f34411a;

        public final /* synthetic */ Listable mo6476c(int i) {
            return m35151n(i);
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return m35151n(i);
        }

        SavedLinksAdapter(SavedLinksScreen savedLinksScreen) {
            this.f34411a = savedLinksScreen;
            super(savedLinksScreen.am_(), 1);
        }

        public final boolean mo6477c() {
            return this.f34411a.isCompact;
        }

        private Link m35151n(int i) {
            return (Link) ((ThingWrapper) this.f34411a.w.a(i)).getData();
        }

        protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
            Routing.m22623a((Screen) this.f34411a, Nav.m22541a(link));
        }

        public final int m35152a() {
            return this.f34411a.w.c();
        }
    }

    public String getAnalyticsScreenName() {
        return "profile_saved_links";
    }

    public final /* bridge */ /* synthetic */ void mo7461O() {
        super.mo7461O();
    }

    public final /* bridge */ /* synthetic */ void mo7462P() {
        super.mo7462P();
    }

    public final /* bridge */ /* synthetic */ int mo7141s() {
        return super.mo7141s();
    }

    public final /* bridge */ /* synthetic */ void mo7466y() {
        super.mo7466y();
    }

    public static SavedLinksScreen m41067w() {
        SavedLinksScreen savedLinksScreen = new SavedLinksScreen();
        savedLinksScreen.isCompact = FrontpageSettings.a().c();
        return savedLinksScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater = super.mo7139a(layoutInflater, viewGroup);
        this.v = SmoothScrollingLinearLayoutManager.m35006a(am_(), this.f40169B);
        this.listview.setLayoutManager(this.v);
        this.listview.addOnScrollListener(new AutoplayGifsOnScrollListener(this.v, this.f40169B));
        this.f40168A = new VisibilityDependentDelegate(this.listview);
        this.listview.addOnChildAttachStateChangeListener(new C23591(this));
        return layoutInflater;
    }

    protected final void mo7144v() {
        this.w = new SavedLinksProvider();
        m37523a(this.w);
    }

    protected final Adapter mo7465x() {
        Adapter savedLinksAdapter = new SavedLinksAdapter(this);
        savedLinksAdapter.f29116m = new SavedLinksScreen$$Lambda$0(this);
        return savedLinksAdapter;
    }

    public final void ap() {
        this.f40168A.m23493a(true);
    }

    public final void aq() {
        if (this.v != null) {
            this.listview.stopScroll();
            this.f40168A.m23493a(false);
        }
    }
}
