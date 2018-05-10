package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: LazyScopeAdapter.kt */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> f38817a;

    public LazyScopeAdapter(NotNullLazyValue<? extends MemberScope> notNullLazyValue) {
        Intrinsics.m26847b(notNullLazyValue, "scope");
        this.f38817a = notNullLazyValue;
    }

    protected final MemberScope mo7113c() {
        return (MemberScope) this.f38817a.invoke();
    }
}
