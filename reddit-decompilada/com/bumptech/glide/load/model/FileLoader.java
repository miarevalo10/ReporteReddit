package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader<Data> implements ModelLoader<File, Data> {
    private final FileOpener<Data> f12535a;

    public interface FileOpener<Data> {
        Class<Data> mo973a();

        Data mo974a(File file) throws FileNotFoundException;

        void mo975a(Data data) throws IOException;
    }

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {
        private final FileOpener<Data> f12531a;

        public Factory(FileOpener<Data> fileOpener) {
            this.f12531a = fileOpener;
        }

        public final ModelLoader<File, Data> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f12531a);
        }
    }

    private static final class FileFetcher<Data> implements DataFetcher<Data> {
        private final File f12532a;
        private final FileOpener<Data> f12533b;
        private Data f12534c;

        public final void mo886b() {
        }

        FileFetcher(File file, FileOpener<Data> fileOpener) {
            this.f12532a = file;
            this.f12533b = fileOpener;
        }

        public final void mo885a(Priority priority, DataCallback<? super Data> dataCallback) {
            try {
                this.f12534c = this.f12533b.mo974a(this.f12532a);
                dataCallback.mo903a(this.f12534c);
            } catch (Exception e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                dataCallback.mo902a(e);
            }
        }

        public final void mo884a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f12534c;
            if (r0 == 0) goto L_0x000c;
        L_0x0004:
            r0 = r2.f12533b;	 Catch:{ IOException -> 0x000c }
            r1 = r2.f12534c;	 Catch:{ IOException -> 0x000c }
            r0.mo975a(r1);	 Catch:{ IOException -> 0x000c }
            return;
        L_0x000c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.FileLoader.FileFetcher.a():void");
        }

        public final Class<Data> mo887c() {
            return this.f12533b.mo973a();
        }

        public final DataSource mo888d() {
            return DataSource.LOCAL;
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {

        class C10741 implements FileOpener<ParcelFileDescriptor> {
            C10741() {
            }

            public final /* synthetic */ void mo975a(Object obj) throws IOException {
                ((ParcelFileDescriptor) obj).close();
            }

            public final Class<ParcelFileDescriptor> mo973a() {
                return ParcelFileDescriptor.class;
            }

            public final /* synthetic */ Object mo974a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public FileDescriptorFactory() {
            super(new C10741());
        }
    }

    public static class StreamFactory extends Factory<InputStream> {

        class C10751 implements FileOpener<InputStream> {
            C10751() {
            }

            public final /* synthetic */ void mo975a(Object obj) throws IOException {
                ((InputStream) obj).close();
            }

            public final Class<InputStream> mo973a() {
                return InputStream.class;
            }

            public final /* synthetic */ Object mo974a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public StreamFactory() {
            super(new C10751());
        }
    }

    public final /* bridge */ /* synthetic */ boolean mo891a(Object obj) {
        return true;
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        File file = (File) obj;
        return new LoadData(new ObjectKey(file), new FileFetcher(file, this.f12535a));
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.f12535a = fileOpener;
    }
}
