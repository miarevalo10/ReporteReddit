package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
    private final float[] f1528a;
    private final float f1529b = (1.0f / ((float) (this.f1528a.length - 1)));

    public LookupTableInterpolator(float[] fArr) {
        this.f1528a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f1528a.length - 1)) * f), this.f1528a.length - 2);
        return this.f1528a[min] + (((f - (((float) min) * this.f1529b)) / this.f1529b) * (this.f1528a[min + 1] - this.f1528a[min]));
    }
}
