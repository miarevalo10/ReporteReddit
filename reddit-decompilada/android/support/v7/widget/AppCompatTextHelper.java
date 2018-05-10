package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.C0164R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

@RequiresApi(9)
class AppCompatTextHelper {
    final TextView f2174a;
    final AppCompatTextViewAutoSizeHelper f2175b;
    private TintInfo f2176c;
    private TintInfo f2177d;
    private TintInfo f2178e;
    private TintInfo f2179f;
    private int f2180g = 0;
    private Typeface f2181h;
    private boolean f2182i;

    static AppCompatTextHelper m1832a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new AppCompatTextHelperV17(textView);
        }
        return new AppCompatTextHelper(textView);
    }

    AppCompatTextHelper(TextView textView) {
        this.f2174a = textView;
        this.f2175b = new AppCompatTextViewAutoSizeHelper(this.f2174a);
    }

    @SuppressLint({"NewApi"})
    void mo591a(AttributeSet attributeSet, int i) {
        TintTypedArray a;
        boolean z;
        boolean z2;
        ColorStateList e;
        ColorStateList e2;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        Context context = this.f2174a.getContext();
        AppCompatDrawableManager a2 = AppCompatDrawableManager.m1809a();
        TintTypedArray a3 = TintTypedArray.m2308a(context, attributeSet2, C0164R.styleable.AppCompatTextHelper, i2, 0);
        int g = a3.m2323g(C0164R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.m2322f(C0164R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            r0.f2176c = m1833a(context, a2, a3.m2323g(C0164R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.m2322f(C0164R.styleable.AppCompatTextHelper_android_drawableTop)) {
            r0.f2177d = m1833a(context, a2, a3.m2323g(C0164R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.m2322f(C0164R.styleable.AppCompatTextHelper_android_drawableRight)) {
            r0.f2178e = m1833a(context, a2, a3.m2323g(C0164R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.m2322f(C0164R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            r0.f2179f = m1833a(context, a2, a3.m2323g(C0164R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a3.f2595b.recycle();
        boolean z3 = r0.f2174a.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList = null;
        if (g != -1) {
            a = TintTypedArray.m2306a(context, g, C0164R.styleable.TextAppearance);
            if (z3 || !a.m2322f(C0164R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = z;
            } else {
                z2 = a.m2312a(C0164R.styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            m1834a(context, a);
            if (VERSION.SDK_INT < 23) {
                e = a.m2322f(C0164R.styleable.TextAppearance_android_textColor) ? a.m2320e(C0164R.styleable.TextAppearance_android_textColor) : null;
                e2 = a.m2322f(C0164R.styleable.TextAppearance_android_textColorHint) ? a.m2320e(C0164R.styleable.TextAppearance_android_textColorHint) : null;
                if (a.m2322f(C0164R.styleable.TextAppearance_android_textColorLink)) {
                    colorStateList = a.m2320e(C0164R.styleable.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList2 = e;
                e = colorStateList;
                colorStateList = colorStateList2;
            } else {
                e = null;
                e2 = e;
            }
            a.f2595b.recycle();
        } else {
            z = false;
            z2 = z;
            e = null;
            e2 = e;
        }
        a = TintTypedArray.m2308a(context, attributeSet2, C0164R.styleable.TextAppearance, i2, 0);
        if (!z3 && a.m2322f(C0164R.styleable.TextAppearance_textAllCaps)) {
            z2 = a.m2312a(C0164R.styleable.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a.m2322f(C0164R.styleable.TextAppearance_android_textColor)) {
                colorStateList = a.m2320e(C0164R.styleable.TextAppearance_android_textColor);
            }
            if (a.m2322f(C0164R.styleable.TextAppearance_android_textColorHint)) {
                e2 = a.m2320e(C0164R.styleable.TextAppearance_android_textColorHint);
            }
            if (a.m2322f(C0164R.styleable.TextAppearance_android_textColorLink)) {
                e = a.m2320e(C0164R.styleable.TextAppearance_android_textColorLink);
            }
        }
        m1834a(context, a);
        a.f2595b.recycle();
        if (colorStateList != null) {
            r0.f2174a.setTextColor(colorStateList);
        }
        if (e2 != null) {
            r0.f2174a.setHintTextColor(e2);
        }
        if (e != null) {
            r0.f2174a.setLinkTextColor(e);
        }
        if (!z3 && r11) {
            m1843a(z2);
        }
        if (r0.f2181h != null) {
            r0.f2174a.setTypeface(r0.f2181h, r0.f2180g);
        }
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = r0.f2175b;
        TypedArray obtainStyledAttributes = appCompatTextViewAutoSizeHelper.f2192h.obtainStyledAttributes(attributeSet2, C0164R.styleable.AppCompatTextView, i2, 0);
        if (obtainStyledAttributes.hasValue(C0164R.styleable.AppCompatTextView_autoSizeTextType)) {
            appCompatTextViewAutoSizeHelper.f2185a = obtainStyledAttributes.getInt(C0164R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(C0164R.styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(C0164R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(C0164R.styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(C0164R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(C0164R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(C0164R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(C0164R.styleable.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = obtainStyledAttributes.getResourceId(C0164R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                int length = obtainTypedArray.length();
                int[] iArr = new int[length];
                if (length > 0) {
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr[i3] = obtainTypedArray.getDimensionPixelSize(i3, -1);
                    }
                    appCompatTextViewAutoSizeHelper.f2190f = AppCompatTextViewAutoSizeHelper.m1848a(iArr);
                    appCompatTextViewAutoSizeHelper.m1851a();
                }
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!appCompatTextViewAutoSizeHelper.m1855e()) {
            appCompatTextViewAutoSizeHelper.f2185a = 0;
        } else if (appCompatTextViewAutoSizeHelper.f2185a == 1) {
            if (!appCompatTextViewAutoSizeHelper.f2191g) {
                DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.f2192h.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                appCompatTextViewAutoSizeHelper.m1849a(dimension2, dimension3, dimension);
            }
            appCompatTextViewAutoSizeHelper.m1852b();
        }
        if (AutoSizeableTextView.f1560a && r0.f2175b.f2185a != 0) {
            int[] iArr2 = r0.f2175b.f2190f;
            if (iArr2.length > 0) {
                if (((float) r0.f2174a.getAutoSizeStepGranularity()) != -1.0f) {
                    r0.f2174a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(r0.f2175b.f2188d), Math.round(r0.f2175b.f2189e), Math.round(r0.f2175b.f2187c), 0);
                    return;
                }
                r0.f2174a.setAutoSizeTextTypeUniformWithPresetSizes(iArr2, 0);
            }
        }
    }

    private void m1834a(android.content.Context r8, android.support.v7.widget.TintTypedArray r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_android_textStyle;
        r1 = r7.f2180g;
        r0 = r9.m2310a(r0, r1);
        r7.f2180g = r0;
        r0 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_android_fontFamily;
        r0 = r9.m2322f(r0);
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0041;
    L_0x0014:
        r0 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_fontFamily;
        r0 = r9.m2322f(r0);
        if (r0 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0041;
    L_0x001d:
        r8 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_android_typeface;
        r8 = r9.m2322f(r8);
        if (r8 == 0) goto L_0x0040;
    L_0x0025:
        r7.f2182i = r2;
        r8 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_android_typeface;
        r8 = r9.m2310a(r8, r1);
        switch(r8) {
            case 1: goto L_0x003b;
            case 2: goto L_0x0036;
            case 3: goto L_0x0031;
            default: goto L_0x0030;
        };
    L_0x0030:
        goto L_0x0040;
    L_0x0031:
        r8 = android.graphics.Typeface.MONOSPACE;
        r7.f2181h = r8;
        goto L_0x0040;
    L_0x0036:
        r8 = android.graphics.Typeface.SERIF;
        r7.f2181h = r8;
        return;
    L_0x003b:
        r8 = android.graphics.Typeface.SANS_SERIF;
        r7.f2181h = r8;
        return;
    L_0x0040:
        return;
    L_0x0041:
        r0 = 0;
        r7.f2181h = r0;
        r3 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_fontFamily;
        r3 = r9.m2322f(r3);
        if (r3 == 0) goto L_0x004f;
    L_0x004c:
        r3 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_fontFamily;
        goto L_0x0051;
    L_0x004f:
        r3 = android.support.v7.appcompat.C0164R.styleable.TextAppearance_android_fontFamily;
    L_0x0051:
        r8 = r8.isRestricted();
        if (r8 != 0) goto L_0x008b;
    L_0x0057:
        r8 = new java.lang.ref.WeakReference;
        r4 = r7.f2174a;
        r8.<init>(r4);
        r4 = new android.support.v7.widget.AppCompatTextHelper$1;
        r4.<init>(r7, r8);
        r8 = r7.f2180g;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        r5 = r9.f2595b;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        r5 = r5.getResourceId(r3, r2);	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        if (r5 != 0) goto L_0x006e;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x006d:
        goto L_0x0081;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x006e:
        r0 = r9.f2596c;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        if (r0 != 0) goto L_0x0079;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x0072:
        r0 = new android.util.TypedValue;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        r0.<init>();	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        r9.f2596c = r0;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x0079:
        r0 = r9.f2594a;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        r6 = r9.f2596c;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        r0 = android.support.v4.content.res.ResourcesCompat.m771a(r0, r5, r6, r8, r4);	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x0081:
        r7.f2181h = r0;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        r8 = r7.f2181h;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
        if (r8 != 0) goto L_0x0088;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x0087:
        goto L_0x0089;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x0088:
        r1 = r2;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x0089:
        r7.f2182i = r1;	 Catch:{ UnsupportedOperationException -> 0x008b, UnsupportedOperationException -> 0x008b }
    L_0x008b:
        r8 = r7.f2181h;
        if (r8 != 0) goto L_0x009d;
    L_0x008f:
        r8 = r9.m2318d(r3);
        if (r8 == 0) goto L_0x009d;
    L_0x0095:
        r9 = r7.f2180g;
        r8 = android.graphics.Typeface.create(r8, r9);
        r7.f2181h = r8;
    L_0x009d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatTextHelper.a(android.content.Context, android.support.v7.widget.TintTypedArray):void");
    }

    final void m1840a(Context context, int i) {
        TintTypedArray a = TintTypedArray.m2306a(context, i, C0164R.styleable.TextAppearance);
        if (a.m2322f(C0164R.styleable.TextAppearance_textAllCaps)) {
            m1843a(a.m2312a(C0164R.styleable.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.m2322f(C0164R.styleable.TextAppearance_android_textColor)) {
            ColorStateList e = a.m2320e(C0164R.styleable.TextAppearance_android_textColor);
            if (e != null) {
                this.f2174a.setTextColor(e);
            }
        }
        m1834a(context, a);
        a.f2595b.recycle();
        if (this.f2181h != null) {
            this.f2174a.setTypeface(this.f2181h, this.f2180g);
        }
    }

    final void m1843a(boolean z) {
        this.f2174a.setAllCaps(z);
    }

    void mo590a() {
        if (this.f2176c != null || this.f2177d != null || this.f2178e != null || this.f2179f != null) {
            Drawable[] compoundDrawables = this.f2174a.getCompoundDrawables();
            m1841a(compoundDrawables[0], this.f2176c);
            m1841a(compoundDrawables[1], this.f2177d);
            m1841a(compoundDrawables[2], this.f2178e);
            m1841a(compoundDrawables[3], this.f2179f);
        }
    }

    final void m1841a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.m1811a(drawable, tintInfo, this.f2174a.getDrawableState());
        }
    }

    protected static TintInfo m1833a(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        context = appCompatDrawableManager.m1820b(context, i);
        if (context == null) {
            return null;
        }
        appCompatDrawableManager = new TintInfo();
        appCompatDrawableManager.f2593d = true;
        appCompatDrawableManager.f2590a = context;
        return appCompatDrawableManager;
    }

    final void m1845b() {
        if (!AutoSizeableTextView.f1560a) {
            this.f2175b.m1853c();
        }
    }

    final void m1838a(int i, float f) {
        if (!AutoSizeableTextView.f1560a && !this.f2175b.m1854d()) {
            this.f2175b.m1850a(i, f);
        }
    }

    final void m1837a(int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.f2175b;
        if (appCompatTextViewAutoSizeHelper.m1855e()) {
            switch (i) {
                case 0:
                    appCompatTextViewAutoSizeHelper.f2185a = 0;
                    appCompatTextViewAutoSizeHelper.f2188d = -1.0f;
                    appCompatTextViewAutoSizeHelper.f2189e = -1.0f;
                    appCompatTextViewAutoSizeHelper.f2187c = -1.0f;
                    appCompatTextViewAutoSizeHelper.f2190f = new int[0];
                    appCompatTextViewAutoSizeHelper.f2186b = false;
                    return;
                case 1:
                    i = appCompatTextViewAutoSizeHelper.f2192h.getResources().getDisplayMetrics();
                    appCompatTextViewAutoSizeHelper.m1849a(TypedValue.applyDimension(2, 12.0f, i), TypedValue.applyDimension(2, 112.0f, i), 1.0f);
                    if (appCompatTextViewAutoSizeHelper.m1852b() != 0) {
                        appCompatTextViewAutoSizeHelper.m1853c();
                        return;
                    }
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown auto-size text type: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    final void m1839a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.f2175b;
        if (appCompatTextViewAutoSizeHelper.m1855e()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.f2192h.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.m1849a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.m1852b() != 0) {
                appCompatTextViewAutoSizeHelper.m1853c();
            }
        }
    }

    final void m1844a(int[] iArr, int i) throws IllegalArgumentException {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.f2175b;
        if (appCompatTextViewAutoSizeHelper.m1855e()) {
            int i2 = 0;
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.f2192h.getResources().getDisplayMetrics();
                    while (i2 < length) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                        i2++;
                    }
                }
                appCompatTextViewAutoSizeHelper.f2190f = AppCompatTextViewAutoSizeHelper.m1848a(iArr2);
                if (appCompatTextViewAutoSizeHelper.m1851a() == 0) {
                    StringBuilder stringBuilder = new StringBuilder("None of the preset sizes is valid: ");
                    stringBuilder.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            appCompatTextViewAutoSizeHelper.f2191g = false;
            if (appCompatTextViewAutoSizeHelper.m1852b() != null) {
                appCompatTextViewAutoSizeHelper.m1853c();
            }
        }
    }

    static /* synthetic */ void m1835a(AppCompatTextHelper appCompatTextHelper, WeakReference weakReference, Typeface typeface) {
        if (appCompatTextHelper.f2182i) {
            appCompatTextHelper.f2181h = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, appCompatTextHelper.f2180g);
            }
        }
    }
}
