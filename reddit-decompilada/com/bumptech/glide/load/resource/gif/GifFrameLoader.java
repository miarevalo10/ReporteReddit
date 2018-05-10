package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
    final GifDecoder f3558a;
    final List<FrameCallback> f3559b;
    final RequestManager f3560c;
    boolean f3561d;
    DelayTarget f3562e;
    boolean f3563f;
    DelayTarget f3564g;
    Bitmap f3565h;
    DelayTarget f3566i;
    private final Handler f3567j;
    private final BitmapPool f3568k;
    private boolean f3569l;
    private boolean f3570m;
    private RequestBuilder<Bitmap> f3571n;
    private Transformation<Bitmap> f3572o;

    public interface FrameCallback {
        void mo1001c();
    }

    private class FrameLoaderCallback implements Callback {
        final /* synthetic */ GifFrameLoader f3557a;

        FrameLoaderCallback(GifFrameLoader gifFrameLoader) {
            this.f3557a = gifFrameLoader;
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                this.f3557a.m3073a((DelayTarget) message.obj);
                return true;
            }
            if (message.what == 2) {
                this.f3557a.f3560c.m11200a((DelayTarget) message.obj);
            }
            return null;
        }
    }

    static class DelayTarget extends SimpleTarget<Bitmap> {
        final int f19483a;
        Bitmap f19484b;
        private final Handler f19485c;
        private final long f19486d;

        public final /* synthetic */ void mo3858a(Object obj, Transition transition) {
            this.f19484b = (Bitmap) obj;
            this.f19485c.sendMessageAtTime(this.f19485c.obtainMessage(1, this), this.f19486d);
        }

        DelayTarget(Handler handler, int i, long j) {
            this.f19485c = handler;
            this.f19483a = i;
            this.f19486d = j;
        }
    }

    private GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f3559b = new ArrayList();
        this.f3560c = requestManager;
        requestManager = new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this));
        this.f3568k = bitmapPool;
        this.f3567j = requestManager;
        this.f3571n = requestBuilder;
        this.f3558a = gifDecoder;
        m3072a(transformation, bitmap);
    }

    final void m3072a(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f3572o = (Transformation) Preconditions.m3217a((Object) transformation);
        this.f3565h = (Bitmap) Preconditions.m3217a((Object) bitmap);
        this.f3571n = this.f3571n.apply(new RequestOptions().mo2846a((Transformation) transformation));
    }

    final int m3071a() {
        return this.f3558a.mo878d();
    }

    final Bitmap m3074b() {
        if (this.f3562e != null) {
            return this.f3562e.f19484b;
        }
        return this.f3565h;
    }

    final void m3075c() {
        if (this.f3561d) {
            if (!this.f3569l) {
                if (this.f3570m) {
                    Preconditions.m3221a(this.f3566i == null, "Pending target must be null when starting from the first frame");
                    this.f3558a.mo880f();
                    this.f3570m = false;
                }
                if (this.f3566i != null) {
                    DelayTarget delayTarget = this.f3566i;
                    this.f3566i = null;
                    m3073a(delayTarget);
                    return;
                }
                this.f3569l = true;
                long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f3558a.mo877c());
                this.f3558a.mo876b();
                this.f3564g = new DelayTarget(this.f3567j, this.f3558a.mo879e(), uptimeMillis);
                this.f3571n.apply(RequestOptions.m3132a(new ObjectKey(Double.valueOf(Math.random())))).load(this.f3558a).into(this.f3564g);
            }
        }
    }

    final void m3076d() {
        if (this.f3565h != null) {
            this.f3568k.mo940a(this.f3565h);
            this.f3565h = null;
        }
    }

    final void m3073a(DelayTarget delayTarget) {
        this.f3569l = false;
        if (this.f3563f) {
            this.f3567j.obtainMessage(2, delayTarget).sendToTarget();
        } else if (this.f3561d) {
            if (delayTarget.f19484b != null) {
                m3076d();
                DelayTarget delayTarget2 = this.f3562e;
                this.f3562e = delayTarget;
                for (delayTarget = this.f3559b.size() - 1; delayTarget >= null; delayTarget--) {
                    ((FrameCallback) this.f3559b.get(delayTarget)).mo1001c();
                }
                if (delayTarget2 != null) {
                    this.f3567j.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            m3075c();
        } else {
            this.f3566i = delayTarget;
        }
    }

    GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.f3192a, Glide.m2780b(glide.f3193b.getBaseContext()), gifDecoder, Glide.m2780b(glide.f3193b.getBaseContext()).mo3783d().apply(RequestOptions.m3134a(DiskCacheStrategy.f3411b).mo2860b(true).mo2870d(true).mo2839a(i, i2)), (Transformation) transformation, bitmap);
    }
}
