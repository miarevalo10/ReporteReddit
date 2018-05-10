package org.jcodec.codecs.raw;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

public class V210Encoder {
    public ByteBuffer encodeFrame(ByteBuffer byteBuffer, Picture picture) throws IOException {
        Picture picture2 = picture;
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        int i = 0;
        int planeWidth = ((picture2.getPlaneWidth(0) + 47) / 48) * 48;
        int[][] data = picture.getData();
        Object obj = new int[planeWidth];
        int i2 = planeWidth >> 1;
        Object obj2 = new int[i2];
        Object obj3 = new int[i2];
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        int i6 = i5;
        while (i3 < picture.getHeight()) {
            System.arraycopy(data[i], i4, obj, i, picture2.getPlaneWidth(i));
            System.arraycopy(data[1], i5, obj2, i, picture2.getPlaneWidth(1));
            System.arraycopy(data[2], i6, obj3, i, picture2.getPlaneWidth(2));
            int i7 = i;
            int i8 = i7;
            int i9 = i8;
            while (i7 < planeWidth) {
                int i10 = i8 + 1;
                int i11 = i7 + 1;
                i7 = (clip(obj[i7]) << 10) | ((clip(obj3[i8]) << 20) | i);
                i8 = i9 + 1;
                duplicate.putInt(clip(obj2[i9]) | i7);
                int i12 = i11 + 1;
                i9 = i12 + 1;
                i12 = (clip(obj[i12]) << 20) | (clip(obj[i11]) | i);
                i7 = i8 + 1;
                duplicate.putInt(i12 | (clip(obj2[i8]) << 10));
                i12 = i7 + 1;
                i8 = i9 + 1;
                int clip = (clip(obj[i9]) << 10) | ((clip(obj2[i7]) << 20) | i);
                i7 = i10 + 1;
                duplicate.putInt(clip(obj3[i10]) | clip);
                i = i8 + 1;
                clip = clip(obj[i8]) | 0;
                i8 = i + 1;
                i = (clip(obj[i]) << 20) | clip;
                clip = i7 + 1;
                duplicate.putInt(i | (clip(obj3[i7]) << 10));
                i9 = i12;
                i7 = i8;
                i = 0;
                i8 = clip;
            }
            i4 += picture2.getPlaneWidth(i);
            i5 += picture2.getPlaneWidth(1);
            i6 += picture2.getPlaneWidth(2);
            i3++;
        }
        duplicate.flip();
        return duplicate;
    }

    static final int clip(int i) {
        return MathUtil.clip(i, 8, 1019);
    }
}
