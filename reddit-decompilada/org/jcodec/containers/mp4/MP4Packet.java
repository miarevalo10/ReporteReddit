package org.jcodec.containers.mp4;

import java.nio.ByteBuffer;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.TapeTimecode;

public class MP4Packet extends Packet {
    private int entryNo;
    private long fileOff;
    private long mediaPts;
    private boolean psync;
    private int size;

    public MP4Packet(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, TapeTimecode tapeTimecode, long j5, int i) {
        super(byteBuffer, j, j2, j3, j4, z, tapeTimecode);
        this.mediaPts = j5;
        this.entryNo = i;
    }

    public MP4Packet(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, TapeTimecode tapeTimecode, long j5, int i, long j6, int i2, boolean z2) {
        super(byteBuffer, j, j2, j3, j4, z, tapeTimecode);
        this.mediaPts = j5;
        this.entryNo = i;
        this.fileOff = j6;
        this.size = i2;
        this.psync = z2;
    }

    public MP4Packet(MP4Packet mP4Packet, ByteBuffer byteBuffer) {
        super((Packet) mP4Packet, byteBuffer);
        this.mediaPts = mP4Packet.mediaPts;
        this.entryNo = mP4Packet.entryNo;
    }

    public MP4Packet(MP4Packet mP4Packet, TapeTimecode tapeTimecode) {
        super((Packet) mP4Packet, tapeTimecode);
        this.mediaPts = mP4Packet.mediaPts;
        this.entryNo = mP4Packet.entryNo;
    }

    public MP4Packet(Packet packet, long j, int i) {
        super(packet);
        this.mediaPts = j;
        this.entryNo = i;
    }

    public MP4Packet(MP4Packet mP4Packet) {
        super(mP4Packet);
        this.mediaPts = mP4Packet.mediaPts;
        this.entryNo = mP4Packet.entryNo;
    }

    public int getEntryNo() {
        return this.entryNo;
    }

    public long getMediaPts() {
        return this.mediaPts;
    }

    public long getFileOff() {
        return this.fileOff;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isPsync() {
        return this.psync;
    }
}
