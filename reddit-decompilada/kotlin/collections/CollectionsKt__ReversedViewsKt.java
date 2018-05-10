package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 1, 9}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* compiled from: ReversedViews.kt */
public class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static final <T> List<T> m39799c(List<T> list) {
        Intrinsics.m26847b(list, "$receiver");
        return new ReversedList(list);
    }

    public static final /* synthetic */ int m39797a(List list, int i) {
        int a = CollectionsKt__CollectionsKt.m26787a(list);
        if (i >= 0) {
            if (a >= i) {
                return CollectionsKt__CollectionsKt.m26787a(list) - i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Element index ");
        stringBuilder.append(i);
        stringBuilder.append(" must be in range [");
        stringBuilder.append(new IntRange(0, CollectionsKt__CollectionsKt.m26787a(list)));
        stringBuilder.append("].");
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public static final /* synthetic */ int m39798b(List list, int i) {
        int size = list.size();
        if (i >= 0) {
            if (size >= i) {
                return list.size() - i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Position index ");
        stringBuilder.append(i);
        stringBuilder.append(" must be in range [");
        stringBuilder.append(new IntRange(0, list.size()));
        stringBuilder.append("].");
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
}
