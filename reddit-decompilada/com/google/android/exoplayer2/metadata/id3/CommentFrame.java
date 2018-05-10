package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.Util;

public final class CommentFrame extends Id3Frame {
    public static final Creator<CommentFrame> CREATOR = new C03981();
    public final String f16879a;
    public final String f16880b;
    public final String f16881c;

    static class C03981 implements Creator<CommentFrame> {
        C03981() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommentFrame[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }
    }

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f16879a = str;
        this.f16880b = str2;
        this.f16881c = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.f16879a = parcel.readString();
        this.f16880b = parcel.readString();
        this.f16881c = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                CommentFrame commentFrame = (CommentFrame) obj;
                return Util.m4313a(this.f16880b, commentFrame.f16880b) && Util.m4313a(this.f16879a, commentFrame.f16879a) && Util.m4313a(this.f16881c, commentFrame.f16881c) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = 31 * (((527 + (this.f16879a != null ? this.f16879a.hashCode() : 0)) * 31) + (this.f16880b != null ? this.f16880b.hashCode() : 0));
        if (this.f16881c != null) {
            i = this.f16881c.hashCode();
        }
        return hashCode + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f16879a);
        parcel.writeString(this.f16881c);
    }
}
