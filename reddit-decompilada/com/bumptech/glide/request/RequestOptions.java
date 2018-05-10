package com.bumptech.glide.request;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.google.android.gms.ads.AdRequest;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.codecs.mpeg12.MPEGConst;

public class RequestOptions implements Cloneable {
    private static RequestOptions f3611x;
    private boolean f3612A;
    float f3613a = 1.0f;
    DiskCacheStrategy f3614b = DiskCacheStrategy.f3414e;
    public Priority f3615c = Priority.NORMAL;
    Drawable f3616d;
    int f3617e;
    Drawable f3618f;
    int f3619g;
    public boolean f3620h = true;
    public int f3621i = -1;
    public int f3622j = -1;
    Key f3623k = EmptySignature.m11730a();
    boolean f3624l;
    public boolean f3625m = true;
    Drawable f3626n;
    int f3627o;
    public Options f3628p = new Options();
    Map<Class<?>, Transformation<?>> f3629q = new HashMap();
    Class<?> f3630r = Object.class;
    Theme f3631s;
    boolean f3632t;
    boolean f3633u;
    boolean f3634v = true;
    boolean f3635w;
    private int f3636y;
    private boolean f3637z;

    private static boolean mo2861b(int i, int i2) {
        return (i & i2) != 0;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo2852b();
    }

    public static RequestOptions m3134a(DiskCacheStrategy diskCacheStrategy) {
        return new RequestOptions().mo2857b(diskCacheStrategy);
    }

    public static RequestOptions m3131a(Drawable drawable) {
        return new RequestOptions().mo2854b(drawable);
    }

    public static RequestOptions m3130a() {
        if (f3611x == null) {
            f3611x = new RequestOptions().mo2870d(true).mo2883o();
        }
        return f3611x;
    }

    public static RequestOptions m3132a(Key key) {
        return new RequestOptions().mo2855b(key);
    }

    public static RequestOptions m3137a(Class<?> cls) {
        return new RequestOptions().mo2858b((Class) cls);
    }

    public RequestOptions mo2837a(float f) {
        if (this.f3612A) {
            return mo2852b().mo2837a(f);
        }
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                this.f3613a = f;
                this.f3636y |= 2;
                return mo2884q();
            }
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public RequestOptions mo2850a(boolean z) {
        if (this.f3612A) {
            return mo2852b().mo2850a(z);
        }
        this.f3632t = z;
        this.f3636y |= true;
        return mo2884q();
    }

    public RequestOptions mo2860b(boolean z) {
        if (this.f3612A) {
            return mo2852b().mo2860b(z);
        }
        this.f3635w = z;
        this.f3636y |= true;
        return mo2884q();
    }

    public RequestOptions mo2865c(boolean z) {
        if (this.f3612A) {
            return mo2852b().mo2865c(z);
        }
        this.f3633u = z;
        this.f3636y |= true;
        return mo2884q();
    }

    public RequestOptions mo2857b(DiskCacheStrategy diskCacheStrategy) {
        if (this.f3612A) {
            return mo2852b().mo2857b(diskCacheStrategy);
        }
        this.f3614b = (DiskCacheStrategy) Preconditions.m3217a((Object) diskCacheStrategy);
        this.f3636y |= 4;
        return mo2884q();
    }

    public RequestOptions mo2843a(Priority priority) {
        if (this.f3612A) {
            return mo2852b().mo2843a(priority);
        }
        this.f3615c = (Priority) Preconditions.m3217a((Object) priority);
        this.f3636y |= 8;
        return mo2884q();
    }

    public RequestOptions mo2854b(Drawable drawable) {
        if (this.f3612A) {
            return mo2852b().mo2854b(drawable);
        }
        this.f3618f = drawable;
        this.f3636y |= 64;
        return mo2884q();
    }

    public RequestOptions mo2838a(int i) {
        if (this.f3612A) {
            return mo2852b().mo2838a(i);
        }
        this.f3619g = i;
        this.f3636y |= 128;
        return mo2884q();
    }

    public RequestOptions mo2864c(Drawable drawable) {
        if (this.f3612A) {
            return mo2852b().mo2864c(drawable);
        }
        this.f3626n = drawable;
        this.f3636y |= 8192;
        return mo2884q();
    }

    public RequestOptions mo2853b(int i) {
        if (this.f3612A) {
            return mo2852b().mo2853b(i);
        }
        this.f3627o = i;
        this.f3636y |= 16384;
        return mo2884q();
    }

    public RequestOptions mo2869d(Drawable drawable) {
        if (this.f3612A) {
            return mo2852b().mo2869d(drawable);
        }
        this.f3616d = drawable;
        this.f3636y |= 16;
        return mo2884q();
    }

