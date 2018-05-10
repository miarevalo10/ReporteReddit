package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001a\u0002H\u0002¢\u0006\u0002\u0010\u000b\u001a4\u0010\f\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00062\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\n¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "lazyOf", "value", "(Ljava/lang/Object;)Lkotlin/Lazy;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/Lazy;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 9})
/* compiled from: Lazy.kt */
public final class LazyKt {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25262a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            f25262a = iArr;
            iArr[LazyThreadSafetyMode.f25263a.ordinal()] = 1;
            f25262a[LazyThreadSafetyMode.f25264b.ordinal()] = 2;
            f25262a[LazyThreadSafetyMode.f25265c.ordinal()] = 3;
        }
    }

    public static final <T> Lazy<T> m26777a(Function0<? extends T> function0) {
        Intrinsics.m26847b(function0, "initializer");
        return new SynchronizedLazyImpl(function0);
    }

    public static final <T> Lazy<T> m26776a(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        Intrinsics.m26847b(lazyThreadSafetyMode, "mode");
        Intrinsics.m26847b(function0, "initializer");
        switch (WhenMappings.f25262a[lazyThreadSafetyMode.ordinal()]) {
            case 1:
                return (Lazy) new SynchronizedLazyImpl(function0);
            case 2:
                return (Lazy) new SafePublicationLazyImpl(function0);
            case 3:
                return (Lazy) new UnsafeLazyImpl(function0);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
