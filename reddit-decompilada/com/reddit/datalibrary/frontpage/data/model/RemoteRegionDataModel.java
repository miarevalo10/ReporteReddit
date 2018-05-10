package com.reddit.datalibrary.frontpage.data.model;

import com.squareup.moshi.Json;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/model/RemoteRegionDataModel;", "", "name", "", "geoFilter", "subregions", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getGeoFilter", "()Ljava/lang/String;", "getName", "getSubregions", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteRegionDataModel.kt */
public final class RemoteRegionDataModel {
    @Json(a = "geo_filter")
    private final String geoFilter;
    private final String name;
    @Json(a = "subdivisions")
    private final Map<String, RemoteRegionDataModel> subregions;

    public static /* synthetic */ RemoteRegionDataModel copy$default(RemoteRegionDataModel remoteRegionDataModel, String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteRegionDataModel.name;
        }
        if ((i & 2) != 0) {
            str2 = remoteRegionDataModel.geoFilter;
        }
        if ((i & 4) != 0) {
            map = remoteRegionDataModel.subregions;
        }
        return remoteRegionDataModel.copy(str, str2, map);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.geoFilter;
    }

    public final Map<String, RemoteRegionDataModel> component3() {
        return this.subregions;
    }

    public final RemoteRegionDataModel copy(String str, String str2, Map<String, RemoteRegionDataModel> map) {
        Intrinsics.b(str, "name");
        Intrinsics.b(str2, "geoFilter");
        return new RemoteRegionDataModel(str, str2, map);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof RemoteRegionDataModel) {
                RemoteRegionDataModel remoteRegionDataModel = (RemoteRegionDataModel) obj;
                if (Intrinsics.a(this.name, remoteRegionDataModel.name) && Intrinsics.a(this.geoFilter, remoteRegionDataModel.geoFilter) && Intrinsics.a(this.subregions, remoteRegionDataModel.subregions)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.geoFilter;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map map = this.subregions;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RemoteRegionDataModel(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", geoFilter=");
        stringBuilder.append(this.geoFilter);
        stringBuilder.append(", subregions=");
        stringBuilder.append(this.subregions);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public RemoteRegionDataModel(String str, String str2, Map<String, RemoteRegionDataModel> map) {
        Intrinsics.b(str, "name");
        Intrinsics.b(str2, "geoFilter");
        this.name = str;
        this.geoFilter = str2;
        this.subregions = map;
    }

    public final String getName() {
        return this.name;
    }

    public final String getGeoFilter() {
        return this.geoFilter;
    }

    public final Map<String, RemoteRegionDataModel> getSubregions() {
        return this.subregions;
    }
}
