package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Creator<TimeSignalCommand> CREATOR = new C04071();
    public final long f16909a;
    public final long f16910b;

    static class C04071 implements Creator<TimeSignalCommand> {
        C04071() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimeSignalCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }
    }

    private TimeSignalCommand(long j, long j2) {
        this.f16909a = j;
        this.f16910b = j2;
    }

    static TimeSignalCommand m17193a(ParsableByteArray parsableByteArray, long j, TimestampAdjuster timestampAdjuster) {
        parsableByteArray = m17192a(parsableByteArray, j);
        return new TimeSignalCommand(parsableByteArray, timestampAdjuster.m4286b(parsableByteArray));
    }

    static long m17192a(ParsableByteArray parsableByteArray, long j) {
        long d = (long) parsableByteArray.m4250d();
        return (128 & d) != 0 ? -1 & ((((d & 1) << 32) | parsableByteArray.m4257h()) + j) : 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f16909a);
        parcel.writeLong(this.f16910b);
    }
}
