package com.reddit.frontpage.ui.inbox;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.crashlytics.android.Crashlytics;
import com.google.common.collect.Lists;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository;
import com.reddit.datalibrary.frontpage.data.feature.inboxcount.InboxCountRepository.InboxCount;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteGatewayDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import com.reddit.frontpage.ui.BadgeView;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ScreenPager;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import javax.inject.Inject;
import kotlin.Unit;
import timber.log.Timber;

public class InboxPagerScreen extends BaseScreen {
    private static final int[] f39184y = new int[]{C1761R.string.title_tab_notifications, C1761R.string.title_tab_messages, C1761R.string.title_tab_mod_mail};
    private BadgeView f39185A;
    private BadgeView f39186B;
    private BadgeView f39187C;
    @BindView
    TabLayout mTabLayout;
    @BindView
    ScreenPager screenPager;
    @BindView
    Toolbar toolbar;
    @Inject
    RemoteRedditApiDataSource f39188v;
    @Inject
    RemoteGatewayDataSource f39189w;
    protected InboxPagerAdapter f39190x;
    private Disposable f39191z;

    class C26861 extends DisposableObserver<InboxCount> {
        final /* synthetic */ InboxPagerScreen f34298a;

        public void onComplete() {
        }

        C26861(InboxPagerScreen inboxPagerScreen) {
            this.f34298a = inboxPagerScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            InboxPagerScreen.m39194a(this.f34298a, (InboxCount) obj);
        }

        public void onError(Throwable th) {
            InboxPagerScreen.m39194a(this.f34298a, null);
            Timber.e(th.getMessage(), new Object[0]);
        }
    }

    class C26872 extends DisposableCompletableObserver {
        final /* synthetic */ InboxPagerScreen f34299a;

        C26872(InboxPagerScreen inboxPagerScreen) {
            this.f34299a = inboxPagerScreen;
        }

        public void onComplete() {
            Timber.a("Marking notifications as read succeeded", new Object[0]);
        }

        public void onError(Throwable th) {
            Timber.c(th, "Marking notifications as read failed", new Object[0]);
        }
    }

    private class InboxPagerAdapter extends ScreenPagerAdapter {
        final /* synthetic */ InboxPagerScreen f37254d;

        InboxPagerAdapter(InboxPagerScreen inboxPagerScreen) {
            this.f37254d = inboxPagerScreen;
            super(inboxPagerScreen, true);
        }

        public final Screen mo6953a(int i) {
            switch (i) {
                case 0:
                    return NotificationsInboxListingScreen.m40988Q();
                case 1:
                    return MessagesInboxListingScreen.m40981Q();
                case 2:
                    return ModeratorInboxListingScreen.m40985Q();
                default:
                    return 0;
            }
        }

        public final int mo6955f() {
            return InboxPagerScreen.f39184y.length;
        }

        public final CharSequence m37582b(int i) {
            return Util.m24027f(InboxPagerScreen.f39184y[i]);
        }
    }

    protected final boolean af_() {
        return true;
    }

    public final int mo7141s() {
        return C1761R.layout.fragment_inbox_pager;
    }

    public static InboxPagerScreen m39195w() {
        return new InboxPagerScreen();
    }

