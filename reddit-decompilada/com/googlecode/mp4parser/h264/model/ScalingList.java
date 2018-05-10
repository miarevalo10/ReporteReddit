package com.googlecode.mp4parser.h264.model;

import com.googlecode.mp4parser.h264.read.CAVLCReader;
import java.io.IOException;

public class ScalingList {
    public int[] f9021a;
    public boolean f9022b;

    public static ScalingList m7700a(CAVLCReader cAVLCReader, int i) throws IOException {
        ScalingList scalingList = new ScalingList();
        scalingList.f9021a = new int[i];
        int i2 = 8;
        int i3 = i2;
        int i4 = 0;
        while (i4 < i) {
            if (i2 != 0) {
                i2 = ((cAVLCReader.m15199b("deltaScale") + i3) + 256) % 256;
                boolean z = i4 == 0 && i2 == 0;
                scalingList.f9022b = z;
            }
            int[] iArr = scalingList.f9021a;
            if (i2 != 0) {
                i3 = i2;
            }
            iArr[i4] = i3;
            i3 = scalingList.f9021a[i4];
            i4++;
        }
        return scalingList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ScalingList{scalingList=");
        stringBuilder.append(this.f9021a);
        stringBuilder.append(", useDefaultScalingMatrixFlag=");
        stringBuilder.append(this.f9022b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
