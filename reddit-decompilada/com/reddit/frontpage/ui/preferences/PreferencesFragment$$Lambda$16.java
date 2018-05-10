package com.reddit.frontpage.ui.preferences;

import android.net.Uri;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class PreferencesFragment$$Lambda$16 implements OnPreferenceClickListener {
    private final PreferencesFragment f29185a;

    PreferencesFragment$$Lambda$16(PreferencesFragment preferencesFragment) {
        this.f29185a = preferencesFragment;
    }

    public final boolean m30297a() {
        PreferencesFragment preferencesFragment = this.f29185a;
        Util.m23966a(preferencesFragment.getActivity(), Uri.parse(preferencesFragment.getResources().getString(C1761R.string.help_faq_uri)));
        return true;
    }
}
