package com.reddit.social.presentation.presentationobjects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/ImageFileMessageData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "name", "", "imageUrl", "thumbnailUrl", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getImageUrl", "()Ljava/lang/String;", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "getName", "getThumbnailUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ImageFileMessageData.kt */
public final class ImageFileMessageData implements HasMessageData {
    public final String f29937a;
    public final String f29938b;
    public final String f29939c;
    private final MessageData f29940d;

    public ImageFileMessageData(String str, String str2, String str3, MessageData messageData) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "imageUrl");
        Intrinsics.m26847b(messageData, "messageData");
        this.f29937a = str;
        this.f29938b = str2;
        this.f29939c = str3;
        this.f29940d = messageData;
    }

    public final MessageData mo5204a() {
        return this.f29940d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImageFileMessageData(name=");
        stringBuilder.append(this.f29937a);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.f29938b);
        stringBuilder.append(", thumbnailUrl=");
        stringBuilder.append(this.f29939c);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29940d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f29937a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f29938b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f29939c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        MessageData messageData = this.f29940d;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ImageFileMessageData) {
                ImageFileMessageData imageFileMessageData = (ImageFileMessageData) obj;
                if (Intrinsics.m26845a(this.f29937a, imageFileMessageData.f29937a) && Intrinsics.m26845a(this.f29938b, imageFileMessageData.f29938b) && Intrinsics.m26845a(this.f29939c, imageFileMessageData.f29939c) && Intrinsics.m26845a(this.f29940d, imageFileMessageData.f29940d) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
