package io.fabric.sdk.android.services.persistence;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Kit;

public class PreferenceStoreImpl implements PreferenceStore {
    private final SharedPreferences f31029a;
    private final String f31030b;
    private final Context f31031c;

    public PreferenceStoreImpl(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f31031c = context;
        this.f31030b = str;
        this.f31029a = this.f31031c.getSharedPreferences(this.f31030b, 0);
    }

    @Deprecated
    public PreferenceStoreImpl(Kit kit) {
        this(kit.getContext(), kit.getClass().getName());
    }

    public final SharedPreferences mo5606a() {
        return this.f31029a;
    }

    public final Editor mo5608b() {
        return this.f31029a.edit();
    }

    @TargetApi(9)
    public final boolean mo5607a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
