package com.googlecode.mp4parser.util;

import android.util.Log;

public class AndroidLogger extends Logger {
    String f15297a;

    public AndroidLogger(String str) {
        this.f15297a = str;
    }

    public final void mo2531a(String str) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.f15297a));
        stringBuilder.append(":");
        stringBuilder.append(str);
        Log.d("isoparser", stringBuilder.toString());
    }

    public final void mo2532b(String str) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.f15297a));
        stringBuilder.append(":");
        stringBuilder.append(str);
        Log.w("isoparser", stringBuilder.toString());
    }

    public final void mo2533c(String str) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.f15297a));
        stringBuilder.append(":");
        stringBuilder.append(str);
        Log.e("isoparser", stringBuilder.toString());
    }
}
