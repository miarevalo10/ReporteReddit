package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LinkModule_ModeratorActionsFactory implements Factory<ModeratorLinkActions> {
    private final LinkModule f33597a;
    private final Provider<LinkRepository> f33598b;
    private final Provider<PostExecutionThread> f33599c;

    private LinkModule_ModeratorActionsFactory(LinkModule linkModule, Provider<LinkRepository> provider, Provider<PostExecutionThread> provider2) {
        this.f33597a = linkModule;
        this.f33598b = provider;
        this.f33599c = provider2;
    }

    public static LinkModule_ModeratorActionsFactory m34497a(LinkModule linkModule, Provider<LinkRepository> provider, Provider<PostExecutionThread> provider2) {
        return new LinkModule_ModeratorActionsFactory(linkModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (ModeratorLinkActions) Preconditions.m26013a(LinkModule.m22346a((LinkRepository) this.f33598b.get(), (PostExecutionThread) this.f33599c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
