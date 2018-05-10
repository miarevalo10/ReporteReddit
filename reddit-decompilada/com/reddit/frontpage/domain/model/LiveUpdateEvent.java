package com.reddit.frontpage.domain.model;

import com.google.android.gms.ads.AdRequest;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010%J\t\u0010/\u001a\u00020\u0011HÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J¦\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u000b2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0011HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00068\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0016\u0010\u0012\u001a\u00020\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0013\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001a¨\u0006A"}, d2 = {"Lcom/reddit/frontpage/domain/model/LiveUpdateEvent;", "Lcom/reddit/frontpage/domain/model/ILink;", "id", "", "kindWithId", "created", "", "createdUtc", "description", "descriptionHtml", "nsfw", "", "resources", "resourcesHtml", "state", "title", "totalViews", "", "viewerCount", "viewerCountFuzzed", "webSocketUrl", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/String;)V", "getCreated", "()J", "getCreatedUtc", "getDescription", "()Ljava/lang/String;", "getDescriptionHtml", "getId", "getKindWithId", "getNsfw", "()Z", "getResources", "getResourcesHtml", "getState", "getTitle", "getTotalViews", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getViewerCount", "()I", "getViewerCountFuzzed", "getWebSocketUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZLjava/lang/String;)Lcom/reddit/frontpage/domain/model/LiveUpdateEvent;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Link.kt */
public final class LiveUpdateEvent extends ILink {
    private final long created;
    @Json(a = "created_utc")
    private final long createdUtc;
    private final String description;
    @Json(a = "description_html")
    private final String descriptionHtml;
    private final String id;
    @Json(a = "name")
    private final String kindWithId;
    private final boolean nsfw;
    private final String resources;
    @Json(a = "resources_html")
    private final String resourcesHtml;
    private final String state;
    private final String title;
    @Json(a = "total_views")
    private final Integer totalViews;
    @Json(a = "viewer_count")
    private final int viewerCount;
    @Json(a = "viewer_count_fuzzed")
    private final boolean viewerCountFuzzed;
    @Json(a = "websocket_url")
    private final String webSocketUrl;

