package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.QualifiedNameTable.QualifiedName.Kind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.StringTable;

/* compiled from: NameResolverImpl.kt */
public final class NameResolverImpl implements NameResolver {
    private final StringTable f33037a;
    private final QualifiedNameTable f33038b;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26258a;

        static {
            int[] iArr = new int[Kind.values().length];
            f26258a = iArr;
            iArr[Kind.CLASS.ordinal()] = 1;
            f26258a[Kind.PACKAGE.ordinal()] = 2;
            f26258a[Kind.LOCAL.ordinal()] = 3;
        }
    }

    public NameResolverImpl(StringTable stringTable, QualifiedNameTable qualifiedNameTable) {
        Intrinsics.m26847b(stringTable, "strings");
        Intrinsics.m26847b(qualifiedNameTable, "qualifiedNames");
        this.f33037a = stringTable;
        this.f33038b = qualifiedNameTable;
    }

    public final String mo5829a(int i) {
        Object a = this.f33037a.m40165a(i);
        Intrinsics.m26843a(a, "strings.getString(index)");
        return a;
    }

    public final Name mo5830b(int i) {
        return Name.m27427d(this.f33037a.m40165a(i));
    }

    public final ClassId mo5831c(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            i = this.f33038b.m40088a(i);
            String a = this.f33037a.m40165a(i.f39794e);
            Kind kind = i.f39795f;
            if (kind == null) {
                Intrinsics.m26842a();
            }
            switch (WhenMappings.f26258a[kind.ordinal()]) {
                case 1:
                    linkedList2.addFirst(a);
                    break;
                case 2:
                    linkedList.addFirst(a);
                    break;
                case 3:
                    linkedList2.addFirst(a);
                    z = true;
                    break;
                default:
                    break;
            }
            i = i.f39793d;
        }
        i = new Triple(linkedList, linkedList2, Boolean.valueOf(z));
        List list = (List) i.f25269a;
        List list2 = (List) i.f25270b;
        return new ClassId(FqName.m27405a(list), FqName.m27405a(list2), ((Boolean) i.f25271c).booleanValue());
    }
}
