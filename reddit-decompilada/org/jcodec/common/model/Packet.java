package org.jcodec.common.model;

import java.nio.ByteBuffer;
import java.util.Comparator;

public class Packet {
    public static final Comparator<Packet> FRAME_ASC = new C22051();
    private ByteBuffer data;
    private int displayOrder;
    private long duration;
    private long frameNo;
    private boolean keyFrame;
    private long pts;
    private TapeTimecode tapeTimecode;
    private long timescale;

    static class C22051 implements Comparator<Packet> {
        C22051() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Packet packet = (Packet) obj;
            Packet packet2 = (Packet) obj2;
            if (packet == null && packet2 == null) {
                return 0;
            }
            if (packet == null) {
                return -1;
            }
            if (packet2 != null) {
                if (packet.frameNo < packet2.frameNo) {
                    return -1;
                }
                if (packet.frameNo == packet2.frameNo) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public Packet(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, TapeTimecode tapeTimecode) {
        this(byteBuffer, j, j2, j3, j4, z, tapeTimecode, 0);
    }

    public Packet(Packet packet) {
        this(packet.data, packet.pts, packet.timescale, packet.duration, packet.frameNo, packet.keyFrame, packet.tapeTimecode);
        this.displayOrder = packet.displayOrder;
    }

    public Packet(Packet packet, ByteBuffer byteBuffer) {
        this(byteBuffer, packet.pts, packet.timescale, packet.duration, packet.frameNo, packet.keyFrame, packet.tapeTimecode);
        this.displayOrder = packet.displayOrder;
    }

    public Packet(Packet packet, TapeTimecode tapeTimecode) {
        this(packet.data, packet.pts, packet.timescale, packet.duration, packet.frameNo, packet.keyFrame, tapeTimecode);
        this.displayOrder = packet.displayOrder;
    }

    public Packet(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, TapeTimecode tapeTimecode, int i) {
        this.data = byteBuffer;
        this.pts = j;
        this.timescale = j2;
        this.duration = j3;
        this.frameNo = j4;
        this.keyFrame = z;
        this.tapeTimecode = tapeTimecode;
        this.displayOrder = i;
    }

    public ByteBuffer getData() {
        return this.data.duplicate();
    }

    public long getPts() {
        return this.pts;
    }

    public long getTimescale() {
        return this.timescale;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getFrameNo() {
        return this.frameNo;
    }

    public void setTimescale(int i) {
        this.timescale = (long) i;
    }

    public TapeTimecode getTapeTimecode() {
        return this.tapeTimecode;
    }

    public void setTapeTimecode(TapeTimecode tapeTimecode) {
        this.tapeTimecode = tapeTimecode;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public boolean isKeyFrame() {
        return this.keyFrame;
    }

    public RationalLarge getPtsR() {
        return RationalLarge.m28382R(this.pts, this.timescale);
    }

    public double getPtsD() {
        return ((double) this.pts) / ((double) this.timescale);
    }

    public double getDurationD() {
        return ((double) this.duration) / ((double) this.timescale);
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }
}
