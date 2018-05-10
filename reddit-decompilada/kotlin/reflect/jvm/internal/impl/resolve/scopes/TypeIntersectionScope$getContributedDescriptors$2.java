package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;

/* compiled from: TypeIntersectionScope.kt */
final class TypeIntersectionScope$getContributedDescriptors$2 extends Lambda implements Function1<CallableDescriptor, CallableDescriptor> {
    public static final TypeIntersectionScope$getContributedDescriptors$2 f38825a = new TypeIntersectionScope$getContributedDescriptors$2();

    TypeIntersectionScope$getContributedDescriptors$2() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CallableDescriptor callableDescriptor = (CallableDescriptor) obj;
        Intrinsics.m26847b(callableDescriptor, "$receiver");
        return callableDescriptor;
    }
}
