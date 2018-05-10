package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class PrivateCommand extends SpliceCommand {
    public static final Creator<PrivateCommand> CREATOR = new C04031();
    public final long f16892a;
    public final long f16893b;
    public final byte[] f16894c;

    static class C04031 implements Creator<PrivateCommand> {
        C04031() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PrivateCommand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }
    }

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.f16892a = j2;
        this.f16893b = j;
        this.f16894c = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f16892a = parcel.readLong();
        this.f16893b = parcel.readLong();
        this.f16894c = new byte[parcel.readInt()];
        parcel.readByteArray(this.f16894c);
    }

    static PrivateCommand m17189a(ParsableByteArray parsableByteArray, int i, long j) {
        long h = parsableByteArray.m4257h();
        byte[] bArr = new byte[(i - 4)];
        parsableByteArray.m4245a(bArr, 0, bArr.length);
        return new PrivateCommand(h, bArr, j);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f16892a);
        parcel.writeLong(this.f16893b);
        parcel.writeInt(this.f16894c.length);
        parcel.writeByteArray(this.f16894c);
    }
}
