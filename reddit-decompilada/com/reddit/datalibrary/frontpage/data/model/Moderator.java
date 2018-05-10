package com.reddit.datalibrary.frontpage.data.model;

import android.text.TextUtils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003Je\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\u0006\u0010,\u001a\u00020\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00060"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/Moderator;", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "username", "", "authorFlairText", "id", "atUtc", "", "modPermissions", "Lcom/reddit/datalibrary/frontpage/data/model/ModPermissions;", "accountIcon", "postKarma", "", "reason", "editable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/reddit/datalibrary/frontpage/data/model/ModPermissions;Ljava/lang/String;DLjava/lang/String;Z)V", "getAccountIcon", "()Ljava/lang/String;", "getAtUtc", "()J", "getAuthorFlairText", "getEditable", "()Z", "getId", "getModPermissions", "()Lcom/reddit/datalibrary/frontpage/data/model/ModPermissions;", "getPostKarma", "()D", "getReason", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getPermissionsString", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Moderator.kt */
public final class Moderator implements ModToolsUserModel {
    @Json(a = "accountIcon")
    private final String accountIcon;
    @Json(a = "moddedAtUTC")
    private final long atUtc;
    @Json(a = "authorFlairText")
    private final String authorFlairText;
    @Json(a = "isEditable")
    private final boolean editable;
    @Json(a = "id")
    private final String id;
    @Json(a = "modPermissions")
    private final ModPermissions modPermissions;
    @Json(a = "postKarma")
    private final double postKarma;
    @Json(a = "reason")
    private final String reason;
    @Json(a = "username")
    private final String username;

    public static /* synthetic */ Moderator copy$default(Moderator moderator, String str, String str2, String str3, long j, ModPermissions modPermissions, String str4, double d, String str5, boolean z, int i, Object obj) {
        Moderator moderator2 = moderator;
        int i2 = i;
        return moderator2.copy((i2 & 1) != 0 ? moderator2.getUsername() : str, (i2 & 2) != 0 ? moderator2.authorFlairText : str2, (i2 & 4) != 0 ? moderator2.getId() : str3, (i2 & 8) != 0 ? moderator2.getAtUtc() : j, (i2 & 16) != 0 ? moderator2.modPermissions : modPermissions, (i2 & 32) != 0 ? moderator2.getAccountIcon() : str4, (i2 & 64) != 0 ? moderator2.postKarma : d, (i2 & 128) != 0 ? moderator2.getReason() : str5, (i2 & 256) != 0 ? moderator2.editable : z);
    }

    public final String component1() {
        return getUsername();
    }

    public final String component2() {
        return this.authorFlairText;
    }

    public final String component3() {
        return getId();
    }

    public final long component4() {
        return getAtUtc();
    }

    public final ModPermissions component5() {
        return this.modPermissions;
    }

    public final String component6() {
        return getAccountIcon();
    }

    public final double component7() {
        return this.postKarma;
    }

    public final String component8() {
        return getReason();
    }

    public final boolean component9() {
        return this.editable;
    }

