package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzo extends FrameLayout implements OnClickListener {
    final ImageButton f5489a;
    private final zzt f5490b;

    public zzo(Context context, zzp com_google_android_gms_ads_internal_overlay_zzp, zzt com_google_android_gms_ads_internal_overlay_zzt) {
        super(context);
        this.f5490b = com_google_android_gms_ads_internal_overlay_zzt;
        setOnClickListener(this);
        this.f5489a = new ImageButton(context);
        this.f5489a.setImageResource(17301527);
        this.f5489a.setBackgroundColor(0);
        this.f5489a.setOnClickListener(this);
        ImageButton imageButton = this.f5489a;
        zzkb.m6345a();
        int a = zzajr.m5318a(context, com_google_android_gms_ads_internal_overlay_zzp.f5491a);
        zzkb.m6345a();
        int a2 = zzajr.m5318a(context, 0);
        zzkb.m6345a();
        int a3 = zzajr.m5318a(context, com_google_android_gms_ads_internal_overlay_zzp.f5492b);
        zzkb.m6345a();
        imageButton.setPadding(a, a2, a3, zzajr.m5318a(context, com_google_android_gms_ads_internal_overlay_zzp.f5494d));
        this.f5489a.setContentDescription("Interstitial close button");
        zzkb.m6345a();
        zzajr.m5318a(context, com_google_android_gms_ads_internal_overlay_zzp.f5495e);
        View view = this.f5489a;
        zzkb.m6345a();
        a = zzajr.m5318a(context, (com_google_android_gms_ads_internal_overlay_zzp.f5495e + com_google_android_gms_ads_internal_overlay_zzp.f5491a) + com_google_android_gms_ads_internal_overlay_zzp.f5492b);
        zzkb.m6345a();
        addView(view, new LayoutParams(a, zzajr.m5318a(context, com_google_android_gms_ads_internal_overlay_zzp.f5495e + com_google_android_gms_ads_internal_overlay_zzp.f5494d), 17));
    }

    public final void onClick(View view) {
        if (this.f5490b != null) {
            this.f5490b.mo3383c();
        }
    }
}
