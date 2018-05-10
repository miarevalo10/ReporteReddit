package com.reddit.frontpage.presentation.usermodal;

import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import dagger.MembersInjector;

public final class UserModalScreen_MembersInjector implements MembersInjector<UserModalScreen> {
    public static void m29903a(UserModalScreen userModalScreen, UserModalPresenter userModalPresenter) {
        userModalScreen.f28817b = userModalPresenter;
    }

    public static void m29902a(UserModalScreen userModalScreen, AccountFormatter accountFormatter) {
        userModalScreen.f28818c = accountFormatter;
    }
}
