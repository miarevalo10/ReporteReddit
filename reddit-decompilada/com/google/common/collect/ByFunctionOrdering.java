package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    final Function<F, ? extends T> f14879a;
    final Ordering<T> f14880b;

    ByFunctionOrdering(Function<F, ? extends T> function, Ordering<T> ordering) {
        this.f14879a = (Function) Preconditions.m6908a((Object) function);
        this.f14880b = (Ordering) Preconditions.m6908a((Object) ordering);
    }

    public final int compare(F f, F f2) {
        return this.f14880b.compare(this.f14879a.apply(f), this.f14879a.apply(f2));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        return this.f14879a.equals(byFunctionOrdering.f14879a) && this.f14880b.equals(byFunctionOrdering.f14880b) != null;
    }

    public final int hashCode() {
        return Objects.m14556a(this.f14879a, this.f14880b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f14880b);
        stringBuilder.append(".onResultOf(");
        stringBuilder.append(this.f14879a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
