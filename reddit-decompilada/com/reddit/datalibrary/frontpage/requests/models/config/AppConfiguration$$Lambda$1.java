package com.reddit.datalibrary.frontpage.requests.models.config;

import com.google.common.base.Function;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Experiments;

final /* synthetic */ class AppConfiguration$$Lambda$1 implements Function {
    static final Function $instance = new AppConfiguration$$Lambda$1();

    private AppConfiguration$$Lambda$1() {
    }

    public final Object apply(Object obj) {
        return ((Experiments) obj).mvp_homepage_android;
    }
}
