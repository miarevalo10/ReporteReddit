package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.util.Arrays;
import java.util.List;

final class GifViewUtils {
    static final List<String> f41199a = Arrays.asList(new String[]{"raw", "drawable", "mipmap"});

    static class GifViewAttributes {
        boolean f41197c;
        int f41198d;

        GifViewAttributes(View view, AttributeSet attributeSet, int i, int i2) {
            view = view.getContext().obtainStyledAttributes(attributeSet, C3062R.styleable.GifView, i, i2);
            this.f41197c = view.getBoolean(C3062R.styleable.GifView_freezesAnimation, 0);
            this.f41198d = view.getInt(C3062R.styleable.GifView_loopCount, -1);
            view.recycle();
        }

        GifViewAttributes() {
            this.f41197c = false;
            this.f41198d = -1;
        }
    }

    static class GifImageViewAttributes extends GifViewAttributes {
        final int f41569a;
        final int f41570b;

        GifImageViewAttributes(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.f41569a = m43730a(imageView, attributeSet, 1);
            this.f41570b = m43730a(imageView, attributeSet, 0);
        }

        GifImageViewAttributes() {
            this.f41569a = 0;
            this.f41570b = 0;
        }

        private static int m43730a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            attributeSet = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
            if (attributeSet > null) {
                if (GifViewUtils.f41199a.contains(imageView.getResources().getResourceTypeName(attributeSet)) && GifViewUtils.m43277a(imageView, z, attributeSet) == null) {
                    return attributeSet;
                }
                return 0;
            }
            return 0;
        }
    }

    static GifImageViewAttributes m43274a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new GifImageViewAttributes();
        }
        GifImageViewAttributes gifImageViewAttributes = new GifImageViewAttributes(imageView, attributeSet, i, i2);
        int i3 = gifImageViewAttributes.d;
        if (i3 >= null) {
            m43275a(i3, imageView.getDrawable());
            m43275a(i3, imageView.getBackground());
        }
        return gifImageViewAttributes;
    }

    private static void m43275a(int i, Drawable drawable) {
        if (drawable instanceof GifDrawable) {
            drawable = ((GifDrawable) drawable).f41153f;
            if (i >= 0) {
                if (i <= 65535) {
                    synchronized (drawable) {
                        GifInfoHandle.setLoopCount(drawable.f41194a, (char) i);
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
    }

    static boolean m43277a(android.widget.ImageView r2, boolean r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getResources();
        if (r0 == 0) goto L_0x0020;
    L_0x0006:
        r1 = new pl.droidsonroids.gif.GifDrawable;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        r1.<init>(r0, r4);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        if (r3 == 0) goto L_0x0011;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
    L_0x000d:
        r2.setImageDrawable(r1);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        goto L_0x001e;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
    L_0x0011:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        r4 = 16;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        if (r3 < r4) goto L_0x001b;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
    L_0x0017:
        r2.setBackground(r1);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
        goto L_0x001e;	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
    L_0x001b:
        r2.setBackgroundDrawable(r1);	 Catch:{ IOException -> 0x0020, IOException -> 0x0020 }
    L_0x001e:
        r2 = 1;
        return r2;
    L_0x0020:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.GifViewUtils.a(android.widget.ImageView, boolean, int):boolean");
    }

    static boolean m43276a(android.widget.ImageView r2, android.net.Uri r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 == 0) goto L_0x0014;
    L_0x0002:
        r0 = new pl.droidsonroids.gif.GifDrawable;	 Catch:{ IOException -> 0x0014 }
        r1 = r2.getContext();	 Catch:{ IOException -> 0x0014 }
        r1 = r1.getContentResolver();	 Catch:{ IOException -> 0x0014 }
        r0.<init>(r1, r3);	 Catch:{ IOException -> 0x0014 }
        r2.setImageDrawable(r0);	 Catch:{ IOException -> 0x0014 }
        r2 = 1;
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.GifViewUtils.a(android.widget.ImageView, android.net.Uri):boolean");
    }

    static float m43273a(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        i = typedValue.density;
        if (i == 0) {
            i = 160;
        } else if (i == 65535) {
            i = 0;
        }
        resources = resources.getDisplayMetrics().densityDpi;
        return (i <= 0 || resources <= null) ? 1.0f : ((float) resources) / ((float) i);
    }
}
