package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {
    State f14868a = State.NOT_READY;
    private T f14869b;

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T mo3613a();

    protected AbstractIterator() {
    }

    public final boolean hasNext() {
        Preconditions.m6921b(this.f14868a != State.FAILED);
        switch (this.f14868a) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                this.f14868a = State.FAILED;
                this.f14869b = mo3613a();
                if (this.f14868a == State.DONE) {
                    return false;
                }
                this.f14868a = State.READY;
                return true;
        }
    }

    public final T next() {
        if (hasNext()) {
            this.f14868a = State.NOT_READY;
            T t = this.f14869b;
            this.f14869b = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
