package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class IndexSegment extends MXFInterchangeObject {
    private int bodySID;
    private DeltaEntries deltaEntries;
    private int editUnitByteCount;
    private IndexEntries ie;
    private long indexDuration;
    private int indexEditRateDen;
    private int indexEditRateNum;
    private int indexSID;
    private long indexStartPosition;
    private UL instanceUID;
    private int posTableCount;
    private int sliceCount;

    public IndexSegment(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue != 15370) {
                switch (intValue) {
                    case 16133:
                        this.editUnitByteCount = byteBuffer.getInt();
                        break;
                    case 16134:
                        this.indexSID = byteBuffer.getInt();
                        break;
                    case 16135:
                        this.bodySID = byteBuffer.getInt();
                        break;
                    case 16136:
                        this.sliceCount = byteBuffer.get() & 255;
                        break;
                    case 16137:
                        this.deltaEntries = DeltaEntries.read(byteBuffer);
                        break;
                    case 16138:
                        this.ie = IndexEntries.read(byteBuffer);
                        break;
                    case 16139:
                        this.indexEditRateNum = byteBuffer.getInt();
                        this.indexEditRateDen = byteBuffer.getInt();
                        break;
                    case 16140:
                        this.indexStartPosition = byteBuffer.getLong();
                        break;
                    case 16141:
                        this.indexDuration = byteBuffer.getLong();
                        break;
                    case 16142:
                        this.posTableCount = byteBuffer.get() & 255;
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown tag [");
                        stringBuilder.append(this.ul);
                        stringBuilder.append("]: %04x");
                        Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                        continue;
                }
            } else {
                this.instanceUID = UL.read(byteBuffer);
            }
            map.remove();
        }
    }

    public IndexEntries getIe() {
        return this.ie;
    }

    public int getEditUnitByteCount() {
        return this.editUnitByteCount;
    }

    public DeltaEntries getDeltaEntries() {
        return this.deltaEntries;
    }

    public int getIndexSID() {
        return this.indexSID;
    }

    public int getBodySID() {
        return this.bodySID;
    }

    public int getIndexEditRateNum() {
        return this.indexEditRateNum;
    }

    public int getIndexEditRateDen() {
        return this.indexEditRateDen;
    }

    public long getIndexStartPosition() {
        return this.indexStartPosition;
    }

    public long getIndexDuration() {
        return this.indexDuration;
    }

    public UL getInstanceUID() {
        return this.instanceUID;
    }

    public int getSliceCount() {
        return this.sliceCount;
    }

    public int getPosTableCount() {
        return this.posTableCount;
    }
}
