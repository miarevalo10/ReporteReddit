package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.frontpage.di.module.AccountPickerViewModule;
import com.reddit.frontpage.di.module.AccountPickerViewModule_ProvideAccountSourceFactory;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.presentation.accounts.AccountHelper;
import com.reddit.frontpage.presentation.accounts.AccountPickerContract.View;
import com.reddit.frontpage.presentation.accounts.AccountPickerFragment;
import com.reddit.frontpage.presentation.accounts.AccountPickerFragment_MembersInjector;
import com.reddit.frontpage.presentation.accounts.AccountPickerPresenter;
import com.reddit.frontpage.presentation.accounts.AccountPickerPresenter_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAccountPickerComponent implements AccountPickerComponent {
    private com_reddit_frontpage_di_component_UserComponent_backgroundThread f27491a;
    private Provider<Context> f27492b;
    private Provider<AccountHelper> f27493c;
    private C2254x5ad35b3b f27494d;
    private Provider<View> f27495e;
    private Provider<AccountPickerPresenter> f27496f;

    private static final class Builder implements com.reddit.frontpage.di.component.AccountPickerComponent.Builder {
        private AccountPickerViewModule f27485a;
        private UserComponent f27486b;
        private View f27487c;
        private Context f27488d;

        private Builder() {
        }

        public final AccountPickerComponent mo4577a() {
            if (this.f27485a == null) {
                this.f27485a = new AccountPickerViewModule();
            }
            StringBuilder stringBuilder;
            if (this.f27486b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27487c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27488d != null) {
                return new DaggerAccountPickerComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Context.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class C2254x5ad35b3b implements Provider<AccountInfoUseCase> {
        private final UserComponent f27489a;

        C2254x5ad35b3b(UserComponent userComponent) {
            this.f27489a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (AccountInfoUseCase) Preconditions.m26013a(this.f27489a.mo4615c(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_backgroundThread implements Provider<BackgroundThread> {
        private final UserComponent f27490a;

        com_reddit_frontpage_di_component_UserComponent_backgroundThread(UserComponent userComponent) {
            this.f27490a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (BackgroundThread) Preconditions.m26013a(this.f27490a.mo4632t(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerAccountPickerComponent(Builder builder) {
        this.f27491a = new com_reddit_frontpage_di_component_UserComponent_backgroundThread(builder.f27486b);
        this.f27492b = InstanceFactory.m35583a(builder.f27488d);
        this.f27493c = DoubleCheck.m31842a(AccountPickerViewModule_ProvideAccountSourceFactory.m34446a(builder.f27485a, this.f27492b));
        this.f27494d = new C2254x5ad35b3b(builder.f27486b);
        this.f27495e = InstanceFactory.m35583a(builder.f27487c);
        this.f27496f = DoubleCheck.m31842a(AccountPickerPresenter_Factory.m34573a(this.f27491a, this.f27493c, this.f27494d, this.f27495e));
    }

    public static com.reddit.frontpage.di.component.AccountPickerComponent.Builder m28990a() {
        return new Builder();
    }

    public final void mo4579a(AccountPickerFragment accountPickerFragment) {
        AccountPickerFragment_MembersInjector.m29366a(accountPickerFragment, (AccountPickerPresenter) this.f27496f.get());
    }
}
