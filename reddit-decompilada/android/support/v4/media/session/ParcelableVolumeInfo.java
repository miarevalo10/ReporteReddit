package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C01141();
    public int f1298a;
    public int f1299b;
    public int f1300c;
    public int f1301d;
    public int f1302e;

    static class C01141 implements Creator<ParcelableVolumeInfo> {
        C01141() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }
    }

    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f1298a = parcel.readInt();
        this.f1300c = parcel.readInt();
        this.f1301d = parcel.readInt();
        this.f1302e = parcel.readInt();
        this.f1299b = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1298a);
        parcel.writeInt(this.f1300c);
        parcel.writeInt(this.f1301d);
        parcel.writeInt(this.f1302e);
        parcel.writeInt(this.f1299b);
    }
}
