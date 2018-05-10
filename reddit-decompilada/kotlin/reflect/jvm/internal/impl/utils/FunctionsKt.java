package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: functions.kt */
public final class FunctionsKt {
    private static final Function1<Object, Object> f26419a = FunctionsKt$IDENTITY$1.f38968a;
    private static final Function1<Object, Boolean> f26420b = FunctionsKt$ALWAYS_TRUE$1.f38964a;
    private static final Function1<Object, Object> f26421c = FunctionsKt$ALWAYS_NULL$1.f38963a;
    private static final Function1<Object, Unit> f26422d = FunctionsKt$DO_NOTHING$1.f38965a;
    private static final Function2<Object, Object, Unit> f26423e = FunctionsKt$DO_NOTHING_2$1.f38966a;
    private static final Function3<Object, Object, Object, Unit> f26424f = FunctionsKt$DO_NOTHING_3$1.f38967a;

    public static final <T> Function1<T, T> m28105a() {
        Object obj = f26419a;
        if (obj != null) {
            return (Function1) TypeIntrinsics.m26870a(obj, 1);
        }
        throw new TypeCastException("null cannot be cast to non-null type (T) -> T");
    }

    public static final <T> Function1<T, Boolean> m28106b() {
        return f26420b;
    }

    public static final Function2<Object, Object, Unit> m28107c() {
        return f26423e;
    }

    public static final Function3<Object, Object, Object, Unit> m28108d() {
        return f26424f;
    }
}
