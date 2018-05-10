package android.support.transition;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;

@RequiresApi(14)
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static ViewGroupOverlayApi14 m16597a(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.m9721c(viewGroup);
    }

    public final void mo3109a(View view) {
        this.a.m494a(view);
    }

    public final void mo3110b(View view) {
        this.a.m495b(view);
    }
}
