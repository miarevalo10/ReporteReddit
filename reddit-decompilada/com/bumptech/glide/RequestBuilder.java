package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class RequestBuilder<TranscodeType> implements Cloneable {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = new RequestOptions().mo2857b(DiskCacheStrategy.f3412c).mo2843a(Priority.LOW).mo2870d(true);
    private final Context context;
    private final RequestOptions defaultRequestOptions;
    private RequestBuilder<TranscodeType> errorBuilder;
    private final Glide glide;
    private final GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private RequestListener<TranscodeType> requestListener;
    private final RequestManager requestManager;
    protected RequestOptions requestOptions;
    private Float thumbSizeMultiplier;
    private RequestBuilder<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;
    private TransitionOptions<?, ? super TranscodeType> transitionOptions;

    static /* synthetic */ class C02652 {
        static final /* synthetic */ int[] f3249a = new int[ScaleType.values().length];

        static {
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
            r0 = com.bumptech.glide.Priority.values();
            r0 = r0.length;
            r0 = new int[r0];
            f3250b = r0;
            r0 = 1;
            r1 = f3250b;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = com.bumptech.glide.Priority.LOW;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = f3250b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = com.bumptech.glide.Priority.NORMAL;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = f3250b;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = com.bumptech.glide.Priority.HIGH;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = 4;
            r4 = f3250b;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = com.bumptech.glide.Priority.IMMEDIATE;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r4 = android.widget.ImageView.ScaleType.values();
            r4 = r4.length;
            r4 = new int[r4];
            f3249a = r4;
            r4 = f3249a;	 Catch:{ NoSuchFieldError -> 0x0048 }
            r5 = android.widget.ImageView.ScaleType.CENTER_CROP;	 Catch:{ NoSuchFieldError -> 0x0048 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0048 }
            r4[r5] = r0;	 Catch:{ NoSuchFieldError -> 0x0048 }
        L_0x0048:
            r0 = f3249a;	 Catch:{ NoSuchFieldError -> 0x0052 }
            r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE;	 Catch:{ NoSuchFieldError -> 0x0052 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0052 }
            r0[r4] = r1;	 Catch:{ NoSuchFieldError -> 0x0052 }
        L_0x0052:
            r0 = f3249a;	 Catch:{ NoSuchFieldError -> 0x005c }
            r1 = android.widget.ImageView.ScaleType.FIT_CENTER;	 Catch:{ NoSuchFieldError -> 0x005c }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x005c }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x005c }
        L_0x005c:
            r0 = f3249a;	 Catch:{ NoSuchFieldError -> 0x0066 }
            r1 = android.widget.ImageView.ScaleType.FIT_START;	 Catch:{ NoSuchFieldError -> 0x0066 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0066 }
            r0[r1] = r3;	 Catch:{ NoSuchFieldError -> 0x0066 }
        L_0x0066:
            r0 = f3249a;	 Catch:{ NoSuchFieldError -> 0x0071 }
            r1 = android.widget.ImageView.ScaleType.FIT_END;	 Catch:{ NoSuchFieldError -> 0x0071 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0071 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0071 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0071 }
        L_0x0071:
            r0 = f3249a;	 Catch:{ NoSuchFieldError -> 0x007c }
            r1 = android.widget.ImageView.ScaleType.FIT_XY;	 Catch:{ NoSuchFieldError -> 0x007c }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007c }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x007c }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x007c }
        L_0x007c:
            r0 = f3249a;	 Catch:{ NoSuchFieldError -> 0x0087 }
            r1 = android.widget.ImageView.ScaleType.CENTER;	 Catch:{ NoSuchFieldError -> 0x0087 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0087 }
            r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0087 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0087 }
        L_0x0087:
            r0 = f3249a;	 Catch:{ NoSuchFieldError -> 0x0093 }
            r1 = android.widget.ImageView.ScaleType.MATRIX;	 Catch:{ NoSuchFieldError -> 0x0093 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0093 }
            r2 = 8;	 Catch:{ NoSuchFieldError -> 0x0093 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0093 }
        L_0x0093:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.2.<clinit>():void");
        }
    }

    protected RequestBuilder(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = glide;
        this.requestManager = requestManager;
        this.transcodeClass = cls;
        this.defaultRequestOptions = requestManager.f12276f;
        this.context = context;
        this.transitionOptions = requestManager.m11201b((Class) cls);
        this.requestOptions = this.defaultRequestOptions;
        this.glideContext = glide.f3193b;
    }

    protected RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, cls, requestBuilder.context);
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        this.requestOptions = requestBuilder.requestOptions;
    }

    public RequestBuilder<TranscodeType> apply(RequestOptions requestOptions) {
        Preconditions.m3217a((Object) requestOptions);
        this.requestOptions = getMutableOptions().mo2848a(requestOptions);
        return this;
    }

    protected RequestOptions getMutableOptions() {
        return this.defaultRequestOptions == this.requestOptions ? this.requestOptions.mo2852b() : this.requestOptions;
    }

    public RequestBuilder<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.transitionOptions = (TransitionOptions) Preconditions.m3217a((Object) transitionOptions);
        this.isDefaultTransitionOptionsSet = null;
        return this;
    }

    public RequestBuilder<TranscodeType> listener(RequestListener<TranscodeType> requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public RequestBuilder<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        this.errorBuilder = requestBuilder;
        return this;
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        this.thumbnailBuilder = requestBuilder;
        return this;
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... requestBuilderArr) {
        RequestBuilder requestBuilder = null;
        if (requestBuilderArr != null) {
            if (requestBuilderArr.length != 0) {
                for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
                    RequestBuilder requestBuilder2 = requestBuilderArr[length];
                    if (requestBuilder2 != null) {
                        requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.thumbnail(requestBuilder);
                    }
                }
                return thumbnail(requestBuilder);
            }
        }
        return thumbnail(null);
    }

    public RequestBuilder<TranscodeType> thumbnail(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                this.thumbSizeMultiplier = Float.valueOf(f);
                return this;
            }
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public RequestBuilder<TranscodeType> load(Object obj) {
        return loadGeneric(obj);
    }

    private RequestBuilder<TranscodeType> loadGeneric(Object obj) {
        this.model = obj;
        this.isModelSet = true;
        return this;
    }

    public RequestBuilder<TranscodeType> load(Bitmap bitmap) {
        return loadGeneric(bitmap).apply(RequestOptions.m3134a(DiskCacheStrategy.f3411b));
    }

    public RequestBuilder<TranscodeType> load(Drawable drawable) {
        return loadGeneric(drawable).apply(RequestOptions.m3134a(DiskCacheStrategy.f3411b));
    }

    public RequestBuilder<TranscodeType> load(String str) {
        return loadGeneric(str);
    }

    public RequestBuilder<TranscodeType> load(Uri uri) {
        return loadGeneric(uri);
    }

    public RequestBuilder<TranscodeType> load(File file) {
        return loadGeneric(file);
    }

    public RequestBuilder<TranscodeType> load(Integer num) {
        return loadGeneric(num).apply(RequestOptions.m3132a(ApplicationVersionSignature.m3202a(this.context)));
    }

    @Deprecated
    public RequestBuilder<TranscodeType> load(URL url) {
        return loadGeneric(url);
    }

    public RequestBuilder<TranscodeType> load(byte[] bArr) {
        bArr = loadGeneric(bArr);
        if (!bArr.requestOptions.m3179g(4)) {
            bArr = bArr.apply(RequestOptions.m3134a(DiskCacheStrategy.f3411b));
        }
        return !bArr.requestOptions.m3179g(256) ? bArr.apply(RequestOptions.m3130a()) : bArr;
    }

    public RequestBuilder<TranscodeType> clone() {
        try {
            RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.clone();
            requestBuilder.requestOptions = requestBuilder.requestOptions.mo2852b();
            requestBuilder.transitionOptions = requestBuilder.transitionOptions.m2793a();
            return requestBuilder;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <Y extends Target<TranscodeType>> Y into(Y y) {
        return into((Target) y, null);
    }

    <Y extends Target<TranscodeType>> Y into(Y y, RequestListener<TranscodeType> requestListener) {
        return into(y, requestListener, getMutableOptions());
    }

    private <Y extends Target<TranscodeType>> Y into(Y y, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions) {
        Util.m3230a();
        Preconditions.m3217a((Object) y);
        if (this.isModelSet) {
            requestOptions = requestOptions.mo2883o();
            Request buildRequest = buildRequest(y, requestListener, requestOptions);
            Object d = y.mo3272d();
            if (buildRequest.isEquivalentTo(d) && isSkipMemoryCacheWithCompletePreviousRequest(requestOptions, d) == null) {
                buildRequest.recycle();
                if (((Request) Preconditions.m3217a(d)).isRunning() == null) {
                    d.begin();
                }
                return y;
            }
            this.requestManager.m11200a((Target) y);
            y.mo3269a(buildRequest);
            requestOptions = this.requestManager;
            requestOptions.f12275e.f12654a.add(y);
            requestOptions = requestOptions.f12274d;
            requestOptions.f3595a.add(buildRequest);
            if (requestOptions.f3597c) {
                requestOptions.f3596b.add(buildRequest);
            } else {
                buildRequest.begin();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public ViewTarget<ImageView, TranscodeType> into(ImageView imageView) {
        Util.m3230a();
        Preconditions.m3217a((Object) imageView);
        RequestOptions requestOptions = this.requestOptions;
        if (!(requestOptions.m3179g(MPEGConst.CODE_END) || !requestOptions.f3625m || imageView.getScaleType() == null)) {
            switch (C02652.f3249a[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestOptions = requestOptions.mo2852b().mo2867d();
                    break;
                case 2:
                    requestOptions = requestOptions.mo2852b().mo2876h();
                    break;
                case 3:
                case 4:
                case 5:
                    requestOptions = requestOptions.mo2852b().mo2873f();
                    break;
                case 6:
                    requestOptions = requestOptions.mo2852b().mo2876h();
                    break;
                default:
                    break;
            }
        }
        return (ViewTarget) into(ImageViewTargetFactory.m3189a(imageView, this.transcodeClass), null, requestOptions);
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }

    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public FutureTarget<TranscodeType> submit(int i, int i2) {
        final Target requestFutureTarget = new RequestFutureTarget(this.glideContext.f3219b, i, i2);
        if (Util.m3239d() != 0) {
            this.glideContext.f3219b.post(new Runnable(this) {
                final /* synthetic */ RequestBuilder f3248b;

                public void run() {
                    if (!requestFutureTarget.isCancelled()) {
                        this.f3248b.into(requestFutureTarget, requestFutureTarget);
                    }
                }
            });
        } else {
            into(requestFutureTarget, (RequestListener) requestFutureTarget);
        }
        return requestFutureTarget;
    }

    public Target<TranscodeType> preload(int i, int i2) {
        return into(PreloadTarget.m20781a(this.requestManager, i, i2));
    }

    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return getDownloadOnlyRequest().into((Target) y);
    }

    @Deprecated
    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    protected RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    private Priority getThumbnailPriority(Priority priority) {
        switch (priority) {
            case LOW:
                return Priority.NORMAL;
            case NORMAL:
                return Priority.HIGH;
            case HIGH:
            case IMMEDIATE:
                return Priority.IMMEDIATE;
            default:
                StringBuilder stringBuilder = new StringBuilder("unknown priority: ");
                stringBuilder.append(this.requestOptions.f3615c);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private Request buildRequest(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions) {
        return buildRequestRecursive(target, requestListener, null, this.transitionOptions, requestOptions.f3615c, requestOptions.f3622j, requestOptions.f3621i, requestOptions);
    }

    private Request buildRequestRecursive(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, RequestOptions requestOptions) {
        RequestCoordinator errorRequestCoordinator;
        RequestCoordinator requestCoordinator2;
        RequestOptions requestOptions2 = requestOptions;
        if (this.errorBuilder != null) {
            errorRequestCoordinator = new ErrorRequestCoordinator(requestCoordinator);
            requestCoordinator2 = errorRequestCoordinator;
        } else {
            requestCoordinator2 = null;
            errorRequestCoordinator = requestCoordinator;
        }
        Request buildThumbnailRequestRecursive = buildThumbnailRequestRecursive(target, requestListener, errorRequestCoordinator, transitionOptions, priority, i, i2, requestOptions2);
        if (requestCoordinator2 == null) {
            return buildThumbnailRequestRecursive;
        }
        int i3 = r9.errorBuilder.requestOptions.f3622j;
        int i4 = r9.errorBuilder.requestOptions.f3621i;
        if (Util.m3231a(i, i2) && !r9.errorBuilder.requestOptions.m3188p()) {
            i3 = requestOptions2.f3622j;
            i4 = requestOptions2.f3621i;
        }
        int i5 = i3;
        int i6 = i4;
        errorRequestCoordinator = requestCoordinator2;
        Request buildRequestRecursive = r9.errorBuilder.buildRequestRecursive(target, requestListener, requestCoordinator2, r9.errorBuilder.transitionOptions, r9.errorBuilder.requestOptions.f3615c, i5, i6, r9.errorBuilder.requestOptions);
        errorRequestCoordinator.f12655a = buildThumbnailRequestRecursive;
        errorRequestCoordinator.f12656b = buildRequestRecursive;
        return errorRequestCoordinator;
    }

    private Request buildThumbnailRequestRecursive(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2, RequestOptions requestOptions) {
        RequestCoordinator requestCoordinator2 = requestCoordinator;
        Priority priority2 = priority;
        RequestOptions requestOptions2 = requestOptions;
        if (this.thumbnailBuilder != null) {
            if (r9.isThumbnailBuilt) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            Priority priority3;
            TransitionOptions transitionOptions2 = r9.thumbnailBuilder.isDefaultTransitionOptionsSet ? transitionOptions : r9.thumbnailBuilder.transitionOptions;
            if (r9.thumbnailBuilder.requestOptions.m3179g(8)) {
                priority3 = r9.thumbnailBuilder.requestOptions.f3615c;
            } else {
                priority3 = getThumbnailPriority(priority2);
            }
            Priority priority4 = priority3;
            int i3 = r9.thumbnailBuilder.requestOptions.f3622j;
            int i4 = r9.thumbnailBuilder.requestOptions.f3621i;
            if (Util.m3231a(i, i2) && !r9.thumbnailBuilder.requestOptions.m3188p()) {
                i3 = requestOptions2.f3622j;
                i4 = requestOptions2.f3621i;
            }
            int i5 = i3;
            int i6 = i4;
            RequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(requestCoordinator2);
            Request obtainRequest = obtainRequest(target, requestListener, requestOptions2, thumbnailRequestCoordinator, transitionOptions, priority2, i, i2);
            r9.isThumbnailBuilt = true;
            RequestCoordinator requestCoordinator3 = thumbnailRequestCoordinator;
            Request buildRequestRecursive = r9.thumbnailBuilder.buildRequestRecursive(target, requestListener, thumbnailRequestCoordinator, transitionOptions2, priority4, i5, i6, r9.thumbnailBuilder.requestOptions);
            r9.isThumbnailBuilt = false;
            requestCoordinator3.m11709a(obtainRequest, buildRequestRecursive);
            return requestCoordinator3;
        } else if (r9.thumbSizeMultiplier == null) {
            return obtainRequest(target, requestListener, requestOptions2, requestCoordinator2, transitionOptions, priority2, i, i2);
        } else {
            Request thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(requestCoordinator2);
            RequestListener<TranscodeType> requestListener2 = requestListener;
            Request request = thumbnailRequestCoordinator2;
            TransitionOptions<?, ? super TranscodeType> transitionOptions3 = transitionOptions;
            int i7 = i;
            int i8 = i2;
            thumbnailRequestCoordinator2.m11709a(obtainRequest(target, requestListener2, requestOptions2, request, transitionOptions3, priority2, i7, i8), obtainRequest(target, requestListener2, requestOptions.mo2852b().mo2837a(r9.thumbSizeMultiplier.floatValue()), request, transitionOptions3, getThumbnailPriority(priority2), i7, i8));
            return thumbnailRequestCoordinator2;
        }
    }

    private Request obtainRequest(Target<TranscodeType> target, RequestListener<TranscodeType> requestListener, RequestOptions requestOptions, RequestCoordinator requestCoordinator, TransitionOptions<?, ? super TranscodeType> transitionOptions, Priority priority, int i, int i2) {
        return SingleRequest.obtain(this.context, this.glideContext, this.model, this.transcodeClass, requestOptions, i, i2, priority, target, requestListener, this.requestListener, requestCoordinator, this.glideContext.f3224g, transitionOptions.f3254a);
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(RequestOptions requestOptions, Request request) {
        return (requestOptions.f3620h != null || request.isComplete() == null) ? null : true;
    }
}
