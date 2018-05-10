package kotlin.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a&\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\f\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\r\u001a9\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0013\u001a9\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0013\u001a(\u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0015\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0016\u001a.\u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\u0010\u0017\u001a)\u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n\u001a)\u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\n\u001a(\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0015\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0016\u001a.\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\u0010\u0017\u001a)\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n\u001a)\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\n\u001a-\u0010\u0019\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u001a*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0015\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u001b\u001a&\u0010\u0019\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\b¢\u0006\u0002\u0010\u001e\u001a-\u0010\u001f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001f\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u001a*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020 H\b\u001a*\u0010\u001f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011\u001a*\u0010\u001f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011\u001a-\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010!\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u001a*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020 H\b\u001a*\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011\u001a*\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0011\u001a\u0015\u0010\"\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0002\b#\u001a\u0019\u0010$\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000bH\b\u001a!\u0010$\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010%\u001a\u00020&H\b\u001a\u001e\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020(\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0007\u001a&\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020(\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0007\u001a\"\u0010)\u001a\u00020\n\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020**\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0007\u001a3\u0010)\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001d0,H\b\u001a5\u0010)\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u001a\u0010-\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020.j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`/H\b\u001a4\u00100\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u001a\u0010-\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020.j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`/H\u0007¨\u00061"}, d2 = {"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "fill", "", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "minusAssign", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "shuffle", "random", "Ljava/util/Random;", "shuffled", "", "sort", "", "comparison", "Lkotlin/Function2;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, k = 5, mv = {1, 1, 9}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* compiled from: MutableCollections.kt */
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__IteratorsKt {
    public static final <T> boolean m38194a(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.m26847b(collection, "$receiver");
        Intrinsics.m26847b(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean m38192a(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.m26847b(iterable, "$receiver");
        Intrinsics.m26847b(function1, "predicate");
        return m38193a((Iterable) iterable, (Function1) function1, true);
    }

    public static final <T> boolean m38196b(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.m26847b(iterable, "$receiver");
        Intrinsics.m26847b(function1, "predicate");
        return m38193a((Iterable) iterable, (Function1) function1, false);
    }

    private static final <T> boolean m38193a(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        iterable = iterable.iterator();
        boolean z2 = false;
        while (iterable.hasNext()) {
            if (((Boolean) function1.mo6492a(iterable.next())).booleanValue() == z) {
                iterable.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean m38197b(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.m26847b(list, "$receiver");
        Intrinsics.m26847b(function1, "predicate");
        return m38195a((List) list, (Function1) function1, true);
    }

    public static final <T> boolean m38198c(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.m26847b(list, "$receiver");
        Intrinsics.m26847b(function1, "predicate");
        return m38195a((List) list, (Function1) function1, false);
    }

    private static final <T> boolean m38195a(List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        if (list instanceof RandomAccess) {
            int i;
            int a = CollectionsKt__CollectionsKt.m26787a((List) list);
            if (a >= 0) {
                int i2 = 0;
                i = i2;
                while (true) {
                    Object obj = list.get(i2);
                    if (((Boolean) function1.mo6492a(obj)).booleanValue() != z) {
                        if (i != i2) {
                            list.set(i, obj);
                        }
                        i++;
                    }
                    if (i2 == a) {
                        break;
                    }
                    i2++;
                }
            } else {
                i = 0;
            }
            if (i >= list.size()) {
                return false;
            }
            function1 = CollectionsKt__CollectionsKt.m26787a((List) list);
            if (function1 >= i) {
                while (true) {
                    list.remove(function1);
                    if (function1 == i) {
                        break;
                    }
                    function1--;
                }
            }
            return true;
        } else if (list != null) {
            return m38193a(TypeIntrinsics.m26869a((Object) list), (Function1) function1, z);
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
    }

    public static final <T> void m38191a(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.m26847b(list, "$receiver");
        Intrinsics.m26847b(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
