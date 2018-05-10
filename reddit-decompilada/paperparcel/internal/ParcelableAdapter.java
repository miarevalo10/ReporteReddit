package paperparcel.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import paperparcel.TypeAdapter;

public final class ParcelableAdapter<T extends Parcelable> implements TypeAdapter<T> {
    private final Creator<T> f41563a = null;

    public final /* synthetic */ void mo7873a(Object obj, Parcel parcel, int i) {
        Parcelable parcelable = (Parcelable) obj;
        if (this.f41563a == null) {
            parcel.writeParcelable(parcelable, i);
        } else if (parcelable == null) {
            parcel.writeInt(null);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }

    public final /* synthetic */ Object mo7872a(Parcel parcel) {
        if (this.f41563a == null) {
            return parcel.readParcelable(ParcelableAdapter.class.getClassLoader());
        }
        Object obj = null;
        if (parcel.readInt() == 1) {
            obj = (Parcelable) this.f41563a.createFromParcel(parcel);
        }
        return obj;
    }
}
