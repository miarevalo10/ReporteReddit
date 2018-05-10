package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeQualifiers.kt */
public final class TypeQualifiersKt {
    private static final JavaTypeQualifiers m27283a(KotlinType kotlinType) {
        Pair pair;
        if (FlexibleTypesKt.m27946a(kotlinType)) {
            FlexibleType b = FlexibleTypesKt.m27947b(kotlinType);
            pair = new Pair(b.f38926a, b.f38927b);
        } else {
            pair = new Pair(kotlinType, kotlinType);
        }
        KotlinType kotlinType2 = (KotlinType) pair.f25267a;
        KotlinType kotlinType3 = (KotlinType) pair.f25268b;
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.f25878a;
        MutabilityQualifier mutabilityQualifier = null;
        NullabilityQualifier nullabilityQualifier = kotlinType2.mo6741c() ? NullabilityQualifier.f25747a : !kotlinType3.mo6741c() ? NullabilityQualifier.f25748b : null;
        int i = 1;
        if (kotlinType2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isReadOnly"}));
        }
        ClassDescriptor f = TypeUtils.m28017f(kotlinType2);
        int i2 = (f == null || !javaToKotlinClassMap.m27445b(f)) ? 0 : 1;
        if (i2 != 0) {
            mutabilityQualifier = MutabilityQualifier.f25744a;
        } else if (kotlinType3 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap", "isMutable"}));
        } else {
            f = TypeUtils.m28017f(kotlinType3);
            if (f == null || !javaToKotlinClassMap.m27444a(f)) {
                i = 0;
            }
            if (i != 0) {
                mutabilityQualifier = MutabilityQualifier.f25745b;
            }
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, kotlinType.mo6738h() instanceof NotNullTypeParameter);
    }

