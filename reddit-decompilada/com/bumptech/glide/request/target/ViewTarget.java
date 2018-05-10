package com.bumptech.glide.request.target;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static boolean f18903c;
    private static Integer f18904d;
    protected final T f18905a;
    boolean f18906b;
    private final SizeDeterminer f18907e;
    private OnAttachStateChangeListener f18908f;
    private boolean f18909g;

    class C02791 implements OnAttachStateChangeListener {
        final /* synthetic */ ViewTarget f3647a;

        C02791(ViewTarget viewTarget) {
            this.f3647a = viewTarget;
        }

        public void onViewAttachedToWindow(View view) {
            view = this.f3647a.mo3272d();
            if (view != null && view.isPaused()) {
                view.begin();
            }
        }

        public void onViewDetachedFromWindow(View view) {
            view = this.f3647a;
            Request d = view.mo3272d();
            if (d != null && !d.isCancelled() && !d.isPaused()) {
                view.f18906b = true;
                d.pause();
                view.f18906b = false;
            }
        }
    }

    static final class SizeDeterminer {
        static Integer f3649a;
        final View f3650b;
        final List<SizeReadyCallback> f3651c = new ArrayList();
        boolean f3652d;
        SizeDeterminerLayoutListener f3653e;

        private static final class SizeDeterminerLayoutListener implements OnPreDrawListener {
            private final WeakReference<SizeDeterminer> f3648a;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f3648a = new WeakReference(sizeDeterminer);
            }

            public final boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    StringBuilder stringBuilder = new StringBuilder("OnGlobalLayoutListener called attachStateListener=");
                    stringBuilder.append(this);
                    Log.v("ViewTarget", stringBuilder.toString());
                }
                SizeDeterminer sizeDeterminer = (SizeDeterminer) this.f3648a.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.m3193a();
                }
                return true;
            }
        }

        private static boolean m3191a(int i) {
            if (i <= 0) {
                if (i != Integer.MIN_VALUE) {
                    return false;
                }
            }
            return true;
        }

        SizeDeterminer(View view) {
            this.f3650b = view;
        }

        final void m3193a() {
            if (!this.f3651c.isEmpty()) {
                int d = m3196d();
                int c = m3195c();
                if (m3192a(d, c)) {
                    Iterator it = new ArrayList(this.f3651c).iterator();
                    while (it.hasNext()) {
                        ((SizeReadyCallback) it.next()).onSizeReady(d, c);
                    }
                    m3194b();
                }
            }
        }

        final void m3194b() {
            ViewTreeObserver viewTreeObserver = this.f3650b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f3653e);
            }
            this.f3653e = null;
            this.f3651c.clear();
        }

        static boolean m3192a(int i, int i2) {
            return (m3191a(i) == 0 || m3191a(i2) == 0) ? false : true;
        }

        final int m3195c() {
            int paddingTop = this.f3650b.getPaddingTop() + this.f3650b.getPaddingBottom();
            LayoutParams layoutParams = this.f3650b.getLayoutParams();
            return m3190a(this.f3650b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        final int m3196d() {
            int paddingLeft = this.f3650b.getPaddingLeft() + this.f3650b.getPaddingRight();
            LayoutParams layoutParams = this.f3650b.getLayoutParams();
            return m3190a(this.f3650b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private int m3190a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f3652d && this.f3650b.isLayoutRequested()) {
                return 0;
            }
            i -= i3;
            if (i > 0) {
                return i;
            }
            if (this.f3650b.isLayoutRequested() != 0 || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4) != 0) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            i = this.f3650b.getContext();
            if (f3649a == 0) {
                i = ((WindowManager) Preconditions.m3217a((WindowManager) i.getSystemService("window"))).getDefaultDisplay();
                i2 = new Point();
                i.getSize(i2);
                f3649a = Integer.valueOf(Math.max(i2.x, i2.y));
            }
            return f3649a.intValue();
        }
    }

    public ViewTarget(T t) {
        this.f18905a = (View) Preconditions.m3217a((Object) t);
        this.f18907e = new SizeDeterminer(t);
    }

    public final ViewTarget<T, Z> m20009f() {
        if (this.f18908f != null) {
            return this;
        }
        this.f18908f = new C02791(this);
        m20002h();
        return this;
    }

    public final ViewTarget<T, Z> m20010g() {
        this.f18907e.f3652d = true;
        return this;
    }

    public void mo3270b(Drawable drawable) {
        super.mo3270b(drawable);
        m20002h();
    }

    private void m20002h() {
        if (this.f18908f != null) {
            if (!this.f18909g) {
                this.f18905a.addOnAttachStateChangeListener(this.f18908f);
                this.f18909g = true;
            }
        }
    }

    public final void mo3857a(SizeReadyCallback sizeReadyCallback) {
        SizeDeterminer sizeDeterminer = this.f18907e;
        int d = sizeDeterminer.m3196d();
        int c = sizeDeterminer.m3195c();
        if (SizeDeterminer.m3192a(d, c)) {
            sizeReadyCallback.onSizeReady(d, c);
            return;
        }
        if (!sizeDeterminer.f3651c.contains(sizeReadyCallback)) {
            sizeDeterminer.f3651c.add(sizeReadyCallback);
        }
        if (sizeDeterminer.f3653e == null) {
            sizeReadyCallback = sizeDeterminer.f3650b.getViewTreeObserver();
            sizeDeterminer.f3653e = new SizeDeterminerLayoutListener(sizeDeterminer);
            sizeReadyCallback.addOnPreDrawListener(sizeDeterminer.f3653e);
        }
    }

    public final void mo3859b(SizeReadyCallback sizeReadyCallback) {
        this.f18907e.f3651c.remove(sizeReadyCallback);
    }

    public void mo3268a(Drawable drawable) {
        super.mo3268a(drawable);
        this.f18907e.m3194b();
        if (this.f18906b == null && this.f18908f != null) {
            if (this.f18909g != null) {
                this.f18905a.removeOnAttachStateChangeListener(this.f18908f);
                this.f18909g = null;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Target for: ");
        stringBuilder.append(this.f18905a);
        return stringBuilder.toString();
    }

    public final void mo3269a(Request request) {
        if (f18904d == null) {
            f18903c = true;
            this.f18905a.setTag(request);
            return;
        }
        this.f18905a.setTag(f18904d.intValue(), request);
    }

    public final Request mo3272d() {
        Object tag;
        if (f18904d == null) {
            tag = this.f18905a.getTag();
        } else {
            tag = this.f18905a.getTag(f18904d.intValue());
        }
        if (tag == null) {
            return null;
        }
        if (tag instanceof Request) {
            return (Request) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
}
