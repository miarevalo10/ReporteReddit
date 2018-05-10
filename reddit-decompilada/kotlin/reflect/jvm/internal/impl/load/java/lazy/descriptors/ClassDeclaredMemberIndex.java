package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: DeclaredMemberIndex.kt */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    final Function1<JavaMember, Boolean> f32714a;
    private final Function1<JavaMethod, Boolean> f32715b = ((Function1) new ClassDeclaredMemberIndex$methodFilter$1(this));
    private final Map<Name, List<JavaMethod>> f32716c;
    private final Map<Name, JavaField> f32717d;
    private final JavaClass f32718e;

    public ClassDeclaredMemberIndex(JavaClass javaClass, Function1<? super JavaMember, Boolean> function1) {
        Intrinsics.m26847b(javaClass, "jClass");
        Intrinsics.m26847b(function1, "memberFilter");
        this.f32718e = javaClass;
        this.f32714a = function1;
        Map map = (Map) new LinkedHashMap();
        javaClass = SequencesKt___SequencesKt.m33708a((Sequence) CollectionsKt___CollectionsKt.m41455t(this.f32718e.mo7281i()), (Function1) this.f32715b).mo5679a();
        while (javaClass.hasNext()) {
            Object next = javaClass.next();
            Name p = ((JavaMethod) next).mo7103p();
            ArrayList arrayList = map.get(p);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(p, arrayList);
            }
            arrayList.add(next);
        }
        this.f32716c = map;
        map = (Map) new LinkedHashMap();
        javaClass = SequencesKt___SequencesKt.m33708a((Sequence) CollectionsKt___CollectionsKt.m41455t(this.f32718e.mo7282j()), (Function1) this.f32714a).mo5679a();
        while (javaClass.hasNext()) {
            next = javaClass.next();
            map.put(((JavaField) next).mo7103p(), next);
        }
        this.f32717d = map;
    }

    public final Collection<JavaMethod> mo5781a(Name name) {
        Intrinsics.m26847b(name, "name");
        List list = (List) this.f32716c.get(name);
        return list != null ? list : CollectionsKt__CollectionsKt.m26790a();
    }

    public final Set<Name> mo5782a() {
        Collection linkedHashSet = new LinkedHashSet();
        Iterator a = SequencesKt___SequencesKt.m33708a(CollectionsKt___CollectionsKt.m41455t(this.f32718e.mo7281i()), this.f32715b).mo5679a();
        while (a.hasNext()) {
            linkedHashSet.add(((JavaMethod) a.next()).mo7103p());
        }
        return (Set) linkedHashSet;
    }

    public final JavaField mo5784b(Name name) {
        Intrinsics.m26847b(name, "name");
        return (JavaField) this.f32717d.get(name);
    }

    public final Set<Name> mo5783b() {
        Collection linkedHashSet = new LinkedHashSet();
        Iterator a = SequencesKt___SequencesKt.m33708a(CollectionsKt___CollectionsKt.m41455t(this.f32718e.mo7282j()), this.f32714a).mo5679a();
        while (a.hasNext()) {
            linkedHashSet.add(((JavaField) a.next()).mo7103p());
        }
        return (Set) linkedHashSet;
    }
}
