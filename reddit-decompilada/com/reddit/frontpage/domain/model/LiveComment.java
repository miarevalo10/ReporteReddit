package com.reddit.frontpage.domain.model;

import com.google.android.gms.ads.AdRequest;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001b¢\u0006\u0002\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0014HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u0015\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\u000bHÆ\u0003Jû\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001bHÆ\u0001J\u0013\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010R\u001a\u00020\u000bHÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0016\u0010\u000e\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$¨\u0006T"}, d2 = {"Lcom/reddit/frontpage/domain/model/LiveComment;", "Lcom/reddit/frontpage/domain/model/IComment;", "id", "", "kindWithId", "parentKindWithId", "parentId", "body", "bodyHtml", "context", "totalCommentCount", "", "score", "fullDate", "authorId", "authorFlairText", "flairCssClass", "flairPosition", "author", "createdUtc", "", "authorKindWithId", "subredditKindWithId", "linkKindWithId", "subreddit", "subredditNamePrefixed", "attribs", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAttribs", "()Ljava/util/List;", "getAuthor", "()Ljava/lang/String;", "getAuthorFlairText", "getAuthorId", "()I", "getAuthorKindWithId", "getBody", "getBodyHtml", "getContext", "getCreatedUtc", "()J", "getFlairCssClass", "getFlairPosition", "getFullDate", "getId", "getKindWithId", "getLinkKindWithId", "getParentId", "getParentKindWithId", "getScore", "getSubreddit", "getSubredditKindWithId", "getSubredditNamePrefixed", "getTotalCommentCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Comment.kt */
public final class LiveComment extends IComment {
    private final List<List<Object>> attribs;
    private final String author;
    @Json(a = "author_flair_text")
    private final String authorFlairText;
    @Json(a = "author_id")
    private final int authorId;
    @Json(a = "author_fullname")
    private final String authorKindWithId;
    private final String body;
    @Json(a = "body_html")
    private final String bodyHtml;
    private final String context;
    @Json(a = "created_utc")
    private final long createdUtc;
    @Json(a = "flair_css_class")
    private final String flairCssClass;
    @Json(a = "flair_position")
    private final String flairPosition;
    @Json(a = "full_date")
    private final String fullDate;
    @Json(a = "_id36")
    private final String id;
    @Json(a = "name")
    private final String kindWithId;
    @Json(a = "link_id")
    private final String linkKindWithId;
    @Json(a = "parent_id36")
    private final String parentId;
    @Json(a = "parent_id")
    private final String parentKindWithId;
    private final int score;
    private final String subreddit;
    @Json(a = "subreddit_id")
    private final String subredditKindWithId;
    @Json(a = "subreddit_name_prefixed")
    private final String subredditNamePrefixed;
    @Json(a = "total_comment_count")
    private final int totalCommentCount;

