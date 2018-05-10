package com.reddit.social.presentation.groupchat.view;

import com.reddit.social.presentation.groupchat.GroupMembersContract.Presenter;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "index", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMembersScreen.kt */
final class GroupMembersScreen$showUserReportDialog$1<T> implements Consumer<Integer> {
    final /* synthetic */ GroupMembersScreen f29848a;
    final /* synthetic */ UserData f29849b;
    final /* synthetic */ List f29850c;

    GroupMembersScreen$showUserReportDialog$1(GroupMembersScreen groupMembersScreen, UserData userData, List list) {
        this.f29848a = groupMembersScreen;
        this.f29849b = userData;
        this.f29850c = list;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Integer) obj;
        Presenter w = this.f29848a.m41282w();
        String str = this.f29849b.f22465b;
        String str2 = this.f29849b.f22464a;
        List list = this.f29850c;
        Intrinsics.m26843a(obj, "index");
        obj = list.get(obj.intValue());
        Intrinsics.m26843a(obj, "reasons[index]");
        w.mo5156a(str, str2, (String) obj);
    }
}
