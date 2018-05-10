package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.AdRequest;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.ui.carousel.CarouselItemLayout;
import com.reddit.frontpage.ui.carousel.SubheaderIcon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jcodec.codecs.mpeg12.MPEGConst;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\b\b\u0018\u0000 ~2\u00020\u0001:\u0004~\u0001Bá\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\t\u0010`\u001a\u00020\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010c\u001a\u00020\u0012HÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\t\u0010e\u001a\u00020\u0016HÆ\u0003J\u0017\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010h\u001a\u00020\nHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010n\u001a\u00020\bHÆ\u0003J\t\u0010o\u001a\u00020\nHÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\nHÆ\u0003J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010s\u001a\u00020t2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002Jå\u0001\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001J\u0013\u0010v\u001a\u00020\b2\b\u0010w\u001a\u0004\u0018\u00010xHÖ\u0003J\t\u0010y\u001a\u00020\nHÖ\u0001J\u0006\u0010z\u001a\u00020\bJ\u0006\u0010{\u001a\u00020\bJ\u0006\u0010|\u001a\u00020\bJ\t\u0010}\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010(\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b)\u0010$R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b,\u0010$R\u0014\u0010-\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010$R\u0014\u0010.\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0014\u00103\u001a\u0002048BX\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001f\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b>\u0010$R\u0011\u0010?\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b@\u0010$R\u0011\u0010A\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bB\u0010$R\u0011\u0010C\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bD\u0010$R\u0011\u0010E\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bF\u0010$R\u0013\u0010G\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0011\u0010J\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bK\u0010$R\u0011\u0010L\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bM\u0010$R\u0011\u0010N\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bO\u0010$R\u0011\u0010P\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bQ\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010 R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010 R\u0011\u0010\u001a\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010+R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u0010 R\u0011\u0010^\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b_\u0010$¨\u0006\u0001"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "Lpaperparcel/PaperParcelable;", "unique_id", "", "unit_type", "surface", "url", "enabled_for_minimum_app_version", "", "min_app_version", "", "min_app_version_name", "index", "title", "subtitle", "subtitle_icon", "Lcom/reddit/frontpage/ui/carousel/SubheaderIcon;", "layout", "Lcom/reddit/frontpage/ui/carousel/CarouselItemLayout;", "options", "", "orderBy", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderBy;", "parameters", "", "custom_hide_key", "versionCode", "versionName", "surface_parameters", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$SurfaceParameters;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/ui/carousel/SubheaderIcon;Lcom/reddit/frontpage/ui/carousel/CarouselItemLayout;Ljava/util/List;Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderBy;Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$SurfaceParameters;)V", "getCustom_hide_key", "()Ljava/lang/String;", "value", "enabled", "getEnabled", "()Z", "setEnabled", "(Z)V", "getEnabled_for_minimum_app_version", "hasFixedIndex", "getHasFixedIndex", "getIndex", "()I", "isFavoriteSubreddits", "isPassesMinAppRequirement", "isRecentSubreddits", "getLayout", "()Lcom/reddit/frontpage/ui/carousel/CarouselItemLayout;", "getMin_app_version", "getMin_app_version_name", "modelType", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$ModelType;", "getModelType", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$ModelType;", "getOptions", "()Ljava/util/List;", "getOrderBy", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/OrderBy;", "getParameters", "()Ljava/util/Map;", "shouldRemoveDismissals", "getShouldRemoveDismissals", "showActionButton", "getShowActionButton", "showDescription", "getShowDescription", "showHideItemsOption", "getShowHideItemsOption", "showLessItemsOption", "getShowLessItemsOption", "showOnSurfaceIfSubscribed", "getShowOnSurfaceIfSubscribed", "()Ljava/lang/Boolean;", "showPostSubredditHeader", "getShowPostSubredditHeader", "showSeeMoreOption", "getShowSeeMoreOption", "showTitle", "getShowTitle", "showUnitSubredditHeader", "getShowUnitSubredditHeader", "getSubtitle", "getSubtitle_icon", "()Lcom/reddit/frontpage/ui/carousel/SubheaderIcon;", "getSurface", "getSurface_parameters", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$SurfaceParameters;", "getTitle", "getUnique_id", "getUnit_type", "getUrl", "getVersionCode", "getVersionName", "wideOption", "getWideOption", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "convertVersionNameToValue", "", "copy", "equals", "other", "", "hashCode", "isLinkListing", "isSubredditListing", "isUnknown", "toString", "Companion", "ModelType", "SurfaceParameters", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: DiscoveryUnit.kt */
public final class DiscoveryUnit implements PaperParcelable {
    public static final Creator<DiscoveryUnit> CREATOR = PaperParcelDiscoveryUnit.CREATOR;
    public static final Companion Companion = new Companion();
    public static final int DEFAULT_INDEX = -1;
    private static final String DEFAULT_VERSION_NAME_COLUMN_VALUE = "0";
    public static final int HIDE_CAROUSEL_DURATION_DAYS = 30;
    private static final String MAX_VERSION_NAME = "99.99.99";
    private static final int MAX_VERSION_NAME_COLUMNS = 3;
    private static final long MAX_VERSION_NAME_VALUE = Long.MAX_VALUE;
    private static final String OPTION_ACTION_BUTTON = "action_button";
    private static final String OPTION_DESCRIPTION = "description";
    private static final String OPTION_DONT_FILTER_DISMISSALS = "dont_filter_dismissals";
    private static final String OPTION_HIDE_ITEMS = "hide_items";
    private static final String OPTION_HIDE_TITLE = "hide_title";
    private static final String OPTION_SEE_MORE = "see_more";
    private static final String OPTION_SHOW_LESS = "show_less";
    private static final String OPTION_SHOW_POST_SUBREDDIT_HEADER = "post_show_subreddit_header";
    private static final String OPTION_SHOW_SUBREDDIT_HEADER = "unit_show_subreddit_header";
    private static final String OPTION_SHOW_UNIT_SUBREDDIT_HEADER = "unit_show_subreddit_header";
    private static final String OPTION_WIDE = "wide";
    public static final String TEMPLATE_FIRST_ITEM_CAUSE = "first_item.cause";
    public static final String TEMPLATE_FIRST_ITEM_SUBREDDIT_KEY = "first_item.subreddit.id";
    public static final String TEMPLATE_FIRST_ITEM_SUBREDDIT_VISUAL_NAME = "first_item.subreddit.visual_name";
    public static final String TEMPLATE_SUBREDDIT_PRIMARY_KEY = "subreddit.id";
    public static final String TEMPLATE_SUBREDDIT_VISUAL_NAME = "subreddit.visual_name";
    private static final String UNIQUE_ID_RECENT_SUBREDDITS = "xd_21";
    private static final String UNIT_TYPE_FAVORITE_SUBREDDITS = "favorite_subreddits";
    public final String custom_hide_key;
    boolean enabled;
    final boolean enabled_for_minimum_app_version;
    public final int index;
    public final CarouselItemLayout layout;
    final int min_app_version;
    final String min_app_version_name;
    public final List<String> options;
    public final OrderBy orderBy;
    public final Map<String, String> parameters;
    public final String subtitle;
    public final SubheaderIcon subtitle_icon;
    public final String surface;
    final SurfaceParameters surface_parameters;
    public final String title;
    public final String unique_id;
    public final String unit_type;
    public final String url;
    final int versionCode;
    final String versionName;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "kotlin.jvm.PlatformType", "DEFAULT_INDEX", "", "DEFAULT_VERSION_NAME_COLUMN_VALUE", "", "HIDE_CAROUSEL_DURATION_DAYS", "MAX_VERSION_NAME", "MAX_VERSION_NAME_COLUMNS", "MAX_VERSION_NAME_VALUE", "", "OPTION_ACTION_BUTTON", "OPTION_DESCRIPTION", "OPTION_DONT_FILTER_DISMISSALS", "OPTION_HIDE_ITEMS", "OPTION_HIDE_TITLE", "OPTION_SEE_MORE", "OPTION_SHOW_LESS", "OPTION_SHOW_POST_SUBREDDIT_HEADER", "OPTION_SHOW_SUBREDDIT_HEADER", "OPTION_SHOW_UNIT_SUBREDDIT_HEADER", "OPTION_WIDE", "TEMPLATE_FIRST_ITEM_CAUSE", "TEMPLATE_FIRST_ITEM_SUBREDDIT_KEY", "TEMPLATE_FIRST_ITEM_SUBREDDIT_VISUAL_NAME", "TEMPLATE_SUBREDDIT_PRIMARY_KEY", "TEMPLATE_SUBREDDIT_VISUAL_NAME", "UNIQUE_ID_RECENT_SUBREDDITS", "UNIT_TYPE_FAVORITE_SUBREDDITS", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnit.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$ModelType;", "", "(Ljava/lang/String;I)V", "LINK", "SUBREDDIT", "UNKNOWN", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnit.kt */
    public enum ModelType {
    }

    @PaperParcel
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$SurfaceParameters;", "Lpaperparcel/PaperParcelable;", "show_if_subscribed", "", "(Ljava/lang/Boolean;)V", "getShow_if_subscribed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$SurfaceParameters;", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DiscoveryUnit.kt */
    public static final class SurfaceParameters implements PaperParcelable {
        public static final Creator<SurfaceParameters> CREATOR = PaperParcelDiscoveryUnit_SurfaceParameters.CREATOR;
        public static final Companion Companion = new Companion();
        final Boolean show_if_subscribed;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$SurfaceParameters$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit$SurfaceParameters;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: DiscoveryUnit.kt */
        public static final class Companion {
            private Companion() {
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof SurfaceParameters) {
                    if (Intrinsics.a(this.show_if_subscribed, ((SurfaceParameters) obj).show_if_subscribed)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            Boolean bool = this.show_if_subscribed;
            return bool != null ? bool.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("SurfaceParameters(show_if_subscribed=");
            stringBuilder.append(this.show_if_subscribed);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        private /* synthetic */ SurfaceParameters() {
            this(null);
        }

        public SurfaceParameters(Boolean bool) {
            this.show_if_subscribed = bool;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            Intrinsics.b(parcel, "dest");
            DefaultImpls.writeToParcel(this, parcel, i);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryUnit) {
            DiscoveryUnit discoveryUnit = (DiscoveryUnit) obj;
            if (Intrinsics.a(this.unique_id, discoveryUnit.unique_id) && Intrinsics.a(this.unit_type, discoveryUnit.unit_type) && Intrinsics.a(this.surface, discoveryUnit.surface) && Intrinsics.a(this.url, discoveryUnit.url)) {
                if (this.enabled_for_minimum_app_version == discoveryUnit.enabled_for_minimum_app_version) {
                    if ((this.min_app_version == discoveryUnit.min_app_version) && Intrinsics.a(this.min_app_version_name, discoveryUnit.min_app_version_name)) {
                        if ((this.index == discoveryUnit.index) && Intrinsics.a(this.title, discoveryUnit.title) && Intrinsics.a(this.subtitle, discoveryUnit.subtitle) && Intrinsics.a(this.subtitle_icon, discoveryUnit.subtitle_icon) && Intrinsics.a(this.layout, discoveryUnit.layout) && Intrinsics.a(this.options, discoveryUnit.options) && Intrinsics.a(this.orderBy, discoveryUnit.orderBy) && Intrinsics.a(this.parameters, discoveryUnit.parameters) && Intrinsics.a(this.custom_hide_key, discoveryUnit.custom_hide_key)) {
                            return (this.versionCode == discoveryUnit.versionCode) && Intrinsics.a(this.versionName, discoveryUnit.versionName) && Intrinsics.a(this.surface_parameters, discoveryUnit.surface_parameters);
                        }
                    }
                }
            }
        }
    }

    public final int hashCode() {
        String str = this.unique_id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.unit_type;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.surface;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.url;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.enabled_for_minimum_app_version;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((hashCode + i2) * 31) + this.min_app_version) * 31;
        str2 = this.min_app_version_name;
        hashCode = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.index) * 31;
        str2 = this.title;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.subtitle;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        SubheaderIcon subheaderIcon = this.subtitle_icon;
        hashCode = (hashCode + (subheaderIcon != null ? subheaderIcon.hashCode() : 0)) * 31;
        CarouselItemLayout carouselItemLayout = this.layout;
        hashCode = (hashCode + (carouselItemLayout != null ? carouselItemLayout.hashCode() : 0)) * 31;
        List list = this.options;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        OrderBy orderBy = this.orderBy;
        hashCode = (hashCode + (orderBy != null ? orderBy.hashCode() : 0)) * 31;
        Map map = this.parameters;
        hashCode = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        str2 = this.custom_hide_key;
        hashCode = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.versionCode) * 31;
        str2 = this.versionName;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        SurfaceParameters surfaceParameters = this.surface_parameters;
        if (surfaceParameters != null) {
            i = surfaceParameters.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DiscoveryUnit(unique_id=");
        stringBuilder.append(this.unique_id);
        stringBuilder.append(", unit_type=");
        stringBuilder.append(this.unit_type);
        stringBuilder.append(", surface=");
        stringBuilder.append(this.surface);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", enabled_for_minimum_app_version=");
        stringBuilder.append(this.enabled_for_minimum_app_version);
        stringBuilder.append(", min_app_version=");
        stringBuilder.append(this.min_app_version);
        stringBuilder.append(", min_app_version_name=");
        stringBuilder.append(this.min_app_version_name);
        stringBuilder.append(", index=");
        stringBuilder.append(this.index);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", subtitle=");
        stringBuilder.append(this.subtitle);
        stringBuilder.append(", subtitle_icon=");
        stringBuilder.append(this.subtitle_icon);
        stringBuilder.append(", layout=");
        stringBuilder.append(this.layout);
        stringBuilder.append(", options=");
        stringBuilder.append(this.options);
        stringBuilder.append(", orderBy=");
        stringBuilder.append(this.orderBy);
        stringBuilder.append(", parameters=");
        stringBuilder.append(this.parameters);
        stringBuilder.append(", custom_hide_key=");
        stringBuilder.append(this.custom_hide_key);
        stringBuilder.append(", versionCode=");
        stringBuilder.append(this.versionCode);
        stringBuilder.append(", versionName=");
        stringBuilder.append(this.versionName);
        stringBuilder.append(", surface_parameters=");
        stringBuilder.append(this.surface_parameters);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public DiscoveryUnit(String str, String str2, String str3, String str4, boolean z, int i, String str5, int i2, String str6, String str7, SubheaderIcon subheaderIcon, CarouselItemLayout carouselItemLayout, List<String> list, OrderBy orderBy, Map<String, String> map, String str8, int i3, String str9, SurfaceParameters surfaceParameters) {
        String str10 = str;
        String str11 = str2;
        String str12 = str3;
        String str13 = str5;
        String str14 = str6;
        CarouselItemLayout carouselItemLayout2 = carouselItemLayout;
        List<String> list2 = list;
        OrderBy orderBy2 = orderBy;
        String str15 = str9;
        Intrinsics.b(str10, "unique_id");
        Intrinsics.b(str11, "unit_type");
        Intrinsics.b(str12, "surface");
        Intrinsics.b(str13, "min_app_version_name");
        Intrinsics.b(str14, "title");
        Intrinsics.b(carouselItemLayout2, "layout");
        Intrinsics.b(list2, "options");
        Intrinsics.b(orderBy2, "orderBy");
        Intrinsics.b(str15, "versionName");
        this.unique_id = str10;
        this.unit_type = str11;
        this.surface = str12;
        this.url = str4;
        this.enabled_for_minimum_app_version = z;
        this.min_app_version = i;
        this.min_app_version_name = str13;
        this.index = i2;
        this.title = str14;
        this.subtitle = str7;
        this.subtitle_icon = subheaderIcon;
        this.layout = carouselItemLayout2;
        this.options = list2;
        this.orderBy = orderBy2;
        this.parameters = map;
        this.custom_hide_key = str8;
        this.versionCode = i3;
        this.versionName = str15;
        this.surface_parameters = surfaceParameters;
        boolean z2 = this.enabled_for_minimum_app_version && m16410h();
        r0.enabled = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    private /* synthetic */ DiscoveryUnit() {
        CarouselItemLayout carouselItemLayout = CarouselItemLayout.SMALL;
        List a = CollectionsKt.a();
        com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.OrderBy.Companion companion = OrderBy.Companion;
        this("", "", "", null, false, RedditJobManager.f10810d, MAX_VERSION_NAME, -1, "", "", null, carouselItemLayout, a, com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.OrderBy.Companion.m9382a(), MapsKt.a(), null, 209200, "3.1.2", null);
    }

    public final ModelType m16411a() {
        String str = this.unit_type;
        int hashCode = str.hashCode();
        if (hashCode != -1951291421) {
            if (hashCode != -633982911) {
                if (hashCode != -205684200) {
                    if (hashCode == 181975684) {
                        if (str.equals("listing")) {
                            return ModelType.LINK;
                        }
                    }
                } else if (str.equals(UNIT_TYPE_FAVORITE_SUBREDDITS)) {
                    return ModelType.SUBREDDIT;
                }
            } else if (str.equals("recently_visited_subreddits")) {
                return ModelType.SUBREDDIT;
            }
        } else if (str.equals("subreddit_listing")) {
            return ModelType.SUBREDDIT;
        }
        return ModelType.UNKNOWN;
    }

    public final boolean m16413b() {
        return Intrinsics.a(this.unit_type, UNIT_TYPE_FAVORITE_SUBREDDITS);
    }

    public final void m16412a(boolean z) {
        z = m16410h() && z;
        this.enabled = z;
    }

    private final boolean m16410h() {
        return m16408a(this.min_app_version_name) <= m16408a(this.versionName);
    }

    public final boolean m16414c() {
        return this.options.contains(OPTION_ACTION_BUTTON);
    }

    public final boolean m16415d() {
        return this.options.contains(OPTION_HIDE_ITEMS);
    }

    public final boolean m16416e() {
        return this.options.contains(OPTION_SHOW_LESS);
    }

    public final boolean m16417f() {
        return this.options.contains(OPTION_WIDE);
    }

    public final Boolean m16418g() {
        SurfaceParameters surfaceParameters = this.surface_parameters;
        return surfaceParameters != null ? surfaceParameters.show_if_subscribed : null;
    }

    private static long m16408a(String str) {
        CharSequence charSequence = str;
        if (new Regex("[0-9.]+").a(charSequence)) {
            char[] cArr = new char[1];
            int i = 0;
            cArr[0] = '.';
            List c = CollectionsKt.c(StringsKt.a(charSequence, cArr));
            while (c.size() < 3) {
                c.add(DEFAULT_VERSION_NAME_COLUMN_VALUE);
            }
            Iterable<String> l = CollectionsKt.l(c);
            Collection arrayList = new ArrayList(CollectionsKt.b(l));
            for (String parseLong : l) {
                arrayList.add(Long.valueOf(Long.parseLong(parseLong)));
            }
            Iterable<Number> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(CollectionsKt.b(iterable));
            int i2 = 1;
            for (Number longValue : iterable) {
                i++;
                i2 *= 1000;
                arrayList2.add(Long.valueOf((longValue.longValue() * ((long) i)) * ((long) i2)));
            }
            long j = 0;
            for (Number longValue2 : (List) arrayList2) {
                j += longValue2.longValue();
            }
            return j;
        }
        RedditLogger.a(new DiscoveryUnit$convertVersionNameToValue$1(str));
        return MAX_VERSION_NAME_VALUE;
    }

    public static /* synthetic */ DiscoveryUnit m16409a(DiscoveryUnit discoveryUnit, String str, String str2, String str3, String str4, boolean z, int i, String str5, int i2, String str6, String str7, SubheaderIcon subheaderIcon, CarouselItemLayout carouselItemLayout, List list, OrderBy orderBy, Map map, String str8, int i3, String str9, SurfaceParameters surfaceParameters, int i4) {
        DiscoveryUnit discoveryUnit2 = discoveryUnit;
        int i5 = i4;
        String str10 = (i5 & 1) != 0 ? discoveryUnit2.unique_id : str;
        String str11 = (i5 & 2) != 0 ? discoveryUnit2.unit_type : str2;
        String str12 = (i5 & 4) != 0 ? discoveryUnit2.surface : str3;
        String str13 = (i5 & 8) != 0 ? discoveryUnit2.url : str4;
        boolean z2 = (i5 & 16) != 0 ? discoveryUnit2.enabled_for_minimum_app_version : z;
        int i6 = (i5 & 32) != 0 ? discoveryUnit2.min_app_version : i;
        String str14 = (i5 & 64) != 0 ? discoveryUnit2.min_app_version_name : str5;
        int i7 = (i5 & 128) != 0 ? discoveryUnit2.index : i2;
        String str15 = (i5 & 256) != 0 ? discoveryUnit2.title : str6;
        String str16 = (i5 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? discoveryUnit2.subtitle : str7;
        SubheaderIcon subheaderIcon2 = (i5 & 1024) != 0 ? discoveryUnit2.subtitle_icon : subheaderIcon;
        CarouselItemLayout carouselItemLayout2 = (i5 & MPEGConst.CODE_END) != 0 ? discoveryUnit2.layout : carouselItemLayout;
        List list2 = (i5 & 4096) != 0 ? discoveryUnit2.options : list;
        OrderBy orderBy2 = (i5 & 8192) != 0 ? discoveryUnit2.orderBy : orderBy;
        SubheaderIcon subheaderIcon3 = subheaderIcon2;
        Map map2 = (i5 & 16384) != 0 ? discoveryUnit2.parameters : map;
        String str17 = (32768 & i5) != 0 ? discoveryUnit2.custom_hide_key : str8;
        int i8 = (65536 & i5) != 0 ? discoveryUnit2.versionCode : i3;
        String str18 = (131072 & i5) != 0 ? discoveryUnit2.versionName : str9;
        SurfaceParameters surfaceParameters2 = (i5 & 262144) != 0 ? discoveryUnit2.surface_parameters : surfaceParameters;
        Intrinsics.b(str10, "unique_id");
        Intrinsics.b(str11, "unit_type");
        Intrinsics.b(str12, "surface");
        Intrinsics.b(str14, "min_app_version_name");
        Intrinsics.b(str15, "title");
        Intrinsics.b(carouselItemLayout2, "layout");
        Intrinsics.b(list2, "options");
        Intrinsics.b(orderBy2, "orderBy");
        Intrinsics.b(str18, "versionName");
        return new DiscoveryUnit(str10, str11, str12, str13, z2, i6, str14, i7, str15, str16, subheaderIcon3, carouselItemLayout2, list2, orderBy2, map2, str17, i8, str18, surfaceParameters2);
    }
}
