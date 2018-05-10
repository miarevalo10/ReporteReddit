package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzi {
    public final int f5483a;
    public final LayoutParams f5484b;
    public final ViewGroup f5485c;
    public final Context f5486d;

    public zzi(zzanh com_google_android_gms_internal_zzanh) throws zzg {
        this.f5484b = com_google_android_gms_internal_zzanh.getLayoutParams();
        ViewParent parent = com_google_android_gms_internal_zzanh.getParent();
        this.f5486d = com_google_android_gms_internal_zzanh.mo4010r();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        this.f5485c = (ViewGroup) parent;
        ViewGroup viewGroup = this.f5485c;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        View view = (View) com_google_android_gms_internal_zzanh;
        this.f5483a = viewGroup.indexOfChild(view);
        viewGroup = this.f5485c;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        viewGroup.removeView(view);
        com_google_android_gms_internal_zzanh.mo3993b(true);
    }
}
