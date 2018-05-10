package com.reddit.social.presentation.presentationobjects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/SnoomojiImageMessageData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "snoomoji", "", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Ljava/lang/String;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "getSnoomoji", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SnoomojiImageMessageData.kt */
public final class SnoomojiImageMessageData implements HasMessageData {
    public final String f29962a;
    private final MessageData f29963b;

    public SnoomojiImageMessageData(String str, MessageData messageData) {
        Intrinsics.m26847b(str, "snoomoji");
        Intrinsics.m26847b(messageData, "messageData");
        this.f29962a = str;
        this.f29963b = messageData;
    }

    public final MessageData mo5204a() {
        return this.f29963b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SnoomojiImageMessageData(snoomoji=");
        stringBuilder.append(this.f29962a);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29963b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f29962a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MessageData messageData = this.f29963b;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SnoomojiImageMessageData) {
                SnoomojiImageMessageData snoomojiImageMessageData = (SnoomojiImageMessageData) obj;
                if (Intrinsics.m26845a(this.f29962a, snoomojiImageMessageData.f29962a) && Intrinsics.m26845a(this.f29963b, snoomojiImageMessageData.f29963b) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
