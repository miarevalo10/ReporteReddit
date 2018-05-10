package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ProfileSettings;", "", "showMyActiveCommunities", "", "(Z)V", "getShowMyActiveCommunities", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProfileSettings.kt */
public final class ProfileSettings {
    @Json(a = "top_karma_subreddits")
    private final boolean showMyActiveCommunities;

    public static /* synthetic */ ProfileSettings copy$default(ProfileSettings profileSettings, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = profileSettings.showMyActiveCommunities;
        }
        return profileSettings.copy(z);
    }

    public final boolean component1() {
        return this.showMyActiveCommunities;
    }

    public final ProfileSettings copy(boolean z) {
        return new ProfileSettings(z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProfileSettings) {
            if (this.showMyActiveCommunities == ((ProfileSettings) obj).showMyActiveCommunities) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.showMyActiveCommunities;
        return z ? 1 : z;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ProfileSettings(showMyActiveCommunities=");
        stringBuilder.append(this.showMyActiveCommunities);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ProfileSettings(boolean z) {
        this.showMyActiveCommunities = z;
    }

    public final boolean getShowMyActiveCommunities() {
        return this.showMyActiveCommunities;
    }
}
