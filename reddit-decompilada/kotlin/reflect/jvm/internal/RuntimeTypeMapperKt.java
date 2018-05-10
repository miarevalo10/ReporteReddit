package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: RuntimeTypeMapper.kt */
public final class RuntimeTypeMapperKt {
    public static final /* synthetic */ String m26931a(Method method) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method.getName());
        stringBuilder.append(ArraysKt___ArraysKt.m36083a((Object[]) method.getParameterTypes(), (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, null, (Function1) RuntimeTypeMapperKt$signature$1.f38313a, 24));
        stringBuilder.append(ReflectClassUtilKt.m27245f(method.getReturnType()));
        return stringBuilder.toString();
    }
}
