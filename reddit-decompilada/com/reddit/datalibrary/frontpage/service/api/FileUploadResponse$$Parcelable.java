package com.reddit.datalibrary.frontpage.service.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

public class FileUploadResponse$$Parcelable implements Parcelable, ParcelWrapper<FileUploadResponse> {
    public static final Creator<FileUploadResponse$$Parcelable> CREATOR = new C17541();
    private FileUploadResponse fileUploadResponse$$0;

    /* compiled from: FileUploadResponse$$Parcelable */
    static class C17541 implements Creator<FileUploadResponse$$Parcelable> {
        C17541() {
        }

        public final FileUploadResponse$$Parcelable createFromParcel(Parcel parcel) {
            return new FileUploadResponse$$Parcelable(FileUploadResponse$$Parcelable.read(parcel, new IdentityCollection()));
        }

        public final FileUploadResponse$$Parcelable[] newArray(int i) {
            return new FileUploadResponse$$Parcelable[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public FileUploadResponse$$Parcelable(FileUploadResponse fileUploadResponse) {
        this.fileUploadResponse$$0 = fileUploadResponse;
    }

    public void writeToParcel(Parcel parcel, int i) {
        write(this.fileUploadResponse$$0, parcel, i, new IdentityCollection());
    }

    public static void write(FileUploadResponse fileUploadResponse, Parcel parcel, int i, IdentityCollection identityCollection) {
        i = identityCollection.m28663b((Object) fileUploadResponse);
        if (i != -1) {
            parcel.writeInt(i);
            return;
        }
        parcel.writeInt(identityCollection.m28660a((Object) fileUploadResponse));
        parcel.writeInt(fileUploadResponse.success);
        parcel.writeString(fileUploadResponse.fileUrl);
        parcel.writeString(fileUploadResponse.fileKey);
    }

    public FileUploadResponse getParcel() {
        return this.fileUploadResponse$$0;
    }

    public static FileUploadResponse read(Parcel parcel, IdentityCollection identityCollection) {
        int readInt = parcel.readInt();
        if (!identityCollection.m28662a(readInt)) {
            int a = identityCollection.m28660a(IdentityCollection.f27202a);
            FileUploadResponse fileUploadResponse = new FileUploadResponse();
            identityCollection.m28661a(a, fileUploadResponse);
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            fileUploadResponse.success = z;
            fileUploadResponse.fileUrl = parcel.readString();
            fileUploadResponse.fileKey = parcel.readString();
            identityCollection.m28661a(readInt, fileUploadResponse);
            return fileUploadResponse;
        } else if (identityCollection.m28664b(readInt) == null) {
            return (FileUploadResponse) identityCollection.m28665c(readInt);
        } else {
            throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
        }
    }
}
