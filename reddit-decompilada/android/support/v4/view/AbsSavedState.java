package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = new C01242();
    public static final AbsSavedState EMPTY_STATE = new C10081();
    private final Parcelable mSuperState;

    static class C01242 implements ClassLoaderCreator<AbsSavedState> {
        C01242() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return C01242.m1071a(parcel, classLoader);
        }

        private static AbsSavedState m1071a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.EMPTY_STATE;
            }
            throw new IllegalStateException("superState must be null");
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AbsSavedState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return C01242.m1071a(parcel, null);
        }
    }

    static class C10081 extends AbsSavedState {
        C10081() {
            super();
        }
    }

    public int describeContents() {
        return 0;
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == EMPTY_STATE) {
            parcelable = null;
        }
        this.mSuperState = parcelable;
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        parcel = parcel.readParcelable(classLoader);
        if (parcel == null) {
            parcel = EMPTY_STATE;
        }
        this.mSuperState = parcel;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}
