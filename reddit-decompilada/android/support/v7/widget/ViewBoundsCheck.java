package android.support.v7.widget;

import android.view.View;

class ViewBoundsCheck {
    final Callback f2668a;
    BoundFlags f2669b = new BoundFlags();

    static class BoundFlags {
        int f2663a = 0;
        int f2664b;
        int f2665c;
        int f2666d;
        int f2667e;

        private static int m2360a(int i, int i2) {
            return i > i2 ? 1 : i == i2 ? 2 : 4;
        }

        BoundFlags() {
        }

        final void m2362a(int i, int i2, int i3, int i4) {
            this.f2664b = i;
            this.f2665c = i2;
            this.f2666d = i3;
            this.f2667e = i4;
        }

        final void m2361a(int i) {
            this.f2663a = i | this.f2663a;
        }

        final boolean m2363a() {
            if ((this.f2663a & 7) != 0 && (this.f2663a & (m2360a(this.f2666d, this.f2664b) << 0)) == 0) {
                return false;
            }
            if ((this.f2663a & 112) != 0 && (this.f2663a & (m2360a(this.f2666d, this.f2665c) << 4)) == 0) {
                return false;
            }
            if ((this.f2663a & 1792) != 0 && (this.f2663a & (m2360a(this.f2667e, this.f2664b) << 8)) == 0) {
                return false;
            }
            if ((this.f2663a & 28672) == 0 || (this.f2663a & (m2360a(this.f2667e, this.f2665c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    interface Callback {
        int mo699a();

        int mo700a(View view);

        View mo701a(int i);

        int mo702b();

        int mo703b(View view);
    }

    ViewBoundsCheck(Callback callback) {
        this.f2668a = callback;
    }

    final View m2369a(int i, int i2, int i3, int i4) {
        int a = this.f2668a.mo699a();
        int b = this.f2668a.mo702b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f2668a.mo701a(i);
            this.f2669b.m2362a(a, b, this.f2668a.mo700a(a2), this.f2668a.mo703b(a2));
            if (i3 != 0) {
                this.f2669b.f2663a = 0;
                this.f2669b.m2361a(i3);
                if (this.f2669b.m2363a()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.f2669b.f2663a = 0;
                this.f2669b.m2361a(i4);
                if (this.f2669b.m2363a()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    final boolean m2370a(View view) {
        this.f2669b.m2362a(this.f2668a.mo699a(), this.f2668a.mo702b(), this.f2668a.mo700a(view), this.f2668a.mo703b(view));
        this.f2669b.f2663a = 0;
        this.f2669b.m2361a(24579);
        return this.f2669b.m2363a();
    }
}
