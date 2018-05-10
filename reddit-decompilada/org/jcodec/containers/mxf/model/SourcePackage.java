package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class SourcePackage extends GenericPackage {
    private UL descriptorRef;
    private UL packageUid;
    private UL[] trackRefs;

    public SourcePackage(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            if (((Integer) entry.getKey()).intValue() != 18177) {
                StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                stringBuilder.append(this.ul);
                stringBuilder.append("]: %04x");
                Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
            } else {
                this.descriptorRef = UL.read(byteBuffer);
                map.remove();
            }
        }
    }

    public UL[] getTrackRefs() {
        return this.trackRefs;
    }

    public UL getDescriptorRef() {
        return this.descriptorRef;
    }

    public UL getPackageUid() {
        return this.packageUid;
    }
}
