package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final int f12516a = 22;
    private final AssetManager f12517b;
    private final AssetFetcherFactory<Data> f12518c;

    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> mo966a(AssetManager assetManager, String str);
    }

    public static class FileDescriptorFactory implements AssetFetcherFactory<ParcelFileDescriptor>, ModelLoaderFactory<Uri, ParcelFileDescriptor> {
        private final AssetManager f12514a;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.f12514a = assetManager;
        }

        public final ModelLoader<Uri, ParcelFileDescriptor> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f12514a, this);
        }

        public final DataFetcher<ParcelFileDescriptor> mo966a(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }
    }

    public static class StreamFactory implements AssetFetcherFactory<InputStream>, ModelLoaderFactory<Uri, InputStream> {
        private final AssetManager f12515a;

        public StreamFactory(AssetManager assetManager) {
            this.f12515a = assetManager;
        }

        public final ModelLoader<Uri, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f12515a, this);
        }

        public final DataFetcher<InputStream> mo966a(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        return new LoadData(new ObjectKey(uri), this.f12518c.mo966a(this.f12517b, uri.toString().substring(f12516a)));
    }

    public final /* synthetic */ boolean mo891a(Object obj) {
        Uri uri = (Uri) obj;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || "android_asset".equals(uri.getPathSegments().get(0)) == null) {
            return false;
        }
        return true;
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.f12517b = assetManager;
        this.f12518c = assetFetcherFactory;
    }
}
