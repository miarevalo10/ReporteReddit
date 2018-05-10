package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor implements TypeConstructor {
    private int f36167a;

    public abstract ClassifierDescriptor mo5724c();

    public AbstractClassTypeConstructor(StorageManager storageManager) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"storageManager", "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "<init>"}));
        }
        super(storageManager);
        this.f36167a = 0;
    }

    public final int hashCode() {
        int i = this.f36167a;
        if (i != 0) {
            return i;
        }
        DeclarationDescriptor c = mo5724c();
        if ((c instanceof ClassDescriptor) && m36414a(c)) {
            i = DescriptorUtils.m27653c(c).hashCode();
        } else {
            i = System.identityHashCode(this);
        }
        this.f36167a = i;
        return i;
    }

    public final KotlinBuiltIns mo5726e() {
        KotlinBuiltIns d = DescriptorUtilsKt.m27745d(mo5724c());
        if (d != null) {
            return d;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "getBuiltIns"}));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        if (typeConstructor.mo5723b().size() != mo5723b().size()) {
            return false;
        }
        DeclarationDescriptor c = mo5724c();
        DeclarationDescriptor c2 = typeConstructor.mo5724c();
        if (c == c2) {
            return true;
        }
        if (m36414a(c)) {
            if (c2 == null || m36414a(c2)) {
                if ((c instanceof ClassDescriptor) == null || (c2 instanceof ClassDescriptor) == null) {
                    return false;
                }
                return DescriptorUtils.m27653c(c).equals(DescriptorUtils.m27653c(c2));
            }
        }
        if (this == obj) {
            return true;
        }
        return false;
    }

    private static boolean m36414a(ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor != null) {
            return !ErrorUtils.m27938a((DeclarationDescriptor) classifierDescriptor) && DescriptorUtils.m27651b((DeclarationDescriptor) classifierDescriptor) == null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "hasMeaningfulFqName"}));
        }
    }

    protected final Collection<KotlinType> mo6733g() {
        DeclarationDescriptor aD_ = mo5724c().aD_();
        Collection singleton;
        if (aD_ instanceof ClassDescriptor) {
            singleton = Collections.singleton(((ClassDescriptor) aD_).mo7714h());
            if (singleton != null) {
                return singleton;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "getAdditionalNeighboursInSupertypeGraph"}));
        }
        singleton = Collections.emptyList();
        if (singleton != null) {
            return singleton;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "getAdditionalNeighboursInSupertypeGraph"}));
    }
}
