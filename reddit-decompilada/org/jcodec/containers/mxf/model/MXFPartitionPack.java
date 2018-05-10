package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.NIOUtils;

public class MXFPartitionPack extends MXFMetadata {
    private int bodySid;
    private long footerPartition;
    private long headerByteCount;
    private long indexByteCount;
    private int indexSid;
    private int kagSize;
    private int nbEssenceContainers;
    private UL op;
    private long prevPartition;
    private long thisPartition;

    public MXFPartitionPack(UL ul) {
        super(ul);
    }

    public void read(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        NIOUtils.skip(byteBuffer, 4);
        this.kagSize = byteBuffer.getInt();
        this.thisPartition = byteBuffer.getLong();
        this.prevPartition = byteBuffer.getLong();
        this.footerPartition = byteBuffer.getLong();
        this.headerByteCount = byteBuffer.getLong();
        this.indexByteCount = byteBuffer.getLong();
        this.indexSid = byteBuffer.getInt();
        NIOUtils.skip(byteBuffer, 8);
        this.bodySid = byteBuffer.getInt();
        this.op = UL.read(byteBuffer);
        this.nbEssenceContainers = byteBuffer.getInt();
    }

    public int getKagSize() {
        return this.kagSize;
    }

    public long getThisPartition() {
        return this.thisPartition;
    }

    public long getPrevPartition() {
        return this.prevPartition;
    }

    public long getFooterPartition() {
        return this.footerPartition;
    }

    public long getHeaderByteCount() {
        return this.headerByteCount;
    }

    public long getIndexByteCount() {
        return this.indexByteCount;
    }

    public int getIndexSid() {
        return this.indexSid;
    }

    public int getBodySid() {
        return this.bodySid;
    }

    public UL getOp() {
        return this.op;
    }

    public int getNbEssenceContainers() {
        return this.nbEssenceContainers;
    }
}
