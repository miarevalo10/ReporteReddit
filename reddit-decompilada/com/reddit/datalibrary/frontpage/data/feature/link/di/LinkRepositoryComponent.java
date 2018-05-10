package com.reddit.datalibrary.frontpage.data.feature.link.di;

import com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.listing.LegacyLinkPagerScreen;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import javax.inject.Singleton;

@Singleton
public interface LinkRepositoryComponent {
    void mo2971a(LinkListingProvider linkListingProvider);

    void mo2972a(DetailHolderScreen detailHolderScreen);

    void mo2973a(BaseDetailScreen baseDetailScreen);

    void mo2974a(LegacyLinkPagerScreen legacyLinkPagerScreen);

    void mo2975a(CardLinkAdapter cardLinkAdapter);
}
