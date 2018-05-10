package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor> {
    protected final /* synthetic */ void mo3262a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    public FileDescriptorLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<ParcelFileDescriptor> mo887c() {
        return ParcelFileDescriptor.class;
    }

    protected final /* synthetic */ Object mo3261a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        contentResolver = contentResolver.openAssetFileDescriptor(uri, "r");
        if (contentResolver != null) {
            return contentResolver.getParcelFileDescriptor();
        }
        StringBuilder stringBuilder = new StringBuilder("FileDescriptor is null for: ");
        stringBuilder.append(uri);
        throw new FileNotFoundException(stringBuilder.toString());
    }
}
