package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: KTypesJvm.kt */
public final class KTypesJvm {
    public static final KClass<?> m26889a(KClassifier kClassifier) {
        Intrinsics.m26847b(kClassifier, "$receiver");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (kClassifier instanceof KTypeParameter) {
            Object obj;
            kClassifier = ((KTypeParameter) kClassifier).mo6678a();
            Iterator it = ((Iterable) kClassifier).iterator();
            int i;
            do {
                ClassifierDescriptor classifierDescriptor = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                KType kType = (KType) obj;
                if (kType == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                }
                ClassifierDescriptor c = ((KTypeImpl) kType).f32603a.mo6743g().mo5724c();
                if (c instanceof ClassDescriptor) {
                    classifierDescriptor = c;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                i = 1;
                if (classDescriptor == null || (Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.INTERFACE) ^ 1) == 0 || (Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.ANNOTATION_CLASS) ^ 1) == 0) {
                    i = 0;
                    continue;
                } else {
                    continue;
                }
            } while (i == 0);
            KType kType2 = (KType) obj;
            if (kType2 == null) {
                kType2 = (KType) CollectionsKt___CollectionsKt.m41434e((List) kClassifier);
            }
            if (kType2 != null) {
                Intrinsics.m26847b(kType2, "$receiver");
                kClassifier = kType2.mo5693a();
                if (kClassifier != null) {
                    kClassifier = m26889a(kClassifier);
                    if (kClassifier != null) {
                        if (kClassifier == null) {
                        }
                        return kClassifier;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("Cannot calculate JVM erasure for type: ");
                stringBuilder.append(kType2);
                throw ((Throwable) new KotlinReflectionInternalError(stringBuilder.toString()));
            }
            kClassifier = Reflection.m26850a(Object.class);
            return kClassifier;
        }
        StringBuilder stringBuilder2 = new StringBuilder("Cannot calculate JVM erasure for type: ");
        stringBuilder2.append(kClassifier);
        throw new KotlinReflectionInternalError(stringBuilder2.toString());
    }
}
