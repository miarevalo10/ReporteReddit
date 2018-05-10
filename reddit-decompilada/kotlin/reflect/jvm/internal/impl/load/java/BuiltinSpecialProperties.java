package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinSpecialProperties {
    public static final BuiltinSpecialProperties f25619a = null;
    private static final Map<FqName, Name> f25620b = null;
    private static final Map<Name, List<Name>> f25621c = null;
    private static final Set<FqName> f25622d = null;
    private static final Set<Name> f25623e = null;

    static {
        BuiltinSpecialProperties builtinSpecialProperties = new BuiltinSpecialProperties();
    }

    private BuiltinSpecialProperties() {
        f25619a = this;
        Map a = MapsKt__MapsKt.m36121a(TuplesKt.m26780a(SpecialBuiltinMembers.m27170a(KotlinBuiltIns.f25420j.f25397r, "name"), Name.m27424a("name")), TuplesKt.m26780a(SpecialBuiltinMembers.m27170a(KotlinBuiltIns.f25420j.f25397r, "ordinal"), Name.m27424a("ordinal")), TuplesKt.m26780a(SpecialBuiltinMembers.m27169a(KotlinBuiltIns.f25420j.f25366M, "size"), Name.m27424a("size")), TuplesKt.m26780a(SpecialBuiltinMembers.m27169a(KotlinBuiltIns.f25420j.f25370Q, "size"), Name.m27424a("size")), TuplesKt.m26780a(SpecialBuiltinMembers.m27170a(KotlinBuiltIns.f25420j.f25385f, "length"), Name.m27424a("length")), TuplesKt.m26780a(SpecialBuiltinMembers.m27169a(KotlinBuiltIns.f25420j.f25370Q, "keys"), Name.m27424a("keySet")), TuplesKt.m26780a(SpecialBuiltinMembers.m27169a(KotlinBuiltIns.f25420j.f25370Q, "values"), Name.m27424a("values")), TuplesKt.m26780a(SpecialBuiltinMembers.m27169a(KotlinBuiltIns.f25420j.f25370Q, "entries"), Name.m27424a("entrySet")));
        f25620b = a;
        Iterable<Entry> entrySet = a.entrySet();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(entrySet));
        for (Entry entry : entrySet) {
            arrayList.add(new Pair(((FqName) entry.getKey()).m27412e(), entry.getValue()));
        }
        a = new LinkedHashMap();
        for (Pair pair : (List) arrayList) {
            Name name = (Name) pair.f25268b;
            ArrayList arrayList2 = a.get(name);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                a.put(name, arrayList2);
            }
            arrayList2.add((Name) pair.f25267a);
        }
        f25621c = a;
        Set keySet = f25620b.keySet();
        f25622d = keySet;
        Iterable<FqName> iterable = keySet;
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (FqName e : iterable) {
            arrayList.add(e.m27412e());
        }
        f25623e = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
    }

    public static Set<Name> m27138a() {
        return f25623e;
    }

    public static boolean m27139a(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "callableMemberDescriptor");
        if ((f25623e.contains(callableMemberDescriptor.mo6689i()) ^ 1) != 0) {
            return false;
        }
        if (CollectionsKt___CollectionsKt.m41420a((Iterable) f25622d, (Object) DescriptorUtilsKt.m27737a((CallableDescriptor) callableMemberDescriptor)) && callableMemberDescriptor.mo7757k().isEmpty()) {
            return true;
        }
        if (KotlinBuiltIns.m26973a((DeclarationDescriptor) callableMemberDescriptor)) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.mo7609m()) {
                Intrinsics.m26843a((Object) callableMemberDescriptor2, "it");
                if (m27139a(callableMemberDescriptor2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Name> m27137a(Name name) {
        Intrinsics.m26847b(name, "name1");
        List list = (List) f25621c.get(name);
        return list == null ? CollectionsKt__CollectionsKt.m26790a() : list;
    }

    public static String m27140b(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "$receiver");
        boolean a = KotlinBuiltIns.m26973a((DeclarationDescriptor) callableMemberDescriptor);
        if (!_Assertions.f25274a || a) {
            callableMemberDescriptor = DescriptorUtilsKt.m27734a(DescriptorUtilsKt.m27733a(callableMemberDescriptor), C2936xbe16cae4.f38362a);
            if (callableMemberDescriptor == null) {
                return null;
            }
            Name name = (Name) f25620b.get(DescriptorUtilsKt.m27742b((DeclarationDescriptor) callableMemberDescriptor));
            if (name != null) {
                return name.m27429a();
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("This method is defined only for builtin members, but ");
        stringBuilder.append(callableMemberDescriptor);
        stringBuilder.append(" found");
        throw new AssertionError(stringBuilder.toString());
    }
}
