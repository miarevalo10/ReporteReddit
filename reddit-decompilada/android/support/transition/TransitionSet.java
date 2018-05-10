package android.support.transition;

import android.support.transition.Transition.EpicenterCallback;
import android.support.transition.Transition.TransitionListener;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    ArrayList<Transition> f11227k = new ArrayList();
    boolean f11228l = true;
    private int f11229m;
    private boolean f11230n = false;

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet f16483a;

        TransitionSetListener(TransitionSet transitionSet) {
            this.f16483a = transitionSet;
        }

        public final void mo138c() {
            if (!this.f16483a.f11230n) {
                this.f16483a.m476c();
                this.f16483a.f11230n = true;
            }
        }

        public final void mo136a(Transition transition) {
            TransitionSet.m9696b(this.f16483a);
            if (this.f16483a.f11229m == 0) {
                this.f16483a.f11230n = false;
                this.f16483a.m478d();
            }
            transition.mo165b((TransitionListener) this);
        }
    }

    static /* synthetic */ int m9696b(TransitionSet transitionSet) {
        int i = transitionSet.f11229m - 1;
        transitionSet.f11229m = i;
        return i;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo172e();
    }

    public final TransitionSet m9709b(Transition transition) {
        this.f11227k.add(transition);
        transition.f879g = this;
        if (this.b >= 0) {
            transition.mo158a(this.b);
        }
        return this;
    }

    public final Transition m9698a(int i) {
        if (i >= 0) {
            if (i < this.f11227k.size()) {
                return (Transition) this.f11227k.get(i);
            }
        }
        return 0;
    }

    public final Transition mo160a(View view, boolean z) {
        for (int i = 0; i < this.f11227k.size(); i++) {
            ((Transition) this.f11227k.get(i)).mo160a(view, z);
        }
        return super.mo160a(view, z);
    }

    protected final void mo167b() {
        if (this.f11227k.isEmpty()) {
            m476c();
            m478d();
            return;
        }
        TransitionListener transitionSetListener = new TransitionSetListener(this);
        Iterator it = this.f11227k.iterator();
        while (it.hasNext()) {
            ((Transition) it.next()).mo159a(transitionSetListener);
        }
        this.f11229m = this.f11227k.size();
        if (this.f11228l) {
            Iterator it2 = this.f11227k.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).mo167b();
            }
            return;
        }
        for (int i = 1; i < this.f11227k.size(); i++) {
            final Transition transition = (Transition) this.f11227k.get(i);
            ((Transition) this.f11227k.get(i - 1)).mo159a(new TransitionListenerAdapter(this) {
                final /* synthetic */ TransitionSet f16482b;

                public final void mo136a(Transition transition) {
                    transition.mo167b();
                    transition.mo165b((TransitionListener) this);
                }
            });
        }
        Transition transition2 = (Transition) this.f11227k.get(0);
        if (transition2 != null) {
            transition2.mo167b();
        }
    }

    public final void mo132a(TransitionValues transitionValues) {
        if (m466a(transitionValues.f903b)) {
            Iterator it = this.f11227k.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.m466a(transitionValues.f903b)) {
                    transition.mo132a(transitionValues);
                    transitionValues.f904c.add(transition);
                }
            }
        }
    }

    public final void mo134b(TransitionValues transitionValues) {
        if (m466a(transitionValues.f903b)) {
            Iterator it = this.f11227k.iterator();
            while (it.hasNext()) {
                Transition transition = (Transition) it.next();
                if (transition.m466a(transitionValues.f903b)) {
                    transition.mo134b(transitionValues);
                    transitionValues.f904c.add(transition);
                }
            }
        }
    }

    final void mo169c(TransitionValues transitionValues) {
        super.mo169c(transitionValues);
        int size = this.f11227k.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f11227k.get(i)).mo169c(transitionValues);
        }
    }

    public final void mo171d(View view) {
        super.mo171d(view);
        int size = this.f11227k.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f11227k.get(i)).mo171d(view);
        }
    }

    public final void mo173e(View view) {
        super.mo173e(view);
        int size = this.f11227k.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f11227k.get(i)).mo173e(view);
        }
    }

    public final void mo162a(EpicenterCallback epicenterCallback) {
        super.mo162a(epicenterCallback);
        int size = this.f11227k.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.f11227k.get(i)).mo162a(epicenterCallback);
        }
    }

    final String mo161a(String str) {
        String a = super.mo161a(str);
        for (int i = 0; i < this.f11227k.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("\n");
            Transition transition = (Transition) this.f11227k.get(i);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("  ");
            stringBuilder.append(transition.mo161a(stringBuilder2.toString()));
            a = stringBuilder.toString();
        }
        return a;
    }

    public final Transition mo172e() {
        TransitionSet transitionSet = (TransitionSet) super.mo172e();
        transitionSet.f11227k = new ArrayList();
        int size = this.f11227k.size();
        for (int i = 0; i < size; i++) {
            transitionSet.m9709b(((Transition) this.f11227k.get(i)).mo172e());
        }
        return transitionSet;
    }

    protected final void mo163a(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long j = this.f873a;
        int size = this.f11227k.size();
        int i = 0;
        while (i < size) {
            Transition transition = (Transition) r0.f11227k.get(i);
            if (j > 0 && (r0.f11228l || i == 0)) {
                long j2 = transition.f873a;
                if (j2 > 0) {
                    transition.mo164b(j2 + j);
                } else {
                    transition.mo164b(j);
                }
            }
            transition.mo163a(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
            i++;
        }
    }

    public final /* synthetic */ Transition mo168c(View view) {
        for (int i = 0; i < this.f11227k.size(); i++) {
            ((Transition) this.f11227k.get(i)).mo168c(view);
        }
        return (TransitionSet) super.mo168c(view);
    }

    public final /* synthetic */ Transition mo166b(View view) {
        for (int i = 0; i < this.f11227k.size(); i++) {
            ((Transition) this.f11227k.get(i)).mo166b(view);
        }
        return (TransitionSet) super.mo166b(view);
    }

    public final /* synthetic */ Transition mo158a(long j) {
        super.mo158a(j);
        if (this.b >= 0) {
            int size = this.f11227k.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.f11227k.get(i)).mo158a(j);
            }
        }
        return this;
    }
}
