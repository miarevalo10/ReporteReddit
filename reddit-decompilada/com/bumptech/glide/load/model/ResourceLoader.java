package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.InputStream;

public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
    private final ModelLoader<Uri, Data> f12564a;
    private final Resources f12565b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        private final Resources f12560a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f12560a = resources;
        }

        public final ModelLoader<Integer, AssetFileDescriptor> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f12560a, multiModelLoaderFactory.m3013a(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        private final Resources f12561a;

        public FileDescriptorFactory(Resources resources) {
            this.f12561a = resources;
        }

        public final ModelLoader<Integer, ParcelFileDescriptor> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f12561a, multiModelLoaderFactory.m3013a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {
        private final Resources f12562a;

        public StreamFactory(Resources resources) {
            this.f12562a = resources;
        }

        public final ModelLoader<Integer, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f12562a, multiModelLoaderFactory.m3013a(Uri.class, InputStream.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {
        private final Resources f12563a;

        public UriFactory(Resources resources) {
            this.f12563a = resources;
        }

        public final ModelLoader<Integer, Uri> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f12563a, UnitModelLoader.m11538a());
        }
    }

    public final /* bridge */ /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        obj = m11520a((Integer) obj);
        if (obj == null) {
            return null;
        }
        return this.f12564a.mo890a(obj, i, i2, options);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f12565b = resources;
        this.f12564a = modelLoader;
    }

    private Uri m11520a(Integer num) {
        try {
            StringBuilder stringBuilder = new StringBuilder("android.resource://");
            stringBuilder.append(this.f12565b.getResourcePackageName(num.intValue()));
            stringBuilder.append('/');
            stringBuilder.append(this.f12565b.getResourceTypeName(num.intValue()));
            stringBuilder.append('/');
            stringBuilder.append(this.f12565b.getResourceEntryName(num.intValue()));
            return Uri.parse(stringBuilder.toString());
        } catch (Throwable e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                StringBuilder stringBuilder2 = new StringBuilder("Received invalid resource id: ");
                stringBuilder2.append(num);
                Log.w("ResourceLoader", stringBuilder2.toString(), e);
            }
            return null;
        }
    }
}
