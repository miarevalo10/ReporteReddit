package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class FragmentTransitionImpl {

    class C00992 implements Runnable {
        final /* synthetic */ ArrayList f1073a;
        final /* synthetic */ Map f1074b;
        final /* synthetic */ FragmentTransitionImpl f1075c;

        C00992(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
            this.f1075c = fragmentTransitionImpl;
            this.f1073a = arrayList;
            this.f1074b = map;
        }

        public void run() {
            int size = this.f1073a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f1073a.get(i);
                String w = ViewCompat.m1262w(view);
                if (w != null) {
                    ViewCompat.m1226a(view, FragmentTransitionImpl.m615a(this.f1074b, w));
                }
            }
        }
    }

    class C01003 implements Runnable {
        final /* synthetic */ ArrayList f1076a;
        final /* synthetic */ Map f1077b;
        final /* synthetic */ FragmentTransitionImpl f1078c;

        C01003(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
            this.f1078c = fragmentTransitionImpl;
            this.f1076a = arrayList;
            this.f1077b = map;
        }

        public void run() {
            int size = this.f1076a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f1076a.get(i);
                ViewCompat.m1226a(view, (String) this.f1077b.get(ViewCompat.m1262w(view)));
            }
        }
    }

    public abstract Object mo139a(Object obj, Object obj2, Object obj3);

    public abstract void mo140a(ViewGroup viewGroup, Object obj);

    public abstract void mo141a(Object obj, Rect rect);

    public abstract void mo142a(Object obj, View view);

    public abstract void mo143a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void mo144a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void mo145a(Object obj, ArrayList<View> arrayList);

    public abstract void mo146a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract boolean mo147a(Object obj);

    public abstract Object mo148b(Object obj);

    public abstract Object mo149b(Object obj, Object obj2, Object obj3);

    public abstract void mo150b(Object obj, View view);

    public abstract void mo151b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void mo152b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object mo153c(Object obj);

    public abstract void mo154c(Object obj, View view);

    protected static void m617a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    static ArrayList<String> m616a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(ViewCompat.m1262w(view));
            ViewCompat.m1226a(view, null);
        }
        return arrayList2;
    }

    final void m622a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String w = ViewCompat.m1262w(view2);
            arrayList4.add(w);
            if (w != null) {
                ViewCompat.m1226a(view2, null);
                String str = (String) map.get(w);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        ViewCompat.m1226a((View) arrayList2.get(i2), w);
                        break;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        OneShotPreDrawListener.m700a(view, new Runnable(this) {
            final /* synthetic */ FragmentTransitionImpl f1072f;

            public void run() {
                for (int i = 0; i < size; i++) {
                    ViewCompat.m1226a((View) arrayList5.get(i), (String) arrayList6.get(i));
                    ViewCompat.m1226a((View) arrayList7.get(i), (String) arrayList4.get(i));
                }
            }
        });
    }

    final void m630a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (ViewGroupCompat.m1271b(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m630a((ArrayList) arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    final void m631a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String w = ViewCompat.m1262w(view);
            if (w != null) {
                map.put(w, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m631a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    protected static void m618a(List<View> list, View view) {
        int size = list.size();
        if (!m620a((List) list, view, size)) {
            list.add(view);
            for (view = size; view < list.size(); view++) {
                View view2 = (View) list.get(view);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (!m620a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean m620a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    protected static boolean m619a(List list) {
        if (list != null) {
            if (list.isEmpty() == null) {
                return null;
            }
        }
        return true;
    }

    static String m615a(Map<String, String> map, String str) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }
}
