package com.instabug.library.instacapture;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* compiled from: ActivityReferenceManager */
public final class C0665a {
    private WeakReference<Activity> f9593a;

    public final void m8173a(Activity activity) {
        this.f9593a = new WeakReference(activity);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.app.Activity m8172a() {
        /*
        r6 = this;
        r0 = r6.f9593a;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r6.f9593a;
        r0 = r0.get();
        r0 = (android.app.Activity) r0;
        r2 = 0;
        r3 = 1;
        if (r0 == 0) goto L_0x002c;
    L_0x0012:
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 17;
        if (r4 < r5) goto L_0x0025;
    L_0x0018:
        r4 = r0.isFinishing();
        if (r4 != 0) goto L_0x002c;
    L_0x001e:
        r4 = r0.isDestroyed();
        if (r4 != 0) goto L_0x002c;
    L_0x0024:
        goto L_0x002b;
    L_0x0025:
        r4 = r0.isFinishing();
        if (r4 != 0) goto L_0x002c;
    L_0x002b:
        r2 = r3;
    L_0x002c:
        if (r2 != 0) goto L_0x002f;
    L_0x002e:
        return r1;
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.instacapture.a.a():android.app.Activity");
    }
}
