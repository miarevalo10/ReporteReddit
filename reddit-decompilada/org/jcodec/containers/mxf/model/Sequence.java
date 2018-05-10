package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class Sequence extends MXFStructuralComponent {
    private UL[] structuralComponentsRefs;

    public Sequence(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (((Integer) entry.getKey()).intValue() != 4097) {
                StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                stringBuilder.append(this.ul);
                stringBuilder.append("]: %04x");
                Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
            } else {
                this.structuralComponentsRefs = MXFMetadata.readULBatch((ByteBuffer) entry.getValue());
                map.remove();
            }
        }
    }

    public UL[] getStructuralComponentsRefs() {
        return this.structuralComponentsRefs;
    }
}
