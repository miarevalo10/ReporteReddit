package com.reddit.frontpage.ui.preferences;

import android.content.Intent;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.AcknowledgementsActivity;

final /* synthetic */ class PreferencesFragment$$Lambda$15 implements OnPreferenceClickListener {
    private final PreferencesFragment f29184a;

    PreferencesFragment$$Lambda$15(PreferencesFragment preferencesFragment) {
        this.f29184a = preferencesFragment;
    }

    public final boolean m30296a() {
        PreferencesFragment preferencesFragment = this.f29184a;
        preferencesFragment.startActivity(new Intent(preferencesFragment.getActivity(), AcknowledgementsActivity.class));
        return true;
    }
}
