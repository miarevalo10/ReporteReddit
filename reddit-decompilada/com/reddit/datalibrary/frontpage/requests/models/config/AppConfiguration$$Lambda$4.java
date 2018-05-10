package com.reddit.datalibrary.frontpage.requests.models.config;

import com.google.common.base.Function;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Experiments;

final /* synthetic */ class AppConfiguration$$Lambda$4 implements Function {
    static final Function $instance = new AppConfiguration$$Lambda$4();

    private AppConfiguration$$Lambda$4() {
    }

    public final Object apply(Object obj) {
        return ((Experiments) obj).performance_analytics_android;
    }
}
