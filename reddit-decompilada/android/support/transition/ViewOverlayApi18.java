package android.support.transition;

import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewOverlay;

@RequiresApi(18)
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay f11237a;

    ViewOverlayApi18(View view) {
        this.f11237a = view.getOverlay();
    }

    public final void mo176a(Drawable drawable) {
        this.f11237a.add(drawable);
    }

    public final void mo177b(Drawable drawable) {
        this.f11237a.remove(drawable);
    }
}
