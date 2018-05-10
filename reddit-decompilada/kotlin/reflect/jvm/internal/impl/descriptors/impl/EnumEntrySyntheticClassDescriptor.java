package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {
    static final /* synthetic */ boolean f40909a = true;
    private final TypeConstructor f40910b;
    private final ClassConstructorDescriptor f40911c;
    private final MemberScope f40912f;
    private final NotNullLazyValue<Set<Name>> f40913g;
    private final Annotations f40914h;

    private class EnumEntryScope extends MemberScopeImpl {
        static final /* synthetic */ boolean f38333a = true;
        final /* synthetic */ EnumEntrySyntheticClassDescriptor f38334b;
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> f38335c;
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> f38336d;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> f38337e;

        static {
            Class cls = EnumEntrySyntheticClassDescriptor.class;
        }

        static /* synthetic */ Collection m38311a(EnumEntryScope enumEntryScope, Name name) {
            if (name != null) {
                return enumEntryScope.m38312a(name, enumEntryScope.m38314c().mo6698b(name, NoLookupLocation.f32686p));
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "computeFunctions"}));
        }

        static /* synthetic */ Collection m38313b(EnumEntryScope enumEntryScope, Name name) {
            if (name != null) {
                return enumEntryScope.m38312a(name, enumEntryScope.m38314c().mo6694a(name, NoLookupLocation.f32686p));
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "computeProperties"}));
        }

        public EnumEntryScope(final EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor, StorageManager storageManager) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "<init>"}));
            }
            this.f38334b = enumEntrySyntheticClassDescriptor;
            this.f38335c = storageManager.mo5925a(new Function1<Name, Collection<SimpleFunctionDescriptor>>(this) {
                final /* synthetic */ EnumEntryScope f36070b;

                public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
                    return EnumEntryScope.m38311a(this.f36070b, (Name) obj);
                }
            });
            this.f38336d = storageManager.mo5925a(new Function1<Name, Collection<PropertyDescriptor>>(this) {
                final /* synthetic */ EnumEntryScope f36072b;

                public final /* synthetic */ Object mo6492a(Object obj) {
                    return EnumEntryScope.m38313b(this.f36072b, (Name) obj);
                }
            });
            this.f38337e = storageManager.mo5926a(new Function0<Collection<DeclarationDescriptor>>(this) {
                final /* synthetic */ EnumEntryScope f36074b;

                public /* synthetic */ Object invoke() {
                    return EnumEntryScope.m38310a(this.f36074b);
                }
            });
        }

        public final Collection mo6694a(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedVariables"}));
            } else if (lookupLocation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedVariables"}));
            } else {
                Collection collection = (Collection) this.f38336d.mo6492a(name);
                if (collection != null) {
                    return collection;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedVariables"}));
            }
        }

        public final Collection mo6698b(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedFunctions"}));
            } else if (lookupLocation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedFunctions"}));
            } else {
                Collection collection = (Collection) this.f38335c.mo6492a(name);
                if (collection != null) {
                    return collection;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedFunctions"}));
            }
        }

        private MemberScope m38314c() {
            Collection aL_ = this.f38334b.mo7610c().aL_();
            if (f38333a || aL_.size() == 1) {
                MemberScope b = ((KotlinType) aL_.iterator().next()).mo6740b();
                if (b != null) {
                    return b;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getSupertypeScope"}));
            }
            StringBuilder stringBuilder = new StringBuilder("Enum entry and its companion object both should have exactly one supertype: ");
            stringBuilder.append(aL_);
            throw new AssertionError(stringBuilder.toString());
        }

        private <D extends CallableMemberDescriptor> Collection<D> m38312a(Name name, Collection<D> collection) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "resolveFakeOverrides"}));
            } else if (collection == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromSupertypes", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "resolveFakeOverrides"}));
            } else {
                final Collection linkedHashSet = new LinkedHashSet();
                OverridingUtil.m27695a(name, collection, Collections.emptySet(), this.f38334b, new NonReportingOverrideStrategy(this) {
                    final /* synthetic */ EnumEntryScope f36076b;

                    protected final void mo6691a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                        if (callableMemberDescriptor == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromSuper", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4", "conflict"}));
                        } else if (callableMemberDescriptor2 == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromCurrent", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4", "conflict"}));
                        }
                    }

                    public final void mo6690a(CallableMemberDescriptor callableMemberDescriptor) {
                        if (callableMemberDescriptor == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fakeOverride", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4", "addFakeOverride"}));
                        }
                        OverridingUtil.m27693a(callableMemberDescriptor, null);
                        linkedHashSet.add(callableMemberDescriptor);
                    }
                });
                return linkedHashSet;
            }
        }

        public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kindFilter", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedDescriptors"}));
            } else if (function1 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"nameFilter", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedDescriptors"}));
            } else {
                Collection collection = (Collection) this.f38337e.invoke();
                if (collection != null) {
                    return collection;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedDescriptors"}));
            }
        }

        public final Set<Name> aE_() {
            Set<Name> set = (Set) this.f38334b.f40913g.invoke();
            if (set != null) {
                return set;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getFunctionNames"}));
        }

        public final Set<Name> aF_() {
            Set<Name> set = (Set) this.f38334b.f40913g.invoke();
            if (set != null) {
                return set;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getVariableNames"}));
        }

        static /* synthetic */ Collection m38310a(EnumEntryScope enumEntryScope) {
            Collection hashSet = new HashSet();
            for (Name name : (Set) enumEntryScope.f38334b.f40913g.invoke()) {
                hashSet.addAll(enumEntryScope.mo6698b(name, NoLookupLocation.f32686p));
                hashSet.addAll(enumEntryScope.mo6694a(name, NoLookupLocation.f32686p));
            }
            return hashSet;
        }
    }

    public final ClassDescriptor mo7769e() {
        return null;
    }

    public final boolean mo7772k() {
        return false;
    }

    public final boolean mo7742l() {
        return false;
    }

    public final boolean mo7773m() {
        return false;
    }

    public final boolean mo7743n() {
        return false;
    }

    public final boolean mo7744o() {
        return false;
    }

    public static EnumEntrySyntheticClassDescriptor m42917a(StorageManager storageManager, ClassDescriptor classDescriptor, Name name, NotNullLazyValue<Set<Name>> notNullLazyValue, Annotations annotations, SourceElement sourceElement) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumClass", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"}));
        } else if (notNullLazyValue == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumMemberNames", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"}));
        } else {
            return new EnumEntrySyntheticClassDescriptor(storageManager, classDescriptor, classDescriptor.mo7714h(), name, notNullLazyValue, annotations, sourceElement);
        }
    }

    private EnumEntrySyntheticClassDescriptor(StorageManager storageManager, ClassDescriptor classDescriptor, KotlinType kotlinType, Name name, NotNullLazyValue<Set<Name>> notNullLazyValue, Annotations annotations, SourceElement sourceElement) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingClass", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertype", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"}));
        } else if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"}));
        } else if (notNullLazyValue == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumMemberNames", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"}));
        } else if (annotations == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"}));
        } else if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"}));
        } else {
            super(storageManager, classDescriptor, name, sourceElement);
            if (f40909a != null || classDescriptor.mo7771g() == ClassKind.ENUM_CLASS) {
                this.f40914h = annotations;
                this.f40910b = new ClassTypeConstructorImpl(this, true, Collections.emptyList(), Collections.singleton(kotlinType));
                this.f40912f = new EnumEntryScope(this, storageManager);
                this.f40913g = notNullLazyValue;
                storageManager = DescriptorFactory.m27629a((ClassDescriptor) this, sourceElement);
                storageManager.m42608a((KotlinType) mo7714h());
                this.f40911c = storageManager;
                return;
            }
            throw new AssertionError();
        }
    }

    public final MemberScope mo7768d() {
        MemberScope memberScope = this.f40912f;
        if (memberScope != null) {
            return memberScope;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getUnsubstitutedMemberScope"}));
    }

    public final MemberScope mo7767b() {
        MemberScope memberScope = Empty.f38819a;
        if (memberScope != null) {
            return memberScope;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getStaticScope"}));
    }

    public final Collection<ClassConstructorDescriptor> mo7770f() {
        Collection singleton = Collections.singleton(this.f40911c);
        if (singleton != null) {
            return singleton;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getConstructors"}));
    }

    public final TypeConstructor mo7610c() {
        TypeConstructor typeConstructor = this.f40910b;
        if (typeConstructor != null) {
            return typeConstructor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getTypeConstructor"}));
    }

    public final ClassKind mo7771g() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind != null) {
            return classKind;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getKind"}));
    }

    public final Modality aG_() {
        Modality modality = Modality.f25488a;
        if (modality != null) {
            return modality;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getModality"}));
    }

    public final Visibility mo7257j() {
        Visibility visibility = Visibilities.f25508e;
        if (visibility != null) {
            return visibility;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getVisibility"}));
    }

    public final ClassConstructorDescriptor aH_() {
        return this.f40911c;
    }

    public final Annotations mo5718q() {
        Annotations annotations = this.f40914h;
        if (annotations != null) {
            return annotations;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getAnnotations"}));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("enum entry ");
        stringBuilder.append(mo6689i());
        return stringBuilder.toString();
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getDeclaredTypeParameters"}));
    }
}
