package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;

public class IntersectionTypeConstructor implements TypeConstructor {
    static final /* synthetic */ boolean f33071a = true;
    private final Set<KotlinType> f33072b;
    private final int f33073c;

    public final ClassifierDescriptor mo5724c() {
        return null;
    }

    public final boolean mo5725d() {
        return false;
    }

    public IntersectionTypeConstructor(Collection<KotlinType> collection) {
        if (f33071a || !collection.isEmpty()) {
            this.f33072b = new LinkedHashSet(collection);
            this.f33073c = this.f33072b.hashCode();
            return;
        }
        throw new AssertionError("Attempt to create an empty intersection");
    }

    public final List<TypeParameterDescriptor> mo5723b() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/IntersectionTypeConstructor", "getParameters"}));
    }

    public final Collection<KotlinType> aL_() {
        Collection collection = this.f33072b;
        if (collection != null) {
            return collection;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/IntersectionTypeConstructor", "getSupertypes"}));
    }

    public final MemberScope m33606f() {
        StringBuilder stringBuilder = new StringBuilder("member scope for intersection type ");
        stringBuilder.append(this);
        return TypeIntersectionScope.m38595a(stringBuilder.toString(), this.f33072b);
    }

    public final KotlinBuiltIns mo5726e() {
        KotlinBuiltIns e = ((KotlinType) this.f33072b.iterator().next()).mo6743g().mo5726e();
        if (e != null) {
            return e;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/types/IntersectionTypeConstructor", "getBuiltIns"}));
    }

    public String toString() {
        Iterable iterable = this.f33072b;
        StringBuilder stringBuilder = new StringBuilder("{");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((KotlinType) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(" & ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) obj;
                if (this.f33072b == null) {
                    return intersectionTypeConstructor.f33072b == null;
                } else {
                    if (this.f33072b.equals(intersectionTypeConstructor.f33072b) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f33073c;
    }
}
