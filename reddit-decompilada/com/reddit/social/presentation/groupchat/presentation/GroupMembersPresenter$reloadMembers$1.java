package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.presentationobjects.UserData;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMembersPresenter.kt */
final class GroupMembersPresenter$reloadMembers$1 extends Lambda implements Function1<List<? extends UserData>, Unit> {
    final /* synthetic */ GroupMembersPresenter f37525a;

    GroupMembersPresenter$reloadMembers$1(GroupMembersPresenter groupMembersPresenter) {
        this.f37525a = groupMembersPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = (List) obj;
        GroupMembersPresenter groupMembersPresenter = this.f37525a;
        Intrinsics.m26843a(obj, "it");
        obj = CollectionsKt___CollectionsKt.m41418a((Iterable) obj, (Comparator) new C1940x8db2633c());
        Intrinsics.m26847b(obj, "<set-?>");
        groupMembersPresenter.f29744f = obj;
        this.f37525a.m30768b().mo7544a(this.f37525a.f29744f);
        return Unit.f25273a;
    }
}
