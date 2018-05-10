package com.reddit.frontpage.domain.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.AdRequest;
import com.reddit.common.ThingUtil;
import com.reddit.datalibrary.frontpage.data.model.RedditModel;
import com.reddit.datalibrary.frontpage.requests.models.v1.BaseThing;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.codecs.common.biari.MQEncoder;
import org.jcodec.codecs.mpeg12.MPEGConst;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0001xB¹\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010#J\t\u0010Q\u001a\u00020\u0004HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010T\u001a\u00020\u0004HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010V\u001a\u00020\u0012HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010%J\t\u0010X\u001a\u00020\u0012HÆ\u0003J\t\u0010Y\u001a\u00020\u0004HÆ\u0003J\t\u0010Z\u001a\u00020\u0004HÆ\u0003J\t\u0010[\u001a\u00020\u0018HÆ\u0003J\t\u0010\\\u001a\u00020\u0004HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010b\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010c\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010d\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010e\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010f\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\t\u0010g\u001a\u00020\u0004HÆ\u0003J\t\u0010h\u001a\u00020\u0004HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010j\u001a\u00020\u0004HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÔ\u0002\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020\u00182\b\u0010q\u001a\u0004\u0018\u00010rHÖ\u0003J\t\u0010s\u001a\u00020tHÖ\u0001J\u0006\u0010u\u001a\u00020vJ\t\u0010w\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0014\u001a\u00020\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u00106\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b:\u0010(R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u00107R\u0011\u0010<\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\bB\u0010(R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010,R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bE\u0010.R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010,R\"\u0010\"\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bH\u0010(\"\u0004\bI\u0010JR\"\u0010 \u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bK\u0010(\"\u0004\bL\u0010JR\"\u0010!\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bM\u0010(\"\u0004\bN\u0010JR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010,R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\bP\u0010(¨\u0006y"}, d2 = {"Lcom/reddit/frontpage/domain/model/Subreddit;", "Lcom/reddit/datalibrary/frontpage/data/model/RedditModel;", "Lpaperparcel/PaperParcelable;", "id", "", "kindWithId", "displayName", "displayNamePrefixed", "iconImg", "keyColor", "bannerImg", "headerImg", "title", "description", "descriptionHtml", "publicDescription", "publicDescriptionHtml", "subscribers", "", "accountsActive", "createdUtc", "subredditType", "url", "over18", "", "wikiEnabled", "whitelistStatus", "newModMailEnabled", "submitType", "allowImages", "allowVideos", "spoilersEnabled", "userIsModerator", "userIsSubscriber", "userHasFavorited", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAccountsActive", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAllowImages", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowVideos", "getBannerImg", "()Ljava/lang/String;", "getCreatedUtc", "()J", "getDescription", "getDescriptionHtml", "getDisplayName", "getDisplayNamePrefixed", "getHeaderImg", "getIconImg", "getId", "isUser", "()Z", "getKeyColor", "getKindWithId", "getNewModMailEnabled", "getOver18", "postPermissions", "Lcom/reddit/frontpage/domain/model/PostPermissions;", "getPostPermissions", "()Lcom/reddit/frontpage/domain/model/PostPermissions;", "getPublicDescription", "getPublicDescriptionHtml", "getSpoilersEnabled", "getSubmitType", "getSubredditType", "getSubscribers", "getTitle", "getUrl", "getUserHasFavorited", "setUserHasFavorited", "(Ljava/lang/Boolean;)V", "getUserIsModerator", "setUserIsModerator", "getUserIsSubscriber", "setUserIsSubscriber", "getWhitelistStatus", "getWikiEnabled", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/reddit/frontpage/domain/model/Subreddit;", "equals", "other", "", "hashCode", "", "toLegacyV1Subreddit", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Subreddit;", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: Subreddit.kt */
public final class Subreddit implements RedditModel, PaperParcelable {
    public static final Creator<Subreddit> CREATOR = PaperParcelSubreddit.CREATOR;
    public static final Companion Companion = new Companion();
    public static final String SUBREDDIT_TYPE_USER = "user";
    @Json(a = "accounts_active")
    private final Long accountsActive;
    @Json(a = "allow_images")
    private final Boolean allowImages;
    @Json(a = "allow_videos")
    private final Boolean allowVideos;
    @Json(a = "banner_img")
    private final String bannerImg;
    @Json(a = "created_utc")
    private final long createdUtc;
    private final String description;
    @Json(a = "description_html")
    private final String descriptionHtml;
    @Json(a = "display_name")
    private final String displayName;
    @Json(a = "display_name_prefixed")
    private final String displayNamePrefixed;
    @Json(a = "header_img")
    private final String headerImg;
    @Json(a = "icon_img")
    private final String iconImg;
    @Json(a = "id")
    private final String id;
    @Json(a = "key_color")
    private final String keyColor;
    @Json(a = "name")
    private final String kindWithId;
    @Json(a = "is_enrolled_in_new_modmail")
    private final Boolean newModMailEnabled;
    private final boolean over18;
    @Json(a = "public_description")
    private final String publicDescription;
    @Json(a = "public_description_html")
    private final String publicDescriptionHtml;
    @Json(a = "spoilers_enabled")
    private final Boolean spoilersEnabled;
    @Json(a = "submission_type")
    private final String submitType;
    @Json(a = "subreddit_type")
    private final String subredditType;
    private final long subscribers;
    private final String title;
    private final String url;
    @Json(a = "user_has_favorited")
    private Boolean userHasFavorited;
    @Json(a = "user_is_moderator")
    private Boolean userIsModerator;
    @Json(a = "user_is_subscriber")
    private Boolean userIsSubscriber;
    @Json(a = "whitelist_status")
    private final String whitelistStatus;
    @Json(a = "wiki_enabled")
    private final Boolean wikiEnabled;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/domain/model/Subreddit$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/model/Subreddit;", "kotlin.jvm.PlatformType", "SUBREDDIT_TYPE_USER", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Subreddit.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ Subreddit copy$default(Subreddit subreddit, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j, Long l, long j2, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, int i, Object obj) {
        String str18;
        long j3;
        Subreddit subreddit2 = subreddit;
        int i2 = i;
        String str19 = (i2 & 1) != 0 ? subreddit2.id : str;
        String kindWithId = (i2 & 2) != 0 ? subreddit.getKindWithId() : str2;
        String str20 = (i2 & 4) != 0 ? subreddit2.displayName : str3;
        String str21 = (i2 & 8) != 0 ? subreddit2.displayNamePrefixed : str4;
        String str22 = (i2 & 16) != 0 ? subreddit2.iconImg : str5;
        String str23 = (i2 & 32) != 0 ? subreddit2.keyColor : str6;
        String str24 = (i2 & 64) != 0 ? subreddit2.bannerImg : str7;
        String str25 = (i2 & 128) != 0 ? subreddit2.headerImg : str8;
        String str26 = (i2 & 256) != 0 ? subreddit2.title : str9;
        String str27 = (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? subreddit2.description : str10;
        String str28 = (i2 & 1024) != 0 ? subreddit2.descriptionHtml : str11;
        String str29 = (i2 & MPEGConst.CODE_END) != 0 ? subreddit2.publicDescription : str12;
        String str30 = (i2 & 4096) != 0 ? subreddit2.publicDescriptionHtml : str13;
        if ((i2 & 8192) != 0) {
            str18 = str30;
            j3 = subreddit2.subscribers;
        } else {
            str18 = str30;
            j3 = j;
        }
        return subreddit2.copy(str19, kindWithId, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str18, j3, (i2 & 16384) != 0 ? subreddit2.accountsActive : l, (32768 & i2) != 0 ? subreddit2.createdUtc : j2, (65536 & i2) != 0 ? subreddit2.subredditType : str14, (131072 & i2) != 0 ? subreddit2.url : str15, (262144 & i2) != 0 ? subreddit2.over18 : z, (524288 & i2) != 0 ? subreddit2.wikiEnabled : bool, (1048576 & i2) != 0 ? subreddit2.whitelistStatus : str16, (2097152 & i2) != 0 ? subreddit2.newModMailEnabled : bool2, (4194304 & i2) != 0 ? subreddit2.submitType : str17, (8388608 & i2) != 0 ? subreddit2.allowImages : bool3, (16777216 & i2) != 0 ? subreddit2.allowVideos : bool4, (33554432 & i2) != 0 ? subreddit2.spoilersEnabled : bool5, (67108864 & i2) != 0 ? subreddit2.userIsModerator : bool6, (MQEncoder.CARRY_MASK & i2) != 0 ? subreddit2.userIsSubscriber : bool7, (i2 & 268435456) != 0 ? subreddit2.userHasFavorited : bool8);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.description;
    }

