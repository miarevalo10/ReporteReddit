package com.reddit.frontpage.ui.inbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.google.common.collect.ImmutableList;
import com.reddit.datalibrary.frontpage.data.feature.common.NotificationSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortSelection;
import com.reddit.datalibrary.frontpage.data.provider.InboxFilterableListingProvider;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SortOption;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

public class NotificationsInboxListingScreen extends InboxListingScreen {
    static final List<SortOption<NotificationSortType>> f40154B;
    static final SortOption<NotificationSortType> f40155C;
    private final CompositeDisposable f40156D = new CompositeDisposable();
    @BindView
    ListingFilterBarView sortBar;
    @BindView
    FrameLayout sortContainer;
    final PublishSubject<SortSelection<NotificationSortType>> f40157v = PublishSubject.create();

    class C23341 implements Observer<SortSelection<NotificationSortType>> {
        final /* synthetic */ NotificationsInboxListingScreen f29007a;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        C23341(NotificationsInboxListingScreen notificationsInboxListingScreen) {
            this.f29007a = notificationsInboxListingScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            SortSelection sortSelection = (SortSelection) obj;
            if (this.f29007a.e) {
                NotificationsInboxListingScreen.m40990a(this.f29007a, sortSelection.a);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f29007a.f40156D.mo5631a(disposable);
        }
    }

    public String getAnalyticsScreenName() {
        return "inbox_notifications";
    }

    public final String mo7443w() {
        return "inbox";
    }

    static {
        List a = ImmutableList.a(new SortOption(C1761R.drawable.ic_icon_activity, C1761R.string.label_sort_all, NotificationSortType.a, false), new SortOption(C1761R.drawable.ic_icon_comment, C1761R.string.label_sort_post_replies, NotificationSortType.b, false), new SortOption(C1761R.drawable.ic_icon_reply, C1761R.string.label_sort_comment_replies, NotificationSortType.c, false), new SortOption(C1761R.drawable.ic_icon_redditor, C1761R.string.label_sort_mentions, NotificationSortType.d, false));
        f40154B = a;
        f40155C = (SortOption) a.get(0);
    }

    public static NotificationsInboxListingScreen m40988Q() {
        return new NotificationsInboxListingScreen();
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        this.f39177A = new NotificationsInboxListingScreen$$Lambda$0(this);
        this.sortContainer.setVisibility(null);
        layoutInflater = m40991R();
        this.sortBar.m24180a(am_().getResources().getString(layoutInflater.f20413b), layoutInflater.f20412a);
        this.sortBar.setOnSortClickListener(new NotificationsInboxListingScreen$$Lambda$1(this));
        this.f40157v.subscribeOn(FrontpageApplication.m28875k().mo4632t().a()).observeOn(FrontpageApplication.m28875k().mo4633u().a()).subscribe(new C23341(this));
        return this.K;
    }

    final SortOption m40991R() {
        NotificationSortType notificationSortType = ((InboxFilterableListingProvider) this.z).c;
        for (SortOption sortOption : f40154B) {
            if (sortOption.f20414c == notificationSortType) {
                return sortOption;
            }
        }
        return f40155C;
    }

    protected final void mo6993c(View view) {
        super.mo6993c(view);
        this.f40156D.m32077c();
    }

    protected final void mo7144v() {
        this.z = new InboxFilterableListingProvider("inbox");
        m37523a(this.z);
    }

    static /* synthetic */ void m40990a(NotificationsInboxListingScreen notificationsInboxListingScreen, SortOption sortOption) {
        notificationsInboxListingScreen.sortBar.m24180a(notificationsInboxListingScreen.am_().getResources().getString(sortOption.f20413b), sortOption.f20412a);
        if (((InboxFilterableListingProvider) notificationsInboxListingScreen.z).a((NotificationSortType) sortOption.f20414c) != null) {
            notificationsInboxListingScreen.mErrorContainer.setVisibility(8);
            notificationsInboxListingScreen.emptyContainer.setVisibility(8);
            notificationsInboxListingScreen.m39192y();
        }
    }
}
