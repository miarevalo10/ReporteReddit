package com.reddit.frontpage.ui.promoted;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.reddit.datalibrary.frontpage.data.feature.ads.NativeAppInstallAdInfoPresentationModel;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/ui/promoted/AppInstallAdViewHolder;", "Lcom/reddit/frontpage/ui/promoted/AdViewHolder;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAppInstallAdInfoPresentationModel;", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "adView", "Lcom/google/android/gms/ads/formats/NativeAppInstallAdView;", "getAdView", "()Lcom/google/android/gms/ads/formats/NativeAppInstallAdView;", "adView$delegate", "Lkotlin/Lazy;", "adAdvertiser", "", "ad", "adBody", "adCallToAction", "adHeadline", "adIcon", "Landroid/net/Uri;", "compact", "", "adImage", "destroy", "", "adInfo", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdsRepository$NativeAdInfo;", "hasVideo", "setNativeAd", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdViewHolder.kt */
public final class AppInstallAdViewHolder extends AdViewHolder<NativeAppInstallAdInfoPresentationModel, NativeAppInstallAd> {
    static final /* synthetic */ KProperty[] f37373s = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(AppInstallAdViewHolder.class), "adView", "getAdView()Lcom/google/android/gms/ads/formats/NativeAppInstallAdView;"))};
    public static final Companion f37374t = new Companion();
    private final Lazy f37375u;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/ui/promoted/AppInstallAdViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/ui/promoted/AppInstallAdViewHolder;", "parent", "Landroid/view/ViewGroup;", "isCompact", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AdViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AppInstallAdViewHolder m23606a(ViewGroup viewGroup, boolean z) {
            Intrinsics.m26847b(viewGroup, "parent");
            return new AppInstallAdViewHolder(ViewGroupsKt.m24100a(viewGroup, z ? true : true, false));
        }
    }

    private final NativeAppInstallAdView m37780D() {
        return (NativeAppInstallAdView) this.f37375u.mo5678b();
    }

    public static final AppInstallAdViewHolder m37781a(ViewGroup viewGroup, boolean z) {
        return Companion.m23606a(viewGroup, z);
    }

    public final /* synthetic */ Uri mo7008a(NativeAd nativeAd, boolean z) {
        NativeAppInstallAd nativeAppInstallAd = (NativeAppInstallAd) nativeAd;
        Intrinsics.m26847b(nativeAppInstallAd, "ad");
        nativeAd = nativeAppInstallAd.e();
        return nativeAd != null ? nativeAd.b() : null;
    }

    public final /* synthetic */ void mo7009a(NativeAd nativeAd) {
        NativeAppInstallAd nativeAppInstallAd = (NativeAppInstallAd) nativeAd;
        Intrinsics.m26847b(nativeAppInstallAd, "ad");
        MediaView z;
        ImageView y;
        if (m37782a(nativeAppInstallAd)) {
            z = m35189z();
            if (z != null) {
                z.setVisibility(0);
            }
            y = m35188y();
            if (y != null) {
                y.setVisibility(8);
            }
        } else {
            z = m35189z();
            if (z != null) {
                z.setVisibility(8);
            }
            y = m35188y();
            if (y != null) {
                y.setVisibility(0);
            }
        }
        if (m35189z() != null) {
            m37780D().setMediaView(m35189z());
        }
        m37780D().setNativeAd(nativeAppInstallAd);
    }

    public final /* synthetic */ boolean mo7010b(NativeAd nativeAd) {
        return m37782a((NativeAppInstallAd) nativeAd);
    }

    public final /* synthetic */ CharSequence mo7011c(NativeAd nativeAd) {
        NativeAppInstallAd nativeAppInstallAd = (NativeAppInstallAd) nativeAd;
        Intrinsics.m26847b(nativeAppInstallAd, "ad");
        Object b = nativeAppInstallAd.b();
        Intrinsics.m26843a(b, "ad.headline");
        return b;
    }

    public final /* synthetic */ CharSequence mo7012d(NativeAd nativeAd) {
        Intrinsics.m26847b((NativeAppInstallAd) nativeAd, "ad");
        return null;
    }

    public final /* synthetic */ CharSequence mo7013e(NativeAd nativeAd) {
        Intrinsics.m26847b((NativeAppInstallAd) nativeAd, "ad");
        Object f = Util.m24027f((int) C1761R.string.label_app);
        Intrinsics.m26843a(f, "Util.getString(R.string.label_app)");
        return (CharSequence) f;
    }

    public final /* synthetic */ CharSequence mo7014f(NativeAd nativeAd) {
        NativeAppInstallAd nativeAppInstallAd = (NativeAppInstallAd) nativeAd;
        Intrinsics.m26847b(nativeAppInstallAd, "ad");
        Object f = nativeAppInstallAd.f();
        Intrinsics.m26843a(f, "ad.callToAction");
        return f;
    }

    public final /* synthetic */ Uri mo7015g(NativeAd nativeAd) {
        NativeAppInstallAd nativeAppInstallAd = (NativeAppInstallAd) nativeAd;
        Intrinsics.m26847b(nativeAppInstallAd, "ad");
        Object c = nativeAppInstallAd.c();
        Intrinsics.m26843a(c, "ad.images");
        Image image = (Image) CollectionsKt___CollectionsKt.m41434e((List) c);
        return image != null ? image.b() : null;
    }

    private AppInstallAdViewHolder(View view) {
        super(view);
        this.f37375u = LazyKt.m26777a(new AppInstallAdViewHolder$adView$2(view));
        m37780D().setHeadlineView(m35185v());
        if (m35188y() != null) {
            m37780D().setImageView(m35188y());
        }
        if (m35186w() != null) {
            m37780D().setBodyView(m35186w());
        }
        if (m35173A() != null) {
            m37780D().setIconView(m35173A());
        }
        m37780D().setCallToActionView(m35175C());
    }

    private static boolean m37782a(NativeAppInstallAd nativeAppInstallAd) {
        Intrinsics.m26847b(nativeAppInstallAd, "ad");
        return nativeAppInstallAd.j().b();
    }
}
