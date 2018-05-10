package com.reddit.social.presentation.groupchat.view;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import butterknife.BindView;
import com.reddit.datalibrary.social.data.common.StateStorageBundle;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.EditTextWithCounter;
import com.reddit.social.presentation.chatrequests.view.MembersAdapter;
import com.reddit.social.presentation.contacts.view.ContactsActionType;
import com.reddit.social.presentation.contacts.view.ContactsActionType.ADD;
import com.reddit.social.presentation.contacts.view.ContactsActionType.CREATE;
import com.reddit.social.presentation.groupchat.ChatSettingsContract.Presenter;
import com.reddit.social.presentation.groupchat.ChatSettingsContract.View;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0014J\u0018\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020QH\u0016J\b\u0010S\u001a\u00020LH\u0016J\b\u0010T\u001a\u00020LH\u0016J\b\u0010U\u001a\u00020LH\u0016J\b\u0010V\u001a\u00020LH\u0002J\b\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020LH\u0016J\b\u0010Z\u001a\u00020LH\u0016J\u0010\u0010[\u001a\u00020L2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u00020`H\u0014J\u0018\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010f\u001a\u00020L2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010g\u001a\u00020]2\u0006\u0010h\u001a\u00020iH\u0016J\u0010\u0010j\u001a\u00020L2\u0006\u0010k\u001a\u00020\u0005H\u0014J\u0010\u0010l\u001a\u00020L2\u0006\u0010m\u001a\u00020\u0005H\u0014J\u001e\u0010n\u001a\u00020L2\u0006\u0010o\u001a\u00020Q2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020I0qH\u0016J\u001e\u0010r\u001a\u00020L2\u0006\u0010o\u001a\u00020Q2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020I0sH\u0016J\u0010\u0010t\u001a\u00020L2\u0006\u0010u\u001a\u00020]H\u0016J\b\u0010v\u001a\u00020LH\u0016J\u0012\u0010w\u001a\u00020L2\b\u0010x\u001a\u0004\u0018\u00010QH\u0016J\b\u0010y\u001a\u00020LH\u0016J\u0016\u0010z\u001a\u00020L2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020I0sH\u0016J\u0010\u0010{\u001a\u00020L2\u0006\u0010|\u001a\u00020XH\u0016J\u0010\u0010}\u001a\u00020L2\u0006\u0010~\u001a\u00020QH\u0016J\b\u0010\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020IH\u0002J\u0015\u0010\u0001\u001a\u00020L2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001e\u00102\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\n\"\u0004\b4\u0010\fR\u001e\u00105\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\n\"\u0004\b7\u0010\fR\u001e\u00108\u001a\u0002098\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010>\u001a\u00020?8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\n\"\u0004\bF\u0010\fR2\u0010G\u001a&\u0012\f\u0012\n J*\u0004\u0018\u00010I0I J*\u0012\u0012\f\u0012\n J*\u0004\u0018\u00010I0I\u0018\u00010H0HX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/reddit/social/presentation/groupchat/view/MessagingSettingsScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "addToGroupButton", "Landroid/widget/TextView;", "getAddToGroupButton", "()Landroid/widget/TextView;", "setAddToGroupButton", "(Landroid/widget/TextView;)V", "composite", "Lio/reactivex/disposables/CompositeDisposable;", "groupName", "Lcom/reddit/social/presentation/EditTextWithCounter;", "getGroupName", "()Lcom/reddit/social/presentation/EditTextWithCounter;", "setGroupName", "(Lcom/reddit/social/presentation/EditTextWithCounter;)V", "groupNameSection", "Landroid/widget/LinearLayout;", "getGroupNameSection", "()Landroid/widget/LinearLayout;", "setGroupNameSection", "(Landroid/widget/LinearLayout;)V", "leaveGroupButton", "getLeaveGroupButton", "setLeaveGroupButton", "membersAdapter", "Lcom/reddit/social/presentation/chatrequests/view/MembersAdapter;", "membersCount", "getMembersCount", "setMembersCount", "membersList", "Landroid/support/v7/widget/RecyclerView;", "getMembersList", "()Landroid/support/v7/widget/RecyclerView;", "setMembersList", "(Landroid/support/v7/widget/RecyclerView;)V", "muteChannelToggle", "Landroid/widget/Switch;", "getMuteChannelToggle", "()Landroid/widget/Switch;", "setMuteChannelToggle", "(Landroid/widget/Switch;)V", "muteChannelToggleContainer", "getMuteChannelToggleContainer", "setMuteChannelToggleContainer", "noConnectionBanner", "getNoConnectionBanner", "setNoConnectionBanner", "notifPrefOffText", "getNotifPrefOffText", "setNotifPrefOffText", "presenter", "Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$Presenter;", "getPresenter", "()Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$Presenter;", "setPresenter", "(Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$Presenter;)V", "saveButton", "Landroid/widget/Button;", "getSaveButton", "()Landroid/widget/Button;", "setSaveButton", "(Landroid/widget/Button;)V", "startGroupChatButton", "getStartGroupChatButton", "setStartGroupChatButton", "userClick", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "kotlin.jvm.PlatformType", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "confirmBlockUser", "userId", "", "username", "confirmLeaveGroup", "defocusGroupName", "disableChannelMuteToggle", "enableChannelMuteToggle", "getLayoutId", "", "hideSaveButton", "navigateToChatInbox", "networkConnectionChange", "hasNetworkConnection", "", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "openContactsScreen", "channelUrl", "members", "", "openGroupMembersScreen", "", "setChannelMuted", "muted", "showAddToGroupButton", "showGroupName", "name", "showLeaveButton", "showMembers", "showMembersCount", "count", "showMessage", "message", "showNotificationsEnabled", "showNotificationsNotEnabled", "showSaveButton", "showStartGroupChatButton", "showUserReportDialog", "user", "startGroupChat", "member", "Lcom/reddit/social/presentation/presentationobjects/ContactData;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessagingSettingsScreen.kt */
public final class MessagingSettingsScreen extends MvpBaseScreen implements View {
    public static final Companion f40221w = new Companion();
    @BindView
    public TextView addToGroupButton;
    @BindView
    public EditTextWithCounter groupName;
    @BindView
    public LinearLayout groupNameSection;
    @BindView
    public TextView leaveGroupButton;
    @BindView
    public TextView membersCount;
    @BindView
    public RecyclerView membersList;
    @BindView
    public Switch muteChannelToggle;
    @BindView
    public LinearLayout muteChannelToggleContainer;
    @BindView
    public TextView noConnectionBanner;
    @BindView
    public TextView notifPrefOffText;
    @BindView
    public Button saveButton;
    @BindView
    public TextView startGroupChatButton;
    @Inject
    public Presenter f40222v;
    private CompositeDisposable f40223x;
    private MembersAdapter f40224y;
    private final PublishSubject<UserData> f40225z = PublishSubject.create();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/social/presentation/groupchat/view/MessagingSettingsScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/social/presentation/groupchat/view/MessagingSettingsScreen;", "url", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: MessagingSettingsScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static MessagingSettingsScreen m24702a(String str) {
            Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
            MessagingSettingsScreen messagingSettingsScreen = new MessagingSettingsScreen();
            messagingSettingsScreen.m41360w().mo5182a(str);
            return messagingSettingsScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22369a;

        static {
            int[] iArr = new int[UserActions.values().length];
            f22369a = iArr;
            iArr[UserActions.f22372a.ordinal()] = 1;
            f22369a[UserActions.f22374c.ordinal()] = 2;
            f22369a[UserActions.f22373b.ordinal()] = 3;
        }
    }

    public final int mo7141s() {
        return C1761R.layout.screen_messaging_settings;
    }

    public MessagingSettingsScreen() {
        super();
        FrontpageApplication.m28878n().mo5099a(this);
    }

    public MessagingSettingsScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        FrontpageApplication.m28878n().mo5099a(this);
    }

    public final Presenter m41360w() {
        Presenter presenter = this.f40222v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return presenter;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.a(Util.m23957a(Util.m23950a((int) C1761R.color.rdt_meta_text), Mode.SRC_ATOP));
        actionBar.c(false);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        Object obj = this.f40225z;
        Intrinsics.m26843a(obj, "userClick");
        this.f40224y = new MembersAdapter(obj);
        layoutInflater = this.membersList;
        if (layoutInflater == null) {
            Intrinsics.m26844a("membersList");
        }
        layoutInflater.setLayoutManager((LayoutManager) new LinearLayoutManager(am_(), 1, false));
        layoutInflater = this.membersList;
        if (layoutInflater == null) {
            Intrinsics.m26844a("membersList");
        }
        viewGroup = this.f40224y;
        if (viewGroup == null) {
            Intrinsics.m26844a("membersAdapter");
        }
        layoutInflater.setAdapter((Adapter) viewGroup);
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
        this.f40223x = new CompositeDisposable();
        layoutInflater = this.f40223x;
        if (layoutInflater == null) {
            Intrinsics.m26844a("composite");
        }
        Observable flatMapSingle = this.f40225z.flatMapSingle(new MessagingSettingsScreen$onCreateView$1(this));
        Intrinsics.m26843a((Object) flatMapSingle, "userClick\n        .flatM…] }\n          }\n        }");
        DisposableKt.m26766a(layoutInflater, ObservablesKt.m24091a(flatMapSingle, (Function1) new MessagingSettingsScreen$onCreateView$2(this)));
        layoutInflater = this.groupName;
        if (layoutInflater == null) {
            Intrinsics.m26844a("groupName");
        }
        Function2 function2 = (Function2) new MessagingSettingsScreen$onCreateView$3(this);
        Intrinsics.m26847b(function2, "l");
        layoutInflater.f22311a = function2;
        layoutInflater = this.saveButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("saveButton");
        }
        ((android.view.View) layoutInflater).setOnClickListener(new MessagingSettingsScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessagingSettingsScreen$onCreateView$4(this)));
        layoutInflater = this.membersCount;
        if (layoutInflater == null) {
            Intrinsics.m26844a("membersCount");
        }
        ((android.view.View) layoutInflater).setOnClickListener(new MessagingSettingsScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessagingSettingsScreen$onCreateView$5(this)));
        layoutInflater = this.leaveGroupButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("leaveGroupButton");
        }
        ((android.view.View) layoutInflater).setOnClickListener(new MessagingSettingsScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessagingSettingsScreen$onCreateView$6(this)));
        layoutInflater = this.addToGroupButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("addToGroupButton");
        }
        ((android.view.View) layoutInflater).setOnClickListener(new MessagingSettingsScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessagingSettingsScreen$onCreateView$7(this)));
        layoutInflater = this.startGroupChatButton;
        if (layoutInflater == null) {
            Intrinsics.m26844a("startGroupChatButton");
        }
        ((android.view.View) layoutInflater).setOnClickListener(new MessagingSettingsScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new MessagingSettingsScreen$onCreateView$8(this)));
        layoutInflater = this.f40222v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.mo5181a((View) this);
        layoutInflater = this.f40222v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.mo5184a(false);
        Object obj2 = this.K;
        Intrinsics.m26843a(obj2, "rootView");
        return obj2;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40222v;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.mo5179a();
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return null;
        }
        m29351F();
        return true;
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        CompositeDisposable compositeDisposable = this.f40223x;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("composite");
        }
        compositeDisposable.mo5626a();
        Presenter presenter = this.f40222v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5185b();
        super.mo6987a(view);
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        Presenter presenter = this.f40222v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5180a((StateStorageContract) new StateStorageBundle(bundle));
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        Presenter presenter = this.f40222v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5186b((StateStorageContract) new StateStorageBundle(bundle));
        super.mo7199c(bundle);
    }

    public final void mo7578a(boolean z) {
        mo7570a();
        Switch switchR = this.muteChannelToggle;
        if (switchR == null) {
            Intrinsics.m26844a("muteChannelToggle");
        }
        switchR.setChecked(z);
        z = this.muteChannelToggle;
        if (!z) {
            Intrinsics.m26844a("muteChannelToggle");
        }
        z.setClickable(true);
        z = this.muteChannelToggleContainer;
        if (!z) {
            Intrinsics.m26844a("muteChannelToggleContainer");
        }
        z.setClickable(true);
        z = this.muteChannelToggle;
        if (!z) {
            Intrinsics.m26844a("muteChannelToggle");
        }
        ((CompoundButton) z).setOnCheckedChangeListener(new C1944xac8ed1b1(new MessagingSettingsScreen$enableChannelMuteToggle$1(this)));
    }

    public final void mo7577a(List<UserData> list) {
        Intrinsics.m26847b(list, "members");
        RecyclerView recyclerView = this.membersList;
        if (recyclerView == null) {
            Intrinsics.m26844a("membersList");
        }
        ViewsKt.m24107c(recyclerView);
        MembersAdapter membersAdapter = this.f40224y;
        if (membersAdapter == null) {
            Intrinsics.m26844a("membersAdapter");
        }
        membersAdapter.m30712a((List) list);
    }

    public final void mo7571a(int i) {
        TextView textView = this.membersCount;
        if (textView == null) {
            Intrinsics.m26844a("membersCount");
        }
        ViewsKt.m24107c(textView);
        textView = this.membersCount;
        if (textView == null) {
            Intrinsics.m26844a("membersCount");
        }
        textView.setText(Util.m23959a((int) C1761R.plurals.fmt_num_group_chat_members_1, i, Integer.valueOf(i)));
    }

    public final void mo7574a(String str, String str2) {
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(str2, "username");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23297a((Context) am_, str2, (Function2) new MessagingSettingsScreen$confirmBlockUser$1(this, str)).m23323a();
    }

    public final void mo7581b() {
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23298a((Context) am_, (Function2) new MessagingSettingsScreen$confirmLeaveGroup$1(this)).m23323a();
    }

    public final void mo7573a(String str) {
        Intrinsics.m26847b(str, "message");
        Toast.makeText(am_(), str, 1).show();
    }

    public final void mo7584c() {
        ai_();
    }

    public final void mo7570a() {
        Switch switchR = this.muteChannelToggle;
        if (switchR == null) {
            Intrinsics.m26844a("muteChannelToggle");
        }
        switchR.setClickable(false);
        LinearLayout linearLayout = this.muteChannelToggleContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("muteChannelToggleContainer");
        }
        linearLayout.setClickable(false);
        switchR = this.muteChannelToggle;
        if (switchR == null) {
            Intrinsics.m26844a("muteChannelToggle");
        }
        Function2 function2 = MessagingSettingsScreen$disableChannelMuteToggle$1.f37544a;
        switchR.setOnCheckedChangeListener(function2 == null ? null : new C1944xac8ed1b1(function2));
    }

    public final void b_(boolean z) {
        TextView textView = this.noConnectionBanner;
        if (textView == null) {
            Intrinsics.m26844a("noConnectionBanner");
        }
        ViewsKt.m24106b(textView, z ^ 1);
    }

    public final void mo7585d() {
        TextView textView = this.leaveGroupButton;
        if (textView == null) {
            Intrinsics.m26844a("leaveGroupButton");
        }
        ViewsKt.m24107c(textView);
    }

    public final void mo7586e() {
        TextView textView = this.addToGroupButton;
        if (textView == null) {
            Intrinsics.m26844a("addToGroupButton");
        }
        ViewsKt.m24107c(textView);
    }

    public final void mo7587f() {
        TextView textView = this.startGroupChatButton;
        if (textView == null) {
            Intrinsics.m26844a("startGroupChatButton");
        }
        ViewsKt.m24107c(textView);
    }

    public final void mo7582b(String str) {
        LinearLayout linearLayout = this.groupNameSection;
        if (linearLayout == null) {
            Intrinsics.m26844a("groupNameSection");
        }
        ViewsKt.m24107c(linearLayout);
        EditTextWithCounter editTextWithCounter = this.groupName;
        if (editTextWithCounter == null) {
            Intrinsics.m26844a("groupName");
        }
        editTextWithCounter.getEditText().setText(str, BufferType.EDITABLE);
    }

    public final void mo7589h() {
        Button button = this.saveButton;
        if (button == null) {
            Intrinsics.m26844a("saveButton");
        }
        ViewsKt.m24107c(button);
    }

    public final void mo7590i() {
        Button button = this.saveButton;
        if (button == null) {
            Intrinsics.m26844a("saveButton");
        }
        ViewsKt.m24109d(button);
    }

    public final void mo7588g() {
        EditTextWithCounter editTextWithCounter = this.groupName;
        if (editTextWithCounter == null) {
            Intrinsics.m26844a("groupName");
        }
        editTextWithCounter.getEditText().clearFocus();
        editTextWithCounter = this.groupName;
        if (editTextWithCounter == null) {
            Intrinsics.m26844a("groupName");
        }
        Util.m23972a((android.view.View) editTextWithCounter);
    }

    public final void mo7572a(ContactData contactData) {
        Routing.m22623a((Screen) this, Nav.m22546a((ContactsActionType) new CREATE(contactData), SetsKt__SetsKt.m26799a()));
    }

    public final void mo7575a(String str, List<UserData> list) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(list, "members");
        Routing.m22623a((Screen) this, Nav.m22561a(str, (List) list));
    }

    public final void mo7576a(String str, Set<UserData> set) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(set, "members");
        Routing.m22623a((Screen) this, Nav.m22546a((ContactsActionType) new ADD(str), (Set) set));
    }

    public final void ar_() {
        TextView textView = this.notifPrefOffText;
        if (textView == null) {
            Intrinsics.m26844a("notifPrefOffText");
        }
        ViewsKt.m24107c(textView);
        Switch switchR = this.muteChannelToggle;
        if (switchR == null) {
            Intrinsics.m26844a("muteChannelToggle");
        }
        ViewsKt.m24109d(switchR);
        LinearLayout linearLayout = this.muteChannelToggleContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("muteChannelToggleContainer");
        }
        linearLayout.setOnClickListener(new MessagingSettingsScreen$inlined$sam$OnClickListener$i$7f478c20(new MessagingSettingsScreen$showNotificationsNotEnabled$1(this)));
    }

    public final void as_() {
        TextView textView = this.notifPrefOffText;
        if (textView == null) {
            Intrinsics.m26844a("notifPrefOffText");
        }
        ViewsKt.m24109d(textView);
        Switch switchR = this.muteChannelToggle;
        if (switchR == null) {
            Intrinsics.m26844a("muteChannelToggle");
        }
        ViewsKt.m24107c(switchR);
        LinearLayout linearLayout = this.muteChannelToggleContainer;
        if (linearLayout == null) {
            Intrinsics.m26844a("muteChannelToggleContainer");
        }
        linearLayout.setOnClickListener(new MessagingSettingsScreen$inlined$sam$OnClickListener$i$7f478c20(new MessagingSettingsScreen$showNotificationsEnabled$1(this)));
    }

    public static final /* synthetic */ void m41333a(MessagingSettingsScreen messagingSettingsScreen, UserData userData) {
        Object e = Util.m24023e((int) C1761R.array.report_user_reasons);
        Intrinsics.m26843a(e, "Util.getStringArray(R.array.report_user_reasons)");
        List i = ArraysKt___ArraysKt.m36109i((Object[]) e);
        CompositeDisposable compositeDisposable = messagingSettingsScreen.f40223x;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("composite");
        }
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = messagingSettingsScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Object subscribe = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23301a((Context) am_, (Collection) i, (int) C1761R.string.action_report).observeOn(SchedulerProvider.m23886b()).flatMapObservable(new MessagingSettingsScreen$showUserReportDialog$1(messagingSettingsScreen, userData, i)).observeOn(SchedulerProvider.m23887c()).subscribe(MessagingSettingsScreen$showUserReportDialog$2.f29874a, new MessagingSettingsScreen$showUserReportDialog$3(messagingSettingsScreen));
        Intrinsics.m26843a(subscribe, "RedditAlertDialog.select…)\n            }\n        )");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }
}
