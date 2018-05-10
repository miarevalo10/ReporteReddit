package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type.Argument;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;

/* compiled from: protoTypeTableUtil.kt */
public final class ProtoTypeTableUtilKt {
    public static final Type m27870a(Argument argument, TypeTable typeTable) {
        Intrinsics.m26847b(argument, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (argument.m40198h()) {
            return argument.f39846e;
        }
        return argument.m40199i() ? typeTable.m27891a(argument.f39847f) : null;
    }

    public static final Type m27871a(Type type, TypeTable typeTable) {
        Intrinsics.m26847b(type, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (type.m41796j()) {
            return type.f40456h;
        }
        return type.m41797k() ? typeTable.m27891a(type.f40457i) : null;
    }

    public static final Type m27868a(Function function, TypeTable typeTable) {
        Intrinsics.m26847b(function, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (!function.m41667j()) {
            return typeTable.m27891a(function.f40377i);
        }
        Object obj = function.f40376h;
        Intrinsics.m26843a(obj, "returnType");
        return obj;
    }

    public static final boolean m27874a(Function function) {
        Intrinsics.m26847b(function, "$receiver");
        if (!function.m41668k()) {
            if (function.m41669l() == null) {
                return null;
            }
        }
        return true;
    }

    public static final Type m27876b(Function function, TypeTable typeTable) {
        Intrinsics.m26847b(function, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (function.m41668k()) {
            return function.f40379k;
        }
        return function.m41669l() ? typeTable.m27891a(function.f40380l) : null;
    }

    public static final Type m27869a(Property property, TypeTable typeTable) {
        Intrinsics.m26847b(property, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (!property.m41746j()) {
            return typeTable.m27891a(property.f40424i);
        }
        Object obj = property.f40423h;
        Intrinsics.m26843a(obj, "returnType");
        return obj;
    }

    public static final boolean m27875a(Property property) {
        Intrinsics.m26847b(property, "$receiver");
        if (!property.m41747k()) {
            if (property.m41748l() == null) {
                return null;
            }
        }
        return true;
    }

    public static final Type m27877b(Property property, TypeTable typeTable) {
        Intrinsics.m26847b(property, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (property.m41747k()) {
            return property.f40426k;
        }
        return property.m41748l() ? typeTable.m27891a(property.f40427l) : null;
    }

    public static final Type m27873a(ValueParameter valueParameter, TypeTable typeTable) {
        Intrinsics.m26847b(valueParameter, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (!valueParameter.m41914j()) {
            return typeTable.m27891a(valueParameter.f40527h);
        }
        Object obj = valueParameter.f40526g;
        Intrinsics.m26843a(obj, "type");
        return obj;
    }

    public static final Type m27880b(ValueParameter valueParameter, TypeTable typeTable) {
        Intrinsics.m26847b(valueParameter, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (valueParameter.m41915k()) {
            return valueParameter.f40528i;
        }
        return valueParameter.m41916l() ? typeTable.m27891a(valueParameter.f40529j) : null;
    }

    public static final Type m27878b(Type type, TypeTable typeTable) {
        Intrinsics.m26847b(type, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (type.m41802p()) {
            return type.f40462n;
        }
        return type.m41803q() ? typeTable.m27891a(type.f40463o) : null;
    }

    public static final Type m27881c(Type type, TypeTable typeTable) {
        Intrinsics.m26847b(type, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (type.m41804r()) {
            return type.f40464p;
        }
        return type.m41805s() ? typeTable.m27891a(type.f40465q) : null;
    }

    public static final Type m27872a(TypeAlias typeAlias, TypeTable typeTable) {
        Intrinsics.m26847b(typeAlias, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (typeAlias.m41844j()) {
            return typeTable.m27891a(typeAlias.f40487i);
        }
        Object obj = typeAlias.f40486h;
        Intrinsics.m26843a(obj, "underlyingType");
        return obj;
    }

    public static final Type m27879b(TypeAlias typeAlias, TypeTable typeTable) {
        Intrinsics.m26847b(typeAlias, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        if (typeAlias.m41846l()) {
            return typeTable.m27891a(typeAlias.f40489k);
        }
        Object obj = typeAlias.f40488j;
        Intrinsics.m26843a(obj, "expandedType");
        return obj;
    }

    public static final List<Type> m27866a(Class classR, TypeTable typeTable) {
        Intrinsics.m26847b(classR, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        Object obj = classR.f40319i;
        if (obj.isEmpty()) {
            Iterable<Object> iterable = (Iterable) classR.f40320j;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (Object obj2 : iterable) {
                Intrinsics.m26843a(obj2, "it");
                arrayList.add(typeTable.m27891a(obj2.intValue()));
            }
            obj = (List) arrayList;
        }
        Intrinsics.m26843a(obj, "supertypeList.ifEmpty { …t.map { typeTable[it] } }");
        return (List) obj;
    }

    public static final List<Type> m27867a(TypeParameter typeParameter, TypeTable typeTable) {
        Intrinsics.m26847b(typeParameter, "$receiver");
        Intrinsics.m26847b(typeTable, "typeTable");
        Object obj = typeParameter.f40509i;
        if (obj.isEmpty()) {
            Iterable<Object> iterable = (Iterable) typeParameter.f40510j;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (Object obj2 : iterable) {
                Intrinsics.m26843a(obj2, "it");
                arrayList.add(typeTable.m27891a(obj2.intValue()));
            }
            obj = (List) arrayList;
        }
        Intrinsics.m26843a(obj, "upperBoundList.ifEmpty {…t.map { typeTable[it] } }");
        return (List) obj;
    }
}
