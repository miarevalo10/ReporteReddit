package com.reddit.frontpage.ui.promoted;

import android.graphics.Point;
import android.net.Uri;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeAppInstallAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository.NativeContentAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.v2.AdsRelated;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.ui.listing.adapter.AccessibleAdapter;
import com.reddit.frontpage.ui.listing.adapter.BaseWrapperAdapter;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

public class RedditDfpRecyclerAdapter extends BaseWrapperAdapter {
    public int f34442b;
    public int f34443c;
    public boolean f34444f;
    public List<NativeAdInfo<?>> f34445g = new ArrayList();
    public SparseArrayCompat<NativeAdInfo<?>> f34446h = new SparseArrayCompat();
    private int f34447i;
    private int f34448j;
    private String f34449k;

    public class AdViewHolder_ViewBinding implements Unbinder {
        private AdViewHolder f29270b;

        public AdViewHolder_ViewBinding(AdViewHolder adViewHolder, View view) {
            this.f29270b = adViewHolder;
            adViewHolder.headline = (TextView) Utils.b(view, C1761R.id.ad_headline, "field 'headline'", TextView.class);
            adViewHolder.body = (TextView) Utils.a(view, C1761R.id.ad_body, "field 'body'", TextView.class);
            adViewHolder.mediaContainer = (ViewGroup) Utils.a(view, C1761R.id.ad_media_container, "field 'mediaContainer'", ViewGroup.class);
            adViewHolder.image = (ImageView) Utils.a(view, C1761R.id.ad_image, "field 'image'", ImageView.class);
            adViewHolder.video = (MediaView) Utils.a(view, C1761R.id.ad_video, "field 'video'", MediaView.class);
            adViewHolder.icon = (ImageView) Utils.a(view, C1761R.id.ad_logo, "field 'icon'", ImageView.class);
            adViewHolder.advertiser = (TextView) Utils.b(view, C1761R.id.ad_advertiser, "field 'advertiser'", TextView.class);
            adViewHolder.callToAction = (TextView) Utils.b(view, C1761R.id.ad_call_to_action, "field 'callToAction'", TextView.class);
        }

        public void mo6524a() {
            AdViewHolder adViewHolder = this.f29270b;
            if (adViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f29270b = null;
            adViewHolder.headline = null;
            adViewHolder.body = null;
            adViewHolder.mediaContainer = null;
            adViewHolder.image = null;
            adViewHolder.video = null;
            adViewHolder.icon = null;
            adViewHolder.advertiser = null;
            adViewHolder.callToAction = null;
        }
    }

    static abstract class AdViewHolder<T extends NativeAdInfo<U>, U extends NativeAd> extends ListingViewHolder implements VisibilityDependent {
        int f34436a = -1;
        @BindView
        TextView advertiser;
        private T f34437b;
        @BindView
        TextView body;
        @BindView
        TextView callToAction;
        @BindView
        TextView headline;
        @BindView
        ImageView icon;
        @BindView
        ImageView image;
        @BindView
        ViewGroup mediaContainer;
        private U f34438p;
        private Point f34439q;
        @BindView
        MediaView video;

        public final int mo6480Q() {
            return 0;
        }

        abstract Uri mo7016a(U u, boolean z);

        abstract void mo7017a(U u);

        abstract void mo7018a(NativeAdInfo<U> nativeAdInfo);

        public final void aq() {
        }

        abstract boolean mo7019b(U u);

        abstract CharSequence mo7020c(U u);

        abstract CharSequence mo7021d(U u);

        abstract CharSequence mo7022e(U u);

        abstract CharSequence mo7023f(U u);

        abstract Uri mo7024g(U u);

        AdViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
            this.f34439q = Util.m23955a(Util.m24014d(view.getContext()));
            if (this.icon != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.icon.getLayoutParams();
                marginLayoutParams.width = (int) (((((double) this.f34439q.x) * 0.25d) - ((double) marginLayoutParams.rightMargin)) - ((double) marginLayoutParams.leftMargin));
                marginLayoutParams.height = marginLayoutParams.width;
                this.icon.requestLayout();
            }
        }

