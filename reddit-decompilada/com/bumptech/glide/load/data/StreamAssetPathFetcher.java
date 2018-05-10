package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    protected final /* synthetic */ void mo3264a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public final Class<InputStream> mo887c() {
        return InputStream.class;
    }

    protected final /* synthetic */ Object mo3263a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
