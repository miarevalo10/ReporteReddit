package com.reddit.frontpage.presentation.listing.common;

import android.support.v7.util.DiffUtil.DiffResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/ViewDiffResult;", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "(Landroid/support/v7/util/DiffUtil$DiffResult;)V", "getDiff", "()Landroid/support/v7/util/DiffUtil$DiffResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingView.kt */
public final class ViewDiffResult {
    public final DiffResult f20594a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ViewDiffResult) {
                if (Intrinsics.m26845a(this.f20594a, ((ViewDiffResult) obj).f20594a)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        DiffResult diffResult = this.f20594a;
        return diffResult != null ? diffResult.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewDiffResult(diff=");
        stringBuilder.append(this.f20594a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ViewDiffResult(DiffResult diffResult) {
        Intrinsics.m26847b(diffResult, "diff");
        this.f20594a = diffResult;
    }
}
