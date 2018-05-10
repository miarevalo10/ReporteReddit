package com.reddit.frontpage.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import butterknife.BindView;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Controller.LifecycleListener;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeListener;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository.InboxCount;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.social.data.datasource.local.ChatCountChangeDataSource;
import com.reddit.datalibrary.social.data.repo.ChatDataRepository;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.nav.FloatingActionsManager;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.color.ColorSource;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import com.reddit.frontpage.ui.color.StatusBarColorControllerChangeListener;
import com.reddit.frontpage.ui.live.TabNavigationStrategy;
import com.reddit.frontpage.ui.live.TabNavigator;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.FloatingActionsView;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import com.reddit.social.analytics.ChatPerformanceAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcel;
import timber.log.Timber;

public class BottomNavScreen extends BaseScreen {
    private CompositeDisposable f39123A;
    private Item f39124B = null;
    private boolean f39125C = FrontpageSettings.a().l();
    private ChatDataRepositoryContract f39126D;
    private ChatPerformanceAnalyticsContract f39127E;
    @BindView
    BottomNavView bottomNav;
    @State
    boolean bottomNavIsActive = true;
    @BindView
    ViewGroup content;
    @BindView
    FloatingActionsView floatingActionsView;
    public Router f39128v;
    TabNavigator f39129w;
    private ControllerChangeListener f39130x;
    private OnGlobalLayoutListener f39131y;
    private FloatingActionsManager f39132z;

    private class BottomNavLayoutListener implements OnGlobalLayoutListener {
        final /* synthetic */ BottomNavScreen f21067a;
        private final int f21068b;
        private int f21069c;

        private BottomNavLayoutListener(BottomNavScreen bottomNavScreen) {
            this.f21067a = bottomNavScreen;
            this.f21068b = Util.m24012d((int) C1761R.dimen.min_keyboard_size);
        }

        public void onGlobalLayout() {
            int height;
            MarginLayoutParams marginLayoutParams;
            if (this.f21067a.bottomNavIsActive) {
                height = this.f21067a.K.getHeight();
            } else {
                height = this.f21067a.am_().getResources().getDisplayMetrics().heightPixels;
            }
            this.f21069c = Math.max(this.f21069c, height);
            int i = this.f21069c - height;
            int i2 = 0;
            if (this.f21067a.bottomNav.getVisibility() != 8 && i > this.f21068b && this.f21067a.bottomNavIsActive) {
                this.f21067a.bottomNav.setVisibility(8);
                marginLayoutParams = (MarginLayoutParams) this.f21067a.content.getLayoutParams();
            } else if (this.f21067a.bottomNav.getVisibility() != 0 && i < this.f21068b && this.f21067a.bottomNavIsActive) {
                this.f21067a.bottomNav.setVisibility(0);
                marginLayoutParams = (MarginLayoutParams) this.f21067a.content.getLayoutParams();
                if (this.f21067a.bottomNavIsActive) {
                    i2 = this.f21067a.bottomNav.getHeight();
                }
            } else {
                return;
            }
            marginLayoutParams.bottomMargin = i2;
            this.f21067a.content.requestLayout();
        }
    }

    private class BottomNavChangeListener implements ControllerChangeListener {
        final /* synthetic */ BottomNavScreen f28880a;

        class C23191 implements OnColorChangedCallback {
            final /* synthetic */ BottomNavChangeListener f28876a;

            public final void mo4944d(Integer num) {
            }

            C23191(BottomNavChangeListener bottomNavChangeListener) {
                this.f28876a = bottomNavChangeListener;
            }

            public final void mo4943c(Integer num) {
                if (this.f28876a.f28880a.e) {
                    this.f28876a.f28880a.bottomNav.setPostButtonColor(num);
                }
            }
        }

        public final void m29937b(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
        }

        private BottomNavChangeListener(BottomNavScreen bottomNavScreen) {
            this.f28880a = bottomNavScreen;
        }

        public final void m29936a(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler) {
            this.f28880a.f39132z.m29345a((BaseScreen) controller);
            if (controller != null) {
                viewGroup = ((Screen) controller).mo7143u();
                if (viewGroup == 1) {
                    this.f28880a.m38989Q();
                } else if (viewGroup == 2) {
                    this.f28880a.m38988P();
                }
            }
            if ((controller instanceof ColorSource) != null) {
                final ColorSource colorSource = (ColorSource) controller;
                final OnColorChangedCallback c23191 = new C23191(this);
                colorSource.mo4950a(c23191);
                controller.a(new LifecycleListener(this) {
                    final /* synthetic */ BottomNavChangeListener f28879c;

                    public final void m29935b(Controller controller, View view) {
                        colorSource.mo4952b(c23191);
                    }
                });
                return;
            }
            this.f28880a.bottomNav.setPostButtonColor(null);
        }
    }

    @Parcel
    static class HomeDeepLinker implements ScreenDeepLinker {
        public int homePosition;

