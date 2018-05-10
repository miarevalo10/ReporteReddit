package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class RateShareEntry extends GroupEntry {
    private short f15218a;
    private short f15219b;
    private List<Entry> f15220c = new LinkedList();
    private int f15221d;
    private int f15222e;
    private short f15223f;

    public static class Entry {
        int f8982a;
        short f8983b;

        public Entry(int i, short s) {
            this.f8982a = i;
            this.f8983b = s;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{availableBitrate=");
            stringBuilder.append(this.f8982a);
            stringBuilder.append(", targetRateShare=");
            stringBuilder.append(this.f8983b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Entry entry = (Entry) obj;
                    return this.f8982a == entry.f8982a && this.f8983b == entry.f8983b;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * this.f8982a) + this.f8983b;
        }
    }

    public final String mo2526a() {
        return "rash";
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        this.f15218a = byteBuffer.getShort();
        if (this.f15218a == (short) 1) {
            this.f15219b = byteBuffer.getShort();
        } else {
            int i = this.f15218a;
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                this.f15220c.add(new Entry(CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer)), byteBuffer.getShort()));
                i = i2;
            }
        }
        this.f15221d = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.f15222e = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.f15223f = (short) IsoTypeReader.m3284d(byteBuffer);
    }

    public final ByteBuffer mo2528b() {
        ByteBuffer allocate = ByteBuffer.allocate(this.f15218a == (short) 1 ? 13 : (this.f15218a * 6) + 11);
        allocate.putShort(this.f15218a);
        if (this.f15218a == (short) 1) {
            allocate.putShort(this.f15219b);
        } else {
            for (Entry entry : this.f15220c) {
                allocate.putInt(entry.f8982a);
                allocate.putShort(entry.f8983b);
            }
        }
        allocate.putInt(this.f15221d);
        allocate.putInt(this.f15222e);
        IsoTypeWriter.m3303c(allocate, this.f15223f);
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                RateShareEntry rateShareEntry = (RateShareEntry) obj;
                if (this.f15223f != rateShareEntry.f15223f || this.f15221d != rateShareEntry.f15221d || this.f15222e != rateShareEntry.f15222e || this.f15218a != rateShareEntry.f15218a || this.f15219b != rateShareEntry.f15219b) {
                    return false;
                }
                if (this.f15220c == null) {
                    return rateShareEntry.f15220c == null;
                } else {
                    if (this.f15220c.equals(rateShareEntry.f15220c) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((((((((this.f15218a * 31) + this.f15219b) * 31) + (this.f15220c != null ? this.f15220c.hashCode() : 0)) * 31) + this.f15221d) * 31) + this.f15222e)) + this.f15223f;
    }
}
