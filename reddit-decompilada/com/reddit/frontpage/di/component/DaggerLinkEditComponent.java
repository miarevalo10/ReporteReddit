package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.LinkEditModule;
import com.reddit.frontpage.di.module.LinkEditModule_ProvideEditPresenterFactory;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.detail.EditContract.LinkParameters;
import com.reddit.frontpage.presentation.detail.EditContract.Presenter;
import com.reddit.frontpage.presentation.detail.EditContract.View;
import com.reddit.frontpage.presentation.detail.EditFragment_MembersInjector;
import com.reddit.frontpage.presentation.detail.LinkEditFragment;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerLinkEditComponent implements LinkEditComponent {
    private Provider<View> f27723a;
    private com_reddit_frontpage_di_component_UserComponent_linkRepository f27724b;
    private C2269xdbdd5b83 f27725c;
    private Provider<LinkParameters> f27726d;
    private Provider<Presenter> f27727e;

    private static final class Builder implements com.reddit.frontpage.di.component.LinkEditComponent.Builder {
        private LinkEditModule f27717a;
        private UserComponent f27718b;
        private LinkParameters f27719c;
        private View f27720d;

        private Builder() {
        }

        public final LinkEditComponent mo4675a() {
            if (this.f27717a == null) {
                this.f27717a = new LinkEditModule();
            }
            StringBuilder stringBuilder;
            if (this.f27718b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27719c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(LinkParameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27720d != null) {
                return new DaggerLinkEditComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_linkRepository implements Provider<LinkRepository> {
        private final UserComponent f27721a;

        com_reddit_frontpage_di_component_UserComponent_linkRepository(UserComponent userComponent) {
            this.f27721a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (LinkRepository) Preconditions.m26013a(this.f27721a.mo4628p(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2269xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27722a;

        C2269xdbdd5b83(UserComponent userComponent) {
            this.f27722a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27722a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerLinkEditComponent(Builder builder) {
        this.f27723a = InstanceFactory.m35583a(builder.f27720d);
        this.f27724b = new com_reddit_frontpage_di_component_UserComponent_linkRepository(builder.f27718b);
        this.f27725c = new C2269xdbdd5b83(builder.f27718b);
        this.f27726d = InstanceFactory.m35583a(builder.f27719c);
        this.f27727e = DoubleCheck.m31842a(LinkEditModule_ProvideEditPresenterFactory.m34495a(builder.f27717a, this.f27723a, this.f27724b, this.f27725c, this.f27726d));
    }

    public static com.reddit.frontpage.di.component.LinkEditComponent.Builder m29162a() {
        return new Builder();
    }

    public final void mo4676a(LinkEditFragment linkEditFragment) {
        EditFragment_MembersInjector.m29495a(linkEditFragment, (Presenter) this.f27727e.get());
    }
}
