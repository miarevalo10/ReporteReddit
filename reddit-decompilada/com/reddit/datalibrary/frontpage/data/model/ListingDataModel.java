package com.reddit.datalibrary.frontpage.data.model;

import com.raizlabs.android.dbflow.kotlinextensions.OneToMany;
import com.raizlabs.android.dbflow.kotlinextensions.OneToManyExtensionsKt;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003Je\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020\tHÖ\u0001R \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRK\u0010 \u001a\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e\u0018\u00010\u001d2\u0016\u0010\u001c\u001a\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e\u0018\u00010\u001d8G@FX\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013¨\u0006E"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/ListingDataModel;", "Lcom/raizlabs/android/dbflow/structure/BaseModel;", "id", "", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "before", "", "after", "adDistance", "username", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "(JLcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/reddit/frontpage/presentation/listing/common/ListingType;)V", "getAdDistance", "()Ljava/lang/String;", "setAdDistance", "(Ljava/lang/String;)V", "getAfter", "setAfter", "getBefore", "setBefore", "getId", "()J", "setId", "(J)V", "<set-?>", "", "Lcom/reddit/datalibrary/frontpage/data/model/LinkDataModel;", "kotlin.jvm.PlatformType", "links", "getLinks", "()Ljava/util/List;", "setLinks", "(Ljava/util/List;)V", "links$delegate", "Lcom/raizlabs/android/dbflow/kotlinextensions/OneToMany;", "getListingType", "()Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "setListingType", "(Lcom/reddit/frontpage/presentation/listing/common/ListingType;)V", "getSort", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "setSort", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;)V", "getSortTimeFrame", "()Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "setSortTimeFrame", "(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;)V", "getUsername", "setUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingDataModel.kt */
public final class ListingDataModel extends BaseModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.a(new MutablePropertyReference1Impl(Reflection.a(ListingDataModel.class), "links", "getLinks()Ljava/util/List;"))};
    private String adDistance;
    private String after;
    private String before;
    private long id;
    private final OneToMany links$delegate;
    private ListingType listingType;
    private SortType sort;
    private SortTimeFrame sortTimeFrame;
    private String username;

    public ListingDataModel() {
        this(0, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ListingDataModel copy$default(ListingDataModel listingDataModel, long j, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, String str3, String str4, ListingType listingType, int i, Object obj) {
        ListingDataModel listingDataModel2 = listingDataModel;
        int i2 = i;
        return listingDataModel2.copy((i2 & 1) != 0 ? listingDataModel2.id : j, (i2 & 2) != 0 ? listingDataModel2.sort : sortType, (i2 & 4) != 0 ? listingDataModel2.sortTimeFrame : sortTimeFrame, (i2 & 8) != 0 ? listingDataModel2.before : str, (i2 & 16) != 0 ? listingDataModel2.after : str2, (i2 & 32) != 0 ? listingDataModel2.adDistance : str3, (i2 & 64) != 0 ? listingDataModel2.username : str4, (i2 & 128) != 0 ? listingDataModel2.listingType : listingType);
    }

    public final long component1() {
        return this.id;
    }

    public final SortType component2() {
        return this.sort;
    }

    public final SortTimeFrame component3() {
        return this.sortTimeFrame;
    }

    public final String component4() {
        return this.before;
    }

    public final String component5() {
        return this.after;
    }

    public final String component6() {
        return this.adDistance;
    }

    public final String component7() {
        return this.username;
    }

    public final ListingType component8() {
        return this.listingType;
    }

    public final ListingDataModel copy(long j, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, String str3, String str4, ListingType listingType) {
        ListingType listingType2 = listingType;
        Intrinsics.b(listingType2, "listingType");
        return new ListingDataModel(j, sortType, sortTimeFrame, str, str2, str3, str4, listingType2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ListingDataModel) {
            ListingDataModel listingDataModel = (ListingDataModel) obj;
            return ((this.id > listingDataModel.id ? 1 : (this.id == listingDataModel.id ? 0 : -1)) == 0) && Intrinsics.a(this.sort, listingDataModel.sort) && Intrinsics.a(this.sortTimeFrame, listingDataModel.sortTimeFrame) && Intrinsics.a(this.before, listingDataModel.before) && Intrinsics.a(this.after, listingDataModel.after) && Intrinsics.a(this.adDistance, listingDataModel.adDistance) && Intrinsics.a(this.username, listingDataModel.username) && Intrinsics.a(this.listingType, listingDataModel.listingType);
        }
    }

    public final List<LinkDataModel> getLinks() {
        return this.links$delegate.getValue((Object) this, $$delegatedProperties[0]);
    }

    public final int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        SortType sortType = this.sort;
        int i2 = 0;
        i = (i + (sortType != null ? sortType.hashCode() : 0)) * 31;
        SortTimeFrame sortTimeFrame = this.sortTimeFrame;
        i = (i + (sortTimeFrame != null ? sortTimeFrame.hashCode() : 0)) * 31;
        String str = this.before;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.after;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.adDistance;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.username;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        ListingType listingType = this.listingType;
        if (listingType != null) {
            i2 = listingType.hashCode();
        }
        return i + i2;
    }

    public final void setLinks(List<LinkDataModel> list) {
        this.links$delegate.setValue((Object) this, $$delegatedProperties[0], (List) list);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ListingDataModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", sort=");
        stringBuilder.append(this.sort);
        stringBuilder.append(", sortTimeFrame=");
        stringBuilder.append(this.sortTimeFrame);
        stringBuilder.append(", before=");
        stringBuilder.append(this.before);
        stringBuilder.append(", after=");
        stringBuilder.append(this.after);
        stringBuilder.append(", adDistance=");
        stringBuilder.append(this.adDistance);
        stringBuilder.append(", username=");
        stringBuilder.append(this.username);
        stringBuilder.append(", listingType=");
        stringBuilder.append(this.listingType);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final SortType getSort() {
        return this.sort;
    }

    public final void setSort(SortType sortType) {
        this.sort = sortType;
    }

    public final SortTimeFrame getSortTimeFrame() {
        return this.sortTimeFrame;
    }

    public final void setSortTimeFrame(SortTimeFrame sortTimeFrame) {
        this.sortTimeFrame = sortTimeFrame;
    }

    public final String getBefore() {
        return this.before;
    }

    public final void setBefore(String str) {
        this.before = str;
    }

    public final String getAfter() {
        return this.after;
    }

    public final void setAfter(String str) {
        this.after = str;
    }

    public final String getAdDistance() {
        return this.adDistance;
    }

    public final void setAdDistance(String str) {
        this.adDistance = str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public /* synthetic */ ListingDataModel(long j, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, String str3, String str4, ListingType listingType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i;
        this((i2 & 1) != 0 ? 0 : j, (i2 & 2) != 0 ? null : sortType, (i2 & 4) != 0 ? null : sortTimeFrame, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? ListingType.a : listingType);
    }

    public final ListingType getListingType() {
        return this.listingType;
    }

    public final void setListingType(ListingType listingType) {
        Intrinsics.b(listingType, "<set-?>");
        this.listingType = listingType;
    }

    public ListingDataModel(long j, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, String str3, String str4, ListingType listingType) {
        Intrinsics.b(listingType, "listingType");
        this.id = j;
        this.sort = sortType;
        this.sortTimeFrame = sortTimeFrame;
        this.before = str;
        this.after = str2;
        this.adDistance = str3;
        this.username = str4;
        this.listingType = listingType;
        this.links$delegate = OneToManyExtensionsKt.oneToMany((Function0) new ListingDataModel$links$2(this));
    }
}
