package com.reddit.social.presentation.presentationobjects;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/HeaderMessageData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Ljava/util/List;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HeaderMessageData.kt */
public final class HeaderMessageData implements HasMessageData {
    public List<UserData> f29935a;
    private final MessageData f29936b;

    private HeaderMessageData(List<UserData> list, MessageData messageData) {
        Intrinsics.m26847b(list, "members");
        Intrinsics.m26847b(messageData, "messageData");
        this.f29935a = list;
        this.f29936b = messageData;
    }

    public /* synthetic */ HeaderMessageData() {
        List a = CollectionsKt__CollectionsKt.m26790a();
        MessageData messageData = r1;
        MessageData messageData2 = new MessageData("", 0, 0, "", "", Boolean.valueOf(false), "", "", MessageType.f22455l, true, SentStatus.f22460a, false, "", "", "");
        this(a, messageData);
    }

    public final MessageData mo5204a() {
        return this.f29936b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("HeaderMessageData(members=");
        stringBuilder.append(this.f29935a);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29936b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        List list = this.f29935a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        MessageData messageData = this.f29936b;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof HeaderMessageData) {
                HeaderMessageData headerMessageData = (HeaderMessageData) obj;
                if (Intrinsics.m26845a(this.f29935a, headerMessageData.f29935a) && Intrinsics.m26845a(this.f29936b, headerMessageData.f29936b) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
