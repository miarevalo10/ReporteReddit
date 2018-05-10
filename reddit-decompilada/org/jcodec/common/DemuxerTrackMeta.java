package org.jcodec.common;

import org.jcodec.common.model.Size;

public class DemuxerTrackMeta {
    private Size dimensions;
    private int[] seekFrames;
    private double totalDuration;
    private int totalFrames;
    private Type type;

    public enum Type {
        VIDEO,
        AUDIO,
        OTHER
    }

    public DemuxerTrackMeta(Type type, int[] iArr, int i, double d, Size size) {
        this.type = type;
        this.seekFrames = iArr;
        this.totalFrames = i;
        this.totalDuration = d;
        this.dimensions = size;
    }

    public Type getType() {
        return this.type;
    }

    public int[] getSeekFrames() {
        return this.seekFrames;
    }

    public int getTotalFrames() {
        return this.totalFrames;
    }

    public double getTotalDuration() {
        return this.totalDuration;
    }

    public Size getDimensions() {
        return this.dimensions;
    }
}
