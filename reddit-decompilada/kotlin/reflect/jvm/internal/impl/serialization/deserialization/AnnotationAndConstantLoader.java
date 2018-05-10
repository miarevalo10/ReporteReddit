package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoader.kt */
public interface AnnotationAndConstantLoader<A, C, T> {
    C mo5806a(ProtoContainer protoContainer, Property property, KotlinType kotlinType);

    List<A> mo5807a(Type type, NameResolver nameResolver);

    List<A> mo5808a(TypeParameter typeParameter, NameResolver nameResolver);

    List<A> mo5809a(Class classR);

    List<T> mo5810a(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);

    List<A> mo5811a(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ValueParameter valueParameter);

    List<A> mo5812a(ProtoContainer protoContainer, EnumEntry enumEntry);

    List<A> mo5813b(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind);
}
