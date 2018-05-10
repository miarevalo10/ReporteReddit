package com.reddit.frontpage.ui.preferences;

import android.net.Uri;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class PreferencesFragment$$Lambda$17 implements OnPreferenceClickListener {
    private final PreferencesFragment f29186a;

    PreferencesFragment$$Lambda$17(PreferencesFragment preferencesFragment) {
        this.f29186a = preferencesFragment;
    }

    public final boolean m30298a() {
        PreferencesFragment preferencesFragment = this.f29186a;
        Util.m23966a(preferencesFragment.getActivity(), Uri.parse(preferencesFragment.getResources().getString(C1761R.string.feedback_uri)));
        return true;
    }
}
