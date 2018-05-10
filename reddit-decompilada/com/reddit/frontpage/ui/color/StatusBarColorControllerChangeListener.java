package com.reddit.frontpage.ui.color;

import android.view.ViewGroup;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeListener;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J4\u0010\u0014\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/ui/color/StatusBarColorControllerChangeListener;", "Lcom/bluelinelabs/conductor/ControllerChangeHandler$ControllerChangeListener;", "activity", "Lcom/reddit/frontpage/RedditThemedActivity;", "(Lcom/reddit/frontpage/RedditThemedActivity;)V", "getActivity", "()Lcom/reddit/frontpage/RedditThemedActivity;", "darkestUsableColor", "", "onChangeCompleted", "", "to", "Lcom/bluelinelabs/conductor/Controller;", "from", "isPush", "", "container", "Landroid/view/ViewGroup;", "handler", "Lcom/bluelinelabs/conductor/ControllerChangeHandler;", "onChangeStarted", "slightlyDarkenColor", "color", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StatusBarColorControllerChangeListener.kt */
public final class StatusBarColorControllerChangeListener implements ControllerChangeListener {
    public static final Companion f28930c = new Companion();
    final int f28931a;
    final RedditThemedActivity f28932b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/ui/color/StatusBarColorControllerChangeListener$Companion;", "", "()V", "DARKENED_LUMINANCE_DIFFERENCE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: StatusBarColorControllerChangeListener.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f21134a;

        static {
            int[] iArr = new int[ThemeOption.values().length];
            f21134a = iArr;
            iArr[ThemeOption.f20984f.ordinal()] = 1;
            f21134a[ThemeOption.f20981c.ordinal()] = 2;
        }
    }

    public final void m29988b(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
        Intrinsics.m26847b(viewGroup, "container");
        Intrinsics.m26847b(controllerChangeHandler, "handler");
    }

    public StatusBarColorControllerChangeListener(RedditThemedActivity redditThemedActivity) {
        Intrinsics.m26847b(redditThemedActivity, "activity");
        this.f28932b = redditThemedActivity;
        redditThemedActivity = this.f28932b.f40551f;
        if (redditThemedActivity != null) {
            switch (WhenMappings.f21134a[redditThemedActivity.ordinal()]) {
                case 1:
                case 2:
                    redditThemedActivity = ResourcesUtil.m22740i(this.f28932b, 16843857);
                    break;
                default:
                    break;
            }
        }
        redditThemedActivity = -16777216;
        this.f28931a = redditThemedActivity;
        if (this.f28932b.m41961k() == null) {
            throw ((Throwable) new IllegalStateException());
        }
    }

    public final void m29987a(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
        Intrinsics.m26847b(viewGroup, "container");
        Intrinsics.m26847b(controllerChangeHandler, "handler");
        if ((controller instanceof ColorSource) != null) {
            ColorSource colorSource = (ColorSource) controller;
            controllerChangeHandler = new C2325xac7cf7c1(this);
            if (controller.v_()) {
                colorSource.mo4950a((OnColorChangedCallback) controllerChangeHandler);
            }
            controller.a(new StatusBarColorControllerChangeListener$onChangeStarted$1(colorSource, controllerChangeHandler));
            return;
        }
        this.f28932b.m41956a((Integer) null, true);
    }
}
