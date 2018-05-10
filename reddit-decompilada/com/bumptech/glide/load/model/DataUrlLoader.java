package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Data> implements ModelLoader<String, Data> {
    private final DataDecoder<Data> f12530a;

    public interface DataDecoder<Data> {
        Class<Data> mo970a();

        Data mo971a(String str) throws IllegalArgumentException;

        void mo972a(Data data) throws IOException;
    }

    private static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        private final String f12525a;
        private final DataDecoder<Data> f12526b;
        private Data f12527c;

        public final void mo886b() {
        }

        DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.f12525a = str;
            this.f12526b = dataDecoder;
        }

        public final void mo885a(Priority priority, DataCallback<? super Data> dataCallback) {
            try {
                this.f12527c = this.f12526b.mo971a(this.f12525a);
                dataCallback.mo903a(this.f12527c);
            } catch (Exception e) {
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
            r0 = r2.f12526b;	 Catch:{ IOException -> 0x0008 }
            r1 = r2.f12527c;	 Catch:{ IOException -> 0x0008 }
            r0.mo972a(r1);	 Catch:{ IOException -> 0x0008 }
            return;
        L_0x0008:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.DataUrlLoader.DataUriFetcher.a():void");
        }

        public final Class<Data> mo887c() {
            return this.f12526b.mo970a();
        }

        public final DataSource mo888d() {
            return DataSource.LOCAL;
        }
    }

    public static final class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        private final DataDecoder<InputStream> f12529a = new C10731(this);

        class C10731 implements DataDecoder<InputStream> {
            final /* synthetic */ StreamFactory f12528a;

            C10731(StreamFactory streamFactory) {
                this.f12528a = streamFactory;
            }

            public final /* synthetic */ void mo972a(Object obj) throws IOException {
                ((InputStream) obj).close();
            }

            public final Class<InputStream> mo970a() {
                return InputStream.class;
            }

            public final /* synthetic */ Object mo971a(String str) throws IllegalArgumentException {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        public final ModelLoader<String, InputStream> mo889a(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f12529a);
        }
    }

    public final /* synthetic */ LoadData mo890a(Object obj, int i, int i2, Options options) {
        String str = (String) obj;
        return new LoadData(new ObjectKey(str), new DataUriFetcher(str, this.f12530a));
    }

    public final /* synthetic */ boolean mo891a(Object obj) {
        return ((String) obj).startsWith("data:image");
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.f12530a = dataDecoder;
    }
}
