package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Creator<ChapterFrame> CREATOR = new C03961();
    public final String f16868a;
    public final int f16869b;
    public final int f16870c;
    public final long f16871d;
    public final long f16872e;
    private final Id3Frame[] f16873g;

    static class C03961 implements Creator<ChapterFrame> {
        C03961() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ChapterFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f16868a = str;
        this.f16869b = i;
        this.f16870c = i2;
        this.f16871d = j;
        this.f16872e = j2;
        this.f16873g = id3FrameArr;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f16868a = parcel.readString();
        this.f16869b = parcel.readInt();
        this.f16870c = parcel.readInt();
        this.f16871d = parcel.readLong();
        this.f16872e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f16873g = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f16873g[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ChapterFrame chapterFrame = (ChapterFrame) obj;
                return this.f16869b == chapterFrame.f16869b && this.f16870c == chapterFrame.f16870c && this.f16871d == chapterFrame.f16871d && this.f16872e == chapterFrame.f16872e && Util.m4313a(this.f16868a, chapterFrame.f16868a) && Arrays.equals(this.f16873g, chapterFrame.f16873g) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (31 * (((((((527 + this.f16869b) * 31) + this.f16870c) * 31) + ((int) this.f16871d)) * 31) + ((int) this.f16872e))) + (this.f16868a != null ? this.f16868a.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16868a);
        parcel.writeInt(this.f16869b);
        parcel.writeInt(this.f16870c);
        parcel.writeLong(this.f16871d);
        parcel.writeLong(this.f16872e);
        parcel.writeInt(this.f16873g.length);
        for (Parcelable writeParcelable : this.f16873g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
