package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class MPEG2VideoDescriptor extends CDCIEssenceDescriptor {
    private short bPictureCount;
    private int bitRate;
    private byte closedGOP;
    private byte codedContentType;
    private byte constantBFrames;
    private byte identicalGOP;
    private byte lowDelay;
    private short maxGOP;
    private byte profileAndLevel;
    private byte singleSequence;

    public MPEG2VideoDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 32768:
                    this.singleSequence = byteBuffer.get();
                    break;
                case 32769:
                    this.constantBFrames = byteBuffer.get();
                    break;
                case 32770:
                    this.codedContentType = byteBuffer.get();
                    break;
                case 32771:
                    this.lowDelay = byteBuffer.get();
                    break;
                case 32772:
                    this.closedGOP = byteBuffer.get();
                    break;
                case 32773:
                    this.identicalGOP = byteBuffer.get();
                    break;
                case 32774:
                    this.maxGOP = byteBuffer.getShort();
                    break;
                case 32775:
                    this.bPictureCount = (short) (byteBuffer.get() & 255);
                    break;
                case 32776:
                    this.bitRate = byteBuffer.getInt();
                    break;
                case 32777:
                    this.profileAndLevel = byteBuffer.get();
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                    stringBuilder.append(this.ul);
                    stringBuilder.append("]: %04x + (");
                    stringBuilder.append(byteBuffer.remaining());
                    stringBuilder.append(")");
                    Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                    continue;
            }
            map.remove();
        }
    }

    public byte getSingleSequence() {
        return this.singleSequence;
    }

    public byte getConstantBFrames() {
        return this.constantBFrames;
    }

    public byte getCodedContentType() {
        return this.codedContentType;
    }

    public byte getLowDelay() {
        return this.lowDelay;
    }

    public byte getClosedGOP() {
        return this.closedGOP;
    }

    public byte getIdenticalGOP() {
        return this.identicalGOP;
    }

    public short getMaxGOP() {
        return this.maxGOP;
    }

    public short getbPictureCount() {
        return this.bPictureCount;
    }

    public int getBitRate() {
        return this.bitRate;
    }

    public byte getProfileAndLevel() {
        return this.profileAndLevel;
    }
}