    public static /* synthetic */ LiveComment copy$default(LiveComment liveComment, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, String str8, int i3, String str9, String str10, String str11, String str12, long j, String str13, String str14, String str15, String str16, String str17, List list, int i4, Object obj) {
        String str18;
        String str19;
        long j2;
        LiveComment liveComment2 = liveComment;
        int i5 = i4;
        String id = (i5 & 1) != 0 ? liveComment.getId() : str;
        String kindWithId = (i5 & 2) != 0 ? liveComment.getKindWithId() : str2;
        String parentKindWithId = (i5 & 4) != 0 ? liveComment.getParentKindWithId() : str3;
        String str20 = (i5 & 8) != 0 ? liveComment2.parentId : str4;
        String str21 = (i5 & 16) != 0 ? liveComment2.body : str5;
        String str22 = (i5 & 32) != 0 ? liveComment2.bodyHtml : str6;
        String str23 = (i5 & 64) != 0 ? liveComment2.context : str7;
        int i6 = (i5 & 128) != 0 ? liveComment2.totalCommentCount : i;
        int i7 = (i5 & 256) != 0 ? liveComment2.score : i2;
        String str24 = (i5 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? liveComment2.fullDate : str8;
        int i8 = (i5 & 1024) != 0 ? liveComment2.authorId : i3;
        String str25 = (i5 & MPEGConst.CODE_END) != 0 ? liveComment2.authorFlairText : str9;
        String str26 = (i5 & 4096) != 0 ? liveComment2.flairCssClass : str10;
        String str27 = (i5 & 8192) != 0 ? liveComment2.flairPosition : str11;
        String str28 = (i5 & 16384) != 0 ? liveComment2.author : str12;
        if ((i5 & 32768) != 0) {
            str18 = str26;
            str19 = str28;
            j2 = liveComment2.createdUtc;
        } else {
            str18 = str26;
            str19 = str28;
            j2 = j;
        }
        return liveComment2.copy(id, kindWithId, parentKindWithId, str20, str21, str22, str23, i6, i7, str24, i8, str25, str18, str27, str19, j2, (65536 & i5) != 0 ? liveComment2.authorKindWithId : str13, (131072 & i5) != 0 ? liveComment2.subredditKindWithId : str14, (262144 & i5) != 0 ? liveComment2.linkKindWithId : str15, (524288 & i5) != 0 ? liveComment2.subreddit : str16, (1048576 & i5) != 0 ? liveComment2.subredditNamePrefixed : str17, (i5 & 2097152) != 0 ? liveComment2.attribs : list);
    }

    public final String component1() {
        return getId();
    }

    public final String component10() {
        return this.fullDate;
    }

    public final int component11() {
        return this.authorId;
    }

    public final String component12() {
        return this.authorFlairText;
    }

    public final String component13() {
        return this.flairCssClass;
    }

    public final String component14() {
        return this.flairPosition;
    }

    public final String component15() {
        return this.author;
    }

    public final long component16() {
        return this.createdUtc;
    }

    public final String component17() {
        return this.authorKindWithId;
    }

    public final String component18() {
        return this.subredditKindWithId;
    }

    public final String component19() {
        return this.linkKindWithId;
    }

    public final String component2() {
        return getKindWithId();
    }

    public final String component20() {
        return this.subreddit;
    }

    public final String component21() {
        return this.subredditNamePrefixed;
    }

    public final List<List<Object>> component22() {
        return this.attribs;
    }

    public final String component3() {
        return getParentKindWithId();
    }

    public final String component4() {
        return this.parentId;
    }

    public final String component5() {
        return this.body;
    }

    public final String component6() {
        return this.bodyHtml;
    }

    public final String component7() {
        return this.context;
    }

    public final int component8() {
        return this.totalCommentCount;
    }

    public final int component9() {
        return this.score;
    }

    public final LiveComment copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, String str8, int i3, String str9, String str10, String str11, String str12, long j, String str13, String str14, String str15, String str16, String str17, List<? extends List<? extends Object>> list) {
        String str18 = str;
        Intrinsics.m26847b(str18, "id");
        String str19 = str2;
        Intrinsics.m26847b(str19, "kindWithId");
        String str20 = str5;
        Intrinsics.m26847b(str20, "body");
        String str21 = str6;
        Intrinsics.m26847b(str21, "bodyHtml");
        String str22 = str7;
        Intrinsics.m26847b(str22, "context");
        String str23 = str8;
        Intrinsics.m26847b(str23, "fullDate");
        Intrinsics.m26847b(str12, "author");
        Intrinsics.m26847b(str13, "authorKindWithId");
        Intrinsics.m26847b(str14, "subredditKindWithId");
        Intrinsics.m26847b(str15, "linkKindWithId");
        Intrinsics.m26847b(str16, "subreddit");
        Intrinsics.m26847b(str17, "subredditNamePrefixed");
        Intrinsics.m26847b(list, "attribs");
        return new LiveComment(str18, str19, str3, str4, str20, str21, str22, i, i2, str23, i3, str9, str10, str11, str12, j, str13, str14, str15, str16, str17, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveComment) {
            LiveComment liveComment = (LiveComment) obj;
            if (Intrinsics.m26845a(getId(), liveComment.getId()) && Intrinsics.m26845a(getKindWithId(), liveComment.getKindWithId()) && Intrinsics.m26845a(getParentKindWithId(), liveComment.getParentKindWithId()) && Intrinsics.m26845a(this.parentId, liveComment.parentId) && Intrinsics.m26845a(this.body, liveComment.body) && Intrinsics.m26845a(this.bodyHtml, liveComment.bodyHtml) && Intrinsics.m26845a(this.context, liveComment.context)) {
                if (this.totalCommentCount == liveComment.totalCommentCount) {
                    if ((this.score == liveComment.score) && Intrinsics.m26845a(this.fullDate, liveComment.fullDate)) {
                        if ((this.authorId == liveComment.authorId) && Intrinsics.m26845a(this.authorFlairText, liveComment.authorFlairText) && Intrinsics.m26845a(this.flairCssClass, liveComment.flairCssClass) && Intrinsics.m26845a(this.flairPosition, liveComment.flairPosition) && Intrinsics.m26845a(this.author, liveComment.author)) {
                            return ((this.createdUtc > liveComment.createdUtc ? 1 : (this.createdUtc == liveComment.createdUtc ? 0 : -1)) == 0) && Intrinsics.m26845a(this.authorKindWithId, liveComment.authorKindWithId) && Intrinsics.m26845a(this.subredditKindWithId, liveComment.subredditKindWithId) && Intrinsics.m26845a(this.linkKindWithId, liveComment.linkKindWithId) && Intrinsics.m26845a(this.subreddit, liveComment.subreddit) && Intrinsics.m26845a(this.subredditNamePrefixed, liveComment.subredditNamePrefixed) && Intrinsics.m26845a(this.attribs, liveComment.attribs);
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
        kindWithId = getParentKindWithId();
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.parentId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.body;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.bodyHtml;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.context;
        hashCode = (((((hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31) + this.totalCommentCount) * 31) + this.score) * 31;
        kindWithId = this.fullDate;
        hashCode = (((hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31) + this.authorId) * 31;
        kindWithId = this.authorFlairText;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.flairCssClass;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.flairPosition;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.author;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        long j = this.createdUtc;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        kindWithId = this.authorKindWithId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.subredditKindWithId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.linkKindWithId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.subreddit;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.subredditNamePrefixed;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        List list = this.attribs;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LiveComment(id=");
        stringBuilder.append(getId());
        stringBuilder.append(", kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", parentKindWithId=");
        stringBuilder.append(getParentKindWithId());
        stringBuilder.append(", parentId=");
        stringBuilder.append(this.parentId);
        stringBuilder.append(", body=");
        stringBuilder.append(this.body);
        stringBuilder.append(", bodyHtml=");
        stringBuilder.append(this.bodyHtml);
        stringBuilder.append(", context=");
        stringBuilder.append(this.context);
        stringBuilder.append(", totalCommentCount=");
        stringBuilder.append(this.totalCommentCount);
        stringBuilder.append(", score=");
        stringBuilder.append(this.score);
        stringBuilder.append(", fullDate=");
        stringBuilder.append(this.fullDate);
        stringBuilder.append(", authorId=");
        stringBuilder.append(this.authorId);
        stringBuilder.append(", authorFlairText=");
        stringBuilder.append(this.authorFlairText);
        stringBuilder.append(", flairCssClass=");
        stringBuilder.append(this.flairCssClass);
        stringBuilder.append(", flairPosition=");
        stringBuilder.append(this.flairPosition);
        stringBuilder.append(", author=");
        stringBuilder.append(this.author);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(this.createdUtc);
        stringBuilder.append(", authorKindWithId=");
        stringBuilder.append(this.authorKindWithId);
        stringBuilder.append(", subredditKindWithId=");
        stringBuilder.append(this.subredditKindWithId);
        stringBuilder.append(", linkKindWithId=");
        stringBuilder.append(this.linkKindWithId);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(", subredditNamePrefixed=");
        stringBuilder.append(this.subredditNamePrefixed);
        stringBuilder.append(", attribs=");
        stringBuilder.append(this.attribs);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final String getId() {
        return this.id;
    }

    public final String getKindWithId() {
        return this.kindWithId;
    }

    public final String getParentKindWithId() {
        return this.parentKindWithId;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getBodyHtml() {
        return this.bodyHtml;
    }

    public final String getContext() {
        return this.context;
    }

    public final int getTotalCommentCount() {
        return this.totalCommentCount;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getFullDate() {
        return this.fullDate;
    }

    public final int getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorFlairText() {
        return this.authorFlairText;
    }

    public final String getFlairCssClass() {
        return this.flairCssClass;
    }

    public /* synthetic */ LiveComment(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, String str8, int i3, String str9, String str10, String str11, String str12, long j, String str13, String str14, String str15, String str16, String str17, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        int i5 = i4;
        this(str, str2, (i5 & 4) != 0 ? null : str3, (i5 & 8) != 0 ? null : str4, str5, str6, str7, i, i2, str8, i3, (i5 & MPEGConst.CODE_END) != 0 ? null : str9, (i5 & 4096) != 0 ? null : str10, (i5 & 8192) != 0 ? null : str11, str12, j, str13, str14, str15, str16, str17, list);
    }

    public final String getFlairPosition() {
        return this.flairPosition;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final String getAuthorKindWithId() {
        return this.authorKindWithId;
    }

    public final String getSubredditKindWithId() {
        return this.subredditKindWithId;
    }

    public final String getLinkKindWithId() {
        return this.linkKindWithId;
    }

    public final String getSubreddit() {
        return this.subreddit;
    }

    public final String getSubredditNamePrefixed() {
        return this.subredditNamePrefixed;
    }

    public final List<List<Object>> getAttribs() {
        return this.attribs;
    }

    public LiveComment(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, String str8, int i3, String str9, String str10, String str11, String str12, long j, String str13, String str14, String str15, String str16, String str17, List<? extends List<? extends Object>> list) {
        String str18 = str;
        String str19 = str2;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str12;
        String str25 = str13;
        String str26 = str14;
        String str27 = str15;
        String str28 = str16;
        String str29 = str17;
        List<? extends List<? extends Object>> list2 = list;
        Intrinsics.m26847b(str18, "id");
        Intrinsics.m26847b(str19, "kindWithId");
        Intrinsics.m26847b(str20, "body");
        Intrinsics.m26847b(str21, "bodyHtml");
        Intrinsics.m26847b(str22, "context");
        Intrinsics.m26847b(str23, "fullDate");
        Intrinsics.m26847b(str24, "author");
        Intrinsics.m26847b(str25, "authorKindWithId");
        Intrinsics.m26847b(str26, "subredditKindWithId");
        Intrinsics.m26847b(str27, "linkKindWithId");
        Intrinsics.m26847b(str28, "subreddit");
        Intrinsics.m26847b(str29, "subredditNamePrefixed");
        Intrinsics.m26847b(list2, "attribs");
        super();
        this.id = str18;
        this.kindWithId = str19;
        this.parentKindWithId = str3;
        this.parentId = str4;
        this.body = str20;
        this.bodyHtml = str21;
        this.context = str22;
        this.totalCommentCount = i;
        this.score = i2;
        this.fullDate = str23;
        this.authorId = i3;
        this.authorFlairText = str9;
        this.flairCssClass = str10;
        this.flairPosition = str11;
        this.author = str24;
        this.createdUtc = j;
        this.authorKindWithId = str25;
        this.subredditKindWithId = str26;
        this.linkKindWithId = str27;
        this.subreddit = str28;
        this.subredditNamePrefixed = str29;
        this.attribs = list2;
    }
}
