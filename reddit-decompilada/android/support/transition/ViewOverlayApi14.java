package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

@RequiresApi(14)
class ViewOverlayApi14 implements ViewOverlayImpl {
    protected OverlayViewGroup f11236a;

    static class OverlayViewGroup extends ViewGroup {
        static Method f911a;
        ViewGroup f912b;
        View f913c;
        ArrayList<Drawable> f914d = null;
        ViewOverlayApi14 f915e;

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = android.view.ViewGroup.class;	 Catch:{ NoSuchMethodException -> 0x001d }
            r1 = "invalidateChildInParentFast";	 Catch:{ NoSuchMethodException -> 0x001d }
            r2 = 3;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001d }
            r3 = 0;	 Catch:{ NoSuchMethodException -> 0x001d }
            r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x001d }
            r3 = 1;	 Catch:{ NoSuchMethodException -> 0x001d }
            r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x001d }
            r3 = 2;	 Catch:{ NoSuchMethodException -> 0x001d }
            r4 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x001d }
            r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x001d }
            r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x001d }
            f911a = r0;	 Catch:{ NoSuchMethodException -> 0x001d }
            return;
        L_0x001d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewOverlayApi14.OverlayViewGroup.<clinit>():void");
        }

        OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.f912b = viewGroup;
            this.f913c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f915e = viewOverlayApi14;
        }

        protected boolean verifyDrawable(Drawable drawable) {
            if (!super.verifyDrawable(drawable)) {
                if (this.f914d == null || this.f914d.contains(drawable) == null) {
                    return null;
                }
            }
            return true;
        }

        public final void m494a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f912b || viewGroup.getParent() == null || !ViewCompat.m1209J(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f912b.getLocationOnScreen(iArr2);
                    ViewCompat.m1236c(view, iArr[0] - iArr2[0]);
                    ViewCompat.m1231b(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public final void m495b(View view) {
            super.removeView(view);
            view = (getChildCount() == null && (this.f914d == null || this.f914d.size() == null)) ? true : null;
            if (view != null) {
                this.f912b.removeView(this);
            }
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f912b.getLocationOnScreen(iArr);
            this.f913c.getLocationOnScreen(iArr2);
            int i = 0;
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f913c.getWidth(), this.f913c.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.f914d == null ? 0 : this.f914d.size();
            while (i < size) {
                ((Drawable) this.f914d.get(i)).draw(canvas);
                i++;
            }
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f912b != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f912b instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    int[] iArr3 = new int[2];
                    int[] iArr4 = new int[2];
                    this.f912b.getLocationOnScreen(iArr3);
                    this.f913c.getLocationOnScreen(iArr4);
                    iArr2[0] = iArr4[0] - iArr3[0];
                    iArr2[1] = iArr4[1] - iArr3[1];
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }

    ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.f11236a = new OverlayViewGroup(context, viewGroup, view, this);
    }

    public final void mo176a(Drawable drawable) {
        Callback callback = this.f11236a;
        if (callback.f914d == null) {
            callback.f914d = new ArrayList();
        }
        if (!callback.f914d.contains(drawable)) {
            callback.f914d.add(drawable);
            callback.invalidate(drawable.getBounds());
            drawable.setCallback(callback);
        }
    }

    public final void mo177b(Drawable drawable) {
        OverlayViewGroup overlayViewGroup = this.f11236a;
        if (overlayViewGroup.f914d != null) {
            overlayViewGroup.f914d.remove(drawable);
            overlayViewGroup.invalidate(drawable.getBounds());
            drawable.setCallback(null);
        }
    }

    static ViewOverlayApi14 m9721c(View view) {
        ViewGroup viewGroup;
        View view2 = view;
        while (view2 != null) {
            if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                viewGroup = (ViewGroup) view2;
                break;
            } else if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        viewGroup = null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof OverlayViewGroup) {
                return ((OverlayViewGroup) childAt).f915e;
            }
        }
        return new ViewGroupOverlayApi14(viewGroup.getContext(), viewGroup, view);
    }
}
