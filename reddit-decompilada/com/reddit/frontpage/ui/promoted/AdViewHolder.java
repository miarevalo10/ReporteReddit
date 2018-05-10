package com.reddit.frontpage.ui.promoted;

import android.graphics.Point;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.instabug.chat.model.Attachment;
import com.reddit.datalibrary.frontpage.data.feature.ads.NativeAdInfoPresentationModel;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.Util;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001 \u0000*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u00103\u001a\u0002042\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u00105J\u0017\u00106\u001a\u0004\u0018\u0001042\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u00105J\u0015\u00107\u001a\u0002042\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u00105J\u0015\u00108\u001a\u0002042\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u00105J\u001f\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\n\u001a\u00028\u00012\u0006\u0010;\u001a\u00020<H&¢\u0006\u0002\u0010=J\u0017\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u0010?J#\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u0002022\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010;\u001a\u00020<¢\u0006\u0002\u0010CJ\u0016\u0010D\u001a\u00020A2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010EH&J\b\u0010F\u001a\u000202H\u0016J\u0015\u0010G\u001a\u00020<2\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u0010HJ\b\u0010I\u001a\u00020AH\u0016J\b\u0010J\u001a\u00020AH\u0016J\u0015\u0010K\u001a\u00020A2\u0006\u0010\n\u001a\u00028\u0001H&¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020AH\u0002J\u0010\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020PH\u0002R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u0018\u0010\u0011R\u001b\u0010\u001a\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001b\u0010\u0011R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8FX\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b#\u0010 R\u001d\u0010%\u001a\u0004\u0018\u00010&8FX\u0002¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u0004\u0018\u00010-8FX\u0002¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/reddit/frontpage/ui/promoted/AdViewHolder;", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAdInfoPresentationModel;", "U", "Lcom/google/android/gms/ads/formats/NativeAd;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "Lcom/reddit/frontpage/ui/listing/newcard/VisibilityDependent;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ad", "Lcom/google/android/gms/ads/formats/NativeAd;", "adInfo", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAdInfoPresentationModel;", "advertiser", "Landroid/widget/TextView;", "getAdvertiser", "()Landroid/widget/TextView;", "advertiser$delegate", "Lkotlin/Lazy;", "body", "getBody", "body$delegate", "callToAction", "getCallToAction", "callToAction$delegate", "headline", "getHeadline", "headline$delegate", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon$delegate", "image", "getImage", "image$delegate", "mediaContainer", "Landroid/view/ViewGroup;", "getMediaContainer", "()Landroid/view/ViewGroup;", "mediaContainer$delegate", "screenDimensions", "Landroid/graphics/Point;", "video", "Lcom/google/android/gms/ads/formats/MediaView;", "getVideo", "()Lcom/google/android/gms/ads/formats/MediaView;", "video$delegate", "videoPosition", "", "adAdvertiser", "", "(Lcom/google/android/gms/ads/formats/NativeAd;)Ljava/lang/CharSequence;", "adBody", "adCallToAction", "adHeadline", "adIcon", "Landroid/net/Uri;", "compact", "", "(Lcom/google/android/gms/ads/formats/NativeAd;Z)Landroid/net/Uri;", "adImage", "(Lcom/google/android/gms/ads/formats/NativeAd;)Landroid/net/Uri;", "bind", "", "position", "(ILcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAdInfoPresentationModel;Z)V", "destroy", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsRepository$NativeAdInfo;", "getCategory", "hasVideo", "(Lcom/google/android/gms/ads/formats/NativeAd;)Z", "notifyOffScreen", "notifyOnScreen", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeAd;)V", "updateIconSize", "updateMediaSize", "aspectRatio", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdViewHolder.kt */
public abstract class AdViewHolder<T extends NativeAdInfoPresentationModel<? extends U>, U extends NativeAd> extends ListingViewHolder implements VisibilityDependent {
    static final /* synthetic */ KProperty[] f34423a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), "headline", "getHeadline()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), "body", "getBody()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), "mediaContainer", "getMediaContainer()Landroid/view/ViewGroup;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), Attachment.TYPE_IMAGE, "getImage()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), Attachment.TYPE_VIDEO, "getVideo()Lcom/google/android/gms/ads/formats/MediaView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), "icon", "getIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), "advertiser", "getAdvertiser()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AdViewHolder.class), "callToAction", "getCallToAction()Landroid/widget/TextView;"))};
    public int f34424b = -1;
    public T f34425p;
    public U f34426q;
    public final Point f34427r;
    private final Lazy f34428s;
    private final Lazy f34429t;
    private final Lazy f34430u;
    private final Lazy f34431v;
    private final Lazy f34432w;
    private final Lazy f34433x;
    private final Lazy f34434y;
    private final Lazy f34435z;

    public final ImageView m35173A() {
        return (ImageView) this.f34433x.mo5678b();
    }

    public final TextView m35174B() {
        return (TextView) this.f34434y.mo5678b();
    }

    public final TextView m35175C() {
        return (TextView) this.f34435z.mo5678b();
    }

    public final int mo6480Q() {
        return 11;
    }

    public abstract Uri mo7008a(U u, boolean z);

    public abstract void mo7009a(U u);

    public final void aq() {
    }

    public abstract boolean mo7010b(U u);

    public abstract CharSequence mo7011c(U u);

    public abstract CharSequence mo7012d(U u);

    public abstract CharSequence mo7013e(U u);

    public abstract CharSequence mo7014f(U u);

    public abstract Uri mo7015g(U u);

    public final TextView m35185v() {
        return (TextView) this.f34428s.mo5678b();
    }

    public final TextView m35186w() {
        return (TextView) this.f34429t.mo5678b();
    }

    public final ViewGroup m35187x() {
        return (ViewGroup) this.f34430u.mo5678b();
    }

    public final ImageView m35188y() {
        return (ImageView) this.f34431v.mo5678b();
    }

    public final MediaView m35189z() {
        return (MediaView) this.f34432w.mo5678b();
    }

    public AdViewHolder(View view) {
        Intrinsics.m26847b(view, "itemView");
        super(view);
        this.f34428s = LazyKt.m26777a(new AdViewHolder$headline$2(view));
        this.f34429t = LazyKt.m26777a(new AdViewHolder$body$2(view));
        this.f34430u = LazyKt.m26777a(new AdViewHolder$mediaContainer$2(view));
        this.f34431v = LazyKt.m26777a(new AdViewHolder$image$2(view));
        this.f34432w = LazyKt.m26777a(new AdViewHolder$video$2(view));
        this.f34433x = LazyKt.m26777a(new AdViewHolder$icon$2(view));
        this.f34434y = LazyKt.m26777a(new AdViewHolder$advertiser$2(view));
        this.f34435z = LazyKt.m26777a(new AdViewHolder$callToAction$2(view));
        Object a = Util.m23955a(Util.m24014d(view.getContext()));
        Intrinsics.m26843a(a, "Util.getScreenDimensions…tivity(itemView.context))");
        this.f34427r = a;
        if (m35173A() != null) {
            view = m35173A();
            view = view != null ? view.getLayoutParams() : null;
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view;
            marginLayoutParams.width = (int) (((((double) this.f34427r.x) * 0.25d) - ((double) marginLayoutParams.rightMargin)) - ((double) marginLayoutParams.leftMargin));
            marginLayoutParams.height = marginLayoutParams.width;
            view = m35173A();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public final void ap() {
        NativeAdInfoPresentationModel nativeAdInfoPresentationModel = this.f34425p;
        if (nativeAdInfoPresentationModel == null) {
            Intrinsics.m26844a("adInfo");
        }
        if (nativeAdInfoPresentationModel.a < 0) {
            Timber.b("Marking app install ad as seen", new Object[0]);
            nativeAdInfoPresentationModel = this.f34425p;
            if (nativeAdInfoPresentationModel == null) {
                Intrinsics.m26844a("adInfo");
            }
            if (!nativeAdInfoPresentationModel.b) {
                nativeAdInfoPresentationModel.b = true;
                FrontpageSettings.a().v();
            }
        }
    }
}
