package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.transition.Transition.TransitionListener;
import android.view.View;
import android.view.ViewGroup;

public abstract class Visibility extends Transition {
    private static final String[] f11244l = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    int f11245k = 3;

    private static class VisibilityInfo {
        boolean f924a;
        boolean f925b;
        int f926c;
        int f927d;
        ViewGroup f928e;
        ViewGroup f929f;

        private VisibilityInfo() {
        }
    }

    private static class DisappearListener extends AnimatorListenerAdapter implements AnimatorPauseListenerCompat, TransitionListener {
        boolean f11238a = false;
        private final View f11239b;
        private final int f11240c;
        private final ViewGroup f11241d;
        private final boolean f11242e;
        private boolean f11243f;

        public final void mo138c() {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        DisappearListener(View view, int i) {
            this.f11239b = view;
            this.f11240c = i;
            this.f11241d = (ViewGroup) view.getParent();
            this.f11242e = true;
            m9735a(true);
        }

        public void onAnimationPause(Animator animator) {
            if (this.f11238a == null) {
                ViewUtils.m500a(this.f11239b, this.f11240c);
            }
        }

        public void onAnimationResume(Animator animator) {
            if (this.f11238a == null) {
                ViewUtils.m500a(this.f11239b, 0);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f11238a = true;
        }

        public void onAnimationEnd(Animator animator) {
            m9736d();
        }

        public final void mo136a(Transition transition) {
            m9736d();
            transition.mo165b((TransitionListener) this);
        }

        public final void mo135a() {
            m9735a(false);
        }

        public final void mo137b() {
            m9735a(true);
        }

        private void m9736d() {
            if (!this.f11238a) {
                ViewUtils.m500a(this.f11239b, this.f11240c);
                if (this.f11241d != null) {
                    this.f11241d.invalidate();
                }
            }
            m9735a(false);
        }

        private void m9735a(boolean z) {
            if (this.f11242e && this.f11243f != z && this.f11241d != null) {
                this.f11243f = z;
                ViewGroupUtils.m491a(this.f11241d, z);
            }
        }
    }

    public Animator mo3107a(View view, TransitionValues transitionValues) {
        return null;
    }

    public Animator mo3108b(View view, TransitionValues transitionValues) {
        return null;
    }

    public final String[] mo133a() {
        return f11244l;
    }

    private static void m9742d(TransitionValues transitionValues) {
        transitionValues.f902a.put("android:visibility:visibility", Integer.valueOf(transitionValues.f903b.getVisibility()));
        transitionValues.f902a.put("android:visibility:parent", transitionValues.f903b.getParent());
        Object obj = new int[2];
        transitionValues.f903b.getLocationOnScreen(obj);
        transitionValues.f902a.put("android:visibility:screenLocation", obj);
    }

    public void mo132a(TransitionValues transitionValues) {
        m9742d(transitionValues);
    }

    public final void mo134b(TransitionValues transitionValues) {
        m9742d(transitionValues);
    }

    private static VisibilityInfo m9741b(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f924a = false;
        visibilityInfo.f925b = false;
        if (transitionValues == null || !transitionValues.f902a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f926c = -1;
            visibilityInfo.f928e = null;
        } else {
            visibilityInfo.f926c = ((Integer) transitionValues.f902a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f928e = (ViewGroup) transitionValues.f902a.get("android:visibility:parent");
        }
        if (transitionValues2 == null || !transitionValues2.f902a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f927d = -1;
            visibilityInfo.f929f = null;
        } else {
            visibilityInfo.f927d = ((Integer) transitionValues2.f902a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f929f = (ViewGroup) transitionValues2.f902a.get("android:visibility:parent");
        }
        if (transitionValues == null || transitionValues2 == null) {
            if (transitionValues == null && visibilityInfo.f927d == null) {
                visibilityInfo.f925b = true;
                visibilityInfo.f924a = true;
            } else if (transitionValues2 == null && visibilityInfo.f926c == null) {
                visibilityInfo.f925b = false;
                visibilityInfo.f924a = true;
            }
        } else if (visibilityInfo.f926c == visibilityInfo.f927d && visibilityInfo.f928e == visibilityInfo.f929f) {
            return visibilityInfo;
        } else {
            if (visibilityInfo.f926c != visibilityInfo.f927d) {
                if (visibilityInfo.f926c == null) {
                    visibilityInfo.f925b = false;
                    visibilityInfo.f924a = true;
                } else if (visibilityInfo.f927d == null) {
                    visibilityInfo.f925b = true;
                    visibilityInfo.f924a = true;
                }
            } else if (visibilityInfo.f929f == null) {
                visibilityInfo.f925b = false;
                visibilityInfo.f924a = true;
            } else if (visibilityInfo.f928e == null) {
                visibilityInfo.f925b = true;
                visibilityInfo.f924a = true;
            }
        }
        return visibilityInfo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator mo131a(android.view.ViewGroup r9, android.support.transition.TransitionValues r10, android.support.transition.TransitionValues r11) {
        /*
        r8 = this;
        r0 = m9741b(r10, r11);
        r1 = r0.f924a;
        r2 = 0;
        if (r1 == 0) goto L_0x011e;
    L_0x0009:
        r1 = r0.f928e;
        if (r1 != 0) goto L_0x0011;
    L_0x000d:
        r1 = r0.f929f;
        if (r1 == 0) goto L_0x011e;
    L_0x0011:
        r1 = r0.f925b;
        r3 = 0;
        r4 = 1;
        if (r1 == 0) goto L_0x0042;
    L_0x0017:
        r9 = r8.f11245k;
        r9 = r9 & r4;
        if (r9 != r4) goto L_0x0041;
    L_0x001c:
        if (r11 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0041;
    L_0x001f:
        if (r10 != 0) goto L_0x003a;
    L_0x0021:
        r9 = r11.f903b;
        r9 = r9.getParent();
        r9 = (android.view.View) r9;
        r0 = r8.m475c(r9, r3);
        r9 = r8.m471b(r9, r3);
        r9 = m9741b(r0, r9);
        r9 = r9.f924a;
        if (r9 == 0) goto L_0x003a;
    L_0x0039:
        return r2;
    L_0x003a:
        r9 = r11.f903b;
        r9 = r8.mo3107a(r9, r10);
        return r9;
    L_0x0041:
        return r2;
    L_0x0042:
        r0 = r0.f927d;
        r1 = r8.f11245k;
        r5 = 2;
        r1 = r1 & r5;
        if (r1 != r5) goto L_0x011d;
    L_0x004a:
        if (r10 == 0) goto L_0x004f;
    L_0x004c:
        r1 = r10.f903b;
        goto L_0x0050;
    L_0x004f:
        r1 = r2;
    L_0x0050:
        if (r11 == 0) goto L_0x0055;
    L_0x0052:
        r11 = r11.f903b;
        goto L_0x0056;
    L_0x0055:
        r11 = r2;
    L_0x0056:
        if (r11 == 0) goto L_0x0068;
    L_0x0058:
        r6 = r11.getParent();
        if (r6 != 0) goto L_0x005f;
    L_0x005e:
        goto L_0x0068;
    L_0x005f:
        r6 = 4;
        if (r0 != r6) goto L_0x0063;
    L_0x0062:
        goto L_0x0065;
    L_0x0063:
        if (r1 != r11) goto L_0x00b0;
    L_0x0065:
        r1 = r11;
        r11 = r2;
        goto L_0x00b4;
    L_0x0068:
        if (r11 == 0) goto L_0x006c;
    L_0x006a:
        r1 = r2;
        goto L_0x00b4;
    L_0x006c:
        if (r1 == 0) goto L_0x00b2;
    L_0x006e:
        r11 = r1.getParent();
        if (r11 == 0) goto L_0x00b0;
    L_0x0074:
        r11 = r1.getParent();
        r11 = r11 instanceof android.view.View;
        if (r11 == 0) goto L_0x00b2;
    L_0x007c:
        r11 = r1.getParent();
        r11 = (android.view.View) r11;
        r6 = r8.m471b(r11, r4);
        r7 = r8.m475c(r11, r4);
        r6 = m9741b(r6, r7);
        r6 = r6.f924a;
        if (r6 != 0) goto L_0x0097;
    L_0x0092:
        r11 = android.support.transition.TransitionUtils.m489a(r9, r1, r11);
        goto L_0x006a;
    L_0x0097:
        r6 = r11.getParent();
        if (r6 != 0) goto L_0x00af;
    L_0x009d:
        r11 = r11.getId();
        r6 = -1;
        if (r11 == r6) goto L_0x00af;
    L_0x00a4:
        r11 = r9.findViewById(r11);
        if (r11 == 0) goto L_0x00af;
    L_0x00aa:
        r11 = r8.h;
        if (r11 == 0) goto L_0x00af;
    L_0x00ae:
        goto L_0x00b0;
    L_0x00af:
        r1 = r2;
    L_0x00b0:
        r11 = r1;
        goto L_0x006a;
    L_0x00b2:
        r11 = r2;
        r1 = r11;
    L_0x00b4:
        if (r11 == 0) goto L_0x00fb;
    L_0x00b6:
        if (r10 == 0) goto L_0x00fb;
    L_0x00b8:
        r0 = r10.f902a;
        r1 = "android:visibility:screenLocation";
        r0 = r0.get(r1);
        r0 = (int[]) r0;
        r1 = r0[r3];
        r0 = r0[r4];
        r2 = new int[r5];
        r9.getLocationOnScreen(r2);
        r3 = r2[r3];
        r1 = r1 - r3;
        r3 = r11.getLeft();
        r1 = r1 - r3;
        r11.offsetLeftAndRight(r1);
        r1 = r2[r4];
        r0 = r0 - r1;
        r1 = r11.getTop();
        r0 = r0 - r1;
        r11.offsetTopAndBottom(r0);
        r9 = android.support.transition.ViewGroupUtils.m490a(r9);
        r9.mo3109a(r11);
        r10 = r8.mo3108b(r11, r10);
        if (r10 != 0) goto L_0x00f2;
    L_0x00ee:
        r9.mo3110b(r11);
        goto L_0x00fa;
    L_0x00f2:
        r0 = new android.support.transition.Visibility$1;
        r0.<init>(r8, r9, r11);
        r10.addListener(r0);
    L_0x00fa:
        return r10;
    L_0x00fb:
        if (r1 == 0) goto L_0x011d;
    L_0x00fd:
        r9 = r1.getVisibility();
        android.support.transition.ViewUtils.m500a(r1, r3);
        r10 = r8.mo3108b(r1, r10);
        if (r10 == 0) goto L_0x0119;
    L_0x010a:
        r9 = new android.support.transition.Visibility$DisappearListener;
        r9.<init>(r1, r0);
        r10.addListener(r9);
        android.support.transition.AnimatorUtils.m429a(r10, r9);
        r8.mo159a(r9);
        goto L_0x011c;
    L_0x0119:
        android.support.transition.ViewUtils.m500a(r1, r9);
    L_0x011c:
        return r10;
    L_0x011d:
        return r2;
    L_0x011e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Visibility.a(android.view.ViewGroup, android.support.transition.TransitionValues, android.support.transition.TransitionValues):android.animation.Animator");
    }

    public final boolean mo189a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f902a.containsKey("android:visibility:visibility") != transitionValues.f902a.containsKey("android:visibility:visibility")) {
            return false;
        }
        transitionValues = m9741b(transitionValues, transitionValues2);
        if (transitionValues.f924a == null || (transitionValues.f926c != null && transitionValues.f927d != null)) {
            return false;
        }
        return true;
    }
}
