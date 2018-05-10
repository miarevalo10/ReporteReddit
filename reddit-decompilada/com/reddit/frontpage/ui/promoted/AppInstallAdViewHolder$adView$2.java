package com.reddit.frontpage.ui.promoted;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/gms/ads/formats/NativeAppInstallAdView;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdViewHolder.kt */
final class AppInstallAdViewHolder$adView$2 extends Lambda implements Function0<NativeAppInstallAdView> {
    final /* synthetic */ View f37372a;

    AppInstallAdViewHolder$adView$2(View view) {
        this.f37372a = view;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.f37372a.findViewById(C1761R.id.ad_view);
        if (findViewById != null) {
            return (NativeAppInstallAdView) findViewById;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.google.android.gms.ads.formats.NativeAppInstallAdView");
    }
}
