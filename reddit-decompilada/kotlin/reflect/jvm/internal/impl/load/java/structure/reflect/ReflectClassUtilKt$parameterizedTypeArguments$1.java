package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.ParameterizedType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: reflectClassUtil.kt */
final class ReflectClassUtilKt$parameterizedTypeArguments$1 extends Lambda implements Function1<ParameterizedType, ParameterizedType> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$1 f38453a = new ReflectClassUtilKt$parameterizedTypeArguments$1();

    ReflectClassUtilKt$parameterizedTypeArguments$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        Intrinsics.m26847b(parameterizedType, "it");
        obj = parameterizedType.getOwnerType();
        if (!(obj instanceof ParameterizedType)) {
            obj = null;
        }
        return (ParameterizedType) obj;
    }
}
