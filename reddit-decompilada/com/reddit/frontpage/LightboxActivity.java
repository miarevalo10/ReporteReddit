package com.reddit.frontpage;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Routing.NavigationAware;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.detail.video.VideoPlayerScreen;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.parceler.Parcels;
import timber.log.Timber;

public class LightboxActivity extends BaseActivity implements NavigationAware {
    private static final Subject<Boolean> f40810j = PublishSubject.create();
    @BindView
    ViewGroup container;
    private Router f40811d;
    private Screen f40812h;
    private String f40813i = null;
    @BindView
    ViewGroup root;

    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected final boolean mo7780i() {
        return true;
    }

    public static Observable<Boolean> m42691f() {
        return f40810j;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ButterKnife.a(this);
        this.f40811d = Conductor.a(this, this.container, bundle);
        this.root.setBackgroundColor(0);
        this.f40813i = getIntent().getStringExtra("com.reddit.frontpage.extra_source_page");
        int intExtra = getIntent().getIntExtra("com.reddit.frontpage.extra_type", 1);
        if (!this.f40811d.n()) {
            Screen screen = null;
            Link j;
            if (intExtra == 1) {
                j = m42692j();
                if (j != null) {
                    screen = Nav.m22564b(j, this.f40813i);
                } else {
                    String stringExtra = getIntent().getStringExtra("com.reddit.frontpage.extra_image_url");
                    int intExtra2 = getIntent().getIntExtra("com.reddit.frontpage.extra_image_width", -1);
                    int intExtra3 = getIntent().getIntExtra("com.reddit.frontpage.extra_image_height", -1);
                    if (stringExtra == null || intExtra2 == -1 || intExtra3 == -1) {
                        Timber.e("Tried to create an image lightbox, but link / url+width+height were missing", new Object[0]);
                    } else {
                        screen = Nav.m22552a(stringExtra, this.f40813i, intExtra2, intExtra3);
                    }
                }
                this.f40812h = screen;
            } else if (intExtra == 2) {
                j = m42692j();
                if (j != null) {
                    screen = Nav.m22569c(j, this.f40813i);
                } else {
                    Uri uri = (Uri) getIntent().getParcelableExtra("com.reddit.frontpage.extra_video_uri");
                    Uri uri2 = (Uri) getIntent().getParcelableExtra("com.reddit.frontpage.extra_video_preview_uri");
                    if (!(uri == null || uri2 == null)) {
                        screen = Nav.m22540a(uri, uri2, this.f40813i);
                    }
                }
                this.f40812h = screen;
            } else {
                return;
            }
            if (this.f40812h != null) {
                this.f40811d.b(RouterTransaction.a(this.f40812h).a(Routing.m22615a()).b(Routing.m22615a()));
            } else {
                return;
            }
        }
        if (bundle != null) {
            Bridge.a(this, bundle);
        }
        if (m42693l() != null) {
            m42694m().m28956a(Action.CLICK).m28957a(Noun.ENTER_FEED).m21891a();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bridge.b(this, bundle);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        f40810j.onNext(Boolean.valueOf(true));
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 108) {
            f40810j.onNext(Boolean.valueOf(false));
        }
        super.onPanelClosed(i, menu);
    }

    private Link m42692j() {
        return (Link) Parcels.m28673a(getIntent().getParcelableExtra("com.reddit.frontpage.extra_link"));
    }

    public void onBackPressed() {
        if (m42693l()) {
            m42694m().m28956a(Action.CLICK).m28957a(Noun.EXIT_FEED).m21891a();
        }
        if (!this.f40811d.i()) {
            if (this.f40812h instanceof VideoPlayerScreen) {
                this.f40812h.mo6986J();
            }
            super.onBackPressed();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final Router mo7778g() {
        return this.f40811d;
    }

    public final Router mo7779h() {
        return this.f40811d;
    }

    private boolean m42693l() {
        if (!"onboarding".equals(this.f40813i)) {
            if (!"onboarding_post_detail".equals(this.f40813i)) {
                return false;
            }
        }
        return true;
    }

    private OnboardingEventBuilder m42694m() {
        OnboardingEventBuilder a = new OnboardingEventBuilder().m28959a(Source.THEATER_MODE);
        if ("onboarding".equals(this.f40813i)) {
            a.m28958a(PageType.RECOMMENDATIONS);
        } else if ("onboarding_post_detail".equals(this.f40813i)) {
            a.m28958a(PageType.POST_DETAIL);
        }
        Link j = m42692j();
        return a.m28955a(j).m28961b(j);
    }
}
