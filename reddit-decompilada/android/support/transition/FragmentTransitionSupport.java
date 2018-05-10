package android.support.transition;

import android.graphics.Rect;
import android.support.transition.Transition.EpicenterCallback;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.app.FragmentTransitionImpl;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport extends FragmentTransitionImpl {
    public final boolean mo147a(Object obj) {
        return obj instanceof Transition;
    }

    public final Object mo148b(Object obj) {
        return obj != null ? ((Transition) obj).mo172e() : null;
    }

    public final Object mo153c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.m9709b((Transition) obj);
        return transitionSet;
    }

    public final void mo143a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        List list = obj.f876d;
        list.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.m618a(list, (View) arrayList.get(i));
        }
        list.add(view);
        arrayList.add(view);
        mo145a(obj, (ArrayList) arrayList);
    }

    public final void mo142a(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            final Rect rect = new Rect();
            FragmentTransitionImpl.m617a(view, rect);
            transition.mo162a(new EpicenterCallback(this) {
                final /* synthetic */ FragmentTransitionSupport f11214b;
            });
        }
    }

    public final void mo145a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            int size;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                size = transitionSet.f11227k.size();
                while (i < size) {
                    mo145a(transitionSet.m9698a(i), (ArrayList) arrayList);
                    i++;
                }
                return;
            }
            if (!m9668a(transition) && FragmentTransitionImpl.m619a(transition.f876d)) {
                size = arrayList.size();
                while (i < size) {
                    transition.mo166b((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public final Object mo139a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.m9709b((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.m9709b((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.m9709b((Transition) obj3);
        }
        return transitionSet;
    }

    public final void mo151b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).mo159a(new TransitionListener(this) {
            final /* synthetic */ FragmentTransitionSupport f11217c;

            public final void mo135a() {
            }

            public final void mo137b() {
            }

            public final void mo138c() {
            }

            public final void mo136a(Transition transition) {
                transition.mo165b((TransitionListener) this);
                view.setVisibility(8);
                transition = arrayList.size();
                for (int i = 0; i < transition; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    public final Object mo149b(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().m9709b(transition).m9709b(transition2);
            transition.f11228l = null;
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        obj2 = new TransitionSet();
        if (transition != null) {
            obj2.m9709b(transition);
        }
        obj2.m9709b(transition3);
        return obj2;
    }

    public final void mo140a(ViewGroup viewGroup, Object obj) {
        TransitionManager.m484a(viewGroup, (Transition) obj);
    }

    public final void mo144a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).mo159a(new TransitionListener(this) {
            final /* synthetic */ FragmentTransitionSupport f11224g;

            public final void mo135a() {
            }

            public final void mo136a(Transition transition) {
            }

            public final void mo137b() {
            }

            public final void mo138c() {
                if (obj5 != null) {
                    this.f11224g.mo152b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    this.f11224g.mo152b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    this.f11224g.mo152b(obj7, arrayList6, null);
                }
            }
        });
    }

    public final void mo146a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (TransitionSet) obj;
        if (obj != null) {
            obj.f876d.clear();
            obj.f876d.addAll(arrayList2);
            mo152b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    public final void mo152b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        int size;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            size = transitionSet.f11227k.size();
            while (i < size) {
                mo152b(transitionSet.m9698a(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
            return;
        }
        if (!m9668a(transition)) {
            List list = transition.f876d;
            if (list.size() == arrayList.size() && list.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i < size) {
                    transition.mo166b((View) arrayList2.get(i));
                    i++;
                }
                for (arrayList2 = arrayList.size() - 1; arrayList2 >= null; arrayList2--) {
                    transition.mo168c((View) arrayList.get(arrayList2));
                }
            }
        }
    }

    public final void mo150b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo166b(view);
        }
    }

    public final void mo154c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo168c(view);
        }
    }

    public final void mo141a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).mo162a(new EpicenterCallback(this) {
                final /* synthetic */ FragmentTransitionSupport f11226b;
            });
        }
    }

    private static boolean m9668a(Transition transition) {
        if (FragmentTransitionImpl.m619a(transition.f875c) && FragmentTransitionImpl.m619a(transition.f877e)) {
            if (FragmentTransitionImpl.m619a((List) transition.f878f) != null) {
                return null;
            }
        }
        return true;
    }
}
