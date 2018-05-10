package com.reddit.frontpage.ui.promoted;

import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0010\b\u0000\u0010\u0002 \u0000*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "T", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/NativeAdInfoPresentationModel;", "U", "Lcom/google/android/gms/ads/formats/NativeAd;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: AdViewHolder.kt */
final class AdViewHolder$body$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ View f37365a;

    AdViewHolder$body$2(View view) {
        this.f37365a = view;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.f37365a.findViewById(C1761R.id.ad_body);
        if (!(findViewById instanceof TextView)) {
            findViewById = null;
        }
        return (TextView) findViewById;
    }
}
