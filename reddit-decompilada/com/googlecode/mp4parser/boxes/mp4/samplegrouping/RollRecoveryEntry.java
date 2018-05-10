package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

public class RollRecoveryEntry extends GroupEntry {
    private short f15224a;

    public final String mo2526a() {
        return "roll";
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        this.f15224a = byteBuffer.getShort();
    }

    public final ByteBuffer mo2528b() {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort(this.f15224a);
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.f15224a == ((RollRecoveryEntry) obj).f15224a;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f15224a;
    }
}
