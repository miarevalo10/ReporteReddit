package org.jcodec.common.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoPool {
    private static AutoPool instance = new AutoPool();
    private List<AutoResource> resources = Collections.synchronizedList(new ArrayList());
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    class C22031 implements Runnable {
        final /* synthetic */ AutoPool f26804a;

        C22031(AutoPool autoPool) {
            this.f26804a = autoPool;
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            for (AutoResource curTime : this.f26804a.resources) {
                curTime.setCurTime(currentTimeMillis);
            }
        }
    }

    private AutoPool() {
        this.scheduler.scheduleAtFixedRate(new C22031(this), 0, 100, TimeUnit.MILLISECONDS);
    }

    public static AutoPool getInstance() {
        return instance;
    }

    public void add(AutoResource autoResource) {
        this.resources.add(autoResource);
    }
}
