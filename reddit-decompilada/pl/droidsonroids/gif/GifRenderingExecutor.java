package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

final class GifRenderingExecutor extends ScheduledThreadPoolExecutor {

    private static final class InstanceHolder {
        private static final GifRenderingExecutor f41195a = new GifRenderingExecutor();
    }

    static GifRenderingExecutor m43271a() {
        return InstanceHolder.f41195a;
    }

    private GifRenderingExecutor() {
        super(1, new DiscardPolicy());
    }
}
