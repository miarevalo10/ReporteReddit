package com.reddit.frontpage.presentation.accounts.model;

import android.content.res.Resources;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.Avatar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "", "name", "", "avatar", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "isActive", "", "(Ljava/lang/String;Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;Z)V", "getAvatar", "()Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$Avatar;", "()Z", "setActive", "(Z)V", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "getPrefixedName", "resources", "Landroid/content/res/Resources;", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountPresentationModel.kt */
public final class AccountPresentationModel {
    public final String f20320a;
    public final Avatar f20321b;
    public boolean f20322c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccountPresentationModel) {
            AccountPresentationModel accountPresentationModel = (AccountPresentationModel) obj;
            if (Intrinsics.m26845a(this.f20320a, accountPresentationModel.f20320a) && Intrinsics.m26845a(this.f20321b, accountPresentationModel.f20321b)) {
                if (this.f20322c == accountPresentationModel.f20322c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f20320a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Avatar avatar = this.f20321b;
        if (avatar != null) {
            i = avatar.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.f20322c;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AccountPresentationModel(name=");
        stringBuilder.append(this.f20320a);
        stringBuilder.append(", avatar=");
        stringBuilder.append(this.f20321b);
        stringBuilder.append(", isActive=");
        stringBuilder.append(this.f20322c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AccountPresentationModel(String str, Avatar avatar, boolean z) {
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(avatar, "avatar");
        this.f20320a = str;
        this.f20321b = avatar;
        this.f20322c = z;
    }

    public final String m22642a(Resources resources) {
        Intrinsics.m26847b(resources, "resources");
        Object string = resources.getString(C1761R.string.fmt_u_name, new Object[]{this.f20320a});
        Intrinsics.m26843a(string, "resources.getString(R.string.fmt_u_name, name)");
        return string;
    }
}
