package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.frontpage.di.module.ReplyModule;
import com.reddit.frontpage.di.module.ReplyModule_ProvideReplyPresenterFactory;
import com.reddit.frontpage.presentation.detail.LinkReplyFragment;
import com.reddit.frontpage.presentation.detail.ReplyContract.Parameters;
import com.reddit.frontpage.presentation.detail.ReplyContract.Presenter;
import com.reddit.frontpage.presentation.detail.ReplyContract.View;
import com.reddit.frontpage.presentation.detail.ReplyFragment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerReplyComponent implements ReplyComponent {
    private Provider<View> f27899a;
    private C2283x2300044a f27900b;
    private C2284xdbdd5b83 f27901c;
    private Provider<Parameters> f27902d;
    private Provider<Presenter> f27903e;

    private static final class Builder implements com.reddit.frontpage.di.component.ReplyComponent.Builder {
        private ReplyModule f27893a;
        private UserComponent f27894b;
        private Parameters f27895c;
        private View f27896d;

        private Builder() {
        }

        public final ReplyComponent mo4734a() {
            if (this.f27893a == null) {
                this.f27893a = new ReplyModule();
            }
            StringBuilder stringBuilder;
            if (this.f27894b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27895c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27896d != null) {
                return new DaggerReplyComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class C2283x2300044a implements Provider<CommentRepository> {
        private final UserComponent f27897a;

        C2283x2300044a(UserComponent userComponent) {
            this.f27897a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (CommentRepository) Preconditions.m26013a(this.f27897a.mo4624l(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2284xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27898a;

        C2284xdbdd5b83(UserComponent userComponent) {
            this.f27898a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27898a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerReplyComponent(Builder builder) {
        this.f27899a = InstanceFactory.m35583a(builder.f27896d);
        this.f27900b = new C2283x2300044a(builder.f27894b);
        this.f27901c = new C2284xdbdd5b83(builder.f27894b);
        this.f27902d = InstanceFactory.m35583a(builder.f27895c);
        this.f27903e = DoubleCheck.m31842a(ReplyModule_ProvideReplyPresenterFactory.m34526a(builder.f27893a, this.f27899a, this.f27900b, this.f27901c, this.f27902d));
    }

    public static com.reddit.frontpage.di.component.ReplyComponent.Builder m29270a() {
        return new Builder();
    }

    public final void mo4735a(LinkReplyFragment linkReplyFragment) {
        ReplyFragment_MembersInjector.m29499a(linkReplyFragment, (Presenter) this.f27903e.get());
    }
}
