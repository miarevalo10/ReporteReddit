package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<ParcelFileDescriptor> {
    protected final /* synthetic */ void mo3264a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    public FileDescriptorAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public final Class<ParcelFileDescriptor> mo887c() {
        return ParcelFileDescriptor.class;
    }

    protected final /* synthetic */ Object mo3263a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