    public static /* synthetic */ LiveUpdateEvent copy$default(LiveUpdateEvent liveUpdateEvent, String str, String str2, long j, long j2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, Integer num, int i, boolean z2, String str9, int i2, Object obj) {
        LiveUpdateEvent liveUpdateEvent2 = liveUpdateEvent;
        int i3 = i2;
        return liveUpdateEvent2.copy((i3 & 1) != 0 ? liveUpdateEvent.getId() : str, (i3 & 2) != 0 ? liveUpdateEvent.getKindWithId() : str2, (i3 & 4) != 0 ? liveUpdateEvent2.created : j, (i3 & 8) != 0 ? liveUpdateEvent.getCreatedUtc() : j2, (i3 & 16) != 0 ? liveUpdateEvent2.description : str3, (i3 & 32) != 0 ? liveUpdateEvent2.descriptionHtml : str4, (i3 & 64) != 0 ? liveUpdateEvent2.nsfw : z, (i3 & 128) != 0 ? liveUpdateEvent2.resources : str5, (i3 & 256) != 0 ? liveUpdateEvent2.resourcesHtml : str6, (i3 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? liveUpdateEvent2.state : str7, (i3 & 1024) != 0 ? liveUpdateEvent2.title : str8, (i3 & MPEGConst.CODE_END) != 0 ? liveUpdateEvent2.totalViews : num, (i3 & 4096) != 0 ? liveUpdateEvent2.viewerCount : i, (i3 & 8192) != 0 ? liveUpdateEvent2.viewerCountFuzzed : z2, (i3 & 16384) != 0 ? liveUpdateEvent2.webSocketUrl : str9);
    }

    public final String component1() {
        return getId();
    }

    public final String component10() {
        return this.state;
    }

    public final String component11() {
        return this.title;
    }

    public final Integer component12() {
        return this.totalViews;
    }

    public final int component13() {
        return this.viewerCount;
    }

    public final boolean component14() {
        return this.viewerCountFuzzed;
    }

    public final String component15() {
        return this.webSocketUrl;
    }

    public final String component2() {
        return getKindWithId();
    }

    public final long component3() {
        return this.created;
    }

    public final long component4() {
        return getCreatedUtc();
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.descriptionHtml;
    }

    public final boolean component7() {
        return this.nsfw;
    }

    public final String component8() {
        return this.resources;
    }

    public final String component9() {
        return this.resourcesHtml;
    }

    public final LiveUpdateEvent copy(String str, String str2, long j, long j2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, Integer num, int i, boolean z2, String str9) {
        String str10 = str;
        Intrinsics.m26847b(str10, "id");
        String str11 = str2;
        Intrinsics.m26847b(str11, "kindWithId");
        String str12 = str3;
        Intrinsics.m26847b(str12, "description");
        String str13 = str4;
        Intrinsics.m26847b(str13, "descriptionHtml");
        String str14 = str5;
        Intrinsics.m26847b(str14, "resources");
        String str15 = str6;
        Intrinsics.m26847b(str15, "resourcesHtml");
        String str16 = str7;
        Intrinsics.m26847b(str16, "state");
        String str17 = str8;
        Intrinsics.m26847b(str17, "title");
        Intrinsics.m26847b(str9, "webSocketUrl");
        return new LiveUpdateEvent(str10, str11, j, j2, str12, str13, z, str14, str15, str16, str17, num, i, z2, str9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveUpdateEvent) {
            LiveUpdateEvent liveUpdateEvent = (LiveUpdateEvent) obj;
            if (Intrinsics.m26845a(getId(), liveUpdateEvent.getId()) && Intrinsics.m26845a(getKindWithId(), liveUpdateEvent.getKindWithId())) {
                if (this.created == liveUpdateEvent.created) {
                    if ((getCreatedUtc() == liveUpdateEvent.getCreatedUtc()) && Intrinsics.m26845a(this.description, liveUpdateEvent.description) && Intrinsics.m26845a(this.descriptionHtml, liveUpdateEvent.descriptionHtml)) {
                        if ((this.nsfw == liveUpdateEvent.nsfw) && Intrinsics.m26845a(this.resources, liveUpdateEvent.resources) && Intrinsics.m26845a(this.resourcesHtml, liveUpdateEvent.resourcesHtml) && Intrinsics.m26845a(this.state, liveUpdateEvent.state) && Intrinsics.m26845a(this.title, liveUpdateEvent.title) && Intrinsics.m26845a(this.totalViews, liveUpdateEvent.totalViews)) {
                            if (this.viewerCount == liveUpdateEvent.viewerCount) {
                                return (this.viewerCountFuzzed == liveUpdateEvent.viewerCountFuzzed) && Intrinsics.m26845a(this.webSocketUrl, liveUpdateEvent.webSocketUrl);
                            }
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String id = getId();
        int i = 0;
        int hashCode = (id != null ? id.hashCode() : 0) * 31;
        String kindWithId = getKindWithId();
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        long j = this.created;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        j = getCreatedUtc();
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        kindWithId = this.description;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.descriptionHtml;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        int i2 = this.nsfw;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.resources;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.resourcesHtml;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.state;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.title;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        Integer num = this.totalViews;
        hashCode = (((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.viewerCount) * 31;
        i2 = this.viewerCountFuzzed;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.webSocketUrl;
        if (kindWithId != null) {
            i = kindWithId.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LiveUpdateEvent(id=");
        stringBuilder.append(getId());
        stringBuilder.append(", kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", created=");
        stringBuilder.append(this.created);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(getCreatedUtc());
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", descriptionHtml=");
        stringBuilder.append(this.descriptionHtml);
        stringBuilder.append(", nsfw=");
        stringBuilder.append(this.nsfw);
        stringBuilder.append(", resources=");
        stringBuilder.append(this.resources);
        stringBuilder.append(", resourcesHtml=");
        stringBuilder.append(this.resourcesHtml);
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", totalViews=");
        stringBuilder.append(this.totalViews);
        stringBuilder.append(", viewerCount=");
        stringBuilder.append(this.viewerCount);
        stringBuilder.append(", viewerCountFuzzed=");
        stringBuilder.append(this.viewerCountFuzzed);
        stringBuilder.append(", webSocketUrl=");
        stringBuilder.append(this.webSocketUrl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String getId() {
        return this.id;
    }

    public final String getKindWithId() {
        return this.kindWithId;
    }

    public final long getCreated() {
        return this.created;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDescriptionHtml() {
        return this.descriptionHtml;
    }

    public final boolean getNsfw() {
        return this.nsfw;
    }

    public final String getResources() {
        return this.resources;
    }

    public final String getResourcesHtml() {
        return this.resourcesHtml;
    }

    public final String getState() {
        return this.state;
    }

    public final String getTitle() {
        return this.title;
    }

    public /* synthetic */ LiveUpdateEvent(String str, String str2, long j, long j2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, Integer num, int i, boolean z2, String str9, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, j2, str3, str4, z, str5, str6, str7, str8, (i2 & MPEGConst.CODE_END) != 0 ? null : num, i, z2, str9);
    }

    public final Integer getTotalViews() {
        return this.totalViews;
    }

    public final int getViewerCount() {
        return this.viewerCount;
    }

    public final boolean getViewerCountFuzzed() {
        return this.viewerCountFuzzed;
    }

    public final String getWebSocketUrl() {
        return this.webSocketUrl;
    }

    public LiveUpdateEvent(String str, String str2, long j, long j2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, Integer num, int i, boolean z2, String str9) {
        String str10 = str;
        String str11 = str2;
        String str12 = str3;
        String str13 = str4;
        String str14 = str5;
        String str15 = str6;
        String str16 = str7;
        String str17 = str8;
        String str18 = str9;
        Intrinsics.m26847b(str10, "id");
        Intrinsics.m26847b(str11, "kindWithId");
        Intrinsics.m26847b(str12, "description");
        Intrinsics.m26847b(str13, "descriptionHtml");
        Intrinsics.m26847b(str14, "resources");
        Intrinsics.m26847b(str15, "resourcesHtml");
        Intrinsics.m26847b(str16, "state");
        Intrinsics.m26847b(str17, "title");
        Intrinsics.m26847b(str18, "webSocketUrl");
        super();
        this.id = str10;
        this.kindWithId = str11;
        this.created = j;
        this.createdUtc = j2;
        this.description = str12;
        this.descriptionHtml = str13;
        this.nsfw = z;
        this.resources = str14;
        this.resourcesHtml = str15;
        this.state = str16;
        this.title = str17;
        this.totalViews = num;
        this.viewerCount = i;
        this.viewerCountFuzzed = z2;
        this.webSocketUrl = str18;
    }
}
