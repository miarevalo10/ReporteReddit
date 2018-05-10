package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final Set<String> f12574a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));
    private final LocalUriFetcherFactory<Data> f12575b;

    public interface LocalUriFetcherFactory<Data> {
        DataFetcher<Data> mo978a(Uri uri);
    }

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {
        private final ContentResolver f12571a;

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this.f12571a = contentResolver;
        }

        public final ModelLoader<Uri, AssetFileDescriptor> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }

        public final DataFetcher<AssetFileDescriptor> mo978a(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f12571a, uri);
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {
        private final ContentResolver f12572a;

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this.f12572a = contentResolver;
        }

        public final DataFetcher<ParcelFileDescriptor> mo978a(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f12572a, uri);
        }

        public final ModelLoader<Uri, ParcelFileDescriptor> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {
        private final ContentResolver f12573a;

        public StreamFactory(ContentResolver contentResolver) {
            this.f12573a = contentResolver;
        }

        public final DataFetcher<InputStream> mo978a(Uri uri) {
            return new StreamLocalUriFetcher(this.f12573a, uri);
        }

        public final ModelLoader<Uri, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        return new LoadData(new ObjectKey(uri), this.f12575b.mo978a(uri));
    }

    public final /* synthetic */ boolean mo891a(Object obj) {
        return f12574a.contains(((Uri) obj).getScheme());
    }

    public UriLoader(LocalUriFetcherFactory<Data> localUriFetcherFactory) {
        this.f12575b = localUriFetcherFactory;
    }
}
