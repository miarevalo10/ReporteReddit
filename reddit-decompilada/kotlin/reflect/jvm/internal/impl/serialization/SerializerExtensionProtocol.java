package kotlin.reflect.jvm.internal.impl.serialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;

/* compiled from: SerializerExtensionProtocol.kt */
public class SerializerExtensionProtocol {
    public final ExtensionRegistryLite f26178c;
    public final GeneratedExtension<Constructor, List<Annotation>> f26179d;
    public final GeneratedExtension<Class, List<Annotation>> f26180e;
    public final GeneratedExtension<Function, List<Annotation>> f26181f;
    public final GeneratedExtension<Property, List<Annotation>> f26182g;
    public final GeneratedExtension<EnumEntry, List<Annotation>> f26183h;
    public final GeneratedExtension<Property, Value> f26184i;
    public final GeneratedExtension<ValueParameter, List<Annotation>> f26185j;
    public final GeneratedExtension<Type, List<Annotation>> f26186k;
    public final GeneratedExtension<TypeParameter, List<Annotation>> f26187l;

    public SerializerExtensionProtocol(ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<Constructor, List<Annotation>> generatedExtension, GeneratedExtension<Class, List<Annotation>> generatedExtension2, GeneratedExtension<Function, List<Annotation>> generatedExtension3, GeneratedExtension<Property, List<Annotation>> generatedExtension4, GeneratedExtension<EnumEntry, List<Annotation>> generatedExtension5, GeneratedExtension<Property, Value> generatedExtension6, GeneratedExtension<ValueParameter, List<Annotation>> generatedExtension7, GeneratedExtension<Type, List<Annotation>> generatedExtension8, GeneratedExtension<TypeParameter, List<Annotation>> generatedExtension9) {
        Intrinsics.m26847b(extensionRegistryLite, "extensionRegistry");
        Intrinsics.m26847b(generatedExtension, "constructorAnnotation");
        Intrinsics.m26847b(generatedExtension2, "classAnnotation");
        Intrinsics.m26847b(generatedExtension3, "functionAnnotation");
        Intrinsics.m26847b(generatedExtension4, "propertyAnnotation");
        Intrinsics.m26847b(generatedExtension5, "enumEntryAnnotation");
        Intrinsics.m26847b(generatedExtension6, "compileTimeValue");
        Intrinsics.m26847b(generatedExtension7, "parameterAnnotation");
        Intrinsics.m26847b(generatedExtension8, "typeAnnotation");
        Intrinsics.m26847b(generatedExtension9, "typeParameterAnnotation");
        this.f26178c = extensionRegistryLite;
        this.f26179d = generatedExtension;
        this.f26180e = generatedExtension2;
        this.f26181f = generatedExtension3;
        this.f26182g = generatedExtension4;
        this.f26183h = generatedExtension5;
        this.f26184i = generatedExtension6;
        this.f26185j = generatedExtension7;
        this.f26186k = generatedExtension8;
        this.f26187l = generatedExtension9;
    }
}
