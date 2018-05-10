package android.support.transition;

import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

@RequiresApi(18)
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay f16484a;

    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.f16484a = viewGroup.getOverlay();
    }

    public final void mo176a(Drawable drawable) {
        this.f16484a.add(drawable);
    }

    public final void mo177b(Drawable drawable) {
        this.f16484a.remove(drawable);
    }

    public final void mo3109a(View view) {
        this.f16484a.add(view);
    }

    public final void mo3110b(View view) {
        this.f16484a.remove(view);
    }
}
