package org.jcodec.movtool.streaming;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface MovieSegment {
    ByteBuffer getData() throws IOException;

    int getDataLen() throws IOException;

    int getNo();

    long getPos();
}
