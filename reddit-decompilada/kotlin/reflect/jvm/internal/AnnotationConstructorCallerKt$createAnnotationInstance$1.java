package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"equals", "", "other", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: AnnotationConstructorCaller.kt */
final class AnnotationConstructorCallerKt$createAnnotationInstance$1 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Class f38206a;
    final /* synthetic */ List f38207b;
    final /* synthetic */ Map f38208c;

    AnnotationConstructorCallerKt$createAnnotationInstance$1(Class cls, List list, Map map) {
        this.f38206a = cls;
        this.f38207b = list;
        this.f38208c = map;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return Boolean.valueOf(m38217b(obj));
    }

    public final boolean m38217b(Object obj) {
        Object obj2 = null;
        Annotation annotation = (Annotation) (!(obj instanceof Annotation) ? null : obj);
        if (annotation != null) {
            KClass a = JvmClassMappingKt.m26831a(annotation);
            if (a != null) {
                obj2 = JvmClassMappingKt.m26829a(a);
            }
        }
        if (Intrinsics.m26845a(obj2, this.f38206a)) {
            for (Method method : this.f38207b) {
                boolean equals;
                Object obj3 = this.f38208c.get(method.getName());
                Object invoke = method.invoke(obj, new Object[0]);
                if (obj3 instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.BooleanArray");
                    }
                    equals = Arrays.equals(zArr, (boolean[]) invoke);
                    continue;
                } else if (obj3 instanceof char[]) {
                    char[] cArr = (char[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharArray");
                    }
                    equals = Arrays.equals(cArr, (char[]) invoke);
                    continue;
                } else if (obj3 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
                    }
                    equals = Arrays.equals(bArr, (byte[]) invoke);
                    continue;
                } else if (obj3 instanceof short[]) {
                    short[] sArr = (short[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.ShortArray");
                    }
                    equals = Arrays.equals(sArr, (short[]) invoke);
                    continue;
                } else if (obj3 instanceof int[]) {
                    int[] iArr = (int[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.IntArray");
                    }
                    equals = Arrays.equals(iArr, (int[]) invoke);
                    continue;
                } else if (obj3 instanceof float[]) {
                    float[] fArr = (float[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.FloatArray");
                    }
                    equals = Arrays.equals(fArr, (float[]) invoke);
                    continue;
                } else if (obj3 instanceof long[]) {
                    long[] jArr = (long[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.LongArray");
                    }
                    equals = Arrays.equals(jArr, (long[]) invoke);
                    continue;
                } else if (obj3 instanceof double[]) {
                    double[] dArr = (double[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.DoubleArray");
                    }
                    equals = Arrays.equals(dArr, (double[]) invoke);
                    continue;
                } else if (obj3 instanceof Object[]) {
                    Object[] objArr = (Object[]) obj3;
                    if (invoke == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                    }
                    equals = Arrays.equals(objArr, (Object[]) invoke);
                    continue;
                } else {
                    equals = Intrinsics.m26845a(obj3, invoke);
                    continue;
                }
                if (!equals) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
