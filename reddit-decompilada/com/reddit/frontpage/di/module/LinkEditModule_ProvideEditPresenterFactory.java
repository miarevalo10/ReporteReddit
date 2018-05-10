package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.detail.EditContract.LinkParameters;
import com.reddit.frontpage.presentation.detail.EditContract.Presenter;
import com.reddit.frontpage.presentation.detail.EditContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LinkEditModule_ProvideEditPresenterFactory implements Factory<Presenter> {
    private final LinkEditModule f33591a;
    private final Provider<View> f33592b;
    private final Provider<LinkRepository> f33593c;
    private final Provider<PostExecutionThread> f33594d;
    private final Provider<LinkParameters> f33595e;

    private LinkEditModule_ProvideEditPresenterFactory(LinkEditModule linkEditModule, Provider<View> provider, Provider<LinkRepository> provider2, Provider<PostExecutionThread> provider3, Provider<LinkParameters> provider4) {
        this.f33591a = linkEditModule;
        this.f33592b = provider;
        this.f33593c = provider2;
        this.f33594d = provider3;
        this.f33595e = provider4;
    }

    public static LinkEditModule_ProvideEditPresenterFactory m34495a(LinkEditModule linkEditModule, Provider<View> provider, Provider<LinkRepository> provider2, Provider<PostExecutionThread> provider3, Provider<LinkParameters> provider4) {
        return new LinkEditModule_ProvideEditPresenterFactory(linkEditModule, provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return (Presenter) Preconditions.m26013a(LinkEditModule.m22345a((View) this.f33592b.get(), (LinkRepository) this.f33593c.get(), (PostExecutionThread) this.f33594d.get(), (LinkParameters) this.f33595e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
