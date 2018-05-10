package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class Identification extends MXFInterchangeObject {
    private String companyName;
    private Date modificationDate;
    private String platform;
    private String productName;
    private UL productUID;
    private UL thisGenerationUID;
    private short versionString;

    public Identification(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 15361:
                    this.companyName = readUtf16String(byteBuffer);
                    break;
                case 15362:
                    this.productName = readUtf16String(byteBuffer);
                    break;
                case 15364:
                    this.versionString = byteBuffer.getShort();
                    break;
                case 15365:
                    this.productUID = UL.read(byteBuffer);
                    break;
                case 15366:
                    this.modificationDate = MXFMetadata.readDate(byteBuffer);
                    break;
                case 15368:
                    this.platform = readUtf16String(byteBuffer);
                    break;
                case 15369:
                    this.thisGenerationUID = UL.read(byteBuffer);
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

    public UL getThisGenerationUID() {
        return this.thisGenerationUID;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getProductName() {
        return this.productName;
    }

    public short getVersionString() {
        return this.versionString;
    }

    public UL getProductUID() {
        return this.productUID;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public String getPlatform() {
        return this.platform;
    }
}
