package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;

/* compiled from: TypeTable.kt */
public final class TypeTable {
    private final List<Type> f26276a;

    public TypeTable(kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeTable typeTable) {
        Intrinsics.m26847b(typeTable, "typeTable");
        List list = typeTable.f39856c;
        if (typeTable.m40227h()) {
            int i = typeTable.f39857d;
            Iterable<Object> iterable = (Iterable) typeTable.f39856c;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            int i2 = 0;
            for (Object obj : iterable) {
                Object obj2;
                int i3 = i2 + 1;
                if (i2 >= i) {
                    obj2 = obj2.m41806t().m41759a(true).m41767h();
                }
                arrayList.add(obj2);
                i2 = i3;
            }
            list = (List) arrayList;
        } else {
            Intrinsics.m26843a((Object) list, "originalTypes");
        }
        this.f26276a = list;
    }

    public final Type m27891a(int i) {
        return (Type) this.f26276a.get(i);
    }
}
