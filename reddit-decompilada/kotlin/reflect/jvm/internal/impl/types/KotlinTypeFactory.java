package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;

/* compiled from: KotlinTypeFactory.kt */
public final class KotlinTypeFactory {
    public static final KotlinTypeFactory f26319a = null;

    static {
        KotlinTypeFactory kotlinTypeFactory = new KotlinTypeFactory();
    }

    private KotlinTypeFactory() {
        f26319a = this;
    }

    public static final SimpleType m27952a(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope) {
        Intrinsics.m26847b(annotations, "annotations");
        Intrinsics.m26847b(typeConstructor, "constructor");
        Intrinsics.m26847b(list, "arguments");
        Intrinsics.m26847b(memberScope, "memberScope");
        return new SimpleTypeImpl(annotations, typeConstructor, list, z, memberScope);
    }

    public static final SimpleType m27950a(Annotations annotations, ClassDescriptor classDescriptor, List<? extends TypeProjection> list) {
        Intrinsics.m26847b(annotations, "annotations");
        Intrinsics.m26847b(classDescriptor, "descriptor");
        Intrinsics.m26847b(list, "arguments");
        Object c = classDescriptor.mo7610c();
        Intrinsics.m26843a(c, "descriptor.typeConstructor");
        Object a = classDescriptor.mo7737a((List) list);
        Intrinsics.m26843a(a, "descriptor.getMemberScope(arguments)");
        return new SimpleTypeImpl(annotations, c, list, false, a);
    }

    public static final UnwrappedType m27953a(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(simpleType, "lowerBound");
        Intrinsics.m26847b(simpleType2, "upperBound");
        if (Intrinsics.m26845a((Object) simpleType, (Object) simpleType2)) {
            return simpleType;
        }
        return new FlexibleTypeImpl(simpleType, simpleType2);
    }

    public static /* synthetic */ SimpleType m27951a(Annotations annotations, TypeConstructor typeConstructor, List list, boolean z) {
        MemberScope b;
        ClassifierDescriptor c = typeConstructor.mo5724c();
        if (c instanceof TypeParameterDescriptor) {
            b = c.mo7714h().mo6740b();
        } else if (c instanceof ClassDescriptor) {
            ClassDescriptor classDescriptor = (ClassDescriptor) c;
            Companion companion = TypeConstructorSubstitution.f33074b;
            b = classDescriptor.mo7738a(Companion.m27971a(typeConstructor, list));
            Intrinsics.m26843a((Object) b, "descriptor.getMemberScop…(constructor, arguments))");
        } else if (c instanceof TypeAliasDescriptor) {
            StringBuilder stringBuilder = new StringBuilder("Scope for abbreviation: ");
            stringBuilder.append(((TypeAliasDescriptor) c).mo6689i());
            b = ErrorUtils.m27934a(stringBuilder.toString(), true);
            Intrinsics.m26843a((Object) b, "ErrorUtils.createErrorSc…{descriptor.name}\", true)");
        } else {
            list = new StringBuilder("Unsupported classifier: ");
            list.append(c);
            list.append(" for constructor: ");
            list.append(typeConstructor);
            throw ((Throwable) new IllegalStateException(list.toString()));
        }
        return m27952a(annotations, typeConstructor, list, z, b);
    }
}
