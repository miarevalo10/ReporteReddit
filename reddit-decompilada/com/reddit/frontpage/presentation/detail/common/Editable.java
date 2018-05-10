package com.reddit.frontpage.presentation.detail.common;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/common/Editable;", "T", "Lpaperparcel/PaperParcelable;", "()V", "model", "getModel", "()Ljava/lang/Object;", "Lcom/reddit/frontpage/presentation/detail/common/Link;", "Lcom/reddit/frontpage/presentation/detail/common/Comment;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Editable.kt */
public abstract class Editable<T> implements PaperParcelable {
    public int describeContents() {
        return 0;
    }

    private Editable() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }
}
