package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.logging.Logger;

public class SourceClip extends MXFStructuralComponent {
    private UL sourcePackageUid;
    private int sourceTrackId;
    private long startPosition;

    public SourceClip(UL ul) {
        super(ul);
    }

    protected void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue != 4609) {
                switch (intValue) {
                    case 4353:
                        this.sourcePackageUid = UL.read(byteBuffer);
                        break;
                    case 4354:
                        this.sourceTrackId = byteBuffer.getInt();
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown tag [ ");
                        stringBuilder.append(this.ul);
                        stringBuilder.append("]: %04x");
                        Logger.warn(String.format(stringBuilder.toString(), new Object[]{entry.getKey()}));
                        continue;
                }
            } else {
                this.startPosition = byteBuffer.getLong();
            }
            map.remove();
        }
    }

    public UL getSourcePackageUid() {
        return this.sourcePackageUid;
    }

    public long getStartPosition() {
        return this.startPosition;
    }

    public int getSourceTrackId() {
        return this.sourceTrackId;
    }
}
