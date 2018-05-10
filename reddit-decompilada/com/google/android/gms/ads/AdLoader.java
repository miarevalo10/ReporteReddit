package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzuw;

public class AdLoader {
    private final zzjm f5364a;
    private final Context f5365b;
    private final zzkk f5366c;

    public static class Builder {
        private final Context f5362a;
        private final zzkn f5363b;

        private Builder(Context context, zzkn com_google_android_gms_internal_zzkn) {
            this.f5362a = context;
            this.f5363b = com_google_android_gms_internal_zzkn;
        }

        public final Builder m4362a(AdListener adListener) {
            try {
                this.f5363b.mo1976a(new zzjg(adListener));
                return this;
            } catch (Throwable e) {
                zzakb.m5369c("Failed to set AdListener.", e);
                return this;
            }
        }

        public final Builder m4363a(NativeAdOptions nativeAdOptions) {
            try {
                this.f5363b.mo1978a(new zzpe(nativeAdOptions));
                return this;
            } catch (Throwable e) {
                zzakb.m5369c("Failed to specify native ad options", e);
                return this;
            }
        }

        public final Builder m4364a(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.f5363b.mo1979a(new zzrk(onAppInstallAdLoadedListener));
                return this;
            } catch (Throwable e) {
                zzakb.m5369c("Failed to add app install ad listener", e);
                return this;
            }
        }

        public final Builder m4365a(OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.f5363b.mo1980a(new zzrl(onContentAdLoadedListener));
                return this;
            } catch (Throwable e) {
                zzakb.m5369c("Failed to add content ad listener", e);
                return this;
            }
        }

        public final Builder m4366a(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            try {
                this.f5363b.mo1983a(str, new zzrn(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzrm(onCustomClickListener));
                return this;
            } catch (Throwable e) {
                zzakb.m5369c("Failed to add custom template ad listener", e);
                return this;
            }
        }

        public final AdLoader m4367a() {
            try {
                return new AdLoader(this.f5362a, this.f5363b.mo1974a());
            } catch (Throwable e) {
                zzakb.m5367b("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder(Context context, String str) {
            this((Context) zzbq.m4809a((Object) context, (Object) "context cannot be null"), (zzkn) zzjr.m6338a(context, null, new zzjv(zzkb.m6346b(), context, str, new zzuw())));
        }
    }

    AdLoader(Context context, zzkk com_google_android_gms_internal_zzkk) {
        this(context, com_google_android_gms_internal_zzkk, zzjm.f7755a);
    }

    private AdLoader(Context context, zzkk com_google_android_gms_internal_zzkk, zzjm com_google_android_gms_internal_zzjm) {
        this.f5365b = context;
        this.f5366c = com_google_android_gms_internal_zzkk;
        this.f5364a = com_google_android_gms_internal_zzjm;
    }

    public final void m4368a(PublisherAdRequest publisherAdRequest) {
        m4369a(publisherAdRequest.zzbg());
    }

    public final void m4369a(zzlt com_google_android_gms_internal_zzlt) {
        try {
            this.f5366c.mo1970a(zzjm.m6331a(this.f5365b, com_google_android_gms_internal_zzlt));
        } catch (Throwable e) {
            zzakb.m5367b("Failed to load ad.", e);
        }
    }

    public final boolean m4370a() {
        try {
            return this.f5366c.mo1973c();
        } catch (Throwable e) {
            zzakb.m5369c("Failed to check if ad is loading.", e);
            return false;
        }
    }
}
