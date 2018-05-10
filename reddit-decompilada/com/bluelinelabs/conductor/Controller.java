package com.bluelinelabs.conductor;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.internal.ClassUtils;
import com.bluelinelabs.conductor.internal.RouterRequiringFunc;
import com.bluelinelabs.conductor.internal.ViewAttachHandler;
import com.bluelinelabs.conductor.internal.ViewAttachHandler.ViewAttachListener;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class Controller {
    private final ArrayList<RouterRequiringFunc> f3087A;
    private WeakReference<View> f3088B;
    private boolean f3089C;
    private boolean f3090D;
    public final Bundle f3091a;
    Bundle b_;
    public boolean f3092c;
    boolean f3093d;
    public boolean f3094e;
    boolean f3095f;
    boolean f3096g;
    boolean f3097h;
    public Router f3098i;
    public View f3099j;
    public Controller f3100k;
    public String f3101l;
    boolean f3102m;
    boolean f3103n;
    ControllerChangeHandler f3104o;
    ControllerChangeHandler f3105p;
    RetainViewMode f3106q;
    ViewAttachHandler f3107r;
    public final List<ControllerHostedRouter> f3108s;
    final List<LifecycleListener> f3109t;
    public final ArrayList<String> f3110u;
    private Bundle f3111v;
    private boolean f3112w;
    private String f3113x;
    private boolean f3114y;
    private boolean f3115z;

    class C02556 implements Comparator<RouterTransaction> {
        final /* synthetic */ Controller f3083a;

        C02556(Controller controller) {
            this.f3083a = controller;
        }

        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((RouterTransaction) obj2).f3149f - ((RouterTransaction) obj).f3149f;
        }
    }

    public static abstract class LifecycleListener {
        public void m2609a(Controller controller) {
        }

        public void m2610a(Controller controller, Bundle bundle) {
        }

        public void m2611a(Controller controller, View view) {
        }

        public void m2612a(Controller controller, ControllerChangeType controllerChangeType) {
        }

        public void mo858a(ControllerChangeType controllerChangeType) {
        }

        public void m2614b(Controller controller) {
        }

        public void m2615b(Controller controller, View view) {
        }

        public void mo859c(Controller controller) {
        }
    }

    public enum RetainViewMode {
        RELEASE_DETACH,
        RETAIN_DETACH
    }

    class C10517 implements ViewAttachListener {
        final /* synthetic */ Controller f12231a;

        C10517(Controller controller) {
            this.f12231a = controller;
        }

        public final void mo850a() {
            this.f12231a.f3097h = true;
            this.f12231a.f3112w = false;
            this.f12231a.m2661d(this.f12231a.f3099j);
        }

        public final void mo851a(boolean z) {
            this.f12231a.f3097h = false;
            this.f12231a.f3112w = true;
            if (!this.f12231a.f3115z) {
                this.f12231a.m2643a(this.f12231a.f3099j, false, z);
            }
        }

        public final void mo852b() {
            if (!this.f12231a.f3115z) {
                this.f12231a.m2643a(this.f12231a.f3099j, false, false);
            }
        }
    }

    public abstract View m2632a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void m2634a(int i, int i2, Intent intent) {
    }

    public void m2635a(int i, String[] strArr, int[] iArr) {
    }

    public void m2636a(Activity activity) {
    }

    public void m2639a(Menu menu) {
    }

    public void m2640a(Menu menu, MenuInflater menuInflater) {
    }

    public void m2641a(View view) {
    }

    public void m2642a(View view, Bundle bundle) {
    }

    public boolean m2649a(MenuItem menuItem) {
        return false;
    }

    public void m2650b(Activity activity) {
    }

    public void m2651b(Bundle bundle) {
    }

    public void m2652b(View view) {
    }

    public void m2653b(View view, Bundle bundle) {
    }

    public void m2656c(Activity activity) {
    }

    public void m2657c(Bundle bundle) {
    }

    public void m2658c(View view) {
    }

    public void m2660d(Activity activity) {
    }

    public void m2666l() {
    }

    static Controller m2617a(Bundle bundle) {
        Controller controller;
        String string = bundle.getString("Controller.className");
        Class a = ClassUtils.m2753a(string, false);
        Constructor[] constructors = a.getConstructors();
        Constructor b = m2623b(constructors);
        Bundle bundle2 = bundle.getBundle("Controller.args");
        if (bundle2 != null) {
            bundle2.setClassLoader(a.getClassLoader());
        }
        if (b != null) {
            try {
                controller = (Controller) b.newInstance(new Object[]{bundle2});
            } catch (Bundle bundle3) {
                StringBuilder stringBuilder = new StringBuilder("An exception occurred while creating a new instance of ");
                stringBuilder.append(string);
                stringBuilder.append(". ");
                stringBuilder.append(bundle3.getMessage());
                throw new RuntimeException(stringBuilder.toString(), bundle3);
            }
        }
        controller = (Controller) m2618a(constructors).newInstance(new Object[0]);
        if (bundle2 != null) {
            controller.f3091a.putAll(bundle2);
        }
        controller.m2627d(bundle3);
        return controller;
    }

    protected Controller() {
        this(null);
    }

    protected Controller(Bundle bundle) {
        this.f3106q = RetainViewMode.RELEASE_DETACH;
        this.f3108s = new ArrayList();
        this.f3109t = new ArrayList();
        this.f3110u = new ArrayList();
        this.f3087A = new ArrayList();
        if (bundle == null) {
            bundle = new Bundle(getClass().getClassLoader());
        }
        this.f3091a = bundle;
        this.f3101l = UUID.randomUUID().toString();
        Constructor[] constructors = getClass().getConstructors();
        if (m2623b(constructors) == null && m2618a(constructors) == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass());
            stringBuilder.append(" does not have a constructor that takes a Bundle argument or a default constructor. Controllers must have one of these in order to restore their states.");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public final Router C_() {
        return this.f3098i;
    }

    public final Bundle t_() {
        return this.f3091a;
    }

    public final boolean u_() {
        return this.f3093d;
    }

    public final boolean v_() {
        return this.f3094e;
    }

    public final View T_() {
        return this.f3099j;
    }

    public final Activity am_() {
        return this.f3098i != null ? this.f3098i.mo833a() : null;
    }

    public final Resources ao_() {
        Activity am_ = am_();
        return am_ != null ? am_.getResources() : null;
    }

    public final Context aq_() {
        Activity am_ = am_();
        return am_ != null ? am_.getApplicationContext() : null;
    }

    public final String Y_() {
        return this.f3101l;
    }

    public final List<Router> m2664j() {
        List<Router> arrayList = new ArrayList();
        for (Router add : this.f3108s) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public void m2645a(Controller controller) {
        if (this.f3113x != null) {
            throw new RuntimeException("Target controller already set. A controller's target may only be set once.");
        }
        if (controller != null) {
            controller = controller.f3101l;
        } else {
            controller = null;
        }
        this.f3113x = controller;
    }

    public final Controller m2665k() {
        return this.f3113x != null ? this.f3098i.mo844e().m2723c(this.f3113x) : null;
    }

    public final void m2637a(final Intent intent) {
        m2620a(new RouterRequiringFunc(this) {
            final /* synthetic */ Controller f12224b;

            public final void mo849a() {
                this.f12224b.f3098i.mo835a(intent);
            }
        });
    }

    public final void m2638a(final Intent intent, final int i) {
        m2620a(new RouterRequiringFunc(this) {
            final /* synthetic */ Controller f12227c;

            public final void mo849a() {
                this.f12227c.f3098i.mo838a(this.f12227c.f3101l, intent, i);
            }
        });
    }

    @TargetApi(23)
    public final void m2648a(final String[] strArr, final int i) {
        this.f3110u.addAll(Arrays.asList(strArr));
        m2620a(new RouterRequiringFunc(this) {
            final /* synthetic */ Controller f12230c;

            public final void mo849a() {
                this.f12230c.f3098i.mo839a(this.f12230c.f3101l, strArr, i);
            }
        });
    }

    public boolean m2667m() {
        List<RouterTransaction> arrayList = new ArrayList();
        for (ControllerHostedRouter m : this.f3108s) {
            arrayList.addAll(m.m2738m());
        }
        Collections.sort(arrayList, new C02556(this));
        for (RouterTransaction routerTransaction : arrayList) {
            Controller controller = routerTransaction.f3144a;
            if (controller.f3094e && controller.f3098i.m2734i()) {
                return true;
            }
        }
        return false;
    }

    public final void m2644a(LifecycleListener lifecycleListener) {
        if (!this.f3109t.contains(lifecycleListener)) {
            this.f3109t.add(lifecycleListener);
        }
    }

    public final void m2668n() {
        boolean z = (!this.f3094e || this.f3096g || this.f3095f) ? false : true;
        this.f3095f = true;
        if (z) {
            this.f3098i.mo840b();
        }
    }

    public final void a_(boolean z) {
        Object obj = (this.f3094e && this.f3095f && this.f3096g != z) ? 1 : null;
        this.f3096g = z;
        if (obj != null) {
            this.f3098i.mo840b();
        }
    }

    final void m2647a(Router router) {
        if (this.f3098i != router) {
            this.f3098i = router;
            m2631t();
            router = this.f3087A.iterator();
            while (router.hasNext()) {
                ((RouterRequiringFunc) router.next()).mo849a();
            }
            this.f3087A.clear();
            return;
        }
        m2631t();
    }

    final void m2669o() {
        Iterator it;
        if (!(this.f3098i.mo833a() == null || this.f3090D)) {
            it = new ArrayList(this.f3109t).iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.f3090D = true;
            it = new ArrayList(this.f3109t).iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        for (Router g : this.f3108s) {
            g.mo846g();
        }
    }

    private void m2620a(RouterRequiringFunc routerRequiringFunc) {
        if (this.f3098i != null) {
            routerRequiringFunc.mo849a();
        } else {
            this.f3087A.add(routerRequiringFunc);
        }
    }

    final void m2662e(Activity activity) {
        if (activity.isChangingConfigurations() != null) {
            m2643a(this.f3099j, true, false);
        } else {
            m2655b(true);
        }
        if (this.f3090D != null) {
            activity = new ArrayList(this.f3109t).iterator();
            while (activity.hasNext()) {
                activity.next();
            }
            this.f3090D = false;
            activity = new ArrayList(this.f3109t).iterator();
            while (activity.hasNext()) {
                activity.next();
            }
        }
    }

    final void m2661d(View view) {
        boolean z;
        if (this.f3098i != null) {
            if (view.getParent() == this.f3098i.f3142g) {
                z = false;
                this.f3114y = z;
                if (this.f3114y) {
                    this.f3103n = false;
                    for (LifecycleListener a : new ArrayList(this.f3109t)) {
                        a.m2611a(this, view);
                    }
                    this.f3094e = true;
                    this.f3102m = false;
                    m2652b(view);
                    if (this.f3095f != null && this.f3096g == null) {
                        this.f3098i.mo840b();
                    }
                    view = new ArrayList(this.f3109t).iterator();
                    while (view.hasNext()) {
                        view.next();
                    }
                }
            }
        }
        z = true;
        this.f3114y = z;
        if (this.f3114y) {
            this.f3103n = false;
            while (r0.hasNext()) {
                a.m2611a(this, view);
            }
            this.f3094e = true;
            this.f3102m = false;
            m2652b(view);
            this.f3098i.mo840b();
            view = new ArrayList(this.f3109t).iterator();
            while (view.hasNext()) {
                view.next();
            }
        }
    }

    final void m2643a(View view, boolean z, boolean z2) {
        if (!this.f3114y) {
            for (ControllerHostedRouter p : this.f3108s) {
                p.m2741p();
            }
        }
        z = !z2 && (z || this.f3106q == RetainViewMode.RELEASE_DETACH || this.f3092c);
        if (this.f3094e) {
            for (LifecycleListener b : new ArrayList(this.f3109t)) {
                b.m2615b(this, view);
            }
            this.f3094e = false;
            m2658c(view);
            if (this.f3095f != null && this.f3096g == null) {
                this.f3098i.mo840b();
            }
            view = new ArrayList(this.f3109t).iterator();
            while (view.hasNext()) {
                view.next();
            }
        }
        if (z) {
            m2670p();
        }
    }

    final void m2670p() {
        if (this.f3099j != null) {
            if (!(this.f3092c || this.f3103n)) {
                m2629f(this.f3099j);
            }
            Iterator it = new ArrayList(this.f3109t).iterator();
            while (it.hasNext()) {
                it.next();
            }
            m2641a(this.f3099j);
            ViewAttachHandler viewAttachHandler = this.f3107r;
            View view = this.f3099j;
            view.removeOnAttachStateChangeListener(viewAttachHandler);
            if (viewAttachHandler.f3185b != null && (view instanceof ViewGroup)) {
                ViewAttachHandler.m2768a((ViewGroup) view).removeOnAttachStateChangeListener(viewAttachHandler.f3185b);
            }
            this.f3107r = null;
            this.f3097h = false;
            if (this.f3092c) {
                this.f3088B = new WeakReference(this.f3099j);
            }
            this.f3099j = null;
            for (LifecycleListener b : new ArrayList(this.f3109t)) {
                b.m2614b(this);
            }
            for (ControllerHostedRouter h : this.f3108s) {
                h.m11152h();
            }
        }
        if (this.f3092c) {
            m2630s();
        }
    }

    final void m2671q() {
        for (ControllerHostedRouter controllerHostedRouter : this.f3108s) {
            if (!controllerHostedRouter.mo842c()) {
                View findViewById = this.f3099j.findViewById(controllerHostedRouter.f12241a);
                if (findViewById != null && (findViewById instanceof ViewGroup)) {
                    controllerHostedRouter.m11138a(this, (ViewGroup) findViewById);
                    controllerHostedRouter.m2740o();
                }
            }
        }
    }

    private void m2630s() {
        Iterator it;
        if (this.f3090D) {
            it = new ArrayList(this.f3109t).iterator();
            while (it.hasNext()) {
                it.next();
                am_();
            }
            this.f3090D = false;
            it = new ArrayList(this.f3109t).iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (!this.f3093d) {
            it = new ArrayList(this.f3109t).iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.f3093d = true;
            m2666l();
            this.f3100k = null;
            for (LifecycleListener c : new ArrayList(this.f3109t)) {
                c.mo859c(this);
            }
        }
    }

    final void m2655b(boolean z) {
        this.f3092c = true;
        if (this.f3098i != null) {
            this.f3098i.mo837a(this.f3101l);
        }
        for (ControllerHostedRouter b : this.f3108s) {
            b.mo857b(false);
        }
        if (this.f3094e) {
            if (z) {
                m2643a(this.f3099j, true, false);
            }
            return;
        }
        m2670p();
    }

    private void m2629f(View view) {
        this.f3103n = true;
        this.b_ = new Bundle(getClass().getClassLoader());
        SparseArray sparseArray = new SparseArray();
        view.saveHierarchyState(sparseArray);
        this.b_.putSparseParcelableArray("Controller.viewState.hierarchy", sparseArray);
        Bundle bundle = new Bundle(getClass().getClassLoader());
        m2642a(view, bundle);
        this.b_.putBundle("Controller.viewState.bundle", bundle);
        view = new ArrayList(this.f3109t).iterator();
        while (view.hasNext()) {
            view.next();
        }
    }

    final void m2663e(View view) {
        if (this.b_ != null) {
            view.restoreHierarchyState(this.b_.getSparseParcelableArray("Controller.viewState.hierarchy"));
            Bundle bundle = this.b_.getBundle("Controller.viewState.bundle");
            bundle.setClassLoader(getClass().getClassLoader());
            m2653b(view, bundle);
            m2671q();
            view = new ArrayList(this.f3109t).iterator();
            while (view.hasNext()) {
                view.next();
            }
        }
    }

    final Bundle m2672r() {
        boolean z;
        ArrayList arrayList;
        Iterator it;
        Bundle bundle;
        if (!(this.f3103n || this.f3099j == null)) {
            m2629f(this.f3099j);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("Controller.className", getClass().getName());
        bundle2.putBundle("Controller.viewState", this.b_);
        bundle2.putBundle("Controller.args", this.f3091a);
        bundle2.putString("Controller.instanceId", this.f3101l);
        bundle2.putString("Controller.target.instanceId", this.f3113x);
        bundle2.putStringArrayList("Controller.requestedPermissions", this.f3110u);
        String str = "Controller.needsAttach";
        if (!this.f3102m) {
            if (!this.f3094e) {
                z = false;
                bundle2.putBoolean(str, z);
                bundle2.putInt("Controller.retainViewMode", this.f3106q.ordinal());
                if (this.f3104o != null) {
                    bundle2.putBundle("Controller.overriddenPushHandler", this.f3104o.m2688d());
                }
                if (this.f3105p != null) {
                    bundle2.putBundle("Controller.overriddenPopHandler", this.f3105p.m2688d());
                }
                arrayList = new ArrayList();
                for (ControllerHostedRouter controllerHostedRouter : this.f3108s) {
                    Bundle bundle3 = new Bundle();
                    controllerHostedRouter.mo836a(bundle3);
                    arrayList.add(bundle3);
                }
                bundle2.putParcelableArrayList("Controller.childRouters", arrayList);
                bundle = new Bundle(getClass().getClassLoader());
                m2651b(bundle);
                it = new ArrayList(this.f3109t).iterator();
                while (it.hasNext()) {
                    it.next();
                }
                bundle2.putBundle("Controller.savedState", bundle);
                return bundle2;
            }
        }
        z = true;
        bundle2.putBoolean(str, z);
        bundle2.putInt("Controller.retainViewMode", this.f3106q.ordinal());
        if (this.f3104o != null) {
            bundle2.putBundle("Controller.overriddenPushHandler", this.f3104o.m2688d());
        }
        if (this.f3105p != null) {
            bundle2.putBundle("Controller.overriddenPopHandler", this.f3105p.m2688d());
        }
        arrayList = new ArrayList();
        for (ControllerHostedRouter controllerHostedRouter2 : this.f3108s) {
            Bundle bundle32 = new Bundle();
            controllerHostedRouter2.mo836a(bundle32);
            arrayList.add(bundle32);
        }
        bundle2.putParcelableArrayList("Controller.childRouters", arrayList);
        bundle = new Bundle(getClass().getClassLoader());
        m2651b(bundle);
        it = new ArrayList(this.f3109t).iterator();
        while (it.hasNext()) {
            it.next();
        }
        bundle2.putBundle("Controller.savedState", bundle);
        return bundle2;
    }

    private void m2627d(Bundle bundle) {
        this.b_ = bundle.getBundle("Controller.viewState");
        if (this.b_ != null) {
            this.b_.setClassLoader(getClass().getClassLoader());
        }
        this.f3101l = bundle.getString("Controller.instanceId");
        this.f3113x = bundle.getString("Controller.target.instanceId");
        this.f3110u.addAll(bundle.getStringArrayList("Controller.requestedPermissions"));
        this.f3104o = ControllerChangeHandler.m2679c(bundle.getBundle("Controller.overriddenPushHandler"));
        this.f3105p = ControllerChangeHandler.m2679c(bundle.getBundle("Controller.overriddenPopHandler"));
        this.f3102m = bundle.getBoolean("Controller.needsAttach");
        this.f3106q = RetainViewMode.values()[bundle.getInt("Controller.retainViewMode", 0)];
        for (Bundle bundle2 : bundle.getParcelableArrayList("Controller.childRouters")) {
            ControllerHostedRouter controllerHostedRouter = new ControllerHostedRouter();
            controllerHostedRouter.mo841b(bundle2);
            this.f3108s.add(controllerHostedRouter);
        }
        this.f3111v = bundle.getBundle("Controller.savedState");
        if (this.f3111v != null) {
            this.f3111v.setClassLoader(getClass().getClassLoader());
        }
        m2631t();
    }

    private void m2631t() {
        if (this.f3111v != null && this.f3098i != null) {
            m2657c(this.f3111v);
            for (LifecycleListener a : new ArrayList(this.f3109t)) {
                a.m2610a(this, this.f3111v);
            }
            this.f3111v = null;
        }
    }

    final void m2646a(ControllerChangeType controllerChangeType) {
        if (!controllerChangeType.f3133f) {
            this.f3089C = true;
            for (ControllerHostedRouter a : this.f3108s) {
                a.m11144a(true);
            }
        }
        for (LifecycleListener a2 : new ArrayList(this.f3109t)) {
            a2.m2612a(this, controllerChangeType);
        }
    }

    final void m2654b(ControllerChangeType controllerChangeType) {
        if (!controllerChangeType.f3133f) {
            this.f3089C = false;
            for (ControllerHostedRouter a : this.f3108s) {
                a.m11144a(false);
            }
        }
        for (LifecycleListener a2 : new ArrayList(this.f3109t)) {
            a2.mo858a(controllerChangeType);
        }
        if (this.f3092c != null && this.f3097h == null && this.f3094e == null && this.f3088B != null) {
            View view = (View) this.f3088B.get();
            if (!(this.f3098i.f3142g == null || view == null || view.getParent() != this.f3098i.f3142g)) {
                this.f3098i.f3142g.removeView(view);
            }
            this.f3088B = null;
        }
    }

    final void m2659c(boolean z) {
        if (this.f3115z != z) {
            this.f3115z = z;
            for (ControllerHostedRouter a : this.f3108s) {
                a.m11144a(z);
            }
            if (!z && this.f3099j && this.f3112w) {
                m2643a(this.f3099j, false, false);
            }
        }
    }

    private static Constructor m2618a(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 0) {
                return constructor;
            }
        }
        return null;
    }

    private static Constructor m2623b(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0] == Bundle.class) {
                return constructor;
            }
        }
        return null;
    }

    public final Router m2633a(ViewGroup viewGroup, String str) {
        int id = viewGroup.getId();
        for (Router router : this.f3108s) {
            if (router.f12241a == id && TextUtils.equals(str, router.f12242b)) {
                break;
            }
        }
        Router router2 = null;
        if (router2 == null) {
            router2 = new ControllerHostedRouter(viewGroup.getId(), str);
            router2.m11138a(this, viewGroup);
            this.f3108s.add(router2);
            if (this.f3089C != null) {
                router2.m11144a(true);
            }
        } else if (router2.mo842c() == null) {
            router2.m11138a(this, viewGroup);
            router2.m2740o();
        }
        return router2;
    }
}
