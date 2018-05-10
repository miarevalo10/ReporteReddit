package com.reddit.frontpage.debug;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/debug/DataLoggingActivity$EventFilter;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DataLoggingActivity.kt */
final class DataLoggingActivity$DataLoggingAdapter$eventFilter$2 extends Lambda implements Function0<EventFilter> {
    final /* synthetic */ DataLoggingAdapter f36333a;

    DataLoggingActivity$DataLoggingAdapter$eventFilter$2(DataLoggingAdapter dataLoggingAdapter) {
        this.f36333a = dataLoggingAdapter;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new EventFilter(this.f36333a, this.f36333a.f27480g);
    }
}
