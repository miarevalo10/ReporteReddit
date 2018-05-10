package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.usecase.UploadingImageUseCase;
import com.reddit.frontpage.ui.profile.profilesettings.ProfileSettingsContract.Parameters;
import com.reddit.frontpage.ui.profile.profilesettings.ProfileSettingsContract.View;
import com.reddit.frontpage.ui.profile.profilesettings.analytics.ProfileSettingsAnalyticsContract;
import com.reddit.frontpage.ui.profile.profilesettings.presentation.ProfileSettingsPresenter;
import com.reddit.frontpage.ui.profile.profilesettings.view.ProfileSettingsScreen;
import com.reddit.frontpage.ui.profile.profilesettings.view.ProfileSettingsScreen_MembersInjector;
import dagger.internal.Preconditions;

public final class DaggerProfileSettingsComponent implements ProfileSettingsComponent {
    private View f27890a;
    private UserComponent f27891b;
    private Parameters f27892c;

    private static final class Builder implements com.reddit.frontpage.di.component.ProfileSettingsComponent.Builder {
        private UserComponent f27887a;
        private View f27888b;
        private Parameters f27889c;

        private Builder() {
        }

        public final ProfileSettingsComponent mo4729a() {
            StringBuilder stringBuilder;
            if (this.f27887a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27888b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27889c != null) {
                return new DaggerProfileSettingsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private DaggerProfileSettingsComponent(Builder builder) {
        this.f27890a = builder.f27888b;
        this.f27891b = builder.f27887a;
        this.f27892c = builder.f27889c;
    }

    public static com.reddit.frontpage.di.component.ProfileSettingsComponent.Builder m29260a() {
        return new Builder();
    }

    public final void mo4730a(ProfileSettingsScreen profileSettingsScreen) {
        ProfileSettingsScreen_MembersInjector.m30357a(profileSettingsScreen, new ProfileSettingsPresenter(this.f27890a, (AccountRepository) Preconditions.m26013a(this.f27891b.mo4614b(), "Cannot return null from a non-@Nullable component method"), this.f27892c, (PostExecutionThread) Preconditions.m26013a(this.f27891b.mo4633u(), "Cannot return null from a non-@Nullable component method"), (ProfileSettingsAnalyticsContract) Preconditions.m26013a(this.f27891b.mo4617e(), "Cannot return null from a non-@Nullable component method"), new UploadingImageUseCase((AccountRepository) Preconditions.m26013a(this.f27891b.mo4614b(), "Cannot return null from a non-@Nullable component method"), (RemoteRedditApiDataSource) Preconditions.m26013a(this.f27891b.mo4618f(), "Cannot return null from a non-@Nullable component method"))));
    }
}
