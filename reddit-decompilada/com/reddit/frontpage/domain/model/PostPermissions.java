package com.reddit.frontpage.domain.model;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/domain/model/PostPermissions;", "", "links", "", "images", "videos", "text", "spoilers", "(ZZZZZ)V", "getImages", "()Z", "getLinks", "getSpoilers", "getText", "getVideos", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Subreddit.kt */
public final class PostPermissions {
    private final boolean images;
    private final boolean links;
    private final boolean spoilers;
    private final boolean text;
    private final boolean videos;

    public static /* synthetic */ PostPermissions copy$default(PostPermissions postPermissions, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = postPermissions.links;
        }
        if ((i & 2) != 0) {
            z2 = postPermissions.images;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = postPermissions.videos;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = postPermissions.text;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            z5 = postPermissions.spoilers;
        }
        return postPermissions.copy(z, z6, z7, z8, z5);
    }

    public final boolean component1() {
        return this.links;
    }

    public final boolean component2() {
        return this.images;
    }

    public final boolean component3() {
        return this.videos;
    }

    public final boolean component4() {
        return this.text;
    }

    public final boolean component5() {
        return this.spoilers;
    }

    public final PostPermissions copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new PostPermissions(z, z2, z3, z4, z5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PostPermissions) {
            PostPermissions postPermissions = (PostPermissions) obj;
            if (this.links == postPermissions.links) {
                if (this.images == postPermissions.images) {
                    if (this.videos == postPermissions.videos) {
                        if (this.text == postPermissions.text) {
                            if (this.spoilers == postPermissions.spoilers) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.links;
        int i2 = 1;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        int i3 = this.images;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.videos;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.text;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        boolean z = this.spoilers;
        if (!z) {
            i2 = z;
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PostPermissions(links=");
        stringBuilder.append(this.links);
        stringBuilder.append(", images=");
        stringBuilder.append(this.images);
        stringBuilder.append(", videos=");
        stringBuilder.append(this.videos);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", spoilers=");
        stringBuilder.append(this.spoilers);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public PostPermissions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.links = z;
        this.images = z2;
        this.videos = z3;
        this.text = z4;
        this.spoilers = z5;
    }

    public final boolean getLinks() {
        return this.links;
    }

    public final boolean getImages() {
        return this.images;
    }

    public final boolean getVideos() {
        return this.videos;
    }

    public final boolean getText() {
        return this.text;
    }

    public final boolean getSpoilers() {
        return this.spoilers;
    }
}
