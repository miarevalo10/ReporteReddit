package com.reddit.social.presentation.presentationobjects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/TypingIndicator;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "title", "", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Ljava/lang/String;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TypingIndicator.kt */
public final class TypingIndicator implements HasMessageData {
    public String f29966a;
    private final MessageData f29967b;

    public TypingIndicator() {
        this(null, null, 3);
    }

    private TypingIndicator(String str, MessageData messageData) {
        Intrinsics.m26847b(messageData, "messageData");
        this.f29966a = str;
        this.f29967b = messageData;
    }

    public /* synthetic */ TypingIndicator(String str, MessageData messageData, int i) {
        MessageData messageData2;
        TypingIndicator typingIndicator;
        String str2 = (i & 1) != 0 ? null : str;
        if ((i & 2) != 0) {
            messageData2 = new MessageData("", 0, 0, "", "", Boolean.valueOf(false), "", "", MessageType.f22456m, true, SentStatus.f22460a, false, "", "", "");
            typingIndicator = this;
        } else {
            typingIndicator = this;
            messageData2 = messageData;
        }
        typingIndicator = new TypingIndicator(str2, messageData2);
    }

    public final MessageData mo5204a() {
        return this.f29967b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TypingIndicator(title=");
        stringBuilder.append(this.f29966a);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29967b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f29966a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MessageData messageData = this.f29967b;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TypingIndicator) {
                TypingIndicator typingIndicator = (TypingIndicator) obj;
                if (Intrinsics.m26845a(this.f29966a, typingIndicator.f29966a) && Intrinsics.m26845a(this.f29967b, typingIndicator.f29967b) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
