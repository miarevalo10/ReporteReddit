package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$constructors$1 extends Lambda implements Function1<Constructor<?>, Boolean> {
    public static final ReflectJavaClass$constructors$1 f38455a = new ReflectJavaClass$constructors$1();

    ReflectJavaClass$constructors$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(((Constructor) obj).isSynthetic() ^ 1);
    }
}
