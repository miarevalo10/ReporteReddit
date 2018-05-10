package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Modality;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument.Projection;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.Variance;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Visibility;

/* compiled from: protoEnumMapping.kt */
public final class Deserialization {
    public static final Deserialization f26227a = null;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26221a;
        public static final /* synthetic */ int[] f26222b;
        public static final /* synthetic */ int[] f26223c;
        public static final /* synthetic */ int[] f26224d;
        public static final /* synthetic */ int[] f26225e;
        public static final /* synthetic */ int[] f26226f;

        static {
            int[] iArr = new int[MemberKind.values().length];
            f26221a = iArr;
            iArr[MemberKind.DECLARATION.ordinal()] = 1;
            f26221a[MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            f26221a[MemberKind.DELEGATION.ordinal()] = 3;
            f26221a[MemberKind.SYNTHESIZED.ordinal()] = 4;
            iArr = new int[Modality.values().length];
            f26222b = iArr;
            iArr[Modality.FINAL.ordinal()] = 1;
            f26222b[Modality.OPEN.ordinal()] = 2;
            f26222b[Modality.ABSTRACT.ordinal()] = 3;
            f26222b[Modality.SEALED.ordinal()] = 4;
            iArr = new int[Visibility.values().length];
            f26223c = iArr;
            iArr[Visibility.INTERNAL.ordinal()] = 1;
            f26223c[Visibility.PRIVATE.ordinal()] = 2;
            f26223c[Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            f26223c[Visibility.PROTECTED.ordinal()] = 4;
            f26223c[Visibility.PUBLIC.ordinal()] = 5;
            f26223c[Visibility.LOCAL.ordinal()] = 6;
            iArr = new int[Kind.values().length];
            f26224d = iArr;
            iArr[Kind.CLASS.ordinal()] = 1;
            f26224d[Kind.INTERFACE.ordinal()] = 2;
            f26224d[Kind.ENUM_CLASS.ordinal()] = 3;
            f26224d[Kind.ENUM_ENTRY.ordinal()] = 4;
            f26224d[Kind.ANNOTATION_CLASS.ordinal()] = 5;
            f26224d[Kind.OBJECT.ordinal()] = 6;
            f26224d[Kind.COMPANION_OBJECT.ordinal()] = 7;
            iArr = new int[Variance.values().length];
            f26225e = iArr;
            iArr[Variance.f33015a.ordinal()] = 1;
            f26225e[Variance.OUT.ordinal()] = 2;
            f26225e[Variance.INV.ordinal()] = 3;
            iArr = new int[Projection.values().length];
            f26226f = iArr;
            iArr[Projection.f33008a.ordinal()] = 1;
            f26226f[Projection.OUT.ordinal()] = 2;
            f26226f[Projection.INV.ordinal()] = 3;
            f26226f[Projection.STAR.ordinal()] = 4;
        }
    }

    static {
        Deserialization deserialization = new Deserialization();
    }

    private Deserialization() {
        f26227a = this;
    }

    public static final CallableMemberDescriptor.Kind m27826a(MemberKind memberKind) {
        if (memberKind != null) {
            switch (WhenMappings.f26221a[memberKind.ordinal()]) {
                case 1:
                    return CallableMemberDescriptor.Kind.DECLARATION;
                case 2:
                    return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
                case 3:
                    return CallableMemberDescriptor.Kind.DELEGATION;
                case 4:
                    return CallableMemberDescriptor.Kind.SYNTHESIZED;
                default:
                    break;
            }
        }
        return CallableMemberDescriptor.Kind.DECLARATION;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.Modality m27828a(Modality modality) {
        if (modality != null) {
            switch (WhenMappings.f26222b[modality.ordinal()]) {
                case 1:
                    return kotlin.reflect.jvm.internal.impl.descriptors.Modality.f25488a;
                case 2:
                    return kotlin.reflect.jvm.internal.impl.descriptors.Modality.f25490c;
                case 3:
                    return kotlin.reflect.jvm.internal.impl.descriptors.Modality.f25491d;
                case 4:
                    return kotlin.reflect.jvm.internal.impl.descriptors.Modality.f25489b;
                default:
                    break;
            }
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.Modality.f25488a;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibility m27829a(Visibility visibility) {
        if (visibility != null) {
            switch (WhenMappings.f26223c[visibility.ordinal()]) {
                case 1:
                    return Visibilities.f25507d;
                case 2:
                    return Visibilities.f25504a;
                case 3:
                    return Visibilities.f25505b;
                case 4:
                    return Visibilities.f25506c;
                case 5:
                    return Visibilities.f25508e;
                case 6:
                    return Visibilities.f25509f;
                default:
                    break;
            }
        }
        return Visibilities.f25504a;
    }

    public static final ClassKind m27827a(Kind kind) {
        if (kind != null) {
            switch (WhenMappings.f26224d[kind.ordinal()]) {
                case 1:
                    return ClassKind.CLASS;
                case 2:
                    return ClassKind.INTERFACE;
                case 3:
                    return ClassKind.ENUM_CLASS;
                case 4:
                    return ClassKind.ENUM_ENTRY;
                case 5:
                    return ClassKind.ANNOTATION_CLASS;
                case 6:
                case 7:
                    return ClassKind.OBJECT;
                default:
                    break;
            }
        }
        return ClassKind.CLASS;
    }

    public static final kotlin.reflect.jvm.internal.impl.types.Variance m27831a(Variance variance) {
        Intrinsics.m26847b(variance, "variance");
        switch (WhenMappings.f26225e[variance.ordinal()]) {
            case 1:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26338b;
            case 2:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26339c;
            case 3:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26337a;
            default:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26337a;
        }
    }

    public static final kotlin.reflect.jvm.internal.impl.types.Variance m27830a(Projection projection) {
        Intrinsics.m26847b(projection, "variance");
        switch (WhenMappings.f26226f[projection.ordinal()]) {
            case 1:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26338b;
            case 2:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26339c;
            case 3:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26337a;
            case 4:
                StringBuilder stringBuilder = new StringBuilder("Only IN, OUT and INV are supported. Actual argument: ");
                stringBuilder.append(projection);
                throw new IllegalArgumentException(stringBuilder.toString());
            default:
                return kotlin.reflect.jvm.internal.impl.types.Variance.f26337a;
        }
    }
}
