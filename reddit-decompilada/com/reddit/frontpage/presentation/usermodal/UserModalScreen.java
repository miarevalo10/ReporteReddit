package com.reddit.frontpage.presentation.usermodal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatDialog;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.feature.modtools.repo.RedditModToolsRepository.ModToolsActionType;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerUserModalComponent;
import com.reddit.frontpage.di.module.UserModalModule;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import com.reddit.frontpage.presentation.usermodal.UserModalContract.View;
import com.reddit.frontpage.presentation.usermodal.UserModalPresenter.UserModalInfo;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.frontpage.widgets.profile.AccountStatsView;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import net.hockeyapp.android.UpdateFragment;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 W2\u00020\u0001:\u0001WB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020K2\u0006\u0010Q\u001a\u00020\nH\u0016J\u0010\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020\rH\u0016J\u0010\u0010T\u001a\u00020K2\u0006\u0010U\u001a\u00020\nH\u0002J\b\u0010V\u001a\u00020KH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001b\u00102\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0013\u001a\u0004\b3\u0010\u0017R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8BX\u0002¢\u0006\f\n\u0004\b?\u0010\u0013\u001a\u0004\b=\u0010>R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0002¢\u0006\f\n\u0004\bD\u0010\u0013\u001a\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u001fR\u001b\u0010G\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\bI\u0010\u0013\u001a\u0004\bH\u0010\u0017¨\u0006X"}, d2 = {"Lcom/reddit/frontpage/presentation/usermodal/UserModalScreen;", "Lcom/reddit/frontpage/presentation/usermodal/UserModalContract$View;", "screen", "Lcom/reddit/frontpage/nav/Screen;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "(Lcom/reddit/frontpage/nav/Screen;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;)V", "author", "", "(Lcom/reddit/frontpage/nav/Screen;Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;Ljava/lang/String;)V", "accountData", "Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter$UserModalInfo;", "accountStats", "Lcom/reddit/frontpage/widgets/profile/AccountStatsView;", "getAccountStats", "()Lcom/reddit/frontpage/widgets/profile/AccountStatsView;", "accountStats$delegate", "Lkotlin/Lazy;", "banUserView", "Lcom/reddit/frontpage/presentation/usermodal/UserModalItem;", "getBanUserView", "()Lcom/reddit/frontpage/presentation/usermodal/UserModalItem;", "banUserView$delegate", "getComment", "()Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "setComment", "(Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;)V", "commentId", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "setContext", "(Landroid/app/Activity;)V", "dialog", "Landroid/app/Dialog;", "formatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "getFormatter", "()Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "setFormatter", "(Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;)V", "getLink", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "muteUserView", "getMuteUserView", "muteUserView$delegate", "presenter", "Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/usermodal/UserModalPresenter;)V", "profileImage", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "getProfileImage", "()Lcom/reddit/frontpage/widgets/ShapedIconView;", "profileImage$delegate", "userName", "Landroid/widget/TextView;", "getUserName", "()Landroid/widget/TextView;", "userName$delegate", "username", "getUsername", "viewProfileView", "getViewProfileView", "viewProfileView$delegate", "onComplete", "", "action", "Lcom/reddit/frontpage/presentation/usermodal/UserModalAction;", "stringRes", "", "onError", "message", "onProfileDataReady", "data", "sendDialogOpenedEvent", "source", "show", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserModalScreen.kt */
public final class UserModalScreen implements View {
    static final /* synthetic */ KProperty[] f28815a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserModalScreen.class), "profileImage", "getProfileImage()Lcom/reddit/frontpage/widgets/ShapedIconView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserModalScreen.class), "userName", "getUserName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserModalScreen.class), "accountStats", "getAccountStats()Lcom/reddit/frontpage/widgets/profile/AccountStatsView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserModalScreen.class), "banUserView", "getBanUserView()Lcom/reddit/frontpage/presentation/usermodal/UserModalItem;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserModalScreen.class), "muteUserView", "getMuteUserView()Lcom/reddit/frontpage/presentation/usermodal/UserModalItem;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(UserModalScreen.class), "viewProfileView", "getViewProfileView()Lcom/reddit/frontpage/presentation/usermodal/UserModalItem;"))};
    public static final Companion f28816i = new Companion();
    @Inject
    public UserModalPresenter f28817b;
    @Inject
    public AccountFormatter f28818c;
    final Link f28819d;
    final String f28820e;
    Comment f28821f;
    public Activity f28822g;
    String f28823h;
    private Dialog f28824j;
    private final Lazy f28825k;
    private final Lazy f28826l;
    private final Lazy f28827m;
    private final Lazy f28828n;
    private final Lazy f28829o;
    private final Lazy f28830p;
    private UserModalInfo f28831q;
    private final Screen f28832r;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/usermodal/UserModalScreen$Companion;", "", "()V", "VERTICAL_FILL_RATIO", "", "newInstance", "Lcom/reddit/frontpage/presentation/usermodal/UserModalScreen;", "screen", "Lcom/reddit/frontpage/nav/Screen;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserModalScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static UserModalScreen m23214a(Screen screen, Link link) {
            Intrinsics.m26847b(screen, "screen");
            Intrinsics.m26847b(link, "link");
            String author = link.getAuthor();
            Intrinsics.m26843a((Object) author, "link.author");
            UserModalScreen userModalScreen = new UserModalScreen(screen, link, author);
            UserModalScreen.m29888a(userModalScreen, ModEventBuilder.f27452c);
            return userModalScreen;
        }

        public static UserModalScreen m23215a(Screen screen, Link link, Comment comment) {
            Intrinsics.m26847b(screen, "screen");
            Intrinsics.m26847b(link, "link");
            Intrinsics.m26847b(comment, "comment");
            UserModalScreen userModalScreen = new UserModalScreen(screen, link, comment);
            screen = comment.getName();
            Intrinsics.m26847b(screen, "<set-?>");
            userModalScreen.f28823h = screen;
            userModalScreen.f28821f = comment;
            UserModalScreen.m29888a(userModalScreen, ModEventBuilder.f27453d);
            return userModalScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20995a;

        static {
            int[] iArr = new int[UserModalAction.values().length];
            f20995a = iArr;
            iArr[UserModalAction.f20988c.ordinal()] = 1;
            f20995a[UserModalAction.f20989d.ordinal()] = 2;
            f20995a[UserModalAction.f20986a.ordinal()] = 3;
            f20995a[UserModalAction.f20987b.ordinal()] = 4;
        }
    }

    public static final UserModalScreen m29886a(Screen screen, Link link) {
        return Companion.m23214a(screen, link);
    }

    public static final UserModalScreen m29887a(Screen screen, Link link, Comment comment) {
        return Companion.m23215a(screen, link, comment);
    }

    private final UserModalItem m29891g() {
        return (UserModalItem) this.f28828n.mo5678b();
    }

    private final UserModalItem m29892h() {
        return (UserModalItem) this.f28829o.mo5678b();
    }

    public UserModalScreen(Screen screen, final Link link, String str) {
        Intrinsics.m26847b(screen, "screen");
        Intrinsics.m26847b(link, "link");
        Intrinsics.m26847b(str, "author");
        this.f28832r = screen;
        this.f28825k = LazyKt.m26777a((Function0) new UserModalScreen$profileImage$2(this));
        this.f28826l = LazyKt.m26777a((Function0) new UserModalScreen$userName$2(this));
        this.f28827m = LazyKt.m26777a((Function0) new UserModalScreen$accountStats$2(this));
        this.f28828n = LazyKt.m26777a((Function0) new UserModalScreen$banUserView$2(this));
        this.f28829o = LazyKt.m26777a((Function0) new UserModalScreen$muteUserView$2(this));
        this.f28830p = LazyKt.m26777a((Function0) new UserModalScreen$viewProfileView$2(this));
        this.f28823h = "";
        DaggerUserModalComponent.m29291a().m22175a(FrontpageApplication.m28875k()).m22176a(new UserModalModule(this)).m22177a().mo4747a(this);
        screen = this.f28832r.am_();
        if (screen == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26847b(screen, "<set-?>");
        this.f28822g = screen;
        this.f28819d = link;
        this.f28820e = str;
        screen = this.f28817b;
        if (screen == null) {
            Intrinsics.m26844a("presenter");
        }
        screen.attach();
        this.f28824j = (Dialog) new AppCompatDialog(m29900e());
        screen = this.f28824j;
        if (screen == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        screen.setContentView(C1761R.layout.dialog_user_modal);
        screen = this.f28824j;
        if (screen == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        screen.setCanceledOnTouchOutside(true);
        screen = new DisplayMetrics();
        str = this.f28824j;
        if (str == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        Object window = str.getWindow();
        Intrinsics.m26843a(window, "dialog.window");
        window = window.getWindowManager();
        Intrinsics.m26843a(window, "dialog.window.windowManager");
        window.getDefaultDisplay().getMetrics(screen);
        screen = screen.widthPixels;
        str = new LayoutParams();
        Dialog dialog = this.f28824j;
        if (dialog == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        Object window2 = dialog.getWindow();
        Intrinsics.m26843a(window2, "dialog.window");
        str.copyFrom(window2.getAttributes());
        str.width = (int) (((float) screen) * 0.8f);
        screen = this.f28824j;
        if (screen == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        Object window3 = screen.getWindow();
        Intrinsics.m26843a(window3, "dialog.window");
        window3.setAttributes(str);
        m29891g().setOnClickListener(new UserModalScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new Function1<android.view.View, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                if (this.f28831q == null) {
                    Screens.m22631a((Context) this.m29900e(), (int) C1761R.string.error_server_error);
                } else {
                    UserModalScreen.m29885a(this).dismiss();
                    obj = this.f28831q;
                    obj = obj != null ? Boolean.valueOf(obj.f20993b) : null;
                    if (obj == null) {
                        Intrinsics.m26842a();
                    }
                    if (obj.booleanValue() == null) {
                        String str;
                        Screen a;
                        if (this.f28821f != null) {
                            obj = this.m29899d();
                            str = this.f28820e;
                            Comment comment = this.f28821f;
                            if (comment == null) {
                                Intrinsics.m26842a();
                            }
                            Screen c = this.f28832r;
                            Intrinsics.m26847b(str, "username");
                            Intrinsics.m26847b(comment, "comment");
                            Intrinsics.m26847b(c, "targetScreen");
                            a = Nav.m22549a(str, comment);
                            Intrinsics.m26843a((Object) a, "screen");
                            a.m29363b(c);
                            Routing.m22619a(obj.f34178a.mo4938c(), a);
                        } else {
                            obj = this.m29899d();
                            str = this.f28820e;
                            Link link = this.f28819d;
                            String str2 = this.f28823h;
                            Screen c2 = this.f28832r;
                            Intrinsics.m26847b(str, "username");
                            Intrinsics.m26847b(link, "link");
                            Intrinsics.m26847b(str2, "commentId");
                            Intrinsics.m26847b(c2, "targetScreen");
                            a = Nav.m22556a(str, str2, link);
                            Intrinsics.m26843a((Object) a, "screen");
                            a.m29363b(c2);
                            Routing.m22619a(obj.f34178a.mo4938c(), a);
                        }
                    } else if (link.getSubredditDetail() != null) {
                        obj = link.getSubredditDetail();
                        Intrinsics.m26843a(obj, "link.subredditDetail");
                        if (obj.b() != null) {
                            obj = RedditAlertDialog.f21112b;
                            com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23295a(this.m29900e(), this.f28820e, C1761R.string.mod_tools_action_unban, C1761R.string.mod_tools_action_unban_content, C1761R.string.mod_tools_option_unban, (Function2) new Function2<DialogInterface, Integer, Unit>() {
                                public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
                                    DialogInterface dialogInterface = (DialogInterface) obj;
                                    ((Number) obj2).intValue();
                                    Intrinsics.m26847b(dialogInterface, "<anonymous parameter 0>");
                                    obj = AppAnalytics.m21880q();
                                    ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) obj.m21888a((String) ModEventBuilder.f27452c)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20038J.f20068M);
                                    String name = link.getSubredditDetail().getName();
                                    Object subredditDetail = link.getSubredditDetail();
                                    Intrinsics.m26843a(subredditDetail, "link.subredditDetail");
                                    subredditDetail = subredditDetail.b();
                                    Intrinsics.m26843a(subredditDetail, "link.subredditDetail.displayName");
                                    modEventBuilder.m21889a(name, subredditDetail);
                                    if ((StringsKt__StringsJVMKt.m41943a((CharSequence) this.f28823h) ^ 1) != null) {
                                        obj.m21893b(this.f28823h, link.getName());
                                    }
                                    obj.m21891a();
                                    obj = this.m29899d();
                                    obj2 = this.f28831q;
                                    if (obj2 != null) {
                                        obj2 = obj2.f20992a;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 == null) {
                                        Intrinsics.m26842a();
                                    }
                                    obj2 = obj2.getId();
                                    ModToolsActionType modToolsActionType = ModToolsActionType.a;
                                    Intrinsics.m26847b(obj2, "id");
                                    Intrinsics.m26847b(modToolsActionType, "type");
                                    ModToolsRepository modToolsRepository = obj.f34179b;
                                    Object subredditDetail2 = obj.f34178a.mo4937b().getSubredditDetail();
                                    Intrinsics.m26843a(subredditDetail2, "view.link.subredditDetail");
                                    String b = subredditDetail2.b();
                                    Intrinsics.m26843a((Object) b, "view.link.subredditDetail.displayName");
                                    SinglesKt.m24094b(modToolsRepository.m22440a(b, UserModalPresenter.m34878a(obj2), modToolsActionType), obj.f34180c).subscribe(new UserModalPresenter$unban$1(obj), new UserModalPresenter$unban$2(obj));
                                    return Unit.f25273a;
                                }
                            }, false).m23323a();
                        }
                    }
                }
                return Unit.f25273a;
            }
        }));
        m29892h().setOnClickListener((OnClickListener) new UserModalScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new Function1<android.view.View, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                UserModalScreen.m29885a(this).dismiss();
                if (this.f28831q == null) {
                    Screens.m22631a((Context) this.m29900e(), (int) C1761R.string.error_server_error);
                } else {
                    obj = this.f28831q;
                    if (obj == null) {
                        Intrinsics.m26842a();
                    }
                    if (obj.f20994c == null) {
                        obj = this.m29899d();
                        String str = this.f28820e;
                        Link link = link;
                        String str2 = this.f28823h;
                        Screen c = this.f28832r;
                        Intrinsics.m26847b(str, "username");
                        Intrinsics.m26847b(link, "link");
                        Intrinsics.m26847b(str2, "commentId");
                        Intrinsics.m26847b(c, "targetScreen");
                        String name = link.getSubredditDetail().getName();
                        Object subredditDetail = link.getSubredditDetail();
                        Intrinsics.m26843a(subredditDetail, "link.subredditDetail");
                        Screen a = Nav.m22559a(name, subredditDetail.b(), str, link.getName(), AppAnalytics.m21848a(link.getLinkType()).name(), link.getTitle(), str2);
                        Intrinsics.m26843a((Object) a, "screen");
                        a.m29363b(c);
                        Routing.m22619a(obj.f34178a.mo4938c(), a);
                    } else if (link.getSubredditDetail() != null) {
                        obj = link.getSubredditDetail();
                        Intrinsics.m26843a(obj, "link.subredditDetail");
                        if (obj.b() != null) {
                            obj = RedditAlertDialog.f21112b;
                            com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23295a(this.m29900e(), this.f28820e, C1761R.string.mod_tools_action_unmute, C1761R.string.mod_tools_action_unmute_content, C1761R.string.mod_tools_option_unmute, (Function2) new Function2<DialogInterface, Integer, Unit>() {
                                public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
                                    DialogInterface dialogInterface = (DialogInterface) obj;
                                    ((Number) obj2).intValue();
                                    Intrinsics.m26847b(dialogInterface, "<anonymous parameter 0>");
                                    ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a((String) ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20038J.f20068M);
                                    obj2 = link.getSubredditDetail().getName();
                                    Object subredditDetail = link.getSubredditDetail();
                                    Intrinsics.m26843a(subredditDetail, "link.subredditDetail");
                                    subredditDetail = subredditDetail.b();
                                    Intrinsics.m26843a(subredditDetail, "link.subredditDetail.displayName");
                                    ((ModEventBuilder) modEventBuilder.m21889a(obj2, subredditDetail)).m21891a();
                                    obj = this.f28831q;
                                    obj2 = null;
                                    if (obj != null) {
                                        obj = obj.f20992a;
                                    } else {
                                        obj = null;
                                    }
                                    if (obj != null) {
                                        obj = this.m29899d();
                                        UserModalInfo b = this.f28831q;
                                        if (b != null) {
                                            obj2 = b.f20992a;
                                        }
                                        if (obj2 == null) {
                                            Intrinsics.m26842a();
                                        }
                                        obj2 = obj2.getId();
                                        Intrinsics.m26847b(obj2, "id");
                                        ModToolsRepository modToolsRepository = obj.f34179b;
                                        Object subredditDetail2 = obj.f34178a.mo4937b().getSubredditDetail();
                                        Intrinsics.m26843a(subredditDetail2, "view.link.subredditDetail");
                                        subredditDetail2 = subredditDetail2.b();
                                        Intrinsics.m26843a(subredditDetail2, "view.link.subredditDetail.displayName");
                                        SinglesKt.m24094b(modToolsRepository.m22458g(subredditDetail2, UserModalPresenter.m34878a(obj2)), obj.f34180c).subscribe(new UserModalPresenter$unmute$1(obj), new UserModalPresenter$unmute$2(obj));
                                    }
                                    return Unit.f25273a;
                                }
                            }, false).m23323a();
                        }
                    }
                }
                return Unit.f25273a;
            }
        }));
        ((UserModalItem) this.f28830p.mo5678b()).setOnClickListener((OnClickListener) new UserModalScreen$inlined$sam$OnClickListener$i$7f478c20((Function1) new Function1<android.view.View, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                UserModalScreen.m29885a(this).dismiss();
                Routing.m22619a((Context) this.m29900e(), Nav.m22594j(this.f28820e));
                return Unit.f25273a;
            }
        }));
    }

    public static final /* synthetic */ Dialog m29885a(UserModalScreen userModalScreen) {
        userModalScreen = userModalScreen.f28824j;
        if (userModalScreen == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        return userModalScreen;
    }

    public final /* synthetic */ Context mo4938c() {
        return m29900e();
    }

    public UserModalScreen(Screen screen, Link link, Comment comment) {
        Intrinsics.m26847b(screen, "screen");
        Intrinsics.m26847b(link, "link");
        Intrinsics.m26847b(comment, "comment");
        String c = comment.c();
        Intrinsics.m26843a((Object) c, "comment.author");
        this(screen, link, c);
        this.f28821f = comment;
    }

    public final UserModalPresenter m29899d() {
        UserModalPresenter userModalPresenter = this.f28817b;
        if (userModalPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return userModalPresenter;
    }

    public final Link mo4937b() {
        return this.f28819d;
    }

    public final String mo4933a() {
        return this.f28820e;
    }

    public final Activity m29900e() {
        Activity activity = this.f28822g;
        if (activity == null) {
            Intrinsics.m26844a("context");
        }
        return activity;
    }

    public final void m29901f() {
        Dialog dialog = this.f28824j;
        if (dialog == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        dialog.show();
    }

    public final void mo4935a(UserModalInfo userModalInfo) {
        Intrinsics.m26847b(userModalInfo, "data");
        this.f28831q = userModalInfo;
        AccountFormatter accountFormatter = this.f28818c;
        if (accountFormatter == null) {
            Intrinsics.m26844a("formatter");
        }
        String b = accountFormatter.mo4820b(userModalInfo.f20992a);
        AccountFormatter accountFormatter2 = this.f28818c;
        if (accountFormatter2 == null) {
            Intrinsics.m26844a("formatter");
        }
        String a = accountFormatter2.mo4818a(userModalInfo.f20992a);
        AccountFormatter accountFormatter3 = this.f28818c;
        if (accountFormatter3 == null) {
            Intrinsics.m26844a("formatter");
        }
        ((AccountStatsView) this.f28827m.mo5678b()).m30526a(new UserAccountPresentationModel(b, a, accountFormatter3.mo4822c(userModalInfo.f20992a), CollectionsKt__CollectionsKt.m26790a()));
        TextView textView = (TextView) this.f28826l.mo5678b();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
        Object f = Util.m24027f((int) C1761R.string.fmt_u_name);
        Intrinsics.m26843a(f, "Util.getString(R.string.fmt_u_name)");
        f = String.format(f, Arrays.copyOf(new Object[]{this.f28820e}, 1));
        Intrinsics.m26843a(f, "java.lang.String.format(format, *args)");
        textView.setText((CharSequence) f);
        ShapedIconView shapedIconView = (ShapedIconView) this.f28825k.mo5678b();
        UserSubreddit subreddit = userModalInfo.f20992a.getSubreddit();
        Object obj = null;
        if (subreddit != null) {
            b = subreddit.getIconImg();
        } else {
            b = null;
        }
        UserSubreddit subreddit2 = userModalInfo.f20992a.getSubreddit();
        Util.m23987a(shapedIconView, b, subreddit2 != null ? subreddit2.getKeyColor() : null, true);
        Object b2 = SessionManager.b();
        Intrinsics.m26843a(b2, "SessionManager.getInstance()");
        Account d = b2.d();
        if (d != null) {
            b2 = d.getName();
            UserModalInfo userModalInfo2 = this.f28831q;
            if (userModalInfo2 != null) {
                com.reddit.datalibrary.frontpage.data.model.Account account = userModalInfo2.f20992a;
                if (account != null) {
                    obj = account.getUsername();
                }
            }
            if ((Intrinsics.m26845a(b2, obj) ^ 1) != 0) {
                m29891g().setVisibility(0);
                m29892h().setVisibility(0);
                Dialog dialog = this.f28824j;
                if (dialog == null) {
                    Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
                }
                android.view.View findViewById = dialog.findViewById(C1761R.id.separator_one);
                if (findViewById == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                }
                findViewById.setVisibility(0);
                dialog = this.f28824j;
                if (dialog == null) {
                    Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
                }
                findViewById = dialog.findViewById(C1761R.id.separator_two);
                if (findViewById == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
                }
                findViewById.setVisibility(0);
                if (userModalInfo.f20993b) {
                    UserModalItem g = m29891g();
                    Object string = m29900e().getString(C1761R.string.mod_tools_action_unban_user);
                    Intrinsics.m26843a(string, "context.getString(R.stri…_tools_action_unban_user)");
                    g.setText(string);
                    ((TextView) m29891g().m23213a(C1761R.id.text)).setTextColor(ContextCompat.c(m29900e(), C1761R.color.rdt_red));
                    ((ImageView) m29891g().m23213a(C1761R.id.left_icon)).setImageResource(C1761R.drawable.ic_unban);
                    b2 = (ImageView) m29891g().m23213a(C1761R.id.left_icon);
                    Intrinsics.m26843a(b2, "banUserView.left_icon");
                    DrawableCompat.a(b2.getDrawable(), ContextCompat.c(m29900e(), C1761R.color.rdt_red));
                }
                if (userModalInfo.f20994c != null) {
                    userModalInfo = m29892h();
                    b2 = m29900e().getString(C1761R.string.mod_tools_action_unmute_user);
                    Intrinsics.m26843a(b2, "context.getString(R.stri…tools_action_unmute_user)");
                    userModalInfo.setText(b2);
                    ((TextView) m29892h().m23213a(C1761R.id.text)).setTextColor(ContextCompat.c(m29900e(), C1761R.color.rdt_red));
                    ((ImageView) m29892h().m23213a(C1761R.id.left_icon)).setImageResource(C1761R.drawable.ic_unmute);
                    Object obj2 = (ImageView) m29892h().m23213a(C1761R.id.left_icon);
                    Intrinsics.m26843a(obj2, "muteUserView.left_icon");
                    DrawableCompat.a(obj2.getDrawable(), ContextCompat.c(m29900e(), C1761R.color.rdt_red));
                }
            }
        }
    }

    public final void mo4934a(UserModalAction userModalAction, int i) {
        String string;
        Intrinsics.m26847b(userModalAction, "action");
        Object string2;
        switch (WhenMappings.f20995a[userModalAction.ordinal()]) {
            case 1:
                userModalAction = m29892h();
                string2 = m29900e().getString(C1761R.string.mod_tools_action_unmute_user);
                Intrinsics.m26843a(string2, "context.getString(R.stri…tools_action_unmute_user)");
                userModalAction.setText(string2);
                string = m29900e().getString(i, new Object[]{this.f28820e});
                Intrinsics.m26843a((Object) string, "context.getString(stringRes, username)");
                break;
            case 2:
                userModalAction = m29892h();
                string2 = m29900e().getString(C1761R.string.mod_tools_action_mute_user);
                Intrinsics.m26843a(string2, "context.getString(R.stri…d_tools_action_mute_user)");
                userModalAction.setText(string2);
                string = m29900e().getString(i, new Object[]{this.f28820e});
                Intrinsics.m26843a((Object) string, "context.getString(stringRes, username)");
                break;
            case 3:
                userModalAction = m29891g();
                string2 = m29900e().getString(C1761R.string.mod_tools_action_unban_user);
                Intrinsics.m26843a(string2, "context.getString(R.stri…_tools_action_unban_user)");
                userModalAction.setText(string2);
                string = m29900e().getString(i, new Object[]{this.f28820e});
                Intrinsics.m26843a((Object) string, "context.getString(stringRes, username)");
                break;
            case 4:
                userModalAction = m29891g();
                string2 = m29900e().getString(C1761R.string.mod_tools_action_ban_user);
                Intrinsics.m26843a(string2, "context.getString(R.stri…od_tools_action_ban_user)");
                userModalAction.setText(string2);
                string = m29900e().getString(i, new Object[]{this.f28820e});
                Intrinsics.m26843a((Object) string, "context.getString(stringRes, username)");
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Screens.m22632a((Context) m29900e(), string);
        userModalAction = this.f28824j;
        if (userModalAction == null) {
            Intrinsics.m26844a(UpdateFragment.FRAGMENT_DIALOG);
        }
        userModalAction.dismiss();
    }

    public final void mo4936a(String str) {
        Intrinsics.m26847b(str, "message");
        Screens.m22632a((Context) m29900e(), str);
    }

    public static final /* synthetic */ void m29888a(UserModalScreen userModalScreen, String str) {
        if (userModalScreen.f28819d.getSubredditDetail() != null) {
            Object subredditDetail = userModalScreen.f28819d.getSubredditDetail();
            Intrinsics.m26843a(subredditDetail, "link.subredditDetail");
            if (subredditDetail.b() != null) {
                ModEventBuilder q = AppAnalytics.m21880q();
                ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) q.m21888a(str)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20037I.f20068M);
                String name = userModalScreen.f28819d.getSubredditDetail().getName();
                Object subredditDetail2 = userModalScreen.f28819d.getSubredditDetail();
                Intrinsics.m26843a(subredditDetail2, "link.subredditDetail");
                subredditDetail2 = subredditDetail2.b();
                Intrinsics.m26843a(subredditDetail2, "link.subredditDetail.displayName");
                modEventBuilder = (ModEventBuilder) modEventBuilder.m21889a(name, subredditDetail2);
                name = userModalScreen.f28819d.getName();
                String name2 = AppAnalytics.m21848a(userModalScreen.f28819d.getLinkType()).name();
                Object title = userModalScreen.f28819d.getTitle();
                Intrinsics.m26843a(title, "link.title");
                modEventBuilder.m21890a(name, name2, title);
                if ((StringsKt__StringsJVMKt.m41943a((CharSequence) userModalScreen.f28823h) ^ 1) != null) {
                    q.m21893b(userModalScreen.f28823h, userModalScreen.f28819d.getName());
                }
                q.m21891a();
            }
        }
    }
}
