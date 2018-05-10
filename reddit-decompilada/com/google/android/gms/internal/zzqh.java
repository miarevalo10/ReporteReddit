package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzqh extends NativeAppInstallAd {
    private final zzqe f18268a;
    private final List<Image> f18269b = new ArrayList();
    private final zzpt f18270c;
    private final VideoController f18271d = new VideoController();
    private final AdChoicesInfo f18272e;

    public zzqh(zzqe com_google_android_gms_internal_zzqe) {
        zzpt com_google_android_gms_internal_zzpt;
        this.f18268a = com_google_android_gms_internal_zzqe;
        AdChoicesInfo adChoicesInfo = null;
        try {
            List b = this.f18268a.mo2107b();
            if (b != null) {
                for (Object next : b) {
                    zzpq com_google_android_gms_internal_zzps;
                    if (next instanceof IBinder) {
                        IBinder iBinder = (IBinder) next;
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                            com_google_android_gms_internal_zzps = queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(iBinder);
                            if (com_google_android_gms_internal_zzps != null) {
                                this.f18269b.add(new zzpt(com_google_android_gms_internal_zzps));
                            }
                        }
                    }
                    com_google_android_gms_internal_zzps = null;
                    if (com_google_android_gms_internal_zzps != null) {
                        this.f18269b.add(new zzpt(com_google_android_gms_internal_zzps));
                    }
                }
            }
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get image.", e);
        }
        try {
            zzpq d = this.f18268a.mo2111d();
            if (d != null) {
                com_google_android_gms_internal_zzpt = new zzpt(d);
                this.f18270c = com_google_android_gms_internal_zzpt;
                if (this.f18268a.mo2121r() != null) {
                    adChoicesInfo = new zzpp(this.f18268a.mo2121r());
                }
                this.f18272e = adChoicesInfo;
            }
        } catch (Throwable e2) {
            zzakb.m5367b("Failed to get image.", e2);
        }
        com_google_android_gms_internal_zzpt = null;
        this.f18270c = com_google_android_gms_internal_zzpt;
        try {
            if (this.f18268a.mo2121r() != null) {
                adChoicesInfo = new zzpp(this.f18268a.mo2121r());
            }
        } catch (Throwable e22) {
            zzakb.m5367b("Failed to get attribution info.", e22);
        }
        this.f18272e = adChoicesInfo;
    }

    private final IObjectWrapper m18952l() {
        try {
            return this.f18268a.mo2117j();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object mo3546a() {
        return m18952l();
    }

    public final CharSequence mo3547b() {
        try {
            return this.f18268a.mo2105a();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get headline.", e);
            return null;
        }
    }

    public final List<Image> mo3548c() {
        return this.f18269b;
    }

    public final CharSequence mo3549d() {
        try {
            return this.f18268a.mo2109c();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get body.", e);
            return null;
        }
    }

    public final Image mo3550e() {
        return this.f18270c;
    }

    public final CharSequence mo3551f() {
        try {
            return this.f18268a.mo2112e();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get call to action.", e);
            return null;
        }
    }

    public final Double mo3552g() {
        try {
            double f = this.f18268a.mo2113f();
            return f == -1.0d ? null : Double.valueOf(f);
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get star rating.", e);
            return null;
        }
    }

    public final CharSequence mo3553h() {
        try {
            return this.f18268a.mo2114g();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get store", e);
            return null;
        }
    }

    public final CharSequence mo3554i() {
        try {
            return this.f18268a.mo2115h();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get price.", e);
            return null;
        }
    }

    public final VideoController mo3555j() {
        try {
            if (this.f18268a.mo2116i() != null) {
                this.f18271d.m4383a(this.f18268a.mo2116i());
            }
        } catch (Throwable e) {
            zzakb.m5367b("Exception occurred while getting video controller", e);
        }
        return this.f18271d;
    }

    public final void mo3556k() {
        try {
            this.f18268a.mo2122s();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to destroy", e);
        }
    }
}
