package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C01101();
    private final int f1276a;
    private final float f1277b;

    static class C01101 implements Creator<RatingCompat> {
        C01101() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RatingCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }
    }

    RatingCompat(int i, float f) {
        this.f1276a = i;
        this.f1277b = f;
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder("Rating:style=");
        stringBuilder.append(this.f1276a);
        stringBuilder.append(" rating=");
        if (this.f1277b < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.f1277b);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return this.f1276a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1276a);
        parcel.writeFloat(this.f1277b);
    }
}
