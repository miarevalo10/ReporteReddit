package com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJB\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanInfoModel;", "", "username", "", "banReason", "modNote", "banMessage", "duration", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getBanMessage", "()Ljava/lang/String;", "getBanReason", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getModNote", "getUsername", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/BanInfoModel;", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BanInfoModel.kt */
public final class BanInfoModel {
    public final String f20891a;
    public final String f20892b;
    public final String f20893c;
    public final String f20894d;
    public final Long f20895e;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BanInfoModel) {
                BanInfoModel banInfoModel = (BanInfoModel) obj;
                if (Intrinsics.m26845a(this.f20891a, banInfoModel.f20891a) && Intrinsics.m26845a(this.f20892b, banInfoModel.f20892b) && Intrinsics.m26845a(this.f20893c, banInfoModel.f20893c) && Intrinsics.m26845a(this.f20894d, banInfoModel.f20894d) && Intrinsics.m26845a(this.f20895e, banInfoModel.f20895e)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f20891a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f20892b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f20893c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f20894d;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.f20895e;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("BanInfoModel(username=");
        stringBuilder.append(this.f20891a);
        stringBuilder.append(", banReason=");
        stringBuilder.append(this.f20892b);
        stringBuilder.append(", modNote=");
        stringBuilder.append(this.f20893c);
        stringBuilder.append(", banMessage=");
        stringBuilder.append(this.f20894d);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.f20895e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public BanInfoModel(String str, String str2, String str3, String str4, Long l) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(str2, "banReason");
        Intrinsics.m26847b(str3, "modNote");
        Intrinsics.m26847b(str4, "banMessage");
        this.f20891a = str;
        this.f20892b = str2;
        this.f20893c = str3;
        this.f20894d = str4;
        this.f20895e = l;
    }
}
