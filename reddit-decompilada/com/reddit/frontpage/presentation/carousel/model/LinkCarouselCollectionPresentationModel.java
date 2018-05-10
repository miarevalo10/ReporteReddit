package com.reddit.frontpage.presentation.carousel.model;

import android.os.Parcelable.Creator;
import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import paperparcel.PaperParcel;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0005\b\b\u0018\u0000 M2\u00020\u0001:\u0001MB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0013HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0016HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00101J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\fHÆ\u0003J\t\u0010D\u001a\u00020\fHÆ\u0003J°\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\b\u0010J\u001a\u00020\u0013H\u0016J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0014\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010.R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006N"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "title", "", "subtitle", "subtitleIcon", "", "subredditName", "subredditMetadata", "subredditDescription", "subredditIconUrl", "subredditInitiallySubscribed", "", "subredditSubscribed", "items", "", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "carouselId", "uniqueId", "", "listableType", "discoveryUnit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "carouselStatePreferenceKey", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/String;JILcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;)V", "getCarouselId", "()Ljava/lang/String;", "getCarouselStatePreferenceKey", "()Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "getDiscoveryUnit", "()Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "getItems", "()Ljava/util/List;", "getListableType", "()I", "numItems", "getNumItems", "getSubredditDescription", "getSubredditIconUrl", "getSubredditInitiallySubscribed", "()Z", "getSubredditMetadata", "getSubredditName", "getSubredditSubscribed", "setSubredditSubscribed", "(Z)V", "getSubtitle", "getSubtitleIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getUniqueId", "()J", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/String;JILcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;)Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "equals", "other", "", "getUniqueID", "hashCode", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
@PaperParcel
/* compiled from: GeneralCarouselCollectionPresentationModel.kt */
public final class LinkCarouselCollectionPresentationModel extends CarouselCollectionPresentationModel {
    public static final Creator<LinkCarouselCollectionPresentationModel> CREATOR = PaperParcelLinkCarouselCollectionPresentationModel.f20356e;
    public static final Companion f36364p = new Companion();
    public final String f36365b;
    public final String f36366c;
    public final Integer f36367d;
    public final String f36368e;
    public final String f36369f;
    public final String f36370g;
    public final String f36371h;
    public final boolean f36372i;
    public boolean f36373j;
    public final List<LinkCarouselItemPresentationModel> f36374k;
    public final String f36375l;
    public final long f36376m;
    public final DiscoveryUnit f36377n;
    final CarouselCollectionStateKey f36378o;
    private final int f36379q;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "kotlin.jvm.PlatformType", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeneralCarouselCollectionPresentationModel.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final int getListableType() {
        return this.f36379q;
    }

    public final DiscoveryUnit mo6934a() {
        return this.f36377n;
    }

    public LinkCarouselCollectionPresentationModel(String str, String str2, Integer num, String str3, String str4, String str5, String str6, boolean z, boolean z2, List<LinkCarouselItemPresentationModel> list, String str7, long j, int i, DiscoveryUnit discoveryUnit, CarouselCollectionStateKey carouselCollectionStateKey) {
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        String str12 = str5;
        List<LinkCarouselItemPresentationModel> list2 = list;
        String str13 = str7;
        DiscoveryUnit discoveryUnit2 = discoveryUnit;
        Intrinsics.m26847b(str8, "title");
        Intrinsics.m26847b(str9, "subtitle");
        Intrinsics.m26847b(str10, "subredditName");
        Intrinsics.m26847b(str11, "subredditMetadata");
        Intrinsics.m26847b(str12, "subredditDescription");
        Intrinsics.m26847b(list2, "items");
        Intrinsics.m26847b(str13, "carouselId");
        Intrinsics.m26847b(discoveryUnit2, "discoveryUnit");
        super();
        this.f36365b = str8;
        this.f36366c = str9;
        this.f36367d = num;
        this.f36368e = str10;
        this.f36369f = str11;
        this.f36370g = str12;
        this.f36371h = str6;
        this.f36372i = z;
        this.f36373j = z2;
        this.f36374k = list2;
        this.f36375l = str13;
        this.f36376m = j;
        this.f36379q = i;
        this.f36377n = discoveryUnit2;
        this.f36378o = carouselCollectionStateKey;
    }

    public final long getUniqueID() {
        return this.f36376m;
    }

    public final int mo6935b() {
        return this.f36374k.size();
    }

