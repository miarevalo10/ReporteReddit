package kotlin.reflect.jvm.internal.impl.load.java;

import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinMethodsWithDifferentJvmName {
    public static final BuiltinMethodsWithDifferentJvmName f25594a = null;
    private static final NameAndSignature f25595b = null;
    private static final Map<NameAndSignature, Name> f25596c = null;
    private static final Map<String, Name> f25597d = null;
    private static final List<Name> f25598e = null;
    private static final Map<Name, List<Name>> f25599f = null;

    static {
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = new BuiltinMethodsWithDifferentJvmName();
    }

    private BuiltinMethodsWithDifferentJvmName() {
        f25594a = this;
        Object c = JvmPrimitiveType.INT.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.INT.desc");
        f25595b = SpecialBuiltinMembers.m27168a("java/util/List", "removeAt", c, "Ljava/lang/Object;");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        Pair[] pairArr = new Pair[8];
        Object c2 = JvmPrimitiveType.BYTE.m27757c();
        Intrinsics.m26843a(c2, "JvmPrimitiveType.BYTE.desc");
        pairArr[0] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27357a("Number"), "toByte", "", c2), Name.m27424a("byteValue"));
        c2 = JvmPrimitiveType.SHORT.m27757c();
        Intrinsics.m26843a(c2, "JvmPrimitiveType.SHORT.desc");
        pairArr[1] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27357a("Number"), "toShort", "", c2), Name.m27424a("shortValue"));
        c2 = JvmPrimitiveType.INT.m27757c();
        Intrinsics.m26843a(c2, "JvmPrimitiveType.INT.desc");
        pairArr[2] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27357a("Number"), "toInt", "", c2), Name.m27424a("intValue"));
        c2 = JvmPrimitiveType.LONG.m27757c();
        Intrinsics.m26843a(c2, "JvmPrimitiveType.LONG.desc");
        pairArr[3] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27357a("Number"), "toLong", "", c2), Name.m27424a("longValue"));
        c2 = JvmPrimitiveType.FLOAT.m27757c();
        Intrinsics.m26843a(c2, "JvmPrimitiveType.FLOAT.desc");
        pairArr[4] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27357a("Number"), "toFloat", "", c2), Name.m27424a("floatValue"));
        c2 = JvmPrimitiveType.DOUBLE.m27757c();
        Intrinsics.m26843a(c2, "JvmPrimitiveType.DOUBLE.desc");
        pairArr[5] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27357a("Number"), "toDouble", "", c2), Name.m27424a("doubleValue"));
        pairArr[6] = TuplesKt.m26780a(f25595b, Name.m27424a(ModQueueOptionsPresenter.ACTION_REMOVE));
        Object c3 = JvmPrimitiveType.INT.m27757c();
        Intrinsics.m26843a(c3, "JvmPrimitiveType.INT.desc");
        c2 = JvmPrimitiveType.CHAR.m27757c();
        Intrinsics.m26843a(c2, "JvmPrimitiveType.CHAR.desc");
        pairArr[7] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27357a("CharSequence"), "get", c3, c2), Name.m27424a("charAt"));
        Map a = MapsKt__MapsKt.m36121a(pairArr);
        f25596c = a;
        Map linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.m36115a(a.size()));
        for (Entry entry : a.entrySet()) {
            linkedHashMap.put(((NameAndSignature) entry.getKey()).f25647b, entry.getValue());
        }
        f25597d = linkedHashMap;
        Iterable<NameAndSignature> keySet = f25596c.keySet();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(keySet));
        for (NameAndSignature nameAndSignature : keySet) {
            arrayList.add(nameAndSignature.f25646a);
        }
        f25598e = (List) arrayList;
        Iterable<Entry> entrySet = f25596c.entrySet();
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(entrySet));
        for (Entry entry2 : entrySet) {
            arrayList.add(new Pair(((NameAndSignature) entry2.getKey()).f25646a, entry2.getValue()));
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
        f25599f = a;
    }

    public static List<Name> m27126a() {
        return f25598e;
    }

    public static boolean m27128a(Name name) {
        Intrinsics.m26847b(name, "$receiver");
        return f25598e.contains(name);
    }

    public static Name m27127a(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.m26847b(simpleFunctionDescriptor, "functionDescriptor");
        Map map = f25597d;
        simpleFunctionDescriptor = MethodSignatureMappingKt.m27348a((CallableDescriptor) simpleFunctionDescriptor);
        return simpleFunctionDescriptor == null ? null : (Name) map.get(simpleFunctionDescriptor);
    }

    public static boolean m27131b(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.m26847b(simpleFunctionDescriptor, "functionDescriptor");
        return (!KotlinBuiltIns.m26973a((DeclarationDescriptor) simpleFunctionDescriptor) || DescriptorUtilsKt.m27734a(simpleFunctionDescriptor, new C2933x6ce919c0(simpleFunctionDescriptor)) == null) ? null : true;
    }

    public static List<Name> m27129b(Name name) {
        Intrinsics.m26847b(name, "name");
        List list = (List) f25599f.get(name);
        return list == null ? CollectionsKt__CollectionsKt.m26790a() : list;
    }

    public static boolean m27132c(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.m26847b(simpleFunctionDescriptor, "$receiver");
        return (!Intrinsics.m26845a(simpleFunctionDescriptor.mo6689i().m27429a(), (Object) "removeAt") || Intrinsics.m26845a(MethodSignatureMappingKt.m27348a((CallableDescriptor) simpleFunctionDescriptor), f25595b.f25647b) == null) ? null : true;
    }
}
