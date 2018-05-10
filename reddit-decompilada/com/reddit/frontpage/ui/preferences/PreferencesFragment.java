package com.reddit.frontpage.ui.preferences;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.SwitchPreferenceCompat;
import android.support.v7.preference.TwoStatePreference;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage.UserSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.RateOrShare;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.ShareOnUpvote;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.SharePiggyback;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.UpvoteShimmer;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.RedditThemedActivity;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import com.reddit.frontpage.util.DeepLinkUtil;
import com.reddit.frontpage.util.InternalAccountUtil;
import com.reddit.frontpage.util.NetworkUtil;
import com.reddit.frontpage.util.NotificationUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.VideoStateUtil;
import com.reddit.frontpage.util.ViewUtils;
import timber.log.Timber;

public class PreferencesFragment extends PreferenceFragmentCompat {
    @State
    protected int resultCode = 0;

    public final void m37734a(Bundle bundle) {
        Preference preference;
        Preference preference2;
        Preference preference3;
        StateSaver.restoreInstanceState(this, bundle);
        a(C1761R.xml.preferences);
        Preference a = a(getString(C1761R.string.key_pref_accounts));
        ListPreference listPreference = (ListPreference) a(getString(C1761R.string.key_pref_theme));
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_auto_night));
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_amoled));
        ListPreference listPreference2 = (ListPreference) a(getString(C1761R.string.key_pref_default_view));
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_disable_preview_images));
        ListPreference listPreference3 = (ListPreference) a(getString(C1761R.string.key_pref_autoplay));
        TwoStatePreference twoStatePreference = (TwoStatePreference) a(getString(C1761R.string.key_pref_over18));
        SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_blur_nsfw));
        Preference a2 = a(getString(C1761R.string.key_pref_notifications));
        Preference a3 = a(getString(C1761R.string.key_pref_content_policy));
        Preference a4 = a(getString(C1761R.string.key_pref_privacy_policy));
        Preference a5 = a(getString(C1761R.string.key_pref_user_agreement));
        Preference a6 = a(getString(C1761R.string.key_pref_acknowledgements));
        Preference a7 = a(getString(C1761R.string.key_pref_help_faq));
        Preference a8 = a(getString(C1761R.string.key_pref_mobile_subreddit));
        Preference preference4 = a6;
        Preference a9 = a(getString(C1761R.string.key_pref_submit_bug));
        a6 = a(getString(C1761R.string.key_pref_build_version));
        Preference preference5 = a5;
        FrontpageSettings a10 = FrontpageSettings.a();
        Preference preference6 = a4;
        switchPreferenceCompat3.v = Boolean.valueOf(a10.b());
        if (InternalAccountUtil.m23766a()) {
            a(C1761R.xml.preferences_employee);
            FrontpageSettings a11 = FrontpageSettings.a();
            preference = a3;
            Context context = getContext();
            preference2 = a2;
            preference3 = a8;
            a(getResources().getString(C1761R.string.key_pref_alpha)).n = new PreferencesFragment$$Lambda$18(r0, context);
            EditTextPreference editTextPreference = (EditTextPreference) a(getString(C1761R.string.key_pref_uri_base));
            editTextPreference.a(a11.i());
            editTextPreference.m = new PreferencesFragment$$Lambda$19(editTextPreference, a11);
            editTextPreference = (EditTextPreference) a(getString(C1761R.string.key_pref_uri_gateway));
            editTextPreference.a(a11.j());
            editTextPreference.m = new PreferencesFragment$$Lambda$20(editTextPreference, a11);
            SwitchPreferenceCompat switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_use_staging));
            switchPreferenceCompat5.v = Boolean.valueOf(a11.k());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$21(a11, context);
            a(getString(C1761R.string.key_pref_debug)).n = new PreferencesFragment$$Lambda$22(r0);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_mvp_frontpage));
            switchPreferenceCompat5.v = Boolean.valueOf(a11.q());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$23(a11);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_mvp_popular));
            switchPreferenceCompat5.v = Boolean.valueOf(a11.q());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$24(a11);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_mvp_usp));
            switchPreferenceCompat5.v = Boolean.valueOf(a11.q());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$25(a11);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_carousel_debug));
            switchPreferenceCompat5.v = Boolean.valueOf(a11.r());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$26(a11);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_onboarding_enabled));
            switchPreferenceCompat5.v = Boolean.valueOf(a11.s());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$27(a11);
            a(getString(C1761R.string.key_pref_data_logging)).n = new PreferencesFragment$$Lambda$28(r0);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_enjoy_reddit_toast));
            switchPreferenceCompat5.f(a11.t().e());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$29(r0, a11);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_upvote_toast));
            switchPreferenceCompat5.f(a11.t().f());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$30(r0, a11);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_share_copy_link));
            switchPreferenceCompat5.f(a11.t().g());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$31(r0, a11);
            switchPreferenceCompat5 = (SwitchPreferenceCompat) a(getString(C1761R.string.key_pref_share_shimmer));
            switchPreferenceCompat5.f(a11.t().d());
            switchPreferenceCompat5.m = new PreferencesFragment$$Lambda$32(r0, a11);
        } else {
            preference2 = a2;
            preference = a3;
            preference3 = a8;
        }
        a6.b(getString(C1761R.string.fmt_build_version, new Object[]{"3.1.2", Integer.valueOf(209200)}));
        Session session = SessionManager.b().c;
        UserSettings a12 = UserSettingsStorage.a().a(session);
        if (AccountUtil.b(getContext()).isEmpty()) {
            a.c(C1761R.string.action_add_account);
        } else {
            a.c(C1761R.string.label_accounts);
            a.x = C1761R.layout.preference_chooser;
            if (session.isAnonymous()) {
                a.a(a.j.getString(C1761R.string.label_anonymous));
            } else {
                a.a(session.getUsername());
            }
        }
        if (!session.isAnonymous()) {
            twoStatePreference.f(a12.a.over_18);
        }
        twoStatePreference.m = new PreferencesFragment$$Lambda$0(a12);
        a.n = new PreferencesFragment$$Lambda$1(r0);
        String string = getString(C1761R.string.option_value_card);
        String string2 = getString(C1761R.string.option_value_compact);
        if (a10.c()) {
            string = string2;
        }
        listPreference2.v = string;
        listPreference2.a(string);
        listPreference2.m = new PreferencesFragment$$Lambda$2(string2, a10);
        listPreference3.m = new PreferencesFragment$$Lambda$3(a10);
        switchPreferenceCompat3.m = new PreferencesFragment$$Lambda$4(a10);
        ThemeOption c = a10.c(false);
        if (c == ThemeOption.f20984f) {
            c = ThemeOption.f20981c;
        }
        listPreference.a(c.ordinal());
        listPreference.m = new PreferencesFragment$$Lambda$5(r0, a10, switchPreferenceCompat);
        switchPreferenceCompat.f(a10.e());
        switchPreferenceCompat.m = new PreferencesFragment$$Lambda$6(r0, a10);
        if (c == ThemeOption.f20981c) {
            switchPreferenceCompat.a(false);
        }
        if (VERSION.SDK_INT >= 23) {
            switchPreferenceCompat2.f(a10.f());
            switchPreferenceCompat2.m = new PreferencesFragment$$Lambda$7(r0, a10, listPreference);
            m37720a(listPreference, switchPreferenceCompat2.a());
        } else {
            switchPreferenceCompat2.k();
        }
        switchPreferenceCompat4.f(a10.g());
        switchPreferenceCompat4.m = new PreferencesFragment$$Lambda$8(a10);
        preference3.n = new PreferencesFragment$$Lambda$9(r0);
        AppConfiguration t = a10.t();
        Object obj = (t.global == null || t.global.push_notifications == null) ? null : t.global.push_notifications.preferences_url;
        if (!session.isAnonymous()) {
            if (!TextUtils.isEmpty(obj)) {
                if (NotificationUtil.m23854a()) {
                    preference2.n = new PreferencesFragment$$Lambda$10(r0, obj);
                } else {
                    a = preference2;
                    CharSequence spannableString = new SpannableString(getString(C1761R.string.summary_notification_preferences));
                    spannableString.setSpan(new ForegroundColorSpan(Util.m23950a((int) C1761R.color.rdt_red)), 0, spannableString.length(), 0);
                    a.a(spannableString);
                    a.n = new PreferencesFragment$$Lambda$11(r0);
                }
                preference.n = new PreferencesFragment$$Lambda$12(r0);
                preference6.n = new PreferencesFragment$$Lambda$13(r0);
                preference5.n = new PreferencesFragment$$Lambda$14(r0);
                preference4.n = new PreferencesFragment$$Lambda$15(r0);
                a7.n = new PreferencesFragment$$Lambda$16(r0);
                a9.n = new PreferencesFragment$$Lambda$17(r0);
            }
        }
        preference2.k();
        preference.n = new PreferencesFragment$$Lambda$12(r0);
        preference6.n = new PreferencesFragment$$Lambda$13(r0);
        preference5.n = new PreferencesFragment$$Lambda$14(r0);
        preference4.n = new PreferencesFragment$$Lambda$15(r0);
        a7.n = new PreferencesFragment$$Lambda$16(r0);
        a9.n = new PreferencesFragment$$Lambda$17(r0);
    }

    static final /* synthetic */ boolean m37723a(UserSettings userSettings, Object obj) {
        userSettings.a.over_18 = ((Boolean) obj).booleanValue();
        userSettings.b();
        return true;
    }

    static final /* synthetic */ boolean m37733l(FrontpageSettings frontpageSettings, Object obj) {
        frontpageSettings.a((String) obj);
        switch (frontpageSettings.h()) {
            case 1:
                frontpageSettings = "autoplay_gifs_always";
                break;
            case 2:
                frontpageSettings = "autoplay_gifs_wifi";
                break;
            case 3:
                frontpageSettings = "autoplay_gifs_never";
                break;
            default:
                frontpageSettings = null;
                break;
        }
        FrontpageApplication.m28871g().mo5026b();
        VideoStateUtil.m24047a();
        if (TextUtils.isEmpty(frontpageSettings) == null) {
            obj = AppAnalytics.m21858b();
            obj.f19954a = "account_settings";
            obj.f19955b = frontpageSettings;
            obj.m21825a();
        }
        return true;
    }

    final /* synthetic */ boolean m37736a(FrontpageSettings frontpageSettings, SwitchPreferenceCompat switchPreferenceCompat, Object obj) {
        Timber.b("App Theme selected: %s", new Object[]{obj});
        String str = (String) obj;
        ThemeOption valueOf = ThemeOption.valueOf(str);
        obj = TextUtils.equals(getString(C1761R.string.option_value_night), str);
        frontpageSettings.b(obj);
        if (obj != null && switchPreferenceCompat.a()) {
            switchPreferenceCompat.f(false);
        }
        switchPreferenceCompat.a(obj ^ 1);
        frontpageSettings.a(valueOf);
        if (obj == null) {
            frontpageSettings.b(valueOf);
        }
        this.resultCode = 1;
        m37741c();
        return true;
    }

    final /* synthetic */ boolean m37735a(FrontpageSettings frontpageSettings, ListPreference listPreference, Object obj) {
        Boolean bool = (Boolean) obj;
        frontpageSettings.a.edit().putBoolean("com.reddit.pref.amoled_night", bool.booleanValue()).apply();
        this.resultCode = 1;
        m37720a(listPreference, bool.booleanValue());
        m37741c();
        return true;
    }

    final /* synthetic */ boolean m37745e() {
        if (NetworkUtil.m23842b()) {
            startActivity(DeepLinkUtil.helpSubreddit(getActivity()));
            return true;
        }
        ViewUtils.m24059a(getView(), (int) C1761R.string.error_no_internet, 0).a();
        return false;
    }

    static final /* synthetic */ boolean m37725b(EditTextPreference editTextPreference, FrontpageSettings frontpageSettings, Object obj) {
        String str = (String) obj;
        editTextPreference.a(str);
        frontpageSettings.d(str);
        return true;
    }

    static final /* synthetic */ boolean m37721a(EditTextPreference editTextPreference, FrontpageSettings frontpageSettings, Object obj) {
        String str = (String) obj;
        editTextPreference.a(str);
        frontpageSettings.e(str);
        return true;
    }

    static final /* synthetic */ boolean m37722a(FrontpageSettings frontpageSettings, Context context, Object obj) {
        Boolean bool = (Boolean) obj;
        frontpageSettings.a.edit().putBoolean("com.reddit.pref.use_staging", bool.booleanValue()).apply();
        if (bool.booleanValue() != null) {
            Toast.makeText(context, "Make sure cookie file is updated and restart app", 0).show();
        } else {
            Toast.makeText(context, "Restart app for change to take effect", 0).show();
        }
        return true;
    }

    final /* synthetic */ boolean m37744d(FrontpageSettings frontpageSettings, Object obj) {
        obj = ((Boolean) obj).booleanValue();
        AppConfiguration t = frontpageSettings.t();
        t.experiments.enjoy_reddit_toast = new RateOrShare(obj, "You should check out the Reddit app!", "https://reddit.app.link/3CsFK8W7iB", "y");
        frontpageSettings.a(t);
        frontpageSettings = new Builder(getActivity()).a(getString(C1761R.string.title_information)).b(C1761R.string.experiment_share_vs_rate).a(getString(C1761R.string.action_okay), new PreferencesFragment$$Lambda$35(this));
        obj = getString(C1761R.string.action_test);
        OnClickListener preferencesFragment$$Lambda$36 = new PreferencesFragment$$Lambda$36(this);
        frontpageSettings.a.m = obj;
        frontpageSettings.a.n = preferencesFragment$$Lambda$36;
        frontpageSettings.c();
        return true;
    }

    final /* synthetic */ boolean m37742c(FrontpageSettings frontpageSettings, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        obj = frontpageSettings.t();
        obj.experiments.upvote_toast = new ShareOnUpvote(booleanValue, "Would you like to share this post?", "https://reddit.app.link/3CsFK8W7iB", "z", "- shared from the Reddit app");
        frontpageSettings.a(obj);
        new Builder(getActivity()).a(getString(C1761R.string.title_information)).b(C1761R.string.experiment_upvote_toast).a(getString(C1761R.string.action_okay), new PreferencesFragment$$Lambda$37(this)).c();
        return true;
    }

    final /* synthetic */ boolean m37740b(FrontpageSettings frontpageSettings, Object obj) {
        obj = ((Boolean) obj).booleanValue();
        AppConfiguration t = frontpageSettings.t();
        t.experiments.share_copy_link = new SharePiggyback(obj, "- shared from the Reddit app", "https://reddit.app.link/3CsFK8W7iB", "x");
        frontpageSettings.a(t);
        new Builder(getActivity()).a(getString(C1761R.string.title_information)).b(C1761R.string.experiment_share_piggyback).a(getString(C1761R.string.action_okay), new PreferencesFragment$$Lambda$38(this)).c();
        return true;
    }

    final /* synthetic */ boolean m37737a(FrontpageSettings frontpageSettings, Object obj) {
        obj = ((Boolean) obj).booleanValue();
        AppConfiguration t = frontpageSettings.t();
        t.experiments.share_shimmer = new UpvoteShimmer(obj, "k");
        frontpageSettings.a(t);
        new Builder(getActivity()).a(getString(C1761R.string.title_information)).b(C1761R.string.experiment_share_shimmer).a(getString(C1761R.string.action_okay), new PreferencesFragment$$Lambda$34(this)).c();
        return true;
    }

    public final void m37739b(Preference preference) {
        if (preference instanceof ListPreference) {
            preference = BottomSheetListDialogFragment.m39354a(preference.q);
            preference.setTargetFragment(this, 0);
            preference.a(getFragmentManager(), null);
            return;
        }
        super.b(preference);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 2) {
            this.resultCode = 2;
            getActivity().finish();
        }
    }

    final void m37738b() {
        Snackbar a = ViewUtils.m24059a(getView(), (int) C1761R.string.experiment_warning_reset, 7500);
        a.a(C1761R.string.action_close, new PreferencesFragment$$Lambda$33(a));
        a.a();
    }

    final void m37741c() {
        ((RedditThemedActivity) getActivity()).m41959b(true);
    }

    public final int m37743d() {
        return this.resultCode;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        StateSaver.saveInstanceState(this, bundle);
    }

    private void m37720a(ListPreference listPreference, boolean z) {
        listPreference = listPreference.g;
        for (int i = 0; i < listPreference.length; i++) {
            Object obj = listPreference[i];
            if (obj.equals(getString(C1761R.string.option_theme_night)) && z) {
                listPreference[i] = getString(C1761R.string.option_theme_night_amoled);
            } else if (obj.equals(getString(C1761R.string.option_theme_night_amoled)) && !z) {
                listPreference[i] = getString(C1761R.string.option_theme_night);
            }
        }
    }
}
