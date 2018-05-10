package org.jcodec.common;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.model.AudioBuffer;

public interface AudioDecoder {
    AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws IOException;
}
