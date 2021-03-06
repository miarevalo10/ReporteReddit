package kotlin.reflect;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/IllegalCallableAccessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "Ljava/lang/IllegalAccessException;", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: exceptions.kt */
public class IllegalCallableAccessException extends Exception {
    public IllegalCallableAccessException(IllegalAccessException illegalAccessException) {
        Intrinsics.m26847b(illegalAccessException, "cause");
        super(illegalAccessException.getMessage());
        if (this == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Throwable");
        }
        initCause(illegalAccessException);
    }
}
