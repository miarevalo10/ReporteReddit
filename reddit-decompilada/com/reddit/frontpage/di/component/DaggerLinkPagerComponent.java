package com.reddit.frontpage.di.component;

import android.app.Activity;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadData;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadData_Factory;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.View;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerPresenter;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerPresenter_Factory;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen_MembersInjector;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerLinkPagerComponent implements LinkPagerComponent {
    private Lazy<? extends Activity> f27736a;
    private Provider<View> f27737b;
    private com_reddit_frontpage_di_component_UserComponent_linkRepository f27738c;
    private C2271xab6fc1a4 f27739d;
    private Provider<LinkPagerLoadData> f27740e;
    private Provider<Parameters> f27741f;
    private C2270xdbdd5b83 f27742g;
    private Provider<LinkPagerPresenter> f27743h;

    private static final class Builder implements com.reddit.frontpage.di.component.LinkPagerComponent.Builder {
        private UserComponent f27729a;
        private View f27730b;
        private Lazy<? extends Activity> f27731c;
        private Parameters f27732d;

        private Builder() {
        }

        public final LinkPagerComponent mo4682a() {
            StringBuilder stringBuilder;
            if (this.f27729a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27730b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27731c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27732d != null) {
                return new DaggerLinkPagerComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_linkRepository implements Provider<LinkRepository> {
        private final UserComponent f27733a;

        com_reddit_frontpage_di_component_UserComponent_linkRepository(UserComponent userComponent) {
            this.f27733a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (LinkRepository) Preconditions.m26013a(this.f27733a.mo4628p(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2270xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27734a;

        C2270xdbdd5b83(UserComponent userComponent) {
            this.f27734a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27734a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2271xab6fc1a4 implements Provider<PreferenceRepository> {
        private final UserComponent f27735a;

        C2271xab6fc1a4(UserComponent userComponent) {
            this.f27735a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PreferenceRepository) Preconditions.m26013a(this.f27735a.mo4613a(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerLinkPagerComponent(Builder builder) {
        this.f27737b = InstanceFactory.m35583a(builder.f27730b);
        this.f27738c = new com_reddit_frontpage_di_component_UserComponent_linkRepository(builder.f27729a);
        this.f27739d = new C2271xab6fc1a4(builder.f27729a);
        this.f27740e = DoubleCheck.m31842a(LinkPagerLoadData_Factory.m34564a(this.f27738c, this.f27739d));
        this.f27741f = InstanceFactory.m35583a(builder.f27732d);
        this.f27742g = new C2270xdbdd5b83(builder.f27729a);
        this.f27743h = DoubleCheck.m31842a(LinkPagerPresenter_Factory.m34741a(this.f27737b, this.f27740e, this.f27741f, this.f27742g, this.f27738c));
        this.f27736a = builder.f27731c;
    }

    public static com.reddit.frontpage.di.component.LinkPagerComponent.Builder m29175a() {
        return new Builder();
    }

    public final void mo4683a(LinkPagerScreen linkPagerScreen) {
        LinkPagerScreen_MembersInjector.m29673a(linkPagerScreen, (LinkPagerPresenter) this.f27743h.get());
        LinkPagerScreen_MembersInjector.m29674a(linkPagerScreen, new AdVisibilityTracker(this.f27736a));
    }
}
