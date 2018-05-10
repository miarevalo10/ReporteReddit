package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeKt {
    public static /* synthetic */ SimpleType m28028a(SimpleType simpleType, CaptureStatus captureStatus) {
        int i;
        Function2 c = FunctionsKt.m28107c();
        Intrinsics.m26847b(simpleType, "type");
        Intrinsics.m26847b(captureStatus, "status");
        Intrinsics.m26847b(c, "acceptNewCapturedType");
        List a = simpleType.mo6739a();
        Iterable<TypeProjection> iterable = a;
        for (TypeProjection b : iterable) {
            if (!Intrinsics.m26845a(b.mo6735b(), Variance.f26337a)) {
                i = 0;
                break;
            }
        }
        i = 1;
        if (i != 0) {
            return simpleType;
        }
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Object obj : iterable) {
            Object obj2;
            if (!Intrinsics.m26845a(obj2.mo6735b(), Variance.f26337a)) {
                UnwrappedType h = (obj2.mo6734a() || !Intrinsics.m26845a(obj2.mo6735b(), Variance.f26338b)) ? null : obj2.mo6736c().mo6738h();
                obj2 = TypeUtilsKt.m28068e(new NewCapturedType(captureStatus, h, (TypeProjection) obj2));
            }
            arrayList.add(obj2);
        }
        List list = (List) arrayList;
        captureStatus = TypeConstructorSubstitution.f33074b;
        captureStatus = Companion.m27971a(simpleType.mo6743g(), list).m27987d();
        int size = a.size() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                TypeProjection typeProjection = (TypeProjection) a.get(i2);
                TypeProjection typeProjection2 = (TypeProjection) list.get(i2);
                if (!Intrinsics.m26845a(typeProjection.mo6735b(), Variance.f26337a)) {
                    Iterable<KotlinType> j = ((TypeParameterDescriptor) simpleType.mo6743g().mo5723b().get(i2)).mo7715j();
                    Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(j));
                    for (KotlinType kotlinType : j) {
                        NewKotlinTypeChecker newKotlinTypeChecker = NewKotlinTypeChecker.f33078b;
                        arrayList2.add(NewKotlinTypeChecker.m33629a(captureStatus.m28002a(kotlinType, Variance.f26337a).mo6738h()));
                    }
                    List list2 = (List) arrayList2;
                    if (!typeProjection.mo6734a() && Intrinsics.m26845a(typeProjection.mo6735b(), Variance.f26339c)) {
                        arrayList2 = list2;
                        NewKotlinTypeChecker newKotlinTypeChecker2 = NewKotlinTypeChecker.f33078b;
                        list2 = CollectionsKt___CollectionsKt.m41419a(arrayList2, (Object) NewKotlinTypeChecker.m33629a(typeProjection.mo6736c().mo6738h()));
                    }
                    KotlinType c2 = typeProjection2.mo6736c();
                    if (c2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                    }
                    NewCapturedType newCapturedType = (NewCapturedType) c2;
                    NewCapturedTypeConstructor newCapturedTypeConstructor = newCapturedType.f39990a;
                    Intrinsics.m26847b(list2, "supertypes");
                    int i3 = newCapturedTypeConstructor.f33076a == null ? 1 : 0;
                    if (_Assertions.f25274a && i3 == 0) {
                        simpleType = new StringBuilder("Already initialized! oldValue = ");
                        simpleType.append(newCapturedTypeConstructor.f33076a);
                        simpleType.append(", newValue = ");
                        simpleType.append(list2);
                        throw ((Throwable) new AssertionError(simpleType.toString()));
                    }
                    newCapturedTypeConstructor.f33076a = list2;
                    c.mo6497a(Integer.valueOf(i2), newCapturedType);
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return KotlinTypeFactory.m27951a(simpleType.mo5718q(), simpleType.mo6743g(), list, simpleType.mo6741c());
    }
}
