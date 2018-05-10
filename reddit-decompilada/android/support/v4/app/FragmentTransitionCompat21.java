package android.support.v4.app;

import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class FragmentTransitionCompat21 extends FragmentTransitionImpl {
    FragmentTransitionCompat21() {
    }

    public final boolean mo147a(Object obj) {
        return obj instanceof Transition;
    }

    public final Object mo148b(Object obj) {
        return obj != null ? ((Transition) obj).clone() : null;
    }

    public final Object mo153c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public final void mo143a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.m618a(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo145a(obj, (ArrayList) arrayList);
    }

    public final void mo142a(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            final Rect rect = new Rect();
            FragmentTransitionImpl.m617a(view, rect);
            transition.setEpicenterCallback(new EpicenterCallback(this) {
                final /* synthetic */ FragmentTransitionCompat21 f1054b;

                public Rect onGetEpicenter(Transition transition) {
                    return rect;
                }
            });
        }
    }

    public final void mo145a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            int transitionCount;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    mo145a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                    i++;
                }
                return;
            }
            if (!m9942a(transition) && FragmentTransitionImpl.m619a(transition.getTargets())) {
                transitionCount = arrayList.size();
                while (i < transitionCount) {
                    transition.addTarget((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    private static boolean m9942a(Transition transition) {
        if (FragmentTransitionImpl.m619a(transition.getTargetIds()) && FragmentTransitionImpl.m619a(transition.getTargetNames())) {
            if (FragmentTransitionImpl.m619a((List) transition.getTargetTypes()) != null) {
                return null;
            }
        }
        return true;
    }

    public final Object mo139a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public final void mo151b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new TransitionListener(this) {
            final /* synthetic */ FragmentTransitionCompat21 f1057c;

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                transition = arrayList.size();
                for (int i = 0; i < transition; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    public final Object mo149b(Object obj, Object obj2, Object obj3) {
        obj = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (obj != null && transition != null) {
            obj = new TransitionSet().addTransition(obj).addTransition(transition).setOrdering(1);
        } else if (obj == null) {
            obj = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return obj;
        }
        obj2 = new TransitionSet();
        if (obj != null) {
            obj2.addTransition(obj);
        }
        obj2.addTransition(transition2);
        return obj2;
    }

    public final void mo140a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public final void mo144a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).addListener(new TransitionListener(this) {
            final /* synthetic */ FragmentTransitionCompat21 f1064g;

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
                if (obj5 != null) {
                    this.f1064g.mo152b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    this.f1064g.mo152b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    this.f1064g.mo152b(obj7, arrayList6, null);
                }
            }
        });
    }

    public final void mo146a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (TransitionSet) obj;
        if (obj != null) {
            obj.getTargets().clear();
            obj.getTargets().addAll(arrayList2);
            mo152b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    public final void mo152b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo152b(transitionSet.getTransitionAt(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
            return;
        }
        if (!m9942a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    transitionCount = 0;
                } else {
                    transitionCount = arrayList2.size();
                }
                while (i < transitionCount) {
                    transition.addTarget((View) arrayList2.get(i));
                    i++;
                }
                for (arrayList2 = arrayList.size() - 1; arrayList2 >= null; arrayList2--) {
                    transition.removeTarget((View) arrayList.get(arrayList2));
                }
            }
        }
    }

    public final void mo150b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public final void mo154c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public final void mo141a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new EpicenterCallback(this) {
                final /* synthetic */ FragmentTransitionCompat21 f1066b;

                public Rect onGetEpicenter(Transition transition) {
                    if (rect != null) {
                        if (rect.isEmpty() == null) {
                            return rect;
                        }
                    }
                    return null;
                }
            });
        }
    }
}
