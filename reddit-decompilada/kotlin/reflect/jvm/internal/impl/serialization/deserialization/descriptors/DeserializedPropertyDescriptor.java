package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedPropertyDescriptor extends PropertyDescriptorImpl implements DeserializedCallableMemberDescriptor {
    public final Property f40993m;
    public final NameResolver f40994n;
    public final TypeTable f40995o;
    public final DeserializedContainerSource f40996p;
    private final SinceKotlinInfoTable f40997q;

    public DeserializedPropertyDescriptor(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations annotations, Modality modality, Visibility visibility, boolean z, Name name, Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, Property property, NameResolver nameResolver, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource) {
        Property property2 = property;
        NameResolver nameResolver2 = nameResolver;
        TypeTable typeTable2 = typeTable;
        SinceKotlinInfoTable sinceKotlinInfoTable2 = sinceKotlinInfoTable;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.m26847b(declarationDescriptor2, "containingDeclaration");
        Annotations annotations2 = annotations;
        Intrinsics.m26847b(annotations2, "annotations");
        Modality modality2 = modality;
        Intrinsics.m26847b(modality2, "modality");
        Visibility visibility2 = visibility;
        Intrinsics.m26847b(visibility2, "visibility");
        Name name2 = name;
        Intrinsics.m26847b(name2, "name");
        Kind kind2 = kind;
        Intrinsics.m26847b(kind2, "kind");
        Intrinsics.m26847b(property2, "proto");
        Intrinsics.m26847b(nameResolver2, "nameResolver");
        Intrinsics.m26847b(typeTable2, "typeTable");
        Intrinsics.m26847b(sinceKotlinInfoTable2, "sinceKotlinInfoTable");
        super(declarationDescriptor2, propertyDescriptor, annotations2, modality2, visibility2, z, name2, kind2, SourceElement.f25498a, z2, z3, false, false, z4, z5);
        this.f40993m = property;
        this.f40994n = nameResolver;
        this.f40995o = typeTable;
        this.f40997q = sinceKotlinInfoTable;
        this.f40996p = deserializedContainerSource;
    }

    public final /* synthetic */ boolean mo7745p() {
        return m43105D().booleanValue();
    }

    public final NameResolver mo7813G() {
        return this.f40994n;
    }

    public final TypeTable mo7814H() {
        return this.f40995o;
    }

    public final DeserializedContainerSource mo7815I() {
        return this.f40996p;
    }

    protected final PropertyDescriptorImpl mo7839a(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, PropertyDescriptor propertyDescriptor, Kind kind) {
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.m26847b(declarationDescriptor2, "newOwner");
        Modality modality2 = modality;
        Intrinsics.m26847b(modality2, "newModality");
        Visibility visibility2 = visibility;
        Intrinsics.m26847b(visibility2, "newVisibility");
        Kind kind2 = kind;
        Intrinsics.m26847b(kind2, "kind");
        Annotations q = mo5718q();
        boolean z = this.f40860j;
        Object i = mo6689i();
        Intrinsics.m26843a(i, "name");
        boolean z2 = this.f40935b;
        boolean A = mo7776A();
        Object D = m43105D();
        Intrinsics.m26843a(D, "isExternal");
        boolean booleanValue = D.booleanValue();
        boolean z3 = this.f40936c;
        Property property = this.f40993m;
        NameResolver nameResolver = this.f40994n;
        Property property2 = property;
        NameResolver nameResolver2 = nameResolver;
        return new DeserializedPropertyDescriptor(declarationDescriptor2, propertyDescriptor, q, modality2, visibility2, z, i, kind2, z2, A, booleanValue, z3, property2, nameResolver2, this.f40995o, this.f40997q, this.f40996p);
    }

    private Boolean m43105D() {
        return Flags.f26172w.m33502a(this.f40993m.f40420e);
    }

    public final /* bridge */ /* synthetic */ MessageLite mo7812F() {
        return this.f40993m;
    }
}
