package com.reddit.datalibrary.frontpage.data.model;

import com.google.android.gms.ads.AdRequest;
import com.raizlabs.android.dbflow.rx2.structure.BaseRXModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jcodec.codecs.mpeg12.MPEGConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b`\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b¢\u0006\u0002\u0010\u001eJ\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010JJ\t\u0010Z\u001a\u00020\bHÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0013HÆ\u0003J\t\u0010^\u001a\u00020\bHÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\bHÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010JJ\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010JJ\t\u0010h\u001a\u00020\bHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010JJ\t\u0010k\u001a\u00020\u0005HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010JJ\t\u0010m\u001a\u00020\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\u0002\u0010p\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001d\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010qJ\u0013\u0010r\u001a\u00020\b2\b\u0010s\u001a\u0004\u0018\u00010tHÖ\u0003J\t\u0010u\u001a\u00020\u0013HÖ\u0001J\t\u0010v\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u00101\"\u0004\b2\u00103R\u001e\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00101\"\u0004\b4\u00103R\u001e\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001e\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00101\"\u0004\b:\u00103R\u001e\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001e\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00101\"\u0004\b>\u00103R\u001e\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\u001e\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\"\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bP\u0010J\"\u0004\bQ\u0010LR\"\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bR\u0010J\"\u0004\bS\u0010LR\"\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bT\u0010J\"\u0004\bU\u0010LR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010 \"\u0004\bW\u0010\"¨\u0006w"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/UserSubredditDataModel;", "Lcom/raizlabs/android/dbflow/rx2/structure/BaseRXModel;", "id", "", "username", "", "bannerImg", "userIsBanned", "", "description", "userIsMuted", "displayName", "headerImg", "title", "userIsModerator", "over18", "iconImg", "displayNamePrefixed", "subscribers", "", "isDefaultIcon", "keyColor", "name", "isDefaultBanner", "url", "userIsContributor", "publicDescription", "subredditType", "userIsSubscriber", "showInDefaultSubreddits", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "getBannerImg", "()Ljava/lang/String;", "setBannerImg", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getDisplayName", "setDisplayName", "getDisplayNamePrefixed", "setDisplayNamePrefixed", "getHeaderImg", "setHeaderImg", "getIconImg", "setIconImg", "getId", "()J", "setId", "(J)V", "()Z", "setDefaultBanner", "(Z)V", "setDefaultIcon", "getKeyColor", "setKeyColor", "getName", "setName", "getOver18", "setOver18", "getPublicDescription", "setPublicDescription", "getShowInDefaultSubreddits", "setShowInDefaultSubreddits", "getSubredditType", "setSubredditType", "getSubscribers", "()I", "setSubscribers", "(I)V", "getTitle", "setTitle", "getUrl", "setUrl", "getUserIsBanned", "()Ljava/lang/Boolean;", "setUserIsBanned", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUserIsContributor", "setUserIsContributor", "getUserIsModerator", "setUserIsModerator", "getUserIsMuted", "setUserIsMuted", "getUserIsSubscriber", "setUserIsSubscriber", "getUsername", "setUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)Lcom/reddit/datalibrary/frontpage/data/model/UserSubredditDataModel;", "equals", "other", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubredditDataModel.kt */
public final class UserSubredditDataModel extends BaseRXModel {
    private String bannerImg;
    private String description;
    private String displayName;
    private String displayNamePrefixed;
    private String headerImg;
    private String iconImg;
    private long id;
    private boolean isDefaultBanner;
    private boolean isDefaultIcon;
    private String keyColor;
    private String name;
    private boolean over18;
    private String publicDescription;
    private boolean showInDefaultSubreddits;
    private String subredditType;
    private int subscribers;
    private String title;
    private String url;
    private Boolean userIsBanned;
    private Boolean userIsContributor;
    private Boolean userIsModerator;
    private Boolean userIsMuted;
    private Boolean userIsSubscriber;
    private String username;

    public UserSubredditDataModel() {
        this(0, null, null, null, null, null, null, null, null, null, false, null, null, 0, false, null, null, false, null, null, null, null, null, false, 16777215, null);
    }

    public static /* synthetic */ UserSubredditDataModel copy$default(UserSubredditDataModel userSubredditDataModel, long j, String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, String str10, boolean z3, String str11, Boolean bool4, String str12, String str13, Boolean bool5, boolean z4, int i2, Object obj) {
        UserSubredditDataModel userSubredditDataModel2 = userSubredditDataModel;
        int i3 = i2;
        return userSubredditDataModel2.copy((i3 & 1) != 0 ? userSubredditDataModel2.id : j, (i3 & 2) != 0 ? userSubredditDataModel2.username : str, (i3 & 4) != 0 ? userSubredditDataModel2.bannerImg : str2, (i3 & 8) != 0 ? userSubredditDataModel2.userIsBanned : bool, (i3 & 16) != 0 ? userSubredditDataModel2.description : str3, (i3 & 32) != 0 ? userSubredditDataModel2.userIsMuted : bool2, (i3 & 64) != 0 ? userSubredditDataModel2.displayName : str4, (i3 & 128) != 0 ? userSubredditDataModel2.headerImg : str5, (i3 & 256) != 0 ? userSubredditDataModel2.title : str6, (i3 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? userSubredditDataModel2.userIsModerator : bool3, (i3 & 1024) != 0 ? userSubredditDataModel2.over18 : z, (i3 & MPEGConst.CODE_END) != 0 ? userSubredditDataModel2.iconImg : str7, (i3 & 4096) != 0 ? userSubredditDataModel2.displayNamePrefixed : str8, (i3 & 8192) != 0 ? userSubredditDataModel2.subscribers : i, (i3 & 16384) != 0 ? userSubredditDataModel2.isDefaultIcon : z2, (32768 & i3) != 0 ? userSubredditDataModel2.keyColor : str9, (65536 & i3) != 0 ? userSubredditDataModel2.name : str10, (131072 & i3) != 0 ? userSubredditDataModel2.isDefaultBanner : z3, (262144 & i3) != 0 ? userSubredditDataModel2.url : str11, (524288 & i3) != 0 ? userSubredditDataModel2.userIsContributor : bool4, (1048576 & i3) != 0 ? userSubredditDataModel2.publicDescription : str12, (2097152 & i3) != 0 ? userSubredditDataModel2.subredditType : str13, (4194304 & i3) != 0 ? userSubredditDataModel2.userIsSubscriber : bool5, (i3 & 8388608) != 0 ? userSubredditDataModel2.showInDefaultSubreddits : z4);
    }

    public final long component1() {
        return this.id;
    }

    public final Boolean component10() {
        return this.userIsModerator;
    }

    public final boolean component11() {
        return this.over18;
    }

    public final String component12() {
        return this.iconImg;
    }

    public final String component13() {
        return this.displayNamePrefixed;
    }

    public final int component14() {
        return this.subscribers;
    }

    public final boolean component15() {
        return this.isDefaultIcon;
    }

    public final String component16() {
        return this.keyColor;
    }

    public final String component17() {
        return this.name;
    }

    public final boolean component18() {
        return this.isDefaultBanner;
    }

    public final String component19() {
        return this.url;
    }

    public final String component2() {
        return this.username;
    }

    public final Boolean component20() {
        return this.userIsContributor;
    }

    public final String component21() {
        return this.publicDescription;
    }

    public final String component22() {
        return this.subredditType;
    }

    public final Boolean component23() {
        return this.userIsSubscriber;
    }

    public final boolean component24() {
        return this.showInDefaultSubreddits;
    }

    public final String component3() {
        return this.bannerImg;
    }

    public final Boolean component4() {
        return this.userIsBanned;
    }

    public final String component5() {
        return this.description;
    }

    public final Boolean component6() {
        return this.userIsMuted;
    }

    public final String component7() {
        return this.displayName;
    }

    public final String component8() {
        return this.headerImg;
    }

    public final String component9() {
        return this.title;
    }

    public final UserSubredditDataModel copy(long j, String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, String str10, boolean z3, String str11, Boolean bool4, String str12, String str13, Boolean bool5, boolean z4) {
        String str14 = str;
        Intrinsics.b(str14, "username");
        String str15 = str3;
        Intrinsics.b(str15, "description");
        String str16 = str4;
        Intrinsics.b(str16, "displayName");
        String str17 = str6;
        Intrinsics.b(str17, "title");
        String str18 = str7;
        Intrinsics.b(str18, "iconImg");
        String str19 = str8;
        Intrinsics.b(str19, "displayNamePrefixed");
        Intrinsics.b(str9, "keyColor");
        Intrinsics.b(str10, "name");
        Intrinsics.b(str11, UpdateFragment.FRAGMENT_URL);
        Intrinsics.b(str12, "publicDescription");
        Intrinsics.b(str13, "subredditType");
        return new UserSubredditDataModel(j, str14, str2, bool, str15, bool2, str16, str5, str17, bool3, z, str18, str19, i, z2, str9, str10, z3, str11, bool4, str12, str13, bool5, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserSubredditDataModel) {
            UserSubredditDataModel userSubredditDataModel = (UserSubredditDataModel) obj;
            if ((this.id == userSubredditDataModel.id) && Intrinsics.a(this.username, userSubredditDataModel.username) && Intrinsics.a(this.bannerImg, userSubredditDataModel.bannerImg) && Intrinsics.a(this.userIsBanned, userSubredditDataModel.userIsBanned) && Intrinsics.a(this.description, userSubredditDataModel.description) && Intrinsics.a(this.userIsMuted, userSubredditDataModel.userIsMuted) && Intrinsics.a(this.displayName, userSubredditDataModel.displayName) && Intrinsics.a(this.headerImg, userSubredditDataModel.headerImg) && Intrinsics.a(this.title, userSubredditDataModel.title) && Intrinsics.a(this.userIsModerator, userSubredditDataModel.userIsModerator)) {
                if ((this.over18 == userSubredditDataModel.over18) && Intrinsics.a(this.iconImg, userSubredditDataModel.iconImg) && Intrinsics.a(this.displayNamePrefixed, userSubredditDataModel.displayNamePrefixed)) {
                    if (this.subscribers == userSubredditDataModel.subscribers) {
                        if ((this.isDefaultIcon == userSubredditDataModel.isDefaultIcon) && Intrinsics.a(this.keyColor, userSubredditDataModel.keyColor) && Intrinsics.a(this.name, userSubredditDataModel.name)) {
                            if ((this.isDefaultBanner == userSubredditDataModel.isDefaultBanner) && Intrinsics.a(this.url, userSubredditDataModel.url) && Intrinsics.a(this.userIsContributor, userSubredditDataModel.userIsContributor) && Intrinsics.a(this.publicDescription, userSubredditDataModel.publicDescription) && Intrinsics.a(this.subredditType, userSubredditDataModel.subredditType) && Intrinsics.a(this.userIsSubscriber, userSubredditDataModel.userIsSubscriber)) {
                                if (this.showInDefaultSubreddits == userSubredditDataModel.showInDefaultSubreddits) {
                                    return true;
                                }
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
        String str = this.username;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.bannerImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.userIsBanned;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.description;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsMuted;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.displayName;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.headerImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.title;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsModerator;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        int i3 = this.over18;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.iconImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.displayNamePrefixed;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.subscribers) * 31;
        i3 = this.isDefaultIcon;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.keyColor;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.name;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        i3 = this.isDefaultBanner;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.url;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsContributor;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        str = this.publicDescription;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.subredditType;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        bool = this.userIsSubscriber;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        i = (i + i2) * 31;
        i3 = this.showInDefaultSubreddits;
        if (i3 != 0) {
            i3 = 1;
        }
        return i + i3;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserSubredditDataModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", username=");
        stringBuilder.append(this.username);
        stringBuilder.append(", bannerImg=");
        stringBuilder.append(this.bannerImg);
        stringBuilder.append(", userIsBanned=");
        stringBuilder.append(this.userIsBanned);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", userIsMuted=");
        stringBuilder.append(this.userIsMuted);
        stringBuilder.append(", displayName=");
        stringBuilder.append(this.displayName);
        stringBuilder.append(", headerImg=");
        stringBuilder.append(this.headerImg);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", userIsModerator=");
        stringBuilder.append(this.userIsModerator);
        stringBuilder.append(", over18=");
        stringBuilder.append(this.over18);
        stringBuilder.append(", iconImg=");
        stringBuilder.append(this.iconImg);
        stringBuilder.append(", displayNamePrefixed=");
        stringBuilder.append(this.displayNamePrefixed);
        stringBuilder.append(", subscribers=");
        stringBuilder.append(this.subscribers);
        stringBuilder.append(", isDefaultIcon=");
        stringBuilder.append(this.isDefaultIcon);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", isDefaultBanner=");
        stringBuilder.append(this.isDefaultBanner);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", userIsContributor=");
        stringBuilder.append(this.userIsContributor);
        stringBuilder.append(", publicDescription=");
        stringBuilder.append(this.publicDescription);
        stringBuilder.append(", subredditType=");
        stringBuilder.append(this.subredditType);
        stringBuilder.append(", userIsSubscriber=");
        stringBuilder.append(this.userIsSubscriber);
        stringBuilder.append(", showInDefaultSubreddits=");
        stringBuilder.append(this.showInDefaultSubreddits);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        Intrinsics.b(str, "<set-?>");
        this.username = str;
    }

    public final String getBannerImg() {
        return this.bannerImg;
    }

    public final void setBannerImg(String str) {
        this.bannerImg = str;
    }

    public /* synthetic */ UserSubredditDataModel(long j, String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, String str10, boolean z3, String str11, Boolean bool4, String str12, String str13, Boolean bool5, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i3 = i2;
        this((i3 & 1) != 0 ? 0 : j, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? Boolean.valueOf(false) : bool, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? Boolean.valueOf(false) : bool2, (i3 & 64) != 0 ? "" : str4, (i3 & 128) != 0 ? null : str5, (i3 & 256) != 0 ? "" : str6, (i3 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? Boolean.valueOf(true) : bool3, (i3 & 1024) != 0 ? false : z, (i3 & MPEGConst.CODE_END) != 0 ? "" : str7, (i3 & 4096) != 0 ? "" : str8, (i3 & 8192) != 0 ? 0 : i, (i3 & 16384) != 0 ? false : z2, (32768 & i3) != 0 ? "" : str9, (65536 & i3) != 0 ? "" : str10, (131072 & i3) != 0 ? false : z3, (262144 & i3) != 0 ? "" : str11, (524288 & i3) != 0 ? Boolean.valueOf(false) : bool4, (1048576 & i3) != 0 ? "" : str12, (2097152 & i3) != 0 ? "" : str13, (4194304 & i3) != 0 ? Boolean.valueOf(false) : bool5, (i3 & 8388608) != 0 ? false : z4);
    }

    public final Boolean getUserIsBanned() {
        return this.userIsBanned;
    }

    public final void setUserIsBanned(Boolean bool) {
        this.userIsBanned = bool;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.b(str, "<set-?>");
        this.description = str;
    }

    public final Boolean getUserIsMuted() {
        return this.userIsMuted;
    }

    public final void setUserIsMuted(Boolean bool) {
        this.userIsMuted = bool;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.displayName = str;
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
        Intrinsics.b(str, "<set-?>");
        this.title = str;
    }

    public final Boolean getUserIsModerator() {
        return this.userIsModerator;
    }

    public final void setUserIsModerator(Boolean bool) {
        this.userIsModerator = bool;
    }

    public final boolean getOver18() {
        return this.over18;
    }

    public final void setOver18(boolean z) {
        this.over18 = z;
    }

    public final String getIconImg() {
        return this.iconImg;
    }

    public final void setIconImg(String str) {
        Intrinsics.b(str, "<set-?>");
        this.iconImg = str;
    }

    public final String getDisplayNamePrefixed() {
        return this.displayNamePrefixed;
    }

    public final void setDisplayNamePrefixed(String str) {
        Intrinsics.b(str, "<set-?>");
        this.displayNamePrefixed = str;
    }

    public final int getSubscribers() {
        return this.subscribers;
    }

    public final void setSubscribers(int i) {
        this.subscribers = i;
    }

    public final boolean isDefaultIcon() {
        return this.isDefaultIcon;
    }

    public final void setDefaultIcon(boolean z) {
        this.isDefaultIcon = z;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }

    public final void setKeyColor(String str) {
        Intrinsics.b(str, "<set-?>");
        this.keyColor = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.b(str, "<set-?>");
        this.name = str;
    }

    public final boolean isDefaultBanner() {
        return this.isDefaultBanner;
    }

    public final void setDefaultBanner(boolean z) {
        this.isDefaultBanner = z;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.b(str, "<set-?>");
        this.url = str;
    }

    public final Boolean getUserIsContributor() {
        return this.userIsContributor;
    }

    public final void setUserIsContributor(Boolean bool) {
        this.userIsContributor = bool;
    }

    public final String getPublicDescription() {
        return this.publicDescription;
    }

    public final void setPublicDescription(String str) {
        Intrinsics.b(str, "<set-?>");
        this.publicDescription = str;
    }

    public final String getSubredditType() {
        return this.subredditType;
    }

    public final void setSubredditType(String str) {
        Intrinsics.b(str, "<set-?>");
        this.subredditType = str;
    }

    public final Boolean getUserIsSubscriber() {
        return this.userIsSubscriber;
    }

    public final void setUserIsSubscriber(Boolean bool) {
        this.userIsSubscriber = bool;
    }

    public final boolean getShowInDefaultSubreddits() {
        return this.showInDefaultSubreddits;
    }

    public final void setShowInDefaultSubreddits(boolean z) {
        this.showInDefaultSubreddits = z;
    }

    public UserSubredditDataModel(long j, String str, String str2, Boolean bool, String str3, Boolean bool2, String str4, String str5, String str6, Boolean bool3, boolean z, String str7, String str8, int i, boolean z2, String str9, String str10, boolean z3, String str11, Boolean bool4, String str12, String str13, Boolean bool5, boolean z4) {
        String str14 = str;
        String str15 = str3;
        String str16 = str4;
        String str17 = str6;
        String str18 = str7;
        String str19 = str8;
        String str20 = str9;
        String str21 = str10;
        String str22 = str11;
        String str23 = str12;
        String str24 = str13;
        Intrinsics.b(str14, "username");
        Intrinsics.b(str15, "description");
        Intrinsics.b(str16, "displayName");
        Intrinsics.b(str17, "title");
        Intrinsics.b(str18, "iconImg");
        Intrinsics.b(str19, "displayNamePrefixed");
        Intrinsics.b(str20, "keyColor");
        Intrinsics.b(str21, "name");
        Intrinsics.b(str22, UpdateFragment.FRAGMENT_URL);
        Intrinsics.b(str23, "publicDescription");
        Intrinsics.b(str24, "subredditType");
        this.id = j;
        this.username = str14;
        this.bannerImg = str2;
        this.userIsBanned = bool;
        this.description = str15;
        this.userIsMuted = bool2;
        this.displayName = str16;
        this.headerImg = str5;
        this.title = str17;
        this.userIsModerator = bool3;
        this.over18 = z;
        this.iconImg = str18;
        this.displayNamePrefixed = str19;
        this.subscribers = i;
        this.isDefaultIcon = z2;
        this.keyColor = str20;
        this.name = str21;
        this.isDefaultBanner = z3;
        this.url = str22;
        this.userIsContributor = bool4;
        this.publicDescription = str23;
        this.subredditType = str24;
        this.userIsSubscriber = bool5;
        this.showInDefaultSubreddits = z4;
    }
}
