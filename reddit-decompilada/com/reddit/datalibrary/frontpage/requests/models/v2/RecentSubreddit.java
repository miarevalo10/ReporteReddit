package com.reddit.datalibrary.frontpage.requests.models.v2;

import com.raizlabs.android.dbflow.structure.BaseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 Jf\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/RecentSubreddit;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "id", "", "username", "", "subredditName", "subredditId", "icon", "headerImg", "keyColor", "visitTime", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getHeaderImg", "()Ljava/lang/String;", "setHeaderImg", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getId", "()J", "setId", "(J)V", "getKeyColor", "setKeyColor", "getSubredditId", "setSubredditId", "getSubredditName", "setSubredditName", "getUsername", "setUsername", "getVisitTime", "()Ljava/lang/Long;", "setVisitTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/reddit/datalibrary/frontpage/requests/models/v2/RecentSubreddit;", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RecentSubreddit.kt */
public final class RecentSubreddit extends BaseModel {
    public String headerImg;
    public String icon;
    long id;
    public String keyColor;
    public String subredditId;
    public String subredditName;
    String username;
    public Long visitTime;

    public RecentSubreddit(byte b) {
        this();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecentSubreddit) {
            RecentSubreddit recentSubreddit = (RecentSubreddit) obj;
            return ((this.id > recentSubreddit.id ? 1 : (this.id == recentSubreddit.id ? 0 : -1)) == 0) && Intrinsics.m26845a(this.username, recentSubreddit.username) && Intrinsics.m26845a(this.subredditName, recentSubreddit.subredditName) && Intrinsics.m26845a(this.subredditId, recentSubreddit.subredditId) && Intrinsics.m26845a(this.icon, recentSubreddit.icon) && Intrinsics.m26845a(this.headerImg, recentSubreddit.headerImg) && Intrinsics.m26845a(this.keyColor, recentSubreddit.keyColor) && Intrinsics.m26845a(this.visitTime, recentSubreddit.visitTime);
        }
    }

    public final int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.username;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.subredditName;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.subredditId;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.icon;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.headerImg;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.keyColor;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.visitTime;
        if (l != null) {
            i2 = l.hashCode();
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RecentSubreddit(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", username=");
        stringBuilder.append(this.username);
        stringBuilder.append(", subredditName=");
        stringBuilder.append(this.subredditName);
        stringBuilder.append(", subredditId=");
        stringBuilder.append(this.subredditId);
        stringBuilder.append(", icon=");
        stringBuilder.append(this.icon);
        stringBuilder.append(", headerImg=");
        stringBuilder.append(this.headerImg);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(", visitTime=");
        stringBuilder.append(this.visitTime);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void m36662a(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.username = str;
    }

    public final void m36663b(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditName = str;
    }

    public final void m36664c(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.subredditId = str;
    }

    private /* synthetic */ RecentSubreddit() {
        this("", "", "");
    }

    private RecentSubreddit(String str, String str2, String str3) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(str2, "subredditName");
        Intrinsics.m26847b(str3, "subredditId");
        this.id = 0;
        this.username = str;
        this.subredditName = str2;
        this.subredditId = str3;
        this.icon = null;
        this.headerImg = null;
        this.keyColor = null;
        this.visitTime = null;
    }
}
