package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.movtool.streaming.AudioCodecMeta;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class PCMFlatternTrack implements VirtualTrack {
    private static final VirtualPacket[] EMPTY = new VirtualPacket[0];
    private int dataLen;
    private int frameNo;
    private int framesPerPkt;
    private VirtualPacket leftover;
    private int leftoverOffset;
    private double packetDur;
    private List<VirtualPacket> pktBuffer = new ArrayList();
    private AudioCodecMeta se;
    private VirtualTrack src;

    private class FlatternPacket implements VirtualPacket {
        final /* synthetic */ PCMFlatternTrack f33313a;
        private int f33314b;
        private int f33315c;
        private VirtualPacket[] f33316d;
        private int f33317e;

        public boolean isKeyframe() {
            return true;
        }

        public FlatternPacket(PCMFlatternTrack pCMFlatternTrack, int i, VirtualPacket[] virtualPacketArr, int i2, int i3) {
            this.f33313a = pCMFlatternTrack;
            this.f33314b = i;
            this.f33315c = i2;
            this.f33316d = virtualPacketArr;
            this.f33317e = i3;
        }

        public ByteBuffer getData() throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(this.f33317e);
            ByteBuffer data = this.f33316d[0].getData();
            NIOUtils.skip(data, this.f33315c);
            NIOUtils.write(allocate, data);
            for (int i = 1; i < this.f33316d.length && allocate.hasRemaining(); i++) {
                ByteBuffer data2 = this.f33316d[i].getData();
                NIOUtils.write(allocate, data2, Math.min(data2.remaining(), allocate.remaining()));
            }
            allocate.flip();
            return allocate;
        }

        public int getDataLen() {
            return this.f33317e;
        }

        public double getPts() {
            return (((double) this.f33314b) * ((double) this.f33313a.framesPerPkt)) / ((double) this.f33313a.se.getSampleRate());
        }

        public double getDuration() {
            return this.f33313a.packetDur;
        }

        public int getFrameNo() {
            return this.f33314b;
        }
    }

    public PCMFlatternTrack(VirtualTrack virtualTrack, int i) {
        this.framesPerPkt = i;
        this.src = virtualTrack;
        this.se = (AudioCodecMeta) virtualTrack.getCodecMeta();
        this.dataLen = this.se.getFrameSize() * this.framesPerPkt;
        this.packetDur = ((double) this.framesPerPkt) / ((double) this.se.getSampleRate());
    }

    public VirtualPacket nextPacket() throws IOException {
        this.pktBuffer.clear();
        VirtualPacket nextPacket = this.leftover == null ? this.src.nextPacket() : this.leftover;
        if (nextPacket == null) {
            return null;
        }
        int i = this.dataLen + this.leftoverOffset;
        do {
            this.pktBuffer.add(nextPacket);
            i -= nextPacket.getDataLen();
            if (i > 0) {
                nextPacket = this.src.nextPacket();
            }
            if (i <= 0) {
                break;
            }
        } while (nextPacket != null);
        VirtualPacket flatternPacket = new FlatternPacket(this, this.frameNo, (VirtualPacket[]) this.pktBuffer.toArray(EMPTY), this.leftoverOffset, this.dataLen - Math.max(i, 0));
        this.frameNo += this.framesPerPkt;
        if (i < 0) {
            this.leftover = (VirtualPacket) this.pktBuffer.get(this.pktBuffer.size() - 1);
            this.leftoverOffset = this.leftover.getDataLen() + i;
        } else {
            this.leftover = null;
            this.leftoverOffset = 0;
        }
        return flatternPacket;
    }

    public CodecMeta getCodecMeta() {
        return this.se;
    }

    public void close() throws IOException {
        this.src.close();
    }

    public VirtualEdit[] getEdits() {
        return this.src.getEdits();
    }

    public int getPreferredTimescale() {
        return this.src.getPreferredTimescale();
    }
}
