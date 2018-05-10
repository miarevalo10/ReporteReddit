package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class GenericDescriptor extends MXFInterchangeObject {
    private UL[] locators;
    private UL[] subDescriptors;

    public GenericDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue == 12033) {
                this.locators = MXFMetadata.readULBatch(byteBuffer);
            } else if (intValue != 16129) {
                StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                stringBuilder.append(this.ul);
                stringBuilder.append("]: %04x");
                Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
            }
            this.subDescriptors = MXFMetadata.readULBatch(byteBuffer);
            map.remove();
        }
    }

    public UL[] getLocators() {
        return this.locators;
    }

    public UL[] getSubDescriptors() {
        return this.subDescriptors;
    }
}
