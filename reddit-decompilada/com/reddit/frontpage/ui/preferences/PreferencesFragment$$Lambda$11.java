package com.reddit.frontpage.ui.preferences;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.preference.Preference.OnPreferenceClickListener;

final /* synthetic */ class PreferencesFragment$$Lambda$11 implements OnPreferenceClickListener {
    private final PreferencesFragment f29180a;

    PreferencesFragment$$Lambda$11(PreferencesFragment preferencesFragment) {
        this.f29180a = preferencesFragment;
    }

    public final boolean m30292a() {
        PreferencesFragment preferencesFragment = this.f29180a;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse(String.format("package:%s", new Object[]{"com.reddit.frontpage"})));
        preferencesFragment.startActivityForResult(intent, 0);
        return true;
    }
}
