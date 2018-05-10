package com.reddit.frontpage.ui.submit.location;

import android.location.Location;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.facebook.stetho.server.http.HttpStatus;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.provider.LocationDataProvider;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.RedditRequestBuilder;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.foursquare.FoursquareVenueDataProvider;
import com.reddit.frontpage.foursquare.FoursquareVenueDataProvider$$Lambda$0;
import com.reddit.frontpage.foursquare.FoursquareVenueDataProvider.C22921;
import com.reddit.frontpage.foursquare.FoursquareVenueDataProvider.C22932;
import com.reddit.frontpage.foursquare.api.FoursquareClient;
import com.reddit.frontpage.foursquare.model.LocationDistance;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.HasToolbar;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.PermissionUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.GoEditTextView;
import de.greenrobot.event.EventBus;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class LocationSearchScreen extends BaseScreen implements HasToolbar {
    @BindView
    View errorContainer;
    @BindView
    TextView errorMessage;
    @BindView
    View loadingSpinner;
    @State
    Location location;
    @BindView
    GoEditTextView locationEdit;
    @BindView
    RecyclerView recyclerView;
    @BindView
    SwipeRefreshLayout refreshLayout;
    @State
    String requestId;
    @BindView
    TextView retryButton;
    @BindView
    public Toolbar toolbar;
    private List<Disposable> f39365v;
    private LocationDataProvider f39366w;
    private FoursquareVenueDataProvider f39367x;
    private LocationDataAdapter f39368y;
    private String f39369z;

    public static class LocationSearchResultEvent extends BaseEvent {
        public final String f29350a;
        public final LocationDistance f29351b;

        public LocationSearchResultEvent(String str, LocationDistance locationDistance) {
            this.f29350a = str;
            this.f29351b = locationDistance;
        }
    }

    class C26971 extends DisposableObserver<List<LocationDistance>> {
        final /* synthetic */ LocationSearchScreen f34463a;

        public void onComplete() {
        }

        C26971(LocationSearchScreen locationSearchScreen) {
            this.f34463a = locationSearchScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            List list = (List) obj;
            if (list.isEmpty()) {
                this.f34463a.m39582b(Util.m23960a((int) C1761R.string.error_unable_find_location, this.f34463a.f39369z));
                return;
            }
            list.add(0, new LocationDistance(Util.m24027f((int) C1761R.string.none_location), null, null, -1.0d, null));
            LocationSearchScreen.m39581a(this.f34463a, list);
        }

        public void onError(Throwable th) {
            Timber.e("Error fetching data from foursquare", new Object[0]);
            this.f34463a.m39582b(Util.m24027f((int) C1761R.string.error_current_location));
        }
    }

    class C26982 extends DisposableObserver<Location> {
        final /* synthetic */ LocationSearchScreen f34464a;

        public void onComplete() {
        }

        C26982(LocationSearchScreen locationSearchScreen) {
            this.f34464a = locationSearchScreen;
        }

        public /* synthetic */ void onNext(Object obj) {
            LocationSearchScreen.m39579a(this.f34464a, (Location) obj);
        }

        public void onError(Throwable th) {
            Timber.e("Error figuring out current location.", new Object[0]);
            this.f34464a.m39582b(Util.m24027f((int) C1761R.string.error_current_location));
        }
    }

    public String getAnalyticsScreenName() {
        return "post_location";
    }

    public final int mo7141s() {
        return C1761R.layout.screen_location_search;
    }

    public final int mo7143u() {
        return 2;
    }

    public static LocationSearchScreen m39577a(String str) {
        LocationSearchScreen locationSearchScreen = new LocationSearchScreen();
        locationSearchScreen.requestId = str;
        return locationSearchScreen;
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.mo7139a(layoutInflater, viewGroup);
        BaseActivity baseActivity = (BaseActivity) am_();
        this.loadingSpinner.setBackground(AnimUtil.m23637a(baseActivity));
        this.recyclerView.setLayoutManager(new LinearLayoutManager(baseActivity, 1, false));
        this.f39368y = new LocationDataAdapter(this);
        this.recyclerView.setAdapter(this.f39368y);
        if (PermissionUtil.m23864a(am_()) != null) {
            m39583y();
        }
        this.locationEdit.setFilters(new InputFilter[0]);
        this.locationEdit.setOnEditorActionListener(new LocationSearchScreen$$Lambda$0(this));
        this.locationEdit.setOnGoClickedListener(new LocationSearchScreen$$Lambda$1(this));
        this.refreshLayout.setEnabled(false);
        this.retryButton.setOnClickListener(new LocationSearchScreen$$Lambda$2(this));
        return this.K;
    }

    final boolean m39595w() {
        String trim = this.locationEdit.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return false;
        }
        if (trim.length() > HttpStatus.HTTP_OK) {
            m39582b(Util.m24027f((int) C1761R.string.error_max_query_length_exceeded));
            return false;
        }
        this.f39369z = trim;
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = getAnalyticsScreenName();
        b.f19955b = "post_location_search";
        b.f19960g = this.f39369z;
        b.m21825a();
        m39596x();
        return true;
    }

    public final void m39586a(int i, String[] strArr, int[] iArr) {
        if (i == 19) {
            m39583y();
        } else {
            super.a(i, strArr, iArr);
        }
    }

    private void m39583y() {
        this.f39365v = new ArrayList(2);
        FoursquareVenueDataProvider foursquareVenueDataProvider = this.f39367x;
        Disposable disposable = (Disposable) foursquareVenueDataProvider.f28032a.subscribeOn(SchedulerProvider.m23886b()).zipWith(foursquareVenueDataProvider.f28033b, new FoursquareVenueDataProvider$$Lambda$0(foursquareVenueDataProvider, am_())).observeOn(SchedulerProvider.m23887c()).subscribeWith(new C26971(this));
        Disposable disposable2 = (Disposable) this.f39366w.a().subscribeWith(new C26982(this));
        this.f39365v.add(disposable);
        this.f39365v.add(disposable2);
    }

    protected final void au() {
        n();
        AppCompatActivity appCompatActivity = (AppCompatActivity) am_();
        appCompatActivity.a(at());
        mo7185a(appCompatActivity.c().a());
    }

    protected final void mo7185a(ActionBar actionBar) {
        actionBar.c(true);
        actionBar.a(true);
        actionBar.b(true);
        this.toolbar.setTitle(C1761R.string.add_location);
    }

    public final void mo7144v() {
        this.f39366w = new LocationDataProvider(am_());
        this.f39367x = new FoursquareVenueDataProvider();
        m37527a("location", this.f39366w);
        m37527a("foursquare", this.f39367x);
    }

    public final void mo6987a(View view) {
        if (this.f39365v != null) {
            for (Disposable a : this.f39365v) {
                a.mo5626a();
            }
        }
        super.mo6987a(view);
    }

    public final boolean mo6986J() {
        ScreenUtil.m23888a(am_());
        return super.mo6986J();
    }

    public final boolean mo7201a(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return null;
        }
        m29351F();
        return true;
    }

    final void m39596x() {
        if (this.location != null) {
            this.loadingSpinner.setVisibility(0);
            this.refreshLayout.setVisibility(8);
            this.errorContainer.setVisibility(8);
            FoursquareVenueDataProvider foursquareVenueDataProvider = this.f39367x;
            String a = Util.m23962a(this.location);
            Object obj = this.f39369z;
            foursquareVenueDataProvider.latlong = a;
            Util.m24006c();
            FoursquareClient foursquareClient = new FoursquareClient();
            RedditRequestBuilder redditRequestBuilder = (RedditRequestBuilder) new RedditRequestBuilder(foursquareClient.f20302a, FoursquareClient.f20301b).a("v2/venues/search").a("client_id", "XVZRK24YKLTDIIYTGDR0PDFUVQBTBMGCHNZZOJE1R52VITCD").a("client_secret", "OOXBJ5X2JWWLCMUPTIMMH3CSBCQKDGQD2TSKLDVWU5XBEGVY").a("v", "20170420");
            if ((TextUtils.isEmpty(obj) ^ 1) != 0) {
                redditRequestBuilder.a("query", obj).a("intent", "global");
            } else {
                redditRequestBuilder.a("ll", a).a("intent", "checkin");
            }
            RedditRequestBuilder redditRequestBuilder2 = (RedditRequestBuilder) new RedditRequestBuilder(foursquareClient.f20302a, FoursquareClient.f20301b).a("v2/venues/search").a("client_id", "XVZRK24YKLTDIIYTGDR0PDFUVQBTBMGCHNZZOJE1R52VITCD").a("client_secret", "OOXBJ5X2JWWLCMUPTIMMH3CSBCQKDGQD2TSKLDVWU5XBEGVY").a("v", "20170420").a("ll", a).a("categoryId", "4d4b7105d754a06373d81259").a("limit", "5");
            if (!TextUtils.isEmpty(obj)) {
                redditRequestBuilder2.a("query", obj);
            }
            redditRequestBuilder.a(new C22921(foursquareVenueDataProvider));
            redditRequestBuilder2.a(new C22932(foursquareVenueDataProvider));
        }
    }

    private void m39582b(String str) {
        this.loadingSpinner.setVisibility(8);
        this.refreshLayout.setVisibility(8);
        this.errorContainer.setVisibility(0);
        this.errorMessage.setText(str);
    }

    final void m39589a(LocationDistance locationDistance) {
        EventBus.getDefault().postSticky(new LocationSearchResultEvent(this.requestId, locationDistance));
        m29351F();
    }

    public final Toolbar mo7208b() {
        return this.toolbar;
    }

    static /* synthetic */ void m39581a(LocationSearchScreen locationSearchScreen, List list) {
        locationSearchScreen.loadingSpinner.setVisibility(8);
        locationSearchScreen.refreshLayout.setVisibility(0);
        locationSearchScreen.errorContainer.setVisibility(8);
        locationSearchScreen = locationSearchScreen.f39368y;
        locationSearchScreen.f29347a = list;
        locationSearchScreen.a_.b();
    }

    static /* synthetic */ void m39579a(LocationSearchScreen locationSearchScreen, Location location) {
        locationSearchScreen.location = location;
        locationSearchScreen.m39596x();
    }
}
