package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CircleImageView extends ImageView {
    AnimationListener f1564a;
    int f1565b;

    private class OvalShadow extends OvalShape {
        final /* synthetic */ CircleImageView f1561a;
        private RadialGradient f1562b;
        private Paint f1563c = new Paint();

        OvalShadow(CircleImageView circleImageView, int i) {
            this.f1561a = circleImageView;
            circleImageView.f1565b = i;
            m1347a((int) rect().width());
        }

        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            m1347a((int) f);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f1561a.getWidth() / 2;
            float f = (float) width;
            float height = (float) (this.f1561a.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.f1563c);
            canvas.drawCircle(f, height, (float) (width - this.f1561a.f1565b), paint);
        }

        private void m1347a(int i) {
            float f = (float) (i / 2);
            this.f1562b = new RadialGradient(f, f, (float) this.f1561a.f1565b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f1563c.setShader(this.f1562b);
        }
    }

    CircleImageView(Context context) {
        Drawable shapeDrawable;
        super(context);
        context = getContext().getResources().getDisplayMetrics().density;
        int i = (int) (1.75f * context);
        int i2 = (int) (0.0f * context);
        this.f1565b = (int) (3.5f * context);
        if (m1348a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.m1243f(this, 4.0f * context);
        } else {
            Drawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this, this.f1565b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f1565b, (float) i2, (float) i, 503316480);
            context = this.f1565b;
            setPadding(context, context, context, context);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(-328966);
        ViewCompat.m1219a((View) this, shapeDrawable);
    }

    private static boolean m1348a() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (m1348a() == 0) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1565b * 2), getMeasuredHeight() + (this.f1565b * 2));
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f1564a != null) {
            this.f1564a.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f1564a != null) {
            this.f1564a.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
