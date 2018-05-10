package com.bluelinelabs.conductor.support;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerHostedRouter;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;

public abstract class RouterPagerAdapter extends PagerAdapter {
    protected int f12262b = RedditJobManager.f10810d;
    protected SparseArray<Router> f12263c = new SparseArray();
    private final Controller f12264d;
    private SparseArray<Bundle> f12265e = new SparseArray();
    private ArrayList<Integer> f12266f = new ArrayList();

    public abstract void m11186a(Router router, int i);

    public RouterPagerAdapter(Controller controller) {
        this.f12264d = controller;
    }

    public Object mo231a(ViewGroup viewGroup, int i) {
        int id = viewGroup.getId();
        long j = (long) i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id);
        stringBuilder.append(":");
        stringBuilder.append(j);
        Router a = this.f12264d.m2633a(viewGroup, stringBuilder.toString());
        if (!a.m2739n()) {
            Bundle bundle = (Bundle) this.f12265e.get(i);
            if (bundle != null) {
                a.mo841b(bundle);
                this.f12265e.remove(i);
            }
        }
        a.m2740o();
        m11186a(a, i);
        this.f12263c.put(i, a);
        return a;
    }

    public final void mo235a(ViewGroup viewGroup, int i, Object obj) {
        Router router = (Router) obj;
        Bundle bundle = new Bundle();
        router.mo836a(bundle);
        this.f12265e.put(i, bundle);
        this.f12266f.remove(Integer.valueOf(i));
        this.f12266f.add(Integer.valueOf(i));
        m11189e();
        viewGroup = this.f12264d;
        if ((router instanceof ControllerHostedRouter) && viewGroup.f3108s.remove(router) != null) {
            router.mo857b(true);
        }
        this.f12263c.remove(i);
    }

    public final boolean mo237a(View view, Object obj) {
        for (RouterTransaction routerTransaction : ((Router) obj).m2738m()) {
            if (routerTransaction.f3144a.f3099j == view) {
                return true;
            }
        }
        return null;
    }

    public final Parcelable mo238b() {
        Parcelable bundle = new Bundle();
        bundle.putSparseParcelableArray("RouterPagerAdapter.savedStates", this.f12265e);
        bundle.putInt("RouterPagerAdapter.maxPagesToStateSave", this.f12262b);
        bundle.putIntegerArrayList("RouterPagerAdapter.savedPageHistory", this.f12266f);
        return bundle;
    }

    public final void mo233a(Parcelable parcelable, ClassLoader classLoader) {
        Bundle bundle = (Bundle) parcelable;
        if (parcelable != null) {
            this.f12265e = bundle.getSparseParcelableArray("RouterPagerAdapter.savedStates");
            this.f12262b = bundle.getInt("RouterPagerAdapter.maxPagesToStateSave");
            this.f12266f = bundle.getIntegerArrayList("RouterPagerAdapter.savedPageHistory");
        }
    }

    protected final void m11189e() {
        while (this.f12265e.size() > this.f12262b) {
            this.f12265e.remove(((Integer) this.f12266f.remove(0)).intValue());
        }
    }
}
