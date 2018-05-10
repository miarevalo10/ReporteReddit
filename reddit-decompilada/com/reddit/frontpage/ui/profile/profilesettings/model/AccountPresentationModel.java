package com.reddit.frontpage.ui.profile.profilesettings.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J[\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountPresentationModel;", "", "title", "", "description", "showMyActiveCommunities", "", "showInDefaultSubreddits", "bannerImg", "iconImg", "isDefaultIcon", "isDefaultBanner", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZZ)V", "getBannerImg", "()Ljava/lang/String;", "getDescription", "getIconImg", "()Z", "getShowInDefaultSubreddits", "getShowMyActiveCommunities", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountPresentationModel.kt */
public final class AccountPresentationModel {
    public final String f21544a;
    public final String f21545b;
    public final boolean f21546c;
    public final boolean f21547d;
    public final String f21548e;
    public final String f21549f;
    public final boolean f21550g;
    public final boolean f21551h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountPresentationModel) {
            AccountPresentationModel accountPresentationModel = (AccountPresentationModel) obj;
            if (Intrinsics.m26845a(this.f21544a, accountPresentationModel.f21544a) && Intrinsics.m26845a(this.f21545b, accountPresentationModel.f21545b)) {
                if (this.f21546c == accountPresentationModel.f21546c) {
                    if ((this.f21547d == accountPresentationModel.f21547d) && Intrinsics.m26845a(this.f21548e, accountPresentationModel.f21548e) && Intrinsics.m26845a(this.f21549f, accountPresentationModel.f21549f)) {
                        if (this.f21550g == accountPresentationModel.f21550g) {
                            if (this.f21551h == accountPresentationModel.f21551h) {
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
        String str = this.f21544a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f21545b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.f21546c;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f21547d;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        str2 = this.f21548e;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f21549f;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.f21550g;
        if (i != 0) {
            i = 1;
        }
        hashCode = (hashCode + i) * 31;
        i = this.f21551h;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AccountPresentationModel(title=");
        stringBuilder.append(this.f21544a);
        stringBuilder.append(", description=");
        stringBuilder.append(this.f21545b);
        stringBuilder.append(", showMyActiveCommunities=");
        stringBuilder.append(this.f21546c);
        stringBuilder.append(", showInDefaultSubreddits=");
        stringBuilder.append(this.f21547d);
        stringBuilder.append(", bannerImg=");
        stringBuilder.append(this.f21548e);
        stringBuilder.append(", iconImg=");
        stringBuilder.append(this.f21549f);
        stringBuilder.append(", isDefaultIcon=");
        stringBuilder.append(this.f21550g);
        stringBuilder.append(", isDefaultBanner=");
        stringBuilder.append(this.f21551h);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AccountPresentationModel(String str, String str2, boolean z, boolean z2, String str3, String str4, boolean z3, boolean z4) {
        Intrinsics.m26847b(str, "title");
        Intrinsics.m26847b(str2, "description");
        Intrinsics.m26847b(str4, "iconImg");
        this.f21544a = str;
        this.f21545b = str2;
        this.f21546c = z;
        this.f21547d = z2;
        this.f21548e = str3;
        this.f21549f = str4;
        this.f21550g = z3;
        this.f21551h = z4;
    }
}
