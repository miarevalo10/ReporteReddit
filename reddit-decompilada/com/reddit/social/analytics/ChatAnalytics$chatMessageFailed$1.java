package com.reddit.social.analytics;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
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
final class ChatAnalytics$chatMessageFailed$1 extends Lambda implements Function1<GroupChannel, Unit> {
    final /* synthetic */ String f37480a;
    final /* synthetic */ String f37481b;
    final /* synthetic */ String f37482c;
    final /* synthetic */ String f37483d;
    final /* synthetic */ String f37484e;

    ChatAnalytics$chatMessageFailed$1(String str, String str2, String str3, String str4, String str5) {
        this.f37480a = str;
        this.f37481b = str2;
        this.f37482c = str3;
        this.f37483d = str4;
        this.f37484e = str5;
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
            Object m = groupChannel.m30983m();
            Intrinsics.m26843a(m, "groupChannel.members");
            for (Object next : (Iterable) m) {
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
        obj = ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22282b.f22289h)).m21892b("view")).m21895c("chat_message_failed")).m28925g(str).m28920d(Long.valueOf((long) n)).m28931m(this.f37480a).m28932n(str2).m28924f(this.f37481b).m28921e(Long.valueOf((long) groupChannel.m30982l()));
        Object d2 = SessionUtil.m23898d();
        Intrinsics.m26843a(d2, "SessionUtil.getTypedCurrentSessionAccountID()");
        obj = obj.m28933o(d2);
        String d3 = SessionUtil.m23898d();
        Intrinsics.m26843a((Object) d3, "SessionUtil.getTypedCurrentSessionAccountID()");
        obj = obj.m28922e(d3);
        if (this.f37482c != null) {
            d3 = this.f37482c;
            str = this.f37483d;
            if (str == null) {
                str = "";
            }
            str2 = this.f37484e;
            if (str2 == null) {
                str2 = "";
            }
            obj.m21890a(d3, str, str2);
        }
        obj.m21891a();
        return Unit.f25273a;
    }
}
