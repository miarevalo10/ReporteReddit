package com.squareup.picasso;

import com.squareup.picasso.Picasso.Priority;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class PicassoExecutorService extends ThreadPoolExecutor {

    private static final class PicassoFutureTask extends FutureTask<BitmapHunter> implements Comparable<PicassoFutureTask> {
        private final BitmapHunter f23852a;

        public final /* synthetic */ int compareTo(Object obj) {
            PicassoFutureTask picassoFutureTask = (PicassoFutureTask) obj;
            Priority priority = this.f23852a.f23752s;
            Priority priority2 = picassoFutureTask.f23852a.f23752s;
            return priority == priority2 ? this.f23852a.f23734a - picassoFutureTask.f23852a.f23734a : priority2.ordinal() - priority.ordinal();
        }

        public PicassoFutureTask(BitmapHunter bitmapHunter) {
            super(bitmapHunter, null);
            this.f23852a = bitmapHunter;
        }
    }

    PicassoExecutorService() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new PicassoThreadFactory());
    }

    final void m25784a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public Future<?> submit(Runnable runnable) {
        Object picassoFutureTask = new PicassoFutureTask((BitmapHunter) runnable);
        execute(picassoFutureTask);
        return picassoFutureTask;
    }
}
