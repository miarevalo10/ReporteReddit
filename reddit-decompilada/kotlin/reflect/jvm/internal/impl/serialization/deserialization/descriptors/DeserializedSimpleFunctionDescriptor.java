package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedSimpleFunctionDescriptor extends SimpleFunctionDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final Function f40973a;
    private final NameResolver f40974b;
    private final TypeTable f40975n;
    private final SinceKotlinInfoTable f40976o;
    private final DeserializedContainerSource f40977p;

    private DeserializedSimpleFunctionDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, Name name, Kind kind, Function function, NameResolver nameResolver, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement) {
        SourceElement sourceElement2;
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = this;
        Function function2 = function;
        NameResolver nameResolver2 = nameResolver;
        TypeTable typeTable2 = typeTable;
        SinceKotlinInfoTable sinceKotlinInfoTable2 = sinceKotlinInfoTable;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.m26847b(declarationDescriptor2, "containingDeclaration");
        Annotations annotations2 = annotations;
        Intrinsics.m26847b(annotations2, "annotations");
        Name name2 = name;
        Intrinsics.m26847b(name2, "name");
        Kind kind2 = kind;
        Intrinsics.m26847b(kind2, "kind");
        Intrinsics.m26847b(function2, "proto");
        Intrinsics.m26847b(nameResolver2, "nameResolver");
        Intrinsics.m26847b(typeTable2, "typeTable");
        Intrinsics.m26847b(sinceKotlinInfoTable2, "sinceKotlinInfoTable");
        if (sourceElement == null) {
            sourceElement2 = SourceElement.f25498a;
        } else {
            sourceElement2 = sourceElement;
        }
        super(declarationDescriptor2, simpleFunctionDescriptor, annotations2, name2, kind2, sourceElement2);
        simpleFunctionDescriptorImpl.f40973a = function2;
        simpleFunctionDescriptorImpl.f40974b = nameResolver2;
        simpleFunctionDescriptorImpl.f40975n = typeTable2;
        simpleFunctionDescriptorImpl.f40976o = sinceKotlinInfoTable2;
        simpleFunctionDescriptorImpl.f40977p = deserializedContainerSource;
    }

    public final NameResolver mo7813G() {
        return this.f40974b;
    }

    public final TypeTable mo7814H() {
        return this.f40975n;
    }

    public final DeserializedContainerSource mo7815I() {
        return this.f40977p;
    }

    protected final FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Name name2;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = this;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.m26847b(declarationDescriptor2, "newOwner");
        Kind kind2 = kind;
        Intrinsics.m26847b(kind2, "kind");
        Annotations annotations2 = annotations;
        Intrinsics.m26847b(annotations2, "annotations");
        SourceElement sourceElement2 = sourceElement;
        Intrinsics.m26847b(sourceElement2, "source");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            Name i = mo6689i();
            Intrinsics.m26843a((Object) i, "name");
            name2 = i;
        } else {
            name2 = name;
        }
        return new DeserializedSimpleFunctionDescriptor(declarationDescriptor2, simpleFunctionDescriptor, annotations2, name2, kind2, deserializedSimpleFunctionDescriptor.f40973a, deserializedSimpleFunctionDescriptor.f40974b, deserializedSimpleFunctionDescriptor.f40975n, deserializedSimpleFunctionDescriptor.f40976o, deserializedSimpleFunctionDescriptor.f40977p, sourceElement2);
    }

    public final /* bridge */ /* synthetic */ MessageLite mo7812F() {
        return this.f40973a;
    }
}
