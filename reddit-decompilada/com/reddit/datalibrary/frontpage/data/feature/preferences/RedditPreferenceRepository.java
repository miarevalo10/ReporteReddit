package com.reddit.datalibrary.frontpage.data.feature.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.region.repo.RedditRegionRepository;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage.UserSettings;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u0014\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0016H\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0013H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u001eH\u0016J$\u0010+\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00192\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180-H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/preferences/RedditPreferenceRepository;", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "context", "Landroid/content/Context;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/UserSettingsStorage$UserSettings;", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/UserSettingsStorage;", "localPreferences", "Landroid/content/SharedPreferences;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "(Landroid/content/Context;Lcom/reddit/datalibrary/frontpage/data/feature/settings/UserSettingsStorage$UserSettings;Landroid/content/SharedPreferences;Lcom/reddit/common/rx/BackgroundThread;)V", "addReadLinkId", "Lio/reactivex/Completable;", "linkKindWithId", "", "clearReadLinkIds", "get", "Lio/reactivex/Single;", "", "key", "default", "", "getCarouselCollectionState", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository$CarouselCollectionStateKey;", "getGeopopularRegionFilter", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "getReadLinkIds", "getViewModeOption", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "save", "value", "setCarouselCollectionState", "state", "setGeopopularRegionFilter", "filter", "setGlobalViewModeOption", "isCompact", "setOver18", "isOver18", "setViewModeOption", "mode", "updateCarouselCollectionState", "action", "Lkotlin/Function1;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
public final class RedditPreferenceRepository implements PreferenceRepository {
    public static final Companion f16105a = new Companion();
    private static final String f16106f = RedditRegionRepository.class.getSimpleName();
    private static final String f16107g;
    private static final String f16108h = "";
    private static final ReentrantLock f16109i = new ReentrantLock();
    private static final List<String> f16110j = CollectionsKt.b(new String[]{"listingViewMode.globalDefault", "listingViewMode.frontpage", "listingViewMode.popular"});
    private final Context f16111b;
    private final UserSettings f16112c;
    private final SharedPreferences f16113d;
    private final BackgroundThread f16114e;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/preferences/RedditPreferenceRepository$Companion;", "", "()V", "GEO_TAG", "", "kotlin.jvm.PlatformType", "getGEO_TAG", "()Ljava/lang/String;", "KEY_GEOPOPULAR_REGION_FILTER", "getKEY_GEOPOPULAR_REGION_FILTER", "KEY_READ_LINK_IDS", "LINK_ID_DELIMETER", "MAX_READ_LINK_IDS", "", "PREF_FRONTPAGE_LISTING_VIEW_MODE", "PREF_GLOBAL_LISTING_VIEW_MODE", "PREF_POPULAR_LISTING_VIEW_MODE", "VALUE_GEOPOPULAR_REGION_FILER_DEFAULT", "getVALUE_GEOPOPULAR_REGION_FILER_DEFAULT", "VIEW_MODE_PREF_KEYS", "", "getVIEW_MODE_PREF_KEYS", "()Ljava/util/List;", "addReadLinkLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getAddReadLinkLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditPreferenceRepository.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public RedditPreferenceRepository(Context context, UserSettings userSettings, SharedPreferences sharedPreferences, BackgroundThread backgroundThread) {
        Intrinsics.b(context, "context");
        Intrinsics.b(userSettings, "settings");
        Intrinsics.b(sharedPreferences, "localPreferences");
        Intrinsics.b(backgroundThread, "backgroundThread");
        this.f16111b = context;
        this.f16112c = userSettings;
        this.f16113d = sharedPreferences;
        this.f16114e = backgroundThread;
    }

    public final Completable m16102a(String str, int i) {
        Intrinsics.b(str, "key");
        str = Completable.fromCallable(new RedditPreferenceRepository$save$1(this, str, i));
        Intrinsics.a(str, "Completable.fromCallable…key, value).apply()\n    }");
        return str;
    }

    public final Single<Integer> m16109b(String str, int i) {
        Intrinsics.b(str, "key");
        str = Single.fromCallable(new RedditPreferenceRepository$get$1(this, str, i));
        Intrinsics.a(str, "Single.fromCallable {\n  …etInt(key, default)\n    }");
        return str;
    }

    public final Completable m16101a(String str) {
        Intrinsics.b(str, "key");
        str = Completable.fromCallable(new RedditPreferenceRepository$save$2(this, str));
        Intrinsics.a(str, "Completable.fromCallable…key, value).apply()\n    }");
        return str;
    }

