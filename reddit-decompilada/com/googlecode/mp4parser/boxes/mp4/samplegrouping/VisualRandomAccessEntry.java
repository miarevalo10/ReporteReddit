package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

public class VisualRandomAccessEntry extends GroupEntry {
    private boolean f15229a;
    private short f15230b;

    public final String mo2526a() {
        return "rap ";
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.get();
        this.f15229a = (byteBuffer & 128) == 128;
        this.f15230b = (short) (byteBuffer & 127);
    }

    public final ByteBuffer mo2528b() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) ((this.f15229a ? 128 : 0) | (this.f15230b & 127)));
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                VisualRandomAccessEntry visualRandomAccessEntry = (VisualRandomAccessEntry) obj;
                return this.f15230b == visualRandomAccessEntry.f15230b && this.f15229a == visualRandomAccessEntry.f15229a;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.f15229a) + this.f15230b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VisualRandomAccessEntry");
        stringBuilder.append("{numLeadingSamplesKnown=");
        stringBuilder.append(this.f15229a);
        stringBuilder.append(", numLeadingSamples=");
        stringBuilder.append(this.f15230b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
