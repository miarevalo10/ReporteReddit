package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;

public class MXFPartition {
    private boolean closed;
    private boolean complete;
    private long essenceFilePos;
    private long essenceLength;
    private MXFPartitionPack pack;

    public MXFPartition(MXFPartitionPack mXFPartitionPack, long j, boolean z, boolean z2, long j2) {
        this.pack = mXFPartitionPack;
        this.essenceFilePos = j;
        this.closed = z;
        this.complete = z2;
        this.essenceLength = j2;
    }

    public static MXFPartition read(UL ul, ByteBuffer byteBuffer, long j, long j2) {
        UL ul2 = ul;
        boolean z = (ul2.get(14) & 1) == 0;
        boolean z2 = ul2.get(14) > 2;
        MXFPartitionPack mXFPartitionPack = new MXFPartitionPack(ul2);
        mXFPartitionPack.read(byteBuffer);
        long roundToKag = (roundToKag(mXFPartitionPack.getThisPartition() + j, mXFPartitionPack.getKagSize()) + roundToKag(mXFPartitionPack.getHeaderByteCount(), mXFPartitionPack.getKagSize())) + roundToKag(mXFPartitionPack.getIndexByteCount(), mXFPartitionPack.getKagSize());
        return new MXFPartition(mXFPartitionPack, roundToKag, z, z2, j2 - roundToKag);
    }

    static long roundToKag(long j, int i) {
        long j2 = (long) i;
        long j3 = (j / j2) * j2;
        return j3 == j ? j3 : j3 + j2;
    }

    public MXFPartitionPack getPack() {
        return this.pack;
    }

    public long getEssenceFilePos() {
        return this.essenceFilePos;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public long getEssenceLength() {
        return this.essenceLength;
    }
}
