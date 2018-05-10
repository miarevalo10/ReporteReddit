package com.reddit.frontpage.ui.live;

import android.os.Bundle;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bJ,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001aR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/ui/live/TabNavigationStrategy;", "", "screenCreator", "Lkotlin/Function1;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView$Item;", "Lcom/reddit/frontpage/nav/Screen;", "transactionCreator", "Lcom/bluelinelabs/conductor/RouterTransaction;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "instanceIdCache", "", "", "calculateNewBackstack", "", "backstack", "tab", "clearTopScreens", "", "canGoBack", "instanceIdForPosition", "isRootScreen", "screen", "Lcom/bluelinelabs/conductor/Controller;", "restoreInstanceState", "", "savedState", "Landroid/os/Bundle;", "saveInstanceState", "outState", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TabNavigationStrategy.kt */
public final class TabNavigationStrategy {
    public final Map<Item, String> f21452a;
    final Function1<Item, Screen> f21453b;
    final Function1<Screen, RouterTransaction> f21454c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bluelinelabs/conductor/RouterTransaction;", "it", "Lcom/reddit/frontpage/nav/Screen;", "invoke"}, k = 3, mv = {1, 1, 9})
    /* compiled from: TabNavigationStrategy.kt */
    static final class C29031 extends Lambda implements Function1<Screen, RouterTransaction> {
        public static final C29031 f37323a = new C29031();

        C29031() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            Screen screen = (Screen) obj;
            Intrinsics.m26847b(screen, "it");
            obj = RouterTransaction.a(screen).a(Routing.m22615a()).b(Routing.m22615a());
            Intrinsics.m26843a(obj, "RouterTransaction.with(i…g.defaultChangeHandler())");
            return obj;
        }
    }

    private TabNavigationStrategy(Function1<? super Item, ? extends Screen> function1, Function1<? super Screen, ? extends RouterTransaction> function12) {
        Intrinsics.m26847b(function1, "screenCreator");
        Intrinsics.m26847b(function12, "transactionCreator");
        this.f21453b = function1;
        this.f21454c = function12;
        this.f21452a = (Map) new EnumMap(Item.class);
    }

    public final boolean m23547a(Controller controller) {
        return this.f21452a.values().contains(controller.Y_());
    }

    public final void m23546a(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        for (Entry entry : this.f21452a.entrySet()) {
            Item item = (Item) entry.getKey();
            bundle.putString(item.name(), (String) entry.getValue());
        }
    }
}
