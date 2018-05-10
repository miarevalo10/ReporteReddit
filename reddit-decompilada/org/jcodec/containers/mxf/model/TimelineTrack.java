package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;

public class TimelineTrack extends GenericTrack {
    private Rational editRate;
    private long origin;

    public TimelineTrack(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 19201:
                    this.editRate = new Rational(byteBuffer.getInt(), byteBuffer.getInt());
                    break;
                case 19202:
                    this.origin = byteBuffer.getLong();
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

    public Rational getEditRate() {
        return this.editRate;
    }

    public long getOrigin() {
        return this.origin;
    }
}
