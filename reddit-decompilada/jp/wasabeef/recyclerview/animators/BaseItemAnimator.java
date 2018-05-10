package jp.wasabeef.recyclerview.animators;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder;
import jp.wasabeef.recyclerview.internal.ViewHelper;

public abstract class BaseItemAnimator extends SimpleItemAnimator {
    protected ArrayList<ViewHolder> f35991a;
    protected ArrayList<ViewHolder> f35992b;
    protected Interpolator f35993c;
    private ArrayList<ViewHolder> f35994d;
    private ArrayList<ViewHolder> f35995e;
    private ArrayList<MoveInfo> f35996f;
    private ArrayList<ChangeInfo> f35997g;
    private ArrayList<ArrayList<ViewHolder>> f35998n;
    private ArrayList<ArrayList<MoveInfo>> f35999o;
    private ArrayList<ArrayList<ChangeInfo>> f36000p;
    private ArrayList<ViewHolder> f36001q;
    private ArrayList<ViewHolder> f36002r;

    private static class ChangeInfo {
        public ViewHolder f25251a;
        public ViewHolder f25252b;
        public int f25253c;
        public int f25254d;
        public int f25255e;
        public int f25256f;

        private ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2) {
            this.f25251a = viewHolder;
            this.f25252b = viewHolder2;
        }

