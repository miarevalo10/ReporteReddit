package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzcg extends Fragment implements zzcf {
    private static WeakHashMap<Activity, WeakReference<zzcg>> f13939a = new WeakHashMap();
    private Map<String, LifecycleCallback> f13940b = new ArrayMap();
    private int f13941c = 0;
    private Bundle f13942d;

    public static zzcg m13007a(Activity activity) {
        zzcg com_google_android_gms_common_api_internal_zzcg;
        WeakReference weakReference = (WeakReference) f13939a.get(activity);
        if (weakReference != null) {
            com_google_android_gms_common_api_internal_zzcg = (zzcg) weakReference.get();
            if (com_google_android_gms_common_api_internal_zzcg != null) {
                return com_google_android_gms_common_api_internal_zzcg;
            }
        }
        try {
            com_google_android_gms_common_api_internal_zzcg = (zzcg) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (com_google_android_gms_common_api_internal_zzcg == null || com_google_android_gms_common_api_internal_zzcg.isRemoving()) {
                com_google_android_gms_common_api_internal_zzcg = new zzcg();
                activity.getFragmentManager().beginTransaction().add(com_google_android_gms_common_api_internal_zzcg, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f13939a.put(activity, new WeakReference(com_google_android_gms_common_api_internal_zzcg));
            return com_google_android_gms_common_api_internal_zzcg;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    public final Activity mo1608a() {
        return getActivity();
    }

    public final <T extends LifecycleCallback> T mo1609a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f13940b.get(str));
    }

    public final void mo1610a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f13940b.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder(59 + String.valueOf(str).length());
            stringBuilder.append("LifecycleCallback with tag ");
            stringBuilder.append(str);
            stringBuilder.append(" already added to this fragment.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f13940b.put(str, lifecycleCallback);
        if (this.f13941c > 0) {
            new Handler(Looper.getMainLooper()).post(new zzch(this, lifecycleCallback, str));
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a : this.f13940b.values()) {
            a.mo3420a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback a : this.f13940b.values()) {
            a.mo1613a(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13941c = 1;
        this.f13942d = bundle;
        for (Entry entry : this.f13940b.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo1614a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f13941c = 5;
        Iterator it = this.f13940b.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f13941c = 3;
        for (LifecycleCallback c : this.f13940b.values()) {
            c.mo3411c();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f13940b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).mo1616b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f13941c = 2;
        for (LifecycleCallback b : this.f13940b.values()) {
            b.mo1615b();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f13941c = 4;
        for (LifecycleCallback d : this.f13940b.values()) {
            d.mo1617d();
        }
    }
}
