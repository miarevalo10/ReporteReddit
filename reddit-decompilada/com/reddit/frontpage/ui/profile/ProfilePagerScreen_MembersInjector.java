package com.reddit.frontpage.ui.profile;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import com.reddit.frontpage.domain.usecase.AccountUseCase;
import dagger.MembersInjector;

public final class ProfilePagerScreen_MembersInjector implements MembersInjector<ProfilePagerScreen> {
    public static void m30332a(ProfilePagerScreen profilePagerScreen, TrophiesRepository trophiesRepository) {
        profilePagerScreen.f39256v = trophiesRepository;
    }

    public static void m30331a(ProfilePagerScreen profilePagerScreen, AccountRepository accountRepository) {
        profilePagerScreen.f39257w = accountRepository;
    }

    public static void m30333a(ProfilePagerScreen profilePagerScreen, AccountUseCase accountUseCase) {
        profilePagerScreen.f39258x = accountUseCase;
    }

    public static void m30330a(ProfilePagerScreen profilePagerScreen, PostExecutionThread postExecutionThread) {
        profilePagerScreen.f39259y = postExecutionThread;
    }
}
