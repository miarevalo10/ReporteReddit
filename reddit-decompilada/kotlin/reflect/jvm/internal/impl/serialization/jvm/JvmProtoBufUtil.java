package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.PackageData;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: JvmProtoBufUtil.kt */
public final class JvmProtoBufUtil {
    public static final JvmProtoBufUtil f26297a = null;
    private static final ExtensionRegistryLite f26298b = null;

    /* compiled from: JvmProtoBufUtil.kt */
    public static final class PropertySignature {
        public final String f26295a;
        public final String f26296b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof PropertySignature) {
                    PropertySignature propertySignature = (PropertySignature) obj;
                    if (Intrinsics.m26845a(this.f26295a, propertySignature.f26295a) && Intrinsics.m26845a(this.f26296b, propertySignature.f26296b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f26295a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f26296b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("PropertySignature(name=");
            stringBuilder.append(this.f26295a);
            stringBuilder.append(", desc=");
            stringBuilder.append(this.f26296b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public PropertySignature(String str, String str2) {
            Intrinsics.m26847b(str, "name");
            Intrinsics.m26847b(str2, "desc");
            this.f26295a = str;
            this.f26296b = str2;
        }
    }

    static {
        JvmProtoBufUtil jvmProtoBufUtil = new JvmProtoBufUtil();
    }

    private JvmProtoBufUtil() {
        f26297a = this;
        Object a = ExtensionRegistryLite.m27503a();
        JvmProtoBuf.m27905a(a);
        Intrinsics.m26843a(a, "registry");
        Intrinsics.m26843a(a, "run {\n        val regist…y)\n        registry\n    }");
        f26298b = (ExtensionRegistryLite) a;
    }

    public static ExtensionRegistryLite m27909a() {
        return f26298b;
    }

    public static final ClassData m27910a(String[] strArr, String[] strArr2) {
        Intrinsics.m26847b(strArr, "data");
        Intrinsics.m26847b(strArr2, "strings");
        Object a = BitEncoding.m27900a(strArr);
        Intrinsics.m26843a(a, "BitEncoding.decodeBytes(data)");
        Intrinsics.m26847b(a, "bytes");
        Intrinsics.m26847b(strArr2, "strings");
        InputStream byteArrayInputStream = new ByteArrayInputStream(a);
        Object a2 = StringTableTypes.m40476a(byteArrayInputStream, f26298b);
        Intrinsics.m26843a(a2, "JvmProtoBuf.StringTableT…nput, EXTENSION_REGISTRY)");
        strArr = new JvmNameResolver(a2, strArr2);
        Object a3 = Class.m41539a(byteArrayInputStream, f26298b);
        NameResolver nameResolver = (NameResolver) strArr;
        Intrinsics.m26843a(a3, "classProto");
        return new ClassData(nameResolver, a3);
    }

    public static final PackageData m27912b(String[] strArr, String[] strArr2) {
        Intrinsics.m26847b(strArr, "data");
        Intrinsics.m26847b(strArr2, "strings");
        Object a = BitEncoding.m27900a(strArr);
        Intrinsics.m26843a(a, "BitEncoding.decodeBytes(data)");
        Intrinsics.m26847b(a, "bytes");
        Intrinsics.m26847b(strArr2, "strings");
        InputStream byteArrayInputStream = new ByteArrayInputStream(a);
        Object a2 = StringTableTypes.m40476a(byteArrayInputStream, f26298b);
        Intrinsics.m26843a(a2, "JvmProtoBuf.StringTableT…nput, EXTENSION_REGISTRY)");
        strArr = new JvmNameResolver(a2, strArr2);
        Object a3 = Package.m41689a(byteArrayInputStream, f26298b);
        NameResolver nameResolver = (NameResolver) strArr;
        Intrinsics.m26843a(a3, "packageProto");
        return new PackageData(nameResolver, a3);
    }

    public static String m27907a(Function function, NameResolver nameResolver, TypeTable typeTable) {
        int i;
        Intrinsics.m26847b(function, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(typeTable, "typeTable");
        JvmMethodSignature jvmMethodSignature = function.m39930a(JvmProtoBuf.f26288b) ? (JvmMethodSignature) function.m39931b(JvmProtoBuf.f26288b) : null;
        if (jvmMethodSignature == null || !jvmMethodSignature.m40392h()) {
            i = function.f40375g;
        } else {
            i = jvmMethodSignature.f39922c;
        }
        if (jvmMethodSignature == null || !jvmMethodSignature.m40393i()) {
            Collection b = CollectionsKt.m28094b(ProtoTypeTableUtilKt.m27876b(function, typeTable));
            Iterable<ValueParameter> iterable = function.f40381m;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (ValueParameter a : iterable) {
                arrayList.add(ProtoTypeTableUtilKt.m27873a(a, typeTable));
            }
            Iterable<Type> b2 = CollectionsKt___CollectionsKt.m41423b(b, (Iterable) (List) arrayList);
            Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(b2));
            for (Type a2 : b2) {
                String a3 = m27908a(a2, nameResolver);
                if (a3 == null) {
                    return null;
                }
                arrayList2.add(a3);
            }
            List list = (List) arrayList2;
            function = m27908a(ProtoTypeTableUtilKt.m27868a(function, typeTable), nameResolver);
            if (function == null) {
                return null;
            }
            typeTable = new StringBuilder();
            typeTable.append(CollectionsKt___CollectionsKt.m41412a((Iterable) list, (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, null, null, 56));
            typeTable.append(function);
            function = typeTable.toString();
        } else {
            function = nameResolver.mo5829a(jvmMethodSignature.f39923d);
        }
        typeTable = new StringBuilder();
        typeTable.append(nameResolver.mo5829a(i));
        typeTable.append(function);
        return typeTable.toString();
    }

    public static String m27906a(Constructor constructor, NameResolver nameResolver, TypeTable typeTable) {
        Intrinsics.m26847b(constructor, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(typeTable, "typeTable");
        JvmMethodSignature jvmMethodSignature = constructor.m39930a(JvmProtoBuf.f26287a) ? (JvmMethodSignature) constructor.m39931b(JvmProtoBuf.f26287a) : null;
        if (jvmMethodSignature == null || !jvmMethodSignature.m40393i()) {
            Iterable<ValueParameter> iterable = (Iterable) constructor.f40344f;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (ValueParameter a : iterable) {
                String a2 = m27908a(ProtoTypeTableUtilKt.m27873a(a, typeTable), nameResolver);
                if (a2 == null) {
                    return null;
                }
                arrayList.add(a2);
            }
            constructor = CollectionsKt___CollectionsKt.m41412a((Iterable) (List) arrayList, (CharSequence) "", (CharSequence) "(", (CharSequence) ")V", 0, null, null, 56);
        } else {
            constructor = nameResolver.mo5829a(jvmMethodSignature.f39923d);
        }
        nameResolver = new StringBuilder("<init>");
        nameResolver.append(constructor);
        return nameResolver.toString();
    }

    public static PropertySignature m27911a(Property property, NameResolver nameResolver, TypeTable typeTable) {
        Intrinsics.m26847b(property, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (!property.m39930a(JvmProtoBuf.f26289c)) {
            return null;
        }
        JvmFieldSignature jvmFieldSignature;
        int i;
        Object a;
        JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) property.m39931b(JvmProtoBuf.f26289c);
        if (jvmPropertySignature.m40422h()) {
            jvmFieldSignature = jvmPropertySignature.f39935c;
        } else {
            jvmFieldSignature = null;
        }
        if (jvmFieldSignature == null || !jvmFieldSignature.m40363h()) {
            i = property.f40422g;
        } else {
            i = jvmFieldSignature.f39911c;
        }
        if (jvmFieldSignature == null || !jvmFieldSignature.m40364i()) {
            a = m27908a(ProtoTypeTableUtilKt.m27869a(property, typeTable), nameResolver);
            if (a == null) {
                return null;
            }
        }
        a = nameResolver.mo5829a(jvmFieldSignature.f39912d);
        Object a2 = nameResolver.mo5829a(i);
        Intrinsics.m26843a(a2, "nameResolver.getString(name)");
        Intrinsics.m26843a(a, "desc");
        return new PropertySignature(a2, a);
    }

    private static String m27908a(Type type, NameResolver nameResolver) {
        if (!type.m41798l()) {
            return null;
        }
        Object c = nameResolver.mo5831c(type.f40458j);
        Intrinsics.m26843a(c, "nameResolver.getClassId(type.className)");
        return ClassMapperLite.m27904a(c);
    }
}
