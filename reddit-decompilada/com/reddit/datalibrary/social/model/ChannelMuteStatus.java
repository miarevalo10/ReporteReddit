package com.reddit.datalibrary.social.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/social/model/ChannelMuteStatus;", "", "channelUrl", "", "isMuted", "", "(Ljava/lang/String;Z)V", "getChannelUrl", "()Ljava/lang/String;", "()Z", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChannelMuteStatus.kt */
public final class ChannelMuteStatus {
    @SerializedName(a = "channel_url")
    private final String channelUrl;
    @SerializedName(a = "is_muted")
    private final boolean isMuted;

    public ChannelMuteStatus(String str, boolean z) {
        Intrinsics.m26847b(str, "channelUrl");
        this.channelUrl = str;
        this.isMuted = z;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }
}
