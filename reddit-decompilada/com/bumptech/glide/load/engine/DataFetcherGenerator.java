package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

public interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void mo908a(Key key, Exception exception, DataFetcher<?> dataFetcher, DataSource dataSource);

        void mo909a(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);

        void mo910c();
    }

    boolean mo904a();

    void mo905b();
}
