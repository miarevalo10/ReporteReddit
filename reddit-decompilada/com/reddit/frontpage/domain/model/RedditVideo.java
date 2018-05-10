package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 )2\u00020\u0001:\u0001)BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006*"}, d2 = {"Lcom/reddit/frontpage/domain/model/RedditVideo;", "Lpaperparcel/PaperParcelable;", "dashUrl", "", "duration", "", "fallBackUrl", "height", "width", "hlsUrl", "isGif", "", "scrubbedMediaUrl", "transcodingStatus", "(Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getDashUrl", "()Ljava/lang/String;", "getDuration", "()I", "getFallBackUrl", "getHeight", "getHlsUrl", "()Z", "getScrubbedMediaUrl", "getTranscodingStatus", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Link.kt */
public final class RedditVideo implements PaperParcelable {
    public static final Creator<RedditVideo> CREATOR = PaperParcelRedditVideo.CREATOR;
    public static final Companion Companion = new Companion();
    @Json(a = "dash_url")
    private final String dashUrl;
    private final int duration;
    @Json(a = "fallback_url")
    private final String fallBackUrl;
    private final int height;
    @Json(a = "hls_url")
    private final String hlsUrl;
    @Json(a = "is_gif")
    private final boolean isGif;
    @Json(a = "scrubber_media_url")
    private final String scrubbedMediaUrl;
    @Json(a = "transcoding_status")
    private final String transcodingStatus;
    private final int width;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/RedditVideo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/RedditVideo;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Link.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ RedditVideo copy$default(RedditVideo redditVideo, String str, int i, String str2, int i2, int i3, String str3, boolean z, String str4, String str5, int i4, Object obj) {
        RedditVideo redditVideo2 = redditVideo;
        int i5 = i4;
        return redditVideo2.copy((i5 & 1) != 0 ? redditVideo2.dashUrl : str, (i5 & 2) != 0 ? redditVideo2.duration : i, (i5 & 4) != 0 ? redditVideo2.fallBackUrl : str2, (i5 & 8) != 0 ? redditVideo2.height : i2, (i5 & 16) != 0 ? redditVideo2.width : i3, (i5 & 32) != 0 ? redditVideo2.hlsUrl : str3, (i5 & 64) != 0 ? redditVideo2.isGif : z, (i5 & 128) != 0 ? redditVideo2.scrubbedMediaUrl : str4, (i5 & 256) != 0 ? redditVideo2.transcodingStatus : str5);
    }

    public final String component1() {
        return this.dashUrl;
    }

    public final int component2() {
        return this.duration;
    }

    public final String component3() {
        return this.fallBackUrl;
    }

    public final int component4() {
        return this.height;
    }

    public final int component5() {
        return this.width;
    }

    public final String component6() {
        return this.hlsUrl;
    }

    public final boolean component7() {
        return this.isGif;
    }

    public final String component8() {
        return this.scrubbedMediaUrl;
    }

    public final String component9() {
        return this.transcodingStatus;
    }

    public final RedditVideo copy(String str, int i, String str2, int i2, int i3, String str3, boolean z, String str4, String str5) {
        String str6 = str;
        Intrinsics.m26847b(str6, "dashUrl");
        String str7 = str2;
        Intrinsics.m26847b(str7, "fallBackUrl");
        String str8 = str3;
        Intrinsics.m26847b(str8, "hlsUrl");
        String str9 = str4;
        Intrinsics.m26847b(str9, "scrubbedMediaUrl");
        String str10 = str5;
        Intrinsics.m26847b(str10, "transcodingStatus");
        return new RedditVideo(str6, i, str7, i2, i3, str8, z, str9, str10);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RedditVideo) {
            RedditVideo redditVideo = (RedditVideo) obj;
            if (Intrinsics.m26845a(this.dashUrl, redditVideo.dashUrl)) {
                if ((this.duration == redditVideo.duration) && Intrinsics.m26845a(this.fallBackUrl, redditVideo.fallBackUrl)) {
                    if (this.height == redditVideo.height) {
                        if ((this.width == redditVideo.width) && Intrinsics.m26845a(this.hlsUrl, redditVideo.hlsUrl)) {
                            return (this.isGif == redditVideo.isGif) && Intrinsics.m26845a(this.scrubbedMediaUrl, redditVideo.scrubbedMediaUrl) && Intrinsics.m26845a(this.transcodingStatus, redditVideo.transcodingStatus);
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.dashUrl;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.duration) * 31;
        String str2 = this.fallBackUrl;
        hashCode = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.height) * 31) + this.width) * 31;
        str2 = this.hlsUrl;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.isGif;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.scrubbedMediaUrl;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.transcodingStatus;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RedditVideo(dashUrl=");
        stringBuilder.append(this.dashUrl);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", fallBackUrl=");
        stringBuilder.append(this.fallBackUrl);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", hlsUrl=");
        stringBuilder.append(this.hlsUrl);
        stringBuilder.append(", isGif=");
        stringBuilder.append(this.isGif);
        stringBuilder.append(", scrubbedMediaUrl=");
        stringBuilder.append(this.scrubbedMediaUrl);
        stringBuilder.append(", transcodingStatus=");
        stringBuilder.append(this.transcodingStatus);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RedditVideo(String str, int i, String str2, int i2, int i3, String str3, boolean z, String str4, String str5) {
        Intrinsics.m26847b(str, "dashUrl");
        Intrinsics.m26847b(str2, "fallBackUrl");
        Intrinsics.m26847b(str3, "hlsUrl");
        Intrinsics.m26847b(str4, "scrubbedMediaUrl");
        Intrinsics.m26847b(str5, "transcodingStatus");
        this.dashUrl = str;
        this.duration = i;
        this.fallBackUrl = str2;
        this.height = i2;
        this.width = i3;
        this.hlsUrl = str3;
        this.isGif = z;
        this.scrubbedMediaUrl = str4;
        this.transcodingStatus = str5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public final String getDashUrl() {
        return this.dashUrl;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getFallBackUrl() {
        return this.fallBackUrl;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final String getHlsUrl() {
        return this.hlsUrl;
    }

    public final boolean isGif() {
        return this.isGif;
    }

    public final String getScrubbedMediaUrl() {
        return this.scrubbedMediaUrl;
    }

    public final String getTranscodingStatus() {
        return this.transcodingStatus;
    }
}
