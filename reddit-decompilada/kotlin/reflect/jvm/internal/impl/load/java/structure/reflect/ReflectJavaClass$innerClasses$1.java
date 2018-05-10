package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$innerClasses$1 extends Lambda implements Function1<Class<?>, Boolean> {
    public static final ReflectJavaClass$innerClasses$1 f38459a = new ReflectJavaClass$innerClasses$1();

    ReflectJavaClass$innerClasses$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(((CharSequence) ((Class) obj).getSimpleName()).length() == null ? true : null);
    }
}
