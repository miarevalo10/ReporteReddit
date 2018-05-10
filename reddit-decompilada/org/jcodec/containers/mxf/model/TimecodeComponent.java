package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class TimecodeComponent extends MXFStructuralComponent {
    private int base;
    private int dropFrame;
    private long start;

    public TimecodeComponent(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 5377:
                    this.start = byteBuffer.getLong();
                    break;
                case 5378:
                    this.base = byteBuffer.getShort();
                    break;
                case 5379:
                    this.dropFrame = byteBuffer.get();
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

    public long getStart() {
        return this.start;
    }

    public int getBase() {
        return this.base;
    }

    public int getDropFrame() {
        return this.dropFrame;
    }
}
