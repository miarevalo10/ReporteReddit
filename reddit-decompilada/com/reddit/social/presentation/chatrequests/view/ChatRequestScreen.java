package com.reddit.social.presentation.chatrequests.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.evernote.android.state.State;
import com.reddit.datalibrary.social.data.common.StateStorageBundle;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.MainActivity;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.ui.BottomNavScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.bottomnav.BottomNavView.Item;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.presentation.chatinbox.view.ChatInboxScreen;
import com.reddit.social.presentation.chatrequests.ChatRequestContract.Presenter;
import com.reddit.social.presentation.chatrequests.ChatRequestContract.View;
import com.reddit.social.presentation.groupchat.view.UserActions;
import com.reddit.social.presentation.messaginglist.MessageContentKt;
import com.reddit.social.presentation.messaginglist.MessageContentViewHolder;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.LinkEmbedState;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.ChatSharedPreferencesUtil;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.GroupChannel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.anko.Sdk21PropertiesKt;
import org.parceler.Parcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 ®\u00012\u00020\u00012\u00020\u0002:\u0004®\u0001¯\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010p\u001a\u00020qH\u0002J\u001a\u0010r\u001a\u00020q2\u0006\u0010d\u001a\u00020\b2\b\u0010s\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010t\u001a\u00020qH\u0016J\u0010\u0010u\u001a\u00020q2\u0006\u0010v\u001a\u00020\bH\u0016J\b\u0010w\u001a\u00020qH\u0016J\u0010\u0010x\u001a\u00020q2\u0006\u0010y\u001a\u00020zH\u0014J\u0016\u0010{\u001a\u00020q2\u0006\u0010v\u001a\u00020\b2\u0006\u0010|\u001a\u00020\bJ\b\u0010}\u001a\u00020qH\u0002J\b\u0010~\u001a\u00020qH\u0016J\b\u0010\u001a\u00020qH\u0016J5\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u00012 \b\u0002\u0010\u0001\u001a\u0019\u0012\u0013\u0012\u0011\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u00010\u0001\u0018\u00010jH\u0002J\t\u0010\u0001\u001a\u00020qH\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0007\u0010\u0001\u001a\u00020qJ\u0013\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020\\2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020\\H\u0016J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020\u0005H\u0014J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020\u0005H\u0014J\u0012\u0010\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020\bH\u0016J\u0013\u0010\u0001\u001a\u00020q2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020q2\u0006\u0010s\u001a\u00020\bH\u0016J\t\u0010\u0001\u001a\u00020qH\u0016J\u0015\u0010 \u0001\u001a\u00020q2\n\b\u0001\u0010¡\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010¢\u0001\u001a\u00020q2\u0007\u0010£\u0001\u001a\u00020kH\u0016J#\u0010¤\u0001\u001a\u00020q2\b\u0010¥\u0001\u001a\u00030¦\u00012\u000e\u0010§\u0001\u001a\t\u0012\u0004\u0012\u00020k0¨\u0001H\u0016J\u0012\u0010©\u0001\u001a\u00020q2\u0007\u0010\u0001\u001a\u00020\bH\u0016J\t\u0010ª\u0001\u001a\u00020qH\u0016J\u0013\u0010«\u0001\u001a\u00020q2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0012\u0010¬\u0001\u001a\u00020q2\u0007\u0010­\u0001\u001a\u00020kH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\u001e\u00107\u001a\u0002088\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016R\u001e\u0010@\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\u001e\u0010C\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R\u001e\u0010F\u001a\u00020G8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010L\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00101\"\u0004\bN\u00103R\u001e\u0010O\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0014\"\u0004\bQ\u0010\u0016R\u001e\u0010R\u001a\u00020S8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010X\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00101\"\u0004\bZ\u00103R\u001e\u0010[\u001a\u00020\\8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001e\u0010a\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103R\u001e\u0010d\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR2\u0010i\u001a&\u0012\f\u0012\n l*\u0004\u0018\u00010k0k l*\u0012\u0012\f\u0012\n l*\u0004\u0018\u00010k0k\u0018\u00010j0jX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010m\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0014\"\u0004\bo\u0010\u0016¨\u0006°\u0001"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/view/ChatRequestScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "KEY_NSFW_DIALOG_TRUEONCE", "", "acceptButton", "Landroid/widget/Button;", "getAcceptButton", "()Landroid/widget/Button;", "setAcceptButton", "(Landroid/widget/Button;)V", "adapter", "Lcom/reddit/social/presentation/chatrequests/view/MembersAdapter;", "blockerInfo", "Landroid/widget/TextView;", "getBlockerInfo", "()Landroid/widget/TextView;", "setBlockerInfo", "(Landroid/widget/TextView;)V", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatNote", "getChatNote", "setChatNote", "chatRequestMessage", "Landroid/widget/FrameLayout;", "getChatRequestMessage", "()Landroid/widget/FrameLayout;", "setChatRequestMessage", "(Landroid/widget/FrameLayout;)V", "declineButton", "getDeclineButton", "setDeclineButton", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "groupInfo", "getGroupInfo", "setGroupInfo", "inviter", "Landroid/widget/LinearLayout;", "getInviter", "()Landroid/widget/LinearLayout;", "setInviter", "(Landroid/widget/LinearLayout;)V", "inviterBlocked", "getInviterBlocked", "setInviterBlocked", "inviterIcon", "Landroid/widget/ImageView;", "getInviterIcon", "()Landroid/widget/ImageView;", "setInviterIcon", "(Landroid/widget/ImageView;)V", "inviterKarmaAndAge", "getInviterKarmaAndAge", "setInviterKarmaAndAge", "inviterName", "getInviterName", "setInviterName", "inviterNsfw", "getInviterNsfw", "setInviterNsfw", "membersList", "Landroid/support/v7/widget/RecyclerView;", "getMembersList", "()Landroid/support/v7/widget/RecyclerView;", "setMembersList", "(Landroid/support/v7/widget/RecyclerView;)V", "membersListContainer", "getMembersListContainer", "setMembersListContainer", "noConnectionBanner", "getNoConnectionBanner", "setNoConnectionBanner", "presenter", "Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$Presenter;", "getPresenter", "()Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$Presenter;", "setPresenter", "(Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$Presenter;)V", "previewMessageContainer", "getPreviewMessageContainer", "setPreviewMessageContainer", "progress", "Landroid/view/View;", "getProgress", "()Landroid/view/View;", "setProgress", "(Landroid/view/View;)V", "requestInfo", "getRequestInfo", "setRequestInfo", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "userClick", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "kotlin.jvm.PlatformType", "userHeader", "getUserHeader", "setUserHeader", "accept", "", "allowConfirmed", "title", "blockInviter", "blockMember", "userId", "closeScreen", "configureActionBar", "actionBar", "Landroid/support/v7/app/ActionBar;", "confirmBlockUser", "username", "decline", "declineConfirmed", "disableButtons", "drawMessage", "message", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "linkEmbedLoaded", "Lkotlin/Pair;", "", "Lcom/reddit/social/presentation/presentationobjects/LinkEmbedState;", "enableButtons", "getDefaultScreenPosition", "", "getLayoutId", "navToChatInbox", "networkConnectionChange", "hasNetworkConnection", "", "onBackPressed", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "view", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "setHeader", "header", "setRequestMessage", "setScreenTitle", "showBlockerInfo", "showErrorMessage", "messageRes", "showInviter", "userData", "showMembers", "channel", "Lcom/sendbird/android/GroupChannel;", "members", "", "showMessage", "showNsfwDialog", "showRequestInfo", "showUserReportDialog", "user", "Companion", "DeepLinker", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestScreen.kt */
public final class ChatRequestScreen extends MvpBaseScreen implements View {
    public static final Companion f40194x = new Companion();
    private CompositeDisposable f40195A;
    private final PublishSubject<UserData> f40196B = PublishSubject.create();
    @BindView
    public Button acceptButton;
    @BindView
    public TextView blockerInfo;
    @BindView
    public TextView chatNote;
    @BindView
    public FrameLayout chatRequestMessage;
    @BindView
    public Button declineButton;
    @BindView
    public TextView groupInfo;
    @BindView
    public LinearLayout inviter;
    @BindView
    public TextView inviterBlocked;
    @BindView
    public ImageView inviterIcon;
    @BindView
    public TextView inviterKarmaAndAge;
    @BindView
    public TextView inviterName;
    @BindView
    public TextView inviterNsfw;
    @BindView
    public RecyclerView membersList;
    @BindView
    public LinearLayout membersListContainer;
    @BindView
    public TextView noConnectionBanner;
    @BindView
    public LinearLayout previewMessageContainer;
    @BindView
    public android.view.View progress;
    @BindView
    public LinearLayout requestInfo;
    @State
    public String url;
    @BindView
    public TextView userHeader;
    @Inject
    public Presenter f40197v;
    @Inject
    public ChatAnalytics f40198w;
    private final String f40199y = "KEY_NSFW_DIALOG_TRUEONCE";
    private MembersAdapter f40200z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/view/ChatRequestScreen$Companion;", "", "()V", "deepLink", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "channelUrl", "", "newInstance", "Lcom/reddit/social/presentation/chatrequests/view/ChatRequestScreen;", "url", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatRequestScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ChatRequestScreen m24558a(String str) {
            Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
            ChatRequestScreen chatRequestScreen = new ChatRequestScreen();
            Intrinsics.m26847b(str, "<set-?>");
            chatRequestScreen.url = str;
            return chatRequestScreen;
        }

        public static ScreenDeepLinker m24559b(String str) {
            Intrinsics.m26847b(str, "channelUrl");
            DeepLinker deepLinker = new DeepLinker();
            deepLinker.setChannelUrl(str);
            return deepLinker;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22336a;

        static {
            int[] iArr = new int[UserActions.values().length];
            f22336a = iArr;
            iArr[UserActions.f22372a.ordinal()] = 1;
            f22336a[UserActions.f22374c.ordinal()] = 2;
            f22336a[UserActions.f22373b.ordinal()] = 3;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/view/ChatRequestScreen$DeepLinker;", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "()V", "channelUrl", "", "getChannelUrl", "()Ljava/lang/String;", "setChannelUrl", "(Ljava/lang/String;)V", "createScreen", "Lcom/reddit/frontpage/nav/Screen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Parcel
    /* compiled from: ChatRequestScreen.kt */
    public static final class DeepLinker implements ScreenDeepLinker {
        public String channelUrl;

        public final String getChannelUrl() {
            String str = this.channelUrl;
            if (str == null) {
                Intrinsics.m26844a("channelUrl");
            }
            return str;
        }

        public final void setChannelUrl(String str) {
            Intrinsics.m26847b(str, "<set-?>");
            this.channelUrl = str;
        }

        public final Screen createScreen() {
            Companion companion = ChatRequestScreen.f40194x;
            String str = this.channelUrl;
            if (str == null) {
                Intrinsics.m26844a("channelUrl");
            }
            return Companion.m24558a(str);
        }
    }

    public static final ChatRequestScreen m41206e(String str) {
        return Companion.m24558a(str);
    }

    public static final ScreenDeepLinker m41207f(String str) {
        return Companion.m24559b(str);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_chat_request;
    }

    public final int mo7143u() {
        return 2;
    }

    public ChatRequestScreen() {
        super();
        FrontpageApplication.m28878n().mo5091a(this);
    }

    public ChatRequestScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        FrontpageApplication.m28878n().mo5091a(this);
    }

    public final Presenter m41233w() {
        Presenter presenter = this.f40197v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return presenter;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        ButterKnife.a(this, this.K);
        layoutInflater = this.membersList;
        if (layoutInflater == null) {
            Intrinsics.m26844a("membersList");
        }
        layoutInflater.setLayoutManager((LayoutManager) new LinearLayoutManager(am_(), 1, false));
        layoutInflater = am_();
        if (layoutInflater == null) {
            Intrinsics.m26842a();
        }
        layoutInflater = DividerItemDecoration.m30092a((Context) layoutInflater, 1);
        viewGroup = this.membersList;
        if (viewGroup == null) {
            Intrinsics.m26844a("membersList");
        }
        viewGroup.addItemDecoration((ItemDecoration) layoutInflater);
        Object obj = this.f40196B;
        Intrinsics.m26843a(obj, "userClick");
        this.f40200z = new MembersAdapter(obj);
        layoutInflater = this.membersList;
        if (layoutInflater == null) {
            Intrinsics.m26844a("membersList");
        }
        viewGroup = this.f40200z;
        if (viewGroup == null) {
            Intrinsics.m26844a("adapter");
        }
        layoutInflater.setAdapter((Adapter) viewGroup);
        this.f40195A = new CompositeDisposable();
        layoutInflater = this.f40195A;
        if (layoutInflater == null) {
            Intrinsics.m26844a("disposables");
        }
        obj = this.f40196B.flatMapSingle(new ChatRequestScreen$onCreateView$1(this)).subscribe((Consumer) new ChatRequestScreen$onCreateView$2(this));
        Intrinsics.m26843a(obj, "userClick\n        .flatM…er)\n          }\n        }");
        DisposableKt.m26766a(layoutInflater, obj);
        layoutInflater = this.acceptButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("acceptButton");
        }
        layoutInflater.setOnClickListener((OnClickListener) new ChatRequestScreen$onCreateView$3(this));
        layoutInflater = this.declineButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("declineButton");
        }
        layoutInflater.setOnClickListener((OnClickListener) new ChatRequestScreen$onCreateView$4(this));
        layoutInflater = this.f40197v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        String str = this.url;
        if (str == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_URL);
        }
        layoutInflater.mo5127a(str);
        layoutInflater = this.f40197v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.mo5125a((View) this);
        layoutInflater = this.progress;
        if (layoutInflater == null) {
            Intrinsics.m26844a("progress");
        }
        layoutInflater.setBackground(AnimUtil.m23637a(am_()));
        Object obj2 = this.K;
        Intrinsics.m26843a(obj2, "rootView");
        return obj2;
    }

    public final void mo7517d(String str) {
        Intrinsics.m26847b(str, "userId");
        MembersAdapter membersAdapter = this.f40200z;
        if (membersAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        membersAdapter.m30711a(str);
    }

    public final void mo7519f() {
        TextView textView = this.inviterBlocked;
        if (textView == null) {
            Intrinsics.m26844a("inviterBlocked");
        }
        ViewsKt.m24107c(textView);
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, "message");
        Activity am_ = am_();
        if (am_ != null) {
            Object makeText = Toast.makeText(am_, str, 0);
            makeText.show();
            Intrinsics.m26843a(makeText, "Toast\n        .makeText(…         show()\n        }");
        }
    }

    public final void mo7518e() {
        String f = Util.m24027f((int) C1761R.string.rdt_label_chat_request_blocker_info_warning);
        String f2 = Util.m24027f((int) C1761R.string.rdt_label_chat_request_blocker_info);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f);
        stringBuilder.append(' ');
        stringBuilder.append(f2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
        TextView textView = this.blockerInfo;
        if (textView == null) {
            Intrinsics.m26844a("blockerInfo");
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ViewsKt.m24101a((android.view.View) textView, (int) C1761R.color.rdt_red)), 0, f.length(), 18);
        TextView textView2 = this.blockerInfo;
        if (textView2 == null) {
            Intrinsics.m26844a("blockerInfo");
        }
        textView2.setText(spannableStringBuilder);
        textView2 = this.blockerInfo;
        if (textView2 == null) {
            Intrinsics.m26844a("blockerInfo");
        }
        ViewsKt.m24107c(textView2);
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.a("");
    }

    public final void mo7511a(String str) {
        Intrinsics.m26847b(str, "title");
        m37537h(str);
    }

    public final void mo7509a(GroupChannel groupChannel) {
        Intrinsics.m26847b(groupChannel, "channel");
        android.view.View view = this.progress;
        if (view == null) {
            Intrinsics.m26844a("progress");
        }
        ViewsKt.m24109d(view);
        LinearLayout linearLayout = this.requestInfo;
        if (linearLayout == null) {
            Intrinsics.m26844a("requestInfo");
        }
        ViewsKt.m24107c(linearLayout);
        TextView textView = this.chatNote;
        if (textView == null) {
            Intrinsics.m26844a("chatNote");
        }
        Sdk21PropertiesKt.m28414b(textView, ChatUtilKt.m24765c(groupChannel) != null ? C1761R.string.rdt_label_chat_request : C1761R.string.rdt_label_group_chat_request);
    }

    public final void mo7507a(HasMessageData hasMessageData) {
        Intrinsics.m26847b(hasMessageData, "message");
        LinearLayout linearLayout = this.previewMessageContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("previewMessageContainer");
        }
        android.view.View view = linearLayout;
        Boolean bool = hasMessageData.mo5204a().f22433f;
        boolean z = true;
        if (bool != null ? bool.booleanValue() : true) {
            z = false;
        }
        ViewsKt.m24108c(view, z);
        PublishSubject create = PublishSubject.create();
        m41203a(hasMessageData, create);
        CompositeDisposable compositeDisposable = this.f40195A;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        Object subscribe = create.subscribe((Consumer) new ChatRequestScreen$setRequestMessage$1(this, hasMessageData));
        Intrinsics.m26843a(subscribe, "linkEmbedLoaded\n        …ssage(message)\n        })");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    private final void m41203a(HasMessageData hasMessageData, PublishSubject<Pair<Long, LinkEmbedState>> publishSubject) {
        FrameLayout frameLayout = this.chatRequestMessage;
        if (frameLayout == null) {
            Intrinsics.m26844a("chatRequestMessage");
        }
        MessageContentViewHolder a = MessageContentKt.m24709a((ViewGroup) frameLayout, hasMessageData.mo5204a().f22435h);
        a.m24711a(hasMessageData, null, publishSubject);
        frameLayout.addView(a.f22385a);
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        Presenter presenter = this.f40197v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5124a((StateStorageContract) new StateStorageBundle(bundle));
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        Presenter presenter = this.f40197v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5130b((StateStorageContract) new StateStorageBundle(bundle));
        super.mo7199c(bundle);
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        CompositeDisposable compositeDisposable = this.f40195A;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
        Presenter presenter = this.f40197v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5132c();
        super.mo6987a(view);
    }

    public final void mo7510a(GroupChannel groupChannel, List<UserData> list) {
        Intrinsics.m26847b(groupChannel, "channel");
        Intrinsics.m26847b(list, "members");
        groupChannel = ChatUtilKt.m24759b(groupChannel);
        String f = Util.m24027f((int) C1761R.string.rdt_label_this_group);
        int size = list.size();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list.size());
        if (groupChannel != null) {
            f = groupChannel;
        }
        objArr[1] = f;
        f = Util.m23959a((int) C1761R.plurals.fmt_num_users_in_group_chat, size, objArr);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(f);
        if (groupChannel != null) {
            spannableStringBuilder.setSpan(new StyleSpan(1), f.length() - groupChannel.length(), f.length(), 18);
        }
        groupChannel = this.groupInfo;
        if (groupChannel == null) {
            Intrinsics.m26844a("groupInfo");
        }
        groupChannel.setText(spannableStringBuilder);
        groupChannel = this.membersListContainer;
        if (groupChannel == null) {
            Intrinsics.m26844a("membersListContainer");
        }
        ViewsKt.m24107c((android.view.View) groupChannel);
        groupChannel = this.f40200z;
        if (groupChannel == null) {
            Intrinsics.m26844a("adapter");
        }
        groupChannel.m30712a((List) list);
    }

    public final void mo7508a(UserData userData) {
        Intrinsics.m26847b(userData, "userData");
        TextView textView = this.inviterName;
        if (textView == null) {
            Intrinsics.m26844a("inviterName");
        }
        textView.setText(userData.f22465b);
        String a = DateUtil.m22704a(userData.f22468e * 1000, 2);
        TextView textView2 = this.inviterKarmaAndAge;
        if (textView2 == null) {
            Intrinsics.m26844a("inviterKarmaAndAge");
        }
        r2 = new Object[2];
        boolean z = false;
        r2[0] = Integer.valueOf(userData.f22467d);
        r2[1] = a;
        textView2.setText(Util.m23960a((int) C1761R.string.fmt_num_karma_and_age_2, r2));
        boolean a2 = AccountPrefsUtil.m23630a(userData.f22465b, userData.f22470g);
        ImageView imageView = this.inviterIcon;
        if (imageView == null) {
            Intrinsics.m26844a("inviterIcon");
        }
        String str = userData.f22466c;
        Boolean valueOf = Boolean.valueOf(a2);
        ImageView imageView2 = this.inviterIcon;
        if (imageView2 == null) {
            Intrinsics.m26844a("inviterIcon");
        }
        AvatarUtilKt.m23659a(imageView, str, valueOf, Integer.valueOf(DimensionsKt.m28408a(imageView2.getContext(), C1761R.dimen.chat_request_inviter_radius)));
        textView2 = this.inviterNsfw;
        if (textView2 == null) {
            Intrinsics.m26844a("inviterNsfw");
        }
        ViewsKt.m24106b(textView2, a2);
        textView = this.inviterBlocked;
        if (textView == null) {
            Intrinsics.m26844a("inviterBlocked");
        }
        android.view.View view = textView;
        Boolean bool = userData.f22469f;
        if (bool != null) {
            z = bool.booleanValue();
        }
        ViewsKt.m24106b(view, z);
        LinearLayout linearLayout = this.inviter;
        if (linearLayout == null) {
            Intrinsics.m26844a("inviter");
        }
        linearLayout.setOnClickListener((OnClickListener) new ChatRequestScreen$inlined$sam$OnClickListener$i$7f478c20(new ChatRequestScreen$showInviter$2(this, userData)));
    }

    public final void mo7514b(String str) {
        Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
        Object C_ = C_();
        Intrinsics.m26843a(C_, "router");
        C_ = C_.m();
        Intrinsics.m26843a(C_, "router.backstack");
        if (C_.size() > 1 && (((RouterTransaction) C_.get(C_.size() - 2)).a() instanceof ChatRequestListScreen)) {
            C_().b(((RouterTransaction) C_.get(C_.size() - 2)).a());
        }
        C_().j();
        Routing.m22623a((Screen) this, Nav.m22558a(str, null, null, null));
    }

    public final void mo7505a() {
        Toast.makeText(am_(), "This chat invite was successfully declined.", 1).show();
        mo7520g();
    }

    public final void mo7506a(int i) {
        Toast.makeText(am_(), i, 1).show();
    }

    public final void mo7512a(boolean z) {
        TextView textView = this.noConnectionBanner;
        if (textView == null) {
            Intrinsics.m26844a("noConnectionBanner");
        }
        ViewsKt.m24106b(textView, z ^ 1);
    }

    public final void mo7516d() {
        android.view.View T_ = T_();
        Context context = T_ != null ? T_.getContext() : null;
        if (context != null) {
            RedditAlertDialog redditAlertDialog = new RedditAlertDialog(context);
            redditAlertDialog.f21113a.a(C1761R.string.rdt_nsfw_chat_request_dialog_title).b(C1761R.string.rdt_nsfw_chat_request_dialog_content).a(C1761R.string.action_continue, new ChatRequestScreen$showNsfwDialog$$inlined$apply$lambda$1(this)).b(C1761R.string.action_cancel, null);
            redditAlertDialog.m23323a();
        }
    }

    public final void mo7513b() {
        Button button = this.acceptButton;
        if (button == null) {
            Intrinsics.m26844a("acceptButton");
        }
        button.setEnabled(true);
        button = this.declineButton;
        if (button == null) {
            Intrinsics.m26844a("declineButton");
        }
        button.setEnabled(true);
    }

    public final void mo7515c() {
        Button button = this.acceptButton;
        if (button == null) {
            Intrinsics.m26844a("acceptButton");
        }
        button.setEnabled(false);
        button = this.declineButton;
        if (button == null) {
            Intrinsics.m26844a("declineButton");
        }
        button.setEnabled(false);
    }

    public final boolean mo6986J() {
        mo7520g();
        return true;
    }

    public final void mo7520g() {
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
    }

    public static final /* synthetic */ void m41202a(ChatRequestScreen chatRequestScreen, UserData userData) {
        Object e = Util.m24023e((int) C1761R.array.report_user_reasons);
        Intrinsics.m26843a(e, "Util.getStringArray(R.array.report_user_reasons)");
        List i = ArraysKt___ArraysKt.m36109i((Object[]) e);
        CompositeDisposable compositeDisposable = chatRequestScreen.f40195A;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = chatRequestScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Object subscribe = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23301a((Context) am_, (Collection) i, (int) C1761R.string.action_report).observeOn(SchedulerProvider.m23886b()).flatMapObservable(new ChatRequestScreen$showUserReportDialog$1(chatRequestScreen, userData, i)).observeOn(SchedulerProvider.m23887c()).subscribe(new ChatRequestScreen$showUserReportDialog$2(chatRequestScreen), new ChatRequestScreen$showUserReportDialog$3(chatRequestScreen));
        Intrinsics.m26843a(subscribe, "RedditAlertDialog.select… be reported.\")\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public static final /* synthetic */ void m41200a(ChatRequestScreen chatRequestScreen) {
        Activity am_ = chatRequestScreen.am_();
        if (am_ != null) {
            Presenter presenter = chatRequestScreen.f40197v;
            if (presenter == null) {
                Intrinsics.m26844a("presenter");
            }
            presenter.mo5128a(ChatSharedPreferencesUtil.m24746a((Context) am_, chatRequestScreen.f40199y));
        }
    }

    public static final /* synthetic */ void m41204b(ChatRequestScreen chatRequestScreen) {
        chatRequestScreen = chatRequestScreen.f40197v;
        if (chatRequestScreen == null) {
            Intrinsics.m26844a("presenter");
        }
        chatRequestScreen.mo5129b();
    }
}