    public final String component11() {
        return this.descriptionHtml;
    }

    public final String component12() {
        return this.publicDescription;
    }

    public final String component13() {
        return this.publicDescriptionHtml;
    }

    public final long component14() {
        return this.subscribers;
    }

    public final Long component15() {
        return this.accountsActive;
    }

    public final long component16() {
        return this.createdUtc;
    }

    public final String component17() {
        return this.subredditType;
    }

    public final String component18() {
        return this.url;
    }

    public final boolean component19() {
        return this.over18;
    }

    public final String component2() {
        return getKindWithId();
    }

    public final Boolean component20() {
        return this.wikiEnabled;
    }

    public final String component21() {
        return this.whitelistStatus;
    }

    public final Boolean component22() {
        return this.newModMailEnabled;
    }

    public final String component23() {
        return this.submitType;
    }

    public final Boolean component24() {
        return this.allowImages;
    }

    public final Boolean component25() {
        return this.allowVideos;
    }

    public final Boolean component26() {
        return this.spoilersEnabled;
    }

    public final Boolean component27() {
        return this.userIsModerator;
    }

    public final Boolean component28() {
        return this.userIsSubscriber;
    }

    public final Boolean component29() {
        return this.userHasFavorited;
    }

    public final String component3() {
        return this.displayName;
    }

