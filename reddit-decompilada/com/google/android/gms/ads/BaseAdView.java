package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzjf;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzod;

class BaseAdView extends ViewGroup {
    protected final zzlv f5381a = new zzlv(this);

    public BaseAdView(Context context) {
        super(context);
    }

    public AdSize getAdSize() {
        return this.f5381a.m6456a();
    }

    public String getAdUnitId() {
        return this.f5381a.m6462b();
    }

    public String getMediationAdapterClassName() {
        return this.f5381a.m6464c();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i3 = ((i3 - i) - measuredWidth) / 2;
            i4 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        int a;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (Throwable e) {
                zzakb.m5367b("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int b = adSize.m4373b(context);
                a = adSize.m4372a(context);
                i3 = b;
            } else {
                a = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            a = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(a, getSuggestedMinimumHeight()), i2));
    }

    public void setAdListener(AdListener adListener) {
        this.f5381a.m6457a(adListener);
        if (adListener == null) {
            this.f5381a.m6459a(null);
            this.f5381a.m6458a(null);
            return;
        }
        if (adListener instanceof zzje) {
            this.f5381a.m6459a((zzje) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.f5381a.m6458a((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f5381a.m6461a(adSize);
    }

    public void setAdUnitId(String str) {
        this.f5381a.m6460a(str);
    }

    public void mo1500c() {
        zzlv com_google_android_gms_internal_zzlv = this.f5381a;
        try {
            if (com_google_android_gms_internal_zzlv.f7818i != null) {
                com_google_android_gms_internal_zzlv.f7818i.mo2006i();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.f5381a.f7814e;
    }

    public void mo1498a(AdRequest adRequest) {
        zzlv com_google_android_gms_internal_zzlv = this.f5381a;
        adRequest = adRequest.zzbg();
        try {
            if (com_google_android_gms_internal_zzlv.f7818i == null) {
                if ((com_google_android_gms_internal_zzlv.f7815f == null || com_google_android_gms_internal_zzlv.f7821l == null) && com_google_android_gms_internal_zzlv.f7818i == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Object a;
                Context context = com_google_android_gms_internal_zzlv.f7822m.getContext();
                zzjn a2 = zzlv.m6455a(context, com_google_android_gms_internal_zzlv.f7815f, com_google_android_gms_internal_zzlv.f7823n);
                if ("search_v2".equals(a2.f18152a)) {
                    a = zzjr.m6338a(context, false, new zzjt(zzkb.m6346b(), context, a2, com_google_android_gms_internal_zzlv.f7821l));
                } else {
                    a = zzjr.m6338a(context, false, new zzjs(zzkb.m6346b(), context, a2, com_google_android_gms_internal_zzlv.f7821l, com_google_android_gms_internal_zzlv.f7810a));
                }
                com_google_android_gms_internal_zzlv.f7818i = (zzks) a;
                com_google_android_gms_internal_zzlv.f7818i.mo1993a(new zzjg(com_google_android_gms_internal_zzlv.f7812c));
                if (com_google_android_gms_internal_zzlv.f7813d != null) {
                    com_google_android_gms_internal_zzlv.f7818i.mo1992a(new zzjf(com_google_android_gms_internal_zzlv.f7813d));
                }
                if (com_google_android_gms_internal_zzlv.f7816g != null) {
                    com_google_android_gms_internal_zzlv.f7818i.mo1994a(new zzjp(com_google_android_gms_internal_zzlv.f7816g));
                }
                if (com_google_android_gms_internal_zzlv.f7819j != null) {
                    com_google_android_gms_internal_zzlv.f7818i.mo1998a(new zzod(com_google_android_gms_internal_zzlv.f7819j));
                }
                if (com_google_android_gms_internal_zzlv.f7817h != null) {
                    com_google_android_gms_internal_zzlv.f7818i.mo1995a(com_google_android_gms_internal_zzlv.f7817h.f5382a);
                }
                if (com_google_android_gms_internal_zzlv.f7820k != null) {
                    com_google_android_gms_internal_zzlv.f7818i.mo1997a(new zzmr(com_google_android_gms_internal_zzlv.f7820k));
                }
                com_google_android_gms_internal_zzlv.f7818i.mo2002b(com_google_android_gms_internal_zzlv.f7824o);
                try {
                    IObjectWrapper j = com_google_android_gms_internal_zzlv.f7818i.mo2007j();
                    if (j != null) {
                        com_google_android_gms_internal_zzlv.f7822m.addView((View) zzn.m17693a(j));
                    }
                } catch (Throwable e) {
                    zzakb.m5369c("Failed to get an ad frame.", e);
                }
            }
            if (com_google_android_gms_internal_zzlv.f7818i.mo2003b(zzjm.m6331a(com_google_android_gms_internal_zzlv.f7822m.getContext(), adRequest))) {
                com_google_android_gms_internal_zzlv.f7810a.f18313a = adRequest.f7786h;
            }
        } catch (AdRequest adRequest2) {
            zzakb.m5369c("Failed to load ad.", adRequest2);
        }
    }

    public void mo1499b() {
        zzlv com_google_android_gms_internal_zzlv = this.f5381a;
        try {
            if (com_google_android_gms_internal_zzlv.f7818i != null) {
                com_google_android_gms_internal_zzlv.f7818i.mo2011n();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to call pause.", e);
        }
    }

    public void mo1497a() {
        zzlv com_google_android_gms_internal_zzlv = this.f5381a;
        try {
            if (com_google_android_gms_internal_zzlv.f7818i != null) {
                com_google_android_gms_internal_zzlv.f7818i.mo2012o();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to call resume.", e);
        }
    }
}
