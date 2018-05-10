package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Creator<ChapterTocFrame> CREATOR = new C03971();
    public final String f16874a;
    public final boolean f16875b;
    public final boolean f16876c;
    public final String[] f16877d;
    private final Id3Frame[] f16878e;

    static class C03971 implements Creator<ChapterTocFrame> {
        C03971() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ChapterTocFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f16874a = str;
        this.f16875b = z;
        this.f16876c = z2;
        this.f16877d = strArr;
        this.f16878e = id3FrameArr;
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f16874a = parcel.readString();
        int i = 0;
        boolean z = true;
        this.f16875b = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.f16876c = z;
        this.f16877d = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f16878e = new Id3Frame[readInt];
        while (i < readInt) {
            this.f16878e[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
                return this.f16875b == chapterTocFrame.f16875b && this.f16876c == chapterTocFrame.f16876c && Util.m4313a(this.f16874a, chapterTocFrame.f16874a) && Arrays.equals(this.f16877d, chapterTocFrame.f16877d) && Arrays.equals(this.f16878e, chapterTocFrame.f16878e) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (((527 + this.f16875b) * 31) + this.f16876c)) + (this.f16874a != null ? this.f16874a.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16874a);
        parcel.writeByte((byte) this.f16875b);
        parcel.writeByte((byte) this.f16876c);
        parcel.writeStringArray(this.f16877d);
        parcel.writeInt(this.f16878e.length);
        for (Parcelable writeParcelable : this.f16878e) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
