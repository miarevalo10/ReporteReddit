package android.support.v7.widget;

import android.graphics.Outline;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
    public ActionBarBackgroundDrawableV21(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f2062d) {
            if (this.a.f2061c != null) {
                this.a.f2061c.getOutline(outline);
            }
        } else if (this.a.f2059a != null) {
            this.a.f2059a.getOutline(outline);
        }
    }
}
