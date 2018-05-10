package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewKotlinTypeChecker.kt */
public final class StrictEqualityTypeChecker {
    public static final StrictEqualityTypeChecker f26352a = null;

    static {
        StrictEqualityTypeChecker strictEqualityTypeChecker = new StrictEqualityTypeChecker();
    }

    private StrictEqualityTypeChecker() {
        f26352a = this;
    }

    public final boolean m28035a(UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.m26847b(unwrappedType, "a");
        Intrinsics.m26847b(unwrappedType2, "b");
        if (unwrappedType == unwrappedType2) {
            return true;
        }
        if ((unwrappedType instanceof SimpleType) && (unwrappedType2 instanceof SimpleType)) {
            return m28034a((SimpleType) unwrappedType, (SimpleType) unwrappedType2);
        }
        if (!(unwrappedType instanceof FlexibleType) || !(unwrappedType2 instanceof FlexibleType)) {
            return false;
        }
        FlexibleType flexibleType = (FlexibleType) unwrappedType;
        FlexibleType flexibleType2 = (FlexibleType) unwrappedType2;
        if (!m28034a(flexibleType.f38926a, flexibleType2.f38926a) || m28034a(flexibleType.f38927b, flexibleType2.f38927b) == null) {
            return false;
        }
        return true;
    }

    public final boolean m28034a(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(simpleType, "a");
        Intrinsics.m26847b(simpleType2, "b");
        if (simpleType.mo6741c() == simpleType2.mo6741c() && (Intrinsics.m26845a(simpleType.mo6743g(), simpleType2.mo6743g()) ^ 1) == 0) {
            if (simpleType.mo6739a().size() == simpleType2.mo6739a().size()) {
                int size = simpleType.mo6739a().size() - 1;
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        TypeProjection typeProjection = (TypeProjection) simpleType.mo6739a().get(i);
                        TypeProjection typeProjection2 = (TypeProjection) simpleType2.mo6739a().get(i);
                        if (typeProjection.mo6734a() != typeProjection2.mo6734a()) {
                            return false;
                        }
                        if (typeProjection.mo6734a() || ((Intrinsics.m26845a(typeProjection.mo6735b(), typeProjection2.mo6735b()) ^ 1) == 0 && m28035a(typeProjection.mo6736c().mo6738h(), typeProjection2.mo6736c().mo6738h()))) {
                            if (i == size) {
                                break;
                            }
                            i++;
                        } else {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
