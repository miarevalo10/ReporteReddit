package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

class AppCompatTextViewAutoSizeHelper {
    private static final RectF f2183i = new RectF();
    private static Hashtable<String, Method> f2184j = new Hashtable();
    int f2185a = 0;
    boolean f2186b = false;
    float f2187c = -1.0f;
    float f2188d = -1.0f;
    float f2189e = -1.0f;
    int[] f2190f = new int[0];
    boolean f2191g = false;
    final Context f2192h;
    private TextPaint f2193k;
    private final TextView f2194l;

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.f2194l = textView;
        this.f2192h = this.f2194l.getContext();
    }

    final boolean m1851a() {
        int length = this.f2190f.length;
        this.f2191g = length > 0;
        if (this.f2191g) {
            this.f2185a = 1;
            this.f2188d = (float) this.f2190f[0];
            this.f2189e = (float) this.f2190f[length - 1];
            this.f2187c = -1.0f;
        }
        return this.f2191g;
    }

    static int[] m1848a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        iArr = arrayList.size();
        int[] iArr2 = new int[iArr];
        while (i < iArr) {
            iArr2[i] = ((Integer) arrayList.get(i)).intValue();
            i++;
        }
        return iArr2;
    }

    final void m1849a(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            f3 = new StringBuilder("Minimum auto-size text size (");
            f3.append(f);
            f3.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(f3.toString());
        } else if (f2 <= f) {
            StringBuilder stringBuilder = new StringBuilder("Maximum auto-size text size (");
            stringBuilder.append(f2);
            stringBuilder.append("px) is less or equal to minimum auto-size text size (");
            stringBuilder.append(f);
            stringBuilder.append("px)");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f3 <= 0.0f) {
            f2 = new StringBuilder("The auto-size step granularity (");
            f2.append(f3);
            f2.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(f2.toString());
        } else {
            this.f2185a = 1;
            this.f2188d = f;
            this.f2189e = f2;
            this.f2187c = f3;
            this.f2191g = false;
        }
    }

    final boolean m1852b() {
        int i = 0;
        if (m1855e() && this.f2185a == 1) {
            if (!this.f2191g || this.f2190f.length == 0) {
                float round = (float) Math.round(this.f2188d);
                int i2 = 1;
                while (Math.round(this.f2187c + round) <= Math.round(this.f2189e)) {
                    i2++;
                    round += this.f2187c;
                }
                int[] iArr = new int[i2];
                float f = this.f2188d;
                while (i < i2) {
                    iArr[i] = Math.round(f);
                    f += this.f2187c;
                    i++;
                }
                this.f2190f = m1848a(iArr);
            }
            this.f2186b = true;
        } else {
            this.f2186b = false;
        }
        return this.f2186b;
    }

    final void m1853c() {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this;
        if (m1854d()) {
            boolean z;
            int i = 1;
            if (appCompatTextViewAutoSizeHelper.f2186b) {
                if (appCompatTextViewAutoSizeHelper.f2194l.getMeasuredHeight() > 0) {
                    if (appCompatTextViewAutoSizeHelper.f2194l.getMeasuredWidth() > 0) {
                        int i2;
                        int i3 = 0;
                        if (((Boolean) m1846a(appCompatTextViewAutoSizeHelper.f2194l, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
                            i2 = 1048576;
                        } else {
                            i2 = (appCompatTextViewAutoSizeHelper.f2194l.getMeasuredWidth() - appCompatTextViewAutoSizeHelper.f2194l.getTotalPaddingLeft()) - appCompatTextViewAutoSizeHelper.f2194l.getTotalPaddingRight();
                        }
                        int height = (appCompatTextViewAutoSizeHelper.f2194l.getHeight() - appCompatTextViewAutoSizeHelper.f2194l.getCompoundPaddingBottom()) - appCompatTextViewAutoSizeHelper.f2194l.getCompoundPaddingTop();
                        if (i2 > 0) {
                            if (height > 0) {
                                synchronized (f2183i) {
                                    RectF rectF;
                                    try {
                                        f2183i.setEmpty();
                                        f2183i.right = (float) i2;
                                        f2183i.bottom = (float) height;
                                        rectF = f2183i;
                                        height = appCompatTextViewAutoSizeHelper.f2190f.length;
                                        if (height == 0) {
                                            throw new IllegalStateException("No available text sizes to choose from.");
                                        }
                                        height--;
                                        int i4 = height;
                                        int i5 = 0;
                                        while (height <= i4) {
                                            StaticLayout build;
                                            int i6;
                                            Object obj;
                                            i5 = (height + i4) / 2;
                                            int i7 = appCompatTextViewAutoSizeHelper.f2190f[i5];
                                            CharSequence text = appCompatTextViewAutoSizeHelper.f2194l.getText();
                                            TransformationMethod transformationMethod = appCompatTextViewAutoSizeHelper.f2194l.getTransformationMethod();
                                            if (transformationMethod != null) {
                                                CharSequence transformation = transformationMethod.getTransformation(text, appCompatTextViewAutoSizeHelper.f2194l);
                                                if (transformation != null) {
                                                    text = transformation;
                                                }
                                            }
                                            int maxLines = VERSION.SDK_INT >= 16 ? appCompatTextViewAutoSizeHelper.f2194l.getMaxLines() : -1;
                                            if (appCompatTextViewAutoSizeHelper.f2193k == null) {
                                                appCompatTextViewAutoSizeHelper.f2193k = new TextPaint();
                                            } else {
                                                appCompatTextViewAutoSizeHelper.f2193k.reset();
                                            }
                                            appCompatTextViewAutoSizeHelper.f2193k.set(appCompatTextViewAutoSizeHelper.f2194l.getPaint());
                                            appCompatTextViewAutoSizeHelper.f2193k.setTextSize((float) i7);
                                            Alignment alignment = (Alignment) m1846a(appCompatTextViewAutoSizeHelper.f2194l, "getLayoutAlignment", Alignment.ALIGN_NORMAL);
                                            if (VERSION.SDK_INT >= 23) {
                                                build = Builder.obtain(text, i3, text.length(), appCompatTextViewAutoSizeHelper.f2193k, Math.round(rectF.right)).setAlignment(alignment).setLineSpacing(appCompatTextViewAutoSizeHelper.f2194l.getLineSpacingExtra(), appCompatTextViewAutoSizeHelper.f2194l.getLineSpacingMultiplier()).setIncludePad(appCompatTextViewAutoSizeHelper.f2194l.getIncludeFontPadding()).setBreakStrategy(appCompatTextViewAutoSizeHelper.f2194l.getBreakStrategy()).setHyphenationFrequency(appCompatTextViewAutoSizeHelper.f2194l.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? RedditJobManager.f10810d : maxLines).setTextDirection((TextDirectionHeuristic) m1846a(appCompatTextViewAutoSizeHelper.f2194l, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR)).build();
                                                i6 = height;
                                                i3 = -1;
                                            } else {
                                                float lineSpacingMultiplier;
                                                float lineSpacingExtra;
                                                boolean includeFontPadding;
                                                i = Math.round(rectF.right);
                                                if (VERSION.SDK_INT >= 16) {
                                                    i6 = height;
                                                    lineSpacingMultiplier = appCompatTextViewAutoSizeHelper.f2194l.getLineSpacingMultiplier();
                                                    lineSpacingExtra = appCompatTextViewAutoSizeHelper.f2194l.getLineSpacingExtra();
                                                    includeFontPadding = appCompatTextViewAutoSizeHelper.f2194l.getIncludeFontPadding();
                                                } else {
                                                    float floatValue = ((Float) m1846a(appCompatTextViewAutoSizeHelper.f2194l, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
                                                    float floatValue2 = ((Float) m1846a(appCompatTextViewAutoSizeHelper.f2194l, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
                                                    i6 = height;
                                                    includeFontPadding = ((Boolean) m1846a(appCompatTextViewAutoSizeHelper.f2194l, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
                                                    lineSpacingMultiplier = floatValue;
                                                    lineSpacingExtra = floatValue2;
                                                }
                                                i3 = -1;
                                                build = new StaticLayout(text, appCompatTextViewAutoSizeHelper.f2193k, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
                                            }
                                            if (maxLines == i3 || (build.getLineCount() <= maxLines && build.getLineEnd(build.getLineCount() - 1) == text.length())) {
                                                if (((float) build.getHeight()) <= rectF.bottom) {
                                                    obj = 1;
                                                    if (obj == null) {
                                                        height = i5 + 1;
                                                        i5 = i6;
                                                    } else {
                                                        i5--;
                                                        i4 = i5;
                                                        height = i6;
                                                    }
                                                    i3 = 0;
                                                }
                                            }
                                            obj = null;
                                            if (obj == null) {
                                                i5--;
                                                i4 = i5;
                                                height = i6;
                                            } else {
                                                height = i5 + 1;
                                                i5 = i6;
                                            }
                                            i3 = 0;
                                        }
                                        float f = (float) appCompatTextViewAutoSizeHelper.f2190f[i5];
                                        if (f != appCompatTextViewAutoSizeHelper.f2194l.getTextSize()) {
                                            m1850a(0, f);
                                        }
                                    } finally {
                                        rectF = 
/*
Method generation error in method: android.support.v7.widget.AppCompatTextViewAutoSizeHelper.c():void
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0218: MERGE  (r2_25 'rectF' android.graphics.RectF) = (r0_1 int), (r3_0 'i' int) in method: android.support.v7.widget.AppCompatTextViewAutoSizeHelper.c():void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:227)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 64 more

*/

                                        final void m1850a(int i, float f) {
                                            Resources system;
                                            if (this.f2192h == null) {
                                                system = Resources.getSystem();
                                            } else {
                                                system = this.f2192h.getResources();
                                            }
                                            i = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
                                            if (i != this.f2194l.getPaint().getTextSize()) {
                                                this.f2194l.getPaint().setTextSize(i);
                                                i = VERSION.SDK_INT >= 18 ? this.f2194l.isInLayout() : 0;
                                                if (this.f2194l.getLayout() != null) {
                                                    this.f2186b = false;
                                                    try {
                                                        f = m1847a("nullLayouts");
                                                        if (f != null) {
                                                            f.invoke(this.f2194l, new Object[0]);
                                                        }
                                                    } catch (float f2) {
                                                        Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", f2);
                                                    }
                                                    if (i == 0) {
                                                        this.f2194l.requestLayout();
                                                    } else {
                                                        this.f2194l.forceLayout();
                                                    }
                                                    this.f2194l.invalidate();
                                                }
                                            }
                                        }

                                        private static <T> T m1846a(Object obj, String str, T t) {
                                            try {
                                                return m1847a(str).invoke(obj, new Object[0]);
                                            } catch (Object obj2) {
                                                StringBuilder stringBuilder = new StringBuilder("Failed to invoke TextView#");
                                                stringBuilder.append(str);
                                                stringBuilder.append("() method");
                                                Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), obj2);
                                                return t;
                                            }
                                        }

                                        private static Method m1847a(String str) {
                                            try {
                                                Method method = (Method) f2184j.get(str);
                                                if (method == null) {
                                                    method = TextView.class.getDeclaredMethod(str, new Class[0]);
                                                    if (method != null) {
                                                        method.setAccessible(true);
                                                        f2184j.put(str, method);
                                                    }
                                                }
                                                return method;
                                            } catch (Throwable e) {
                                                StringBuilder stringBuilder = new StringBuilder("Failed to retrieve TextView#");
                                                stringBuilder.append(str);
                                                stringBuilder.append("() method");
                                                Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), e);
                                                return null;
                                            }
                                        }

                                        final boolean m1854d() {
                                            return m1855e() && this.f2185a != 0;
                                        }

                                        final boolean m1855e() {
                                            return !(this.f2194l instanceof AppCompatEditText);
                                        }
                                    }
