package android.support.animation;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.ArrayList;

class AnimationHandler {
    public static final ThreadLocal<AnimationHandler> f28a = new ThreadLocal();
    final SimpleArrayMap<AnimationFrameCallback, Long> f29b = new SimpleArrayMap();
    final ArrayList<AnimationFrameCallback> f30c = new ArrayList();
    boolean f31d = false;
    private final AnimationCallbackDispatcher f32e = new AnimationCallbackDispatcher(this);
    private AnimationFrameCallbackProvider f33f;
    private long f34g = 0;

    class AnimationCallbackDispatcher {
        final /* synthetic */ AnimationHandler f24a;

        AnimationCallbackDispatcher(AnimationHandler animationHandler) {
            this.f24a = animationHandler;
        }

        public final void m6a() {
            this.f24a.f34g = SystemClock.uptimeMillis();
            AnimationHandler.m13b(this.f24a, this.f24a.f34g);
            if (this.f24a.f30c.size() > 0) {
                this.f24a.m15b().mo3a();
            }
        }
    }

    interface AnimationFrameCallback {
        boolean mo4a(long j);
    }

    public static abstract class AnimationFrameCallbackProvider {
        final AnimationCallbackDispatcher f25a;

        abstract void mo3a();

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f25a = animationCallbackDispatcher;
        }
    }

    private static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        private final Runnable f10954b = new C00011(this);
        private final Handler f10955c = new Handler(Looper.myLooper());
        private long f10956d = -1;

        class C00011 implements Runnable {
            final /* synthetic */ FrameCallbackProvider14 f26a;

            C00011(FrameCallbackProvider14 frameCallbackProvider14) {
                this.f26a = frameCallbackProvider14;
            }

            public void run() {
                this.f26a.f10956d = SystemClock.uptimeMillis();
                this.f26a.a.m6a();
            }
        }

        FrameCallbackProvider14(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
        }

        final void mo3a() {
            this.f10955c.postDelayed(this.f10954b, Math.max(10 - (SystemClock.uptimeMillis() - this.f10956d), 0));
        }
    }

    @TargetApi(16)
    private static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        private final Choreographer f10957b = Choreographer.getInstance();
        private final FrameCallback f10958c = new C00021(this);

        class C00021 implements FrameCallback {
            final /* synthetic */ FrameCallbackProvider16 f27a;

            C00021(FrameCallbackProvider16 frameCallbackProvider16) {
                this.f27a = frameCallbackProvider16;
            }

            public void doFrame(long j) {
                this.f27a.a.m6a();
            }
        }

        FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
        }

        final void mo3a() {
            this.f10957b.postFrameCallback(this.f10958c);
        }
    }

    AnimationHandler() {
    }

    public static AnimationHandler m11a() {
        if (f28a.get() == null) {
            f28a.set(new AnimationHandler());
        }
        return (AnimationHandler) f28a.get();
    }

    final AnimationFrameCallbackProvider m15b() {
        if (this.f33f == null) {
            if (VERSION.SDK_INT >= 16) {
                this.f33f = new FrameCallbackProvider16(this.f32e);
            } else {
                this.f33f = new FrameCallbackProvider14(this.f32e);
            }
        }
        return this.f33f;
    }

    static /* synthetic */ void m13b(AnimationHandler animationHandler, long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= animationHandler.f30c.size()) {
                break;
            }
            AnimationFrameCallback animationFrameCallback = (AnimationFrameCallback) animationHandler.f30c.get(i);
            if (animationFrameCallback != null) {
                Long l = (Long) animationHandler.f29b.get(animationFrameCallback);
                if (l != null) {
                    if (l.longValue() < uptimeMillis) {
                        animationHandler.f29b.remove(animationFrameCallback);
                    } else {
                        i2 = 0;
                    }
                }
                if (i2 != 0) {
                    animationFrameCallback.mo4a(j);
                }
            }
            i++;
        }
        if (animationHandler.f31d != null) {
            for (j = animationHandler.f30c.size() - 1; j >= null; j--) {
                if (animationHandler.f30c.get(j) == null) {
                    animationHandler.f30c.remove(j);
                }
            }
            animationHandler.f31d = false;
        }
    }
}
