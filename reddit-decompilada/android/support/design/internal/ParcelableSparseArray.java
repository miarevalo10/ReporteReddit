package android.support.design.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Creator<ParcelableSparseArray> CREATOR = new C00181();

    static class C00181 implements ClassLoaderCreator<ParcelableSparseArray> {
        C00181() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ParcelableSparseArray(parcel, classLoader);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableSparseArray[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelableSparseArray(parcel, null);
        }
    }

    public int describeContents() {
        return 0;
    }

    public ParcelableSparseArray(Parcel parcel, ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        parcel = parcel.readParcelableArray(classLoader);
        for (classLoader = null; classLoader < readInt; classLoader++) {
            put(iArr[classLoader], parcel[classLoader]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = keyAt(i2);
            parcelableArr[i2] = (Parcelable) valueAt(i2);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
