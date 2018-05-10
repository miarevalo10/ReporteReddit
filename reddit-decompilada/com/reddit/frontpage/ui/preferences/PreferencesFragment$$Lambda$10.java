package com.reddit.frontpage.ui.preferences;

import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class PreferencesFragment$$Lambda$10 implements OnPreferenceClickListener {
    private final PreferencesFragment f29178a;
    private final String f29179b;

    PreferencesFragment$$Lambda$10(PreferencesFragment preferencesFragment, String str) {
        this.f29178a = preferencesFragment;
        this.f29179b = str;
    }

    public final boolean m30291a() {
        PreferencesFragment preferencesFragment = this.f29178a;
        preferencesFragment.startActivityForResult(IntentUtil.m23749a(preferencesFragment.getActivity(), this.f29179b, preferencesFragment.getString(C1761R.string.title_notification_preferences), Util.m24005c(preferencesFragment.getActivity())), 0);
        return true;
    }
}
