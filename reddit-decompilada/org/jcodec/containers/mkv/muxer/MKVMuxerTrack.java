package org.jcodec.containers.mkv.muxer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mkv.boxes.MkvBlock;

public class MKVMuxerTrack {
    static final int DEFAULT_TIMESCALE = 1000000000;
    static final int MULTIPLIER = 1000;
    static final int NANOSECONDS_IN_A_MILISECOND = 1000000;
    public String codecId;
    public Size frameDimentions;
    private int frameDuration;
    List<MkvBlock> trackBlocks = new ArrayList();
    public int trackNo;
    public MKVMuxerTrackType type = MKVMuxerTrackType.VIDEO;

    public enum MKVMuxerTrackType {
        VIDEO
    }

    public int getTimescale() {
        return NANOSECONDS_IN_A_MILISECOND;
    }

    public void addSampleEntry(ByteBuffer byteBuffer, int i) {
        byteBuffer = MkvBlock.keyFrame((long) this.trackNo, 0, byteBuffer);
        byteBuffer.absoluteTimecode = (long) (i - 1);
        this.trackBlocks.add(byteBuffer);
    }

    public long getTrackNo() {
        return (long) this.trackNo;
    }
}
