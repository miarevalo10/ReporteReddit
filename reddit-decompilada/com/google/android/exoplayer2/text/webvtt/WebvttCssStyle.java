package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import java.util.Collections;
import java.util.List;

final class WebvttCssStyle {
    String f5084a = "";
    String f5085b = "";
    List<String> f5086c = Collections.emptyList();
    String f5087d = "";
    String f5088e = null;
    int f5089f;
    boolean f5090g = false;
    int f5091h;
    boolean f5092i = false;
    int f5093j = -1;
    int f5094k = -1;
    int f5095l = -1;
    int f5096m = -1;
    int f5097n = -1;
    float f5098o;
    Alignment f5099p = null;

    public final int m4102a() {
        if (this.f5095l == -1 && this.f5096m == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.f5095l == 1 ? 1 : 0;
        if (this.f5096m == 1) {
            i = 2;
        }
        return i2 | i;
    }

    static int m4101a(int i, String str, String str2, int i2) {
        if (!str.isEmpty()) {
            if (i != -1) {
                if (str.equals(str2) != null) {
                    return i + i2;
                }
                return -1;
            }
        }
        return i;
    }
}
