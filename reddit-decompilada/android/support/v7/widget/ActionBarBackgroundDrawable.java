package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@RequiresApi(9)
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer f2058a;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f2058a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2058a.f2062d) {
            if (this.f2058a.f2059a != null) {
                this.f2058a.f2059a.draw(canvas);
            }
            if (this.f2058a.f2060b != null && this.f2058a.f2063e) {
                this.f2058a.f2060b.draw(canvas);
            }
        } else if (this.f2058a.f2061c != null) {
            this.f2058a.f2061c.draw(canvas);
        }
    }
}
