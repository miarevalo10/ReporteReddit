package kotlin.reflect.jvm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.ModuleByClassLoaderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.BitEncoding;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, d2 = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: reflectLambda.kt */
public final class ReflectLambdaKt {
    public static final <R> KFunction<R> m26890a(Function<? extends R> function) {
        Intrinsics.m26847b(function, "$receiver");
        Metadata metadata = (Metadata) function.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.m27900a(metadata.d1()));
        JvmProtoBufUtil jvmProtoBufUtil = JvmProtoBufUtil.f26297a;
        Object a = StringTableTypes.m40476a(byteArrayInputStream, JvmProtoBufUtil.m27909a());
        Intrinsics.m26843a(a, "JvmProtoBuf.StringTableT…fUtil.EXTENSION_REGISTRY)");
        JvmNameResolver jvmNameResolver = new JvmNameResolver(a, metadata.d2());
        JvmProtoBufUtil jvmProtoBufUtil2 = JvmProtoBufUtil.f26297a;
        ProtoBuf.Function a2 = ProtoBuf.Function.m41645a(byteArrayInputStream, JvmProtoBufUtil.m27909a());
        function = ModuleByClassLoaderKt.m26913a(function.getClass());
        DeserializationComponents deserializationComponents = function.f25848a;
        NameResolver nameResolver = jvmNameResolver;
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) function.f25848a.f26230c;
        Object obj = a2.f40382n;
        Intrinsics.m26843a(obj, "proto.typeTable");
        TypeTable typeTable = new TypeTable(obj);
        function = SinceKotlinInfoTable.f26281a;
        SinceKotlinInfoTable a3 = Companion.m27896a();
        Object obj2 = a2.f40378j;
        Intrinsics.m26843a(obj2, "proto.typeParameterList");
        function = new MemberDeserializer(new DeserializationContext(deserializationComponents, nameResolver, declarationDescriptor, typeTable, a3, null, null, obj2));
        Intrinsics.m26843a((Object) a2, "proto");
        return new KFunctionImpl(EmptyContainerForLocal.f38213a, function.m27852a(a2));
    }
}
