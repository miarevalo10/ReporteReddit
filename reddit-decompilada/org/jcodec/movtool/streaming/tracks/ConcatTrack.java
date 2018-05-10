package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class ConcatTrack implements VirtualTrack {
    private int idx = 0;
    private VirtualPacket lastPacket;
    private int offsetFn = 0;
    private double offsetPts = 0.0d;
    private VirtualTrack[] tracks;

    public VirtualEdit[] getEdits() {
        return null;
    }

    public ConcatTrack(VirtualTrack[] virtualTrackArr) {
        this.tracks = virtualTrackArr;
    }

    public VirtualPacket nextPacket() throws IOException {
        while (this.idx < this.tracks.length) {
            VirtualPacket nextPacket = this.tracks[this.idx].nextPacket();
            if (nextPacket == null) {
                this.idx++;
                this.offsetPts += this.lastPacket.getPts() + this.lastPacket.getDuration();
                this.offsetFn += this.lastPacket.getFrameNo() + 1;
            } else {
                this.lastPacket = nextPacket;
                return new ConcatPacket(nextPacket, this.offsetPts, this.offsetFn);
            }
        }
        return null;
    }

    public CodecMeta getCodecMeta() {
        return this.tracks[0].getCodecMeta();
    }

    public int getPreferredTimescale() {
        return this.tracks[0].getPreferredTimescale();
    }

    public void close() throws IOException {
        for (VirtualTrack close : this.tracks) {
            close.close();
        }
    }
}
