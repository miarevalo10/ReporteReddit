package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class CDCIEssenceDescriptor extends GenericPictureEssenceDescriptor {
    private int alphaSampleDepth;
    private int blackRefLevel;
    private int colorRange;
    private byte colorSiting;
    private int componentDepth;
    private int horizontalSubsampling;
    private short paddingBits;
    private byte reversedByteOrder;
    private int verticalSubsampling;
    private int whiteReflevel;

    public CDCIEssenceDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 13057:
                    this.componentDepth = byteBuffer.getInt();
                    break;
                case 13058:
                    this.horizontalSubsampling = byteBuffer.getInt();
                    break;
                case 13059:
                    this.colorSiting = byteBuffer.get();
                    break;
                case 13060:
                    this.blackRefLevel = byteBuffer.getInt();
                    break;
                case 13061:
                    this.whiteReflevel = byteBuffer.getInt();
                    break;
                case 13062:
                    this.colorRange = byteBuffer.getInt();
                    break;
                case 13063:
                    this.paddingBits = byteBuffer.getShort();
                    break;
                case 13064:
                    this.verticalSubsampling = byteBuffer.getInt();
                    break;
                case 13065:
                    this.alphaSampleDepth = byteBuffer.getInt();
                    break;
                case 13067:
                    this.reversedByteOrder = byteBuffer.get();
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                    stringBuilder.append(this.ul);
                    stringBuilder.append("]: %04x");
                    Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                    continue;
            }
            map.remove();
        }
    }

    public int getComponentDepth() {
        return this.componentDepth;
    }

    public int getHorizontalSubsampling() {
        return this.horizontalSubsampling;
    }

    public int getVerticalSubsampling() {
        return this.verticalSubsampling;
    }

    public byte getColorSiting() {
        return this.colorSiting;
    }

    public byte getReversedByteOrder() {
        return this.reversedByteOrder;
    }

    public short getPaddingBits() {
        return this.paddingBits;
    }

    public int getAlphaSampleDepth() {
        return this.alphaSampleDepth;
    }

    public int getBlackRefLevel() {
        return this.blackRefLevel;
    }

    public int getWhiteReflevel() {
        return this.whiteReflevel;
    }

    public int getColorRange() {
        return this.colorRange;
    }
}
