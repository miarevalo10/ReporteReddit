package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: reflectClassUtil.kt */
final class ReflectClassUtilKt$parameterizedTypeArguments$2 extends Lambda implements Function1<ParameterizedType, Sequence<? extends Type>> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$2 f38454a = new ReflectClassUtilKt$parameterizedTypeArguments$2();

    ReflectClassUtilKt$parameterizedTypeArguments$2() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        Intrinsics.m26847b(parameterizedType, "it");
        return ArraysKt___ArraysKt.m36114n((Object[]) parameterizedType.getActualTypeArguments());
    }
}
