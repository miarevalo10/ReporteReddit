package com.reddit.frontpage.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/domain/model/Region;", "", "id", "", "name", "subregions", "", "geoFilter", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getGeoFilter", "()Ljava/lang/String;", "getId", "getName", "getSubregions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: Region.kt */
public final class Region {
    public static final Companion Companion = new Companion();
    public static final Region DEFAULT = new Region("", "Global", CollectionsKt__CollectionsKt.m26790a(), "GLOBAL");
    private final String geoFilter;
    private final String id;
    private final String name;
    private final List<Region> subregions;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/domain/model/Region$Companion;", "", "()V", "DEFAULT", "Lcom/reddit/frontpage/domain/model/Region;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: Region.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public static /* synthetic */ Region copy$default(Region region, String str, String str2, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = region.id;
        }
        if ((i & 2) != 0) {
            str2 = region.name;
        }
        if ((i & 4) != 0) {
            list = region.subregions;
        }
        if ((i & 8) != 0) {
            str3 = region.geoFilter;
        }
        return region.copy(str, str2, list, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final List<Region> component3() {
        return this.subregions;
    }

    public final String component4() {
        return this.geoFilter;
    }

    public final Region copy(String str, String str2, List<Region> list, String str3) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        Intrinsics.m26847b(list, "subregions");
        Intrinsics.m26847b(str3, "geoFilter");
        return new Region(str, str2, list, str3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Region) {
                Region region = (Region) obj;
                if (Intrinsics.m26845a(this.id, region.id) && Intrinsics.m26845a(this.name, region.name) && Intrinsics.m26845a(this.subregions, region.subregions) && Intrinsics.m26845a(this.geoFilter, region.geoFilter)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        hashCode = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List list = this.subregions;
        hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        str2 = this.geoFilter;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Region(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", subregions=");
        stringBuilder.append(this.subregions);
        stringBuilder.append(", geoFilter=");
        stringBuilder.append(this.geoFilter);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public Region(String str, String str2, List<Region> list, String str3) {
        Intrinsics.m26847b(str, "id");
        Intrinsics.m26847b(str2, "name");
        Intrinsics.m26847b(list, "subregions");
        Intrinsics.m26847b(str3, "geoFilter");
        this.id = str;
        this.name = str2;
        this.subregions = list;
        this.geoFilter = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Region> getSubregions() {
        return this.subregions;
    }

    public final String getGeoFilter() {
        return this.geoFilter;
    }
}
