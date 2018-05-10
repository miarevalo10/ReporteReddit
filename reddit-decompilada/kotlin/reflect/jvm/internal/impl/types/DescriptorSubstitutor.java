package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Mutable;
import org.jetbrains.annotations.ReadOnly;

public class DescriptorSubstitutor {
    static final /* synthetic */ boolean f26312a = true;

    private DescriptorSubstitutor() {
    }

    public static TypeSubstitutor m27928a(@ReadOnly List<TypeParameterDescriptor> list, TypeSubstitution typeSubstitution, DeclarationDescriptor declarationDescriptor, @Mutable List<TypeParameterDescriptor> list2) {
        TypeSubstitution typeSubstitution2 = typeSubstitution;
        List<TypeParameterDescriptor> list3 = list2;
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeParameters", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"}));
        } else if (typeSubstitution2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"originalSubstitution", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newContainingDeclaration", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"}));
        } else if (list3 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"}));
        } else {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it.next();
                Annotations q = typeParameterDescriptor.mo5718q();
                boolean l = typeParameterDescriptor.mo7717l();
                Variance k = typeParameterDescriptor.mo7716k();
                int i2 = i + 1;
                TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
                Name i3 = typeParameterDescriptor.mo6689i();
                Iterator it2 = it;
                TypeParameterDescriptorImpl a = TypeParameterDescriptorImpl.m42661a(declarationDescriptor, q, l, k, i3, i, SourceElement.f25498a);
                hashMap.put(typeParameterDescriptor2.mo7610c(), new TypeProjectionImpl(a.mo7714h()));
                hashMap2.put(typeParameterDescriptor2, a);
                list3.add(a);
                it = it2;
                i = i2;
            }
            TypeSubstitutor a2 = TypeSubstitutor.m27998a(typeSubstitution2, TypeConstructorSubstitution.m33613a(hashMap));
            for (TypeParameterDescriptor typeParameterDescriptor3 : list) {
                TypeParameterDescriptorImpl typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) hashMap2.get(typeParameterDescriptor3);
                for (KotlinType b : typeParameterDescriptor3.mo7715j()) {
                    KotlinType b2 = a2.m28005b(b2, Variance.f26338b);
                    if (f26312a || b2 != null) {
                        typeParameterDescriptorImpl.m42665b(b2);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Upper bound failed to substitute: ");
                        stringBuilder.append(typeParameterDescriptor3);
                        throw new AssertionError(stringBuilder.toString());
                    }
                }
                typeParameterDescriptorImpl.m42667n();
            }
            if (a2 != null) {
                return a2;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"}));
        }
    }
}
