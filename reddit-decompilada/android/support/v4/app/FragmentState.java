package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C00891();
    final String f1004a;
    final int f1005b;
    final boolean f1006c;
    final int f1007d;
    final int f1008e;
    final String f1009f;
    final boolean f1010g;
    final boolean f1011h;
    final Bundle f1012i;
    final boolean f1013j;
    Bundle f1014k;
    Fragment f1015l;

    static class C00891 implements Creator<FragmentState> {
        C00891() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }
    }

    public final int describeContents() {
        return 0;
    }

    FragmentState(Fragment fragment) {
        this.f1004a = fragment.getClass().getName();
        this.f1005b = fragment.mIndex;
        this.f1006c = fragment.mFromLayout;
        this.f1007d = fragment.mFragmentId;
        this.f1008e = fragment.mContainerId;
        this.f1009f = fragment.mTag;
        this.f1010g = fragment.mRetainInstance;
        this.f1011h = fragment.mDetached;
        this.f1012i = fragment.mArguments;
        this.f1013j = fragment.mHidden;
    }

    FragmentState(Parcel parcel) {
        this.f1004a = parcel.readString();
        this.f1005b = parcel.readInt();
        boolean z = false;
        this.f1006c = parcel.readInt() != 0;
        this.f1007d = parcel.readInt();
        this.f1008e = parcel.readInt();
        this.f1009f = parcel.readString();
        this.f1010g = parcel.readInt() != 0;
        this.f1011h = parcel.readInt() != 0;
        this.f1012i = parcel.readBundle();
        if (parcel.readInt() != 0) {
            z = true;
        }
        this.f1013j = z;
        this.f1014k = parcel.readBundle();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1004a);
        parcel.writeInt(this.f1005b);
        parcel.writeInt(this.f1006c);
        parcel.writeInt(this.f1007d);
        parcel.writeInt(this.f1008e);
        parcel.writeString(this.f1009f);
        parcel.writeInt(this.f1010g);
        parcel.writeInt(this.f1011h);
        parcel.writeBundle(this.f1012i);
        parcel.writeInt(this.f1013j);
        parcel.writeBundle(this.f1014k);
    }
}
