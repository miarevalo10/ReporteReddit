package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.analytics.ChatAnalytics.Source;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMembersPresenter.kt */
final class GroupMembersPresenter$blockUser$2<T> implements Consumer<Boolean> {
    final /* synthetic */ GroupMembersPresenter f29734a;
    final /* synthetic */ String f29735b;

    GroupMembersPresenter$blockUser$2(GroupMembersPresenter groupMembersPresenter, String str) {
        this.f29734a = groupMembersPresenter;
        this.f29735b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f29734a.m30768b().mo7546b(this.f29735b);
        obj = this.f29734a.f29740b;
        if (obj == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        String str = this.f29734a.f29741c;
        if (str == null) {
            Intrinsics.m26844a("channelUrl");
        }
        obj.m24472a(str, this.f29735b, Source.f22284d);
    }
}
