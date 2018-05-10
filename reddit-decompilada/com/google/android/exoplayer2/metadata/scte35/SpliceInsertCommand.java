package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Creator<SpliceInsertCommand> CREATOR = new C04041();
    public final long f16895a;
    public final boolean f16896b;
    public final boolean f16897c;
    public final boolean f16898d;
    public final boolean f16899e;
    public final long f16900f;
    public final long f16901g;
    public final List<ComponentSplice> f16902h;
    public final boolean f16903i;
    public final long f16904j;
    public final int f16905k;
    public final int f16906l;
    public final int f16907m;

    static class C04041 implements Creator<SpliceInsertCommand> {
        C04041() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SpliceInsertCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }
    }

    public static final class ComponentSplice {
        public final int f4671a;
        public final long f4672b;
        public final long f4673c;

        private ComponentSplice(int i, long j, long j2) {
            this.f4671a = i;
            this.f4672b = j;
            this.f4673c = j2;
        }

        public static ComponentSplice m3914a(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<ComponentSplice> list, boolean z5, long j4, int i, int i2, int i3) {
        this.f16895a = j;
        this.f16896b = z;
        this.f16897c = z2;
        this.f16898d = z3;
        this.f16899e = z4;
        this.f16900f = j2;
        this.f16901g = j3;
        this.f16902h = Collections.unmodifiableList(list);
        this.f16903i = z5;
        this.f16904j = j4;
        this.f16905k = i;
        this.f16906l = i2;
        this.f16907m = i3;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f16895a = parcel.readLong();
        boolean z = false;
        this.f16896b = parcel.readByte() == (byte) 1;
        this.f16897c = parcel.readByte() == (byte) 1;
        this.f16898d = parcel.readByte() == (byte) 1;
        this.f16899e = parcel.readByte() == (byte) 1;
        this.f16900f = parcel.readLong();
        this.f16901g = parcel.readLong();
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(ComponentSplice.m3914a(parcel));
        }
        this.f16902h = Collections.unmodifiableList(arrayList);
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        this.f16903i = z;
        this.f16904j = parcel.readLong();
        this.f16905k = parcel.readInt();
        this.f16906l = parcel.readInt();
        this.f16907m = parcel.readInt();
    }

    static SpliceInsertCommand m17190a(ParsableByteArray parsableByteArray, long j, TimestampAdjuster timestampAdjuster) {
        List list;
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        boolean z4;
        long j3;
        int i;
        int i2;
        int i3;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        long h = parsableByteArray.m4257h();
        boolean z5 = (parsableByteArray.m4250d() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z5) {
            list = emptyList;
            z = false;
            z2 = false;
            z3 = false;
            j2 = -9223372036854775807L;
            z4 = false;
            j3 = -9223372036854775807L;
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            List list2;
            int i4;
            boolean z6;
            long h2;
            int d = parsableByteArray.m4250d();
            boolean z7 = (d & 128) != 0;
            boolean z8 = (d & 64) != 0;
            Object obj = (d & 32) != 0 ? 1 : null;
            boolean z9 = (d & 16) != 0;
            j3 = (!z8 || z9) ? -9223372036854775807L : TimeSignalCommand.m17192a(parsableByteArray, j);
            if (z8) {
                list2 = emptyList;
            } else {
                int d2 = parsableByteArray.m4250d();
                list2 = new ArrayList(d2);
                i4 = 0;
                while (i4 < d2) {
                    int i5;
                    long j4;
                    int d3 = parsableByteArray.m4250d();
                    if (z9) {
                        i5 = d2;
                        j4 = -9223372036854775807L;
                    } else {
                        i5 = d2;
                        j4 = TimeSignalCommand.m17192a(parsableByteArray, j);
                    }
                    list2.add(new ComponentSplice(d3, j4, timestampAdjuster2.m4286b(j4)));
                    i4++;
                    d2 = i5;
                }
            }
            if (obj != null) {
                long d4 = (long) parsableByteArray.m4250d();
                z6 = (128 & d4) != 0;
                h2 = ((d4 & 1) << 32) | parsableByteArray.m4257h();
            } else {
                z6 = false;
                h2 = -9223372036854775807L;
            }
            i4 = parsableByteArray.m4252e();
            i2 = parsableByteArray.m4250d();
            i3 = parsableByteArray.m4250d();
            z3 = z9;
            z2 = z8;
            j2 = j3;
            list = list2;
            z4 = z6;
            j3 = h2;
            i = i4;
            z = z7;
        }
        return new SpliceInsertCommand(h, z5, z, z2, z3, j2, timestampAdjuster2.m4286b(j2), list, z4, j3, i, i2, i3);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f16895a);
        parcel.writeByte((byte) this.f16896b);
        parcel.writeByte((byte) this.f16897c);
        parcel.writeByte((byte) this.f16898d);
        parcel.writeByte((byte) this.f16899e);
        parcel.writeLong(this.f16900f);
        parcel.writeLong(this.f16901g);
        i = this.f16902h.size();
        parcel.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            ComponentSplice componentSplice = (ComponentSplice) this.f16902h.get(i2);
            parcel.writeInt(componentSplice.f4671a);
            parcel.writeLong(componentSplice.f4672b);
            parcel.writeLong(componentSplice.f4673c);
        }
        parcel.writeByte((byte) this.f16903i);
        parcel.writeLong(this.f16904j);
        parcel.writeInt(this.f16905k);
        parcel.writeInt(this.f16906l);
        parcel.writeInt(this.f16907m);
    }
}
