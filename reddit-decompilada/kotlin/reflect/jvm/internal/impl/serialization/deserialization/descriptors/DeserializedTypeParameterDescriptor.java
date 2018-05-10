package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter.Variance;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final DeserializedAnnotationsWithPossibleTargets f40895b = new DeserializedAnnotationsWithPossibleTargets(this.f40896c.f26245c.f26229b, (Function0) new DeserializedTypeParameterDescriptor$annotations$1(this));
    private final DeserializationContext f40896c;
    private final TypeParameter f40897d;

    public final /* synthetic */ void mo7774a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        StringBuilder stringBuilder = new StringBuilder("There should be no cycles for deserialized type parameters, but found for: ");
        stringBuilder.append(this);
        throw ((Throwable) new IllegalStateException(stringBuilder.toString()));
    }

    protected final List<KotlinType> mo7775m() {
        List a = ProtoTypeTableUtilKt.m27867a(this.f40897d, this.f40896c.f26248f);
        if (a.isEmpty()) {
            return CollectionsKt__CollectionsKt.m26791a((Object) DescriptorUtilsKt.m27745d(this).m27017o());
        }
        Iterable<Type> iterable = a;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Type type : iterable) {
            TypeDeserializer typeDeserializer = this.f40896c.f26243a;
            Companion companion = Annotations.f32643a;
            arrayList.add(typeDeserializer.m27890a(type, Companion.m27115a()));
        }
        return (List) arrayList;
    }

    public final /* bridge */ /* synthetic */ Annotations mo5718q() {
        return this.f40895b;
    }

    public DeserializedTypeParameterDescriptor(DeserializationContext deserializationContext, TypeParameter typeParameter, int i) {
        Intrinsics.m26847b(deserializationContext, "c");
        Intrinsics.m26847b(typeParameter, "proto");
        StorageManager storageManager = deserializationContext.f26245c.f26229b;
        DeclarationDescriptor declarationDescriptor = deserializationContext.f26247e;
        Name b = deserializationContext.f26246d.mo5830b(typeParameter.f40506f);
        Variance variance = typeParameter.f40508h;
        Intrinsics.m26843a((Object) variance, "proto.variance");
        super(storageManager, declarationDescriptor, b, Deserialization.m27831a(variance), typeParameter.f40507g, i, SourceElement.f25498a, EMPTY.f32638a);
        this.f40896c = deserializationContext;
        this.f40897d = typeParameter;
    }
}
