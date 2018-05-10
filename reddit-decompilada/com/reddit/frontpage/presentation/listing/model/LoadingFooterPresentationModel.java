package com.reddit.frontpage.presentation.listing.model;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/model/LoadingFooterPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "state", "Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "errorMessage", "", "(Lcom/reddit/frontpage/presentation/listing/model/FooterState;Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "listableType", "", "getListableType", "()I", "getState", "()Lcom/reddit/frontpage/presentation/listing/model/FooterState;", "component1", "component2", "copy", "equals", "", "other", "", "getUniqueID", "", "hashCode", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoadingFooterPresentationModel.kt */
public final class LoadingFooterPresentationModel implements Listable {
    public final FooterState f34003a;
    public final String f34004b;

    public LoadingFooterPresentationModel() {
        this(null, 3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LoadingFooterPresentationModel) {
                LoadingFooterPresentationModel loadingFooterPresentationModel = (LoadingFooterPresentationModel) obj;
                if (Intrinsics.m26845a(this.f34003a, loadingFooterPresentationModel.f34003a) && Intrinsics.m26845a(this.f34004b, loadingFooterPresentationModel.f34004b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int getListableType() {
        return 8;
    }

    public final int getMinAndroidVersion() {
        return 0;
    }

    public final long getUniqueID() {
        return Long.MAX_VALUE;
    }

    public final int hashCode() {
        FooterState footerState = this.f34003a;
        int i = 0;
        int hashCode = (footerState != null ? footerState.hashCode() : 0) * 31;
        String str = this.f34004b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LoadingFooterPresentationModel(state=");
        stringBuilder.append(this.f34003a);
        stringBuilder.append(", errorMessage=");
        stringBuilder.append(this.f34004b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public LoadingFooterPresentationModel(FooterState footerState, String str) {
        Intrinsics.m26847b(footerState, "state");
        this.f34003a = footerState;
        this.f34004b = str;
        if (Intrinsics.m26845a(this.f34003a, FooterState.ERROR) != null && this.f34004b == null) {
            throw ((Throwable) new IllegalStateException("Error message can't be null when using FooterState.ERROR"));
        }
    }

    public /* synthetic */ LoadingFooterPresentationModel(FooterState footerState, int i) {
        if ((i & 1) != 0) {
            footerState = FooterState.NONE;
        }
        this(footerState, (String) 0);
    }
}
