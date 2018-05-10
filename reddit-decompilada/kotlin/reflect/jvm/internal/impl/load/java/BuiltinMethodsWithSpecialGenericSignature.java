package kotlin.reflect.jvm.internal.impl.load.java;

import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: specialBuiltinMembers.kt */
public final class BuiltinMethodsWithSpecialGenericSignature {
    public static final BuiltinMethodsWithSpecialGenericSignature f25612a = null;
    private static final List<NameAndSignature> f25613b = null;
    private static final List<String> f25614c = null;
    private static final Map<NameAndSignature, TypeSafeBarrierDescription> f25615d = null;
    private static final Map<String, TypeSafeBarrierDescription> f25616e = null;
    private static final Set<Name> f25617f = null;
    private static final Set<String> f25618g = null;

    /* compiled from: specialBuiltinMembers.kt */
    public enum SpecialSignatureInfo {
        ;
        
        private final String f25604e;
        private final boolean f25605f;

        private SpecialSignatureInfo(String str, boolean z) {
            this.f25604e = str;
            this.f25605f = z;
        }
    }

    /* compiled from: specialBuiltinMembers.kt */
    public enum TypeSafeBarrierDescription {
        ;
        
        private final Object f25611f;

        /* compiled from: specialBuiltinMembers.kt */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String str) {
                super(str, 3, null);
            }
        }

        protected TypeSafeBarrierDescription(Object obj) {
            this.f25611f = obj;
        }
    }

    static {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = new BuiltinMethodsWithSpecialGenericSignature();
    }

    private BuiltinMethodsWithSpecialGenericSignature() {
        Object c;
        f25612a = this;
        Iterable<String> a = SetsKt__SetsKt.m26802a((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (String a2 : a) {
            c = JvmPrimitiveType.BOOLEAN.m27757c();
            Intrinsics.m26843a(c, "JvmPrimitiveType.BOOLEAN.desc");
            arrayList.add(SpecialBuiltinMembers.m27168a("java/util/Collection", a2, "Ljava/util/Collection;", c));
        }
        List list = (List) arrayList;
        f25613b = list;
        Iterable<NameAndSignature> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (NameAndSignature nameAndSignature : iterable) {
            arrayList2.add(nameAndSignature.f25647b);
        }
        f25614c = (List) arrayList2;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f25810a;
        Pair[] pairArr = new Pair[10];
        c = JvmPrimitiveType.BOOLEAN.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[0] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Collection"), "contains", "Ljava/lang/Object;", c), TypeSafeBarrierDescription.f25608c);
        c = JvmPrimitiveType.BOOLEAN.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[1] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Collection"), ModQueueOptionsPresenter.ACTION_REMOVE, "Ljava/lang/Object;", c), TypeSafeBarrierDescription.f25608c);
        c = JvmPrimitiveType.BOOLEAN.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[2] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Map"), "containsKey", "Ljava/lang/Object;", c), TypeSafeBarrierDescription.f25608c);
        c = JvmPrimitiveType.BOOLEAN.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[3] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Map"), "containsValue", "Ljava/lang/Object;", c), TypeSafeBarrierDescription.f25608c);
        c = JvmPrimitiveType.BOOLEAN.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.BOOLEAN.desc");
        pairArr[4] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Map"), ModQueueOptionsPresenter.ACTION_REMOVE, "Ljava/lang/Object;Ljava/lang/Object;", c), TypeSafeBarrierDescription.f25608c);
        pairArr[5] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.f25609d);
        pairArr[6] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.f25606a);
        pairArr[7] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("Map"), ModQueueOptionsPresenter.ACTION_REMOVE, "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.f25606a);
        c = JvmPrimitiveType.INT.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.INT.desc");
        pairArr[8] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("List"), "indexOf", "Ljava/lang/Object;", c), TypeSafeBarrierDescription.f25607b);
        c = JvmPrimitiveType.INT.m27757c();
        Intrinsics.m26843a(c, "JvmPrimitiveType.INT.desc");
        pairArr[9] = TuplesKt.m26780a(SpecialBuiltinMembers.m27168a(SignatureBuildingComponents.m27362b("List"), "lastIndexOf", "Ljava/lang/Object;", c), TypeSafeBarrierDescription.f25607b);
        Map a3 = MapsKt__MapsKt.m36121a(pairArr);
        f25615d = a3;
        Map linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.m36115a(a3.size()));
        for (Entry entry : a3.entrySet()) {
            linkedHashMap.put(((NameAndSignature) entry.getKey()).f25647b, entry.getValue());
        }
        f25616e = linkedHashMap;
        Iterable<NameAndSignature> a4 = SetsKt___SetsKt.m32819a(f25615d.keySet(), (Iterable) f25613b);
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a4));
        for (NameAndSignature nameAndSignature2 : a4) {
            arrayList.add(nameAndSignature2.f25646a);
        }
        f25617f = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a4));
        for (NameAndSignature nameAndSignature3 : a4) {
            arrayList.add(nameAndSignature3.f25647b);
        }
        f25618g = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
    }

    public static final FunctionDescriptor m27133a(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        if (m27135a(functionDescriptor.mo6689i())) {
            return (FunctionDescriptor) DescriptorUtilsKt.m27734a(functionDescriptor, C2934x3e04c33b.f38360a);
        }
        return null;
    }

    public static boolean m27135a(Name name) {
        Intrinsics.m26847b(name, "$receiver");
        return f25617f.contains(name);
    }

    public static final SpecialSignatureInfo m27134a(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "$receiver");
        if ((f25617f.contains(callableMemberDescriptor.mo6689i()) ^ 1) != 0) {
            return null;
        }
        callableMemberDescriptor = DescriptorUtilsKt.m27734a(callableMemberDescriptor, C2935xdb572182.f38361a);
        if (callableMemberDescriptor != null) {
            callableMemberDescriptor = MethodSignatureMappingKt.m27348a((CallableDescriptor) callableMemberDescriptor);
            if (callableMemberDescriptor != null) {
                if (f25614c.contains(callableMemberDescriptor)) {
                    return SpecialSignatureInfo.f25600a;
                }
                callableMemberDescriptor = f25616e.get(callableMemberDescriptor);
                if (callableMemberDescriptor == null) {
                    Intrinsics.m26842a();
                }
                if (Intrinsics.m26845a((TypeSafeBarrierDescription) callableMemberDescriptor, TypeSafeBarrierDescription.f25606a) != null) {
                    return SpecialSignatureInfo.f25602c;
                }
                return SpecialSignatureInfo.f25601b;
            }
        }
        return null;
    }
}
