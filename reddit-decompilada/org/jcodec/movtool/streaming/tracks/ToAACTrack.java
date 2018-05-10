package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class ToAACTrack implements VirtualTrack {
    public void close() throws IOException {
    }

    public CodecMeta getCodecMeta() {
        return null;
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public int getPreferredTimescale() {
        return 0;
    }

    public VirtualPacket nextPacket() throws IOException {
        return null;
    }
}
