package com.reddit.config;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    GlideRequest(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    GlideRequest(Glide glide, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        super(glide, requestManager, cls, context);
    }

    protected GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    public GlideRequest<TranscodeType> sizeMultiplier(float f) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15738b(f);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15738b(f);
        }
        return this;
    }

    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15767e(z);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15767e(z);
        }
        return this;
    }

    public GlideRequest<TranscodeType> useAnimationPool(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15771f(z);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15771f(z);
        }
        return this;
    }

    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15774g(z);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15774g(z);
        }
        return this;
    }

    public GlideRequest<TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15755c(diskCacheStrategy);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15755c(diskCacheStrategy);
        }
        return this;
    }

    public GlideRequest<TranscodeType> priority(Priority priority) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15743b(priority);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15743b(priority);
        }
        return this;
    }

    public GlideRequest<TranscodeType> placeholder(Drawable drawable) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15766e(drawable);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15766e(drawable);
        }
        return this;
    }

    public GlideRequest<TranscodeType> placeholder(int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15776h(i);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15776h(i);
        }
        return this;
    }

    public GlideRequest<TranscodeType> fallback(Drawable drawable) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15770f(drawable);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15770f(drawable);
        }
        return this;
    }

    public GlideRequest<TranscodeType> fallback(int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15779i(i);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15779i(i);
        }
        return this;
    }

    public GlideRequest<TranscodeType> error(Drawable drawable) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15773g(drawable);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15773g(drawable);
        }
        return this;
    }

    public GlideRequest<TranscodeType> error(int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15781j(i);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15781j(i);
        }
        return this;
    }

    public GlideRequest<TranscodeType> theme(Theme theme) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15741b(theme);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15741b(theme);
        }
        return this;
    }

    public GlideRequest<TranscodeType> skipMemoryCache(boolean z) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15777h(z);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15777h(z);
        }
        return this;
    }

    public GlideRequest<TranscodeType> override(int i, int i2) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).mo2861b(i, i2);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).mo2861b(i, i2);
        }
        return this;
    }

    public GlideRequest<TranscodeType> override(int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15783k(i);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15783k(i);
        }
        return this;
    }

    public GlideRequest<TranscodeType> signature(Key key) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15753c(key);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15753c(key);
        }
        return this;
    }

    public <T> GlideRequest<TranscodeType> set(Option<T> option, T t) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15745b((Option) option, (Object) t);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15745b((Option) option, (Object) t);
        }
        return this;
    }

    public GlideRequest<TranscodeType> decode(Class<?> cls) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15756c((Class) cls);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15756c((Class) cls);
        }
        return this;
    }

    public GlideRequest<TranscodeType> encodeFormat(CompressFormat compressFormat) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15742b(compressFormat);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15742b(compressFormat);
        }
        return this;
    }

    public GlideRequest<TranscodeType> encodeQuality(int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15785l(i);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15785l(i);
        }
        return this;
    }

    public GlideRequest<TranscodeType> frame(long j) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15740b(j);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15740b(j);
        }
        return this;
    }

    public GlideRequest<TranscodeType> format(DecodeFormat decodeFormat) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15744b(decodeFormat);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15744b(decodeFormat);
        }
        return this;
    }

    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).mo2884q();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).mo2884q();
        }
        return this;
    }

    public GlideRequest<TranscodeType> downsample(DownsampleStrategy downsampleStrategy) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15746b(downsampleStrategy);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15746b(downsampleStrategy);
        }
        return this;
    }

    public GlideRequest<TranscodeType> timeout(int i) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15787m(i);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15787m(i);
        }
        return this;
    }

    public GlideRequest<TranscodeType> optionalCenterCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15791r();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15791r();
        }
        return this;
    }

    public GlideRequest<TranscodeType> centerCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15792s();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15792s();
        }
        return this;
    }

    public GlideRequest<TranscodeType> optionalFitCenter() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15793t();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15793t();
        }
        return this;
    }

    public GlideRequest<TranscodeType> fitCenter() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15794u();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15794u();
        }
        return this;
    }

    public GlideRequest<TranscodeType> optionalCenterInside() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15795v();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15795v();
        }
        return this;
    }

    public GlideRequest<TranscodeType> centerInside() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15796w();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15796w();
        }
        return this;
    }

    public GlideRequest<TranscodeType> optionalCircleCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15797x();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15797x();
        }
        return this;
    }

    public GlideRequest<TranscodeType> circleCrop() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15798y();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15798y();
        }
        return this;
    }

    public GlideRequest<TranscodeType> transform(Transformation<Bitmap> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15754c((Transformation) transformation);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15754c((Transformation) transformation);
        }
        return this;
    }

    public GlideRequest<TranscodeType> transforms(Transformation<Bitmap>... transformationArr) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15748b((Transformation[]) transformationArr);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15748b((Transformation[]) transformationArr);
        }
        return this;
    }

    public GlideRequest<TranscodeType> optionalTransform(Transformation<Bitmap> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15762d((Transformation) transformation);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15762d((Transformation) transformation);
        }
        return this;
    }

    public <T> GlideRequest<TranscodeType> optionalTransform(Class<T> cls, Transformation<T> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15757c(cls, transformation);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15757c(cls, transformation);
        }
        return this;
    }

    public <T> GlideRequest<TranscodeType> transform(Class<T> cls, Transformation<T> transformation) {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15763d(cls, transformation);
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15763d(cls, transformation);
        }
        return this;
    }

    public GlideRequest<TranscodeType> dontTransform() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15799z();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15799z();
        }
        return this;
    }

    public GlideRequest<TranscodeType> dontAnimate() {
        if (getMutableOptions() instanceof GlideOptions) {
            this.requestOptions = ((GlideOptions) getMutableOptions()).m15713A();
        } else {
            this.requestOptions = new GlideOptions().m15747b(this.requestOptions).m15713A();
        }
        return this;
    }

    public GlideRequest<TranscodeType> apply(RequestOptions requestOptions) {
        return (GlideRequest) super.apply(requestOptions);
    }

    public GlideRequest<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest) super.transition(transitionOptions);
    }

    public GlideRequest<TranscodeType> listener(RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.listener(requestListener);
    }

    public GlideRequest<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.error(requestBuilder);
    }

    public GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.thumbnail((RequestBuilder) requestBuilder);
    }

    @SafeVarargs
    public final GlideRequest<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (GlideRequest) super.thumbnail((RequestBuilder[]) requestBuilderArr);
    }

    public GlideRequest<TranscodeType> thumbnail(float f) {
        return (GlideRequest) super.thumbnail(f);
    }

    public GlideRequest<TranscodeType> load(Object obj) {
        return (GlideRequest) super.load(obj);
    }

    public GlideRequest<TranscodeType> load(Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    public GlideRequest<TranscodeType> load(Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    public GlideRequest<TranscodeType> load(String str) {
        return (GlideRequest) super.load(str);
    }

    public GlideRequest<TranscodeType> load(Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    public GlideRequest<TranscodeType> load(File file) {
        return (GlideRequest) super.load(file);
    }

    public GlideRequest<TranscodeType> load(Integer num) {
        return (GlideRequest) super.load(num);
    }

    @Deprecated
    public GlideRequest<TranscodeType> load(URL url) {
        return (GlideRequest) super.load(url);
    }

    public GlideRequest<TranscodeType> load(byte[] bArr) {
        return (GlideRequest) super.load(bArr);
    }

    public GlideRequest<TranscodeType> clone() {
        return (GlideRequest) super.clone();
    }
}
