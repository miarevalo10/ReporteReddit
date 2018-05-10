package com.reddit.frontpage.ui.preferences;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.IntentUtil;

final /* synthetic */ class PreferencesFragment$$Lambda$18 implements OnPreferenceClickListener {
    private final PreferencesFragment f29187a;
    private final Context f29188b;

    PreferencesFragment$$Lambda$18(PreferencesFragment preferencesFragment, Context context) {
        this.f29187a = preferencesFragment;
        this.f29188b = context;
    }

    public final boolean m30299a() {
        PreferencesFragment preferencesFragment = this.f29187a;
        Context context = this.f29188b;
        preferencesFragment.startActivity(IntentUtil.m23747a(context, preferencesFragment.getResources().getString(C1761R.string.url_join_alpha), ContextCompat.c(context, C1761R.color.rdt_alien_blue)));
        return true;
    }
}