        public final void m35193a(int i, T t, boolean z) {
            if (this.f34438p != t.a) {
                this.f34437b = t;
                this.f34438p = t.a;
                if (!mo7019b(this.f34438p)) {
                    i = -1;
                }
                this.f34436a = i;
                mo7017a(this.f34438p);
                i = t.b;
                if (this.mediaContainer != null) {
                    if (i <= 0) {
                        i = 1072986849;
                    }
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mediaContainer.getLayoutParams();
                    marginLayoutParams.width = this.f34439q.x;
                    marginLayoutParams.height = (int) (((float) marginLayoutParams.width) / i);
                    this.mediaContainer.setLayoutParams(marginLayoutParams);
                    this.mediaContainer.requestLayout();
                }
                this.headline.setText(mo7020c(this.f34438p));
                this.advertiser.setText(mo7022e(this.f34438p));
                this.callToAction.setText(mo7023f(this.f34438p));
                if (this.icon != 0) {
                    i = mo7016a(this.f34438p, z);
                    if (i != 0) {
                        GlideApp.a(this.c.getContext()).b(i).centerCrop().into(this.icon);
                        this.icon.setVisibility(0);
                    } else {
                        this.icon.setVisibility(8);
                    }
                }
                if (this.image != 0 && t.a() == 0) {
                    i = mo7024g(this.f34438p);
                    if (i != 0) {
                        GlideApp.a(this.c.getContext()).b(i).fitCenter().into(this.image);
                        this.image.setVisibility(0);
                    } else {
                        this.image.setVisibility(8);
                    }
                }
                if (this.body != 0) {
                    i = mo7021d(this.f34438p);
                    if (TextUtils.isEmpty(i) == null) {
                        this.body.setText(i);
                        this.body.setVisibility(0);
                        return;
                    }
                    this.body.setVisibility(8);
                }
            }
        }

        public final void ap() {
            if (this.f34437b.c < 0) {
                Timber.b("Marking app install ad as seen", new Object[0]);
                NativeAdInfo nativeAdInfo = this.f34437b;
                if (!nativeAdInfo.d) {
                    nativeAdInfo.d = true;
                    FrontpageSettings.a().v();
                }
            }
        }
    }

    public class AppInstallAdViewHolder_ViewBinding extends AdViewHolder_ViewBinding {
        private AppInstallAdViewHolder f34440b;

        public AppInstallAdViewHolder_ViewBinding(AppInstallAdViewHolder appInstallAdViewHolder, View view) {
            super(appInstallAdViewHolder, view);
            this.f34440b = appInstallAdViewHolder;
            appInstallAdViewHolder.adView = (NativeAppInstallAdView) Utils.b(view, C1761R.id.ad_view, "field 'adView'", NativeAppInstallAdView.class);
        }

        public final void mo6524a() {
            AppInstallAdViewHolder appInstallAdViewHolder = this.f34440b;
            if (appInstallAdViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f34440b = null;
            appInstallAdViewHolder.adView = null;
            super.mo6524a();
        }
    }

    public class ContentAdViewHolder_ViewBinding extends AdViewHolder_ViewBinding {
        private ContentAdViewHolder f34441b;

        public ContentAdViewHolder_ViewBinding(ContentAdViewHolder contentAdViewHolder, View view) {
            super(contentAdViewHolder, view);
            this.f34441b = contentAdViewHolder;
            contentAdViewHolder.adView = (NativeContentAdView) Utils.b(view, C1761R.id.ad_view, "field 'adView'", NativeContentAdView.class);
        }

        public final void mo6524a() {
            ContentAdViewHolder contentAdViewHolder = this.f34441b;
            if (contentAdViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f34441b = null;
            contentAdViewHolder.adView = null;
            super.mo6524a();
        }
    }

    static class AppInstallAdViewHolder extends AdViewHolder<NativeAppInstallAdInfo, NativeAppInstallAd> {
        @BindView
        NativeAppInstallAdView adView;

        final /* bridge */ /* synthetic */ CharSequence mo7021d(NativeAd nativeAd) {
            return null;
        }

