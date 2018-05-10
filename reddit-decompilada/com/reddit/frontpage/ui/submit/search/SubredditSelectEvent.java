package com.reddit.frontpage.ui.submit.search;

import com.google.common.base.MoreObjects;
import org.parceler.Parcel;

@Parcel
public class SubredditSelectEvent {
    public final String icon;
    public final String keyColor;
    public final String requestId;
    public final String subredditId;
    public final String subredditName;

    public SubredditSelectEvent(String str, String str2, String str3, String str4, String str5) {
        this.requestId = str;
        this.subredditName = str2;
        this.subredditId = str3;
        this.icon = str4;
        this.keyColor = str5;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String toString() {
        return MoreObjects.a(this).a("subredditName", this.subredditName).a("subredditId", this.subredditId).a("icon", this.icon).a("keyColor", this.keyColor).a("requestId", this.requestId).toString();
    }
}
