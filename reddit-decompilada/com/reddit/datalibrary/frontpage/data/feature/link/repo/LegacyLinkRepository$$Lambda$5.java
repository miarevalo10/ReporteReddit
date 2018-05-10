package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubmittedVideoLink;
import io.reactivex.functions.Function;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$5 implements Function {
    public static final Function f16065a = new LegacyLinkRepository$$Lambda$5();

    private LegacyLinkRepository$$Lambda$5() {
    }

    public final Object apply(Object obj) {
        return new SubmittedVideoLink((VideoUpload) obj);
    }
}
