package com.reddit.frontpage.presentation.profile.user.model;

import com.reddit.frontpage.domain.model.Trophy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/profile/user/model/UserAccountPresentationModel;", "", "karma", "", "age", "description", "trophies", "", "Lcom/reddit/frontpage/domain/model/Trophy;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAge", "()Ljava/lang/String;", "getDescription", "getKarma", "getTrophies", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserAccountPresentationModel.kt */
public final class UserAccountPresentationModel {
    public final String f20961a;
    public final String f20962b;
    public final String f20963c;
    public final List<Trophy> f20964d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UserAccountPresentationModel) {
                UserAccountPresentationModel userAccountPresentationModel = (UserAccountPresentationModel) obj;
                if (Intrinsics.m26845a(this.f20961a, userAccountPresentationModel.f20961a) && Intrinsics.m26845a(this.f20962b, userAccountPresentationModel.f20962b) && Intrinsics.m26845a(this.f20963c, userAccountPresentationModel.f20963c) && Intrinsics.m26845a(this.f20964d, userAccountPresentationModel.f20964d)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f20961a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f20962b;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f20963c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List list = this.f20964d;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserAccountPresentationModel(karma=");
        stringBuilder.append(this.f20961a);
        stringBuilder.append(", age=");
        stringBuilder.append(this.f20962b);
        stringBuilder.append(", description=");
        stringBuilder.append(this.f20963c);
        stringBuilder.append(", trophies=");
        stringBuilder.append(this.f20964d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public UserAccountPresentationModel(String str, String str2, String str3, List<Trophy> list) {
        Intrinsics.m26847b(str, "karma");
        Intrinsics.m26847b(str2, "age");
        Intrinsics.m26847b(str3, "description");
        Intrinsics.m26847b(list, "trophies");
        this.f20961a = str;
        this.f20962b = str2;
        this.f20963c = str3;
        this.f20964d = list;
    }
}
