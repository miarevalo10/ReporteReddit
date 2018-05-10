package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    private static TimeInterpolator f16687n;
    ArrayList<ArrayList<ViewHolder>> f16688a = new ArrayList();
    ArrayList<ArrayList<MoveInfo>> f16689b = new ArrayList();
    ArrayList<ArrayList<ChangeInfo>> f16690c = new ArrayList();
    ArrayList<ViewHolder> f16691d = new ArrayList();
    ArrayList<ViewHolder> f16692e = new ArrayList();
    ArrayList<ViewHolder> f16693f = new ArrayList();
    ArrayList<ViewHolder> f16694g = new ArrayList();
    private ArrayList<ViewHolder> f16695o = new ArrayList();
    private ArrayList<ViewHolder> f16696p = new ArrayList();
    private ArrayList<MoveInfo> f16697q = new ArrayList();
    private ArrayList<ChangeInfo> f16698r = new ArrayList();

    class C02025 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewHolder f2230a;
        final /* synthetic */ View f2231b;
        final /* synthetic */ ViewPropertyAnimator f2232c;
        final /* synthetic */ DefaultItemAnimator f2233d;

        public void onAnimationStart(Animator animator) {
        }

        C02025(DefaultItemAnimator defaultItemAnimator, ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2233d = defaultItemAnimator;
            this.f2230a = viewHolder;
            this.f2231b = view;
            this.f2232c = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2231b.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f2232c.setListener(null);
            this.f2233d.m2062f(this.f2230a);
            this.f2233d.f16691d.remove(this.f2230a);
            this.f2233d.m16918c();
        }
    }

    class C02036 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewHolder f2234a;
        final /* synthetic */ int f2235b;
        final /* synthetic */ View f2236c;
        final /* synthetic */ int f2237d;
        final /* synthetic */ ViewPropertyAnimator f2238e;
        final /* synthetic */ DefaultItemAnimator f2239f;

        public void onAnimationStart(Animator animator) {
        }

        C02036(DefaultItemAnimator defaultItemAnimator, ViewHolder viewHolder, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2239f = defaultItemAnimator;
            this.f2234a = viewHolder;
            this.f2235b = i;
            this.f2236c = view;
            this.f2237d = i2;
            this.f2238e = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f2235b != null) {
                this.f2236c.setTranslationX(0.0f);
            }
            if (this.f2237d != null) {
                this.f2236c.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f2238e.setListener(null);
            this.f2239f.m2062f(this.f2234a);
            this.f2239f.f16692e.remove(this.f2234a);
            this.f2239f.m16918c();
        }
    }

    class C02047 extends AnimatorListenerAdapter {
        final /* synthetic */ ChangeInfo f2240a;
        final /* synthetic */ ViewPropertyAnimator f2241b;
        final /* synthetic */ View f2242c;
        final /* synthetic */ DefaultItemAnimator f2243d;

        public void onAnimationStart(Animator animator) {
        }

        C02047(DefaultItemAnimator defaultItemAnimator, ChangeInfo changeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2243d = defaultItemAnimator;
            this.f2240a = changeInfo;
            this.f2241b = viewPropertyAnimator;
            this.f2242c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2241b.setListener(null);
            this.f2242c.setAlpha(1.0f);
            this.f2242c.setTranslationX(0.0f);
            this.f2242c.setTranslationY(0.0f);
            this.f2243d.m2062f(this.f2240a.f2248a);
            this.f2243d.f16694g.remove(this.f2240a.f2248a);
            this.f2243d.m16918c();
        }
    }

    class C02058 extends AnimatorListenerAdapter {
        final /* synthetic */ ChangeInfo f2244a;
        final /* synthetic */ ViewPropertyAnimator f2245b;
        final /* synthetic */ View f2246c;
        final /* synthetic */ DefaultItemAnimator f2247d;

        public void onAnimationStart(Animator animator) {
        }

        C02058(DefaultItemAnimator defaultItemAnimator, ChangeInfo changeInfo, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2247d = defaultItemAnimator;
            this.f2244a = changeInfo;
            this.f2245b = viewPropertyAnimator;
            this.f2246c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2245b.setListener(null);
            this.f2246c.setAlpha(1.0f);
            this.f2246c.setTranslationX(0.0f);
            this.f2246c.setTranslationY(0.0f);
            this.f2247d.m2062f(this.f2244a.f2249b);
            this.f2247d.f16694g.remove(this.f2244a.f2249b);
            this.f2247d.m16918c();
        }
    }

    private static class ChangeInfo {
        public ViewHolder f2248a;
        public ViewHolder f2249b;
        public int f2250c;
        public int f2251d;
        public int f2252e;
        public int f2253f;

        private ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2) {
            this.f2248a = viewHolder;
            this.f2249b = viewHolder2;
        }

        ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.f2250c = i;
            this.f2251d = i2;
            this.f2252e = i3;
            this.f2253f = i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ChangeInfo{oldHolder=");
            stringBuilder.append(this.f2248a);
            stringBuilder.append(", newHolder=");
            stringBuilder.append(this.f2249b);
            stringBuilder.append(", fromX=");
            stringBuilder.append(this.f2250c);
            stringBuilder.append(", fromY=");
            stringBuilder.append(this.f2251d);
            stringBuilder.append(", toX=");
            stringBuilder.append(this.f2252e);
            stringBuilder.append(", toY=");
            stringBuilder.append(this.f2253f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class MoveInfo {
        public ViewHolder f2254a;
        public int f2255b;
        public int f2256c;
        public int f2257d;
        public int f2258e;

        MoveInfo(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.f2254a = viewHolder;
            this.f2255b = i;
            this.f2256c = i2;
            this.f2257d = i3;
            this.f2258e = i4;
        }
    }

    public final void mo3230a() {
        int isEmpty = this.f16695o.isEmpty() ^ 1;
        int isEmpty2 = this.f16697q.isEmpty() ^ 1;
        int isEmpty3 = this.f16698r.isEmpty() ^ 1;
        int isEmpty4 = this.f16696p.isEmpty() ^ 1;
        if (isEmpty != 0 || isEmpty2 != 0 || isEmpty4 != 0 || isEmpty3 != 0) {
            final ArrayList arrayList;
            Runnable c01981;
            Iterator it = this.f16695o.iterator();
            while (it.hasNext()) {
                final ViewHolder viewHolder = (ViewHolder) it.next();
                final View view = viewHolder.f2424c;
                final ViewPropertyAnimator animate = view.animate();
                this.f16693f.add(viewHolder);
                animate.setDuration(this.f2357j).alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ DefaultItemAnimator f2229d;

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        this.f2229d.m2062f(viewHolder);
                        this.f2229d.f16693f.remove(viewHolder);
                        this.f2229d.m16918c();
                    }
                }).start();
            }
            this.f16695o.clear();
            if (isEmpty2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f16697q);
                this.f16689b.add(arrayList);
                this.f16697q.clear();
                c01981 = new Runnable(this) {
                    final /* synthetic */ DefaultItemAnimator f2221b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it.next();
                            ItemAnimator itemAnimator = this.f2221b;
                            ViewHolder viewHolder = moveInfo.f2254a;
                            int i = moveInfo.f2255b;
                            int i2 = moveInfo.f2256c;
                            int i3 = moveInfo.f2257d;
                            int i4 = moveInfo.f2258e;
                            View view = viewHolder.f2424c;
                            i3 -= i;
                            i4 -= i2;
                            if (i3 != 0) {
                                view.animate().translationX(0.0f);
                            }
                            if (i4 != 0) {
                                view.animate().translationY(0.0f);
                            }
                            ViewPropertyAnimator animate = view.animate();
                            itemAnimator.f16692e.add(viewHolder);
                            animate.setDuration(itemAnimator.f2358k).setListener(new C02036(itemAnimator, viewHolder, i3, view, i4, animate)).start();
                        }
                        arrayList.clear();
                        this.f2221b.f16689b.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    ViewCompat.m1225a(((MoveInfo) arrayList.get(0)).f2254a.f2424c, c01981, this.f2357j);
                } else {
                    c01981.run();
                }
            }
            if (isEmpty3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f16698r);
                this.f16690c.add(arrayList);
                this.f16698r.clear();
                c01981 = new Runnable(this) {
                    final /* synthetic */ DefaultItemAnimator f2223b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            View view;
                            ChangeInfo changeInfo = (ChangeInfo) it.next();
                            ItemAnimator itemAnimator = this.f2223b;
                            ViewHolder viewHolder = changeInfo.f2248a;
                            View view2 = null;
                            if (viewHolder == null) {
                                view = null;
                            } else {
                                view = viewHolder.f2424c;
                            }
                            ViewHolder viewHolder2 = changeInfo.f2249b;
                            if (viewHolder2 != null) {
                                view2 = viewHolder2.f2424c;
                            }
                            if (view != null) {
                                ViewPropertyAnimator duration = view.animate().setDuration(itemAnimator.f2359l);
                                itemAnimator.f16694g.add(changeInfo.f2248a);
                                duration.translationX((float) (changeInfo.f2252e - changeInfo.f2250c));
                                duration.translationY((float) (changeInfo.f2253f - changeInfo.f2251d));
                                duration.alpha(0.0f).setListener(new C02047(itemAnimator, changeInfo, duration, view)).start();
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator animate = view2.animate();
                                itemAnimator.f16694g.add(changeInfo.f2249b);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(itemAnimator.f2359l).alpha(1.0f).setListener(new C02058(itemAnimator, changeInfo, animate, view2)).start();
                            }
                        }
                        arrayList.clear();
                        this.f2223b.f16690c.remove(arrayList);
                    }
                };
                if (isEmpty != 0) {
                    ViewCompat.m1225a(((ChangeInfo) arrayList.get(0)).f2248a.f2424c, c01981, this.f2357j);
                } else {
                    c01981.run();
                }
            }
            if (isEmpty4 != 0) {
                long j;
                long j2;
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f16696p);
                this.f16688a.add(arrayList2);
                this.f16696p.clear();
                Runnable c02003 = new Runnable(this) {
                    final /* synthetic */ DefaultItemAnimator f2225b;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            ViewHolder viewHolder = (ViewHolder) it.next();
                            ItemAnimator itemAnimator = this.f2225b;
                            View view = viewHolder.f2424c;
                            ViewPropertyAnimator animate = view.animate();
                            itemAnimator.f16691d.add(viewHolder);
                            animate.alpha(1.0f).setDuration(itemAnimator.f2356i).setListener(new C02025(itemAnimator, viewHolder, view, animate)).start();
                        }
                        arrayList2.clear();
                        this.f2225b.f16688a.remove(arrayList2);
                    }
                };
                if (isEmpty == 0 && isEmpty2 == 0) {
                    if (isEmpty3 == 0) {
                        c02003.run();
                    }
                }
                long j3 = 0;
                if (isEmpty != 0) {
                    j = this.f2357j;
                } else {
                    j = 0;
                }
                if (isEmpty2 != 0) {
                    j2 = this.f2358k;
                } else {
                    j2 = 0;
                }
                if (isEmpty3 != 0) {
                    j3 = this.f2359l;
                }
                ViewCompat.m1225a(((ViewHolder) arrayList2.get(0)).f2424c, c02003, j + Math.max(j2, j3));
            }
        }
    }

    public final boolean mo3231a(ViewHolder viewHolder) {
        m16910h(viewHolder);
        this.f16695o.add(viewHolder);
        return true;
    }

    public final boolean mo3236b(ViewHolder viewHolder) {
        m16910h(viewHolder);
        viewHolder.f2424c.setAlpha(0.0f);
        this.f16696p.add(viewHolder);
        return true;
    }

    public final boolean mo3232a(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.f2424c;
        int translationX = i + ((int) viewHolder.f2424c.getTranslationX());
        int translationY = i2 + ((int) viewHolder.f2424c.getTranslationY());
        m16910h(viewHolder);
        i = i3 - translationX;
        i2 = i4 - translationY;
        if (i == 0 && i2 == 0) {
            m2062f(viewHolder);
            return null;
        }
        if (i != 0) {
            view.setTranslationX((float) (-i));
        }
        if (i2 != 0) {
            view.setTranslationY((float) (-i2));
        }
        this.f16697q.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    public final boolean mo3233a(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return mo3232a(viewHolder, i, i2, i3, i4);
        }
        float translationX = viewHolder.f2424c.getTranslationX();
        float translationY = viewHolder.f2424c.getTranslationY();
        float alpha = viewHolder.f2424c.getAlpha();
        m16910h(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        viewHolder.f2424c.setTranslationX(translationX);
        viewHolder.f2424c.setTranslationY(translationY);
        viewHolder.f2424c.setAlpha(alpha);
        if (viewHolder2 != null) {
            m16910h(viewHolder2);
            viewHolder2.f2424c.setTranslationX((float) (-i5));
            viewHolder2.f2424c.setTranslationY((float) (-i6));
            viewHolder2.f2424c.setAlpha(0.0f);
        }
        this.f16698r.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    private void m16908a(List<ChangeInfo> list, ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) list.get(size);
            if (m16909a(changeInfo, viewHolder) && changeInfo.f2248a == null && changeInfo.f2249b == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void m16906a(ChangeInfo changeInfo) {
        if (changeInfo.f2248a != null) {
            m16909a(changeInfo, changeInfo.f2248a);
        }
        if (changeInfo.f2249b != null) {
            m16909a(changeInfo, changeInfo.f2249b);
        }
    }

    private boolean m16909a(ChangeInfo changeInfo, ViewHolder viewHolder) {
        if (changeInfo.f2249b == viewHolder) {
            changeInfo.f2249b = null;
        } else if (changeInfo.f2248a != viewHolder) {
            return null;
        } else {
            changeInfo.f2248a = null;
        }
        viewHolder.f2424c.setAlpha(1.0f);
        viewHolder.f2424c.setTranslationX(0.0f);
        viewHolder.f2424c.setTranslationY(0.0f);
        m2062f(viewHolder);
        return true;
    }

    public final void mo3237c(ViewHolder viewHolder) {
        int size;
        View view = viewHolder.f2424c;
        view.animate().cancel();
        for (size = this.f16697q.size() - 1; size >= 0; size--) {
            if (((MoveInfo) this.f16697q.get(size)).f2254a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m2062f(viewHolder);
                this.f16697q.remove(size);
            }
        }
        m16908a(this.f16698r, viewHolder);
        if (this.f16695o.remove(viewHolder)) {
            view.setAlpha(1.0f);
            m2062f(viewHolder);
        }
        if (this.f16696p.remove(viewHolder)) {
            view.setAlpha(1.0f);
            m2062f(viewHolder);
        }
        for (size = this.f16690c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f16690c.get(size);
            m16908a(list, viewHolder);
            if (list.isEmpty()) {
                this.f16690c.remove(size);
            }
        }
        for (size = this.f16689b.size() - 1; size >= 0; size--) {
            ArrayList arrayList = (ArrayList) this.f16689b.get(size);
            int size2 = arrayList.size() - 1;
            while (size2 >= 0) {
                if (((MoveInfo) arrayList.get(size2)).f2254a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m2062f(viewHolder);
                    arrayList.remove(size2);
                    if (arrayList.isEmpty()) {
                        this.f16689b.remove(size);
                    }
                } else {
                    size2--;
                }
            }
        }
        for (size = this.f16688a.size() - 1; size >= 0; size--) {
            ArrayList arrayList2 = (ArrayList) this.f16688a.get(size);
            if (arrayList2.remove(viewHolder)) {
                view.setAlpha(1.0f);
                m2062f(viewHolder);
                if (arrayList2.isEmpty()) {
                    this.f16688a.remove(size);
                }
            }
        }
        this.f16693f.remove(viewHolder);
        this.f16691d.remove(viewHolder);
        this.f16694g.remove(viewHolder);
        this.f16692e.remove(viewHolder);
        m16918c();
    }

    private void m16910h(ViewHolder viewHolder) {
        if (f16687n == null) {
            f16687n = new ValueAnimator().getInterpolator();
        }
        viewHolder.f2424c.animate().setInterpolator(f16687n);
        mo3237c(viewHolder);
    }

    public final boolean mo3235b() {
        if (this.f16696p.isEmpty() && this.f16698r.isEmpty() && this.f16697q.isEmpty() && this.f16695o.isEmpty() && this.f16692e.isEmpty() && this.f16693f.isEmpty() && this.f16691d.isEmpty() && this.f16694g.isEmpty() && this.f16689b.isEmpty() && this.f16688a.isEmpty()) {
            if (this.f16690c.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    final void m16918c() {
        if (!mo3235b()) {
            m2061e();
        }
    }

    public final void mo3238d() {
        int size;
        for (size = this.f16697q.size() - 1; size >= 0; size--) {
            MoveInfo moveInfo = (MoveInfo) this.f16697q.get(size);
            View view = moveInfo.f2254a.f2424c;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m2062f(moveInfo.f2254a);
            this.f16697q.remove(size);
        }
        for (size = this.f16695o.size() - 1; size >= 0; size--) {
            m2062f((ViewHolder) this.f16695o.get(size));
            this.f16695o.remove(size);
        }
        for (size = this.f16696p.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) this.f16696p.get(size);
            viewHolder.f2424c.setAlpha(1.0f);
            m2062f(viewHolder);
            this.f16696p.remove(size);
        }
        for (size = this.f16698r.size() - 1; size >= 0; size--) {
            m16906a((ChangeInfo) this.f16698r.get(size));
        }
        this.f16698r.clear();
        if (mo3235b()) {
            ArrayList arrayList;
            for (size = this.f16689b.size() - 1; size >= 0; size--) {
                ArrayList arrayList2 = (ArrayList) this.f16689b.get(size);
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList2.get(size2);
                    View view2 = moveInfo2.f2254a.f2424c;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m2062f(moveInfo2.f2254a);
                    arrayList2.remove(size2);
                    if (arrayList2.isEmpty()) {
                        this.f16689b.remove(arrayList2);
                    }
                }
            }
            for (size = this.f16688a.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.f16688a.get(size);
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ViewHolder viewHolder2 = (ViewHolder) arrayList.get(size3);
                    viewHolder2.f2424c.setAlpha(1.0f);
                    m2062f(viewHolder2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f16688a.remove(arrayList);
                    }
                }
            }
            for (size = this.f16690c.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.f16690c.get(size);
                for (int size4 = arrayList.size() - 1; size4 >= 0; size4--) {
                    m16906a((ChangeInfo) arrayList.get(size4));
                    if (arrayList.isEmpty()) {
                        this.f16690c.remove(arrayList);
                    }
                }
            }
            m16907a(this.f16693f);
            m16907a(this.f16692e);
            m16907a(this.f16691d);
            m16907a(this.f16694g);
            m2061e();
        }
    }

    private static void m16907a(List<ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((ViewHolder) list.get(size)).f2424c.animate().cancel();
        }
    }

    public final boolean mo3234a(ViewHolder viewHolder, List<Object> list) {
        if (list.isEmpty()) {
            if (super.mo3234a(viewHolder, list) == null) {
                return null;
            }
        }
        return true;
    }
}
