package com.reddit.datalibrary.frontpage.data.feature.link.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.DatabaseLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LocalLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.ApiLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteLinkDataSourceLegacy;
import javax.inject.Singleton;

public class LegacyLinkDataSourceModule {
    @Singleton
    static RemoteLinkDataSourceLegacy m8974a() {
        return new ApiLinkDataSourceLegacy();
    }

    @Singleton
    static LocalLinkDataSourceLegacy m8975b() {
        return new DatabaseLinkDataSourceLegacy();
    }
}
