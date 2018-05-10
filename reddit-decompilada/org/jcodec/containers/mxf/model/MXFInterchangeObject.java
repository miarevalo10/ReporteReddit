package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.NIOUtils;

public abstract class MXFInterchangeObject extends MXFMetadata {
    private UL generationUID;
    private UL objectClass;

    protected abstract void read(Map<Integer, ByteBuffer> map);

    public MXFInterchangeObject(UL ul) {
        super(ul);
    }

    public void read(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        Map hashMap = new HashMap();
        while (byteBuffer.hasRemaining()) {
            int i = byteBuffer.getShort() & 65535;
            ByteBuffer read = NIOUtils.read(byteBuffer, 65535 & byteBuffer.getShort());
            if (i != 15370) {
                switch (i) {
                    case 257:
                        this.objectClass = UL.read(read);
                        break;
                    case 258:
                        this.generationUID = UL.read(read);
                        break;
                    default:
                        hashMap.put(Integer.valueOf(i), read);
                        break;
                }
            }
            this.uid = UL.read(read);
        }
        if (hashMap.size() > null) {
            read(hashMap);
        }
    }

    public UL getGenerationUID() {
        return this.generationUID;
    }

    public UL getObjectClass() {
        return this.objectClass;
    }
}
