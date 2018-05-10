package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$nestedClassIndex$1 extends Lambda implements Function0<Map<Name, ? extends JavaClass>> {
    final /* synthetic */ LazyJavaClassMemberScope f38401a;

    LazyJavaClassMemberScope$nestedClassIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.f38401a = lazyJavaClassMemberScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable d = this.f38401a.f39724j.mo7276d();
        Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(d)), 16));
        for (Object next : d) {
            linkedHashMap.put(((JavaClass) next).mo7103p(), next);
        }
        return linkedHashMap;
    }
}
