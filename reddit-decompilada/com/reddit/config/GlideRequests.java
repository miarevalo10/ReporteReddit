package com.reddit.config;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;

public class GlideRequests extends RequestManager {
    public final /* synthetic */ RequestBuilder mo3778a(Uri uri) {
        return m19644b(uri);
    }

    public final /* synthetic */ RequestBuilder mo3780a(Integer num) {
        return m19645b(num);
    }

    public final /* synthetic */ RequestBuilder mo3781a(String str) {
        return m19646b(str);
    }

    public GlideRequests(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    public final GlideRequest<Bitmap> m19651h() {
        return (GlideRequest) super.mo3783d();
    }

    public final GlideRequest<GifDrawable> m19652i() {
        return (GlideRequest) super.mo3784e();
    }

    public final GlideRequest<Drawable> m19646b(String str) {
        return (GlideRequest) super.mo3781a(str);
    }

    public final GlideRequest<Drawable> m19644b(Uri uri) {
        return (GlideRequest) super.mo3778a(uri);
    }

    public final GlideRequest<Drawable> m19645b(Integer num) {
        return (GlideRequest) super.mo3780a(num);
    }

    public final GlideRequest<File> m19653j() {
        return (GlideRequest) super.mo3786g();
    }

    protected final void mo3782a(RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.mo3782a(requestOptions);
        } else {
            super.mo3782a(new GlideOptions().m15747b(requestOptions));
        }
    }

    public final /* synthetic */ RequestBuilder mo3779a(Class cls) {
        return new GlideRequest(this.a, this, cls, this.b);
    }

    public final /* bridge */ /* synthetic */ RequestBuilder mo3786g() {
        return (GlideRequest) super.mo3786g();
    }

    public final /* bridge */ /* synthetic */ RequestBuilder mo3785f() {
        return (GlideRequest) super.mo3785f();
    }

    public final /* bridge */ /* synthetic */ RequestBuilder mo3784e() {
        return (GlideRequest) super.mo3784e();
    }

    public final /* bridge */ /* synthetic */ RequestBuilder mo3783d() {
        return (GlideRequest) super.mo3783d();
    }
}