    public static /* synthetic */ LinkCarouselCollectionPresentationModel m36775a(LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel) {
        LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel2 = linkCarouselCollectionPresentationModel;
        String str = linkCarouselCollectionPresentationModel2.f36365b;
        String str2 = linkCarouselCollectionPresentationModel2.f36366c;
        Integer num = linkCarouselCollectionPresentationModel2.f36367d;
        String str3 = linkCarouselCollectionPresentationModel2.f36368e;
        String str4 = linkCarouselCollectionPresentationModel2.f36369f;
        String str5 = linkCarouselCollectionPresentationModel2.f36370g;
        String str6 = linkCarouselCollectionPresentationModel2.f36371h;
        boolean z = linkCarouselCollectionPresentationModel2.f36372i;
        List list = linkCarouselCollectionPresentationModel2.f36374k;
        String str7 = linkCarouselCollectionPresentationModel2.f36375l;
        long j = linkCarouselCollectionPresentationModel2.f36376m;
        int listableType = linkCarouselCollectionPresentationModel.getListableType();
        DiscoveryUnit discoveryUnit = linkCarouselCollectionPresentationModel2.f36377n;
        CarouselCollectionStateKey carouselCollectionStateKey = linkCarouselCollectionPresentationModel2.f36378o;
        Intrinsics.m26847b(str, "title");
        Intrinsics.m26847b(str2, "subtitle");
        Intrinsics.m26847b(str3, "subredditName");
        Intrinsics.m26847b(str4, "subredditMetadata");
        Intrinsics.m26847b(str5, "subredditDescription");
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(str7, "carouselId");
        Intrinsics.m26847b(discoveryUnit, "discoveryUnit");
        return new LinkCarouselCollectionPresentationModel(str, str2, num, str3, str4, str5, str6, z, true, list, str7, j, listableType, discoveryUnit, carouselCollectionStateKey);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkCarouselCollectionPresentationModel(title=");
        stringBuilder.append(this.f36365b);
        stringBuilder.append(", subtitle=");
        stringBuilder.append(this.f36366c);
        stringBuilder.append(", subtitleIcon=");
        stringBuilder.append(this.f36367d);
        stringBuilder.append(", subredditName=");
        stringBuilder.append(this.f36368e);
        stringBuilder.append(", subredditMetadata=");
        stringBuilder.append(this.f36369f);
        stringBuilder.append(", subredditDescription=");
        stringBuilder.append(this.f36370g);
        stringBuilder.append(", subredditIconUrl=");
        stringBuilder.append(this.f36371h);
        stringBuilder.append(", subredditInitiallySubscribed=");
        stringBuilder.append(this.f36372i);
        stringBuilder.append(", subredditSubscribed=");
        stringBuilder.append(this.f36373j);
        stringBuilder.append(", items=");
        stringBuilder.append(this.f36374k);
        stringBuilder.append(", carouselId=");
        stringBuilder.append(this.f36375l);
        stringBuilder.append(", uniqueId=");
        stringBuilder.append(this.f36376m);
        stringBuilder.append(", listableType=");
        stringBuilder.append(getListableType());
        stringBuilder.append(", discoveryUnit=");
        stringBuilder.append(this.f36377n);
        stringBuilder.append(", carouselStatePreferenceKey=");
        stringBuilder.append(this.f36378o);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final int hashCode() {
        String str = this.f36365b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f36366c;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.f36367d;
        hashCode = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        str2 = this.f36368e;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f36369f;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f36370g;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        str2 = this.f36371h;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i2 = this.f36372i;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        i2 = this.f36373j;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        List list = this.f36374k;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        str2 = this.f36375l;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.f36376m;
        hashCode = (((hashCode + ((int) (j ^ (j >>> 32)))) * 31) + getListableType()) * 31;
        DiscoveryUnit discoveryUnit = this.f36377n;
        hashCode = (hashCode + (discoveryUnit != null ? discoveryUnit.hashCode() : 0)) * 31;
        CarouselCollectionStateKey carouselCollectionStateKey = this.f36378o;
        if (carouselCollectionStateKey != null) {
            i = carouselCollectionStateKey.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LinkCarouselCollectionPresentationModel) {
                LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel = (LinkCarouselCollectionPresentationModel) obj;
                if (Intrinsics.m26845a(this.f36365b, linkCarouselCollectionPresentationModel.f36365b) && Intrinsics.m26845a(this.f36366c, linkCarouselCollectionPresentationModel.f36366c) && Intrinsics.m26845a(this.f36367d, linkCarouselCollectionPresentationModel.f36367d) && Intrinsics.m26845a(this.f36368e, linkCarouselCollectionPresentationModel.f36368e) && Intrinsics.m26845a(this.f36369f, linkCarouselCollectionPresentationModel.f36369f) && Intrinsics.m26845a(this.f36370g, linkCarouselCollectionPresentationModel.f36370g) && Intrinsics.m26845a(this.f36371h, linkCarouselCollectionPresentationModel.f36371h)) {
                    if (this.f36372i == linkCarouselCollectionPresentationModel.f36372i) {
                        if ((this.f36373j == linkCarouselCollectionPresentationModel.f36373j) && Intrinsics.m26845a(this.f36374k, linkCarouselCollectionPresentationModel.f36374k) && Intrinsics.m26845a(this.f36375l, linkCarouselCollectionPresentationModel.f36375l)) {
                            if (this.f36376m == linkCarouselCollectionPresentationModel.f36376m) {
                                if ((getListableType() == linkCarouselCollectionPresentationModel.getListableType()) && Intrinsics.m26845a(this.f36377n, linkCarouselCollectionPresentationModel.f36377n) && Intrinsics.m26845a(this.f36378o, linkCarouselCollectionPresentationModel.f36378o) != null) {
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
