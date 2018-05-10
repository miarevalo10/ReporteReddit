package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.StreamFactory;
import com.bumptech.glide.load.model.ResourceLoader.UriFactory;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader.Factory;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    private static volatile Glide f3190h;
    private static volatile boolean f3191i;
    public final BitmapPool f3192a;
    public final GlideContext f3193b;
    public final Registry f3194c;
    public final ArrayPool f3195d;
    public final RequestManagerRetriever f3196e;
    final ConnectivityMonitorFactory f3197f;
    final List<RequestManager> f3198g = new ArrayList();
    private final Engine f3199j;
    private final MemoryCache f3200k;
    private final BitmapPreFiller f3201l;
    private MemoryCategory f3202m = MemoryCategory.NORMAL;

    public void onConfigurationChanged(Configuration configuration) {
    }

    public static Glide m2775a(Context context) {
        if (f3190h == null) {
            synchronized (Glide.class) {
                if (f3190h == null) {
                    if (f3191i) {
                        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                    }
                    f3191i = true;
                    m2778a(context, new GlideBuilder());
                    f3191i = null;
                }
            }
        }
        return f3190h;
    }

    private static void m2778a(Context context, GlideBuilder glideBuilder) {
        List<GlideModule> list;
        Set a;
        Iterator it;
        GlideModule glideModule;
        RequestManagerFactory b;
        int i;
        Context context2;
        Glide glide;
        context = context.getApplicationContext();
        GeneratedAppGlideModule a2 = m2774a();
        List emptyList = Collections.emptyList();
        if (a2 != null) {
            if (a2.mo4179c()) {
            }
            list = emptyList;
            if (!(a2 == null || a2.mo4230a().isEmpty())) {
                a = a2.mo4230a();
                it = list.iterator();
                while (it.hasNext()) {
                    glideModule = (GlideModule) it.next();
                    if (!a.contains(glideModule.getClass())) {
                        if (Log.isLoggable("Glide", 3)) {
                            StringBuilder stringBuilder = new StringBuilder("AppGlideModule excludes manifest GlideModule: ");
                            stringBuilder.append(glideModule);
                            Log.d("Glide", stringBuilder.toString());
                        }
                        it.remove();
                    }
                }
            }
            if (Log.isLoggable("Glide", 3)) {
                for (GlideModule glideModule2 : list) {
                    StringBuilder stringBuilder2 = new StringBuilder("Discovered GlideModule from manifest: ");
                    stringBuilder2.append(glideModule2.getClass());
                    Log.d("Glide", stringBuilder2.toString());
                }
            }
            if (a2 == null) {
                b = a2.mo4231b();
            } else {
                b = null;
            }
            glideBuilder.f3215m = b;
            for (GlideModule glideModule22 : list) {
                glideModule22.mo3259a(context, glideBuilder);
            }
            if (a2 != null) {
                a2.mo3259a(context, glideBuilder);
            }
            if (glideBuilder.f3208f == null) {
                glideBuilder.f3208f = GlideExecutor.m2980b();
            }
            if (glideBuilder.f3209g == null) {
                glideBuilder.f3209g = GlideExecutor.m2979a();
            }
            if (glideBuilder.f3216n == null) {
                glideBuilder.f3216n = GlideExecutor.m2982d();
            }
            if (glideBuilder.f3211i == null) {
                glideBuilder.f3211i = new MemorySizeCalculator(new Builder(context));
            }
            if (glideBuilder.f3212j == null) {
                glideBuilder.f3212j = new DefaultConnectivityMonitorFactory();
            }
            if (glideBuilder.f3205c == null) {
                i = glideBuilder.f3211i.f3464a;
                if (i <= 0) {
                    glideBuilder.f3205c = new LruBitmapPool((long) i);
                } else {
                    glideBuilder.f3205c = new BitmapPoolAdapter();
                }
            }
            if (glideBuilder.f3206d == null) {
                glideBuilder.f3206d = new LruArrayPool(glideBuilder.f3211i.f3466c);
            }
            if (glideBuilder.f3207e == null) {
                glideBuilder.f3207e = new LruResourceCache((long) glideBuilder.f3211i.f3465b);
            }
            if (glideBuilder.f3210h == null) {
                glideBuilder.f3210h = new InternalCacheDiskCacheFactory(context);
            }
            if (glideBuilder.f3204b == null) {
                glideBuilder.f3204b = new Engine(glideBuilder.f3207e, glideBuilder.f3210h, glideBuilder.f3209g, glideBuilder.f3208f, GlideExecutor.m2981c(), GlideExecutor.m2982d(), glideBuilder.f3217o);
            }
            context2 = context;
            glide = new Glide(context2, glideBuilder.f3204b, glideBuilder.f3207e, glideBuilder.f3205c, glideBuilder.f3206d, new RequestManagerRetriever(glideBuilder.f3215m), glideBuilder.f3212j, glideBuilder.f3213k, glideBuilder.f3214l.mo2882n(), glideBuilder.f3203a);
            for (GlideModule a3 : list) {
                a3.mo1006a(context, glide, glide.f3194c);
            }
            if (a2 != null) {
                a2.mo1006a(context, glide, glide.f3194c);
            }
            context.registerComponentCallbacks(glide);
            f3190h = glide;
        }
        emptyList = new ManifestParser(context).m3106a();
        list = emptyList;
        a = a2.mo4230a();
        it = list.iterator();
        while (it.hasNext()) {
            glideModule = (GlideModule) it.next();
            if (!a.contains(glideModule.getClass())) {
                if (Log.isLoggable("Glide", 3)) {
                    StringBuilder stringBuilder3 = new StringBuilder("AppGlideModule excludes manifest GlideModule: ");
                    stringBuilder3.append(glideModule);
                    Log.d("Glide", stringBuilder3.toString());
                }
                it.remove();
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (GlideModule glideModule222 : list) {
                StringBuilder stringBuilder22 = new StringBuilder("Discovered GlideModule from manifest: ");
                stringBuilder22.append(glideModule222.getClass());
                Log.d("Glide", stringBuilder22.toString());
            }
        }
        if (a2 == null) {
            b = null;
        } else {
            b = a2.mo4231b();
        }
        glideBuilder.f3215m = b;
        while (r0.hasNext()) {
            glideModule222.mo3259a(context, glideBuilder);
        }
        if (a2 != null) {
            a2.mo3259a(context, glideBuilder);
        }
        if (glideBuilder.f3208f == null) {
            glideBuilder.f3208f = GlideExecutor.m2980b();
        }
        if (glideBuilder.f3209g == null) {
            glideBuilder.f3209g = GlideExecutor.m2979a();
        }
        if (glideBuilder.f3216n == null) {
            glideBuilder.f3216n = GlideExecutor.m2982d();
        }
        if (glideBuilder.f3211i == null) {
            glideBuilder.f3211i = new MemorySizeCalculator(new Builder(context));
        }
        if (glideBuilder.f3212j == null) {
            glideBuilder.f3212j = new DefaultConnectivityMonitorFactory();
        }
        if (glideBuilder.f3205c == null) {
            i = glideBuilder.f3211i.f3464a;
            if (i <= 0) {
                glideBuilder.f3205c = new BitmapPoolAdapter();
            } else {
                glideBuilder.f3205c = new LruBitmapPool((long) i);
            }
        }
        if (glideBuilder.f3206d == null) {
            glideBuilder.f3206d = new LruArrayPool(glideBuilder.f3211i.f3466c);
        }
        if (glideBuilder.f3207e == null) {
            glideBuilder.f3207e = new LruResourceCache((long) glideBuilder.f3211i.f3465b);
        }
        if (glideBuilder.f3210h == null) {
            glideBuilder.f3210h = new InternalCacheDiskCacheFactory(context);
        }
        if (glideBuilder.f3204b == null) {
            glideBuilder.f3204b = new Engine(glideBuilder.f3207e, glideBuilder.f3210h, glideBuilder.f3209g, glideBuilder.f3208f, GlideExecutor.m2981c(), GlideExecutor.m2982d(), glideBuilder.f3217o);
        }
        context2 = context;
        glide = new Glide(context2, glideBuilder.f3204b, glideBuilder.f3207e, glideBuilder.f3205c, glideBuilder.f3206d, new RequestManagerRetriever(glideBuilder.f3215m), glideBuilder.f3212j, glideBuilder.f3213k, glideBuilder.f3214l.mo2882n(), glideBuilder.f3203a);
        while (glideBuilder.hasNext()) {
            a3.mo1006a(context, glide, glide.f3194c);
        }
        if (a2 != null) {
            a2.mo1006a(context, glide, glide.f3194c);
        }
        context.registerComponentCallbacks(glide);
        f3190h = glide;
    }

    private static com.bumptech.glide.GeneratedAppGlideModule m2774a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = "com.bumptech.glide.GeneratedAppGlideModuleImpl";	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        r1 = 0;	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        r2 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        r1 = new java.lang.Object[r1];	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        r0 = r0.newInstance(r1);	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        r0 = (com.bumptech.glide.GeneratedAppGlideModule) r0;	 Catch:{ ClassNotFoundException -> 0x002a, InstantiationException -> 0x0025, IllegalAccessException -> 0x0020, NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0016 }
        goto L_0x003b;
    L_0x0016:
        r0 = move-exception;
        m2779a(r0);
        goto L_0x003a;
    L_0x001b:
        r0 = move-exception;
        m2779a(r0);
        goto L_0x003a;
    L_0x0020:
        r0 = move-exception;
        m2779a(r0);
        goto L_0x003a;
    L_0x0025:
        r0 = move-exception;
        m2779a(r0);
        goto L_0x003a;
    L_0x002a:
        r0 = "Glide";
        r1 = 5;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x003a;
    L_0x0033:
        r0 = "Glide";
        r1 = "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored";
        android.util.Log.w(r0, r1);
    L_0x003a:
        r0 = 0;
    L_0x003b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Glide.a():com.bumptech.glide.GeneratedAppGlideModule");
    }

    private static void m2779a(Exception exception) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exception);
    }

    private Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int i, RequestOptions requestOptions, Map<Class<?>, TransitionOptions<?, ?>> map) {
        Context context2 = context;
        MemoryCache memoryCache2 = memoryCache;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        this.f3199j = engine;
        this.f3192a = bitmapPool2;
        this.f3195d = arrayPool2;
        this.f3200k = memoryCache2;
        this.f3196e = requestManagerRetriever;
        this.f3197f = connectivityMonitorFactory;
        this.f3201l = new BitmapPreFiller(memoryCache2, bitmapPool2, (DecodeFormat) requestOptions.f3628p.m11235a(Downsampler.f3525a));
        Resources resources = context.getResources();
        this.f3194c = new Registry();
        Registry registry = this.f3194c;
        registry.f3243g.m3111a(new DefaultImageHeaderParser());
        Downsampler downsampler = new Downsampler(this.f3194c.m2790a(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
        ResourceDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, this.f3194c.m2790a(), bitmapPool2, arrayPool2);
        ResourceDecoder b = VideoDecoder.m11637b(bitmapPool);
        ResourceDecoder byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
        ResourceDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool2);
        ResourceDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        ModelLoaderFactory streamFactory = new StreamFactory(resources);
        UriFactory uriFactory = new UriFactory(resources);
        FileDescriptorFactory fileDescriptorFactory = new FileDescriptorFactory(resources);
        AssetFileDescriptorFactory assetFileDescriptorFactory = new AssetFileDescriptorFactory(resources);
        ResourceEncoder bitmapEncoder = new BitmapEncoder();
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ModelLoaderFactory modelLoaderFactory = fileDescriptorFactory;
        modelLoaderFactory = uriFactory;
        ModelLoaderFactory modelLoaderFactory2 = assetFileDescriptorFactory;
        Context context3 = context;
        ContentResolver contentResolver = context.getContentResolver();
        ResourceTranscoder resourceTranscoder = bitmapBytesTranscoder;
        ResourceTranscoder resourceTranscoder2 = gifDrawableBytesTranscoder;
        this.f3194c.m2784a(ByteBuffer.class, new ByteBufferEncoder()).m2784a(InputStream.class, new StreamEncoder(arrayPool2)).m2789a("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).m2789a("Bitmap", InputStream.class, Bitmap.class, streamBitmapDecoder).m2789a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b).m2789a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.m11636a(bitmapPool)).m2787a(Bitmap.class, Bitmap.class, Factory.m11531a()).m2789a("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).m2785a(Bitmap.class, bitmapEncoder).m2789a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).m2789a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).m2789a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, b)).m2785a(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool2, bitmapEncoder)).m2789a("Gif", InputStream.class, GifDrawable.class, new StreamGifDecoder(this.f3194c.m2790a(), byteBufferGifDecoder, arrayPool2)).m2789a("Gif", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).m2785a(GifDrawable.class, new GifDrawableEncoder()).m2787a(GifDecoder.class, GifDecoder.class, Factory.m11531a()).m2789a("Bitmap", GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool2)).m2786a(Uri.class, Drawable.class, resourceDrawableDecoder).m2786a(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool2)).m2783a(new ByteBufferRewinder.Factory()).m2787a(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).m2787a(File.class, InputStream.class, new FileLoader.StreamFactory()).m2786a(File.class, File.class, new FileDecoder()).m2787a(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).m2787a(File.class, File.class, Factory.m11531a()).m2783a(new InputStreamRewinder.Factory(arrayPool2)).m2787a(Integer.TYPE, InputStream.class, streamFactory).m2787a(Integer.TYPE, ParcelFileDescriptor.class, modelLoaderFactory).m2787a(Integer.class, InputStream.class, streamFactory).m2787a(Integer.class, ParcelFileDescriptor.class, modelLoaderFactory).m2787a(Integer.class, Uri.class, modelLoaderFactory).m2787a(Integer.TYPE, AssetFileDescriptor.class, modelLoaderFactory2).m2787a(Integer.class, AssetFileDescriptor.class, modelLoaderFactory2).m2787a(Integer.TYPE, Uri.class, modelLoaderFactory).m2787a(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).m2787a(String.class, InputStream.class, new StringLoader.StreamFactory()).m2787a(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).m2787a(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).m2787a(Uri.class, InputStream.class, new HttpUriLoader.Factory()).m2787a(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).m2787a(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).m2787a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context3)).m2787a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context3)).m2787a(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver)).m2787a(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver)).m2787a(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver)).m2787a(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).m2787a(URL.class, InputStream.class, new UrlLoader.StreamFactory()).m2787a(Uri.class, File.class, new MediaStoreFileLoader.Factory(context3)).m2787a(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).m2787a(byte[].class, ByteBuffer.class, new ByteBufferFactory()).m2787a(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).m2787a(Uri.class, Uri.class, Factory.m11531a()).m2787a(Drawable.class, Drawable.class, Factory.m11531a()).m2786a(Drawable.class, Drawable.class, new UnitDrawableDecoder()).m2788a(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).m2788a(Bitmap.class, byte[].class, resourceTranscoder).m2788a(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool2, resourceTranscoder, resourceTranscoder2)).m2788a(GifDrawable.class, byte[].class, resourceTranscoder2);
        this.f3193b = new GlideContext(context3, arrayPool2, this.f3194c, new ImageViewTargetFactory(), requestOptions, map, engine, i);
    }

    private static RequestManagerRetriever m2781c(Context context) {
        Preconditions.m3218a((Object) context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m2775a(context).f3196e;
    }

    public static RequestManager m2780b(Context context) {
        return m2781c(context).m3096a(context);
    }

    public static RequestManager m2776a(Activity activity) {
        return m2781c(activity).m3095a(activity);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.RequestManager m2777a(android.view.View r7) {
        /*
        r0 = r7.getContext();
        r0 = m2781c(r0);
        r1 = com.bumptech.glide.util.Util.m3239d();
        if (r1 == 0) goto L_0x001b;
    L_0x000e:
        r7 = r7.getContext();
        r7 = r7.getApplicationContext();
        r7 = r0.m3096a(r7);
        return r7;
    L_0x001b:
        com.bumptech.glide.util.Preconditions.m3217a(r7);
        r1 = r7.getContext();
        r2 = "Unable to obtain a request manager for a view without a Context";
        com.bumptech.glide.util.Preconditions.m3218a(r1, r2);
        r1 = r7.getContext();
    L_0x002b:
        r2 = r1 instanceof android.app.Activity;
        r3 = 0;
        if (r2 == 0) goto L_0x0033;
    L_0x0030:
        r1 = (android.app.Activity) r1;
        goto L_0x003f;
    L_0x0033:
        r2 = r1 instanceof android.content.ContextWrapper;
        if (r2 == 0) goto L_0x003e;
    L_0x0037:
        r1 = (android.content.ContextWrapper) r1;
        r1 = r1.getBaseContext();
        goto L_0x002b;
    L_0x003e:
        r1 = r3;
    L_0x003f:
        if (r1 != 0) goto L_0x004e;
    L_0x0041:
        r7 = r7.getContext();
        r7 = r7.getApplicationContext();
        r7 = r0.m3096a(r7);
        return r7;
    L_0x004e:
        r2 = r1 instanceof android.support.v4.app.FragmentActivity;
        r4 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;
        if (r2 == 0) goto L_0x00c2;
    L_0x0055:
        r2 = r1;
        r2 = (android.support.v4.app.FragmentActivity) r2;
        r5 = r0.f3589c;
        r5.clear();
        r5 = r2.getSupportFragmentManager();
        r5 = r5.mo229f();
        r6 = r0.f3589c;
        com.bumptech.glide.manager.RequestManagerRetriever.m3092a(r5, r6);
        r2 = r2.findViewById(r4);
    L_0x006e:
        r4 = r7.equals(r2);
        if (r4 != 0) goto L_0x008d;
    L_0x0074:
        r3 = r0.f3589c;
        r3 = r3.get(r7);
        r3 = (android.support.v4.app.Fragment) r3;
        if (r3 != 0) goto L_0x008d;
    L_0x007e:
        r4 = r7.getParent();
        r4 = r4 instanceof android.view.View;
        if (r4 == 0) goto L_0x008d;
    L_0x0086:
        r7 = r7.getParent();
        r7 = (android.view.View) r7;
        goto L_0x006e;
    L_0x008d:
        r7 = r0.f3589c;
        r7.clear();
        if (r3 == 0) goto L_0x00bd;
    L_0x0094:
        r7 = r3.getActivity();
        r1 = "You cannot start a load on a fragment before it is attached or after it is destroyed";
        com.bumptech.glide.util.Preconditions.m3218a(r7, r1);
        r7 = com.bumptech.glide.util.Util.m3239d();
        if (r7 == 0) goto L_0x00b0;
    L_0x00a3:
        r7 = r3.getActivity();
        r7 = r7.getApplicationContext();
        r7 = r0.m3096a(r7);
        return r7;
    L_0x00b0:
        r7 = r3.getChildFragmentManager();
        r1 = r3.getActivity();
        r7 = r0.m3098a(r1, r7, r3);
        return r7;
    L_0x00bd:
        r7 = r0.m3095a(r1);
        return r7;
    L_0x00c2:
        r2 = r0.f3590d;
        r2.clear();
        r2 = r1.getFragmentManager();
        r5 = r0.f3590d;
        r0.m3101a(r2, r5);
        r2 = r1.findViewById(r4);
    L_0x00d4:
        r4 = r7.equals(r2);
        if (r4 != 0) goto L_0x00f3;
    L_0x00da:
        r3 = r0.f3590d;
        r3 = r3.get(r7);
        r3 = (android.app.Fragment) r3;
        if (r3 != 0) goto L_0x00f3;
    L_0x00e4:
        r4 = r7.getParent();
        r4 = r4 instanceof android.view.View;
        if (r4 == 0) goto L_0x00f3;
    L_0x00ec:
        r7 = r7.getParent();
        r7 = (android.view.View) r7;
        goto L_0x00d4;
    L_0x00f3:
        r7 = r0.f3590d;
        r7.clear();
        if (r3 != 0) goto L_0x00ff;
    L_0x00fa:
        r7 = r0.m3095a(r1);
        return r7;
    L_0x00ff:
        r7 = r3.getActivity();
        if (r7 != 0) goto L_0x010d;
    L_0x0105:
        r7 = new java.lang.IllegalArgumentException;
        r0 = "You cannot start a load on a fragment before it is attached";
        r7.<init>(r0);
        throw r7;
    L_0x010d:
        r7 = com.bumptech.glide.util.Util.m3239d();
        if (r7 != 0) goto L_0x0127;
    L_0x0113:
        r7 = android.os.Build.VERSION.SDK_INT;
        r1 = 17;
        if (r7 >= r1) goto L_0x011a;
    L_0x0119:
        goto L_0x0127;
    L_0x011a:
        r7 = r3.getChildFragmentManager();
        r1 = r3.getActivity();
        r7 = r0.m3097a(r1, r7, r3);
        return r7;
    L_0x0127:
        r7 = r3.getActivity();
        r7 = r7.getApplicationContext();
        r7 = r0.m3096a(r7);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Glide.a(android.view.View):com.bumptech.glide.RequestManager");
    }

    final boolean m2782a(Target<?> target) {
        synchronized (this.f3198g) {
            for (RequestManager b : this.f3198g) {
                if (b.m11203b((Target) target)) {
                    return true;
                }
            }
            return null;
        }
    }

    public void onTrimMemory(int i) {
        Util.m3230a();
        this.f3200k.trimMemory(i);
        this.f3192a.mo939a(i);
        this.f3195d.mo949a(i);
    }

    public void onLowMemory() {
        Util.m3230a();
        this.f3200k.clearMemory();
        this.f3192a.mo938a();
        this.f3195d.mo948a();
    }
}
