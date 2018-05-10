package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.subreddit.rules.SubredditRulesContract.Parameters;
import com.reddit.frontpage.presentation.subreddit.rules.SubredditRulesContract.View;
import com.reddit.frontpage.presentation.subreddit.rules.presenter.SubredditRulesPresenter;
import com.reddit.frontpage.presentation.subreddit.rules.view.SubredditRulesScreen;
import com.reddit.frontpage.presentation.subreddit.rules.view.SubredditRulesScreen_MembersInjector;
import dagger.internal.Preconditions;

public final class DaggerSubredditRulesComponent implements SubredditRulesComponent {
    private View f27907a;
    private Parameters f27908b;
    private UserComponent f27909c;

    private static final class Builder implements com.reddit.frontpage.di.component.SubredditRulesComponent.Builder {
        private UserComponent f27904a;
        private View f27905b;
        private Parameters f27906c;

        private Builder() {
        }

        public final SubredditRulesComponent mo4739a() {
            StringBuilder stringBuilder;
            if (this.f27904a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27905b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27906c != null) {
                return new DaggerSubredditRulesComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private DaggerSubredditRulesComponent(Builder builder) {
        this.f27907a = builder.f27905b;
        this.f27908b = builder.f27906c;
        this.f27909c = builder.f27904a;
    }

    public static com.reddit.frontpage.di.component.SubredditRulesComponent.Builder m29279a() {
        return new Builder();
    }

    public final void mo4740a(SubredditRulesScreen subredditRulesScreen) {
        SubredditRulesScreen_MembersInjector.m29878a(subredditRulesScreen, new SubredditRulesPresenter(this.f27907a, this.f27908b, (SubredditRepository) Preconditions.m26013a(this.f27909c.mo4635w(), "Cannot return null from a non-@Nullable component method"), (ModToolsRepository) Preconditions.m26013a(this.f27909c.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27909c.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