    public final Moderator copy(String str, String str2, String str3, long j, ModPermissions modPermissions, String str4, double d, String str5, boolean z) {
        String str6 = str;
        Intrinsics.b(str6, "username");
        String str7 = str2;
        Intrinsics.b(str7, "authorFlairText");
        String str8 = str3;
        Intrinsics.b(str8, "id");
        ModPermissions modPermissions2 = modPermissions;
        Intrinsics.b(modPermissions2, "modPermissions");
        String str9 = str4;
        Intrinsics.b(str9, "accountIcon");
        return new Moderator(str6, str7, str8, j, modPermissions2, str9, d, str5, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Moderator) {
            Moderator moderator = (Moderator) obj;
            if (Intrinsics.a(getUsername(), moderator.getUsername()) && Intrinsics.a(this.authorFlairText, moderator.authorFlairText) && Intrinsics.a(getId(), moderator.getId())) {
                if ((getAtUtc() == moderator.getAtUtc()) && Intrinsics.a(this.modPermissions, moderator.modPermissions) && Intrinsics.a(getAccountIcon(), moderator.getAccountIcon()) && Double.compare(this.postKarma, moderator.postKarma) == 0 && Intrinsics.a(getReason(), moderator.getReason())) {
                    if (this.editable == moderator.editable) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String username = getUsername();
        int i = 0;
        int hashCode = (username != null ? username.hashCode() : 0) * 31;
        String str = this.authorFlairText;
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        str = getId();
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        long atUtc = getAtUtc();
        hashCode = (hashCode + ((int) (atUtc ^ (atUtc >>> 32)))) * 31;
        ModPermissions modPermissions = this.modPermissions;
        hashCode = (hashCode + (modPermissions != null ? modPermissions.hashCode() : 0)) * 31;
        str = getAccountIcon();
        hashCode = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        atUtc = Double.doubleToLongBits(this.postKarma);
        hashCode = (hashCode + ((int) (atUtc ^ (atUtc >>> 32)))) * 31;
        str = getReason();
        if (str != null) {
            i = str.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.editable;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Moderator(username=");
        stringBuilder.append(getUsername());
        stringBuilder.append(", authorFlairText=");
        stringBuilder.append(this.authorFlairText);
        stringBuilder.append(", id=");
        stringBuilder.append(getId());
        stringBuilder.append(", atUtc=");
        stringBuilder.append(getAtUtc());
        stringBuilder.append(", modPermissions=");
        stringBuilder.append(this.modPermissions);
        stringBuilder.append(", accountIcon=");
        stringBuilder.append(getAccountIcon());
        stringBuilder.append(", postKarma=");
        stringBuilder.append(this.postKarma);
        stringBuilder.append(", reason=");
        stringBuilder.append(getReason());
        stringBuilder.append(", editable=");
        stringBuilder.append(this.editable);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Moderator(String str, String str2, String str3, long j, ModPermissions modPermissions, String str4, double d, String str5, boolean z) {
        Intrinsics.b(str, "username");
        Intrinsics.b(str2, "authorFlairText");
        Intrinsics.b(str3, "id");
        Intrinsics.b(modPermissions, "modPermissions");
        Intrinsics.b(str4, "accountIcon");
        this.username = str;
        this.authorFlairText = str2;
        this.id = str3;
        this.atUtc = j;
        this.modPermissions = modPermissions;
        this.accountIcon = str4;
        this.postKarma = d;
        this.reason = str5;
        this.editable = z;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getAuthorFlairText() {
        return this.authorFlairText;
    }

    public final String getId() {
        return this.id;
    }

    public final long getAtUtc() {
        return this.atUtc;
    }

    public final ModPermissions getModPermissions() {
        return this.modPermissions;
    }

    public final String getAccountIcon() {
        return this.accountIcon;
    }

    public final double getPostKarma() {
        return this.postKarma;
    }

    public final String getReason() {
        return this.reason;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final String getPermissionsString() {
        if (this.modPermissions.getAll()) {
            String f = Util.f(C1761R.string.mod_tools_full_permission);
            Intrinsics.a(f, "Util.getString(R.string.mod_tools_full_permission)");
            return f;
        }
        List arrayList = new ArrayList();
        for (Entry entry : MapsKt.a(new Pair[]{TuplesKt.a(Util.f(C1761R.string.mod_tools_access_permission), Boolean.valueOf(this.modPermissions.getAccess())), TuplesKt.a(Util.f(C1761R.string.mod_tools_config_permission), Boolean.valueOf(this.modPermissions.getConfig())), TuplesKt.a(Util.f(C1761R.string.mod_tools_flair_permission), Boolean.valueOf(this.modPermissions.getFlair())), TuplesKt.a(Util.f(C1761R.string.mod_tools_mail_permission), Boolean.valueOf(this.modPermissions.getMail())), TuplesKt.a(Util.f(C1761R.string.mod_tools_posts_permission), Boolean.valueOf(this.modPermissions.getPosts())), TuplesKt.a(Util.f(C1761R.string.mod_tools_wiki_permission), Boolean.valueOf(this.modPermissions.getWiki()))}).entrySet()) {
            String str = (String) entry.getKey();
            if (((Boolean) entry.getValue()).booleanValue()) {
                Intrinsics.a(str, "permissionString");
                arrayList.add(str);
            }
        }
        f = TextUtils.join(", ", arrayList);
        Intrinsics.a(f, "android.text.TextUtils.join(\", \", permissionsList)");
        return f;
    }
}
