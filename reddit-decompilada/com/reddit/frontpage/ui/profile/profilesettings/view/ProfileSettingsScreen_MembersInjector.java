package com.reddit.frontpage.ui.profile.profilesettings.view;

import com.reddit.frontpage.ui.profile.profilesettings.presentation.ProfileSettingsPresenter;
import dagger.MembersInjector;

public final class ProfileSettingsScreen_MembersInjector implements MembersInjector<ProfileSettingsScreen> {
    public static void m30357a(ProfileSettingsScreen profileSettingsScreen, ProfileSettingsPresenter profileSettingsPresenter) {
        profileSettingsScreen.f39285w = profileSettingsPresenter;
    }
}
