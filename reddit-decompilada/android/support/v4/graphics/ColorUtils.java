package android.support.v4.graphics;

import android.graphics.Color;

public final class ColorUtils {
    private static final ThreadLocal<double[]> f1239a = new ThreadLocal();

    private static float m792a(float f, float f2) {
        return f < 0.0f ? 0.0f : f > f2 ? f2 : f;
    }

    private static int m793a(int i) {
        return i < 0 ? 0 : i > 255 ? 255 : i;
    }

    public static int m794a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - (((255 - alpha) * (255 - alpha2)) / 255);
        return Color.argb(i3, m795a(Color.red(i), alpha2, Color.red(i2), alpha, i3), m795a(Color.green(i), alpha2, Color.green(i2), alpha, i3), m795a(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    private static int m795a(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? 0 : (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static void m797a(int i, float[] fArr) {
        float red = ((float) Color.red(i)) / 255.0f;
        float green = ((float) Color.green(i)) / 255.0f;
        i = ((float) Color.blue(i)) / 1132396544;
        float max = Math.max(red, Math.max(green, i));
        float min = Math.min(red, Math.min(green, i));
        float f = max - min;
        float f2 = (max + min) / 2.0f;
        if (max == min) {
            i = 0;
            red = i;
        } else {
            i = max == red ? ((green - i) / f) % 1086324736 : max == green ? ((i - red) / f) + 1073741824 : ((red - green) / f) + 1082130432;
            red = f / (1.0f - Math.abs((2.0f * f2) - 1.0f));
        }
        float f3 = (i * 1114636288) % 1135869952;
        if (f3 < 0) {
            f3 += 1135869952;
        }
        fArr[0] = m792a(f3, 360.0f);
        fArr[1] = m792a(red, 1.0f);
        fArr[2] = m792a(f2, 1.0f);
    }

    public static int m796a(float[] fArr) {
        int round;
        int round2;
        int i = 0;
        float f = fArr[0];
        float f2 = fArr[1];
        fArr = fArr[2];
        float abs = (1.0f - Math.abs((2.0f * fArr) - 1.0f)) * f2;
        fArr -= 0.5f * abs;
        float abs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f) / 60) {
            case 0:
                i = Math.round((abs + fArr) * 255.0f);
                round = Math.round((abs2 + fArr) * 255.0f);
                round2 = Math.round(255.0f * fArr);
                break;
            case 1:
                i = Math.round((abs2 + fArr) * 255.0f);
                round = Math.round((abs + fArr) * 255.0f);
                round2 = Math.round(255.0f * fArr);
                break;
            case 2:
                i = Math.round(255.0f * fArr);
                round = Math.round((abs + fArr) * 255.0f);
                round2 = Math.round(255.0f * (abs2 + fArr));
                break;
            case 3:
                i = Math.round(255.0f * fArr);
                round = Math.round((abs2 + fArr) * 255.0f);
                round2 = Math.round(255.0f * (abs + fArr));
                break;
            case 4:
                i = Math.round((abs2 + fArr) * 255.0f);
                round = Math.round(255.0f * fArr);
                round2 = Math.round(255.0f * (abs + fArr));
                break;
            case 5:
            case 6:
                i = Math.round((abs + fArr) * 255.0f);
                round = Math.round(255.0f * fArr);
                round2 = Math.round(255.0f * (abs2 + fArr));
                break;
            default:
                round2 = null;
                round = round2;
                break;
        }
        return Color.rgb(m793a(i), m793a(round), m793a(round2));
    }

    public static int m798b(int i, int i2) {
        if (i2 >= 0) {
            if (i2 <= 255) {
                return (i & 16777215) | (i2 << 24);
            }
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
