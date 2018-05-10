package com.reddit.datalibrary.frontpage.data.feature.link.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LocalLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import javax.inject.Singleton;

public class LegacyLinkRepositoryModule {
    @Singleton
    static LegacyLinkRepository m8976a(RemoteLinkDataSourceLegacy remoteLinkDataSourceLegacy, LocalLinkDataSourceLegacy localLinkDataSourceLegacy) {
        return new LegacyLinkRepository(remoteLinkDataSourceLegacy, localLinkDataSourceLegacy);
    }
}
