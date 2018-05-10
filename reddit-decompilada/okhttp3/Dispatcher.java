package okhttp3;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

public final class Dispatcher {
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<AsyncCall> readyAsyncCalls = new ArrayDeque();
    private final Deque<AsyncCall> runningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public final synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, RedditJobManager.f10810d, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public final synchronized void setMaxRequests(int i) {
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder("max < 1: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.maxRequests = i;
        promoteCalls();
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized void setMaxRequestsPerHost(int i) {
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder("max < 1: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.maxRequestsPerHost = i;
        promoteCalls();
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    final synchronized void enqueue(AsyncCall asyncCall) {
        if (this.runningAsyncCalls.size() >= this.maxRequests || runningCallsForHost(asyncCall) >= this.maxRequestsPerHost) {
            this.readyAsyncCalls.add(asyncCall);
            return;
        }
        this.runningAsyncCalls.add(asyncCall);
        executorService().execute(asyncCall);
    }

    public final synchronized void cancelAll() {
        for (AsyncCall asyncCall : this.readyAsyncCalls) {
            asyncCall.get().cancel();
        }
        for (AsyncCall asyncCall2 : this.runningAsyncCalls) {
            asyncCall2.get().cancel();
        }
        for (RealCall cancel : this.runningSyncCalls) {
            cancel.cancel();
        }
    }

    private void promoteCalls() {
        if (this.runningAsyncCalls.size() < this.maxRequests && !this.readyAsyncCalls.isEmpty()) {
            Iterator it = this.readyAsyncCalls.iterator();
            while (it.hasNext()) {
                AsyncCall asyncCall = (AsyncCall) it.next();
                if (runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
                    it.remove();
                    this.runningAsyncCalls.add(asyncCall);
                    executorService().execute(asyncCall);
                }
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    return;
                }
            }
        }
    }

    private int runningCallsForHost(AsyncCall asyncCall) {
        int i = 0;
        for (AsyncCall host : this.runningAsyncCalls) {
            if (host.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    final synchronized void executed(RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    final void finished(AsyncCall asyncCall) {
        finished(this.runningAsyncCalls, asyncCall, true);
    }

    final void finished(RealCall realCall) {
        finished(this.runningSyncCalls, realCall, false);
    }

    private <T> void finished(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (deque.remove(t) == null) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                promoteCalls();
            }
            deque = runningCallsCount();
            t = this.idleCallback;
        }
        if (deque == null && t != null) {
            t.run();
        }
    }

    public final synchronized List<Call> queuedCalls() {
        List arrayList;
        arrayList = new ArrayList();
        for (AsyncCall asyncCall : this.readyAsyncCalls) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized List<Call> runningCalls() {
        List arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        for (AsyncCall asyncCall : this.runningAsyncCalls) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }
}
