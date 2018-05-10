package org.jcodec.common;

import java.io.IOException;
import org.jcodec.common.model.Packet;

public interface DemuxerTrack {
    DemuxerTrackMeta getMeta();

    Packet nextFrame() throws IOException;
}
