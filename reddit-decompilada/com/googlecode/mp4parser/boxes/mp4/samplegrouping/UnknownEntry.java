package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.coremedia.iso.Hex;
import java.nio.ByteBuffer;

public class UnknownEntry extends GroupEntry {
    private ByteBuffer f15227a;
    private String f15228b;

    public UnknownEntry(String str) {
        this.f15228b = str;
    }

    public final String mo2526a() {
        return this.f15228b;
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        this.f15227a = (ByteBuffer) byteBuffer.duplicate().rewind();
    }

    public final ByteBuffer mo2528b() {
        return this.f15227a.duplicate();
    }

    public String toString() {
        ByteBuffer duplicate = this.f15227a.duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        StringBuilder stringBuilder = new StringBuilder("UnknownEntry{content=");
        stringBuilder.append(Hex.m3277a(bArr));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                UnknownEntry unknownEntry = (UnknownEntry) obj;
                if (this.f15227a == null) {
                    return unknownEntry.f15227a == null;
                } else {
                    if (this.f15227a.equals(unknownEntry.f15227a) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f15227a != null ? this.f15227a.hashCode() : 0;
    }
}
