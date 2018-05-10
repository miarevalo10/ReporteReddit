package org.jcodec.codecs.pcmdvd;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.AudioDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.model.AudioBuffer;

public class PCMDVDDecoder implements AudioDecoder {
    private static final int[] lpcm_freq_tab = new int[]{48000, 96000, 44100, 32000};

    public AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException {
        byteBuffer2 = byteBuffer2.duplicate();
        byteBuffer = byteBuffer.duplicate();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        int i = byteBuffer.get() & 255;
        NIOUtils.skip(byteBuffer, 3);
        int i2 = i & JpegConst.APP0;
        if (i2 == 160) {
            byteBuffer.get();
            i = byteBuffer.get() & 255;
            byteBuffer.get();
            int i3 = lpcm_freq_tab[(i >> 4) & 3];
            int i4 = 1 + (i & 7);
            i2 = 16 + (((i >> 6) & 3) * 4);
            i = byteBuffer.remaining() / ((i2 >> 3) * i4);
            int i5;
            if (i2 == 20) {
                for (i5 = 0; i5 < (i >> 1); i5++) {
                    for (i2 = 0; i2 < i4; i2++) {
                        byteBuffer2.putShort(byteBuffer.getShort());
                        byteBuffer2.putShort(byteBuffer.getShort());
                    }
                    NIOUtils.skip(byteBuffer, i4);
                }
            } else if (i2 == 24) {
                for (i5 = 0; i5 < (i >> 1); i5++) {
                    for (i2 = 0; i2 < i4; i2++) {
                        byteBuffer2.putShort(byteBuffer.getShort());
                        byteBuffer2.putShort(byteBuffer.getShort());
                    }
                    NIOUtils.skip(byteBuffer, i4 << 1);
                }
            }
            byteBuffer2.flip();
            return new AudioBuffer(byteBuffer2, new AudioFormat(i3, 16, i4, true, false), i);
        } else if (i2 != 128) {
            throw new RuntimeException("MPEG DVD unknown coded");
        } else if ((i & 248) == 136) {
            throw new RuntimeException("CODEC_ID_DTS");
        } else {
            throw new RuntimeException("CODEC_ID_AC3");
        }
    }
}
