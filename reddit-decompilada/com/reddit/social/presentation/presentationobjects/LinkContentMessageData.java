package com.reddit.social.presentation.presentationobjects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/LinkContentMessageData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "linkEmbedState", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getLinkEmbedState", "()Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "setLinkEmbedState", "(Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;)V", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkContentMessageData.kt */
public final class LinkContentMessageData implements HasMessageData {
    public LinkEmbedState f29941a;
    public final MessageData f29942b;

    public LinkContentMessageData(LinkEmbedState linkEmbedState, MessageData messageData) {
        Intrinsics.m26847b(linkEmbedState, "linkEmbedState");
        Intrinsics.m26847b(messageData, "messageData");
        this.f29941a = linkEmbedState;
        this.f29942b = messageData;
    }

    public final MessageData mo5204a() {
        return this.f29942b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkContentMessageData(linkEmbedState=");
        stringBuilder.append(this.f29941a);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29942b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        LinkEmbedState linkEmbedState = this.f29941a;
        int i = 0;
        int hashCode = (linkEmbedState != null ? linkEmbedState.hashCode() : 0) * 31;
        MessageData messageData = this.f29942b;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkContentMessageData) {
                LinkContentMessageData linkContentMessageData = (LinkContentMessageData) obj;
                if (Intrinsics.m26845a(this.f29941a, linkContentMessageData.f29941a) && Intrinsics.m26845a(this.f29942b, linkContentMessageData.f29942b) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