        private ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.f25253c = i;
            this.f25254d = i2;
            this.f25255e = i3;
            this.f25256f = i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ChangeInfo{oldHolder=");
            stringBuilder.append(this.f25251a);
            stringBuilder.append(", newHolder=");
            stringBuilder.append(this.f25252b);
            stringBuilder.append(", fromX=");
            stringBuilder.append(this.f25253c);
            stringBuilder.append(", fromY=");
            stringBuilder.append(this.f25254d);
            stringBuilder.append(", toX=");
            stringBuilder.append(this.f25255e);
            stringBuilder.append(", toY=");
            stringBuilder.append(this.f25256f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class MoveInfo {
        public ViewHolder f25257a;
        public int f25258b;
        public int f25259c;
        public int f25260d;
        public int f25261e;

        private MoveInfo(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.f25257a = viewHolder;
            this.f25258b = i;
            this.f25259c = i2;
            this.f25260d = i3;
            this.f25261e = i4;
        }
    }

    private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        public void mo6653a(View view) {
        }

        public void mo6654b(View view) {
        }

        public void mo6655c(View view) {
        }

        private VpaListenerAdapter() {
        }
    }

    protected class DefaultAddVpaListener extends VpaListenerAdapter {
        ViewHolder f35987a;
        final /* synthetic */ BaseItemAnimator f35988b;

        public final void mo6653a(View view) {
        }

        public DefaultAddVpaListener(BaseItemAnimator baseItemAnimator, ViewHolder viewHolder) {
            this.f35988b = baseItemAnimator;
            super();
            this.f35987a = viewHolder;
        }

        public final void mo6655c(View view) {
            ViewHelper.m26773a(view);
        }

        public final void mo6654b(View view) {
            ViewHelper.m26773a(view);
            this.f35988b.f(this.f35987a);
            this.f35988b.f35991a.remove(this.f35987a);
            this.f35988b.m36063c();
        }
    }

    protected class DefaultRemoveVpaListener extends VpaListenerAdapter {
        ViewHolder f35989a;
        final /* synthetic */ BaseItemAnimator f35990b;

        public final void mo6653a(View view) {
        }

        public DefaultRemoveVpaListener(BaseItemAnimator baseItemAnimator, ViewHolder viewHolder) {
            this.f35990b = baseItemAnimator;
            super();
            this.f35989a = viewHolder;
        }

        public final void mo6655c(View view) {
            ViewHelper.m26773a(view);
        }

        public final void mo6654b(View view) {
            ViewHelper.m26773a(view);
            this.f35990b.f(this.f35989a);
            this.f35990b.f35992b.remove(this.f35989a);
            this.f35990b.m36063c();
        }
    }

    protected abstract void mo6928h(ViewHolder viewHolder);

    protected void mo6929i(ViewHolder viewHolder) {
    }

    protected abstract void mo6930j(ViewHolder viewHolder);

    public BaseItemAnimator() {
        this.f35994d = new ArrayList();
        this.f35995e = new ArrayList();
        this.f35996f = new ArrayList();
        this.f35997g = new ArrayList();
        this.f35998n = new ArrayList();
        this.f35999o = new ArrayList();
        this.f36000p = new ArrayList();
        this.f35991a = new ArrayList();
        this.f36001q = new ArrayList();
        this.f35992b = new ArrayList();
        this.f36002r = new ArrayList();
        this.f35993c = new DecelerateInterpolator();
        this.m = false;
    }

    public final void m36067a() {
        int isEmpty = this.f35994d.isEmpty() ^ 1;
        int isEmpty2 = this.f35996f.isEmpty() ^ 1;
        int isEmpty3 = this.f35997g.isEmpty() ^ 1;
        int isEmpty4 = this.f35995e.isEmpty() ^ 1;
        if (isEmpty != 0 || isEmpty2 != 0 || isEmpty4 != 0 || isEmpty3 != 0) {
            final ArrayList arrayList;
            Runnable c21331;
            Iterator it = this.f35994d.iterator();
            while (it.hasNext()) {
                ViewHolder viewHolder = (ViewHolder) it.next();
                if (viewHolder instanceof AnimateViewHolder) {
                    DefaultRemoveVpaListener defaultRemoveVpaListener = new DefaultRemoveVpaListener(this, viewHolder);
                } else {
                    mo6928h(viewHolder);
                }
                this.f35992b.add(viewHolder);
            }
            this.f35994d.clear();
            if (isEmpty2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f35996f);
                this.f35999o.add(arrayList);
                this.f35996f.clear();
                c21331 = new Runnable(this) {
                    final /* synthetic */ BaseItemAnimator f25246b;

                    public void run() {
                        if (this.f25246b.f35999o.remove(arrayList)) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                MoveInfo moveInfo = (MoveInfo) it.next();
                                BaseItemAnimator.m36058a(this.f25246b, moveInfo.f25257a, moveInfo.f25258b, moveInfo.f25259c, moveInfo.f25260d, moveInfo.f25261e);
                            }
                            arrayList.clear();
                        }
                    }
                };
                if (isEmpty != 0) {
                    ViewCompat.a(((MoveInfo) arrayList.get(0)).f25257a.c, c21331, this.j);
                } else {
                    c21331.run();
                }
            }
            if (isEmpty3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f35997g);
                this.f36000p.add(arrayList);
                this.f35997g.clear();
                c21331 = new Runnable(this) {
                    final /* synthetic */ BaseItemAnimator f25248b;

                    public void run() {
                        if (this.f25248b.f36000p.remove(arrayList)) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                BaseItemAnimator.m36059a(this.f25248b, (ChangeInfo) it.next());
                            }
                            arrayList.clear();
                        }
                    }
                };
                if (isEmpty != 0) {
                    ViewCompat.a(((ChangeInfo) arrayList.get(0)).f25251a.c, c21331, this.j);
                } else {
                    c21331.run();
                }
            }
            if (isEmpty4 != 0) {
                long j;
                long j2;
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f35995e);
                this.f35998n.add(arrayList2);
                this.f35995e.clear();
                Runnable c21353 = new Runnable(this) {
                    final /* synthetic */ BaseItemAnimator f25250b;

                    public void run() {
                        if (this.f25250b.f35998n.remove(arrayList2)) {
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                BaseItemAnimator.m36057a(this.f25250b, (ViewHolder) it.next());
                            }
                            arrayList2.clear();
                        }
                    }
                };
                if (isEmpty == 0 && isEmpty2 == 0) {
                    if (isEmpty3 == 0) {
                        c21353.run();
                    }
                }
                long j3 = 0;
                if (isEmpty != 0) {
                    j = this.j;
                } else {
                    j = 0;
                }
                if (isEmpty2 != 0) {
                    j2 = this.k;
                } else {
                    j2 = 0;
                }
                if (isEmpty3 != 0) {
                    j3 = this.l;
                }
                ViewCompat.a(((ViewHolder) arrayList2.get(0)).c, c21353, j + Math.max(j2, j3));
            }
        }
    }

    public final boolean m36068a(ViewHolder viewHolder) {
        m36073c(viewHolder);
        ViewHelper.m26773a(viewHolder.c);
        this.f35994d.add(viewHolder);
        return true;
    }

    public final boolean m36072b(ViewHolder viewHolder) {
        m36073c(viewHolder);
        ViewHelper.m26773a(viewHolder.c);
        if (!(viewHolder instanceof AnimateViewHolder)) {
            mo6929i(viewHolder);
        }
        this.f35995e.add(viewHolder);
        return true;
    }

    protected final long m36078k(ViewHolder viewHolder) {
        return Math.abs((((long) viewHolder.d()) * this.i) / 4);
    }

    public final boolean m36069a(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.c;
        int k = (int) (((float) i) + ViewCompat.k(viewHolder.c));
        int l = (int) (((float) i2) + ViewCompat.l(viewHolder.c));
        m36073c(viewHolder);
        i = i3 - k;
        i2 = i4 - l;
        if (i == 0 && i2 == 0) {
            f(viewHolder);
            return null;
        }
        if (i != 0) {
            ViewCompat.a(view, (float) (-i));
        }
        if (i2 != 0) {
            ViewCompat.b(view, (float) (-i2));
        }
        this.f35996f.add(new MoveInfo(viewHolder, k, l, i3, i4));
        return true;
    }

    public final boolean m36070a(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        ViewHolder viewHolder3 = viewHolder;
        ViewHolder viewHolder4 = viewHolder2;
        float k = ViewCompat.k(viewHolder3.c);
        float l = ViewCompat.l(viewHolder3.c);
        float e = ViewCompat.e(viewHolder3.c);
        m36073c(viewHolder3);
        int i5 = (int) (((float) (i3 - i)) - k);
        int i6 = (int) (((float) (i4 - i2)) - l);
        ViewCompat.a(viewHolder3.c, k);
        ViewCompat.b(viewHolder3.c, l);
        ViewCompat.c(viewHolder3.c, e);
        if (!(viewHolder4 == null || viewHolder4.c == null)) {
            m36073c(viewHolder4);
            ViewCompat.a(viewHolder4.c, (float) (-i5));
            ViewCompat.b(viewHolder4.c, (float) (-i6));
            ViewCompat.c(viewHolder4.c, 0.0f);
        }
        r0.f35997g.add(new ChangeInfo(viewHolder3, viewHolder4, i, i2, i3, i4));
        return true;
    }

    private void m36055a(List<ChangeInfo> list, ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) list.get(size);
            if (m36060a(changeInfo, viewHolder) && changeInfo.f25251a == null && changeInfo.f25252b == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void m36056a(ChangeInfo changeInfo) {
        if (changeInfo.f25251a != null) {
            m36060a(changeInfo, changeInfo.f25251a);
        }
        if (changeInfo.f25252b != null) {
            m36060a(changeInfo, changeInfo.f25252b);
        }
    }

    private boolean m36060a(ChangeInfo changeInfo, ViewHolder viewHolder) {
        if (changeInfo.f25252b == viewHolder) {
            changeInfo.f25252b = null;
        } else if (changeInfo.f25251a != viewHolder) {
            return null;
        } else {
            changeInfo.f25251a = null;
        }
        ViewCompat.c(viewHolder.c, 1.0f);
        ViewCompat.a(viewHolder.c, 0.0f);
        ViewCompat.b(viewHolder.c, 0.0f);
        f(viewHolder);
        return true;
    }

    public final void m36073c(ViewHolder viewHolder) {
        int size;
        View view = viewHolder.c;
        ViewCompat.o(view).a();
        for (size = this.f35996f.size() - 1; size >= 0; size--) {
            if (((MoveInfo) this.f35996f.get(size)).f25257a == viewHolder) {
                ViewCompat.b(view, 0.0f);
                ViewCompat.a(view, 0.0f);
                f(viewHolder);
                this.f35996f.remove(size);
            }
        }
        m36055a(this.f35997g, viewHolder);
        if (this.f35994d.remove(viewHolder)) {
            ViewHelper.m26773a(viewHolder.c);
            f(viewHolder);
        }
        if (this.f35995e.remove(viewHolder)) {
            ViewHelper.m26773a(viewHolder.c);
            f(viewHolder);
        }
        for (size = this.f36000p.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f36000p.get(size);
            m36055a(list, viewHolder);
            if (list.isEmpty()) {
                this.f36000p.remove(size);
            }
        }
        for (size = this.f35999o.size() - 1; size >= 0; size--) {
            ArrayList arrayList = (ArrayList) this.f35999o.get(size);
            int size2 = arrayList.size() - 1;
            while (size2 >= 0) {
                if (((MoveInfo) arrayList.get(size2)).f25257a == viewHolder) {
                    ViewCompat.b(view, 0.0f);
                    ViewCompat.a(view, 0.0f);
                    f(viewHolder);
                    arrayList.remove(size2);
                    if (arrayList.isEmpty()) {
                        this.f35999o.remove(size);
                    }
                } else {
                    size2--;
                }
            }
        }
        for (int size3 = this.f35998n.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f35998n.get(size3);
            if (arrayList2.remove(viewHolder)) {
                ViewHelper.m26773a(viewHolder.c);
                f(viewHolder);
                if (arrayList2.isEmpty()) {
                    this.f35998n.remove(size3);
                }
            }
        }
        this.f35992b.remove(viewHolder);
        this.f35991a.remove(viewHolder);
        this.f36002r.remove(viewHolder);
        this.f36001q.remove(viewHolder);
        m36063c();
    }

    public final boolean m36071b() {
        if (this.f35995e.isEmpty() && this.f35997g.isEmpty() && this.f35996f.isEmpty() && this.f35994d.isEmpty() && this.f36001q.isEmpty() && this.f35992b.isEmpty() && this.f35991a.isEmpty() && this.f36002r.isEmpty() && this.f35999o.isEmpty() && this.f35998n.isEmpty()) {
            if (this.f36000p.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void m36063c() {
        if (!m36071b()) {
            e();
        }
    }

    public final void m36074d() {
        int size;
        for (size = this.f35996f.size() - 1; size >= 0; size--) {
            MoveInfo moveInfo = (MoveInfo) this.f35996f.get(size);
            View view = moveInfo.f25257a.c;
            ViewCompat.b(view, 0.0f);
            ViewCompat.a(view, 0.0f);
            f(moveInfo.f25257a);
            this.f35996f.remove(size);
        }
        for (size = this.f35994d.size() - 1; size >= 0; size--) {
            f((ViewHolder) this.f35994d.get(size));
            this.f35994d.remove(size);
        }
        for (size = this.f35995e.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) this.f35995e.get(size);
            ViewHelper.m26773a(viewHolder.c);
            f(viewHolder);
            this.f35995e.remove(size);
        }
        for (size = this.f35997g.size() - 1; size >= 0; size--) {
            m36056a((ChangeInfo) this.f35997g.get(size));
        }
        this.f35997g.clear();
        if (m36071b()) {
            ArrayList arrayList;
            int size2;
            for (size = this.f35999o.size() - 1; size >= 0; size--) {
                ArrayList arrayList2 = (ArrayList) this.f35999o.get(size);
                for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList2.get(size3);
                    View view2 = moveInfo2.f25257a.c;
                    ViewCompat.b(view2, 0.0f);
                    ViewCompat.a(view2, 0.0f);
                    f(moveInfo2.f25257a);
                    arrayList2.remove(size3);
                    if (arrayList2.isEmpty()) {
                        this.f35999o.remove(arrayList2);
                    }
                }
            }
            for (size = this.f35998n.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.f35998n.get(size);
                for (size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ViewHolder viewHolder2 = (ViewHolder) arrayList.get(size2);
                    ViewCompat.c(viewHolder2.c, 1.0f);
                    f(viewHolder2);
                    if (size2 < arrayList.size()) {
                        arrayList.remove(size2);
                    }
                    if (arrayList.isEmpty()) {
                        this.f35998n.remove(arrayList);
                    }
                }
            }
            for (size = this.f36000p.size() - 1; size >= 0; size--) {
                arrayList = (ArrayList) this.f36000p.get(size);
                for (size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    m36056a((ChangeInfo) arrayList.get(size2));
                    if (arrayList.isEmpty()) {
                        this.f36000p.remove(arrayList);
                    }
                }
            }
            m36054a(this.f35992b);
            m36054a(this.f36001q);
            m36054a(this.f35991a);
            m36054a(this.f36002r);
            e();
        }
    }

    private static void m36054a(List<ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.o(((ViewHolder) list.get(size)).c).a();
        }
    }

    static /* synthetic */ void m36058a(BaseItemAnimator baseItemAnimator, ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.c;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.o(view).b(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.o(view).c(0.0f);
        }
        baseItemAnimator.f36001q.add(viewHolder);
        final ViewPropertyAnimatorCompat o = ViewCompat.o(view);
        final ViewHolder viewHolder2 = viewHolder;
        o.a(baseItemAnimator.k).a(new VpaListenerAdapter(baseItemAnimator) {
            final /* synthetic */ BaseItemAnimator f35979e;

            public final void mo6653a(View view) {
            }

            public final void mo6655c(View view) {
                if (i5 != 0) {
                    ViewCompat.a(view, 0.0f);
                }
                if (i6 != 0) {
                    ViewCompat.b(view, 0.0f);
                }
            }

            public final void mo6654b(View view) {
                o.a(null);
                this.f35979e.f(viewHolder2);
                this.f35979e.f36001q.remove(viewHolder2);
                this.f35979e.m36063c();
            }
        }).b();
    }

    static /* synthetic */ void m36059a(BaseItemAnimator baseItemAnimator, final ChangeInfo changeInfo) {
        View view;
        ViewHolder viewHolder = changeInfo.f25251a;
        View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.c;
        }
        ViewHolder viewHolder2 = changeInfo.f25252b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.c;
        }
        if (view != null) {
            baseItemAnimator.f36002r.add(changeInfo.f25251a);
            final ViewPropertyAnimatorCompat a = ViewCompat.o(view).a(baseItemAnimator.l);
            a.b((float) (changeInfo.f25255e - changeInfo.f25253c));
            a.c((float) (changeInfo.f25256f - changeInfo.f25254d));
            a.a(0.0f).a(new VpaListenerAdapter(baseItemAnimator) {
                final /* synthetic */ BaseItemAnimator f35982c;

                public final void mo6653a(View view) {
                }

                public final void mo6654b(View view) {
                    a.a(null);
                    ViewCompat.c(view, 1.0f);
                    ViewCompat.a(view, 0.0f);
                    ViewCompat.b(view, 0.0f);
                    this.f35982c.f(changeInfo.f25251a);
                    this.f35982c.f36002r.remove(changeInfo.f25251a);
                    this.f35982c.m36063c();
                }
            }).b();
        }
        if (view2 != null) {
            baseItemAnimator.f36002r.add(changeInfo.f25252b);
            a = ViewCompat.o(view2);
            a.b(0.0f).c(0.0f).a(baseItemAnimator.l).a(1.0f).a(new VpaListenerAdapter(baseItemAnimator) {
                final /* synthetic */ BaseItemAnimator f35986d;

                public final void mo6653a(View view) {
                }

                public final void mo6654b(View view) {
                    a.a(null);
                    ViewCompat.c(view2, 1.0f);
                    ViewCompat.a(view2, 0.0f);
                    ViewCompat.b(view2, 0.0f);
                    this.f35986d.f(changeInfo.f25252b);
                    this.f35986d.f36002r.remove(changeInfo.f25252b);
                    this.f35986d.m36063c();
                }
            }).b();
        }
    }

    static /* synthetic */ void m36057a(BaseItemAnimator baseItemAnimator, ViewHolder viewHolder) {
        if (viewHolder instanceof AnimateViewHolder) {
            DefaultAddVpaListener defaultAddVpaListener = new DefaultAddVpaListener(baseItemAnimator, viewHolder);
        } else {
            baseItemAnimator.mo6930j(viewHolder);
        }
        baseItemAnimator.f35991a.add(viewHolder);
    }
}
