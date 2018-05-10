package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class GenericDataEssenceDescriptor extends FileDescriptor {
    private UL dataEssenceCoding;

    public GenericDataEssenceDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            if (((Integer) entry.getKey()).intValue() != 15873) {
                StringBuilder stringBuilder = new StringBuilder("Unknown tag [ FileDescriptor: ");
                stringBuilder.append(this.ul);
                stringBuilder.append("]: %04x");
                Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
            } else {
                this.dataEssenceCoding = UL.read(byteBuffer);
                map.remove();
            }
        }
    }

    public UL getDataEssenceCoding() {
        return this.dataEssenceCoding;
    }
}
