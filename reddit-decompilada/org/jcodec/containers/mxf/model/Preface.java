package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class Preface extends MXFInterchangeObject {
    private UL[] dmSchemes;
    private UL[] essenceContainers;
    private Date lastModifiedDate;
    private int objectModelVersion;
    private UL op;

    public Preface(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue == 15106) {
                this.lastModifiedDate = MXFMetadata.readDate(byteBuffer);
            } else if (intValue != 15111) {
                switch (intValue) {
                    case 15113:
                        this.op = UL.read(byteBuffer);
                        break;
                    case 15114:
                        this.essenceContainers = MXFMetadata.readULBatch(byteBuffer);
                        break;
                    case 15115:
                        this.dmSchemes = MXFMetadata.readULBatch(byteBuffer);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                        stringBuilder.append(this.ul);
                        stringBuilder.append("]: %04x");
                        Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                        continue;
                }
            } else {
                this.objectModelVersion = byteBuffer.getInt();
            }
            map.remove();
        }
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public int getObjectModelVersion() {
        return this.objectModelVersion;
    }

    public UL getOp() {
        return this.op;
    }

    public UL[] getEssenceContainers() {
        return this.essenceContainers;
    }

    public UL[] getDmSchemes() {
        return this.dmSchemes;
    }
}
