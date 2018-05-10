package com.reddit.frontpage.ui;

import android.os.Bundle;
import android.view.View;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.util.Util;
import com.reddit.frontpage.nav.Screen;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016R2\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\u000b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/ui/GlideLifecycleScreen;", "Lcom/reddit/frontpage/nav/Screen;", "Lcom/bumptech/glide/manager/Lifecycle;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "lifecycleListeners", "", "Lcom/bumptech/glide/manager/LifecycleListener;", "kotlin.jvm.PlatformType", "", "addListener", "", "listener", "onAttach", "view", "Landroid/view/View;", "onDestroyView", "onDetach", "removeListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GlideLifecycleScreen.kt */
public abstract class GlideLifecycleScreen extends Screen implements Lifecycle {
    private final Set<LifecycleListener> f34211v;

    public GlideLifecycleScreen() {
        this.f34211v = Collections.newSetFromMap(new WeakHashMap());
    }

    public GlideLifecycleScreen(Bundle bundle) {
        super(bundle);
        this.f34211v = Collections.newSetFromMap((Map) new WeakHashMap());
    }

    public final void m34898a(LifecycleListener lifecycleListener) {
        Intrinsics.m26847b(lifecycleListener, "listener");
        this.f34211v.add(lifecycleListener);
        if (u_()) {
            lifecycleListener.c();
        } else if (v_()) {
            lifecycleListener.a();
        } else {
            lifecycleListener.b();
        }
    }

    public final void m34900b(LifecycleListener lifecycleListener) {
        Intrinsics.m26847b(lifecycleListener, "listener");
        this.f34211v.remove(lifecycleListener);
    }

    public void mo6992b(View view) {
        Intrinsics.m26847b(view, "view");
        super.b(view);
        for (LifecycleListener a : Util.a((Collection) this.f34211v)) {
            a.a();
        }
    }

    public void mo6993c(View view) {
        Intrinsics.m26847b(view, "view");
        for (LifecycleListener b : Util.a(this.f34211v)) {
            b.b();
        }
        super.c(view);
    }

    public void mo6987a(View view) {
        Intrinsics.m26847b(view, "view");
        for (LifecycleListener c : Util.a(this.f34211v)) {
            c.c();
        }
        super.a(view);
    }
}
