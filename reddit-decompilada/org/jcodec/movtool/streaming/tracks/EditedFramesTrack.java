package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class EditedFramesTrack implements VirtualTrack {
    private List<VirtualPacket>[] buckets = new List[this.edits.length];
    private int curEdit;
    private int curPkt;
    private VirtualEdit[] edits;
    private int frameNo;
    private double pts;
    private VirtualTrack src;

    public static class EditedFramesPacket extends VirtualPacketWrapper {
        private double duration;
        private int frameNo;
        private double pts;

        public boolean isKeyframe() {
            return true;
        }

        public EditedFramesPacket(VirtualPacket virtualPacket, double d, double d2, int i) {
            super(virtualPacket);
            this.pts = d;
            this.duration = d2;
            this.frameNo = i;
        }

        public double getPts() {
            return this.pts;
        }

        public double getDuration() {
            return this.duration;
        }

        public int getFrameNo() {
            return this.frameNo;
        }
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public EditedFramesTrack(VirtualTrack virtualTrack) throws IOException {
        this.src = virtualTrack;
        this.edits = virtualTrack.getEdits();
        for (int i = 0; i < this.edits.length; i++) {
            this.buckets[i] = new ArrayList();
        }
        while (true) {
            VirtualPacket nextPacket = virtualTrack.nextPacket();
            if (nextPacket == null) {
                return;
            }
            if (nextPacket.isKeyframe()) {
                for (int i2 = 0; i2 < this.edits.length; i2++) {
                    VirtualEdit virtualEdit = this.edits[i2];
                    if (nextPacket.getPts() < virtualEdit.getIn() + virtualEdit.getDuration() && nextPacket.getPts() + nextPacket.getDuration() > virtualEdit.getIn()) {
                        this.buckets[i2].add(nextPacket);
                    }
                }
            } else {
                throw new IllegalArgumentException("Can not apply edits to a track that has inter frames, this will result in decoding errors.");
            }
        }
    }

    public VirtualPacket nextPacket() throws IOException {
        if (this.curEdit >= this.edits.length) {
            return null;
        }
        VirtualPacket virtualPacket = (VirtualPacket) this.buckets[this.curEdit].get(this.curPkt);
        VirtualEdit virtualEdit = this.edits[this.curEdit];
        double duration = virtualPacket.getDuration() - (Math.max(virtualEdit.getIn() - virtualPacket.getPts(), 0.0d) + Math.max((virtualPacket.getPts() + virtualPacket.getDuration()) - (virtualEdit.getIn() + virtualEdit.getDuration()), 0.0d));
        VirtualPacket editedFramesPacket = new EditedFramesPacket(virtualPacket, this.pts, duration, this.frameNo);
        this.curPkt++;
        if (this.curPkt >= this.buckets[this.curEdit].size()) {
            this.curEdit++;
            this.curPkt = 0;
        }
        this.frameNo++;
        this.pts += duration;
        return editedFramesPacket;
    }

    public CodecMeta getCodecMeta() {
        return this.src.getCodecMeta();
    }

    public void close() throws IOException {
        this.src.close();
    }

    public int getPreferredTimescale() {
        return this.src.getPreferredTimescale();
    }
}
