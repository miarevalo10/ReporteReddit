package com.reddit.social.presentation.chatinbox.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.social.data.common.StateStorageBundle;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.presentation.chatinbox.ChatInboxContract.Presenter;
import com.reddit.social.presentation.chatinbox.ChatInboxContract.View;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.presentation.chatinbox.view.LoadingState.CONTENT;
import com.reddit.social.presentation.chatinbox.view.LoadingState.EMPTY;
import com.reddit.social.presentation.chatinbox.view.LoadingState.ERROR;
import com.reddit.social.presentation.chatinbox.view.LoadingState.LOADING;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import org.parceler.Parcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0006\u0001\u0001\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020fH\u0014J\b\u0010g\u001a\u00020hH\u0016J\b\u0010i\u001a\u00020fH\u0016J\u0010\u0010j\u001a\u00020h2\u0006\u0010k\u001a\u00020fH\u0016J\u0010\u0010l\u001a\u00020h2\u0006\u0010m\u001a\u00020nH\u0014J\u0018\u0010o\u001a\u00020h2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0016J\u0018\u0010t\u001a\u0002012\u0006\u0010r\u001a\u00020u2\u0006\u0010v\u001a\u00020wH\u0016J\u0010\u0010x\u001a\u00020h2\u0006\u0010y\u001a\u000201H\u0016J\u0010\u0010z\u001a\u00020f2\u0006\u0010{\u001a\u00020|H\u0016J\u0010\u0010}\u001a\u00020h2\u0006\u0010~\u001a\u00020\u0005H\u0014J\u0011\u0010\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020\u0005H\u0014J\u0013\u0010\u0001\u001a\u00020h2\b\u0010\u0001\u001a\u00030\u0001H\u0002J%\u0010\u0001\u001a\u00020h2\u0011\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020fH\u0016J\u0013\u0010\u0001\u001a\u00020h2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0011\u0010\u0001\u001a\u00020h2\b\u0010\u0001\u001a\u00030\u0001J\t\u0010\u0001\u001a\u00020hH\u0016J\u0014\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020dH\u0016J\t\u0010\u0001\u001a\u00020hH\u0016J\t\u0010\u0001\u001a\u00020hH\u0016J\t\u0010\u0001\u001a\u00020hH\u0016J\t\u0010\u0001\u001a\u00020hH\u0016J\t\u0010\u0001\u001a\u00020hH\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001e\u00109\u001a\u00020:8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010-\"\u0004\bG\u0010/R\u001e\u0010H\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010'\"\u0004\bJ\u0010)R\u001e\u0010K\u001a\u00020L8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010Q\u001a\u00020L8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010N\"\u0004\bS\u0010PR\u001e\u0010T\u001a\u00020U8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001e\u0010Z\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R\u001e\u0010]\u001a\u00020^8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006\u0001"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "adapter", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxItemAdapter;", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatNavType", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;", "getChatNavType", "()Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;", "setChatNavType", "(Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;)V", "chatPerfAnalytics", "Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "getChatPerfAnalytics", "()Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "setChatPerfAnalytics", "(Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;)V", "contentContainer", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "setContentContainer", "(Landroid/widget/FrameLayout;)V", "emptyContainer", "getEmptyContainer", "setEmptyContainer", "errorContainer", "Landroid/widget/LinearLayout;", "getErrorContainer", "()Landroid/widget/LinearLayout;", "setErrorContainer", "(Landroid/widget/LinearLayout;)V", "errorMessage", "Landroid/widget/TextView;", "getErrorMessage", "()Landroid/widget/TextView;", "setErrorMessage", "(Landroid/widget/TextView;)V", "loadingSnoo", "Landroid/view/View;", "getLoadingSnoo", "()Landroid/view/View;", "setLoadingSnoo", "(Landroid/view/View;)V", "noConnectionBanner", "getNoConnectionBanner", "setNoConnectionBanner", "presenter", "Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$Presenter;", "getPresenter", "()Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$Presenter;", "setPresenter", "(Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$Presenter;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "retryButton", "getRetryButton", "setRetryButton", "splashScreen", "getSplashScreen", "setSplashScreen", "splashStartButton", "Landroid/widget/Button;", "getSplashStartButton", "()Landroid/widget/Button;", "setSplashStartButton", "(Landroid/widget/Button;)V", "startChatButton", "getStartChatButton", "setStartChatButton", "swipeRefreshLayout", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroid/support/v4/widget/SwipeRefreshLayout;)V", "toolbarTitle", "getToolbarTitle", "setToolbarTitle", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getLayoutId", "", "hasNavigationDrawer", "", "hideLoadingMore", "", "isShowingSplash", "networkConnectionChange", "hasNetworkConnection", "onActivityStarted", "activity", "Landroid/app/Activity;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "view", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "openGroupMessaging", "chatInboxItem", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "renderConversations", "conversations", "", "updateViewStateOnErrorOrEmpty", "seeAll", "show", "loadingState", "Lcom/reddit/social/presentation/chatinbox/view/LoadingState;", "showContentScreen", "showErrorMessage", "message", "showInbox", "showLoading", "showLoadingMore", "showSplashScreen", "startNewChat", "ChatNavType", "Companion", "DeepLinker", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxScreen.kt */
public final class ChatInboxScreen extends MvpBaseScreen implements View {
    public static final Companion f40185y = new Companion();
    @State
    ChatNavType chatNavType = ChatNavType.f22323a;
    @BindView
    public FrameLayout contentContainer;
    @BindView
    public FrameLayout emptyContainer;
    @BindView
    public LinearLayout errorContainer;
    @BindView
    public TextView errorMessage;
    @BindView
    public android.view.View loadingSnoo;
    @BindView
    public TextView noConnectionBanner;
    @BindView
    public RecyclerView recyclerView;
    @BindView
    public TextView retryButton;
    @BindView
    public LinearLayout splashScreen;
    @BindView
    public Button splashStartButton;
    @BindView
    public Button startChatButton;
    @BindView
    public SwipeRefreshLayout swipeRefreshLayout;
    @BindView
    public TextView toolbarTitle;
    @State
    String url = "";
    @Inject
    public Presenter f40186v;
    @Inject
    public ChatAnalytics f40187w;
    @Inject
    public ChatPerformanceAnalyticsContract f40188x;
    private ChatInboxItemAdapter f40189z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;", "", "(Ljava/lang/String;I)V", "INBOX", "INVITE", "CHAT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxScreen.kt */
    public enum ChatNavType {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001c\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$Companion;", "", "()V", "deepLink", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "channelUrl", "", "navType", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;", "newInstance", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen;", "url", "chatNavType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ChatInboxScreen m24516a(String str, ChatNavType chatNavType) {
            Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
            Intrinsics.m26847b(chatNavType, "chatNavType");
            ChatInboxScreen chatInboxScreen = new ChatInboxScreen();
            chatInboxScreen.m41172a(str);
            chatInboxScreen.m41171a(chatNavType);
            return chatInboxScreen;
        }

