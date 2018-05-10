package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.io.InputStream;

public class StringLoader<Data> implements ModelLoader<String, Data> {
    private final ModelLoader<Uri, Data> f12567a;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        public final ModelLoader<String, AssetFileDescriptor> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m3013a(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        public final ModelLoader<String, ParcelFileDescriptor> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m3013a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        public final ModelLoader<String, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.m3013a(Uri.class, InputStream.class));
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            obj = null;
        } else if (str.charAt(0) == '/') {
            obj = m11528a(str);
        } else {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() == null) {
                obj = m11528a(str);
            } else {
                obj = parse;
            }
        }
        if (obj == null) {
            return null;
        }
        return this.f12567a.mo890a(obj, i, i2, options);
    }

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.f12567a = modelLoader;
    }

    private static Uri m11528a(String str) {
        return Uri.fromFile(new File(str));
    }
}
