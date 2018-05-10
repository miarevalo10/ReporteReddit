package com.reddit.social.presentation.groupchat.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.social.data.common.StateStorageBundle;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.ui.BottomNavScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.sorting.SnoomojiPreviewDialog.OnSendListener;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.CollectionsKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen;
import com.reddit.social.presentation.chatrequests.view.ChatRequestListScreen;
import com.reddit.social.presentation.groupchat.ChatContract.Presenter;
import com.reddit.social.presentation.groupchat.ChatContract.View;
import com.reddit.social.presentation.messaginglist.MessageItemOnClickListener;
import com.reddit.social.presentation.messaginglist.MessagingAdapter;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.HeaderMessageData;
import com.reddit.social.presentation.presentationobjects.MessageData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.TypingIndicator;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.widgets.SnoomojiMedium;
import com.reddit.social.widgets.WidgetKeyboard;
import com.reddit.social.widgets.WidgetKeyboard.Medium;
import com.reddit.social.widgets.WidgetKeyboard.SendListener;
import com.reddit.social.widgets.WidgetKeyboardHeader;
import com.reddit.social.widgets.WidgetKeyboardHeader$inlined$sam$OnClickListener$i$7f478c20;
import com.sendbird.android.SendBird;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import net.hockeyapp.android.UpdateFragment;
import org.jetbrains.anko.Sdk21PropertiesKt;
import org.parceler.Parcel;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ¤\u00012\u00020\u00012\u00020\u0002:\u0004¤\u0001¥\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010C\u001a\u00020<H\u0016J\u0010\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020<H\u0016J\b\u0010H\u001a\u00020<H\u0016J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020<H\u0002J\b\u0010N\u001a\u00020JH\u0016J\b\u0010O\u001a\u00020LH\u0016J\b\u0010P\u001a\u00020\u001aH\u0002J\b\u0010Q\u001a\u00020<H\u0016J\b\u0010R\u001a\u00020<H\u0002J\b\u0010S\u001a\u00020<H\u0016J\b\u0010T\u001a\u00020<H\u0016J\b\u0010U\u001a\u00020<H\u0016J\u0018\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020J2\u0006\u0010X\u001a\u00020YH\u0016J\u0006\u0010Z\u001a\u00020<J\u0010\u0010[\u001a\u00020<2\u0006\u0010\\\u001a\u00020\u001aH\u0016J\"\u0010]\u001a\u00020<2\u0006\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u00020L2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020\u001cH\u0014J\b\u0010d\u001a\u00020\u001aH\u0016J\u0018\u0010e\u001a\u00020<2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0016J\u0018\u0010j\u001a\u00020\u001c2\u0006\u0010h\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0016J\u0010\u0010n\u001a\u00020<2\u0006\u0010c\u001a\u00020\u001cH\u0016J\u0010\u0010o\u001a\u00020<2\u0006\u0010p\u001a\u00020JH\u0002J\u0010\u0010q\u001a\u00020\u001a2\u0006\u0010r\u001a\u00020sH\u0016J+\u0010t\u001a\u00020<2\u0006\u0010^\u001a\u00020L2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020J0v2\u0006\u0010w\u001a\u00020xH\u0016¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020<2\u0006\u0010{\u001a\u00020\u0005H\u0014J\u0010\u0010|\u001a\u00020<2\u0006\u0010}\u001a\u00020\u0005H\u0014J\u0010\u0010~\u001a\u00020<2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010~\u001a\u00020<2\u0006\u0010W\u001a\u00020JH\u0016J\b\u0010\u001a\u00020<H\u0002J\t\u0010\u0001\u001a\u00020<H\u0003J\t\u0010\u0001\u001a\u00020<H\u0016J\t\u0010\u0001\u001a\u00020<H\u0016J\u0012\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020JH\u0016J\u001a\u0010\u0001\u001a\u00020<2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020J2\t\u0010\u0001\u001a\u0004\u0018\u00010JH\u0016J\u0014\u0010\u0001\u001a\u00020<2\t\u0010\u0001\u001a\u0004\u0018\u00010JH\u0016J\u0007\u0010\u0001\u001a\u00020<J\u0012\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020JH\u0002J\u0007\u0010\u0001\u001a\u00020<J\u0014\u0010\u0001\u001a\u00020<2\t\b\u0001\u0010\u0001\u001a\u00020LH\u0016J\u0011\u0010\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020JH\u0016J\u0007\u0010\u0001\u001a\u00020<J\u0011\u0010\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0011\u0010\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0011\u0010\u0001\u001a\u00020<2\u0006\u0010p\u001a\u00020JH\u0016J\t\u0010\u0001\u001a\u00020<H\u0016J\u001b\u0010\u0001\u001a\u00020<2\u0007\u0010\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020JH\u0016J\u0013\u0010\u0001\u001a\u00020<2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001b\u0010 \u0001\u001a\u00020<2\u0006\u0010W\u001a\u00020J2\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J\u0011\u0010£\u0001\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0016R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001e\u0010/\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001e\u00102\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006¦\u0001"}, d2 = {"Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/social/presentation/groupchat/ChatContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "adapter", "Lcom/reddit/social/presentation/messaginglist/MessagingAdapter;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "errorContainer", "Landroid/widget/LinearLayout;", "getErrorContainer", "()Landroid/widget/LinearLayout;", "setErrorContainer", "(Landroid/widget/LinearLayout;)V", "errorMessage", "Landroid/widget/TextView;", "getErrorMessage", "()Landroid/widget/TextView;", "setErrorMessage", "(Landroid/widget/TextView;)V", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "loadingMore", "", "loadingSnoo", "Landroid/view/View;", "noConnectionBanner", "getNoConnectionBanner", "setNoConnectionBanner", "presenter", "Lcom/reddit/social/presentation/groupchat/ChatContract$Presenter;", "getPresenter", "()Lcom/reddit/social/presentation/groupchat/ChatContract$Presenter;", "setPresenter", "(Lcom/reddit/social/presentation/groupchat/ChatContract$Presenter;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "retryButton", "getRetryButton", "setRetryButton", "subtitleTextView", "getSubtitleTextView", "setSubtitleTextView", "titleTextView", "getTitleTextView", "setTitleTextView", "widgetKeyboard", "Lcom/reddit/social/widgets/WidgetKeyboard;", "getWidgetKeyboard", "()Lcom/reddit/social/widgets/WidgetKeyboard;", "setWidgetKeyboard", "(Lcom/reddit/social/widgets/WidgetKeyboard;)V", "addNewMessage", "", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "addNewMessages", "messagesBatch", "Lcom/reddit/social/domain/functions/MessagesBatch;", "addOldMessages", "clearInputField", "deleteMessage", "messageData", "Lcom/reddit/social/presentation/presentationobjects/MessageData;", "disableSendButton", "enableSendButton", "getAnalyticsScreenName", "", "getDefaultScreenPosition", "", "getImage", "getInputFieldText", "getLayoutId", "isLastMessageVisible", "loadError", "loadMoreMessages", "loading", "loadingStarted", "loadingStopped", "markMessageSent", "requestId", "messageId", "", "navToChatInbox", "networkConnectionChange", "hasNetworkConnection", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "view", "onBackPressed", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onFileMessageClicked", "url", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "removeMessage", "requestImage", "requestStoragePermissions", "sendError", "sending", "setKeyboardHint", "channelName", "setMembers", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "setTitle", "title", "subtitle", "setTypingIndicator", "typingTitle", "showContent", "showDownloadConfirmDialog", "fileUrl", "showError", "showErrorMessage", "messageRes", "showErrorMessageTooLong", "showLoading", "showMessageActions", "showMessageReportDialog", "showMessageSettings", "showRefreshing", "showRevealConfirmationDialog", "currentUserName", "recipient", "showUploadConfirmDialog", "uri", "Landroid/net/Uri;", "updateMessageStatus", "status", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "updateMessages", "Companion", "DeepLinker", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMessagingScreen.kt */
public final class GroupMessagingScreen extends MvpBaseScreen implements View {
    private static final int f40212C = 300;
    private static final int f40213D = 13;
    public static final Companion f40214w = new Companion();
    private CompositeDisposable f40215A;
    private boolean f40216B;
    @BindView
    public LinearLayout errorContainer;
    @BindView
    public TextView errorMessage;
    @BindView
    public TextView noConnectionBanner;
    @BindView
    public RecyclerView recyclerView;
    @BindView
    public TextView retryButton;
    @BindView
    public TextView subtitleTextView;
    @BindView
    public TextView titleTextView;
    @Inject
    public Presenter f40217v;
    @BindView
    public WidgetKeyboard widgetKeyboard;
    private android.view.View f40218x;
    private MessagingAdapter f40219y;
    private LinearLayoutManager f40220z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen$Companion;", "", "()V", "INTENT_REQUEST_CHOOSE_IMAGE", "", "getINTENT_REQUEST_CHOOSE_IMAGE", "()I", "PERMISSION_WRITE_EXTERNAL_STORAGE", "getPERMISSION_WRITE_EXTERNAL_STORAGE", "deepLink", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "channelUrl", "", "newInstance", "Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen;", "recipientId", "recipientUsername", "channelName", "shareTitle", "shareUrl", "shareLink", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GroupMessagingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static GroupMessagingScreen m24695a(String str, String str2) {
            Intrinsics.m26847b(str, "recipientId");
            Intrinsics.m26847b(str2, "recipientUsername");
            GroupMessagingScreen groupMessagingScreen = new GroupMessagingScreen();
            groupMessagingScreen.m41332w().mo5168a(str, str2);
            return groupMessagingScreen;
        }

        public static GroupMessagingScreen m24696a(String str, String str2, String str3, Link link) {
            Intrinsics.m26847b(str, "channelUrl");
            GroupMessagingScreen groupMessagingScreen = new GroupMessagingScreen();
            groupMessagingScreen.m41332w().mo5169a(str, str2, str3, link);
            return groupMessagingScreen;
        }

        public static GroupMessagingScreen m24694a(String str) {
            GroupMessagingScreen groupMessagingScreen = new GroupMessagingScreen();
            groupMessagingScreen.m41332w().mo5166a(str);
            return groupMessagingScreen;
        }

        public static ScreenDeepLinker m24698b(String str) {
            Intrinsics.m26847b(str, "channelUrl");
            DeepLinker deepLinker = new DeepLinker();
            deepLinker.setChannelUrl(str);
            return deepLinker;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22349a;

        static {
            int[] iArr = new int[MessageAction.values().length];
            f22349a = iArr;
            iArr[MessageAction.f22361b.ordinal()] = 1;
            f22349a[MessageAction.f22360a.ordinal()] = 2;
            f22349a[MessageAction.f22362c.ordinal()] = 3;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/reddit/social/presentation/groupchat/view/GroupMessagingScreen$DeepLinker;", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "()V", "channelUrl", "", "getChannelUrl", "()Ljava/lang/String;", "setChannelUrl", "(Ljava/lang/String;)V", "createScreen", "Lcom/reddit/frontpage/nav/Screen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Parcel
    /* compiled from: GroupMessagingScreen.kt */
    public static final class DeepLinker implements ScreenDeepLinker {
        private String channelUrl;

        public final String getChannelUrl() {
            return this.channelUrl;
        }

        public final void setChannelUrl(String str) {
            this.channelUrl = str;
        }

        public final Screen createScreen() {
            Companion companion = GroupMessagingScreen.f40214w;
            return Companion.m24694a(this.channelUrl);
        }
    }

    public final String getAnalyticsScreenName() {
        return "chat_message";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_messaging;
    }

    public final int mo7143u() {
        return 2;
    }

    public static final /* synthetic */ MessagingAdapter m41285a(GroupMessagingScreen groupMessagingScreen) {
        groupMessagingScreen = groupMessagingScreen.f40219y;
        if (groupMessagingScreen == null) {
            Intrinsics.m26844a("adapter");
        }
        return groupMessagingScreen;
    }

    public static final /* synthetic */ LinearLayoutManager m41291c(GroupMessagingScreen groupMessagingScreen) {
        groupMessagingScreen = groupMessagingScreen.f40220z;
        if (groupMessagingScreen == null) {
            Intrinsics.m26844a("layoutManager");
        }
        return groupMessagingScreen;
    }

    public GroupMessagingScreen() {
        super();
        FrontpageApplication.m28878n().mo5098a(this);
    }

    public GroupMessagingScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        FrontpageApplication.m28878n().mo5098a(this);
    }

    public final Presenter m41332w() {
        Presenter presenter = this.f40217v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return presenter;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        this.f40215A = new CompositeDisposable();
        Object create = PublishSubject.create();
        Intrinsics.m26843a(create, "linkEmbedLoaded");
        this.f40219y = new MessagingAdapter(create);
        viewGroup = this.f40215A;
        if (viewGroup == null) {
            Intrinsics.m26844a("disposables");
        }
        DisposableKt.m26766a(viewGroup, ObservablesKt.m24091a((Observable) create, (Function1) new GroupMessagingScreen$onCreateView$1(this)));
        layoutInflater = this.f40219y;
        if (layoutInflater == null) {
            Intrinsics.m26844a("adapter");
        }
        MessageItemOnClickListener messageItemOnClickListener = (MessageItemOnClickListener) new GroupMessagingScreen$onCreateView$2(this);
        Intrinsics.m26847b(messageItemOnClickListener, "listener");
        layoutInflater.f29886b = messageItemOnClickListener;
        this.f40220z = new LinearLayoutManager(am_());
        layoutInflater = this.f40220z;
        if (layoutInflater == null) {
            Intrinsics.m26844a("layoutManager");
        }
        layoutInflater.b(true);
        layoutInflater = this.recyclerView;
        if (layoutInflater == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup = this.f40220z;
        if (viewGroup == null) {
            Intrinsics.m26844a("layoutManager");
        }
        layoutInflater.setLayoutManager((LayoutManager) viewGroup);
        layoutInflater = this.recyclerView;
        if (layoutInflater == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup = this.f40219y;
        if (viewGroup == null) {
            Intrinsics.m26844a("adapter");
        }
        layoutInflater.setAdapter((Adapter) viewGroup);
        layoutInflater = this.recyclerView;
        if (layoutInflater == null) {
            Intrinsics.m26844a("recyclerView");
        }
        layoutInflater.addOnScrollListener((OnScrollListener) new GroupMessagingScreen$onCreateView$3(this));
        layoutInflater = this.widgetKeyboard;
        if (layoutInflater == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        layoutInflater.setSendOnClickListener((SendListener) new GroupMessagingScreen$onCreateView$4(this));
        create = this.K.findViewById(C1761R.id.progress_bar);
        Intrinsics.m26843a(create, "rootView.findViewById(R.id.progress_bar)");
        this.f40218x = create;
        layoutInflater = this.f40218x;
        if (layoutInflater == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        layoutInflater.setBackground(AnimUtil.m23637a(am_()));
        OnSendListener onSendListener = (OnSendListener) new GroupMessagingScreen$onCreateView$sendListener$1(this);
        viewGroup = this.widgetKeyboard;
        if (viewGroup == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        Medium snoomojiMedium = new SnoomojiMedium(onSendListener);
        Intrinsics.m26847b(snoomojiMedium, "medium");
        WidgetKeyboardHeader widgetKeyboardHeader = (WidgetKeyboardHeader) viewGroup.m24794a(C1761R.id.keyboardHeader);
        Intrinsics.m26847b(snoomojiMedium, "medium");
        viewGroup = widgetKeyboardHeader.f22513b.size();
        widgetKeyboardHeader.f22513b.add(snoomojiMedium);
        ImageView imageView = new ImageView(widgetKeyboardHeader.getContext());
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.rightMargin = (int) widgetKeyboardHeader.getResources().getDimension(C1761R.dimen.triple_pad);
        imageView.setLayoutParams(layoutParams);
        Sdk21PropertiesKt.m28410a(imageView, widgetKeyboardHeader.f22512a == null ? C1761R.drawable.snoomojis_active : C1761R.drawable.snoomojis);
        android.view.View view = imageView;
        view.setOnClickListener((OnClickListener) new WidgetKeyboardHeader$inlined$sam$OnClickListener$i$7f478c20(new WidgetKeyboardHeader$addMedium$1(widgetKeyboardHeader, snoomojiMedium, viewGroup)));
        ((LinearLayout) widgetKeyboardHeader.m24800a(C1761R.id.mediaControlContainer)).addView(view);
        if (widgetKeyboardHeader.f22512a == null) {
            widgetKeyboardHeader.f22512a = snoomojiMedium;
        }
        this.K.post((Runnable) new GroupMessagingScreen$onCreateView$5(this));
        layoutInflater = this.f40217v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.mo5164a((View) this);
        layoutInflater = this.widgetKeyboard;
        if (layoutInflater == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        Observable throttleFirst = layoutInflater.m24797c().filter((Predicate) GroupMessagingScreen$onCreateView$6.f29856a).throttleFirst(1, TimeUnit.SECONDS);
        Intrinsics.m26843a((Object) throttleFirst, "widgetKeyboard.listenTex…irst(1, TimeUnit.SECONDS)");
        ObservablesKt.m24091a(throttleFirst, (Function1) new GroupMessagingScreen$onCreateView$7(this));
        layoutInflater = this.widgetKeyboard;
        if (layoutInflater == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        throttleFirst = layoutInflater.m24797c().filter((Predicate) GroupMessagingScreen$onCreateView$8.f29857a).debounce(3, TimeUnit.SECONDS);
        Intrinsics.m26843a((Object) throttleFirst, "widgetKeyboard.listenTex…unce(3, TimeUnit.SECONDS)");
        ObservablesKt.m24091a(throttleFirst, (Function1) new GroupMessagingScreen$onCreateView$9(this));
        create = this.K;
        Intrinsics.m26843a(create, "rootView");
        return create;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40217v;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.mo5161a();
    }

    public final void m41303a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_group_messaging, menu);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_chat_settings) {
            return super.mo7201a(menuItem);
        }
        menuItem = this.f40217v;
        if (menuItem == null) {
            Intrinsics.m26844a("presenter");
        }
        menuItem.mo5173c();
        return true;
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        CompositeDisposable compositeDisposable = this.f40215A;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
        Presenter presenter = this.f40217v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5175d();
        super.mo6987a(view);
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        Presenter presenter = this.f40217v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5163a((StateStorageContract) new StateStorageBundle(bundle));
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        Presenter presenter = this.f40217v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5171b((StateStorageContract) new StateStorageBundle(bundle));
        super.mo7199c(bundle);
    }

    public final void mo7563d() {
        this.f40216B = true;
        android.view.View view = this.f40218x;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        view.setVisibility(0);
    }

    public final void mo7565e() {
        this.f40216B = false;
        android.view.View view = this.f40218x;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        view.setVisibility(8);
    }

    public final void mo7555a(String str, String str2) {
        Intrinsics.m26847b(str, "title");
        TextView textView = this.titleTextView;
        if (textView == null) {
            Intrinsics.m26844a("titleTextView");
        }
        textView.setText(str);
        str = this.subtitleTextView;
        if (str == null) {
            Intrinsics.m26844a("subtitleTextView");
        }
        ViewsKt.m24106b((android.view.View) str, str2 != null);
        str = this.subtitleTextView;
        if (str == null) {
            Intrinsics.m26844a("subtitleTextView");
        }
        str.setText(str2);
    }

    public final void mo7560b(String str) {
        Intrinsics.m26847b(str, "channelName");
        WidgetKeyboard widgetKeyboard = this.widgetKeyboard;
        if (widgetKeyboard == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        Object a = Util.m23960a((int) C1761R.string.chat_keyboard_hint_1, str);
        Intrinsics.m26843a(a, "Util.getString(R.string.…oard_hint_1, channelName)");
        widgetKeyboard.setHint(a);
    }

    public final void mo7547a() {
        LinearLayout linearLayout = this.errorContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("errorContainer");
        }
        linearLayout.setVisibility(8);
        android.view.View view = this.f40218x;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        view.setVisibility(0);
    }

    private void m41283O() {
        this.f40216B = false;
        LinearLayout linearLayout = this.errorContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("errorContainer");
        }
        linearLayout.setVisibility(8);
        android.view.View view = this.f40218x;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        view.setVisibility(8);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.m26844a("recyclerView");
        }
        recyclerView.setVisibility(0);
    }

    public final void mo7556a(List<UserData> list) {
        Intrinsics.m26847b(list, "members");
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(list, "members");
        HeaderMessageData headerMessageData = messagingAdapter.f29887c;
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if ((Intrinsics.m26845a(((UserData) next).f22464a, SessionUtil.m23898d()) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        Intrinsics.m26847b(list2, "<set-?>");
        headerMessageData.f29935a = list2;
        messagingAdapter.d(CollectionsKt__CollectionsKt.m26787a((List) messagingAdapter.m30875b()));
    }

    public final void mo7559b(MessagesBatch messagesBatch) {
        Intrinsics.m26847b(messagesBatch, "messagesBatch");
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(messagesBatch, "batch");
        int a = CollectionsKt__CollectionsKt.m26787a(messagingAdapter.m30875b());
        messagingAdapter.m30873a(CollectionsKt___CollectionsKt.m41423b((Collection) messagingAdapter.m30875b(), (Iterable) messagingAdapter.m30870a(messagesBatch.f22302a, messagesBatch.f22303b)));
        messagingAdapter.d(a);
        m41283O();
    }

    public final void mo7562c(MessagesBatch messagesBatch) {
        Intrinsics.m26847b(messagesBatch, "messagesBatch");
        boolean P = m41284P();
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(messagesBatch, "batch");
        messagingAdapter.m30873a(messagingAdapter.m30876b(CollectionsKt___CollectionsKt.m41423b((Collection) messagesBatch.f22302a, (Iterable) MessagingAdapter.m30867c(messagingAdapter.m30875b()))));
        if (P) {
            messagesBatch = this.recyclerView;
            if (messagesBatch == null) {
                Intrinsics.m26844a("recyclerView");
            }
            messagesBatch.scrollToPosition(0);
        }
        m41283O();
    }

    public final void mo7550a(MessagesBatch messagesBatch) {
        Intrinsics.m26847b(messagesBatch, "messagesBatch");
        boolean P = m41284P();
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(messagesBatch, "batch");
        messagingAdapter.m30873a(messagingAdapter.m30876b(messagingAdapter.m30870a(messagesBatch.f22302a, messagesBatch.f22303b)));
        if (P) {
            messagesBatch = this.recyclerView;
            if (messagesBatch == null) {
                Intrinsics.m26844a("recyclerView");
            }
            messagesBatch.scrollToPosition(0);
        }
        m41283O();
    }

    public final void mo7551a(HasMessageData hasMessageData) {
        Intrinsics.m26847b(hasMessageData, "message");
        boolean P = m41284P();
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(hasMessageData, "message");
        messagingAdapter.m30873a(messagingAdapter.m30876b(CollectionsKt.m24072a(MessagingAdapter.m30867c(messagingAdapter.m30875b()), hasMessageData)));
        if (hasMessageData.mo5204a().f22437j != null || P) {
            hasMessageData = this.recyclerView;
            if (hasMessageData == null) {
                Intrinsics.m26844a("recyclerView");
            }
            hasMessageData.scrollToPosition(0);
        }
        m41283O();
    }

    public final void mo7549a(long j) {
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        int i = 0;
        for (HasMessageData a : messagingAdapter.m30875b()) {
            if ((a.mo5204a().f22429b == j ? 1 : 0) != 0) {
                break;
            }
            i++;
        }
        i = -1;
        messagingAdapter.m30873a(CollectionsKt___CollectionsKt.m41422b((Iterable) messagingAdapter.m30875b(), messagingAdapter.m30875b().get(i)));
        messagingAdapter.d(i - 1);
    }

    public final void mo7552a(String str) {
        Intrinsics.m26847b(str, "requestId");
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(str, "requestId");
        int i = 0;
        for (HasMessageData a : messagingAdapter.m30875b()) {
            if (Intrinsics.m26845a(a.mo5204a().f22428a, (Object) str)) {
                break;
            }
            i++;
        }
        i = -1;
        messagingAdapter.m30873a(CollectionsKt___CollectionsKt.m41422b((Iterable) messagingAdapter.m30875b(), messagingAdapter.m30875b().get(i)));
        messagingAdapter.d(i - 1);
    }

    public final void mo7558b() {
        WidgetKeyboard widgetKeyboard = this.widgetKeyboard;
        if (widgetKeyboard == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        widgetKeyboard.setText(null);
    }

    public final String mo7561c() {
        WidgetKeyboard widgetKeyboard = this.widgetKeyboard;
        if (widgetKeyboard == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        return widgetKeyboard.getText();
    }

    public final void mo7548a(int i) {
        Toast.makeText(am_(), i, 1).show();
    }

    public final void mo7566e(String str) {
        Intrinsics.m26847b(str, "message");
        Activity am_ = am_();
        if (am_ != null) {
            new Builder(am_).b(str).a(C1761R.string.action_okay, GroupMessagingScreen$showErrorMessageTooLong$1$1.f22357a).c();
        }
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        Routing.m22623a((Screen) this, Nav.m22610u(str));
    }

    public final void mo7557a(boolean z) {
        TextView textView = this.noConnectionBanner;
        if (textView == null) {
            Intrinsics.m26844a("noConnectionBanner");
        }
        ViewsKt.m24106b(textView, z ^ 1);
    }

    private final boolean m41284P() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.m26844a("recyclerView");
        }
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        int k = ((LinearLayoutManager) layoutManager).k();
        if (k != 0) {
            if (k != 1) {
                return false;
            }
        }
        return true;
    }

    public final void m41301a(int i, String[] strArr, int[] iArr) {
        Intrinsics.m26847b(strArr, "permissions");
        Intrinsics.m26847b(iArr, "grantResults");
        if (i == f40213D) {
            if ((1 ^ (iArr.length == 0 ? 1 : 0)) == 0 || iArr[0] != 0) {
                Snackbar.a(this.K, Util.m24027f((int) 2131887133), -1).a();
                return;
            }
            i = new Intent();
            i.setType("image/* video/*");
            i.setAction("android.intent.action.GET_CONTENT");
            a(Intent.createChooser(i, "Select Media"), f40212C);
            SendBird.m24981b(false);
            return;
        }
        super.a(i, strArr, iArr);
    }

    public final void mo7202a(int i, int i2, Intent intent) {
        super.mo7202a(i, i2, intent);
        if (i == f40212C && i2 == -1) {
            if (intent == null) {
                Timber.e("GroupMessagingScreen.onActivityResult. Data is null!", new Object[0]);
                return;
            }
            Object data = intent.getData();
            Intrinsics.m26843a(data, "data.data");
            i2 = am_();
            if (i2 != 0) {
                new Builder((Context) i2).b(Util.m24027f((int) C1761R.string.rdt_upload_file_msg)).a("UPLOAD", new C1943x9d417d4d(this, data)).b("CANCEL", null).c();
            }
        }
        SendBird.m24981b((boolean) 1);
    }

    public final void mo7568g() {
        WidgetKeyboard widgetKeyboard = this.widgetKeyboard;
        if (widgetKeyboard == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        ((WidgetKeyboardHeader) widgetKeyboard.m24794a(C1761R.id.keyboardHeader)).setSendButtonEnabled(true);
    }

    public final void mo7569h() {
        WidgetKeyboard widgetKeyboard = this.widgetKeyboard;
        if (widgetKeyboard == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        ((WidgetKeyboardHeader) widgetKeyboard.m24794a(C1761R.id.keyboardHeader)).setSendButtonEnabled(false);
    }

    public final void mo7554a(String str, SentStatus sentStatus) {
        Intrinsics.m26847b(str, "requestId");
        Intrinsics.m26847b(sentStatus, "status");
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        messagingAdapter.m30872a(str, sentStatus);
    }

    public final void mo7553a(String str, long j) {
        Intrinsics.m26847b(str, "requestId");
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(str, "requestId");
        int i = 0;
        for (HasMessageData a : messagingAdapter.m30875b()) {
            if (Intrinsics.m26845a(a.mo5204a().f22428a, (Object) str)) {
                break;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            Timber.e("Error adding group message. No index", new Object[0]);
        } else {
            ((HasMessageData) messagingAdapter.m30875b().get(i)).mo5204a().f22429b = j;
        }
        j = this.f40219y;
        if (j == null) {
            Intrinsics.m26844a("adapter");
        }
        j.m30872a(str, SentStatus.f22460a);
    }

    public final void mo7564d(String str) {
        boolean P = m41284P();
        MessagingAdapter messagingAdapter = this.f40219y;
        if (messagingAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        if ((Intrinsics.m26845a(messagingAdapter.f29888f, (Object) str) ^ 1) != 0) {
            messagingAdapter.f29888f = str;
            Object obj = messagingAdapter.m30875b().get(0);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.social.presentation.presentationobjects.TypingIndicator");
            }
            ((TypingIndicator) obj).f29966a = messagingAdapter.f29888f;
            messagingAdapter.d(0);
        }
        if (str != null && P) {
            str = this.recyclerView;
            if (str == null) {
                Intrinsics.m26844a("recyclerView");
            }
            str.scrollToPosition(0);
        }
    }

    public final boolean mo6986J() {
        WidgetKeyboard widgetKeyboard = this.widgetKeyboard;
        if (widgetKeyboard == null) {
            Intrinsics.m26844a("widgetKeyboard");
        }
        boolean z = widgetKeyboard.f22502a;
        if (z) {
            widgetKeyboard.m24795a();
        }
        if (z) {
            return true;
        }
        ai_();
        Object C_ = C_();
        Intrinsics.m26843a(C_, "router");
        C_ = C_.m();
        Intrinsics.m26843a(C_, "router.backstack");
        RouterTransaction routerTransaction = (RouterTransaction) CollectionsKt___CollectionsKt.m41434e((List) C_);
        Controller controller = null;
        Controller a = routerTransaction != null ? routerTransaction.a() : null;
        if (a != null) {
            C_ = a.j();
            Intrinsics.m26843a(C_, "childRouters");
            Router router = (Router) CollectionsKt___CollectionsKt.m41434e((List) C_);
            if (router != null) {
                routerTransaction = (RouterTransaction) CollectionsKt___CollectionsKt.m41439g(router.m());
                if (routerTransaction != null) {
                    controller = routerTransaction.a();
                }
            }
            if (!((controller instanceof ChatInboxScreen) || (controller instanceof ChatRequestListScreen))) {
                C_ = C_();
                Intrinsics.m26843a(C_, "router");
                Activity a2 = C_.a();
                if (a2 instanceof MainActivity) {
                    BottomNavScreen a3 = ((MainActivity) a2).m42708a(false);
                    if (a3 != null) {
                        a3.m39004a(Item.f21975d);
                    }
                }
            }
        }
        return true;
    }

    public final void mo7567f() {
        LinearLayout linearLayout = this.errorContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("errorContainer");
        }
        linearLayout.setVisibility(8);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.m26844a("recyclerView");
        }
        recyclerView.setVisibility(0);
        android.view.View view = this.f40218x;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        view.setVisibility(0);
    }

    public static final /* synthetic */ void m41286a(GroupMessagingScreen groupMessagingScreen, HasMessageData hasMessageData) {
        List b;
        MessageData a = hasMessageData.mo5204a();
        MessageActions messageActions;
        if (Intrinsics.m26845a(a.f22436i, SentStatus.f22462c)) {
            messageActions = MessageActions.f22365a;
            b = MessageActions.m24700b();
        } else if (a.f22437j) {
            messageActions = MessageActions.f22365a;
            b = MessageActions.m24699a();
        } else {
            messageActions = MessageActions.f22365a;
            b = MessageActions.m24701c();
        }
        CompositeDisposable compositeDisposable = groupMessagingScreen.f40215A;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = groupMessagingScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Context context = (Context) am_;
        Iterable<MessageAction> iterable = b;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (MessageAction messageAction : iterable) {
            arrayList.add(messageAction.f22364d);
        }
        Object subscribe = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23301a(context, (Collection) (List) arrayList, 0).subscribe((Consumer) new GroupMessagingScreen$showMessageActions$2(groupMessagingScreen, b, a, hasMessageData));
        Intrinsics.m26843a(subscribe, "RedditAlertDialog.select…ge)\n          }\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public static final /* synthetic */ void m41288a(GroupMessagingScreen groupMessagingScreen, String str) {
        CharSequence charSequence = str;
        if (StringsKt__StringsKt.m42454a(charSequence, (CharSequence) "mp4", false)) {
            Timber.b("onFileMessageClicked: video", new Object[0]);
            return;
        }
        if (!(StringsKt__StringsKt.m42454a(charSequence, (CharSequence) "gif", false) || StringsKt__StringsKt.m42454a(charSequence, (CharSequence) "jpg", false) || StringsKt__StringsKt.m42454a(charSequence, (CharSequence) "jpeg", false))) {
            if (!StringsKt__StringsKt.m42454a(charSequence, (CharSequence) "png", false)) {
                Activity am_ = groupMessagingScreen.am_();
                if (am_ != null) {
                    if (ContextCompat.a(am_, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                        if (VERSION.SDK_INT >= 23) {
                            str = groupMessagingScreen.am_();
                            if (str != null) {
                                if (ActivityCompat.a(str, "android.permission.WRITE_EXTERNAL_STORAGE") != null) {
                                    Snackbar.a(groupMessagingScreen.K, Util.m24027f((int) C1761R.string.rdt_storage_permission_required_msg), 0).a("OKAY", new GroupMessagingScreen$requestStoragePermissions$1(groupMessagingScreen)).a();
                                    return;
                                }
                                groupMessagingScreen.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, f40213D);
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    am_ = groupMessagingScreen.am_();
                    if (am_ != null) {
                        new Builder(am_).b(Util.m24027f((int) C1761R.string.rdt_download_file_msg)).a("DOWNLOAD", new C1942x84b9e966(groupMessagingScreen, str)).b("CANCEL", null).c();
                        return;
                    }
                    return;
                }
                return;
            }
        }
        Timber.b("onFileMessageClicked: image", new Object[0]);
    }

    public static final /* synthetic */ void m41292d(GroupMessagingScreen groupMessagingScreen) {
        groupMessagingScreen = groupMessagingScreen.f40217v;
        if (groupMessagingScreen == null) {
            Intrinsics.m26844a("presenter");
        }
        groupMessagingScreen.mo5170b();
    }

    public static final /* synthetic */ void m41287a(GroupMessagingScreen groupMessagingScreen, MessageData messageData) {
        Activity am_ = groupMessagingScreen.am_();
        if (am_ != null) {
            new Builder(am_).a(Util.m24027f((int) C1761R.string.title_delete_message_dialog)).b("Are you sure you want to delete this message?").a("YES", new GroupMessagingScreen$deleteMessage$$inlined$let$lambda$1(groupMessagingScreen, messageData)).b("NO", GroupMessagingScreen$deleteMessage$1$2.f22352a).a().c();
        }
    }

    public static final /* synthetic */ void m41289b(GroupMessagingScreen groupMessagingScreen, HasMessageData hasMessageData) {
        Object e = Util.m24023e((int) C1761R.array.report_message_reasons);
        Intrinsics.m26843a(e, "Util.getStringArray(R.ar…y.report_message_reasons)");
        List i = ArraysKt___ArraysKt.m36109i((Object[]) e);
        CompositeDisposable compositeDisposable = groupMessagingScreen.f40215A;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = groupMessagingScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Object subscribe = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23301a((Context) am_, (Collection) i, (int) C1761R.string.action_report).observeOn(SchedulerProvider.m23886b()).flatMapObservable(new GroupMessagingScreen$showMessageReportDialog$1(groupMessagingScreen, hasMessageData, i)).observeOn(SchedulerProvider.m23887c()).subscribe(GroupMessagingScreen$showMessageReportDialog$2.f29866a, new GroupMessagingScreen$showMessageReportDialog$3(groupMessagingScreen));
        Intrinsics.m26843a(subscribe, "RedditAlertDialog.select…TH_LONG).show()\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }
}
