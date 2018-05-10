package com.reddit.datalibrary.frontpage.data.feature.ads;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/AdContext;", "", "adUnit", "", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "listingId", "screenName", "subreddit", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/SubredditAdMetadata;", "(Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/data/feature/ads/SubredditAdMetadata;)V", "getAdUnit", "()Ljava/lang/String;", "getListingId", "getScreenName", "getSession", "()Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "getSubreddit", "()Lcom/reddit/datalibrary/frontpage/data/feature/ads/SubredditAdMetadata;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdContext.kt */
public final class AdContext {
    public final String f10314a;
    public final Session f10315b;
    public final String f10316c;
    public final String f10317d;
    public final SubredditAdMetadata f10318e;

    public AdContext(String str, Session session, String str2, String str3, SubredditAdMetadata subredditAdMetadata) {
        Intrinsics.b(session, SDKCoreEvent.Session.TYPE_SESSION);
        Intrinsics.b(str2, "listingId");
        Intrinsics.b(str3, "screenName");
        this.f10314a = str;
        this.f10315b = session;
        this.f10316c = str2;
        this.f10317d = str3;
        this.f10318e = subredditAdMetadata;
    }
}