    public final String component4() {
        return this.displayNamePrefixed;
    }

    public final String component5() {
        return this.iconImg;
    }

    public final String component6() {
        return this.keyColor;
    }

    public final String component7() {
        return this.bannerImg;
    }

    public final String component8() {
        return this.headerImg;
    }

    public final String component9() {
        return this.title;
    }

    public final Subreddit copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j, Long l, long j2, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8) {
        String str18 = str;
        Intrinsics.m26847b(str18, "id");
        String str19 = str2;
        Intrinsics.m26847b(str19, "kindWithId");
        String str20 = str3;
        Intrinsics.m26847b(str20, "displayName");
        String str21 = str4;
        Intrinsics.m26847b(str21, "displayNamePrefixed");
        String str22 = str6;
        Intrinsics.m26847b(str22, "keyColor");
        String str23 = str12;
        Intrinsics.m26847b(str23, "publicDescription");
        Intrinsics.m26847b(str14, "subredditType");
        Intrinsics.m26847b(str15, UpdateFragment.FRAGMENT_URL);
        return new Subreddit(str18, str19, str20, str21, str5, str22, str7, str8, str9, str10, str11, str23, str13, j, l, j2, str14, str15, z, bool, str16, bool2, str17, bool3, bool4, bool5, bool6, bool7, bool8);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Subreddit) {
            Subreddit subreddit = (Subreddit) obj;
            if (Intrinsics.m26845a(this.id, subreddit.id) && Intrinsics.m26845a(getKindWithId(), subreddit.getKindWithId()) && Intrinsics.m26845a(this.displayName, subreddit.displayName) && Intrinsics.m26845a(this.displayNamePrefixed, subreddit.displayNamePrefixed) && Intrinsics.m26845a(this.iconImg, subreddit.iconImg) && Intrinsics.m26845a(this.keyColor, subreddit.keyColor) && Intrinsics.m26845a(this.bannerImg, subreddit.bannerImg) && Intrinsics.m26845a(this.headerImg, subreddit.headerImg) && Intrinsics.m26845a(this.title, subreddit.title) && Intrinsics.m26845a(this.description, subreddit.description) && Intrinsics.m26845a(this.descriptionHtml, subreddit.descriptionHtml) && Intrinsics.m26845a(this.publicDescription, subreddit.publicDescription) && Intrinsics.m26845a(this.publicDescriptionHtml, subreddit.publicDescriptionHtml)) {
                if ((this.subscribers == subreddit.subscribers) && Intrinsics.m26845a(this.accountsActive, subreddit.accountsActive)) {
                    if ((this.createdUtc == subreddit.createdUtc) && Intrinsics.m26845a(this.subredditType, subreddit.subredditType) && Intrinsics.m26845a(this.url, subreddit.url)) {
                        return (this.over18 == subreddit.over18) && Intrinsics.m26845a(this.wikiEnabled, subreddit.wikiEnabled) && Intrinsics.m26845a(this.whitelistStatus, subreddit.whitelistStatus) && Intrinsics.m26845a(this.newModMailEnabled, subreddit.newModMailEnabled) && Intrinsics.m26845a(this.submitType, subreddit.submitType) && Intrinsics.m26845a(this.allowImages, subreddit.allowImages) && Intrinsics.m26845a(this.allowVideos, subreddit.allowVideos) && Intrinsics.m26845a(this.spoilersEnabled, subreddit.spoilersEnabled) && Intrinsics.m26845a(this.userIsModerator, subreddit.userIsModerator) && Intrinsics.m26845a(this.userIsSubscriber, subreddit.userIsSubscriber) && Intrinsics.m26845a(this.userHasFavorited, subreddit.userHasFavorited);
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String kindWithId = getKindWithId();
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.displayName;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.displayNamePrefixed;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.iconImg;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.keyColor;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.bannerImg;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.headerImg;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.title;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.description;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.descriptionHtml;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.publicDescription;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.publicDescriptionHtml;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        long j = this.subscribers;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        Long l = this.accountsActive;
        hashCode = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        j = this.createdUtc;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        kindWithId = this.subredditType;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        kindWithId = this.url;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        int i2 = this.over18;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        Boolean bool = this.wikiEnabled;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        kindWithId = this.whitelistStatus;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        bool = this.newModMailEnabled;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        kindWithId = this.submitType;
        hashCode = (hashCode + (kindWithId != null ? kindWithId.hashCode() : 0)) * 31;
        bool = this.allowImages;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.allowVideos;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.spoilersEnabled;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.userIsModerator;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.userIsSubscriber;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.userHasFavorited;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Subreddit(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", kindWithId=");
        stringBuilder.append(getKindWithId());
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.displayName);
        stringBuilder.append(", displayNamePrefixed=");
        stringBuilder.append(this.displayNamePrefixed);
        stringBuilder.append(", iconImg=");
        stringBuilder.append(this.iconImg);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", bannerImg=");
        stringBuilder.append(this.bannerImg);
        stringBuilder.append(", headerImg=");
        stringBuilder.append(this.headerImg);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", descriptionHtml=");
        stringBuilder.append(this.descriptionHtml);
        stringBuilder.append(", publicDescription=");
        stringBuilder.append(this.publicDescription);
        stringBuilder.append(", publicDescriptionHtml=");
        stringBuilder.append(this.publicDescriptionHtml);
        stringBuilder.append(", subscribers=");
        stringBuilder.append(this.subscribers);
        stringBuilder.append(", accountsActive=");
        stringBuilder.append(this.accountsActive);
        stringBuilder.append(", createdUtc=");
        stringBuilder.append(this.createdUtc);
        stringBuilder.append(", subredditType=");
        stringBuilder.append(this.subredditType);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.over18);
        stringBuilder.append(", wikiEnabled=");
        stringBuilder.append(this.wikiEnabled);
        stringBuilder.append(", whitelistStatus=");
        stringBuilder.append(this.whitelistStatus);
        stringBuilder.append(", newModMailEnabled=");
        stringBuilder.append(this.newModMailEnabled);
        stringBuilder.append(", submitType=");
        stringBuilder.append(this.submitType);
        stringBuilder.append(", allowImages=");
        stringBuilder.append(this.allowImages);
        stringBuilder.append(", allowVideos=");
        stringBuilder.append(this.allowVideos);
        stringBuilder.append(", spoilersEnabled=");
        stringBuilder.append(this.spoilersEnabled);
        stringBuilder.append(", userIsModerator=");
        stringBuilder.append(this.userIsModerator);
        stringBuilder.append(", userIsSubscriber=");
        stringBuilder.append(this.userIsSubscriber);
        stringBuilder.append(", userHasFavorited=");
        stringBuilder.append(this.userHasFavorited);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Subreddit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j, Long l, long j2, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str4;
        String str22 = str6;
        String str23 = str12;
        String str24 = str14;
        String str25 = str15;
        Intrinsics.m26847b(str18, "id");
        Intrinsics.m26847b(str19, "kindWithId");
        Intrinsics.m26847b(str20, "displayName");
        Intrinsics.m26847b(str21, "displayNamePrefixed");
        Intrinsics.m26847b(str22, "keyColor");
        Intrinsics.m26847b(str23, "publicDescription");
        Intrinsics.m26847b(str24, "subredditType");
        Intrinsics.m26847b(str25, UpdateFragment.FRAGMENT_URL);
        this.id = str18;
        this.kindWithId = str19;
        this.displayName = str20;
        this.displayNamePrefixed = str21;
        this.iconImg = str5;
        this.keyColor = str22;
        this.bannerImg = str7;
        this.headerImg = str8;
        this.title = str9;
        this.description = str10;
        this.descriptionHtml = str11;
        this.publicDescription = str23;
        this.publicDescriptionHtml = str13;
        this.subscribers = j;
        this.accountsActive = l;
        this.createdUtc = j2;
        this.subredditType = str24;
        this.url = str25;
        this.over18 = z;
        this.wikiEnabled = bool;
        this.whitelistStatus = str16;
        this.newModMailEnabled = bool2;
        this.submitType = str17;
        this.allowImages = bool3;
        this.allowVideos = bool4;
        this.spoilersEnabled = bool5;
        this.userIsModerator = bool6;
        this.userIsSubscriber = bool7;
        this.userHasFavorited = bool8;
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

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getDisplayNamePrefixed() {
        return this.displayNamePrefixed;
    }

    public final String getIconImg() {
        return this.iconImg;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final String getBannerImg() {
        return this.bannerImg;
    }

    public final String getHeaderImg() {
        return this.headerImg;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDescriptionHtml() {
        return this.descriptionHtml;
    }

    public final String getPublicDescription() {
        return this.publicDescription;
    }

    public final String getPublicDescriptionHtml() {
        return this.publicDescriptionHtml;
    }

    public final long getSubscribers() {
        return this.subscribers;
    }

    public /* synthetic */ Subreddit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j, Long l, long j2, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i;
        this(str, str2, str3, str4, str5, str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : str8, (i2 & 256) != 0 ? null : str9, (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? null : str10, (i2 & 1024) != 0 ? null : str11, str12, (i2 & 4096) != 0 ? null : str13, (i2 & 8192) != 0 ? 0 : j, (i2 & 16384) != 0 ? Long.valueOf(0) : l, (32768 & i2) != 0 ? System.currentTimeMillis() : j2, str14, str15, (262144 & i2) != 0 ? false : z, (524288 & i2) != 0 ? Boolean.valueOf(false) : bool, (1048576 & i2) != 0 ? null : str16, (2097152 & i2) != 0 ? Boolean.valueOf(false) : bool2, (4194304 & i2) != 0 ? null : str17, (8388608 & i2) != 0 ? Boolean.valueOf(false) : bool3, (16777216 & i2) != 0 ? Boolean.valueOf(false) : bool4, (33554432 & i2) != 0 ? Boolean.valueOf(false) : bool5, (67108864 & i2) != 0 ? Boolean.valueOf(false) : bool6, (MQEncoder.CARRY_MASK & i2) != 0 ? Boolean.valueOf(false) : bool7, (i2 & 268435456) != 0 ? Boolean.valueOf(false) : bool8);
    }

    public final Long getAccountsActive() {
        return this.accountsActive;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final String getSubredditType() {
        return this.subredditType;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public final Boolean getWikiEnabled() {
        return this.wikiEnabled;
    }

    public final String getWhitelistStatus() {
        return this.whitelistStatus;
    }

    public final Boolean getNewModMailEnabled() {
        return this.newModMailEnabled;
    }

    public final String getSubmitType() {
        return this.submitType;
    }

    public final Boolean getAllowImages() {
        return this.allowImages;
    }

    public final Boolean getAllowVideos() {
        return this.allowVideos;
    }

    public final Boolean getSpoilersEnabled() {
        return this.spoilersEnabled;
    }

    public final Boolean getUserIsModerator() {
        return this.userIsModerator;
    }

    public final void setUserIsModerator(Boolean bool) {
        this.userIsModerator = bool;
    }

    public final Boolean getUserIsSubscriber() {
        return this.userIsSubscriber;
    }

    public final void setUserIsSubscriber(Boolean bool) {
        this.userIsSubscriber = bool;
    }

    public final Boolean getUserHasFavorited() {
        return this.userHasFavorited;
    }

    public final void setUserHasFavorited(Boolean bool) {
        this.userHasFavorited = bool;
    }

    public final boolean isUser() {
        return Intrinsics.m26845a(this.subredditType, (Object) "user");
    }

    public final PostPermissions getPostPermissions() {
        boolean z;
        boolean a;
        boolean a2;
        boolean z2;
        boolean a3;
        boolean z3;
        boolean z4;
        Object obj = this.submitType;
        if (!Intrinsics.m26845a(obj, (Object) "link")) {
            if (!Intrinsics.m26845a(obj, (Object) "any")) {
                z = false;
                a = Intrinsics.m26845a(this.allowImages, Boolean.valueOf(true));
                a2 = Intrinsics.m26845a(this.allowVideos, Boolean.valueOf(true));
                if (!Intrinsics.m26845a(obj, (Object) "self")) {
                    if (Intrinsics.m26845a(obj, (Object) "any")) {
                        z2 = false;
                        a3 = Intrinsics.m26845a(this.spoilersEnabled, Boolean.valueOf(true));
                        z3 = z && a;
                        z4 = z && a2;
                        return new PostPermissions(z, z3, z4, z2, a3);
                    }
                }
                z2 = true;
                a3 = Intrinsics.m26845a(this.spoilersEnabled, Boolean.valueOf(true));
                if (!z) {
                }
                if (!z) {
                }
                return new PostPermissions(z, z3, z4, z2, a3);
            }
        }
        z = true;
        a = Intrinsics.m26845a(this.allowImages, Boolean.valueOf(true));
        a2 = Intrinsics.m26845a(this.allowVideos, Boolean.valueOf(true));
        if (Intrinsics.m26845a(obj, (Object) "self")) {
            if (Intrinsics.m26845a(obj, (Object) "any")) {
                z2 = false;
                a3 = Intrinsics.m26845a(this.spoilersEnabled, Boolean.valueOf(true));
                if (z) {
                }
                if (z) {
                }
                return new PostPermissions(z, z3, z4, z2, a3);
            }
        }
        z2 = true;
        a3 = Intrinsics.m26845a(this.spoilersEnabled, Boolean.valueOf(true));
        if (z) {
        }
        if (z) {
        }
        return new PostPermissions(z, z3, z4, z2, a3);
    }

    public final com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit toLegacyV1Subreddit() {
        String str = this.displayName;
        String str2 = this.displayNamePrefixed;
        String str3 = this.iconImg;
        String str4 = this.keyColor;
        String str5 = this.url;
        List a = CollectionsKt__CollectionsKt.m26790a();
        String str6 = this.publicDescriptionHtml;
        String str7 = this.headerImg;
        long j = this.subscribers;
        Long l = this.accountsActive;
        long longValue = l != null ? l.longValue() : 0;
        String str8 = r0.bannerImg;
        Boolean bool = r0.userIsSubscriber;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        bool = r0.userIsModerator;
        boolean booleanValue2 = bool != null ? bool.booleanValue() : false;
        String str9 = r0.description;
        String str10 = str8;
        str8 = r0.descriptionHtml;
        String str11 = str9;
        bool = r0.wikiEnabled;
        boolean booleanValue3 = bool != null ? bool.booleanValue() : false;
        boolean z = r0.over18;
        bool = r0.newModMailEnabled;
        BaseThing baseThing = r1;
        BaseThing subreddit = new com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit(str, str2, str3, str4, str5, a, str6, str7, j, longValue, str10, booleanValue, booleanValue2, str11, str8, booleanValue3, z, bool != null ? bool.booleanValue() : false, r0.whitelistStatus);
        BaseThing baseThing2 = baseThing;
        baseThing2.a(ThingUtil.b(r0.id));
        baseThing2.b(getKindWithId());
        baseThing2.createdUtc = r0.createdUtc;
        return baseThing2;
    }
}
