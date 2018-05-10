package com.reddit.frontpage.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/domain/model/Trophy;", "", "id", "", "awardId", "name", "description", "iconUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAwardId", "()Ljava/lang/String;", "getDescription", "getIconUrl", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Trophy.kt */
public final class Trophy {
    private final String awardId;
    private final String description;
    private final String iconUrl;
    private final String id;
    private final String name;

    public static /* synthetic */ Trophy copy$default(Trophy trophy, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trophy.id;
        }
        if ((i & 2) != 0) {
            str2 = trophy.awardId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = trophy.name;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = trophy.description;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = trophy.iconUrl;
        }
        return trophy.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.awardId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final Trophy copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.m26847b(str3, "name");
        Intrinsics.m26847b(str5, "iconUrl");
        return new Trophy(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Trophy) {
                Trophy trophy = (Trophy) obj;
                if (Intrinsics.m26845a(this.id, trophy.id) && Intrinsics.m26845a(this.awardId, trophy.awardId) && Intrinsics.m26845a(this.name, trophy.name) && Intrinsics.m26845a(this.description, trophy.description) && Intrinsics.m26845a(this.iconUrl, trophy.iconUrl)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.awardId;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.description;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.iconUrl;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Trophy(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", awardId=");
        stringBuilder.append(this.awardId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Trophy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.m26847b(str3, "name");
        Intrinsics.m26847b(str5, "iconUrl");
        this.id = str;
        this.awardId = str2;
        this.name = str3;
        this.description = str4;
        this.iconUrl = str5;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAwardId() {
        return this.awardId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }
}
