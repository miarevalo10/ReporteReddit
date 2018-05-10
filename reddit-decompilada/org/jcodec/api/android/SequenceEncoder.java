package org.jcodec.api.android;

import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import org.jcodec.scale.BitmapUtil;

public class SequenceEncoder extends org.jcodec.api.SequenceEncoder {
    public SequenceEncoder(File file) throws IOException {
        super(file);
    }

    public void encodeImage(Bitmap bitmap) throws IOException {
        encodeNativeFrame(BitmapUtil.fromBitmap(bitmap));
    }
}
