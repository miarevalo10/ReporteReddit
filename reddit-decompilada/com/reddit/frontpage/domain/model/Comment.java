package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.AdRequest;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jcodec.codecs.common.biari.MQEncoder;
import org.jcodec.codecs.mpeg12.MPEGConst;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\bM\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\b\b\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001vBÑ\u0002\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\r\u001a\b\u0018\u00010\u000ej\u0002`\u000f\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n\u0012\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#\u0012\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010#¢\u0006\u0002\u0010'J\t\u0010N\u001a\u00020\u0004HÆ\u0003J\t\u0010O\u001a\u00020\nHÆ\u0003J\t\u0010P\u001a\u00020\u000eHÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010R\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010T\u001a\u00020\u000eHÆ\u0003J\t\u0010U\u001a\u00020\u0004HÆ\u0003J\t\u0010V\u001a\u00020\u0004HÆ\u0003J\t\u0010W\u001a\u00020\u0004HÆ\u0003J\t\u0010X\u001a\u00020\u0004HÆ\u0003J\t\u0010Y\u001a\u00020\u0004HÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\\\u001a\u00020\u000eHÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010^\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010_\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010AJ\u0015\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#HÆ\u0003J\u0015\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#HÆ\u0003J\t\u0010d\u001a\u00020\u0004HÆ\u0003J\t\u0010e\u001a\u00020\nHÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010#HÂ\u0003J\t\u0010g\u001a\u00020\u0004HÆ\u0003J\t\u0010h\u001a\u00020\u0004HÆ\u0003J\t\u0010i\u001a\u00020\nHÆ\u0003J\t\u0010j\u001a\u00020\u0004HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0014\u0010l\u001a\b\u0018\u00010\u000ej\u0002`\u000fHÆ\u0003¢\u0006\u0002\u0010)Jþ\u0002\u0010m\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\r\u001a\b\u0018\u00010\u000ej\u0002`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#2\u0014\b\u0002\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#2\b\b\u0002\u0010%\u001a\u00020\n2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010#HÆ\u0001¢\u0006\u0002\u0010nJ\u0013\u0010o\u001a\u00020\u000e2\b\u0010p\u001a\u0004\u0018\u00010qHÖ\u0003J\u000e\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00010sH\u0016J\t\u0010t\u001a\u00020\nHÖ\u0001J\t\u0010u\u001a\u00020\u0004HÖ\u0001R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u001e\u0010\r\u001a\b\u0018\u00010\u000ej\u0002`\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b0\u0010)R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0011\u0010%\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\b:\u0010)R\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001a\u0010!\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0016\u0010\u0006\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\bD\u0010)R\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010#8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bF\u00105R\u0016\u0010\u001a\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\bH\u0010)R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010.R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010,R\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010,R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010,R\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010?¨\u0006w"}, d2 = {"Lcom/reddit/frontpage/domain/model/Comment;", "Lcom/reddit/frontpage/domain/model/IComment;", "Lpaperparcel/PaperParcelable;", "id", "", "kindWithId", "parentKindWithId", "body", "bodyHtml", "score", "", "author", "authorFlairText", "authorCakeDay", "", "Lcom/reddit/frontpage/domain/model/Nullean;", "gilded", "archive", "likes", "linkTitle", "distinguished", "stickied", "subreddit", "subredditId", "subredditNamePrefixed", "linkKindWithId", "scoreHidden", "linkUrl", "saved", "approved", "spam", "removed", "approvedBy", "numReports", "modReports", "", "userReports", "depth", "replies", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;ILjava/util/List;)V", "getApproved", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApprovedBy", "()Ljava/lang/String;", "getArchive", "()Z", "getAuthor", "getAuthorCakeDay", "getAuthorFlairText", "getBody", "getBodyHtml", "getDepth", "()I", "getDistinguished", "getGilded", "getId", "getKindWithId", "getLikes", "getLinkKindWithId", "getLinkTitle", "getLinkUrl", "getModReports", "()Ljava/util/List;", "getNumReports", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getParentKindWithId", "getRemoved", "getSaved", "getScore", "getScoreHidden", "getSpam", "getStickied", "getSubreddit", "getSubredditId", "getSubredditNamePrefixed", "getUserReports", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;ILjava/util/List;)Lcom/reddit/frontpage/domain/model/Comment;", "equals", "other", "", "getInternalCommentReplies", "", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Comment.kt */
public final class Comment extends IComment implements PaperParcelable {
    public static final Creator<Comment> CREATOR = PaperParcelComment.CREATOR;
    public static final Companion Companion = new Companion();
    private final Boolean approved;
    @Json(a = "approved_by")
    private final String approvedBy;
    private final boolean archive;
    private final String author;
    @Json(a = "author_cakeday")
    private final Boolean authorCakeDay;
    @Json(a = "author_flair_text")
    private final String authorFlairText;
    private final String body;
    @Json(a = "body_html")
    private final String bodyHtml;
    private final int depth;
    private final String distinguished;
    private final int gilded;
    private final String id;
    @Json(a = "name")
    private final String kindWithId;
    private final Boolean likes;
    @Json(a = "link_id")
    private final String linkKindWithId;
    @Json(a = "link_title")
    private final String linkTitle;
    @Json(a = "link_url")
    private final String linkUrl;
    @Json(a = "mod_reports")
    private final List<List<String>> modReports;
    @Json(a = "num_reports")
    private final Integer numReports;
    @Json(a = "parent_id")
    private final String parentKindWithId;
    private final Boolean removed;
    private final transient List<IComment> replies;
    private final boolean saved;
    private final int score;
    @Json(a = "score_hidden")
    private final boolean scoreHidden;
    private final Boolean spam;
    private final boolean stickied;
    private final String subreddit;
    @Json(a = "subreddit_id")
    private final String subredditId;
    @Json(a = "subreddit_name_prefixed")
    private final String subredditNamePrefixed;
    @Json(a = "user_reports")
    private final List<List<String>> userReports;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/domain/model/Comment$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Comment;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Comment.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, boolean z, boolean z2, String str7, String str8, String str9, String str10, boolean z3, boolean z4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, null, null, i2, z, null, null, null, z2, str7, str8, str9, str10, z3, null, z4, null, null, null, null, null, list, list2, i3, null, 1204828544, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, int i2, boolean z, boolean z2, String str8, String str9, String str10, String str11, boolean z3, boolean z4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, null, i2, z, null, null, null, z2, str8, str9, str10, str11, z3, null, z4, null, null, null, null, null, list, list2, i3, null, 1204828416, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, Boolean bool5, String str15, Integer num, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, str14, z4, bool3, bool4, bool5, str15, num, list, list2, i3, null, 1073741824, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, Boolean bool5, String str15, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, str14, z4, bool3, bool4, bool5, str15, null, list, list2, i3, null, 1140850688, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, Boolean bool5, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, str14, z4, bool3, bool4, bool5, null, null, list, list2, i3, null, 1174405120, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, str14, z4, bool3, bool4, null, null, null, list, list2, i3, null, 1191182336, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, str14, z4, bool3, null, null, null, null, list, list2, i3, null, 1199570944, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, str14, z4, null, null, null, null, null, list, list2, i3, null, 1203765248, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, boolean z4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, null, z4, null, null, null, null, null, list, list2, i3, null, 1204813824, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, boolean z2, String str9, String str10, String str11, String str12, boolean z3, boolean z4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, str8, null, z2, str9, str10, str11, str12, z3, null, z4, null, null, null, null, null, list, list2, i3, null, 1204822016, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, boolean z2, String str8, String str9, String str10, String str11, boolean z3, boolean z4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, bool2, null, null, z2, str8, str9, str10, str11, z3, null, z4, null, null, null, null, null, list, list2, i3, null, 1204826112, null);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, boolean z2, String str8, String str9, String str10, String str11, boolean z3, boolean z4, List<? extends List<String>> list, List<? extends List<String>> list2, int i3) {
        this(str, str2, str3, str4, str5, i, str6, str7, bool, i2, z, null, null, null, z2, str8, str9, str10, str11, z3, null, z4, null, null, null, null, null, list, list2, i3, null, 1204828160, null);
    }

    private final List<IComment> component31() {
        return this.replies;
    }

    public static /* synthetic */ Comment copy$default(Comment comment, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, Boolean bool5, String str15, Integer num, List list, List list2, int i3, List list3, int i4, Object obj) {
        boolean z5;
        String str16;
        Comment comment2 = comment;
        int i5 = i4;
        String id = (i5 & 1) != 0 ? comment.getId() : str;
        String kindWithId = (i5 & 2) != 0 ? comment.getKindWithId() : str2;
        String parentKindWithId = (i5 & 4) != 0 ? comment.getParentKindWithId() : str3;
        String str17 = (i5 & 8) != 0 ? comment2.body : str4;
        String str18 = (i5 & 16) != 0 ? comment2.bodyHtml : str5;
        int i6 = (i5 & 32) != 0 ? comment2.score : i;
        String str19 = (i5 & 64) != 0 ? comment2.author : str6;
        String str20 = (i5 & 128) != 0 ? comment2.authorFlairText : str7;
        Boolean bool6 = (i5 & 256) != 0 ? comment2.authorCakeDay : bool;
        int i7 = (i5 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? comment2.gilded : i2;
        boolean z6 = (i5 & 1024) != 0 ? comment2.archive : z;
        Boolean bool7 = (i5 & MPEGConst.CODE_END) != 0 ? comment2.likes : bool2;
        String str21 = (i5 & 4096) != 0 ? comment2.linkTitle : str8;
        String str22 = (i5 & 8192) != 0 ? comment2.distinguished : str9;
        boolean z7 = (i5 & 16384) != 0 ? comment2.stickied : z2;
        if ((i5 & 32768) != 0) {
            z5 = z7;
            str16 = comment2.subreddit;
        } else {
            z5 = z7;
            str16 = str10;
        }
        return comment2.copy(id, kindWithId, parentKindWithId, str17, str18, i6, str19, str20, bool6, i7, z6, bool7, str21, str22, z5, str16, (65536 & i5) != 0 ? comment2.subredditId : str11, (131072 & i5) != 0 ? comment2.subredditNamePrefixed : str12, (262144 & i5) != 0 ? comment2.linkKindWithId : str13, (524288 & i5) != 0 ? comment2.scoreHidden : z3, (1048576 & i5) != 0 ? comment2.linkUrl : str14, (2097152 & i5) != 0 ? comment2.saved : z4, (4194304 & i5) != 0 ? comment2.approved : bool3, (8388608 & i5) != 0 ? comment2.spam : bool4, (16777216 & i5) != 0 ? comment2.removed : bool5, (33554432 & i5) != 0 ? comment2.approvedBy : str15, (67108864 & i5) != 0 ? comment2.numReports : num, (MQEncoder.CARRY_MASK & i5) != 0 ? comment2.modReports : list, (268435456 & i5) != 0 ? comment2.userReports : list2, (536870912 & i5) != 0 ? comment2.depth : i3, (i5 & 1073741824) != 0 ? comment2.replies : list3);
    }

    public final String component1() {
        return getId();
    }

    public final int component10() {
        return this.gilded;
    }

    public final boolean component11() {
        return this.archive;
    }

    public final Boolean component12() {
        return this.likes;
    }

    public final String component13() {
        return this.linkTitle;
    }

    public final String component14() {
        return this.distinguished;
    }

    public final boolean component15() {
        return this.stickied;
    }

    public final String component16() {
        return this.subreddit;
    }

    public final String component17() {
        return this.subredditId;
    }

    public final String component18() {
        return this.subredditNamePrefixed;
    }

    public final String component19() {
        return this.linkKindWithId;
    }

    public final String component2() {
        return getKindWithId();
    }

    public final boolean component20() {
        return this.scoreHidden;
    }

    public final String component21() {
        return this.linkUrl;
    }

    public final boolean component22() {
        return this.saved;
    }

    public final Boolean component23() {
        return this.approved;
    }

    public final Boolean component24() {
        return this.spam;
    }

    public final Boolean component25() {
        return this.removed;
    }

    public final String component26() {
        return this.approvedBy;
    }

    public final Integer component27() {
        return this.numReports;
    }

    public final List<List<String>> component28() {
        return this.modReports;
    }

    public final List<List<String>> component29() {
        return this.userReports;
    }

    public final String component3() {
        return getParentKindWithId();
    }

    public final int component30() {
        return this.depth;
    }

    public final String component4() {
        return this.body;
    }

    public final String component5() {
        return this.bodyHtml;
    }

    public final int component6() {
        return this.score;
    }

    public final String component7() {
        return this.author;
    }

    public final String component8() {
        return this.authorFlairText;
    }

    public final Boolean component9() {
        return this.authorCakeDay;
    }

    public final Comment copy(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, Boolean bool5, String str15, Integer num, List<? extends List<String>> list, List<? extends List<String>> list2, int i3, List<? extends IComment> list3) {
        String str16 = str;
        Intrinsics.m26847b(str16, "id");
        String str17 = str2;
        Intrinsics.m26847b(str17, "kindWithId");
        String str18 = str3;
        Intrinsics.m26847b(str18, "parentKindWithId");
        String str19 = str4;
        Intrinsics.m26847b(str19, "body");
        String str20 = str5;
        Intrinsics.m26847b(str20, "bodyHtml");
        String str21 = str6;
        Intrinsics.m26847b(str21, "author");
        Intrinsics.m26847b(str10, "subreddit");
        Intrinsics.m26847b(str11, "subredditId");
        Intrinsics.m26847b(str12, "subredditNamePrefixed");
        Intrinsics.m26847b(str13, "linkKindWithId");
        Intrinsics.m26847b(list, "modReports");
        Intrinsics.m26847b(list2, "userReports");
        return new Comment(str16, str17, str18, str19, str20, i, str21, str7, bool, i2, z, bool2, str8, str9, z2, str10, str11, str12, str13, z3, str14, z4, bool3, bool4, bool5, str15, num, list, list2, i3, list3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Comment) {
            Comment comment = (Comment) obj;
            if (Intrinsics.m26845a(getId(), comment.getId()) && Intrinsics.m26845a(getKindWithId(), comment.getKindWithId()) && Intrinsics.m26845a(getParentKindWithId(), comment.getParentKindWithId()) && Intrinsics.m26845a(this.body, comment.body) && Intrinsics.m26845a(this.bodyHtml, comment.bodyHtml)) {
                if ((this.score == comment.score) && Intrinsics.m26845a(this.author, comment.author) && Intrinsics.m26845a(this.authorFlairText, comment.authorFlairText) && Intrinsics.m26845a(this.authorCakeDay, comment.authorCakeDay)) {
                    if (this.gilded == comment.gilded) {
                        if ((this.archive == comment.archive) && Intrinsics.m26845a(this.likes, comment.likes) && Intrinsics.m26845a(this.linkTitle, comment.linkTitle) && Intrinsics.m26845a(this.distinguished, comment.distinguished)) {
                            if ((this.stickied == comment.stickied) && Intrinsics.m26845a(this.subreddit, comment.subreddit) && Intrinsics.m26845a(this.subredditId, comment.subredditId) && Intrinsics.m26845a(this.subredditNamePrefixed, comment.subredditNamePrefixed) && Intrinsics.m26845a(this.linkKindWithId, comment.linkKindWithId)) {
                                if ((this.scoreHidden == comment.scoreHidden) && Intrinsics.m26845a(this.linkUrl, comment.linkUrl)) {
                                    if ((this.saved == comment.saved) && Intrinsics.m26845a(this.approved, comment.approved) && Intrinsics.m26845a(this.spam, comment.spam) && Intrinsics.m26845a(this.removed, comment.removed) && Intrinsics.m26845a(this.approvedBy, comment.approvedBy) && Intrinsics.m26845a(this.numReports, comment.numReports) && Intrinsics.m26845a(this.modReports, comment.modReports) && Intrinsics.m26845a(this.userReports, comment.userReports)) {
                                        return (this.depth == comment.depth) && Intrinsics.m26845a(this.replies, comment.replies);
                                    }
                                }
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
        kindWithId = getParentKindWithId();
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.body;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.bodyHtml;
        hashCode = (((hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31) + this.score) * 31;
        kindWithId = this.author;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.authorFlairText;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        Boolean bool = this.authorCakeDay;
        hashCode = (((hashCode + (bool != null ? bool.hashCode() : 0)) * 31) + this.gilded) * 31;
        int i2 = this.archive;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        bool = this.likes;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        kindWithId = this.linkTitle;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.distinguished;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        i2 = this.stickied;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.subreddit;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.subredditId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.subredditNamePrefixed;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.linkKindWithId;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        i2 = this.scoreHidden;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        kindWithId = this.linkUrl;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        i2 = this.saved;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        bool = this.approved;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.spam;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.removed;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        kindWithId = this.approvedBy;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        Integer num = this.numReports;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        List list = this.modReports;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        list = this.userReports;
        hashCode = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.depth) * 31;
        list = this.replies;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Comment(id=");
        stringBuilder.append(getId());
        stringBuilder.append(", kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", parentKindWithId=");
        stringBuilder.append(getParentKindWithId());
        stringBuilder.append(", body=");
        stringBuilder.append(this.body);
        stringBuilder.append(", bodyHtml=");
        stringBuilder.append(this.bodyHtml);
        stringBuilder.append(", score=");
        stringBuilder.append(this.score);
        stringBuilder.append(", author=");
        stringBuilder.append(this.author);
        stringBuilder.append(", authorFlairText=");
        stringBuilder.append(this.authorFlairText);
        stringBuilder.append(", authorCakeDay=");
        stringBuilder.append(this.authorCakeDay);
        stringBuilder.append(", gilded=");
        stringBuilder.append(this.gilded);
        stringBuilder.append(", archive=");
        stringBuilder.append(this.archive);
        stringBuilder.append(", likes=");
        stringBuilder.append(this.likes);
        stringBuilder.append(", linkTitle=");
        stringBuilder.append(this.linkTitle);
        stringBuilder.append(", distinguished=");
        stringBuilder.append(this.distinguished);
        stringBuilder.append(", stickied=");
        stringBuilder.append(this.stickied);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.subreddit);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(", subredditNamePrefixed=");
        stringBuilder.append(this.subredditNamePrefixed);
        stringBuilder.append(", linkKindWithId=");
        stringBuilder.append(this.linkKindWithId);
        stringBuilder.append(", scoreHidden=");
        stringBuilder.append(this.scoreHidden);
        stringBuilder.append(", linkUrl=");
        stringBuilder.append(this.linkUrl);
        stringBuilder.append(", saved=");
        stringBuilder.append(this.saved);
        stringBuilder.append(", approved=");
        stringBuilder.append(this.approved);
        stringBuilder.append(", spam=");
        stringBuilder.append(this.spam);
        stringBuilder.append(", removed=");
        stringBuilder.append(this.removed);
        stringBuilder.append(", approvedBy=");
        stringBuilder.append(this.approvedBy);
        stringBuilder.append(", numReports=");
        stringBuilder.append(this.numReports);
        stringBuilder.append(", modReports=");
        stringBuilder.append(this.modReports);
        stringBuilder.append(", userReports=");
        stringBuilder.append(this.userReports);
        stringBuilder.append(", depth=");
        stringBuilder.append(this.depth);
        stringBuilder.append(", replies=");
        stringBuilder.append(this.replies);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
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

    public final String getBody() {
        return this.body;
    }

    public final String getBodyHtml() {
        return this.bodyHtml;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getAuthorFlairText() {
        return this.authorFlairText;
    }

    public final Boolean getAuthorCakeDay() {
        return this.authorCakeDay;
    }

    public final int getGilded() {
        return this.gilded;
    }

    public final boolean getArchive() {
        return this.archive;
    }

    public final Boolean getLikes() {
        return this.likes;
    }

    public final String getLinkTitle() {
        return this.linkTitle;
    }

    public final String getDistinguished() {
        return this.distinguished;
    }

    public final boolean getStickied() {
        return this.stickied;
    }

    public final String getSubreddit() {
        return this.subreddit;
    }

    public final String getSubredditId() {
        return this.subredditId;
    }

    public final String getSubredditNamePrefixed() {
        return this.subredditNamePrefixed;
    }

    public final String getLinkKindWithId() {
        return this.linkKindWithId;
    }

    public final boolean getScoreHidden() {
        return this.scoreHidden;
    }

    public final String getLinkUrl() {
        return this.linkUrl;
    }

    public final boolean getSaved() {
        return this.saved;
    }

    public final Boolean getApproved() {
        return this.approved;
    }

    public final Boolean getSpam() {
        return this.spam;
    }

    public final Boolean getRemoved() {
        return this.removed;
    }

    public final String getApprovedBy() {
        return this.approvedBy;
    }

    public final Integer getNumReports() {
        return this.numReports;
    }

    public final List<List<String>> getModReports() {
        return this.modReports;
    }

    public final List<List<String>> getUserReports() {
        return this.userReports;
    }

    public final int getDepth() {
        return this.depth;
    }

    public /* synthetic */ Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, Boolean bool5, String str15, Integer num, List list, List list2, int i3, List list3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        int i5 = i4;
        this(str, str2, str3, str4, str5, i, str6, (i5 & 128) != 0 ? null : str7, (i5 & 256) != 0 ? null : bool, i2, z, (i5 & MPEGConst.CODE_END) != 0 ? null : bool2, (i5 & 4096) != 0 ? null : str8, (i5 & 8192) != 0 ? null : str9, z2, str10, str11, str12, str13, z3, (1048576 & i5) != 0 ? null : str14, z4, (4194304 & i5) != 0 ? null : bool3, (8388608 & i5) != 0 ? null : bool4, (16777216 & i5) != 0 ? null : bool5, (33554432 & i5) != 0 ? null : str15, (67108864 & i5) != 0 ? null : num, list, list2, i3, (i5 & 1073741824) != 0 ? null : list3);
    }

    public Comment(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, Boolean bool, int i2, boolean z, Boolean bool2, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, boolean z4, Boolean bool3, Boolean bool4, Boolean bool5, String str15, Integer num, List<? extends List<String>> list, List<? extends List<String>> list2, int i3, List<? extends IComment> list3) {
        String str16 = str;
        String str17 = str2;
        String str18 = str3;
        String str19 = str4;
        String str20 = str5;
        String str21 = str6;
        String str22 = str10;
        String str23 = str11;
        String str24 = str12;
        String str25 = str13;
        List<? extends List<String>> list4 = list;
        List<? extends List<String>> list5 = list2;
        Intrinsics.m26847b(str16, "id");
        Intrinsics.m26847b(str17, "kindWithId");
        Intrinsics.m26847b(str18, "parentKindWithId");
        Intrinsics.m26847b(str19, "body");
        Intrinsics.m26847b(str20, "bodyHtml");
        Intrinsics.m26847b(str21, "author");
        Intrinsics.m26847b(str22, "subreddit");
        Intrinsics.m26847b(str23, "subredditId");
        Intrinsics.m26847b(str24, "subredditNamePrefixed");
        Intrinsics.m26847b(str25, "linkKindWithId");
        Intrinsics.m26847b(list4, "modReports");
        Intrinsics.m26847b(list5, "userReports");
        super();
        this.id = str16;
        this.kindWithId = str17;
        this.parentKindWithId = str18;
        this.body = str19;
        this.bodyHtml = str20;
        this.score = i;
        this.author = str21;
        this.authorFlairText = str7;
        this.authorCakeDay = bool;
        this.gilded = i2;
        this.archive = z;
        this.likes = bool2;
        this.linkTitle = str8;
        this.distinguished = str9;
        this.stickied = z2;
        this.subreddit = str22;
        this.subredditId = str23;
        this.subredditNamePrefixed = str24;
        this.linkKindWithId = str25;
        this.scoreHidden = z3;
        this.linkUrl = str14;
        this.saved = z4;
        this.approved = bool3;
        this.spam = bool4;
        this.removed = bool5;
        this.approvedBy = str15;
        this.numReports = num;
        this.modReports = list4;
        this.userReports = list5;
        this.depth = i3;
        this.replies = list3;
    }

    public final List<IComment> getInternalCommentReplies() {
        List list = this.replies;
        return list != null ? CollectionsKt___CollectionsKt.m41428c(list) : super.getInternalCommentReplies();
    }
}
