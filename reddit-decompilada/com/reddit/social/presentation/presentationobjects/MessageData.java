package com.reddit.social.presentation.presentationobjects;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u0017J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u000eHÆ\u0003J´\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\"R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\"R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006G"}, d2 = {"Lcom/reddit/social/presentation/presentationobjects/MessageData;", "", "requestId", "", "messageId", "", "timestamp", "authorUserId", "author", "authorIsNsfw", "", "profileUrl", "age", "type", "Lcom/reddit/social/presentation/presentationobjects/MessageType;", "isRead", "sentStatus", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "isSelf", "channelUrl", "customType", "customData", "isHackIsPost", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/social/presentation/presentationobjects/MessageType;ZLcom/reddit/social/presentation/presentationobjects/SentStatus;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAge", "()Ljava/lang/String;", "getAuthor", "getAuthorIsNsfw", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAuthorUserId", "getChannelUrl", "getCustomData", "getCustomType", "()Z", "getMessageId", "()J", "setMessageId", "(J)V", "getProfileUrl", "getRequestId", "getSentStatus", "()Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "setSentStatus", "(Lcom/reddit/social/presentation/presentationobjects/SentStatus;)V", "getTimestamp", "getType", "()Lcom/reddit/social/presentation/presentationobjects/MessageType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/social/presentation/presentationobjects/MessageType;ZLcom/reddit/social/presentation/presentationobjects/SentStatus;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/reddit/social/presentation/presentationobjects/MessageData;", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageData.kt */
public final class MessageData {
    public final String f22428a;
    public long f22429b;
    public final long f22430c;
    public final String f22431d;
    public final String f22432e;
    public final Boolean f22433f;
    public final String f22434g;
    public final MessageType f22435h;
    public SentStatus f22436i;
    public final boolean f22437j;
    public final String f22438k;
    public final String f22439l;
    public final String f22440m;
    public final boolean f22441n;
    private final String f22442o;
    private final boolean f22443p;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageData) {
            MessageData messageData = (MessageData) obj;
            if (Intrinsics.m26845a(this.f22428a, messageData.f22428a)) {
                if (this.f22429b == messageData.f22429b) {
                    if ((this.f22430c == messageData.f22430c) && Intrinsics.m26845a(this.f22431d, messageData.f22431d) && Intrinsics.m26845a(this.f22432e, messageData.f22432e) && Intrinsics.m26845a(this.f22433f, messageData.f22433f) && Intrinsics.m26845a(this.f22434g, messageData.f22434g) && Intrinsics.m26845a(this.f22442o, messageData.f22442o) && Intrinsics.m26845a(this.f22435h, messageData.f22435h)) {
                        if ((this.f22443p == messageData.f22443p) && Intrinsics.m26845a(this.f22436i, messageData.f22436i)) {
                            if ((this.f22437j == messageData.f22437j) && Intrinsics.m26845a(this.f22438k, messageData.f22438k) && Intrinsics.m26845a(this.f22439l, messageData.f22439l) && Intrinsics.m26845a(this.f22440m, messageData.f22440m)) {
                                if (this.f22441n == messageData.f22441n) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f22428a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        long j = this.f22429b;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        j = this.f22430c;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f22431d;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22432e;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.f22433f;
        hashCode = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        str2 = this.f22434g;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22442o;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        MessageType messageType = this.f22435h;
        hashCode = (hashCode + (messageType != null ? messageType.hashCode() : 0)) * 31;
        int i2 = this.f22443p;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        SentStatus sentStatus = this.f22436i;
        hashCode = (hashCode + (sentStatus != null ? sentStatus.hashCode() : 0)) * 31;
        i2 = this.f22437j;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.f22438k;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22439l;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f22440m;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.f22441n;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MessageData(requestId=");
        stringBuilder.append(this.f22428a);
        stringBuilder.append(", messageId=");
        stringBuilder.append(this.f22429b);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.f22430c);
        stringBuilder.append(", authorUserId=");
        stringBuilder.append(this.f22431d);
        stringBuilder.append(", author=");
        stringBuilder.append(this.f22432e);
        stringBuilder.append(", authorIsNsfw=");
        stringBuilder.append(this.f22433f);
        stringBuilder.append(", profileUrl=");
        stringBuilder.append(this.f22434g);
        stringBuilder.append(", age=");
        stringBuilder.append(this.f22442o);
        stringBuilder.append(", type=");
        stringBuilder.append(this.f22435h);
        stringBuilder.append(", isRead=");
        stringBuilder.append(this.f22443p);
        stringBuilder.append(", sentStatus=");
        stringBuilder.append(this.f22436i);
        stringBuilder.append(", isSelf=");
        stringBuilder.append(this.f22437j);
        stringBuilder.append(", channelUrl=");
        stringBuilder.append(this.f22438k);
        stringBuilder.append(", customType=");
        stringBuilder.append(this.f22439l);
        stringBuilder.append(", customData=");
        stringBuilder.append(this.f22440m);
        stringBuilder.append(", isHackIsPost=");
        stringBuilder.append(this.f22441n);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public MessageData(String str, long j, long j2, String str2, String str3, Boolean bool, String str4, String str5, MessageType messageType, boolean z, SentStatus sentStatus, boolean z2, String str6, String str7, String str8) {
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str5;
        MessageType messageType2 = messageType;
        String str13 = str6;
        String str14 = str7;
        String str15 = str8;
        Intrinsics.m26847b(str9, "requestId");
        Intrinsics.m26847b(str10, "authorUserId");
        Intrinsics.m26847b(str11, "author");
        Intrinsics.m26847b(str12, "age");
        Intrinsics.m26847b(messageType2, "type");
        Intrinsics.m26847b(str13, "channelUrl");
        Intrinsics.m26847b(str14, "customType");
        Intrinsics.m26847b(str15, "customData");
        this.f22428a = str9;
        this.f22429b = j;
        this.f22430c = j2;
        this.f22431d = str10;
        this.f22432e = str11;
        this.f22433f = bool;
        this.f22434g = str4;
        this.f22442o = str12;
        this.f22435h = messageType2;
        this.f22443p = z;
        this.f22436i = sentStatus;
        this.f22437j = z2;
        this.f22438k = str13;
        this.f22439l = str14;
        this.f22440m = str15;
        this.f22441n = false;
    }
}