    protected final void mo7142t() {
        super.mo7142t();
        FrontpageApplication.m28877m().mo4607a(this);
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        n();
        this.f39190x = new InboxPagerAdapter(this);
        this.screenPager.setAdapter(this.f39190x);
        this.screenPager.setOffscreenPageLimit(2);
        this.mTabLayout.setupWithViewPager(this.screenPager);
        TextView textView = (TextView) LayoutInflater.from(am_()).inflate(C1761R.layout.tab_text_view, null);
        textView.setText(f39184y[0]);
        TextView textView2 = (TextView) LayoutInflater.from(am_()).inflate(C1761R.layout.tab_text_view, null);
        textView2.setText(f39184y[1]);
        TextView textView3 = (TextView) LayoutInflater.from(am_()).inflate(C1761R.layout.tab_text_view, null);
        textView3.setText(f39184y[2]);
        Tab a = this.mTabLayout.a(0);
        Tab a2 = this.mTabLayout.a(1);
        viewGroup = this.mTabLayout.a(2);
        a.a(textView);
        a2.a(textView2);
        viewGroup.a(textView3);
        this.f39185A = new BadgeView(am_(), textView);
        m39193a(this.f39185A);
        this.f39186B = new BadgeView(am_(), textView2);
        m39193a(this.f39186B);
        this.f39187C = new BadgeView(am_(), textView3);
        m39193a(this.f39187C);
        layoutInflater = InboxCountRepository.a;
        this.f39191z = (Disposable) InboxCountRepository.f().subscribeWith(new C26861(this));
        return this.K;
    }

    protected final void mo6992b(View view) {
        Crashlytics.log("InboxPagerScreen: uses ScreenPager");
        super.mo6992b(view);
    }

    private static void m39193a(BadgeView badgeView) {
        badgeView.setBadgePosition(2);
        badgeView.f34199b = 0;
        badgeView.f34200c = 0;
        badgeView.setTextSize(2, 10.0f);
    }

    public final void mo6987a(View view) {
        if (this.f39191z != null) {
            this.f39191z.mo5626a();
        }
        super.mo6987a(view);
        this.f39190x.f34367g = false;
        this.f39190x = null;
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.b(false);
        this.toolbar.findViewById(C1761R.id.search_view).setVisibility(8);
    }

    public final boolean mo7200K() {
        if (!(this.screenPager == null || this.f39190x == null)) {
            Screen d = this.f39190x.m35102d(this.screenPager.getCurrentItem());
            if (d != null) {
                return d.mo7200K();
            }
        }
        return false;
    }

    public final void m39201a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        if (!SessionManager.b().c.isAnonymous()) {
            menuInflater.inflate(C1761R.menu.menu_notification_inbox, menu);
        }
    }

    public final boolean mo7201a(MenuItem menuItem) {
        if (menuItem.getItemId() != C1761R.id.action_overflow_menu) {
            return false;
        }
        new ListOptionsDialog(am_(), Lists.a(new ListOptionAction[]{new ListOptionAction(am_().getString(C1761R.string.title_compose), Integer.valueOf(C1761R.drawable.ic_icon_post_edit), new InboxPagerScreen$$Lambda$0(this)), new ListOptionAction(am_().getString(C1761R.string.action_mark_notifications_read), Integer.valueOf(C1761R.drawable.ic_mark_read), new InboxPagerScreen$$Lambda$1(this))}), (byte) 0).show();
        return true;
    }

    final /* synthetic */ Unit m39199a(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f39189w.markAllNotificationsRead("").subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).subscribe(new C26872(this));
        dialogInterface = InboxCountRepository.a;
        InboxCountRepository.d();
        for (dialogInterface = null; dialogInterface < f39184y.length; dialogInterface++) {
            ((InboxListingScreen) this.f39190x.m35102d(dialogInterface)).m39191x();
        }
        return Unit.f25273a;
    }

    static /* synthetic */ void m39194a(InboxPagerScreen inboxPagerScreen, InboxCount inboxCount) {
        if (inboxCount == null || inboxCount.a <= 0) {
            inboxPagerScreen.f39185A.setText("0");
            inboxPagerScreen.f39185A.m34895b();
        } else {
            inboxPagerScreen.f39185A.setText(String.valueOf(inboxCount.a));
            inboxPagerScreen.f39185A.m34894a();
        }
        if (inboxCount == null || inboxCount.b <= 0) {
            inboxPagerScreen.f39186B.setText("0");
            inboxPagerScreen.f39186B.m34895b();
            return;
        }
        inboxPagerScreen.f39186B.setText(String.valueOf(inboxCount.b));
        inboxPagerScreen.f39186B.m34894a();
    }
}
