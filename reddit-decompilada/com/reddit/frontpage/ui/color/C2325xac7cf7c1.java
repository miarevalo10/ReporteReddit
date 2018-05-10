package com.reddit.frontpage.ui.color;

import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\n"}, d2 = {"com/reddit/frontpage/ui/color/StatusBarColorControllerChangeListener$onChangeStarted$colorCallback$1", "Lcom/reddit/frontpage/ui/color/ColorSource$OnColorChangedCallback;", "(Lcom/reddit/frontpage/ui/color/StatusBarColorControllerChangeListener;)V", "onKeyColorChanged", "", "keyColor", "", "(Ljava/lang/Integer;)V", "onTopColorChanged", "topColor", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StatusBarColorControllerChangeListener.kt */
public final class C2325xac7cf7c1 implements OnColorChangedCallback {
    final /* synthetic */ StatusBarColorControllerChangeListener f28929a;

    public final void mo4943c(Integer num) {
    }

    C2325xac7cf7c1(StatusBarColorControllerChangeListener statusBarColorControllerChangeListener) {
        this.f28929a = statusBarColorControllerChangeListener;
    }

    public final void mo4944d(Integer num) {
        if (num != null) {
            StatusBarColorControllerChangeListener statusBarColorControllerChangeListener = this.f28929a;
            float[] fArr = new float[3];
            ColorUtils.a(num.intValue(), fArr);
            fArr[2] = Math.max(Color.luminance(statusBarColorControllerChangeListener.f28931a), fArr[2] - 0.125f);
            num = Integer.valueOf(ColorUtils.a(fArr));
        } else {
            num = null;
        }
        this.f28929a.f28932b.m41956a(num, true);
    }
}
