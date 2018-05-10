package com.reddit.datalibrary.frontpage.data.feature.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ<\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/settings/NotificationSettings;", "", "enabled", "", "soundEnabled", "badgeEnabled", "overrideDnd", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBadgeEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnabled", "()Z", "getOverrideDnd", "getSoundEnabled", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/reddit/datalibrary/frontpage/data/feature/settings/NotificationSettings;", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: NotificationSettings.kt */
public final class NotificationSettings {
    public final boolean f10764a;
    public final Boolean f10765b;
    public final Boolean f10766c;
    public final Boolean f10767d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NotificationSettings) {
            NotificationSettings notificationSettings = (NotificationSettings) obj;
            return (this.f10764a == notificationSettings.f10764a) && Intrinsics.a(this.f10765b, notificationSettings.f10765b) && Intrinsics.a(this.f10766c, notificationSettings.f10766c) && Intrinsics.a(this.f10767d, notificationSettings.f10767d);
        }
    }

    public final int hashCode() {
        int i = this.f10764a;
        if (i != 0) {
            i = 1;
        }
        i *= 31;
        Boolean bool = this.f10765b;
        int i2 = 0;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.f10766c;
        i = (i + (bool != null ? bool.hashCode() : 0)) * 31;
        bool = this.f10767d;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return i + i2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NotificationSettings(enabled=");
        stringBuilder.append(this.f10764a);
        stringBuilder.append(", soundEnabled=");
        stringBuilder.append(this.f10765b);
        stringBuilder.append(", badgeEnabled=");
        stringBuilder.append(this.f10766c);
        stringBuilder.append(", overrideDnd=");
        stringBuilder.append(this.f10767d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public NotificationSettings(boolean z, Boolean bool, Boolean bool2, Boolean bool3) {
        this.f10764a = z;
        this.f10765b = bool;
        this.f10766c = bool2;
        this.f10767d = bool3;
    }
}
