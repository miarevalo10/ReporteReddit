package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import java.nio.ByteBuffer;

public class StepwiseTemporalLayerEntry extends GroupEntry {
    public final String mo2526a() {
        return "stsa";
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
    }

    public int hashCode() {
        return 37;
    }

    public final ByteBuffer mo2528b() {
        return ByteBuffer.allocate(0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return true;
            }
        }
        return null;
    }
}
