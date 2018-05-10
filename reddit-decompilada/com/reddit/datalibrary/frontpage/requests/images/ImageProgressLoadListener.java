package com.reddit.datalibrary.frontpage.requests.images;

import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import java.util.ArrayDeque;
import java.util.Deque;
import timber.log.Timber;

public class ImageProgressLoadListener<T> implements RequestListener<T> {
    private static final Deque<ImageProgressLoadListener<?>> f16335a = new ArrayDeque(20);
    private SnooProgressDrawable f16336b;
    private String f16337c;

    public static <T> ImageProgressLoadListener<T> m16395a(SnooProgressDrawable snooProgressDrawable, String str) {
        ImageProgressLoadListener<T> imageProgressLoadListener = new ImageProgressLoadListener(snooProgressDrawable, str);
        while (f16335a.size() > 19) {
            ((ImageProgressLoadListener) f16335a.removeFirst()).m16396a();
        }
        f16335a.addLast(imageProgressLoadListener);
        return imageProgressLoadListener;
    }

    private ImageProgressLoadListener(SnooProgressDrawable snooProgressDrawable, String str) {
        this.f16336b = snooProgressDrawable;
        this.f16337c = str;
        ProgressMonitorBus.m9343a().register(this);
    }

    public void onEventMainThread(ProgressChangedEvent progressChangedEvent) {
        if (this.f16337c == null || this.f16336b == null || this.f16337c.equals(progressChangedEvent.f10923a)) {
            this.f16336b.a(progressChangedEvent.f10924b);
        }
    }

    private void m16396a() {
        if (this.f16336b != null) {
            ProgressMonitorBus.m9343a().unregister(this);
            this.f16336b = null;
            this.f16337c = null;
        }
    }

    public final boolean mo3043a(GlideException glideException) {
        if (glideException != null) {
            Throwable exception = new Exception("ImageProgressLoadListener");
            StringBuilder stringBuilder = new StringBuilder("Glide Image Load Exception. Message: ");
            stringBuilder.append(glideException.getMessage());
            Timber.c(exception, stringBuilder.toString(), new Object[0]);
        }
        if (this.f16336b != null) {
            this.f16336b.a(-1);
        }
        m16396a();
        return false;
    }

    public final boolean mo3044a(T t) {
        m16396a();
        return null;
    }
}