    public RequestOptions mo2863c(int i) {
        if (this.f3612A) {
            return mo2852b().mo2863c(i);
        }
        this.f3617e = i;
        this.f3636y |= 32;
        return mo2884q();
    }

    public RequestOptions mo2841a(Theme theme) {
        if (this.f3612A) {
            return mo2852b().mo2841a(theme);
        }
        this.f3631s = theme;
        this.f3636y |= 32768;
        return mo2884q();
    }

    public RequestOptions mo2870d(boolean z) {
        if (this.f3612A) {
            return mo2852b().mo2870d(true);
        }
        this.f3620h = z ^ true;
        this.f3636y |= 256;
        return mo2884q();
    }

    public RequestOptions mo2839a(int i, int i2) {
        if (this.f3612A) {
            return mo2852b().mo2839a(i, i2);
        }
        this.f3622j = i;
        this.f3621i = i2;
        this.f3636y |= AdRequest.MAX_CONTENT_URL_LENGTH;
        return mo2884q();
    }

    public RequestOptions mo2868d(int i) {
        return mo2839a(i, i);
    }

    public RequestOptions mo2855b(Key key) {
        if (this.f3612A) {
            return mo2852b().mo2855b(key);
        }
        this.f3623k = (Key) Preconditions.m3217a((Object) key);
        this.f3636y |= 1024;
        return mo2884q();
    }

