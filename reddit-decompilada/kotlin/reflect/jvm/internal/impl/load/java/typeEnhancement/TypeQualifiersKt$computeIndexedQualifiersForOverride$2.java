package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion;

/* compiled from: typeQualifiers.kt */
final class TypeQualifiersKt$computeIndexedQualifiersForOverride$2 extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
    final /* synthetic */ JavaTypeQualifiers[] f38757a;

    TypeQualifiersKt$computeIndexedQualifiersForOverride$2(JavaTypeQualifiers[] javaTypeQualifiersArr) {
        this.f38757a = javaTypeQualifiersArr;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = ((Number) obj).intValue();
        Object[] objArr = (Object[]) this.f38757a;
        if (obj < null || obj > ArraysKt___ArraysKt.m36107g(objArr)) {
            obj = JavaTypeQualifiers.f25739d;
            obj = Companion.m27257a();
        } else {
            obj = objArr[obj];
        }
        return (JavaTypeQualifiers) obj;
    }
}
