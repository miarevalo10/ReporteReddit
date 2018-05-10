package android.support.v7.view;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {
    public final ArrayList<ViewPropertyAnimatorCompat> f2010a = new ArrayList();
    ViewPropertyAnimatorListener f2011b;
    boolean f2012c;
    private long f2013d = -1;
    private Interpolator f2014e;
    private final ViewPropertyAnimatorListenerAdapter f2015f = new C15941(this);

    class C15941 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimatorCompatSet f16595a;
        private boolean f16596b = false;
        private int f16597c = 0;

        C15941(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
            this.f16595a = viewPropertyAnimatorCompatSet;
        }

        public final void mo377a(View view) {
            if (this.f16596b == null) {
                this.f16596b = true;
                if (this.f16595a.f2011b != null) {
                    this.f16595a.f2011b.mo377a(null);
                }
            }
        }

        public final void mo378b(View view) {
            view = this.f16597c + 1;
            this.f16597c = view;
            if (view == this.f16595a.f2010a.size()) {
                if (this.f16595a.f2011b != null) {
                    this.f16595a.f2011b.mo378b(null);
                }
                this.f16597c = 0;
                this.f16596b = false;
                this.f16595a.f2012c = false;
            }
        }
    }

    public final ViewPropertyAnimatorCompatSet m1700a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f2012c) {
            this.f2010a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public final void m1703a() {
        if (!this.f2012c) {
            Iterator it = this.f2010a.iterator();
            while (it.hasNext()) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
                if (this.f2013d >= 0) {
                    viewPropertyAnimatorCompat.m1292a(this.f2013d);
                }
                if (this.f2014e != null) {
                    viewPropertyAnimatorCompat.m1295a(this.f2014e);
                }
                if (this.f2011b != null) {
                    viewPropertyAnimatorCompat.m1293a(this.f2015f);
                }
                viewPropertyAnimatorCompat.m1299b();
            }
            this.f2012c = true;
        }
    }

    public final void m1704b() {
        if (this.f2012c) {
            Iterator it = this.f2010a.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).m1296a();
            }
            this.f2012c = false;
        }
    }

    public final ViewPropertyAnimatorCompatSet m1705c() {
        if (!this.f2012c) {
            this.f2013d = 250;
        }
        return this;
    }

    public final ViewPropertyAnimatorCompatSet m1702a(Interpolator interpolator) {
        if (!this.f2012c) {
            this.f2014e = interpolator;
        }
        return this;
    }

    public final ViewPropertyAnimatorCompatSet m1701a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f2012c) {
            this.f2011b = viewPropertyAnimatorListener;
        }
        return this;
    }
}
