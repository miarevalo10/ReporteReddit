package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzc;
import com.instabug.library.model.State;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@zzzv
public final class zzamd extends FrameLayout implements zzama {
    final zzamr f14150a;
    zzamb f14151b;
    long f14152c;
    String f14153d;
    private final zzamp f14154e;
    private final FrameLayout f14155f;
    private final zznu f14156g;
    private final long f14157h;
    private boolean f14158i;
    private boolean f14159j;
    private boolean f14160k;
    private boolean f14161l;
    private long f14162m;
    private Bitmap f14163n;
    private ImageView f14164o;
    private boolean f14165p;

    public zzamd(Context context, zzamp com_google_android_gms_internal_zzamp, boolean z, zznu com_google_android_gms_internal_zznu) {
        super(context);
        this.f14154e = com_google_android_gms_internal_zzamp;
        this.f14156g = com_google_android_gms_internal_zznu;
        this.f14155f = new FrameLayout(context);
        addView(this.f14155f, new LayoutParams(-1, -1));
        zzc.m4821a(com_google_android_gms_internal_zzamp.mo3468e());
        this.f14151b = com_google_android_gms_internal_zzamp.mo3468e().f5650b.mo1750a(context, com_google_android_gms_internal_zzamp, z, com_google_android_gms_internal_zznu);
        if (this.f14151b != null) {
            this.f14155f.addView(this.f14151b, new LayoutParams(-1, -1, 17));
            if (((Boolean) zzkb.m6350f().m6488a(zznh.f7910s)).booleanValue()) {
                m13368l();
            }
        }
        this.f14164o = new ImageView(context);
        this.f14157h = ((Long) zzkb.m6350f().m6488a(zznh.f7914w)).longValue();
        this.f14161l = ((Boolean) zzkb.m6350f().m6488a(zznh.f7912u)).booleanValue();
        if (this.f14156g != null) {
            this.f14156g.m6504a("spinner_used", this.f14161l ? "1" : "0");
        }
        this.f14150a = new zzamr(this);
        if (this.f14151b != null) {
            this.f14151b.mo3450a((zzama) this);
        }
        if (this.f14151b == null) {
            mo1743a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void m13348a(zzamp com_google_android_gms_internal_zzamp) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        com_google_android_gms_internal_zzamp.mo3462a("onVideoEvent", hashMap);
    }

    public static void m13349a(zzamp com_google_android_gms_internal_zzamp, String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        com_google_android_gms_internal_zzamp.mo3462a("onVideoEvent", hashMap);
    }

    public static void m13350a(zzamp com_google_android_gms_internal_zzamp, Map<String, List<Map<String, Object>>> map) {
        Map hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        com_google_android_gms_internal_zzamp.mo3462a("onVideoEvent", hashMap);
    }

    private final boolean m13351n() {
        return this.f14164o.getParent() != null;
    }

    public final void mo1742a(int i, int i2) {
        if (this.f14161l) {
            i = Math.max(i / ((Integer) zzkb.m6350f().m6488a(zznh.f7913v)).intValue(), 1);
            i2 = Math.max(i2 / ((Integer) zzkb.m6350f().m6488a(zznh.f7913v)).intValue(), 1);
            if (this.f14163n == null || this.f14163n.getWidth() != i || this.f14163n.getHeight() != i2) {
                this.f14163n = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f14165p = false;
            }
        }
    }

    public final void m13355a(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.f14155f.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void mo1743a(String str, String str2) {
        m13357a("error", "what", str, "extra", str2);
    }

    final void m13357a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        Object obj = null;
        for (Object obj2 : strArr) {
            if (obj == null) {
                obj = obj2;
            } else {
                hashMap.put(obj, obj2);
                obj = null;
            }
        }
        this.f14154e.mo3462a("onVideoEvent", hashMap);
    }

    public final void mo1744b() {
        if (this.f14151b != null && this.f14162m == 0) {
            float duration = ((float) this.f14151b.getDuration()) / 1000.0f;
            int videoWidth = this.f14151b.getVideoWidth();
            int videoHeight = this.f14151b.getVideoHeight();
            m13357a("canplaythrough", State.KEY_DURATION, String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public final void mo1745c() {
        if (!(this.f14154e.mo3467d() == null || this.f14159j)) {
            this.f14160k = (this.f14154e.mo3467d().getWindow().getAttributes().flags & 128) != 0;
            if (!this.f14160k) {
                this.f14154e.mo3467d().getWindow().addFlags(128);
                this.f14159j = true;
            }
        }
        this.f14158i = true;
    }

    public final void mo1746d() {
        m13357a("pause", new String[0]);
        m13369m();
        this.f14158i = false;
    }

    public final void mo1747e() {
        m13357a("ended", new String[0]);
        m13369m();
    }

    public final void mo1749g() {
        if (this.f14158i && m13351n()) {
            this.f14155f.removeView(this.f14164o);
        }
        if (this.f14163n != null) {
            long b = zzbs.m4492k().mo1633b();
            if (this.f14151b.getBitmap(this.f14163n) != null) {
                this.f14165p = true;
            }
            long b2 = zzbs.m4492k().mo1633b() - b;
            if (zzagf.m13279a()) {
                StringBuilder stringBuilder = new StringBuilder(46);
                stringBuilder.append("Spinner frame grab took ");
                stringBuilder.append(b2);
                stringBuilder.append("ms");
                zzagf.m13278a(stringBuilder.toString());
            }
            if (b2 > this.f14157h) {
                zzakb.m5371e("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.f14161l = false;
                this.f14163n = null;
                if (this.f14156g != null) {
                    this.f14156g.m6504a("spinner_jank", Long.toString(b2));
                }
            }
        }
    }

    public final void m13364h() {
        if (this.f14151b != null) {
            if (TextUtils.isEmpty(this.f14153d)) {
                m13357a("no_src", new String[0]);
            } else {
                this.f14151b.setVideoPath(this.f14153d);
            }
        }
    }

    public final void m13365i() {
        if (this.f14151b != null) {
            this.f14151b.mo3453d();
        }
    }

    public final void m13366j() {
        if (this.f14151b != null) {
            zzamb com_google_android_gms_internal_zzamb = this.f14151b;
            com_google_android_gms_internal_zzamb.f14149b.m5427a(true);
            com_google_android_gms_internal_zzamb.mo1740e();
        }
    }

    public final void m13367k() {
        if (this.f14151b != null) {
            zzamb com_google_android_gms_internal_zzamb = this.f14151b;
            com_google_android_gms_internal_zzamb.f14149b.m5427a(false);
            com_google_android_gms_internal_zzamb.mo1740e();
        }
    }

    @TargetApi(14)
    public final void m13368l() {
        if (this.f14151b != null) {
            View textView = new TextView(this.f14151b.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.f14151b.mo3447a());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.f14155f.addView(textView, new LayoutParams(-2, -2, 17));
            this.f14155f.bringChildToFront(textView);
        }
    }

    final void m13369m() {
        if (!(this.f14154e.mo3467d() == null || !this.f14159j || this.f14160k)) {
            this.f14154e.mo3467d().getWindow().clearFlags(128);
            this.f14159j = false;
        }
    }

    public final void m13353a(float f) {
        if (this.f14151b != null) {
            zzamb com_google_android_gms_internal_zzamb = this.f14151b;
            zzams com_google_android_gms_internal_zzams = com_google_android_gms_internal_zzamb.f14149b;
            com_google_android_gms_internal_zzams.f6586d = f;
            com_google_android_gms_internal_zzams.m5426a();
            com_google_android_gms_internal_zzamb.mo1740e();
        }
    }

    public final void mo1741a() {
        zzamr com_google_android_gms_internal_zzamr = this.f14150a;
        com_google_android_gms_internal_zzamr.f6581a = false;
        com_google_android_gms_internal_zzamr.m5425a();
        zzahn.f6379a.post(new zzame(this));
    }

    public final void mo1748f() {
        if (!(!this.f14165p || this.f14163n == null || m13351n())) {
            this.f14164o.setImageBitmap(this.f14163n);
            this.f14164o.invalidate();
            this.f14155f.addView(this.f14164o, new LayoutParams(-1, -1));
            this.f14155f.bringChildToFront(this.f14164o);
        }
        this.f14150a.f6581a = true;
        this.f14162m = this.f14152c;
        zzahn.f6379a.post(new zzamf(this));
    }
}
