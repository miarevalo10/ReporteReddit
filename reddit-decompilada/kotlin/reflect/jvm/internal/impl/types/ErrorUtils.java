package kotlin.reflect.jvm.internal.impl.types;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.Capability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceKind;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl;

public class ErrorUtils {
    public static final SimpleType f26313a = m27943c("<LOOP IN SUPERTYPES>");
    private static final ModuleDescriptor f26314b = new C30001();
    private static final ErrorClassDescriptor f26315c = new ErrorClassDescriptor(null);
    private static final KotlinType f26316d = m27943c("<ERROR PROPERTY TYPE>");
    private static final PropertyDescriptor f26317e;
    private static final Set<PropertyDescriptor> f26318f;

    public static class UninferredParameterTypeConstructor implements TypeConstructor {
        public final TypeParameterDescriptor f33066a;
        private final TypeConstructor f33067b;

        public final List<TypeParameterDescriptor> mo5723b() {
            List<TypeParameterDescriptor> b = this.f33067b.mo5723b();
            if (b != null) {
                return b;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getParameters"}));
        }

        public final Collection<KotlinType> aL_() {
            Collection<KotlinType> aL_ = this.f33067b.aL_();
            if (aL_ != null) {
                return aL_;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getSupertypes"}));
        }

        public final boolean mo5725d() {
            return this.f33067b.mo5725d();
        }

        public final ClassifierDescriptor mo5724c() {
            return this.f33067b.mo5724c();
        }

        public final KotlinBuiltIns mo5726e() {
            KotlinBuiltIns d = DescriptorUtilsKt.m27745d(this.f33066a);
            if (d != null) {
                return d;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getBuiltIns"}));
        }
    }

    public static class ErrorScope implements MemberScope {
        private final String f36168a;

        public final /* synthetic */ Collection mo6694a(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedVariables"}));
            } else if (lookupLocation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedVariables"}));
            } else {
                name = ErrorUtils.f26318f;
                if (name != null) {
                    return name;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedVariables"}));
            }
        }

        public final /* synthetic */ Collection mo6698b(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedFunctions"}));
            } else if (lookupLocation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedFunctions"}));
            } else {
                name = Collections.singleton(ErrorUtils.m27933a(this));
                if (name != null) {
                    return name;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedFunctions"}));
            }
        }

        private ErrorScope(String str) {
            if (str == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "<init>"}));
            } else {
                this.f36168a = str;
            }
        }

