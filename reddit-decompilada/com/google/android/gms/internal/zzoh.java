package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;

@zzzv
public final class zzoh extends RelativeLayout {
    private static final float[] f7949a = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable f7950b;

    public final void onAttachedToWindow() {
        if (this.f7950b != null) {
            this.f7950b.start();
        }
        super.onAttachedToWindow();
    }

    public zzoh(Context context, zzog com_google_android_gms_internal_zzog, LayoutParams layoutParams) {
        View textView;
        super(context);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzog);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f7949a, null, null));
        shapeDrawable.getPaint().setColor(com_google_android_gms_internal_zzog.f18183b);
        setLayoutParams(layoutParams);
        zzbs.m4488g().mo4288a((View) this, shapeDrawable);
        layoutParams = new LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzog.mo2089a())) {
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
            textView = new TextView(context);
            textView.setLayoutParams(layoutParams2);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(com_google_android_gms_internal_zzog.mo2089a());
            textView.setTextColor(com_google_android_gms_internal_zzog.f18184c);
            textView.setTextSize((float) com_google_android_gms_internal_zzog.f18185d);
            zzkb.m6345a();
            int a = zzajr.m5318a(context, 4);
            zzkb.m6345a();
            textView.setPadding(a, 0, zzajr.m5318a(context, 4), 0);
            addView(textView);
            layoutParams.addRule(1, textView.getId());
        }
        textView = new ImageView(context);
        textView.setLayoutParams(layoutParams);
        textView.setId(1195835394);
        Context<zzoi> context2 = com_google_android_gms_internal_zzog.f18182a;
        if (context2 != null && context2.size() > 1) {
            this.f7950b = new AnimationDrawable();
            for (zzoi a2 : context2) {
                try {
                    this.f7950b.addFrame((Drawable) zzn.m17693a(a2.mo2091a()), com_google_android_gms_internal_zzog.f18186e);
                } catch (LayoutParams layoutParams3) {
                    zzakb.m5367b("Error while getting drawable.", layoutParams3);
                }
            }
            zzbs.m4488g().mo4288a(textView, this.f7950b);
        } else if (context2.size() == 1) {
            try {
                textView.setImageDrawable((Drawable) zzn.m17693a(((zzoi) context2.get(0)).mo2091a()));
            } catch (Context context3) {
                zzakb.m5367b("Error while getting drawable.", context3);
            }
        }
        addView(textView);
    }
}
