package com.reddit.datalibrary.social.model;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/reddit/datalibrary/social/model/ReportMessageFields;", "", "channelUrl", "", "createdAt", "", "messageId", "userId", "userNickname", "customType", "customData", "messageBody", "fileUrl", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelUrl", "()Ljava/lang/String;", "getCreatedAt", "()J", "getCustomData", "getCustomType", "getFileUrl", "getMessageBody", "getMessageId", "getUserId", "getUserNickname", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReportMessage.kt */
public final class ReportMessageFields {
    private final String channelUrl;
    private final long createdAt;
    private final String customData;
    private final String customType;
    private final String fileUrl;
    private final String messageBody;
    private final long messageId;
    private final String userId;
    private final String userNickname;

    public ReportMessageFields(String str, long j, long j2, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "userId");
        Intrinsics.m26847b(str3, "userNickname");
        Intrinsics.m26847b(str4, "customType");
        Intrinsics.m26847b(str5, "customData");
        this.channelUrl = str;
        this.createdAt = j;
        this.messageId = j2;
        this.userId = str2;
        this.userNickname = str3;
        this.customType = str4;
        this.customData = str5;
        this.messageBody = str6;
        this.fileUrl = str7;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserNickname() {
        return this.userNickname;
    }

    public final String getCustomType() {
        return this.customType;
    }

    public final String getCustomData() {
        return this.customData;
    }

    public final String getMessageBody() {
        return this.messageBody;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final String toString() {
        Object b = new Gson().b(this);
        Intrinsics.m26843a(b, "Gson().toJson(this)");
        return b;
    }
}
