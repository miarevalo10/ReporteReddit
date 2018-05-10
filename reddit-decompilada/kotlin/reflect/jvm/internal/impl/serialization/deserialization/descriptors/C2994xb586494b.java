package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion;

/* compiled from: DeserializedClassDescriptor.kt */
final class C2994xb586494b extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    final /* synthetic */ DeserializedClassMemberScope f38872a;

    C2994xb586494b(DeserializedClassMemberScope deserializedClassMemberScope) {
        this.f38872a = deserializedClassMemberScope;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        DeserializedClassMemberScope deserializedClassMemberScope = this.f38872a;
        DescriptorKindFilter descriptorKindFilter = DescriptorKindFilter.f26113c;
        Companion companion = MemberScope.f32953f;
        return deserializedClassMemberScope.m38640a(descriptorKindFilter, Companion.m27788a(), NoLookupLocation.f32683m);
    }
}
