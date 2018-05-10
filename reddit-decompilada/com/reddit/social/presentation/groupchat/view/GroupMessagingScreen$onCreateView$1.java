package com.reddit.social.presentation.groupchat.view;

import com.reddit.social.presentation.messaginglist.MessagingAdapter;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.LinkContentMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class GroupMessagingScreen$onCreateView$1 extends Lambda implements Function1<Pair<? extends Long, ? extends LinkEmbedState>, Unit> {
    final /* synthetic */ GroupMessagingScreen f37538a;

    GroupMessagingScreen$onCreateView$1(GroupMessagingScreen groupMessagingScreen) {
        this.f37538a = groupMessagingScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Pair pair = (Pair) obj;
        long longValue = ((Number) pair.f25267a).longValue();
        LinkEmbedState linkEmbedState = (LinkEmbedState) pair.f25268b;
        MessagingAdapter a = GroupMessagingScreen.m41285a(this.f37538a);
        Intrinsics.m26847b(linkEmbedState, "linkEmbedState");
        int i = 0;
        for (HasMessageData a2 : a.m30875b()) {
            if ((a2.mo5204a().f22429b == longValue ? 1 : null) != null) {
                break;
            }
            i++;
        }
        i = -1;
        if (i != -1) {
            HasMessageData hasMessageData = (HasMessageData) a.m30875b().get(i);
            if (hasMessageData instanceof LinkContentMessageData) {
                LinkContentMessageData linkContentMessageData = (LinkContentMessageData) hasMessageData;
                Intrinsics.m26847b(linkEmbedState, "<set-?>");
                linkContentMessageData.f29941a = linkEmbedState;
                a.d(i);
            }
        }
        return Unit.f25273a;
    }
}
