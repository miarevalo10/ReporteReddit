package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcel;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.util.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcelable;
import paperparcel.PaperParcelable.DefaultImpls;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0013\b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "Lpaperparcel/PaperParcelable;", "carouselStatePreferenceKey", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "(Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;)V", "getCarouselStatePreferenceKey", "()Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "discoveryUnit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "getDiscoveryUnit", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "numItems", "", "getNumItems", "()I", "Companion", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeneralCarouselCollectionPresentationModel.kt */
public abstract class CarouselCollectionPresentationModel implements Listable, PaperParcelable {
    public static final Companion f33781a = new Companion();
    private final CarouselCollectionStateKey f33782b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel$Companion;", "", "()V", "newKarmaCarousel", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "items", "", "Lcom/reddit/frontpage/ui/carousel/KarmaCarouselItemPresentationModel;", "uniqueId", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeneralCarouselCollectionPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ CarouselCollectionPresentationModel m22682a(List list) {
            Intrinsics.m26847b(list, "items");
            Object f = Util.m24027f((int) C1761R.string.active_communities_banner);
            Intrinsics.m26843a(f, "Util.getString(R.string.active_communities_banner)");
            return new GeneralCarouselCollectionPresentationModel(f, list, "");
        }
    }

    public abstract DiscoveryUnit mo6934a();

    public abstract int mo6935b();

    public int describeContents() {
        return 0;
    }

    public int getMinAndroidVersion() {
        return 0;
    }

    private CarouselCollectionPresentationModel() {
        this.f33782b = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.m26847b(parcel, "dest");
        DefaultImpls.writeToParcel(this, parcel, i);
    }
}
