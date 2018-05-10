package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* compiled from: LazyJavaClassDescriptor.kt */
final class LazyJavaClassDescriptor$declaredParameters$1 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ LazyJavaClassDescriptor f38387a;

    LazyJavaClassDescriptor$declaredParameters$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        this.f38387a = lazyJavaClassDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<JavaTypeParameter> q = this.f38387a.f40959f.mo7284q();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
        for (JavaTypeParameter javaTypeParameter : q) {
            TypeParameterDescriptor a = this.f38387a.f40956a.f25704c.mo5779a(javaTypeParameter);
            if (a == null) {
                StringBuilder stringBuilder = new StringBuilder("Parameter ");
                stringBuilder.append(javaTypeParameter);
                stringBuilder.append(" surely belongs to class ");
                stringBuilder.append(this.f38387a.f40959f);
                stringBuilder.append(", so it must be resolved");
                throw new AssertionError(stringBuilder.toString());
            }
            arrayList.add(a);
        }
        return (List) arrayList;
    }
}
