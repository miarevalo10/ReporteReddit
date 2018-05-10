package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: LazyJavaScope.kt */
final class LazyJavaScope$functions$1 extends Lambda implements Function1<Name, List<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ LazyJavaScope f38417a;

    LazyJavaScope$functions$1(LazyJavaScope lazyJavaScope) {
        this.f38417a = lazyJavaScope;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaMethod javaMethod : ((DeclaredMemberIndex) this.f38417a.f38426c.invoke()).mo5781a(name)) {
            JavaMethodDescriptor a = this.f38417a.m38390a(javaMethod);
            if (this.f38417a.mo7263a(a)) {
                this.f38417a.f38427d.f25703b.f25692h.recordMethod(javaMethod, a);
                linkedHashSet.add(a);
                if (javaMethod.mo7100m()) {
                    CollectionsKt.m28092a((Collection) linkedHashSet, this.f38417a.f38427d.f25703b.f25694j.mo5774a(a));
                }
            }
        }
        Collection collection = linkedHashSet;
        this.f38417a.mo7261a(collection, name);
        return CollectionsKt.m28089a(SignatureEnhancementKt.m27269a(collection));
    }
}
