package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.ModQueueRightCommentViewModule;
import com.reddit.frontpage.di.module.ModQueueRightCommentViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModQueueRightCommentContract.View;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModViewRightComment;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModViewRightCommentPresenter;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModViewRightComment_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerModQueueRightCommentComponent implements ModQueueRightCommentComponent {
    private UserComponent f27748a;
    private Provider<View> f27749b;

    public static final class Builder {
        private ModQueueRightCommentViewModule f20196a;
        private UserComponent f20197b;

        private Builder() {
        }

        public final ModQueueRightCommentComponent m22133a() {
            StringBuilder stringBuilder;
            if (this.f20196a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ModQueueRightCommentViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20197b != null) {
                return new DaggerModQueueRightCommentComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22132a(ModQueueRightCommentViewModule modQueueRightCommentViewModule) {
            this.f20196a = (ModQueueRightCommentViewModule) Preconditions.m26012a(modQueueRightCommentViewModule);
            return this;
        }

        public final Builder m22131a(UserComponent userComponent) {
            this.f20197b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerModQueueRightCommentComponent(Builder builder) {
        this.f27748a = builder.f20197b;
        this.f27749b = DoubleCheck.m31842a(ModQueueRightCommentViewModule_ViewFactory.m34500a(builder.f20196a));
    }

    public static Builder m29181a() {
        return new Builder();
    }

    public final void mo4686a(ModViewRightComment modViewRightComment) {
        ModViewRightComment_MembersInjector.m30523a(modViewRightComment, new ModViewRightCommentPresenter((LinkRepository) Preconditions.m26013a(this.f27748a.mo4628p(), "Cannot return null from a non-@Nullable component method"), (View) this.f27749b.get(), (PostExecutionThread) Preconditions.m26013a(this.f27748a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