        HomeDeepLinker(int i) {
            this.homePosition = i;
        }

        public Screen createScreen() {
            Screen w = HomeScreen.m39019w();
            w.m39023a(this.homePosition);
            return w;
        }

        public void apply(BottomNavScreen bottomNavScreen) {
            bottomNavScreen.bottomNav.setSelectedItem(Item.f21972a);
            bottomNavScreen.m39006a(Item.f21972a, false);
            bottomNavScreen = Routing.m22618a(bottomNavScreen.f39128v);
            if (bottomNavScreen instanceof HomeScreen) {
                ((HomeScreen) bottomNavScreen).m39023a(this.homePosition);
            }
        }
    }

    class C26801 extends DisposableObserver<InboxCount> {
        final /* synthetic */ BottomNavScreen f34210a;

        public void onComplete() {
        }

        C26801(BottomNavScreen bottomNavScreen) {
            this.f34210a = bottomNavScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            InboxCount inboxCount = (InboxCount) obj;
            this.f34210a.bottomNav.m24210a(Item.f21976e, (inboxCount.a + inboxCount.b) + inboxCount.c);
        }

        public void onError(Throwable th) {
            this.f34210a.bottomNav.m24210a(Item.f21976e, 0);
            Timber.c(th, "BottomNavScreen: InboxCountRepository.INSTANCE.inboxCountObservable", new Object[0]);
        }
    }

    protected final boolean af_() {
        return true;
    }

    public final int mo7141s() {
        return C1761R.layout.screen_bottom_nav;
    }

    public BottomNavScreen() {
        if (this.f39125C) {
            this.f39126D = new ChatDataRepository();
        }
        this.f39127E = new ChatPerformanceAnalytics();
        this.f39129w = new TabNavigator(new BottomNavScreen$$Lambda$0(this));
    }

    public static ScreenDeepLinker m38998w() {
        return new HomeDeepLinker(0);
    }

    public static ScreenDeepLinker m38999x() {
        return new HomeDeepLinker(1);
    }

    public final boolean m39005a(ScreenDeepLinker screenDeepLinker) {
        if (!(screenDeepLinker instanceof HomeDeepLinker) || Routing.m22618a(this.i) != this || m39001O() == Item.f21972a) {
            return false;
        }
        ((HomeDeepLinker) screenDeepLinker).apply(this);
        return true;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater = super.mo7139a(layoutInflater, viewGroup);
        this.f39128v = a(this.content, null);
        viewGroup = this.f39129w;
        Router router = this.f39128v;
        Intrinsics.m26847b(router, "<set-?>");
        viewGroup.f21455a = router;
        TabNavigator.m23548a(this.f39129w);
        this.f39130x = new BottomNavChangeListener();
        this.f39128v.a(this.f39130x);
        if ((am_() instanceof RedditThemedActivity) != null) {
            RedditThemedActivity redditThemedActivity = (RedditThemedActivity) am_();
            if (redditThemedActivity.m41961k()) {
                this.f39128v.a(new StatusBarColorControllerChangeListener(redditThemedActivity));
            }
        }
        this.f39132z = new FloatingActionsManager(this.floatingActionsView);
        this.f39132z.m29345a((BaseScreen) Routing.m22618a(this.f39128v));
        this.bottomNav.m24211a(Item.values());
        viewGroup = Routing.m22618a(this.f39128v);
        if (viewGroup instanceof ColorSource) {
            this.bottomNav.setPostButtonColor(((ColorSource) viewGroup).mo4954w());
        }
        this.bottomNav.setOnItemSelectedListener(new BottomNavScreen$$Lambda$8(this));
        this.f39131y = new BottomNavLayoutListener();
        this.f39123A = new CompositeDisposable();
        viewGroup = InboxCountRepository.a;
        this.f39123A.mo5631a((Disposable) InboxCountRepository.f().subscribeWith(new C26801(this)));
        if (this.f39125C != null) {
            this.f39123A.mo5631a(this.f39126D.mo4518b("CHANNEL_HANDLER_CHATS_BOTTOM_NAV_SCREEN").subscribe(new BottomNavScreen$$Lambda$1(this), BottomNavScreen$$Lambda$2.f28869a));
            this.f39123A.mo5631a(this.f39126D.mo4521c("CHANNEL_HANDLER_INVITES_BOTTOM_NAV_SCREEN").subscribe(new BottomNavScreen$$Lambda$3(this), BottomNavScreen$$Lambda$4.f28871a));
            viewGroup = ChatCountChangeDataSource.f19838a;
            this.f39123A.mo5631a(ChatCountChangeDataSource.m21694a().subscribe(new BottomNavScreen$$Lambda$5(this), BottomNavScreen$$Lambda$6.f28873a));
        }
        if (this.f39124B != null) {
            this.bottomNav.setSelectedItem(this.f39124B);
            m39006a(this.f39124B, false);
        } else {
            this.bottomNav.setSelectedItem(Item.f21972a);
        }
        if (this.bottomNavIsActive != null) {
            m38989Q();
        } else {
            m38988P();
        }
        return layoutInflater;
    }

