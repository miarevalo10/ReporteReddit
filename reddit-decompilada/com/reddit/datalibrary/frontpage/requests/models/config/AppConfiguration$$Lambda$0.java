package com.reddit.datalibrary.frontpage.requests.models.config;

import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Bucket;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class AppConfiguration$$Lambda$0 implements Consumer {
    private final AppConfiguration arg$1;

    public AppConfiguration$$Lambda$0(AppConfiguration appConfiguration) {
        this.arg$1 = appConfiguration;
    }

    public final void accept(Object obj) {
        Bucket bucket = (Bucket) obj;
        this.arg$1.bucketMap.put(bucket.experiment_name, bucket);
    }
}
