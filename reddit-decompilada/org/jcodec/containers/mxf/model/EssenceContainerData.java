package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class EssenceContainerData extends MXFInterchangeObject {
    private int bodySID;
    private int indexSID;
    private UL linkedPackageUID;

    public EssenceContainerData(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue != 9985) {
                switch (intValue) {
                    case 16134:
                        this.indexSID = byteBuffer.getInt();
                        break;
                    case 16135:
                        this.bodySID = byteBuffer.getInt();
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown tag [ EssenceContainerData: ");
                        stringBuilder.append(this.ul);
                        stringBuilder.append("]: %04x");
                        Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                        continue;
                }
            } else {
                this.linkedPackageUID = UL.read(byteBuffer);
            }
            map.remove();
        }
    }

    public UL getLinkedPackageUID() {
        return this.linkedPackageUID;
    }

    public int getIndexSID() {
        return this.indexSID;
    }

    public int getBodySID() {
        return this.bodySID;
    }
}
