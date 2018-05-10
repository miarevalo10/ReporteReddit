package com.reddit.social.presentation.chatinbox;

import com.reddit.social.presentation.presentationobjects.UserData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#¨\u0006&"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "", "titleText", "", "url", "accepted", "", "messageText", "", "timestamp", "", "unreadCount", "", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "inviter", "remainingUnaccepted", "isPrivate", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/CharSequence;JILjava/util/List;Lcom/reddit/social/presentation/presentationobjects/UserData;IZ)V", "getAccepted", "()Z", "getInviter", "()Lcom/reddit/social/presentation/presentationobjects/UserData;", "getMembers", "()Ljava/util/List;", "getMessageText", "()Ljava/lang/CharSequence;", "getRemainingUnaccepted", "()I", "setRemainingUnaccepted", "(I)V", "getTimestamp", "()J", "getTitleText", "()Ljava/lang/String;", "getUnreadCount", "getUrl", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxItem.kt */
public final class ChatInboxItem {
    public final String f22313a;
    public final String f22314b;
    public final boolean f22315c;
    public final CharSequence f22316d;
    public final long f22317e;
    public final int f22318f;
    public final List<UserData> f22319g;
    public final UserData f22320h;
    public int f22321i;
    public final boolean f22322j;

    private ChatInboxItem(String str, String str2, boolean z, CharSequence charSequence, long j, int i, List<UserData> list, UserData userData, boolean z2) {
        Intrinsics.m26847b(str, "titleText");
        Intrinsics.m26847b(str2, UpdateFragment.FRAGMENT_URL);
        Intrinsics.m26847b(charSequence, "messageText");
        Intrinsics.m26847b(list, "members");
        this.f22313a = str;
        this.f22314b = str2;
        this.f22315c = z;
        this.f22316d = charSequence;
        this.f22317e = j;
        this.f22318f = i;
        this.f22319g = list;
        this.f22320h = userData;
        this.f22321i = null;
        this.f22322j = z2;
    }
}
