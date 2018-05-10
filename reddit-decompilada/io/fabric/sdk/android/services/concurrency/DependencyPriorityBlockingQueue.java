package io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DependencyPriorityBlockingQueue<E extends Dependency & Task & PriorityProvider> extends PriorityBlockingQueue<E> {
    final Queue<E> f24818a = new LinkedList();
    private final ReentrantLock f24819b = new ReentrantLock();

    public /* synthetic */ Object peek() {
        return m26380b();
    }

    public /* synthetic */ Object poll() {
        return m26381c();
    }

    private E m26380b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = 1;
        r1 = 0;
        r0 = r2.m26377a(r0, r1, r1);	 Catch:{ InterruptedException -> 0x0007 }
        return r0;
    L_0x0007:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue.b():E");
    }

    private E m26381c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = 2;
        r1 = 0;
        r0 = r2.m26377a(r0, r1, r1);	 Catch:{ InterruptedException -> 0x0007 }
        return r0;
    L_0x0007:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue.c():E");
    }

    public int size() {
        try {
            this.f24819b.lock();
            int size = this.f24818a.size() + super.size();
            return size;
        } finally {
            this.f24819b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f24819b.lock();
            tArr = m26379a(super.toArray(tArr), this.f24818a.toArray(tArr));
            return tArr;
        } finally {
            this.f24819b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f24819b.lock();
            Object[] a = m26379a(super.toArray(), this.f24818a.toArray());
            return a;
        } finally {
            this.f24819b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        int drainTo;
        try {
            this.f24819b.lock();
            drainTo = super.drainTo(collection) + this.f24818a.size();
            while (!this.f24818a.isEmpty()) {
                collection.add(this.f24818a.poll());
            }
            return drainTo;
        } finally {
            drainTo = this.f24819b;
            drainTo.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f24819b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f24818a.isEmpty() && drainTo <= i) {
                collection.add(this.f24818a.poll());
                drainTo++;
            }
            this.f24819b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.f24819b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f24819b.lock();
            if (!super.contains(obj)) {
                if (this.f24818a.contains(obj) == null) {
                    obj = null;
                    this.f24819b.unlock();
                    return obj;
                }
            }
            obj = true;
            this.f24819b.unlock();
            return obj;
        } catch (Throwable th) {
            this.f24819b.unlock();
        }
    }

    public void clear() {
        try {
            this.f24819b.lock();
            this.f24818a.clear();
            super.clear();
        } finally {
            this.f24819b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f24819b.lock();
            if (!super.remove(obj)) {
                if (this.f24818a.remove(obj) == null) {
                    obj = null;
                    this.f24819b.unlock();
                    return obj;
                }
            }
            obj = true;
            this.f24819b.unlock();
            return obj;
        } catch (Throwable th) {
            this.f24819b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f24819b.lock();
            collection = this.f24818a.removeAll(collection) | super.removeAll(collection);
            return collection;
        } finally {
            this.f24819b.unlock();
        }
    }

    private boolean m26378a(int i, E e) {
        try {
            this.f24819b.lock();
            if (i == 1) {
                super.remove(e);
            }
            i = this.f24818a.offer(e);
            return i;
        } finally {
            this.f24819b.unlock();
        }
    }

    public final void m26382a() {
        try {
            this.f24819b.lock();
            Iterator it = this.f24818a.iterator();
            while (it.hasNext()) {
                Dependency dependency = (Dependency) it.next();
                if (dependency.areDependenciesMet()) {
                    super.offer(dependency);
                    it.remove();
                }
            }
        } finally {
            this.f24819b.unlock();
        }
    }

    private static <T> T[] m26379a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }

    private E m26377a(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        while (true) {
            Dependency dependency;
            switch (i) {
                case 0:
                    dependency = (Dependency) super.take();
                    break;
                case 1:
                    dependency = (Dependency) super.peek();
                    break;
                case 2:
                    dependency = (Dependency) super.poll();
                    break;
                case 3:
                    dependency = (Dependency) super.poll(l.longValue(), timeUnit);
                    break;
                default:
                    dependency = null;
                    break;
            }
            if (dependency == null || dependency.areDependenciesMet()) {
                return dependency;
            }
            m26378a(i, dependency);
        }
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return m26377a(3, Long.valueOf(j), timeUnit);
    }

    public /* synthetic */ Object take() throws InterruptedException {
        return m26377a(0, null, null);
    }
}
