package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import org.jcodec.common.SeekableByteChannel;

public interface ByteChannelPool {
    void close();

    SeekableByteChannel getChannel() throws IOException;
}
