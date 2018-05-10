package com.google.android.gms.ads.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class SearchAdView extends ViewGroup {
    private final zzlv f5669a;

    public final AdSize getAdSize() {
        return this.f5669a.m6456a();
    }

    public final String getAdUnitId() {
        return this.f5669a.m6462b();
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i3 = ((i3 - i) - measuredWidth) / 2;
            i4 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
        }
    }

    protected final void onMeasure(int i, int i2) {
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

    public final void setAdListener(AdListener adListener) {
        this.f5669a.m6457a(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.f5669a.m6461a(adSize);
    }

    public final void setAdUnitId(String str) {
        this.f5669a.m6460a(str);
    }

    public final AdListener getAdListener() {
        return this.f5669a.f7814e;
    }
}
