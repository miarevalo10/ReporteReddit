package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class ClipTrack implements VirtualTrack {
    private boolean eof;
    private int from;
    private List<VirtualPacket> gop;
    private VirtualTrack src;
    private int startFrame;
    private double startPts;
    private int to;

    public class ClipPacket extends VirtualPacketWrapper {
        public ClipPacket(VirtualPacket virtualPacket) {
            super(virtualPacket);
        }

        public double getPts() {
            return super.getPts() - ClipTrack.this.startPts;
        }

        public int getFrameNo() {
            return super.getFrameNo() - ClipTrack.this.startFrame;
        }
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public ClipTrack(VirtualTrack virtualTrack, int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException("Clipping negative or zero frames.");
        }
        this.src = virtualTrack;
        this.from = i;
        this.to = i2;
    }

    public VirtualPacket nextPacket() throws IOException {
        if (this.eof) {
            return null;
        }
        if (this.gop == null) {
            this.gop = getGop(this.src, this.from);
            this.startPts = ((VirtualPacket) this.gop.get(0)).getPts();
            this.startFrame = ((VirtualPacket) this.gop.get(0)).getFrameNo();
        }
        VirtualPacket nextPacket = this.gop.size() > 0 ? (VirtualPacket) this.gop.remove(0) : this.src.nextPacket();
        if (nextPacket != null) {
            if (nextPacket.getFrameNo() < this.to) {
                return new ClipPacket(nextPacket);
            }
        }
        this.eof = true;
        return null;
    }

    public List<VirtualPacket> getGop(VirtualTrack virtualTrack, int i) throws IOException {
        List<VirtualPacket> arrayList = new ArrayList();
        VirtualPacket nextPacket;
        do {
            nextPacket = virtualTrack.nextPacket();
            if (nextPacket != null) {
                if (nextPacket.isKeyframe()) {
                    arrayList.clear();
                }
                arrayList.add(nextPacket);
            }
            if (nextPacket == null) {
                break;
            }
        } while (nextPacket.getFrameNo() < i);
        return arrayList;
    }

    public CodecMeta getCodecMeta() {
        return this.src.getCodecMeta();
    }

    public int getPreferredTimescale() {
        return this.src.getPreferredTimescale();
    }

    public void close() throws IOException {
        this.src.close();
    }
}
