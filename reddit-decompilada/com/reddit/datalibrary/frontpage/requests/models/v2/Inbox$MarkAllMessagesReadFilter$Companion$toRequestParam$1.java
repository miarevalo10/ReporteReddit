package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.reddit.datalibrary.frontpage.requests.models.v2.Inbox.MarkAllMessagesReadFilter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Inbox$MarkAllMessagesReadFilter;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: Inbox.kt */
final class Inbox$MarkAllMessagesReadFilter$Companion$toRequestParam$1 extends Lambda implements Function1<MarkAllMessagesReadFilter, String> {
    public static final Inbox$MarkAllMessagesReadFilter$Companion$toRequestParam$1 INSTANCE = new Inbox$MarkAllMessagesReadFilter$Companion$toRequestParam$1();

    Inbox$MarkAllMessagesReadFilter$Companion$toRequestParam$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        MarkAllMessagesReadFilter markAllMessagesReadFilter = (MarkAllMessagesReadFilter) obj;
        Intrinsics.m26847b(markAllMessagesReadFilter, "it");
        return markAllMessagesReadFilter.value;
    }
}
