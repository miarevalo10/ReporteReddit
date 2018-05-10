package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes.Record;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.StringTableTypes.Record.Operation;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: JvmNameResolver.kt */
public final class JvmNameResolver implements NameResolver {
    public static final Companion f32814a = new Companion();
    private static final List<String> f32815f = CollectionsKt__CollectionsKt.m26796b((Object[]) new String[]{"kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator"});
    private static final Map<String, Integer> f32816g;
    private final Set<Integer> f32817b;
    private final List<Record> f32818c;
    private final StringTableTypes f32819d;
    private final String[] f32820e;

    /* compiled from: JvmNameResolver.kt */
    public static final class Companion {
        private Companion() {
        }

        public static List<String> m27318a() {
            return JvmNameResolver.f32815f;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25799a;

        static {
            int[] iArr = new int[Operation.values().length];
            f25799a = iArr;
            iArr[Operation.NONE.ordinal()] = 1;
            f25799a[Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            f25799a[Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
        }
    }

    public JvmNameResolver(StringTableTypes stringTableTypes, String[] strArr) {
        Intrinsics.m26847b(stringTableTypes, "types");
        Intrinsics.m26847b(strArr, "strings");
        this.f32819d = stringTableTypes;
        this.f32820e = strArr;
        List list = (List) this.f32819d.f39970d;
        this.f32817b = (Set) (list.isEmpty() != null ? SetsKt__SetsKt.m26799a() : CollectionsKt___CollectionsKt.m41451p(list));
        stringTableTypes = new ArrayList();
        ArrayList arrayList = (ArrayList) stringTableTypes;
        List<Record> list2 = this.f32819d.f39969c;
        arrayList.ensureCapacity(list2.size());
        for (Record record : list2) {
            int i = 0;
            int i2 = record.f39956d - 1;
            if (i2 >= 0) {
                while (true) {
                    arrayList.add(record);
                    if (i == i2) {
                        break;
                    }
                    i++;
                }
            }
        }
        arrayList.trimToSize();
        this.f32818c = (List) stringTableTypes;
    }

    public final String mo5829a(int i) {
        Object obj;
        int i2;
        Record record = (Record) this.f32818c.get(i);
        if (record.m40473i()) {
            i = record.f39958f;
            if (i instanceof String) {
                obj = (String) i;
            } else {
                ByteString byteString = (ByteString) i;
                String e = byteString.m27467e();
                if (byteString.mo5875f() != 0) {
                    record.f39958f = e;
                }
                obj = e;
            }
        } else {
            if (record.m40472h()) {
                IntProgression a = CollectionsKt__CollectionsKt.m26792a((Collection) Companion.m27318a());
                int i3 = record.f39957e;
                i2 = (a.f32536a > i3 || i3 > a.f32537b) ? 0 : 1;
                if (i2 != 0) {
                    obj = (String) Companion.m27318a().get(record.f39957e);
                }
            }
            obj = this.f32820e[i];
        }
        if (record.f39960h.size() >= 2) {
            List list = record.f39960h;
            Object obj2 = (Integer) list.get(0);
            Object obj3 = (Integer) list.get(1);
            Intrinsics.m26843a(obj2, "begin");
            if (Intrinsics.m26838a(0, obj2.intValue()) <= 0) {
                int intValue = obj2.intValue();
                Intrinsics.m26843a(obj3, "end");
                if (Intrinsics.m26838a(intValue, obj3.intValue()) <= 0 && Intrinsics.m26838a(obj3.intValue(), obj.length()) <= 0) {
                    Intrinsics.m26843a(obj2, "begin");
                    int intValue2 = obj2.intValue();
                    Intrinsics.m26843a(obj3, "end");
                    i2 = obj3.intValue();
                    if (obj == 0) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    obj = ((String) obj).substring(intValue2, i2);
                    Intrinsics.m26843a(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        if (record.f39961i.size() >= 2) {
            list = record.f39961i;
            obj = StringsKt__StringsJVMKt.m41941a((String) obj, (char) ((Integer) list.get(0)).intValue(), (char) ((Integer) list.get(1)).intValue());
        }
        Operation operation = record.f39959g;
        if (operation == null) {
            operation = Operation.NONE;
        }
        switch (WhenMappings.f25799a[operation.ordinal()]) {
            case 1:
                break;
            case 2:
                obj = StringsKt__StringsJVMKt.m41941a((String) obj, '$', '.');
                break;
            case 3:
                if (obj.length() >= 2) {
                    int length = obj.length() - 1;
                    if (obj == 0) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    i = ((String) obj).substring(1, length);
                    Intrinsics.m26843a((Object) i, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                obj = StringsKt__StringsJVMKt.m41941a((String) i, '$', '.');
                break;
            default:
                break;
        }
        Intrinsics.m26843a(obj, "string");
        return obj;
    }

    public final Name mo5830b(int i) {
        return Name.m27427d(mo5829a(i));
    }

    public final ClassId mo5831c(int i) {
        FqName fqName;
        String a = mo5829a(i);
        int a2 = StringsKt__StringsKt.m42438a((CharSequence) a, '/');
        if (a2 < 0) {
            fqName = FqName.f25855a;
        } else if (a == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else {
            Object substring = a.substring(0, a2);
            Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            fqName = new FqName(StringsKt__StringsJVMKt.m41941a((String) substring, '/', '.'));
        }
        a2++;
        if (a == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        a = a.substring(a2);
        Intrinsics.m26843a((Object) a, "(this as java.lang.String).substring(startIndex)");
        return new ClassId(fqName, new FqName(a), this.f32817b.contains(Integer.valueOf(i)));
    }

    static {
        Iterable<IndexedValue> q = CollectionsKt___CollectionsKt.m41452q(Companion.m27318a());
        Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(q)), 16));
        for (IndexedValue indexedValue : q) {
            linkedHashMap.put((String) indexedValue.f25278b, Integer.valueOf(indexedValue.f25277a));
        }
        f32816g = linkedHashMap;
    }
}
