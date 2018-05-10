package com.reddit.datalibrary.frontpage.data.feature.link.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LocalLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider_MembersInjector;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.DetailHolderScreen_MembersInjector;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.detail.BaseDetailScreen_MembersInjector;
import com.reddit.frontpage.ui.listing.LegacyLinkPagerScreen;
import com.reddit.frontpage.ui.listing.LegacyLinkPagerScreen_MembersInjector;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter_MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

public final class DaggerLinkRepositoryComponent implements LinkRepositoryComponent {
    private Provider<RemoteLinkDataSourceLegacy> f16052a;
    private Provider<LocalLinkDataSourceLegacy> f16053b;
    private Provider<LegacyLinkRepository> f16054c;

    public static final class Builder {
        public LegacyLinkDataSourceModule f10665a;
        public LegacyLinkRepositoryModule f10666b;

        private Builder() {
        }
    }

    private DaggerLinkRepositoryComponent(Builder builder) {
        this.f16052a = DoubleCheck.a(LegacyLinkDataSourceModule_ProvideRemoteLinkDataSourceFactory.m19675a(builder.f10665a));
        this.f16053b = DoubleCheck.a(LegacyLinkDataSourceModule_ProvideLocalLinkDataSourceFactory.m19674a(builder.f10665a));
        this.f16054c = DoubleCheck.a(LegacyLinkRepositoryModule_ProvideLinkRepositoryFactory.m19676a(builder.f10666b, this.f16052a, this.f16053b));
    }

    public static Builder m16016a() {
        return new Builder();
    }

    public final void mo2972a(DetailHolderScreen detailHolderScreen) {
        DetailHolderScreen_MembersInjector.a(detailHolderScreen, (LegacyLinkRepository) this.f16054c.get());
    }

    public final void mo2974a(LegacyLinkPagerScreen legacyLinkPagerScreen) {
        LegacyLinkPagerScreen_MembersInjector.a(legacyLinkPagerScreen, (LegacyLinkRepository) this.f16054c.get());
    }

    public final void mo2971a(LinkListingProvider linkListingProvider) {
        LinkListingProvider_MembersInjector.m16258a(linkListingProvider, (LegacyLinkRepository) this.f16054c.get());
    }

    public final void mo2975a(CardLinkAdapter cardLinkAdapter) {
        CardLinkAdapter_MembersInjector.a(cardLinkAdapter, (LegacyLinkRepository) this.f16054c.get());
    }

    public final void mo2973a(BaseDetailScreen baseDetailScreen) {
        BaseDetailScreen_MembersInjector.a(baseDetailScreen, (LegacyLinkRepository) this.f16054c.get());
    }
}
