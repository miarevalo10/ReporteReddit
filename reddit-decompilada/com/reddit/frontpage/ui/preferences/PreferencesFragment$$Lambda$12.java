package com.reddit.frontpage.ui.preferences;

import android.net.Uri;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class PreferencesFragment$$Lambda$12 implements OnPreferenceClickListener {
    private final PreferencesFragment f29181a;

    PreferencesFragment$$Lambda$12(PreferencesFragment preferencesFragment) {
        this.f29181a = preferencesFragment;
    }

    public final boolean m30293a() {
        PreferencesFragment preferencesFragment = this.f29181a;
        Util.m23966a(preferencesFragment.getActivity(), Uri.parse(preferencesFragment.getResources().getString(C1761R.string.content_policy_uri)));
        return true;
    }
}
