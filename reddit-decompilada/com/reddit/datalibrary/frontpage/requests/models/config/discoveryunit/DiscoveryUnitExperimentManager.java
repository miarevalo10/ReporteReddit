package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnitExperimentManager;", "", "configDiscoveryUnits", "", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "experimentDiscoveryUnits", "", "surfaces", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/Surface;", "debugMode", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)V", "surfacesMap", "", "", "getDiscoveryUnitsForSurface", "surface", "isSurfaceEnabled", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitExperimentManager.kt */
public final class DiscoveryUnitExperimentManager {
    private final List<DiscoveryUnit> configDiscoveryUnits;
    private final boolean debugMode;
    private final Map<String, Surface> surfacesMap;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OrderType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[OrderType.RANDOM.ordinal()] = 1;
            $EnumSwitchMapping$0[OrderType.INDEX.ordinal()] = 2;
        }
    }

    public DiscoveryUnitExperimentManager(List<DiscoveryUnit> list, List<DiscoveryUnit> list2, List<Surface> list3, boolean z) {
        Object a;
        List<DiscoveryUnit> list4 = list;
        List<DiscoveryUnit> list5 = list2;
        List<Surface> list6 = list3;
        Intrinsics.b(list4, "configDiscoveryUnits");
        Intrinsics.b(list5, "experimentDiscoveryUnits");
        Intrinsics.b(list6, "surfaces");
        this.configDiscoveryUnits = list4;
        this.debugMode = z;
        Iterable<Surface> iterable = list6;
        Map linkedHashMap = new LinkedHashMap(RangesKt.c(MapsKt.a(CollectionsKt.b(iterable)), 16));
        for (Surface surface : iterable) {
            linkedHashMap.put(surface.name, surface);
        }
        r0.surfacesMap = linkedHashMap;
        Set linkedHashSet = new LinkedHashSet();
        for (DiscoveryUnit discoveryUnit : r0.configDiscoveryUnits) {
            Surface surface2 = (Surface) r0.surfacesMap.get(discoveryUnit.surface);
            if (surface2 != null) {
                switch (WhenMappings.$EnumSwitchMapping$0[surface2.order.ordinal()]) {
                    case 1:
                        a = DiscoveryUnit.m16409a(discoveryUnit, null, null, null, null, false, 0, null, 0, null, null, null, null, null, new OrderBy(r0.debugMode ? 0 : surface2.start, r0.debugMode ? 0 : surface2.distance, 0, OrderType.RANDOM, 4), null, null, 0, null, null, 516095);
                        break;
                    case 2:
                        a = DiscoveryUnit.m16409a(discoveryUnit, null, null, null, null, false, 0, null, 0, null, null, null, null, null, new OrderBy(0, 0, discoveryUnit.index, surface2.order, 3), null, null, 0, null, null, 516095);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                linkedHashSet.add(a);
            }
        }
        List list7 = r0.configDiscoveryUnits;
        CollectionsKt.b(list7, new DiscoveryUnitExperimentManager$$special$$inlined$apply$lambda$1(linkedHashSet));
        list7.addAll(linkedHashSet);
        for (DiscoveryUnit discoveryUnit2 : list5) {
            DiscoveryUnit discoveryUnit3;
            for (Object a2 : r0.configDiscoveryUnits) {
                if (Intrinsics.a(((DiscoveryUnit) a2).unique_id, discoveryUnit2.unique_id)) {
                    discoveryUnit3 = (DiscoveryUnit) a2;
                    if (discoveryUnit3 == null) {
                        boolean z2 = discoveryUnit2.enabled_for_minimum_app_version && !(Intrinsics.a(discoveryUnit3.orderBy.orderType, OrderType.INDEX) && discoveryUnit3.index == -1);
                        discoveryUnit3.m16412a(z2);
                    }
                }
            }
            a2 = null;
            discoveryUnit3 = (DiscoveryUnit) a2;
            if (discoveryUnit3 == null) {
                if (!discoveryUnit2.enabled_for_minimum_app_version) {
                }
                discoveryUnit3.m16412a(z2);
            }
        }
    }

    private /* synthetic */ DiscoveryUnitExperimentManager() {
        this(new ArrayList(), CollectionsKt.a(), CollectionsKt.a(), false);
    }

    public final List<DiscoveryUnit> m9381a(String str) {
        boolean z;
        Object obj;
        Collection arrayList;
        Object obj2;
        Intrinsics.b(str, "surface");
        Surface surface = (Surface) this.surfacesMap.get(str);
        if (surface != null) {
            z = surface.enabled;
        } else {
            z = true;
        }
        if (!z) {
            if (!this.debugMode) {
                obj = null;
                if (obj != null) {
                    return CollectionsKt.a();
                }
                arrayList = new ArrayList();
                for (Object next : this.configDiscoveryUnits) {
                    DiscoveryUnit discoveryUnit = (DiscoveryUnit) next;
                    obj2 = (Intrinsics.a(discoveryUnit.surface, str) || !(this.debugMode || discoveryUnit.enabled)) ? null : 1;
                    if (obj2 != null) {
                        arrayList.add(next);
                    }
                }
                return (List) arrayList;
            }
        }
        obj = 1;
        if (obj != null) {
            return CollectionsKt.a();
        }
        arrayList = new ArrayList();
        for (Object next2 : this.configDiscoveryUnits) {
            DiscoveryUnit discoveryUnit2 = (DiscoveryUnit) next2;
            if (Intrinsics.a(discoveryUnit2.surface, str)) {
            }
            if (obj2 != null) {
                arrayList.add(next2);
            }
        }
        return (List) arrayList;
    }
}
