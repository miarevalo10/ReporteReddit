package com.reddit.social.presentation.chatrequests.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.social.data.common.StateStorageBundle;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.presentation.chatinbox.view.ChatInboxItemAdapter;
import com.reddit.social.presentation.chatinbox.view.ChatInboxItemEvent;
import com.reddit.social.presentation.chatrequests.ChatRequestListContract.Presenter;
import com.reddit.social.presentation.chatrequests.ChatRequestListContract.View;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020CH\u0016J\u0018\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\"H\u0016J\u0010\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020\u0005H\u0014J\u0010\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020\u0005H\u0014J\u0018\u0010O\u001a\u00020<2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010QH\u0016J\u0006\u0010S\u001a\u00020<J\u000e\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020VJ\u0010\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020VH\u0016J\u0006\u0010Y\u001a\u00020<J\b\u0010Z\u001a\u00020<H\u0016J\b\u0010[\u001a\u00020<H\u0016J\u000e\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u00020VR\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010 R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006_"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/view/ChatRequestListScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "adapter", "Lcom/reddit/social/presentation/chatinbox/view/ChatInboxItemAdapter;", "contentContainer", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "setContentContainer", "(Landroid/widget/FrameLayout;)V", "emptyContainer", "Landroid/view/ViewStub;", "getEmptyContainer", "()Landroid/view/ViewStub;", "setEmptyContainer", "(Landroid/view/ViewStub;)V", "errorContainer", "Landroid/widget/LinearLayout;", "getErrorContainer", "()Landroid/widget/LinearLayout;", "setErrorContainer", "(Landroid/widget/LinearLayout;)V", "errorMessage", "Landroid/widget/TextView;", "getErrorMessage", "()Landroid/widget/TextView;", "setErrorMessage", "(Landroid/widget/TextView;)V", "loadingSnoo", "Landroid/view/View;", "noConnectionBanner", "getNoConnectionBanner", "setNoConnectionBanner", "presenter", "Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$Presenter;", "getPresenter", "()Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$Presenter;", "setPresenter", "(Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$Presenter;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "retryButton", "getRetryButton", "setRetryButton", "swipeRefreshLayout", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroid/support/v4/widget/SwipeRefreshLayout;)V", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "getLayoutId", "", "networkConnectionChange", "hasNetworkConnection", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "view", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "showChatRequests", "chatRequests", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "showContent", "showError", "errorText", "", "showErrorMessage", "message", "showLoading", "showLoadingMore", "showRefreshing", "toChatRequestScreen", "url", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestListScreen.kt */
public final class ChatRequestListScreen extends MvpBaseScreen implements View {
    public static final Companion f40190w = new Companion();
    @BindView
    public FrameLayout contentContainer;
    @BindView
    public ViewStub emptyContainer;
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
    public SwipeRefreshLayout swipeRefreshLayout;
    @Inject
    public Presenter f40191v;
    private android.view.View f40192x;
    private ChatInboxItemAdapter f40193y;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/view/ChatRequestListScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/social/presentation/chatrequests/view/ChatRequestListScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatRequestListScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ChatRequestListScreen m24557a() {
            return new ChatRequestListScreen();
        }
    }

    public static final ChatRequestListScreen m41187x() {
        return Companion.m24557a();
    }

    public final int mo7141s() {
        return C1761R.layout.screen_chat_request_list;
    }

    public static final /* synthetic */ ChatInboxItemAdapter m41185a(ChatRequestListScreen chatRequestListScreen) {
        chatRequestListScreen = chatRequestListScreen.f40193y;
        if (chatRequestListScreen == null) {
            Intrinsics.m26844a("adapter");
        }
        return chatRequestListScreen;
    }

    public ChatRequestListScreen() {
        super();
        FrontpageApplication.m28878n().mo5090a(this);
    }

    public ChatRequestListScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        FrontpageApplication.m28878n().mo5090a(this);
    }

    public final Presenter m41199w() {
        Presenter presenter = this.f40191v;
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
        layoutInflater = new LinearLayoutManager(am_(), 1, false);
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.setLayoutManager((LayoutManager) layoutInflater);
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
        viewGroup.addOnScrollListener(new ChatRequestListScreen$onCreateView$1(this, layoutInflater));
        this.f40193y = new ChatInboxItemAdapter(false, (ChatInboxItemEvent) new ChatRequestListScreen$onCreateView$2(this));
        layoutInflater = this.recyclerView;
        if (layoutInflater == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup = this.f40193y;
        if (viewGroup == null) {
            Intrinsics.m26844a("adapter");
        }
        layoutInflater.setAdapter((Adapter) viewGroup);
        layoutInflater = this.swipeRefreshLayout;
        if (layoutInflater == null) {
            Intrinsics.m26844a("swipeRefreshLayout");
        }
        layoutInflater.setOnRefreshListener((OnRefreshListener) new ChatRequestListScreen$onCreateView$3(this));
        Object findViewById = this.K.findViewById(C1761R.id.progress_bar);
        Intrinsics.m26843a(findViewById, "rootView.findViewById(R.id.progress_bar)");
        this.f40192x = findViewById;
        layoutInflater = this.f40192x;
        if (layoutInflater == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        layoutInflater.setBackground(AnimUtil.m23637a(am_()));
        layoutInflater = this.errorContainer;
        if (layoutInflater == null) {
            Intrinsics.m26844a("errorContainer");
        }
        layoutInflater.setVisibility(8);
        layoutInflater = this.contentContainer;
        if (layoutInflater == null) {
            Intrinsics.m26844a("contentContainer");
        }
        layoutInflater.setVisibility(0);
        layoutInflater = this.f40192x;
        if (layoutInflater == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        layoutInflater.setVisibility(0);
        layoutInflater = this.f40191v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.mo5118a((View) this);
        findViewById = this.K;
        Intrinsics.m26843a(findViewById, "rootView");
        return findViewById;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.a(Util.m24027f((int) C1761R.string.rdt_title_chat_request_list_screen));
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        Presenter presenter = this.f40191v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5117a((StateStorageContract) new StateStorageBundle(bundle));
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        Presenter presenter = this.f40191v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5120b(new StateStorageBundle(bundle));
        super.mo7199c(bundle);
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        Presenter presenter = this.f40191v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5121c();
        super.mo6987a(view);
    }

    public final void mo7502a(List<ChatInboxItem> list) {
        if (list == null) {
            m41186b("Ahhh! We couldn't load your chat requests.");
        } else if (list.isEmpty()) {
            m41186b("Looks like you don't have any chat requests.");
        } else {
            ChatInboxItemAdapter chatInboxItemAdapter = this.f40193y;
            if (chatInboxItemAdapter == null) {
                Intrinsics.m26844a("adapter");
            }
            chatInboxItemAdapter.m30650a(list);
            list = this.errorContainer;
            if (list == null) {
                Intrinsics.m26844a("errorContainer");
            }
            list.setVisibility(8);
            list = this.contentContainer;
            if (list == null) {
                Intrinsics.m26844a("contentContainer");
            }
            list.setVisibility(0);
            list = this.f40192x;
            if (list == null) {
                Intrinsics.m26844a("loadingSnoo");
            }
            list.setVisibility(8);
            list = this.swipeRefreshLayout;
            if (list == null) {
                Intrinsics.m26844a("swipeRefreshLayout");
            }
            list.setRefreshing(false);
            list = this.f40193y;
            if (list == null) {
                Intrinsics.m26844a("adapter");
            }
            if (list.m30647a() == null) {
                list = this.emptyContainer;
                if (list == null) {
                    Intrinsics.m26844a("emptyContainer");
                }
                list.setVisibility(0);
                return;
            }
            list = this.emptyContainer;
            if (list == null) {
                Intrinsics.m26844a("emptyContainer");
            }
            list.setVisibility(8);
        }
    }

    public final void mo7501a(String str) {
        Intrinsics.m26847b(str, "message");
        Toast.makeText(am_(), str, 1).show();
    }

    public final void mo7500a() {
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout == null) {
            Intrinsics.m26844a("swipeRefreshLayout");
        }
        swipeRefreshLayout.setRefreshing(true);
    }

    public final void mo7504b() {
        android.view.View view = this.f40192x;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        view.setVisibility(0);
    }

    private void m41186b(String str) {
        Intrinsics.m26847b(str, "errorText");
        android.view.View view = this.f40192x;
        if (view == null) {
            Intrinsics.m26844a("loadingSnoo");
        }
        view.setVisibility(8);
        FrameLayout frameLayout = this.contentContainer;
        if (frameLayout == null) {
            Intrinsics.m26844a("contentContainer");
        }
        frameLayout.setVisibility(8);
        LinearLayout linearLayout = this.errorContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("errorContainer");
        }
        linearLayout.setVisibility(0);
        ViewStub viewStub = this.emptyContainer;
        if (viewStub == null) {
            Intrinsics.m26844a("emptyContainer");
        }
        viewStub.setVisibility(8);
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout == null) {
            Intrinsics.m26844a("swipeRefreshLayout");
        }
        swipeRefreshLayout.setRefreshing(false);
        TextView textView = this.errorMessage;
        if (textView == null) {
            Intrinsics.m26844a("errorMessage");
        }
        textView.setText(str);
    }

    public final void mo7503a(boolean z) {
        TextView textView = this.noConnectionBanner;
        if (textView == null) {
            Intrinsics.m26844a("noConnectionBanner");
        }
        ViewsKt.m24106b(textView, z ^ 1);
    }
}
