package com.reddit.datalibrary.social.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/reddit/datalibrary/social/model/Contact;", "", "userId", "", "name", "createdUtc", "", "linkKarma", "", "lastInteraction", "", "commentKarma", "profileIcon", "(Ljava/lang/String;Ljava/lang/String;JIDILjava/lang/String;)V", "getCommentKarma", "()I", "getCreatedUtc", "()J", "getLastInteraction", "()D", "getLinkKarma", "getName", "()Ljava/lang/String;", "getProfileIcon", "getUserId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Contact.kt */
public final class Contact {
    @SerializedName(a = "comment_karma")
    private final int commentKarma;
    @SerializedName(a = "created_utc")
    private final long createdUtc;
    @SerializedName(a = "last_interaction")
    private final double lastInteraction;
    @SerializedName(a = "link_karma")
    private final int linkKarma;
    @SerializedName(a = "name")
    private final String name;
    @SerializedName(a = "profile_img")
    private final String profileIcon;
    @SerializedName(a = "contact_account_id")
    private final String userId;

    public Contact(String str, String str2, long j, int i, double d, int i2, String str3) {
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(str2, "name");
        this.userId = str;
        this.name = str2;
        this.createdUtc = j;
        this.linkKarma = i;
        this.lastInteraction = d;
        this.commentKarma = i2;
        this.profileIcon = str3;
    }

    public final String getUserId() {
        return this.userId;
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

    public final double getLastInteraction() {
        return this.lastInteraction;
    }

    public final int getCommentKarma() {
        return this.commentKarma;
    }

    public final String getProfileIcon() {
        return this.profileIcon;
    }
}
