package com.reddit.frontpage.redditauth_private.ui;

import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LoginSignUpPagerFragment_ViewBinding implements Unbinder {
    private LoginSignUpPagerFragment f28846b;

    public LoginSignUpPagerFragment_ViewBinding(LoginSignUpPagerFragment loginSignUpPagerFragment, View view) {
        this.f28846b = loginSignUpPagerFragment;
        loginSignUpPagerFragment.viewPager = (ViewPager) Utils.b(view, C1761R.id.loginsignup_pager, "field 'viewPager'", ViewPager.class);
    }

    public final void m29915a() {
        LoginSignUpPagerFragment loginSignUpPagerFragment = this.f28846b;
        if (loginSignUpPagerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28846b = null;
        loginSignUpPagerFragment.viewPager = null;
    }
}
