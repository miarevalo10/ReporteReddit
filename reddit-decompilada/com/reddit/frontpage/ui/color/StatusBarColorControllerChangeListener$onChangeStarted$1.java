package com.reddit.frontpage.ui.color;

import android.view.View;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Controller.LifecycleListener;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"com/reddit/frontpage/ui/color/StatusBarColorControllerChangeListener$onChangeStarted$1", "Lcom/bluelinelabs/conductor/Controller$LifecycleListener;", "(Lcom/reddit/frontpage/ui/color/ColorSource;Lcom/reddit/frontpage/ui/color/StatusBarColorControllerChangeListener$onChangeStarted$colorCallback$1;)V", "preAttach", "", "controller", "Lcom/bluelinelabs/conductor/Controller;", "view", "Landroid/view/View;", "preDetach", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StatusBarColorControllerChangeListener.kt */
public final class StatusBarColorControllerChangeListener$onChangeStarted$1 extends LifecycleListener {
    final /* synthetic */ ColorSource f28927a;
    final /* synthetic */ C2325xac7cf7c1 f28928b;

    StatusBarColorControllerChangeListener$onChangeStarted$1(ColorSource colorSource, C2325xac7cf7c1 c2325xac7cf7c1) {
        this.f28927a = colorSource;
        this.f28928b = c2325xac7cf7c1;
    }

    public final void m29983a(Controller controller, View view) {
        Intrinsics.m26847b(controller, "controller");
        Intrinsics.m26847b(view, "view");
        this.f28927a.mo4950a((OnColorChangedCallback) this.f28928b);
    }

    public final void m29984b(Controller controller, View view) {
        Intrinsics.m26847b(controller, "controller");
        Intrinsics.m26847b(view, "view");
        this.f28927a.mo4952b((OnColorChangedCallback) this.f28928b);
    }
}
