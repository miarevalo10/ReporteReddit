package com.reddit.frontpage.commons.analytics.events.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v2/AnalyticsHeartbeatParams;", "", "inFocus", "", "pageType", "", "(ZLjava/lang/String;)V", "getInFocus", "()Z", "getPageType", "()Ljava/lang/String;", "subredditId", "getSubredditId", "setSubredditId", "(Ljava/lang/String;)V", "subredditName", "getSubredditName", "setSubredditName", "userId", "getUserId", "setUserId", "userName", "getUserName", "setUserName", "profile", "id", "name", "subreddit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnalyticsHeartbeatParams.kt */
public final class AnalyticsHeartbeatParams {
    public final boolean inFocus;
    public final String pageType;
    public String subredditId;
    public String subredditName;
    public String userId;
    public String userName;

    public AnalyticsHeartbeatParams(boolean z, String str) {
        this.inFocus = z;
        this.pageType = str;
    }

    public final AnalyticsHeartbeatParams m21905a(String str, String str2) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        this.subredditId = str;
        this.subredditName = str2;
        return this;
    }

    public final AnalyticsHeartbeatParams m21906b(String str, String str2) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        this.userId = str;
        this.userName = str2;
        return this;
    }
}
