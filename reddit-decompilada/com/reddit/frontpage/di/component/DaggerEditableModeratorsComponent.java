package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.EditableModeratorsViewModule;
import com.reddit.frontpage.di.module.EditableModeratorsViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.modlist.editable.EditableModeratorsPresenter;
import com.reddit.frontpage.presentation.modtools.modlist.editable.EditableModeratorsScreen;
import com.reddit.frontpage.presentation.modtools.modlist.editable.EditableModeratorsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerEditableModeratorsComponent implements EditableModeratorsComponent {
    private UserComponent f27621a;
    private Provider<View> f27622b;

    public static final class Builder {
        private EditableModeratorsViewModule f20182a;
        private UserComponent f20183b;

        private Builder() {
        }

        public final EditableModeratorsComponent m22099a() {
            StringBuilder stringBuilder;
            if (this.f20182a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(EditableModeratorsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20183b != null) {
                return new DaggerEditableModeratorsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22098a(EditableModeratorsViewModule editableModeratorsViewModule) {
            this.f20182a = (EditableModeratorsViewModule) Preconditions.m26012a(editableModeratorsViewModule);
            return this;
        }

        public final Builder m22097a(UserComponent userComponent) {
            this.f20183b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerEditableModeratorsComponent(Builder builder) {
        this.f27622b = DoubleCheck.m31842a(EditableModeratorsViewModule_ViewFactory.m34476a(builder.f20182a));
        this.f27621a = builder.f20183b;
    }

    public static Builder m29112a() {
        return new Builder();
    }

    public final void mo4652a(EditableModeratorsScreen editableModeratorsScreen) {
        EditableModeratorsScreen_MembersInjector.m29786a(editableModeratorsScreen, new EditableModeratorsPresenter((View) this.f27622b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27621a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27621a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
