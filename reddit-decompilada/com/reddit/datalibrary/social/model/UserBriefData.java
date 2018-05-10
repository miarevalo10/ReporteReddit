package com.reddit.datalibrary.social.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/reddit/datalibrary/social/model/UserBriefData;", "", "name", "", "createdUtc", "", "linkKarma", "", "commentKarma", "profileIcon", "isNsfw", "", "(Ljava/lang/String;JIILjava/lang/String;Z)V", "getCommentKarma", "()I", "getCreatedUtc", "()J", "()Z", "getLinkKarma", "getName", "()Ljava/lang/String;", "getProfileIcon", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserBriefData.kt */
public final class UserBriefData {
    @SerializedName(a = "comment_karma")
    private final int commentKarma;
    @SerializedName(a = "created_utc")
    private final long createdUtc;
    @SerializedName(a = "profile_over_18")
    private final boolean isNsfw;
    @SerializedName(a = "link_karma")
    private final int linkKarma;
    @SerializedName(a = "name")
    private final String name;
    @SerializedName(a = "profile_img")
    private final String profileIcon;

    public UserBriefData(String str, long j, int i, int i2, String str2, boolean z) {
        Intrinsics.m26847b(str, "name");
        this.name = str;
        this.createdUtc = j;
        this.linkKarma = i;
        this.commentKarma = i2;
        this.profileIcon = str2;
        this.isNsfw = z;
    }

    public final String getName() {
        return this.name;
    }

    public final long getCreatedUtc() {
        return this.createdUtc;
    }

    public final int getLinkKarma() {
        return this.linkKarma;
    }

    public final int getCommentKarma() {
        return this.commentKarma;
    }

    public final String getProfileIcon() {
        return this.profileIcon;
    }

    public final boolean isNsfw() {
        return this.isNsfw;
    }
}
