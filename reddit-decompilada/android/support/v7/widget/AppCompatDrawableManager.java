package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AppCompatDrawableManager {
    private static final Mode f2140c = Mode.SRC_IN;
    private static AppCompatDrawableManager f2141d;
    private static final ColorFilterLruCache f2142e = new ColorFilterLruCache();
    private static final int[] f2143f = new int[]{C0164R.drawable.abc_textfield_search_default_mtrl_alpha, C0164R.drawable.abc_textfield_default_mtrl_alpha, C0164R.drawable.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f2144g = new int[]{C0164R.drawable.abc_ic_commit_search_api_mtrl_alpha, C0164R.drawable.abc_seekbar_tick_mark_material, C0164R.drawable.abc_ic_menu_share_mtrl_alpha, C0164R.drawable.abc_ic_menu_copy_mtrl_am_alpha, C0164R.drawable.abc_ic_menu_cut_mtrl_alpha, C0164R.drawable.abc_ic_menu_selectall_mtrl_alpha, C0164R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f2145h = new int[]{C0164R.drawable.abc_textfield_activated_mtrl_alpha, C0164R.drawable.abc_textfield_search_activated_mtrl_alpha, C0164R.drawable.abc_cab_background_top_mtrl_alpha, C0164R.drawable.abc_text_cursor_material, C0164R.drawable.abc_text_select_handle_left_mtrl_dark, C0164R.drawable.abc_text_select_handle_middle_mtrl_dark, C0164R.drawable.abc_text_select_handle_right_mtrl_dark, C0164R.drawable.abc_text_select_handle_left_mtrl_light, C0164R.drawable.abc_text_select_handle_middle_mtrl_light, C0164R.drawable.abc_text_select_handle_right_mtrl_light};
    private static final int[] f2146i = new int[]{C0164R.drawable.abc_popup_background_mtrl_mult, C0164R.drawable.abc_cab_background_internal_bg, C0164R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f2147j = new int[]{C0164R.drawable.abc_tab_indicator_material, C0164R.drawable.abc_textfield_search_material};
    private static final int[] f2148k = new int[]{C0164R.drawable.abc_btn_check_material, C0164R.drawable.abc_btn_radio_material};
    public final Object f2149a = new Object();
    public final WeakHashMap<Context, LongSparseArray<WeakReference<ConstantState>>> f2150b = new WeakHashMap(0);
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f2151l;
    private ArrayMap<String, InflateDelegate> f2152m;
    private SparseArrayCompat<String> f2153n;
    private TypedValue f2154o;
    private boolean f2155p;

    private interface InflateDelegate {
        Drawable mo583a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    @RequiresApi(11)
    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        public final Drawable mo583a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.m16577a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Context context2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", context2);
                return null;
            }
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache() {
            super(6);
        }

        static int m10574a(int i, Mode mode) {
            return (31 * (i + 31)) + mode.hashCode();
        }
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        public final Drawable mo583a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return VectorDrawableCompat.m16582a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Context context2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", context2);
                return null;
            }
        }
    }

    public static AppCompatDrawableManager m1809a() {
        if (f2141d == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            f2141d = appCompatDrawableManager;
            if (VERSION.SDK_INT < 24) {
                appCompatDrawableManager.m1812a("vector", new VdcInflateDelegate());
                appCompatDrawableManager.m1812a("animated-vector", new AvdcInflateDelegate());
            }
        }
        return f2141d;
    }

    private static long m1806a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    final Drawable m1819a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m1820b(context, i);
        Mode mode = null;
        if (b != null) {
            if (DrawableUtils.m1960c(drawable) != null) {
                drawable = drawable.mutate();
            }
            drawable = DrawableCompat.m844g(drawable);
            DrawableCompat.m833a(drawable, b);
            if (i == C0164R.drawable.abc_switch_thumb_material) {
                mode = Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawable;
            }
            DrawableCompat.m836a(drawable, mode);
            return drawable;
        } else if (i == C0164R.drawable.abc_seekbar_track_material) {
            r7 = (LayerDrawable) drawable;
            m1810a(r7.findDrawableByLayerId(16908288), ThemeUtils.m2301a(context, C0164R.attr.colorControlNormal), f2140c);
            m1810a(r7.findDrawableByLayerId(16908303), ThemeUtils.m2301a(context, C0164R.attr.colorControlNormal), f2140c);
            m1810a(r7.findDrawableByLayerId(16908301), ThemeUtils.m2301a(context, C0164R.attr.colorControlActivated), f2140c);
            return drawable;
        } else {
            if (!(i == C0164R.drawable.abc_ratingbar_material || i == C0164R.drawable.abc_ratingbar_indicator_material)) {
                if (i != C0164R.drawable.abc_ratingbar_small_material) {
                    if (m1813a(context, i, drawable) == null && z) {
                        return null;
                    }
                    return drawable;
                }
            }
            r7 = (LayerDrawable) drawable;
            m1810a(r7.findDrawableByLayerId(16908288), ThemeUtils.m2303c(context, C0164R.attr.colorControlNormal), f2140c);
            m1810a(r7.findDrawableByLayerId(16908303), ThemeUtils.m2301a(context, C0164R.attr.colorControlActivated), f2140c);
            m1810a(r7.findDrawableByLayerId(16908301), ThemeUtils.m2301a(context, C0164R.attr.colorControlActivated), f2140c);
            return drawable;
        }
    }

    final Drawable m1817a(Context context, int i) {
        if (this.f2152m == null || this.f2152m.isEmpty()) {
            return null;
        }
        if (this.f2153n != null) {
            String str = (String) this.f2153n.m1059a(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f2152m.get(str) == null)) {
                return null;
            }
        }
        this.f2153n = new SparseArrayCompat();
        if (this.f2154o == null) {
            this.f2154o = new TypedValue();
        }
        TypedValue typedValue = this.f2154o;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = m1806a(typedValue);
        Drawable a2 = m1808a(context, a);
        if (a2 != null) {
            return a2;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                int next;
                XmlPullParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2153n.m1063b(i, name);
                InflateDelegate inflateDelegate = (InflateDelegate) this.f2152m.get(name);
                if (inflateDelegate != null) {
                    a2 = inflateDelegate.mo583a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    m1814a(context, a, a2);
                }
            } catch (Context context2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", context2);
            }
        }
        if (a2 == null) {
            this.f2153n.m1063b(i, "appcompat_skip_skip");
        }
        return a2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m1808a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r0 = r4.f2149a;
        monitor-enter(r0);
        r1 = r4.f2150b;	 Catch:{ all -> 0x0047 }
        r1 = r1.get(r5);	 Catch:{ all -> 0x0047 }
        r1 = (android.support.v4.util.LongSparseArray) r1;	 Catch:{ all -> 0x0047 }
        r2 = 0;
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        return r2;
    L_0x0010:
        r3 = r1.m1015a(r6);	 Catch:{ all -> 0x0047 }
        r3 = (java.lang.ref.WeakReference) r3;	 Catch:{ all -> 0x0047 }
        if (r3 == 0) goto L_0x0045;
    L_0x0018:
        r3 = r3.get();	 Catch:{ all -> 0x0047 }
        r3 = (android.graphics.drawable.Drawable.ConstantState) r3;	 Catch:{ all -> 0x0047 }
        if (r3 == 0) goto L_0x002a;
    L_0x0020:
        r5 = r5.getResources();	 Catch:{ all -> 0x0047 }
        r5 = r3.newDrawable(r5);	 Catch:{ all -> 0x0047 }
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        return r5;
    L_0x002a:
        r5 = r1.f1392c;	 Catch:{ all -> 0x0047 }
        r3 = r1.f1394e;	 Catch:{ all -> 0x0047 }
        r5 = android.support.v4.util.ContainerHelpers.m1007a(r5, r3, r6);	 Catch:{ all -> 0x0047 }
        if (r5 < 0) goto L_0x0045;
    L_0x0034:
        r6 = r1.f1393d;	 Catch:{ all -> 0x0047 }
        r6 = r6[r5];	 Catch:{ all -> 0x0047 }
        r7 = android.support.v4.util.LongSparseArray.f1390a;	 Catch:{ all -> 0x0047 }
        if (r6 == r7) goto L_0x0045;
    L_0x003c:
        r6 = r1.f1393d;	 Catch:{ all -> 0x0047 }
        r7 = android.support.v4.util.LongSparseArray.f1390a;	 Catch:{ all -> 0x0047 }
        r6[r5] = r7;	 Catch:{ all -> 0x0047 }
        r5 = 1;
        r1.f1391b = r5;	 Catch:{ all -> 0x0047 }
    L_0x0045:
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        return r2;
    L_0x0047:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean m1814a(Context context, long j, Drawable drawable) {
        drawable = drawable.getConstantState();
        if (drawable == null) {
            return null;
        }
        synchronized (this.f2149a) {
            LongSparseArray longSparseArray = (LongSparseArray) this.f2150b.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.f2150b.put(context, longSparseArray);
            }
            longSparseArray.m1017a(j, new WeakReference(drawable));
        }
        return true;
    }

    static boolean m1813a(Context context, int i, Drawable drawable) {
        int round;
        Mode mode = f2140c;
        int i2 = 16842801;
        if (m1815a(f2143f, i)) {
            i2 = C0164R.attr.colorControlNormal;
        } else if (m1815a(f2145h, i)) {
            i2 = C0164R.attr.colorControlActivated;
        } else if (m1815a(f2146i, i)) {
            mode = Mode.MULTIPLY;
        } else if (i == C0164R.drawable.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            round = Math.round(1109603123);
            i = 1;
            if (i != 0) {
                return false;
            }
            if (DrawableUtils.m1960c(drawable) != 0) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(m1807a(ThemeUtils.m2301a(context, i2), mode));
            if (round != -1) {
                drawable.setAlpha(round);
            }
            return true;
        } else if (i != C0164R.drawable.abc_dialog_material_background) {
            round = -1;
            i = 0;
            i2 = i;
            if (i != 0) {
                return false;
            }
            if (DrawableUtils.m1960c(drawable) != 0) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(m1807a(ThemeUtils.m2301a(context, i2), mode));
            if (round != -1) {
                drawable.setAlpha(round);
            }
            return true;
        }
        round = -1;
        i = 1;
        if (i != 0) {
            return false;
        }
        if (DrawableUtils.m1960c(drawable) != 0) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(m1807a(ThemeUtils.m2301a(context, i2), mode));
        if (round != -1) {
            drawable.setAlpha(round);
        }
        return true;
    }

    private void m1812a(String str, InflateDelegate inflateDelegate) {
        if (this.f2152m == null) {
            this.f2152m = new ArrayMap();
        }
        this.f2152m.put(str, inflateDelegate);
    }

    private static boolean m1815a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return 1;
            }
        }
        return false;
    }

    private static ColorStateList m1816c(Context context, int i) {
        r1 = new int[4][];
        r0 = new int[4];
        int a = ThemeUtils.m2301a(context, C0164R.attr.colorControlHighlight);
        context = ThemeUtils.m2303c(context, C0164R.attr.colorButtonNormal);
        r1[0] = ThemeUtils.f2576a;
        r0[0] = context;
        r1[1] = ThemeUtils.f2579d;
        r0[1] = ColorUtils.m794a(a, i);
        r1[2] = ThemeUtils.f2577b;
        r0[2] = ColorUtils.m794a(a, i);
        r1[3] = ThemeUtils.f2583h;
        r0[3] = i;
        return new ColorStateList(r1, r0);
    }

    static void m1811a(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (!DrawableUtils.m1960c(drawable) || drawable.mutate() == drawable) {
            if (!tintInfo.f2593d) {
                if (!tintInfo.f2592c) {
                    drawable.clearColorFilter();
                    if (VERSION.SDK_INT <= 23) {
                        drawable.invalidateSelf();
                    }
                    return;
                }
            }
            ColorFilter colorFilter = null;
            ColorStateList colorStateList = tintInfo.f2593d ? tintInfo.f2590a : null;
            Mode mode = tintInfo.f2592c ? tintInfo.f2591b : f2140c;
            if (colorStateList != null) {
                if (mode != null) {
                    colorFilter = m1807a(colorStateList.getColorForState(iArr, 0), mode);
                }
            }
            drawable.setColorFilter(colorFilter);
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    public static PorterDuffColorFilter m1807a(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) f2142e.get(Integer.valueOf(ColorFilterLruCache.m10574a(i, mode)));
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        f2142e.put(Integer.valueOf(ColorFilterLruCache.m10574a(i, mode)), porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static void m1810a(Drawable drawable, int i, Mode mode) {
        if (DrawableUtils.m1960c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2140c;
        }
        drawable.setColorFilter(m1807a(i, mode));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable m1818a(android.content.Context r9, int r10, boolean r11) {
        /*
        r8 = this;
        r0 = r8.f2155p;
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0034;
    L_0x0006:
        r8.f2155p = r1;
        r0 = android.support.v7.appcompat.C0164R.drawable.abc_vector_test;
        r0 = r8.m1818a(r9, r0, r2);
        if (r0 == 0) goto L_0x002a;
    L_0x0010:
        r3 = r0 instanceof android.support.graphics.drawable.VectorDrawableCompat;
        if (r3 != 0) goto L_0x0027;
    L_0x0014:
        r3 = "android.graphics.drawable.VectorDrawable";
        r0 = r0.getClass();
        r0 = r0.getName();
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0025;
    L_0x0024:
        goto L_0x0027;
    L_0x0025:
        r0 = r2;
        goto L_0x0028;
    L_0x0027:
        r0 = r1;
    L_0x0028:
        if (r0 != 0) goto L_0x0034;
    L_0x002a:
        r8.f2155p = r2;
        r9 = new java.lang.IllegalStateException;
        r10 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.";
        r9.<init>(r10);
        throw r9;
    L_0x0034:
        r0 = r8.m1817a(r9, r10);
        if (r0 != 0) goto L_0x007f;
    L_0x003a:
        r0 = r8.f2154o;
        if (r0 != 0) goto L_0x0045;
    L_0x003e:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r8.f2154o = r0;
    L_0x0045:
        r0 = r8.f2154o;
        r3 = r9.getResources();
        r3.getValue(r10, r0, r1);
        r3 = m1806a(r0);
        r5 = r8.m1808a(r9, r3);
        if (r5 != 0) goto L_0x007e;
    L_0x0058:
        r6 = android.support.v7.appcompat.C0164R.drawable.abc_cab_background_top_material;
        if (r10 != r6) goto L_0x0074;
    L_0x005c:
        r5 = new android.graphics.drawable.LayerDrawable;
        r6 = 2;
        r6 = new android.graphics.drawable.Drawable[r6];
        r7 = android.support.v7.appcompat.C0164R.drawable.abc_cab_background_internal_bg;
        r7 = r8.m1818a(r9, r7, r2);
        r6[r2] = r7;
        r7 = android.support.v7.appcompat.C0164R.drawable.abc_cab_background_top_mtrl_alpha;
        r2 = r8.m1818a(r9, r7, r2);
        r6[r1] = r2;
        r5.<init>(r6);
    L_0x0074:
        if (r5 == 0) goto L_0x007e;
    L_0x0076:
        r0 = r0.changingConfigurations;
        r5.setChangingConfigurations(r0);
        r8.m1814a(r9, r3, r5);
    L_0x007e:
        r0 = r5;
    L_0x007f:
        if (r0 != 0) goto L_0x0085;
    L_0x0081:
        r0 = android.support.v4.content.ContextCompat.m714a(r9, r10);
    L_0x0085:
        if (r0 == 0) goto L_0x008b;
    L_0x0087:
        r0 = r8.m1819a(r9, r10, r11, r0);
    L_0x008b:
        if (r0 == 0) goto L_0x0090;
    L_0x008d:
        android.support.v7.widget.DrawableUtils.m1959b(r0);
    L_0x0090:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.a(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    final ColorStateList m1820b(Context context, int i) {
        SparseArrayCompat sparseArrayCompat;
        ColorStateList colorStateList = null;
        if (this.f2151l != null) {
            sparseArrayCompat = (SparseArrayCompat) this.f2151l.get(context);
            if (sparseArrayCompat != null) {
                colorStateList = (ColorStateList) sparseArrayCompat.m1059a(i);
            }
        }
        if (colorStateList == null) {
            ColorStateList a;
            if (i == C0164R.drawable.abc_edit_text_material) {
                a = AppCompatResources.m1569a(context, C0164R.color.abc_tint_edittext);
            } else if (i == C0164R.drawable.abc_switch_track_mtrl_alpha) {
                a = AppCompatResources.m1569a(context, C0164R.color.abc_tint_switch_track);
            } else {
                if (i == C0164R.drawable.abc_switch_thumb_material) {
                    int[][] iArr = new int[3][];
                    int[] iArr2 = new int[3];
                    ColorStateList b = ThemeUtils.m2302b(context, C0164R.attr.colorSwitchThumbNormal);
                    if (b == null || !b.isStateful()) {
                        iArr[0] = ThemeUtils.f2576a;
                        iArr2[0] = ThemeUtils.m2303c(context, C0164R.attr.colorSwitchThumbNormal);
                        iArr[1] = ThemeUtils.f2580e;
                        iArr2[1] = ThemeUtils.m2301a(context, C0164R.attr.colorControlActivated);
                        iArr[2] = ThemeUtils.f2583h;
                        iArr2[2] = ThemeUtils.m2301a(context, C0164R.attr.colorSwitchThumbNormal);
                    } else {
                        iArr[0] = ThemeUtils.f2576a;
                        iArr2[0] = b.getColorForState(iArr[0], 0);
                        iArr[1] = ThemeUtils.f2580e;
                        iArr2[1] = ThemeUtils.m2301a(context, C0164R.attr.colorControlActivated);
                        iArr[2] = ThemeUtils.f2583h;
                        iArr2[2] = b.getDefaultColor();
                    }
                    colorStateList = new ColorStateList(iArr, iArr2);
                } else if (i == C0164R.drawable.abc_btn_default_mtrl_shape) {
                    a = m1816c(context, ThemeUtils.m2301a(context, C0164R.attr.colorButtonNormal));
                } else if (i == C0164R.drawable.abc_btn_borderless_material) {
                    a = m1816c(context, 0);
                } else if (i == C0164R.drawable.abc_btn_colored_material) {
                    a = m1816c(context, ThemeUtils.m2301a(context, C0164R.attr.colorAccent));
                } else {
                    if (i != C0164R.drawable.abc_spinner_mtrl_am_alpha) {
                        if (i != C0164R.drawable.abc_spinner_textfield_background_material) {
                            if (m1815a(f2144g, i)) {
                                a = ThemeUtils.m2302b(context, C0164R.attr.colorControlNormal);
                            } else if (m1815a(f2147j, i)) {
                                a = AppCompatResources.m1569a(context, C0164R.color.abc_tint_default);
                            } else if (m1815a(f2148k, i)) {
                                a = AppCompatResources.m1569a(context, C0164R.color.abc_tint_btn_checkable);
                            } else if (i == C0164R.drawable.abc_seekbar_thumb_material) {
                                a = AppCompatResources.m1569a(context, C0164R.color.abc_tint_seek_thumb);
                            }
                        }
                    }
                    a = AppCompatResources.m1569a(context, C0164R.color.abc_tint_spinner);
                }
                if (colorStateList != null) {
                    if (this.f2151l == null) {
                        this.f2151l = new WeakHashMap();
                    }
                    sparseArrayCompat = (SparseArrayCompat) this.f2151l.get(context);
                    if (sparseArrayCompat == null) {
                        sparseArrayCompat = new SparseArrayCompat();
                        this.f2151l.put(context, sparseArrayCompat);
                    }
                    sparseArrayCompat.m1063b(i, colorStateList);
                }
            }
            colorStateList = a;
            if (colorStateList != null) {
                if (this.f2151l == null) {
                    this.f2151l = new WeakHashMap();
                }
                sparseArrayCompat = (SparseArrayCompat) this.f2151l.get(context);
                if (sparseArrayCompat == null) {
                    sparseArrayCompat = new SparseArrayCompat();
                    this.f2151l.put(context, sparseArrayCompat);
                }
                sparseArrayCompat.m1063b(i, colorStateList);
            }
        }
        return colorStateList;
    }
}
