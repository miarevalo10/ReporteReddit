package com.reddit.frontpage.domain.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/domain/model/Multireddit;", "", "name", "", "isEditable", "", "path", "iconUrl", "keyColor", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "()Z", "getKeyColor", "getName", "getPath", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Multireddit.kt */
public final class Multireddit {
    @Json(a = "icon_url")
    private final String iconUrl;
    @Json(a = "can_edit")
    private final boolean isEditable;
    @Json(a = "key_color")
    private final String keyColor;
    private final String name;
    private final String path;

    public static /* synthetic */ Multireddit copy$default(Multireddit multireddit, String str, boolean z, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = multireddit.name;
        }
        if ((i & 2) != 0) {
            z = multireddit.isEditable;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = multireddit.path;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = multireddit.iconUrl;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = multireddit.keyColor;
        }
        return multireddit.copy(str, z2, str5, str6, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.isEditable;
    }

    public final String component3() {
        return this.path;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final String component5() {
        return this.keyColor;
    }

    public final Multireddit copy(String str, boolean z, String str2, String str3, String str4) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "path");
        return new Multireddit(str, z, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Multireddit) {
            Multireddit multireddit = (Multireddit) obj;
            if (Intrinsics.m26845a(this.name, multireddit.name)) {
                return (this.isEditable == multireddit.isEditable) && Intrinsics.m26845a(this.path, multireddit.path) && Intrinsics.m26845a(this.iconUrl, multireddit.iconUrl) && Intrinsics.m26845a(this.keyColor, multireddit.keyColor);
            }
        }
    }

    public final int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        int i2 = this.isEditable;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        String str2 = this.path;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.iconUrl;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.keyColor;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Multireddit(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", isEditable=");
        stringBuilder.append(this.isEditable);
        stringBuilder.append(", path=");
        stringBuilder.append(this.path);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", keyColor=");
        stringBuilder.append(this.keyColor);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Multireddit(String str, boolean z, String str2, String str3, String str4) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(str2, "path");
        this.name = str;
        this.isEditable = z;
        this.path = str2;
        this.iconUrl = str3;
        this.keyColor = str4;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isEditable() {
        return this.isEditable;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getKeyColor() {
        return this.keyColor;
    }
}
