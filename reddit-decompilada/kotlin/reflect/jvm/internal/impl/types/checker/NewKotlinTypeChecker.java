package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.LowerIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.UpperIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NewKotlinTypeChecker implements KotlinTypeChecker {
    public static final NewKotlinTypeChecker f33078b = null;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26350a;

        static {
            int[] iArr = new int[Variance.values().length];
            f26350a = iArr;
            iArr[Variance.f26337a.ordinal()] = 1;
            f26350a[Variance.f26339c.ordinal()] = 2;
            f26350a[Variance.f26338b.ordinal()] = 3;
        }
    }

    static {
        NewKotlinTypeChecker newKotlinTypeChecker = new NewKotlinTypeChecker();
    }

    private NewKotlinTypeChecker() {
        f33078b = this;
    }

    public final boolean mo5935a(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.m26847b(kotlinType, "subtype");
        Intrinsics.m26847b(kotlinType2, "supertype");
        return f33078b.m33635b(new TypeCheckerContext(true), kotlinType.mo6738h(), kotlinType2.mo6738h());
    }

    public final boolean mo5936b(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.m26847b(kotlinType, "a");
        Intrinsics.m26847b(kotlinType2, "b");
        return f33078b.m33633a(new TypeCheckerContext(false), kotlinType.mo6738h(), kotlinType2.mo6738h());
    }

    private boolean m33633a(TypeCheckerContext typeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.m26847b(typeCheckerContext, "$receiver");
        Intrinsics.m26847b(unwrappedType, "a");
        Intrinsics.m26847b(unwrappedType2, "b");
        if (unwrappedType == unwrappedType2) {
            return true;
        }
        return (!m33635b(typeCheckerContext, unwrappedType, unwrappedType2) || m33635b(typeCheckerContext, unwrappedType2, unwrappedType) == null) ? null : true;
    }

    private boolean m33635b(TypeCheckerContext typeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.m26847b(typeCheckerContext, "$receiver");
        Intrinsics.m26847b(unwrappedType, "subType");
        Intrinsics.m26847b(unwrappedType2, "superType");
        unwrappedType = m33629a(unwrappedType);
        unwrappedType2 = m33629a(unwrappedType2);
        KotlinType kotlinType = unwrappedType;
        SimpleType c = FlexibleTypesKt.m27948c(kotlinType);
        KotlinType kotlinType2 = unwrappedType2;
        SimpleType d = FlexibleTypesKt.m27949d(kotlinType2);
        Boolean bool = null;
        boolean z = false;
        if (!c.mo6742d()) {
            if (!d.mo6742d()) {
                if (d instanceof NewCapturedType) {
                    NewCapturedType newCapturedType = (NewCapturedType) d;
                    if (newCapturedType.f39991b != null && m33635b(typeCheckerContext, (UnwrappedType) c, newCapturedType.f39991b)) {
                        bool = Boolean.valueOf(true);
                        if (bool == null) {
                            return bool.booleanValue();
                        }
                        TypeCheckerContext.m28038a(unwrappedType, unwrappedType2);
                        return m33632a(typeCheckerContext, FlexibleTypesKt.m27948c(kotlinType), FlexibleTypesKt.m27949d(kotlinType2));
                    }
                }
                TypeConstructor g = d.mo6743g();
                if (!(g instanceof IntersectionTypeConstructor)) {
                    g = null;
                }
                IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) g;
                if (intersectionTypeConstructor != null) {
                    intersectionTypeConstructor = intersectionTypeConstructor;
                    int c2 = d.mo6741c() ^ 1;
                    if (_Assertions.f25274a && c2 == 0) {
                        typeCheckerContext = new StringBuilder("Intersection type should not be marked nullable!: ");
                        typeCheckerContext.append(d);
                        throw ((Throwable) new AssertionError(typeCheckerContext.toString()));
                    }
                    for (KotlinType h : intersectionTypeConstructor.aL_()) {
                        if (!f33078b.m33635b(typeCheckerContext, (UnwrappedType) c, h.mo6738h())) {
                            break;
                        }
                    }
                    z = true;
                    bool = Boolean.valueOf(z);
                }
                if (bool == null) {
                    return bool.booleanValue();
                }
                TypeCheckerContext.m28038a(unwrappedType, unwrappedType2);
                return m33632a(typeCheckerContext, FlexibleTypesKt.m27948c(kotlinType), FlexibleTypesKt.m27949d(kotlinType2));
            }
        }
        if (typeCheckerContext.f26355a) {
            bool = Boolean.valueOf(true);
        } else if (!c.mo6741c() || d.mo6741c()) {
            bool = Boolean.valueOf(StrictEqualityTypeChecker.f26352a.m28034a(c.mo7297b(false), d.mo7297b(false)));
        } else {
            bool = Boolean.valueOf(false);
        }
        if (bool == null) {
            return bool.booleanValue();
        }
        TypeCheckerContext.m28038a(unwrappedType, unwrappedType2);
        return m33632a(typeCheckerContext, FlexibleTypesKt.m27948c(kotlinType), FlexibleTypesKt.m27949d(kotlinType2));
    }

    private static SimpleType m33628a(SimpleType simpleType) {
        Intrinsics.m26847b(simpleType, "type");
        if (simpleType instanceof CapturedType) {
            UnwrappedType h;
            UnwrappedType unwrappedType;
            CapturedTypeConstructor capturedTypeConstructor;
            TypeProjection typeProjection;
            Iterable<KotlinType> aL_;
            Collection arrayList;
            CaptureStatus captureStatus;
            NewCapturedTypeConstructor newCapturedTypeConstructor;
            CapturedType capturedType = (CapturedType) simpleType;
            TypeProjection typeProjection2 = (TypeProjection) AddToStdlibKt.m28126a(capturedType.f39733a, NewKotlinTypeChecker$transformToNewType$lowerType$1.f38939a);
            if (typeProjection2 != null) {
                KotlinType c = typeProjection2.mo6736c();
                if (c != null) {
                    h = c.mo6738h();
                    unwrappedType = h;
                    if (capturedType.f39734b.f32934a == null) {
                        capturedTypeConstructor = capturedType.f39734b;
                        typeProjection = capturedType.f39733a;
                        aL_ = capturedType.f39734b.aL_();
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(aL_));
                        for (KotlinType h2 : aL_) {
                            arrayList.add(h2.mo6738h());
                        }
                        capturedTypeConstructor.f32934a = new NewCapturedTypeConstructor(typeProjection, (List) arrayList);
                    }
                    captureStatus = CaptureStatus.f26346a;
                    newCapturedTypeConstructor = capturedType.f39734b.f32934a;
                    if (newCapturedTypeConstructor == null) {
                        Intrinsics.m26842a();
                    }
                    return new NewCapturedType(captureStatus, newCapturedTypeConstructor, unwrappedType, simpleType.mo5718q(), simpleType.mo6741c());
                }
            }
            h = null;
            unwrappedType = h;
            if (capturedType.f39734b.f32934a == null) {
                capturedTypeConstructor = capturedType.f39734b;
                typeProjection = capturedType.f39733a;
                aL_ = capturedType.f39734b.aL_();
                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(aL_));
                while (r4.hasNext()) {
                    arrayList.add(h2.mo6738h());
                }
                capturedTypeConstructor.f32934a = new NewCapturedTypeConstructor(typeProjection, (List) arrayList);
            }
            captureStatus = CaptureStatus.f26346a;
            newCapturedTypeConstructor = capturedType.f39734b.f32934a;
            if (newCapturedTypeConstructor == null) {
                Intrinsics.m26842a();
            }
            return new NewCapturedType(captureStatus, newCapturedTypeConstructor, unwrappedType, simpleType.mo5718q(), simpleType.mo6741c());
        } else if ((simpleType.mo6743g() instanceof IntersectionTypeConstructor) && simpleType.mo6741c()) {
            Iterable<KotlinType> aL_2 = simpleType.mo6743g().aL_();
            Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(aL_2));
            for (KotlinType b : aL_2) {
                arrayList2.add(TypeUtilsKt.m28065b(b));
            }
            IntersectionTypeConstructor intersectionTypeConstructor = new IntersectionTypeConstructor((List) arrayList2);
            simpleType = simpleType.mo5718q();
            TypeConstructor typeConstructor = intersectionTypeConstructor;
            List a = CollectionsKt__CollectionsKt.m26790a();
            Object f = intersectionTypeConstructor.m33606f();
            Intrinsics.m26843a(f, "newConstructor.createScopeForKotlinType()");
            return KotlinTypeFactory.m27952a(simpleType, typeConstructor, a, false, f);
        } else if (!(simpleType.mo6743g() instanceof IntegerValueTypeConstructor)) {
            return simpleType;
        } else {
            Iterable<KotlinType> aL_3 = simpleType.mo6743g().aL_();
            Collection arrayList3 = new ArrayList(CollectionsKt__IterablesKt.m32812b(aL_3));
            for (KotlinType a2 : aL_3) {
                arrayList3.add(TypeUtils.m28007a(a2, simpleType.mo6741c()));
            }
            return KotlinTypeFactory.m27952a(simpleType.mo5718q(), new IntersectionTypeConstructor((List) arrayList3), CollectionsKt__CollectionsKt.m26790a(), false, simpleType.mo6740b());
        }
    }

    public static UnwrappedType m33629a(UnwrappedType unwrappedType) {
        Intrinsics.m26847b(unwrappedType, "type");
        if (unwrappedType instanceof SimpleType) {
            return m33628a((SimpleType) unwrappedType);
        }
        if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType;
            SimpleType a = m33628a(flexibleType.f38926a);
            SimpleType a2 = m33628a(flexibleType.f38927b);
            if (a == flexibleType.f38926a) {
                if (a2 == flexibleType.f38927b) {
                    return unwrappedType;
                }
            }
            return KotlinTypeFactory.m27953a(a, a2);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static boolean m33631a(TypeCheckerContext typeCheckerContext, SimpleType simpleType) {
        return typeCheckerContext.m28041a(simpleType, NewKotlinTypeChecker$hasNothingSupertype$1.f38936a, NewKotlinTypeChecker$hasNothingSupertype$2.f38937a);
    }

    private static boolean m33632a(TypeCheckerContext typeCheckerContext, SimpleType simpleType, SimpleType simpleType2) {
        int i;
        boolean b;
        NullabilityChecker nullabilityChecker;
        TypeConstructor g;
        List b2;
        Iterable<SimpleType> iterable;
        boolean z;
        Iterable b3;
        Collection arrayList;
        Iterator it;
        int i2;
        Collection arrayList2;
        TypeProjection typeProjection;
        KotlinType c;
        UnwrappedType h;
        int i3 = 0;
        if (!NewKotlinTypeCheckerKt.m28030b(simpleType)) {
            if (!(simpleType.mo6743g() instanceof IntersectionTypeConstructor)) {
                i = 0;
                if (_Assertions.f25274a || r0 != 0) {
                    b = NewKotlinTypeCheckerKt.m28030b(simpleType2);
                    if (_Assertions.f25274a || b) {
                        nullabilityChecker = NullabilityChecker.f26351a;
                        Intrinsics.m26847b(typeCheckerContext, "context");
                        Intrinsics.m26847b(simpleType, "subType");
                        Intrinsics.m26847b(simpleType2, "superType");
                        if (!(simpleType.mo6743g() instanceof IntersectionTypeConstructor)) {
                            if (NewKotlinTypeCheckerKt.m28030b(simpleType)) {
                                i = 0;
                                if (_Assertions.f25274a || r0 != 0) {
                                    b = NewKotlinTypeCheckerKt.m28030b(simpleType2);
                                    if (_Assertions.f25274a || b) {
                                        if (!simpleType2.mo6741c()) {
                                            if (!NullabilityChecker.m28033a(typeCheckerContext, simpleType, (SupertypesPolicy) LowerIfFlexible.f33079a)) {
                                                if (!NullabilityChecker.m28033a(typeCheckerContext, simpleType2, (SupertypesPolicy) UpperIfFlexible.f33082a)) {
                                                    if (!(simpleType.mo6743g().mo5724c() instanceof ClassDescriptor)) {
                                                        b = NullabilityChecker.m28032a(typeCheckerContext, simpleType, simpleType2.mo6743g());
                                                        if (b) {
                                                            return false;
                                                        }
                                                        g = simpleType2.mo6743g();
                                                        b2 = m33634b(typeCheckerContext, simpleType, g);
                                                        switch (b2.size()) {
                                                            case 0:
                                                                return m33631a(typeCheckerContext, simpleType);
                                                            case 1:
                                                                return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                                                            default:
                                                                iterable = b2;
                                                                for (SimpleType a : iterable) {
                                                                    if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                                                        z = true;
                                                                        if (!z) {
                                                                            return true;
                                                                        }
                                                                        b3 = g.mo5723b();
                                                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                                        it = b3.iterator();
                                                                        while (it.hasNext()) {
                                                                            it.next();
                                                                            i2 = i3 + 1;
                                                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                                            for (SimpleType simpleType3 : iterable) {
                                                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3.mo6739a(), i3);
                                                                                if (typeProjection == null) {
                                                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                                                    if (typeProjection == null) {
                                                                                        c = typeProjection.mo6736c();
                                                                                        if (c == null) {
                                                                                            h = c.mo6738h();
                                                                                            if (h != null) {
                                                                                                arrayList2.add(h);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                                                typeCheckerContext.append(simpleType3);
                                                                                typeCheckerContext.append(", subType: ");
                                                                                typeCheckerContext.append(simpleType);
                                                                                typeCheckerContext.append(", superType: ");
                                                                                typeCheckerContext.append(simpleType2);
                                                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                                            }
                                                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                                            i3 = i2;
                                                                        }
                                                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                                                    }
                                                                }
                                                                z = false;
                                                                if (!z) {
                                                                    return true;
                                                                }
                                                                b3 = g.mo5723b();
                                                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                                it = b3.iterator();
                                                                while (it.hasNext()) {
                                                                    it.next();
                                                                    i2 = i3 + 1;
                                                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                                    for (SimpleType simpleType32 : iterable) {
                                                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32.mo6739a(), i3);
                                                                        if (typeProjection == null) {
                                                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                                            if (typeProjection == null) {
                                                                                c = typeProjection.mo6736c();
                                                                                if (c == null) {
                                                                                    h = c.mo6738h();
                                                                                    if (h != null) {
                                                                                        arrayList2.add(h);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                                        typeCheckerContext.append(simpleType32);
                                                                        typeCheckerContext.append(", subType: ");
                                                                        typeCheckerContext.append(simpleType);
                                                                        typeCheckerContext.append(", superType: ");
                                                                        typeCheckerContext.append(simpleType2);
                                                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                                    }
                                                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                                    i3 = i2;
                                                                }
                                                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                                        }
                                                    }
                                                }
                                                b = false;
                                                if (b) {
                                                    return false;
                                                }
                                                g = simpleType2.mo6743g();
                                                b2 = m33634b(typeCheckerContext, simpleType, g);
                                                switch (b2.size()) {
                                                    case 0:
                                                        return m33631a(typeCheckerContext, simpleType);
                                                    case 1:
                                                        return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                                                    default:
                                                        iterable = b2;
                                                        while (r4.hasNext()) {
                                                            if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                                                z = true;
                                                                if (!z) {
                                                                    return true;
                                                                }
                                                                b3 = g.mo5723b();
                                                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                                it = b3.iterator();
                                                                while (it.hasNext()) {
                                                                    it.next();
                                                                    i2 = i3 + 1;
                                                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                                    for (SimpleType simpleType322 : iterable) {
                                                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322.mo6739a(), i3);
                                                                        if (typeProjection == null) {
                                                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                                            if (typeProjection == null) {
                                                                                c = typeProjection.mo6736c();
                                                                                if (c == null) {
                                                                                    h = c.mo6738h();
                                                                                    if (h != null) {
                                                                                        arrayList2.add(h);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                                        typeCheckerContext.append(simpleType322);
                                                                        typeCheckerContext.append(", subType: ");
                                                                        typeCheckerContext.append(simpleType);
                                                                        typeCheckerContext.append(", superType: ");
                                                                        typeCheckerContext.append(simpleType2);
                                                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                                    }
                                                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                                    i3 = i2;
                                                                }
                                                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                                            }
                                                        }
                                                        z = false;
                                                        if (!z) {
                                                            return true;
                                                        }
                                                        b3 = g.mo5723b();
                                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                        it = b3.iterator();
                                                        while (it.hasNext()) {
                                                            it.next();
                                                            i2 = i3 + 1;
                                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                            for (SimpleType simpleType3222 : iterable) {
                                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3222.mo6739a(), i3);
                                                                if (typeProjection == null) {
                                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                                    if (typeProjection == null) {
                                                                        c = typeProjection.mo6736c();
                                                                        if (c == null) {
                                                                            h = c.mo6738h();
                                                                            if (h != null) {
                                                                                arrayList2.add(h);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                                typeCheckerContext.append(simpleType3222);
                                                                typeCheckerContext.append(", subType: ");
                                                                typeCheckerContext.append(simpleType);
                                                                typeCheckerContext.append(", superType: ");
                                                                typeCheckerContext.append(simpleType2);
                                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                            }
                                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                            i3 = i2;
                                                        }
                                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                                }
                                            }
                                        }
                                        b = true;
                                        if (b) {
                                            return false;
                                        }
                                        g = simpleType2.mo6743g();
                                        b2 = m33634b(typeCheckerContext, simpleType, g);
                                        switch (b2.size()) {
                                            case 0:
                                                return m33631a(typeCheckerContext, simpleType);
                                            case 1:
                                                return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                                            default:
                                                iterable = b2;
                                                while (r4.hasNext()) {
                                                    if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                                        z = true;
                                                        if (!z) {
                                                            return true;
                                                        }
                                                        b3 = g.mo5723b();
                                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                        it = b3.iterator();
                                                        while (it.hasNext()) {
                                                            it.next();
                                                            i2 = i3 + 1;
                                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                            for (SimpleType simpleType32222 : iterable) {
                                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32222.mo6739a(), i3);
                                                                if (typeProjection == null) {
                                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                                    if (typeProjection == null) {
                                                                        c = typeProjection.mo6736c();
                                                                        if (c == null) {
                                                                            h = c.mo6738h();
                                                                            if (h != null) {
                                                                                arrayList2.add(h);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                                typeCheckerContext.append(simpleType32222);
                                                                typeCheckerContext.append(", subType: ");
                                                                typeCheckerContext.append(simpleType);
                                                                typeCheckerContext.append(", superType: ");
                                                                typeCheckerContext.append(simpleType2);
                                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                            }
                                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                            i3 = i2;
                                                        }
                                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                                    }
                                                }
                                                z = false;
                                                if (!z) {
                                                    return true;
                                                }
                                                b3 = g.mo5723b();
                                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                it = b3.iterator();
                                                while (it.hasNext()) {
                                                    it.next();
                                                    i2 = i3 + 1;
                                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                    for (SimpleType simpleType322222 : iterable) {
                                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322222.mo6739a(), i3);
                                                        if (typeProjection == null) {
                                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                            if (typeProjection == null) {
                                                                c = typeProjection.mo6736c();
                                                                if (c == null) {
                                                                    h = c.mo6738h();
                                                                    if (h != null) {
                                                                        arrayList2.add(h);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                        typeCheckerContext.append(simpleType322222);
                                                        typeCheckerContext.append(", subType: ");
                                                        typeCheckerContext.append(simpleType);
                                                        typeCheckerContext.append(", superType: ");
                                                        typeCheckerContext.append(simpleType2);
                                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                    }
                                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                    i3 = i2;
                                                }
                                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                        }
                                    }
                                    typeCheckerContext = new StringBuilder("Not singleClassifierType superType: ");
                                    typeCheckerContext.append(simpleType2);
                                    throw ((Throwable) new AssertionError(typeCheckerContext.toString()));
                                }
                                typeCheckerContext = new StringBuilder("Not singleClassifierType superType: ");
                                typeCheckerContext.append(simpleType2);
                                throw ((Throwable) new AssertionError(typeCheckerContext.toString()));
                            }
                        }
                        i = true;
                        if (_Assertions.f25274a) {
                        }
                        b = NewKotlinTypeCheckerKt.m28030b(simpleType2);
                        if (_Assertions.f25274a) {
                        }
                        if (simpleType2.mo6741c()) {
                            if (!NullabilityChecker.m28033a(typeCheckerContext, simpleType, (SupertypesPolicy) LowerIfFlexible.f33079a)) {
                                if (NullabilityChecker.m28033a(typeCheckerContext, simpleType2, (SupertypesPolicy) UpperIfFlexible.f33082a)) {
                                    if (!(simpleType.mo6743g().mo5724c() instanceof ClassDescriptor)) {
                                        b = NullabilityChecker.m28032a(typeCheckerContext, simpleType, simpleType2.mo6743g());
                                        if (b) {
                                            return false;
                                        }
                                        g = simpleType2.mo6743g();
                                        b2 = m33634b(typeCheckerContext, simpleType, g);
                                        switch (b2.size()) {
                                            case 0:
                                                return m33631a(typeCheckerContext, simpleType);
                                            case 1:
                                                return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                                            default:
                                                iterable = b2;
                                                while (r4.hasNext()) {
                                                    if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                                        z = true;
                                                        if (!z) {
                                                            return true;
                                                        }
                                                        b3 = g.mo5723b();
                                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                        it = b3.iterator();
                                                        while (it.hasNext()) {
                                                            it.next();
                                                            i2 = i3 + 1;
                                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                            for (SimpleType simpleType3222222 : iterable) {
                                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3222222.mo6739a(), i3);
                                                                if (typeProjection == null) {
                                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                                    if (typeProjection == null) {
                                                                        c = typeProjection.mo6736c();
                                                                        if (c == null) {
                                                                            h = c.mo6738h();
                                                                            if (h != null) {
                                                                                arrayList2.add(h);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                                typeCheckerContext.append(simpleType3222222);
                                                                typeCheckerContext.append(", subType: ");
                                                                typeCheckerContext.append(simpleType);
                                                                typeCheckerContext.append(", superType: ");
                                                                typeCheckerContext.append(simpleType2);
                                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                            }
                                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                            i3 = i2;
                                                        }
                                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                                    }
                                                }
                                                z = false;
                                                if (!z) {
                                                    return true;
                                                }
                                                b3 = g.mo5723b();
                                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                it = b3.iterator();
                                                while (it.hasNext()) {
                                                    it.next();
                                                    i2 = i3 + 1;
                                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                    for (SimpleType simpleType32222222 : iterable) {
                                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32222222.mo6739a(), i3);
                                                        if (typeProjection == null) {
                                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                            if (typeProjection == null) {
                                                                c = typeProjection.mo6736c();
                                                                if (c == null) {
                                                                    h = c.mo6738h();
                                                                    if (h != null) {
                                                                        arrayList2.add(h);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                        typeCheckerContext.append(simpleType32222222);
                                                        typeCheckerContext.append(", subType: ");
                                                        typeCheckerContext.append(simpleType);
                                                        typeCheckerContext.append(", superType: ");
                                                        typeCheckerContext.append(simpleType2);
                                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                    }
                                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                    i3 = i2;
                                                }
                                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                        }
                                    }
                                }
                                b = false;
                                if (b) {
                                    return false;
                                }
                                g = simpleType2.mo6743g();
                                b2 = m33634b(typeCheckerContext, simpleType, g);
                                switch (b2.size()) {
                                    case 0:
                                        return m33631a(typeCheckerContext, simpleType);
                                    case 1:
                                        return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                                    default:
                                        iterable = b2;
                                        while (r4.hasNext()) {
                                            if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                                z = true;
                                                if (!z) {
                                                    return true;
                                                }
                                                b3 = g.mo5723b();
                                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                it = b3.iterator();
                                                while (it.hasNext()) {
                                                    it.next();
                                                    i2 = i3 + 1;
                                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                    for (SimpleType simpleType322222222 : iterable) {
                                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322222222.mo6739a(), i3);
                                                        if (typeProjection == null) {
                                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                            if (typeProjection == null) {
                                                                c = typeProjection.mo6736c();
                                                                if (c == null) {
                                                                    h = c.mo6738h();
                                                                    if (h != null) {
                                                                        arrayList2.add(h);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                        typeCheckerContext.append(simpleType322222222);
                                                        typeCheckerContext.append(", subType: ");
                                                        typeCheckerContext.append(simpleType);
                                                        typeCheckerContext.append(", superType: ");
                                                        typeCheckerContext.append(simpleType2);
                                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                    }
                                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                    i3 = i2;
                                                }
                                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                            }
                                        }
                                        z = false;
                                        if (!z) {
                                            return true;
                                        }
                                        b3 = g.mo5723b();
                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                        it = b3.iterator();
                                        while (it.hasNext()) {
                                            it.next();
                                            i2 = i3 + 1;
                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                            for (SimpleType simpleType3222222222 : iterable) {
                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3222222222.mo6739a(), i3);
                                                if (typeProjection == null) {
                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                    if (typeProjection == null) {
                                                        c = typeProjection.mo6736c();
                                                        if (c == null) {
                                                            h = c.mo6738h();
                                                            if (h != null) {
                                                                arrayList2.add(h);
                                                            }
                                                        }
                                                    }
                                                }
                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                typeCheckerContext.append(simpleType3222222222);
                                                typeCheckerContext.append(", subType: ");
                                                typeCheckerContext.append(simpleType);
                                                typeCheckerContext.append(", superType: ");
                                                typeCheckerContext.append(simpleType2);
                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                            }
                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                            i3 = i2;
                                        }
                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                }
                            }
                        }
                        b = true;
                        if (b) {
                            return false;
                        }
                        g = simpleType2.mo6743g();
                        b2 = m33634b(typeCheckerContext, simpleType, g);
                        switch (b2.size()) {
                            case 0:
                                return m33631a(typeCheckerContext, simpleType);
                            case 1:
                                return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                            default:
                                iterable = b2;
                                while (r4.hasNext()) {
                                    if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                        z = true;
                                        if (!z) {
                                            return true;
                                        }
                                        b3 = g.mo5723b();
                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                        it = b3.iterator();
                                        while (it.hasNext()) {
                                            it.next();
                                            i2 = i3 + 1;
                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                            for (SimpleType simpleType32222222222 : iterable) {
                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32222222222.mo6739a(), i3);
                                                if (typeProjection == null) {
                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                    if (typeProjection == null) {
                                                        c = typeProjection.mo6736c();
                                                        if (c == null) {
                                                            h = c.mo6738h();
                                                            if (h != null) {
                                                                arrayList2.add(h);
                                                            }
                                                        }
                                                    }
                                                }
                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                typeCheckerContext.append(simpleType32222222222);
                                                typeCheckerContext.append(", subType: ");
                                                typeCheckerContext.append(simpleType);
                                                typeCheckerContext.append(", superType: ");
                                                typeCheckerContext.append(simpleType2);
                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                            }
                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                            i3 = i2;
                                        }
                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                    }
                                }
                                z = false;
                                if (!z) {
                                    return true;
                                }
                                b3 = g.mo5723b();
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                it = b3.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    i2 = i3 + 1;
                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                    for (SimpleType simpleType322222222222 : iterable) {
                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322222222222.mo6739a(), i3);
                                        if (typeProjection == null) {
                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                            if (typeProjection == null) {
                                                c = typeProjection.mo6736c();
                                                if (c == null) {
                                                    h = c.mo6738h();
                                                    if (h != null) {
                                                        arrayList2.add(h);
                                                    }
                                                }
                                            }
                                        }
                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                        typeCheckerContext.append(simpleType322222222222);
                                        typeCheckerContext.append(", subType: ");
                                        typeCheckerContext.append(simpleType);
                                        typeCheckerContext.append(", superType: ");
                                        typeCheckerContext.append(simpleType2);
                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                    }
                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                    i3 = i2;
                                }
                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                        }
                    }
                    typeCheckerContext = new StringBuilder("Not singleClassifierType superType: ");
                    typeCheckerContext.append(simpleType2);
                    throw ((Throwable) new AssertionError(typeCheckerContext.toString()));
                }
                typeCheckerContext = new StringBuilder("Not singleClassifierType and not intersection subType: ");
                typeCheckerContext.append(simpleType);
                throw ((Throwable) new AssertionError(typeCheckerContext.toString()));
            }
        }
        i = true;
        if (_Assertions.f25274a) {
        }
        b = NewKotlinTypeCheckerKt.m28030b(simpleType2);
        if (_Assertions.f25274a) {
        }
        nullabilityChecker = NullabilityChecker.f26351a;
        Intrinsics.m26847b(typeCheckerContext, "context");
        Intrinsics.m26847b(simpleType, "subType");
        Intrinsics.m26847b(simpleType2, "superType");
        if ((simpleType.mo6743g() instanceof IntersectionTypeConstructor)) {
            if (NewKotlinTypeCheckerKt.m28030b(simpleType)) {
                i = 0;
                if (_Assertions.f25274a) {
                }
                b = NewKotlinTypeCheckerKt.m28030b(simpleType2);
                if (_Assertions.f25274a) {
                }
                if (simpleType2.mo6741c()) {
                    if (!NullabilityChecker.m28033a(typeCheckerContext, simpleType, (SupertypesPolicy) LowerIfFlexible.f33079a)) {
                        if (NullabilityChecker.m28033a(typeCheckerContext, simpleType2, (SupertypesPolicy) UpperIfFlexible.f33082a)) {
                            if (!(simpleType.mo6743g().mo5724c() instanceof ClassDescriptor)) {
                                b = NullabilityChecker.m28032a(typeCheckerContext, simpleType, simpleType2.mo6743g());
                                if (b) {
                                    return false;
                                }
                                g = simpleType2.mo6743g();
                                b2 = m33634b(typeCheckerContext, simpleType, g);
                                switch (b2.size()) {
                                    case 0:
                                        return m33631a(typeCheckerContext, simpleType);
                                    case 1:
                                        return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                                    default:
                                        iterable = b2;
                                        while (r4.hasNext()) {
                                            if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                                z = true;
                                                if (!z) {
                                                    return true;
                                                }
                                                b3 = g.mo5723b();
                                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                                it = b3.iterator();
                                                while (it.hasNext()) {
                                                    it.next();
                                                    i2 = i3 + 1;
                                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                                    for (SimpleType simpleType3222222222222 : iterable) {
                                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3222222222222.mo6739a(), i3);
                                                        if (typeProjection == null) {
                                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                            if (typeProjection == null) {
                                                                c = typeProjection.mo6736c();
                                                                if (c == null) {
                                                                    h = c.mo6738h();
                                                                    if (h != null) {
                                                                        arrayList2.add(h);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                        typeCheckerContext.append(simpleType3222222222222);
                                                        typeCheckerContext.append(", subType: ");
                                                        typeCheckerContext.append(simpleType);
                                                        typeCheckerContext.append(", superType: ");
                                                        typeCheckerContext.append(simpleType2);
                                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                                    }
                                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                                    i3 = i2;
                                                }
                                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                            }
                                        }
                                        z = false;
                                        if (!z) {
                                            return true;
                                        }
                                        b3 = g.mo5723b();
                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                        it = b3.iterator();
                                        while (it.hasNext()) {
                                            it.next();
                                            i2 = i3 + 1;
                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                            for (SimpleType simpleType32222222222222 : iterable) {
                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32222222222222.mo6739a(), i3);
                                                if (typeProjection == null) {
                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                    if (typeProjection == null) {
                                                        c = typeProjection.mo6736c();
                                                        if (c == null) {
                                                            h = c.mo6738h();
                                                            if (h != null) {
                                                                arrayList2.add(h);
                                                            }
                                                        }
                                                    }
                                                }
                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                typeCheckerContext.append(simpleType32222222222222);
                                                typeCheckerContext.append(", subType: ");
                                                typeCheckerContext.append(simpleType);
                                                typeCheckerContext.append(", superType: ");
                                                typeCheckerContext.append(simpleType2);
                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                            }
                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                            i3 = i2;
                                        }
                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                }
                            }
                        }
                        b = false;
                        if (b) {
                            return false;
                        }
                        g = simpleType2.mo6743g();
                        b2 = m33634b(typeCheckerContext, simpleType, g);
                        switch (b2.size()) {
                            case 0:
                                return m33631a(typeCheckerContext, simpleType);
                            case 1:
                                return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                            default:
                                iterable = b2;
                                while (r4.hasNext()) {
                                    if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                        z = true;
                                        if (!z) {
                                            return true;
                                        }
                                        b3 = g.mo5723b();
                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                        it = b3.iterator();
                                        while (it.hasNext()) {
                                            it.next();
                                            i2 = i3 + 1;
                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                            for (SimpleType simpleType322222222222222 : iterable) {
                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322222222222222.mo6739a(), i3);
                                                if (typeProjection == null) {
                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                    if (typeProjection == null) {
                                                        c = typeProjection.mo6736c();
                                                        if (c == null) {
                                                            h = c.mo6738h();
                                                            if (h != null) {
                                                                arrayList2.add(h);
                                                            }
                                                        }
                                                    }
                                                }
                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                typeCheckerContext.append(simpleType322222222222222);
                                                typeCheckerContext.append(", subType: ");
                                                typeCheckerContext.append(simpleType);
                                                typeCheckerContext.append(", superType: ");
                                                typeCheckerContext.append(simpleType2);
                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                            }
                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                            i3 = i2;
                                        }
                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                    }
                                }
                                z = false;
                                if (!z) {
                                    return true;
                                }
                                b3 = g.mo5723b();
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                it = b3.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    i2 = i3 + 1;
                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                    for (SimpleType simpleType3222222222222222 : iterable) {
                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3222222222222222.mo6739a(), i3);
                                        if (typeProjection == null) {
                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                            if (typeProjection == null) {
                                                c = typeProjection.mo6736c();
                                                if (c == null) {
                                                    h = c.mo6738h();
                                                    if (h != null) {
                                                        arrayList2.add(h);
                                                    }
                                                }
                                            }
                                        }
                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                        typeCheckerContext.append(simpleType3222222222222222);
                                        typeCheckerContext.append(", subType: ");
                                        typeCheckerContext.append(simpleType);
                                        typeCheckerContext.append(", superType: ");
                                        typeCheckerContext.append(simpleType2);
                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                    }
                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                    i3 = i2;
                                }
                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                        }
                    }
                }
                b = true;
                if (b) {
                    return false;
                }
                g = simpleType2.mo6743g();
                b2 = m33634b(typeCheckerContext, simpleType, g);
                switch (b2.size()) {
                    case 0:
                        return m33631a(typeCheckerContext, simpleType);
                    case 1:
                        return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                    default:
                        iterable = b2;
                        while (r4.hasNext()) {
                            if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                z = true;
                                if (!z) {
                                    return true;
                                }
                                b3 = g.mo5723b();
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                it = b3.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    i2 = i3 + 1;
                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                    for (SimpleType simpleType32222222222222222 : iterable) {
                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32222222222222222.mo6739a(), i3);
                                        if (typeProjection == null) {
                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                            if (typeProjection == null) {
                                                c = typeProjection.mo6736c();
                                                if (c == null) {
                                                    h = c.mo6738h();
                                                    if (h != null) {
                                                        arrayList2.add(h);
                                                    }
                                                }
                                            }
                                        }
                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                        typeCheckerContext.append(simpleType32222222222222222);
                                        typeCheckerContext.append(", subType: ");
                                        typeCheckerContext.append(simpleType);
                                        typeCheckerContext.append(", superType: ");
                                        typeCheckerContext.append(simpleType2);
                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                    }
                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                    i3 = i2;
                                }
                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                            }
                        }
                        z = false;
                        if (!z) {
                            return true;
                        }
                        b3 = g.mo5723b();
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                        it = b3.iterator();
                        while (it.hasNext()) {
                            it.next();
                            i2 = i3 + 1;
                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                            for (SimpleType simpleType322222222222222222 : iterable) {
                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322222222222222222.mo6739a(), i3);
                                if (typeProjection == null) {
                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                    if (typeProjection == null) {
                                        c = typeProjection.mo6736c();
                                        if (c == null) {
                                            h = c.mo6738h();
                                            if (h != null) {
                                                arrayList2.add(h);
                                            }
                                        }
                                    }
                                }
                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                typeCheckerContext.append(simpleType322222222222222222);
                                typeCheckerContext.append(", subType: ");
                                typeCheckerContext.append(simpleType);
                                typeCheckerContext.append(", superType: ");
                                typeCheckerContext.append(simpleType2);
                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                            }
                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                            i3 = i2;
                        }
                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                }
            }
        }
        i = true;
        if (_Assertions.f25274a) {
        }
        b = NewKotlinTypeCheckerKt.m28030b(simpleType2);
        if (_Assertions.f25274a) {
        }
        if (simpleType2.mo6741c()) {
            if (!NullabilityChecker.m28033a(typeCheckerContext, simpleType, (SupertypesPolicy) LowerIfFlexible.f33079a)) {
                if (NullabilityChecker.m28033a(typeCheckerContext, simpleType2, (SupertypesPolicy) UpperIfFlexible.f33082a)) {
                    if (!(simpleType.mo6743g().mo5724c() instanceof ClassDescriptor)) {
                        b = NullabilityChecker.m28032a(typeCheckerContext, simpleType, simpleType2.mo6743g());
                        if (b) {
                            return false;
                        }
                        g = simpleType2.mo6743g();
                        b2 = m33634b(typeCheckerContext, simpleType, g);
                        switch (b2.size()) {
                            case 0:
                                return m33631a(typeCheckerContext, simpleType);
                            case 1:
                                return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                            default:
                                iterable = b2;
                                while (r4.hasNext()) {
                                    if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                        z = true;
                                        if (!z) {
                                            return true;
                                        }
                                        b3 = g.mo5723b();
                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                        it = b3.iterator();
                                        while (it.hasNext()) {
                                            it.next();
                                            i2 = i3 + 1;
                                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                            for (SimpleType simpleType3222222222222222222 : iterable) {
                                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3222222222222222222.mo6739a(), i3);
                                                if (typeProjection == null) {
                                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                                    if (typeProjection == null) {
                                                        c = typeProjection.mo6736c();
                                                        if (c == null) {
                                                            h = c.mo6738h();
                                                            if (h != null) {
                                                                arrayList2.add(h);
                                                            }
                                                        }
                                                    }
                                                }
                                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                                typeCheckerContext.append(simpleType3222222222222222222);
                                                typeCheckerContext.append(", subType: ");
                                                typeCheckerContext.append(simpleType);
                                                typeCheckerContext.append(", superType: ");
                                                typeCheckerContext.append(simpleType2);
                                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                            }
                                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                            i3 = i2;
                                        }
                                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                                    }
                                }
                                z = false;
                                if (!z) {
                                    return true;
                                }
                                b3 = g.mo5723b();
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                it = b3.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    i2 = i3 + 1;
                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                    for (SimpleType simpleType32222222222222222222 : iterable) {
                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32222222222222222222.mo6739a(), i3);
                                        if (typeProjection == null) {
                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                            if (typeProjection == null) {
                                                c = typeProjection.mo6736c();
                                                if (c == null) {
                                                    h = c.mo6738h();
                                                    if (h != null) {
                                                        arrayList2.add(h);
                                                    }
                                                }
                                            }
                                        }
                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                        typeCheckerContext.append(simpleType32222222222222222222);
                                        typeCheckerContext.append(", subType: ");
                                        typeCheckerContext.append(simpleType);
                                        typeCheckerContext.append(", superType: ");
                                        typeCheckerContext.append(simpleType2);
                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                    }
                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                    i3 = i2;
                                }
                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                        }
                    }
                }
                b = false;
                if (b) {
                    return false;
                }
                g = simpleType2.mo6743g();
                b2 = m33634b(typeCheckerContext, simpleType, g);
                switch (b2.size()) {
                    case 0:
                        return m33631a(typeCheckerContext, simpleType);
                    case 1:
                        return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
                    default:
                        iterable = b2;
                        while (r4.hasNext()) {
                            if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                                z = true;
                                if (!z) {
                                    return true;
                                }
                                b3 = g.mo5723b();
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                                it = b3.iterator();
                                while (it.hasNext()) {
                                    it.next();
                                    i2 = i3 + 1;
                                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                    for (SimpleType simpleType322222222222222222222 : iterable) {
                                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322222222222222222222.mo6739a(), i3);
                                        if (typeProjection == null) {
                                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                            if (typeProjection == null) {
                                                c = typeProjection.mo6736c();
                                                if (c == null) {
                                                    h = c.mo6738h();
                                                    if (h != null) {
                                                        arrayList2.add(h);
                                                    }
                                                }
                                            }
                                        }
                                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                                        typeCheckerContext.append(simpleType322222222222222222222);
                                        typeCheckerContext.append(", subType: ");
                                        typeCheckerContext.append(simpleType);
                                        typeCheckerContext.append(", superType: ");
                                        typeCheckerContext.append(simpleType2);
                                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                                    }
                                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                                    i3 = i2;
                                }
                                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                            }
                        }
                        z = false;
                        if (!z) {
                            return true;
                        }
                        b3 = g.mo5723b();
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                        it = b3.iterator();
                        while (it.hasNext()) {
                            it.next();
                            i2 = i3 + 1;
                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                            for (SimpleType simpleType3222222222222222222222 : iterable) {
                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType3222222222222222222222.mo6739a(), i3);
                                if (typeProjection == null) {
                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                    if (typeProjection == null) {
                                        c = typeProjection.mo6736c();
                                        if (c == null) {
                                            h = c.mo6738h();
                                            if (h != null) {
                                                arrayList2.add(h);
                                            }
                                        }
                                    }
                                }
                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                typeCheckerContext.append(simpleType3222222222222222222222);
                                typeCheckerContext.append(", subType: ");
                                typeCheckerContext.append(simpleType);
                                typeCheckerContext.append(", superType: ");
                                typeCheckerContext.append(simpleType2);
                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                            }
                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                            i3 = i2;
                        }
                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                }
            }
        }
        b = true;
        if (b) {
            return false;
        }
        g = simpleType2.mo6743g();
        b2 = m33634b(typeCheckerContext, simpleType, g);
        switch (b2.size()) {
            case 0:
                return m33631a(typeCheckerContext, simpleType);
            case 1:
                return m33630a(typeCheckerContext, ((SimpleType) CollectionsKt___CollectionsKt.m41430d(b2)).mo6739a(), simpleType2);
            default:
                iterable = b2;
                while (r4.hasNext()) {
                    if (m33630a(typeCheckerContext, a.mo6739a(), simpleType2)) {
                        z = true;
                        if (!z) {
                            return true;
                        }
                        b3 = g.mo5723b();
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                        it = b3.iterator();
                        while (it.hasNext()) {
                            it.next();
                            i2 = i3 + 1;
                            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                            for (SimpleType simpleType32222222222222222222222 : iterable) {
                                typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType32222222222222222222222.mo6739a(), i3);
                                if (typeProjection == null) {
                                    typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                                    if (typeProjection == null) {
                                        c = typeProjection.mo6736c();
                                        if (c == null) {
                                            h = c.mo6738h();
                                            if (h != null) {
                                                arrayList2.add(h);
                                            }
                                        }
                                    }
                                }
                                typeCheckerContext = new StringBuilder("Incorrect type: ");
                                typeCheckerContext.append(simpleType32222222222222222222222);
                                typeCheckerContext.append(", subType: ");
                                typeCheckerContext.append(simpleType);
                                typeCheckerContext.append(", superType: ");
                                typeCheckerContext.append(simpleType2);
                                throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                            }
                            arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                            i3 = i2;
                        }
                        return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
                b3 = g.mo5723b();
                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b3));
                it = b3.iterator();
                while (it.hasNext()) {
                    it.next();
                    i2 = i3 + 1;
                    arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                    for (SimpleType simpleType322222222222222222222222 : iterable) {
                        typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.m41425c(simpleType322222222222222222222222.mo6739a(), i3);
                        if (typeProjection == null) {
                            typeProjection = (TypeProjection) AddToStdlibKt.m28126a(typeProjection, C3003xc5bfe649.f38938a);
                            if (typeProjection == null) {
                                c = typeProjection.mo6736c();
                                if (c == null) {
                                    h = c.mo6738h();
                                    if (h != null) {
                                        arrayList2.add(h);
                                    }
                                }
                            }
                        }
                        typeCheckerContext = new StringBuilder("Incorrect type: ");
                        typeCheckerContext.append(simpleType322222222222222222222222);
                        typeCheckerContext.append(", subType: ");
                        typeCheckerContext.append(simpleType);
                        typeCheckerContext.append(", superType: ");
                        typeCheckerContext.append(simpleType2);
                        throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                    }
                    arrayList.add(TypeUtilsKt.m28068e(IntersectionTypeKt.m28023a((List) arrayList2)));
                    i3 = i2;
                }
                return m33630a(typeCheckerContext, (List) arrayList, simpleType2);
        }
    }

    private static List<SimpleType> m33634b(TypeCheckerContext typeCheckerContext, SimpleType simpleType, TypeConstructor typeConstructor) {
        NewKotlinTypeChecker$findCorrespondingSupertypes$1 newKotlinTypeChecker$findCorrespondingSupertypes$1 = NewKotlinTypeChecker$findCorrespondingSupertypes$1.f38933a;
        if ((simpleType.mo6743g().mo5724c() instanceof ClassDescriptor)) {
            return NewKotlinTypeChecker$findCorrespondingSupertypes$1.m38690a(typeCheckerContext, simpleType, typeConstructor);
        }
        if (!(typeConstructor instanceof ClassDescriptor)) {
            return m33636c(typeCheckerContext, simpleType, typeConstructor);
        }
        SmartList<SimpleType> smartList = new SmartList();
        typeCheckerContext.m28041a(simpleType, NewKotlinTypeChecker$findCorrespondingSupertypes$2.f38934a, new NewKotlinTypeChecker$findCorrespondingSupertypes$3(smartList));
        Collection collection = (Collection) new ArrayList();
        for (SimpleType simpleType2 : smartList) {
            NewKotlinTypeChecker$findCorrespondingSupertypes$1 newKotlinTypeChecker$findCorrespondingSupertypes$12 = NewKotlinTypeChecker$findCorrespondingSupertypes$1.f38933a;
            Intrinsics.m26843a((Object) simpleType2, "it");
            CollectionsKt__MutableCollectionsKt.m38194a(collection, (Iterable) NewKotlinTypeChecker$findCorrespondingSupertypes$1.m38690a(typeCheckerContext, simpleType2, typeConstructor));
        }
        return (List) collection;
    }

    private static List<SimpleType> m33636c(TypeCheckerContext typeCheckerContext, SimpleType simpleType, TypeConstructor typeConstructor) {
        ObjectRef objectRef = new ObjectRef();
        objectRef.f25291a = null;
        typeCheckerContext.m28041a(simpleType, C3001xfde4a0b5.f38930a, new C3002xfde4a0b6(typeConstructor, objectRef));
        List list = (List) objectRef.f25291a;
        return list == null ? CollectionsKt__CollectionsKt.m26790a() : list;
    }

    private static boolean m33630a(TypeCheckerContext typeCheckerContext, List<? extends TypeProjection> list, SimpleType simpleType) {
        List b = simpleType.mo6743g().mo5723b();
        int size = b.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                TypeProjection typeProjection = (TypeProjection) simpleType.mo6739a().get(i);
                if (!typeProjection.mo6734a()) {
                    UnwrappedType h = typeProjection.mo6736c().mo6738h();
                    TypeProjection typeProjection2 = (TypeProjection) list.get(i);
                    boolean a = Intrinsics.m26845a(typeProjection2.mo6735b(), Variance.f26337a);
                    if (!_Assertions.f25274a || a) {
                        UnwrappedType h2 = typeProjection2.mo6736c().mo6738h();
                        Variance k = ((TypeParameterDescriptor) b.get(i)).mo7716k();
                        Intrinsics.m26843a((Object) k, "parameters[index].variance");
                        Object b2 = typeProjection.mo6735b();
                        Intrinsics.m26843a(b2, "superProjection.projectionKind");
                        if (Intrinsics.m26845a((Object) k, Variance.f26337a)) {
                            k = b2;
                        } else if (!Intrinsics.m26845a(b2, Variance.f26337a)) {
                            if (!Intrinsics.m26845a((Object) k, b2)) {
                                k = null;
                            }
                        }
                        if (k == null) {
                            return typeCheckerContext.f26355a;
                        }
                        if (typeCheckerContext.f26356b > 100) {
                            typeCheckerContext = new StringBuilder("Arguments depth is too high. Some related argument: ");
                            typeCheckerContext.append(h2);
                            throw ((Throwable) new IllegalStateException(typeCheckerContext.toString().toString()));
                        }
                        boolean a2;
                        typeCheckerContext.f26356b = typeCheckerContext.f26356b + 1;
                        TypeCheckerContext typeCheckerContext2 = typeCheckerContext;
                        switch (WhenMappings.f26350a[k.ordinal()]) {
                            case 1:
                                a2 = f33078b.m33633a(typeCheckerContext2, h2, h);
                                break;
                            case 2:
                                a2 = f33078b.m33635b(typeCheckerContext2, h2, h);
                                break;
                            case 3:
                                a2 = f33078b.m33635b(typeCheckerContext2, h, h2);
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        typeCheckerContext.f26356b = typeCheckerContext.f26356b - 1;
                        if (!a2) {
                            return false;
                        }
                    }
                    typeCheckerContext = new StringBuilder("Incorrect sub argument: ");
                    typeCheckerContext.append(typeProjection2);
                    throw ((Throwable) new AssertionError(typeCheckerContext.toString()));
                }
                if (i != size) {
                    i++;
                }
            }
        }
        return true;
    }

    public static final /* synthetic */ List m33626a(List list) {
        if (list.size() >= 2) {
            Collection arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                int i = 1;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                for (TypeProjection c : ((SimpleType) next).mo6739a()) {
                    if ((FlexibleTypesKt.m27946a(c.mo6736c()) ^ 1) == 0) {
                        i = 0;
                        break;
                    }
                }
                if (i != 0) {
                    arrayList.add(next);
                }
            }
            List list2 = (List) arrayList;
            if ((list2.isEmpty() ^ 1) != 0) {
                return list2;
            }
        }
        return list;
    }
}
