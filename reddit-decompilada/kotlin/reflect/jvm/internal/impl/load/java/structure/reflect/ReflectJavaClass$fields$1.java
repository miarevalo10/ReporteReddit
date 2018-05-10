package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Field;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$fields$1 extends Lambda implements Function1<Field, Boolean> {
    public static final ReflectJavaClass$fields$1 f38457a = new ReflectJavaClass$fields$1();

    ReflectJavaClass$fields$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(((Field) obj).isSynthetic() ^ 1);
    }
}
