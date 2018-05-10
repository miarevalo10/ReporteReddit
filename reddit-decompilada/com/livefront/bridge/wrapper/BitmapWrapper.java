package com.livefront.bridge.wrapper;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.ByteArrayOutputStream;

class BitmapWrapper implements Parcelable {
    public static final Creator<BitmapWrapper> CREATOR = new C08261();
    Bitmap f10034a;

    static class C08261 implements Creator<BitmapWrapper> {
        C08261() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BitmapWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BitmapWrapper(parcel);
        }
    }

    public int describeContents() {
        return 0;
    }

    public BitmapWrapper(Bitmap bitmap) {
        this.f10034a = bitmap;
    }

    protected BitmapWrapper(Parcel parcel) {
        parcel = parcel.createByteArray();
        this.f10034a = BitmapFactory.decodeByteArray(parcel, 0, parcel.length);
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = new ByteArrayOutputStream();
        this.f10034a.compress(CompressFormat.PNG, 100, i);
        parcel.writeByteArray(i.toByteArray());
    }
}
