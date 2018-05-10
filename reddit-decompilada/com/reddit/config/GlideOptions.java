package com.reddit.config;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestOptions;

public final class GlideOptions extends RequestOptions implements Cloneable {
    public final /* synthetic */ RequestOptions mo2837a(float f) {
        return m15738b(f);
    }

    public final /* synthetic */ RequestOptions mo2838a(int i) {
        return m15776h(i);
    }

    public final /* synthetic */ RequestOptions mo2839a(int i, int i2) {
        return mo2861b(i, i2);
    }

    public final /* synthetic */ RequestOptions mo2840a(long j) {
        return m15740b(j);
    }

    public final /* synthetic */ RequestOptions mo2841a(Theme theme) {
        return m15741b(theme);
    }

    public final /* synthetic */ RequestOptions mo2842a(CompressFormat compressFormat) {
        return m15742b(compressFormat);
    }

    public final /* synthetic */ RequestOptions mo2843a(Priority priority) {
        return m15743b(priority);
    }

    public final /* synthetic */ RequestOptions mo2844a(DecodeFormat decodeFormat) {
        return m15744b(decodeFormat);
    }

    public final /* synthetic */ RequestOptions mo2845a(Option option, Object obj) {
        return m15745b(option, obj);
    }

    public final /* synthetic */ RequestOptions mo2846a(Transformation transformation) {
        return m15754c(transformation);
    }

    public final /* synthetic */ RequestOptions mo2847a(DownsampleStrategy downsampleStrategy) {
        return m15746b(downsampleStrategy);
    }

    public final /* synthetic */ RequestOptions mo2848a(RequestOptions requestOptions) {
        return m15747b(requestOptions);
    }

    public final /* synthetic */ RequestOptions mo2849a(Class cls, Transformation transformation) {
        return m15757c(cls, transformation);
    }

    public final /* synthetic */ RequestOptions mo2850a(boolean z) {
        return m15767e(z);
    }

    @SafeVarargs
    public final /* synthetic */ RequestOptions mo2851a(Transformation[] transformationArr) {
        return m15748b(transformationArr);
    }

    public final /* synthetic */ RequestOptions mo2853b(int i) {
        return m15779i(i);
    }

    public final /* synthetic */ RequestOptions mo2854b(Drawable drawable) {
        return m15766e(drawable);
    }

    public final /* synthetic */ RequestOptions mo2855b(Key key) {
        return m15753c(key);
    }

    public final /* synthetic */ RequestOptions mo2856b(Transformation transformation) {
        return m15762d(transformation);
    }

    public final /* synthetic */ RequestOptions mo2857b(DiskCacheStrategy diskCacheStrategy) {
        return m15755c(diskCacheStrategy);
    }

    public final /* synthetic */ RequestOptions mo2858b(Class cls) {
        return m15756c(cls);
    }

    public final /* synthetic */ RequestOptions mo2859b(Class cls, Transformation transformation) {
        return m15763d(cls, transformation);
    }

    public final /* synthetic */ RequestOptions mo2860b(boolean z) {
        return m15771f(z);
    }

    public final /* synthetic */ RequestOptions mo2863c(int i) {
        return m15781j(i);
    }

    public final /* synthetic */ RequestOptions mo2864c(Drawable drawable) {
        return m15770f(drawable);
    }

    public final /* synthetic */ RequestOptions mo2865c(boolean z) {
        return m15774g(z);
    }

    public final /* synthetic */ RequestOptions mo2868d(int i) {
        return m15783k(i);
    }

    public final /* synthetic */ RequestOptions mo2869d(Drawable drawable) {
        return m15773g(drawable);
    }

    public final /* synthetic */ RequestOptions mo2870d(boolean z) {
        return m15777h(z);
    }

    public final /* synthetic */ RequestOptions mo2872e(int i) {
        return m15785l(i);
    }

    public final /* synthetic */ RequestOptions mo2874f(int i) {
        return m15787m(i);
    }

    public final GlideOptions m15738b(float f) {
        return (GlideOptions) super.mo2837a(f);
    }

    public final GlideOptions m15767e(boolean z) {
        return (GlideOptions) super.mo2850a(z);
    }

    public final GlideOptions m15771f(boolean z) {
        return (GlideOptions) super.mo2860b(z);
    }

    public final GlideOptions m15774g(boolean z) {
        return (GlideOptions) super.mo2865c(z);
    }

