package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class GenericTrack extends MXFInterchangeObject {
    private String name;
    private UL sequenceRef;
    private int trackId;
    private int trackNumber;

    public GenericTrack(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 18433:
                    this.trackId = byteBuffer.getInt();
                    break;
                case 18434:
                    this.name = readUtf16String(byteBuffer);
                    break;
                case 18435:
                    this.sequenceRef = UL.read(byteBuffer);
                    break;
                case 18436:
                    this.trackNumber = byteBuffer.getInt();
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

    public int getTrackId() {
        return this.trackId;
    }

    public String getName() {
        return this.name;
    }

    public UL getSequenceRef() {
        return this.sequenceRef;
    }

    public int getTrackNumber() {
        return this.trackNumber;
    }
}
