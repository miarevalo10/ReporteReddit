package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final Constructor f40988n;
    private final NameResolver f40989o;
    private final TypeTable f40990p;
    private final SinceKotlinInfoTable f40991q;
    private final DeserializedContainerSource f40992r;

    public final boolean mo7747B() {
        return false;
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

    private DeserializedClassConstructorDescriptor(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations, boolean z, Kind kind, Constructor constructor, NameResolver nameResolver, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement) {
        SourceElement sourceElement2;
        ClassConstructorDescriptorImpl classConstructorDescriptorImpl = this;
        Constructor constructor2 = constructor;
        NameResolver nameResolver2 = nameResolver;
        TypeTable typeTable2 = typeTable;
        SinceKotlinInfoTable sinceKotlinInfoTable2 = sinceKotlinInfoTable;
        ClassDescriptor classDescriptor2 = classDescriptor;
        Intrinsics.m26847b(classDescriptor2, "containingDeclaration");
        Annotations annotations2 = annotations;
        Intrinsics.m26847b(annotations2, "annotations");
        Kind kind2 = kind;
        Intrinsics.m26847b(kind2, "kind");
        Intrinsics.m26847b(constructor2, "proto");
        Intrinsics.m26847b(nameResolver2, "nameResolver");
        Intrinsics.m26847b(typeTable2, "typeTable");
        Intrinsics.m26847b(sinceKotlinInfoTable2, "sinceKotlinInfoTable");
        if (sourceElement == null) {
            sourceElement2 = SourceElement.f25498a;
        } else {
            sourceElement2 = sourceElement;
        }
        super(classDescriptor2, constructorDescriptor, annotations2, z, kind2, sourceElement2);
        classConstructorDescriptorImpl.f40988n = constructor2;
        classConstructorDescriptorImpl.f40989o = nameResolver2;
        classConstructorDescriptorImpl.f40990p = typeTable2;
        classConstructorDescriptorImpl.f40991q = sinceKotlinInfoTable2;
        classConstructorDescriptorImpl.f40992r = deserializedContainerSource;
    }

    public final /* bridge */ /* synthetic */ FunctionDescriptorImpl mo7795a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        return m43094a(declarationDescriptor, functionDescriptor, kind, annotations, sourceElement);
    }

    public final /* synthetic */ ClassConstructorDescriptorImpl mo7837b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        return m43094a(declarationDescriptor, functionDescriptor, kind, annotations, sourceElement);
    }

    public final NameResolver mo7813G() {
        return this.f40989o;
    }

    public final TypeTable mo7814H() {
        return this.f40990p;
    }

    public final DeserializedContainerSource mo7815I() {
        return this.f40992r;
    }

    private DeserializedClassConstructorDescriptor m43094a(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Annotations annotations, SourceElement sourceElement) {
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = this;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.m26847b(declarationDescriptor2, "newOwner");
        Kind kind2 = kind;
        Intrinsics.m26847b(kind2, "kind");
        Annotations annotations2 = annotations;
        Intrinsics.m26847b(annotations2, "annotations");
        SourceElement sourceElement2 = sourceElement;
        Intrinsics.m26847b(sourceElement2, "source");
        if (declarationDescriptor2 != null) {
            return new DeserializedClassConstructorDescriptor((ClassDescriptor) declarationDescriptor2, (ConstructorDescriptor) functionDescriptor, annotations2, deserializedClassConstructorDescriptor.a, kind2, deserializedClassConstructorDescriptor.f40988n, deserializedClassConstructorDescriptor.f40989o, deserializedClassConstructorDescriptor.f40990p, deserializedClassConstructorDescriptor.f40991q, deserializedClassConstructorDescriptor.f40992r, sourceElement2);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    public final /* bridge */ /* synthetic */ MessageLite mo7812F() {
        return this.f40988n;
    }
}