        final /* synthetic */ Uri mo7016a(NativeAd nativeAd, boolean z) {
            nativeAd = ((NativeAppInstallAd) nativeAd).e();
            return nativeAd != null ? nativeAd.b() : null;
        }

        final /* synthetic */ void mo7017a(NativeAd nativeAd) {
            NativeAppInstallAd nativeAppInstallAd = (NativeAppInstallAd) nativeAd;
            if (this.video != null) {
                if (nativeAppInstallAd.j().b()) {
                    this.video.setVisibility(0);
                    this.image.setVisibility(8);
                } else {
                    this.video.setVisibility(8);
                    this.image.setVisibility(0);
                }
            }
            this.adView.setMediaView(this.video);
            this.adView.setNativeAd(nativeAppInstallAd);
        }

        final /* synthetic */ boolean mo7019b(NativeAd nativeAd) {
            return ((NativeAppInstallAd) nativeAd).j().b();
        }

        final /* synthetic */ CharSequence mo7020c(NativeAd nativeAd) {
            return ((NativeAppInstallAd) nativeAd).b();
        }

        final /* bridge */ /* synthetic */ CharSequence mo7023f(NativeAd nativeAd) {
            return ((NativeAppInstallAd) nativeAd).f();
        }

        final /* synthetic */ Uri mo7024g(NativeAd nativeAd) {
            nativeAd = ((NativeAppInstallAd) nativeAd).c();
            return !nativeAd.isEmpty() ? ((Image) nativeAd.get(0)).b() : null;
        }

        AppInstallAdViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
            this.adView.setHeadlineView(this.headline);
            this.adView.setImageView(this.image);
            this.adView.setBodyView(this.body);
            this.adView.setIconView(this.icon);
            this.adView.setCallToActionView(this.callToAction);
        }

        final void mo7018a(NativeAdInfo<NativeAppInstallAd> nativeAdInfo) {
            if (this.video != null && this.video.getChildCount() > 0) {
                this.video.removeAllViews();
            }
            if (nativeAdInfo.a()) {
                this.adView.setMediaView(null);
                this.adView.setNativeAd(nativeAdInfo.a);
                nativeAdInfo.b();
            }
        }

        final /* synthetic */ CharSequence mo7022e(NativeAd nativeAd) {
            return Util.m24027f((int) C1761R.string.label_app);
        }
    }

    static class ContentAdViewHolder extends AdViewHolder<NativeContentAdInfo, NativeContentAd> {
        @BindView
        NativeContentAdView adView;

        final /* synthetic */ Uri mo7016a(NativeAd nativeAd, boolean z) {
            NativeContentAd nativeContentAd = (NativeContentAd) nativeAd;
            if (z) {
                nativeAd = nativeContentAd.e();
                if (nativeAd != null) {
                    return nativeAd.b();
                }
            }
            return null;
        }

        final /* synthetic */ void mo7017a(NativeAd nativeAd) {
            NativeContentAd nativeContentAd = (NativeContentAd) nativeAd;
            if (this.video != null) {
                if (nativeContentAd.h().b()) {
                    this.video.setVisibility(0);
                    this.image.setVisibility(8);
                } else {
                    this.video.setVisibility(8);
                    this.image.setVisibility(0);
                }
            }
            this.adView.setMediaView(this.video);
            this.adView.setNativeAd(nativeContentAd);
        }

        final /* synthetic */ boolean mo7019b(NativeAd nativeAd) {
            return ((NativeContentAd) nativeAd).h().b();
        }

        final /* synthetic */ CharSequence mo7020c(NativeAd nativeAd) {
            return ((NativeContentAd) nativeAd).b();
        }

        final /* bridge */ /* synthetic */ CharSequence mo7021d(NativeAd nativeAd) {
            return ((NativeContentAd) nativeAd).d();
        }

        final /* synthetic */ CharSequence mo7022e(NativeAd nativeAd) {
            return ((NativeContentAd) nativeAd).g();
        }

        final /* bridge */ /* synthetic */ CharSequence mo7023f(NativeAd nativeAd) {
            return ((NativeContentAd) nativeAd).f();
        }

