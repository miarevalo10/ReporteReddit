package com.livefront.bridge;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

class BridgeDelegate {
    private static final String f10025g = "com.livefront.bridge.BridgeDelegate";
    boolean f10026a = true;
    Map<String, Bundle> f10027b = new HashMap();
    Map<Object, String> f10028c = new WeakHashMap();
    SavedStateHandler f10029d;
    Set<String> f10030e = new HashSet();
    SharedPreferences f10031f;
    private boolean f10032h = false;
    private long f10033i;

    class C14251 extends ActivityLifecycleCallbacksAdapter {
        final /* synthetic */ BridgeDelegate f15604a;

        C14251(BridgeDelegate bridgeDelegate) {
            this.f15604a = bridgeDelegate;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.f15604a.f10032h = true;
        }

        public void onActivityDestroyed(Activity activity) {
            this.f15604a.f10032h = activity.isChangingConfigurations() ^ 1;
        }
    }

    BridgeDelegate(Context context, SavedStateHandler savedStateHandler) {
        this.f10031f = context.getSharedPreferences(f10025g, 0);
        this.f10029d = savedStateHandler;
        if (VERSION.SDK_INT < 14) {
            this.f10032h = false;
        } else {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new C14251(this));
        }
    }

    final void m8488a(String str) {
        this.f10030e.remove(str);
        this.f10027b.remove(str);
        this.f10031f.edit().remove(m8486b(str)).apply();
    }

    final void m8487a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f10033i >= 100) {
            this.f10033i = currentTimeMillis;
            System.gc();
            Set<String> hashSet = new HashSet(this.f10030e);
            hashSet.removeAll(this.f10028c.values());
            for (String a : hashSet) {
                m8488a(a);
            }
        }
    }

    static String m8486b(String str) {
        return String.format("bundle_%s", new Object[]{str});
    }

    static String m8484a(Object obj) {
        return String.format("uuid_%s", new Object[]{obj.getClass().getName()});
    }
}
