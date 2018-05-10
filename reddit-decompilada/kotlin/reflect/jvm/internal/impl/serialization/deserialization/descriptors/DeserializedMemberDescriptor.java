package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;

/* compiled from: DeserializedMemberDescriptor.kt */
public interface DeserializedMemberDescriptor extends MemberDescriptor {
    MessageLite mo7812F();

    NameResolver mo7813G();

    TypeTable mo7814H();

    DeserializedContainerSource mo7815I();
}
