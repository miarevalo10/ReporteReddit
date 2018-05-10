package com.reddit.social.presentation.presentationobjects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/VideoFileMessageData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "name", "", "videoUrl", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "getName", "()Ljava/lang/String;", "getVideoUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: VideoFileMessageData.kt */
public final class VideoFileMessageData implements HasMessageData {
    public final String f29968a;
    public final String f29969b;
    private final MessageData f29970c;

    public final MessageData mo5204a() {
        return this.f29970c;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("VideoFileMessageData(name=");
        stringBuilder.append(this.f29968a);
        stringBuilder.append(", videoUrl=");
        stringBuilder.append(this.f29969b);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29970c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f29968a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f29969b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        MessageData messageData = this.f29970c;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof VideoFileMessageData) {
                VideoFileMessageData videoFileMessageData = (VideoFileMessageData) obj;
                if (Intrinsics.m26845a(this.f29968a, videoFileMessageData.f29968a) && Intrinsics.m26845a(this.f29969b, videoFileMessageData.f29969b) && Intrinsics.m26845a(this.f29970c, videoFileMessageData.f29970c) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
