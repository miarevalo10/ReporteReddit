package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

public class ClassTypeConstructorImpl extends AbstractClassTypeConstructor implements TypeConstructor {
    private final ClassDescriptor f38922a;
    private final List<TypeParameterDescriptor> f38923b;
    private final Collection<KotlinType> f38924c;
    private final boolean f38925d;

    public ClassTypeConstructorImpl(ClassDescriptor classDescriptor, boolean z, List<? extends TypeParameterDescriptor> list, Collection<KotlinType> collection) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classDescriptor", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "<init>"}));
        } else if (list == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"parameters", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "<init>"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"supertypes", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "<init>"}));
        } else {
            super(LockBasedStorageManager.f33053a);
            this.f38922a = classDescriptor;
            this.f38925d = z;
            this.f38923b = Collections.unmodifiableList(new ArrayList(list));
            this.f38924c = Collections.unmodifiableCollection(collection);
        }
    }

    public final List<TypeParameterDescriptor> mo5723b() {
        List<TypeParameterDescriptor> list = this.f38923b;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "getParameters"}));
    }

    public String toString() {
        return DescriptorUtils.m27653c(this.f38922a).m27418b();
    }

    public final boolean mo5725d() {
        return this.f38925d;
    }

    protected final Collection<KotlinType> mo6684a() {
        Collection<KotlinType> collection = this.f38924c;
        if (collection != null) {
            return collection;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "computeSupertypes"}));
    }

    protected final SupertypeLoopChecker aK_() {
        SupertypeLoopChecker supertypeLoopChecker = EMPTY.f32638a;
        if (supertypeLoopChecker != null) {
            return supertypeLoopChecker;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "getSupertypeLoopChecker"}));
    }

    public final /* synthetic */ ClassifierDescriptor mo5724c() {
        ClassifierDescriptor classifierDescriptor = this.f38922a;
        if (classifierDescriptor != null) {
            return classifierDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "getDeclarationDescriptor"}));
    }
}
