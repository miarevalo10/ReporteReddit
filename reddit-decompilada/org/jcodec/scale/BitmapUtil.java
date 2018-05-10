package org.jcodec.scale;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.IntBuffer;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public class BitmapUtil {
    private static ThreadLocal<int[]> buffer = new ThreadLocal();

    public static Picture fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Picture create = Picture.create(bitmap.getWidth(), bitmap.getHeight(), ColorSpace.RGB);
        fromBitmap(bitmap, create);
        return create;
    }

    public static void fromBitmap(Bitmap bitmap, Picture picture) {
        picture = picture.getPlaneData(0);
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < bitmap.getHeight()) {
            int i4 = i3;
            i3 = i2;
            i2 = 0;
            while (i2 < bitmap.getWidth()) {
                int i5 = iArr[i3];
                picture[i4] = (i5 >> 16) & 255;
                picture[i4 + 1] = (i5 >> 8) & 255;
                picture[i4 + 2] = i5 & 255;
                i2++;
                i3++;
                i4 += 3;
            }
            i++;
            i2 = i3;
            i3 = i4;
        }
    }

    public static Bitmap toBitmap(Picture picture) {
        if (picture == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(picture.getCroppedWidth(), picture.getCroppedHeight(), Config.ARGB_8888);
        toBitmap(picture, createBitmap);
        return createBitmap;
    }

    public static void toBitmap(Picture picture, Bitmap bitmap) {
        int[] planeData = picture.getPlaneData(0);
        int[] buffer = getBuffer(picture);
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < picture.getCroppedHeight()) {
            int i4 = i3;
            i3 = i2;
            i2 = 0;
            while (i2 < picture.getCroppedWidth()) {
                buffer[i3] = ((-16777216 | (planeData[i4] << 16)) | (planeData[i4 + 1] << 8)) | planeData[i4 + 2];
                i2++;
                i3++;
                i4 += 3;
            }
            i++;
            int i5 = i3;
            i3 = (picture.getWidth() - picture.getCroppedWidth()) + i4;
            i2 = i5;
        }
        bitmap.copyPixelsFromBuffer(IntBuffer.wrap(buffer));
    }

    private static int[] getBuffer(Picture picture) {
        int[] iArr = (int[]) buffer.get();
        if (iArr != null) {
            return iArr;
        }
        Object obj = new int[(picture.getWidth() * picture.getHeight())];
        buffer.set(obj);
        return obj;
    }
}
