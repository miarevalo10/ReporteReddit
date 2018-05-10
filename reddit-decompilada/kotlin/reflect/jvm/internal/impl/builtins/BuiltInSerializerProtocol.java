package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.builtins.BuiltInsProtoBuf;

/* compiled from: BuiltInSerializerProtocol.kt */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    static final String f32611a = "kotlin_builtins";
    public static final BuiltInSerializerProtocol f32612b = null;

    static {
        BuiltInSerializerProtocol builtInSerializerProtocol = new BuiltInSerializerProtocol();
    }

    private BuiltInSerializerProtocol() {
        Object a = ExtensionRegistryLite.m27503a();
        ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) a;
        BuiltInsProtoBuf.m27798a(extensionRegistryLite);
        Intrinsics.m26843a(a, "ExtensionRegistryLite.ne…sterAllExtensions(this) }");
        Object obj = BuiltInsProtoBuf.f26190c;
        Intrinsics.m26843a(obj, "BuiltInsProtoBuf.constructorAnnotation");
        Object obj2 = BuiltInsProtoBuf.f26189b;
        Intrinsics.m26843a(obj2, "BuiltInsProtoBuf.classAnnotation");
        Object obj3 = BuiltInsProtoBuf.f26191d;
        Intrinsics.m26843a(obj3, "BuiltInsProtoBuf.functionAnnotation");
        Object obj4 = BuiltInsProtoBuf.f26192e;
        Intrinsics.m26843a(obj4, "BuiltInsProtoBuf.propertyAnnotation");
        Object obj5 = BuiltInsProtoBuf.f26194g;
        Intrinsics.m26843a(obj5, "BuiltInsProtoBuf.enumEntryAnnotation");
        Object obj6 = BuiltInsProtoBuf.f26193f;
        Intrinsics.m26843a(obj6, "BuiltInsProtoBuf.compileTimeValue");
        Object obj7 = BuiltInsProtoBuf.f26195h;
        Intrinsics.m26843a(obj7, "BuiltInsProtoBuf.parameterAnnotation");
        Object obj8 = BuiltInsProtoBuf.f26196i;
        Intrinsics.m26843a(obj8, "BuiltInsProtoBuf.typeAnnotation");
        Object obj9 = BuiltInsProtoBuf.f26197j;
        Intrinsics.m26843a(obj9, "BuiltInsProtoBuf.typeParameterAnnotation");
        super(extensionRegistryLite, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        f32612b = this;
        f32611a = f32611a;
    }
}
