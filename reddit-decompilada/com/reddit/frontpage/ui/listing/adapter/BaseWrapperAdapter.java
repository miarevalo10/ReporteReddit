package com.reddit.frontpage.ui.listing.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BaseWrapperAdapter<T extends ViewHolder> extends Adapter<T> {
    protected Adapter<T> f29087a;
    private BridgeObserver f29088b = new BridgeObserver(this);

    private static final class BridgeObserver<VH extends ViewHolder> extends AdapterDataObserver {
        private final WeakReference<BaseWrapperAdapter<VH>> f29086a;

        BridgeObserver(BaseWrapperAdapter<VH> baseWrapperAdapter) {
            this.f29086a = new WeakReference(baseWrapperAdapter);
        }

        public final void m30131a() {
            BaseWrapperAdapter baseWrapperAdapter = (BaseWrapperAdapter) this.f29086a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.mo6525c();
            }
        }

        public final void m30132a(int i, int i2) {
            BaseWrapperAdapter baseWrapperAdapter = (BaseWrapperAdapter) this.f29086a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.a(i, i2);
            }
        }

        public final void m30133b(int i, int i2) {
            BaseWrapperAdapter baseWrapperAdapter = (BaseWrapperAdapter) this.f29086a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.mo6527e(i, i2);
            }
        }

        public final void m30134c(int i, int i2) {
            BaseWrapperAdapter baseWrapperAdapter = (BaseWrapperAdapter) this.f29086a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.mo6528f(i, i2);
            }
        }

        public final void m30135d(int i, int i2) {
            BaseWrapperAdapter baseWrapperAdapter = (BaseWrapperAdapter) this.f29086a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.b(i, i2);
            }
        }
    }

    public BaseWrapperAdapter(Adapter<T> adapter) {
        this.f29087a = adapter;
        this.f29087a.a(this.f29088b);
        super.a(this.f29087a.e);
    }

    public final void m30143b() {
        if (this.f29087a instanceof BaseWrapperAdapter) {
            ((BaseWrapperAdapter) this.f29087a).m30143b();
        }
        if (!(this.f29087a == null || this.f29088b == null)) {
            this.f29087a.b(this.f29088b);
        }
        this.f29087a = null;
        this.f29088b = null;
    }

    public final void m30144b(T t) {
        this.f29087a.b(t);
    }

    public void mo6526c(T t) {
        this.f29087a.c(t);
    }

    public final void m30139a(T t) {
        this.f29087a.a(t);
    }

    public final void m30141a(boolean z) {
        super.a(z);
        this.f29087a.a(z);
    }

    public T mo6512a(ViewGroup viewGroup, int i) {
        return this.f29087a.a(viewGroup, i);
    }

    public void mo6513a(T t, int i) {
        this.f29087a.a(t, i);
    }

    public int mo6510a() {
        return this.f29087a.a();
    }

    public long mo6511a(int i) {
        return this.f29087a.a(i);
    }

    public int mo6514b(int i) {
        return this.f29087a.b(i);
    }

    public final int m30148d(ViewHolder viewHolder) {
        return mo6515c(viewHolder.d());
    }

    public int mo6515c(int i) {
        return this.f29087a instanceof BaseWrapperAdapter ? ((BaseWrapperAdapter) this.f29087a).mo6515c(i) : i;
    }

    public void mo6527e(int i, int i2) {
        c(i, i2);
    }

    public void mo6528f(int i, int i2) {
        d(i, i2);
    }

    public void mo6525c() {
        this.a_.b();
    }
}
