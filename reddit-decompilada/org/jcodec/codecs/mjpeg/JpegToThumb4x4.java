package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;
import org.jcodec.common.dct.IDCT4x4;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

public class JpegToThumb4x4 extends JpegDecoder {
    private static final int[] mapping4x4 = new int[]{0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 16, 13, 10, 7, 16, 16, 16, 11, 14, 16, 16, 16, 16, 16, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16};

    public JpegToThumb4x4(boolean z, boolean z2) {
        super(z, z2);
    }

    void decodeBlock(BitReader bitReader, int[] iArr, int[][] iArr2, VLC[] vlcArr, Picture picture, int[] iArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        BitReader bitReader2 = bitReader;
        Picture picture2 = picture;
        int[] iArr4 = iArr3;
        int i7 = i3;
        iArr4[15] = 0;
        iArr4[14] = 0;
        iArr4[13] = 0;
        iArr4[12] = 0;
        iArr4[11] = 0;
        iArr4[10] = 0;
        iArr4[9] = 0;
        iArr4[8] = 0;
        iArr4[7] = 0;
        iArr4[6] = 0;
        iArr4[5] = 0;
        iArr4[4] = 0;
        iArr4[3] = 0;
        iArr4[2] = 0;
        iArr4[1] = 0;
        int readDCValue = (readDCValue(bitReader2, vlcArr[i4]) * iArr2[i4][0]) + iArr[i7];
        iArr4[0] = readDCValue;
        iArr[i7] = readDCValue;
        readACValues(bitReader2, iArr4, vlcArr[i4 + 2], iArr2[i4]);
        IDCT4x4.idct(iArr4, 0);
        putBlock4x4(picture2.getPlaneData(i7), picture2.getPlaneWidth(i7), iArr4, i, i2, i5, i6);
    }

    private void putBlock4x4(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5) {
        i >>= 1;
        i5 *= i;
        i4 = ((i4 * i) + ((i3 >> 1) * i5)) + (i2 >> 1);
        for (i2 = 0; i2 < 16; i2 += 4) {
            iArr[i4] = MathUtil.clip(iArr2[i2], 0, 255);
            iArr[i4 + 1] = MathUtil.clip(iArr2[i2 + 1], 0, 255);
            iArr[i4 + 2] = MathUtil.clip(iArr2[i2 + 2], 0, 255);
            iArr[i4 + 3] = MathUtil.clip(iArr2[i2 + 3], 0, 255);
            i4 += i5;
        }
    }

    void readACValues(BitReader bitReader, int[] iArr, VLC vlc, int[] iArr2) {
        int i = 1;
        do {
            int readVLC16 = vlc.readVLC16(bitReader);
            if (readVLC16 == 240) {
                i += 16;
            } else if (readVLC16 > 0) {
                i += readVLC16 >> 4;
                int i2 = readVLC16 & 15;
                iArr[mapping4x4[i]] = JpegDecoder.toValue(bitReader.readNBit(i2), i2) * iArr2[i];
                i++;
            }
            if (readVLC16 == 0) {
                break;
            }
        } while (i < 19);
        if (readVLC16 != 0) {
            do {
                iArr = vlc.readVLC16(bitReader);
                if (iArr == 240) {
                    i += 16;
                } else if (iArr > null) {
                    i += iArr >> 4;
                    bitReader.skip(iArr & 15);
                    i++;
                }
                if (iArr == null) {
                    return;
                }
            } while (i < 64);
        }
    }

    public Picture decodeField(ByteBuffer byteBuffer, int[][] iArr, int i, int i2) {
        byteBuffer = super.decodeField(byteBuffer, iArr, i, i2);
        return new Picture(byteBuffer.getWidth() >> 1, byteBuffer.getHeight() >> 1, byteBuffer.getData(), byteBuffer.getColor(), new Rect(0, 0, byteBuffer.getCroppedWidth() >> 1, byteBuffer.getCroppedHeight() >> 1));
    }
}
