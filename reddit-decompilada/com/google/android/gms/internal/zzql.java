package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzql extends NativeContentAd {
    private final zzqi f18273a;
    private final List<Image> f18274b = new ArrayList();
    private final zzpt f18275c;
    private final VideoController f18276d = new VideoController();
    private final AdChoicesInfo f18277e;

    public zzql(zzqi com_google_android_gms_internal_zzqi) {
        zzpt com_google_android_gms_internal_zzpt;
        this.f18273a = com_google_android_gms_internal_zzqi;
        AdChoicesInfo adChoicesInfo = null;
        try {
            List b = this.f18273a.mo2125b();
            if (b != null) {
                for (Object next : b) {
                    zzpq com_google_android_gms_internal_zzps;
                    if (next instanceof IBinder) {
                        IBinder iBinder = (IBinder) next;
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                            com_google_android_gms_internal_zzps = queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(iBinder);
                            if (com_google_android_gms_internal_zzps != null) {
                                this.f18274b.add(new zzpt(com_google_android_gms_internal_zzps));
                            }
                        }
                    }
                    com_google_android_gms_internal_zzps = null;
                    if (com_google_android_gms_internal_zzps != null) {
                        this.f18274b.add(new zzpt(com_google_android_gms_internal_zzps));
                    }
                }
            }
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get image.", e);
        }
        try {
            zzpq f = this.f18273a.mo2131f();
            if (f != null) {
                com_google_android_gms_internal_zzpt = new zzpt(f);
                this.f18275c = com_google_android_gms_internal_zzpt;
                if (this.f18273a.mo2137p() != null) {
                    adChoicesInfo = new zzpp(this.f18273a.mo2137p());
                }
                this.f18277e = adChoicesInfo;
            }
        } catch (Throwable e2) {
            zzakb.m5367b("Failed to get image.", e2);
        }
        com_google_android_gms_internal_zzpt = null;
        this.f18275c = com_google_android_gms_internal_zzpt;
        try {
            if (this.f18273a.mo2137p() != null) {
                adChoicesInfo = new zzpp(this.f18273a.mo2137p());
            }
        } catch (Throwable e22) {
            zzakb.m5367b("Failed to get attribution info.", e22);
        }
        this.f18277e = adChoicesInfo;
    }

    private final IObjectWrapper m18964j() {
        try {
            return this.f18273a.mo2135j();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object mo3546a() {
        return m18964j();
    }

    public final CharSequence mo3557b() {
        try {
            return this.f18273a.mo2123a();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get headline.", e);
            return null;
        }
    }

    public final List<Image> mo3558c() {
        return this.f18274b;
    }

    public final CharSequence mo3559d() {
        try {
            return this.f18273a.mo2130e();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get body.", e);
            return null;
        }
    }

    public final Image mo3560e() {
        return this.f18275c;
    }

    public final CharSequence mo3561f() {
        try {
            return this.f18273a.mo2132g();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get call to action.", e);
            return null;
        }
    }

    public final CharSequence mo3562g() {
        try {
            return this.f18273a.mo2133h();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get attribution.", e);
            return null;
        }
    }

    public final VideoController mo3563h() {
        try {
            if (this.f18273a.mo2134i() != null) {
                this.f18276d.m4383a(this.f18273a.mo2134i());
            }
        } catch (Throwable e) {
            zzakb.m5367b("Exception occurred while getting video controller", e);
        }
        return this.f18276d;
    }

    public final void mo3564i() {
        try {
            this.f18273a.mo2138q();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to destroy", e);
        }
    }
}
