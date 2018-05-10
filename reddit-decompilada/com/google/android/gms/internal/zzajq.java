package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzbs;

@zzzv
public final class zzajq {
    Activity f6466a;
    private final View f6467b;
    private boolean f6468c;
    private boolean f6469d;
    private boolean f6470e;
    private OnGlobalLayoutListener f6471f;
    private OnScrollChangedListener f6472g;

    public zzajq(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f6466a = activity;
        this.f6467b = view;
        this.f6471f = onGlobalLayoutListener;
        this.f6472g = onScrollChangedListener;
    }

    private final void m5312e() {
        if (!this.f6468c) {
            if (this.f6471f != null) {
                if (this.f6466a != null) {
                    zzbs.m4486e();
                    zzahn.m5165a(this.f6466a, this.f6471f);
                }
                zzbs.m4506y();
                zzaln.m5398a(this.f6467b, this.f6471f);
            }
            if (this.f6472g != null) {
                if (this.f6466a != null) {
                    zzbs.m4486e();
                    zzahn.m5166a(this.f6466a, this.f6472g);
                }
                zzbs.m4506y();
                zzaln.m5399a(this.f6467b, this.f6472g);
            }
            this.f6468c = true;
        }
    }

    private final void m5313f() {
        if (this.f6466a != null && this.f6468c) {
            if (!(this.f6471f == null || this.f6466a == null)) {
                zzbs.m4488g().mo4287a(this.f6466a, this.f6471f);
            }
            if (!(this.f6472g == null || this.f6466a == null)) {
                zzbs.m4486e();
                zzahn.m5190b(this.f6466a, this.f6472g);
            }
            this.f6468c = false;
        }
    }

    public final void m5314a() {
        this.f6470e = true;
        if (this.f6469d) {
            m5312e();
        }
    }

    public final void m5315b() {
        this.f6470e = false;
        m5313f();
    }

    public final void m5316c() {
        this.f6469d = true;
        if (this.f6470e) {
            m5312e();
        }
    }

    public final void m5317d() {
        this.f6469d = false;
        m5313f();
    }
}
