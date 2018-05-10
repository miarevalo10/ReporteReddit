package com.reddit.frontpage.presentation.navdrawer;

import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar;
import com.reddit.frontpage.presentation.common.BasePresenter;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract;", "", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditNavHeaderContract.kt */
public interface RedditNavHeaderContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$View;", "", "setAccount", "", "account", "Lcom/reddit/frontpage/presentation/profile/user/model/UserAccountPresentationModel;", "setAvatar", "avatar", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "setUsername", "username", "", "showSignUpMessage", "showUserProfile", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditNavHeaderContract.kt */
    public interface View {
        void U_();

        void mo4916b();

        void setAccount(UserAccountPresentationModel userAccountPresentationModel);

        void setAvatar(Avatar avatar);

        void setUsername(String str);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$Presenter;", "Lcom/reddit/frontpage/presentation/common/BasePresenter;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    public interface Presenter extends BasePresenter {
    }
}
