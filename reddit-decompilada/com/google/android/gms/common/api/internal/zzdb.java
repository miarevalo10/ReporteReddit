package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzdb extends Fragment implements zzcf {
    private static WeakHashMap<FragmentActivity, WeakReference<zzdb>> f17307a = new WeakHashMap();
    private Map<String, LifecycleCallback> f17308b = new ArrayMap();
    private int f17309c = 0;
    private Bundle f17310d;

    public static zzdb m17654a(FragmentActivity fragmentActivity) {
        zzdb com_google_android_gms_common_api_internal_zzdb;
        WeakReference weakReference = (WeakReference) f17307a.get(fragmentActivity);
        if (weakReference != null) {
            com_google_android_gms_common_api_internal_zzdb = (zzdb) weakReference.get();
            if (com_google_android_gms_common_api_internal_zzdb != null) {
                return com_google_android_gms_common_api_internal_zzdb;
            }
        }
        try {
            com_google_android_gms_common_api_internal_zzdb = (zzdb) fragmentActivity.getSupportFragmentManager().mo218a("SupportLifecycleFragmentImpl");
            if (com_google_android_gms_common_api_internal_zzdb == null || com_google_android_gms_common_api_internal_zzdb.isRemoving()) {
                com_google_android_gms_common_api_internal_zzdb = new zzdb();
                fragmentActivity.getSupportFragmentManager().mo219a().mo197a((Fragment) com_google_android_gms_common_api_internal_zzdb, "SupportLifecycleFragmentImpl").mo205d();
            }
            f17307a.put(fragmentActivity, new WeakReference(com_google_android_gms_common_api_internal_zzdb));
            return com_google_android_gms_common_api_internal_zzdb;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    public final /* synthetic */ Activity mo1608a() {
        return getActivity();
    }

    public final <T extends LifecycleCallback> T mo1609a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f17308b.get(str));
    }

    public final void mo1610a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f17308b.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder(59 + String.valueOf(str).length());
            stringBuilder.append("LifecycleCallback with tag ");
            stringBuilder.append(str);
            stringBuilder.append(" already added to this fragment.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f17308b.put(str, lifecycleCallback);
        if (this.f17309c > 0) {
            new Handler(Looper.getMainLooper()).post(new zzdc(this, lifecycleCallback, str));
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a : this.f17308b.values()) {
            a.mo3420a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback a : this.f17308b.values()) {
            a.mo1613a(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17309c = 1;
        this.f17310d = bundle;
        for (Entry entry : this.f17308b.entrySet()) {
            ((LifecycleCallback) entry.getValue()).mo1614a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f17309c = 5;
        Iterator it = this.f17308b.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f17309c = 3;
        for (LifecycleCallback c : this.f17308b.values()) {
            c.mo3411c();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f17308b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).mo1616b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f17309c = 2;
        for (LifecycleCallback b : this.f17308b.values()) {
            b.mo1615b();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f17309c = 4;
        for (LifecycleCallback d : this.f17308b.values()) {
            d.mo1617d();
        }
    }
}
