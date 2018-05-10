package com.bluelinelabs.conductor.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

public class StringSparseArrayParceler implements Parcelable {
    public static final Creator<StringSparseArrayParceler> CREATOR = new C02601();
    final SparseArray<String> f3175a;

    static class C02601 implements Creator<StringSparseArrayParceler> {
        C02601() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StringSparseArrayParceler[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new StringSparseArrayParceler(parcel);
        }
    }

    public int describeContents() {
        return 0;
    }

    public StringSparseArrayParceler(SparseArray<String> sparseArray) {
        this.f3175a = sparseArray;
    }

    private StringSparseArrayParceler(Parcel parcel) {
        this.f3175a = new SparseArray();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f3175a.put(parcel.readInt(), parcel.readString());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = this.f3175a.size();
        parcel.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            int keyAt = this.f3175a.keyAt(i2);
            parcel.writeInt(keyAt);
            parcel.writeString((String) this.f3175a.get(keyAt));
        }
    }
}