    public RequestOptions mo2852b() {
        try {
            RequestOptions requestOptions = (RequestOptions) super.clone();
            requestOptions.f3628p = new Options();
            requestOptions.f3628p.m11236a(this.f3628p);
            requestOptions.f3629q = new HashMap();
            requestOptions.f3629q.putAll(this.f3629q);
            requestOptions.f3637z = false;
            requestOptions.f3612A = false;
            return requestOptions;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <T> RequestOptions mo2845a(Option<T> option, T t) {
        if (this.f3612A) {
            return mo2852b().mo2845a((Option) option, (Object) t);
        }
        Preconditions.m3217a((Object) option);
        Preconditions.m3217a((Object) t);
        this.f3628p.m11234a(option, t);
        return mo2884q();
    }

    public RequestOptions mo2858b(Class<?> cls) {
        if (this.f3612A) {
            return mo2852b().mo2858b((Class) cls);
        }
        this.f3630r = (Class) Preconditions.m3217a((Object) cls);
        this.f3636y |= 4096;
        return mo2884q();
    }

    public RequestOptions mo2842a(CompressFormat compressFormat) {
        return mo2845a(BitmapEncoder.f16732b, Preconditions.m3217a((Object) compressFormat));
    }

    public RequestOptions mo2872e(int i) {
        return mo2845a(BitmapEncoder.f16731a, Integer.valueOf(i));
    }

    public RequestOptions mo2840a(long j) {
        return mo2845a(VideoDecoder.f12609a, Long.valueOf(j));
    }

    public RequestOptions mo2844a(DecodeFormat decodeFormat) {
        Preconditions.m3217a((Object) decodeFormat);
        return mo2845a(Downsampler.f3525a, (Object) decodeFormat).mo2845a(GifOptions.f3573a, (Object) decodeFormat);
    }

    public RequestOptions mo2862c() {
        return mo2845a(Downsampler.f3528d, Boolean.valueOf(false));
    }

    public RequestOptions mo2847a(DownsampleStrategy downsampleStrategy) {
        return mo2845a(Downsampler.f3526b, Preconditions.m3217a((Object) downsampleStrategy));
    }

    public RequestOptions mo2874f(int i) {
        return mo2845a(HttpGlideUrlLoader.f12579a, Integer.valueOf(i));
    }

    public RequestOptions mo2867d() {
        return m3135a(DownsampleStrategy.f3519b, new CenterCrop());
    }

    public RequestOptions mo2871e() {
        return m3139b(DownsampleStrategy.f3519b, new CenterCrop());
    }

    public RequestOptions mo2873f() {
        return m3136a(DownsampleStrategy.f3518a, new FitCenter(), false);
    }

    public RequestOptions mo2875g() {
        return m3136a(DownsampleStrategy.f3518a, new FitCenter(), true);
    }

    public RequestOptions mo2876h() {
        return m3136a(DownsampleStrategy.f3522e, new CenterInside(), false);
    }

    public RequestOptions mo2877i() {
        return m3136a(DownsampleStrategy.f3522e, new CenterInside(), true);
    }

    public RequestOptions mo2878j() {
        return m3135a(DownsampleStrategy.f3519b, new CircleCrop());
    }

    public RequestOptions mo2879k() {
        return m3139b(DownsampleStrategy.f3522e, new CircleCrop());
    }

    private RequestOptions m3135a(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        RequestOptions requestOptions = this;
        while (requestOptions.f3612A) {
            requestOptions = requestOptions.mo2852b();
        }
        requestOptions.mo2847a(downsampleStrategy);
        return requestOptions.m3133a((Transformation) transformation, (boolean) null);
    }

    private RequestOptions m3139b(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation) {
        RequestOptions requestOptions = this;
        while (requestOptions.f3612A) {
            requestOptions = requestOptions.mo2852b();
        }
        requestOptions.mo2847a(downsampleStrategy);
        return requestOptions.mo2846a((Transformation) transformation);
    }

    private RequestOptions m3136a(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> transformation, boolean z) {
        downsampleStrategy = z ? m3139b(downsampleStrategy, (Transformation) transformation) : m3135a(downsampleStrategy, (Transformation) transformation);
        downsampleStrategy.f3634v = true;
        return downsampleStrategy;
    }

    public RequestOptions mo2846a(Transformation<Bitmap> transformation) {
        return m3133a((Transformation) transformation, true);
    }

    public RequestOptions mo2851a(Transformation<Bitmap>... transformationArr) {
        return m3133a(new MultiTransformation(transformationArr), (boolean) 1);
    }

    public RequestOptions mo2856b(Transformation<Bitmap> transformation) {
        return m3133a((Transformation) transformation, false);
    }

    private RequestOptions m3133a(Transformation<Bitmap> transformation, boolean z) {
        RequestOptions requestOptions = this;
        while (requestOptions.f3612A) {
            requestOptions = requestOptions.mo2852b();
        }
        Transformation drawableTransformation = new DrawableTransformation(transformation, z);
        requestOptions.m3138a(Bitmap.class, (Transformation) transformation, z);
        requestOptions.m3138a(Drawable.class, drawableTransformation, z);
        requestOptions.m3138a(BitmapDrawable.class, drawableTransformation, z);
        requestOptions.m3138a(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return requestOptions.mo2884q();
    }

    public <T> RequestOptions mo2849a(Class<T> cls, Transformation<T> transformation) {
        return m3138a((Class) cls, (Transformation) transformation, false);
    }

    private <T> RequestOptions m3138a(Class<T> cls, Transformation<T> transformation, boolean z) {
        RequestOptions requestOptions = this;
        while (requestOptions.f3612A) {
            requestOptions = requestOptions.mo2852b();
        }
        Preconditions.m3217a((Object) cls);
        Preconditions.m3217a((Object) transformation);
        requestOptions.f3629q.put(cls, transformation);
        requestOptions.f3636y |= MPEGConst.CODE_END;
        requestOptions.f3625m = true;
        requestOptions.f3636y |= 65536;
        requestOptions.f3634v = null;
        if (z) {
            requestOptions.f3636y |= true;
            requestOptions.f3624l = true;
        }
        return requestOptions.mo2884q();
    }

    public <T> RequestOptions mo2859b(Class<T> cls, Transformation<T> transformation) {
        return m3138a((Class) cls, (Transformation) transformation, true);
    }

    public RequestOptions mo2880l() {
        if (this.f3612A) {
            return mo2852b().mo2880l();
        }
        this.f3629q.clear();
        this.f3636y &= -2049;
        this.f3624l = false;
        this.f3636y &= -131073;
        this.f3625m = false;
        this.f3636y |= 65536;
        this.f3634v = true;
        return mo2884q();
    }

    public RequestOptions mo2881m() {
        return mo2845a(GifOptions.f3574b, Boolean.valueOf(true));
    }

    public RequestOptions mo2848a(RequestOptions requestOptions) {
        if (this.f3612A) {
            return mo2852b().mo2848a(requestOptions);
        }
        if (mo2861b(requestOptions.f3636y, 2)) {
            this.f3613a = requestOptions.f3613a;
        }
        if (mo2861b(requestOptions.f3636y, 262144)) {
            this.f3632t = requestOptions.f3632t;
        }
        if (mo2861b(requestOptions.f3636y, 1048576)) {
            this.f3635w = requestOptions.f3635w;
        }
        if (mo2861b(requestOptions.f3636y, 4)) {
            this.f3614b = requestOptions.f3614b;
        }
        if (mo2861b(requestOptions.f3636y, 8)) {
            this.f3615c = requestOptions.f3615c;
        }
        if (mo2861b(requestOptions.f3636y, 16)) {
            this.f3616d = requestOptions.f3616d;
        }
        if (mo2861b(requestOptions.f3636y, 32)) {
            this.f3617e = requestOptions.f3617e;
        }
        if (mo2861b(requestOptions.f3636y, 64)) {
            this.f3618f = requestOptions.f3618f;
        }
        if (mo2861b(requestOptions.f3636y, 128)) {
            this.f3619g = requestOptions.f3619g;
        }
        if (mo2861b(requestOptions.f3636y, 256)) {
            this.f3620h = requestOptions.f3620h;
        }
        if (mo2861b(requestOptions.f3636y, (int) AdRequest.MAX_CONTENT_URL_LENGTH)) {
            this.f3622j = requestOptions.f3622j;
            this.f3621i = requestOptions.f3621i;
        }
        if (mo2861b(requestOptions.f3636y, 1024)) {
            this.f3623k = requestOptions.f3623k;
        }
        if (mo2861b(requestOptions.f3636y, 4096)) {
            this.f3630r = requestOptions.f3630r;
        }
        if (mo2861b(requestOptions.f3636y, 8192)) {
            this.f3626n = requestOptions.f3626n;
        }
        if (mo2861b(requestOptions.f3636y, 16384)) {
            this.f3627o = requestOptions.f3627o;
        }
        if (mo2861b(requestOptions.f3636y, 32768)) {
            this.f3631s = requestOptions.f3631s;
        }
        if (mo2861b(requestOptions.f3636y, 65536)) {
            this.f3625m = requestOptions.f3625m;
        }
        if (mo2861b(requestOptions.f3636y, 131072)) {
            this.f3624l = requestOptions.f3624l;
        }
        if (mo2861b(requestOptions.f3636y, (int) MPEGConst.CODE_END)) {
            this.f3629q.putAll(requestOptions.f3629q);
            this.f3634v = requestOptions.f3634v;
        }
        if (mo2861b(requestOptions.f3636y, 524288)) {
            this.f3633u = requestOptions.f3633u;
        }
        if (!this.f3625m) {
            this.f3629q.clear();
            this.f3636y &= -2049;
            this.f3624l = false;
            this.f3636y &= -131073;
            this.f3634v = true;
        }
        this.f3636y |= requestOptions.f3636y;
        this.f3628p.m11236a(requestOptions.f3628p);
        return mo2884q();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RequestOptions)) {
            return false;
        }
        RequestOptions requestOptions = (RequestOptions) obj;
        if (Float.compare(requestOptions.f3613a, this.f3613a) == 0 && this.f3617e == requestOptions.f3617e && Util.m3232a(this.f3616d, requestOptions.f3616d) && this.f3619g == requestOptions.f3619g && Util.m3232a(this.f3618f, requestOptions.f3618f) && this.f3627o == requestOptions.f3627o && Util.m3232a(this.f3626n, requestOptions.f3626n) && this.f3620h == requestOptions.f3620h && this.f3621i == requestOptions.f3621i && this.f3622j == requestOptions.f3622j && this.f3624l == requestOptions.f3624l && this.f3625m == requestOptions.f3625m && this.f3632t == requestOptions.f3632t && this.f3633u == requestOptions.f3633u && this.f3614b.equals(requestOptions.f3614b) && this.f3615c == requestOptions.f3615c && this.f3628p.equals(requestOptions.f3628p) && this.f3629q.equals(requestOptions.f3629q) && this.f3630r.equals(requestOptions.f3630r) && Util.m3232a(this.f3623k, requestOptions.f3623k) && Util.m3232a(this.f3631s, requestOptions.f3631s) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Util.m3225a(this.f3631s, Util.m3225a(this.f3623k, Util.m3225a(this.f3630r, Util.m3225a(this.f3629q, Util.m3225a(this.f3628p, Util.m3225a(this.f3615c, Util.m3225a(this.f3614b, Util.m3226a(this.f3633u, Util.m3226a(this.f3632t, Util.m3226a(this.f3625m, Util.m3226a(this.f3624l, Util.m3234b(this.f3622j, Util.m3234b(this.f3621i, Util.m3226a(this.f3620h, Util.m3225a(this.f3626n, Util.m3234b(this.f3627o, Util.m3225a(this.f3618f, Util.m3234b(this.f3619g, Util.m3225a(this.f3616d, Util.m3234b(this.f3617e, Util.m3222a(this.f3613a)))))))))))))))))))));
    }

    public RequestOptions mo2882n() {
        this.f3637z = true;
        return this;
    }

    public RequestOptions mo2883o() {
        if (!this.f3637z || this.f3612A) {
            this.f3612A = true;
            return mo2882n();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    private RequestOptions mo2884q() {
        if (!this.f3637z) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    public final boolean m3188p() {
        return Util.m3231a(this.f3622j, this.f3621i);
    }

    public final boolean m3179g(int i) {
        return mo2861b(this.f3636y, i);
    }
}
