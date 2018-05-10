package org.jcodec.scale;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;

public class ImageConvert {
    private static final int CROP = 1024;
    private static final int FIX_0_71414 = FIX(0.71414d);
    private static final int FIX_1_402 = FIX(1.402d);
    private static final int FIX_1_772 = FIX(1.772d);
    private static final int ONE_HALF = 512;
    private static final int SCALEBITS = 10;
    private static final int _FIX_0_34414 = (-FIX(0.34414d));
    private static final byte[] cropTable = new byte[2304];
    private static final int[] intCropTable = new int[2304];
    private static final byte[] y_ccir_to_jpeg = new byte[256];
    private static final byte[] y_jpeg_to_ccir = new byte[256];

    private static final int FIX(double d) {
        return (int) ((d * 1024.0d) + 0.5d);
    }

    static {
        int i = -1024;
        while (true) {
            int i2 = 0;
            if (i >= 0) {
                break;
            }
            int i3 = i + 1024;
            cropTable[i3] = (byte) 0;
            intCropTable[i3] = 0;
            i++;
        }
        for (i = 0; i < 256; i++) {
            i3 = i + 1024;
            cropTable[i3] = (byte) i;
            intCropTable[i3] = i;
        }
        for (i = 256; i < 1024; i++) {
            i3 = i + 1024;
            cropTable[i3] = (byte) -1;
            intCropTable[i3] = 255;
        }
        while (i2 < 256) {
            y_ccir_to_jpeg[i2] = crop(Y_CCIR_TO_JPEG(i2));
            y_jpeg_to_ccir[i2] = crop(Y_JPEG_TO_CCIR(i2));
            i2++;
        }
    }

    public static final int ycbcr_to_rgb24(int i, int i2, int i3) {
        i <<= 10;
        i2 -= 128;
        i3 -= 128;
        int i4 = ((_FIX_0_34414 * i2) - (FIX_0_71414 * i3)) + 512;
        i2 = (((FIX_1_402 * i3) + 512) + i) >> 10;
        int i5 = (i4 + i) >> 10;
        i = (i + ((FIX_1_772 * i2) + 512)) >> 10;
        return (crop(i) & 255) | (((crop(i2) & 255) << 16) | ((crop(i5) & 255) << 8));
    }

    static final int Y_JPEG_TO_CCIR(int i) {
        return ((i * FIX(0.8588235294117647d)) + 16896) >> 10;
    }

    static final int Y_CCIR_TO_JPEG(int i) {
        return ((i * FIX(1.1643835616438356d)) + (512 - (16 * FIX(1.1643835616438356d)))) >> 10;
    }

    public static final int icrop(int i) {
        return intCropTable[i + 1024];
    }

    public static final byte crop(int i) {
        return cropTable[i + 1024];
    }

    public static final byte y_ccir_to_jpeg(byte b) {
        return y_ccir_to_jpeg[b & 255];
    }

    public static final byte y_jpeg_to_ccir(byte b) {
        return y_jpeg_to_ccir[b & 255];
    }

    public static void YUV444toRGB888(int i, int i2, int i3, ByteBuffer byteBuffer) {
        i2 -= 128;
        i3 -= 128;
        int i4 = 298 * (i - 16);
        i3 = (((i4 - (100 * i2)) - (JpegConst.RST0 * i3)) + 128) >> 8;
        i2 = ((i4 + (516 * i2)) + 128) >> 8;
        byteBuffer.put(crop((((409 * i3) + i4) + 128) >> 8));
        byteBuffer.put(crop(i3));
        byteBuffer.put(crop(i2));
    }

    public static void RGB888toYUV444(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) {
        int i = byteBuffer.get() & 255;
        int i2 = byteBuffer.get() & 255;
        byteBuffer = byteBuffer.get() & 255;
        int i3 = ((66 * i) + (129 * i2)) + (25 * byteBuffer);
        int i4 = ((112 * i) - (94 * i2)) - (18 * byteBuffer);
        i = ((((-38 * i) - (74 * i2)) + (112 * byteBuffer)) + 128) >> 8;
        i2 = (i4 + 128) >> 8;
        byteBuffer2.put(crop(((i3 + 128) >> 8) + 16));
        byteBuffer3.put(crop(i + 128));
        byteBuffer4.put(crop(i2 + 128));
    }

    public static byte RGB888toY4(int i, int i2, int i3) {
        return crop((((((66 * i) + (129 * i2)) + (25 * i3)) + 128) >> 8) + 16);
    }

    public static byte RGB888toU4(int i, int i2, int i3) {
        return crop((((((-38 * i) - (74 * i2)) + (112 * i3)) + 128) >> 8) + 128);
    }

    public static byte RGB888toV4(int i, int i2, int i3) {
        return crop((((((112 * i) - (94 * i2)) - (18 * i3)) + 128) >> 8) + 128);
    }
}
