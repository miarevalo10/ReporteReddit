package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ModPermissions;", "", "access", "", "config", "flair", "mail", "posts", "wiki", "all", "(ZZZZZZZ)V", "getAccess", "()Z", "getAll", "getConfig", "getFlair", "getMail", "getPosts", "getWiki", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Moderator.kt */
public final class ModPermissions {
    @Json(a = "access")
    private final boolean access;
    @Json(a = "all")
    private final boolean all;
    @Json(a = "config")
    private final boolean config;
    @Json(a = "flair")
    private final boolean flair;
    @Json(a = "mail")
    private final boolean mail;
    @Json(a = "posts")
    private final boolean posts;
    @Json(a = "wiki")
    private final boolean wiki;

    public static /* synthetic */ ModPermissions copy$default(ModPermissions modPermissions, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z = modPermissions.access;
        }
        if ((i & 2) != 0) {
            z2 = modPermissions.config;
        }
        boolean z8 = z2;
        if ((i & 4) != 0) {
            z3 = modPermissions.flair;
        }
        boolean z9 = z3;
        if ((i & 8) != 0) {
            z4 = modPermissions.mail;
        }
        boolean z10 = z4;
        if ((i & 16) != 0) {
            z5 = modPermissions.posts;
        }
        boolean z11 = z5;
        if ((i & 32) != 0) {
            z6 = modPermissions.wiki;
        }
        boolean z12 = z6;
        if ((i & 64) != 0) {
            z7 = modPermissions.all;
        }
        return modPermissions.copy(z, z8, z9, z10, z11, z12, z7);
    }

    public final boolean component1() {
        return this.access;
    }

    public final boolean component2() {
        return this.config;
    }

    public final boolean component3() {
        return this.flair;
    }

    public final boolean component4() {
        return this.mail;
    }

    public final boolean component5() {
        return this.posts;
    }

    public final boolean component6() {
        return this.wiki;
    }

    public final boolean component7() {
        return this.all;
    }

    public final ModPermissions copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return new ModPermissions(z, z2, z3, z4, z5, z6, z7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModPermissions) {
            ModPermissions modPermissions = (ModPermissions) obj;
            if (this.access == modPermissions.access) {
                if (this.config == modPermissions.config) {
                    if (this.flair == modPermissions.flair) {
                        if (this.mail == modPermissions.mail) {
                            if (this.posts == modPermissions.posts) {
                                if (this.wiki == modPermissions.wiki) {
                                    if (this.all == modPermissions.all) {
                                        return true;
                                    }
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
        int i = this.access;
        int i2 = 1;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        int i3 = this.config;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.flair;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.mail;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.posts;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.wiki;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        boolean z = this.all;
        if (!z) {
            i2 = z;
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ModPermissions(access=");
        stringBuilder.append(this.access);
        stringBuilder.append(", config=");
        stringBuilder.append(this.config);
        stringBuilder.append(", flair=");
        stringBuilder.append(this.flair);
        stringBuilder.append(", mail=");
        stringBuilder.append(this.mail);
        stringBuilder.append(", posts=");
        stringBuilder.append(this.posts);
        stringBuilder.append(", wiki=");
        stringBuilder.append(this.wiki);
        stringBuilder.append(", all=");
        stringBuilder.append(this.all);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ModPermissions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.access = z;
        this.config = z2;
        this.flair = z3;
        this.mail = z4;
        this.posts = z5;
        this.wiki = z6;
        this.all = z7;
    }

    public final boolean getAccess() {
        return this.access;
    }

    public final boolean getConfig() {
        return this.config;
    }

    public final boolean getFlair() {
        return this.flair;
    }

    public final boolean getMail() {
        return this.mail;
    }

    public final boolean getPosts() {
        return this.posts;
    }

    public final boolean getWiki() {
        return this.wiki;
    }

    public final boolean getAll() {
        return this.all;
    }
}
