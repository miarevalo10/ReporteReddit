package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.Request.Builder;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestCreator {
    private static final AtomicInteger f23868l = new AtomicInteger();
    public final Picasso f23869a;
    public final Builder f23870b;
    public boolean f23871c;
    public boolean f23872d;
    public int f23873e;
    public int f23874f;
    public int f23875g;
    public int f23876h;
    public Drawable f23877i;
    public Drawable f23878j;
    public Object f23879k;
    private boolean f23880m;

    RequestCreator(Picasso picasso, Uri uri) {
        this.f23872d = true;
        if (picasso.f23841o) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f23869a = picasso;
        this.f23870b = new Builder(uri, picasso.f23838l);
    }

    RequestCreator() {
        this.f23872d = true;
        this.f23869a = null;
        this.f23870b = new Builder(null, null);
    }

    public final RequestCreator m25789a(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.f23878j != null) {
            throw new IllegalStateException("Error image already set.");
        } else {
            this.f23874f = i;
            return this;
        }
    }

    public final RequestCreator m25788a() {
        Builder builder = this.f23870b;
        if (builder.f23859g) {
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }
        builder.f23858f = true;
        return this;
    }

    public final void m25790a(ImageView imageView, Callback callback) {
        RequestCreator requestCreator = this;
        ImageView imageView2 = imageView;
        Callback callback2 = callback;
        long nanoTime = System.nanoTime();
        Utils.m25822a();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (requestCreator.f23870b.m25786a()) {
            if (requestCreator.f23871c) {
                Object obj;
                int width;
                int height;
                Picasso picasso;
                Builder builder = requestCreator.f23870b;
                if (builder.f23856d == 0) {
                    if (builder.f23857e == 0) {
                        obj = null;
                        if (obj == null) {
                            throw new IllegalStateException("Fit cannot be used with resize.");
                        }
                        width = imageView.getWidth();
                        height = imageView.getHeight();
                        if (width != 0) {
                            if (height == 0) {
                                requestCreator.f23870b.m25785a(width, height);
                            }
                        }
                        if (requestCreator.f23872d) {
                            PicassoDrawable.m25783a(imageView2, m25791b());
                        }
                        picasso = requestCreator.f23869a;
                        picasso.f23836j.put(imageView2, new DeferredRequestCreator(requestCreator, imageView2, callback2));
                        return;
                    }
                }
                obj = 1;
                if (obj == null) {
                    width = imageView.getWidth();
                    height = imageView.getHeight();
                    if (width != 0) {
                        if (height == 0) {
                            requestCreator.f23870b.m25785a(width, height);
                        }
                    }
                    if (requestCreator.f23872d) {
                        PicassoDrawable.m25783a(imageView2, m25791b());
                    }
                    picasso = requestCreator.f23869a;
                    picasso.f23836j.put(imageView2, new DeferredRequestCreator(requestCreator, imageView2, callback2));
                    return;
                }
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            Request a = m25787a(nanoTime);
            String a2 = Utils.m25821a(a);
            if (MemoryPolicy.m25768a(requestCreator.f23875g)) {
                Bitmap b = requestCreator.f23869a.m25780b(a2);
                if (b != null) {
                    requestCreator.f23869a.m25779a((Object) imageView2);
                    PicassoDrawable.m25782a(imageView2, requestCreator.f23869a.f23831e, b, LoadedFrom.MEMORY, requestCreator.f23880m, requestCreator.f23869a.f23839m);
                    if (requestCreator.f23869a.f23840n) {
                        String plainId = a.plainId();
                        StringBuilder stringBuilder = new StringBuilder("from ");
                        stringBuilder.append(LoadedFrom.MEMORY);
                        Utils.m25826a("Main", "completed", plainId, stringBuilder.toString());
                    }
                    if (callback2 != null) {
                        callback.mo5492a();
                    }
                    return;
                }
            }
            if (requestCreator.f23872d) {
                PicassoDrawable.m25783a(imageView2, m25791b());
            }
            requestCreator.f23869a.m25778a(new ImageViewAction(requestCreator.f23869a, imageView2, a, requestCreator.f23875g, requestCreator.f23876h, requestCreator.f23874f, requestCreator.f23878j, a2, requestCreator.f23879k, callback2, requestCreator.f23880m));
        } else {
            requestCreator.f23869a.m25779a((Object) imageView2);
            if (requestCreator.f23872d) {
                PicassoDrawable.m25783a(imageView2, m25791b());
            }
        }
    }

    public final Drawable m25791b() {
        if (this.f23873e != 0) {
            return this.f23869a.f23831e.getResources().getDrawable(this.f23873e);
        }
        return this.f23877i;
    }

    public final Request m25787a(long j) {
        long j2 = j;
        int andIncrement = f23868l.getAndIncrement();
        Builder builder = this.f23870b;
        if (builder.f23859g && builder.f23858f) {
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        } else if (builder.f23858f && builder.f23856d == 0 && builder.f23857e == 0) {
            throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
        } else if (builder.f23859g && builder.f23856d == 0 && builder.f23857e == 0) {
            throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
        } else {
            if (builder.f23867o == null) {
                builder.f23867o = Priority.NORMAL;
            }
            int i = andIncrement;
            Request request = new Request(builder.f23853a, builder.f23854b, builder.f23855c, builder.f23865m, builder.f23856d, builder.f23857e, builder.f23858f, builder.f23859g, builder.f23860h, builder.f23861i, builder.f23862j, builder.f23863k, builder.f23864l, builder.f23866n, builder.f23867o);
            int i2 = i;
            request.id = i2;
            j2 = j;
            request.started = j2;
            boolean z = this.f23869a.f23840n;
            if (z) {
                Utils.m25826a("Main", "created", request.plainId(), request.toString());
            }
            Picasso picasso = r3.f23869a;
            Request a = picasso.f23829c.mo5460a(request);
            if (a == null) {
                StringBuilder stringBuilder = new StringBuilder("Request transformer ");
                stringBuilder.append(picasso.f23829c.getClass().getCanonicalName());
                stringBuilder.append(" returned null for ");
                stringBuilder.append(request);
                throw new IllegalStateException(stringBuilder.toString());
            }
            if (a != request) {
                a.id = i2;
                a.started = j2;
                if (z) {
                    String logId = a.logId();
                    StringBuilder stringBuilder2 = new StringBuilder("into ");
                    stringBuilder2.append(a);
                    Utils.m25826a("Main", "changed", logId, stringBuilder2.toString());
                }
            }
            return a;
        }
    }
}
