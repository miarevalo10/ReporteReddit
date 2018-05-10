package com.reddit.frontpage.di.component;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.frontpage.di.module.OnboardingViewModule;
import com.reddit.frontpage.di.module.OnboardingViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import com.reddit.frontpage.presentation.onboarding.OnboardingContract.View;
import com.reddit.frontpage.presentation.onboarding.OnboardingPresenter;
import com.reddit.frontpage.presentation.onboarding.OnboardingPresenter_Factory;
import com.reddit.frontpage.presentation.onboarding.OnboardingScreen;
import com.reddit.frontpage.presentation.onboarding.OnboardingScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerOnboardingViewComponent implements OnboardingViewComponent {
    private Provider<View> f27819a;
    private C2277xa5e66dc7 f27820b;
    private C2279xfa494edd f27821c;
    private com_reddit_frontpage_di_component_UserComponent_backgroundThread f27822d;
    private C2278xdbdd5b83 f27823e;
    private Provider<OnboardingPresenter> f27824f;

    public static final class Builder {
        private OnboardingViewModule f20207a;
        private UserComponent f20208b;

        private Builder() {
        }

        public final OnboardingViewComponent m22154a() {
            StringBuilder stringBuilder;
            if (this.f20207a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(OnboardingViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20208b != null) {
                return new DaggerOnboardingViewComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22153a(OnboardingViewModule onboardingViewModule) {
            this.f20207a = (OnboardingViewModule) Preconditions.m26012a(onboardingViewModule);
            return this;
        }

        public final Builder m22152a(UserComponent userComponent) {
            this.f20208b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_backgroundThread implements Provider<BackgroundThread> {
        private final UserComponent f27815a;

        com_reddit_frontpage_di_component_UserComponent_backgroundThread(UserComponent userComponent) {
            this.f27815a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (BackgroundThread) Preconditions.m26013a(this.f27815a.mo4632t(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2277xa5e66dc7 implements Provider<CategoryRepository> {
        private final UserComponent f27816a;

        C2277xa5e66dc7(UserComponent userComponent) {
            this.f27816a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (CategoryRepository) Preconditions.m26013a(this.f27816a.mo4623k(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2278xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27817a;

        C2278xdbdd5b83(UserComponent userComponent) {
            this.f27817a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27817a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2279xfa494edd implements Provider<SubscriptionCountRepository> {
        private final UserComponent f27818a;

        C2279xfa494edd(UserComponent userComponent) {
            this.f27818a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SubscriptionCountRepository) Preconditions.m26013a(this.f27818a.mo4636x(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerOnboardingViewComponent(Builder builder) {
        this.f27819a = DoubleCheck.m31842a(OnboardingViewModule_ViewFactory.m34521a(builder.f20207a));
        this.f27820b = new C2277xa5e66dc7(builder.f20208b);
        this.f27821c = new C2279xfa494edd(builder.f20208b);
        this.f27822d = new com_reddit_frontpage_di_component_UserComponent_backgroundThread(builder.f20208b);
        this.f27823e = new C2278xdbdd5b83(builder.f20208b);
        this.f27824f = DoubleCheck.m31842a(OnboardingPresenter_Factory.m34824a(this.f27819a, this.f27820b, this.f27821c, this.f27822d, this.f27823e));
    }

    public static Builder m29222a() {
        return new Builder();
    }

    public final void mo4710a(OnboardingScreen onboardingScreen) {
        OnboardingScreen_MembersInjector.m29829a(onboardingScreen, (OnboardingPresenter) this.f27824f.get());
    }
}
