package com.reddit.datalibrary.frontpage.data.feature.inboxcount;

import com.reddit.datalibrary.frontpage.requests.models.v2.BadgeCount;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "badgeCount", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/BadgeCount;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: InboxCountRepository.kt */
final class InboxCountRepository$fetchBadgeCount$1<T> implements Consumer<BadgeCount> {
    public static final InboxCountRepository$fetchBadgeCount$1 f15836a = new InboxCountRepository$fetchBadgeCount$1();

    InboxCountRepository$fetchBadgeCount$1() {
    }

    public final /* synthetic */ void accept(Object obj) {
        BadgeCount badgeCount = (BadgeCount) obj;
        InboxCountRepository inboxCountRepository = InboxCountRepository.f10408a;
        Intrinsics.a(badgeCount, "badgeCount");
        InboxCountRepository.m8835a(badgeCount);
    }
}
