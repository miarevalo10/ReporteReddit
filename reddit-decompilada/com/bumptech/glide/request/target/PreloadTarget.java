package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    private static final Handler f19488b = new Handler(Looper.getMainLooper(), new C02781());
    final RequestManager f19489a;

    class C02781 implements Callback {
        C02781() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return null;
            }
            Target target = (PreloadTarget) message.obj;
            target.f19489a.m11200a(target);
            return true;
        }
    }

    public static <Z> PreloadTarget<Z> m20781a(RequestManager requestManager, int i, int i2) {
        return new PreloadTarget(requestManager, i, i2);
    }

    private PreloadTarget(RequestManager requestManager, int i, int i2) {
        super(i, i2);
        this.f19489a = requestManager;
    }

    public final void mo3858a(Z z, Transition<? super Z> transition) {
        f19488b.obtainMessage(1, this).sendToTarget();
    }
}
