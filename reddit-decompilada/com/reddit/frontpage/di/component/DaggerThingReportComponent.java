package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.ThingReportModule;
import com.reddit.frontpage.di.module.ThingReportModule_ViewFactory;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog_MembersInjector;
import com.reddit.frontpage.presentation.dialogs.customreports.CustomReportReasonsDialog;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportPresenter;
import com.reddit.frontpage.presentation.dialogs.messagereport.MessageReportDialog;
import com.reddit.frontpage.ui.inbox.InboxListingScreen;
import com.reddit.frontpage.ui.inbox.InboxListingScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerThingReportComponent implements ThingReportComponent {
    private UserComponent f27910a;
    private Provider<View> f27911b;

    public static final class Builder {
        private ThingReportModule f20213a;
        private UserComponent f20214b;

        private Builder() {
        }

        public final ThingReportComponent m22163a() {
            StringBuilder stringBuilder;
            if (this.f20213a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ThingReportModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20214b != null) {
                return new DaggerThingReportComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22162a(ThingReportModule thingReportModule) {
            this.f20213a = (ThingReportModule) Preconditions.m26012a(thingReportModule);
            return this;
        }

        public final Builder m22161a(UserComponent userComponent) {
            this.f20214b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerThingReportComponent(Builder builder) {
        this.f27911b = DoubleCheck.m31842a(ThingReportModule_ViewFactory.m34533a(builder.f20213a));
        this.f27910a = builder.f20214b;
    }

    public static Builder m29281a() {
        return new Builder();
    }

    private ThingReportPresenter m29282b() {
        return new ThingReportPresenter((View) this.f27911b.get(), (PostExecutionThread) Preconditions.m26013a(this.f27910a.mo4633u(), "Cannot return null from a non-@Nullable component method"), (ModToolsRepository) Preconditions.m26013a(this.f27910a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (AccountRepository) Preconditions.m26013a(this.f27910a.mo4614b(), "Cannot return null from a non-@Nullable component method"));
    }

    public final void mo4741a(CustomReportReasonsDialog customReportReasonsDialog) {
        BaseThingReportDialog_MembersInjector.m29515a(customReportReasonsDialog, m29282b());
    }

    public final void mo4742a(MessageReportDialog messageReportDialog) {
        BaseThingReportDialog_MembersInjector.m29515a(messageReportDialog, m29282b());
    }

    public final void mo4743a(InboxListingScreen inboxListingScreen) {
        InboxListingScreen_MembersInjector.m30061a(inboxListingScreen, m29282b());
    }
}
