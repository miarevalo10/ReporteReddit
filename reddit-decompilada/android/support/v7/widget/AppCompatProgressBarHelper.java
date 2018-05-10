package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import io.fabric.sdk.android.services.common.AbstractSpiCall;

class AppCompatProgressBarHelper {
    private static final int[] f2162b = new int[]{16843067, 16843068};
    Bitmap f2163a;
    private final ProgressBar f2164c;

    AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.f2164c = progressBar;
    }

    void mo588a(AttributeSet attributeSet, int i) {
        attributeSet = TintTypedArray.m2308a(this.f2164c.getContext(), attributeSet, f2162b, i, 0);
        i = attributeSet.m2314b(0);
        if (i != 0) {
            ProgressBar progressBar = this.f2164c;
            if (i instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) i;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable a = m1830a(animationDrawable.getFrame(i2), true);
                    a.setLevel(AbstractSpiCall.DEFAULT_TIMEOUT);
                    animationDrawable2.addFrame(a, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(AbstractSpiCall.DEFAULT_TIMEOUT);
                i = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(i);
        }
        Drawable b = attributeSet.m2314b(1);
        if (b != null) {
            this.f2164c.setProgressDrawable(m1830a(b, false));
        }
        attributeSet.f2595b.recycle();
    }

    private Drawable m1830a(Drawable drawable, boolean z) {
        Drawable a;
        if (drawable instanceof DrawableWrapper) {
            DrawableWrapper drawableWrapper = (DrawableWrapper) drawable;
            a = drawableWrapper.mo273a();
            if (a != null) {
                drawableWrapper.mo274a(m1830a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            z = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[z];
            boolean z2 = false;
            for (boolean z3 = false; z3 < z; z3++) {
                boolean z4;
                int id = layerDrawable.getId(z3);
                Drawable drawable2 = layerDrawable.getDrawable(z3);
                if (id != 16908301) {
                    if (id != 16908303) {
                        z4 = false;
                        drawableArr[z3] = m1830a(drawable2, z4);
                    }
                }
                z4 = true;
                drawableArr[z3] = m1830a(drawable2, z4);
            }
            a = new LayerDrawable(drawableArr);
            while (z2 < z) {
                a.setId(z2, layerDrawable.getId(z2));
                z2++;
            }
            return a;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f2163a == null) {
                this.f2163a = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, true, 1) : shapeDrawable;
        }
        return drawable;
    }
}
