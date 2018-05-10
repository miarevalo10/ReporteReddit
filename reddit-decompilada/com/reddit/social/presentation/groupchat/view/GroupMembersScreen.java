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
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent;
import com.reddit.datalibrary.social.data.common.StateStorageBundle;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.social.presentation.chatrequests.view.MembersAdapter;
import com.reddit.social.presentation.groupchat.GroupMembersContract.Presenter;
import com.reddit.social.presentation.groupchat.GroupMembersContract.View;
import com.reddit.social.presentation.presentationobjects.UserData;
import de.greenrobot.event.EventBus;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.hockeyapp.android.UpdateFragment;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0014J\u0018\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u00101\u001a\u00020,H\u0016J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020*2\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u000208H\u0016J\u0010\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\u0005H\u0014J\u0010\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020\u0005H\u0014J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020*H\u0016J\u0016\u0010\u0015\u001a\u00020*2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0JH\u0016J\u0010\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020,H\u0016J\u0010\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u00020\u000fH\u0002R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR2\u0010\r\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006P"}, d2 = {"Lcom/reddit/social/presentation/groupchat/view/GroupMembersScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/social/presentation/groupchat/GroupMembersContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "setDisposables", "(Lio/reactivex/disposables/CompositeDisposable;)V", "memberClick", "Lio/reactivex/subjects/PublishSubject;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "kotlin.jvm.PlatformType", "members", "Landroid/support/v7/widget/RecyclerView;", "getMembers", "()Landroid/support/v7/widget/RecyclerView;", "setMembers", "(Landroid/support/v7/widget/RecyclerView;)V", "membersAdapter", "Lcom/reddit/social/presentation/chatrequests/view/MembersAdapter;", "getMembersAdapter", "()Lcom/reddit/social/presentation/chatrequests/view/MembersAdapter;", "setMembersAdapter", "(Lcom/reddit/social/presentation/chatrequests/view/MembersAdapter;)V", "noConnectionBanner", "Landroid/widget/TextView;", "getNoConnectionBanner", "()Landroid/widget/TextView;", "setNoConnectionBanner", "(Landroid/widget/TextView;)V", "presenter", "Lcom/reddit/social/presentation/groupchat/GroupMembersContract$Presenter;", "getPresenter", "()Lcom/reddit/social/presentation/groupchat/GroupMembersContract$Presenter;", "setPresenter", "(Lcom/reddit/social/presentation/groupchat/GroupMembersContract$Presenter;)V", "blockMember", "", "userId", "", "configureActionBar", "actionBar", "Landroid/support/v7/app/ActionBar;", "confirmBlockUser", "username", "getLayoutId", "", "networkConnectionChange", "hasNetworkConnection", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "view", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRestoreInstanceState", "savedInstanceState", "onSaveInstanceState", "outState", "reportUserError", "error", "", "reportUserSuccess", "", "showMessage", "message", "showUserReportDialog", "user", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMembersScreen.kt */
public final class GroupMembersScreen extends MvpBaseScreen implements View {
    public static final Companion f40207y = new Companion();
    @BindView
    public RecyclerView members;
    @BindView
    public TextView noConnectionBanner;
    @Inject
    public Presenter f40208v;
    public CompositeDisposable f40209w;
    public MembersAdapter f40210x;
    private final PublishSubject<UserData> f40211z = PublishSubject.create();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, d2 = {"Lcom/reddit/social/presentation/groupchat/view/GroupMembersScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/social/presentation/groupchat/view/GroupMembersScreen;", "url", "", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GroupMembersScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static GroupMembersScreen m24692a(String str, List<UserData> list) {
            Intrinsics.m26847b(str, UpdateFragment.FRAGMENT_URL);
            Intrinsics.m26847b(list, "members");
            GroupMembersScreen groupMembersScreen = new GroupMembersScreen();
            groupMembersScreen.m41282w().mo5157a(str, (List) list);
            return groupMembersScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f22348a;

        static {
            int[] iArr = new int[UserActions.values().length];
            f22348a = iArr;
            iArr[UserActions.f22372a.ordinal()] = 1;
            f22348a[UserActions.f22374c.ordinal()] = 2;
            f22348a[UserActions.f22373b.ordinal()] = 3;
        }
    }

    public final int mo7141s() {
        return C1761R.layout.screen_group_members;
    }

    public GroupMembersScreen() {
        super();
        FrontpageApplication.m28878n().mo5097a(this);
    }

    public GroupMembersScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        FrontpageApplication.m28878n().mo5097a(this);
    }

