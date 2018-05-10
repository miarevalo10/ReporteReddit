package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedTypeAliasDescriptor extends AbstractTypeAliasDescriptor implements DeserializedMemberDescriptor {
    private SimpleType f40886b;
    private SimpleType f40887c;
    private List<? extends TypeParameterDescriptor> f40888d;
    private SimpleType f40889e;
    private final TypeAlias f40890f;
    private final NameResolver f40891g;
    private final TypeTable f40892h;
    private final SinceKotlinInfoTable f40893i;
    private final DeserializedContainerSource f40894j;

    public DeserializedTypeAliasDescriptor(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, Visibility visibility, TypeAlias typeAlias, NameResolver nameResolver, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource) {
        TypeAlias typeAlias2 = typeAlias;
        NameResolver nameResolver2 = nameResolver;
        TypeTable typeTable2 = typeTable;
        SinceKotlinInfoTable sinceKotlinInfoTable2 = sinceKotlinInfoTable;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.m26847b(declarationDescriptor2, "containingDeclaration");
        Annotations annotations2 = annotations;
        Intrinsics.m26847b(annotations2, "annotations");
        Name name2 = name;
        Intrinsics.m26847b(name2, "name");
        Visibility visibility2 = visibility;
        Intrinsics.m26847b(visibility2, "visibility");
        Intrinsics.m26847b(typeAlias2, "proto");
        Intrinsics.m26847b(nameResolver2, "nameResolver");
        Intrinsics.m26847b(typeTable2, "typeTable");
        Intrinsics.m26847b(sinceKotlinInfoTable2, "sinceKotlinInfoTable");
        Object obj = SourceElement.f25498a;
        Intrinsics.m26843a(obj, "SourceElement.NO_SOURCE");
        super(declarationDescriptor2, annotations2, name2, obj, visibility2);
        this.f40890f = typeAlias2;
        this.f40891g = nameResolver2;
        this.f40892h = typeTable2;
        this.f40893i = sinceKotlinInfoTable2;
        this.f40894j = deserializedContainerSource;
    }

    public final /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
        Intrinsics.m26847b(typeSubstitutor, "substitutor");
        if (typeSubstitutor.f26329b.mo5796a()) {
            typeSubstitutor = this;
        } else {
            Object aD_ = aD_();
            Intrinsics.m26843a(aD_, "containingDeclaration");
            Object q = mo5718q();
            Intrinsics.m26843a(q, "annotations");
            Object i = mo6689i();
            Intrinsics.m26843a(i, "name");
            DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(aD_, q, i, this.f40760a, this.f40890f, this.f40891g, this.f40892h, this.f40893i, this.f40894j);
            deserializedTypeAliasDescriptor.m42865a(mo7719s(), TypeSubstitutionKt.m27990a(typeSubstitutor.m28002a((KotlinType) mo7809b(), Variance.f26337a)), TypeSubstitutionKt.m27990a(typeSubstitutor.m28002a((KotlinType) m42860m(), Variance.f26337a)));
            typeSubstitutor = deserializedTypeAliasDescriptor;
        }
        return (DeclarationDescriptor) typeSubstitutor;
    }

    public final NameResolver mo7813G() {
        return this.f40891g;
    }

    public final TypeTable mo7814H() {
        return this.f40892h;
    }

    public final DeserializedContainerSource mo7815I() {
        return this.f40894j;
    }

    public final SimpleType mo7809b() {
        SimpleType simpleType = this.f40886b;
        if (simpleType == null) {
            Intrinsics.m26844a("underlyingType");
        }
        return simpleType;
    }

    private SimpleType m42860m() {
        SimpleType simpleType = this.f40887c;
        if (simpleType == null) {
            Intrinsics.m26844a("expandedType");
        }
        return simpleType;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m42865a(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r2, kotlin.reflect.jvm.internal.impl.types.SimpleType r3, kotlin.reflect.jvm.internal.impl.types.SimpleType r4) {
        /*
        r1 = this;
        r0 = "declaredTypeParameters";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r0);
        r0 = "underlyingType";
        kotlin.jvm.internal.Intrinsics.m26847b(r3, r0);
        r0 = "expandedType";
        kotlin.jvm.internal.Intrinsics.m26847b(r4, r0);
        r1.m42587a(r2);
        r1.f40886b = r3;
        r1.f40887c = r4;
        r2 = kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.m27089a(r1);
        r1.f40888d = r2;
        r2 = r1;
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r2;
        r3 = r1.mo7810d();
        if (r3 == 0) goto L_0x002c;
    L_0x0026:
        r3 = r3.mo7768d();
        if (r3 != 0) goto L_0x0030;
    L_0x002c:
        r3 = kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.f38819a;
        r3 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r3;
    L_0x0030:
        r2 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.m28008a(r2, r3);
        r3 = "TypeUtils.makeUnsubstitu…ope ?: MemberScope.Empty)";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r3);
        r1.f40889e = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor.a(java.util.List, kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.SimpleType):void");
    }

    public final ClassDescriptor mo7810d() {
        if (m42860m().mo6742d()) {
            return null;
        }
        ClassifierDescriptor c = m42860m().mo6743g().mo5724c();
        if (!(c instanceof ClassDescriptor)) {
            c = null;
        }
        return (ClassDescriptor) c;
    }

    public final SimpleType mo7714h() {
        SimpleType simpleType = this.f40889e;
        if (simpleType == null) {
            Intrinsics.m26844a("defaultTypeImpl");
        }
        return simpleType;
    }

    protected final List<TypeParameterDescriptor> mo7811k() {
        List<TypeParameterDescriptor> list = this.f40888d;
        if (list == null) {
            Intrinsics.m26844a("typeConstructorParameters");
        }
        return list;
    }

    public final /* bridge */ /* synthetic */ MessageLite mo7812F() {
        return this.f40890f;
    }
}
