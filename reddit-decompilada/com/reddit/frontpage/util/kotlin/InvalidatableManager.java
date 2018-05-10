package com.reddit.frontpage.util.kotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0006\u0010\u000b\u001a\u00020\tR\u001b\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/util/kotlin/InvalidatableManager;", "", "()V", "values", "", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "getValues", "()Ljava/util/List;", "add", "", "value", "invalidate", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Lazy.kt */
public final class InvalidatableManager {
    final List<InvalidatableLazy<?>> f21832a = new ArrayList();

    public final void m24081a() {
        for (InvalidatableLazy a : this.f21832a) {
            a.mo6532a();
        }
    }
}
