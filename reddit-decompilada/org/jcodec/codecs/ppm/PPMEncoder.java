package org.jcodec.codecs.ppm;

import com.facebook.stetho.server.http.HttpStatus;
import java.nio.ByteBuffer;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public class PPMEncoder {
    public ByteBuffer encodeFrame(Picture picture) {
        if (picture.getColor() != ColorSpace.RGB) {
            throw new IllegalArgumentException("Only RGB image can be stored in PPM");
        }
        ByteBuffer allocate = ByteBuffer.allocate(((picture.getWidth() * picture.getHeight()) * 3) + HttpStatus.HTTP_OK);
        StringBuilder stringBuilder = new StringBuilder("P6 ");
        stringBuilder.append(picture.getWidth());
        stringBuilder.append(" ");
        stringBuilder.append(picture.getHeight());
        stringBuilder.append(" 255\n");
        allocate.put(JCodecUtil.asciiString(stringBuilder.toString()));
        int[][] data = picture.getData();
        for (int i = 0; i < (picture.getWidth() * picture.getHeight()) * 3; i += 3) {
            allocate.put((byte) data[0][i + 2]);
            allocate.put((byte) data[0][i + 1]);
            allocate.put((byte) data[0][i]);
        }
        allocate.flip();
        return allocate;
    }
}
