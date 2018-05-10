package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.Parameters;
import com.reddit.frontpage.presentation.postoption.PostOptionsContract.View;
import com.reddit.frontpage.presentation.postoption.PostOptionsNavigator;
import com.reddit.frontpage.presentation.postoption.PostOptionsPresenter;
import com.reddit.frontpage.presentation.postoption.PostOptionsScreen;
import com.reddit.frontpage.presentation.postoption.PostOptionsScreen_MembersInjector;
import com.reddit.frontpage.presentation.postoption.RedditPostOptionsNavigator_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerPostOptionsComponent implements PostOptionsComponent {
    private View f27871a;
    private Parameters f27872b;
    private Provider<Lazy<? extends Context>> f27873c;
    private RedditPostOptionsNavigator_Factory f27874d;
    private Provider<PostOptionsNavigator> f27875e;

    private static final class Builder implements com.reddit.frontpage.di.component.PostOptionsComponent.Builder {
        private UserComponent f27867a;
        private View f27868b;
        private Parameters f27869c;
        private Lazy<? extends Context> f27870d;

        private Builder() {
        }

        public final PostOptionsComponent mo4723a() {
            StringBuilder stringBuilder;
            if (this.f27867a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27868b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27869c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27870d != null) {
                return new DaggerPostOptionsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private DaggerPostOptionsComponent(Builder builder) {
        this.f27871a = builder.f27868b;
        this.f27872b = builder.f27869c;
        this.f27873c = InstanceFactory.m35583a(builder.f27870d);
        this.f27874d = RedditPostOptionsNavigator_Factory.m34866a(this.f27873c);
        this.f27875e = DoubleCheck.m31842a(this.f27874d);
    }

    public static com.reddit.frontpage.di.component.PostOptionsComponent.Builder m29249a() {
        return new Builder();
    }

    public final void mo4724a(PostOptionsScreen postOptionsScreen) {
        PostOptionsScreen_MembersInjector.m29845a(postOptionsScreen, new PostOptionsPresenter(this.f27871a, this.f27872b, (PostOptionsNavigator) this.f27875e.get()));
    }
}
