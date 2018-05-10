package com.reddit.frontpage;

import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LightboxActivity_ViewBinding implements Unbinder {
    private LightboxActivity f27421b;

    public LightboxActivity_ViewBinding(LightboxActivity lightboxActivity, View view) {
        this.f27421b = lightboxActivity;
        lightboxActivity.container = (ViewGroup) Utils.b(view, C1761R.id.container, "field 'container'", ViewGroup.class);
        lightboxActivity.root = (ViewGroup) Utils.b(view, C1761R.id.activity_root, "field 'root'", ViewGroup.class);
    }

    public final void m28887a() {
        LightboxActivity lightboxActivity = this.f27421b;
        if (lightboxActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f27421b = null;
        lightboxActivity.container = null;
        lightboxActivity.root = null;
    }
}
