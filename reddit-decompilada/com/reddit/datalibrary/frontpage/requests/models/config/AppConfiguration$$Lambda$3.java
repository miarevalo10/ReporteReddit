package com.reddit.datalibrary.frontpage.requests.models.config;

import com.google.common.base.Function;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Experiments;

public final /* synthetic */ class AppConfiguration$$Lambda$3 implements Function {
    public static final Function $instance = new AppConfiguration$$Lambda$3();

    private AppConfiguration$$Lambda$3() {
    }

    public final Object apply(Object obj) {
        return ((Experiments) obj).trending_pn_logged_out;
    }
}
