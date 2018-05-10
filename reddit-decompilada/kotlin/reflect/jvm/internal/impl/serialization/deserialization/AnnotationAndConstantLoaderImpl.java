package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoaderImpl.kt */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>, AnnotationWithTarget> {
    private final AnnotationDeserializer f33031a;
    private final SerializerExtensionProtocol f33032b;

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics.m26847b(moduleDescriptor, "module");
        Intrinsics.m26847b(notFoundClasses, "notFoundClasses");
        Intrinsics.m26847b(serializerExtensionProtocol, "protocol");
        this.f33032b = serializerExtensionProtocol;
        this.f33031a = new AnnotationDeserializer(moduleDescriptor, notFoundClasses);
    }

    public final /* synthetic */ Object mo5806a(ProtoContainer protoContainer, Property property, KotlinType kotlinType) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(property, "proto");
        Intrinsics.m26847b(kotlinType, "expectedType");
        if (!property.m39930a(this.f33032b.f26184i)) {
            return null;
        }
        Object obj = (Value) property.m39931b(this.f33032b.f26184i);
        AnnotationDeserializer annotationDeserializer = this.f33031a;
        Intrinsics.m26843a(obj, "value");
        return annotationDeserializer.m27814a(kotlinType, obj, protoContainer.f26267a);
    }

    public final List<AnnotationWithTarget> mo5810a(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(messageLite, "proto");
        Intrinsics.m26847b(annotatedCallableKind, "kind");
        if ((messageLite instanceof Constructor) != null) {
            messageLite = (List) ((Constructor) messageLite).m39931b(this.f33032b.f26179d);
        } else if ((messageLite instanceof Function) != null) {
            messageLite = (List) ((Function) messageLite).m39931b(this.f33032b.f26181f);
        } else if ((messageLite instanceof Property) != null) {
            messageLite = (List) ((Property) messageLite).m39931b(this.f33032b.f26182g);
        } else {
            protoContainer = new StringBuilder("Unknown message: ");
            protoContainer.append(messageLite);
            throw ((Throwable) new IllegalStateException(protoContainer.toString().toString()));
        }
        if (messageLite == null) {
            messageLite = CollectionsKt__CollectionsKt.m26790a();
        }
        Iterable<Annotation> iterable = (Iterable) messageLite;
        Collection collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation a : iterable) {
            collection.add(new AnnotationWithTarget(this.f33031a.m27813a(a, protoContainer.f26267a), null));
        }
        return (List) collection;
    }

    public final List<AnnotationDescriptor> mo5812a(ProtoContainer protoContainer, EnumEntry enumEntry) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(enumEntry, "proto");
        enumEntry = (List) enumEntry.m39931b(this.f33032b.f26183h);
        if (enumEntry == null) {
            enumEntry = CollectionsKt__CollectionsKt.m26790a();
        }
        Iterable<Annotation> iterable = (Iterable) enumEntry;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation a : iterable) {
            arrayList.add(this.f33031a.m27813a(a, protoContainer.f26267a));
        }
        return (List) arrayList;
    }

    public final List<AnnotationDescriptor> mo5811a(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ValueParameter valueParameter) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(messageLite, "callableProto");
        Intrinsics.m26847b(annotatedCallableKind, "kind");
        Intrinsics.m26847b(valueParameter, "proto");
        messageLite = (List) valueParameter.m39931b(this.f33032b.f26185j);
        if (messageLite == null) {
            messageLite = CollectionsKt__CollectionsKt.m26790a();
        }
        Iterable<Annotation> iterable = (Iterable) messageLite;
        Collection collection = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation a : iterable) {
            collection.add(this.f33031a.m27813a(a, protoContainer.f26267a));
        }
        return (List) collection;
    }

    public final List<AnnotationDescriptor> mo5813b(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(messageLite, "proto");
        Intrinsics.m26847b(annotatedCallableKind, "kind");
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final List<AnnotationDescriptor> mo5807a(Type type, NameResolver nameResolver) {
        Intrinsics.m26847b(type, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        type = (List) type.m39931b(this.f33032b.f26186k);
        if (type == null) {
            type = CollectionsKt__CollectionsKt.m26790a();
        }
        Iterable<Annotation> iterable = (Iterable) type;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation a : iterable) {
            arrayList.add(this.f33031a.m27813a(a, nameResolver));
        }
        return (List) arrayList;
    }

    public final List<AnnotationDescriptor> mo5808a(TypeParameter typeParameter, NameResolver nameResolver) {
        Intrinsics.m26847b(typeParameter, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        typeParameter = (List) typeParameter.m39931b(this.f33032b.f26187l);
        if (typeParameter == null) {
            typeParameter = CollectionsKt__CollectionsKt.m26790a();
        }
        Iterable<Annotation> iterable = (Iterable) typeParameter;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation a : iterable) {
            arrayList.add(this.f33031a.m27813a(a, nameResolver));
        }
        return (List) arrayList;
    }

    public final List<AnnotationDescriptor> mo5809a(Class classR) {
        Intrinsics.m26847b(classR, "container");
        List list = (List) classR.f33044g.m39931b(this.f33032b.f26180e);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.m26790a();
        }
        Iterable<Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation a : iterable) {
            arrayList.add(this.f33031a.m27813a(a, classR.f26267a));
        }
        return (List) arrayList;
    }
}
