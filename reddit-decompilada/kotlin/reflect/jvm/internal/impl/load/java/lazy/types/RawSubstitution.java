package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: RawType.kt */
public final class RawSubstitution extends TypeSubstitution {
    public static final RawSubstitution f32752a = null;
    private static final JavaTypeAttributes f32753b = null;
    private static final JavaTypeAttributes f32754c = null;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25727a;

        static {
            int[] iArr = new int[RawBound.values().length];
            f25727a = iArr;
            iArr[RawBound.f25723a.ordinal()] = 1;
            f25727a[RawBound.f25724b.ordinal()] = 2;
            f25727a[RawBound.f25725c.ordinal()] = 3;
        }
    }

    public final boolean mo5796a() {
        return false;
    }

    static {
        RawSubstitution rawSubstitution = new RawSubstitution();
    }

    private RawSubstitution() {
        f32752a = this;
        f32753b = JavaTypeResolverKt.m27227a(JavaTypeResolverKt.m27226a(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, false, null, 7), false, true, true);
        f32754c = JavaTypeResolverKt.m27227a(JavaTypeResolverKt.m27226a(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, false, null, 7), false, true, false);
    }

    public final /* synthetic */ TypeProjection mo5795a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "key");
        return new TypeProjectionImpl(m33092b(kotlinType));
    }

    private KotlinType m33092b(KotlinType kotlinType) {
        while (true) {
            Intrinsics.m26847b(kotlinType, "type");
            ClassifierDescriptor c = kotlinType.mo6743g().mo5724c();
            if (!(c instanceof TypeParameterDescriptor)) {
                break;
            }
            kotlinType = JavaTypeResolverKt.m27230a((TypeParameterDescriptor) c, null, new JavaTypeResolverKt$getErasedUpperBound$1((TypeParameterDescriptor) c));
        }
        if (c instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) c;
            Pair a = m33090a(FlexibleTypesKt.m27948c(kotlinType), classDescriptor, f32753b);
            SimpleType simpleType = (SimpleType) a.f25267a;
            boolean booleanValue = ((Boolean) a.f25268b).booleanValue();
            kotlinType = m33090a(FlexibleTypesKt.m27949d(kotlinType), classDescriptor, f32754c);
            SimpleType simpleType2 = (SimpleType) kotlinType.f25267a;
            kotlinType = ((Boolean) kotlinType.f25268b).booleanValue();
            if (!booleanValue) {
                if (kotlinType == null) {
                    kotlinType = KotlinTypeFactory.m27953a(simpleType, simpleType2);
                    return kotlinType;
                }
            }
            kotlinType = (UnwrappedType) new RawTypeImpl(simpleType, simpleType2);
            return kotlinType;
        }
        kotlinType = new StringBuilder("Unexpected declaration kind: ");
        kotlinType.append(c);
        throw new IllegalStateException(kotlinType.toString().toString());
    }

    private final Pair<SimpleType, Boolean> m33090a(SimpleType simpleType, ClassDescriptor classDescriptor, JavaTypeAttributes javaTypeAttributes) {
        if (simpleType.mo6743g().mo5723b().isEmpty()) {
            return TuplesKt.m26780a(simpleType, Boolean.valueOf(false));
        }
        Object c;
        if (KotlinBuiltIns.m26982b((KotlinType) simpleType)) {
            TypeProjection typeProjection = (TypeProjection) simpleType.mo6739a().get(0);
            Variance b = typeProjection.mo6735b();
            c = typeProjection.mo6736c();
            Intrinsics.m26843a(c, "componentTypeProjection.type");
            return TuplesKt.m26780a(KotlinTypeFactory.m27951a(simpleType.mo5718q(), simpleType.mo6743g(), CollectionsKt__CollectionsKt.m26791a((Object) new TypeProjectionImpl(b, m33092b(c))), simpleType.mo6741c()), Boolean.valueOf(false));
        } else if (simpleType.mo6742d()) {
            classDescriptor = new StringBuilder("Raw error type: ");
            classDescriptor.append(simpleType.mo6743g());
            return TuplesKt.m26780a(ErrorUtils.m27943c(classDescriptor.toString()), Boolean.valueOf(false));
        } else {
            Annotations q = simpleType.mo5718q();
            TypeConstructor g = simpleType.mo6743g();
            Iterable<TypeParameterDescriptor> b2 = simpleType.mo6743g().mo5723b();
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b2));
            for (TypeParameterDescriptor typeParameterDescriptor : b2) {
                Intrinsics.m26843a((Object) typeParameterDescriptor, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                arrayList.add(m33091a(typeParameterDescriptor, javaTypeAttributes, JavaTypeResolverKt.m27230a(typeParameterDescriptor, null, new JavaTypeResolverKt$getErasedUpperBound$1(typeParameterDescriptor))));
            }
            List list = (List) arrayList;
            simpleType = simpleType.mo6741c();
            c = classDescriptor.mo7738a((TypeSubstitution) f32752a);
            Intrinsics.m26843a(c, "declaration.getMemberScope(RawSubstitution)");
            return TuplesKt.m26780a(KotlinTypeFactory.m27952a(q, g, list, simpleType, c), Boolean.valueOf(true));
        }
    }

    public static TypeProjection m33091a(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType) {
        Intrinsics.m26847b(typeParameterDescriptor, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
        Intrinsics.m26847b(javaTypeAttributes, "attr");
        Intrinsics.m26847b(kotlinType, "erasedUpperBound");
        switch (WhenMappings.f25727a[javaTypeAttributes.mo5794i().ordinal()]) {
            case 1:
                return (TypeProjection) new TypeProjectionImpl(Variance.f26337a, kotlinType);
            case 2:
            case 3:
                if (!typeParameterDescriptor.mo7716k().f26342e) {
                    return (TypeProjection) new TypeProjectionImpl(Variance.f26337a, DescriptorUtilsKt.m27745d(typeParameterDescriptor).m27014l());
                }
                if ((kotlinType.mo6743g().mo5723b().isEmpty() ^ 1) != 0) {
                    return (TypeProjection) new TypeProjectionImpl(Variance.f26339c, kotlinType);
                }
                return JavaTypeResolverKt.m27231a(typeParameterDescriptor, javaTypeAttributes);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
