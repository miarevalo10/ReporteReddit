package com.reddit.datalibrary.frontpage.data.feature.ads.di;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository;
import javax.inject.Singleton;

public class AdRepositoryModule {
    @Singleton
    static AdsRepository m8785a() {
        return new AdsRepository();
    }
}
