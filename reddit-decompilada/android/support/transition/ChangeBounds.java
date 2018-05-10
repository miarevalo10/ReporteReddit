package android.support.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.Property;
import android.view.View;

public class ChangeBounds extends Transition {
    private static final String[] f11202k = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> f11203l = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        private Rect f822a = new Rect();

        public final /* synthetic */ Object get(Object obj) {
            ((Drawable) obj).copyBounds(this.f822a);
            return new PointF((float) this.f822a.left, (float) this.f822a.top);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            Drawable drawable = (Drawable) obj;
            PointF pointF = (PointF) obj2;
            drawable.copyBounds(this.f822a);
            this.f822a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f822a);
        }
    };
    private static final Property<ViewBounds, PointF> f11204m = new Property<ViewBounds, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ViewBounds viewBounds = (ViewBounds) obj;
            PointF pointF = (PointF) obj2;
            viewBounds.f833a = Math.round(pointF.x);
            viewBounds.f834b = Math.round(pointF.y);
            viewBounds.f837e++;
            if (viewBounds.f837e == viewBounds.f838f) {
                viewBounds.m434a();
            }
        }
    };
    private static final Property<ViewBounds, PointF> f11205n = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ViewBounds viewBounds = (ViewBounds) obj;
            PointF pointF = (PointF) obj2;
            viewBounds.f835c = Math.round(pointF.x);
            viewBounds.f836d = Math.round(pointF.y);
            viewBounds.f838f++;
            if (viewBounds.f837e == viewBounds.f838f) {
                viewBounds.m434a();
            }
        }
    };
    private static final Property<View, PointF> f11206o = new Property<View, PointF>(PointF.class, "bottomRight") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            ViewUtils.m501a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> f11207p = new Property<View, PointF>(PointF.class, "topLeft") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            ViewUtils.m501a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> f11208q = new Property<View, PointF>(PointF.class, "position") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            obj2 = Math.round(pointF.y);
            ViewUtils.m501a(view, round, obj2, view.getWidth() + round, view.getHeight() + obj2);
        }
    };
    private static RectEvaluator f11209u = new RectEvaluator();
    private int[] f11210r = new int[2];
    private boolean f11211s = false;
    private boolean f11212t = false;

    private static class ViewBounds {
        int f833a;
        int f834b;
        int f835c;
        int f836d;
        int f837e;
        int f838f;
        private View f839g;

        ViewBounds(View view) {
            this.f839g = view;
        }

        final void m434a() {
            ViewUtils.m501a(this.f839g, this.f833a, this.f834b, this.f835c, this.f836d);
            this.f837e = 0;
            this.f838f = 0;
        }
    }

    public final String[] mo133a() {
        return f11202k;
    }

    private void m9655d(TransitionValues transitionValues) {
        View view = transitionValues.f903b;
        if (ViewCompat.m1206G(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.f902a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.f902a.put("android:changeBounds:parent", transitionValues.f903b.getParent());
            if (this.f11212t) {
                transitionValues.f903b.getLocationInWindow(this.f11210r);
                transitionValues.f902a.put("android:changeBounds:windowX", Integer.valueOf(this.f11210r[0]));
                transitionValues.f902a.put("android:changeBounds:windowY", Integer.valueOf(this.f11210r[1]));
            }
            if (this.f11211s) {
                transitionValues.f902a.put("android:changeBounds:clip", ViewCompat.m1208I(view));
            }
        }
    }

    public final void mo132a(TransitionValues transitionValues) {
        m9655d(transitionValues);
    }

    public final void mo134b(TransitionValues transitionValues) {
        m9655d(transitionValues);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator mo131a(android.view.ViewGroup r21, android.support.transition.TransitionValues r22, android.support.transition.TransitionValues r23) {
        /*
        r20 = this;
        r8 = r20;
        r0 = r22;
        r1 = r23;
        if (r0 == 0) goto L_0x026f;
    L_0x0008:
        if (r1 != 0) goto L_0x000c;
    L_0x000a:
        goto L_0x026f;
    L_0x000c:
        r3 = r0.f902a;
        r4 = r1.f902a;
        r5 = "android:changeBounds:parent";
        r3 = r3.get(r5);
        r3 = (android.view.ViewGroup) r3;
        r5 = "android:changeBounds:parent";
        r4 = r4.get(r5);
        r4 = (android.view.ViewGroup) r4;
        if (r3 == 0) goto L_0x026d;
    L_0x0022:
        if (r4 != 0) goto L_0x0026;
    L_0x0024:
        goto L_0x026d;
    L_0x0026:
        r9 = r1.f903b;
        r5 = r8.f11212t;
        r10 = 1;
        if (r5 == 0) goto L_0x003c;
    L_0x002d:
        r5 = r8.m475c(r3, r10);
        if (r5 != 0) goto L_0x0038;
    L_0x0033:
        if (r3 != r4) goto L_0x0036;
    L_0x0035:
        goto L_0x003c;
    L_0x0036:
        r3 = 0;
        goto L_0x003d;
    L_0x0038:
        r3 = r5.f903b;
        if (r4 != r3) goto L_0x0036;
    L_0x003c:
        r3 = r10;
    L_0x003d:
        if (r3 == 0) goto L_0x01c0;
    L_0x003f:
        r3 = r0.f902a;
        r4 = "android:changeBounds:bounds";
        r3 = r3.get(r4);
        r3 = (android.graphics.Rect) r3;
        r4 = r1.f902a;
        r5 = "android:changeBounds:bounds";
        r4 = r4.get(r5);
        r4 = (android.graphics.Rect) r4;
        r5 = r3.left;
        r7 = r4.left;
        r11 = r3.top;
        r12 = r4.top;
        r13 = r3.right;
        r14 = r4.right;
        r3 = r3.bottom;
        r15 = r4.bottom;
        r4 = r13 - r5;
        r2 = r3 - r11;
        r10 = r14 - r7;
        r6 = r15 - r12;
        r0 = r0.f902a;
        r16 = r9;
        r9 = "android:changeBounds:clip";
        r0 = r0.get(r9);
        r0 = (android.graphics.Rect) r0;
        r1 = r1.f902a;
        r9 = "android:changeBounds:clip";
        r1 = r1.get(r9);
        r9 = r1;
        r9 = (android.graphics.Rect) r9;
        if (r4 == 0) goto L_0x0086;
    L_0x0084:
        if (r2 != 0) goto L_0x008a;
    L_0x0086:
        if (r10 == 0) goto L_0x0099;
    L_0x0088:
        if (r6 == 0) goto L_0x0099;
    L_0x008a:
        if (r5 != r7) goto L_0x0091;
    L_0x008c:
        if (r11 == r12) goto L_0x008f;
    L_0x008e:
        goto L_0x0091;
    L_0x008f:
        r1 = 0;
        goto L_0x0092;
    L_0x0091:
        r1 = 1;
    L_0x0092:
        if (r13 != r14) goto L_0x0096;
    L_0x0094:
        if (r3 == r15) goto L_0x009a;
    L_0x0096:
        r1 = r1 + 1;
        goto L_0x009a;
    L_0x0099:
        r1 = 0;
    L_0x009a:
        if (r0 == 0) goto L_0x00a2;
    L_0x009c:
        r17 = r0.equals(r9);
        if (r17 == 0) goto L_0x00a6;
    L_0x00a2:
        if (r0 != 0) goto L_0x00a8;
    L_0x00a4:
        if (r9 == 0) goto L_0x00a8;
    L_0x00a6:
        r1 = r1 + 1;
    L_0x00a8:
        if (r1 <= 0) goto L_0x01fd;
    L_0x00aa:
        r18 = r9;
        r9 = r8.f11211s;
        r19 = r0;
        r0 = 2;
        if (r9 != 0) goto L_0x0139;
    L_0x00b3:
        r9 = r16;
        android.support.transition.ViewUtils.m501a(r9, r5, r11, r13, r3);
        if (r1 != r0) goto L_0x0110;
    L_0x00ba:
        if (r4 != r10) goto L_0x00d0;
    L_0x00bc:
        if (r2 != r6) goto L_0x00d0;
    L_0x00be:
        r0 = r8.f882j;
        r1 = (float) r5;
        r2 = (float) r11;
        r3 = (float) r7;
        r4 = (float) r12;
        r0 = r0.mo157a(r1, r2, r3, r4);
        r1 = f11208q;
        r0 = android.support.transition.ObjectAnimatorUtils.m435a(r9, r1, r0);
        goto L_0x01a5;
    L_0x00d0:
        r1 = new android.support.transition.ChangeBounds$ViewBounds;
        r1.<init>(r9);
        r2 = r8.f882j;
        r4 = (float) r5;
        r5 = (float) r11;
        r6 = (float) r7;
        r7 = (float) r12;
        r2 = r2.mo157a(r4, r5, r6, r7);
        r4 = f11204m;
        r2 = android.support.transition.ObjectAnimatorUtils.m435a(r1, r4, r2);
        r4 = r8.f882j;
        r5 = (float) r13;
        r3 = (float) r3;
        r6 = (float) r14;
        r7 = (float) r15;
        r3 = r4.mo157a(r5, r3, r6, r7);
        r4 = f11205n;
        r3 = android.support.transition.ObjectAnimatorUtils.m435a(r1, r4, r3);
        r4 = new android.animation.AnimatorSet;
        r4.<init>();
        r0 = new android.animation.Animator[r0];
        r5 = 0;
        r0[r5] = r2;
        r2 = 1;
        r0[r2] = r3;
        r4.playTogether(r0);
        r0 = new android.support.transition.ChangeBounds$7;
        r0.<init>(r8, r1);
        r4.addListener(r0);
        r0 = r4;
        goto L_0x01a5;
    L_0x0110:
        if (r5 != r7) goto L_0x0127;
    L_0x0112:
        if (r11 == r12) goto L_0x0115;
    L_0x0114:
        goto L_0x0127;
    L_0x0115:
        r0 = r8.f882j;
        r1 = (float) r13;
        r2 = (float) r3;
        r3 = (float) r14;
        r4 = (float) r15;
        r0 = r0.mo157a(r1, r2, r3, r4);
        r1 = f11206o;
        r0 = android.support.transition.ObjectAnimatorUtils.m435a(r9, r1, r0);
        goto L_0x01a5;
    L_0x0127:
        r0 = r8.f882j;
        r1 = (float) r5;
        r2 = (float) r11;
        r3 = (float) r7;
        r4 = (float) r12;
        r0 = r0.mo157a(r1, r2, r3, r4);
        r1 = f11207p;
        r0 = android.support.transition.ObjectAnimatorUtils.m435a(r9, r1, r0);
        goto L_0x01a5;
    L_0x0139:
        r9 = r16;
        r1 = java.lang.Math.max(r4, r10);
        r3 = java.lang.Math.max(r2, r6);
        r1 = r1 + r5;
        r3 = r3 + r11;
        android.support.transition.ViewUtils.m501a(r9, r5, r11, r1, r3);
        if (r5 != r7) goto L_0x014f;
    L_0x014a:
        if (r11 == r12) goto L_0x014d;
    L_0x014c:
        goto L_0x014f;
    L_0x014d:
        r11 = 0;
        goto L_0x0160;
    L_0x014f:
        r1 = r8.f882j;
        r3 = (float) r5;
        r5 = (float) r11;
        r11 = (float) r7;
        r13 = (float) r12;
        r1 = r1.mo157a(r3, r5, r11, r13);
        r3 = f11208q;
        r1 = android.support.transition.ObjectAnimatorUtils.m435a(r9, r3, r1);
        r11 = r1;
    L_0x0160:
        if (r19 != 0) goto L_0x0169;
    L_0x0162:
        r1 = new android.graphics.Rect;
        r3 = 0;
        r1.<init>(r3, r3, r4, r2);
        goto L_0x016c;
    L_0x0169:
        r3 = 0;
        r1 = r19;
    L_0x016c:
        if (r18 != 0) goto L_0x0174;
    L_0x016e:
        r2 = new android.graphics.Rect;
        r2.<init>(r3, r3, r10, r6);
        goto L_0x0176;
    L_0x0174:
        r2 = r18;
    L_0x0176:
        r4 = r1.equals(r2);
        if (r4 != 0) goto L_0x01a0;
    L_0x017c:
        android.support.v4.view.ViewCompat.m1218a(r9, r1);
        r4 = "clipBounds";
        r5 = f11209u;
        r0 = new java.lang.Object[r0];
        r0[r3] = r1;
        r1 = 1;
        r0[r1] = r2;
        r10 = android.animation.ObjectAnimator.ofObject(r9, r4, r5, r0);
        r13 = new android.support.transition.ChangeBounds$8;
        r0 = r13;
        r1 = r8;
        r2 = r9;
        r3 = r18;
        r4 = r7;
        r5 = r12;
        r6 = r14;
        r7 = r15;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r10.addListener(r13);
        goto L_0x01a1;
    L_0x01a0:
        r10 = 0;
    L_0x01a1:
        r0 = android.support.transition.TransitionUtils.m488a(r11, r10);
    L_0x01a5:
        r1 = r9.getParent();
        r1 = r1 instanceof android.view.ViewGroup;
        if (r1 == 0) goto L_0x01bf;
    L_0x01ad:
        r1 = r9.getParent();
        r1 = (android.view.ViewGroup) r1;
        r2 = 1;
        android.support.transition.ViewGroupUtils.m491a(r1, r2);
        r2 = new android.support.transition.ChangeBounds$9;
        r2.<init>(r8, r1);
        r8.mo159a(r2);
    L_0x01bf:
        return r0;
    L_0x01c0:
        r2 = r0.f902a;
        r3 = "android:changeBounds:windowX";
        r2 = r2.get(r3);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r0 = r0.f902a;
        r3 = "android:changeBounds:windowY";
        r0 = r0.get(r3);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r3 = r1.f902a;
        r4 = "android:changeBounds:windowX";
        r3 = r3.get(r4);
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        r1 = r1.f902a;
        r4 = "android:changeBounds:windowY";
        r1 = r1.get(r4);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        if (r2 != r3) goto L_0x01ff;
    L_0x01fa:
        if (r0 == r1) goto L_0x01fd;
    L_0x01fc:
        goto L_0x01ff;
    L_0x01fd:
        r0 = 0;
        return r0;
    L_0x01ff:
        r4 = r8.f11210r;
        r5 = r21;
        r5.getLocationInWindow(r4);
        r4 = r9.getWidth();
        r6 = r9.getHeight();
        r7 = android.graphics.Bitmap.Config.ARGB_8888;
        r4 = android.graphics.Bitmap.createBitmap(r4, r6, r7);
        r6 = new android.graphics.Canvas;
        r6.<init>(r4);
        r9.draw(r6);
        r6 = new android.graphics.drawable.BitmapDrawable;
        r6.<init>(r4);
        r7 = android.support.transition.ViewUtils.m505c(r9);
        r4 = 0;
        android.support.transition.ViewUtils.m499a(r9, r4);
        r4 = android.support.transition.ViewUtils.m498a(r21);
        r4.mo176a(r6);
        r4 = r8.f882j;
        r10 = r8.f11210r;
        r11 = 0;
        r10 = r10[r11];
        r2 = r2 - r10;
        r2 = (float) r2;
        r10 = r8.f11210r;
        r12 = 1;
        r10 = r10[r12];
        r0 = r0 - r10;
        r0 = (float) r0;
        r10 = r8.f11210r;
        r10 = r10[r11];
        r3 = r3 - r10;
        r3 = (float) r3;
        r10 = r8.f11210r;
        r10 = r10[r12];
        r1 = r1 - r10;
        r1 = (float) r1;
        r0 = r4.mo157a(r2, r0, r3, r1);
        r1 = f11203l;
        r0 = android.support.transition.PropertyValuesHolderUtils.m438a(r1, r0);
        r1 = new android.animation.PropertyValuesHolder[r12];
        r1[r11] = r0;
        r10 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r6, r1);
        r11 = new android.support.transition.ChangeBounds$10;
        r0 = r11;
        r1 = r8;
        r2 = r5;
        r3 = r6;
        r4 = r9;
        r5 = r7;
        r0.<init>(r1, r2, r3, r4, r5);
        r10.addListener(r11);
        return r10;
    L_0x026d:
        r0 = 0;
        return r0;
    L_0x026f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ChangeBounds.a(android.view.ViewGroup, android.support.transition.TransitionValues, android.support.transition.TransitionValues):android.animation.Animator");
    }
}
