package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.mpeg12.bitstream.GOPHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.codecs.prores.ProresEncoder.Profile;
import org.jcodec.common.dct.DCTRef;
import org.jcodec.common.dct.SimpleIDCT10Bit;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

public class Mpeg2Prores extends MPEGDecoder {
    private DCT2Prores dct2Prores;

    public Mpeg2Prores(SequenceHeader sequenceHeader, GOPHeader gOPHeader, Profile profile) {
        super(sequenceHeader, gOPHeader);
        this.dct2Prores = new DCT2Prores(profile);
    }

    protected void idctPut(int[] iArr, int[][] iArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        i5 = (i5 * (i >> 4)) + i4;
        if (i3 < 4) {
            i = i5 << 8;
            i2 = i3 << 6;
        } else {
            i = i5 << (5 + i2);
            i2 = ((i3 - 4) >> 1) << 6;
        }
        System.arraycopy(iArr, 0, iArr2[MPEGConst.BLOCK_TO_CC[i3]], i + i2, 64);
        iArr2[3][i5] = i6;
    }

    public ByteBuffer transcode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer2 = byteBuffer2.slice();
        int i = (this.sh.horizontal_size + 15) & -16;
        int i2 = (this.sh.vertical_size + 15) & -16;
        r3 = new int[4][];
        int i3 = i * i2;
        r3[0] = new int[i3];
        r3[1] = new int[i3];
        r3[2] = new int[i3];
        r3[3] = new int[((i >> 4) * (i2 >> 4))];
        if (convert(decodeFrame(byteBuffer, r3)).length == 1) {
            this.dct2Prores.encodeFrame(byteBuffer2, byteBuffer[0]);
        } else {
            this.dct2Prores.encodeFrame(byteBuffer2, byteBuffer[0], byteBuffer[1]);
        }
        byteBuffer2.flip();
        return byteBuffer2;
    }

    private Picture[] convert(Picture picture) {
        int[] planeData = picture.getPlaneData(3);
        int i = 0;
        int i2 = i;
        while (i < planeData.length) {
            i2 += planeData[i];
            i++;
        }
        if (i2 == 0) {
            upShift(picture);
            return new Picture[]{colorCvt(picture)};
        }
        picture = interlaced(picture);
        return new Picture[]{colorCvt(picture[0]), colorCvt(picture[1])};
    }

    private void upShift(Picture picture) {
        for (int[] iArr : picture.getData()) {
            upShift(iArr, 0, iArr.length);
        }
    }

    private Picture[] interlaced(Picture picture) {
        Picture picture2 = picture;
        int width = (picture.getWidth() + 15) >> 4;
        int height = (picture.getHeight() + 15) >> 4;
        Picture create = Picture.create(picture.getWidth(), picture.getHeight() >> 1, picture.getColor());
        Picture create2 = Picture.create(picture.getWidth(), picture.getHeight() >> 1, picture.getColor());
        int i = width;
        int i2 = height;
        splitY(i, i2, picture2.getPlaneData(0), create.getPlaneData(0), create2.getPlaneData(0), picture2.getPlaneData(3));
        splitCbCr(i, i2, picture2.getPlaneData(1), create.getPlaneData(1), create2.getPlaneData(1), picture2.getPlaneData(3));
        splitCbCr(i, i2, picture2.getPlaneData(2), create.getPlaneData(2), create2.getPlaneData(2), picture2.getPlaneData(3));
        return new Picture[]{create, create2};
    }

    private final void splitY(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i3 = i;
        int[] iArr5 = iArr;
        int[] iArr6 = iArr2;
        int[] iArr7 = iArr3;
        int i4 = i2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i8 < i4) {
            int i9;
            int i10 = i5;
            int i11 = i6;
            int i12 = i7;
            int i13 = 0;
            while (i13 < i3) {
                int i14;
                int[] iArr8;
                if (iArr4[i12] == 0) {
                    SimpleIDCT10Bit.idct10(iArr5, i11);
                    i14 = i11 + 64;
                    SimpleIDCT10Bit.idct10(iArr5, i14);
                    int i15 = i11 + 128;
                    SimpleIDCT10Bit.idct10(iArr5, i15);
                    i7 = i11 + JpegConst.SOF0;
                    SimpleIDCT10Bit.idct10(iArr5, i7);
                    iArr8 = iArr5;
                    int i16 = i7;
                    int i17 = i14;
                    int[] iArr9 = iArr6;
                    int i18 = i11;
                    i11 = i10;
                    deinterleave(iArr8, i11, i15, iArr9, iArr7, i11);
                    int i19 = i11 + 64;
                    i9 = i11;
                    deinterleave(iArr8, i17, i16, iArr9, iArr7, i19);
                    DCTRef.fdct(iArr6, i9);
                    i10 = i19;
                    DCTRef.fdct(iArr6, i10);
                    DCTRef.fdct(iArr7, i9);
                    DCTRef.fdct(iArr7, i10);
                    i11 = i18;
                } else {
                    i9 = i10;
                    iArr8 = iArr5;
                    i14 = i9;
                    copyShift(iArr8, i11, iArr6, i14, 128);
                    copyShift(iArr8, i11 + 128, iArr7, i14, 128);
                }
                i13++;
                i12++;
                i10 = i9 + 256;
                i11 += 256;
            }
            i9 = i10;
            i5 = (i8 & 1) == 0 ? i9 - ((i3 << 8) - 128) : i9 - 128;
            i8++;
            i6 = i11;
            i7 = i12;
        }
    }

    private final void copyShift(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i + 1;
            int i6 = i2 + 1;
            iArr[i] = iArr2[i2] << 2;
            i4++;
            i = i5;
            i2 = i6;
        }
    }

    private final void splitCbCr(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i3 = i;
        int[] iArr5 = iArr;
        int i4 = i2;
        int i5 = 0;
        int i6 = i5;
        int i7 = i6;
        int i8 = i7;
        while (i8 < i4) {
            int i9 = i5;
            int i10 = i6;
            int i11 = i7;
            int i12 = 0;
            while (i12 < i3) {
                int[] iArr6;
                if (iArr4[i11] == 0) {
                    SimpleIDCT10Bit.idct10(iArr5, i10);
                    int i13 = i10 + 64;
                    SimpleIDCT10Bit.idct10(iArr5, i13);
                    iArr6 = iArr3;
                    deinterleave(iArr5, i10, i13, iArr2, iArr6, i9);
                    DCTRef.fdct(iArr2, i9);
                    DCTRef.fdct(iArr6, i9);
                } else {
                    iArr6 = iArr3;
                    int[] iArr7 = iArr5;
                    int i14 = i9;
                    copyShift(iArr7, i10, iArr2, i14, 64);
                    copyShift(iArr7, i10 + 64, iArr3, i14, 64);
                }
                i12++;
                i11++;
                i9 += 128;
                i10 += 128;
            }
            int[] iArr8 = iArr2;
            i5 = (i8 & 1) == 0 ? i9 - ((i3 << 7) - 64) : i9 - 64;
            i8++;
            i7 = i11;
            i6 = i10;
        }
    }

    private void deinterleave(int[] iArr, int i, int i2, int[] iArr2, int[] iArr3, int i3) {
        int i4 = i3 + 0;
        copyLine(iArr, iArr2, i + 0, i4);
        int i5 = i3 + 8;
        copyLine(iArr, iArr2, i + 16, i5);
        int i6 = i3 + 16;
        copyLine(iArr, iArr2, i + 32, i6);
        int i7 = i3 + 24;
        copyLine(iArr, iArr2, i + 48, i7);
        int i8 = i3 + 32;
        copyLine(iArr, iArr2, i2 + 0, i8);
        int i9 = i3 + 40;
        copyLine(iArr, iArr2, i2 + 16, i9);
        int i10 = i3 + 48;
        copyLine(iArr, iArr2, i2 + 32, i10);
        i3 += 56;
        copyLine(iArr, iArr2, i2 + 48, i3);
        copyLine(iArr, iArr3, i + 8, i4);
        copyLine(iArr, iArr3, i + 24, i5);
        copyLine(iArr, iArr3, i + 40, i6);
        copyLine(iArr, iArr3, i + 56, i7);
        copyLine(iArr, iArr3, i2 + 8, i8);
        copyLine(iArr, iArr3, i2 + 24, i9);
        copyLine(iArr, iArr3, i2 + 40, i10);
        copyLine(iArr, iArr3, i2 + 56, i3);
    }

    private Picture progressive(Picture picture) {
        progressiveY(picture.getPlaneData(0), picture.getPlaneData(3));
        progressiveCbCr(picture.getPlaneData(0), picture.getPlaneData(3));
        progressiveCbCr(picture.getPlaneData(0), picture.getPlaneData(3));
        return picture;
    }

    private void progressiveY(int[] iArr, int[] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (iArr2[i] == 1) {
                int i2 = i << 8;
                int i3 = i2 + 0;
                SimpleIDCT10Bit.idct10(iArr, i3);
                int i4 = i2 + 64;
                SimpleIDCT10Bit.idct10(iArr, i4);
                int i5 = i2 + 128;
                SimpleIDCT10Bit.idct10(iArr, i5);
                i2 += JpegConst.SOF0;
                SimpleIDCT10Bit.idct10(iArr, i2);
                interleave(iArr, i3, i5);
                interleave(iArr, i4, i2);
                DCTRef.fdct(iArr, i3);
                DCTRef.fdct(iArr, i4);
                DCTRef.fdct(iArr, i5);
                DCTRef.fdct(iArr, i2);
            } else {
                upShift(iArr, i << 8, 256);
            }
        }
    }

    private void upShift(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i + 1;
            iArr[i] = iArr[i] << 2;
            i3++;
            i = i4;
        }
    }

    private void progressiveCbCr(int[] iArr, int[] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (iArr2[i] == 1) {
                int i2 = i << 7;
                int i3 = i2 + 0;
                SimpleIDCT10Bit.idct10(iArr, i3);
                i2 += 64;
                SimpleIDCT10Bit.idct10(iArr, i2);
                interleave(iArr, i3, i2);
                DCTRef.fdct(iArr, i3);
                DCTRef.fdct(iArr, i2);
            } else {
                upShift(iArr, i << 7, 128);
            }
        }
    }

    private void interleave(int[] iArr, int i, int i2) {
        int i3;
        int[] iArr2 = new int[64];
        for (i3 = 0; i3 < 64; i3++) {
            iArr2[i3] = iArr[i2 + i3];
        }
        int i4 = i + 56;
        copyLine(iArr, iArr, i4, i2 + 48);
        i3 = i + 48;
        copyLine(iArr, iArr, i3, i2 + 32);
        int i5 = i + 40;
        copyLine(iArr, iArr, i5, i2 + 16);
        int i6 = i + 32;
        copyLine(iArr, iArr, i6, i2);
        int i7 = i + 24;
        copyLine(iArr, iArr, i7, i3);
        i3 = i + 16;
        copyLine(iArr, iArr, i3, i6);
        i += 8;
        copyLine(iArr, iArr, i, i3);
        copyLine(iArr2, iArr, 0, i);
        copyLine(iArr2, iArr, 8, i7);
        copyLine(iArr2, iArr, 16, i5);
        copyLine(iArr2, iArr, 24, i4);
        copyLine(iArr2, iArr, 32, i2 + 8);
        copyLine(iArr2, iArr, 40, i2 + 24);
        copyLine(iArr2, iArr, 48, i2 + 40);
    }

    private final void copyLine(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i2 + 1;
            int i5 = i + 1;
            iArr2[i2] = iArr[i];
            i3++;
            i2 = i4;
            i = i5;
        }
    }

    private Picture colorCvt(Picture picture) {
        if (picture.getColor() == ColorSpace.YUV422_10) {
            return picture;
        }
        Transform transform = ColorUtil.getTransform(picture.getColor(), ColorSpace.YUV422_10);
        Picture create = Picture.create(picture.getWidth(), picture.getHeight(), ColorSpace.YUV422_10);
        transform.transform(picture, create);
        return create;
    }
}
