package com.reddit.frontpage.presentation.listing.carousel;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "Lpaperparcel/PaperParcelable;", "dismissedItems", "", "", "(Ljava/util/Set;)V", "getDismissedItems", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "isItemDismissed", "id", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: CarouselCollectionState.kt */
public final class CarouselCollectionState implements PaperParcelable {
    public static final Creator<CarouselCollectionState> CREATOR = PaperParcelCarouselCollectionState.f20567b;
    public static final Companion Companion = new Companion();
    private static final CarouselCollectionState INITIAL_STATE = new CarouselCollectionState(null, 1, null);
    private final Set<String> dismissedItems;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "kotlin.jvm.PlatformType", "INITIAL_STATE", "getINITIAL_STATE", "()Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CarouselCollectionState.kt */
    public static final class Companion {
        private Companion() {
        }

        public static CarouselCollectionState m22869a() {
            return CarouselCollectionState.INITIAL_STATE;
        }
    }

    public CarouselCollectionState() {
        this(null, 1, null);
    }

    public static /* synthetic */ CarouselCollectionState copy$default(CarouselCollectionState carouselCollectionState, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = carouselCollectionState.dismissedItems;
        }
        return carouselCollectionState.copy(set);
    }

    public final Set<String> component1() {
        return this.dismissedItems;
    }

    public final CarouselCollectionState copy(Set<String> set) {
        Intrinsics.m26847b(set, "dismissedItems");
        return new CarouselCollectionState(set);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CarouselCollectionState) {
                if (Intrinsics.m26845a(this.dismissedItems, ((CarouselCollectionState) obj).dismissedItems)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Set set = this.dismissedItems;
        return set != null ? set.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CarouselCollectionState(dismissedItems=");
        stringBuilder.append(this.dismissedItems);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CarouselCollectionState(Set<String> set) {
        Intrinsics.m26847b(set, "dismissedItems");
        this.dismissedItems = set;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }

    public /* synthetic */ CarouselCollectionState(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        this(set);
    }

    public final Set<String> getDismissedItems() {
        return this.dismissedItems;
    }

    public final boolean isItemDismissed(String str) {
        Intrinsics.m26847b(str, "id");
        return this.dismissedItems.contains(str);
    }
}
