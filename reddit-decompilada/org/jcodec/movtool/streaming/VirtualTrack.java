package org.jcodec.movtool.streaming;

import java.io.IOException;

public interface VirtualTrack {

    public static class VirtualEdit {
        private double duration;
        private double in;

        public VirtualEdit(double d, double d2) {
            this.in = d;
            this.duration = d2;
        }

        public double getIn() {
            return this.in;
        }

        public double getDuration() {
            return this.duration;
        }
    }

    void close() throws IOException;

    CodecMeta getCodecMeta();

    VirtualEdit[] getEdits();

    int getPreferredTimescale();

    VirtualPacket nextPacket() throws IOException;
}
