package android.support.design.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0016R;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable f403a;
    Rect f404b;
    private Rect f405c;

    class C09721 implements OnApplyWindowInsetsListener {
        final /* synthetic */ ScrimInsetsFrameLayout f11029a;

        C09721(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
            this.f11029a = scrimInsetsFrameLayout;
        }

        public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
            if (this.f11029a.f404b == null) {
                this.f11029a.f404b = new Rect();
            }
            this.f11029a.f404b.set(windowInsetsCompat.m1307a(), windowInsetsCompat.m1309b(), windowInsetsCompat.m1310c(), windowInsetsCompat.m1311d());
            this.f11029a.mo109a(windowInsetsCompat);
            view = this.f11029a;
            boolean z = false;
            if (!(VERSION.SDK_INT >= 20 ? ((WindowInsets) windowInsetsCompat.f1489a).hasSystemWindowInsets() : false) || this.f11029a.f403a == null) {
                z = true;
            }
            view.setWillNotDraw(z);
            ViewCompat.m1234c(this.f11029a);
            return windowInsetsCompat.m1313f();
        }
    }

    public void mo109a(WindowInsetsCompat windowInsetsCompat) {
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f405c = new Rect();
        context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.ScrimInsetsFrameLayout, i, C0016R.style.Widget_Design_ScrimInsetsFrameLayout);
        this.f403a = context.getDrawable(C0016R.styleable.ScrimInsetsFrameLayout_insetForeground);
        context.recycle();
        setWillNotDraw(true);
        ViewCompat.m1221a((View) this, new C09721(this));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f404b != null && this.f403a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.f405c.set(0, 0, width, this.f404b.top);
            this.f403a.setBounds(this.f405c);
            this.f403a.draw(canvas);
            this.f405c.set(0, height - this.f404b.bottom, width, height);
            this.f403a.setBounds(this.f405c);
            this.f403a.draw(canvas);
            this.f405c.set(0, this.f404b.top, this.f404b.left, height - this.f404b.bottom);
            this.f403a.setBounds(this.f405c);
            this.f403a.draw(canvas);
            this.f405c.set(width - this.f404b.right, this.f404b.top, width, height - this.f404b.bottom);
            this.f403a.setBounds(this.f405c);
            this.f403a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f403a != null) {
            this.f403a.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f403a != null) {
            this.f403a.setCallback(null);
        }
    }
}
