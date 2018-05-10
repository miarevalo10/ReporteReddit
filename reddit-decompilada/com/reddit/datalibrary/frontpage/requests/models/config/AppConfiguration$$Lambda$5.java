package com.reddit.datalibrary.frontpage.requests.models.config;

import com.google.common.base.Function;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Experiments;

final /* synthetic */ class AppConfiguration$$Lambda$5 implements Function {
    static final Function $instance = new AppConfiguration$$Lambda$5();

    private AppConfiguration$$Lambda$5() {
    }

    public final Object apply(Object obj) {
        return ((Experiments) obj).performance_analytics_android;
    }
}
