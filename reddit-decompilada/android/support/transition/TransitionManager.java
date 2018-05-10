package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
    private static Transition f899a = new AutoTransition();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f900b = new ThreadLocal();
    private static ArrayList<ViewGroup> f901c = new ArrayList();

    private static class MultiListener implements OnAttachStateChangeListener, OnPreDrawListener {
        Transition f897a;
        ViewGroup f898b;

        public void onViewAttachedToWindow(View view) {
        }

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f897a = transition;
            this.f898b = viewGroup;
        }

        private void m482a() {
            this.f898b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f898b.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            m482a();
            TransitionManager.f901c.remove(this.f898b);
            ArrayList arrayList = (ArrayList) TransitionManager.m483a().get(this.f898b);
            if (arrayList != null && arrayList.size() > 0) {
                view = arrayList.iterator();
                while (view.hasNext()) {
                    ((Transition) view.next()).mo173e(this.f898b);
                }
            }
            this.f897a.m464a(true);
        }

        public boolean onPreDraw() {
            m482a();
            if (!TransitionManager.f901c.remove(this.f898b)) {
                return true;
            }
            final ArrayMap a = TransitionManager.m483a();
            ArrayList arrayList = (ArrayList) a.get(this.f898b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a.put(this.f898b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f897a);
            this.f897a.mo159a(new TransitionListenerAdapter(this) {
                final /* synthetic */ MultiListener f16480b;

                public final void mo136a(Transition transition) {
                    ((ArrayList) a.get(this.f16480b.f898b)).remove(transition);
                }
            });
            this.f897a.m463a(this.f898b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo173e(this.f898b);
                }
            }
            this.f897a.m461a(this.f898b);
            return true;
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> m483a() {
        WeakReference weakReference = (WeakReference) f900b.get();
        if (weakReference == null || weakReference.get() == null) {
            WeakReference weakReference2 = new WeakReference(new ArrayMap());
            f900b.set(weakReference2);
            weakReference = weakReference2;
        }
        return (ArrayMap) weakReference.get();
    }

    public static void m484a(ViewGroup viewGroup, Transition transition) {
        if (!f901c.contains(viewGroup) && ViewCompat.m1206G(viewGroup)) {
            f901c.add(viewGroup);
            if (transition == null) {
                transition = f899a;
            }
            transition = transition.mo172e();
            ArrayList arrayList = (ArrayList) m483a().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo171d(viewGroup);
                }
            }
            if (transition != null) {
                transition.m463a(viewGroup, true);
            }
            Scene b = Scene.m441b(viewGroup);
            if (!(b == null || Scene.m441b(b.f851a) != b || b.f852b == null)) {
                b.f852b.run();
            }
            Scene.m440a(viewGroup);
            if (transition != null && viewGroup != null) {
                Object multiListener = new MultiListener(transition, viewGroup);
                viewGroup.addOnAttachStateChangeListener(multiListener);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
            }
        }
    }
}
