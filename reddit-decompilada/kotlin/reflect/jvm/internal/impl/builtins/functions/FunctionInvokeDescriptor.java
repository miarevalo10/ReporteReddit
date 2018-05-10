package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* compiled from: FunctionInvokeDescriptor.kt */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory f40898a = new Factory();

    /* compiled from: FunctionInvokeDescriptor.kt */
    public static final class Factory {
        private Factory() {
        }

        public static FunctionInvokeDescriptor m27040a(FunctionClassDescriptor functionClassDescriptor, boolean z) {
            Object h;
            FunctionClassDescriptor functionClassDescriptor2 = functionClassDescriptor;
            Intrinsics.m26847b(functionClassDescriptor2, "functionClass");
            List list = functionClassDescriptor2.f40841a;
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClassDescriptor2, Kind.DECLARATION, z);
            ReceiverParameterDescriptor u = functionClassDescriptor.mo7740u();
            List a = CollectionsKt__CollectionsKt.m26790a();
            Iterable iterable = list;
            ArrayList arrayList = new ArrayList();
            for (Object h2 : iterable) {
                if (!Intrinsics.m26845a(((TypeParameterDescriptor) h2).mo7716k(), Variance.f26338b)) {
                    break;
                }
                arrayList.add(h2);
            }
            Iterable<IndexedValue> q = CollectionsKt___CollectionsKt.m41452q(arrayList);
            Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
            for (IndexedValue indexedValue : q) {
                CallableDescriptor callableDescriptor;
                Companion companion;
                Annotations a2;
                Name a3;
                KotlinType kotlinType;
                SourceElement sourceElement;
                Factory factory = FunctionInvokeDescriptor.f40898a;
                int i = indexedValue.f25277a;
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) indexedValue.f25278b;
                String a4 = typeParameterDescriptor.mo6689i().m27429a();
                int hashCode = a4.hashCode();
                if (hashCode != 69) {
                    if (hashCode == 84) {
                        if (a4.equals("T")) {
                            a4 = "instance";
                            callableDescriptor = functionInvokeDescriptor;
                            companion = Annotations.f32643a;
                            a2 = Companion.m27115a();
                            a3 = Name.m27424a(a4);
                            Intrinsics.m26843a((Object) a3, "Name.identifier(name)");
                            h2 = typeParameterDescriptor.mo7714h();
                            Intrinsics.m26843a(h2, "typeParameter.defaultType");
                            kotlinType = (KotlinType) h2;
                            sourceElement = SourceElement.f25498a;
                            Intrinsics.m26843a((Object) sourceElement, "SourceElement.NO_SOURCE");
                            arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, a2, a3, kotlinType, false, false, false, null, sourceElement));
                        }
                    }
                } else if (a4.equals("E")) {
                    a4 = "receiver";
                    callableDescriptor = functionInvokeDescriptor;
                    companion = Annotations.f32643a;
                    a2 = Companion.m27115a();
                    a3 = Name.m27424a(a4);
                    Intrinsics.m26843a((Object) a3, "Name.identifier(name)");
                    h2 = typeParameterDescriptor.mo7714h();
                    Intrinsics.m26843a(h2, "typeParameter.defaultType");
                    kotlinType = (KotlinType) h2;
                    sourceElement = SourceElement.f25498a;
                    Intrinsics.m26843a((Object) sourceElement, "SourceElement.NO_SOURCE");
                    arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, a2, a3, kotlinType, false, false, false, null, sourceElement));
                }
                if (a4 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                a4 = a4.toLowerCase();
                Intrinsics.m26843a((Object) a4, "(this as java.lang.String).toLowerCase()");
                callableDescriptor = functionInvokeDescriptor;
                companion = Annotations.f32643a;
                a2 = Companion.m27115a();
                a3 = Name.m27424a(a4);
                Intrinsics.m26843a((Object) a3, "Name.identifier(name)");
                h2 = typeParameterDescriptor.mo7714h();
                Intrinsics.m26843a(h2, "typeParameter.defaultType");
                kotlinType = (KotlinType) h2;
                sourceElement = SourceElement.f25498a;
                Intrinsics.m26843a((Object) sourceElement, "SourceElement.NO_SOURCE");
                arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, a2, a3, kotlinType, false, false, false, null, sourceElement));
            }
            functionInvokeDescriptor.mo7833b(null, u, a, (List) arrayList2, ((TypeParameterDescriptor) CollectionsKt___CollectionsKt.m41437f(list)).mo7714h(), Modality.f25491d, Visibilities.f25508e);
            functionInvokeDescriptor.mo7838b(true);
            return functionInvokeDescriptor;
        }
    }

    public final boolean mo7752b() {
        return false;
    }

    public final boolean mo7753c() {
        return false;
    }

    public final boolean mo7745p() {
        return false;
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, Kind kind, boolean z) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = functionInvokeDescriptor;
        functionInvokeDescriptor = Annotations.f32643a;
        super(declarationDescriptor, simpleFunctionDescriptor, Companion.m27115a(), OperatorNameConventions.f26399g, kind, SourceElement.f25498a);
        this.f40767e = true;
        this.f40774l = z;
        mo7836a((boolean) null);
    }

    protected final FunctionDescriptor mo7816a(CopyConfiguration copyConfiguration) {
        Intrinsics.m26847b(copyConfiguration, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.mo7816a(copyConfiguration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        Iterator it = functionInvokeDescriptor.mo7757k().iterator();
        Object obj;
        do {
            Object obj2 = null;
            obj = 1;
            if (!it.hasNext()) {
                obj2 = 1;
                break;
            } else if (FunctionTypesKt.m26954g(((ValueParameterDescriptor) it.next()).mo7777x()) != null) {
                continue;
            } else {
                obj = null;
                continue;
            }
        } while (obj == null);
        if (obj2 != null) {
            return functionInvokeDescriptor;
        }
        Iterable<ValueParameterDescriptor> k = functionInvokeDescriptor.mo7757k();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(k));
        for (ValueParameterDescriptor x : k) {
            arrayList.add(FunctionTypesKt.m26954g(x.mo7777x()));
        }
        return functionInvokeDescriptor.m42876a((List) arrayList);
    }

    protected final FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.m26847b(declarationDescriptor, "newOwner");
        Intrinsics.m26847b(kind, "kind");
        Intrinsics.m26847b(annotations, "annotations");
        Intrinsics.m26847b(sourceElement, "source");
        return (FunctionDescriptorImpl) new FunctionInvokeDescriptor(declarationDescriptor, (FunctionInvokeDescriptor) functionDescriptor, kind, mo7747B());
    }

    private final FunctionDescriptor m42876a(List<Name> list) {
        boolean z;
        Iterable<ValueParameterDescriptor> k;
        Collection arrayList;
        Object i;
        int i2;
        Name name;
        List list2;
        CopyConfiguration e;
        int size = mo7757k().size() - list.size();
        boolean z2 = false;
        if (size != 0) {
            if (size != 1) {
                z = false;
                if (_Assertions.f25274a || r3) {
                    k = mo7757k();
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(k));
                    for (ValueParameterDescriptor valueParameterDescriptor : k) {
                        i = valueParameterDescriptor.mo6689i();
                        int c = valueParameterDescriptor.mo7801c();
                        i2 = c - size;
                        if (i2 >= 0) {
                            name = (Name) list.get(i2);
                            if (name != null) {
                                i = name;
                            }
                        }
                        CallableDescriptor callableDescriptor = this;
                        Intrinsics.m26843a(i, "newName");
                        arrayList.add(valueParameterDescriptor.mo7799a(callableDescriptor, i, c));
                    }
                    list2 = (List) arrayList;
                    e = m42618e(TypeSubstitutor.f26327a);
                    for (Name name2 : list) {
                        if (name2 != null) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            z2 = true;
                            break;
                        }
                    }
                    e.f32661p = Boolean.valueOf(z2);
                    list = super.mo7816a((CopyConfiguration) e.m32998b(list2).m32995a((FunctionDescriptor) m42807u()));
                    if (list == null) {
                        Intrinsics.m26842a();
                    }
                    return list;
                }
                throw new AssertionError("Assertion failed");
            }
        }
        z = true;
        if (_Assertions.f25274a) {
        }
        k = mo7757k();
        arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(k));
        for (ValueParameterDescriptor valueParameterDescriptor2 : k) {
            i = valueParameterDescriptor2.mo6689i();
            int c2 = valueParameterDescriptor2.mo7801c();
            i2 = c2 - size;
            if (i2 >= 0) {
                name = (Name) list.get(i2);
                if (name != null) {
                    i = name;
                }
            }
            CallableDescriptor callableDescriptor2 = this;
            Intrinsics.m26843a(i, "newName");
            arrayList.add(valueParameterDescriptor2.mo7799a(callableDescriptor2, i, c2));
        }
        list2 = (List) arrayList;
        e = m42618e(TypeSubstitutor.f26327a);
        while (list.hasNext()) {
            if (name2 != null) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                z2 = true;
                break;
            }
        }
        e.f32661p = Boolean.valueOf(z2);
        list = super.mo7816a((CopyConfiguration) e.m32998b(list2).m32995a((FunctionDescriptor) m42807u()));
        if (list == null) {
            Intrinsics.m26842a();
        }
        return list;
    }
}
