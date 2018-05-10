package org.jcodec.common;

import java.nio.ByteBuffer;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public interface VideoEncoder {
    ByteBuffer encodeFrame(Picture picture, ByteBuffer byteBuffer);

    ColorSpace[] getSupportedColorSpaces();
}
