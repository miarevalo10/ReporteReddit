package com.reddit.datalibrary.frontpage.data.feature.search;

import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 1, 9})
/* compiled from: Comparisons.kt */
public final class C0933x6ebb1722<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        String str = (String) t2;
        Intrinsics.a(str, "it");
        Comparable valueOf = Integer.valueOf(Integer.parseInt(StringsKt.c(str, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR)));
        String str2 = (String) t;
        Intrinsics.a(str2, "it");
        return ComparisonsKt.a(valueOf, Integer.valueOf(Integer.parseInt(StringsKt.c(str2, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR))));
    }
}
