package com.reddit.frontpage.ui.preferences;

import android.content.Intent;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.debug.DataLoggingActivity;

final /* synthetic */ class PreferencesFragment$$Lambda$28 implements OnPreferenceClickListener {
    private final PreferencesFragment f29202a;

    PreferencesFragment$$Lambda$28(PreferencesFragment preferencesFragment) {
        this.f29202a = preferencesFragment;
    }

    public final boolean m30310a() {
        PreferencesFragment preferencesFragment = this.f29202a;
        preferencesFragment.startActivity(new Intent(preferencesFragment.getContext(), DataLoggingActivity.class));
        return true;
    }
}
