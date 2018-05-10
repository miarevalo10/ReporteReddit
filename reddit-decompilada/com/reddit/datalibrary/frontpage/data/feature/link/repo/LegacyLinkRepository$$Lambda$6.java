package com.reddit.datalibrary.frontpage.data.feature.link.repo;

import com.reddit.datalibrary.frontpage.requests.models.v2.SubmittedVideoLink;
import java.util.Comparator;

public final /* synthetic */ class LegacyLinkRepository$$Lambda$6 implements Comparator {
    public static final Comparator f10699a = new LegacyLinkRepository$$Lambda$6();

    private LegacyLinkRepository$$Lambda$6() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((SubmittedVideoLink) obj).videoUpload.compareTo(((SubmittedVideoLink) obj2).videoUpload);
    }
}
