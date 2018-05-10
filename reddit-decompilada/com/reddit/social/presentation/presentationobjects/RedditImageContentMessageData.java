package com.reddit.social.presentation.presentationobjects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\r¨\u0006("}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/RedditImageContentMessageData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "title", "", "subreddit", "linkUrl", "sourceUrl", "gifUrl", "mp4Url", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getGifUrl", "()Ljava/lang/String;", "setGifUrl", "(Ljava/lang/String;)V", "getLinkUrl", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "getMp4Url", "setMp4Url", "getSourceUrl", "setSourceUrl", "getSubreddit", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditImageContentMessageData.kt */
public final class RedditImageContentMessageData implements HasMessageData {
    public final String f29947a;
    public final String f29948b;
    public String f29949c;
    public String f29950d;
    public String f29951e;
    private final String f29952f;
    private final MessageData f29953g;

    public final MessageData mo5204a() {
        return this.f29953g;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RedditImageContentMessageData(title=");
        stringBuilder.append(this.f29947a);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.f29952f);
        stringBuilder.append(", linkUrl=");
        stringBuilder.append(this.f29948b);
        stringBuilder.append(", sourceUrl=");
        stringBuilder.append(this.f29949c);
        stringBuilder.append(", gifUrl=");
        stringBuilder.append(this.f29950d);
        stringBuilder.append(", mp4Url=");
        stringBuilder.append(this.f29951e);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29953g);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f29947a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f29952f;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f29948b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f29949c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f29950d;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f29951e;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        MessageData messageData = this.f29953g;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RedditImageContentMessageData) {
                RedditImageContentMessageData redditImageContentMessageData = (RedditImageContentMessageData) obj;
                if (Intrinsics.m26845a(this.f29947a, redditImageContentMessageData.f29947a) && Intrinsics.m26845a(this.f29952f, redditImageContentMessageData.f29952f) && Intrinsics.m26845a(this.f29948b, redditImageContentMessageData.f29948b) && Intrinsics.m26845a(this.f29949c, redditImageContentMessageData.f29949c) && Intrinsics.m26845a(this.f29950d, redditImageContentMessageData.f29950d) && Intrinsics.m26845a(this.f29951e, redditImageContentMessageData.f29951e) && Intrinsics.m26845a(this.f29953g, redditImageContentMessageData.f29953g) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
