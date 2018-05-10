package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.VolatileSizeArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected final CountDownLatch f32459a = new CountDownLatch(1);
    protected final List<T> f32460b = new VolatileSizeArrayList();
    protected final List<Throwable> f32461c = new VolatileSizeArrayList();
    protected long f32462d;
    protected Thread f32463e;
    protected boolean f32464f;
    protected int f32465g;
    protected int f32466h;
}
