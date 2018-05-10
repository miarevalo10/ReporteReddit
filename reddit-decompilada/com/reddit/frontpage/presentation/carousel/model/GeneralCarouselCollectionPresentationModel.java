package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;

@PaperParcel
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0005\b\b\u0018\u0000 :*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003:\u0001:Be\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0012HÆ\u0003J}\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\b\u00107\u001a\u00020\rH\u0016J\t\u00108\u001a\u00020\u0010HÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "T", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "title", "", "hasDescription", "", "hasMetadata", "items", "", "carouselId", "uniqueId", "", "showTitle", "listableType", "", "discoveryUnit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "carouselStatePreferenceKey", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "(Ljava/lang/String;ZZLjava/util/List;Ljava/lang/String;JZILcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;)V", "getCarouselId", "()Ljava/lang/String;", "getCarouselStatePreferenceKey", "()Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "getDiscoveryUnit", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "getHasDescription", "()Z", "getHasMetadata", "getItems", "()Ljava/util/List;", "getListableType", "()I", "numItems", "getNumItems", "getShowTitle", "getTitle", "getUniqueId", "()J", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getUniqueID", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeneralCarouselCollectionPresentationModel.kt */
public final class GeneralCarouselCollectionPresentationModel<T extends ICarouselItemPresentationModel> extends CarouselCollectionPresentationModel {
    public static final Creator<GeneralCarouselCollectionPresentationModel<ICarouselItemPresentationModel>> CREATOR = PaperParcelGeneralCarouselCollectionPresentationModel.f20351e;
    public static final Companion f36353k = new Companion();
    public final String f36354b;
    final boolean f36355c;
    final boolean f36356d;
    public final List<T> f36357e;
    public final String f36358f;
    public final long f36359g;
    public final boolean f36360h;
    public final DiscoveryUnit f36361i;
    public final CarouselCollectionStateKey f36362j;
    private final int f36363l;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006 \u0007*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0005¨\u0006\u00010\u0005¨\u0006\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/carousel/model/GeneralCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeneralCarouselCollectionPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int getListableType() {
        return this.f36363l;
    }

    public final DiscoveryUnit mo6934a() {
        return this.f36361i;
    }

    public GeneralCarouselCollectionPresentationModel(String str, boolean z, boolean z2, List<? extends T> list, String str2, long j, boolean z3, int i, DiscoveryUnit discoveryUnit, CarouselCollectionStateKey carouselCollectionStateKey) {
        Intrinsics.m26847b(str, "title");
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(str2, "carouselId");
        super();
        this.f36354b = str;
        this.f36355c = z;
        this.f36356d = z2;
        this.f36357e = list;
        this.f36358f = str2;
        this.f36359g = j;
        this.f36360h = z3;
        this.f36363l = i;
        this.f36361i = discoveryUnit;
        this.f36362j = carouselCollectionStateKey;
    }

    public final long getUniqueID() {
        return this.f36359g;
    }

    public final int mo6935b() {
        return this.f36357e.size();
    }

    public static /* synthetic */ GeneralCarouselCollectionPresentationModel m36772a(GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel, List list) {
        String str = generalCarouselCollectionPresentationModel.f36354b;
        boolean z = generalCarouselCollectionPresentationModel.f36355c;
        boolean z2 = generalCarouselCollectionPresentationModel.f36356d;
        String str2 = generalCarouselCollectionPresentationModel.f36358f;
        long j = generalCarouselCollectionPresentationModel.f36359g;
        boolean z3 = generalCarouselCollectionPresentationModel.f36360h;
        int listableType = generalCarouselCollectionPresentationModel.getListableType();
        DiscoveryUnit discoveryUnit = generalCarouselCollectionPresentationModel.f36361i;
        CarouselCollectionStateKey carouselCollectionStateKey = generalCarouselCollectionPresentationModel.f36362j;
        Intrinsics.m26847b(str, "title");
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(str2, "carouselId");
        return new GeneralCarouselCollectionPresentationModel(str, z, z2, list, str2, j, z3, listableType, discoveryUnit, carouselCollectionStateKey);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GeneralCarouselCollectionPresentationModel(title=");
        stringBuilder.append(this.f36354b);
        stringBuilder.append(", hasDescription=");
        stringBuilder.append(this.f36355c);
        stringBuilder.append(", hasMetadata=");
        stringBuilder.append(this.f36356d);
        stringBuilder.append(", items=");
        stringBuilder.append(this.f36357e);
        stringBuilder.append(", carouselId=");
        stringBuilder.append(this.f36358f);
        stringBuilder.append(", uniqueId=");
        stringBuilder.append(this.f36359g);
        stringBuilder.append(", showTitle=");
        stringBuilder.append(this.f36360h);
        stringBuilder.append(", listableType=");
        stringBuilder.append(getListableType());
        stringBuilder.append(", discoveryUnit=");
        stringBuilder.append(this.f36361i);
        stringBuilder.append(", carouselStatePreferenceKey=");
        stringBuilder.append(this.f36362j);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f36354b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        int i2 = this.f36355c;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f36356d;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        List list = this.f36357e;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f36358f;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.f36359g;
        hashCode = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        i2 = this.f36360h;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (((hashCode + i2) * 31) + getListableType()) * 31;
        DiscoveryUnit discoveryUnit = this.f36361i;
        hashCode = (hashCode + (discoveryUnit != null ? discoveryUnit.hashCode() : 0)) * 31;
        CarouselCollectionStateKey carouselCollectionStateKey = this.f36362j;
        if (carouselCollectionStateKey != null) {
            i = carouselCollectionStateKey.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GeneralCarouselCollectionPresentationModel) {
                GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = (GeneralCarouselCollectionPresentationModel) obj;
                if (Intrinsics.m26845a(this.f36354b, generalCarouselCollectionPresentationModel.f36354b)) {
                    if (this.f36355c == generalCarouselCollectionPresentationModel.f36355c) {
                        if ((this.f36356d == generalCarouselCollectionPresentationModel.f36356d) && Intrinsics.m26845a(this.f36357e, generalCarouselCollectionPresentationModel.f36357e) && Intrinsics.m26845a(this.f36358f, generalCarouselCollectionPresentationModel.f36358f)) {
                            if (this.f36359g == generalCarouselCollectionPresentationModel.f36359g) {
                                if (this.f36360h == generalCarouselCollectionPresentationModel.f36360h) {
                                    if ((getListableType() == generalCarouselCollectionPresentationModel.getListableType()) && Intrinsics.m26845a(this.f36361i, generalCarouselCollectionPresentationModel.f36361i) && Intrinsics.m26845a(this.f36362j, generalCarouselCollectionPresentationModel.f36362j) != null) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }
}
