package org.jetbrains.anko;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 1}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a!\u0010\u0004\u001a\u00020\u0002*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a#\u0010\t\u001a\u0004\u0018\u00010\u0002*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\b\u001a'\u0010\r\u001a\u00020\u000b*\u00020\u00052\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u000eH\b¨\u0006\u0010"}, d2 = {"childrenRecursiveSequence", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "childrenSequence", "firstChild", "Landroid/view/ViewGroup;", "predicate", "Lkotlin/Function1;", "", "firstChildOrNull", "forEachChild", "", "action", "forEachChildWithIndex", "Lkotlin/Function2;", "", "commons_release"}, k = 2, mv = {1, 1, 5})
/* compiled from: viewChildrenSequences.kt */
public final class ViewChildrenSequencesKt {
    public static final Sequence<View> m28417a(View view) {
        Intrinsics.m26847b(view, "$receiver");
        return new ViewChildrenSequence(view);
    }
}
