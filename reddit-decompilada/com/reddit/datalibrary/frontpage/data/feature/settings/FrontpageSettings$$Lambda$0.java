package com.reddit.datalibrary.frontpage.data.feature.settings;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.debug.RedditLogger;
import io.reactivex.functions.Predicate;

final /* synthetic */ class FrontpageSettings$$Lambda$0 implements Predicate {
    private final FrontpageSettings f16149a;

    FrontpageSettings$$Lambda$0(FrontpageSettings frontpageSettings) {
        this.f16149a = frontpageSettings;
    }

    public final boolean test(Object obj) {
        FrontpageSettings frontpageSettings = this.f16149a;
        String str = ((DiscoveryUnit) obj).unique_id;
        if (frontpageSettings.m9057r()) {
            return true;
        }
        RedditLogger.a(String.format("shouldShowCarousel(%1$s), key = %2$s, show = %3$s", new Object[]{str, FrontpageSettings.m9014g(str), Boolean.valueOf(frontpageSettings.m9023a(FrontpageSettings.m9014g(str), 2592000000L))}));
        return frontpageSettings.m9023a(FrontpageSettings.m9014g(str), 2592000000L);
    }
}
