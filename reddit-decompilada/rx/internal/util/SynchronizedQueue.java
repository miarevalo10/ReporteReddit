package rx.internal.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedQueue<T> implements Cloneable, Queue<T> {
    private final Queue<T> f41365a;
    private final int f41366b;

    public SynchronizedQueue() {
        this.f41365a = new LinkedList();
        this.f41366b = -1;
    }

    public SynchronizedQueue(int i) {
        this.f41365a = new LinkedList();
        this.f41366b = i;
    }

    public synchronized boolean isEmpty() {
        return this.f41365a.isEmpty();
    }

    public synchronized boolean contains(Object obj) {
        return this.f41365a.contains(obj);
    }

    public synchronized Iterator<T> iterator() {
        return this.f41365a.iterator();
    }

    public synchronized int size() {
        return this.f41365a.size();
    }

    public synchronized boolean add(T t) {
        return this.f41365a.add(t);
    }

    public synchronized boolean remove(Object obj) {
        return this.f41365a.remove(obj);
    }

    public synchronized boolean containsAll(Collection<?> collection) {
        return this.f41365a.containsAll(collection);
    }

    public synchronized boolean addAll(Collection<? extends T> collection) {
        return this.f41365a.addAll(collection);
    }

    public synchronized boolean removeAll(Collection<?> collection) {
        return this.f41365a.removeAll(collection);
    }

    public synchronized boolean retainAll(Collection<?> collection) {
        return this.f41365a.retainAll(collection);
    }

    public synchronized void clear() {
        this.f41365a.clear();
    }

    public synchronized String toString() {
        return this.f41365a.toString();
    }

    public int hashCode() {
        return this.f41365a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f41365a.equals(((SynchronizedQueue) obj).f41365a);
    }

    public synchronized T peek() {
        return this.f41365a.peek();
    }

    public synchronized T element() {
        return this.f41365a.element();
    }

    public synchronized T poll() {
        return this.f41365a.poll();
    }

    public synchronized T remove() {
        return this.f41365a.remove();
    }

    public synchronized boolean offer(T t) {
        if (this.f41366b >= 0 && this.f41365a.size() + 1 > this.f41366b) {
            return null;
        }
        return this.f41365a.offer(t);
    }

    public synchronized Object clone() {
        SynchronizedQueue synchronizedQueue;
        synchronizedQueue = new SynchronizedQueue(this.f41366b);
        synchronizedQueue.addAll(this.f41365a);
        return synchronizedQueue;
    }

    public synchronized Object[] toArray() {
        return this.f41365a.toArray();
    }

    public synchronized <R> R[] toArray(R[] rArr) {
        return this.f41365a.toArray(rArr);
    }
}
