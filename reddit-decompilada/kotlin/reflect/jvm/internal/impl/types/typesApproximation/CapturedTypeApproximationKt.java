package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: CapturedTypeApproximation.kt */
public final class CapturedTypeApproximationKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26370a;
        public static final /* synthetic */ int[] f26371b;

        static {
            int[] iArr = new int[Variance.values().length];
            f26370a = iArr;
            iArr[Variance.f26337a.ordinal()] = 1;
            f26370a[Variance.f26338b.ordinal()] = 2;
            f26370a[Variance.f26339c.ordinal()] = 3;
            iArr = new int[Variance.values().length];
            f26371b = iArr;
            iArr[Variance.f26338b.ordinal()] = 1;
            f26371b[Variance.f26339c.ordinal()] = 2;
        }
    }

    public static final TypeProjection m28071a(TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.mo6734a()) {
            return typeProjection;
        }
        Object c = typeProjection.mo6736c();
        if (!TypeUtils.m28011a((KotlinType) c, (Function1) C3004x21acc51c.f38947a)) {
            return typeProjection;
        }
        Object b = typeProjection.mo6735b();
        if (Intrinsics.m26845a(b, Variance.f26339c)) {
            Intrinsics.m26843a(c, "type");
            return (TypeProjection) new TypeProjectionImpl(b, (KotlinType) m28072a(c).f26369b);
        } else if (!z) {
            return TypeSubstitutor.m27997a((TypeSubstitution) new C2802x12aaa596()).m28003a(typeProjection);
        } else {
            Intrinsics.m26843a(c, "type");
            return (TypeProjection) new TypeProjectionImpl(b, (KotlinType) m28072a(c).f26368a);
        }
    }

    public static final ApproximationBounds<KotlinType> m28072a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        if (FlexibleTypesKt.m27946a(kotlinType)) {
            ApproximationBounds a = m28072a(FlexibleTypesKt.m27948c(kotlinType));
            kotlinType = m28072a(FlexibleTypesKt.m27949d(kotlinType));
            return new ApproximationBounds(KotlinTypeFactory.m27953a(FlexibleTypesKt.m27948c((KotlinType) a.f26368a), FlexibleTypesKt.m27949d((KotlinType) kotlinType.f26368a)), KotlinTypeFactory.m27953a(FlexibleTypesKt.m27948c((KotlinType) a.f26369b), FlexibleTypesKt.m27949d(kotlinType.f26369b)));
        }
        TypeConstructor g = kotlinType.mo6743g();
        if (!CapturedTypeConstructorKt.m27712a(kotlinType)) {
            if (!kotlinType.mo6739a().isEmpty()) {
                if (kotlinType.mo6739a().size() == g.mo5723b().size()) {
                    int i;
                    Object l;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterable a2 = kotlinType.mo6739a();
                    Object b = g.mo5723b();
                    Intrinsics.m26843a(b, "typeConstructor.parameters");
                    for (Pair pair : CollectionsKt___CollectionsKt.m41417a(a2, (Iterable) b)) {
                        TypeArgument typeArgument;
                        TypeProjection typeProjection = (TypeProjection) pair.f25267a;
                        Object obj = (TypeParameterDescriptor) pair.f25268b;
                        Intrinsics.m26843a(obj, "typeParameter");
                        Object c;
                        Object c2;
                        switch (WhenMappings.f26370a[TypeSubstitutor.m27999a(obj.mo7716k(), typeProjection).ordinal()]) {
                            case 1:
                                c = typeProjection.mo6736c();
                                Intrinsics.m26843a(c, "type");
                                c2 = typeProjection.mo6736c();
                                Intrinsics.m26843a(c2, "type");
                                typeArgument = new TypeArgument(obj, c, c2);
                                break;
                            case 2:
                                c = typeProjection.mo6736c();
                                Intrinsics.m26843a(c, "type");
                                c2 = DescriptorUtilsKt.m27745d((DeclarationDescriptor) obj).m27016n();
                                Intrinsics.m26843a(c2, "typeParameter.builtIns.nullableAnyType");
                                typeArgument = new TypeArgument(obj, c, (KotlinType) c2);
                                break;
                            case 3:
                                c = DescriptorUtilsKt.m27745d((DeclarationDescriptor) obj).m27014l();
                                Intrinsics.m26843a(c, "typeParameter.builtIns.nothingType");
                                KotlinType kotlinType2 = (KotlinType) c;
                                c2 = typeProjection.mo6736c();
                                Intrinsics.m26843a(c2, "type");
                                typeArgument = new TypeArgument(obj, kotlinType2, c2);
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        if (typeProjection.mo6734a()) {
                            arrayList.add(typeArgument);
                            arrayList2.add(typeArgument);
                        } else {
                            ApproximationBounds a3 = m28072a(typeArgument.f26373b);
                            KotlinType kotlinType3 = (KotlinType) a3.f26368a;
                            KotlinType kotlinType4 = (KotlinType) a3.f26369b;
                            ApproximationBounds a4 = m28072a(typeArgument.f26374c);
                            ApproximationBounds approximationBounds = new ApproximationBounds(new TypeArgument(typeArgument.f26372a, kotlinType4, (KotlinType) a4.f26368a), new TypeArgument(typeArgument.f26372a, kotlinType3, (KotlinType) a4.f26369b));
                            TypeArgument typeArgument2 = (TypeArgument) approximationBounds.f26369b;
                            arrayList.add((TypeArgument) approximationBounds.f26368a);
                            arrayList2.add(typeArgument2);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    do {
                        i = 1;
                        if (!it.hasNext()) {
                            i = 0;
                        }
                        if (i == 0) {
                            l = TypeUtilsKt.m28060a(kotlinType).m27014l();
                            Intrinsics.m26843a(l, "type.builtIns.nothingType");
                            l = (KotlinType) l;
                        } else {
                            l = m28070a(kotlinType, (List) arrayList);
                        }
                        return new ApproximationBounds(l, m28070a(kotlinType, (List) arrayList2));
                    } while ((((TypeArgument) it.next()).m28073a() ^ 1) == 0);
                    if (i == 0) {
                        l = m28070a(kotlinType, (List) arrayList);
                    } else {
                        l = TypeUtilsKt.m28060a(kotlinType).m27014l();
                        Intrinsics.m26843a(l, "type.builtIns.nothingType");
                        l = (KotlinType) l;
                    }
                    return new ApproximationBounds(l, m28070a(kotlinType, (List) arrayList2));
                }
            }
            return new ApproximationBounds(kotlinType, kotlinType);
        } else if (g == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        } else {
            TypeProjection typeProjection2 = ((CapturedTypeConstructor) g).f32935b;
            CapturedTypeApproximationKt$approximateCapturedTypes$1 capturedTypeApproximationKt$approximateCapturedTypes$1 = new CapturedTypeApproximationKt$approximateCapturedTypes$1(kotlinType);
            Object a5 = capturedTypeApproximationKt$approximateCapturedTypes$1.m38709a(typeProjection2.mo6736c());
            switch (WhenMappings.f26371b[typeProjection2.mo6735b().ordinal()]) {
                case 1:
                    Intrinsics.m26843a(a5, "bound");
                    Object n = TypeUtilsKt.m28060a(kotlinType).m27016n();
                    Intrinsics.m26843a(n, "type.builtIns.nullableAnyType");
                    return new ApproximationBounds(a5, n);
                case 2:
                    return new ApproximationBounds(capturedTypeApproximationKt$approximateCapturedTypes$1.m38709a(TypeUtilsKt.m28060a(kotlinType).m27014l()), a5);
                default:
                    StringBuilder stringBuilder = new StringBuilder("Only nontrivial projections should have been captured, not: ");
                    stringBuilder.append(typeProjection2);
                    throw ((Throwable) new AssertionError(stringBuilder.toString()));
            }
        }
    }

    private static final KotlinType m28070a(KotlinType kotlinType, List<TypeArgument> list) {
        int i = kotlinType.mo6739a().size() == list.size() ? 1 : 0;
        if (_Assertions.f25274a && i == 0) {
            kotlinType = new StringBuilder("Incorrect type arguments ");
            kotlinType.append(list);
            throw ((Throwable) new AssertionError(kotlinType.toString()));
        }
        Iterable<TypeArgument> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (TypeArgument typeArgument : iterable) {
            boolean a = typeArgument.m28073a();
            if (!_Assertions.f25274a || a) {
                Object typeProjectionImpl;
                CapturedTypeApproximationKt$toTypeProjection$2 capturedTypeApproximationKt$toTypeProjection$2 = new CapturedTypeApproximationKt$toTypeProjection$2(typeArgument);
                if (Intrinsics.m26845a(typeArgument.f26373b, typeArgument.f26374c)) {
                    typeProjectionImpl = new TypeProjectionImpl(typeArgument.f26373b);
                } else if (KotlinBuiltIns.m26989e(typeArgument.f26373b) && (Intrinsics.m26845a(typeArgument.f26372a.mo7716k(), Variance.f26338b) ^ 1) != 0) {
                    typeProjectionImpl = new TypeProjectionImpl(capturedTypeApproximationKt$toTypeProjection$2.m38713a(Variance.f26339c), typeArgument.f26374c);
                } else if (KotlinBuiltIns.m26992h(typeArgument.f26374c)) {
                    typeProjectionImpl = new TypeProjectionImpl(capturedTypeApproximationKt$toTypeProjection$2.m38713a(Variance.f26338b), typeArgument.f26373b);
                } else {
                    typeProjectionImpl = new TypeProjectionImpl(capturedTypeApproximationKt$toTypeProjection$2.m38713a(Variance.f26339c), typeArgument.f26374c);
                }
                arrayList.add(typeProjectionImpl);
            } else {
                kotlinType = DescriptorRenderer.f26016i;
                kotlinType = Companion.m27584a((Function1) C3005x8e300b6.f38948a);
                list = new StringBuilder("Only consistent enhanced type projection can be converted to type projection, but ");
                StringBuilder stringBuilder = new StringBuilder("[");
                stringBuilder.append(kotlinType.mo5890a((DeclarationDescriptor) typeArgument.f26372a));
                stringBuilder.append(": <");
                stringBuilder.append(kotlinType.mo5894a(typeArgument.f26373b));
                stringBuilder.append(", ");
                stringBuilder.append(kotlinType.mo5894a(typeArgument.f26374c));
                stringBuilder.append(">]");
                list.append(stringBuilder.toString());
                list.append(" was found");
                throw ((Throwable) new AssertionError(list.toString()));
            }
        }
        return TypeSubstitutionKt.m27989a(kotlinType, (List) arrayList, kotlinType.mo5718q());
    }
}
