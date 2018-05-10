package org.jcodec.common;

import android.graphics.Bitmap;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.BitmapUtil;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

public class AndroidUtil {
    public static Bitmap toBitmap(Picture picture) {
        if (picture == null) {
            return null;
        }
        Transform transform = ColorUtil.getTransform(picture.getColor(), ColorSpace.RGB);
        Picture create = Picture.create(picture.getWidth(), picture.getHeight(), ColorSpace.RGB, picture.getCrop());
        transform.transform(picture, create);
        return BitmapUtil.toBitmap(create);
    }

    public static void toBitmap(Picture picture, Bitmap bitmap) {
        if (picture == null) {
            throw new IllegalArgumentException("Input pic is null");
        } else if (bitmap == null) {
            throw new IllegalArgumentException("Out bitmap is null");
        } else {
            Transform transform = ColorUtil.getTransform(picture.getColor(), ColorSpace.RGB);
            Picture create = Picture.create(picture.getWidth(), picture.getHeight(), ColorSpace.RGB, picture.getCrop());
            transform.transform(picture, create);
            BitmapUtil.toBitmap(create, bitmap);
        }
    }
}
