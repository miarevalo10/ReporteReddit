package com.reddit.social.presentation.groupchat.view;

import com.reddit.social.presentation.groupchat.view.GroupMessagingScreen.WhenMappings;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.MessageData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "index", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
final class GroupMessagingScreen$showMessageActions$2<T> implements Consumer<Integer> {
    final /* synthetic */ GroupMessagingScreen f29859a;
    final /* synthetic */ List f29860b;
    final /* synthetic */ MessageData f29861c;
    final /* synthetic */ HasMessageData f29862d;

    GroupMessagingScreen$showMessageActions$2(GroupMessagingScreen groupMessagingScreen, List list, MessageData messageData, HasMessageData hasMessageData) {
        this.f29859a = groupMessagingScreen;
        this.f29860b = list;
        this.f29861c = messageData;
        this.f29862d = hasMessageData;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Integer) obj;
        List list = this.f29860b;
        Intrinsics.m26843a(obj, "index");
        switch (WhenMappings.f22349a[((MessageAction) list.get(obj.intValue())).ordinal()]) {
            case 1:
                GroupMessagingScreen.m41287a(this.f29859a, this.f29861c);
                return;
            case 2:
                GroupMessagingScreen.m41289b(this.f29859a, this.f29862d);
                return;
            case 3:
                this.f29859a.m41332w().mo5165a(this.f29862d);
                break;
            default:
                break;
        }
    }
}
