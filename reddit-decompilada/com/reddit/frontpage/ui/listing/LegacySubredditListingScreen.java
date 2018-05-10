package com.reddit.frontpage.ui.listing;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.percent.PercentFrameLayout.LayoutParams;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.birbit.android.jobqueue.JobManager;
import com.evernote.android.state.State;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.reddit.config.GlideApp;
import com.reddit.config.GlideRequest;
import com.reddit.datalibrary.frontpage.data.feature.ads.SubredditAdMetadata;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.model.ModPermissions;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.ProviderManager;
import com.reddit.datalibrary.frontpage.data.provider.SubredditLinkListingProvider;
import com.reddit.datalibrary.frontpage.job.DeletePostJob.ResultEvent;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.job.UpdatePostFlairJob;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.service.db.VisitService;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.analytics.ListItemViewAttachListener;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.TexturedBackground;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.modtools.ModAddUserTarget;
import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import com.reddit.frontpage.presentation.postoption.PostOptionsScreen;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionSelection;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.carousel.CarouselRecyclerView;
import com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder;
import com.reddit.frontpage.ui.color.ColorSource;
import com.reddit.frontpage.ui.color.ColorSource.OnColorChangedCallback;
import com.reddit.frontpage.ui.color.ColorSourceHelper;
import com.reddit.frontpage.ui.detail.LinkEditCache;
import com.reddit.frontpage.ui.listener.ProfileToolbarOffsetChangedListener;
import com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitListingView;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter.OnLinkHiddenListener;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen.LinkFlairSelectedListener;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.InstabugUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Nimbledroid.Scenario;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.frontpage.widgets.modtools.modqueue.ModModeable;
import de.greenrobot.event.EventBus;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import org.parceler.Parcel;
import org.parceler.Parcels;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ö\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 à\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0006à\u0001á\u0001â\u0001B\u000f\b\u0014\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0014\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\r\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0011\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0001J\u0018\u0010z\u001a\u00020w2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020&H\u0004J\u0019\u0010~\u001a\u00020w2\u0007\u0010\u001a\u00030\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0013\u0010\u0001\u001a\u00020w2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0017\u0010\u0001\u001a\u00020w2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0013\u0010\u0001\u001a\u00020w2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u0012\u0010\u0001\u001a\u00020w2\u0007\u0010\u0001\u001a\u000200H\u0002J\u0013\u0010\u0001\u001a\u00020w2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020w2\b\u0010\u0001\u001a\u00030\u0001H\u0014J\t\u0010\u0001\u001a\u00020EH\u0003J\t\u0010\u0001\u001a\u00020wH\u0002J\t\u0010\u0001\u001a\u00020wH\u0002J\t\u0010\u0001\u001a\u00020wH\u0002J\t\u0010\u0001\u001a\u00020wH\u0002J\t\u0010\u0001\u001a\u00020\bH\u0014J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\bH\u0016J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\bH\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010 \u0001\u001a\u00020EH\u0016J\t\u0010¡\u0001\u001a\u00020EH\u0016J\u000b\u0010¢\u0001\u001a\u0004\u0018\u00010\bH\u0016J\u0011\u0010£\u0001\u001a\u00020w2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\f\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0014J\t\u0010¦\u0001\u001a\u000200H\u0014J\t\u0010§\u0001\u001a\u00020wH\u0014J\u0012\u0010¨\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020EH\u0016J\u0013\u0010ª\u0001\u001a\u00020w2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0014J\u001b\u0010­\u0001\u001a\u00020w2\u0007\u0010®\u0001\u001a\u00020\b2\u0007\u0010¯\u0001\u001a\u00020EH\u0016J\u0012\u0010°\u0001\u001a\u00020w2\u0007\u0010±\u0001\u001a\u00020\u0011H\u0014J\u001c\u0010²\u0001\u001a\u00020w2\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010{\u001a\u00030µ\u0001H\u0016J\u0019\u0010¶\u0001\u001a\u00020\u00112\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020&H\u0016J\t\u0010·\u0001\u001a\u00020wH\u0016J\u0011\u0010¸\u0001\u001a\u00020w2\b\u0010¹\u0001\u001a\u00030º\u0001J\u0011\u0010»\u0001\u001a\u00020w2\b\u0010¼\u0001\u001a\u00030½\u0001J\t\u0010¾\u0001\u001a\u00020wH\u0014J,\u0010¿\u0001\u001a\u00020w2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010\b2\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0016J\u0013\u0010Å\u0001\u001a\u0002002\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0016J\u0013\u0010È\u0001\u001a\u00020w2\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u001b\u0010É\u0001\u001a\u00020w2\u0007\u0010±\u0001\u001a\u00020\u00112\u0007\u0010Ê\u0001\u001a\u00020\u000eH\u0014J\u001b\u0010Ë\u0001\u001a\u00020w2\u0007\u0010±\u0001\u001a\u00020\u00112\u0007\u0010Ì\u0001\u001a\u00020\u000eH\u0014J\u001b\u0010Í\u0001\u001a\u00020w2\u0007\u0010Î\u0001\u001a\u00020E2\u0007\u0010Ï\u0001\u001a\u00020EH\u0014J$\u0010Ð\u0001\u001a\f\u0012\u0005\u0012\u00030Ò\u0001\u0018\u00010Ñ\u00012\u000f\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030Ò\u00010Ñ\u0001H\u0015J\u0011\u0010Ô\u0001\u001a\u00020w2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\t\u0010Õ\u0001\u001a\u00020wH\u0014J\t\u0010Ö\u0001\u001a\u00020wH\u0004J\u0012\u0010×\u0001\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0001J\t\u0010Ø\u0001\u001a\u00020wH\u0002J\t\u0010Ù\u0001\u001a\u00020wH\u0014J\t\u0010Ú\u0001\u001a\u00020wH\u0002J\u0012\u0010Û\u0001\u001a\u00020w2\u0007\u0010Ü\u0001\u001a\u000200H\u0002J\t\u0010Ý\u0001\u001a\u00020wH\u0004J\t\u0010Þ\u0001\u001a\u00020wH\u0002J\u0017\u0010ß\u0001\u001a\u00020E*\f\u0012\u0005\u0012\u00030Ò\u0001\u0018\u00010Ñ\u0001H\u0002R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u000200XD¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010=\u001a\u000200XD¢\u0006\b\n\u0000\u001a\u0004\b>\u00102R\u0013\u0010?\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b@\u0010(R\u0016\u0010A\u001a\u0004\u0018\u0001008VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u0002008VX\u0004¢\u0006\u0006\u001a\u0004\bC\u00102R\u001a\u0010D\u001a\u0004\u0018\u00010EX\u000f¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u00020E8VX\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0016\u0010P\u001a\u0004\u0018\u00010 8BX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\"R\u001a\u0010R\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00102\"\u0004\bT\u0010UR\u0016\u0010V\u001a\u0004\u0018\u00010W8BX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR*\u0010[\u001a\u0004\u0018\u00010\u000b2\b\u0010Z\u001a\u0004\u0018\u00010\u000b8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010\tR\u0016\u0010b\u001a\u0004\u0018\u00010 8BX\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\"R\u001e\u0010d\u001a\u0002008\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00102\"\u0004\bf\u0010UR\u0016\u0010g\u001a\u0004\u0018\u00010 8BX\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\"R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010k\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010`R\"\u0010m\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010p\u001a\u0004\bn\u0010G\"\u0004\bo\u0010IR\u0011\u0010q\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\br\u0010\"R\u001a\u0010s\u001a\u0004\u0018\u00010EX\u000f¢\u0006\f\u001a\u0004\bt\u0010G\"\u0004\bu\u0010I¨\u0006ã\u0001"}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacySubredditListingScreen;", "Lcom/reddit/frontpage/ui/listing/AdsListingScreen;", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView;", "Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$LinkFlairSelectedListener;", "Lcom/reddit/frontpage/ui/color/ColorSource;", "Lcom/reddit/frontpage/widgets/modtools/modqueue/ModModeable;", "Lcom/reddit/frontpage/presentation/modtools/ModAddUserTarget;", "subredditName", "", "(Ljava/lang/String;)V", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Lcom/reddit/frontpage/domain/model/Subreddit;)V", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "bannerShadow", "Landroid/view/View;", "getBannerShadow", "()Landroid/view/View;", "bannerView", "Landroid/widget/ImageView;", "getBannerView", "()Landroid/widget/ImageView;", "carousel", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "collapsingToolbar", "Landroid/support/design/widget/CollapsingToolbarLayout;", "getCollapsingToolbar", "()Landroid/support/design/widget/CollapsingToolbarLayout;", "descriptionView", "Landroid/widget/TextView;", "getDescriptionView", "()Landroid/widget/TextView;", "discoveryUnitAttachListener", "Lcom/reddit/frontpage/presentation/analytics/ListItemViewAttachListener;", "discoveryUnitLayout", "Landroid/view/ViewGroup;", "getDiscoveryUnitLayout", "()Landroid/view/ViewGroup;", "discoveryUnitListingDelegate", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "getDiscoveryUnitListingDelegate", "()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;", "discoveryUnitListingDelegate$delegate", "Lkotlin/Lazy;", "discoveryUnitsEnabled", "", "getDiscoveryUnitsEnabled", "()Z", "filterBarView", "Lcom/reddit/frontpage/widgets/ListingFilterBarView;", "getFilterBarView", "()Lcom/reddit/frontpage/widgets/ListingFilterBarView;", "setFilterBarView", "(Lcom/reddit/frontpage/widgets/ListingFilterBarView;)V", "followButton", "Landroid/widget/Button;", "getFollowButton", "()Landroid/widget/Button;", "hasDiscoveryUnits", "getHasDiscoveryUnits", "headerView", "getHeaderView", "isSurfaceSubscribed", "()Ljava/lang/Boolean;", "isViewAttached", "keyColor", "", "getKeyColor", "()Ljava/lang/Integer;", "setKeyColor", "(Ljava/lang/Integer;)V", "modPermissions", "Lcom/reddit/datalibrary/frontpage/data/model/ModPermissions;", "needsScreenViewEvent", "numListItems", "getNumListItems", "()I", "onlineCountView", "getOnlineCountView", "overrideOnCreateByChild", "getOverrideOnCreateByChild", "setOverrideOnCreateByChild", "(Z)V", "subredditIconView", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "getSubredditIconView", "()Lcom/reddit/frontpage/widgets/ShapedIconView;", "value", "subredditModel", "getSubredditModel", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "setSubredditModel", "getSubredditName", "()Ljava/lang/String;", "setSubredditName", "subredditNameView", "getSubredditNameView", "subscribed", "getSubscribed", "setSubscribed", "subscriberCountView", "getSubscriberCountView", "subscriptionDuDisposable", "Lio/reactivex/disposables/Disposable;", "surfaceName", "getSurfaceName", "themedKeyColor", "getThemedKeyColor", "setThemedKeyColor", "Ljava/lang/Integer;", "toolbarTitle", "getToolbarTitle", "topColor", "getTopColor", "setTopColor", "addOnColorChangedCallback", "", "callback", "Lcom/reddit/frontpage/ui/color/ColorSource$OnColorChangedCallback;", "addSortBar", "inflater", "Landroid/view/LayoutInflater;", "container", "addToRecentSubreddits", "manager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "bindSubreddit", "bindSubscriptionDiscoveryUnit", "configureActionBar", "actionBar", "Landroid/support/v7/app/ActionBar;", "configureSubscribeButton", "useAnimation", "confirmUnsubscribe", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "createListingAdapter", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "createListingProvider", "Lcom/reddit/datalibrary/frontpage/data/provider/LinkListingProvider;", "createV1ScreenViewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScreenViewEvent;", "customizeDecorationStrategy", "strategy", "Lcom/reddit/frontpage/ui/listing/DecorationInclusionStrategy;", "defaultKeyColor", "defaultUi", "fetchDiscoveryUnits", "fetchRelatedCommunitiesDiscoveryUnit", "fixLoaderMargin", "getAdUnitName", "getAnalyticsHeartbeatParams", "Lcom/reddit/frontpage/commons/analytics/events/v2/AnalyticsHeartbeatParams;", "getAnalyticsPageType", "getAnalyticsScreenName", "getAnalyticsScreenviewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v2/ScreenviewEventBuilder;", "getIndexOfLastDiscoveryUnit", "getLayoutId", "getListingName", "getModPermissions", "getSubredditAdMetadata", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/SubredditAdMetadata;", "hasSubreddit", "loadSubreddit", "notifyDiscoveryUnitInsertedAtPosition", "position", "onActivityPaused", "activity", "Landroid/app/Activity;", "onAddUserSuccess", "username", "stringRes", "onAttach", "view", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onCreateView", "onDestroy", "onEvent", "event", "Lcom/reddit/datalibrary/frontpage/job/DeletePostJob$ResultEvent;", "onEventMainThread", "viewModeSelection", "Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionSelection;", "onInitialize", "onLinkFlairSelected", "selectedLinkFlair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "selectedLinkFlairEdit", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPrepareOptionsMenu", "onRestoreViewState", "savedViewState", "onSaveViewState", "outState", "onSortChanged", "sortType", "sortTimeFrame", "processListing", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "listing", "rageShakeSetup", "refresh", "refreshKeyColor", "removeOnColorChangedCallback", "showCommunityError", "showCreatePostOptions", "showExploreCommunities", "subscribeSubreddit", "subscribe", "switchModMode", "updateSubscribeButtonVisuals", "indexOfLastDiscoveryUnit", "Companion", "DeepLinker", "FlairLinkAdapter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LegacySubredditListingScreen.kt */
public class LegacySubredditListingScreen extends AdsListingScreen implements ModAddUserTarget, ColorSource, DiscoveryUnitListingView, LinkFlairSelectedListener, ModModeable {
    static final /* synthetic */ KProperty[] f40614M = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LegacySubredditListingScreen.class), "discoveryUnitListingDelegate", "getDiscoveryUnitListingDelegate()Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager;"))};
    public static final Companion f40615Q = new Companion();
    String f40616N;
    ListingFilterBarView f40617O;
    boolean f40618P;
    private ModPermissions f40619R;
    private boolean f40620S;
    private Disposable f40621T;
    private ListItemViewAttachListener f40622U;
    private final Lazy f40623V;
    private final boolean f40624W;
    private GeneralCarouselCollectionPresentationModel<? extends ICarouselItemPresentationModel> f40625X;
    private final boolean f40626Y;
    private final /* synthetic */ ColorSourceHelper f40627Z;
    @State
    Subreddit subredditModel;
    @State
    boolean subscribed;
    @State
    Integer themedKeyColor;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacySubredditListingScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "ANALYTICS_SCREEN_NAME", "ARGS_SUBREDDIT_MODEL", "ARGS_SUBREDDIT_NAME", "DESCRIPTION_MAX_LINES", "", "HEADER_SURFACE_NAME", "SURFACE_NAME", "args", "Landroid/os/Bundle;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "subredditName", "deepLink", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "newInstance", "Lcom/reddit/frontpage/ui/listing/LegacySubredditListingScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LegacySubredditListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LegacySubredditListingScreen m23430a(String str) {
            Intrinsics.m26847b(str, "subredditName");
            return new LegacySubredditListingScreen(str);
        }

        public static LegacySubredditListingScreen m23429a(Subreddit subreddit) {
            Intrinsics.m26847b(subreddit, "subreddit");
            return new LegacySubredditListingScreen(subreddit);
        }

        public static ScreenDeepLinker m23432b(String str) {
            Intrinsics.m26847b(str, "subredditName");
            DeepLinker deepLinker = new DeepLinker();
            deepLinker.setSubredditName(str);
            return deepLinker;
        }

        public static final /* synthetic */ Bundle m23433c(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("args.subreddit_name", str);
            return bundle;
        }

        public static final /* synthetic */ Bundle m23431b(Subreddit subreddit) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("args.subreddit_model", Parcels.m28672a((Object) subreddit));
            return bundle;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacySubredditListingScreen$DeepLinker;", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "()V", "subredditName", "", "getSubredditName", "()Ljava/lang/String;", "setSubredditName", "(Ljava/lang/String;)V", "createScreen", "Lcom/reddit/frontpage/nav/Screen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Parcel
    /* compiled from: LegacySubredditListingScreen.kt */
    public static final class DeepLinker implements ScreenDeepLinker {
        public String subredditName;

        public final String getSubredditName() {
            String str = this.subredditName;
            if (str == null) {
                Intrinsics.m26844a("subredditName");
            }
            return str;
        }

        public final void setSubredditName(String str) {
            Intrinsics.m26847b(str, "<set-?>");
            this.subredditName = str;
        }

        public final Screen createScreen() {
            Companion companion = LegacySubredditListingScreen.f40615Q;
            String str = this.subredditName;
            if (str == null) {
                Intrinsics.m26844a("subredditName");
            }
            return Companion.m23430a(str);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0016H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0014J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0005H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/reddit/frontpage/ui/listing/LegacySubredditListingScreen$FlairLinkAdapter;", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "context", "Landroid/content/Context;", "sourcePage", "", "(Lcom/reddit/frontpage/ui/listing/LegacySubredditListingScreen;Landroid/content/Context;Ljava/lang/String;)V", "bindViewHolder", "", "holder", "Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "getAnalyticsScreenName", "getCompact", "", "getItem", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "position", "", "getItemCount", "getListing", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getSourcePage", "getUnadjustedPosition", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;)Ljava/lang/Integer;", "navigateToPostDetail", "onCarouselItemRemovedFromListing", "renderShortDurationMessage", "message", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LegacySubredditListingScreen.kt */
    private final class FlairLinkAdapter extends CardLinkAdapter {
        final /* synthetic */ LegacySubredditListingScreen f34320a;
        private final String f34321b;

        public FlairLinkAdapter(LegacySubredditListingScreen legacySubredditListingScreen, Context context, String str) {
            Intrinsics.m26847b(context, "context");
            this.f34320a = legacySubredditListingScreen;
            super(context, 6);
            this.f34321b = str;
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        public final Listable mo6476c(int i) {
            Object obj = this.f34320a.y.get(i);
            Intrinsics.m26843a(obj, "this@LegacySubredditList…een.listing.get(position)");
            return (Listable) obj;
        }

        public final boolean mo6477c() {
            return this.f34320a.H == ListingViewMode.f20613b;
        }

        public final int m35038a() {
            Listing listing = this.f34320a.y;
            return listing != null ? listing.size() : 0;
        }

        protected final void mo6506b(LinkViewHolder linkViewHolder, Link link) {
            Intrinsics.m26847b(linkViewHolder, "holder");
            Intrinsics.m26847b(link, "link");
            super.mo6506b(linkViewHolder, link);
            linkViewHolder.m35121a(this.f34320a.Y_());
        }

        protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
            Intrinsics.m26847b(linkViewHolder, "holder");
            Intrinsics.m26847b(link, "link");
            linkViewHolder.mo7006w();
            this.f34320a.m39238a((ViewHolder) linkViewHolder);
        }

        protected final String mo6479f() {
            return this.f34321b;
        }

        protected final void mo6504a(String str) {
            Intrinsics.m26847b(str, "message");
            super.mo6504a(str);
            this.f34320a.m37531b((CharSequence) str);
        }

        protected final Listing<Listable> G_() {
            return this.f34320a.y;
        }

        protected final Integer a_(ViewHolder viewHolder) {
            return Integer.valueOf(this.f34320a.w.m30148d(viewHolder));
        }

        protected final String mo6508g() {
            return this.f34320a.getAnalyticsScreenName();
        }

        protected final RecyclerView mo6490h() {
            return this.f34320a.listView;
        }

        protected final void b_(int i) {
            super.b_(i);
            this.f34320a.E.c(i);
        }
    }

    public static final LegacySubredditListingScreen m42256a(String str) {
        return Companion.m23430a(str);
    }

    private final DiscoveryUnitManager aJ() {
        return (DiscoveryUnitManager) this.f40623V.mo5678b();
    }

    public static final ScreenDeepLinker m42264b(String str) {
        return Companion.m23432b(str);
    }

    public static final LegacySubredditListingScreen m42267c(Subreddit subreddit) {
        return Companion.m23429a(subreddit);
    }

    protected final boolean mo7702Q() {
        return true;
    }

    public final void mo4950a(OnColorChangedCallback onColorChangedCallback) {
        Intrinsics.m26847b(onColorChangedCallback, "callback");
        this.f40627Z.mo4950a(onColorChangedCallback);
    }

    public final void mo4951a(Integer num) {
        this.f40627Z.mo4951a(num);
    }

    public final void mo4952b(OnColorChangedCallback onColorChangedCallback) {
        Intrinsics.m26847b(onColorChangedCallback, "callback");
        this.f40627Z.mo4952b(onColorChangedCallback);
    }

    public final void mo4953b(Integer num) {
        this.f40627Z.mo4953b(num);
    }

    public final String mo4800c() {
        return "subreddit_listing";
    }

    public String getAnalyticsPageType() {
        return "community";
    }

    public String getAnalyticsScreenName() {
        return "community_view";
    }

    public int mo7141s() {
        return C1761R.layout.screen_subreddit_listing;
    }

    public LegacySubredditListingScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "args");
        super(bundle);
        this.f40627Z = new ColorSourceHelper();
        this.f40623V = LazyKt.m26777a((Function0) new LegacySubredditListingScreen$discoveryUnitListingDelegate$2(this));
        this.f40624W = true;
        this.f40626Y = true;
    }

    public final void m42294a(Subreddit subreddit) {
        this.subredditModel = subreddit;
        m29352G();
    }

    public final TextView m42280S() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (TextView) obj.findViewById(C1761R.id.toolbar_title);
        Intrinsics.m26843a(obj, "rootView.toolbar_title");
        return obj;
    }

    private final CollapsingToolbarLayout ar() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (CollapsingToolbarLayout) obj.findViewById(C1761R.id.collapsing_toolbar);
    }

    private final ImageView as() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (ImageView) obj.findViewById(C1761R.id.profile_banner);
    }

    private final ShapedIconView aB() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (ShapedIconView) obj.findViewById(C1761R.id.profile_icon);
    }

    public final Button ak() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (Button) obj.findViewById(C1761R.id.profile_follow);
    }

    private final TextView aC() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (TextView) obj.findViewById(C1761R.id.profile_detail_1);
    }

    private final TextView aD() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (TextView) obj.findViewById(C1761R.id.profile_detail_2);
    }

    private final TextView aE() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (TextView) obj.findViewById(C1761R.id.profile_description);
    }

    protected LegacySubredditListingScreen(String str) {
        Intrinsics.m26847b(str, "subredditName");
        this(Companion.m23433c(str));
    }

    protected LegacySubredditListingScreen(Subreddit subreddit) {
        Intrinsics.m26847b(subreddit, "subreddit");
        this(Companion.m23431b(subreddit));
    }

    protected final void mo7142t() {
        super.mo7142t();
        n();
        this.f40616N = t_().getString("args.subreddit_name");
        if (this.f40616N == null) {
            m42294a((Subreddit) Parcels.m28673a(t_().getParcelable("args.subreddit_model")));
            Subreddit subreddit = this.subredditModel;
            this.f40616N = subreddit != null ? subreddit.getDisplayName() : null;
        }
    }

    protected void mo6992b(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = this.f40625X;
        if (generalCarouselCollectionPresentationModel != null) {
            m42257a(generalCarouselCollectionPresentationModel);
            aF();
        }
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        boolean z = false;
        if (!this.f40618P) {
            Object obj = this.K;
            Intrinsics.m26843a(obj, "rootView");
            View findViewById = obj.findViewById(C1761R.id.appbar);
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.design.widget.AppBarLayout");
            }
            ((AppBarLayout) findViewById).a(new ProfileToolbarOffsetChangedListener(ar(), m42280S()));
            StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
            Resources ao_ = ao_();
            if (ao_ == null) {
                Intrinsics.m26842a();
            }
            obj = ao_.getString(C1761R.string.fmt_r_name);
            Intrinsics.m26843a(obj, "resources!!.getString(R.string.fmt_r_name)");
            obj = String.format(obj, Arrays.copyOf(new Object[]{this.f40616N}, 1));
            Intrinsics.m26843a(obj, "java.lang.String.format(format, *args)");
            Object obj2 = this.K;
            Intrinsics.m26843a(obj2, "rootView");
            TextView textView = (TextView) obj2.findViewById(C1761R.id.profile_title);
            if (textView == null) {
                Intrinsics.m26842a();
            }
            CharSequence charSequence = (CharSequence) obj;
            textView.setText(charSequence);
            m42280S().setText(charSequence);
            Button ak = ak();
            if (ak == null) {
                Intrinsics.m26842a();
            }
            ak.setText(C1761R.string.action_subscribe);
            obj = this.K;
            Intrinsics.m26843a(obj, "rootView");
            ConstraintLayout constraintLayout = (ConstraintLayout) obj.findViewById(C1761R.id.profile_header);
            if (constraintLayout == null) {
                Intrinsics.m26842a();
            }
            constraintLayout.setLayoutTransition(new LayoutTransition());
            m42300b(layoutInflater, viewGroup);
        }
        layoutInflater = this.swipeRefreshLayout;
        viewGroup = ao_();
        if (viewGroup == null) {
            Intrinsics.m26842a();
        }
        layoutInflater.setProgressViewOffset$4958629f(viewGroup.getDimensionPixelOffset(C1761R.dimen.sub_bar_height) / 2);
        if (this.H == ListingViewMode.f20613b) {
            z = true;
        }
        m41008e(z);
        if (this.subredditModel == null) {
            am();
        } else if (this.f40618P == null) {
            mo7733b(this.subredditModel);
        }
        Object obj3 = this.loadingSpinner;
        Intrinsics.m26843a(obj3, "loadingSpinner");
        layoutInflater = obj3.getLayoutParams();
        if (layoutInflater == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.percent.PercentFrameLayout.LayoutParams");
        }
        ((LayoutParams) layoutInflater).a().d = 0.24f;
        this.loadingSpinner.requestLayout();
        Scenario.f21765a.m23847b();
        obj3 = this.K;
        Intrinsics.m26843a(obj3, "rootView");
        return obj3;
    }

    protected final void m42300b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        View inflate = layoutInflater.inflate(C1761R.layout.widget_sort_bar, viewGroup, false);
        Intrinsics.m26843a((Object) inflate, "view");
        viewGroup = inflate.findViewById(C1761R.id.listing_filter_bar);
        if (viewGroup == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.ListingFilterBarView");
        }
        ListingFilterBarView listingFilterBarView = (ListingFilterBarView) viewGroup;
        Object obj = this.E;
        Intrinsics.m26843a(obj, "linkProvider");
        int b = obj.b();
        Object obj2 = this.E;
        Intrinsics.m26843a(obj2, "linkProvider");
        listingFilterBarView.m24179a(b, obj2.c());
        listingFilterBarView.setOnSortClickListener(new LegacySubredditListingScreen$addSortBar$$inlined$apply$lambda$1(this));
        listingFilterBarView.setOnViewModeClickListener(new LegacySubredditListingScreen$addSortBar$$inlined$apply$lambda$2(this));
        obj = this.H;
        Intrinsics.m26843a(obj, "viewMode");
        listingFilterBarView.setViewMode(obj);
        this.f40617O = listingFilterBarView;
        this.w.m35092a(inflate);
    }

    protected final void mo7705c(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.mo7705c(activity);
        activity = this.f40617O;
        if (activity != null) {
            ModUtil.m23825a((View) activity.getModModeButton());
        }
    }

    public void mo7191l() {
        super.mo7191l();
        if (ModUtil.m23831a((Screen) this)) {
            ModUtil.m23832b();
            Subreddit subreddit = this.subredditModel;
            if ((subreddit != null ? subreddit.getKindWithId() : null) != null) {
                subreddit = this.subredditModel;
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                String kindWithId = subreddit.getKindWithId();
                Subreddit subreddit2 = this.subredditModel;
                if (subreddit2 == null) {
                    Intrinsics.m26842a();
                }
                ModUtil.m23830a(kindWithId, subreddit2.getDisplayName());
            }
        }
        this.f40625X = null;
        aJ().f21278a.m32077c();
        this.f40622U = null;
    }

    protected final void mo7696a(DecorationInclusionStrategy decorationInclusionStrategy) {
        Intrinsics.m26847b(decorationInclusionStrategy, "strategy");
        decorationInclusionStrategy.m23389a(LegacySubredditListingScreen$customizeDecorationStrategy$1.f37279a);
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.c(false);
    }

    public CardLinkAdapter mo7455Y() {
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        FlairLinkAdapter flairLinkAdapter = new FlairLinkAdapter(this, (Context) am_, this.f40616N);
        flairLinkAdapter.m30203a((OnLinkHiddenListener) new C2341x6d1f6653(this));
        return flairLinkAdapter;
    }

    public final LinkListingProvider mo7452U() {
        ProviderManager providerManager = ProviderManager.b;
        Object Y_ = Y_();
        Intrinsics.m26843a(Y_, "instanceId");
        String str = this.f40616N;
        if (str == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26847b(Y_, "ownerId");
        Intrinsics.m26847b(str, "subreddit");
        BaseOtherProvider baseOtherProvider = (BaseOtherProvider) ProviderManager.b().get(Y_);
        if (baseOtherProvider == null) {
            baseOtherProvider = new SubredditLinkListingProvider(Y_, str);
            ProviderManager.b().put(Y_, baseOtherProvider);
        }
        return (SubredditLinkListingProvider) baseOtherProvider;
    }

    public final void onEvent(ResultEvent resultEvent) {
        Intrinsics.m26847b(resultEvent, "event");
        EventBus.getDefault().removeStickyEvent((Object) resultEvent);
        resultEvent = resultEvent.a;
        if (resultEvent != -1) {
            m39249b((int) resultEvent);
        }
    }

    protected final void al() {
        Object obj;
        Integer valueOf;
        Activity am_;
        Subreddit subreddit = this.subredditModel;
        CharSequence keyColor = subreddit != null ? subreddit.getKeyColor() : null;
        if (keyColor != null) {
            if (keyColor.length() != 0) {
                obj = null;
                if (obj != null) {
                    subreddit = this.subredditModel;
                    if (subreddit == null) {
                        Intrinsics.m26842a();
                    }
                    valueOf = Integer.valueOf(Color.parseColor(subreddit.getKeyColor()));
                } else {
                    valueOf = Integer.valueOf(aG());
                }
                mo4951a(valueOf);
                am_ = am_();
                if (am_ != null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.RedditThemedActivity");
                }
                obj = ((RedditThemedActivity) am_).f40551f;
                if (!Intrinsics.m26845a(obj, ThemeOption.f20981c)) {
                    if (Intrinsics.m26845a(obj, ThemeOption.f20984f)) {
                        valueOf = this.f40627Z.f28924a;
                        this.themedKeyColor = valueOf;
                        mo4953b(this.themedKeyColor);
                        return;
                    }
                }
                obj = am_();
                if (obj == null) {
                    Intrinsics.m26842a();
                }
                Intrinsics.m26843a(obj, "activity!!");
                valueOf = Integer.valueOf(ResourcesUtil.m22740i((Context) obj, C1761R.attr.rdt_body_color));
                this.themedKeyColor = valueOf;
                mo4953b(this.themedKeyColor);
                return;
            }
        }
        obj = 1;
        if (obj != null) {
            valueOf = Integer.valueOf(aG());
        } else {
            subreddit = this.subredditModel;
            if (subreddit == null) {
                Intrinsics.m26842a();
            }
            valueOf = Integer.valueOf(Color.parseColor(subreddit.getKeyColor()));
        }
        mo4951a(valueOf);
        am_ = am_();
        if (am_ != null) {
            obj = ((RedditThemedActivity) am_).f40551f;
            if (Intrinsics.m26845a(obj, ThemeOption.f20981c)) {
                if (Intrinsics.m26845a(obj, ThemeOption.f20984f)) {
                    valueOf = this.f40627Z.f28924a;
                    this.themedKeyColor = valueOf;
                    mo4953b(this.themedKeyColor);
                    return;
                }
            }
            obj = am_();
            if (obj == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(obj, "activity!!");
            valueOf = Integer.valueOf(ResourcesUtil.m22740i((Context) obj, C1761R.attr.rdt_body_color));
            this.themedKeyColor = valueOf;
            mo4953b(this.themedKeyColor);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.RedditThemedActivity");
    }

    protected void am() {
        if (!SubredditUtil.m23920a((CharSequence) this.f40616N)) {
            if (this.subredditModel == null) {
                int aG = aG();
                CollapsingToolbarLayout ar = ar();
                if (ar != null) {
                    ar.setContentScrimColor(aG);
                }
                ImageView as = as();
                if (as != null) {
                    as.setBackground(new ColorDrawable(aG));
                }
                if (!(aB() == null || ModUtil.m23834b(this))) {
                    Util.m23980a(aB(), this.subredditModel);
                    ShapedIconView aB = aB();
                    if (aB != null) {
                        aB.setVisibility(0);
                    }
                }
            }
            CompositeDisposable compositeDisposable = this.G;
            SubredditRepository w = FrontpageApplication.m28875k().mo4635w();
            String str = this.f40616N;
            if (str == null) {
                Intrinsics.m26842a();
            }
            Single observeOn = w.m22493a(str).observeOn(FrontpageApplication.m28875k().mo4633u().a());
            Intrinsics.m26843a((Object) observeOn, "FrontpageApplication\n   …cutionThread().scheduler)");
            compositeDisposable.mo5631a(SubscribersKt.m26769a(observeOn, (Function1) new LegacySubredditListingScreen$loadSubreddit$1(this), (Function1) new LegacySubredditListingScreen$loadSubreddit$2(this)));
        }
    }

    protected void mo7733b(Subreddit subreddit) {
        m29352G();
        if (subreddit == null) {
            Timber.e("subreddit is null", new Object[0]);
            return;
        }
        String displayName;
        TextView aC;
        boolean z = true;
        if (Intrinsics.m26845a(subreddit.getUserIsModerator(), Boolean.valueOf(true))) {
            displayName = subreddit.getDisplayName();
            CompositeDisposable compositeDisposable = this.G;
            ModToolsRepository r = FrontpageApplication.m28875k().mo4630r();
            Object e = SessionUtil.m23899e();
            Intrinsics.m26843a(e, "SessionUtil.getCurrentUsername()");
            Single observeOn = r.m22462k(displayName, e).observeOn(FrontpageApplication.m28875k().mo4633u().a());
            Intrinsics.m26843a((Object) observeOn, "FrontpageApplication\n   …cutionThread().scheduler)");
            compositeDisposable.mo5631a(SubscribersKt.m26769a(observeOn, (Function1) LegacySubredditListingScreen$getModPermissions$1.f37281a, (Function1) new LegacySubredditListingScreen$getModPermissions$2(this)));
        }
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "manager");
        if (!(subreddit.isUser() || b.c().isAnonymous())) {
            String username = b.c().getUsername();
            Intent intent = new Intent(am_(), VisitService.class);
            intent.putExtra("username", username);
            intent.putExtra("subreddit", Parcels.m28672a((Object) subreddit));
            Activity am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            am_.startService(intent);
        }
        m42294a(subreddit);
        al();
        CollapsingToolbarLayout ar = ar();
        if (ar == null) {
            Intrinsics.m26842a();
        }
        Integer num = this.themedKeyColor;
        if (num == null) {
            Intrinsics.m26842a();
        }
        ar.setContentScrimColor(num.intValue());
        Boolean userIsSubscriber = subreddit.getUserIsSubscriber();
        this.subscribed = userIsSubscriber != null ? userIsSubscriber.booleanValue() : false;
        if (!b.c().isAnonymous()) {
            m42274g(false);
            Button ak = ak();
            if (ak == null) {
                Intrinsics.m26842a();
            }
            ak.setOnClickListener(new LegacySubredditListingScreen$bindSubreddit$1(this));
        }
        if (subreddit.getSubscribers() > 0) {
            aC = aC();
            if (aC == null) {
                Intrinsics.m26842a();
            }
            aC.setText(Util.m23960a((int) C1761R.string.fmt_num_subscribers, Long.valueOf(subreddit.getSubscribers())));
        } else {
            aC = aC();
            if (aC == null) {
                Intrinsics.m26842a();
            }
            aC.setText(C1761R.string.placeholder_subscriber_count);
        }
        if (subreddit.getAccountsActive() == null || subreddit.getAccountsActive().longValue() <= 0) {
            aC = aD();
            if (aC == null) {
                Intrinsics.m26842a();
            }
            aC.setText(C1761R.string.placeholder_online_count);
        } else {
            aC = aD();
            if (aC == null) {
                Intrinsics.m26842a();
            }
            aC.setText(Util.m23960a((int) C1761R.string.fmt_num_online, subreddit.getAccountsActive()));
        }
        if (((CharSequence) subreddit.getPublicDescription()).length() == 0) {
            aC = aE();
            if (aC == null) {
                Intrinsics.m26842a();
            }
            aC.setVisibility(8);
        } else {
            aC = aE();
            if (aC == null) {
                Intrinsics.m26842a();
            }
            aC.setText(subreddit.getPublicDescription());
            aC = aE();
            if (aC == null) {
                Intrinsics.m26842a();
            }
            aC.setOnClickListener(new C1895xce3c3de4(new LegacySubredditListingScreen$bindSubreddit$2(this)));
        }
        boolean a = AccountPrefsUtil.m23629a(Boolean.valueOf(subreddit.getOver18()));
        if (!ModUtil.m23834b(this)) {
            Util.m24001b(aB(), subreddit.toLegacyV1Subreddit(), a);
            ShapedIconView aB = aB();
            if (aB == null) {
                Intrinsics.m26842a();
            }
            aB.setVisibility(0);
        }
        displayName = subreddit.getBannerImg();
        CharSequence charSequence = displayName;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                z = false;
            }
        }
        ImageView as;
        if (z) {
            Object am_2 = am_();
            if (am_2 == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(am_2, "activity!!");
            Context context = (Context) am_2;
            Integer num2 = this.themedKeyColor;
            if (num2 == null) {
                Intrinsics.m26842a();
            }
            int intValue = num2.intValue();
            as = as();
            if (as == null) {
                Intrinsics.m26842a();
            }
            TexturedBackground.m22744a(context, intValue, as);
        } else {
            Activity am_3 = am_();
            if (am_3 == null) {
                Intrinsics.m26842a();
            }
            GlideRequest b2 = GlideApp.a(am_3).b(displayName);
            as = as();
            if (as == null) {
                Intrinsics.m26842a();
            }
            b2.into(as);
            b = this.K;
            Intrinsics.m26843a(b, "rootView");
            View findViewById = b.findViewById(C1761R.id.banner_shadow);
            if (findViewById == null) {
                Intrinsics.m26842a();
            }
            findViewById.setVisibility(0);
        }
        if (this.subredditModel != null) {
            Subreddit subreddit2 = this.subredditModel;
            if (subreddit2 == null) {
                Intrinsics.m26842a();
            }
            ListingFilterBarView listingFilterBarView = this.f40617O;
            if (listingFilterBarView == null) {
                Intrinsics.m26842a();
            }
            ModUtil.m23828a(subreddit2, (View) listingFilterBarView.getModModeButton(), (Runnable) new LegacySubredditListingScreen$bindSubreddit$3(this));
        }
        m40999P();
        aJ().m23420a(DiscoveryUnit.TEMPLATE_SUBREDDIT_PRIMARY_KEY, subreddit.getKindWithId());
        aJ().m23420a(DiscoveryUnit.TEMPLATE_SUBREDDIT_VISUAL_NAME, subreddit.getDisplayNamePrefixed());
        aK();
    }

    public final void mo7454a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.mo7454a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_community, menu);
        Object findItem = menu.findItem(C1761R.id.action_search);
        Intrinsics.m26843a(findItem, "searchItem");
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Context context = (Context) am_;
        Drawable icon = findItem.getIcon();
        Intrinsics.m26843a((Object) icon, "searchItem.icon");
        findItem.setIcon(ResourcesUtil.m22737g(context, icon));
        findItem = menu.findItem(C1761R.id.action_sort);
        Intrinsics.m26843a(findItem, "sortItem");
        am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        context = (Context) am_;
        icon = findItem.getIcon();
        Intrinsics.m26843a((Object) icon, "sortItem.icon");
        findItem.setIcon(ResourcesUtil.m22737g(context, icon));
        findItem.setVisible(false);
        Object findItem2 = menu.findItem(C1761R.id.action_mod_tools);
        Intrinsics.m26843a(findItem2, "modToolsItem");
        findItem = am_();
        if (findItem == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(findItem, "activity!!");
        Context context2 = (Context) findItem;
        Drawable icon2 = findItem2.getIcon();
        Intrinsics.m26843a((Object) icon2, "modToolsItem.icon");
        findItem2.setIcon(ResourcesUtil.m22737g(context2, icon2));
    }

    public void mo7730a(Menu menu) {
        Object findItem;
        Intrinsics.m26847b(menu, "menu");
        super.a(menu);
        if (this.subredditModel != null) {
            boolean z;
            findItem = menu.findItem(C1761R.id.action_subscribe);
            Object findItem2 = menu.findItem(C1761R.id.action_unsubscribe);
            Intrinsics.m26843a(findItem, "subscribedItem");
            findItem.setVisible(this.subscribed ^ true);
            Intrinsics.m26843a(findItem2, "unsubscribedItem");
            findItem2.setVisible(this.subscribed);
            Subreddit subreddit = this.subredditModel;
            if (subreddit == null) {
                Intrinsics.m26842a();
            }
            CharSequence descriptionHtml = subreddit.getDescriptionHtml();
            if (descriptionHtml != null) {
                if (descriptionHtml.length() != 0) {
                    z = false;
                    if (z) {
                        subreddit = this.subredditModel;
                        if (subreddit == null) {
                            Intrinsics.m26842a();
                        }
                        descriptionHtml = subreddit.getDescription();
                        if (descriptionHtml != null) {
                            if (descriptionHtml.length() == 0) {
                                z = false;
                                if (z) {
                                    findItem = menu.findItem(C1761R.id.action_subreddit_info);
                                    Intrinsics.m26843a(findItem, "infoItem");
                                    findItem.setVisible(false);
                                }
                            }
                        }
                        z = true;
                        if (z) {
                            findItem = menu.findItem(C1761R.id.action_subreddit_info);
                            Intrinsics.m26843a(findItem, "infoItem");
                            findItem.setVisible(false);
                        }
                    }
                    subreddit = this.subredditModel;
                    if (subreddit == null) {
                        Intrinsics.m26842a();
                    }
                    if (Intrinsics.m26845a(subreddit.getUserIsModerator(), Boolean.valueOf(true))) {
                        findItem = menu.findItem(C1761R.id.action_mod_tools);
                        Intrinsics.m26843a(findItem, "modToolsItem");
                        findItem.setVisible(true);
                    }
                }
            }
            z = true;
            if (z) {
                subreddit = this.subredditModel;
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                descriptionHtml = subreddit.getDescription();
                if (descriptionHtml != null) {
                    if (descriptionHtml.length() == 0) {
                        z = false;
                        if (z) {
                            findItem = menu.findItem(C1761R.id.action_subreddit_info);
                            Intrinsics.m26843a(findItem, "infoItem");
                            findItem.setVisible(false);
                        }
                    }
                }
                z = true;
                if (z) {
                    findItem = menu.findItem(C1761R.id.action_subreddit_info);
                    Intrinsics.m26843a(findItem, "infoItem");
                    findItem.setVisible(false);
                }
            }
            subreddit = this.subredditModel;
            if (subreddit == null) {
                Intrinsics.m26842a();
            }
            if (Intrinsics.m26845a(subreddit.getUserIsModerator(), Boolean.valueOf(true))) {
                findItem = menu.findItem(C1761R.id.action_mod_tools);
                Intrinsics.m26843a(findItem, "modToolsItem");
                findItem.setVisible(true);
            }
        }
        Object findItem3 = menu.findItem(C1761R.id.action_contact_moderators);
        Intrinsics.m26843a(findItem3, "item");
        findItem = SessionManager.b();
        Intrinsics.m26843a(findItem, "SessionManager.getInstance()");
        findItem3.setVisible(findItem.c().isAnonymous() ^ true);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        int itemId = menuItem.getItemId();
        boolean z = false;
        Subreddit subreddit;
        switch (itemId) {
            case C1761R.id.action_contact_moderators:
                m29359a((Screen) Nav.m22591i(this.f40616N));
                return true;
            case C1761R.id.action_mod_tools:
                List asList;
                menuItem = this.subredditModel;
                String str = null;
                if ((menuItem != null ? menuItem.getKindWithId() : null) != null) {
                    menuItem = this.subredditModel;
                    if (menuItem != null) {
                        str = menuItem.getDisplayName();
                    }
                    if (str != null) {
                        ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20044c.f20068M);
                        subreddit = this.subredditModel;
                        if (subreddit == null) {
                            Intrinsics.m26842a();
                        }
                        str = subreddit.getKindWithId();
                        Subreddit subreddit2 = this.subredditModel;
                        if (subreddit2 == null) {
                            Intrinsics.m26842a();
                        }
                        String displayName = subreddit2.getDisplayName();
                        if (displayName == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                        Object toLowerCase = displayName.toLowerCase();
                        Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
                        ((ModEventBuilder) modEventBuilder.m21889a(str, toLowerCase)).m21891a();
                    }
                }
                if (TextUtils.equals((CharSequence) this.f40616N, Util.m24027f((int) C1761R.string.mod)) != null) {
                    asList = Arrays.asList(new ModToolsAction[]{ModToolsAction.f20930f, ModToolsAction.f20929e, ModToolsAction.f20927c, ModToolsAction.f20928d, ModToolsAction.f20926b});
                } else {
                    if (this.f40619R != null) {
                        menuItem = this.f40619R;
                        if (menuItem == null) {
                            Intrinsics.m26842a();
                        }
                        if (menuItem.getAll() != null) {
                            m29360a(Nav.m22570c(this.subredditModel), "ModToolsActionsScreenTag");
                            return true;
                        }
                    }
                    asList = (List) new ArrayList();
                    if (this.f40619R != null) {
                        ModPermissions modPermissions = this.f40619R;
                        if (modPermissions == null) {
                            Intrinsics.m26842a();
                        }
                        if (!modPermissions.getAccess()) {
                            asList.add(ModToolsAction.f20929e);
                            asList.add(ModToolsAction.f20927c);
                            asList.add(ModToolsAction.f20928d);
                            asList.add(ModToolsAction.f20930f);
                        }
                        modPermissions = this.f40619R;
                        if (modPermissions == null) {
                            Intrinsics.m26842a();
                        }
                        if (!modPermissions.getPosts()) {
                            asList.add(ModToolsAction.f20925a);
                        }
                        modPermissions = this.f40619R;
                        if (modPermissions == null) {
                            Intrinsics.m26842a();
                        }
                        if (!modPermissions.getMail()) {
                            asList.add(ModToolsAction.f20926b);
                        }
                    }
                    return true;
                }
                m29360a(Nav.m22545a(this.subredditModel, asList), "ModToolsActionsScreenTag");
                return true;
            case C1761R.id.action_search:
                if (this.subredditModel != null) {
                    m29359a((Screen) Nav.m22562a(this.f40616N, false));
                }
                return true;
            case C1761R.id.action_subreddit_info:
                if (this.subredditModel != null) {
                    subreddit = this.subredditModel;
                    if (subreddit == null) {
                        Intrinsics.m26842a();
                    }
                    CharSequence descriptionHtml = subreddit.getDescriptionHtml();
                    if (descriptionHtml == null || descriptionHtml.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        m29359a((Screen) Nav.m22565b(this.subredditModel));
                        return true;
                    }
                }
                break;
            case C1761R.id.action_subscribe:
            case C1761R.id.action_unsubscribe:
                if (itemId == C1761R.id.action_subscribe) {
                    z = true;
                }
                m42272f(z);
                return true;
            default:
                break;
        }
        return super.mo7201a(menuItem);
    }

    protected final void an() {
        if (this.C instanceof CardLinkAdapter) {
            ModUtil.m23832b();
            if (this.subredditModel != null) {
                Subreddit subreddit = this.subredditModel;
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                String kindWithId = subreddit.getKindWithId();
                Subreddit subreddit2 = this.subredditModel;
                if (subreddit2 == null) {
                    Intrinsics.m26842a();
                }
                ModUtil.m23830a(kindWithId, subreddit2.getDisplayName());
            }
            this.C.e();
        }
    }

    public AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        Object analyticsHeartbeatParams = super.getAnalyticsHeartbeatParams();
        Subreddit subreddit = this.subredditModel;
        String str = null;
        if ((subreddit != null ? subreddit.getKindWithId() : null) != null) {
            subreddit = this.subredditModel;
            if (subreddit != null) {
                str = subreddit.getDisplayName();
            }
            if (str != null) {
                subreddit = this.subredditModel;
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                String kindWithId = subreddit.getKindWithId();
                Subreddit subreddit2 = this.subredditModel;
                if (subreddit2 == null) {
                    Intrinsics.m26842a();
                }
                analyticsHeartbeatParams.m21905a(kindWithId, subreddit2.getDisplayName());
            }
        }
        Intrinsics.m26843a(analyticsHeartbeatParams, "params");
        return analyticsHeartbeatParams;
    }

    public ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        ScreenviewEventBuilder screenviewEventBuilder = null;
        if (this.subredditModel == null) {
            this.f40620S = true;
            return null;
        }
        ScreenviewEventBuilder analyticsScreenviewEvent = super.getAnalyticsScreenviewEvent();
        Subreddit subreddit = this.subredditModel;
        if (subreddit != null) {
            screenviewEventBuilder = subreddit.getKindWithId();
        }
        if (screenviewEventBuilder != null) {
            Subreddit subreddit2 = this.subredditModel;
            if (subreddit2 == null) {
                Intrinsics.m26842a();
            }
            String kindWithId = subreddit2.getKindWithId();
            subreddit = this.subredditModel;
            if (subreddit == null) {
                Intrinsics.m26842a();
            }
            analyticsScreenviewEvent.m21929a(kindWithId, subreddit.getDisplayName());
        }
        return analyticsScreenviewEvent;
    }

    public final String mo7451T() {
        Subreddit subreddit = this.subredditModel;
        if (subreddit != null) {
            String displayName = subreddit.getDisplayName();
            if (displayName != null) {
                return displayName;
            }
        }
        return this.f40616N;
    }

    protected final String mo7447x() {
        StringBuilder stringBuilder = new StringBuilder("r.");
        String T = mo7451T();
        if (T == null) {
            Intrinsics.m26842a();
        }
        stringBuilder.append(T);
        return stringBuilder.toString();
    }

    protected final SubredditAdMetadata mo7703R() {
        Subreddit subreddit = this.subredditModel;
        return subreddit != null ? new SubredditAdMetadata(subreddit.getOver18(), subreddit.getWhitelistStatus()) : null;
    }

    private final void m42272f(boolean z) {
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        b = b.c();
        if (b.isAnonymous()) {
            z = SessionManager.b();
            b = am_();
            if (b == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(b, "activity!!");
            z.a(ContextsKt.m24080d((Context) b), true);
            return;
        }
        Subreddit subreddit = this.subredditModel;
        if (subreddit != null) {
            if (z) {
                SubredditUtil.m23918a(subreddit, getAnalyticsScreenName());
                Snackbar a = Screens.m22629a(this, Util.m23960a((int) C1761R.string.fmt_now_subscribed, subreddit.getDisplayNamePrefixed()), -1);
                if (a != null) {
                    a.a();
                }
                this.subscribed = z;
                m42274g(true);
                aF();
                return;
            }
            Intrinsics.m26843a(b, Session.TYPE_SESSION);
            Object am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(am_, "activity!!");
            z = new RedditAlertDialog((Context) am_, true);
            Builder builder = z.f21113a;
            Object[] objArr = new Object[1];
            Subreddit subreddit2 = this.subredditModel;
            if (subreddit2 == null) {
                Intrinsics.m26842a();
            }
            objArr[0] = subreddit2.getDisplayNamePrefixed();
            builder.b(Util.m23960a((int) C1761R.string.prompt_confirm_unsubscribe, objArr)).b(Util.m24027f((int) C1761R.string.action_cancel), null).a(Util.m24027f((int) C1761R.string.action_unsubscribe), new C1893xe63bea3d(this, b));
            z.m23323a();
        }
    }

    private final void aF() {
        ViewsKt.m24103a((View) aI(), true);
        ListItemViewAttachListener listItemViewAttachListener = this.f40622U;
        if (listItemViewAttachListener != null) {
            listItemViewAttachListener.ab_();
        }
    }

    public final ScreenViewEvent mo7203N() {
        if (this.subredditModel == null) {
            return null;
        }
        ScreenViewEvent N = super.mo7203N();
        ScreenViewPayload screenViewPayload = (ScreenViewPayload) N.payload;
        Subreddit subreddit = this.subredditModel;
        if (subreddit == null) {
            Intrinsics.m26842a();
        }
        screenViewPayload.sr_id = subreddit.getId();
        screenViewPayload = (ScreenViewPayload) N.payload;
        subreddit = this.subredditModel;
        if (subreddit == null) {
            Intrinsics.m26842a();
        }
        screenViewPayload.sr_name = subreddit.getDisplayName();
        screenViewPayload = (ScreenViewPayload) N.payload;
        subreddit = this.subredditModel;
        if (subreddit == null) {
            Intrinsics.m26842a();
        }
        screenViewPayload.target_fullname = subreddit.getKindWithId();
        return N;
    }

    private final int aG() {
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        return ResourcesUtil.m22740i((Context) am_, C1761R.attr.rdt_default_key_color);
    }

    protected final void ax() {
        Subreddit subreddit = this.subredditModel;
        if (subreddit != null) {
            Object am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(am_, "activity!!");
            new PostOptionsScreen((Context) am_, subreddit).show();
        }
    }

    protected final void mo7694a(int i, int i2) {
        super.mo7694a(i, i2);
        i = this.f40617O;
        if (i == 0) {
            Intrinsics.m26842a();
        }
        Object obj = this.E;
        Intrinsics.m26843a(obj, "linkProvider");
        i2 = obj.b();
        Object obj2 = this.E;
        Intrinsics.m26843a(obj2, "linkProvider");
        i.m24179a(i2, obj2.c());
        aJ().m23417a();
    }

    private final void m42274g(boolean z) {
        Button ak = ak();
        if (ak == null) {
            Intrinsics.m26842a();
        }
        ak.setVisibility(0);
        if (z) {
            AnimUtil.m23639a((View) ak(), (Runnable) new LegacySubredditListingScreen$configureSubscribeButton$1(this));
        } else {
            aH();
        }
    }

    private final void aH() {
        int i;
        int intValue;
        Button ak = ak();
        if (ak == null) {
            Intrinsics.m26842a();
        }
        if (this.subscribed) {
            ak.setActivated(true);
            i = C1761R.string.action_subscribed;
            Integer num = this.f40627Z.f28924a;
            if (num == null) {
                Intrinsics.m26842a();
            }
            intValue = num.intValue();
        } else {
            ak.setActivated(false);
            i = C1761R.string.action_subscribe;
            Object context = ak.getContext();
            Intrinsics.m26843a(context, "context");
            intValue = ResourcesUtil.m22740i(context, C1761R.attr.rdt_light_text_color);
        }
        ak.setText(i);
        ak.setTextColor(intValue);
        TextView textView = ak;
        ColorStateList valueOf = ColorStateList.valueOf(intValue);
        Intrinsics.m26843a((Object) valueOf, "ColorStateList.valueOf(textColor)");
        TextViewsKt.m24096a(textView, valueOf);
        Integer num2 = this.f40627Z.f28924a;
        if (num2 == null) {
            Intrinsics.m26842a();
        }
        ak.setBackgroundTintList(ColorStateList.valueOf(num2.intValue()));
    }

    public final void mo4797a(int i) {
        this.E.b(i);
    }

    public final boolean mo4799b() {
        return v_();
    }

    public final Boolean mo4802e() {
        return Boolean.valueOf(this.subscribed);
    }

    public final int mo4796a() {
        Listing listing = this.y;
        if (listing != null) {
            List entities = listing.getEntities();
            if (entities != null) {
                return entities.size();
            }
        }
        return 0;
    }

    public final int mo4801d() {
        return m42263b(this.y);
    }

    private static int m42263b(Listing<Listable> listing) {
        if (listing != null) {
            listing = listing.getEntities();
            if (listing != null) {
                listing = listing.listIterator(listing.size());
                while (listing.hasPrevious()) {
                    Listable listable = (Listable) listing.previous();
                    com.reddit.datalibrary.frontpage.requests.models.v2.Listable.Companion companion = Listable.Companion;
                    if (com.reddit.datalibrary.frontpage.requests.models.v2.Listable.Companion.m21639a().contains(Integer.valueOf(listable.getListableType()))) {
                        return listing.nextIndex();
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    private final ViewGroup aI() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (FrameLayout) obj.findViewById(C1761R.id.subreddit_header_discovery_unit);
        Intrinsics.m26843a(obj, "rootView.subreddit_header_discovery_unit");
        return (ViewGroup) obj;
    }

    protected void mo7448y() {
        super.mo7448y();
        aJ().m23417a();
    }

    @SuppressLint({"CheckResult"})
    protected final Listing<Listable> mo7456a(Listing<Listable> listing) {
        Intrinsics.m26847b(listing, "listing");
        Listing a = super.mo7456a((Listing) listing);
        aK();
        DiscoveryUnitManager aJ = aJ();
        Intrinsics.m26843a((Object) a, "result");
        aJ().m23419a(a, aJ.m23415a(a.getEntities().size(), m42263b(a)));
        return a;
    }

    protected final void mo7457a(View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "outState");
        super.mo7457a(view, bundle);
        aJ().m23418a(bundle);
    }

    protected final void mo7700b(View view, Bundle bundle) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(bundle, "savedViewState");
        super.mo7700b(view, bundle);
        aJ().m23422b(bundle);
    }

    private final void aK() {
        if (ao()) {
            aJ().m23421b();
            GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = this.f40625X;
            if (generalCarouselCollectionPresentationModel != null) {
                m42257a(generalCarouselCollectionPresentationModel);
                return;
            }
            generalCarouselCollectionPresentationModel = this.f40625X;
            if (generalCarouselCollectionPresentationModel != null) {
                m42257a(generalCarouselCollectionPresentationModel);
            }
            Disposable disposable = this.f40621T;
            if (disposable != null) {
                disposable.mo5626a();
            }
            Single single = (Single) CollectionsKt___CollectionsKt.m41434e(aJ().m23414a("subreddit_header"));
            if (single != null) {
                Object map = single.map(C2342xf922fff5.f29056a);
                Intrinsics.m26843a(map, "unit\n        .map {\n    …sentationModel>\n        }");
                this.f40621T = SinglesKt.m24094b(map, FrontpageApplication.m28875k().mo4633u()).subscribe((Consumer) new C2343xf922fff6(this));
            }
        }
    }

    private final void m42257a(GeneralCarouselCollectionPresentationModel<? extends ICarouselItemPresentationModel> generalCarouselCollectionPresentationModel) {
        this.f40625X = generalCarouselCollectionPresentationModel;
        CarouselAnalytics d = FrontpageApplication.m28875k().mo4616d();
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        int dimensionPixelOffset = obj.getResources().getDimensionPixelOffset(C1761R.dimen.single_pad);
        ViewGroup aI = aI();
        Object system = Resources.getSystem();
        Intrinsics.m26843a(system, "Resources.getSystem()");
        int i = system.getDisplayMetrics().widthPixels;
        com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion companion = SmallCarouselViewHolder.f37244b;
        SmallCarouselViewHolder a = com.reddit.frontpage.ui.carousel.SmallCarouselViewHolder.Companion.m23328a(aI, i, true, new LegacySubredditListingScreen$bindSubscriptionDiscoveryUnit$1(this, d, generalCarouselCollectionPresentationModel));
        a.m34914a(generalCarouselCollectionPresentationModel, null, null, new C2899x406f3747(this, generalCarouselCollectionPresentationModel, d), LegacySubredditListingScreen$bindSubscriptionDiscoveryUnit$2$2.f37278a, null);
        this.f40622U = a;
        View view = aI;
        ((ConstraintLayout) view.findViewById(C1761R.id.carousel_container)).setPadding(0, dimensionPixelOffset, 0, 0);
        CarouselRecyclerView carouselRecyclerView = (CarouselRecyclerView) view.findViewById(C1761R.id.carousel_recyclerview);
        carouselRecyclerView.setClipToPadding(false);
        carouselRecyclerView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
    }

    protected boolean ao() {
        return this.f40626Y;
    }

    public final void mo7206a(LinkFlair linkFlair, String str, Thing thing) {
        JobManager a = RedditJobManager.a();
        if (a != null) {
            Object b = SessionManager.b();
            Intrinsics.m26843a(b, "SessionManager.getInstance()");
            b = b.c();
            Intrinsics.m26843a(b, "SessionManager.getInstance().activeSession");
            if (thing == null) {
                Intrinsics.m26842a();
            }
            a.a(new UpdatePostFlairJob(b, linkFlair, str, thing.getName()));
        }
        if (TextUtils.isEmpty(str)) {
            str = linkFlair != null ? linkFlair.getText() : "";
            Intrinsics.m26843a((Object) str, "if (selectedLinkFlair !=…  } else {\n      \"\"\n    }");
        } else if (str == null) {
            Intrinsics.m26842a();
        }
        ModUtil.m23824a().m30462g(thing != null ? thing.getName() : null, Boolean.valueOf(TextUtils.isEmpty(str)));
        linkFlair = LinkEditCache.getLinkFlairEditCache();
        if (thing == null) {
            Intrinsics.m26842a();
        }
        linkFlair.put(thing.getName(), str);
    }

    public final void mo7384a(String str, int i) {
        Intrinsics.m26847b(str, "username");
        str = Screens.m22629a(this, Util.m23960a(i, str), 0);
        if (str != null) {
            str.a();
        }
    }

    public final void onEventMainThread(ViewModeOptionSelection viewModeOptionSelection) {
        Intrinsics.m26847b(viewModeOptionSelection, "viewModeSelection");
        if (viewModeOptionSelection.f20997a == this) {
            EventBus.getDefault().removeStickyEvent((Object) viewModeOptionSelection);
            if (this.f40617O != null) {
                ListingFilterBarView listingFilterBarView = this.f40617O;
                if (listingFilterBarView == null) {
                    Intrinsics.m26842a();
                }
                listingFilterBarView.setViewMode(viewModeOptionSelection.f20998b);
            }
            this.H = viewModeOptionSelection.f20998b;
            ab();
            this.w.e();
            m41008e(viewModeOptionSelection.f20998b == ListingViewMode.f20613b ? true : null);
        }
    }

    public final Integer mo4954w() {
        return this.f40627Z.f28924a;
    }

    public final Integer mo4949M() {
        return this.f40627Z.f28925b;
    }

    public static final /* synthetic */ void m42258a(LegacySubredditListingScreen legacySubredditListingScreen) {
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = legacySubredditListingScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23291a((Context) am_, (int) C1761R.string.title_subreddit_error, (int) C1761R.string.error_message_subreddit, (int) C1761R.string.error_submessage_subreddit, (Function0) new LegacySubredditListingScreen$showCommunityError$1(legacySubredditListingScreen)).m23323a();
    }

    public static final /* synthetic */ void m42261a(LegacySubredditListingScreen legacySubredditListingScreen, String str) {
        FrontpageSettings a = FrontpageSettings.a();
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        String username = b.c().getUsername();
        if (!a.l(username)) {
            legacySubredditListingScreen.am_();
            FrontpageSettings.m(str);
            if (a.l(username) != null) {
                InstabugUtil.m23734b();
                InstabugUtil.m23733a(legacySubredditListingScreen.am_());
            }
        }
    }
}
