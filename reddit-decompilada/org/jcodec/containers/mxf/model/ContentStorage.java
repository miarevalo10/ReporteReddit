package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class ContentStorage extends MXFInterchangeObject {
    private UL[] essenceContainerData;
    private UL[] packageRefs;

    public ContentStorage(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 6401:
                    this.packageRefs = MXFMetadata.readULBatch(byteBuffer);
                    break;
                case 6402:
                    this.essenceContainerData = MXFMetadata.readULBatch(byteBuffer);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ContentStorage: ");
                    stringBuilder.append(this.ul);
                    stringBuilder.append("]: %04x");
                    Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                    continue;
            }
            map.remove();
        }
    }

    public UL[] getPackageRefs() {
        return this.packageRefs;
    }

    public UL[] getEssenceContainerData() {
        return this.essenceContainerData;
    }
}
