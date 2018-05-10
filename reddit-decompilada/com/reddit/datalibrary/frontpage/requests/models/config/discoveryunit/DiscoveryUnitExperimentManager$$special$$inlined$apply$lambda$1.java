package com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "oldUnit", "Lcom/reddit/datalibrary/frontpage/requests/models/config/discoveryunit/DiscoveryUnit;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitExperimentManager.kt */
final class DiscoveryUnitExperimentManager$$special$$inlined$apply$lambda$1 extends Lambda implements Function1<DiscoveryUnit, Boolean> {
    final /* synthetic */ Set $updatedUnits$inlined;

    DiscoveryUnitExperimentManager$$special$$inlined$apply$lambda$1(Set set) {
        this.$updatedUnits$inlined = set;
        super(1);
    }

    public final /* synthetic */ Object m20723a(Object obj) {
        DiscoveryUnit discoveryUnit = (DiscoveryUnit) obj;
        Intrinsics.b(discoveryUnit, "oldUnit");
        for (Object next : this.$updatedUnits$inlined) {
            if (Intrinsics.a(((DiscoveryUnit) next).unique_id, discoveryUnit.unique_id)) {
                break;
            }
        }
        Object next2 = null;
        return Boolean.valueOf(next2 != null ? true : null);
    }
}