        final /* synthetic */ Uri mo7024g(NativeAd nativeAd) {
            nativeAd = ((NativeContentAd) nativeAd).c();
            return !nativeAd.isEmpty() ? ((Image) nativeAd.get(0)).b() : null;
        }

        ContentAdViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
            this.adView.setHeadlineView(this.headline);
            this.adView.setImageView(this.image);
            this.adView.setLogoView(this.icon);
            this.adView.setBodyView(this.body);
            this.adView.setAdvertiserView(this.advertiser);
            this.adView.setCallToActionView(this.callToAction);
        }

        final void mo7018a(NativeAdInfo<NativeContentAd> nativeAdInfo) {
            if (this.video != null && this.video.getChildCount() > 0) {
                this.video.removeAllViews();
            }
            if (nativeAdInfo.a()) {
                this.adView.setMediaView(null);
                this.adView.setNativeAd(nativeAdInfo.a);
                nativeAdInfo.b();
            }
        }
    }

    public <T extends Adapter & AccessibleAdapter<Listable>> RedditDfpRecyclerAdapter(T t, String str) {
        super(t);
        t = FrontpageSettings.a().t().a();
        this.f34447i = t.b() - 1;
        this.f34448j = t.c();
        this.f34449k = str;
        m35206g();
    }

    private void m35206g() {
        this.f34444f = ((ListingViewMode) FrontpageApplication.m28875k().mo4613a().m22477b(this.f34449k != null ? this.f34449k : "listingViewMode.globalDefault", FrontpageSettings.a().c() ? ListingViewMode.f20613b : ListingViewMode.f20612a).blockingGet()) == ListingViewMode.f20613b;
    }

    protected final void mo6525c() {
        super.mo6525c();
        m35206g();
    }

    protected final void mo6527e(int i, int i2) {
        m35207g(i, i2);
        super.mo6527e(i, i2);
    }

    protected final void mo6528f(int i, int i2) {
        m35207g(i, -i2);
        super.mo6528f(i, i2);
    }

    private void m35207g(int i, int i2) {
        int i3;
        int c;
        if (i2 < 0) {
            for (i3 = 0; i3 < this.f34446h.a(); i3++) {
                c = this.f34446h.c(i3);
                if (c > i) {
                    m35208h(c + i2, i3);
                }
            }
            return;
        }
        for (i3 = this.f34446h.a() - 1; i3 >= 0; i3--) {
            c = this.f34446h.c(i3);
            if (c <= i) {
                break;
            }
            m35208h(c + i2, i3);
        }
    }

    private void m35208h(int i, int i2) {
        NativeAdInfo nativeAdInfo = (NativeAdInfo) this.f34446h.d(i2);
        SparseArrayCompat sparseArrayCompat = this.f34446h;
        if (sparseArrayCompat.c[i2] != SparseArrayCompat.a) {
            sparseArrayCompat.c[i2] = SparseArrayCompat.a;
            sparseArrayCompat.b = true;
        }
        this.f34446h.a(i, nativeAdInfo);
        nativeAdInfo.c = i;
    }

    public final int mo6514b(int i) {
        NativeAdInfo nativeAdInfo = (NativeAdInfo) this.f34446h.a(i);
        if (nativeAdInfo != null) {
            return (nativeAdInfo.a instanceof NativeAppInstallAd) != 0 ? this.f34444f != 0 ? -56 : -55 : this.f34444f != 0 ? -58 : -57;
        } else {
            return super.mo6514b(m35205g(i));
        }
    }

    public final void mo6526c(ViewHolder viewHolder) {
        super.mo6526c(viewHolder);
        if (viewHolder instanceof AdViewHolder) {
            AdViewHolder adViewHolder = (AdViewHolder) viewHolder;
            if (viewHolder.d() >= 0 && adViewHolder.f34437b.a()) {
                viewHolder.c.post(new RedditDfpRecyclerAdapter$$Lambda$0(this, viewHolder));
            }
        }
    }

