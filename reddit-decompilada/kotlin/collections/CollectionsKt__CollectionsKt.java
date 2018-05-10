package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\b\u001a@\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\b\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001a\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00182\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u0002H\b¢\u0006\u0002\u0010\u001d\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018\"\u0004\b\u0000\u0010\u00072\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0018H\b¢\u0006\u0002\u0010\u001f\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\b\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\"\u001a\u0002H\u0007H\u0007¢\u0006\u0002\u0010#\u001a+\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010$\u001a%\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010#\u001a3\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020\u001b2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010$\u001a\u0015\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\b\u001a+\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010$\u001a%\u0010'\u001a\u00020(2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0002\b+\u001a%\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010-\u001aS\u0010.\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010\"\u001a\u0002H\u00072\u001a\u0010/\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000700j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`12\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00102\u001a>\u0010.\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u0010.\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u000704*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010\"\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00105\u001ad\u00106\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u00107*\b\u0012\u0004\u0012\u0002H704*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u00108\u001a\u0004\u0018\u0001H72\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0016\b\u0004\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H70\u000eH\b¢\u0006\u0002\u0010:\u001a,\u0010;\u001a\u00020<\"\t\b\u0000\u0010\u0007¢\u0006\u0002\b=*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\b\u001a1\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0018\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u00182\u0006\u0010?\u001a\u00020<H\u0003¢\u0006\u0004\b@\u0010A\u001a\u0019\u0010B\u001a\u00020<\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\b\u001a\u001e\u0010C\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\b\u001a!\u0010D\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\b\u001a\u001f\u0010E\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070FH\b\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006G"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "copyToArrayImpl", "", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "emptyList", "listOf", "element", "(Ljava/lang/Object;)Ljava/util/List;", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "mutableListOf", "rangeCheck", "", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "copyToArrayOfAny", "isVarargs", "copyToArrayOfAny$CollectionsKt__CollectionsKt", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "isNotEmpty", "optimizeReadOnlyList", "orEmpty", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 9}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* compiled from: Collections.kt */
public class CollectionsKt__CollectionsKt {
    public static final <T> Collection<T> m26789a(T[] tArr) {
        Intrinsics.m26847b(tArr, "$receiver");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T> List<T> m26790a() {
        return EmptyList.f32507a;
    }

    public static final <T> List<T> m26796b(T... tArr) {
        Intrinsics.m26847b(tArr, "elements");
        return tArr.length > 0 ? ArraysKt___ArraysKt.m36106f(tArr) : (List) EmptyList.f32507a;
    }

    public static final <T> List<T> m26791a(T t) {
        Object singletonList = Collections.singletonList(t);
        Intrinsics.m26843a(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> List<T> m26797c(T... tArr) {
        Intrinsics.m26847b(tArr, "elements");
        return tArr.length == 0 ? (List) new ArrayList() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    public static final <T> List<T> m26794b(T t) {
        if (t != null) {
            return m26791a((Object) t);
        }
        return (List) EmptyList.f32507a;
    }

    public static final <T> List<T> m26798d(T... tArr) {
        Intrinsics.m26847b(tArr, "elements");
        return ArraysKt___ArraysKt.m36105e((Object[]) tArr);
    }

    public static final IntRange m26792a(Collection<?> collection) {
        Intrinsics.m26847b(collection, "$receiver");
        return new IntRange(0, collection.size() - 1);
    }

    public static final <T> int m26787a(List<? extends T> list) {
        Intrinsics.m26847b(list, "$receiver");
        return list.size() - 1;
    }

    public static final <T> List<T> m26795b(List<? extends T> list) {
        Intrinsics.m26847b(list, "$receiver");
        switch (list.size()) {
            case 0:
                return EmptyList.f32507a;
            case 1:
                return m26791a((Object) list.get(0));
            default:
                return list;
        }
    }

    public static /* synthetic */ int m26788a(List list, Function1 function1) {
        int size = list.size();
        Intrinsics.m26847b(list, "$receiver");
        Intrinsics.m26847b(function1, "comparison");
        int size2 = list.size();
        if (size <= 0) {
            function1 = new StringBuilder("fromIndex (1) is greater than toIndex (");
            function1.append(size);
            function1.append(").");
            throw ((Throwable) new IllegalArgumentException(function1.toString()));
        } else if (size > size2) {
            function1 = new StringBuilder("toIndex (");
            function1.append(size);
            function1.append(") is greater than size (");
            function1.append(size2);
            function1.append(").");
            throw ((Throwable) new IndexOutOfBoundsException(function1.toString()));
        } else {
            int i = size - 1;
            size = 1;
            while (size <= i) {
                int i2 = (size + i) >>> 1;
                int intValue = ((Number) function1.mo6492a(list.get(i2))).intValue();
                if (intValue < 0) {
                    size = i2 + 1;
                } else if (intValue <= 0) {
                    return i2;
                } else {
                    i = i2 - 1;
                }
            }
            return -(size + 1);
        }
    }

    public static final /* synthetic */ Object[] m26793a(Object[] objArr, boolean z) {
        if (!z || !Intrinsics.m26845a(objArr.getClass(), (Object) Object[].class)) {
            Object copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
            Intrinsics.m26843a(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
            return copyOf;
        } else if (objArr != null) {
            return objArr;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
    }
}