    final void m39012y() {
        if (this.f39125C && this.f39126D != null) {
            this.f39123A.mo5631a(this.f39126D.mo4533g().observeOn(SchedulerProvider.m23887c()).onErrorReturnItem(Integer.valueOf(0)).subscribe(new BottomNavScreen$$Lambda$7(this)));
        }
    }

    protected final void mo6992b(View view) {
        super.mo6992b(view);
        this.K.getViewTreeObserver().addOnGlobalLayoutListener(this.f39131y);
        m39012y();
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.K.getViewTreeObserver().removeOnGlobalLayoutListener(this.f39131y);
    }

    protected final void mo6991b(Bundle bundle) {
        super.mo6991b(bundle);
        Bundle bundle2 = new Bundle();
        TabNavigator tabNavigator = this.f39129w;
        Intrinsics.m26847b(bundle2, "outState");
        tabNavigator.f21456b.m23546a(bundle2);
        bundle.putBundle("tabNavigatorState", bundle2);
    }

    protected final void mo7199c(android.os.Bundle r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        super.mo7199c(r7);
        r0 = "tabNavigatorState";
        r7 = r7.getBundle(r0);
        if (r7 == 0) goto L_0x0050;
    L_0x000b:
        r0 = r6.f39129w;
        r1 = "savedState";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r1);
        r0 = r0.f21456b;
        r1 = "savedState";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r1);
        r1 = r7.keySet();
        r2 = "savedState.keySet()";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r2);
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
    L_0x0028:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0050;
    L_0x002e:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r3 = "key";	 Catch:{ Exception -> 0x003e }
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r3);	 Catch:{ Exception -> 0x003e }
        r3 = com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item.valueOf(r2);	 Catch:{ Exception -> 0x003e }
        goto L_0x003f;
    L_0x003e:
        r3 = 0;
    L_0x003f:
        if (r3 == 0) goto L_0x0028;
    L_0x0041:
        r4 = r0.f21452a;
        r2 = r7.getString(r2);
        r5 = "savedState.getString(key)";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r5);
        r4.put(r3, r2);
        goto L_0x0028;
    L_0x0050:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.BottomNavScreen.c(android.os.Bundle):void");
    }

    public final void mo6987a(View view) {
        if (this.f39125C) {
            this.f39126D.mo4526d("CHANNEL_HANDLER_CHATS_BOTTOM_NAV_SCREEN");
            this.f39126D.mo4526d("CHANNEL_HANDLER_INVITES_BOTTOM_NAV_SCREEN");
        }
        if (this.f39123A != null) {
            this.f39123A.mo5626a();
        }
        super.mo6987a(view);
        this.f39128v.b(this.f39130x);
    }

    public final boolean mo7197I() {
        TabNavigator tabNavigator = this.f39129w;
        TabNavigationStrategy tabNavigationStrategy = tabNavigator.f21456b;
        Router router = tabNavigator.f21455a;
        if (router == null) {
            Intrinsics.m26844a("router");
        }
        Object m = router.m();
        Intrinsics.m26843a(m, "router.backstack");
        Intrinsics.m26847b(m, "backstack");
        if (!m.isEmpty()) {
            Controller controller = ((RouterTransaction) CollectionsKt___CollectionsKt.m41437f((List) m)).a;
            Intrinsics.m26843a((Object) controller, "backstack.last().controller()");
            if (!tabNavigationStrategy.m23547a(controller)) {
                return true;
            }
        }
        return false;
    }

    public final Item m39001O() {
        return this.bottomNav != null ? this.bottomNav.getSelectedItem() : null;
    }

    public final void m39004a(Item item) {
        if (this.bottomNav != null) {
            this.bottomNav.setSelectedItem(item);
            m39006a(item, false);
            return;
        }
        this.f39124B = item;
    }

    public final boolean m39006a(Item item, boolean z) {
        if (this.f39125C && item == Item.f21975d) {
            this.f39127E.mo5100a();
        }
        this.f39129w.m23549a(item, z);
        return true;
    }

    private void m38988P() {
        this.bottomNav.setVisibility(8);
        this.bottomNavIsActive = false;
        if (((MarginLayoutParams) this.content.getLayoutParams()).bottomMargin != 0) {
            ((MarginLayoutParams) this.content.getLayoutParams()).bottomMargin = 0;
            this.content.requestLayout();
        }
    }

    private void m38989Q() {
        this.bottomNav.setVisibility(0);
        this.bottomNavIsActive = true;
        if (((MarginLayoutParams) this.content.getLayoutParams()).bottomMargin == 0) {
            ((MarginLayoutParams) this.content.getLayoutParams()).bottomMargin = this.bottomNav.getHeight();
            this.content.requestLayout();
        }
    }
}
