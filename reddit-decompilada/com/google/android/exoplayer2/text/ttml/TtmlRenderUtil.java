package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

final class TtmlRenderUtil {
    public static TtmlStyle m4087a(TtmlStyle ttmlStyle, String[] strArr, Map<String, TtmlStyle> map) {
        if (ttmlStyle == null && strArr == null) {
            return null;
        }
        int i = 0;
        if (ttmlStyle == null && strArr.length == 1) {
            return (TtmlStyle) map.get(strArr[0]);
        }
        int length;
        if (ttmlStyle == null && strArr.length > 1) {
            ttmlStyle = new TtmlStyle();
            length = strArr.length;
            while (i < length) {
                ttmlStyle.m4093a((TtmlStyle) map.get(strArr[i]));
                i++;
            }
            return ttmlStyle;
        } else if (ttmlStyle != null && strArr != null && strArr.length == 1) {
            return ttmlStyle.m4093a((TtmlStyle) map.get(strArr[0]));
        } else {
            if (ttmlStyle == null || strArr == null || strArr.length <= 1) {
                return ttmlStyle;
            }
            length = strArr.length;
            while (i < length) {
                ttmlStyle.m4093a((TtmlStyle) map.get(strArr[i]));
                i++;
            }
            return ttmlStyle;
        }
    }

    public static void m4090a(SpannableStringBuilder spannableStringBuilder, int i, int i2, TtmlStyle ttmlStyle) {
        if (ttmlStyle.m4091a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(ttmlStyle.m4091a()), i, i2, 33);
        }
        boolean z = false;
        if (ttmlStyle.f5072f == 1) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (ttmlStyle.f5073g == 1) {
            z = true;
        }
        if (z) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (ttmlStyle.f5069c) {
            if (ttmlStyle.f5069c) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ttmlStyle.f5068b), i, i2, 33);
            } else {
                throw new IllegalStateException("Font color has not been defined.");
            }
        }
        if (ttmlStyle.f5071e) {
            if (ttmlStyle.f5071e) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(ttmlStyle.f5070d), i, i2, 33);
            } else {
                throw new IllegalStateException("Background color has not been defined.");
            }
        }
        if (ttmlStyle.f5067a != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(ttmlStyle.f5067a), i, i2, 33);
        }
        if (ttmlStyle.f5080n != null) {
            spannableStringBuilder.setSpan(new Standard(ttmlStyle.f5080n), i, i2, 33);
        }
        switch (ttmlStyle.f5076j) {
            case 1:
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) ttmlStyle.f5077k, true), i, i2, 33);
                return;
            case 2:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.f5077k), i, i2, 33);
                return;
            case 3:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.f5077k / 100.0f), i, i2, 33);
                break;
            default:
                break;
        }
    }

    static void m4089a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    static String m4088a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }
}
