package com.reddit.frontpage.ui.detail.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.RequestOptions;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkPreview;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.commons.analytics.outboundlinks.OutboundLinkTracker;
import com.reddit.frontpage.commons.vendor.CustomTabsActivityHelper;
import com.reddit.frontpage.ui.detail.FlexContainerDetailScreen;
import com.reddit.frontpage.ui.listing.adapter.ads.LegacyAdsNavigator;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import org.parceler.Parcels;
import timber.log.Timber;

public class WebDetailScreen extends FlexContainerDetailScreen {
    private View aa;
    private FrameLayout ab;

    public static WebDetailScreen m42213a(Link link, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("com.reddit.arg.link", Parcels.m28672a((Object) link));
        bundle2.putBundle("com.reddit.arg.context", bundle);
        return new WebDetailScreen(bundle2);
    }

    public WebDetailScreen(Bundle bundle) {
        super(bundle);
    }

    public final View mo7682T() {
        this.ab.setOnClickListener(new WebDetailScreen$$Lambda$0(this));
        ((TextView) this.ab.findViewById(C1761R.id.domain)).setText(this.f39153F.getDisplayDomain());
        ImageView imageView = (ImageView) this.ab.findViewById(C1761R.id.preview_image);
        LinkPreview preview = this.f39153F.getPreview();
        if (preview != null) {
            String sourceUrl = preview.getSourceUrl();
            Drawable snooProgressDrawable = new SnooProgressDrawable(this.ab.getContext());
            GlideApp.a(am_()).b(sourceUrl).placeholder(snooProgressDrawable).apply(RequestOptions.a(snooProgressDrawable)).listener(ImageProgressLoadListener.a(snooProgressDrawable, sourceUrl)).into(imageView);
        } else {
            imageView.setVisibility(8);
        }
        return this.ab;
    }

    final /* synthetic */ void mo7684x() {
        Timber.b("clicked content preview layout", new Object[0]);
        Link link = this.f39153F;
        String url = link.getUrl();
        Uri parse = Uri.parse(url);
        StringBuilder stringBuilder = new StringBuilder("host is ");
        stringBuilder.append(parse.getHost());
        Timber.b(stringBuilder.toString(), new Object[0]);
        if (LegacyAdsNavigator.m23458a(link)) {
            LegacyAdsNavigator.m23457a(am_(), link, "post_detail");
        } else if (LinkUtil.m23794b(url)) {
            StringBuilder stringBuilder2 = new StringBuilder("converted reddit link ");
            stringBuilder2.append(url);
            stringBuilder2.append(" to ");
            stringBuilder2.append(LinkUtil.m23795c(url).toString());
            Timber.b(stringBuilder2.toString(), new Object[0]);
            Uri c = LinkUtil.m23795c(url);
            StringBuilder stringBuilder3 = new StringBuilder("firing: ");
            stringBuilder3.append(c.toString());
            Timber.b(stringBuilder3.toString(), new Object[0]);
            a(new Intent("android.intent.action.VIEW", LinkUtil.m23795c(url)));
        } else {
            String str;
            Builder builder = new Builder();
            Context am_ = am_();
            if (this.f39153F.getSubredditDetail() != null) {
                str = this.f39153F.getSubredditDetail().key_color;
            } else {
                str = null;
            }
            CustomTabsIntent a = builder.a(Util.m23951a(am_, str)).a();
            String str2 = m39101W() ? "onboarding_post_detail" : "post_detail";
            OutboundLinkTracker.m21950a(url, link, getAnalyticsScreenName());
            CustomTabsActivityHelper.m21970a(am_(), a, Uri.parse(url), link.getName(), str2, new WebViewFallback(link));
        }
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.ab = (FrameLayout) layoutInflater.inflate(C1761R.layout.detail_content_web, this.f39167y, false);
        this.aa = this.ab.findViewById(C1761R.id.web_content_container);
        return super.mo7139a(layoutInflater, viewGroup);
    }

    public final int ag() {
        int dimensionPixelSize;
        if (this.f39153F.getPreview() == null) {
            dimensionPixelSize = ao_().getDimensionPixelSize(C1761R.dimen.sub_bar_height);
        } else {
            dimensionPixelSize = ao_().getDimensionPixelSize(C1761R.dimen.link_image_min_height) + ao_().getDimensionPixelSize(C1761R.dimen.sub_bar_height);
        }
        this.aa.getLayoutParams().height = dimensionPixelSize;
        this.aa.requestLayout();
        return dimensionPixelSize;
    }
}
