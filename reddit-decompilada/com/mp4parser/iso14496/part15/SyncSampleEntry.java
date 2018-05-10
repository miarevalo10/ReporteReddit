package com.mp4parser.iso14496.part15;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;

public class SyncSampleEntry extends GroupEntry {
    int f15610a;
    int f15611b;

    public final String mo2526a() {
        return "sync";
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        byteBuffer = IsoTypeReader.m3284d(byteBuffer);
        this.f15610a = (byteBuffer & JpegConst.SOF0) >> 6;
        this.f15611b = byteBuffer & 63;
    }

    public final ByteBuffer mo2528b() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        IsoTypeWriter.m3303c(allocate, this.f15611b + (this.f15610a << 6));
        return (ByteBuffer) allocate.rewind();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                SyncSampleEntry syncSampleEntry = (SyncSampleEntry) obj;
                return this.f15611b == syncSampleEntry.f15611b && this.f15610a == syncSampleEntry.f15610a;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.f15610a) + this.f15611b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SyncSampleEntry{reserved=");
        stringBuilder.append(this.f15610a);
        stringBuilder.append(", nalUnitType=");
        stringBuilder.append(this.f15611b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
