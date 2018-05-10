package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class GenericPackage extends MXFInterchangeObject {
    private String name;
    private Date packageCreationDate;
    private Date packageModifiedDate;
    private UL packageUID;
    private UL[] tracks;

    public GenericPackage(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 17409:
                    this.packageUID = UL.read(byteBuffer);
                    break;
                case 17410:
                    this.name = readUtf16String(byteBuffer);
                    break;
                case 17411:
                    this.tracks = MXFMetadata.readULBatch(byteBuffer);
                    break;
                case 17412:
                    this.packageModifiedDate = MXFMetadata.readDate(byteBuffer);
                    break;
                case 17413:
                    this.packageCreationDate = MXFMetadata.readDate(byteBuffer);
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

    public UL[] getTracks() {
        return this.tracks;
    }

    public UL getPackageUID() {
        return this.packageUID;
    }

    public String getName() {
        return this.name;
    }

    public Date getPackageModifiedDate() {
        return this.packageModifiedDate;
    }

    public Date getPackageCreationDate() {
        return this.packageCreationDate;
    }
}
