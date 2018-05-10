package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.Factory;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: FunctionClassScope.kt */
public final class FunctionClassScope extends GivenFunctionsMemberScope {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25463a;

        static {
            int[] iArr = new int[Kind.values().length];
            f25463a = iArr;
            iArr[Kind.f25456a.ordinal()] = 1;
            f25463a[Kind.f25457b.ordinal()] = 2;
        }
    }

    public FunctionClassScope(StorageManager storageManager, FunctionClassDescriptor functionClassDescriptor) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(functionClassDescriptor, "containingClass");
        super(storageManager, functionClassDescriptor);
    }

    protected final List<FunctionDescriptor> mo7256a() {
        ClassDescriptor classDescriptor = this.f38815b;
        if (classDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        }
        Factory factory;
        switch (WhenMappings.f25463a[((FunctionClassDescriptor) classDescriptor).f40842b.ordinal()]) {
            case 1:
                factory = FunctionInvokeDescriptor.f40898a;
                return CollectionsKt__CollectionsKt.m26791a((Object) Factory.m27040a((FunctionClassDescriptor) this.f38815b, false));
            case 2:
                factory = FunctionInvokeDescriptor.f40898a;
                return CollectionsKt__CollectionsKt.m26791a((Object) Factory.m27040a((FunctionClassDescriptor) this.f38815b, true));
            default:
                return CollectionsKt__CollectionsKt.m26790a();
        }
    }
}
