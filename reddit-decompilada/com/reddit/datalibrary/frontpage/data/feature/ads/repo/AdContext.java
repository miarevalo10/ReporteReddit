package com.reddit.datalibrary.frontpage.data.feature.ads.repo;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.frontpage.domain.model.Subreddit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "screenName", "", "adUnit", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "(Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/domain/model/Subreddit;)V", "getAdUnit", "()Ljava/lang/String;", "getScreenName", "getSession", "()Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "getSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAdsRepository.kt */
public final class AdContext {
    final Session f10322a;
    final String f10323b;
    final String f10324c;
    final Subreddit f10325d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AdContext) {
                AdContext adContext = (AdContext) obj;
                if (Intrinsics.a(this.f10322a, adContext.f10322a) && Intrinsics.a(this.f10323b, adContext.f10323b) && Intrinsics.a(this.f10324c, adContext.f10324c) && Intrinsics.a(this.f10325d, adContext.f10325d)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Session session = this.f10322a;
        int i = 0;
        int hashCode = (session != null ? session.hashCode() : 0) * 31;
        String str = this.f10323b;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = this.f10324c;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Subreddit subreddit = this.f10325d;
        if (subreddit != null) {
            i = subreddit.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AdContext(session=");
        stringBuilder.append(this.f10322a);
        stringBuilder.append(", screenName=");
        stringBuilder.append(this.f10323b);
        stringBuilder.append(", adUnit=");
        stringBuilder.append(this.f10324c);
        stringBuilder.append(", subreddit=");
        stringBuilder.append(this.f10325d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private AdContext(Session session, String str, String str2) {
        Intrinsics.b(session, SDKCoreEvent.Session.TYPE_SESSION);
        Intrinsics.b(str, "screenName");
        this.f10322a = session;
        this.f10323b = str;
        this.f10324c = str2;
        this.f10325d = null;
    }
}
