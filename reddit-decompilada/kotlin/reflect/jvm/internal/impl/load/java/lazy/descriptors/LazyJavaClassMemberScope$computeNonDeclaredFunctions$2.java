package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$computeNonDeclaredFunctions$2 extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    LazyJavaClassMemberScope$computeNonDeclaredFunctions$2(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1, lazyJavaClassMemberScope);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(LazyJavaClassMemberScope.class);
    }

    public final String mo5687b() {
        return "searchMethodsByNameWithoutBuiltinMagic";
    }

    public final String mo6932c() {
        return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "p1");
        return LazyJavaClassMemberScope.m39842a((LazyJavaClassMemberScope) this.b, name);
    }
}
