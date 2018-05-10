package com.reddit.frontpage.ui.listing;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.ads.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.ads.SubredditAdMetadata;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdListener;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdLoader;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAppInstallAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeContentAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.ui.listing.adapter.AccessibleAdapter;
import com.reddit.frontpage.ui.promoted.RedditDfpRecyclerAdapter;
import com.reddit.frontpage.util.InternalAccountUtil;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import timber.log.Timber;

public abstract class AdsListingScreen extends BaseLinkListingScreen {
    private RedditDfpRecyclerAdapter f40158M;
    private NativeAdLoader f40159N;
    @State
    String adListingId = UUID.randomUUID().toString();
    @Inject
    AdsRepository f40160v;

    class C23351 implements NativeAdListener {
        final /* synthetic */ AdsListingScreen f29014a;

        C23351(AdsListingScreen adsListingScreen) {
            this.f29014a = adsListingScreen;
        }

        public final void m30076a(NativeAppInstallAdInfo nativeAppInstallAdInfo) {
            if (this.f29014a.e && this.f29014a.f40158M != null) {
                this.f29014a.f40158M.m35212a(nativeAppInstallAdInfo);
            }
        }

        public final void m30077a(NativeContentAdInfo nativeContentAdInfo) {
            if (this.f29014a.e && this.f29014a.f40158M != null) {
                this.f29014a.f40158M.m35212a(nativeContentAdInfo);
            }
        }
    }

    protected boolean mo7702Q() {
        return false;
    }

    protected SubredditAdMetadata mo7703R() {
        return null;
    }

    protected abstract String mo7447x();

    protected AdsListingScreen() {
    }

    protected AdsListingScreen(Bundle bundle) {
        super(bundle);
    }

    protected void mo7142t() {
        super.mo7142t();
        FrontpageApplication.m28874j().a(this);
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.listView.setItemAnimator(null);
        return this.K;
    }

    protected final Adapter mo7445a(Adapter adapter) {
        AppConfiguration t = FrontpageSettings.a().t();
        if (t == null) {
            Timber.b("Not showing ads: No app config", new Object[0]);
            return adapter;
        } else if (t.a().a()) {
            Account d = SessionManager.b().d();
            if (d == null || !d.is_gold || InternalAccountUtil.m23766a()) {
                this.f40158M = new RedditDfpRecyclerAdapter((Adapter) ((AccessibleAdapter) adapter), ah());
                if (mo7702Q() == null || mo7703R() != null) {
                    this.f40159N = mo4954w();
                } else {
                    Timber.b("Delaying ad loading: no subreddit", new Object[0]);
                }
                Timber.b("Showing ads, enjoy", new Object[0]);
                return this.f40158M;
            }
            Timber.b("Not showing ads: user has gold", new Object[0]);
            return adapter;
        } else {
            Timber.b("Not showing ads: Not active", new Object[0]);
            return adapter;
        }
    }

    public final void mo7446d(boolean z) {
        if (z && this.f40158M != null) {
            RedditDfpRecyclerAdapter redditDfpRecyclerAdapter = this.f40158M;
            redditDfpRecyclerAdapter.f34442b = 0;
            redditDfpRecyclerAdapter.f34443c = 0;
            redditDfpRecyclerAdapter.f34445g.clear();
            redditDfpRecyclerAdapter.f34446h.b();
        }
        super.mo7446d(z);
    }

    protected void mo6992b(View view) {
        super.mo6992b(view);
        if (this.f40159N != null) {
            this.f40159N.a();
        }
    }

    protected void mo6993c(View view) {
        super.mo6993c(view);
        if (this.f40159N != null) {
            view = this.f40159N;
            view.b = true;
            List list = (List) AdsRepository.a(view.c).get(view.a.c);
            List list2 = (List) AdsRepository.b(view.c).get(view.a.c);
            if (list != null && list2 != null) {
                list.addAll(0, list2);
                list2.clear();
            }
        }
    }

    public void mo6987a(View view) {
        super.mo6987a(view);
        this.f40158M = null;
        this.f40159N = null;
    }

    public void mo7191l() {
        this.f40160v.a(this.adListingId);
        super.mo7191l();
    }

    protected void mo7448y() {
        this.f40160v.a(this.adListingId);
        this.adListingId = UUID.randomUUID().toString();
        if (this.f40159N != null) {
            this.f40159N = mo4954w();
            this.f40159N.a();
        }
        super.mo7448y();
    }

    protected void mo7444O() {
        super.mo7444O();
        if (this.f40159N != null) {
            this.f40159N.a();
        }
    }

    protected final void m41008e(boolean z) {
        if (this.f40158M != null) {
            this.f40158M.f34444f = z;
        }
    }

    protected final void m40999P() {
        if (this.f40159N == null) {
            if (this.f40158M != null) {
                this.f40159N = mo4954w();
                if (this.e) {
                    this.f40159N.a();
                }
            }
        }
    }

    private NativeAdLoader mo4954w() {
        AdContext adContext = new AdContext(FrontpageSettings.a().t().a().a(mo7447x()), SessionManager.b().c, this.adListingId, getAnalyticsScreenName(), mo7703R());
        AdsRepository adsRepository = this.f40160v;
        NativeAdListener c23351 = new C23351(this);
        if (!adsRepository.c.contains(adContext.c)) {
            for (String str : adsRepository.c) {
                Timber.b("Removing ads for %s", new Object[]{str});
                List<NativeAdInfo> list = (List) adsRepository.a.get(str);
                if (list != null) {
                    for (NativeAdInfo b : list) {
                        b.b();
                    }
                    adsRepository.a.remove(str);
                }
                list = (List) adsRepository.b.get(str);
                if (list != null) {
                    for (NativeAdInfo b2 : list) {
                        b2.b();
                    }
                    adsRepository.b.remove(str);
                }
            }
            adsRepository.c.clear();
        }
        return new NativeAdLoader(adsRepository, adContext, c23351);
    }
}
