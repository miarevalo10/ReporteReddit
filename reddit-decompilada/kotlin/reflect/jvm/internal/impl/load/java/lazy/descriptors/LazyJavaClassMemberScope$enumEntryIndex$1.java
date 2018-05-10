package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$enumEntryIndex$1 extends Lambda implements Function0<Map<Name, ? extends JavaField>> {
    final /* synthetic */ LazyJavaClassMemberScope f38394a;

    LazyJavaClassMemberScope$enumEntryIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        this.f38394a = lazyJavaClassMemberScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f38394a.f39724j.mo7282j()) {
            if (((JavaField) next).mo7288b()) {
                arrayList.add(next);
            }
        }
        Iterable iterable = (List) arrayList;
        Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(iterable)), 16));
        for (Object next2 : iterable) {
            linkedHashMap.put(((JavaField) next2).mo7103p(), next2);
        }
        return linkedHashMap;
    }
}