    public final Single<Boolean> m16108b(String str) {
        Intrinsics.b(str, "key");
        str = Single.fromCallable(new RedditPreferenceRepository$get$2(this, str));
        Intrinsics.a(str, "Single.fromCallable {\n  …olean(key, default)\n    }");
        return str;
    }

    public final Completable m16100a(GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        Intrinsics.b(geopopularRegionSelectFilter, "filter");
        geopopularRegionSelectFilter = Completable.fromCallable(new RedditPreferenceRepository$setGeopopularRegionFilter$1(this, geopopularRegionSelectFilter));
        Intrinsics.a(geopopularRegionSelectFilter, "Completable\n        .fro…       .apply()\n        }");
        return geopopularRegionSelectFilter;
    }

    public final Single<GeopopularRegionSelectFilter> m16105a() {
        Single<GeopopularRegionSelectFilter> fromCallable = Single.fromCallable(new RedditPreferenceRepository$getGeopopularRegionFilter$1(this));
        Intrinsics.a(fromCallable, "Single.fromCallable {\n  …class.java)\n      }\n    }");
        return fromCallable;
    }

    public final Completable m16104a(boolean z) {
        z = Completable.fromCallable(new RedditPreferenceRepository$setGlobalViewModeOption$1(this, z));
        Intrinsics.a(z, "Completable.fromCallable…ue).apply()\n      }\n    }");
        return z;
    }

    public final Completable m16103a(String str, ListingViewMode listingViewMode) {
        Intrinsics.b(str, "key");
        Intrinsics.b(listingViewMode, "mode");
        str = Completable.fromCallable(new RedditPreferenceRepository$setViewModeOption$1(this, str, listingViewMode));
        Intrinsics.a(str, "Completable.fromCallable… mode.name).apply()\n    }");
        return str;
    }

    public final Single<ListingViewMode> m16110b(String str, ListingViewMode listingViewMode) {
        Intrinsics.b(str, "key");
        Intrinsics.b(listingViewMode, "default");
        str = Single.fromCallable(new RedditPreferenceRepository$getViewModeOption$1(this, str, listingViewMode));
        Intrinsics.a(str, "Single.fromCallable {\n  …lueOf(pref)\n      }\n    }");
        return str;
    }

    public final Single<CarouselCollectionState> m16106a(CarouselCollectionStateKey carouselCollectionStateKey) {
        Intrinsics.b(carouselCollectionStateKey, "key");
        carouselCollectionStateKey = Single.fromCallable(new RedditPreferenceRepository$getCarouselCollectionState$1(this, carouselCollectionStateKey));
        Intrinsics.a(carouselCollectionStateKey, "Single.fromCallable {\n  …class.java)\n      }\n    }");
        return carouselCollectionStateKey;
    }

    public final Completable m16099a(CarouselCollectionStateKey carouselCollectionStateKey, Function1<? super CarouselCollectionState, CarouselCollectionState> function1) {
        Intrinsics.b(carouselCollectionStateKey, "key");
        Intrinsics.b(function1, "action");
        carouselCollectionStateKey = m16106a(carouselCollectionStateKey).flatMapCompletable(new RedditPreferenceRepository$updateCarouselCollectionState$1(this, carouselCollectionStateKey, function1));
        Intrinsics.a(carouselCollectionStateKey, "getCarouselCollectionSta…te(key, action(it))\n    }");
        return carouselCollectionStateKey;
    }

    public final Single<String> m16107b() {
        Single fromCallable = Single.fromCallable(new RedditPreferenceRepository$getReadLinkIds$1(this));
        Intrinsics.a(fromCallable, "Single.fromCallable {\n  …_READ_LINK_IDS, \"\")\n    }");
        return SinglesKt.a(fromCallable, this.f16114e);
    }

    public final Completable m16112c(String str) {
        Intrinsics.b(str, "linkKindWithId");
        str = Completable.fromCallable(new RedditPreferenceRepository$addReadLinkId$1(this, str));
        Intrinsics.a(str, "Completable.fromCallable…ck.unlock()\n      }\n    }");
        return str;
    }

    public final Completable m16111c() {
        Completable fromCallable = Completable.fromCallable(new RedditPreferenceRepository$clearReadLinkIds$1(this));
        Intrinsics.a(fromCallable, "Completable.fromCallable…NK_IDS, \"\").apply()\n    }");
        return fromCallable;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f16106f);
        stringBuilder.append(":GeopopularRegionFilter");
        f16107g = stringBuilder.toString();
    }
}
