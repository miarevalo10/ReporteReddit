package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;

public class FileDescriptor extends GenericDescriptor {
    private UL codec;
    private long containerDuration;
    private UL essenceContainer;
    private int linkedTrackId;
    private Rational sampleRate;

    public FileDescriptor(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            switch (((Integer) entry.getKey()).intValue()) {
                case 12289:
                    this.sampleRate = new Rational(byteBuffer.getInt(), byteBuffer.getInt());
                    break;
                case 12290:
                    this.containerDuration = byteBuffer.getLong();
                    break;
                case 12292:
                    this.essenceContainer = UL.read(byteBuffer);
                    break;
                case 12293:
                    this.codec = UL.read(byteBuffer);
                    break;
                case 12294:
                    this.linkedTrackId = byteBuffer.getInt();
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

    public int getLinkedTrackId() {
        return this.linkedTrackId;
    }

    public Rational getSampleRate() {
        return this.sampleRate;
    }

    public long getContainerDuration() {
        return this.containerDuration;
    }

    public UL getEssenceContainer() {
        return this.essenceContainer;
    }

    public UL getCodec() {
        return this.codec;
    }
}
