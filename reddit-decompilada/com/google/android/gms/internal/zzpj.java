package com.google.android.gms.internal;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@zzzv
public final class zzpj extends zzqa implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    static final String[] f18257a = new String[]{"2011", "1009"};
    private final Object f18258b = new Object();
    private final WeakReference<View> f18259c;
    private final Map<String, WeakReference<View>> f18260d = new HashMap();
    private final Map<String, WeakReference<View>> f18261e = new HashMap();
    private final Map<String, WeakReference<View>> f18262f = new HashMap();
    private zzos f18263g;
    private View f18264h;
    private Point f18265i = new Point();
    private Point f18266j = new Point();
    private WeakReference<zzgp> f18267k = new WeakReference(null);

    public zzpj(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        zzbs.m4506y();
        zzaln.m5398a(view, (OnGlobalLayoutListener) this);
        zzbs.m4506y();
        zzaln.m5399a(view, (OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.f18259c = new WeakReference(view);
        m18947a((Map) hashMap);
        this.f18262f.putAll(this.f18260d);
        m18949b(hashMap2);
        this.f18262f.putAll(this.f18261e);
        zznh.m6490a(view.getContext());
    }

    private final int m18944a(int i) {
        synchronized (this.f18258b) {
            zzkb.m6345a();
            i = zzajr.m5329b(this.f18263g.mo2088i(), i);
        }
        return i;
    }

    private final void m18945a(View view) {
        synchronized (this.f18258b) {
            if (this.f18263g != null) {
                zzos d = this.f18263g instanceof zzor ? ((zzor) this.f18263g).m18927d() : this.f18263g;
                if (d != null) {
                    d.mo2080b(view);
                }
            }
        }
    }

    private final void m18947a(Map<String, View> map) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            View view = (View) entry.getValue();
            if (view != null) {
                this.f18260d.put(str, new WeakReference(view));
                if (!"1098".equals(str)) {
                    view.setOnTouchListener(this);
                    view.setClickable(true);
                    view.setOnClickListener(this);
                }
            }
        }
    }

    private final void m18949b(Map<String, View> map) {
        for (Entry entry : map.entrySet()) {
            View view = (View) entry.getValue();
            if (view != null) {
                this.f18261e.put((String) entry.getKey(), new WeakReference(view));
                view.setOnTouchListener(this);
            }
        }
    }

    public final void mo2103a() {
        synchronized (this.f18258b) {
            this.f18264h = null;
            this.f18263g = null;
            this.f18265i = null;
            this.f18266j = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r9) {
        /*
        r8 = this;
        r0 = r8.f18258b;
        monitor-enter(r0);
        r1 = r8.f18263g;	 Catch:{ all -> 0x0090 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        return;
    L_0x0009:
        r1 = r8.f18259c;	 Catch:{ all -> 0x0090 }
        r1 = r1.get();	 Catch:{ all -> 0x0090 }
        r7 = r1;
        r7 = (android.view.View) r7;	 Catch:{ all -> 0x0090 }
        if (r7 != 0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        return;
    L_0x0016:
        r5 = new android.os.Bundle;	 Catch:{ all -> 0x0090 }
        r5.<init>();	 Catch:{ all -> 0x0090 }
        r1 = "x";
        r2 = r8.f18265i;	 Catch:{ all -> 0x0090 }
        r2 = r2.x;	 Catch:{ all -> 0x0090 }
        r2 = r8.m18944a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = "y";
        r2 = r8.f18265i;	 Catch:{ all -> 0x0090 }
        r2 = r2.y;	 Catch:{ all -> 0x0090 }
        r2 = r8.m18944a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = "start_x";
        r2 = r8.f18266j;	 Catch:{ all -> 0x0090 }
        r2 = r2.x;	 Catch:{ all -> 0x0090 }
        r2 = r8.m18944a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = "start_y";
        r2 = r8.f18266j;	 Catch:{ all -> 0x0090 }
        r2 = r2.y;	 Catch:{ all -> 0x0090 }
        r2 = r8.m18944a(r2);	 Catch:{ all -> 0x0090 }
        r2 = (float) r2;	 Catch:{ all -> 0x0090 }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x0090 }
        r1 = r8.f18264h;	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x0087;
    L_0x0057:
        r1 = r8.f18264h;	 Catch:{ all -> 0x0090 }
        r1 = r1.equals(r9);	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x0087;
    L_0x005f:
        r1 = r8.f18263g;	 Catch:{ all -> 0x0090 }
        r1 = r1 instanceof com.google.android.gms.internal.zzor;	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x0080;
    L_0x0065:
        r1 = r8.f18263g;	 Catch:{ all -> 0x0090 }
        r1 = (com.google.android.gms.internal.zzor) r1;	 Catch:{ all -> 0x0090 }
        r1 = r1.m18927d();	 Catch:{ all -> 0x0090 }
        if (r1 == 0) goto L_0x008e;
    L_0x006f:
        r1 = r8.f18263g;	 Catch:{ all -> 0x0090 }
        r1 = (com.google.android.gms.internal.zzor) r1;	 Catch:{ all -> 0x0090 }
        r2 = r1.m18927d();	 Catch:{ all -> 0x0090 }
        r4 = "1007";
        r6 = r8.f18262f;	 Catch:{ all -> 0x0090 }
    L_0x007b:
        r3 = r9;
        r2.mo2074a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0090 }
        goto L_0x008e;
    L_0x0080:
        r2 = r8.f18263g;	 Catch:{ all -> 0x0090 }
        r4 = "1007";
        r6 = r8.f18262f;	 Catch:{ all -> 0x0090 }
        goto L_0x007b;
    L_0x0087:
        r1 = r8.f18263g;	 Catch:{ all -> 0x0090 }
        r2 = r8.f18262f;	 Catch:{ all -> 0x0090 }
        r1.mo2076a(r9, r2, r5, r7);	 Catch:{ all -> 0x0090 }
    L_0x008e:
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        return;
    L_0x0090:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0090 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpj.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        synchronized (this.f18258b) {
            if (this.f18263g != null) {
                View view = (View) this.f18259c.get();
                if (view != null) {
                    this.f18263g.mo2084c(view, this.f18262f);
                }
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.f18258b) {
            if (this.f18263g != null) {
                View view = (View) this.f18259c.get();
                if (view != null) {
                    this.f18263g.mo2084c(view, this.f18262f);
                }
            }
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f18258b) {
            if (this.f18263g == null) {
                return false;
            }
            View view2 = (View) this.f18259c.get();
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
            this.f18265i = point;
            if (motionEvent.getAction() == 0) {
                this.f18266j = point;
            }
            motionEvent = MotionEvent.obtain(motionEvent);
            motionEvent.setLocation((float) point.x, (float) point.y);
            this.f18263g.mo2071a(motionEvent);
            motionEvent.recycle();
            return false;
        }
    }

    public final void mo2104a(IObjectWrapper iObjectWrapper) {
        synchronized (this.f18258b) {
            ViewGroup viewGroup = null;
            m18945a(null);
            iObjectWrapper = zzn.m17693a(iObjectWrapper);
            if (iObjectWrapper instanceof zzow) {
                zzow com_google_android_gms_internal_zzow = (zzow) iObjectWrapper;
                if (com_google_android_gms_internal_zzow.mo2082b()) {
                    View view;
                    View view2 = (View) this.f18259c.get();
                    if (!(this.f18263g == null || view2 == null)) {
                        if (((Boolean) zzkb.m6350f().m6488a(zznh.bM)).booleanValue()) {
                            this.f18263g.mo2081b(view2, this.f18262f);
                        }
                    }
                    synchronized (this.f18258b) {
                        if (this.f18263g instanceof zzow) {
                            zzow com_google_android_gms_internal_zzow2 = (zzow) this.f18263g;
                            View view3 = (View) this.f18259c.get();
                            if (!(com_google_android_gms_internal_zzow2 == null || com_google_android_gms_internal_zzow2.f14575b == null || view3 == null || !zzbs.m4507z().m5097c(view3.getContext()))) {
                                zzgt j = com_google_android_gms_internal_zzow2.m14149j();
                                if (j != null) {
                                    j.m13229a(false);
                                }
                                zzgp com_google_android_gms_internal_zzgp = (zzgp) this.f18267k.get();
                                if (!(com_google_android_gms_internal_zzgp == null || j == null)) {
                                    com_google_android_gms_internal_zzgp.m6266b(j);
                                }
                            }
                        }
                    }
                    if ((this.f18263g instanceof zzor) && ((zzor) this.f18263g).m18926c()) {
                        ((zzor) this.f18263g).m18922a(com_google_android_gms_internal_zzow);
                    } else {
                        this.f18263g = com_google_android_gms_internal_zzow;
                        if (com_google_android_gms_internal_zzow instanceof zzor) {
                            ((zzor) com_google_android_gms_internal_zzow).m18922a(null);
                        }
                    }
                    WeakReference weakReference = (WeakReference) this.f18262f.get("1098");
                    if (weakReference == null) {
                        zzakb.m5371e("Ad choices asset view is not provided.");
                    } else {
                        view = (View) weakReference.get();
                        if (view instanceof ViewGroup) {
                            viewGroup = (ViewGroup) view;
                        }
                        if (viewGroup != null) {
                            this.f18264h = com_google_android_gms_internal_zzow.mo2070a((OnClickListener) this, true);
                            if (this.f18264h != null) {
                                this.f18262f.put("1007", new WeakReference(this.f18264h));
                                this.f18260d.put("1007", new WeakReference(this.f18264h));
                                viewGroup.removeAllViews();
                                viewGroup.addView(this.f18264h);
                            }
                        }
                    }
                    com_google_android_gms_internal_zzow.mo3544a(view2, this.f18260d, this.f18261e, (OnTouchListener) this, (OnClickListener) this);
                    zzahn.f6379a.post(new zzpk(this, com_google_android_gms_internal_zzow));
                    m18945a(view2);
                    this.f18263g.mo2072a(view2);
                    synchronized (this.f18258b) {
                        if (this.f18263g instanceof zzow) {
                            zzow com_google_android_gms_internal_zzow3 = (zzow) this.f18263g;
                            view = (View) this.f18259c.get();
                            if (!(com_google_android_gms_internal_zzow3 == null || com_google_android_gms_internal_zzow3.f14575b == null || view == null || !zzbs.m4507z().m5097c(view.getContext()))) {
                                zzgp com_google_android_gms_internal_zzgp2 = (zzgp) this.f18267k.get();
                                if (com_google_android_gms_internal_zzgp2 == null) {
                                    com_google_android_gms_internal_zzgp2 = new zzgp(view.getContext(), view);
                                    this.f18267k = new WeakReference(com_google_android_gms_internal_zzgp2);
                                }
                                com_google_android_gms_internal_zzgp2.m6265a(com_google_android_gms_internal_zzow3.m14149j());
                            }
                        }
                    }
                    return;
                }
                zzakb.m5368c("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            zzakb.m5371e("Not an instance of native engine. This is most likely a transient error");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m18946a(com.google.android.gms.internal.zzpj r6, com.google.android.gms.internal.zzow r7) {
        /*
        r0 = r6.f18258b;
        monitor-enter(r0);
        r1 = f18257a;	 Catch:{ all -> 0x003b }
        r2 = r1.length;	 Catch:{ all -> 0x003b }
        r3 = 0;
    L_0x0007:
        if (r3 >= r2) goto L_0x001f;
    L_0x0009:
        r4 = r1[r3];	 Catch:{ all -> 0x003b }
        r5 = r6.f18262f;	 Catch:{ all -> 0x003b }
        r4 = r5.get(r4);	 Catch:{ all -> 0x003b }
        r4 = (java.lang.ref.WeakReference) r4;	 Catch:{ all -> 0x003b }
        if (r4 == 0) goto L_0x001c;
    L_0x0015:
        r1 = r4.get();	 Catch:{ all -> 0x003b }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x003b }
        goto L_0x0020;
    L_0x001c:
        r3 = r3 + 1;
        goto L_0x0007;
    L_0x001f:
        r1 = 0;
    L_0x0020:
        r2 = r1 instanceof android.widget.FrameLayout;	 Catch:{ all -> 0x003b }
        if (r2 != 0) goto L_0x0029;
    L_0x0024:
        r7.mo2086g();	 Catch:{ all -> 0x003b }
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        return;
    L_0x0029:
        r2 = new com.google.android.gms.internal.zzpl;	 Catch:{ all -> 0x003b }
        r2.<init>(r6, r1);	 Catch:{ all -> 0x003b }
        r6 = r7 instanceof com.google.android.gms.internal.zzor;	 Catch:{ all -> 0x003b }
        if (r6 == 0) goto L_0x0036;
    L_0x0032:
        r7.m14141b(r1, r2);	 Catch:{ all -> 0x003b }
        goto L_0x0039;
    L_0x0036:
        r7.mo2073a(r1, r2);	 Catch:{ all -> 0x003b }
    L_0x0039:
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        return;
    L_0x003b:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003b }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpj.a(com.google.android.gms.internal.zzpj, com.google.android.gms.internal.zzow):void");
    }

    static /* synthetic */ boolean m18948a(zzpj com_google_android_gms_internal_zzpj, String[] strArr) {
        for (Object obj : strArr) {
            if (com_google_android_gms_internal_zzpj.f18260d.get(obj) != null) {
                return true;
            }
        }
        for (Object obj2 : strArr) {
            if (com_google_android_gms_internal_zzpj.f18261e.get(obj2) != null) {
                break;
            }
        }
        return false;
    }
}
