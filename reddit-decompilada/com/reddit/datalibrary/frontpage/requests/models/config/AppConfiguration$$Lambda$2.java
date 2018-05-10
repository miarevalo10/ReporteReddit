package com.reddit.datalibrary.frontpage.requests.models.config;

import com.google.common.base.Function;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Experiments;

final /* synthetic */ class AppConfiguration$$Lambda$2 implements Function {
    static final Function $instance = new AppConfiguration$$Lambda$2();

    private AppConfiguration$$Lambda$2() {
    }

    public final Object apply(Object obj) {
        return ((Experiments) obj).mvp_homepage_android;
    }
}
