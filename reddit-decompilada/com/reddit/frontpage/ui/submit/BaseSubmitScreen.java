package com.reddit.frontpage.ui.submit;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitResponse.LinkResult;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.datalibrary.frontpage.service.api.SubmitService.SubmitErrorEvent;
import com.reddit.datalibrary.frontpage.service.api.SubmitService.SubmitResultEvent;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen.LinkFlairSelectedListener;
import com.reddit.frontpage.ui.submit.search.SubredditSelectEvent;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.PermissionUtil.Permission;
import com.reddit.frontpage.util.RichTextUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.RulesClickListener;
import com.reddit.frontpage.widgets.submit.SubredditLocationSelectView.SelectionListener;
import de.greenrobot.event.EventBus;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\b \u0018\u0000 ¡\u00012\u00020\u00012\u00020\u0002:\u0002¡\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0014J\b\u0010g\u001a\u00020dH\u0014J\u000f\u0010h\u001a\u0004\u0018\u00010dH\u0004¢\u0006\u0002\u0010iJ\b\u0010j\u001a\u00020kH\u0016J\n\u0010l\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010m\u001a\u00020`H\u0002J\b\u0010n\u001a\u00020`H\u0016J\b\u0010o\u001a\u00020`H&J\b\u0010p\u001a\u00020dH\u0002J\b\u0010q\u001a\u00020%H\u0016J\u0018\u0010r\u001a\u00020d2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020vH\u0016J\u0018\u0010w\u001a\u00020x2\u0006\u0010u\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0016J\u0010\u0010|\u001a\u00020d2\u0006\u0010}\u001a\u00020xH\u0016J\u000f\u0010~\u001a\u00020d2\u0007\u0010\u001a\u00030\u0001J\u000f\u0010~\u001a\u00020d2\u0007\u0010\u001a\u00030\u0001J\u000f\u0010~\u001a\u00020d2\u0007\u0010\u001a\u00030\u0001J\u000e\u0010~\u001a\u00020d2\u0006\u0010\u001a\u00020CJ+\u0010\u0001\u001a\u00020d2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020%2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020\u000fH\u0014J\u0012\u0010\u0001\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020\u000fH\u0014J2\u0010\u0001\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020`2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020dH&J\t\u0010\u0001\u001a\u00020dH\u0002J\u0007\u0010\u0001\u001a\u00020dJ\t\u0010\u0001\u001a\u00020dH\u0002J\t\u0010\u0001\u001a\u00020dH$J\u001e\u0010\u0001\u001a\u00020d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\t\u0010\u0001\u001a\u00020dH\u0002J\t\u0010\u0001\u001a\u00020dH\u0016J\t\u0010\u0001\u001a\u00020%H\u0016J\t\u0010\u0001\u001a\u00020dH\u0002J\t\u0010 \u0001\u001a\u00020dH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R \u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8TX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8DX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u0010.\u001a\u0004\u0018\u00010\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0011R \u00100\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u001dR \u00103\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u001dR\u001e\u00106\u001a\u00020)8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010+\"\u0004\b8\u0010-R \u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0011\"\u0004\bA\u0010\u001dR \u0010B\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u001dR\u0016\u0010K\u001a\u0004\u0018\u00010\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0011R\u001a\u0010M\u001a\u00020NX.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010!\"\u0004\bU\u0010#R\u001a\u0010V\u001a\u00020WX.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R \u0010\\\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u001dR\u0012\u0010_\u001a\u00020`X¦\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006¢\u0001"}, d2 = {"Lcom/reddit/frontpage/ui/submit/BaseSubmitScreen;", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/ui/submit/LinkFlairSelectScreen$LinkFlairSelectedListener;", "()V", "dialog", "Landroid/support/v7/app/AlertDialog;", "flair", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "getFlair", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "setFlair", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;)V", "flairDisposable", "Lio/reactivex/disposables/Disposable;", "flairId", "", "getFlairId", "()Ljava/lang/String;", "flairList", "", "getFlairList", "()Ljava/util/List;", "setFlairList", "(Ljava/util/List;)V", "flairText", "getFlairText", "flairTextEdit", "getFlairTextEdit", "setFlairTextEdit", "(Ljava/lang/String;)V", "flairTextView", "Landroid/widget/TextView;", "getFlairTextView", "()Landroid/widget/TextView;", "setFlairTextView", "(Landroid/widget/TextView;)V", "isFormValid", "", "()Z", "isPromoter", "latitude", "", "getLatitude", "()D", "setLatitude", "(D)V", "location", "getLocation", "locationKeyColor", "getLocationKeyColor", "setLocationKeyColor", "locationName", "getLocationName", "setLocationName", "longitude", "getLongitude", "setLongitude", "originSubreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "getOriginSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "setOriginSubreddit", "(Lcom/reddit/frontpage/domain/model/Subreddit;)V", "requestId", "getRequestId", "setRequestId", "selectedSubredditData", "Lcom/reddit/frontpage/ui/submit/search/SubredditSelectEvent;", "getSelectedSubredditData", "()Lcom/reddit/frontpage/ui/submit/search/SubredditSelectEvent;", "setSelectedSubredditData", "(Lcom/reddit/frontpage/ui/submit/search/SubredditSelectEvent;)V", "submitRequestId", "getSubmitRequestId", "setSubmitRequestId", "submitSubredditName", "getSubmitSubredditName", "submitTitleView", "Landroid/widget/EditText;", "getSubmitTitleView", "()Landroid/widget/EditText;", "setSubmitTitleView", "(Landroid/widget/EditText;)V", "submitView", "getSubmitView", "setSubmitView", "subredditLocationSelectView", "Lcom/reddit/frontpage/widgets/submit/SubredditLocationSelectView;", "getSubredditLocationSelectView", "()Lcom/reddit/frontpage/widgets/submit/SubredditLocationSelectView;", "setSubredditLocationSelectView", "(Lcom/reddit/frontpage/widgets/submit/SubredditLocationSelectView;)V", "subredditSelectRequestId", "getSubredditSelectRequestId", "setSubredditSelectRequestId", "title", "", "getTitle", "()I", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "configureNavigation", "dismissDialog", "()Lkotlin/Unit;", "getAnalyticsHeartbeatParams", "Lcom/reddit/frontpage/commons/analytics/events/v2/AnalyticsHeartbeatParams;", "getAnalyticsPageType", "getDefaultKeyColor", "getDefaultScreenPosition", "getLayoutId", "navigateToLocationSearchScreen", "onBackPressed", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "view", "onEventMainThread", "event", "Lcom/reddit/datalibrary/frontpage/service/api/SubmitService$SubmitErrorEvent;", "Lcom/reddit/datalibrary/frontpage/service/api/SubmitService$SubmitResultEvent;", "Lcom/reddit/frontpage/ui/submit/location/LocationSearchScreen$LocationSearchResultEvent;", "onLinkFlairSelected", "selectedLinkFlair", "selectedLinkFlairEdit", "thing", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPermissionDenied", "permission", "onPermissionGranted", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSubmit", "permittedNavigateToLocationScreen", "refreshRequestId", "resetFlair", "setEditTextHints", "setFlairText", "editedFlairText", "setupFlair", "setupTitleEditText", "shouldEnableSubmitButton", "submit", "updateSubmitButton", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
public abstract class BaseSubmitScreen extends BaseScreen implements LinkFlairSelectedListener {
    private static final String f39329C = "post_submit";
    private static final int f39330D = 16;
    private static final String f39331E = "post_location_tapped";
    private static final String f39332F = "location_permission_accepted";
    private static final String f39333G = "location_permission_declined";
    private static final String f39334H = "post_location_removed";
    private static final String f39335M = "post_location_added";
    private static final String f39336N = "post_flair_added";
    private static final long f39337O = 50;
    public static final Companion f39338z = new Companion();
    private Disposable f39339A;
    private AlertDialog f39340B;
    @State(ParcelerBundler.class)
    LinkFlair flair;
    @State(ParcelerBundler.class)
    List<LinkFlair> flairList;
    @State
    String flairTextEdit;
    @State
    double latitude;
    @State
    String locationKeyColor;
    @State
    String locationName;
    @State
    double longitude;
    @State
    Subreddit originSubreddit;
    @State
    String requestId = UUID.randomUUID().toString();
    @State(ParcelerBundler.class)
    SubredditSelectEvent selectedSubredditData;
    @State
    String submitRequestId = UUID.randomUUID().toString();
    @State
    String subredditSelectRequestId;
    protected SubredditLocationSelectView f39341v;
    protected EditText f39342w;
    protected TextView f39343x;
    TextView f39344y;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0018XD¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/ui/submit/BaseSubmitScreen$Companion;", "", "()V", "ANALYTICS_PAGE_TYPE", "", "getANALYTICS_PAGE_TYPE", "()Ljava/lang/String;", "LOCATION_ADDED_CONTROL_NAME", "getLOCATION_ADDED_CONTROL_NAME", "LOCATION_REMOVED_CONTROL_NAME", "getLOCATION_REMOVED_CONTROL_NAME", "PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION", "", "getPERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION", "()I", "PERMISSION_DENIED_CONTROL_NAME", "getPERMISSION_DENIED_CONTROL_NAME", "PERMISSION_GRANTED_CONTROL_NAME", "getPERMISSION_GRANTED_CONTROL_NAME", "SELECT_LOCATION_CONTROL_NAME", "getSELECT_LOCATION_CONTROL_NAME", "SELECT_POST_FLAIR_CONTROL_NAME", "getSELECT_POST_FLAIR_CONTROL_NAME", "SUBREDDIT_NAME_TEXT_CHANGE_DEBOUNCE", "", "getSUBREDDIT_NAME_TEXT_CHANGE_DEBOUNCE", "()J", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BaseSubmitScreen.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public abstract void mo7477U();

    protected abstract void mo7478V();

    public final int mo7143u() {
        return 2;
    }

    public abstract int mo7480y();

    protected final SubredditLocationSelectView m39542w() {
        SubredditLocationSelectView subredditLocationSelectView = this.f39341v;
        if (subredditLocationSelectView == null) {
            Intrinsics.m26844a("subredditLocationSelectView");
        }
        return subredditLocationSelectView;
    }

    protected final EditText m39543x() {
        EditText editText = this.f39342w;
        if (editText == null) {
            Intrinsics.m26844a("submitTitleView");
        }
        return editText;
    }

    public final void m39537a(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.submitRequestId = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final java.lang.String m39519O() {
        /*
        r1 = this;
        r0 = r1.selectedSubredditData;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r0.subredditName;
        if (r0 != 0) goto L_0x0012;
    L_0x0008:
        r0 = r1.originSubreddit;
        if (r0 == 0) goto L_0x0011;
    L_0x000c:
        r0 = r0.getDisplayName();
        return r0;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.submit.BaseSubmitScreen.O():java.lang.String");
    }

    protected final boolean m39520P() {
        if (this.originSubreddit != null || this.selectedSubredditData == null) {
            return false;
        }
        SubredditSelectEvent subredditSelectEvent = this.selectedSubredditData;
        if (subredditSelectEvent == null) {
            Intrinsics.m26842a();
        }
        return SubredditUtil.m23920a((CharSequence) subredditSelectEvent.subredditName);
    }

    protected boolean mo7476Q() {
        if (m39519O() != null) {
            return true;
        }
        mo7204a((CharSequence) Util.m24027f((int) C1761R.string.error_pick_subreddit));
        return false;
    }

    protected final String m39522R() {
        String str = this.flairTextEdit;
        if (str == null) {
            LinkFlair linkFlair = this.flair;
            if (linkFlair != null) {
                return linkFlair.getText();
            }
            str = null;
        }
        return str;
    }

    protected final String m39523S() {
        LinkFlair linkFlair = this.flair;
        return linkFlair != null ? linkFlair.getId() : null;
    }

    protected final String m39524T() {
        SubredditLocationSelectView subredditLocationSelectView = this.f39341v;
        if (subredditLocationSelectView == null) {
            Intrinsics.m26844a("subredditLocationSelectView");
        }
        return subredditLocationSelectView.getLocation();
    }

    public View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Flowable observeOn;
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        layoutInflater = super.mo7139a(layoutInflater, viewGroup);
        Object findViewById = layoutInflater.findViewById(C1761R.id.submit_subreddit);
        Intrinsics.m26843a(findViewById, "view.findViewById(R.id.submit_subreddit)");
        this.f39341v = (SubredditLocationSelectView) findViewById;
        findViewById = layoutInflater.findViewById(C1761R.id.submit_title);
        Intrinsics.m26843a(findViewById, "view.findViewById(R.id.submit_title)");
        this.f39342w = (EditText) findViewById;
        Object findViewById2 = layoutInflater.findViewById(C1761R.id.flair_text);
        Intrinsics.m26843a(findViewById2, "view.findViewById(R.id.flair_text)");
        this.f39343x = (TextView) findViewById2;
        n();
        mo7481Z();
        if (this.originSubreddit != null) {
            layoutInflater = this.f39341v;
            if (layoutInflater == null) {
                Intrinsics.m26844a("subredditLocationSelectView");
            }
            layoutInflater.setSubreddit(this.originSubreddit);
        } else if (this.selectedSubredditData != null) {
            layoutInflater = this.f39341v;
            if (layoutInflater == null) {
                Intrinsics.m26844a("subredditLocationSelectView");
            }
            viewGroup = this.selectedSubredditData;
            if (viewGroup == null) {
                Intrinsics.m26842a();
            }
            viewGroup = viewGroup.subredditName;
            SubredditSelectEvent subredditSelectEvent = this.selectedSubredditData;
            if (subredditSelectEvent == null) {
                Intrinsics.m26842a();
            }
            String str = subredditSelectEvent.icon;
            SubredditSelectEvent subredditSelectEvent2 = this.selectedSubredditData;
            if (subredditSelectEvent2 == null) {
                Intrinsics.m26842a();
            }
            layoutInflater.m30538a(viewGroup, str, subredditSelectEvent2.keyColor);
        }
        layoutInflater = this.f39341v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("subredditLocationSelectView");
        }
        layoutInflater.setSelectionListener((SelectionListener) new BaseSubmitScreen$onCreateView$1(this));
        CharSequence charSequence = (CharSequence) this.locationName;
        if (charSequence != null) {
            if (charSequence.length() != null) {
                layoutInflater = null;
                if (layoutInflater == null) {
                    layoutInflater = this.f39341v;
                    if (layoutInflater == null) {
                        Intrinsics.m26844a("subredditLocationSelectView");
                    }
                    layoutInflater.m30537a(this.locationName, this.locationKeyColor);
                }
                layoutInflater = this.f39341v;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("subredditLocationSelectView");
                }
                layoutInflater.setOnRulesClickListener((RulesClickListener) new BaseSubmitScreen$onCreateView$2(this));
                layoutInflater = this.f39341v;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("subredditLocationSelectView");
                }
                layoutInflater = layoutInflater.m30539b().debounce(f39337O, TimeUnit.MILLISECONDS);
                viewGroup = (Function1) BaseSubmitScreen$setupFlair$1.f37388a;
                if (viewGroup != null) {
                    viewGroup = new BaseSubmitScreenKt$sam$Function$111344f3(viewGroup);
                }
                observeOn = layoutInflater.map((Function) viewGroup).distinctUntilChanged().switchMap((Function) BaseSubmitScreen$setupFlair$2.f29305a).observeOn(SchedulerProvider.m23887c());
                Intrinsics.m26843a((Object) observeOn, "subredditLocationSelectV…n(SchedulerProvider.ui())");
                this.f39339A = SubscribersKt.m26768a(observeOn, (Function1) new BaseSubmitScreen$setupFlair$3(this), (Function1) new BaseSubmitScreen$setupFlair$4(this));
                layoutInflater = this.f39343x;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("flairTextView");
                }
                layoutInflater.setOnClickListener((OnClickListener) new BaseSubmitScreen$setupFlair$5(this));
                mo7478V();
                findViewById2 = this.K;
                Intrinsics.m26843a(findViewById2, "rootView");
                return findViewById2;
            }
        }
        layoutInflater = true;
        if (layoutInflater == null) {
            layoutInflater = this.f39341v;
            if (layoutInflater == null) {
                Intrinsics.m26844a("subredditLocationSelectView");
            }
            layoutInflater.m30537a(this.locationName, this.locationKeyColor);
        }
        layoutInflater = this.f39341v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("subredditLocationSelectView");
        }
        layoutInflater.setOnRulesClickListener((RulesClickListener) new BaseSubmitScreen$onCreateView$2(this));
        layoutInflater = this.f39341v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("subredditLocationSelectView");
        }
        layoutInflater = layoutInflater.m30539b().debounce(f39337O, TimeUnit.MILLISECONDS);
        viewGroup = (Function1) BaseSubmitScreen$setupFlair$1.f37388a;
        if (viewGroup != null) {
            viewGroup = new BaseSubmitScreenKt$sam$Function$111344f3(viewGroup);
        }
        observeOn = layoutInflater.map((Function) viewGroup).distinctUntilChanged().switchMap((Function) BaseSubmitScreen$setupFlair$2.f29305a).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "subredditLocationSelectV…n(SchedulerProvider.ui())");
        this.f39339A = SubscribersKt.m26768a(observeOn, (Function1) new BaseSubmitScreen$setupFlair$3(this), (Function1) new BaseSubmitScreen$setupFlair$4(this));
        layoutInflater = this.f39343x;
        if (layoutInflater == null) {
            Intrinsics.m26844a("flairTextView");
        }
        layoutInflater.setOnClickListener((OnClickListener) new BaseSubmitScreen$setupFlair$5(this));
        mo7478V();
        findViewById2 = this.K;
        Intrinsics.m26843a(findViewById2, "rootView");
        return findViewById2;
    }

    public final void mo6987a(View view) {
        Intrinsics.m26847b(view, "view");
        Disposable disposable = this.f39339A;
        if (disposable != null) {
            disposable.mo5626a();
        }
        super.mo6987a(view);
    }

    public final void m39534a(Menu menu, MenuInflater menuInflater) {
        Resources ao_;
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        menuInflater.inflate(C1761R.menu.menu_submit, menu);
        menu = menu.findItem(C1761R.id.action_submit);
        if (menu != null) {
            menuInflater = menu.getActionView();
            if (menuInflater != null) {
                menuInflater = (TextView) menuInflater.findViewById(C1761R.id.menu_item_text);
                this.f39344y = menuInflater;
                menuInflater = this.f39344y;
                if (menuInflater != null) {
                    ao_ = ao_();
                    if (ao_ == null) {
                        Intrinsics.m26842a();
                    }
                    menuInflater.setText(ao_.getString(C1761R.string.action_post));
                }
                if (menu != null) {
                    menuInflater = menu.getActionView();
                    if (menuInflater != null) {
                        menuInflater.setOnClickListener(new BaseSubmitScreen$onCreateOptionsMenu$1(this, menu));
                    }
                }
                mo7479W();
            }
        }
        menuInflater = null;
        this.f39344y = menuInflater;
        menuInflater = this.f39344y;
        if (menuInflater != null) {
            ao_ = ao_();
            if (ao_ == null) {
                Intrinsics.m26842a();
            }
            menuInflater.setText(ao_.getString(C1761R.string.action_post));
        }
        if (menu != null) {
            menuInflater = menu.getActionView();
            if (menuInflater != null) {
                menuInflater.setOnClickListener(new BaseSubmitScreen$onCreateOptionsMenu$1(this, menu));
            }
        }
        mo7479W();
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        menuItem = menuItem.getItemId();
        if (menuItem == 16908332) {
            ai_();
            return true;
        } else if (menuItem != C1761R.id.action_submit) {
            return false;
        } else {
            if (NetworkUtil.m23842b() == null) {
                Screens.m22628a((Screen) this, (int) C1761R.string.error_no_internet).a();
            } else if (mo7476Q() != null) {
                menuItem = RedditAlertDialog.f21112b;
                Object am_ = am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                Intrinsics.m26843a(am_, "activity!!");
                menuItem = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23286a((Context) am_, (int) C1761R.string.title_submitting, false);
                menuItem.setOnDismissListener(new BaseSubmitScreen$submit$$inlined$apply$lambda$1(this));
                menuItem.setOnCancelListener(new BaseSubmitScreen$submit$$inlined$apply$lambda$2(this));
                ScreenUtil.m23890b(am_());
                menuItem.show();
                this.f39340B = menuItem;
                mo7477U();
            }
            return true;
        }
    }

    public boolean mo6986J() {
        Activity am_ = am_();
        Util.m23972a(am_ != null ? am_.getCurrentFocus() : null);
        return false;
    }

    public final void m39532a(int i, String[] strArr, int[] iArr) {
        Intrinsics.m26847b(strArr, "permissions");
        Intrinsics.m26847b(iArr, "grantResults");
        super.a(i, strArr, iArr);
        int length = strArr.length;
        for (i = 0; i < length; i++) {
            Permission a = PermissionUtil.m23860a(strArr[i]);
            String str;
            if (iArr[i] == 0) {
                if (a == null) {
                    Intrinsics.m26842a();
                }
                str = a.f21782d;
                Intrinsics.m26843a((Object) str, "permission!!.permission");
                mo7485b(str);
            } else {
                Activity am_ = am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                if (a == null) {
                    Intrinsics.m26842a();
                }
                if (PermissionUtil.m23863a(am_, a)) {
                    am_ = am_();
                    if (am_ == null) {
                        Intrinsics.m26842a();
                    }
                    PermissionUtil.m23868b(am_, a);
                } else {
                    str = a.f21782d;
                    Intrinsics.m26843a((Object) str, "permission.permission");
                    mo7241c(str);
                }
            }
        }
    }

    public void mo7479W() {
        boolean X = mo7487X();
        TextView textView = this.f39344y;
        if (textView != null) {
            textView.setEnabled(X);
        }
    }

    public boolean mo7487X() {
        if (this.f39344y == null) {
            return false;
        }
        EditText editText = this.f39342w;
        if (editText == null) {
            Intrinsics.m26844a("submitTitleView");
        }
        Object text = editText.getText();
        Intrinsics.m26843a(text, "submitTitleView.text");
        if (!StringsKt__StringsJVMKt.m41943a((CharSequence) text)) {
            boolean z;
            CharSequence O = m39519O();
            if (O != null) {
                if (O.length() != 0) {
                    z = false;
                    if (z) {
                        return true;
                    }
                }
            }
            z = true;
            if (z) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onEventMainThread(com.reddit.frontpage.ui.submit.location.LocationSearchScreen.LocationSearchResultEvent r5) {
        /*
        r4 = this;
        r0 = "event";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r0 = r5.f29350a;
        r1 = r4.requestId;
        r0 = kotlin.jvm.internal.Intrinsics.m26845a(r0, r1);
        r1 = 1;
        r0 = r0 ^ r1;
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r0 = de.greenrobot.event.EventBus.getDefault();
        r0.removeStickyEvent(r5);
        r0 = r5.f29351b;
        r0 = r0.f20304a;
        r2 = 2131886999; // 0x7f120397 float:1.9408593E38 double:1.053292127E-314;
        r2 = com.reddit.frontpage.util.Util.m24027f(r2);
        r0 = kotlin.jvm.internal.Intrinsics.m26845a(r0, r2);
        r2 = r5.f29351b;
        r2 = r2.f20304a;
        r3 = "event.locationDistance.name";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r3);
        r2 = (java.lang.CharSequence) r2;
        r2 = r2.length();
        if (r2 != 0) goto L_0x003a;
    L_0x0039:
        goto L_0x003b;
    L_0x003a:
        r1 = 0;
    L_0x003b:
        if (r1 != 0) goto L_0x0092;
    L_0x003d:
        if (r0 == 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0092;
    L_0x0040:
        r5 = r5.f29351b;
        r0 = r5.f20304a;
        r4.locationName = r0;
        r0 = r5.f20305b;
        r1 = "it.latitude";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r0 = r0.doubleValue();
        r4.latitude = r0;
        r5 = r5.f20306c;
        r0 = "it.longitude";
        kotlin.jvm.internal.Intrinsics.m26843a(r5, r0);
        r0 = r5.doubleValue();
        r4.longitude = r0;
        r5 = r4.originSubreddit;
        if (r5 == 0) goto L_0x006a;
    L_0x0064:
        r5 = r5.getKeyColor();
        if (r5 != 0) goto L_0x0072;
    L_0x006a:
        r5 = r4.al();
        r5 = com.reddit.frontpage.util.Util.m23995b(r5);
    L_0x0072:
        r4.locationKeyColor = r5;
        r5 = com.reddit.frontpage.commons.analytics.AppAnalytics.m21858b();
        r0 = r4.getAnalyticsScreenName();
        r5 = r5.m21824a(r0);
        r0 = f39335M;
        r5 = r5.m21826b(r0);
        r0 = r4.locationName;
        r5 = r5.m21831g(r0);
        r5.m21825a();
        goto L_0x00b5;
    L_0x0092:
        r5 = 0;
        r4.locationName = r5;
        r5 = 2131099840; // 0x7f0600c0 float:1.7812045E38 double:1.052903219E-314;
        r5 = com.reddit.frontpage.util.Util.m24027f(r5);
        r4.locationKeyColor = r5;
        r5 = com.reddit.frontpage.commons.analytics.AppAnalytics.m21858b();
        r0 = r4.getAnalyticsScreenName();
        r5 = r5.m21824a(r0);
        r0 = f39334H;
        r5 = r5.m21826b(r0);
        r5.m21825a();
    L_0x00b5:
        r5 = r4.f39341v;
        if (r5 != 0) goto L_0x00be;
    L_0x00b9:
        r0 = "subredditLocationSelectView";
        kotlin.jvm.internal.Intrinsics.m26844a(r0);
    L_0x00be:
        r0 = r4.locationName;
        r1 = r4.locationKeyColor;
        r5.m30537a(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.submit.BaseSubmitScreen.onEventMainThread(com.reddit.frontpage.ui.submit.location.LocationSearchScreen$LocationSearchResultEvent):void");
    }

    public final void onEventMainThread(SubredditSelectEvent subredditSelectEvent) {
        Intrinsics.m26847b(subredditSelectEvent, "event");
        int i = 1;
        if ((Intrinsics.m26845a(subredditSelectEvent.requestId, this.subredditSelectRequestId) ^ 1) == 0) {
            EventBus.getDefault().removeStickyEvent((Object) subredditSelectEvent);
            if (this.originSubreddit != null) {
                Subreddit subreddit = this.originSubreddit;
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                if ((Intrinsics.m26845a(subreddit.getDisplayName(), subredditSelectEvent.subredditName) ^ 1) != 0) {
                    ak();
                }
            }
            Timber.b("Selected community for post: %s", new Object[]{subredditSelectEvent});
            this.originSubreddit = null;
            this.selectedSubredditData = subredditSelectEvent;
            SubredditLocationSelectView subredditLocationSelectView = this.f39341v;
            if (subredditLocationSelectView == null) {
                Intrinsics.m26844a("subredditLocationSelectView");
            }
            subredditLocationSelectView.m30538a(subredditSelectEvent.subredditName, subredditSelectEvent.icon, subredditSelectEvent.keyColor);
            boolean a = Intrinsics.m26845a(this.locationName, Util.m24027f((int) C1761R.string.none_location));
            CharSequence charSequence = this.locationName;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    i = 0;
                }
            }
            if (i == 0) {
                if (!a) {
                    subredditSelectEvent = subredditSelectEvent.keyColor;
                    if (subredditSelectEvent == null) {
                        subredditSelectEvent = Util.m23995b(al());
                    }
                    this.locationKeyColor = subredditSelectEvent;
                    subredditSelectEvent = this.f39341v;
                    if (subredditSelectEvent == null) {
                        Intrinsics.m26844a("subredditLocationSelectView");
                    }
                    subredditSelectEvent.m30537a(this.locationName, this.locationKeyColor);
                    mo7478V();
                }
            }
            Object am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(am_, "activity!!");
            subredditSelectEvent = Util.m23995b(ResourcesUtil.m22740i((Context) am_, C1761R.attr.rdt_action_icon_color));
            this.locationKeyColor = subredditSelectEvent;
            subredditSelectEvent = this.f39341v;
            if (subredditSelectEvent == null) {
                Intrinsics.m26844a("subredditLocationSelectView");
            }
            subredditSelectEvent.m30537a(this.locationName, this.locationKeyColor);
            mo7478V();
        }
    }

    public final void onEventMainThread(SubmitResultEvent submitResultEvent) {
        Intrinsics.m26847b(submitResultEvent, "event");
        if ((Intrinsics.m26845a(submitResultEvent.requestId, this.submitRequestId) ^ 1) == 0) {
            m39529Y();
            boolean a = Intrinsics.m26845a(Screens.m22630a(this), (Object) this);
            if (!a) {
                ai_();
            }
            Screen screen = null;
            if (submitResultEvent.response != null) {
                Object obj = submitResultEvent.response.json.data;
                Intrinsics.m26843a(obj, "event.response.json.data");
                screen = Nav.m22557a(((LinkResult) obj).a(), null, null);
            } else if (submitResultEvent.subreddit != null && SubredditUtil.m23920a((CharSequence) submitResultEvent.subreddit)) {
                screen = Nav.m22594j(SubredditUtil.m23921b(submitResultEvent.subreddit));
            } else if (!(submitResultEvent.subreddit == null || SubredditUtil.m23920a((CharSequence) submitResultEvent.subreddit))) {
                screen = Nav.m22566b(SubredditUtil.m23912a(submitResultEvent.subreddit));
            }
            if (screen == null) {
                return;
            }
            if (!a || (am_() instanceof MainActivity) == null) {
                m29359a(screen);
                return;
            }
            submitResultEvent = am_();
            if (submitResultEvent == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.MainActivity");
            }
            ((MainActivity) submitResultEvent).m42709a(screen);
        }
    }

    public final void onEventMainThread(SubmitErrorEvent submitErrorEvent) {
        Intrinsics.m26847b(submitErrorEvent, "event");
        if ((Intrinsics.m26845a(submitErrorEvent.requestId, this.submitRequestId) ^ 1) == 0) {
            m39529Y();
            Activity am_ = am_();
            if (am_ == null) {
                Intrinsics.m26842a();
            }
            mo7204a((CharSequence) am_.getString(C1761R.string.error_network_error));
            Timber.c((Throwable) submitErrorEvent.exception, "Submit error. Showing fallback error message", new Object[0]);
        }
    }

    protected final void au() {
        Toolbar at = at();
        Activity am_ = am_();
        if (am_ == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.app.AppCompatActivity");
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_;
        appCompatActivity.a(at);
        ActionBar b = appCompatActivity.b();
        if (b == null) {
            Intrinsics.m26842a();
        }
        b.a(true);
        b.b(true);
        Intrinsics.m26843a((Object) b, "activity.supportActionBa…meAsUpEnabled(true)\n    }");
        mo7185a(b);
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.c(true);
        actionBar.a(mo7480y());
    }

    protected void mo7485b(String str) {
        Intrinsics.m26847b(str, "permission");
        if (StringsKt__StringsJVMKt.m41946a("android.permission.ACCESS_COARSE_LOCATION", str, true) != null) {
            AppAnalytics.m21858b().m21824a(getAnalyticsScreenName()).m21826b(f39332F).m21825a();
            aj();
        }
    }

    protected void mo7241c(String str) {
        Intrinsics.m26847b(str, "permission");
        if (StringsKt__StringsJVMKt.m41946a("android.permission.ACCESS_COARSE_LOCATION", str, true) != null) {
            AppAnalytics.m21858b().m21824a(getAnalyticsScreenName()).m21826b(f39333G).m21825a();
            Snackbar.a(this.K, C1761R.string.error_unable_access_coarse_location_permission, -1).a();
        }
    }

    protected final Unit m39529Y() {
        AlertDialog alertDialog = this.f39340B;
        if (alertDialog == null) {
            return null;
        }
        alertDialog.dismiss();
        return Unit.f25273a;
    }

    private final void aj() {
        m29359a(Nav.m22612w(this.requestId));
    }

    public void mo7481Z() {
        EditText editText = this.f39342w;
        if (editText == null) {
            Intrinsics.m26844a("submitTitleView");
        }
        editText.setHorizontallyScrolling(false);
        editText = this.f39342w;
        if (editText == null) {
            Intrinsics.m26844a("submitTitleView");
        }
        editText.setRawInputType(16384);
        editText = this.f39342w;
        if (editText == null) {
            Intrinsics.m26844a("submitTitleView");
        }
        editText.setImeOptions(5);
    }

    private final void ak() {
        this.flairList = null;
        this.flair = null;
        m39511a(null, null);
        TextView textView = this.f39343x;
        if (textView == null) {
            Intrinsics.m26844a("flairTextView");
        }
        ViewsKt.m24109d(textView);
    }

    private final void m39511a(LinkFlair linkFlair, String str) {
        this.flair = linkFlair;
        this.flairTextEdit = str;
        TextView textView = this.f39343x;
        if (textView == null) {
            Intrinsics.m26844a("flairTextView");
        }
        ViewsKt.m24107c(textView);
        if ((linkFlair != null ? 1 : null) != null) {
            if (str == null) {
                if (linkFlair == null) {
                    Intrinsics.m26842a();
                }
                str = linkFlair.getFlairRichText();
                Intrinsics.m26843a((Object) str, "flair!!.flairRichText");
            }
            linkFlair = this.f39343x;
            if (linkFlair == null) {
                Intrinsics.m26844a("flairTextView");
            }
            RichTextUtil.m23883a(str, linkFlair);
            return;
        }
        linkFlair = this.f39343x;
        if (linkFlair == null) {
            Intrinsics.m26844a("flairTextView");
        }
        linkFlair.setText(C1761R.string.title_add_flair);
    }

    public final void mo7206a(LinkFlair linkFlair, String str, Thing thing) {
        m39511a(linkFlair, str);
        AppAnalytics.m21858b().m21824a(getAnalyticsScreenName()).m21826b(f39336N).m21825a();
    }

    public String getAnalyticsPageType() {
        return f39329C;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        /*
        r5 = this;
        r0 = super.getAnalyticsHeartbeatParams();
        r1 = r5.m39520P();
        r2 = 0;
        if (r1 == 0) goto L_0x006d;
    L_0x000b:
        r1 = com.reddit.datalibrary.frontpage.redditauth.account.SessionManager.b();
        r3 = "SessionManager.getInstance()";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r3);
        r1 = r1.d();
        r1 = r1.getId();
        r1 = com.reddit.frontpage.util.SessionUtil.m23893a(r1);
        r3 = r5.selectedSubredditData;
        if (r3 == 0) goto L_0x0027;
    L_0x0024:
        r3 = r3.subredditId;
        goto L_0x0028;
    L_0x0027:
        r3 = r2;
    L_0x0028:
        if (r3 == 0) goto L_0x0099;
    L_0x002a:
        r3 = r5.selectedSubredditData;
        if (r3 == 0) goto L_0x0030;
    L_0x002e:
        r2 = r3.subredditName;
    L_0x0030:
        if (r2 == 0) goto L_0x0099;
    L_0x0032:
        r2 = r5.selectedSubredditData;
        if (r2 != 0) goto L_0x0039;
    L_0x0036:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0039:
        r2 = r2.subredditId;
        r3 = "selectedSubredditData!!.subredditId";
        kotlin.jvm.internal.Intrinsics.m26843a(r2, r3);
        r3 = r5.selectedSubredditData;
        if (r3 != 0) goto L_0x0047;
    L_0x0044:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0047:
        r3 = r3.subredditName;
        r4 = "selectedSubredditData!!.subredditName";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        r2 = r0.m21905a(r2, r3);
        if (r1 != 0) goto L_0x0057;
    L_0x0054:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x0057:
        r3 = r5.selectedSubredditData;
        if (r3 != 0) goto L_0x005e;
    L_0x005b:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x005e:
        r3 = r3.subredditName;
        r3 = com.reddit.frontpage.util.SubredditUtil.m23921b(r3);
        r4 = "SubredditUtil.stripUserP…dditData!!.subredditName)";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        r2.m21906b(r1, r3);
        goto L_0x0099;
    L_0x006d:
        r1 = r5.originSubreddit;
        if (r1 == 0) goto L_0x0077;
    L_0x0071:
        r1 = r1.getKindWithId();
        if (r1 != 0) goto L_0x007f;
    L_0x0077:
        r1 = r5.selectedSubredditData;
        if (r1 == 0) goto L_0x007e;
    L_0x007b:
        r1 = r1.subredditId;
        goto L_0x007f;
    L_0x007e:
        r1 = r2;
    L_0x007f:
        r3 = r5.originSubreddit;
        if (r3 == 0) goto L_0x008c;
    L_0x0083:
        r3 = r3.getDisplayName();
        if (r3 != 0) goto L_0x008a;
    L_0x0089:
        goto L_0x008c;
    L_0x008a:
        r2 = r3;
        goto L_0x0092;
    L_0x008c:
        r3 = r5.selectedSubredditData;
        if (r3 == 0) goto L_0x0092;
    L_0x0090:
        r2 = r3.subredditName;
    L_0x0092:
        if (r1 == 0) goto L_0x0099;
    L_0x0094:
        if (r2 == 0) goto L_0x0099;
    L_0x0096:
        r0.m21905a(r1, r2);
    L_0x0099:
        r1 = "params";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.ui.submit.BaseSubmitScreen.getAnalyticsHeartbeatParams():com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams");
    }

    private final int al() {
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        return ResourcesUtil.m22740i((Context) am_, C1761R.attr.rdt_default_key_color);
    }

    public static final /* synthetic */ void m39512a(BaseSubmitScreen baseSubmitScreen) {
        if (PermissionUtil.m23864a((Context) baseSubmitScreen.am_())) {
            baseSubmitScreen.aj();
        } else {
            baseSubmitScreen.a(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, f39330D);
        }
    }
}
