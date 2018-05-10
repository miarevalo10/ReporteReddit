package com.reddit.frontpage.presentation.viewmode;

import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.ui.BaseScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/viewmode/ViewModeOptionSelection;", "", "screen", "Lcom/reddit/frontpage/ui/BaseScreen;", "mode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "(Lcom/reddit/frontpage/ui/BaseScreen;Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)V", "getMode", "()Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getScreen", "()Lcom/reddit/frontpage/ui/BaseScreen;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ViewModeOptionSelection.kt */
public final class ViewModeOptionSelection {
    public final BaseScreen f20997a;
    public final ListingViewMode f20998b;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ViewModeOptionSelection) {
                ViewModeOptionSelection viewModeOptionSelection = (ViewModeOptionSelection) obj;
                if (Intrinsics.m26845a(this.f20997a, viewModeOptionSelection.f20997a) && Intrinsics.m26845a(this.f20998b, viewModeOptionSelection.f20998b)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        BaseScreen baseScreen = this.f20997a;
        int i = 0;
        int hashCode = (baseScreen != null ? baseScreen.hashCode() : 0) * 31;
        ListingViewMode listingViewMode = this.f20998b;
        if (listingViewMode != null) {
            i = listingViewMode.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewModeOptionSelection(screen=");
        stringBuilder.append(this.f20997a);
        stringBuilder.append(", mode=");
        stringBuilder.append(this.f20998b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public ViewModeOptionSelection(BaseScreen baseScreen, ListingViewMode listingViewMode) {
        Intrinsics.m26847b(baseScreen, "screen");
        Intrinsics.m26847b(listingViewMode, "mode");
        this.f20997a = baseScreen;
        this.f20998b = listingViewMode;
    }
}
