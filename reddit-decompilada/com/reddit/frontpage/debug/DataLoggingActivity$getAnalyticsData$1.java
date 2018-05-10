package com.reddit.frontpage.debug;

import com.reddit.data.events.models.Event;
import com.reddit.frontpage.debug.DataLoggingActivity.Data;
import com.reddit.frontpage.util.BoundedLinkedList;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/debug/DataLoggingActivity$Data;", "v1Data", "Lcom/reddit/frontpage/util/BoundedLinkedList;", "Lorg/json/JSONObject;", "v2Data", "Lcom/reddit/data/events/models/Event;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DataLoggingActivity.kt */
final class DataLoggingActivity$getAnalyticsData$1<T1, T2, R> implements BiFunction<BoundedLinkedList<JSONObject>, List<? extends Event>, List<? extends Data>> {
    final /* synthetic */ DataLoggingActivity f27482a;

    DataLoggingActivity$getAnalyticsData$1(DataLoggingActivity dataLoggingActivity) {
        this.f27482a = dataLoggingActivity;
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        BoundedLinkedList boundedLinkedList = (BoundedLinkedList) obj;
        List list = (List) obj2;
        Intrinsics.m26847b(boundedLinkedList, "v1Data");
        Intrinsics.m26847b(list, "v2Data");
        return DataLoggingActivity.m42477a(DataLoggingActivity.m42478b(boundedLinkedList), DataLoggingActivity.m42475a(this.f27482a, list));
    }
}
