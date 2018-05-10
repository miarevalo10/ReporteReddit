package com.reddit.frontpage.presentation.listing.linkpager;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadData;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.Parameters;
import com.reddit.frontpage.presentation.listing.linkpager.LinkPagerContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LinkPagerPresenter_Factory implements Factory<LinkPagerPresenter> {
    private final Provider<View> f33941a;
    private final Provider<LinkPagerLoadData> f33942b;
    private final Provider<Parameters> f33943c;
    private final Provider<PostExecutionThread> f33944d;
    private final Provider<LinkRepository> f33945e;

    private LinkPagerPresenter_Factory(Provider<View> provider, Provider<LinkPagerLoadData> provider2, Provider<Parameters> provider3, Provider<PostExecutionThread> provider4, Provider<LinkRepository> provider5) {
        this.f33941a = provider;
        this.f33942b = provider2;
        this.f33943c = provider3;
        this.f33944d = provider4;
        this.f33945e = provider5;
    }

    public static LinkPagerPresenter_Factory m34741a(Provider<View> provider, Provider<LinkPagerLoadData> provider2, Provider<Parameters> provider3, Provider<PostExecutionThread> provider4, Provider<LinkRepository> provider5) {
        return new LinkPagerPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new LinkPagerPresenter((View) this.f33941a.get(), (LinkPagerLoadData) this.f33942b.get(), (Parameters) this.f33943c.get(), (PostExecutionThread) this.f33944d.get(), (LinkRepository) this.f33945e.get());
    }
}
