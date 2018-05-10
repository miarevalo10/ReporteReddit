package com.reddit.frontpage.redditauth_private.ui;

import com.reddit.datalibrary.frontpage.data.model.Account;
import io.reactivex.functions.Function;

final /* synthetic */ class LoginFragment$LoginTask$$Lambda$0 implements Function {
    static final Function f28844a = new LoginFragment$LoginTask$$Lambda$0();

    private LoginFragment$LoginTask$$Lambda$0() {
    }

    public final Object apply(Object obj) {
        return ((Account) obj).getUsername();
    }
}
