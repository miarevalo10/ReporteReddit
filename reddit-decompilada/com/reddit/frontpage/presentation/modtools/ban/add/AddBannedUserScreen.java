package com.reddit.frontpage.presentation.modtools.ban.add;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.bluelinelabs.conductor.Controller;
import com.evernote.android.state.State;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.reddit.datalibrary.frontpage.data.model.BannedUser;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerAddBannedUserComponent;
import com.reddit.frontpage.di.module.AddBannedUserViewModule;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.listing.ui.view.Indicator;
import com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView;
import com.reddit.frontpage.presentation.modtools.ModAddUserTarget;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserContract.View;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanInfoModel;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReason;
import com.reddit.frontpage.presentation.modtools.util.ModScreenMode;
import com.reddit.frontpage.ui.listing.newcard.CompactLinkView;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder.OnViewMediaListener;
import com.reddit.frontpage.ui.listing.newcard.XpostCompactCardBodyView;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020rH\u0016J\b\u0010t\u001a\u00020uH\u0002J\b\u0010v\u001a\u00020uH\u0002J\u0010\u0010w\u001a\u00020p2\u0006\u0010x\u001a\u00020yH\u0014J\u0010\u0010z\u001a\u00020p2\u0006\u0010{\u001a\u00020&H\u0016J\u0010\u0010|\u001a\u00020p2\u0006\u0010i\u001a\u00020&H\u0016J\b\u0010}\u001a\u00020pH\u0007J\u001b\u0010~\u001a\u00020p2\u0007\u0010\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020y2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0011\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020=H\u0016J\u0011\u0010\u0001\u001a\u00020p2\u0006\u0010{\u001a\u00020&H\u0016J\t\u0010\u0001\u001a\u00020pH\u0002J\u0013\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0019\u0010\u0001\u001a\u00020p2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020&0\u0001H\u0016J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\n\"\u0004\b5\u0010\fR \u00106\u001a\u0004\u0018\u0001078\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010<\u001a\u00020=X.¢\u0006\u0002\n\u0000R\u001e\u0010>\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\n\"\u0004\b@\u0010\fR\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u00020H8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020T8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010Y\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020&0]X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X.¢\u0006\u0002\n\u0000R\u001e\u0010`\u001a\u00020&8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010(\"\u0004\bb\u0010*R\u001e\u0010c\u001a\u00020&8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010(\"\u0004\be\u0010*R\u001e\u0010f\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0016\"\u0004\bh\u0010\u0018R\u001e\u0010i\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\n\"\u0004\bk\u0010\fR\u001a\u0010l\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010(\"\u0004\bn\u0010*¨\u0006\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "banMessage", "Landroid/widget/EditText;", "getBanMessage", "()Landroid/widget/EditText;", "setBanMessage", "(Landroid/widget/EditText;)V", "bannedForStub", "Landroid/view/ViewStub;", "getBannedForStub", "()Landroid/view/ViewStub;", "setBannedForStub", "(Landroid/view/ViewStub;)V", "bannedForTitle", "Landroid/widget/TextView;", "getBannedForTitle", "()Landroid/widget/TextView;", "setBannedForTitle", "(Landroid/widget/TextView;)V", "bannedUser", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUser;", "getBannedUser", "()Lcom/reddit/datalibrary/frontpage/data/model/BannedUser;", "setBannedUser", "(Lcom/reddit/datalibrary/frontpage/data/model/BannedUser;)V", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "getComment", "()Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "setComment", "(Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;)V", "commentId", "", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "commentView", "Lcom/reddit/frontpage/presentation/modtools/ban/add/BannedForCommentView;", "crossPostView", "Lcom/reddit/frontpage/ui/listing/newcard/CompactLinkView;", "getCrossPostView", "()Lcom/reddit/frontpage/ui/listing/newcard/CompactLinkView;", "setCrossPostView", "(Lcom/reddit/frontpage/ui/listing/newcard/CompactLinkView;)V", "durationEditText", "getDurationEditText", "setDurationEditText", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "getLink", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "setLink", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;)V", "menuItem", "Landroid/view/MenuItem;", "modNote", "getModNote", "setModNote", "onViewMediaListener", "Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder$OnViewMediaListener;", "getOnViewMediaListener", "()Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder$OnViewMediaListener;", "setOnViewMediaListener", "(Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder$OnViewMediaListener;)V", "permanentRadioButon", "Landroid/widget/CheckBox;", "getPermanentRadioButon", "()Landroid/widget/CheckBox;", "setPermanentRadioButon", "(Landroid/widget/CheckBox;)V", "postView", "Lcom/reddit/frontpage/ui/listing/newcard/XpostCompactCardBodyView;", "getPostView", "()Lcom/reddit/frontpage/ui/listing/newcard/XpostCompactCardBodyView;", "setPostView", "(Lcom/reddit/frontpage/ui/listing/newcard/XpostCompactCardBodyView;)V", "presenter", "Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserPresenter;)V", "reason", "getReason", "setReason", "reasons", "", "screenMode", "Lcom/reddit/frontpage/presentation/modtools/util/ModScreenMode;", "subredditId", "getSubredditId", "setSubredditId", "subredditName", "getSubredditName", "setSubredditName", "title", "getTitle", "setTitle", "username", "getUsername", "setUsername", "usernameString", "getUsernameString", "setUsernameString", "configureScreen", "", "getDefaultScreenPosition", "", "getLayoutId", "isCrosspost", "", "isFormValid", "onAttach", "view", "Landroid/view/View;", "onBanUserError", "errorMessage", "onBanUserSuccess", "onClick", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDurationTextChanged", "textChanged", "", "onEventMainThread", "banReason", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanReason;", "onOptionsItemSelected", "item", "onReasonsError", "onThumbnailClick", "onUsernameTextChanged", "populateReasons", "rules", "", "setupBannedForCommentView", "setupBannedForCrossPostView", "setupBannedForPostView", "updateMenuButton", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddBannedUserScreen.kt */
public final class AddBannedUserScreen extends MvpBaseScreen implements View {
    public static final Companion f40082A = new Companion();
    private XpostCompactCardBodyView f40083B;
    private MenuItem f40084C;
    private ModScreenMode f40085D;
    private final List<String> f40086E;
    @BindView
    public EditText banMessage;
    @BindView
    public ViewStub bannedForStub;
    @BindView
    public TextView bannedForTitle;
    @State
    Comment comment;
    @State
    public String commentId;
    @BindView
    public BannedForCommentView commentView;
    @BindView
    public EditText durationEditText;
    @State
    Link link;
    @BindView
    public EditText modNote;
    @BindView
    public CheckBox permanentRadioButon;
    @BindView
    public EditText reason;
    @State
    public String subredditId;
    @State
    public String subredditName;
    @BindView
    public TextView title;
    @BindView
    public EditText username;
    CompactLinkView f40087v;
    OnViewMediaListener f40088w;
    public BannedUser f40089x;
    public String f40090y;
    @Inject
    public AddBannedUserPresenter f40091z;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserScreen$Companion;", "", "()V", "COMMENT_CONTEXT", "", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/ban/add/AddBannedUserScreen;", "username", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "subredditId", "subredditName", "bannedUser", "Lcom/reddit/datalibrary/frontpage/data/model/BannedUser;", "commentId", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AddBannedUserScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AddBannedUserScreen m23102a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            AddBannedUserScreen addBannedUserScreen = new AddBannedUserScreen();
            addBannedUserScreen.m40759e(str);
            addBannedUserScreen.m40758d(str2);
            addBannedUserScreen.f40085D = ModScreenMode.f20921a;
            addBannedUserScreen.m40760f("");
            return addBannedUserScreen;
        }

        public static AddBannedUserScreen m23104a(String str, String str2, Link link) {
            Intrinsics.m26847b(str, "username");
            Intrinsics.m26847b(str2, "commentId");
            Intrinsics.m26847b(link, "link");
            AddBannedUserScreen addBannedUserScreen = new AddBannedUserScreen();
            addBannedUserScreen.m40759e(link.getSubredditDetail().getName());
            Object subredditDetail = link.getSubredditDetail();
            Intrinsics.m26843a(subredditDetail, "link.subredditDetail");
            subredditDetail = subredditDetail.b();
            Intrinsics.m26843a(subredditDetail, "link.subredditDetail.displayName");
            addBannedUserScreen.m40758d(subredditDetail);
            addBannedUserScreen.m40761g(str);
            addBannedUserScreen.f40085D = ModScreenMode.f20923c;
            addBannedUserScreen.m40760f(str2);
            addBannedUserScreen.link = link;
            return addBannedUserScreen;
        }

        public static AddBannedUserScreen m23101a(String str, Comment comment) {
            Intrinsics.m26847b(str, "username");
            Intrinsics.m26847b(comment, "comment");
            AddBannedUserScreen addBannedUserScreen = new AddBannedUserScreen();
            Object i = comment.i();
            Intrinsics.m26843a(i, "comment.subredditId");
            addBannedUserScreen.m40759e(i);
            i = comment.h();
            Intrinsics.m26843a(i, "comment.subreddit");
            addBannedUserScreen.m40758d(i);
            addBannedUserScreen.m40761g(str);
            addBannedUserScreen.f40085D = ModScreenMode.f20923c;
            addBannedUserScreen.m40760f(comment.getName());
            addBannedUserScreen.comment = comment;
            return addBannedUserScreen;
        }

        public static AddBannedUserScreen m23103a(String str, String str2, BannedUser bannedUser) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            Intrinsics.m26847b(bannedUser, "bannedUser");
            AddBannedUserScreen addBannedUserScreen = new AddBannedUserScreen();
            addBannedUserScreen.m40759e(str);
            addBannedUserScreen.m40758d(str2);
            Intrinsics.m26847b(bannedUser, "<set-?>");
            addBannedUserScreen.f40089x = bannedUser;
            addBannedUserScreen.f40085D = ModScreenMode.f20922b;
            addBannedUserScreen.m40760f("");
            return addBannedUserScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20877a;

        static {
            int[] iArr = new int[ModScreenMode.values().length];
            f20877a = iArr;
            iArr[ModScreenMode.f20921a.ordinal()] = 1;
            f20877a[ModScreenMode.f20922b.ordinal()] = 2;
            f20877a[ModScreenMode.f20923c.ordinal()] = 3;
        }
    }

    public static final AddBannedUserScreen m40736a(String str, Comment comment) {
        return Companion.m23101a(str, comment);
    }

    public static final AddBannedUserScreen m40737a(String str, String str2) {
        return Companion.m23102a(str, str2);
    }

    public static final AddBannedUserScreen m40738a(String str, String str2, BannedUser bannedUser) {
        return Companion.m23103a(str, str2, bannedUser);
    }

    public static final AddBannedUserScreen m40739a(String str, String str2, Link link) {
        return Companion.m23104a(str, str2, link);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_add_banned_user;
    }

    public final int mo7143u() {
        return 2;
    }

    public AddBannedUserScreen() {
        super();
        this.f40086E = new ArrayList();
        DaggerAddBannedUserComponent.m28994a().m22044a(FrontpageApplication.m28875k()).m22045a(new AddBannedUserViewModule(this)).m22043a().mo4581a(this);
    }

    public AddBannedUserScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        this.f40086E = (List) new ArrayList();
        DaggerAddBannedUserComponent.m28994a().m22044a(FrontpageApplication.m28875k()).m22045a(new AddBannedUserViewModule(this)).m22043a().mo4581a(this);
    }

    public final String mo7379b() {
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        return str;
    }

    public final void m40758d(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditName = str;
    }

    public final String mo7376a() {
        String str = this.subredditId;
        if (str == null) {
            Intrinsics.m26844a("subredditId");
        }
        return str;
    }

    public final void m40759e(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditId = str;
    }

    public final String mo7381c() {
        String str = this.commentId;
        if (str == null) {
            Intrinsics.m26844a("commentId");
        }
        return str;
    }

    public final void m40760f(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.commentId = str;
    }

    public final Link mo7382d() {
        return this.link;
    }

    public final void m40761g(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.f40090y = str;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String b;
        Object obj;
        Comment comment;
        String f;
        Object noneOf;
        LinearLayout linearLayout;
        android.view.View childAt;
        LayoutParams layoutParams;
        Object am_;
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        layoutInflater = this.f40085D;
        if (layoutInflater == null) {
            Intrinsics.m26844a("screenMode");
        }
        switch (WhenMappings.f20877a[layoutInflater.ordinal()]) {
            case 1:
                layoutInflater = this.title;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("title");
                }
                layoutInflater.setText(Util.m24027f((int) C1761R.string.mod_tools_add_banned_user));
                break;
            case 2:
                layoutInflater = this.title;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("title");
                }
                layoutInflater.setText(Util.m24027f((int) C1761R.string.mod_tools_edit_banned_user));
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                BannedUser bannedUser = this.f40089x;
                if (bannedUser == null) {
                    Intrinsics.m26844a("bannedUser");
                }
                layoutInflater.setText(bannedUser.getUsername());
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                layoutInflater.setFocusable(false);
                layoutInflater = this.reason;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("reason");
                }
                bannedUser = this.f40089x;
                if (bannedUser == null) {
                    Intrinsics.m26844a("bannedUser");
                }
                layoutInflater.setText(bannedUser.getReason());
                layoutInflater = this.modNote;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("modNote");
                }
                bannedUser = this.f40089x;
                if (bannedUser == null) {
                    Intrinsics.m26844a("bannedUser");
                }
                layoutInflater.setText(bannedUser.getModNote());
                layoutInflater = this.f40089x;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("bannedUser");
                }
                if (layoutInflater.getDuration() == null) {
                    layoutInflater = this.permanentRadioButon;
                    if (layoutInflater == null) {
                        Intrinsics.m26844a("permanentRadioButon");
                    }
                    layoutInflater.setChecked(true);
                } else {
                    layoutInflater = this.durationEditText;
                    if (layoutInflater == null) {
                        Intrinsics.m26844a("durationEditText");
                    }
                    bannedUser = this.f40089x;
                    if (bannedUser == null) {
                        Intrinsics.m26844a("bannedUser");
                    }
                    layoutInflater.setText(String.valueOf(bannedUser.getDuration()));
                }
                layoutInflater = this.banMessage;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("banMessage");
                }
                bannedUser = this.f40089x;
                if (bannedUser == null) {
                    Intrinsics.m26844a("bannedUser");
                }
                layoutInflater.setText(bannedUser.getBanMessage());
                break;
            case 3:
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                String str = this.f40090y;
                if (str == null) {
                    Intrinsics.m26844a("usernameString");
                }
                layoutInflater.setText(str);
                layoutInflater = this.username;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("username");
                }
                layoutInflater.setFocusable(false);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        layoutInflater = this.link;
        if (layoutInflater != null) {
            layoutInflater = layoutInflater.getSubredditDetail();
            if (layoutInflater != null) {
                b = layoutInflater.b();
                this.f40088w = LinkUtil.m23790b((Context) am_(), b);
                layoutInflater = this.reason;
                if (layoutInflater == null) {
                    Intrinsics.m26844a("reason");
                }
                layoutInflater.setOnClickListener(new AddBannedUserScreen$onCreateView$1(this));
                obj = this.f40085D;
                if (obj == null) {
                    Intrinsics.m26844a("screenMode");
                }
                if (Intrinsics.m26845a(obj, ModScreenMode.f20923c) != null) {
                    if (this.comment == null) {
                        if (this.commentView != null) {
                            layoutInflater = this.commentView;
                            if (layoutInflater != null) {
                                layoutInflater.setVisibility(0);
                            }
                            layoutInflater = this.commentView;
                            if (layoutInflater != null) {
                                comment = this.comment;
                                if (comment != null) {
                                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Comment");
                                }
                                Intrinsics.m26847b(comment, "comment");
                                Object b2 = SessionManager.b();
                                Intrinsics.m26843a(b2, "SessionManager.getInstance()");
                                b2 = b2.c();
                                Intrinsics.m26843a(b2, Session.TYPE_SESSION);
                                Intrinsics.m26847b(comment, "comment");
                                Intrinsics.m26847b(b2, Session.TYPE_SESSION);
                                f = Util.m24027f((int) C1761R.string.internal_deleted);
                                if (TextUtils.equals(f, comment.c())) {
                                    f = comment.c();
                                }
                                noneOf = EnumSet.noneOf(Indicator.class);
                                layoutInflater.getAuthorView().setText(f);
                                TextView authorView = layoutInflater.getAuthorView();
                                Object context = layoutInflater.getContext();
                                Intrinsics.m26843a(context, "context");
                                authorView.setTextColor(context.getResources().getColor(C1761R.color.rdt_blue));
                                noneOf.add(Indicator.f20734c);
                                if (ModUtil.m23823a(comment.getName()).getDistinguishState(comment.getName(), Intrinsics.m26845a(comment.g(), BannedForCommentView.f28581o))) {
                                    layoutInflater.getAuthorView().setTextColor(Util.m23950a((int) C1761R.color.rdt_green));
                                    noneOf.add(Indicator.f20733b);
                                } else if (ModUtil.m23823a(comment.a()).getDistinguishAdminState(comment.getName(), TextUtils.equals(comment.g(), BannedForCommentView.f28582p))) {
                                    layoutInflater.getAuthorView().setTextColor(Util.m23950a((int) C1761R.color.rdt_red));
                                    noneOf.add(Indicator.f20732a);
                                }
                                if (comment.e()) {
                                    noneOf.add(Indicator.f20736e);
                                }
                                UserIndicatorsView authorIndicators = layoutInflater.getAuthorIndicators();
                                Intrinsics.m26843a(noneOf, "indicators");
                                authorIndicators.setActiveIndicators((Set) noneOf);
                                layoutInflater.getBody().setHtmlFromString(comment.b());
                                layoutInflater.getBody().setVisibility(0);
                                layoutInflater.getBody().setPaintFlags(((layoutInflater.getBody().getPaintFlags() | 128) | 256) | 1);
                            }
                            layoutInflater = this.commentView;
                            if (layoutInflater != null) {
                                layoutInflater.setOnClickListener((OnClickListener) new C1853x2ee5d3ab(this));
                            }
                        }
                    } else if (this.link != null) {
                        if (m40744w() != null) {
                            layoutInflater = this.bannedForTitle;
                            if (layoutInflater == null) {
                                Intrinsics.m26844a("bannedForTitle");
                            }
                            layoutInflater.setVisibility(0);
                            layoutInflater = this.bannedForStub;
                            if (layoutInflater == null) {
                                Intrinsics.m26844a("bannedForStub");
                            }
                            layoutInflater.setLayoutResource(C1761R.layout.item_xpost_compact_card_legacy);
                            layoutInflater = this.bannedForStub;
                            if (layoutInflater == null) {
                                Intrinsics.m26844a("bannedForStub");
                            }
                            layoutInflater = layoutInflater.inflate();
                            if (layoutInflater != null) {
                                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
                            }
                            linearLayout = (LinearLayout) layoutInflater;
                            childAt = linearLayout.getChildAt(0);
                            if (childAt != null) {
                                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.newcard.CompactLinkView");
                            }
                            this.f40087v = (CompactLinkView) childAt;
                            layoutInflater = linearLayout.getChildAt(1);
                            if (layoutInflater != null) {
                                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.LinkFooterView");
                            }
                            ((LinkFooterView) layoutInflater).setVisibility(8);
                            layoutInflater = this.f40087v;
                            if (layoutInflater != null) {
                                layoutInflater.m23471b();
                            }
                            layoutInflater = this.f40087v;
                            layoutInflater = layoutInflater == null ? layoutInflater.getLayoutParams() : null;
                            if ((layoutInflater instanceof LayoutParams) == null) {
                                layoutInflater = null;
                            }
                            layoutParams = (LayoutParams) layoutInflater;
                            if (layoutParams != null) {
                                am_ = am_();
                                if (am_ == null) {
                                    Intrinsics.m26842a();
                                }
                                Intrinsics.m26843a(am_, "activity!!");
                                layoutParams.topMargin = (int) am_.getResources().getDimension(C1761R.dimen.single_pad);
                            }
                            if (layoutParams != null) {
                                am_ = am_();
                                if (am_ == null) {
                                    Intrinsics.m26842a();
                                }
                                Intrinsics.m26843a(am_, "activity!!");
                                layoutParams.bottomMargin = (int) am_.getResources().getDimension(C1761R.dimen.double_pad);
                            }
                            viewGroup = this.f40087v;
                            if (viewGroup != null) {
                                viewGroup.setLayoutParams(layoutParams);
                            }
                            layoutInflater = T_();
                            if (layoutInflater != null) {
                                layoutInflater.setOnLongClickListener((OnLongClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$1(this));
                            }
                            layoutInflater = this.f40087v;
                            if (layoutInflater != null) {
                                layoutInflater.setViewMediaClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$2(this));
                            }
                            layoutInflater = this.f40087v;
                            if (layoutInflater != null) {
                                layoutInflater.setXpostEmbedOnClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$3(this));
                            }
                            layoutInflater = this.f40087v;
                            if (layoutInflater != null) {
                                layoutInflater.setXpostThumbnailOnClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$4(this));
                            }
                            layoutInflater = this.f40087v;
                            if (layoutInflater != null) {
                                layoutInflater.setXpostThumbnailOnClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$5(this));
                            }
                            layoutInflater = this.f40087v;
                            if (layoutInflater != null) {
                                layoutInflater.m23470a(this.link);
                            }
                        }
                        if (m40744w() == null) {
                            layoutInflater = this.bannedForStub;
                            if (layoutInflater == null) {
                                Intrinsics.m26844a("bannedForStub");
                            }
                            layoutInflater.setLayoutResource(C1761R.layout.item_bannded_for);
                            layoutInflater = this.bannedForStub;
                            if (layoutInflater == null) {
                                Intrinsics.m26844a("bannedForStub");
                            }
                            layoutInflater = layoutInflater.inflate();
                            if (layoutInflater != null) {
                                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.newcard.XpostCompactCardBodyView");
                            }
                            XpostCompactCardBodyView xpostCompactCardBodyView = (XpostCompactCardBodyView) layoutInflater;
                            xpostCompactCardBodyView.setThumbnailOnClickListener((OnClickListener) new C1854xdad481a4(this));
                            xpostCompactCardBodyView.setOnClickListener((OnClickListener) new C1855xdad481a5(this));
                            xpostCompactCardBodyView.m30250a(this.link);
                            this.f40083B = xpostCompactCardBodyView;
                        }
                    }
                }
                obj = this.K;
                Intrinsics.m26843a(obj, "rootView");
                return obj;
            }
        }
        b = null;
        this.f40088w = LinkUtil.m23790b((Context) am_(), b);
        layoutInflater = this.reason;
        if (layoutInflater == null) {
            Intrinsics.m26844a("reason");
        }
        layoutInflater.setOnClickListener(new AddBannedUserScreen$onCreateView$1(this));
        obj = this.f40085D;
        if (obj == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(obj, ModScreenMode.f20923c) != null) {
            if (this.comment == null) {
                if (this.link != null) {
                    if (m40744w() != null) {
                        layoutInflater = this.bannedForTitle;
                        if (layoutInflater == null) {
                            Intrinsics.m26844a("bannedForTitle");
                        }
                        layoutInflater.setVisibility(0);
                        layoutInflater = this.bannedForStub;
                        if (layoutInflater == null) {
                            Intrinsics.m26844a("bannedForStub");
                        }
                        layoutInflater.setLayoutResource(C1761R.layout.item_xpost_compact_card_legacy);
                        layoutInflater = this.bannedForStub;
                        if (layoutInflater == null) {
                            Intrinsics.m26844a("bannedForStub");
                        }
                        layoutInflater = layoutInflater.inflate();
                        if (layoutInflater != null) {
                            linearLayout = (LinearLayout) layoutInflater;
                            childAt = linearLayout.getChildAt(0);
                            if (childAt != null) {
                                this.f40087v = (CompactLinkView) childAt;
                                layoutInflater = linearLayout.getChildAt(1);
                                if (layoutInflater != null) {
                                    ((LinkFooterView) layoutInflater).setVisibility(8);
                                    layoutInflater = this.f40087v;
                                    if (layoutInflater != null) {
                                        layoutInflater.m23471b();
                                    }
                                    layoutInflater = this.f40087v;
                                    if (layoutInflater == null) {
                                    }
                                    if ((layoutInflater instanceof LayoutParams) == null) {
                                        layoutInflater = null;
                                    }
                                    layoutParams = (LayoutParams) layoutInflater;
                                    if (layoutParams != null) {
                                        am_ = am_();
                                        if (am_ == null) {
                                            Intrinsics.m26842a();
                                        }
                                        Intrinsics.m26843a(am_, "activity!!");
                                        layoutParams.topMargin = (int) am_.getResources().getDimension(C1761R.dimen.single_pad);
                                    }
                                    if (layoutParams != null) {
                                        am_ = am_();
                                        if (am_ == null) {
                                            Intrinsics.m26842a();
                                        }
                                        Intrinsics.m26843a(am_, "activity!!");
                                        layoutParams.bottomMargin = (int) am_.getResources().getDimension(C1761R.dimen.double_pad);
                                    }
                                    viewGroup = this.f40087v;
                                    if (viewGroup != null) {
                                        viewGroup.setLayoutParams(layoutParams);
                                    }
                                    layoutInflater = T_();
                                    if (layoutInflater != null) {
                                        layoutInflater.setOnLongClickListener((OnLongClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$1(this));
                                    }
                                    layoutInflater = this.f40087v;
                                    if (layoutInflater != null) {
                                        layoutInflater.setViewMediaClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$2(this));
                                    }
                                    layoutInflater = this.f40087v;
                                    if (layoutInflater != null) {
                                        layoutInflater.setXpostEmbedOnClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$3(this));
                                    }
                                    layoutInflater = this.f40087v;
                                    if (layoutInflater != null) {
                                        layoutInflater.setXpostThumbnailOnClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$4(this));
                                    }
                                    layoutInflater = this.f40087v;
                                    if (layoutInflater != null) {
                                        layoutInflater.setXpostThumbnailOnClickListener((OnClickListener) new AddBannedUserScreen$setupBannedForCrossPostView$5(this));
                                    }
                                    layoutInflater = this.f40087v;
                                    if (layoutInflater != null) {
                                        layoutInflater.m23470a(this.link);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.widgets.LinkFooterView");
                                }
                            }
                            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.newcard.CompactLinkView");
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
                    }
                    if (m40744w() == null) {
                        layoutInflater = this.bannedForStub;
                        if (layoutInflater == null) {
                            Intrinsics.m26844a("bannedForStub");
                        }
                        layoutInflater.setLayoutResource(C1761R.layout.item_bannded_for);
                        layoutInflater = this.bannedForStub;
                        if (layoutInflater == null) {
                            Intrinsics.m26844a("bannedForStub");
                        }
                        layoutInflater = layoutInflater.inflate();
                        if (layoutInflater != null) {
                            XpostCompactCardBodyView xpostCompactCardBodyView2 = (XpostCompactCardBodyView) layoutInflater;
                            xpostCompactCardBodyView2.setThumbnailOnClickListener((OnClickListener) new C1854xdad481a4(this));
                            xpostCompactCardBodyView2.setOnClickListener((OnClickListener) new C1855xdad481a5(this));
                            xpostCompactCardBodyView2.m30250a(this.link);
                            this.f40083B = xpostCompactCardBodyView2;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.newcard.XpostCompactCardBodyView");
                        }
                    }
                }
            } else if (this.commentView != null) {
                layoutInflater = this.commentView;
                if (layoutInflater != null) {
                    layoutInflater.setVisibility(0);
                }
                layoutInflater = this.commentView;
                if (layoutInflater != null) {
                    comment = this.comment;
                    if (comment != null) {
                        Intrinsics.m26847b(comment, "comment");
                        Object b22 = SessionManager.b();
                        Intrinsics.m26843a(b22, "SessionManager.getInstance()");
                        b22 = b22.c();
                        Intrinsics.m26843a(b22, Session.TYPE_SESSION);
                        Intrinsics.m26847b(comment, "comment");
                        Intrinsics.m26847b(b22, Session.TYPE_SESSION);
                        f = Util.m24027f((int) C1761R.string.internal_deleted);
                        if (TextUtils.equals(f, comment.c())) {
                            f = comment.c();
                        }
                        noneOf = EnumSet.noneOf(Indicator.class);
                        layoutInflater.getAuthorView().setText(f);
                        TextView authorView2 = layoutInflater.getAuthorView();
                        Object context2 = layoutInflater.getContext();
                        Intrinsics.m26843a(context2, "context");
                        authorView2.setTextColor(context2.getResources().getColor(C1761R.color.rdt_blue));
                        noneOf.add(Indicator.f20734c);
                        if (ModUtil.m23823a(comment.getName()).getDistinguishState(comment.getName(), Intrinsics.m26845a(comment.g(), BannedForCommentView.f28581o))) {
                            layoutInflater.getAuthorView().setTextColor(Util.m23950a((int) C1761R.color.rdt_green));
                            noneOf.add(Indicator.f20733b);
                        } else if (ModUtil.m23823a(comment.a()).getDistinguishAdminState(comment.getName(), TextUtils.equals(comment.g(), BannedForCommentView.f28582p))) {
                            layoutInflater.getAuthorView().setTextColor(Util.m23950a((int) C1761R.color.rdt_red));
                            noneOf.add(Indicator.f20732a);
                        }
                        if (comment.e()) {
                            noneOf.add(Indicator.f20736e);
                        }
                        UserIndicatorsView authorIndicators2 = layoutInflater.getAuthorIndicators();
                        Intrinsics.m26843a(noneOf, "indicators");
                        authorIndicators2.setActiveIndicators((Set) noneOf);
                        layoutInflater.getBody().setHtmlFromString(comment.b());
                        layoutInflater.getBody().setVisibility(0);
                        layoutInflater.getBody().setPaintFlags(((layoutInflater.getBody().getPaintFlags() | 128) | 256) | 1);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Comment");
                    }
                }
                layoutInflater = this.commentView;
                if (layoutInflater != null) {
                    layoutInflater.setOnClickListener((OnClickListener) new C1853x2ee5d3ab(this));
                }
            }
        }
        obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void m40748a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_modtools_add_user, menu);
        Object findItem = menu.findItem(C1761R.id.action_modtools_add);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_modtools_add)");
        this.f40084C = findItem;
        findItem = this.f40085D;
        if (findItem == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(findItem, ModScreenMode.f20922b) != null) {
            menu = this.f40084C;
            if (menu == null) {
                Intrinsics.m26844a("menuItem");
            }
            menu.setTitle(C1761R.string.action_modtools_save);
            menu = this.f40084C;
            if (menu == null) {
                Intrinsics.m26844a("menuItem");
            }
            menu.setEnabled(true);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_modtools_add) {
            return super.mo7201a(menuItem);
        }
        String str;
        Long valueOf;
        ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27452c)).m21892b(ModEventBuilder.f27450a);
        Object obj = this.f40085D;
        if (obj == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(obj, ModScreenMode.f20921a)) {
            str = ModNoun.f20057p.f20068M;
        } else {
            str = ModNoun.f20058q.f20068M;
        }
        ((ModEventBuilder) ((ModEventBuilder) modEventBuilder.m21895c(str)).m21889a(mo7376a(), mo7379b())).m21891a();
        menuItem = this.f40091z;
        if (menuItem == null) {
            Intrinsics.m26844a("presenter");
        }
        EditText editText = this.username;
        if (editText == null) {
            Intrinsics.m26844a("username");
        }
        Object text = editText.getText();
        Intrinsics.m26843a(text, "username.text");
        String obj2 = StringsKt__StringsKt.m42456b((CharSequence) text).toString();
        editText = this.reason;
        if (editText == null) {
            Intrinsics.m26844a("reason");
        }
        String obj3 = editText.getText().toString();
        editText = this.banMessage;
        if (editText == null) {
            Intrinsics.m26844a("banMessage");
        }
        String obj4 = editText.getText().toString();
        editText = this.modNote;
        if (editText == null) {
            Intrinsics.m26844a("modNote");
        }
        String obj5 = editText.getText().toString();
        editText = this.durationEditText;
        if (editText == null) {
            Intrinsics.m26844a("durationEditText");
        }
        text = editText.getText();
        Intrinsics.m26843a(text, "durationEditText.text");
        if (((CharSequence) text).length() > 0) {
            editText = this.durationEditText;
            if (editText == null) {
                Intrinsics.m26844a("durationEditText");
            }
            valueOf = Long.valueOf(Long.parseLong(editText.getText().toString()));
        } else {
            valueOf = null;
        }
        menuItem.m34797a(new BanInfoModel(obj2, obj3, obj5, obj4, valueOf));
        return true;
    }

    private final void m40745x() {
        MenuItem menuItem = this.f40084C;
        if (menuItem == null) {
            Intrinsics.m26844a("menuItem");
        }
        EditText editText = this.username;
        if (editText == null) {
            Intrinsics.m26844a("username");
        }
        Object text = editText.getText();
        Intrinsics.m26843a(text, "username.text");
        boolean z = false;
        if (StringsKt__StringsKt.m42456b((CharSequence) text).length() > 0) {
            editText = this.reason;
            if (editText == null) {
                Intrinsics.m26844a("reason");
            }
            text = editText.getText();
            Intrinsics.m26843a(text, "reason.text");
            if (((CharSequence) text).length() > 0) {
                z = true;
            }
        }
        menuItem.setEnabled(z);
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40091z;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    public final void mo7377a(String str) {
        Intrinsics.m26847b(str, "username");
        m29351F();
        Controller k = k();
        if (k == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.modtools.ModAddUserTarget");
        }
        ((ModAddUserTarget) k).mo7384a(str, C1761R.string.mod_tools_action_ban_success);
    }

    public final void mo7380b(String str) {
        Intrinsics.m26847b(str, "errorMessage");
        str = Screens.m22629a(this, str, -1);
        if (str != null) {
            str.a();
        }
    }

    public final void mo7378a(List<String> list) {
        Intrinsics.m26847b(list, "rules");
        this.f40086E.addAll(list);
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, "errorMessage");
        str = Screens.m22629a(this, str, -1);
        if (str != null) {
            str.a();
        }
    }

    public final void onEventMainThread(BanReason banReason) {
        Intrinsics.m26847b(banReason, "banReason");
        EventBus.getDefault().removeStickyEvent((Object) banReason);
        EditText editText = this.reason;
        if (editText == null) {
            Intrinsics.m26844a("reason");
        }
        editText.setText((CharSequence) banReason.f20896a);
        m40745x();
    }

    @OnTextChanged
    public final void onUsernameTextChanged(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "textChanged");
        Object obj = this.f40085D;
        if (obj == null) {
            Intrinsics.m26844a("screenMode");
        }
        if (Intrinsics.m26845a(obj, ModScreenMode.f20921a) != null) {
            m40745x();
        }
    }

    @OnTextChanged
    public final void onDurationTextChanged(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "textChanged");
        if ((charSequence.length() > null ? true : null) != null) {
            charSequence = this.permanentRadioButon;
            if (charSequence == null) {
                Intrinsics.m26844a("permanentRadioButon");
            }
            charSequence.setChecked(false);
        }
    }

    @OnClick
    public final void onClick() {
        EditText editText = this.durationEditText;
        if (editText == null) {
            Intrinsics.m26844a("durationEditText");
        }
        Object text = editText.getText();
        Intrinsics.m26843a(text, "durationEditText.text");
        if ((((CharSequence) text).length() > 0 ? 1 : null) != null) {
            editText = this.durationEditText;
            if (editText == null) {
                Intrinsics.m26844a("durationEditText");
            }
            editText.getText().clear();
        }
    }

    private final boolean m40744w() {
        if (this.link != null) {
            Link link = this.link;
            if (link == null) {
                Intrinsics.m26842a();
            }
            if (link.getCrosspostParentList() != null) {
                link = this.link;
                if (link == null) {
                    Intrinsics.m26842a();
                }
                if (link.getCrosspostParentList().size() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final /* synthetic */ void m40743b(AddBannedUserScreen addBannedUserScreen) {
        ClientLink b = Util.m23994b(addBannedUserScreen.link);
        if (addBannedUserScreen.f40088w == null || b == null) {
            OnViewMediaListener onViewMediaListener = addBannedUserScreen.f40088w;
            if (onViewMediaListener == null) {
                Intrinsics.m26842a();
            }
            onViewMediaListener.mo4993a(addBannedUserScreen.link);
            return;
        }
        addBannedUserScreen = addBannedUserScreen.f40088w;
        if (addBannedUserScreen == null) {
            Intrinsics.m26842a();
        }
        addBannedUserScreen.mo4993a(b);
    }
}
