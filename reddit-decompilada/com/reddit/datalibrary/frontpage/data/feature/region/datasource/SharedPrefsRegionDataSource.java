package com.reddit.datalibrary.frontpage.data.feature.region.datasource;

import android.content.SharedPreferences;
import com.reddit.datalibrary.frontpage.data.feature.region.local.LocalRegionDataSource;
import com.reddit.frontpage.domain.model.Region;
import com.squareup.moshi.Moshi;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0010H\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/region/datasource/SharedPrefsRegionDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/region/local/LocalRegionDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "preferences", "Landroid/content/SharedPreferences;", "(Lcom/squareup/moshi/Moshi;Landroid/content/SharedPreferences;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/reddit/frontpage/domain/model/Region;", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "get", "Lio/reactivex/Maybe;", "save", "Lio/reactivex/Single;", "", "regions", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SharedPrefsRegionDataSource.kt */
public final class SharedPrefsRegionDataSource implements LocalRegionDataSource {
    static final /* synthetic */ KProperty[] f16115a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(SharedPrefsRegionDataSource.class), "adapter", "getAdapter()Lcom/squareup/moshi/JsonAdapter;"))};
    public static final Companion f16116b = new Companion();
    private static final String f16117f = "SharedPrefsRegionDataSource";
    private static final String f16118g;
    private final Lazy f16119c = LazyKt.a((Function0) new SharedPrefsRegionDataSource$adapter$2(this));
    private final Moshi f16120d;
    private final SharedPreferences f16121e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/region/datasource/SharedPrefsRegionDataSource$Companion;", "", "()V", "KEY_GEOPOPULAR_REGIONS", "", "getKEY_GEOPOPULAR_REGIONS", "()Ljava/lang/String;", "TAG", "kotlin.jvm.PlatformType", "getTAG", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SharedPrefsRegionDataSource.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Inject
    public SharedPrefsRegionDataSource(Moshi moshi, SharedPreferences sharedPreferences) {
        Intrinsics.b(moshi, "moshi");
        Intrinsics.b(sharedPreferences, "preferences");
        this.f16120d = moshi;
        this.f16121e = sharedPreferences;
    }

    public final Single<Boolean> mo2977a(List<Region> list) {
        Intrinsics.b(list, "regions");
        list = Single.fromCallable(new SharedPrefsRegionDataSource$save$1(this, list));
        Intrinsics.a(list, "Single.fromCallable {\n  …pply()\n        true\n    }");
        return list;
    }

    public final Maybe<List<Region>> mo2976a() {
        String string = this.f16121e.getString(f16118g, "");
        Intrinsics.a(string, "result");
        if ((((CharSequence) string).length() == 0 ? 1 : null) != null) {
            Maybe<List<Region>> empty = Maybe.empty();
            Intrinsics.a(empty, "Maybe.empty<List<Region>>()");
            return empty;
        }
        empty = Maybe.fromCallable(new SharedPrefsRegionDataSource$get$1(this, string));
        Intrinsics.a(empty, "Maybe.fromCallable {\n   …son(result)\n            }");
        return empty;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f16117f);
        stringBuilder.append(":GeopopularRegions");
        f16118g = stringBuilder.toString();
    }
}
