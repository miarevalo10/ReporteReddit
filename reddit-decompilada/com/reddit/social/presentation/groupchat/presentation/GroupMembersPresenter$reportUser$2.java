package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.groupchat.GroupMembersContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMembersPresenter.kt */
final class GroupMembersPresenter$reportUser$2<T> implements Consumer<Throwable> {
    final /* synthetic */ GroupMembersPresenter f29738a;

    GroupMembersPresenter$reportUser$2(GroupMembersPresenter groupMembersPresenter) {
        this.f29738a = groupMembersPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        View b = this.f29738a.m30768b();
        Intrinsics.m26843a((Object) th, "it");
        b.mo7543a(th);
    }
}
