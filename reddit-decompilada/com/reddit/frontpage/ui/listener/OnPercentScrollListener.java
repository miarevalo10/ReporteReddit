package com.reddit.frontpage.ui.listener;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import timber.log.Timber;

public abstract class OnPercentScrollListener extends OnScrollListener {
    private final float f29008a;
    private float f29009b;
    private int f29010c;

    public abstract void mo6462a();

    protected OnPercentScrollListener(float f) {
        this.f29010c = 0;
        this.f29008a = f;
    }

    protected OnPercentScrollListener() {
        this(0.1f);
    }

    public void mo6517a(RecyclerView recyclerView, int i, int i2) {
        super.a(recyclerView, i, i2);
        this.f29010c += i2;
        if (((float) Math.abs(this.f29010c)) > this.f29009b) {
            Timber.a("Scroll exceeded min dy", new Object[0]);
            mo6462a();
            this.f29010c = 0;
        }
    }

    public void mo6501a(RecyclerView recyclerView, int i) {
        super.a(recyclerView, i);
        if (this.f29009b != 0.0f) {
            return;
        }
        if (i == 0 || i == 2) {
            this.f29009b = ((float) recyclerView.getHeight()) * this.f29008a;
            Timber.b("Calculated DY before notifying screen changes: %f", new Object[]{Float.valueOf(this.f29009b)});
        }
    }
}
