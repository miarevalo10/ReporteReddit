package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzajq;
import com.google.android.gms.internal.zzanh;
import java.util.ArrayList;
import java.util.List;

public final class zzbu extends ViewSwitcher {
    final zzaig f5624a;
    final zzajq f5625b;
    boolean f5626c = true;

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5625b != null) {
            this.f5625b.m5316c();
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f5625b != null) {
            this.f5625b.m5317d();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f5626c) {
            this.f5624a.m5275a(motionEvent);
        }
        return false;
    }

    public final void removeAllViews() {
        int i;
        List arrayList = new ArrayList();
        int i2 = 0;
        for (i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof zzanh)) {
                arrayList.add((zzanh) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = (ArrayList) arrayList;
        i = arrayList2.size();
        while (i2 < i) {
            Object obj = arrayList2.get(i2);
            i2++;
            ((zzanh) obj).destroy();
        }
    }

    public zzbu(Context context, String str, String str2, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.f5624a = new zzaig(context);
        this.f5624a.f6395b = str;
        this.f5624a.f6396c = str2;
        if ((context instanceof Activity) != null) {
            this.f5625b = new zzajq((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.f5625b = new zzajq(null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.f5625b.m5314a();
    }
}
