package com.reddit.social.presentation.presentationobjects;

import com.reddit.datalibrary.frontpage.requests.models.v1.ImageResolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006#"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/RedditVideoContentMessageData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "title", "", "subreddit", "sourceUrl", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;", "gifUrl", "mp4Url", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;Lcom/reddit/social/presentation/presentationobjects/MessageData;)V", "getGifUrl", "()Lcom/reddit/datalibrary/frontpage/requests/models/v1/ImageResolution;", "getMessageData", "()Lcom/reddit/social/presentation/presentationobjects/MessageData;", "getMp4Url", "getSourceUrl", "getSubreddit", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditVideoContentMessageData.kt */
public final class RedditVideoContentMessageData implements HasMessageData {
    public final ImageResolution f29954a;
    public final ImageResolution f29955b;
    public final ImageResolution f29956c;
    private final String f29957d;
    private final String f29958e;
    private final MessageData f29959f;

    public final MessageData mo5204a() {
        return this.f29959f;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RedditVideoContentMessageData(title=");
        stringBuilder.append(this.f29957d);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.f29958e);
        stringBuilder.append(", sourceUrl=");
        stringBuilder.append(this.f29954a);
        stringBuilder.append(", gifUrl=");
        stringBuilder.append(this.f29955b);
        stringBuilder.append(", mp4Url=");
        stringBuilder.append(this.f29956c);
        stringBuilder.append(", messageData=");
        stringBuilder.append(this.f29959f);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f29957d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f29958e;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ImageResolution imageResolution = this.f29954a;
        hashCode = (hashCode + (imageResolution != null ? imageResolution.hashCode() : 0)) * 31;
        imageResolution = this.f29955b;
        hashCode = (hashCode + (imageResolution != null ? imageResolution.hashCode() : 0)) * 31;
        imageResolution = this.f29956c;
        hashCode = (hashCode + (imageResolution != null ? imageResolution.hashCode() : 0)) * 31;
        MessageData messageData = this.f29959f;
        if (messageData != null) {
            i = messageData.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RedditVideoContentMessageData) {
                RedditVideoContentMessageData redditVideoContentMessageData = (RedditVideoContentMessageData) obj;
                if (Intrinsics.m26845a(this.f29957d, redditVideoContentMessageData.f29957d) && Intrinsics.m26845a(this.f29958e, redditVideoContentMessageData.f29958e) && Intrinsics.m26845a(this.f29954a, redditVideoContentMessageData.f29954a) && Intrinsics.m26845a(this.f29955b, redditVideoContentMessageData.f29955b) && Intrinsics.m26845a(this.f29956c, redditVideoContentMessageData.f29956c) && Intrinsics.m26845a(this.f29959f, redditVideoContentMessageData.f29959f) != null) {
                }
            }
            return null;
        }
        return true;
    }
}
