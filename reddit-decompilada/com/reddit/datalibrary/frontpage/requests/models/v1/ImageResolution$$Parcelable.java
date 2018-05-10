package com.reddit.datalibrary.frontpage.requests.models.v1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import net.hockeyapp.android.UpdateFragment;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class ImageResolution$$Parcelable implements Parcelable, ParcelWrapper<ImageResolution> {
    public static final Creator<ImageResolution$$Parcelable> CREATOR = new C09551();
    private ImageResolution imageResolution$$0;

    /* compiled from: ImageResolution$$Parcelable */
    static class C09551 implements Creator<ImageResolution$$Parcelable> {
        C09551() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ImageResolution$$Parcelable[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ImageResolution$$Parcelable(ImageResolution$$Parcelable.read(parcel, new IdentityCollection()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public ImageResolution$$Parcelable(ImageResolution imageResolution) {
        this.imageResolution$$0 = imageResolution;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.imageResolution$$0, parcel, i, new IdentityCollection());
    }

    public static void write(ImageResolution imageResolution, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.b(imageResolution);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.a(imageResolution));
        i = Integer.TYPE;
        parcel.writeInt(((Integer) InjectionUtil.a(ImageResolution.class, imageResolution, "width")).intValue());
        parcel.writeString((String) InjectionUtil.a(ImageResolution.class, imageResolution, UpdateFragment.FRAGMENT_URL));
        i = Integer.TYPE;
        parcel.writeInt(((Integer) InjectionUtil.a(ImageResolution.class, imageResolution, "height")).intValue());
    }

    public ImageResolution getParcel() {
        return this.imageResolution$$0;
    }

    public static ImageResolution read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.a(readInt)) {
            int a = identityCollection.a(IdentityCollection.a);
            ImageResolution imageResolution = new ImageResolution();
            identityCollection.a(a, imageResolution);
            InjectionUtil.a(ImageResolution.class, imageResolution, "width", Integer.valueOf(parcel.readInt()));
            InjectionUtil.a(ImageResolution.class, imageResolution, UpdateFragment.FRAGMENT_URL, parcel.readString());
            InjectionUtil.a(ImageResolution.class, imageResolution, "height", Integer.valueOf(parcel.readInt()));
            identityCollection.a(readInt, imageResolution);
            return imageResolution;
        } else if (identityCollection.b(readInt) == null) {
            return (ImageResolution) identityCollection.c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
