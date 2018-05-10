package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Map.Entry;

public class RequestManager implements LifecycleListener {
    private static final RequestOptions f12268g = RequestOptions.m3137a(Bitmap.class).mo2882n();
    private static final RequestOptions f12269h = RequestOptions.m3137a(GifDrawable.class).mo2882n();
    private static final RequestOptions f12270i = RequestOptions.m3134a(DiskCacheStrategy.f3412c).mo2843a(Priority.LOW).mo2870d(true);
    protected final Glide f12271a;
    protected final Context f12272b;
    final Lifecycle f12273c;
    final RequestTracker f12274d;
    final TargetTracker f12275e;
    RequestOptions f12276f;
    private final RequestManagerTreeNode f12277j;
    private final Runnable f12278k;
    private final Handler f12279l;
    private final ConnectivityMonitor f12280m;

    class C02661 implements Runnable {
        final /* synthetic */ RequestManager f3251a;

        C02661(RequestManager requestManager) {
            this.f3251a = requestManager;
        }

        public void run() {
            this.f3251a.f12273c.mo1003a(this.f3251a);
        }
    }

    private static class RequestManagerConnectivityListener implements ConnectivityListener {
        private final RequestTracker f12267a;

        RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.f12267a = requestTracker;
        }

        public final void mo870a(boolean z) {
            if (z) {
                z = this.f12267a;
                for (Request request : Util.m3228a(z.f3595a)) {
                    if (!(request.isComplete() || request.isCancelled())) {
                        request.pause();
                        if (z.f3597c) {
                            z.f3596b.add(request);
                        } else {
                            request.begin();
                        }
                    }
                }
            }
        }
    }

    private static class ClearTarget extends ViewTarget<View, Object> {
        public final void mo3858a(Object obj, Transition<? super Object> transition) {
        }

        ClearTarget(View view) {
            super(view);
        }
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.f3197f, context);
    }

    private RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f12275e = new TargetTracker();
        this.f12278k = new C02661(this);
        this.f12279l = new Handler(Looper.getMainLooper());
        this.f12271a = glide;
        this.f12273c = lifecycle;
        this.f12277j = requestManagerTreeNode;
        this.f12274d = requestTracker;
        this.f12272b = context;
        this.f12280m = connectivityMonitorFactory.mo1005a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        if (Util.m3239d() != null) {
            this.f12279l.post(this.f12278k);
        } else {
            lifecycle.mo1003a(this);
        }
        lifecycle.mo1003a(this.f12280m);
        mo3782a(glide.f3193b.f3222e);
        synchronized (glide.f3198g) {
            if (glide.f3198g.contains(this) != null) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            glide.f3198g.add(this);
        }
    }

    protected void mo3782a(RequestOptions requestOptions) {
        this.f12276f = requestOptions.mo2852b().mo2883o();
    }

    @Deprecated
    public final void m11197a(int i) {
        this.f12271a.onTrimMemory(i);
    }

    public final void mo873c() {
        this.f12275e.mo873c();
        for (Target a : Util.m3228a(this.f12275e.f12654a)) {
            m11200a(a);
        }
        this.f12275e.f12654a.clear();
        RequestTracker requestTracker = this.f12274d;
        for (Request a2 : Util.m3228a(requestTracker.f3595a)) {
            requestTracker.m3102a(a2, false);
        }
        requestTracker.f3596b.clear();
        this.f12273c.mo1004b(this);
        this.f12273c.mo1004b(this.f12280m);
        this.f12279l.removeCallbacks(this.f12278k);
        Glide glide = this.f12271a;
        synchronized (glide.f3198g) {
            if (glide.f3198g.contains(this)) {
                glide.f3198g.remove(this);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public RequestBuilder<Bitmap> mo3783d() {
        return mo3779a(Bitmap.class).apply(f12268g);
    }

    public RequestBuilder<GifDrawable> mo3784e() {
        return mo3779a(GifDrawable.class).apply(f12269h);
    }

    public RequestBuilder<Drawable> mo3785f() {
        return mo3779a(Drawable.class);
    }

    public RequestBuilder<Drawable> mo3781a(String str) {
        return mo3785f().load(str);
    }

    public RequestBuilder<Drawable> mo3778a(Uri uri) {
        return mo3785f().load(uri);
    }

    public RequestBuilder<Drawable> mo3780a(Integer num) {
        return mo3785f().load(num);
    }

    public RequestBuilder<File> mo3786g() {
        return mo3779a(File.class).apply(RequestOptions.m3130a());
    }

    public <ResourceType> RequestBuilder<ResourceType> mo3779a(Class<ResourceType> cls) {
        return new RequestBuilder(this.f12271a, this, cls, this.f12272b);
    }

    public final void m11198a(View view) {
        m11200a(new ClearTarget(view));
    }

    public final void m11200a(final Target<?> target) {
        if (target != null) {
            if (Util.m3237c()) {
                if (!(m11203b((Target) target) || this.f12271a.m2782a((Target) target) || target.mo3272d() == null)) {
                    Request d = target.mo3272d();
                    target.mo3269a(null);
                    d.clear();
                }
                return;
            }
            this.f12279l.post(new Runnable(this) {
                final /* synthetic */ RequestManager f3253b;

                public void run() {
                    this.f3253b.m11200a(target);
                }
            });
        }
    }

    final boolean m11203b(Target<?> target) {
        Request d = target.mo3272d();
        if (d == null) {
            return true;
        }
        if (!this.f12274d.m3102a(d, true)) {
            return null;
        }
        this.f12275e.f12654a.remove(target);
        target.mo3269a(null);
        return true;
    }

    final <T> TransitionOptions<?, T> m11201b(Class<T> cls) {
        GlideContext glideContext = this.f12271a.f3193b;
        TransitionOptions<?, T> transitionOptions = (TransitionOptions) glideContext.f3223f.get(cls);
        if (transitionOptions == null) {
            for (Entry entry : glideContext.f3223f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    TransitionOptions transitionOptions2 = (TransitionOptions) entry.getValue();
                }
            }
        }
        return transitionOptions == null ? GlideContext.f3218a : transitionOptions;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{tracker=");
        stringBuilder.append(this.f12274d);
        stringBuilder.append(", treeNode=");
        stringBuilder.append(this.f12277j);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void mo871a() {
        Util.m3230a();
        RequestTracker requestTracker = this.f12274d;
        requestTracker.f3597c = false;
        for (Request request : Util.m3228a(requestTracker.f3595a)) {
            if (!(request.isComplete() || request.isCancelled() || request.isRunning())) {
                request.begin();
            }
        }
        requestTracker.f3596b.clear();
        this.f12275e.mo871a();
    }

    public final void mo872b() {
        Util.m3230a();
        RequestTracker requestTracker = this.f12274d;
        requestTracker.f3597c = true;
        for (Request request : Util.m3228a(requestTracker.f3595a)) {
            if (request.isRunning()) {
                request.pause();
                requestTracker.f3596b.add(request);
            }
        }
        this.f12275e.mo872b();
    }
}
