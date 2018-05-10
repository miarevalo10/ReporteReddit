package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$4 implements Predicate {
    public static final Predicate f16064a = new LegacyLinkRepository$$Lambda$4();

    private LegacyLinkRepository$$Lambda$4() {
    }

    public final boolean test(Object obj) {
        return ((VideoUpload) obj).hasPostData();
    }
}
