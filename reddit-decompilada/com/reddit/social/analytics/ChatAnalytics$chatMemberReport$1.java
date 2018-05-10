package com.reddit.social.analytics;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "groupChannel", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatAnalytics.kt */
final class ChatAnalytics$chatMemberReport$1 extends Lambda implements Function1<GroupChannel, Unit> {
    final /* synthetic */ Source f37472a;
    final /* synthetic */ String f37473b;
    final /* synthetic */ String f37474c;

    ChatAnalytics$chatMemberReport$1(Source source, String str, String str2) {
        this.f37472a = source;
        this.f37473b = str;
        this.f37474c = str2;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str;
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "groupChannel");
        int n = groupChannel.m30984n();
        String str2 = null;
        if (groupChannel.m30985o()) {
            str = "direct";
            Object d = SessionUtil.m23898d();
            obj = groupChannel.m30983m();
            Intrinsics.m26843a(obj, "groupChannel.members");
            for (Object next : (Iterable) obj) {
                Object obj2 = (Member) next;
                Intrinsics.m26843a(obj2, "it");
                if ((Intrinsics.m26845a(obj2.m25021d(), d) ^ 1) != 0) {
                    break;
                }
            }
            Object next2 = null;
            Member member = (Member) next2;
            if (member != null) {
                str2 = member.m25021d();
            }
        } else {
            str = "group";
        }
        obj = ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(this.f37472a.f22289h)).m21892b(ModEventBuilder.f27451b)).m21895c("chat_member_report")).m28925g(str).m28920d(Long.valueOf((long) n)).m28932n(str2);
        String str3 = this.f37473b;
        Intrinsics.m26847b(str3, "reportedUserId");
        obj.f27446a.reported_user_id(str3);
        obj.m28924f(this.f37474c).m21891a();
        return Unit.f25273a;
    }
}
