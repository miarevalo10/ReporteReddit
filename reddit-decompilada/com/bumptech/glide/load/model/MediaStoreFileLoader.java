package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context f12550a;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context f12546a;

        public Factory(Context context) {
            this.f12546a = context;
        }

        public final ModelLoader<Uri, File> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f12546a);
        }
    }

    private static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] f12547a = new String[]{"_data"};
        private final Context f12548b;
        private final Uri f12549c;

        public final void mo884a() {
        }

        public final void mo886b() {
        }

        FilePathFetcher(Context context, Uri uri) {
            this.f12548b = context;
            this.f12549c = uri;
        }

        public final void mo885a(Priority priority, DataCallback<? super File> dataCallback) {
            priority = this.f12548b.getContentResolver().query(this.f12549c, f12547a, null, null, null);
            Object obj = null;
            if (priority != null) {
                try {
                    if (priority.moveToFirst()) {
                        obj = priority.getString(priority.getColumnIndexOrThrow("_data"));
                    }
                    priority.close();
                } catch (Throwable th) {
                    priority.close();
                }
            }
            if (TextUtils.isEmpty(obj) != null) {
                StringBuilder stringBuilder = new StringBuilder("Failed to find file path for: ");
                stringBuilder.append(this.f12549c);
                dataCallback.mo902a(new FileNotFoundException(stringBuilder.toString()));
                return;
            }
            dataCallback.mo903a(new File(obj));
        }

        public final Class<File> mo887c() {
            return File.class;
        }

        public final DataSource mo888d() {
            return DataSource.LOCAL;
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        return new LoadData(new ObjectKey(uri), new FilePathFetcher(this.f12550a, uri));
    }

    public final /* bridge */ /* synthetic */ boolean mo891a(Object obj) {
        return MediaStoreUtil.m2873a((Uri) obj);
    }

    public MediaStoreFileLoader(Context context) {
        this.f12550a = context;
    }
}
