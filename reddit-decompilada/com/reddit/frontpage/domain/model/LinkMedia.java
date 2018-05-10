package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/domain/model/LinkMedia;", "Lpaperparcel/PaperParcelable;", "redditVideo", "Lcom/reddit/frontpage/domain/model/RedditVideo;", "(Lcom/reddit/frontpage/domain/model/RedditVideo;)V", "getRedditVideo", "()Lcom/reddit/frontpage/domain/model/RedditVideo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class LinkMedia implements PaperParcelable {
    public static final Creator<LinkMedia> CREATOR = PaperParcelLinkMedia.CREATOR;
    public static final Companion Companion = new Companion();
    @Json(a = "reddit_video")
    private final RedditVideo redditVideo;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/LinkMedia$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/LinkMedia;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ LinkMedia copy$default(LinkMedia linkMedia, RedditVideo redditVideo, int i, Object obj) {
        if ((i & 1) != 0) {
            redditVideo = linkMedia.redditVideo;
        }
        return linkMedia.copy(redditVideo);
    }

    public final RedditVideo component1() {
        return this.redditVideo;
    }

    public final LinkMedia copy(RedditVideo redditVideo) {
        return new LinkMedia(redditVideo);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkMedia) {
                if (Intrinsics.m26845a(this.redditVideo, ((LinkMedia) obj).redditVideo)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        RedditVideo redditVideo = this.redditVideo;
        return redditVideo != null ? redditVideo.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkMedia(redditVideo=");
        stringBuilder.append(this.redditVideo);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LinkMedia(RedditVideo redditVideo) {
        this.redditVideo = redditVideo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final RedditVideo getRedditVideo() {
        return this.redditVideo;
    }
}