        public static ScreenDeepLinker m24517b(String str, ChatNavType chatNavType) {
            Intrinsics.m26847b(str, "channelUrl");
            Intrinsics.m26847b(chatNavType, "navType");
            DeepLinker deepLinker = new DeepLinker();
            deepLinker.setChannelUrl(str);
            deepLinker.setChatNavType(chatNavType);
            return deepLinker;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22327a;

        static {
            int[] iArr = new int[ChatNavType.values().length];
            f22327a = iArr;
            iArr[ChatNavType.f22323a.ordinal()] = 1;
            f22327a[ChatNavType.f22325c.ordinal()] = 2;
            f22327a[ChatNavType.f22324b.ordinal()] = 3;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$DeepLinker;", "Lcom/reddit/frontpage/util/DeepLinkUtil$ScreenDeepLinker;", "()V", "channelUrl", "", "getChannelUrl", "()Ljava/lang/String;", "setChannelUrl", "(Ljava/lang/String;)V", "chatNavType", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;", "getChatNavType", "()Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;", "setChatNavType", "(Lcom/reddit/social/presentation/chatinbox/view/ChatInboxScreen$ChatNavType;)V", "createScreen", "Lcom/reddit/frontpage/nav/Screen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    @Parcel
    /* compiled from: ChatInboxScreen.kt */
    public static final class DeepLinker implements ScreenDeepLinker {
        public String channelUrl;
        public ChatNavType chatNavType;

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

        public final ChatNavType getChatNavType() {
            ChatNavType chatNavType = this.chatNavType;
            if (chatNavType == null) {
                Intrinsics.m26844a("chatNavType");
            }
            return chatNavType;
        }

        public final void setChatNavType(ChatNavType chatNavType) {
            Intrinsics.m26847b(chatNavType, "<set-?>");
            this.chatNavType = chatNavType;
        }

        public final Screen createScreen() {
            Companion companion = ChatInboxScreen.f40185y;
            String str = this.channelUrl;
            if (str == null) {
                Intrinsics.m26844a("channelUrl");
            }
            ChatNavType chatNavType = this.chatNavType;
            if (chatNavType == null) {
                Intrinsics.m26844a("chatNavType");
            }
            return Companion.m24516a(str, chatNavType);
        }
    }

    public static final ScreenDeepLinker m41159a(String str, ChatNavType chatNavType) {
        return Companion.m24517b(str, chatNavType);
    }

    protected final boolean af_() {
        return true;
    }

    public final int mo7141s() {
        return C1761R.layout.screen_conversation;
    }

    public static final /* synthetic */ ChatInboxItemAdapter m41160a(ChatInboxScreen chatInboxScreen) {
        chatInboxScreen = chatInboxScreen.f40189z;
        if (chatInboxScreen == null) {
            Intrinsics.m26844a("adapter");
        }
        return chatInboxScreen;
    }

    public final Presenter m41184w() {
        Presenter presenter = this.f40186v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return presenter;
    }

    public final void m41172a(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.url = str;
    }

    public final void m41171a(ChatNavType chatNavType) {
        Intrinsics.m26847b(chatNavType, "<set-?>");
        this.chatNavType = chatNavType;
    }

    public ChatInboxScreen() {
        super();
        FrontpageApplication.m28878n().mo5087a(this);
    }

    public ChatInboxScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        FrontpageApplication.m28878n().mo5087a(this);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = this.f40186v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.mo5108a((View) this);
        n();
        this.f40189z = new ChatInboxItemAdapter(true, (ChatInboxItemEvent) new ChatInboxScreen$onCreateView$1(this));
        layoutInflater = new LinearLayoutManager(am_(), 1, false);
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.setLayoutManager((LayoutManager) layoutInflater);
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        ChatInboxItemAdapter chatInboxItemAdapter = this.f40189z;
        if (chatInboxItemAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        viewGroup.setAdapter(chatInboxItemAdapter);
        viewGroup = am_();
        if (viewGroup == null) {
            Intrinsics.m26842a();
        }
        viewGroup = DividerItemDecoration.m30092a((Context) viewGroup, 1);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.m26844a("recyclerView");
        }
        recyclerView.addItemDecoration((ItemDecoration) viewGroup);
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.addOnScrollListener(new ChatInboxScreen$onCreateView$2(this, layoutInflater));
        layoutInflater = this.swipeRefreshLayout;
        if (layoutInflater == null) {
            Intrinsics.m26844a("swipeRefreshLayout");
        }
        layoutInflater.setOnRefreshListener((OnRefreshListener) new ChatInboxScreen$onCreateView$3(this));
        layoutInflater = this.startChatButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("startChatButton");
        }
        layoutInflater.setOnClickListener((OnClickListener) new ChatInboxScreen$onCreateView$4(this));
        layoutInflater = this.splashStartButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("splashStartButton");
        }
        layoutInflater.setOnClickListener((OnClickListener) new ChatInboxScreen$onCreateView$5(this));
        layoutInflater = this.retryButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("retryButton");
        }
        ViewsKt.m24109d((android.view.View) layoutInflater);
        layoutInflater = this.loadingSnoo;
        if (layoutInflater == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        layoutInflater.setBackground(AnimUtil.m23637a(am_()));
        layoutInflater = this.toolbarTitle;
        if (layoutInflater == null) {
            Intrinsics.m26844a("toolbarTitle");
        }
        viewGroup = am_();
        if (viewGroup == null) {
            Intrinsics.m26842a();
        }
        layoutInflater.setText(viewGroup.getString(C1761R.string.rdt_title_conversations_screen));
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void mo7499f() {
        switch (WhenMappings.f22327a[this.chatNavType.ordinal()]) {
            case 1:
                LinearLayout linearLayout = this.splashScreen;
                if (linearLayout == null) {
                    Intrinsics.m26844a("splashScreen");
                }
                ViewsKt.m24109d(linearLayout);
                SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
                if (swipeRefreshLayout == null) {
                    Intrinsics.m26844a("swipeRefreshLayout");
                }
                ViewsKt.m24107c(swipeRefreshLayout);
                break;
            case 2:
                Routing.m22623a((Screen) this, Nav.m22558a(this.url, null, null, null));
                break;
            case 3:
                Routing.m22623a((Screen) this, Nav.m22609t(this.url));
                break;
            default:
                break;
        }
        this.url = "";
        this.chatNavType = ChatNavType.f22323a;
    }

    public final boolean an_() {
        LinearLayout linearLayout = this.splashScreen;
        if (linearLayout == null) {
            Intrinsics.m26844a("splashScreen");
        }
        return ViewsKt.m24104a(linearLayout);
    }

    public final void mo7498e() {
        LinearLayout linearLayout = this.splashScreen;
        if (linearLayout == null) {
            Intrinsics.m26844a("splashScreen");
        }
        ViewsKt.m24107c(linearLayout);
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout == null) {
            Intrinsics.m26844a("swipeRefreshLayout");
        }
        ViewsKt.m24109d(swipeRefreshLayout);
    }

