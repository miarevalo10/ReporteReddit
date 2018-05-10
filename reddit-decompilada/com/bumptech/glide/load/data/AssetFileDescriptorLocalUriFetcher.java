package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class AssetFileDescriptorLocalUriFetcher extends LocalUriFetcher<AssetFileDescriptor> {
    protected final /* synthetic */ void mo3262a(Object obj) throws IOException {
        ((AssetFileDescriptor) obj).close();
    }

    public AssetFileDescriptorLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<AssetFileDescriptor> mo887c() {
        return AssetFileDescriptor.class;
    }

    protected final /* synthetic */ Object mo3261a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        contentResolver = contentResolver.openAssetFileDescriptor(uri, "r");
        if (contentResolver != null) {
            return contentResolver;
        }
        StringBuilder stringBuilder = new StringBuilder("FileDescriptor is null for: ");
        stringBuilder.append(uri);
        throw new FileNotFoundException(stringBuilder.toString());
    }
}
