package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public abstract class OrientationHelper {
    protected final LayoutManager f2338a;
    int f2339b;
    final Rect f2340c;

    public abstract int mo661a(View view);

    public abstract void mo662a(int i);

    public abstract int mo663b();

    public abstract int mo664b(View view);

    public abstract int mo665c();

    public abstract int mo666c(View view);

    public abstract int mo667d();

    public abstract int mo668d(View view);

    public abstract int mo669e();

    public abstract int mo670e(View view);

    public abstract int mo671f();

    public abstract int mo672f(View view);

    public abstract int mo673g();

    public abstract int mo674h();

    private OrientationHelper(LayoutManager layoutManager) {
        this.f2339b = Integer.MIN_VALUE;
        this.f2340c = new Rect();
        this.f2338a = layoutManager;
    }

    public final int m1991a() {
        return Integer.MIN_VALUE == this.f2339b ? 0 : mo669e() - this.f2339b;
    }

    public static OrientationHelper m1989a(LayoutManager layoutManager, int i) {
        switch (i) {
            case 0:
                return m1988a(layoutManager);
            case 1:
                return m1990b(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static OrientationHelper m1988a(LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public final int mo665c() {
                return this.a.f2367D - this.a.m2156v();
            }

            public final int mo667d() {
                return this.a.f2367D;
            }

            public final void mo662a(int i) {
                this.a.mo730f(i);
            }

            public final int mo663b() {
                return this.a.m2154t();
            }

            public final int mo670e(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return (LayoutManager.m2077c(view) + layoutParams.leftMargin) + layoutParams.rightMargin;
            }

            public final int mo672f(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return (LayoutManager.m2078d(view) + layoutParams.topMargin) + layoutParams.bottomMargin;
            }

            public final int mo664b(View view) {
                return LayoutManager.m2082g(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public final int mo661a(View view) {
                return LayoutManager.m2080e(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public final int mo666c(View view) {
                this.a.m2105a(view, this.c);
                return this.c.right;
            }

            public final int mo668d(View view) {
                this.a.m2105a(view, this.c);
                return this.c.left;
            }

            public final int mo669e() {
                return (this.a.f2367D - this.a.m2154t()) - this.a.m2156v();
            }

            public final int mo671f() {
                return this.a.m2156v();
            }

            public final int mo673g() {
                return this.a.f2365B;
            }

            public final int mo674h() {
                return this.a.f2366C;
            }
        };
    }

    public static OrientationHelper m1990b(LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public final int mo665c() {
                return this.a.f2368E - this.a.m2157w();
            }

            public final int mo667d() {
                return this.a.f2368E;
            }

            public final void mo662a(int i) {
                this.a.mo731g(i);
            }

            public final int mo663b() {
                return this.a.m2155u();
            }

            public final int mo670e(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return (LayoutManager.m2078d(view) + layoutParams.topMargin) + layoutParams.bottomMargin;
            }

            public final int mo672f(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return (LayoutManager.m2077c(view) + layoutParams.leftMargin) + layoutParams.rightMargin;
            }

            public final int mo664b(View view) {
                return LayoutManager.m2083h(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public final int mo661a(View view) {
                return LayoutManager.m2081f(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public final int mo666c(View view) {
                this.a.m2105a(view, this.c);
                return this.c.bottom;
            }

            public final int mo668d(View view) {
                this.a.m2105a(view, this.c);
                return this.c.top;
            }

            public final int mo669e() {
                return (this.a.f2368E - this.a.m2155u()) - this.a.m2157w();
            }

            public final int mo671f() {
                return this.a.m2157w();
            }

            public final int mo673g() {
                return this.a.f2366C;
            }

            public final int mo674h() {
                return this.a.f2365B;
            }
        };
    }
}