    private static final JavaTypeQualifiers m27284b(KotlinType kotlinType) {
        TypeQualifiersKt$extractQualifiersFromAnnotations$1 typeQualifiersKt$extractQualifiersFromAnnotations$1 = new TypeQualifiersKt$extractQualifiersFromAnnotations$1(kotlinType);
        Object obj = (NullabilityQualifier) TypeQualifiersKt$extractQualifiersFromAnnotations$3.f38763a.mo6509a(typeQualifiersKt$extractQualifiersFromAnnotations$1.m38526a(JvmAnnotationNamesKt.m27158a(), NullabilityQualifier.f25747a), typeQualifiersKt$extractQualifiersFromAnnotations$1.m38526a(JvmAnnotationNamesKt.m27160c(), NullabilityQualifier.f25748b), new TypeQualifiersKt$extractQualifiersFromAnnotations$4(kotlinType).m38530a(JvmAnnotationNamesKt.m27159b()));
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) TypeQualifiersKt$extractQualifiersFromAnnotations$2.f38762a.mo6497a(typeQualifiersKt$extractQualifiersFromAnnotations$1.m38526a(JvmAnnotationNamesKt.m27161d(), MutabilityQualifier.f25744a), typeQualifiersKt$extractQualifiersFromAnnotations$1.m38526a(JvmAnnotationNamesKt.m27162e(), MutabilityQualifier.f25745b));
        kotlinType = (!Intrinsics.m26845a(obj, NullabilityQualifier.f25748b) || TypeUtilsKt.m28067d(kotlinType) == null) ? null : true;
        return new JavaTypeQualifiers(obj, mutabilityQualifier, kotlinType);
    }

    public static final Function1<Integer, JavaTypeQualifiers> m27282a(KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z) {
        JavaTypeQualifiers[] javaTypeQualifiersArr;
        int i;
        int i2;
        int i3;
        KotlinType kotlinType2;
        Collection arrayList;
        KotlinType kotlinType3;
        boolean z2;
        Intrinsics.m26847b(kotlinType, "$receiver");
        Intrinsics.m26847b(collection, "fromSupertypes");
        TypeQualifiersKt$computeIndexedQualifiersForOverride$1 typeQualifiersKt$computeIndexedQualifiersForOverride$1 = TypeQualifiersKt$computeIndexedQualifiersForOverride$1.f38756a;
        Iterable<KotlinType> iterable = collection;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (KotlinType kotlinType4 : iterable) {
            TypeQualifiersKt$computeIndexedQualifiersForOverride$1 typeQualifiersKt$computeIndexedQualifiersForOverride$12 = TypeQualifiersKt$computeIndexedQualifiersForOverride$1.f38756a;
            arrayList2.add(TypeQualifiersKt$computeIndexedQualifiersForOverride$1.m38516a(kotlinType4));
        }
        List<List> list = (List) arrayList2;
        List a = TypeQualifiersKt$computeIndexedQualifiersForOverride$1.m38516a(kotlinType);
        if (z) {
            for (KotlinType b : iterable) {
                if ((KotlinTypeChecker.f26349a.mo5936b(b, kotlinType) ^ 1) != 0) {
                    kotlinType = 1;
                    break;
                }
            }
            kotlinType = null;
            if (kotlinType != null) {
                kotlinType = 1;
                if (kotlinType == null) {
                    collection = 1;
                } else {
                    collection = a.size();
                }
                javaTypeQualifiersArr = new JavaTypeQualifiers[collection];
                collection -= 1;
                if (collection >= null) {
                    i = 0;
                    while (true) {
                        i2 = i != 0 ? 1 : 0;
                        if (i2 == 0) {
                            if (kotlinType == null) {
                                i3 = 0;
                                if (_Assertions.f25274a || r7 != 0) {
                                    kotlinType2 = (KotlinType) a.get(i);
                                    arrayList = new ArrayList();
                                    for (List c : list) {
                                        kotlinType3 = (KotlinType) CollectionsKt___CollectionsKt.m41425c(c, i);
                                        if (kotlinType3 == null) {
                                            arrayList.add(kotlinType3);
                                        }
                                    }
                                    arrayList = (List) arrayList;
                                    z2 = z && i2 != 0;
                                    javaTypeQualifiersArr[i] = m27285b(kotlinType2, arrayList, z2);
                                    if (i == collection) {
                                        break;
                                    }
                                    i++;
                                } else {
                                    throw ((Throwable) new AssertionError("Only head type constructors should be computed"));
                                }
                            }
                        }
                        i3 = 1;
                        if (_Assertions.f25274a) {
                        }
                        kotlinType2 = (KotlinType) a.get(i);
                        arrayList = new ArrayList();
                        while (r8.hasNext()) {
                            kotlinType3 = (KotlinType) CollectionsKt___CollectionsKt.m41425c(c, i);
                            if (kotlinType3 == null) {
                                arrayList.add(kotlinType3);
                            }
                        }
                        arrayList = (List) arrayList;
                        if (!z) {
                        }
                        javaTypeQualifiersArr[i] = m27285b(kotlinType2, arrayList, z2);
                        if (i == collection) {
                            break;
                        }
                        i++;
                    }
                }
                return (Function1) new TypeQualifiersKt$computeIndexedQualifiersForOverride$2((JavaTypeQualifiers[]) ((Object[]) javaTypeQualifiersArr));
            }
        }
        kotlinType = null;
        if (kotlinType == null) {
            collection = a.size();
        } else {
            collection = 1;
        }
        javaTypeQualifiersArr = new JavaTypeQualifiers[collection];
        collection -= 1;
        if (collection >= null) {
            i = 0;
            while (true) {
                if (i != 0) {
                }
                if (i2 == 0) {
                    if (kotlinType == null) {
                        i3 = 0;
                        if (_Assertions.f25274a) {
                        }
                        kotlinType2 = (KotlinType) a.get(i);
                        arrayList = new ArrayList();
                        while (r8.hasNext()) {
                            kotlinType3 = (KotlinType) CollectionsKt___CollectionsKt.m41425c(c, i);
                            if (kotlinType3 == null) {
                                arrayList.add(kotlinType3);
                            }
                        }
                        arrayList = (List) arrayList;
                        if (z) {
                        }
                        javaTypeQualifiersArr[i] = m27285b(kotlinType2, arrayList, z2);
                        if (i == collection) {
                            break;
                        }
                        i++;
                    }
                }
                i3 = 1;
                if (_Assertions.f25274a) {
                }
                kotlinType2 = (KotlinType) a.get(i);
                arrayList = new ArrayList();
                while (r8.hasNext()) {
                    kotlinType3 = (KotlinType) CollectionsKt___CollectionsKt.m41425c(c, i);
                    if (kotlinType3 == null) {
                        arrayList.add(kotlinType3);
                    }
                }
                arrayList = (List) arrayList;
                if (z) {
                }
                javaTypeQualifiersArr[i] = m27285b(kotlinType2, arrayList, z2);
                if (i == collection) {
                    break;
                }
                i++;
            }
        }
        return (Function1) new TypeQualifiersKt$computeIndexedQualifiersForOverride$2((JavaTypeQualifiers[]) ((Object[]) javaTypeQualifiersArr));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers m27285b(kotlin.reflect.jvm.internal.impl.types.KotlinType r5, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> r6, boolean r7) {
        /*
        r6 = (java.lang.Iterable) r6;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = (java.util.Collection) r0;
        r1 = r6.iterator();
    L_0x000d:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0025;
    L_0x0013:
        r2 = r1.next();
        r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2;
        r2 = m27283a(r2);
        r2 = r2.f25741a;
        if (r2 == 0) goto L_0x000d;
    L_0x0021:
        r0.add(r2);
        goto L_0x000d;
    L_0x0025:
        r0 = (java.util.List) r0;
        r0 = (java.lang.Iterable) r0;
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.m41451p(r0);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = (java.util.Collection) r1;
        r2 = r6.iterator();
    L_0x0038:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0050;
    L_0x003e:
        r3 = r2.next();
        r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3;
        r3 = m27283a(r3);
        r3 = r3.f25742b;
        if (r3 == 0) goto L_0x0038;
    L_0x004c:
        r1.add(r3);
        goto L_0x0038;
    L_0x0050:
        r1 = (java.util.List) r1;
        r1 = (java.lang.Iterable) r1;
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.m41451p(r1);
        r5 = m27284b(r5);
        r2 = r5.f25743c;
        r3 = 0;
        r4 = 1;
        if (r2 != 0) goto L_0x007f;
    L_0x0062:
        r6 = r6.iterator();
    L_0x0066:
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x007c;
    L_0x006c:
        r2 = r6.next();
        r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2;
        r2 = m27283a(r2);
        r2 = r2.f25743c;
        if (r2 == 0) goto L_0x0066;
    L_0x007a:
        r6 = r4;
        goto L_0x007d;
    L_0x007c:
        r6 = r3;
    L_0x007d:
        if (r6 == 0) goto L_0x0080;
    L_0x007f:
        r3 = r4;
    L_0x0080:
        r6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$1;
        r6.<init>(r3);
        if (r7 == 0) goto L_0x00a8;
    L_0x0087:
        r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$2.f38759a;
        r6 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$1) r6;
        r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.f25748b;
        r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.f25747a;
        r3 = r5.f25741a;
        r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$2.m38521a(r0, r7, r2, r3);
        r7 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier) r7;
        r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.f25745b;
        r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.f25744a;
        r5 = r5.f25742b;
        r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$2.m38521a(r1, r0, r2, r5);
        r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r5;
        r5 = r6.m38520a(r7, r5);
        return r5;
    L_0x00a8:
        r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$3.f38760a;
        r6 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$1) r6;
        r7 = r5.f25741a;
        r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$3.m38523a(r0, r7);
        r7 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier) r7;
        r5 = r5.f25742b;
        r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt$computeQualifiersForOverride$3.m38523a(r1, r5);
        r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r5;
        r5 = r6.m38520a(r7, r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeQualifiersKt.b(kotlin.reflect.jvm.internal.impl.types.KotlinType, java.util.Collection, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
    }
}
