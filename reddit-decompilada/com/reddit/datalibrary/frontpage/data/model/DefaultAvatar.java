package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/DefaultAvatar;", "", "iconImg", "", "(Ljava/lang/String;)V", "getIconImg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DefaultAvatar.kt */
public final class DefaultAvatar {
    @Json(a = "icon_img")
    private final String iconImg;

    public static /* synthetic */ DefaultAvatar copy$default(DefaultAvatar defaultAvatar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = defaultAvatar.iconImg;
        }
        return defaultAvatar.copy(str);
    }

    public final String component1() {
        return this.iconImg;
    }

    public final DefaultAvatar copy(String str) {
        Intrinsics.b(str, "iconImg");
        return new DefaultAvatar(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof DefaultAvatar) {
                if (Intrinsics.a(this.iconImg, ((DefaultAvatar) obj).iconImg)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.iconImg;
        return str != null ? str.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DefaultAvatar(iconImg=");
        stringBuilder.append(this.iconImg);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public DefaultAvatar(String str) {
        Intrinsics.b(str, "iconImg");
        this.iconImg = str;
    }

    public final String getIconImg() {
        return this.iconImg;
    }
}
