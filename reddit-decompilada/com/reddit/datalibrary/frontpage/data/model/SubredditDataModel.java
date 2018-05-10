package com.reddit.datalibrary.frontpage.data.model;

import com.google.android.gms.ads.AdRequest;
import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.codecs.common.biari.MQEncoder;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\by\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BÝ\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010#\u001a\u00020\u0003¢\u0006\u0002\u0010$J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0018HÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010}\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010+J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jè\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010#\u001a\u00020\u0003HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u0001\u001a\u00030\u0001HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00102\"\u0004\b>\u00104R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00102\"\u0004\b@\u00104R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00102\"\u0004\bB\u00104R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00102\"\u0004\bD\u00104R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00106\"\u0004\bF\u00108R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00102\"\u0004\bH\u00104R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00102\"\u0004\bJ\u00104R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bK\u0010+\"\u0004\bL\u0010-R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00102\"\u0004\bR\u00104R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00102\"\u0004\bT\u00104R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bU\u0010+\"\u0004\bV\u0010-R \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00102\"\u0004\bX\u00104R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00102\"\u0004\bZ\u00104R\u001e\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00102\"\u0004\b\\\u00104R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00106\"\u0004\b^\u00108R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00102\"\u0004\b`\u00104R\u001e\u0010#\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u00106\"\u0004\bb\u00108R\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00102\"\u0004\bd\u00104R\"\u0010\"\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\be\u0010+\"\u0004\bf\u0010-R\"\u0010!\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bg\u0010+\"\u0004\bh\u0010-R\"\u0010 \u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bi\u0010+\"\u0004\bj\u0010-R \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00102\"\u0004\bl\u00104R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bm\u0010+\"\u0004\bn\u0010-¨\u0006\u0001"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/SubredditDataModel;", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "id", "", "subredditId", "", "name", "displayName", "displayNamePrefixed", "iconImg", "keyColor", "bannerImg", "headerImg", "title", "description", "publicDescription", "descriptionHtml", "publicDescriptionHtml", "subscribers", "accountsActive", "createdUtc", "subredditType", "url", "over18", "", "wikiEnabled", "whitelistStatus", "newModMailEnabled", "submitType", "allowImages", "allowVideos", "spoilersEnabled", "userIsSubscriber", "userIsModerator", "userHasFavorited", "updatedTimestampUtc", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;J)V", "getAccountsActive", "()Ljava/lang/Long;", "setAccountsActive", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAllowImages", "()Ljava/lang/Boolean;", "setAllowImages", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAllowVideos", "setAllowVideos", "getBannerImg", "()Ljava/lang/String;", "setBannerImg", "(Ljava/lang/String;)V", "getCreatedUtc", "()J", "setCreatedUtc", "(J)V", "getDescription", "setDescription", "getDescriptionHtml", "setDescriptionHtml", "getDisplayName", "setDisplayName", "getDisplayNamePrefixed", "setDisplayNamePrefixed", "getHeaderImg", "setHeaderImg", "getIconImg", "setIconImg", "getId", "setId", "getKeyColor", "setKeyColor", "getName", "setName", "getNewModMailEnabled", "setNewModMailEnabled", "getOver18", "()Z", "setOver18", "(Z)V", "getPublicDescription", "setPublicDescription", "getPublicDescriptionHtml", "setPublicDescriptionHtml", "getSpoilersEnabled", "setSpoilersEnabled", "getSubmitType", "setSubmitType", "getSubredditId", "setSubredditId", "getSubredditType", "setSubredditType", "getSubscribers", "setSubscribers", "getTitle", "setTitle", "getUpdatedTimestampUtc", "setUpdatedTimestampUtc", "getUrl", "setUrl", "getUserHasFavorited", "setUserHasFavorited", "getUserIsModerator", "setUserIsModerator", "getUserIsSubscriber", "setUserIsSubscriber", "getWhitelistStatus", "setWhitelistStatus", "getWikiEnabled", "setWikiEnabled", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;J)Lcom/reddit/datalibrary/frontpage/data/model/SubredditDataModel;", "equals", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditDataModel.kt */
public final class SubredditDataModel extends BaseRXModel {
    private Long accountsActive;
    private Boolean allowImages;
    private Boolean allowVideos;
    private String bannerImg;
    private long createdUtc;
    private String description;
    private String descriptionHtml;
    private String displayName;
    private String displayNamePrefixed;
    private String headerImg;
    private String iconImg;
    private long id;
    private String keyColor;
    private String name;
    private Boolean newModMailEnabled;
    private boolean over18;
    private String publicDescription;
    private String publicDescriptionHtml;
    private Boolean spoilersEnabled;
    private String submitType;
    private String subredditId;
    private String subredditType;
    private long subscribers;
    private String title;
    private long updatedTimestampUtc;
    private String url;
    private Boolean userHasFavorited;
    private Boolean userIsModerator;
    private Boolean userIsSubscriber;
    private String whitelistStatus;
    private Boolean wikiEnabled;

