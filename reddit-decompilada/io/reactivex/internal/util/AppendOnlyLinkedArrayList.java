package io.reactivex.internal.util;

import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T> {
    public final int f25179a = 4;
    public final Object[] f25180b = new Object[5];
    Object[] f25181c = this.f25180b;
    int f25182d;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t);
    }

    public final void m26667a(T t) {
        int i = this.f25179a;
        int i2 = this.f25182d;
        if (i2 == i) {
            Object[] objArr = new Object[(i + 1)];
            this.f25181c[i] = objArr;
            this.f25181c = objArr;
            i2 = 0;
        }
        this.f25181c[i2] = t;
        this.f25182d = i2 + 1;
    }

    public final void m26666a(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i = this.f25179a;
        for (Object[] objArr = this.f25180b; objArr != null; objArr = (Object[]) objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null || nonThrowingPredicate.test(obj)) {
                    break;
                }
            }
        }
    }

    public final <U> boolean m26668a(Subscriber<? super U> subscriber) {
        Object[] objArr = this.f25180b;
        int i = this.f25179a;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object obj = objArr[i2];
                if (obj == null) {
                    continue;
                    break;
                } else if (NotificationLite.m26703b(obj, (Subscriber) subscriber)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = (Object[]) objArr[i];
        }
    }
}
