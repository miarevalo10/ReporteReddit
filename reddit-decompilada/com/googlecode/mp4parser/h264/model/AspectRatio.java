package com.googlecode.mp4parser.h264.model;

public class AspectRatio {
    public static final AspectRatio f8998a = new AspectRatio(255);
    private int f8999b;

    private AspectRatio(int i) {
        this.f8999b = i;
    }

    public static AspectRatio m7698a(int i) {
        if (i == f8998a.f8999b) {
            return f8998a;
        }
        return new AspectRatio(i);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AspectRatio{");
        stringBuilder.append("value=");
        stringBuilder.append(this.f8999b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
