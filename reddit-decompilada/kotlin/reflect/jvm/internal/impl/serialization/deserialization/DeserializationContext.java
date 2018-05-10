package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;

/* compiled from: context.kt */
public final class DeserializationContext {
    public final TypeDeserializer f26243a;
    public final MemberDeserializer f26244b = new MemberDeserializer(this);
    public final DeserializationComponents f26245c;
    public final NameResolver f26246d;
    public final DeclarationDescriptor f26247e;
    public final TypeTable f26248f;
    public final SinceKotlinInfoTable f26249g;
    public final DeserializedContainerSource f26250h;

    public DeserializationContext(DeserializationComponents deserializationComponents, NameResolver nameResolver, DeclarationDescriptor declarationDescriptor, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource, TypeDeserializer typeDeserializer, List<TypeParameter> list) {
        Intrinsics.m26847b(deserializationComponents, "components");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(declarationDescriptor, "containingDeclaration");
        Intrinsics.m26847b(typeTable, "typeTable");
        Intrinsics.m26847b(sinceKotlinInfoTable, "sinceKotlinInfoTable");
        Intrinsics.m26847b(list, "typeParameters");
        this.f26245c = deserializationComponents;
        this.f26246d = nameResolver;
        this.f26247e = declarationDescriptor;
        this.f26248f = typeTable;
        this.f26249g = sinceKotlinInfoTable;
        this.f26250h = deserializedContainerSource;
        nameResolver = new StringBuilder("Deserializer for ");
        nameResolver.append(this.f26247e.mo6689i());
        this.f26243a = new TypeDeserializer(this, typeDeserializer, list, nameResolver.toString());
    }

    public final DeserializationContext m27835a(DeclarationDescriptor declarationDescriptor, List<TypeParameter> list, NameResolver nameResolver, TypeTable typeTable) {
        Intrinsics.m26847b(declarationDescriptor, "descriptor");
        Intrinsics.m26847b(list, "typeParameterProtos");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(typeTable, "typeTable");
        return new DeserializationContext(this.f26245c, nameResolver, declarationDescriptor, typeTable, this.f26249g, this.f26250h, this.f26243a, list);
    }
}
