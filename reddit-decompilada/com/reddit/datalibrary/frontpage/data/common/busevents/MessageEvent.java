package com.reddit.datalibrary.frontpage.data.common.busevents;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/busevents/MessageEvent;", "", "message", "", "duration", "", "(Ljava/lang/String;I)V", "getDuration", "()I", "getMessage", "()Ljava/lang/String;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageEvent.kt */
public final class MessageEvent {
    public static final Companion f10305c = new Companion();
    public final String f10306a;
    public final int f10307b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/busevents/MessageEvent$Companion;", "", "()V", "indefiniteDuration", "Lcom/reddit/datalibrary/frontpage/data/common/busevents/MessageEvent;", "message", "", "longDuration", "newInstance", "shortDuration", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: MessageEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public static MessageEvent m8762a(String str) {
            Intrinsics.b(str, "message");
            Intrinsics.b(str, "message");
            return new MessageEvent(str, -1);
        }

        public static MessageEvent m8763b(String str) {
            Intrinsics.b(str, "message");
            return new MessageEvent(str, 0);
        }
    }

    public static final MessageEvent m8764a(String str) {
        return Companion.m8762a(str);
    }

    public static final MessageEvent m8765b(String str) {
        return Companion.m8763b(str);
    }

    private MessageEvent(String str, int i) {
        this.f10306a = str;
        this.f10307b = i;
    }
}
