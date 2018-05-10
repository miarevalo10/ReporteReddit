package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    static final Mode f16464a = Mode.SRC_IN;
    VectorDrawableCompatState f16465c;
    boolean f16466d;
    private PorterDuffColorFilter f16467e;
    private ColorFilter f16468f;
    private boolean f16469g;
    private ConstantState f16470h;
    private final float[] f16471i;
    private final Matrix f16472j;
    private final Rect f16473k;

    private static class VGroup {
        final ArrayList<Object> f751a = new ArrayList();
        float f752b = 0.0f;
        float f753c = 0.0f;
        float f754d = 0.0f;
        float f755e = 1.0f;
        float f756f = 1.0f;
        float f757g = 0.0f;
        float f758h = 0.0f;
        int f759i;
        int[] f760j;
        String f761k = null;
        private final Matrix f762l = new Matrix();
        private final Matrix f763m = new Matrix();

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            this.f752b = vGroup.f752b;
            this.f753c = vGroup.f753c;
            this.f754d = vGroup.f754d;
            this.f755e = vGroup.f755e;
            this.f756f = vGroup.f756f;
            this.f757g = vGroup.f757g;
            this.f758h = vGroup.f758h;
            this.f760j = vGroup.f760j;
            this.f761k = vGroup.f761k;
            this.f759i = vGroup.f759i;
            if (this.f761k != null) {
                arrayMap.put(this.f761k, this);
            }
            this.f763m.set(vGroup.f763m);
            vGroup = vGroup.f751a;
            for (int i = 0; i < vGroup.size(); i++) {
                Object obj = vGroup.get(i);
                if (obj instanceof VGroup) {
                    this.f751a.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    VPath vFullPath;
                    if (obj instanceof VFullPath) {
                        vFullPath = new VFullPath((VFullPath) obj);
                    } else if (obj instanceof VClipPath) {
                        vFullPath = new VClipPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f751a.add(vFullPath);
                    if (vFullPath.f765n != null) {
                        arrayMap.put(vFullPath.f765n, vFullPath);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.f761k;
        }

        public Matrix getLocalMatrix() {
            return this.f763m;
        }

        final void m379a() {
            this.f763m.reset();
            this.f763m.postTranslate(-this.f753c, -this.f754d);
            this.f763m.postScale(this.f755e, this.f756f);
            this.f763m.postRotate(this.f752b, 0.0f, 0.0f);
            this.f763m.postTranslate(this.f757g + this.f753c, this.f758h + this.f754d);
        }

        public float getRotation() {
            return this.f752b;
        }

        public void setRotation(float f) {
            if (f != this.f752b) {
                this.f752b = f;
                m379a();
            }
        }

        public float getPivotX() {
            return this.f753c;
        }

        public void setPivotX(float f) {
            if (f != this.f753c) {
                this.f753c = f;
                m379a();
            }
        }

        public float getPivotY() {
            return this.f754d;
        }

        public void setPivotY(float f) {
            if (f != this.f754d) {
                this.f754d = f;
                m379a();
            }
        }

        public float getScaleX() {
            return this.f755e;
        }

        public void setScaleX(float f) {
            if (f != this.f755e) {
                this.f755e = f;
                m379a();
            }
        }

        public float getScaleY() {
            return this.f756f;
        }

        public void setScaleY(float f) {
            if (f != this.f756f) {
                this.f756f = f;
                m379a();
            }
        }

        public float getTranslateX() {
            return this.f757g;
        }

        public void setTranslateX(float f) {
            if (f != this.f757g) {
                this.f757g = f;
                m379a();
            }
        }

        public float getTranslateY() {
            return this.f758h;
        }

        public void setTranslateY(float f) {
            if (f != this.f758h) {
                this.f758h = f;
                m379a();
            }
        }
    }

    private static class VPath {
        protected PathDataNode[] f764m = null;
        String f765n;
        int f766o;

        public boolean mo126a() {
            return false;
        }

        public VPath(VPath vPath) {
            this.f765n = vPath.f765n;
            this.f766o = vPath.f766o;
            this.f764m = PathParser.m808a(vPath.f764m);
        }

        public final void m380a(Path path) {
            path.reset();
            if (this.f764m != null) {
                PathDataNode.m801a(this.f764m, path);
            }
        }

        public String getPathName() {
            return this.f765n;
        }

        public PathDataNode[] getPathData() {
            return this.f764m;
        }

        public void setPathData(PathDataNode[] pathDataNodeArr) {
            if (PathParser.m806a(this.f764m, pathDataNodeArr)) {
                PathParser.m809b(this.f764m, pathDataNodeArr);
            } else {
                this.f764m = PathParser.m808a(pathDataNodeArr);
            }
        }
    }

    private static class VPathRenderer {
        private static final Matrix f767k = new Matrix();
        final VGroup f768a;
        float f769b;
        float f770c;
        float f771d;
        float f772e;
        int f773f;
        String f774g;
        final ArrayMap<String, Object> f775h;
        private final Path f776i;
        private final Path f777j;
        private final Matrix f778l;
        private Paint f779m;
        private Paint f780n;
        private PathMeasure f781o;
        private int f782p;

        public VPathRenderer() {
            this.f778l = new Matrix();
            this.f769b = 0.0f;
            this.f770c = 0.0f;
            this.f771d = 0.0f;
            this.f772e = 0.0f;
            this.f773f = 255;
            this.f774g = null;
            this.f775h = new ArrayMap();
            this.f768a = new VGroup();
            this.f776i = new Path();
            this.f777j = new Path();
        }

        public void setRootAlpha(int i) {
            this.f773f = i;
        }

        public int getRootAlpha() {
            return this.f773f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f778l = new Matrix();
            this.f769b = 0.0f;
            this.f770c = 0.0f;
            this.f771d = 0.0f;
            this.f772e = 0.0f;
            this.f773f = 255;
            this.f774g = null;
            this.f775h = new ArrayMap();
            this.f768a = new VGroup(vPathRenderer.f768a, this.f775h);
            this.f776i = new Path(vPathRenderer.f776i);
            this.f777j = new Path(vPathRenderer.f777j);
            this.f769b = vPathRenderer.f769b;
            this.f770c = vPathRenderer.f770c;
            this.f771d = vPathRenderer.f771d;
            this.f772e = vPathRenderer.f772e;
            this.f782p = vPathRenderer.f782p;
            this.f773f = vPathRenderer.f773f;
            this.f774g = vPathRenderer.f774g;
            if (vPathRenderer.f774g != null) {
                this.f775h.put(vPathRenderer.f774g, this);
            }
        }

        private void m384a(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            VPathRenderer vPathRenderer;
            VPathRenderer vPathRenderer2 = this;
            VGroup vGroup2 = vGroup;
            Canvas canvas2 = canvas;
            ColorFilter colorFilter2 = colorFilter;
            vGroup.f762l.set(matrix);
            vGroup.f762l.preConcat(vGroup.f763m);
            canvas.save();
            boolean z = false;
            int i3 = 0;
            while (i3 < vGroup2.f751a.size()) {
                Object obj = vGroup2.f751a.get(i3);
                if (obj instanceof VGroup) {
                    vPathRenderer2.m384a((VGroup) obj, vGroup.f762l, canvas2, i, i2, colorFilter2);
                } else if (obj instanceof VPath) {
                    VPath vPath = (VPath) obj;
                    float f = ((float) i) / vPathRenderer2.f771d;
                    float f2 = ((float) i2) / vPathRenderer2.f772e;
                    float min = Math.min(f, f2);
                    Matrix a = vGroup.f762l;
                    vPathRenderer2.f778l.set(a);
                    vPathRenderer2.f778l.postScale(f, f2);
                    float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                    a.mapVectors(fArr);
                    float f3 = min;
                    float f4 = (fArr[z] * fArr[3]) - (fArr[1] * fArr[2]);
                    f = Math.max((float) Math.hypot((double) fArr[z], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    f = f > 0.0f ? Math.abs(f4) / f : 0.0f;
                    if (f != 0.0f) {
                        vPath.m380a(this.f776i);
                        Path path = this.f776i;
                        this.f777j.reset();
                        if (vPath.mo126a()) {
                            vPathRenderer.f777j.addPath(path, vPathRenderer.f778l);
                            canvas2.clipPath(vPathRenderer.f777j);
                        } else {
                            Paint paint;
                            VFullPath vFullPath = (VFullPath) vPath;
                            if (!(vFullPath.f11194g == 0.0f && vFullPath.f11195h == 1.0f)) {
                                float f5;
                                float f6 = (vFullPath.f11194g + vFullPath.f11196i) % 1.0f;
                                float f7 = (vFullPath.f11195h + vFullPath.f11196i) % 1.0f;
                                if (vPathRenderer.f781o == null) {
                                    vPathRenderer.f781o = new PathMeasure();
                                }
                                vPathRenderer.f781o.setPath(vPathRenderer.f776i, z);
                                f2 = vPathRenderer.f781o.getLength();
                                f6 *= f2;
                                f7 *= f2;
                                path.reset();
                                if (f6 > f7) {
                                    vPathRenderer.f781o.getSegment(f6, f2, path, true);
                                    f5 = 0.0f;
                                    vPathRenderer.f781o.getSegment(0.0f, f7, path, true);
                                } else {
                                    f5 = 0.0f;
                                    vPathRenderer.f781o.getSegment(f6, f7, path, true);
                                }
                                path.rLineTo(f5, f5);
                            }
                            vPathRenderer.f777j.addPath(path, vPathRenderer.f778l);
                            if (vFullPath.f11190c != 0) {
                                if (vPathRenderer.f780n == null) {
                                    vPathRenderer.f780n = new Paint();
                                    vPathRenderer.f780n.setStyle(Style.FILL);
                                    vPathRenderer.f780n.setAntiAlias(true);
                                }
                                paint = vPathRenderer.f780n;
                                paint.setColor(VectorDrawableCompat.m16579a(vFullPath.f11190c, vFullPath.f11193f));
                                paint.setColorFilter(colorFilter2);
                                vPathRenderer.f777j.setFillType(vFullPath.f11192e == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                                canvas2.drawPath(vPathRenderer.f777j, paint);
                            }
                            if (vFullPath.f11188a != 0) {
                                if (vPathRenderer.f779m == null) {
                                    vPathRenderer.f779m = new Paint();
                                    vPathRenderer.f779m.setStyle(Style.STROKE);
                                    vPathRenderer.f779m.setAntiAlias(true);
                                }
                                paint = vPathRenderer.f779m;
                                if (vFullPath.f11198k != null) {
                                    paint.setStrokeJoin(vFullPath.f11198k);
                                }
                                if (vFullPath.f11197j != null) {
                                    paint.setStrokeCap(vFullPath.f11197j);
                                }
                                paint.setStrokeMiter(vFullPath.f11199l);
                                paint.setColor(VectorDrawableCompat.m16579a(vFullPath.f11188a, vFullPath.f11191d));
                                paint.setColorFilter(colorFilter2);
                                paint.setStrokeWidth(vFullPath.f11189b * (f * f3));
                                canvas2.drawPath(vPathRenderer.f777j, paint);
                            }
                        }
                    } else {
                        vPathRenderer = this;
                    }
                    i3++;
                    vPathRenderer2 = vPathRenderer;
                    z = false;
                }
                int i4 = i;
                int i5 = i2;
                vPathRenderer = vPathRenderer2;
                i3++;
                vPathRenderer2 = vPathRenderer;
                z = false;
            }
            vPathRenderer = vPathRenderer2;
            canvas.restore();
        }

        public final void m387a(Canvas canvas, int i, int i2) {
            m384a(this.f768a, f767k, canvas, i, i2, null);
        }
    }

    private static class VectorDrawableCompatState extends ConstantState {
        int f783a;
        VPathRenderer f784b;
        ColorStateList f785c;
        Mode f786d;
        boolean f787e;
        Bitmap f788f;
        ColorStateList f789g;
        Mode f790h;
        int f791i;
        boolean f792j;
        boolean f793k;
        Paint f794l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f785c = null;
            this.f786d = VectorDrawableCompat.f16464a;
            if (vectorDrawableCompatState != null) {
                this.f783a = vectorDrawableCompatState.f783a;
                this.f784b = new VPathRenderer(vectorDrawableCompatState.f784b);
                if (vectorDrawableCompatState.f784b.f780n != null) {
                    this.f784b.f780n = new Paint(vectorDrawableCompatState.f784b.f780n);
                }
                if (vectorDrawableCompatState.f784b.f779m != null) {
                    this.f784b.f779m = new Paint(vectorDrawableCompatState.f784b.f779m);
                }
                this.f785c = vectorDrawableCompatState.f785c;
                this.f786d = vectorDrawableCompatState.f786d;
                this.f787e = vectorDrawableCompatState.f787e;
            }
        }

        public final void m388a(int i, int i2) {
            this.f788f.eraseColor(0);
            this.f784b.m387a(new Canvas(this.f788f), i, i2);
        }

        public VectorDrawableCompatState() {
            this.f785c = null;
            this.f786d = VectorDrawableCompat.f16464a;
            this.f784b = new VPathRenderer();
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public int getChangingConfigurations() {
            return this.f783a;
        }
    }

    @RequiresApi(24)
    private static class VectorDrawableDelegateState extends ConstantState {
        private final ConstantState f795a;

        public VectorDrawableDelegateState(ConstantState constantState) {
            this.f795a = constantState;
        }

        public Drawable newDrawable() {
            Drawable vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.b = (VectorDrawable) this.f795a.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.b = (VectorDrawable) this.f795a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.b = (VectorDrawable) this.f795a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }

        public boolean canApplyTheme() {
            return this.f795a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f795a.getChangingConfigurations();
        }
    }

    private static class VClipPath extends VPath {
        public final boolean mo126a() {
            return true;
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        final void m9645a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            typedArray = typedArray.getString(1);
            if (typedArray != null) {
                this.m = PathParser.m810b(typedArray);
            }
        }
    }

    private static class VFullPath extends VPath {
        int f11188a = 0;
        float f11189b = 0.0f;
        int f11190c = 0;
        float f11191d = 1.0f;
        int f11192e = 0;
        float f11193f = 1.0f;
        float f11194g = 0.0f;
        float f11195h = 1.0f;
        float f11196i = 0.0f;
        Cap f11197j = Cap.BUTT;
        Join f11198k = Join.MITER;
        float f11199l = 4.0f;
        private int[] f11200p;

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.f11200p = vFullPath.f11200p;
            this.f11188a = vFullPath.f11188a;
            this.f11189b = vFullPath.f11189b;
            this.f11191d = vFullPath.f11191d;
            this.f11190c = vFullPath.f11190c;
            this.f11192e = vFullPath.f11192e;
            this.f11193f = vFullPath.f11193f;
            this.f11194g = vFullPath.f11194g;
            this.f11195h = vFullPath.f11195h;
            this.f11196i = vFullPath.f11196i;
            this.f11197j = vFullPath.f11197j;
            this.f11198k = vFullPath.f11198k;
            this.f11199l = vFullPath.f11199l;
        }

        final void m9647a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f11200p = null;
            if (TypedArrayUtils.m785a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = PathParser.m810b(string);
                }
                this.f11190c = TypedArrayUtils.m787b(typedArray, xmlPullParser, "fillColor", 1, this.f11190c);
                this.f11193f = TypedArrayUtils.m775a(typedArray, xmlPullParser, "fillAlpha", 12, this.f11193f);
                int a = TypedArrayUtils.m779a(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                Cap cap = this.f11197j;
                switch (a) {
                    case 0:
                        cap = Cap.BUTT;
                        break;
                    case 1:
                        cap = Cap.ROUND;
                        break;
                    case 2:
                        cap = Cap.SQUARE;
                        break;
                    default:
                        break;
                }
                this.f11197j = cap;
                a = TypedArrayUtils.m779a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                Join join = this.f11198k;
                switch (a) {
                    case 0:
                        join = Join.MITER;
                        break;
                    case 1:
                        join = Join.ROUND;
                        break;
                    case 2:
                        join = Join.BEVEL;
                        break;
                    default:
                        break;
                }
                this.f11198k = join;
                this.f11199l = TypedArrayUtils.m775a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f11199l);
                this.f11188a = TypedArrayUtils.m787b(typedArray, xmlPullParser, "strokeColor", 3, this.f11188a);
                this.f11191d = TypedArrayUtils.m775a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f11191d);
                this.f11189b = TypedArrayUtils.m775a(typedArray, xmlPullParser, "strokeWidth", 4, this.f11189b);
                this.f11195h = TypedArrayUtils.m775a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f11195h);
                this.f11196i = TypedArrayUtils.m775a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f11196i);
                this.f11194g = TypedArrayUtils.m775a(typedArray, xmlPullParser, "trimPathStart", 5, this.f11194g);
                this.f11192e = TypedArrayUtils.m779a(typedArray, xmlPullParser, "fillType", 13, this.f11192e);
            }
        }

        int getStrokeColor() {
            return this.f11188a;
        }

        void setStrokeColor(int i) {
            this.f11188a = i;
        }

        float getStrokeWidth() {
            return this.f11189b;
        }

        void setStrokeWidth(float f) {
            this.f11189b = f;
        }

        float getStrokeAlpha() {
            return this.f11191d;
        }

        void setStrokeAlpha(float f) {
            this.f11191d = f;
        }

        int getFillColor() {
            return this.f11190c;
        }

        void setFillColor(int i) {
            this.f11190c = i;
        }

        float getFillAlpha() {
            return this.f11193f;
        }

        void setFillAlpha(float f) {
            this.f11193f = f;
        }

        float getTrimPathStart() {
            return this.f11194g;
        }

        void setTrimPathStart(float f) {
            this.f11194g = f;
        }

        float getTrimPathEnd() {
            return this.f11195h;
        }

        void setTrimPathEnd(float f) {
            this.f11195h = f;
        }

        float getTrimPathOffset() {
            return this.f11196i;
        }

        void setTrimPathOffset(float f) {
            this.f11196i = f;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    VectorDrawableCompat() {
        this.f16466d = true;
        this.f16471i = new float[9];
        this.f16472j = new Matrix();
        this.f16473k = new Rect();
        this.f16465c = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.f16466d = true;
        this.f16471i = new float[9];
        this.f16472j = new Matrix();
        this.f16473k = new Rect();
        this.f16465c = vectorDrawableCompatState;
        this.f16467e = m16580a(vectorDrawableCompatState.f785c, vectorDrawableCompatState.f786d);
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
            return this;
        }
        if (!this.f16469g && super.mutate() == this) {
            this.f16465c = new VectorDrawableCompatState(this.f16465c);
            this.f16469g = true;
        }
        return this;
    }

    public ConstantState getConstantState() {
        if (this.b != null && VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.b.getConstantState());
        }
        this.f16465c.f783a = getChangingConfigurations();
        return this.f16465c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
        r10 = this;
        r0 = r10.b;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r10.b;
        r0.draw(r11);
        return;
    L_0x000a:
        r0 = r10.f16473k;
        r10.copyBounds(r0);
        r0 = r10.f16473k;
        r0 = r0.width();
        if (r0 <= 0) goto L_0x017a;
    L_0x0017:
        r0 = r10.f16473k;
        r0 = r0.height();
        if (r0 > 0) goto L_0x0021;
    L_0x001f:
        goto L_0x017a;
    L_0x0021:
        r0 = r10.f16468f;
        if (r0 != 0) goto L_0x0028;
    L_0x0025:
        r0 = r10.f16467e;
        goto L_0x002a;
    L_0x0028:
        r0 = r10.f16468f;
    L_0x002a:
        r1 = r10.f16472j;
        r11.getMatrix(r1);
        r1 = r10.f16472j;
        r2 = r10.f16471i;
        r1.getValues(r2);
        r1 = r10.f16471i;
        r2 = 0;
        r1 = r1[r2];
        r1 = java.lang.Math.abs(r1);
        r3 = r10.f16471i;
        r4 = 4;
        r3 = r3[r4];
        r3 = java.lang.Math.abs(r3);
        r4 = r10.f16471i;
        r5 = 1;
        r4 = r4[r5];
        r4 = java.lang.Math.abs(r4);
        r6 = r10.f16471i;
        r7 = 3;
        r6 = r6[r7];
        r6 = java.lang.Math.abs(r6);
        r7 = 0;
        r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1));
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r4 != 0) goto L_0x0065;
    L_0x0061:
        r4 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r4 == 0) goto L_0x0067;
    L_0x0065:
        r1 = r8;
        r3 = r1;
    L_0x0067:
        r4 = r10.f16473k;
        r4 = r4.width();
        r4 = (float) r4;
        r4 = r4 * r1;
        r1 = (int) r4;
        r4 = r10.f16473k;
        r4 = r4.height();
        r4 = (float) r4;
        r4 = r4 * r3;
        r3 = (int) r4;
        r4 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r1 = java.lang.Math.min(r4, r1);
        r3 = java.lang.Math.min(r4, r3);
        if (r1 <= 0) goto L_0x0179;
    L_0x0085:
        if (r3 > 0) goto L_0x0089;
    L_0x0087:
        goto L_0x0179;
    L_0x0089:
        r4 = r11.save();
        r6 = r10.f16473k;
        r6 = r6.left;
        r6 = (float) r6;
        r9 = r10.f16473k;
        r9 = r9.top;
        r9 = (float) r9;
        r11.translate(r6, r9);
        r6 = android.os.Build.VERSION.SDK_INT;
        r9 = 17;
        if (r6 < r9) goto L_0x00ae;
    L_0x00a0:
        r6 = r10.isAutoMirrored();
        if (r6 == 0) goto L_0x00ae;
    L_0x00a6:
        r6 = android.support.v4.graphics.drawable.DrawableCompat.m846i(r10);
        if (r6 != r5) goto L_0x00ae;
    L_0x00ac:
        r6 = r5;
        goto L_0x00af;
    L_0x00ae:
        r6 = r2;
    L_0x00af:
        if (r6 == 0) goto L_0x00c0;
    L_0x00b1:
        r6 = r10.f16473k;
        r6 = r6.width();
        r6 = (float) r6;
        r11.translate(r6, r7);
        r6 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r11.scale(r6, r8);
    L_0x00c0:
        r6 = r10.f16473k;
        r6.offsetTo(r2, r2);
        r6 = r10.f16465c;
        r7 = r6.f788f;
        if (r7 == 0) goto L_0x00e0;
    L_0x00cb:
        r7 = r6.f788f;
        r7 = r7.getWidth();
        if (r1 != r7) goto L_0x00dd;
    L_0x00d3:
        r7 = r6.f788f;
        r7 = r7.getHeight();
        if (r3 != r7) goto L_0x00dd;
    L_0x00db:
        r7 = r5;
        goto L_0x00de;
    L_0x00dd:
        r7 = r2;
    L_0x00de:
        if (r7 != 0) goto L_0x00ea;
    L_0x00e0:
        r7 = android.graphics.Bitmap.Config.ARGB_8888;
        r7 = android.graphics.Bitmap.createBitmap(r1, r3, r7);
        r6.f788f = r7;
        r6.f793k = r5;
    L_0x00ea:
        r6 = r10.f16466d;
        if (r6 != 0) goto L_0x00f4;
    L_0x00ee:
        r6 = r10.f16465c;
        r6.m388a(r1, r3);
        goto L_0x0138;
    L_0x00f4:
        r6 = r10.f16465c;
        r7 = r6.f793k;
        if (r7 != 0) goto L_0x0118;
    L_0x00fa:
        r7 = r6.f789g;
        r8 = r6.f785c;
        if (r7 != r8) goto L_0x0118;
    L_0x0100:
        r7 = r6.f790h;
        r8 = r6.f786d;
        if (r7 != r8) goto L_0x0118;
    L_0x0106:
        r7 = r6.f792j;
        r8 = r6.f787e;
        if (r7 != r8) goto L_0x0118;
    L_0x010c:
        r7 = r6.f791i;
        r6 = r6.f784b;
        r6 = r6.getRootAlpha();
        if (r7 != r6) goto L_0x0118;
    L_0x0116:
        r6 = r5;
        goto L_0x0119;
    L_0x0118:
        r6 = r2;
    L_0x0119:
        if (r6 != 0) goto L_0x0138;
    L_0x011b:
        r6 = r10.f16465c;
        r6.m388a(r1, r3);
        r1 = r10.f16465c;
        r3 = r1.f785c;
        r1.f789g = r3;
        r3 = r1.f786d;
        r1.f790h = r3;
        r3 = r1.f784b;
        r3 = r3.getRootAlpha();
        r1.f791i = r3;
        r3 = r1.f787e;
        r1.f792j = r3;
        r1.f793k = r2;
    L_0x0138:
        r1 = r10.f16465c;
        r3 = r10.f16473k;
        r6 = r1.f784b;
        r6 = r6.getRootAlpha();
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r6 >= r7) goto L_0x0147;
    L_0x0146:
        r2 = r5;
    L_0x0147:
        r6 = 0;
        if (r2 != 0) goto L_0x014e;
    L_0x014a:
        if (r0 != 0) goto L_0x014e;
    L_0x014c:
        r0 = r6;
        goto L_0x0170;
    L_0x014e:
        r2 = r1.f794l;
        if (r2 != 0) goto L_0x015e;
    L_0x0152:
        r2 = new android.graphics.Paint;
        r2.<init>();
        r1.f794l = r2;
        r2 = r1.f794l;
        r2.setFilterBitmap(r5);
    L_0x015e:
        r2 = r1.f794l;
        r5 = r1.f784b;
        r5 = r5.getRootAlpha();
        r2.setAlpha(r5);
        r2 = r1.f794l;
        r2.setColorFilter(r0);
        r0 = r1.f794l;
    L_0x0170:
        r1 = r1.f788f;
        r11.drawBitmap(r1, r6, r3, r0);
        r11.restoreToCount(r4);
        return;
    L_0x0179:
        return;
    L_0x017a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.graphics.drawable.VectorDrawableCompat.draw(android.graphics.Canvas):void");
    }

    public int getAlpha() {
        if (this.b != null) {
            return DrawableCompat.m840c(this.b);
        }
        return this.f16465c.f784b.getRootAlpha();
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
            return;
        }
        if (this.f16465c.f784b.getRootAlpha() != i) {
            this.f16465c.f784b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
            return;
        }
        this.f16468f = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter m16580a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }

    public void setTint(int i) {
        if (this.b != null) {
            DrawableCompat.m831a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            DrawableCompat.m833a(this.b, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f16465c;
        if (vectorDrawableCompatState.f785c != colorStateList) {
            vectorDrawableCompatState.f785c = colorStateList;
            this.f16467e = m16580a(colorStateList, vectorDrawableCompatState.f786d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            DrawableCompat.m836a(this.b, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f16465c;
        if (vectorDrawableCompatState.f786d != mode) {
            vectorDrawableCompatState.f786d = mode;
            this.f16467e = m16580a(vectorDrawableCompatState.f785c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.b != null) {
            return this.b.isStateful();
        }
        if (!super.isStateful()) {
            if (this.f16465c == null || this.f16465c.f785c == null || !this.f16465c.f785c.isStateful()) {
                return false;
            }
        }
        return true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        iArr = this.f16465c;
        if (iArr.f785c == null || iArr.f786d == null) {
            return null;
        }
        this.f16467e = m16580a(iArr.f785c, iArr.f786d);
        invalidateSelf();
        return 1;
    }

    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : -3;
    }

    public int getIntrinsicWidth() {
        if (this.b != null) {
            return this.b.getIntrinsicWidth();
        }
        return (int) this.f16465c.f784b.f769b;
    }

    public int getIntrinsicHeight() {
        if (this.b != null) {
            return this.b.getIntrinsicHeight();
        }
        return (int) this.f16465c.f784b.f770c;
    }

    public boolean canApplyTheme() {
        if (this.b != null) {
            DrawableCompat.m841d(this.b);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.b != null) {
            return DrawableCompat.m838b(this.b);
        }
        return this.f16465c.f787e;
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            DrawableCompat.m837a(this.b, z);
        } else {
            this.f16465c.f787e = z;
        }
    }

    public static VectorDrawableCompat m16581a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.b = ResourcesCompat.m774a(resources, i, theme);
            vectorDrawableCompat.f16470h = new VectorDrawableDelegateState(vectorDrawableCompat.b.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            int next;
            i = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(i);
            do {
                next = i.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return m16582a(resources, i, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Resources resources2) {
            Log.e("VectorDrawableCompat", "parser error", resources2);
            return null;
        } catch (Resources resources22) {
            Log.e("VectorDrawableCompat", "parser error", resources22);
            return null;
        }
    }

    public static VectorDrawableCompat m16582a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    static int m16579a(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.b != null) {
            DrawableCompat.m835a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f16465c;
        vectorDrawableCompatState.f784b = new VPathRenderer();
        TypedArray a = TypedArrayUtils.m780a(resources, theme, attributeSet, AndroidResources.f728a);
        VectorDrawableCompatState vectorDrawableCompatState2 = this.f16465c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState2.f784b;
        int a2 = TypedArrayUtils.m779a(a, xmlPullParser, "tintMode", 6, -1);
        Mode mode = Mode.SRC_IN;
        if (a2 == 3) {
            mode = Mode.SRC_OVER;
        } else if (a2 == 5) {
            mode = Mode.SRC_IN;
        } else if (a2 != 9) {
            switch (a2) {
                case 14:
                    mode = Mode.MULTIPLY;
                    break;
                case 15:
                    mode = Mode.SCREEN;
                    break;
                case 16:
                    if (VERSION.SDK_INT >= 11) {
                        mode = Mode.ADD;
                        break;
                    }
                    break;
                default:
                    break;
            }
        } else {
            mode = Mode.SRC_ATOP;
        }
        vectorDrawableCompatState2.f786d = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            vectorDrawableCompatState2.f785c = colorStateList;
        }
        vectorDrawableCompatState2.f787e = TypedArrayUtils.m784a(a, xmlPullParser, "autoMirrored", vectorDrawableCompatState2.f787e);
        vPathRenderer.f771d = TypedArrayUtils.m775a(a, xmlPullParser, "viewportWidth", 7, vPathRenderer.f771d);
        vPathRenderer.f772e = TypedArrayUtils.m775a(a, xmlPullParser, "viewportHeight", 8, vPathRenderer.f772e);
        if (vPathRenderer.f771d <= 0.0f) {
            xmlPullParser = new StringBuilder();
            xmlPullParser.append(a.getPositionDescription());
            xmlPullParser.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(xmlPullParser.toString());
        } else if (vPathRenderer.f772e <= 0.0f) {
            xmlPullParser = new StringBuilder();
            xmlPullParser.append(a.getPositionDescription());
            xmlPullParser.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(xmlPullParser.toString());
        } else {
            vPathRenderer.f769b = a.getDimension(3, vPathRenderer.f769b);
            vPathRenderer.f770c = a.getDimension(2, vPathRenderer.f770c);
            if (vPathRenderer.f769b <= 0.0f) {
                xmlPullParser = new StringBuilder();
                xmlPullParser.append(a.getPositionDescription());
                xmlPullParser.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(xmlPullParser.toString());
            } else if (vPathRenderer.f770c <= 0.0f) {
                xmlPullParser = new StringBuilder();
                xmlPullParser.append(a.getPositionDescription());
                xmlPullParser.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(xmlPullParser.toString());
            } else {
                vPathRenderer.setAlpha(TypedArrayUtils.m775a(a, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = a.getString(0);
                if (string != null) {
                    vPathRenderer.f774g = string;
                    vPathRenderer.f775h.put(string, vPathRenderer);
                }
                a.recycle();
                vectorDrawableCompatState.f783a = getChangingConfigurations();
                vectorDrawableCompatState.f793k = true;
                m16583b(resources, xmlPullParser, attributeSet, theme);
                this.f16467e = m16580a(vectorDrawableCompatState.f785c, vectorDrawableCompatState.f786d);
            }
        }
    }

    private void m16583b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        Resources resources2 = resources;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AttributeSet attributeSet2 = attributeSet;
        Theme theme2 = theme;
        VectorDrawableCompatState vectorDrawableCompatState = this.f16465c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f784b;
        Stack stack = new Stack();
        stack.push(vPathRenderer.f768a);
        int eventType = xmlPullParser.getEventType();
        int i = 1;
        int depth = xmlPullParser.getDepth() + 1;
        int i2 = 1;
        while (eventType != i && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) stack.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    TypedArray a = TypedArrayUtils.m780a(resources2, theme2, attributeSet2, AndroidResources.f730c);
                    vFullPath.m9647a(a, xmlPullParser2);
                    a.recycle();
                    vGroup.f751a.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.f775h.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.f783a = vFullPath.o | vectorDrawableCompatState.f783a;
                    i2 = 0;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    if (TypedArrayUtils.m785a(xmlPullParser2, "pathData")) {
                        r12 = TypedArrayUtils.m780a(resources2, theme2, attributeSet2, AndroidResources.f731d);
                        vClipPath.m9645a(r12);
                        r12.recycle();
                    }
                    vGroup.f751a.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.f775h.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f783a = vClipPath.o | vectorDrawableCompatState.f783a;
                } else if ("group".equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    r12 = TypedArrayUtils.m780a(resources2, theme2, attributeSet2, AndroidResources.f729b);
                    vGroup2.f760j = null;
                    vGroup2.f752b = TypedArrayUtils.m775a(r12, xmlPullParser2, "rotation", 5, vGroup2.f752b);
                    vGroup2.f753c = r12.getFloat(1, vGroup2.f753c);
                    vGroup2.f754d = r12.getFloat(2, vGroup2.f754d);
                    vGroup2.f755e = TypedArrayUtils.m775a(r12, xmlPullParser2, "scaleX", 3, vGroup2.f755e);
                    vGroup2.f756f = TypedArrayUtils.m775a(r12, xmlPullParser2, "scaleY", 4, vGroup2.f756f);
                    vGroup2.f757g = TypedArrayUtils.m775a(r12, xmlPullParser2, "translateX", 6, vGroup2.f757g);
                    vGroup2.f758h = TypedArrayUtils.m775a(r12, xmlPullParser2, "translateY", 7, vGroup2.f758h);
                    String string = r12.getString(0);
                    if (string != null) {
                        vGroup2.f761k = string;
                    }
                    vGroup2.m379a();
                    r12.recycle();
                    vGroup.f751a.add(vGroup2);
                    stack.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.f775h.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f783a = vGroup2.f759i | vectorDrawableCompatState.f783a;
                }
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
            i = 1;
        }
        if (i2 != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            StringBuilder stringBuilder = new StringBuilder("no ");
            stringBuilder.append(stringBuffer);
            stringBuilder.append(" defined");
            throw new XmlPullParserException(stringBuilder.toString());
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.b != null) {
            return this.b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f16465c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
