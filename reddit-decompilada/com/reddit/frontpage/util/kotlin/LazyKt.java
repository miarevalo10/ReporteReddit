package com.reddit.frontpage.util.kotlin;

import com.reddit.frontpage.ui.BaseFrontpageFragment;
import com.reddit.frontpage.ui.BaseScreen;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a$\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a$\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\n"}, d2 = {"resettableLazy", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "T", "initializer", "Lkotlin/Function0;", "manager", "Lcom/reddit/frontpage/util/kotlin/InvalidatableManager;", "manageableLazy", "Lcom/reddit/frontpage/ui/BaseFrontpageFragment;", "Lcom/reddit/frontpage/ui/BaseScreen;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: Lazy.kt */
public final class LazyKt {
    public static final <T> InvalidatableLazy<T> m24085a(BaseScreen baseScreen, Function0<? extends T> function0) {
        Intrinsics.m26847b(baseScreen, "$receiver");
        Intrinsics.m26847b(function0, "initializer");
        InvalidatableManager invalidatableManager = baseScreen.f37154I;
        Intrinsics.m26843a((Object) invalidatableManager, "this.invalidatableManager");
        return m24086a((Function0) function0, invalidatableManager);
    }

    public static final <T> InvalidatableLazy<T> m24084a(BaseFrontpageFragment baseFrontpageFragment, Function0<? extends T> function0) {
        Intrinsics.m26847b(baseFrontpageFragment, "$receiver");
        Intrinsics.m26847b(function0, "initializer");
        InvalidatableManager invalidatableManager = baseFrontpageFragment.f37151f;
        Intrinsics.m26843a((Object) invalidatableManager, "this.invalidatableManager");
        return m24086a((Function0) function0, invalidatableManager);
    }

    private static final <T> InvalidatableLazy<T> m24086a(Function0<? extends T> function0, InvalidatableManager invalidatableManager) {
        InvalidatableLazy<T> invalidatableLazyImpl = new InvalidatableLazyImpl(function0);
        Intrinsics.m26847b(invalidatableLazyImpl, "value");
        invalidatableManager.f21832a.add(invalidatableLazyImpl);
        return invalidatableLazyImpl;
    }
}
