package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

public abstract class AbstractClassDescriptor implements ClassDescriptor {
    static final /* synthetic */ boolean f40755e = true;
    private final Name f40756a;
    private final NotNullLazyValue<MemberScope> f40757b;
    private final NotNullLazyValue<ReceiverParameterDescriptor> f40758c;
    protected final NotNullLazyValue<SimpleType> f40759d;

    class C27441 implements Function0<SimpleType> {
        final /* synthetic */ AbstractClassDescriptor f36056a;

        C27441(AbstractClassDescriptor abstractClassDescriptor) {
            this.f36056a = abstractClassDescriptor;
        }

        public /* synthetic */ Object invoke() {
            return TypeUtils.m28008a(this.f36056a, this.f36056a.mo7768d());
        }
    }

    class C27452 implements Function0<MemberScope> {
        final /* synthetic */ AbstractClassDescriptor f36057a;

        C27452(AbstractClassDescriptor abstractClassDescriptor) {
            this.f36057a = abstractClassDescriptor;
        }

        public /* synthetic */ Object invoke() {
            return new InnerClassesScopeWrapper(this.f36057a.mo7768d());
        }
    }

    class C27463 implements Function0<ReceiverParameterDescriptor> {
        final /* synthetic */ AbstractClassDescriptor f36058a;

        C27463(AbstractClassDescriptor abstractClassDescriptor) {
            this.f36058a = abstractClassDescriptor;
        }

        public /* synthetic */ Object invoke() {
            return new LazyClassReceiverParameterDescriptor(this.f36058a);
        }
    }

    public final /* synthetic */ ClassifierDescriptor aI_() {
        return mo7741v();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7741v();
    }

    public /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7840a(typeSubstitutor);
    }

    public AbstractClassDescriptor(StorageManager storageManager, Name name) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "<init>"}));
        } else {
            this.f40756a = name;
            this.f40759d = storageManager.mo5926a(new C27441(this));
            this.f40757b = storageManager.mo5926a(new C27452(this));
            this.f40758c = storageManager.mo5926a(new C27463(this));
        }
    }

    public final Name mo6689i() {
        Name name = this.f40756a;
        if (name != null) {
            return name;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getName"}));
    }

    public final ClassDescriptor mo7741v() {
        if (this != null) {
            return this;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getOriginal"}));
    }

    public MemberScope mo7739t() {
        MemberScope memberScope = (MemberScope) this.f40757b.invoke();
        if (memberScope != null) {
            return memberScope;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getUnsubstitutedInnerClassesScope"}));
    }

    public final ReceiverParameterDescriptor mo7740u() {
        ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor) this.f40758c.invoke();
        if (receiverParameterDescriptor != null) {
            return receiverParameterDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getThisAsReceiverParameter"}));
    }

    public MemberScope mo7737a(List<? extends TypeProjection> list) {
        if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeArguments", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"}));
        } else if (!f40755e && list.size() != mo7610c().mo5723b().size()) {
            StringBuilder stringBuilder = new StringBuilder("Illegal number of type arguments: expected ");
            stringBuilder.append(mo7610c().mo5723b().size());
            stringBuilder.append(" but was ");
            stringBuilder.append(list.size());
            stringBuilder.append(" for ");
            stringBuilder.append(mo7610c());
            stringBuilder.append(" ");
            stringBuilder.append(mo7610c().mo5723b());
            throw new AssertionError(stringBuilder.toString());
        } else if (list.isEmpty()) {
            list = mo7768d();
            if (list != null) {
                return list;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"}));
        } else {
            return new SubstitutingScope(mo7768d(), TypeConstructorSubstitution.m33614a(mo7610c(), list).m27987d());
        }
    }

    public MemberScope mo7738a(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeSubstitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"}));
        } else if (typeSubstitution.mo5796a()) {
            typeSubstitution = mo7768d();
            if (typeSubstitution != null) {
                return typeSubstitution;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"}));
        } else {
            return new SubstitutingScope(mo7768d(), TypeSubstitutor.m27997a(typeSubstitution));
        }
    }

    public final SimpleType mo7714h() {
        SimpleType simpleType = (SimpleType) this.f40759d.invoke();
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getDefaultType"}));
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5727a((ClassDescriptor) this, (Object) d);
    }

    public ClassDescriptor mo7840a(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "substitute"}));
        } else if (!typeSubstitutor.f26329b.mo5796a()) {
            return new LazySubstitutingClassDescriptor(this, typeSubstitutor);
        } else {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "substitute"}));
        }
    }
}
