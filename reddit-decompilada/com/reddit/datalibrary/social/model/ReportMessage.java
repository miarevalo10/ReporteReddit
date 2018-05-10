package com.reddit.datalibrary.social.model;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/social/model/ReportMessage;", "", "sendbirdChatMessage", "Lcom/reddit/datalibrary/social/model/ReportMessageFields;", "(Lcom/reddit/datalibrary/social/model/ReportMessageFields;)V", "getSendbirdChatMessage", "()Lcom/reddit/datalibrary/social/model/ReportMessageFields;", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReportMessage.kt */
public final class ReportMessage {
    private final ReportMessageFields sendbirdChatMessage;

    public ReportMessage(ReportMessageFields reportMessageFields) {
        Intrinsics.m26847b(reportMessageFields, "sendbirdChatMessage");
        this.sendbirdChatMessage = reportMessageFields;
    }

    public final ReportMessageFields getSendbirdChatMessage() {
        return this.sendbirdChatMessage;
    }

    public final String toString() {
        Object b = new Gson().b(this);
        Intrinsics.m26843a(b, "Gson().toJson(this)");
        return b;
    }
}
