package io.reactivex.android;

import android.os.Looper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MainThreadDisposable implements Disposable {
    private final AtomicBoolean f31086a = new AtomicBoolean();

    class C21271 implements Runnable {
        final /* synthetic */ MainThreadDisposable f24999a;

        C21271(MainThreadDisposable mainThreadDisposable) {
            this.f24999a = mainThreadDisposable;
        }

        public void run() {
            this.f24999a.p_();
        }
    }

    public abstract void p_();

    public final boolean mo5627b() {
        return this.f31086a.get();
    }

    public final void mo5626a() {
        if (this.f31086a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                p_();
                return;
            }
            AndroidSchedulers.m26509a().mo5677a(new C21271(this));
        }
    }
}
