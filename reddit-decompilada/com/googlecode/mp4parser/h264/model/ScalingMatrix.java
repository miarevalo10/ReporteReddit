package com.googlecode.mp4parser.h264.model;

import java.util.Arrays;

public class ScalingMatrix {
    public ScalingList[] f9023a;
    public ScalingList[] f9024b;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ScalingMatrix{ScalingList4x4=");
        Object obj = null;
        stringBuilder.append(this.f9023a == null ? null : Arrays.asList(this.f9023a));
        stringBuilder.append("\n, ScalingList8x8=");
        if (this.f9024b != null) {
            obj = Arrays.asList(this.f9024b);
        }
        stringBuilder.append(obj);
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}