    public SubredditDataModel() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, null, null, false, null, null, null, null, null, null, null, null, null, null, 0, RedditJobManager.f10810d, null);
    }

    public static /* synthetic */ SubredditDataModel copy$default(SubredditDataModel subredditDataModel, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j2, Long l, long j3, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, long j4, int i, Object obj) {
        String str18;
        long j5;
        SubredditDataModel subredditDataModel2 = subredditDataModel;
        int i2 = i;
        long j6 = (i2 & 1) != 0 ? subredditDataModel2.id : j;
        String str19 = (i2 & 2) != 0 ? subredditDataModel2.subredditId : str;
        String str20 = (i2 & 4) != 0 ? subredditDataModel2.name : str2;
        String str21 = (i2 & 8) != 0 ? subredditDataModel2.displayName : str3;
        String str22 = (i2 & 16) != 0 ? subredditDataModel2.displayNamePrefixed : str4;
        String str23 = (i2 & 32) != 0 ? subredditDataModel2.iconImg : str5;
        String str24 = (i2 & 64) != 0 ? subredditDataModel2.keyColor : str6;
        String str25 = (i2 & 128) != 0 ? subredditDataModel2.bannerImg : str7;
        String str26 = (i2 & 256) != 0 ? subredditDataModel2.headerImg : str8;
        String str27 = (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? subredditDataModel2.title : str9;
        String str28 = (i2 & 1024) != 0 ? subredditDataModel2.description : str10;
        String str29 = (i2 & MPEGConst.CODE_END) != 0 ? subredditDataModel2.publicDescription : str11;
        String str30 = (i2 & 4096) != 0 ? subredditDataModel2.descriptionHtml : str12;
        String str31 = (i2 & 8192) != 0 ? subredditDataModel2.publicDescriptionHtml : str13;
        if ((i2 & 16384) != 0) {
            str18 = str29;
            j5 = subredditDataModel2.subscribers;
        } else {
            str18 = str29;
            j5 = j2;
        }
        return subredditDataModel2.copy(j6, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str18, str30, str31, j5, (32768 & i2) != 0 ? subredditDataModel2.accountsActive : l, (65536 & i2) != 0 ? subredditDataModel2.createdUtc : j3, (131072 & i2) != 0 ? subredditDataModel2.subredditType : str14, (262144 & i2) != 0 ? subredditDataModel2.url : str15, (524288 & i2) != 0 ? subredditDataModel2.over18 : z, (1048576 & i2) != 0 ? subredditDataModel2.wikiEnabled : bool, (2097152 & i2) != 0 ? subredditDataModel2.whitelistStatus : str16, (4194304 & i2) != 0 ? subredditDataModel2.newModMailEnabled : bool2, (8388608 & i2) != 0 ? subredditDataModel2.submitType : str17, (16777216 & i2) != 0 ? subredditDataModel2.allowImages : bool3, (33554432 & i2) != 0 ? subredditDataModel2.allowVideos : bool4, (67108864 & i2) != 0 ? subredditDataModel2.spoilersEnabled : bool5, (MQEncoder.CARRY_MASK & i2) != 0 ? subredditDataModel2.userIsSubscriber : bool6, (268435456 & i2) != 0 ? subredditDataModel2.userIsModerator : bool7, (536870912 & i2) != 0 ? subredditDataModel2.userHasFavorited : bool8, (i2 & 1073741824) != 0 ? subredditDataModel2.updatedTimestampUtc : j4);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.title;
    }

    public final String component11() {
        return this.description;
    }

    public final String component12() {
        return this.publicDescription;
    }

    public final String component13() {
        return this.descriptionHtml;
    }

    public final String component14() {
        return this.publicDescriptionHtml;
    }

    public final long component15() {
        return this.subscribers;
    }

    public final Long component16() {
        return this.accountsActive;
    }

    public final long component17() {
        return this.createdUtc;
    }

    public final String component18() {
        return this.subredditType;
    }

    public final String component19() {
        return this.url;
    }

    public final String component2() {
        return this.subredditId;
    }

    public final boolean component20() {
        return this.over18;
    }

    public final Boolean component21() {
        return this.wikiEnabled;
    }

    public final String component22() {
        return this.whitelistStatus;
    }

    public final Boolean component23() {
        return this.newModMailEnabled;
    }

    public final String component24() {
        return this.submitType;
    }

    public final Boolean component25() {
        return this.allowImages;
    }

    public final Boolean component26() {
        return this.allowVideos;
    }

    public final Boolean component27() {
        return this.spoilersEnabled;
    }

    public final Boolean component28() {
        return this.userIsSubscriber;
    }

    public final Boolean component29() {
        return this.userIsModerator;
    }

    public final String component3() {
        return this.name;
    }

    public final Boolean component30() {
        return this.userHasFavorited;
    }

    public final long component31() {
        return this.updatedTimestampUtc;
    }

    public final String component4() {
        return this.displayName;
    }

    public final String component5() {
        return this.displayNamePrefixed;
    }

    public final String component6() {
        return this.iconImg;
    }

    public final String component7() {
        return this.keyColor;
    }

    public final String component8() {
        return this.bannerImg;
    }

    public final String component9() {
        return this.headerImg;
    }

    public final SubredditDataModel copy(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j2, Long l, long j3, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, long j4) {
        String str18 = str;
        Intrinsics.b(str18, "subredditId");
        String str19 = str2;
        Intrinsics.b(str19, "name");
        String str20 = str3;
        Intrinsics.b(str20, "displayName");
        String str21 = str4;
        Intrinsics.b(str21, "displayNamePrefixed");
        String str22 = str6;
        Intrinsics.b(str22, "keyColor");
        String str23 = str10;
        Intrinsics.b(str23, "description");
        String str24 = str11;
        Intrinsics.b(str24, "publicDescription");
        Intrinsics.b(str14, "subredditType");
        Intrinsics.b(str15, UpdateFragment.FRAGMENT_URL);
        return new SubredditDataModel(j, str18, str19, str20, str21, str5, str22, str7, str8, str9, str23, str24, str12, str13, j2, l, j3, str14, str15, z, bool, str16, bool2, str17, bool3, bool4, bool5, bool6, bool7, bool8, j4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubredditDataModel) {
            SubredditDataModel subredditDataModel = (SubredditDataModel) obj;
            if ((this.id == subredditDataModel.id) && Intrinsics.a(this.subredditId, subredditDataModel.subredditId) && Intrinsics.a(this.name, subredditDataModel.name) && Intrinsics.a(this.displayName, subredditDataModel.displayName) && Intrinsics.a(this.displayNamePrefixed, subredditDataModel.displayNamePrefixed) && Intrinsics.a(this.iconImg, subredditDataModel.iconImg) && Intrinsics.a(this.keyColor, subredditDataModel.keyColor) && Intrinsics.a(this.bannerImg, subredditDataModel.bannerImg) && Intrinsics.a(this.headerImg, subredditDataModel.headerImg) && Intrinsics.a(this.title, subredditDataModel.title) && Intrinsics.a(this.description, subredditDataModel.description) && Intrinsics.a(this.publicDescription, subredditDataModel.publicDescription) && Intrinsics.a(this.descriptionHtml, subredditDataModel.descriptionHtml) && Intrinsics.a(this.publicDescriptionHtml, subredditDataModel.publicDescriptionHtml)) {
                if ((this.subscribers == subredditDataModel.subscribers) && Intrinsics.a(this.accountsActive, subredditDataModel.accountsActive)) {
                    if ((this.createdUtc == subredditDataModel.createdUtc) && Intrinsics.a(this.subredditType, subredditDataModel.subredditType) && Intrinsics.a(this.url, subredditDataModel.url)) {
                        if ((this.over18 == subredditDataModel.over18) && Intrinsics.a(this.wikiEnabled, subredditDataModel.wikiEnabled) && Intrinsics.a(this.whitelistStatus, subredditDataModel.whitelistStatus) && Intrinsics.a(this.newModMailEnabled, subredditDataModel.newModMailEnabled) && Intrinsics.a(this.submitType, subredditDataModel.submitType) && Intrinsics.a(this.allowImages, subredditDataModel.allowImages) && Intrinsics.a(this.allowVideos, subredditDataModel.allowVideos) && Intrinsics.a(this.spoilersEnabled, subredditDataModel.spoilersEnabled) && Intrinsics.a(this.userIsSubscriber, subredditDataModel.userIsSubscriber) && Intrinsics.a(this.userIsModerator, subredditDataModel.userIsModerator) && Intrinsics.a(this.userHasFavorited, subredditDataModel.userHasFavorited)) {
                            if (this.updatedTimestampUtc == subredditDataModel.updatedTimestampUtc) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.subredditId;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.name;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.displayName;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.displayNamePrefixed;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.iconImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.keyColor;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.bannerImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.headerImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.title;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.publicDescription;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.descriptionHtml;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.publicDescriptionHtml;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        long j2 = this.subscribers;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Long l = this.accountsActive;
        i = (i + (l != null ? l.hashCode() : 0)) * 31;
        j2 = this.createdUtc;
        i = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        str = this.subredditType;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.url;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i3 = this.over18;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        Boolean bool = this.wikiEnabled;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.whitelistStatus;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.newModMailEnabled;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.submitType;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.allowImages;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.allowVideos;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.spoilersEnabled;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.userIsSubscriber;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.userIsModerator;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.userHasFavorited;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        i = (i + i2) * 31;
        long j3 = this.updatedTimestampUtc;
        return i + ((int) ((j3 >>> 32) ^ j3));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubredditDataModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
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
        stringBuilder.append(", publicDescription=");
        stringBuilder.append(this.publicDescription);
        stringBuilder.append(", descriptionHtml=");
        stringBuilder.append(this.descriptionHtml);
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
        stringBuilder.append(", userIsSubscriber=");
        stringBuilder.append(this.userIsSubscriber);
        stringBuilder.append(", userIsModerator=");
        stringBuilder.append(this.userIsModerator);
        stringBuilder.append(", userHasFavorited=");
        stringBuilder.append(this.userHasFavorited);
        stringBuilder.append(", updatedTimestampUtc=");
        stringBuilder.append(this.updatedTimestampUtc);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getSubredditId() {
        return this.subredditId;
    }

    public final void setSubredditId(String str) {
        Intrinsics.b(str, "<set-?>");
        this.subredditId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.name = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.displayName = str;
    }

    public final String getDisplayNamePrefixed() {
        return this.displayNamePrefixed;
    }

    public final void setDisplayNamePrefixed(String str) {
        Intrinsics.b(str, "<set-?>");
        this.displayNamePrefixed = str;
    }

    public final String getIconImg() {
        return this.iconImg;
    }

    public final void setIconImg(String str) {
        this.iconImg = str;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final void setKeyColor(String str) {
        Intrinsics.b(str, "<set-?>");
        this.keyColor = str;
    }

    public final String getBannerImg() {
        return this.bannerImg;
    }

    public final void setBannerImg(String str) {
        this.bannerImg = str;
    }

    public final String getHeaderImg() {
        return this.headerImg;
    }

    public final void setHeaderImg(String str) {
        this.headerImg = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.b(str, "<set-?>");
        this.description = str;
    }

    public final String getPublicDescription() {
        return this.publicDescription;
    }

    public final void setPublicDescription(String str) {
        Intrinsics.b(str, "<set-?>");
        this.publicDescription = str;
    }

    public final String getDescriptionHtml() {
        return this.descriptionHtml;
    }

    public final void setDescriptionHtml(String str) {
        this.descriptionHtml = str;
    }

    public final String getPublicDescriptionHtml() {
        return this.publicDescriptionHtml;
    }

    public final void setPublicDescriptionHtml(String str) {
        this.publicDescriptionHtml = str;
    }

    public final long getSubscribers() {
        return this.subscribers;
    }

    public final void setSubscribers(long j) {
        this.subscribers = j;
    }

    public /* synthetic */ SubredditDataModel(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j2, Long l, long j3, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i;
        this((i2 & 1) != 0 ? 0 : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? null : str9, (i2 & 1024) != 0 ? "" : str10, (i2 & MPEGConst.CODE_END) != 0 ? "" : str11, (i2 & 4096) != 0 ? null : str12, (i2 & 8192) != 0 ? null : str13, (i2 & 16384) != 0 ? 0 : j2, (32768 & i2) != 0 ? Long.valueOf(0) : l, (65536 & i2) != 0 ? System.currentTimeMillis() : j3, (131072 & i2) != 0 ? "" : str14, (262144 & i2) != 0 ? "" : str15, (524288 & i2) != 0 ? false : z, (1048576 & i2) != 0 ? Boolean.valueOf(false) : bool, (2097152 & i2) != 0 ? null : str16, (4194304 & i2) != 0 ? Boolean.valueOf(false) : bool2, (8388608 & i2) != 0 ? null : str17, (16777216 & i2) != 0 ? Boolean.valueOf(false) : bool3, (33554432 & i2) != 0 ? Boolean.valueOf(false) : bool4, (67108864 & i2) != 0 ? Boolean.valueOf(false) : bool5, (MQEncoder.CARRY_MASK & i2) != 0 ? Boolean.valueOf(false) : bool6, (268435456 & i2) != 0 ? Boolean.valueOf(false) : bool7, (536870912 & i2) != 0 ? Boolean.valueOf(false) : bool8, (i2 & 1073741824) != 0 ? System.currentTimeMillis() : j4);
    }

    public final Long getAccountsActive() {
        return this.accountsActive;
    }

    public final void setAccountsActive(Long l) {
        this.accountsActive = l;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final void setCreatedUtc(long j) {
        this.createdUtc = j;
    }

    public final String getSubredditType() {
        return this.subredditType;
    }

    public final void setSubredditType(String str) {
        Intrinsics.b(str, "<set-?>");
        this.subredditType = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.b(str, "<set-?>");
        this.url = str;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public final void setOver18(boolean z) {
        this.over18 = z;
    }

    public final Boolean getWikiEnabled() {
        return this.wikiEnabled;
    }

    public final void setWikiEnabled(Boolean bool) {
        this.wikiEnabled = bool;
    }

    public final String getWhitelistStatus() {
        return this.whitelistStatus;
    }

    public final void setWhitelistStatus(String str) {
        this.whitelistStatus = str;
    }

    public final Boolean getNewModMailEnabled() {
        return this.newModMailEnabled;
    }

    public final void setNewModMailEnabled(Boolean bool) {
        this.newModMailEnabled = bool;
    }

    public final String getSubmitType() {
        return this.submitType;
    }

    public final void setSubmitType(String str) {
        this.submitType = str;
    }

    public final Boolean getAllowImages() {
        return this.allowImages;
    }

    public final void setAllowImages(Boolean bool) {
        this.allowImages = bool;
    }

    public final Boolean getAllowVideos() {
        return this.allowVideos;
    }

    public final void setAllowVideos(Boolean bool) {
        this.allowVideos = bool;
    }

    public final Boolean getSpoilersEnabled() {
        return this.spoilersEnabled;
    }

    public final void setSpoilersEnabled(Boolean bool) {
        this.spoilersEnabled = bool;
    }

    public final Boolean getUserIsSubscriber() {
        return this.userIsSubscriber;
    }

    public final void setUserIsSubscriber(Boolean bool) {
        this.userIsSubscriber = bool;
    }

    public final Boolean getUserIsModerator() {
        return this.userIsModerator;
    }

    public final void setUserIsModerator(Boolean bool) {
        this.userIsModerator = bool;
    }

    public final Boolean getUserHasFavorited() {
        return this.userHasFavorited;
    }

    public final void setUserHasFavorited(Boolean bool) {
        this.userHasFavorited = bool;
    }

    public final long getUpdatedTimestampUtc() {
        return this.updatedTimestampUtc;
    }

    public final void setUpdatedTimestampUtc(long j) {
        this.updatedTimestampUtc = j;
    }

    public SubredditDataModel(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, long j2, Long l, long j3, String str14, String str15, boolean z, Boolean bool, String str16, Boolean bool2, String str17, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, long j4) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str4;
        String str22 = str6;
        String str23 = str10;
        String str24 = str11;
        String str25 = str14;
        String str26 = str15;
        Intrinsics.b(str18, "subredditId");
        Intrinsics.b(str19, "name");
        Intrinsics.b(str20, "displayName");
        Intrinsics.b(str21, "displayNamePrefixed");
        Intrinsics.b(str22, "keyColor");
        Intrinsics.b(str23, "description");
        Intrinsics.b(str24, "publicDescription");
        Intrinsics.b(str25, "subredditType");
        Intrinsics.b(str26, UpdateFragment.FRAGMENT_URL);
        this.id = j;
        this.subredditId = str18;
        this.name = str19;
        this.displayName = str20;
        this.displayNamePrefixed = str21;
        this.iconImg = str5;
        this.keyColor = str22;
        this.bannerImg = str7;
        this.headerImg = str8;
        this.title = str9;
        this.description = str23;
        this.publicDescription = str24;
        this.descriptionHtml = str12;
        this.publicDescriptionHtml = str13;
        this.subscribers = j2;
        this.accountsActive = l;
        this.createdUtc = j3;
        this.subredditType = str25;
        this.url = str26;
        this.over18 = z;
        this.wikiEnabled = bool;
        this.whitelistStatus = str16;
        this.newModMailEnabled = bool2;
        this.submitType = str17;
        this.allowImages = bool3;
        this.allowVideos = bool4;
        this.spoilersEnabled = bool5;
        this.userIsSubscriber = bool6;
        this.userIsModerator = bool7;
        this.userHasFavorited = bool8;
        this.updatedTimestampUtc = j4;
    }
}
