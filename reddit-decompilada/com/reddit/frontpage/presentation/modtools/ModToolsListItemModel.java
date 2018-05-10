package com.reddit.frontpage.presentation.modtools;

import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;", "", "index", "", "userModel", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "(ILcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;)V", "getIndex", "()I", "getUserModel", "()Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsListItemModel.kt */
public final class ModToolsListItemModel {
    public final int f20858a;
    public final ModToolsUserModel f20859b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ModToolsListItemModel) {
            ModToolsListItemModel modToolsListItemModel = (ModToolsListItemModel) obj;
            return (this.f20858a == modToolsListItemModel.f20858a) && Intrinsics.m26845a(this.f20859b, modToolsListItemModel.f20859b);
        }
    }

    public final int hashCode() {
        int i = this.f20858a * 31;
        ModToolsUserModel modToolsUserModel = this.f20859b;
        return i + (modToolsUserModel != null ? modToolsUserModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ModToolsListItemModel(index=");
        stringBuilder.append(this.f20858a);
        stringBuilder.append(", userModel=");
        stringBuilder.append(this.f20859b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ModToolsListItemModel(int i, ModToolsUserModel modToolsUserModel) {
        Intrinsics.m26847b(modToolsUserModel, "userModel");
        this.f20858a = i;
        this.f20859b = modToolsUserModel;
    }
}
