package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

public class TemporalLevelEntry extends GroupEntry {
    private boolean f15225a;
    private short f15226b;

    public final String mo2526a() {
        return "tele";
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        this.f15225a = (byteBuffer.get() & 128) == 128 ? true : null;
    }

    public final ByteBuffer mo2528b() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) (this.f15225a ? 128 : 0));
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                TemporalLevelEntry temporalLevelEntry = (TemporalLevelEntry) obj;
                return this.f15225a == temporalLevelEntry.f15225a && this.f15226b == temporalLevelEntry.f15226b;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.f15225a) + this.f15226b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemporalLevelEntry");
        stringBuilder.append("{levelIndependentlyDecodable=");
        stringBuilder.append(this.f15225a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
