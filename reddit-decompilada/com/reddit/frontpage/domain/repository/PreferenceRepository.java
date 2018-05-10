package com.reddit.frontpage.domain.repository;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;
import paperparcel.PaperParcelable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001$J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\tH&J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\n\u001a\u00020\u000fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\tH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\fH&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000eH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0011H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\tH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0014H&J$\u0010!\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0#H&¨\u0006%"}, d2 = {"Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "", "addReadLinkId", "Lio/reactivex/Completable;", "linkKindWithId", "", "clearReadLinkIds", "get", "Lio/reactivex/Single;", "", "key", "default", "", "getCarouselCollectionState", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "getGeopopularRegionFilter", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "getReadLinkIds", "getViewModeOption", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "save", "value", "setCarouselCollectionState", "state", "setGeopopularRegionFilter", "filter", "setGlobalViewModeOption", "isCompact", "setOver18", "isOver18", "setViewModeOption", "mode", "updateCarouselCollectionState", "action", "Lkotlin/Function1;", "CarouselCollectionStateKey", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: PreferenceRepository.kt */
public interface PreferenceRepository {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: PreferenceRepository.kt */
    public static final class DefaultImpls {
    }

    @PaperParcel
    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "Lpaperparcel/PaperParcelable;", "surface", "", "uniqueId", "customKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomKey", "()Ljava/lang/String;", "getSurface", "getUniqueId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: PreferenceRepository.kt */
    public static final class CarouselCollectionStateKey implements PaperParcelable {
        public static final Creator<CarouselCollectionStateKey> CREATOR = PaperParcelPreferenceRepository_CarouselCollectionStateKey.f20259a;
        public static final Companion f27953d = new Companion();
        final String f27954a;
        final String f27955b;
        final String f27956c;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "kotlin.jvm.PlatformType", "from", "unit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "customKey", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
        /* compiled from: PreferenceRepository.kt */
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ CarouselCollectionStateKey m22464a(DiscoveryUnit discoveryUnit) {
                String str = "";
                Intrinsics.m26847b(discoveryUnit, "unit");
                Intrinsics.m26847b(str, "customKey");
                return new CarouselCollectionStateKey(discoveryUnit.surface, discoveryUnit.unique_id, str);
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof CarouselCollectionStateKey) {
                    CarouselCollectionStateKey carouselCollectionStateKey = (CarouselCollectionStateKey) obj;
                    if (Intrinsics.m26845a(this.f27954a, carouselCollectionStateKey.f27954a) && Intrinsics.m26845a(this.f27955b, carouselCollectionStateKey.f27955b) && Intrinsics.m26845a(this.f27956c, carouselCollectionStateKey.f27956c)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f27954a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f27955b;
            hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            str2 = this.f27956c;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public CarouselCollectionStateKey(String str, String str2, String str3) {
            Intrinsics.m26847b(str, "surface");
            Intrinsics.m26847b(str2, "uniqueId");
            Intrinsics.m26847b(str3, "customKey");
            this.f27954a = str;
            this.f27955b = str2;
            this.f27956c = str3;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            Intrinsics.m26847b(parcel, "dest");
            paperparcel.PaperParcelable.DefaultImpls.writeToParcel(this, parcel, i);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f27954a);
            stringBuilder.append('-');
            stringBuilder.append(this.f27955b);
            stringBuilder.append('-');
            stringBuilder.append(this.f27956c);
            return stringBuilder.toString();
        }
    }

    Completable m22466a(CarouselCollectionStateKey carouselCollectionStateKey, Function1<? super CarouselCollectionState, CarouselCollectionState> function1);

    Completable m22467a(GeopopularRegionSelectFilter geopopularRegionSelectFilter);

    Completable m22468a(String str);

    Completable m22469a(String str, int i);

    Completable m22470a(String str, ListingViewMode listingViewMode);

    Completable m22471a(boolean z);

    Single<GeopopularRegionSelectFilter> m22472a();

    Single<CarouselCollectionState> m22473a(CarouselCollectionStateKey carouselCollectionStateKey);

    Single<String> m22474b();

    Single<Boolean> m22475b(String str);

    Single<Integer> m22476b(String str, int i);

    Single<ListingViewMode> m22477b(String str, ListingViewMode listingViewMode);

    Completable m22478c();

    Completable m22479c(String str);
}
