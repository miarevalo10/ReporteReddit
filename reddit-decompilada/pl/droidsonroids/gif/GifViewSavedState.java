package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class GifViewSavedState extends BaseSavedState {
    public static final Creator<GifViewSavedState> CREATOR = new C30611();
    final long[][] f41196a;

    static class C30611 implements Creator<GifViewSavedState> {
        C30611() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GifViewSavedState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel);
        }
    }

    GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f41196a = new long[2][];
        for (int i = 0; i < 2; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof GifDrawable) {
                this.f41196a[i] = ((GifDrawable) drawable).f41153f.m43265k();
            } else {
                this.f41196a[i] = null;
            }
        }
    }

    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f41196a = new long[parcel.readInt()][];
        for (int i = 0; i < this.f41196a.length; i++) {
            this.f41196a[i] = parcel.createLongArray();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f41196a.length);
        for (long[] writeLongArray : this.f41196a) {
            parcel.writeLongArray(writeLongArray);
        }
    }

    final void m43272a(Drawable drawable, int i) {
        if (this.f41196a[i] != null && (drawable instanceof GifDrawable)) {
            GifDrawable gifDrawable = (GifDrawable) drawable;
            gifDrawable.m43246a((long) gifDrawable.f41153f.m43252a(this.f41196a[i], gifDrawable.f41152e));
        }
    }
}
