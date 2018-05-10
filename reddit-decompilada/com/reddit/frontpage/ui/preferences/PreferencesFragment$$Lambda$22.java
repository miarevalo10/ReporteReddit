package com.reddit.frontpage.ui.preferences;

import android.content.Intent;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.debug.DebugActivity;

final /* synthetic */ class PreferencesFragment$$Lambda$22 implements OnPreferenceClickListener {
    private final PreferencesFragment f29196a;

    PreferencesFragment$$Lambda$22(PreferencesFragment preferencesFragment) {
        this.f29196a = preferencesFragment;
    }

    public final boolean m30304a() {
        PreferencesFragment preferencesFragment = this.f29196a;
        preferencesFragment.startActivityForResult(new Intent(preferencesFragment.getContext(), DebugActivity.class), 1);
        return true;
    }
}
