package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class MXFStructuralComponent extends MXFInterchangeObject {
    private UL dataDefinitionUL;
    private long duration;

    public MXFStructuralComponent(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            switch (((Integer) entry.getKey()).intValue()) {
                case 513:
                    this.dataDefinitionUL = UL.read((ByteBuffer) entry.getValue());
                    break;
                case 514:
                    this.duration = ((ByteBuffer) entry.getValue()).getLong();
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

    public long getDuration() {
        return this.duration;
    }

    public UL getDataDefinitionUL() {
        return this.dataDefinitionUL;
    }
}
