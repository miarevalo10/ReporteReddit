package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: TypeIntersectionScope.kt */
final class TypeIntersectionScope$getContributedVariables$1 extends Lambda implements Function1<PropertyDescriptor, PropertyDescriptor> {
    public static final TypeIntersectionScope$getContributedVariables$1 f38827a = new TypeIntersectionScope$getContributedVariables$1();

    TypeIntersectionScope$getContributedVariables$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) obj;
        Intrinsics.m26847b(propertyDescriptor, "$receiver");
        return propertyDescriptor;
    }
}
