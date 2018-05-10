package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;

public final class ConsPStack<E> implements Iterable<E> {
    private static final ConsPStack<Object> f26438d = new ConsPStack();
    public final E f26439a;
    public final ConsPStack<E> f26440b;
    public final int f26441c;

    private static class Itr<E> implements Iterator<E> {
        private ConsPStack<E> f26437a;

        public Itr(ConsPStack<E> consPStack) {
            this.f26437a = consPStack;
        }

        public boolean hasNext() {
            return this.f26437a.f26441c > 0;
        }

        public E next() {
            E e = this.f26437a.f26439a;
            this.f26437a = this.f26437a.f26440b;
            return e;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static <E> ConsPStack<E> m28128a() {
        return f26438d;
    }

    private ConsPStack() {
        this.f26441c = 0;
        this.f26439a = null;
        this.f26440b = null;
    }

    ConsPStack(E e, ConsPStack<E> consPStack) {
        this.f26439a = e;
        this.f26440b = consPStack;
        this.f26441c = 1 + consPStack.f26441c;
    }

    public final E m28131a(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        if (r4 < 0) goto L_0x0024;
    L_0x0002:
        r0 = r3.f26441c;
        if (r4 <= r0) goto L_0x0007;
    L_0x0006:
        goto L_0x0024;
    L_0x0007:
        r0 = r3.m28129b(r4);	 Catch:{ NoSuchElementException -> 0x0010 }
        r0 = r0.next();	 Catch:{ NoSuchElementException -> 0x0010 }
        return r0;
    L_0x0010:
        r0 = new java.lang.IndexOutOfBoundsException;
        r1 = new java.lang.StringBuilder;
        r2 = "Index: ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
    L_0x0024:
        r4 = new java.lang.IndexOutOfBoundsException;
        r4.<init>();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.pcollections.ConsPStack.a(int):E");
    }

    public final Iterator<E> iterator() {
        return m28129b(0);
    }

    private Iterator<E> m28129b(int i) {
        return new Itr(m28130c(i));
    }

    final ConsPStack<E> m28132a(Object obj) {
        if (this.f26441c == 0) {
            return this;
        }
        if (this.f26439a.equals(obj)) {
            return this.f26440b;
        }
        ConsPStack a = this.f26440b.m28132a(obj);
        if (a == this.f26440b) {
            return this;
        }
        return new ConsPStack(this.f26439a, a);
    }

    private ConsPStack<E> m28130c(int i) {
        ConsPStack<E> consPStack = this;
        while (i >= 0) {
            if (i > consPStack.f26441c) {
                break;
            } else if (i == 0) {
                return consPStack;
            } else {
                consPStack = consPStack.f26440b;
                i--;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