    public final Presenter m41282w() {
        Presenter presenter = this.f40208v;
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
        Object obj = this.f40211z;
        Intrinsics.m26843a(obj, "memberClick");
        this.f40210x = new MembersAdapter(obj);
        layoutInflater = this.members;
        if (layoutInflater == null) {
            Intrinsics.m26844a("members");
        }
        layoutInflater.setLayoutManager((LayoutManager) new LinearLayoutManager(am_(), 1, false));
        layoutInflater = this.members;
        if (layoutInflater == null) {
            Intrinsics.m26844a("members");
        }
        viewGroup = this.f40210x;
        if (viewGroup == null) {
            Intrinsics.m26844a("membersAdapter");
        }
        layoutInflater.setAdapter((Adapter) viewGroup);
        layoutInflater = am_();
        if (layoutInflater == null) {
            Intrinsics.m26842a();
        }
        layoutInflater = DividerItemDecoration.m30092a((Context) layoutInflater, 1);
        viewGroup = this.members;
        if (viewGroup == null) {
            Intrinsics.m26844a("members");
        }
        viewGroup.addItemDecoration((ItemDecoration) layoutInflater);
        this.f40209w = new CompositeDisposable();
        layoutInflater = this.f40209w;
        if (layoutInflater == null) {
            Intrinsics.m26844a("disposables");
        }
        Observable flatMapSingle = this.f40211z.flatMapSingle(new GroupMembersScreen$onCreateView$1(this));
        Intrinsics.m26843a((Object) flatMapSingle, "memberClick\n        .fla…] }\n          }\n        }");
        DisposableKt.m26766a(layoutInflater, ObservablesKt.m24091a(flatMapSingle, (Function1) new GroupMembersScreen$onCreateView$2(this)));
        layoutInflater = this.f40208v;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.mo5153a((View) this);
        Object obj2 = this.K;
        Intrinsics.m26843a(obj2, "rootView");
        return obj2;
    }

    public final void mo7544a(List<UserData> list) {
        Intrinsics.m26847b(list, "members");
        MembersAdapter membersAdapter = this.f40210x;
        if (membersAdapter == null) {
            Intrinsics.m26844a("membersAdapter");
        }
        membersAdapter.m30712a((List) list);
    }

    public final void mo7540a() {
        String f = Util.m24027f((int) C1761R.string.chat_success_user_report);
        Intrinsics.m26843a((Object) f, "Util.getString(R.string.chat_success_user_report)");
        mo7541a(f);
    }

    public final void mo7543a(Throwable th) {
        Intrinsics.m26847b(th, "error");
        StringBuilder stringBuilder = new StringBuilder("Report user error: ");
        stringBuilder.append(th.getLocalizedMessage());
        Timber.e(stringBuilder.toString(), new Object[0]);
        Toast.makeText(am_(), C1761R.string.chat_error_something_went_wrong_report, 1).show();
    }

    public final void mo7542a(String str, String str2) {
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(str2, "username");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23297a((Context) am_, str2, (Function2) new GroupMembersScreen$confirmBlockUser$1(this, str)).m23323a();
    }

    public final void mo7546b(String str) {
        Intrinsics.m26847b(str, "userId");
        MembersAdapter membersAdapter = this.f40210x;
        if (membersAdapter == null) {
            Intrinsics.m26844a("membersAdapter");
        }
        membersAdapter.m30711a(str);
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        actionBar.c(false);
        actionBar.a(Util.m23957a(Util.m23950a((int) C1761R.color.rdt_meta_text), Mode.SRC_ATOP));
    }

    public final void mo7545a(boolean z) {
        TextView textView = this.noConnectionBanner;
        if (textView == null) {
            Intrinsics.m26844a("noConnectionBanner");
        }
        ViewsKt.m24106b(textView, z ^ 1);
    }

    public final void mo7541a(String str) {
        Intrinsics.m26847b(str, "message");
        EventBus eventBus = EventBus.getDefault();
        com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent.Companion companion = MessageEvent.c;
        eventBus.post(com.reddit.datalibrary.frontpage.data.common.busevents.MessageEvent.Companion.a(str));
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return null;
        }
        m29351F();
        return true;
    }

    protected final void mo6991b(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        Presenter presenter = this.f40208v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5152a((StateStorageContract) new StateStorageBundle(bundle));
        super.mo6991b(bundle);
    }

    protected final void mo7199c(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        Presenter presenter = this.f40208v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5158b(new StateStorageBundle(bundle));
        super.mo7199c(bundle);
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        CompositeDisposable compositeDisposable = this.f40209w;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
        Presenter presenter = this.f40208v;
        if (presenter == null) {
            Intrinsics.m26844a("presenter");
        }
        presenter.mo5151a();
        super.mo6987a(view);
    }

    public static final /* synthetic */ void m41267a(GroupMembersScreen groupMembersScreen, UserData userData) {
        Object e = Util.m24023e((int) C1761R.array.report_user_reasons);
        Intrinsics.m26843a(e, "Util.getStringArray(R.array.report_user_reasons)");
        List i = ArraysKt___ArraysKt.m36109i((Object[]) e);
        CompositeDisposable compositeDisposable = groupMembersScreen.f40209w;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = groupMembersScreen.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Object subscribe = com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23301a((Context) am_, (Collection) i, (int) C1761R.string.action_report).observeOn(SchedulerProvider.m23886b()).subscribe(new GroupMembersScreen$showUserReportDialog$1(groupMembersScreen, userData, i), (Consumer) new GroupMembersScreen$showUserReportDialog$2(groupMembersScreen));
        Intrinsics.m26843a(subscribe, "RedditAlertDialog.select…   { reportUserError(it)}");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }
}
