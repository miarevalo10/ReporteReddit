package com.reddit.frontpage.ui.live;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0004R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/ui/live/TabNavigator;", "", "screenCreator", "Lkotlin/Function1;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "Lcom/reddit/frontpage/nav/Screen;", "(Lkotlin/jvm/functions/Function1;)V", "router", "Lcom/bluelinelabs/conductor/Router;", "getRouter", "()Lcom/bluelinelabs/conductor/Router;", "setRouter", "(Lcom/bluelinelabs/conductor/Router;)V", "strategy", "Lcom/reddit/frontpage/ui/live/TabNavigationStrategy;", "canGoBack", "", "initialize", "", "startingPosition", "navigateTo", "tab", "clearTopScreens", "restoreInstanceState", "savedState", "Landroid/os/Bundle;", "saveInstanceState", "outState", "screenAtPosition", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TabNavigator.kt */
public final class TabNavigator {
    public Router f21455a;
    public final TabNavigationStrategy f21456b;

    public TabNavigator(Function1<? super Item, ? extends Screen> function1) {
        Intrinsics.m26847b(function1, "screenCreator");
        this.f21456b = new TabNavigationStrategy(function1);
    }

    public static /* synthetic */ void m23548a(TabNavigator tabNavigator) {
        Item item = Item.f21972a;
        Intrinsics.m26847b(item, "startingPosition");
        Router router = tabNavigator.f21455a;
        if (router == null) {
            Intrinsics.m26844a("router");
        }
        if (!router.n()) {
            tabNavigator.m23549a(item, false);
        }
    }

    public final void m23549a(Item item, boolean z) {
        Intrinsics.m26847b(item, "tab");
        Router router = this.f21455a;
        if (router == null) {
            Intrinsics.m26844a("router");
        }
        TabNavigationStrategy tabNavigationStrategy = this.f21456b;
        Router router2 = this.f21455a;
        if (router2 == null) {
            Intrinsics.m26844a("router");
        }
        Object<RouterTransaction> m = router2.m();
        Intrinsics.m26843a((Object) m, "router.backstack");
        Intrinsics.m26847b(m, "backstack");
        Intrinsics.m26847b(item, "tab");
        int i = 0;
        for (RouterTransaction a : m) {
            Object a2 = a.a();
            Intrinsics.m26843a(a2, "it.controller()");
            if (Intrinsics.m26845a(a2.Y_(), (String) tabNavigationStrategy.f21452a.get(item))) {
                break;
            }
            i++;
        }
        i = -1;
        List arrayList;
        if (i >= 0) {
            List list = (List) new ArrayList();
            arrayList = new ArrayList();
            int size = m.size();
            int i2 = 0;
            int i3 = i2;
            while (i2 < size) {
                if (i2 == i) {
                    list.add(m.get(i2));
                    i3 = 1;
                } else {
                    if (i3 != 0) {
                        Controller a3 = ((RouterTransaction) m.get(i2)).a();
                        Intrinsics.m26843a((Object) a3, "backstack[i].controller()");
                        if (tabNavigationStrategy.m23547a(a3)) {
                            arrayList.add(m.get(i2));
                            i3 = 0;
                        }
                    }
                    if (i3 == 0) {
                        arrayList.add(m.get(i2));
                    } else if (!z) {
                        list.add(m.get(i2));
                    }
                }
                i2++;
            }
            item = CollectionsKt___CollectionsKt.m41423b((Collection) arrayList, (Iterable) list);
        } else {
            Screen screen = (Screen) tabNavigationStrategy.f21453b.mo6492a(item);
            arrayList = new ArrayList();
            arrayList.addAll((Collection) m);
            arrayList.add(tabNavigationStrategy.f21454c.mo6492a(screen));
            Map map = tabNavigationStrategy.f21452a;
            Object Y_ = screen.Y_();
            Intrinsics.m26843a(Y_, "screen.instanceId");
            map.put(item, Y_);
            item = arrayList;
        }
        router.a(item, Routing.m22615a());
    }
}
