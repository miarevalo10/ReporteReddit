package com.bluelinelabs.conductor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeListener;
import com.bluelinelabs.conductor.internal.TransactionIndexer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControllerHostedRouter extends Router {
    int f12241a;
    String f12242b;
    private final String f12243h = "ControllerHostedRouter.hostId";
    private final String f12244i = "ControllerHostedRouter.tag";
    private Controller f12245j;
    private boolean f12246k;

    ControllerHostedRouter() {
    }

    ControllerHostedRouter(int i, String str) {
        this.f12241a = i;
        this.f12242b = str;
    }

    final void m11138a(Controller controller, ViewGroup viewGroup) {
        if (this.f12245j != controller || this.g != viewGroup) {
            m11152h();
            if (viewGroup instanceof ControllerChangeListener) {
                m2707a((ControllerChangeListener) viewGroup);
            }
            this.f12245j = controller;
            this.g = viewGroup;
            viewGroup = this.c.iterator();
            while (viewGroup.hasNext()) {
                ((RouterTransaction) viewGroup.next()).f3144a.f3100k = controller;
            }
            m2742q();
        }
    }

    final void m11152h() {
        if (this.g != null && (this.g instanceof ControllerChangeListener)) {
            m2718b((ControllerChangeListener) this.g);
        }
        for (Controller controller : new ArrayList(this.e)) {
            if (controller.f3099j != null) {
                controller.m2643a(controller.f3099j, true, false);
            }
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            RouterTransaction routerTransaction = (RouterTransaction) it.next();
            if (routerTransaction.f3144a.f3099j != null) {
                routerTransaction.f3144a.m2643a(routerTransaction.f3144a.f3099j, true, false);
            }
        }
        m2743r();
        this.f12245j = null;
        this.g = null;
    }

    final void m11144a(boolean z) {
        this.f12246k = z;
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((RouterTransaction) it.next()).f3144a.m2659c(z);
        }
    }

    final void mo857b(boolean z) {
        m11144a(false);
        super.mo857b(z);
    }

    protected final void mo855a(RouterTransaction routerTransaction) {
        if (this.f12246k) {
            routerTransaction.f3144a.m2659c(true);
        }
        super.mo855a(routerTransaction);
    }

    public final void mo856a(List<RouterTransaction> list, ControllerChangeHandler controllerChangeHandler) {
        if (this.f12246k) {
            for (RouterTransaction routerTransaction : list) {
                routerTransaction.f3144a.m2659c(true);
            }
        }
        super.mo856a((List) list, controllerChangeHandler);
    }

    public final Activity mo833a() {
        return this.f12245j != null ? this.f12245j.am_() : null;
    }

    public final void mo834a(Activity activity) {
        super.mo834a(activity);
        m11152h();
    }

    public final void mo840b() {
        if (this.f12245j != null && this.f12245j.f3098i != null) {
            this.f12245j.f3098i.mo840b();
        }
    }

    final void mo835a(Intent intent) {
        if (this.f12245j != null && this.f12245j.f3098i != null) {
            this.f12245j.f3098i.mo835a(intent);
        }
    }

    final void mo838a(String str, Intent intent, int i) {
        if (this.f12245j != null && this.f12245j.f3098i != null) {
            this.f12245j.f3098i.mo838a(str, intent, i);
        }
    }

    final void mo837a(String str) {
        if (this.f12245j != null && this.f12245j.f3098i != null) {
            this.f12245j.f3098i.mo837a(str);
        }
    }

    final void mo839a(String str, String[] strArr, int i) {
        if (this.f12245j != null && this.f12245j.f3098i != null) {
            this.f12245j.f3098i.mo839a(str, strArr, i);
        }
    }

    final boolean mo842c() {
        return this.f12245j != null;
    }

    public final void mo836a(Bundle bundle) {
        super.mo836a(bundle);
        bundle.putInt("ControllerHostedRouter.hostId", this.f12241a);
        bundle.putString("ControllerHostedRouter.tag", this.f12242b);
    }

    public final void mo841b(Bundle bundle) {
        super.mo841b(bundle);
        this.f12241a = bundle.getInt("ControllerHostedRouter.hostId");
        this.f12242b = bundle.getString("ControllerHostedRouter.tag");
    }

    final void mo854a(Controller controller) {
        super.mo854a(controller);
        controller.f3100k = this.f12245j;
    }

    final List<Router> mo843d() {
        List<Router> arrayList = new ArrayList();
        arrayList.addAll(this.f12245j.m2664j());
        arrayList.addAll(this.f12245j.f3098i.mo843d());
        return arrayList;
    }

    final Router mo844e() {
        return (this.f12245j == null || this.f12245j.f3098i == null) ? this : this.f12245j.f3098i.mo844e();
    }

    final TransactionIndexer mo845f() {
        return mo844e().mo845f();
    }
}