    public final ViewHolder mo6512a(ViewGroup viewGroup, int i) {
        switch (i) {
            case -58:
            case -57:
                return new ContentAdViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i == -57 ? C1761R.layout.listitem_ad_content : C1761R.layout.listitem_ad_content_compact, viewGroup, false));
            case -56:
            case -55:
                return new AppInstallAdViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i == -55 ? C1761R.layout.listitem_ad_install : C1761R.layout.listitem_ad_install_compact, viewGroup, false));
            default:
                return super.mo6512a(viewGroup, i);
        }
    }

    public final void mo6513a(ViewHolder viewHolder, int i) {
        if (mo6510a() != this.f34443c) {
            this.f34443c = mo6510a();
            viewHolder.c.post(new RedditDfpRecyclerAdapter$$Lambda$1(this));
        }
        this.f34442b = Math.max(this.f34442b, i);
        NativeAdInfo nativeAdInfo = (NativeAdInfo) this.f34446h.a(i);
        if (nativeAdInfo != null) {
            if (viewHolder.h != -55) {
                if (viewHolder.h != -56) {
                    ((ContentAdViewHolder) viewHolder).m35193a(i, (NativeContentAdInfo) nativeAdInfo, this.f34444f);
                    return;
                }
            }
            ((AppInstallAdViewHolder) viewHolder).m35193a(i, (NativeAppInstallAdInfo) nativeAdInfo, this.f34444f);
            return;
        }
        super.mo6513a(viewHolder, m35205g(i));
    }

    public final int mo6510a() {
        int a = super.mo6510a();
        for (int i = 0; i < this.f34446h.a(); i++) {
            if (this.f34446h.c(i) < a) {
                a++;
            }
        }
        return a;
    }

    private int m35205g(int i) {
        int e = this.f34446h.e(i);
        return e >= 0 ? e : (i + e) + 1;
    }

    public final int mo6515c(int i) {
        int e = this.f34446h.e(i);
        if (e < 0) {
            e = (i + e) + 1;
        }
        return super.mo6515c(e);
    }

    public final void m35212a(NativeAdInfo<?> nativeAdInfo) {
        if (!m35204b((NativeAdInfo) nativeAdInfo)) {
            this.f34445g.add(nativeAdInfo);
        }
    }

    private boolean m35204b(NativeAdInfo<?> nativeAdInfo) {
        if (this.f29087a == null) {
            return false;
        }
        int i = nativeAdInfo.c;
        if (i >= 0) {
            this.f34446h.a(i, nativeAdInfo);
            return true;
        }
        i = this.f34446h.a();
        i = i > 0 ? this.f34446h.c(i - 1) : 0;
        int max = Math.max(i != 0 ? this.f34448j + i : this.f34447i, this.f34442b);
        int a = mo6510a();
        int i2 = nativeAdInfo.c;
        if (i2 < 0) {
            i2 = max - 1;
            boolean z = false;
            while (i2 < a) {
                if (i2 < 0) {
                    z = true;
                } else {
                    boolean z2;
                    Listable listable = (Listable) ((AccessibleAdapter) this.f29087a).mo4996g(m35205g(i2));
                    if (listable instanceof AdsRelated) {
                        AdsRelated adsRelated = (AdsRelated) listable;
                        if (adsRelated.isNsfw() || !adsRelated.isBrandSafe()) {
                            z2 = false;
                            if (!z && z2) {
                                break;
                            }
                            z = z2;
                        }
                    }
                    z2 = true;
                    if (!z) {
                    }
                    z = z2;
                }
                i2++;
            }
            i2 = -1;
        }
        Timber.b("targetPosition %d lastAdPosition %d maxBound %d position %d", new Object[]{Integer.valueOf(max), Integer.valueOf(i), Integer.valueOf(this.f34442b), Integer.valueOf(i2)});
        if (i2 < 0) {
            return false;
        }
        this.f34446h.a(i2, nativeAdInfo);
        nativeAdInfo.c = i2;
        e(i2);
        return true;
    }

    final /* synthetic */ void m35218f() {
        if (!this.f34445g.isEmpty()) {
            Iterator it = this.f34445g.iterator();
            while (it.hasNext() && m35204b((NativeAdInfo) it.next())) {
                it.remove();
            }
        }
    }
}
