package com.reddit.datalibrary.frontpage.requests.models.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/Inbox;", "", "MarkAllMessagesReadFilter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Inbox.kt */
public interface Inbox {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/Inbox$MarkAllMessagesReadFilter;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMMENT_REPLY", "PRIVATE_MESSAGE", "USERNAME_MENTION", "POST_REPLY", "TRENDING_NOTIFICATION", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Inbox.kt */
    public enum MarkAllMessagesReadFilter {
        ;
        
        public static final Companion Companion = null;
        final String value;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/Inbox$MarkAllMessagesReadFilter$Companion;", "", "()V", "toRequestParam", "", "types", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Inbox$MarkAllMessagesReadFilter;", "([Lcom/reddit/datalibrary/frontpage/requests/models/v2/Inbox$MarkAllMessagesReadFilter;)Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: Inbox.kt */
        public static final class Companion {
            private Companion() {
            }
        }

        private MarkAllMessagesReadFilter(String str) {
            Intrinsics.m26847b(str, "value");
            this.value = str;
        }

        static {
            Companion = new Companion();
        }
    }
}
