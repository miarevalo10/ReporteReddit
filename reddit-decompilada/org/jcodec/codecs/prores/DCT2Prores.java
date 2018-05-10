package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresEncoder.Profile;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public class DCT2Prores extends ProresEncoder {
    public DCT2Prores(Profile profile) {
        super(profile);
    }

    protected int encodeSlice(ByteBuffer byteBuffer, int[][] iArr, int[][] iArr2, int[] iArr3, int i, int i2, int i3, Picture picture, int i4, int i5, int i6, boolean z) {
        int[] iArr4;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i4;
        Picture sliceData = sliceData(picture, i2, i3, i5, i);
        int i8 = (i >> 2) * this.profile.bitrate;
        int i9 = i8 >> 3;
        int i10 = i8 - i9;
        i8 += i9;
        byteBuffer2.put((byte) 48);
        byteBuffer2.put((byte) i7);
        ByteBuffer duplicate = byteBuffer.duplicate();
        byteBuffer2.putInt(0);
        int position = byteBuffer.position();
        int[] iArr5 = new int[3];
        int i11 = i7 - 1;
        int i12 = position;
        position = i7;
        ByteBuffer byteBuffer3 = duplicate;
        i9 = i7;
        int[] iArr6 = iArr5;
        ProresEncoder.encodeSliceData(byteBuffer2, iArr[i11], iArr2[i11], iArr3, i, sliceData, position, iArr6);
        if (ProresEncoder.bits(iArr6) <= i8 || i9 >= r6.profile.lastQp) {
            iArr4 = iArr6;
            if (ProresEncoder.bits(iArr4) < i10 && i9 > r6.profile.firstQp) {
                do {
                    i9--;
                    byteBuffer2.position(i12);
                    i11 = i9 - 1;
                    ProresEncoder.encodeSliceData(byteBuffer2, iArr[i11], iArr2[i11], iArr3, i, sliceData, i9, iArr4);
                    if (ProresEncoder.bits(iArr4) >= i10) {
                        break;
                    }
                } while (i9 > r6.profile.firstQp);
            }
        } else {
            int[] iArr7;
            while (true) {
                i9++;
                byteBuffer2.position(i12);
                i10 = i9 - 1;
                iArr7 = iArr6;
                ProresEncoder.encodeSliceData(byteBuffer2, iArr[i10], iArr2[i10], iArr3, i, sliceData, i9, iArr6);
                if (ProresEncoder.bits(iArr7) <= i8) {
                    break;
                } else if (i9 >= r6.profile.lastQp) {
                    break;
                } else {
                    iArr6 = iArr7;
                }
            }
            iArr4 = iArr7;
        }
        ByteBuffer byteBuffer4 = byteBuffer3;
        byteBuffer4.putShort((short) iArr4[0]);
        byteBuffer4.putShort((short) iArr4[1]);
        return i9;
    }

    private Picture sliceData(Picture picture, int i, int i2, int i3, int i4) {
        i4 = Picture.create(i4 << 4, 16, ColorSpace.YUV422_10);
        int[][] data = i4.getData();
        picture = picture.getData();
        i2 = (i2 * i3) + i;
        System.arraycopy(picture[0], i2 << 8, data[0], 0, data[0].length);
        i2 <<= 7;
        System.arraycopy(picture[1], i2, data[1], 0, data[1].length);
        System.arraycopy(picture[2], i2, data[2], 0, data[2].length);
        return i4;
    }
}
