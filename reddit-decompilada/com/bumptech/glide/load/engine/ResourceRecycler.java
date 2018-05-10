package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.Util;

class ResourceRecycler {
    private boolean f3440a;
    private final Handler f3441b = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());

    private static final class ResourceRecyclerCallback implements Callback {
        ResourceRecyclerCallback() {
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return null;
            }
            ((Resource) message.obj).mo928d();
            return true;
        }
    }

    ResourceRecycler() {
    }

    final void m2934a(Resource<?> resource) {
        Util.m3230a();
        if (this.f3440a) {
            this.f3441b.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.f3440a = true;
        resource.mo928d();
        this.f3440a = null;
    }
}
