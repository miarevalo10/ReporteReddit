package com.reddit.datalibrary.social.network;

import com.reddit.datalibrary.social.model.ReportMessage;
import com.reddit.datalibrary.social.model.UserBriefData;
import com.reddit.datalibrary.social.network.RedditAPIService.DefaultImpls;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import io.reactivex.Observable;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\tJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tJ2\u0010\u0013\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\tj\u0002`\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u000b2\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\tj\u0002`\u00150\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/reddit/datalibrary/social/network/RedditAPIClient;", "Lcom/reddit/datalibrary/social/network/BaseClient;", "()V", "redditAPIService", "Lcom/reddit/datalibrary/social/network/RedditAPIService;", "addDynamicHeadersTo", "", "headers", "", "", "blockUser", "Lio/reactivex/Observable;", "", "userId", "reportMessage", "userName", "reason", "Lcom/reddit/datalibrary/social/model/ReportMessage;", "reportUser", "userDataByAccountIds", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "Lcom/reddit/datalibrary/social/network/UserBriefDataMap;", "ids", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAPIClient.kt */
public final class RedditAPIClient extends BaseClient {
    private final RedditAPIService f27396a;

    public RedditAPIClient() {
        Object f = Util.m24027f((int) C1761R.string.base_uri_default);
        Intrinsics.m26843a(f, "redditUri");
        this.f27396a = (RedditAPIService) BaseClient.m21773a(f, RedditAPIService.class);
    }

    public final Observable<Object> m28854a(String str, String str2) {
        Intrinsics.m26847b(str, "userName");
        Intrinsics.m26847b(str2, "reason");
        return DefaultImpls.reportUser$default(this.f27396a, BaseClient.m21774a(), str, str2, null, 8, null);
    }

    public final Observable<Object> m28855a(String str, String str2, ReportMessage reportMessage) {
        Intrinsics.m26847b(str, "userName");
        Intrinsics.m26847b(str2, "reason");
        Intrinsics.m26847b(reportMessage, "reportMessage");
        return this.f27396a.reportUser(BaseClient.m21774a(), str, str2, reportMessage);
    }

    public final Observable<Object> m28853a(String str) {
        Intrinsics.m26847b(str, "userId");
        return this.f27396a.blockUser(BaseClient.m21774a(), str);
    }

    public final Observable<Map<String, UserBriefData>> m28856a(Set<String> set) {
        Intrinsics.m26847b(set, "ids");
        Object onErrorReturn = this.f27396a.userDataByAccountIds(BaseClient.m21774a(), CollectionsKt___CollectionsKt.m41412a((Iterable) set, null, null, null, 0, null, null, 63)).onErrorReturn(new RedditAPIClient$userDataByAccountIds$1(set));
        Intrinsics.m26843a(onErrorReturn, "redditAPIService\n       …   emptyMap()\n          }");
        return onErrorReturn;
    }
}