    protected final void m41168a(Activity activity) {
        Intrinsics.m26847b(activity, "activity");
        super.a(activity);
        activity = this.f40186v;
        if (activity == null) {
            Intrinsics.m26844a("presenter");
        }
        activity.mo5109b();
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        Presenter presenter = this.f40186v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5111c();
        super.mo6987a(view);
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        Presenter presenter = this.f40186v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5107a((StateStorageContract) new StateStorageBundle(bundle));
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        Presenter presenter = this.f40186v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5110b(new StateStorageBundle(bundle));
        super.mo7199c(bundle);
    }

    public final void m41169a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_chat_inbox, menu);
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_chat) {
            return super.mo7201a(menuItem);
        }
        m41165x();
        return true;
    }

    public final void mo7492a(List<ChatInboxItem> list, boolean z) {
        if (list == null) {
            if (z) {
                m41162a((LoadingState) new ERROR());
            }
        } else if (list.isEmpty()) {
            if (z) {
                m41162a((LoadingState) EMPTY.f29633a);
            }
        } else {
            z = this.f40189z;
            if (!z) {
                Intrinsics.m26844a("adapter");
            }
            z.m30650a(list);
            m41162a((LoadingState) CONTENT.f29632a);
        }
    }

    public final void mo7491a() {
        m41162a((LoadingState) LOADING.f29635a);
    }

    public final void mo7495b() {
        android.view.View view = this.loadingSnoo;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        ViewsKt.m24107c(view);
    }

    public final void mo7496c() {
        android.view.View view = this.loadingSnoo;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        ViewsKt.m24109d(view);
    }

    private final void m41165x() {
        ChatAnalytics chatAnalytics = this.f40187w;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        chatAnalytics.m24471a("click", "create_chat");
        Routing.m22623a((Screen) this, Nav.m22596k());
    }

    private void m41162a(LoadingState loadingState) {
        boolean z;
        Intrinsics.m26847b(loadingState, "loadingState");
        android.view.View view = this.loadingSnoo;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        boolean z2 = loadingState instanceof LOADING;
        ViewsKt.m24106b(view, z2);
        LinearLayout linearLayout = this.errorContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("errorContainer");
        }
        boolean z3 = loadingState instanceof ERROR;
        ViewsKt.m24106b(linearLayout, z3);
        FrameLayout frameLayout = this.emptyContainer;
        if (frameLayout == null) {
            Intrinsics.m26844a("emptyContainer");
        }
        ViewsKt.m24106b(frameLayout, loadingState instanceof EMPTY);
        frameLayout = this.contentContainer;
        if (frameLayout == null) {
            Intrinsics.m26844a("contentContainer");
        }
        view = frameLayout;
        if (!(loadingState instanceof CONTENT)) {
            if (!z2) {
                z = false;
                ViewsKt.m24106b(view, z);
                if (!z2) {
                    SwipeRefreshLayout swipeRefreshLayout;
                    swipeRefreshLayout = this.swipeRefreshLayout;
                    if (swipeRefreshLayout == null) {
                        Intrinsics.m26844a("swipeRefreshLayout");
                    }
                    swipeRefreshLayout.setRefreshing(false);
                }
                if (z3) {
                    TextView textView;
                    textView = this.errorMessage;
                    if (textView == null) {
                        Intrinsics.m26844a("errorMessage");
                    }
                    Object obj = this.K;
                    Intrinsics.m26843a(obj, "rootView");
                    textView.setText(obj.getContext().getString(((ERROR) loadingState).f29634a));
                }
            }
        }
        z = true;
        ViewsKt.m24106b(view, z);
        if (z2) {
            swipeRefreshLayout = this.swipeRefreshLayout;
            if (swipeRefreshLayout == null) {
                Intrinsics.m26844a("swipeRefreshLayout");
            }
            swipeRefreshLayout.setRefreshing(false);
        }
        if (z3) {
            textView = this.errorMessage;
            if (textView == null) {
                Intrinsics.m26844a("errorMessage");
            }
            Object obj2 = this.K;
            Intrinsics.m26843a(obj2, "rootView");
            textView.setText(obj2.getContext().getString(((ERROR) loadingState).f29634a));
        }
    }

    public final void mo7497d() {
        m41162a((LoadingState) new ERROR());
    }

    public final void mo7493a(boolean z) {
        TextView textView = this.noConnectionBanner;
        if (textView == null) {
            Intrinsics.m26844a("noConnectionBanner");
        }
        ViewsKt.m24106b(textView, z ^ 1);
    }

    public static final /* synthetic */ void m41161a(ChatInboxScreen chatInboxScreen, ChatInboxItem chatInboxItem) {
        if (chatInboxItem.f22315c) {
            Routing.m22619a((Context) chatInboxScreen.am_(), Nav.m22558a(chatInboxItem.f22314b, null, null, null));
        } else {
            Routing.m22619a((Context) chatInboxScreen.am_(), Nav.m22609t(chatInboxItem.f22314b));
        }
    }

    public static final /* synthetic */ void m41164b(ChatInboxScreen chatInboxScreen, ChatInboxItem chatInboxItem) {
        if (chatInboxItem.f22315c == null) {
            Routing.m22619a((Context) chatInboxScreen.am_(), Nav.m22593j());
        }
    }
}
