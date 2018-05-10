package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/TrophyRemoteDataModel;", "", "trophyId", "", "name", "description", "awardId", "icon40Url", "icon70Url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAwardId", "()Ljava/lang/String;", "getDescription", "getIcon40Url", "getIcon70Url", "getName", "getTrophyId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TrophyRemoteDataModel.kt */
public final class TrophyRemoteDataModel {
    @Json(a = "award_id")
    private final String awardId;
    private final String description;
    @Json(a = "icon_40")
    private final String icon40Url;
    @Json(a = "icon_70")
    private final String icon70Url;
    private final String name;
    @Json(a = "id")
    private final String trophyId;

    public static /* synthetic */ TrophyRemoteDataModel copy$default(TrophyRemoteDataModel trophyRemoteDataModel, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trophyRemoteDataModel.trophyId;
        }
        if ((i & 2) != 0) {
            str2 = trophyRemoteDataModel.name;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = trophyRemoteDataModel.description;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = trophyRemoteDataModel.awardId;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = trophyRemoteDataModel.icon40Url;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = trophyRemoteDataModel.icon70Url;
        }
        return trophyRemoteDataModel.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.trophyId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.awardId;
    }

    public final String component5() {
        return this.icon40Url;
    }

    public final String component6() {
        return this.icon70Url;
    }

    public final TrophyRemoteDataModel copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.b(str, "trophyId");
        Intrinsics.b(str2, "name");
        Intrinsics.b(str3, "description");
        Intrinsics.b(str4, "awardId");
        Intrinsics.b(str5, "icon40Url");
        Intrinsics.b(str6, "icon70Url");
        return new TrophyRemoteDataModel(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TrophyRemoteDataModel) {
                TrophyRemoteDataModel trophyRemoteDataModel = (TrophyRemoteDataModel) obj;
                if (Intrinsics.a(this.trophyId, trophyRemoteDataModel.trophyId) && Intrinsics.a(this.name, trophyRemoteDataModel.name) && Intrinsics.a(this.description, trophyRemoteDataModel.description) && Intrinsics.a(this.awardId, trophyRemoteDataModel.awardId) && Intrinsics.a(this.icon40Url, trophyRemoteDataModel.icon40Url) && Intrinsics.a(this.icon70Url, trophyRemoteDataModel.icon70Url)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.trophyId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.description;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.awardId;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.icon40Url;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.icon70Url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TrophyRemoteDataModel(trophyId=");
        stringBuilder.append(this.trophyId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", awardId=");
        stringBuilder.append(this.awardId);
        stringBuilder.append(", icon40Url=");
        stringBuilder.append(this.icon40Url);
        stringBuilder.append(", icon70Url=");
        stringBuilder.append(this.icon70Url);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public TrophyRemoteDataModel(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.b(str, "trophyId");
        Intrinsics.b(str2, "name");
        Intrinsics.b(str3, "description");
        Intrinsics.b(str4, "awardId");
        Intrinsics.b(str5, "icon40Url");
        Intrinsics.b(str6, "icon70Url");
        this.trophyId = str;
        this.name = str2;
        this.description = str3;
        this.awardId = str4;
        this.icon40Url = str5;
        this.icon70Url = str6;
    }

    public final String getTrophyId() {
        return this.trophyId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getAwardId() {
        return this.awardId;
    }

    public final String getIcon40Url() {
        return this.icon40Url;
    }

    public final String getIcon70Url() {
        return this.icon70Url;
    }
}
