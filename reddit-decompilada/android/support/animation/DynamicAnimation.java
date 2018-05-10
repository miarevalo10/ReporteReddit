package android.support.animation;

import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationFrameCallback {
    public static final ViewProperty f10959a = new ViewProperty("translationX") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getTranslationX();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setTranslationX(f);
        }
    };
    public static final ViewProperty f10960b = new ViewProperty("translationY") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getTranslationY();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setTranslationY(f);
        }
    };
    public static final ViewProperty f10961c = new ViewProperty("translationZ") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ViewCompat.m1261v((View) obj);
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ViewCompat.m1245g((View) obj, f);
        }
    };
    public static final ViewProperty f10962d = new ViewProperty("scaleX") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getScaleX();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setScaleX(f);
        }
    };
    public static final ViewProperty f10963e = new ViewProperty("scaleY") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getScaleY();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setScaleY(f);
        }
    };
    public static final ViewProperty f10964f = new ViewProperty("rotation") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getRotation();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setRotation(f);
        }
    };
    public static final ViewProperty f10965g = new ViewProperty("rotationX") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getRotationX();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setRotationX(f);
        }
    };
    public static final ViewProperty f10966h = new ViewProperty("rotationY") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getRotationY();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setRotationY(f);
        }
    };
    public static final ViewProperty f10967i = new ViewProperty("x") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getX();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setX(f);
        }
    };
    public static final ViewProperty f10968j = new ViewProperty("y") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getY();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setY(f);
        }
    };
    public static final ViewProperty f10969k = new ViewProperty("z") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ViewCompat.m1207H((View) obj);
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ViewCompat.m1247h((View) obj, f);
        }
    };
    public static final ViewProperty f10970l = new ViewProperty("alpha") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return ((View) obj).getAlpha();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setAlpha(f);
        }
    };
    public static final ViewProperty f10971m = new ViewProperty("scrollX") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return (float) ((View) obj).getScrollX();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setScrollX((int) f);
        }
    };
    public static final ViewProperty f10972n = new ViewProperty("scrollY") {
        public final /* synthetic */ float mo3067a(Object obj) {
            return (float) ((View) obj).getScrollY();
        }

        public final /* synthetic */ void mo3068a(Object obj, float f) {
            ((View) obj).setScrollY((int) f);
        }
    };
    float f10973o = 0.0f;
    float f10974p = Float.MAX_VALUE;
    boolean f10975q = false;
    final Object f10976r;
    final FloatPropertyCompat f10977s;
    boolean f10978t = false;
    float f10979u = Float.MAX_VALUE;
    float f10980v = (-this.f10979u);
    float f10981w;
    private long f10982x = 0;
    private final ArrayList<Object> f10983y = new ArrayList();
    private final ArrayList<Object> f10984z = new ArrayList();

    static class MassState {
        float f35a;
        float f36b;

        MassState() {
        }
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    abstract boolean mo3071b(long j);

    <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.f10976r = k;
        this.f10977s = floatPropertyCompat;
        if (!(this.f10977s == f10964f || this.f10977s == f10965g)) {
            if (this.f10977s != f10966h) {
                if (this.f10977s == f10970l) {
                    this.f10981w = 0.00390625f;
                    return;
                }
                if (this.f10977s != f10962d) {
                    if (this.f10977s != f10963e) {
                        this.f10981w = 1.0f;
                        return;
                    }
                }
                this.f10981w = 0.00390625f;
                return;
            }
        }
        this.f10981w = 0.1f;
    }

    private static <T> void m9420a(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void mo3069a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f10978t && !this.f10978t) {
            this.f10978t = true;
            if (!this.f10975q) {
                this.f10974p = this.f10977s.mo3067a(this.f10976r);
            }
            if (this.f10974p <= this.f10979u) {
                if (this.f10974p >= this.f10980v) {
                    AnimationHandler a = AnimationHandler.m11a();
                    if (a.f30c.size() == 0) {
                        a.m15b().mo3a();
                    }
                    if (!a.f30c.contains(this)) {
                        a.f30c.add(this);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    public final boolean mo4a(long j) {
        int i = 0;
        if (this.f10982x == 0) {
            this.f10982x = j;
            mo3070a(this.f10974p);
            return false;
        }
        long j2 = j - this.f10982x;
        this.f10982x = j;
        j = mo3071b(j2);
        this.f10974p = Math.min(this.f10974p, this.f10979u);
        this.f10974p = Math.max(this.f10974p, this.f10980v);
        mo3070a(this.f10974p);
        if (j != null) {
            this.f10978t = false;
            AnimationHandler a = AnimationHandler.m11a();
            a.f29b.remove(this);
            int indexOf = a.f30c.indexOf(this);
            if (indexOf >= 0) {
                a.f30c.set(indexOf, null);
                a.f31d = true;
            }
            this.f10982x = 0;
            this.f10975q = false;
            while (i < this.f10983y.size()) {
                if (this.f10983y.get(i) != null) {
                    this.f10983y.get(i);
                }
                i++;
            }
            m9420a(this.f10983y);
        }
        return j;
    }

    private void mo3070a(float f) {
        this.f10977s.mo3068a(this.f10976r, f);
        for (int i = 0; i < this.f10984z.size(); i++) {
            if (this.f10984z.get(i) != null) {
                this.f10984z.get(i);
            }
        }
        m9420a(this.f10984z);
    }
}
