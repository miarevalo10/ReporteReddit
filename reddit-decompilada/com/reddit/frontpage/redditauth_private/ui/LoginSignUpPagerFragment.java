package com.reddit.frontpage.redditauth_private.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.ui.BaseFragment;

public class LoginSignUpPagerFragment extends BaseFragment {
    private View f37141a;
    private Unbinder f37142b;
    @BindView
    ViewPager viewPager;

    private static class LoginSignupPagerAdapter extends FragmentPagerAdapter {
        public final int m34881c() {
            return 2;
        }

        LoginSignupPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public final Fragment m34880a(int i) {
            if (i == 0) {
                return LoginFragment.m37493a();
            }
            return RegisterFragment.m37502a();
        }
    }

    public static LoginSignUpPagerFragment m37500a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("signup", z);
        z = new LoginSignUpPagerFragment();
        z.setArguments(bundle);
        return z;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f37141a = layoutInflater.inflate(C1761R.layout.rdt_fragment_loginsignuppager, viewGroup, false);
        this.f37142b = ButterKnife.a(this, this.f37141a);
        this.viewPager.setAdapter(new LoginSignupPagerAdapter(getChildFragmentManager()));
        if (getArguments().getBoolean("signup", false) != null) {
            this.viewPager.setCurrentItem(1);
        }
        return this.f37141a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f37142b.a();
    }
}