    public final GlideOptions m15755c(DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions) super.mo2857b(diskCacheStrategy);
    }

    public final GlideOptions m15743b(Priority priority) {
        return (GlideOptions) super.mo2843a(priority);
    }

    public final GlideOptions m15766e(Drawable drawable) {
        return (GlideOptions) super.mo2854b(drawable);
    }

    public final GlideOptions m15776h(int i) {
        return (GlideOptions) super.mo2838a(i);
    }

    public final GlideOptions m15770f(Drawable drawable) {
        return (GlideOptions) super.mo2864c(drawable);
    }

    public final GlideOptions m15779i(int i) {
        return (GlideOptions) super.mo2853b(i);
    }

    public final GlideOptions m15773g(Drawable drawable) {
        return (GlideOptions) super.mo2869d(drawable);
    }

    public final GlideOptions m15781j(int i) {
        return (GlideOptions) super.mo2863c(i);
    }

    public final GlideOptions m15741b(Theme theme) {
        return (GlideOptions) super.mo2841a(theme);
    }

    public final GlideOptions m15777h(boolean z) {
        return (GlideOptions) super.mo2870d(z);
    }

    public final GlideOptions mo2861b(int i, int i2) {
        return (GlideOptions) super.mo2839a(i, i2);
    }

    public final GlideOptions m15783k(int i) {
        return (GlideOptions) super.mo2868d(i);
    }

    public final GlideOptions m15753c(Key key) {
        return (GlideOptions) super.mo2855b(key);
    }

    public final <T> GlideOptions m15745b(Option<T> option, T t) {
        return (GlideOptions) super.mo2845a((Option) option, (Object) t);
    }

    public final GlideOptions m15756c(Class<?> cls) {
        return (GlideOptions) super.mo2858b((Class) cls);
    }

    public final GlideOptions m15742b(CompressFormat compressFormat) {
        return (GlideOptions) super.mo2842a(compressFormat);
    }

    public final GlideOptions m15785l(int i) {
        return (GlideOptions) super.mo2872e(i);
    }

    public final GlideOptions m15740b(long j) {
        return (GlideOptions) super.mo2840a(j);
    }

    public final GlideOptions m15744b(DecodeFormat decodeFormat) {
        return (GlideOptions) super.mo2844a(decodeFormat);
    }

    public final GlideOptions mo2884q() {
        return (GlideOptions) super.mo2862c();
    }

    public final GlideOptions m15746b(DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.mo2847a(downsampleStrategy);
    }

    public final GlideOptions m15787m(int i) {
        return (GlideOptions) super.mo2874f(i);
    }

    public final GlideOptions m15791r() {
        return (GlideOptions) super.mo2867d();
    }

    public final GlideOptions m15792s() {
        return (GlideOptions) super.mo2871e();
    }

    public final GlideOptions m15793t() {
        return (GlideOptions) super.mo2873f();
    }

    public final GlideOptions m15794u() {
        return (GlideOptions) super.mo2875g();
    }

    public final GlideOptions m15795v() {
        return (GlideOptions) super.mo2876h();
    }

    public final GlideOptions m15796w() {
        return (GlideOptions) super.mo2877i();
    }

    public final GlideOptions m15797x() {
        return (GlideOptions) super.mo2878j();
    }

    public final GlideOptions m15798y() {
        return (GlideOptions) super.mo2879k();
    }

    public final GlideOptions m15754c(Transformation<Bitmap> transformation) {
        return (GlideOptions) super.mo2846a((Transformation) transformation);
    }

    @SafeVarargs
    public final GlideOptions m15748b(Transformation<Bitmap>... transformationArr) {
        return (GlideOptions) super.mo2851a((Transformation[]) transformationArr);
    }

    public final GlideOptions m15762d(Transformation<Bitmap> transformation) {
        return (GlideOptions) super.mo2856b((Transformation) transformation);
    }

    public final <T> GlideOptions m15757c(Class<T> cls, Transformation<T> transformation) {
        return (GlideOptions) super.mo2849a((Class) cls, (Transformation) transformation);
    }

    public final <T> GlideOptions m15763d(Class<T> cls, Transformation<T> transformation) {
        return (GlideOptions) super.mo2859b((Class) cls, (Transformation) transformation);
    }

    public final GlideOptions m15799z() {
        return (GlideOptions) super.mo2880l();
    }

    public final GlideOptions m15713A() {
        return (GlideOptions) super.mo2881m();
    }

    public final GlideOptions m15747b(RequestOptions requestOptions) {
        return (GlideOptions) super.mo2848a(requestOptions);
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2883o() {
        return (GlideOptions) super.mo2883o();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2882n() {
        return (GlideOptions) super.mo2882n();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2881m() {
        return (GlideOptions) super.mo2881m();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2880l() {
        return (GlideOptions) super.mo2880l();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2879k() {
        return (GlideOptions) super.mo2879k();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2878j() {
        return (GlideOptions) super.mo2878j();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2877i() {
        return (GlideOptions) super.mo2877i();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2876h() {
        return (GlideOptions) super.mo2876h();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2875g() {
        return (GlideOptions) super.mo2875g();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2873f() {
        return (GlideOptions) super.mo2873f();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2871e() {
        return (GlideOptions) super.mo2871e();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2867d() {
        return (GlideOptions) super.mo2867d();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2862c() {
        return (GlideOptions) super.mo2862c();
    }

    public final /* bridge */ /* synthetic */ RequestOptions mo2852b() {
        return (GlideOptions) super.mo2852b();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (GlideOptions) super.mo2852b();
    }
}
