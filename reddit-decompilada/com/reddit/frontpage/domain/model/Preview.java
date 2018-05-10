package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/domain/model/Preview;", "Lpaperparcel/PaperParcelable;", "images", "", "Lcom/reddit/frontpage/domain/model/Image;", "redditVideoPreview", "Lcom/reddit/frontpage/domain/model/RedditVideo;", "(Ljava/util/List;Lcom/reddit/frontpage/domain/model/RedditVideo;)V", "getImages", "()Ljava/util/List;", "getRedditVideoPreview", "()Lcom/reddit/frontpage/domain/model/RedditVideo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class Preview implements PaperParcelable {
    public static final Creator<Preview> CREATOR = PaperParcelPreview.CREATOR;
    public static final Companion Companion = new Companion();
    private final List<Image> images;
    @Json(a = "reddit_video_preview")
    private final RedditVideo redditVideoPreview;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/Preview$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Preview;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ Preview copy$default(Preview preview, List list, RedditVideo redditVideo, int i, Object obj) {
        if ((i & 1) != 0) {
            list = preview.images;
        }
        if ((i & 2) != 0) {
            redditVideo = preview.redditVideoPreview;
        }
        return preview.copy(list, redditVideo);
    }

    public final List<Image> component1() {
        return this.images;
    }

    public final RedditVideo component2() {
        return this.redditVideoPreview;
    }

    public final Preview copy(List<Image> list, RedditVideo redditVideo) {
        Intrinsics.m26847b(list, "images");
        return new Preview(list, redditVideo);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Preview) {
                Preview preview = (Preview) obj;
                if (Intrinsics.m26845a(this.images, preview.images) && Intrinsics.m26845a(this.redditVideoPreview, preview.redditVideoPreview)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.images;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        RedditVideo redditVideo = this.redditVideoPreview;
        if (redditVideo != null) {
            i = redditVideo.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Preview(images=");
        stringBuilder.append(this.images);
        stringBuilder.append(", redditVideoPreview=");
        stringBuilder.append(this.redditVideoPreview);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Preview(List<Image> list, RedditVideo redditVideo) {
        Intrinsics.m26847b(list, "images");
        this.images = list;
        this.redditVideoPreview = redditVideo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final List<Image> getImages() {
        return this.images;
    }

    public final RedditVideo getRedditVideoPreview() {
        return this.redditVideoPreview;
    }
}
