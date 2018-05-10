package com.google.android.gms.internal;

final class zzaiz implements zzx {
    private /* synthetic */ String f14112a;
    private /* synthetic */ zzajc f14113b;

    zzaiz(String str, zzajc com_google_android_gms_internal_zzajc) {
        this.f14112a = str;
        this.f14113b = com_google_android_gms_internal_zzajc;
    }

    public final void mo1726a(zzad com_google_android_gms_internal_zzad) {
        String str = this.f14112a;
        String com_google_android_gms_internal_zzad2 = com_google_android_gms_internal_zzad.toString();
        StringBuilder stringBuilder = new StringBuilder((21 + String.valueOf(str).length()) + String.valueOf(com_google_android_gms_internal_zzad2).length());
        stringBuilder.append("Failed to load URL: ");
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append(com_google_android_gms_internal_zzad2);
        zzakb.m5371e(stringBuilder.toString());
        this.f14113b.mo3446a(null);
    }
}
