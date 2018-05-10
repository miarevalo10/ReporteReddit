package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Creator<Metadata> CREATOR = new C03921();
    public final Entry[] f4666a;

    static class C03921 implements Creator<Metadata> {
        C03921() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Metadata[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }
    }

    public interface Entry extends Parcelable {
    }

    public final int describeContents() {
        return 0;
    }

    public Metadata(Entry... entryArr) {
        this.f4666a = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        this.f4666a = new Entry[list.size()];
        list.toArray(this.f4666a);
    }

    Metadata(Parcel parcel) {
        this.f4666a = new Entry[parcel.readInt()];
        for (int i = 0; i < this.f4666a.length; i++) {
            this.f4666a[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return Arrays.equals(this.f4666a, ((Metadata) obj).f4666a);
            }
        }
        return null;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4666a);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4666a.length);
        for (Parcelable writeParcelable : this.f4666a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