        public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedClassifier"}));
            } else if (lookupLocation != null) {
                return ErrorUtils.m27931a(name.m27429a());
            } else {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedClassifier"}));
            }
        }

        public final Set<Name> aE_() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getFunctionNames"}));
        }

        public final Set<Name> aF_() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getVariableNames"}));
        }

        public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kindFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedDescriptors"}));
            } else if (function1 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"nameFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedDescriptors"}));
            } else {
                descriptorKindFilter = Collections.emptyList();
                if (descriptorKindFilter != null) {
                    return descriptorKindFilter;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedDescriptors"}));
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ErrorScope{");
            stringBuilder.append(this.f36168a);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class ThrowingScope implements MemberScope {
        private final String f36169a;

        private ThrowingScope(String str) {
            if (str == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"message", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "<init>"}));
            } else {
                this.f36169a = str;
            }
        }

        public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedClassifier"}));
            } else if (lookupLocation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedClassifier"}));
            } else {
                throw new IllegalStateException();
            }
        }

        public final Collection mo6694a(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedVariables"}));
            } else if (lookupLocation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedVariables"}));
            } else {
                throw new IllegalStateException();
            }
        }

        public final Collection mo6698b(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedFunctions"}));
            } else if (lookupLocation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedFunctions"}));
            } else {
                throw new IllegalStateException();
            }
        }

        public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"kindFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedDescriptors"}));
            } else if (function1 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"nameFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedDescriptors"}));
            } else {
                throw new IllegalStateException();
            }
        }

        public final Set<Name> aE_() {
            throw new IllegalStateException();
        }

        public final Set<Name> aF_() {
            throw new IllegalStateException();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ThrowingScope{");
            stringBuilder.append(this.f36169a);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static class C30001 implements ModuleDescriptor {
        public final <R, D> R mo7078a(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            if (declarationDescriptorVisitor != null) {
                return null;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visitor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "accept"}));
        }

        public final <T> T mo7085a(Capability<T> capability) {
            if (capability != null) {
                return null;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"capability", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getCapability"}));
        }

        public final boolean mo7088a(ModuleDescriptor moduleDescriptor) {
            if (moduleDescriptor != null) {
                return false;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"targetModule", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "shouldSeeInternalsOf"}));
        }

        public final DeclarationDescriptor aD_() {
            return null;
        }

        C30001() {
        }

        public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "substitute"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "substitute"}));
            }
        }

        public final SourceKind mo7090c() {
            SourceKind sourceKind = SourceKind.f25500a;
            if (sourceKind != null) {
                return sourceKind;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSourceKind"}));
        }

        public final Annotations mo5718q() {
            Companion companion = Annotations.f32643a;
            Annotations a = Companion.m27115a();
            if (a != null) {
                return a;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getAnnotations"}));
        }

        public final Collection<FqName> mo7086a(FqName fqName, Function1<? super Name, Boolean> function1) {
            if (fqName == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSubPackagesOf"}));
            } else if (function1 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"nameFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSubPackagesOf"}));
            } else {
                fqName = CollectionsKt__CollectionsKt.m26790a();
                if (fqName != null) {
                    return fqName;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSubPackagesOf"}));
            }
        }

        public final Name mo6689i() {
            return Name.m27426c("<ERROR MODULE>");
        }

        public final PackageViewDescriptor mo7087a(FqName fqName) {
            if (fqName == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fqName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getPackage"}));
            }
            throw new IllegalStateException("Should not be called!");
        }

        public final DeclarationDescriptor aJ_() {
            if (this != null) {
                return this;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getOriginal"}));
        }

        public final KotlinBuiltIns mo7089b() {
            KotlinBuiltIns b = DefaultBuiltIns.m32915b();
            if (b != null) {
                return b;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getBuiltIns"}));
        }
    }

    private static class ErrorTypeImpl extends SimpleType {
        private final TypeConstructor f39978a;
        private final MemberScope f39979b;
        private final List<TypeProjection> f39980c;
        private final boolean f39981d;

        public final boolean mo6742d() {
            return true;
        }

        public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
            return mo7296b(annotations);
        }

        public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
            return mo7297b(z);
        }

        private ErrorTypeImpl(TypeConstructor typeConstructor, MemberScope memberScope, List<TypeProjection> list, boolean z) {
            if (typeConstructor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"constructor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"}));
            } else if (memberScope == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"memberScope", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"}));
            } else if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"arguments", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"}));
            } else {
                this.f39978a = typeConstructor;
                this.f39979b = memberScope;
                this.f39980c = list;
                this.f39981d = z;
            }
        }

        private ErrorTypeImpl(TypeConstructor typeConstructor, MemberScope memberScope) {
            if (typeConstructor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"constructor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"}));
            } else if (memberScope == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"memberScope", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"}));
            } else {
                this(typeConstructor, memberScope, Collections.emptyList(), false);
            }
        }

        public final TypeConstructor mo6743g() {
            TypeConstructor typeConstructor = this.f39978a;
            if (typeConstructor != null) {
                return typeConstructor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getConstructor"}));
        }

        public final List<TypeProjection> mo6739a() {
            List<TypeProjection> list = this.f39980c;
            if (list != null) {
                return list;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getArguments"}));
        }

        public final boolean mo6741c() {
            return this.f39981d;
        }

        public final MemberScope mo6740b() {
            MemberScope memberScope = this.f39979b;
            if (memberScope != null) {
                return memberScope;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getMemberScope"}));
        }

        public final Annotations mo5718q() {
            Companion companion = Annotations.f32643a;
            Annotations a = Companion.m27115a();
            if (a != null) {
                return a;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getAnnotations"}));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f39978a.toString());
            stringBuilder.append(this.f39980c.isEmpty() ? "" : CollectionsKt___CollectionsKt.m41411a(this.f39980c, ", ", Operation.LESS_THAN, Operation.GREATER_THAN, -1, "...", null));
            return stringBuilder.toString();
        }

        public final SimpleType mo7296b(Annotations annotations) {
            if (annotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"newAnnotations", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "replaceAnnotations"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "replaceAnnotations"}));
            }
        }

        public final SimpleType mo7297b(boolean z) {
            return new ErrorTypeImpl(this.f39978a, this.f39979b, this.f39980c, z);
        }
    }

    private static class ErrorClassDescriptor extends ClassDescriptorImpl {
        public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
            return mo7840a(typeSubstitutor);
        }

        public ErrorClassDescriptor(String str) {
            DeclarationDescriptor a = ErrorUtils.m27932a();
            if (str == null) {
                str = "<ERROR CLASS>";
            } else {
                StringBuilder stringBuilder = new StringBuilder("<ERROR CLASS: ");
                stringBuilder.append(str);
                stringBuilder.append(Operation.GREATER_THAN);
                str = stringBuilder.toString();
            }
            super(a, Name.m27426c(str), Modality.f25490c, ClassKind.CLASS, Collections.emptyList(), SourceElement.f25498a);
            str = Annotations.f32643a;
            str = ClassConstructorDescriptorImpl.m42883a((ClassDescriptor) this, Companion.m27115a(), SourceElement.f25498a);
            str.m42889a(Collections.emptyList(), Visibilities.f25507d);
            MemberScope b = ErrorUtils.m27941b(mo6689i().m27429a());
            str.m42608a(new ErrorTypeImpl(ErrorUtils.m27942b("<ERROR>", this), b));
            m42902a(b, Collections.singleton(str), str);
        }

        public final ClassDescriptor mo7840a(TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"substitutor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "substitute"}));
            } else if (this != null) {
                return this;
            } else {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "substitute"}));
            }
        }

        public String toString() {
            return mo6689i().m27429a();
        }

        public final MemberScope mo7737a(List<? extends TypeProjection> list) {
            if (list == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeArguments", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"}));
            }
            StringBuilder stringBuilder = new StringBuilder("Error scope for class ");
            stringBuilder.append(mo6689i());
            stringBuilder.append(" with arguments: ");
            stringBuilder.append(list);
            list = ErrorUtils.m27941b(stringBuilder.toString());
            if (list != null) {
                return list;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"}));
        }

        public final MemberScope mo7738a(TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeSubstitution", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"}));
            }
            StringBuilder stringBuilder = new StringBuilder("Error scope for class ");
            stringBuilder.append(mo6689i());
            stringBuilder.append(" with arguments: ");
            stringBuilder.append(typeSubstitution);
            typeSubstitution = ErrorUtils.m27941b(stringBuilder.toString());
            if (typeSubstitution != null) {
                return typeSubstitution;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"}));
        }
    }

    static /* synthetic */ SimpleFunctionDescriptor m27933a(ErrorScope errorScope) {
        if (errorScope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"ownerScope", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorFunction"}));
        }
        SimpleFunctionDescriptor errorSimpleFunctionDescriptorImpl = new ErrorSimpleFunctionDescriptorImpl(f26315c, errorScope);
        errorSimpleFunctionDescriptorImpl.mo7833b(null, null, Collections.emptyList(), Collections.emptyList(), m27943c("<ERROR FUNCTION RETURN TYPE>"), Modality.f25490c, Visibilities.f25508e);
        return errorSimpleFunctionDescriptorImpl;
    }

    static {
        DeclarationDescriptor declarationDescriptor = f26315c;
        Companion companion = Annotations.f32643a;
        PropertyDescriptor a = PropertyDescriptorImpl.m42981a(declarationDescriptor, Companion.m27115a(), Modality.f25490c, Visibilities.f25508e, Name.m27426c("<ERROR PROPERTY>"), Kind.DECLARATION, SourceElement.f25498a);
        a.m42991a(f26316d, Collections.emptyList(), null, null);
        f26317e = a;
        f26318f = Collections.singleton(a);
    }

    public static ClassDescriptor m27931a(String str) {
        if (str != null) {
            return new ErrorClassDescriptor(str);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorClass"}));
    }

    public static MemberScope m27941b(String str) {
        if (str != null) {
            return m27934a(str, false);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorScope"}));
    }

    public static MemberScope m27934a(String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorScope"}));
        } else if (z) {
            return new ThrowingScope(str);
        } else {
            return new ErrorScope(str);
        }
    }

    public static SimpleType m27943c(String str) {
        if (str != null) {
            return m27935a(str, Collections.emptyList());
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorType"}));
    }

    public static SimpleType m27936a(String str, TypeConstructor typeConstructor) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithCustomConstructor"}));
        } else if (typeConstructor != null) {
            return new ErrorTypeImpl(typeConstructor, m27941b(str));
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeConstructor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithCustomConstructor"}));
        }
    }

    public static SimpleType m27935a(String str, List<TypeProjection> list) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithArguments"}));
        } else if (list != null) {
            return new ErrorTypeImpl(m27945e(str), m27941b(str), (List) list);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"arguments", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithArguments"}));
        }
    }

    public static TypeConstructor m27945e(String str) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructor"}));
        }
        StringBuilder stringBuilder = new StringBuilder("[ERROR : ");
        stringBuilder.append(str);
        stringBuilder.append("]");
        return m27942b(stringBuilder.toString(), f26315c);
    }

    private static TypeConstructor m27942b(final String str, final ErrorClassDescriptor errorClassDescriptor) {
        if (str == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"debugName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructorWithCustomDebugName"}));
        } else if (errorClassDescriptor != null) {
            return new TypeConstructor() {
                public final boolean mo5725d() {
                    return false;
                }

                public final List<TypeParameterDescriptor> mo5723b() {
                    List<TypeParameterDescriptor> a = CollectionsKt__CollectionsKt.m26790a();
                    if (a != null) {
                        return a;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2", "getParameters"}));
                }

                public final Collection<KotlinType> aL_() {
                    Collection a = CollectionsKt__CollectionsKt.m26790a();
                    if (a != null) {
                        return a;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2", "getSupertypes"}));
                }

                public final ClassifierDescriptor mo5724c() {
                    return errorClassDescriptor;
                }

                public final KotlinBuiltIns mo5726e() {
                    KotlinBuiltIns b = DefaultBuiltIns.m32915b();
                    if (b != null) {
                        return b;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2", "getBuiltIns"}));
                }

                public final String toString() {
                    return str;
                }
            };
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"errorClass", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructorWithCustomDebugName"}));
        }
    }

    public static ModuleDescriptor m27932a() {
        ModuleDescriptor moduleDescriptor = f26314b;
        if (moduleDescriptor != null) {
            return moduleDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "getErrorModule"}));
    }

    public static boolean m27939a(KotlinType kotlinType) {
        return (kotlinType == null || (kotlinType.mo6743g() instanceof UninferredParameterTypeConstructor) == null) ? null : true;
    }

    public static SimpleType m27944d(String str) {
        return m27936a(str, m27942b(str, f26315c));
    }

    public static boolean m27938a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            return false;
        }
        if (!((declarationDescriptor instanceof ErrorClassDescriptor) || (declarationDescriptor.aD_() instanceof ErrorClassDescriptor))) {
            if (declarationDescriptor != f26314b) {
                return false;
            }
        }
        return true;
    }
}
