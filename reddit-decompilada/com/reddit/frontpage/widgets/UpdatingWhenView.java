package com.reddit.frontpage.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.reddit.frontpage.util.DateUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import timber.log.Timber;

public class UpdatingWhenView extends AppCompatTextView {
    AtomicBoolean f34524b = new AtomicBoolean();
    Runnable f34525c = new C19261(this);
    private long f34526d;
    private Handler f34527e;

    class C19261 implements Runnable {
        final /* synthetic */ UpdatingWhenView f21952a;

        C19261(UpdatingWhenView updatingWhenView) {
            this.f21952a = updatingWhenView;
        }

        @SuppressLint({"NewApi"})
        public void run() {
            if (this.f21952a.f34524b.get() || this.f21952a.isAttachedToWindow()) {
                this.f21952a.m35299a();
                long b = DateUtil.m23683b(this.f21952a.f34526d, System.currentTimeMillis());
                if (b > 0) {
                    Timber.b("UpdatingWhenView: rescheduled", new Object[0]);
                    this.f21952a.f34527e.postDelayed(this.f21952a.f34525c, b);
                }
                return;
            }
            this.f21952a.f34527e.removeCallbacks(this);
        }
    }

    public UpdatingWhenView(Context context) {
        super(context);
    }

    public UpdatingWhenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UpdatingWhenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void m35299a() {
        setText(DateUtil.m23685c(this.f34526d, System.currentTimeMillis()));
        Timber.b("UpdatingWhenView: %s", new Object[]{r0});
    }

    public void setStartTime(long j) {
        this.f34526d = j;
        this.f34527e = new Handler();
        Timber.b("UpdatingWhenView: setting start time", new Object[0]);
        m35299a();
        m35300b();
    }

    private void m35300b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (DateUtil.m23686d(this.f34526d, currentTimeMillis) && !this.f34524b.getAndSet(true)) {
            if (this.f34527e == null) {
                this.f34527e = new Handler();
            }
            currentTimeMillis = DateUtil.m23683b(this.f34526d, currentTimeMillis);
            if (currentTimeMillis > 0) {
                Timber.b("UpdatingWhenView: scheduled", new Object[0]);
                this.f34527e.postDelayed(this.f34525c, currentTimeMillis);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m35300b();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f34524b.getAndSet(false) && this.f34527e != null) {
            this.f34527e.removeCallbacks(this.f34525c);
        }
    }
}
