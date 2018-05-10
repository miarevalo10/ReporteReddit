package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> f35865a = new AtomicReference();
    private final AtomicReference<LinkedQueueNode<T>> f35866b = new AtomicReference();

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private E f25153a;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e) {
            this.f25153a = e;
        }

        public final E m26654a() {
            E e = this.f25153a;
            this.f25153a = null;
            return e;
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        m35957b(linkedQueueNode);
        m35956a(linkedQueueNode);
    }

    public final boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t);
        m35956a(linkedQueueNode).lazySet(linkedQueueNode);
        return true;
    }

    public final void clear() {
        while (poll() != null) {
            if (isEmpty()) {
                return;
            }
        }
    }

    private LinkedQueueNode<T> m35955a() {
        return (LinkedQueueNode) this.f35865a.get();
    }

    private LinkedQueueNode<T> m35956a(LinkedQueueNode<T> linkedQueueNode) {
        return (LinkedQueueNode) this.f35865a.getAndSet(linkedQueueNode);
    }

    private void m35957b(LinkedQueueNode<T> linkedQueueNode) {
        this.f35866b.lazySet(linkedQueueNode);
    }

    public final T poll() {
        LinkedQueueNode linkedQueueNode = (LinkedQueueNode) this.f35866b.get();
        LinkedQueueNode linkedQueueNode2 = (LinkedQueueNode) linkedQueueNode.get();
        T a;
        if (linkedQueueNode2 != null) {
            a = linkedQueueNode2.m26654a();
            m35957b(linkedQueueNode2);
            return a;
        } else if (linkedQueueNode == m35955a()) {
            return null;
        } else {
            do {
                linkedQueueNode2 = (LinkedQueueNode) linkedQueueNode.get();
            } while (linkedQueueNode2 == null);
            a = linkedQueueNode2.m26654a();
            m35957b(linkedQueueNode2);
            return a;
        }
    }

    public final boolean isEmpty() {
        return ((LinkedQueueNode) this.f35866b.get()) == m35955a();
    }
}
