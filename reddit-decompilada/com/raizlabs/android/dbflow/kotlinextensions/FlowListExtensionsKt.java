package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.list.IFlowCursorIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a&\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"get", "TModel", "Lcom/raizlabs/android/dbflow/list/IFlowCursorIterator;", "i", "", "(Lcom/raizlabs/android/dbflow/list/IFlowCursorIterator;I)Ljava/lang/Object;", "", "(Lcom/raizlabs/android/dbflow/list/IFlowCursorIterator;J)Ljava/lang/Object;", "dbflow-kotlinextensions_release"}, k = 2, mv = {1, 1, 7})
/* compiled from: FlowListExtensions.kt */
public final class FlowListExtensionsKt {
    public static final <TModel> TModel get(IFlowCursorIterator<TModel> iFlowCursorIterator, long j) {
        Intrinsics.b(iFlowCursorIterator, "$receiver");
        iFlowCursorIterator = iFlowCursorIterator.getItem(j);
        if (iFlowCursorIterator != null) {
            return iFlowCursorIterator;
        }
        StringBuilder stringBuilder = new StringBuilder("Could not find item at index ");
        stringBuilder.append(j);
        stringBuilder.append(" from the cursor.");
        throw ((Throwable) new IndexOutOfBoundsException(stringBuilder.toString()));
    }

    public static final <TModel> TModel get(IFlowCursorIterator<TModel> iFlowCursorIterator, int i) {
        Intrinsics.b(iFlowCursorIterator, "$receiver");
        iFlowCursorIterator = iFlowCursorIterator.getItem((long) i);
        if (iFlowCursorIterator != null) {
            return iFlowCursorIterator;
        }
        StringBuilder stringBuilder = new StringBuilder("Could not find item at index ");
        stringBuilder.append(i);
        stringBuilder.append(" from the cursor.");
        throw ((Throwable) new IndexOutOfBoundsException(stringBuilder.toString()));
    }
}
