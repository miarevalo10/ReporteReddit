package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2 extends AbstractNodeHandler<ClassDescriptor, Unit> {
    final /* synthetic */ ClassDescriptor f36096a;
    final /* synthetic */ Set f36097b;
    final /* synthetic */ Function1 f36098c;

    LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ClassDescriptor classDescriptor, Set set, Function1 function1) {
        this.f36096a = classDescriptor;
        this.f36097b = set;
        this.f36098c = function1;
    }

    public final /* bridge */ /* synthetic */ Object mo6700a() {
        return Unit.f25273a;
    }

    public final /* synthetic */ boolean mo5948a(Object obj) {
        ClassDescriptor classDescriptor = (ClassDescriptor) obj;
        Intrinsics.m26847b(classDescriptor, "current");
        if (classDescriptor != this.f36096a) {
            obj = classDescriptor.mo7767b();
            if (obj instanceof LazyJavaStaticScope) {
                Set set = this.f36097b;
                Function1 function1 = this.f36098c;
                Intrinsics.m26843a(obj, "staticScope");
                set.addAll((Collection) function1.mo6492a(obj));
                return null;
            }
        }
        return true;
    }
}
