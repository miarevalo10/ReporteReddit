package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import org.xmlpull.v1.XmlPullParser;

public class TypedArrayUtils {
    public static boolean m785a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null ? true : null;
    }

    public static float m775a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        if (m785a(xmlPullParser, str) == null) {
            return f;
        }
        return typedArray.getFloat(i, f);
    }

    public static boolean m784a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, boolean z) {
        if (m785a(xmlPullParser, str) == null) {
            return z;
        }
        return typedArray.getBoolean(5, z);
    }

    public static int m779a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (m785a(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    public static int m787b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (m785a(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getColor(i, i2);
    }

    public static int m778a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m785a(xmlPullParser, str) == null) {
            return 0;
        }
        return typedArray.getResourceId(i, 0);
    }

    public static String m788b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m785a(xmlPullParser, str) == null) {
            return null;
        }
        return typedArray.getString(i);
    }

    public static TypedValue m782a(TypedArray typedArray, XmlPullParser xmlPullParser, String str) {
        if (m785a(xmlPullParser, str) == null) {
            return null;
        }
        return typedArray.peekValue(null);
    }

    public static TypedArray m780a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static boolean m783a(TypedArray typedArray, int i, int i2, boolean z) {
        return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
    }

    public static Drawable m781a(TypedArray typedArray, int i, int i2) {
        i = typedArray.getDrawable(i);
        return i == 0 ? typedArray.getDrawable(i2) : i;
    }

    public static int m786b(TypedArray typedArray, int i, int i2) {
        return typedArray.getInt(i, typedArray.getInt(i2, RedditJobManager.f10810d));
    }

    public static int m777a(TypedArray typedArray, int i, int i2, int i3) {
        return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
    }

    public static String m789c(TypedArray typedArray, int i, int i2) {
        i = typedArray.getString(i);
        return i == 0 ? typedArray.getString(i2) : i;
    }

    public static CharSequence m790d(TypedArray typedArray, int i, int i2) {
        i = typedArray.getText(i);
        return i == 0 ? typedArray.getText(i2) : i;
    }

    public static CharSequence[] m791e(TypedArray typedArray, int i, int i2) {
        i = typedArray.getTextArray(i);
        return i == 0 ? typedArray.getTextArray(i2) : i;
    }

    public static int m776a(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != null ? i : i2;
    }
}
