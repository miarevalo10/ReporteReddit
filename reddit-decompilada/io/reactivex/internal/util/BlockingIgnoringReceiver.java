package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

public final class BlockingIgnoringReceiver extends CountDownLatch implements Action, Consumer<Throwable> {
    public Throwable f32458a;

    public final /* synthetic */ void accept(Object obj) throws Exception {
        this.f32458a = (Throwable) obj;
        countDown();
    }

    public BlockingIgnoringReceiver() {
        super(1);
    }

    public final void run() {
        countDown();
    }
}
