package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public abstract class AbstractTypeParameterDescriptor extends DeclarationDescriptorNonRootImpl implements TypeParameterDescriptor {
    final boolean f40719a;
    private final Variance f40720b;
    private final int f40721c;
    private final NotNullLazyValue<TypeConstructor> f40722d;
    private final NotNullLazyValue<SimpleType> f40723e;

    private class TypeParameterTypeConstructor extends AbstractTypeConstructor {
        final /* synthetic */ AbstractTypeParameterDescriptor f36066a;
        private final SupertypeLoopChecker f36067b;

        public final boolean mo5725d() {
            return false;
        }

        public TypeParameterTypeConstructor(AbstractTypeParameterDescriptor abstractTypeParameterDescriptor, StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "<init>"}));
            }
            this.f36066a = abstractTypeParameterDescriptor;
            super(storageManager);
            this.f36067b = supertypeLoopChecker;
        }

        protected final Collection<KotlinType> mo6684a() {
            Collection m = this.f36066a.mo7775m();
            if (m != null) {
                return m;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "computeSupertypes"}));
        }

        public final List<TypeParameterDescriptor> mo5723b() {
            List<TypeParameterDescriptor> emptyList = Collections.emptyList();
            if (emptyList != null) {
                return emptyList;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getParameters"}));
        }

        public final ClassifierDescriptor mo5724c() {
            ClassifierDescriptor classifierDescriptor = this.f36066a;
            if (classifierDescriptor != null) {
                return classifierDescriptor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getDeclarationDescriptor"}));
        }

        public final KotlinBuiltIns mo5726e() {
            KotlinBuiltIns d = DescriptorUtilsKt.m27745d(this.f36066a);
            if (d != null) {
                return d;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getBuiltIns"}));
        }

        public String toString() {
            return this.f36066a.mo6689i().toString();
        }

        protected final SupertypeLoopChecker aK_() {
            SupertypeLoopChecker supertypeLoopChecker = this.f36067b;
            if (supertypeLoopChecker != null) {
                return supertypeLoopChecker;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getSupertypeLoopChecker"}));
        }

        protected final void mo6685a(KotlinType kotlinType) {
            if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "reportSupertypeLoopError"}));
            } else {
                this.f36066a.mo7774a(kotlinType);
            }
        }

        protected final KotlinType mo6687f() {
            return ErrorUtils.m27943c("Cyclic upper bounds");
        }
    }

    public abstract void mo7774a(KotlinType kotlinType);

    public final boolean mo7711b() {
        return false;
    }

    public abstract List<KotlinType> mo7775m();

    public final /* synthetic */ ClassifierDescriptor aI_() {
        return mo7712d();
    }

    public final /* synthetic */ DeclarationDescriptor aJ_() {
        return mo7712d();
    }

    public final /* synthetic */ DeclarationDescriptorWithSource aO_() {
        return mo7712d();
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        return mo7709a(typeSubstitutor);
    }

    protected AbstractTypeParameterDescriptor(final StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Annotations annotations, final Name name, Variance variance, boolean z, int i, SourceElement sourceElement, final SupertypeLoopChecker supertypeLoopChecker) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"}));
        } else if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"}));
        } else if (supertypeLoopChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertypeLoopChecker", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"}));
        } else {
            super(declarationDescriptor, annotations, name, sourceElement);
            this.f40720b = variance;
            this.f40719a = z;
            this.f40721c = i;
            this.f40722d = storageManager.mo5926a(new Function0<TypeConstructor>(this) {
                final /* synthetic */ AbstractTypeParameterDescriptor f36061c;

                public /* synthetic */ Object invoke() {
                    return new TypeParameterTypeConstructor(this.f36061c, storageManager, supertypeLoopChecker);
                }
            });
            this.f40723e = storageManager.mo5926a(new Function0<SimpleType>(this) {
                final /* synthetic */ AbstractTypeParameterDescriptor f36065c;

                class C27481 implements Function0<MemberScope> {
                    final /* synthetic */ C27492 f36062a;

                    C27481(C27492 c27492) {
                        this.f36062a = c27492;
                    }

                    public /* synthetic */ Object invoke() {
                        StringBuilder stringBuilder = new StringBuilder("Scope for type parameter ");
                        stringBuilder.append(name.m27429a());
                        return TypeIntersectionScope.m38595a(stringBuilder.toString(), this.f36062a.f36065c.mo7715j());
                    }
                }

                public /* synthetic */ Object invoke() {
                    Companion companion = Annotations.f32643a;
                    return KotlinTypeFactory.m27952a(Companion.m27115a(), this.f36065c.mo7610c(), Collections.emptyList(), false, new LazyScopeAdapter(storageManager.mo5926a(new C27481(this))));
                }
            });
        }
    }

    public final Variance mo7716k() {
        Variance variance = this.f40720b;
        if (variance != null) {
            return variance;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getVariance"}));
    }

    public final boolean mo7717l() {
        return this.f40719a;
    }

    public final int mo7713g() {
        return this.f40721c;
    }

    public final List<KotlinType> mo7715j() {
        List<KotlinType> h = ((TypeParameterTypeConstructor) mo7610c()).m33577h();
        if (h != null) {
            return h;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getUpperBounds"}));
    }

    public final TypeConstructor mo7610c() {
        TypeConstructor typeConstructor = (TypeConstructor) this.f40722d.invoke();
        if (typeConstructor != null) {
            return typeConstructor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getTypeConstructor"}));
    }

    public final SimpleType mo7714h() {
        SimpleType simpleType = (SimpleType) this.f40723e.invoke();
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getDefaultType"}));
    }

    public final TypeParameterDescriptor mo7712d() {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) super.aO_();
        if (typeParameterDescriptor != null) {
            return typeParameterDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getOriginal"}));
    }

    @Deprecated
    public final TypeParameterDescriptor mo7709a(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "substitute"}));
        }
        throw new UnsupportedOperationException("Don't call substitute() on type parameters");
    }

    public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.mo5738a((TypeParameterDescriptor) this, (Object) d);
    }
}
