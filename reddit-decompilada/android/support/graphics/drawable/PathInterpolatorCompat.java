package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class PathInterpolatorCompat implements Interpolator {
    private float[] f749a;
    private float[] f750b;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private PathInterpolatorCompat(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = TypedArrayUtils.m780a(resources, theme, attributeSet, AndroidResources.f739l);
        if (TypedArrayUtils.m785a(xmlPullParser, "pathData") != null) {
            String b = TypedArrayUtils.m788b(a, xmlPullParser, "pathData", 4);
            attributeSet = PathParser.m804a(b);
            if (attributeSet == null) {
                attributeSet = new StringBuilder("The path is null, which is created from ");
                attributeSet.append(b);
                throw new InflateException(attributeSet.toString());
            }
            m376a(attributeSet);
        } else if (TypedArrayUtils.m785a(xmlPullParser, "controlX1") == null) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (TypedArrayUtils.m785a(xmlPullParser, "controlY1") == null) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        } else {
            float a2 = TypedArrayUtils.m775a(a, xmlPullParser, "controlX1", (int) null, 0.0f);
            float a3 = TypedArrayUtils.m775a(a, xmlPullParser, "controlY1", 1, 0.0f);
            theme = TypedArrayUtils.m785a(xmlPullParser, "controlX2");
            if (theme != TypedArrayUtils.m785a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (theme == null) {
                theme = new Path();
                theme.moveTo(0.0f, 0.0f);
                theme.quadTo(a2, a3, 1.0f, 1.0f);
                m376a(theme);
            } else {
                float a4 = TypedArrayUtils.m775a(a, xmlPullParser, "controlX2", 2, 0.0f);
                float a5 = TypedArrayUtils.m775a(a, xmlPullParser, "controlY2", 3, 0.0f);
                theme = new Path();
                theme.moveTo(0.0f, 0.0f);
                theme.cubicTo(a2, a3, a4, a5, 1.0f, 1.0f);
                m376a(theme);
            }
        }
        a.recycle();
    }

    private void m376a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        path = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (path / 0.002f)) + 1);
        if (min <= 0) {
            StringBuilder stringBuilder = new StringBuilder("The Path has a invalid length ");
            stringBuilder.append(path);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i2;
        this.f749a = new float[min];
        this.f750b = new float[min];
        float[] fArr = new float[2];
        for (i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((((float) i2) * path) / ((float) (min - 1)), fArr, null);
            this.f749a[i2] = fArr[0];
            this.f750b[i2] = fArr[1];
        }
        if (((double) Math.abs(this.f749a[0])) <= 1.0E-5d && ((double) Math.abs(this.f750b[0])) <= 1.0E-5d) {
            int i3 = min - 1;
            if (((double) Math.abs(this.f749a[i3] - 1065353216)) <= 1.0E-5d) {
                if (((double) Math.abs(this.f750b[i3] - 1065353216)) <= 1.0E-5d) {
                    float f = null;
                    path = null;
                    while (i < min) {
                        i2 = path + 1;
                        path = this.f749a[path];
                        if (path < f) {
                            stringBuilder = new StringBuilder("The Path cannot loop back on itself, x :");
                            stringBuilder.append(path);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        this.f749a[i] = path;
                        i++;
                        f = path;
                        path = i2;
                    }
                    if (pathMeasure.nextContour() != null) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
        stringBuilder2.append(this.f749a[0]);
        stringBuilder2.append(",");
        stringBuilder2.append(this.f750b[0]);
        stringBuilder2.append(" end:");
        min--;
        stringBuilder2.append(this.f749a[min]);
        stringBuilder2.append(",");
        stringBuilder2.append(this.f750b[min]);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f749a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f749a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f749a[length] - this.f749a[i];
        if (f2 == 0.0f) {
            return this.f750b[i];
        }
        f = (f - this.f749a[i]) / f2;
        float f3 = this.f750b[i];
        return f3 + (f * (this.f750b[length] - f3));
    }
}
