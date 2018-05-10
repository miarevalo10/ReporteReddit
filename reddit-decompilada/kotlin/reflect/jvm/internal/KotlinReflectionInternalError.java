package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinReflectionInternalError;", "Lkotlin/reflect/KotlinReflectionInternalError;", "message", "", "(Ljava/lang/String;)V", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: KotlinReflectionInternalError.kt */
public final class KotlinReflectionInternalError extends kotlin.reflect.KotlinReflectionInternalError {
    public KotlinReflectionInternalError(String str) {
        Intrinsics.m26847b(str, "message");
        super(str);
    }
}
