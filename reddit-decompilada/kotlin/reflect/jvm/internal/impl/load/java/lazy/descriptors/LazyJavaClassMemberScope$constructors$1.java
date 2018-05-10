package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {
    final /* synthetic */ LazyJavaClassMemberScope f38392a;
    final /* synthetic */ LazyJavaResolverContext f38393b;

    LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        this.f38392a = lazyJavaClassMemberScope;
        this.f38393b = lazyJavaResolverContext;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Collection<JavaConstructor> k = this.f38392a.f39724j.mo7283k();
        ArrayList arrayList = new ArrayList(k.size());
        for (JavaConstructor a : k) {
            JavaClassConstructorDescriptor a2 = LazyJavaClassMemberScope.m39848a(this.f38392a, a);
            arrayList.add(a2);
            CollectionsKt.m28092a((Collection) arrayList, this.f38393b.f25703b.f25694j.mo5774a(a2));
        }
        Collection collection = arrayList;
        if (collection.isEmpty()) {
            collection = CollectionsKt.m28087a(LazyJavaClassMemberScope.m39859b(this.f38392a));
        }
        return CollectionsKt.m28089a(SignatureEnhancementKt.m27269a(collection));
    }
}
