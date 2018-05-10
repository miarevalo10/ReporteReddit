package com.android.volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
    final Map<String, Queue<Request<?>>> f2790a = new HashMap();
    final Set<Request<?>> f2791b = new HashSet();
    public final PriorityBlockingQueue<Request<?>> f2792c = new PriorityBlockingQueue();
    public final PriorityBlockingQueue<Request<?>> f2793d = new PriorityBlockingQueue();
    public final Cache f2794e;
    public final Network f2795f;
    public final ResponseDelivery f2796g;
    public NetworkDispatcher[] f2797h;
    public CacheDispatcher f2798i;
    List<Object> f2799j = new ArrayList();
    private AtomicInteger f2800k = new AtomicInteger();

    public RequestQueue(Cache cache, Network network, ResponseDelivery responseDelivery) {
        this.f2794e = cache;
        this.f2795f = network;
        this.f2797h = new NetworkDispatcher[8];
        this.f2796g = responseDelivery;
    }

    public <T> Request<T> mo3040a(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.f2791b) {
            this.f2791b.add(request);
        }
        request.setSequence(this.f2800k.incrementAndGet());
        request.addMarker("add-to-queue");
        if (request.shouldCache()) {
            synchronized (this.f2790a) {
                String cacheKey = request.getCacheKey();
                if (this.f2790a.containsKey(cacheKey)) {
                    Queue queue = (Queue) this.f2790a.get(cacheKey);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(request);
                    this.f2790a.put(cacheKey, queue);
                    if (VolleyLog.f2814b) {
                        VolleyLog.m2454a("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                } else {
                    this.f2790a.put(cacheKey, null);
                    this.f2792c.add(request);
                }
            }
            return request;
        }
        this.f2793d.add(request);
        return request;
    }
}
