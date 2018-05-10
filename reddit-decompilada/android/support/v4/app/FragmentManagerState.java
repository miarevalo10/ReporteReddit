package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: FragmentManager */
final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C00881();
    FragmentState[] f999a;
    int[] f1000b;
    BackStackState[] f1001c;
    int f1002d = -1;
    int f1003e;

    /* compiled from: FragmentManager */
    static class C00881 implements Creator<FragmentManagerState> {
        C00881() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public FragmentManagerState(Parcel parcel) {
        this.f999a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f1000b = parcel.createIntArray();
        this.f1001c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f1002d = parcel.readInt();
        this.f1003e = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f999a, i);
        parcel.writeIntArray(this.f1000b);
        parcel.writeTypedArray(this.f1001c, i);
        parcel.writeInt(this.f1002d);
        parcel.writeInt(this.f1003e);
    }
}
