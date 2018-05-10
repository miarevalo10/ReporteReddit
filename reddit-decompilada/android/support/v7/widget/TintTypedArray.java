package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;

public class TintTypedArray {
    final Context f2594a;
    public final TypedArray f2595b;
    TypedValue f2596c;

    public static TintTypedArray m2307a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray m2308a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static TintTypedArray m2306a(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f2594a = context;
        this.f2595b = typedArray;
    }

    public final Drawable m2311a(int i) {
        if (this.f2595b.hasValue(i)) {
            int resourceId = this.f2595b.getResourceId(i, 0);
            if (resourceId != 0) {
                return AppCompatResources.m1570b(this.f2594a, resourceId);
            }
        }
        return this.f2595b.getDrawable(i);
    }

    public final Drawable m2314b(int i) {
        if (this.f2595b.hasValue(i)) {
            i = this.f2595b.getResourceId(i, 0);
            if (i != 0) {
                return AppCompatDrawableManager.m1809a().m1818a(this.f2594a, i, true);
            }
        }
        return 0;
    }

    public final CharSequence m2316c(int i) {
        return this.f2595b.getText(i);
    }

    public final String m2318d(int i) {
        return this.f2595b.getString(i);
    }

    public final boolean m2312a(int i, boolean z) {
        return this.f2595b.getBoolean(i, z);
    }

    public final int m2310a(int i, int i2) {
        return this.f2595b.getInt(i, i2);
    }

    public final float m2309a(int i, float f) {
        return this.f2595b.getFloat(i, f);
    }

    public final int m2313b(int i, int i2) {
        return this.f2595b.getColor(i, i2);
    }

    public final ColorStateList m2320e(int i) {
        if (this.f2595b.hasValue(i)) {
            int resourceId = this.f2595b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = AppCompatResources.m1569a(this.f2594a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.f2595b.getColorStateList(i);
    }

    public final int m2315c(int i, int i2) {
        return this.f2595b.getInteger(i, i2);
    }

    public final int m2317d(int i, int i2) {
        return this.f2595b.getDimensionPixelOffset(i, i2);
    }

    public final int m2319e(int i, int i2) {
        return this.f2595b.getDimensionPixelSize(i, i2);
    }

    public final int m2321f(int i, int i2) {
        return this.f2595b.getLayoutDimension(i, i2);
    }

    public final int m2323g(int i, int i2) {
        return this.f2595b.getResourceId(i, i2);
    }

    public final boolean m2322f(int i) {
        return this.f2595b.hasValue(i);
    }
}
