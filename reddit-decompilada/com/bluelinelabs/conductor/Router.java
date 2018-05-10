package com.bluelinelabs.conductor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.Controller.LifecycleListener;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeListener;
import com.bluelinelabs.conductor.changehandler.SimpleSwapChangeHandler;
import com.bluelinelabs.conductor.internal.NoOpControllerChangeHandler;
import com.bluelinelabs.conductor.internal.ThreadUtils;
import com.bluelinelabs.conductor.internal.TransactionIndexer;
import com.bluelinelabs.conductor.internal.ViewAttachHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Router {
    private final List<ControllerChangeListener> f3136a = new ArrayList();
    private boolean f3137b = false;
    public final Backstack f3138c = new Backstack();
    final List<ChangeTransaction> f3139d = new ArrayList();
    final List<Controller> f3140e = new ArrayList();
    boolean f3141f = false;
    ViewGroup f3142g;

    class C02562 implements Runnable {
        final /* synthetic */ Router f3134a;

        C02562(Router router) {
            this.f3134a = router;
        }

        public void run() {
            this.f3134a.f3141f = true;
        }
    }

    class C02573 implements Runnable {
        final /* synthetic */ Router f3135a;

        C02573(Router router) {
            this.f3135a = router;
        }

        public void run() {
            Router router = this.f3135a;
            for (int i = 0; i < router.f3139d.size(); i++) {
                ControllerChangeHandler.m2676a((ChangeTransaction) router.f3139d.get(i));
            }
            router.f3139d.clear();
        }
    }

    class C10544 extends LifecycleListener {
        final /* synthetic */ Router f12249a;

        C10544(Router router) {
            this.f12249a = router;
        }

        public final void mo859c(Controller controller) {
            this.f12249a.f3140e.remove(controller);
        }
    }

    public abstract Activity mo833a();

    abstract void mo835a(Intent intent);

    abstract void mo837a(String str);

    abstract void mo838a(String str, Intent intent, int i);

    abstract void mo839a(String str, String[] strArr, int i);

    abstract void mo840b();

    abstract boolean mo842c();

    abstract List<Router> mo843d();

    abstract Router mo844e();

    abstract TransactionIndexer mo845f();

    public final boolean m2734i() {
        ThreadUtils.m2763a();
        if (this.f3138c.m2603a() || (!this.f3138c.m2607e().f3144a.m2667m() && !m2735j())) {
            return false;
        }
        return true;
    }

    public final boolean m2735j() {
        ThreadUtils.m2763a();
        RouterTransaction e = this.f3138c.m2607e();
        if (e != null) {
            return m2721b(e.f3144a);
        }
        throw new IllegalStateException("Trying to pop the current controller when there are none on the backstack.");
    }

    public final boolean m2721b(Controller controller) {
        ThreadUtils.m2763a();
        RouterTransaction e = this.f3138c.m2607e();
        boolean z = e != null && e.f3144a == controller;
        if (z) {
            m2699e(this.f3138c.m2606d());
            m2694a(this.f3138c.m2607e(), e, false);
        } else {
            Iterator it = this.f3138c.iterator();
            RouterTransaction routerTransaction = null;
            RouterTransaction routerTransaction2 = null;
            while (it.hasNext()) {
                RouterTransaction routerTransaction3 = (RouterTransaction) it.next();
                if (routerTransaction3.f3144a == controller) {
                    if (controller.f3094e) {
                        m2699e(routerTransaction3);
                    }
                    this.f3138c.f3082a.removeFirstOccurrence(routerTransaction3);
                    routerTransaction2 = routerTransaction3;
                } else if (routerTransaction2 != null) {
                    if (routerTransaction3.f3144a.f3094e == null) {
                        routerTransaction = routerTransaction3;
                    }
                    if (routerTransaction2 != null) {
                        m2694a(routerTransaction, routerTransaction2, false);
                    }
                }
            }
            if (routerTransaction2 != null) {
                m2694a(routerTransaction, routerTransaction2, false);
            }
        }
        return this.f3137b != null ? e != null : this.f3138c.m2603a() == null;
    }

    public final void m2719b(RouterTransaction routerTransaction) {
        ThreadUtils.m2763a();
        RouterTransaction e = this.f3138c.m2607e();
        mo855a(routerTransaction);
        m2694a(routerTransaction, e, true);
    }

    public final void m2725c(RouterTransaction routerTransaction) {
        ThreadUtils.m2763a();
        RouterTransaction e = this.f3138c.m2607e();
        if (!this.f3138c.m2603a()) {
            m2699e(this.f3138c.m2606d());
        }
        ControllerChangeHandler b = routerTransaction.m2749b();
        if (e != null) {
            boolean z;
            boolean z2 = false;
            if (e.m2749b() != null) {
                if (!e.m2749b().mo865e()) {
                    z = false;
                    if (b == null || b.mo865e()) {
                        z2 = true;
                    }
                    if (!z && r4) {
                        for (RouterTransaction a : m2690a(this.f3138c.iterator())) {
                            m2695a(null, a, true, b);
                        }
                    }
                }
            }
            z = true;
            z2 = true;
            while (r3.hasNext()) {
                m2695a(null, a, true, b);
            }
        }
        mo855a(routerTransaction);
        if (b != null) {
            b.f3125a = true;
        }
        m2694a(routerTransaction.m2746a(b), e, true);
    }

    public void mo857b(boolean z) {
        this.f3137b = true;
        Backstack backstack = this.f3138c;
        final List arrayList = new ArrayList();
        while (!backstack.m2603a()) {
            arrayList.add(backstack.m2606d());
        }
        m2696a(arrayList);
        if (z && arrayList.size() <= false) {
            RouterTransaction routerTransaction = (RouterTransaction) arrayList.get(0);
            routerTransaction.f3144a.m2644a(new LifecycleListener(this) {
                final /* synthetic */ Router f12248b;

                public final void mo858a(ControllerChangeType controllerChangeType) {
                    if (controllerChangeType == ControllerChangeType.POP_EXIT) {
                        for (controllerChangeType = arrayList.size() - 1; controllerChangeType > null; controllerChangeType--) {
                            this.f12248b.m2695a(null, (RouterTransaction) arrayList.get(controllerChangeType), true, new SimpleSwapChangeHandler());
                        }
                    }
                }
            });
            m2695a(null, routerTransaction, false, routerTransaction.m2751c());
        }
    }

    public final int m2736k() {
        return this.f3142g != null ? this.f3142g.getId() : 0;
    }

    public final boolean m2737l() {
        ThreadUtils.m2763a();
        return m2714a(null);
    }

    public final boolean m2714a(ControllerChangeHandler controllerChangeHandler) {
        ThreadUtils.m2763a();
        if (this.f3138c.m2604b() <= 1) {
            return null;
        }
        Backstack backstack = this.f3138c;
        m2693a(backstack.f3082a.size() > 0 ? (RouterTransaction) backstack.f3082a.getLast() : null, controllerChangeHandler);
        return true;
    }

    public final boolean m2722b(String str) {
        ThreadUtils.m2763a();
        ThreadUtils.m2763a();
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            if (str.equals(routerTransaction.f3145b)) {
                m2693a(routerTransaction, (ControllerChangeHandler) null);
                return true;
            }
        }
        return null;
    }

    public final void m2729d(RouterTransaction routerTransaction) {
        ThreadUtils.m2763a();
        mo856a(Collections.singletonList(routerTransaction), routerTransaction.m2749b());
    }

    public final Controller m2723c(String str) {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            Controller controller = ((RouterTransaction) it.next()).f3144a;
            if (controller.f3101l.equals(str)) {
                continue;
            } else {
                for (Router c : controller.f3108s) {
                    Controller c2 = c.m2723c(str);
                    if (c2 != null) {
                        controller = c2;
                        continue;
                        break;
                    }
                }
                controller = null;
                continue;
            }
            if (controller != null) {
                return controller;
            }
        }
        return null;
    }

    public final List<RouterTransaction> m2738m() {
        List<RouterTransaction> arrayList = new ArrayList();
        Iterator c = this.f3138c.m2605c();
        while (c.hasNext()) {
            arrayList.add(c.next());
        }
        return arrayList;
    }

    public void mo856a(List<RouterTransaction> list, ControllerChangeHandler controllerChangeHandler) {
        boolean z;
        List arrayList;
        int childCount;
        int i;
        View childAt;
        Iterator it;
        RouterTransaction routerTransaction;
        RouterTransaction routerTransaction2;
        int size;
        ControllerChangeHandler b;
        RouterTransaction routerTransaction3;
        ThreadUtils.m2763a();
        List a = m2690a(this.f3138c.iterator());
        if (list.size() > 0) {
            if (this.f3138c.f3082a.contains((RouterTransaction) list.get(0))) {
                z = false;
                arrayList = new ArrayList();
                for (RouterTransaction routerTransaction4 : m2690a(this.f3138c.iterator())) {
                    if (routerTransaction4.f3144a.f3099j != null) {
                        arrayList.add(routerTransaction4.f3144a.f3099j);
                    }
                }
                for (Router router : mo843d()) {
                    if (router.f3142g == this.f3142g) {
                        m2692a(router, arrayList);
                    }
                }
                childCount = this.f3142g.getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = this.f3142g.getChildAt(i);
                    if (!arrayList.contains(childAt)) {
                        this.f3142g.removeView(childAt);
                    }
                }
                m2698b((List) list);
                this.f3138c.m2602a((List) list);
                it = this.f3138c.iterator();
                while (it.hasNext()) {
                    ((RouterTransaction) it.next()).f3148e = true;
                }
                if (list.size() > 0) {
                    arrayList = new ArrayList(list);
                    Collections.reverse(arrayList);
                    arrayList = m2690a(arrayList.iterator());
                    if ((m2697a(arrayList, a) ^ 1) != 0) {
                        routerTransaction = a.size() <= 0 ? (RouterTransaction) a.get(0) : null;
                        routerTransaction2 = (RouterTransaction) arrayList.get(0);
                        if (routerTransaction == null || routerTransaction.f3144a != routerTransaction2.f3144a) {
                            if (routerTransaction != null) {
                                ControllerChangeHandler.m2678a(routerTransaction.f3144a.f3101l);
                            }
                            m2695a(routerTransaction2, routerTransaction, z, controllerChangeHandler);
                        }
                        for (size = a.size() - 1; size > 0; size--) {
                            routerTransaction = (RouterTransaction) a.get(size);
                            if (arrayList.contains(routerTransaction)) {
                                if (controllerChangeHandler == null) {
                                    b = controllerChangeHandler.mo866b();
                                } else {
                                    b = new SimpleSwapChangeHandler();
                                }
                                b.f3125a = true;
                                ControllerChangeHandler.m2678a(routerTransaction.f3144a.f3101l);
                                m2695a(null, routerTransaction, z, b);
                            }
                        }
                        for (controllerChangeHandler = 1; controllerChangeHandler < arrayList.size(); controllerChangeHandler++) {
                            routerTransaction3 = (RouterTransaction) arrayList.get(controllerChangeHandler);
                            if (!a.contains(routerTransaction3)) {
                                m2695a(routerTransaction3, (RouterTransaction) arrayList.get(controllerChangeHandler - 1), true, routerTransaction3.m2749b());
                            }
                        }
                    }
                    for (RouterTransaction routerTransaction5 : list) {
                        routerTransaction5.f3144a.m2647a(this);
                    }
                }
            }
        }
        z = true;
        arrayList = new ArrayList();
        for (RouterTransaction routerTransaction42 : m2690a(this.f3138c.iterator())) {
            if (routerTransaction42.f3144a.f3099j != null) {
                arrayList.add(routerTransaction42.f3144a.f3099j);
            }
        }
        for (Router router2 : mo843d()) {
            if (router2.f3142g == this.f3142g) {
                m2692a(router2, arrayList);
            }
        }
        childCount = this.f3142g.getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = this.f3142g.getChildAt(i);
            if (!arrayList.contains(childAt)) {
                this.f3142g.removeView(childAt);
            }
        }
        m2698b((List) list);
        this.f3138c.m2602a((List) list);
        it = this.f3138c.iterator();
        while (it.hasNext()) {
            ((RouterTransaction) it.next()).f3148e = true;
        }
        if (list.size() > 0) {
            arrayList = new ArrayList(list);
            Collections.reverse(arrayList);
            arrayList = m2690a(arrayList.iterator());
            if ((m2697a(arrayList, a) ^ 1) != 0) {
                if (a.size() <= 0) {
                }
                routerTransaction2 = (RouterTransaction) arrayList.get(0);
                if (routerTransaction != null) {
                    ControllerChangeHandler.m2678a(routerTransaction.f3144a.f3101l);
                }
                m2695a(routerTransaction2, routerTransaction, z, controllerChangeHandler);
                for (size = a.size() - 1; size > 0; size--) {
                    routerTransaction = (RouterTransaction) a.get(size);
                    if (arrayList.contains(routerTransaction)) {
                        if (controllerChangeHandler == null) {
                            b = new SimpleSwapChangeHandler();
                        } else {
                            b = controllerChangeHandler.mo866b();
                        }
                        b.f3125a = true;
                        ControllerChangeHandler.m2678a(routerTransaction.f3144a.f3101l);
                        m2695a(null, routerTransaction, z, b);
                    }
                }
                for (controllerChangeHandler = 1; controllerChangeHandler < arrayList.size(); controllerChangeHandler++) {
                    routerTransaction3 = (RouterTransaction) arrayList.get(controllerChangeHandler);
                    if (!a.contains(routerTransaction3)) {
                        m2695a(routerTransaction3, (RouterTransaction) arrayList.get(controllerChangeHandler - 1), true, routerTransaction3.m2749b());
                    }
                }
            }
            while (list.hasNext() != null) {
                routerTransaction5.f3144a.m2647a(this);
            }
        }
    }

    public final void m2707a(ControllerChangeListener controllerChangeListener) {
        if (!this.f3136a.contains(controllerChangeListener)) {
            this.f3136a.add(controllerChangeListener);
        }
    }

    public final void m2718b(ControllerChangeListener controllerChangeListener) {
        this.f3136a.remove(controllerChangeListener);
    }

    public final void m2740o() {
        ThreadUtils.m2763a();
        Iterator c = this.f3138c.m2605c();
        while (c.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) c.next();
            if (routerTransaction.f3144a.f3102m) {
                m2695a(routerTransaction, null, true, new SimpleSwapChangeHandler(false));
            }
        }
    }

    public final void m2716b(Activity activity) {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            Controller controller = routerTransaction.f3144a;
            if (controller.f3107r != null) {
                ViewAttachHandler viewAttachHandler = controller.f3107r;
                viewAttachHandler.f3184a = false;
                viewAttachHandler.m2772a();
            }
            controller.m2636a(activity);
            for (Router b : routerTransaction.f3144a.m2664j()) {
                b.m2716b(activity);
            }
        }
    }

    public final void m2724c(Activity activity) {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            Controller controller = routerTransaction.f3144a;
            if (!controller.f3094e && controller.f3099j != null && controller.f3097h) {
                controller.m2661d(controller.f3099j);
            } else if (controller.f3094e) {
                controller.f3102m = false;
                controller.f3103n = false;
            }
            controller.m2650b(activity);
            for (Router c : routerTransaction.f3144a.m2664j()) {
                c.m2724c(activity);
            }
        }
    }

    public final void m2728d(Activity activity) {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            routerTransaction.f3144a.m2656c(activity);
            for (Router d : routerTransaction.f3144a.m2664j()) {
                d.m2728d(activity);
            }
        }
    }

    public final void m2731e(Activity activity) {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            Controller controller = routerTransaction.f3144a;
            if (controller.f3107r != null) {
                ViewAttachHandler viewAttachHandler = controller.f3107r;
                viewAttachHandler.f3184a = true;
                viewAttachHandler.m2773a(true);
            }
            controller.m2660d(activity);
            for (Router e : routerTransaction.f3144a.m2664j()) {
                e.m2731e(activity);
            }
        }
    }

    public void mo834a(Activity activity) {
        m2743r();
        this.f3136a.clear();
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            routerTransaction.f3144a.m2662e(activity);
            for (Router a : routerTransaction.f3144a.m2664j()) {
                a.mo834a(activity);
            }
        }
        for (int size = this.f3140e.size() - 1; size >= 0; size--) {
            Controller controller = (Controller) this.f3140e.get(size);
            controller.m2662e(activity);
            for (Router a2 : controller.m2664j()) {
                a2.mo834a(activity);
            }
        }
        this.f3142g = null;
    }

    final void m2741p() {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            boolean z = true;
            if (ControllerChangeHandler.m2678a(routerTransaction.f3144a.f3101l)) {
                routerTransaction.f3144a.f3102m = true;
            }
            Controller controller = routerTransaction.f3144a;
            if (!controller.f3102m) {
                if (!controller.f3094e) {
                    z = false;
                }
            }
            controller.f3102m = z;
            for (ControllerHostedRouter p : controller.f3108s) {
                p.m2741p();
            }
        }
    }

    public void mo836a(Bundle bundle) {
        m2741p();
        Bundle bundle2 = new Bundle();
        this.f3138c.m2601a(bundle2);
        bundle.putParcelable("Router.backstack", bundle2);
        bundle.putBoolean("Router.popsLastView", this.f3137b);
    }

    public void mo841b(Bundle bundle) {
        Bundle bundle2 = (Bundle) bundle.getParcelable("Router.backstack");
        Backstack backstack = this.f3138c;
        Object parcelableArrayList = bundle2.getParcelableArrayList("Backstack.entries");
        if (parcelableArrayList != null) {
            Collections.reverse(parcelableArrayList);
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                backstack.f3082a.push(new RouterTransaction((Bundle) it.next()));
            }
        }
        this.f3137b = bundle.getBoolean("Router.popsLastView");
        bundle = this.f3138c.m2605c();
        while (bundle.hasNext()) {
            mo854a(((RouterTransaction) bundle.next()).f3144a);
        }
    }

    public final void m2705a(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            Controller controller = routerTransaction.f3144a;
            if (controller.f3094e && controller.f3095f && !controller.f3096g) {
                controller.m2640a(menu, menuInflater);
            }
            for (Router a : routerTransaction.f3144a.m2664j()) {
                a.m2705a(menu, menuInflater);
            }
        }
    }

    public final void m2704a(Menu menu) {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            Controller controller = routerTransaction.f3144a;
            if (controller.f3094e && controller.f3095f && !controller.f3096g) {
                controller.m2639a(menu);
            }
            for (Router a : routerTransaction.f3144a.m2664j()) {
                a.m2704a(menu);
            }
        }
    }

    public final boolean m2713a(MenuItem menuItem) {
        Iterator it = this.f3138c.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                return false;
            }
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            Controller controller = routerTransaction.f3144a;
            if (controller.f3094e && controller.f3095f && !controller.f3096g && controller.m2649a(menuItem)) {
                z = true;
            }
            if (z) {
                return true;
            }
            for (Router a : routerTransaction.f3144a.m2664j()) {
                if (a.m2713a(menuItem)) {
                    return true;
                }
            }
        }
    }

    private void m2693a(RouterTransaction routerTransaction, ControllerChangeHandler controllerChangeHandler) {
        if (this.f3138c.m2604b() > 0) {
            RouterTransaction e = this.f3138c.m2607e();
            List arrayList = new ArrayList();
            Iterator c = this.f3138c.m2605c();
            while (c.hasNext()) {
                RouterTransaction routerTransaction2 = (RouterTransaction) c.next();
                arrayList.add(routerTransaction2);
                if (routerTransaction2 == routerTransaction) {
                    break;
                }
            }
            if (controllerChangeHandler == null) {
                controllerChangeHandler = e.m2751c();
            }
            mo856a(arrayList, controllerChangeHandler);
        }
    }

    final void m2742q() {
        this.f3142g.post(new C02562(this));
    }

    final void m2743r() {
        this.f3141f = false;
        if (this.f3142g != null) {
            this.f3142g.setOnHierarchyChangeListener(null);
        }
    }

    void mo846g() {
        Iterator it = this.f3138c.iterator();
        while (it.hasNext()) {
            ((RouterTransaction) it.next()).f3144a.m2669o();
        }
    }

    private void m2695a(RouterTransaction routerTransaction, RouterTransaction routerTransaction2, boolean z, ControllerChangeHandler controllerChangeHandler) {
        ChangeTransaction changeTransaction;
        Controller controller = null;
        Controller controller2 = routerTransaction != null ? routerTransaction.f3144a : null;
        if (routerTransaction2 != null) {
            controller = routerTransaction2.f3144a;
        }
        if (routerTransaction != null) {
            routerTransaction.m2748a(mo845f());
            mo854a(controller2);
        } else if (this.f3138c.m2604b() == null && this.f3137b == null) {
            controllerChangeHandler = new NoOpControllerChangeHandler();
            routerTransaction = 1;
            if (z || controller2 == null || !controller2.f3093d) {
                changeTransaction = new ChangeTransaction(controller2, controller, z, this.f3142g, controllerChangeHandler, this.f3136a);
                if (this.f3139d.size() > false) {
                    this.f3139d.add(changeTransaction);
                } else if (controller != null || (!(controllerChangeHandler == null || controllerChangeHandler.mo865e()) || this.f3141f)) {
                    ControllerChangeHandler.m2676a(changeTransaction);
                } else {
                    this.f3139d.add(changeTransaction);
                    this.f3142g.post(new C02573(this));
                }
                if (routerTransaction != null && controller != null && controller.f3099j != null) {
                    controller.m2643a(controller.f3099j, true, false);
                    return;
                }
                return;
            }
            routerTransaction2 = new StringBuilder("Trying to push a controller that has already been destroyed. (");
            routerTransaction2.append(controller2.getClass().getSimpleName());
            routerTransaction2.append(")");
            throw new IllegalStateException(routerTransaction2.toString());
        }
        routerTransaction = null;
        if (z) {
        }
        changeTransaction = new ChangeTransaction(controller2, controller, z, this.f3142g, controllerChangeHandler, this.f3136a);
        if (this.f3139d.size() > false) {
            if (controller != null) {
            }
            ControllerChangeHandler.m2676a(changeTransaction);
        } else {
            this.f3139d.add(changeTransaction);
        }
        if (routerTransaction != null) {
        }
    }

    protected void mo855a(RouterTransaction routerTransaction) {
        this.f3138c.f3082a.push(routerTransaction);
    }

    private void m2699e(RouterTransaction routerTransaction) {
        if (!routerTransaction.f3144a.f3093d) {
            this.f3140e.add(routerTransaction.f3144a);
            routerTransaction.f3144a.m2644a(new C10544(this));
        }
    }

    private void m2696a(List<RouterTransaction> list) {
        for (RouterTransaction e : list) {
            m2699e(e);
        }
    }

    private void m2698b(List<RouterTransaction> list) {
        List arrayList = new ArrayList();
        for (RouterTransaction routerTransaction : list) {
            routerTransaction.m2748a(mo845f());
            arrayList.add(Integer.valueOf(routerTransaction.f3149f));
        }
        Collections.sort(arrayList);
        for (int i = 0; i < list.size(); i++) {
            ((RouterTransaction) list.get(i)).f3149f = ((Integer) arrayList.get(i)).intValue();
        }
    }

    private static List<RouterTransaction> m2690a(Iterator<RouterTransaction> it) {
        List<RouterTransaction> arrayList = new ArrayList();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            arrayList.add(routerTransaction);
            if (routerTransaction.m2749b() != null) {
                if (routerTransaction.m2749b().mo865e()) {
                    break;
                }
            }
            break;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    private static boolean m2697a(List<RouterTransaction> list, List<RouterTransaction> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list2.size(); i++) {
            if (((RouterTransaction) list2.get(i)).f3144a != ((RouterTransaction) list.get(i)).f3144a) {
                return false;
            }
        }
        return true;
    }

    void mo854a(Controller controller) {
        controller.m2647a(this);
        controller.m2669o();
    }

    public final boolean m2739n() {
        return this.f3138c.m2604b() > 0;
    }

    private void m2694a(RouterTransaction routerTransaction, RouterTransaction routerTransaction2, boolean z) {
        if (z && routerTransaction != null) {
            routerTransaction.f3148e = true;
        }
        ControllerChangeHandler b = z ? routerTransaction.m2749b() : routerTransaction2 != null ? routerTransaction2.m2751c() : null;
        m2695a(routerTransaction, routerTransaction2, z, b);
    }

    private void m2692a(Router router, List<View> list) {
        List<Controller> arrayList = new ArrayList();
        router = router.f3138c.m2605c();
        while (router.hasNext()) {
            arrayList.add(((RouterTransaction) router.next()).f3144a);
        }
        for (Controller controller : arrayList) {
            if (controller.f3099j != null) {
                list.add(controller.f3099j);
            }
            for (Router a : controller.m2664j()) {
                m2692a(a, (List) list);
            }
        }
    }
}
