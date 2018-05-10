package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Creator<SpliceScheduleCommand> CREATOR = new C04061();
    public final List<Event> f16908a;

    static class C04061 implements Creator<SpliceScheduleCommand> {
        C04061() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }
    }

    public static final class ComponentSplice {
        public final int f4674a;
        public final long f4675b;

        private ComponentSplice(int i, long j) {
            this.f4674a = i;
            this.f4675b = j;
        }

        static /* synthetic */ void m3916a(ComponentSplice componentSplice, Parcel parcel) {
            parcel.writeInt(componentSplice.f4674a);
            parcel.writeLong(componentSplice.f4675b);
        }
    }

    public static final class Event {
        public final long f4676a;
        public final boolean f4677b;
        public final boolean f4678c;
        public final boolean f4679d;
        public final long f4680e;
        public final List<ComponentSplice> f4681f;
        public final boolean f4682g;
        public final long f4683h;
        public final int f4684i;
        public final int f4685j;
        public final int f4686k;

        private Event(long j, boolean z, boolean z2, boolean z3, List<ComponentSplice> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.f4676a = j;
            this.f4677b = z;
            this.f4678c = z2;
            this.f4679d = z3;
            this.f4681f = Collections.unmodifiableList(list);
            this.f4680e = j2;
            this.f4682g = z4;
            this.f4683h = j3;
            this.f4684i = i;
            this.f4685j = i2;
            this.f4686k = i3;
        }

        private Event(Parcel parcel) {
            this.f4676a = parcel.readLong();
            boolean z = false;
            this.f4677b = parcel.readByte() == (byte) 1;
            this.f4678c = parcel.readByte() == (byte) 1;
            this.f4679d = parcel.readByte() == (byte) 1;
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(new ComponentSplice(parcel.readInt(), parcel.readLong()));
            }
            this.f4681f = Collections.unmodifiableList(arrayList);
            this.f4680e = parcel.readLong();
            if (parcel.readByte() == (byte) 1) {
                z = true;
            }
            this.f4682g = z;
            this.f4683h = parcel.readLong();
            this.f4684i = parcel.readInt();
            this.f4685j = parcel.readInt();
            this.f4686k = parcel.readInt();
        }

        static /* synthetic */ Event m3918a(ParsableByteArray parsableByteArray) {
            List list;
            boolean z;
            boolean z2;
            int i;
            int i2;
            int i3;
            long j;
            long j2;
            long h = parsableByteArray.m4257h();
            boolean z3 = false;
            boolean z4 = (parsableByteArray.m4250d() & 128) != 0;
            ArrayList arrayList = new ArrayList();
            if (z4) {
                list = arrayList;
                z = false;
                z2 = z;
                i = z2;
                i2 = i;
                i3 = i2;
                j = -9223372036854775807L;
                j2 = -9223372036854775807L;
            } else {
                ArrayList arrayList2;
                int d = parsableByteArray.m4250d();
                z = (d & 128) != 0;
                z2 = (d & 64) != 0;
                boolean z5 = (d & 32) != 0;
                long h2 = z2 ? parsableByteArray.m4257h() : -9223372036854775807L;
                if (z2) {
                    arrayList2 = arrayList;
                } else {
                    int d2 = parsableByteArray.m4250d();
                    arrayList2 = new ArrayList(d2);
                    for (int i4 = 0; i4 < d2; i4++) {
                        arrayList2.add(new ComponentSplice(parsableByteArray.m4250d(), parsableByteArray.m4257h()));
                    }
                }
                if (z5) {
                    long d3 = (long) parsableByteArray.m4250d();
                    if ((d3 & 128) != 0) {
                        z3 = true;
                    }
                    j2 = ((d3 & 1) << 32) | parsableByteArray.m4257h();
                } else {
                    j2 = -9223372036854775807L;
                }
                j = h2;
                i = parsableByteArray.m4252e();
                i2 = parsableByteArray.m4250d();
                boolean z6 = z;
                z = z3;
                z3 = z6;
                ArrayList arrayList3 = arrayList2;
                i3 = parsableByteArray.m4250d();
                list = arrayList3;
            }
            return new Event(h, z4, z3, z2, list, j, z, j2, i, i2, i3);
        }

        static /* synthetic */ void m3919a(Event event, Parcel parcel) {
            parcel.writeLong(event.f4676a);
            parcel.writeByte((byte) event.f4677b);
            parcel.writeByte((byte) event.f4678c);
            parcel.writeByte((byte) event.f4679d);
            int size = event.f4681f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                ComponentSplice.m3916a((ComponentSplice) event.f4681f.get(i), parcel);
            }
            parcel.writeLong(event.f4680e);
            parcel.writeByte((byte) event.f4682g);
            parcel.writeLong(event.f4683h);
            parcel.writeInt(event.f4684i);
            parcel.writeInt(event.f4685j);
            parcel.writeInt(event.f4686k);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.f16908a = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new Event(parcel));
        }
        this.f16908a = Collections.unmodifiableList(arrayList);
    }

    static SpliceScheduleCommand m17191a(ParsableByteArray parsableByteArray) {
        int d = parsableByteArray.m4250d();
        List arrayList = new ArrayList(d);
        for (int i = 0; i < d; i++) {
            arrayList.add(Event.m3918a(parsableByteArray));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = this.f16908a.size();
        parcel.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            Event.m3919a((Event) this.f16908a.get(i2), parcel);
        }
    }
}
