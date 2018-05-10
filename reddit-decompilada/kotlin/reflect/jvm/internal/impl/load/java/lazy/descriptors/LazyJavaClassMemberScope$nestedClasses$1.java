package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {
    final /* synthetic */ LazyJavaClassMemberScope f38403a;
    final /* synthetic */ LazyJavaResolverContext f38404b;

    LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        this.f38403a = lazyJavaClassMemberScope;
        this.f38404b = lazyJavaResolverContext;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Name name = (Name) obj;
        Intrinsics.m26847b(name, "name");
        JavaClass javaClass = (JavaClass) ((Map) this.f38403a.f39721g.invoke()).get(name);
        if (javaClass != null) {
            return new LazyJavaClassDescriptor(this.f38404b, this.f38403a.f39720b, javaClass);
        }
        JavaField javaField = (JavaField) ((Map) this.f38403a.f39722h.invoke()).get(name);
        if (javaField != null) {
            obj = EnumEntrySyntheticClassDescriptor.m42917a(this.f38404b.f25703b.f25685a, this.f38403a.f39720b, name, this.f38404b.f25703b.f25685a.mo5926a((Function0) new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this)), LazyJavaAnnotationsKt.m27201a(this.f38404b, javaField), this.f38404b.f25703b.f25695k.mo5773a(javaField));
        } else {
            obj = null;
        }
        return (ClassDescriptorBase) obj;
    }
}
