package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.social.domain.functions.GroupChannelMemberListTransformer;
import com.reddit.social.presentation.groupchat.ChatContract.View;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/sendbird/android/GroupChannel;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadChatInfo$3<T> implements Consumer<Pair<? extends GroupChannel, ? extends List<? extends UserData>>> {
    final /* synthetic */ GroupMessagingPresenter f29761a;

    GroupMessagingPresenter$loadChatInfo$3(GroupMessagingPresenter groupMessagingPresenter) {
        this.f29761a = groupMessagingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        String f;
        String a;
        Pair pair = (Pair) obj;
        GroupChannel groupChannel = (GroupChannel) pair.f25267a;
        List list = (List) pair.f25268b;
        GroupMessagingPresenter.m30774a(this.f29761a).mo7556a(list);
        Object f2 = groupChannel.m24872f();
        Intrinsics.m26843a(f2, "channel.name");
        if ((((CharSequence) f2).length() == 0 ? 1 : 0) == 0) {
            if (!Intrinsics.m26845a(groupChannel.m24872f(), this.f29761a.f29801g)) {
                f = groupChannel.m24872f();
                Intrinsics.m26843a((Object) f, "channel.name");
                GroupMessagingPresenter.m30774a(this.f29761a).mo7560b(f);
                if (ChatUtilKt.m24765c(groupChannel)) {
                    a = Util.m23959a((int) C1761R.plurals.fmt_people_in_group, list.size(), Integer.valueOf(list.size()));
                } else {
                    a = null;
                }
                GroupMessagingPresenter.m30774a(this.f29761a).mo7555a(f, a);
            }
        }
        f = new GroupChannelMemberListTransformer(SessionUtil.m23898d()).m30618a(list);
        if (ChatUtilKt.m24765c(groupChannel)) {
            GroupMessagingPresenter.m30774a(this.f29761a).mo7560b(f);
        } else {
            View a2 = GroupMessagingPresenter.m30774a(this.f29761a);
            String f3 = Util.m24027f((int) C1761R.string.rdt_group);
            Intrinsics.m26843a((Object) f3, "Util.getString(R.string.rdt_group)");
            a2.mo7560b(f3);
        }
        if (ChatUtilKt.m24765c(groupChannel)) {
            a = Util.m23959a((int) C1761R.plurals.fmt_people_in_group, list.size(), Integer.valueOf(list.size()));
        } else {
            a = null;
        }
        GroupMessagingPresenter.m30774a(this.f29761a).mo7555a(f, a);
    }
}
